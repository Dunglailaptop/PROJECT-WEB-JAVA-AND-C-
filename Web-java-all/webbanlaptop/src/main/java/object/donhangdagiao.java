package object;

public class donhangdagiao {
	  private String namecustomer;
	    private String email;
	      private String address;
	        private String pay;
	        private String tinhtrang;
	        private String sdt;
	        private String ngaydat;
	        private billproduct billp;
	public donhangdagiao() {
		
	}
	    public donhangdagiao(String namecustomer, String email, String address, String pay,String sdt,String tinhtrang) {
	        this.namecustomer = namecustomer;
	        this.email = email;
	        this.address = address;
	        this.pay = pay;
	      
	    }

	    public String getNamecustomer() {
	        return namecustomer;
	    }

	    public void setNamecustomer(String namecustomer) {
	        this.namecustomer = namecustomer;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getAddress() {
	        return address;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public String getPay() {
	        return pay;
	    }

	    public void setPay(String pay) {
	        this.pay = pay;
	    }

	    public billproduct getBillp() {
	        return billp;
	    }

	    public void setBillp(billproduct billp) {
	        this.billp = billp;
	    }

	    public String getTinhtrang() {
	        return tinhtrang;
	    }

	    public void setTinhtrang(String tinhtrang) {
	        this.tinhtrang = tinhtrang;
	    }

	    public String getSdt() {
	        return sdt;
	    }

	    public void setSdt(String sdt) {
	        this.sdt = sdt;
	    }

	    public String getNgaydat() {
	        return ngaydat;
	    }

	    public void setNgaydat(String ngaydat) {
	        this.ngaydat = ngaydat;
	    }

	    public donhangdagiao(String namecustomer, String email, String address, String pay, String tinhtrang, String sdt, String ngaydat, billproduct billp) {
	        this.namecustomer = namecustomer;
	        this.email = email;
	        this.address = address;
	        this.pay = pay;
	        this.tinhtrang = tinhtrang;
	        this.sdt = sdt;
	        this.ngaydat = ngaydat;
	        this.billp = billp;
	    }

	    @Override
	    public String toString() {
	        return "billcustomer{" + "namecustomer=" + namecustomer + ", email=" + email + ", address=" + address + ", pay=" + pay + ", tinhtrang=" + tinhtrang + ", sdt=" + sdt + ", ngaydat=" + ngaydat + ", billp=" + billp + '}';
	    }

	    
	}