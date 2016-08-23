package com.training;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT")
public class EventPOJO {

	private int eventId;
	private String eventName;

	private Set<SpeakerPOJO> speakers;

	public EventPOJO() {
	}

	public EventPOJO(String eventName) {
		this.eventName = eventName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EVENT_ID")
	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	@Column(name = "EVENT_NAME")
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "EVENT_SPEAKER", joinColumns = { @JoinColumn(name = "EVENT_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "SPEAKER_ID") })
	public Set<SpeakerPOJO> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(Set<SpeakerPOJO> speakers) {
		this.speakers = speakers;
	}

}
