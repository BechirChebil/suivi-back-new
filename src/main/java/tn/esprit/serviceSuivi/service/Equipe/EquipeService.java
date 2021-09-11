package tn.esprit.serviceSuivi.service.Equipe;

import tn.esprit.serviceSuivi.Model.Equipe;
import tn.esprit.serviceSuivi.repositories.Equipe.IEquipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService implements IEquipeService {

    IEquipeRepository equipeRepository;

    public EquipeService(IEquipeRepository equipeRepository) {
        this.equipeRepository = equipeRepository;
    }

    @Override
    public Equipe addEquipe(Equipe equipe) {
        equipeRepository.save(equipe);
        return equipe;
    }

    @Override
    public Equipe updateEquipe(Equipe equipeToUpdate, Equipe equipe) {

//        equipeToUpdate.setTitre(equipe.getTitre() != null ? equipe.getTitre() : equipeToUpdate.getTitre());
//        equipeToUpdate.setObjectif(equipe.getObjectif() != null ? equipe.getObjectif() : equipeToUpdate.getObjectif());
//        equipeToUpdate.setIndicationTuteur(equipe.getIndicationTuteur() != null ? equipe.getIndicationTuteur() : equipeToUpdate.getIndicationTuteur());
//        equipeToUpdate.setIndicationEtudiant(equipe.getIndicationEtudiant() != null ? equipe.getIndicationEtudiant() : equipeToUpdate.getIndicationEtudiant());
//        equipeToUpdate.setDate(equipe.getDate()  != null ? equipe.getDate() : equipeToUpdate.getDate());
//        equipeToUpdate.setCreneau(equipe.getCreneau()  != null ? equipe.getCreneau() : equipeToUpdate.getCreneau());
//
//        equipeToUpdate.setPhases(equipe.getPhases()  != null ? equipe.getPhases() : equipeToUpdate.getPhases());
//        equipeToUpdate.setTutor(equipe.getTutor()  != null ? equipe.getTutor() : equipeToUpdate.getTutor());


       /* if (equipe.getPhases() != null) {
            equipeToUpdate.setPhases(equipe.getPhases());
        }*/



        equipeRepository.save(equipeToUpdate);
        return equipeToUpdate;
    }

    @Override
    public Equipe getEquipe(Long equipeId) {
        Optional<Equipe> equipe = equipeRepository.findById(equipeId);
        return equipe.orElse(null);
    }

    @Override
    public List<Equipe> getEquipes() {
        return (List<Equipe>) equipeRepository.findAll();
    }

    @Override
    public void deleteEquipe(Long equipeId) {
        Optional<Equipe> equipe = equipeRepository.findById(equipeId);
        // equivalent to if equipe.isPresent ---> delete equipe object
        equipe.ifPresent(value -> equipeRepository.delete(value));
    }
}
