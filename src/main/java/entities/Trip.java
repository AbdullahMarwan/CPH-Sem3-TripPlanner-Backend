package entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "trip")
public class Trip {
    @Id
    @javax.persistence.Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Date")
    private String date;
    @Basic
    @Column(name = "Time")
    private String time;
    @Basic
    @Column(name = "Location")
    private String location;
    @Basic
    @Column(name = "Duration")
    private String duration;
    @Basic
    @Column(name = "Packing List")
    private String packingList;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Guide_Name")
    private String guideName;

    public Trip() {
    }

    public Trip(String name, String date, String time, String location, String guideName, String duration, String packingList) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
        this.guideName = guideName;
        this.duration = duration;
        this.packingList = packingList;
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

    public String getGuideName() {
        return guideName;
    }
    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPackingList() {
        return packingList;
    }
    public void setPackingList(String packingList) {
        this.packingList = packingList;
    }

    @ManyToMany(mappedBy = "tripList")
    private List<Person> personList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Objects.equals(name, trip.name) && Objects.equals(date, trip.date) && Objects.equals(time, trip.time) && Objects.equals(location, trip.location) && Objects.equals(duration, trip.duration) && Objects.equals(packingList, trip.packingList) && Objects.equals(guideName, trip.guideName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, date, time, location, duration, packingList, guideName);
    }

    public String getTripName() {
        return name;
    }
}
