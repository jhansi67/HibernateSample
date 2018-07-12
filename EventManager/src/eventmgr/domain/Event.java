package eventmgr.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Event {
	@Id
	private int id; 
private String name;
private Date startDate;
   
	private  Location  Location;
	private Set<Speaker> speakers;

	public Set<Speaker> getSpeakers() { 
		return speakers; }

	/** set the event speakers (for use by Hibernate) */
	public void setSpeakers(Set<Speaker> speakers) {
		this.speakers = speakers;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	public Location getLocation() {
		return Location;
	}
	public void setLocation(Location location) {
		Location = location;
	}
	public Event() {
		super();
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", startDate=" + startDate + ", Location=" + Location + "]";
	}
	public Event( String name, Date startDate, eventmgr.domain.Location location) {
		super();
		this.name = name;
		this.startDate = startDate;
		Location = location;
	}
	
	
}
