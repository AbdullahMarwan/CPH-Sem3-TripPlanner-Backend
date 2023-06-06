package entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "guide")
public class Guide implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Column(name = "Name")
    private String name;
    @Basic
    @Column(name = "Gender")
    private String gender;
    @Basic
    @Column(name = "Birth Year")
    private String birthYear;
    @Basic
    @Column(name = "Profile")
    private String profile;
    @Basic
    @Column(name = "Image Url")
    private String imageUrl;

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

    public String getBirthYear() {
        return birthYear;
    }
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guide guide = (Guide) o;
        return Objects.equals(name, guide.name) && Objects.equals(gender, guide.gender) && Objects.equals(birthYear, guide.birthYear) && Objects.equals(profile, guide.profile) && Objects.equals(imageUrl, guide.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, birthYear, profile, imageUrl);
    }
}
