import{APP_ID} from './env.js'

let appID=APP_ID
let token=null
let uid=String(Math.floor(Math.random()*1232))
 
let roomsData = {}
 
let initiate =async () => {
    let rtmClient = await AgoraRTM.createInstance(appID)
    await rtmClient.login({uid,token})
    
 

    let lobbyChannel = await rtmClient.createChannel('lobby')
    await lobbyChannel.join()

    rtmClient.on('MessageFromPeer', async (message,peerId) =>{
        let messageData =JSON.parse(message.text)
        let count = await rtmClient.getChannelMemberCount([messageData.room])
       roomsData[messageData.room]={'members': count}
      //  console.log('ok')
      let rooms = document.getElementById('room__container')
      let room = document.getElementById(`room__${messageData.room}`)
      if(room === null){
        room = await buildRoom(count, messageData.room)
        rooms.insertAdjacentHTML('beforeend',room)
      }
    })


    let buildRoom = async (count, room_id) =>{
      let attributes = await rtmClient.getChannelAttributesByKeys(room_id,['room_name','host','host_image'])
      console.log('Attributes:',attributes)
      let roomName = attributes.room_name.value
      let hostName = attributes.host.value
      let hostImage=attributes.host_image.value
        let roomItem =`   <div class="room__item" id="room__${room_id}">
                 <img src="${hostImage}">
                      <div class="room__content">
                        <p class="room__meta">
                          <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24">
                     <path d="M10.118 16.064c2.293-.529 4.428-.993 3.394-2.945-3.146-5.942-.834-9.119 2.488-9.119 3.388 0 5.644 3.299 2.488 9.119-1.065 1.964 1.149 2.427 3.394 2.945 1.986.459 2.118 1.43 2.118 3.111l-.003.825h-15.994c0-2.196-.176-3.407 2.115-3.936zm-10.116 3.936h6.001c-.028-6.542 2.995-3.697 2.995-8.901 0-2.009-1.311-3.099-2.998-3.099-2.492 0-4.226 2.383-1.866 6.839.775 1.464-.825 1.812-2.545 2.209-1.49.344-1.589 1.072-1.589 2.333l.002.619z"/></svg>
                            <span>${count} watching</span>
                       </p>
                       <h4 class="room__title">${roomName} </h4>
                     <div class="room__box">
                     <div class="room__author">
                     <img class="avatar__md" src="${hostImage}">
                     <strong class="message__author">${hostName}</strong>
                 </div>
                 <a class="room__action" href="join.jsp?room=${room_id}">Join Now</a>
             </div>
         </div>
      </div>`
        return roomItem
    }

    let checkHeartBeat = async () =>{
      for(let room_id in roomsData) {
        let count = await rtmClient.getChannelMemberCount([room_id])
        if(count[room_id]<1){
          document.getElementById(`room__${room_id}`).remove()
          delete roomsData[room_id]
        }else {
          let newRoom; //= document.getElementById(`room__${room_id}`)
          let rooms = document.getElementById(`room__container`)
          newRoom = await buildRoom(count[room_id], room_id)
          document.getElementById(`room__${room_id}`).innerHTML = newRoom
          //rooms.insertAdjacentHTML(newRoom)
        }

      }
    }
    let interval = setInterval(() =>{
      checkHeartBeat()
    }, 2000)
    return () => clearInterval(interval)
}

initiate()