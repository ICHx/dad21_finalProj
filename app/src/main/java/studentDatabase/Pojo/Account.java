package studentDatabase.Pojo;

import lombok.NonNull;

public class Account {
    @NonNull private String netid;
    private String firstname;
    private String lastname;
    @NonNull private String deptid;
    private String gender;
    private String phone;

    public Account(String netid, String firstname, String lastname, String deptid, String gender, String phone) {
        this.netid = netid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.deptid = deptid;
        this.gender = gender;
        this.phone = phone;
    }

    public Account() {
    }

    public String getNetid() {
        return netid;
    }

    public void setNetid(String netid) {
        this.netid = netid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid.toUpperCase();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender.toUpperCase();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
