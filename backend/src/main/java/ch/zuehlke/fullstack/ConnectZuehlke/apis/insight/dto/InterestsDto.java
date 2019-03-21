package ch.zuehlke.fullstack.ConnectZuehlke.apis.insight.dto;

import ch.zuehlke.fullstack.ConnectZuehlke.domain.Interests;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

@JsonIgnoreProperties
public class InterestsDto {
    private String name;
    private String id;


    @JsonProperty("Name")
    private void unpackNested(Map<String,Object> interests) {
        this.name = (String)interests.get("Name");
    }

    @JsonProperty("Id")
    private void unpackNested2(Map<String,Object> interests) {
        this.name = (String)interests.get("Id");
    }

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
