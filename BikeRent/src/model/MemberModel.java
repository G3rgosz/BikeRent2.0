package model;

public class MemberModel {
    
    private String name;
    private String email;
    private String phone;
    private String address;
    private String identity;

    public MemberModel() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getIdentity() {
        return identity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
    
}
