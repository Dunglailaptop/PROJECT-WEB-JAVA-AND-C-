package object;

public class chitietproduct {
    private String cpu;
    private String gpu;
    private String display;
    private String ram;
    private String ssd;
    private String weight;
      private String mota;
        private String khuyenmai;
    private int idproduct;

    public chitietproduct() {
    }

    public chitietproduct(String cpu, String gpu, String display, String ram, String ssd, String weight, int idproduct) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.display = display;
        this.ram = ram;
        this.ssd = ssd;
        this.weight = weight;
        this.idproduct = idproduct;
    }

    public chitietproduct(String cpu, String gpu, String display, String ram, String ssd, String weight, String mota, String khuyenmai, int idproduct) {
        this.cpu = cpu;
        this.gpu = gpu;
        this.display = display;
        this.ram = ram;
        this.ssd = ssd;
        this.weight = weight;
        this.mota = mota;
        this.khuyenmai = khuyenmai;
        this.idproduct = idproduct;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(int idproduct) {
        this.idproduct = idproduct;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getKhuyenmai() {
        return khuyenmai;
    }

    public void setKhuyenmai(String khuyenmai) {
        this.khuyenmai = khuyenmai;
    }

    @Override
    public String toString() {
        return "chitietproduct{" + "cpu=" + cpu + ", gpu=" + gpu + ", display=" + display + ", ram=" + ram + ", ssd=" + ssd + ", weight=" + weight + ", mota=" + mota + ", khuyenmai=" + khuyenmai + ", idproduct=" + idproduct + '}';
    }

  
    
}