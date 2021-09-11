package tn.esprit.serviceSuivi.service.Equipe;


import tn.esprit.serviceSuivi.Model.Equipe;
import java.util.List;

public interface IEquipeService {
    public Equipe addEquipe(Equipe equipe);
    public Equipe updateEquipe(Equipe equipeToUpdate, Equipe equipe);
    public Equipe getEquipe(Long equipeId);
    public List<Equipe> getEquipes();
    public void deleteEquipe(Long equipeId);
}
