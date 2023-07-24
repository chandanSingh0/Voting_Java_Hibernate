package com.masai.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String partyAffiliation;
    // Other attributes and getters/setters

    @OneToMany(mappedBy = "candidate")
    private List<Election> elections;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Vote> votes;

    // Constructors, getters, and setters
    public Candidate() {
		// TODO Auto-generated constructor stub
	}

	public Candidate(String name, String partyAffiliation, List<Election> elections, List<Vote> votes) {
		super();
		this.name = name;
		this.partyAffiliation = partyAffiliation;
		this.elections = elections;
		this.votes = votes;
	}

	public Candidate(Long id, String name, String partyAffiliation, List<Election> elections, List<Vote> votes) {
		super();
		this.id = id;
		this.name = name;
		this.partyAffiliation = partyAffiliation;
		this.elections = elections;
		this.votes = votes;
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

	public String getPartyAffiliation() {
		return partyAffiliation;
	}

	public void setPartyAffiliation(String partyAffiliation) {
		this.partyAffiliation = partyAffiliation;
	}

	public List<Election> getElections() {
		return elections;
	}

	public void setElections(List<Election> elections) {
		this.elections = elections;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", name=" + name + ", partyAffiliation=" + partyAffiliation + ", elections="
				+ elections + ", votes=" + votes + "]";
	}
    
}
