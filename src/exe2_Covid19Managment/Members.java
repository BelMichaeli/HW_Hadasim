package exe2_Covid19Managment;

import java.sql.Date;

public class Members {

    private int id;
    private String id_member;
    private String first_name;
    private String last_name;
    private String city;
    private String address;
    private Date birth_date;
    private String phone;
    private String cellular;

    //constructor
    public Members(int id, String id_member, String first_name, String last_name, String city,
                   String address, Date birth_date, String phone, String cellular) {
        setId(id);
        setId_member(id_member);
        setFirst_name(first_name);
        setLast_name(last_name);
        setCity(city);
        setAddress(address);
        setBirth_date(birth_date);
        setPhone(phone);
        setCellular(cellular);
    }

    //methods

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", id_member='" + id_member + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", birth_date=" + birth_date +
                ", phone='" + phone + '\'' +
                ", cellular='" + cellular + '\'' +
                '}';
    }

    //getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_member() {
        return id_member;
    }

    public void setId_member(String id_member) {
        this.id_member = id_member;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellular() {
        return cellular;
    }

    public void setCellular(String cellular) {
        this.cellular = cellular;
    }
}
