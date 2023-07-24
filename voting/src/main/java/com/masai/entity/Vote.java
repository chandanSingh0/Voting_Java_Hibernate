package com.masai.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "voter_id")
    private Voter voter;

    @ManyToOne
    @JoinColumn(name = "election_id")
    private Election election;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    private Date timestamp;
    // Other attributes and getters/setters

    // Constructors, getters, and setters
   public Vote() {
	// TODO Auto-generated constructor stub
}
	public Vote(Voter voter, Election election, Candidate candidate, Date timestamp) {
		super();
		this.voter = voter;
		this.election = election;
		this.candidate = candidate;
		this.timestamp = timestamp;
	}
	public Vote(Long id, Voter voter, Election election, Candidate candidate, Date timestamp) {
		super();
		this.id = id;
		this.voter = voter;
		this.election = election;
		this.candidate = candidate;
		this.timestamp = timestamp;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Voter getVoter() {
		return voter;
	}
	public void setVoter(Voter voter) {
		this.voter = voter;
	}
	public Election getElection() {
		return election;
	}
	public void setElection(Election election) {
		this.election = election;
	}
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "Vote [id=" + id + ", voter=" + voter + ", election=" + election + ", candidate=" + candidate
				+ ", timestamp=" + timestamp + "]";
	}
   
}

