package object;

public class billproduct {
    private String idproduct;
    private String namecustomer;
    private String nameproduct;
    private int quantity;
    private int totalprice;
    public billproduct() {
    	
    }
    public billproduct(String idproduct, String namecustomer, int quantity, int totalprice) {
        this.idproduct = idproduct;
        this.namecustomer = namecustomer;
        this.quantity = quantity;
        this.totalprice = totalprice;
    }

    public String getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(String idproduct) {
        this.idproduct = idproduct;
    }

    public String getNamecustomer() {
        return namecustomer;
    }

    public void setNamecustomer(String namecustomer) {
        this.namecustomer = namecustomer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(int totalprice) {
        this.totalprice = totalprice;
    }
    public billproduct(String idproduct, String namecustomer, String nameproduct, int quantity, int totalprice) {
        this.idproduct = idproduct;
        this.namecustomer = namecustomer;
        this.nameproduct = nameproduct;
        this.quantity = quantity;
        this.totalprice = totalprice;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }
    
    @Override
    public String toString() {
        return "billproduct{" + "idproduct=" + idproduct + ", namecustomer=" + namecustomer + ", quantity=" + quantity + ", totalprice=" + totalprice + '}';
    }
    
}