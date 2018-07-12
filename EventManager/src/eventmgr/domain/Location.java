package eventmgr.domain;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location {
    @Id
	private int id ;
	
	private String name; 
	private String address;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String adress) {
		this.address = adress;
	}
	public Location( String name, String adress) {
		super();
		this.name = name;
		this.address = adress;
	}
	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + ", adress=" + address + "]";
	}
	public Location() {
		super();
	}
	
	
}
