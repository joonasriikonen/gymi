package sali.gymi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sali {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String day;
	private String toistot;
	private String sarjat;
	private String kg;
	private String kommentti;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "liikeid") 
	private Liike liike;
	
	public Sali() {}
	
	public Sali(String day, String toistot, String sarjat, String kg, String kommentti, Liike liike){
		super();
		this.day = day;
		this.toistot = toistot;
		this.sarjat = sarjat;
		this.kg = kg;
		this.kommentti = kommentti;
		this.liike = liike;
		
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getToistot() {
		return toistot;
	}

	public void setToistot(String toistot) {
		this.toistot = toistot;
	}

	public String getSarjat() {
		return sarjat;
	}

	public void setSarjat(String sarjat) {
		this.sarjat = sarjat;
	}

	public String getKg() {
		return kg;
	}

	public void setKg(String kg) {
		this.kg = kg;
	}

	public String getKommentti() {
		return kommentti;
	}

	public void setKommentti(String kommentti) {
		this.kommentti = kommentti;
	}

	public Liike getLiike() {
		return liike;
	}

	public void setLiike(Liike liike) {
		this.liike = liike;
	}

	@Override
	public String toString() {
		return "Sali [id=" + id + ", day=" + day + ", toistot=" + toistot + ", sarjat=" + sarjat + ", kg=" + kg
				+ ", kommentti=" + kommentti + ", liike=" + liike + "]";
	}
	
	
}
