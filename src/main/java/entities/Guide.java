package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "guide")
public class Guide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String gender;
    private String birthyear;
    private String profile;
    private String image_url;

    @OneToMany(mappedBy = "guide", cascade = CascadeType.PERSIST)
    private List<Trip> tripList;

    public Guide() {
    }

    public Guide(String name, String gender, String birthyear, String profile, String image_url) {
        this.name = name;
        this.gender = gender;
        this.birthyear = birthyear;
        this.profile = profile;
        this.image_url = image_url;
        this.tripList = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(String birthyear) {
        this.birthyear = birthyear;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public List<Trip> getTripList() {
        return tripList;
    }

    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }

    public void addTrip(Trip trip) {
        this.tripList.add(trip);
        trip.setGuide(this);
    }

    @Override
    public String toString() {
        return "Guide{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthyear='" + birthyear + '\'' +
                ", profile='" + profile + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}