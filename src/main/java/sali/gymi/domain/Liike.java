package sali.gymi.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Liike {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long liikeid;
	private String liikeName;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "liike")
	private List<Sali> salit;
	
	public Liike () { 
		
	}
	
	public Liike (String liikeName){
		super();
		this.liikeName = liikeName;
	}
	
	public List<Sali> getSalit() {
		return salit;
	}

	public void setSalit(List<Sali> salit) {
		this.salit = salit;
	}
	
	public Long getLiikeid() {
		return liikeid;
	}

	public void setLiikeid(Long liikeid) {
		this.liikeid = liikeid;
	}

	public String getLiikeName() {
		return liikeName;
	}

	public void setLiikeName(String liikeName) {
		this.liikeName = liikeName;
	}

	

	@Override
	public String toString() {
		return "Liike [Liikeid=" + liikeid + ", liikeName=" + liikeName + "]";
	}
	
	
}
