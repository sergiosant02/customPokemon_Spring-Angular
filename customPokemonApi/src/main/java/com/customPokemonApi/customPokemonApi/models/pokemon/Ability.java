package com.customPokemonApi.customPokemonApi.models.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "Ability")
public class Ability {
	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@JsonProperty("slot")
	private Integer slot;
	
	@JsonProperty("is_hidden")
	private Boolean isHidden;
	
	@ManyToOne
	@JsonProperty("ability")
	private AbilityInfo abilityInfo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSlot() {
		return slot;
	}

	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	public Boolean getIsHidden() {
		return isHidden;
	}

	public void setIsHidden(Boolean isHidden) {
		this.isHidden = isHidden;
	}

	public AbilityInfo getAbilityInfo() {
		return abilityInfo;
	}

	public void setAbilityInfo(AbilityInfo abilityInfo) {
		this.abilityInfo = abilityInfo;
	}

	@Override
	public String toString() {
		return "Ability [id=" + id + ", slot=" + slot + ", isHidden=" + isHidden + ", abilityInfo=" + abilityInfo + "]";
	}
}
