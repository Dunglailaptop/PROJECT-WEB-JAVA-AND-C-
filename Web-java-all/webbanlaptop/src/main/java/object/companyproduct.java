package object;

public class companyproduct {
    private String companyid;
    private String namecompany;
private String diachi;
private String lienhe;
private String email;
private String picture;
private String icon;
    public companyproduct() {
    }

    public companyproduct(String companyid, String namecompany) {
        this.companyid = companyid;
        this.namecompany = namecompany;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getNamecompany() {
        return namecompany;
    }

    public void setNamecompany(String namecompany) {
        this.namecompany = namecompany;
    }

    @Override
    public String toString() {
        return "companyproduct{" + "companyid=" + companyid + ", namecompany=" + namecompany + ", diachi=" + diachi + ", lienhe=" + lienhe + ", email=" + email + ", picture=" + picture + ", icon=" + icon + '}';
    }

 
    public companyproduct(String companyid, String namecompany, String diachi, String lienhe, String email, String picture, String icon) {
        this.companyid = companyid;
        this.namecompany = namecompany;
        this.diachi = diachi;
        this.lienhe = lienhe;
        this.email = email;
        this.picture = picture;
        this.icon = icon;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getLienhe() {
        return lienhe;
    }

    public void setLienhe(String lienhe) {
        this.lienhe = lienhe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
    
}
