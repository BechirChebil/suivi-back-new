package tn.esprit.serviceSuivi.Model;

import java.util.Date;

import javax.persistence.*;

@Entity
public class PlanDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date day_date;
    private String creneau;
    public PlanDay() {
    }

    public PlanDay(Long id, Date day_date) {
        this.id = id;
        this.setDay_date(day_date);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public Date getDay_date() {
		return day_date;
	}

	public void setDay_date(Date day_date) {
		this.day_date = day_date;
	}

	public String getCreneau() {
		return creneau;
	}

	public void setCreneau(String creneau) {
		this.creneau = creneau;
	}



}
