package ch.zuehlke.fullstack.ConnectZuehlke.domain;

import java.util.Objects;

public class Interests {

    public String name;
    public String id;

    public Interests(String name, String id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interests interests = (Interests) o;
        return name.equals(interests.name) &&
                id.equals(interests.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
}
