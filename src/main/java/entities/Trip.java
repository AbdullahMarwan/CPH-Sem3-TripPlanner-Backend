package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id", nullable = false)
    private Long id;
    private String name;
    //    @Temporal(TemporalType.DATE)
    private String date; //TODO: Change to Date java.util.Date
    //    @Temporal(TemporalType.TIME)
    private String time; //TODO: Change to Time java.util.Time
    private String location;
    private String duration;
    private String packinglist;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Guide guide;
    private Long guideId = guide.getId();

    @JoinTable(name = "trip_user", joinColumns = {
            @JoinColumn(name = "trip_id", referencedColumnName = "id")}, inverseJoinColumns = {
            @JoinColumn(name = "user_name", referencedColumnName = "user_name"),
            @JoinColumn(name = "guide_id", referencedColumnName = "GUIDE_id")})

    @ManyToMany
    private List<User> userList = new ArrayList<>();

    public List<String> usersOnTrip() {
        if(userList.isEmpty()) {
            return null;
        }
        List<String> usersByName = new ArrayList<>();
        userList.forEach((user) -> {
            usersByName.add(user.getUserName());
        });
        return usersByName;
    }
    public Trip() {
    }

    public Trip(String name, String date, String time, String location, String duration, String packinglist) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.duration = duration;
        this.packinglist = packinglist;
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

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPackinglist() {
        return packinglist;
    }
    public void setPackinglist(String packinglist) {
        this.packinglist = packinglist;
    }

    public Guide getGuide() {
        return guide;
    }
    public void addGuide(Long guideid) {
        this.guide.getId();
    }

    public List<User> getUsers() {
        return userList;
    }
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    public void addUser(User user) {
        this.userList.add(user);
    }


}