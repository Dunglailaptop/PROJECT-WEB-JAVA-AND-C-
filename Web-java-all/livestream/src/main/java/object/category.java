package object;
public class category {
     private String cateid;
      private String cname;
public category() {
	
}
    public category(String cateid, String cname) {
        this.cateid = cateid;
        this.cname = cname;
    }

    public String getCateid() {
        return cateid;
    }

    public void setCateid(String cateid) {
        this.cateid = cateid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
      
}
