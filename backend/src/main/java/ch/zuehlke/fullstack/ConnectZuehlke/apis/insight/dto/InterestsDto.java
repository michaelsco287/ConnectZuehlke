package ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.dto;

import ch.zuehlke.fullstack.ConnectZuehlke.domain.Interests;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties
public class InterestsDto {
    private String name;
    private String id;

    @JsonProperty("Skill")
    private void unpack(Map<String, Object> skill){
        this.name = (String) skill.get("Name");
        Integer integerId = (Integer) skill.get("Id");
        this.id = integerId.toString();
    }

    public Interests toInterests(){
        return new Interests(getName(), getId());
    }

    private String getName() {
        return this.name;
    }

    private String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
