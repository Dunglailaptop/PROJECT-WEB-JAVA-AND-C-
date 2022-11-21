package object;

public class comment {
    private String idcomment;
     private String username;
      private int idproduct;
       private String content;
        private String timeup;

    public comment() {
    }

    public comment(String idcomment, String username, int idproduct, String content, String timeup) {
        this.idcomment = idcomment;
        this.username = username;
        this.idproduct = idproduct;
        this.content = content;
        this.timeup = timeup;
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

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
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

    @Override
    public String toString() {
        return "comment{" + "idcomment=" + idcomment + ", username=" + username + ", idproduct=" + idproduct + ", content=" + content + ", timeup=" + timeup + '}';
    }
        
}
