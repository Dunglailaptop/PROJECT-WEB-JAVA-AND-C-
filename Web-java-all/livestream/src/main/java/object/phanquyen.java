package object;

public class phanquyen {
    private int idadmin;
    private String namequyen;

    public phanquyen() {
    }

    public phanquyen(int idadmin, String namequyen) {
        this.idadmin = idadmin;
        this.namequyen = namequyen;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public String getNamequyen() {
        return namequyen;
    }

    public void setNamequyen(String namequyen) {
        this.namequyen = namequyen;
    }

    @Override
    public String toString() {
        return "phanquyen{" + "idadmin=" + idadmin + ", namequyen=" + namequyen + '}';
    }
    
}
