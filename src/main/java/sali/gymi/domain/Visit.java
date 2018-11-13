package sali.gymi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Visit {
	
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long visitid;
		private String date;
		
		@ManyToOne
		@JsonIgnore
		@JoinColumn(name = "id") 
		private Sali sali;
		
		public Visit () {}
		
		public Visit(String date){
			super();
			this.date = date;
		}

		public Long getVisitid() {
			return visitid;
		}

		public void setVisitid(Long visitid) {
			this.visitid = visitid;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public Sali getSali() {
			return sali;
		}

		public void setSali(Sali sali) {
			this.sali = sali;
		}

		@Override
		public String toString() {
			return "Visit [visitid=" + visitid + ", date=" + date + ", sali=" + sali + "]";
		}

}
