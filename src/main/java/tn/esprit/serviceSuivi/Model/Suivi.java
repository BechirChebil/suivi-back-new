package tn.esprit.serviceSuivi.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Suivi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String etat;

    private Long plan_day_id;

    private Long tutor_id;

    public Suivi() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Long getPlan_day_id() {
		return plan_day_id;
	}

	public void setPlan_day_id(Long plan_day_id) {
		this.plan_day_id = plan_day_id;
	}

	public Long getTutor_id() {
		return tutor_id;
	}

	public void setTutor_id(Long tutor_id) {
		this.tutor_id = tutor_id;
	}


}
