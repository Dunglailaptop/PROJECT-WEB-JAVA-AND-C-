package object;

public class comment {
    private String idcomment;
    private String username;
     private String image;
      private String content;
       private String timeup;
         private String idvideo;

   public comment() {
   }

   public comment(String idcomment, String username, String image, String content, String timeup, String idvideo) {
       this.idcomment = idcomment;
       this.username = username;
       this.image = image;
       this.content = content;
       this.timeup = timeup;
       this.idvideo = idvideo;
   }

   public String getIdcomment() {
       return idcomment;
   }

   public void setIdcomment(String idcomment) {
       this.idcomment = idcomment;
   }

   public String getUsername() {
       return username;
   }

   public void setUsername(String username) {
       this.username = username;
   }

   public String getImage() {
       return image;
   }

   public void setImage(String image) {
       this.image = image;
   }

   public String getContent() {
       return content;
   }

   public void setContent(String content) {
       this.content = content;
   }

   public String getTimeup() {
       return timeup;
   }

   public void setTimeup(String timeup) {
       this.timeup = timeup;
   }

   public String getIdvideo() {
       return idvideo;
   }

   public void setIdvideo(String idvideo) {
       this.idvideo = idvideo;
   }

   @Override
   public String toString() {
       return "comment{" + "idcomment=" + idcomment + ", username=" + username + ", image=" + image + ", content=" + content + ", timeup=" + timeup + ", idvideo=" + idvideo + '}';
   }
       
       
       
       
}