package com.customPokemonApi.customPokemonApi.models.pokemon;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "PhotoSprites")
@Getter
@Setter
public class PhotoSprites {
	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
    @JsonProperty("back_default")
    private String backDefault;
    
    @JsonProperty("back_female")
    private String backFemale;
    
    @JsonProperty("back_shiny")
    private String backShiny;
    
    @JsonProperty("back_shiny_female")
    private String backShinyFemale;
    
    @JsonProperty("front_default")
    private String frontDefault;
    
    @JsonProperty("front_female")
    private String frontFemale;
    
    @JsonProperty("front_shiny")
    private String frontShiny;
    
    @JsonProperty("front_shiny_female")
    private String frontShinyFemale;
    
    public List<String> getPhtos(){
    	List<String> allFiles = new ArrayList<String>();
    	allFiles.add(backDefault);
    	allFiles.add(backFemale);
    	allFiles.add(backShiny);
    	allFiles.add(backShinyFemale);
    	allFiles.add(frontDefault);
    	allFiles.add(frontFemale);
    	allFiles.add(frontShiny);
    	allFiles.add(frontShinyFemale);
    	return allFiles.stream().filter(file -> file != null).toList();
    }

	@Override
	public String toString() {
		return "PhotoSprites [id=" + id + ", backDefault=" + backDefault + ", backFemale=" + backFemale + ", backShiny="
				+ backShiny + ", backShinyFemale=" + backShinyFemale + ", frontDefault=" + frontDefault
				+ ", frontFemale=" + frontFemale + ", frontShiny=" + frontShiny + ", frontShinyFemale="
				+ frontShinyFemale + "]";
	}
  
}
