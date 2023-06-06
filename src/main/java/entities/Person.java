package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "person")
public class Person implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "user_name")
    @OneToOne(cascade = CascadeType.PERSIST)
    private String userName;
    @Basic
    @Column(name = "Address")
    private String address;
    @Basic
    @Column(name = "Phone")
    private String phone;
    @Basic
    @Column(name = "Email")
    private String email;
    @Basic
    @Column(name = "Birth Year")
    private String birthYear;
    @Basic
    @Column(name = "Gender")
    private String gender;

    @JoinTable(name = "user_has_trip", joinColumns = {
            @JoinColumn(name = "user_name", referencedColumnName = "user_name")}, inverseJoinColumns = {
            @JoinColumn(name = "trip_name", referencedColumnName = "name"),
            @JoinColumn(name = "guide_name", referencedColumnName = "guide_name")})
    @ManyToMany

    private List<Trip> tripList = new ArrayList<>();

    public List<String> getTripsAsStrings() {
        if (tripList.isEmpty()) {
            return null;
        }
        List<String> tripsAsStrings = new ArrayList<>();
        tripList.forEach((trip) -> {
            tripsAsStrings.add(trip.getTripName());
        });
        return tripsAsStrings;
    }

    public Person() {
    }

    public Person(String userName, String address, String phone, String email, String birthYear, String gender){
        this.userName = userName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.birthYear = birthYear;
        this.gender = gender;
    }


    public String getUserName() {
        return userName;
    }
    public void setUserName(String usersPersonName) {
        this.userName = usersPersonName;
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

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthYear() {
        return birthYear;
    }
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Trip> getTripList() {
        return tripList;
    }
    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(userName, person.userName) && Objects.equals(address, person.address) && Objects.equals(phone, person.phone) && Objects.equals(email, person.email) && Objects.equals(birthYear, person.birthYear) && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, address, phone, email, birthYear, gender);
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthYear='" + birthYear + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
