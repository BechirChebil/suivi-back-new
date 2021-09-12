package tn.esprit.serviceSuivi.service.Suivi;


import tn.esprit.serviceSuivi.Model.Suivi;
import java.util.List;

public interface ISuiviService {
    public Suivi addSuivi(Suivi suivi);
    public Suivi updateSuivi(Suivi suiviToUpdate, Suivi suivi);
    public Suivi getSuivi(Long suiviId);
    public List<Suivi> getSuivis();
    public void deleteSuivi(Long suiviId);
}
