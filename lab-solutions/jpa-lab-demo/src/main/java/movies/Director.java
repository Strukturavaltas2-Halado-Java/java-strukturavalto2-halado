package movies;


import javax.persistence.Embeddable;

@Embeddable
public class Director {


    public String name;

    public Director(String name) {
        this.name = name;
    }

    public Director() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
