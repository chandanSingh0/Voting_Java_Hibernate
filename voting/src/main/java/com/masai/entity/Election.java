package com.masai.entity;


import java.sql.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private String status;
    // Other attributes and getters/setters
    @ManyToOne
    @JoinColumn(name = "candidate_id") // Adjust the column name based on your database schema
    private Candidate candidate;
    @ManyToMany(mappedBy = "elections")
    private List<Voter> voters;

    // Constructors, getters, and setters
    public Election() {
		// TODO Auto-generated constructor stub
	}

	public Election(String title, String description, Date startDate, Date endDate, String status, Candidate candidate,
			List<Voter> voters) {
		super();
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.candidate = candidate;
		this.voters = voters;
	}

	public Election(Long id, String title, String description, Date startDate, Date endDate, String status,
			Candidate candidate, List<Voter> voters) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.candidate = candidate;
		this.voters = voters;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public List<Voter> getVoters() {
		return voters;
	}

	public void setVoters(List<Voter> voters) {
		this.voters = voters;
	}

	@Override
	public String toString() {
		return "Election [id=" + id + ", title=" + title + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", status=" + status + ", candidate=" + candidate + ", voters=" + voters
				+ "]";
	}

	
    
}
