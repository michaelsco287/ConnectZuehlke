package ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.dto;

import ch.zuehlke.fullstack.ConnectZuehlke.domain.Interests;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class InterestsDto {
    @JsonProperty("Name")
    private String name;
    @JsonProperty("Id")
    private String id;

    public InterestsDto(String name, String id){
        this.name = name;
        this.id = id;
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
}
