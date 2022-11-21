package object;

public class video {
    private int id;
    private String image;
    private String imageacc;
    private String nameacc;
    private String title;
    private int cateid;
    private int idacc;
    private String timeup;
 private String video;
  public video() {
      
      
  }

  public video(int id, String image, String imageacc, String nameacc, String title, int cateid, int idacc, String timeup, String video) {
      this.id = id;
      this.image = image;
      this.imageacc = imageacc;
      this.nameacc = nameacc;
      this.title = title;
      this.cateid = cateid;
      this.idacc = idacc;
      this.timeup = timeup;
      this.video = video;
  }

  public video(int id, String image, String imageacc, String nameacc, String title, int cateid, int idacc, String timeup) {
      this.id = id;
      this.image = image;
      this.imageacc = imageacc;
      this.nameacc = nameacc;
      this.title = title;
      this.cateid = cateid;
      this.idacc = idacc;
      this.timeup = timeup;
  }

    
    
    
    
  public video(int id, String image, String imageacc, String nameacc, String title, int cateid, int idacc) {
      this.id = id;
      this.image = image;
      this.imageacc = imageacc;
      this.nameacc = nameacc;
      this.title = title;
      this.cateid = cateid;
      this.idacc = idacc;
  }

  public int getId() {
      return id;
  }

  public void setId(int id) {
      this.id = id;
  }

  public String getImage() {
      return image;
  }

  public void setImage(String image) {
      this.image = image;
  }

  public String getImageacc() {
      return imageacc;
  }

  public void setImageacc(String imageacc) {
      this.imageacc = imageacc;
  }

  public String getNameacc() {
      return nameacc;
  }

  public void setNameacc(String nameacc) {
      this.nameacc = nameacc;
  }

  public String getTitle() {
      return title;
  }

  public void setTitle(String title) {
      this.title = title;
  }

  public int getCateid() {
      return cateid;
  }

  public void setCateid(int cateid) {
      this.cateid = cateid;
  }

  public int getIdacc() {
      return idacc;
  }

  public void setIdacc(int idacc) {
      this.idacc = idacc;
  }

  public String getTimeup() {
      return timeup;
  }

  public void setTimeup(String timeup) {
      this.timeup = timeup;
  }

  public String getVideo() {
      return video;
  }

  public void setVideo(String video) {
      this.video = video;
  }

  @Override
  public String toString() {
      return "video{" + "id=" + id + ", image=" + image + ", imageacc=" + imageacc + ", nameacc=" + nameacc + ", title=" + title + ", cateid=" + cateid + ", idacc=" + idacc + ", timeup=" + timeup + ", video=" + video + '}';
  }



    
    
    
}

