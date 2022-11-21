package object;

public class UserAccount {
private String userName;
private String gender;
private String email;
private String password;
 private String address;
 private String phone;
 private String idadmin;
private String image;
private int iduser;
private String lock;

    public UserAccount() {
    }
    public UserAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public UserAccount(String userName, String gender, String email, String password) {
        this.userName = userName;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }
    public UserAccount(String email, String password, String lock) {
        this.email = email;
        this.password = password;
        this.lock = lock;
    }
    public UserAccount(String userName, String gender, String email, String password, String address, String phone, String idadmin, String image, int iduser, String lock) {
        this.userName = userName;
        this.gender = gender;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.idadmin = idadmin;
        this.image = image;
        this.iduser = iduser;
        this.lock = lock;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(String idadmin) {
        this.idadmin = idadmin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    @Override
    public String toString() {
        return "UserAccount{" + "userName=" + userName + ", gender=" + gender + ", email=" + email + ", password=" + password + ", address=" + address + ", phone=" + phone + ", idadmin=" + idadmin + ", image=" + image + ", iduser=" + iduser + ", lock=" + lock + '}';
    }
   
}
