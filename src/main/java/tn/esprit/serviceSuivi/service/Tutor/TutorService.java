package tn.esprit.serviceSuivi.service.Tutor;

import tn.esprit.serviceSuivi.Model.*;

import tn.esprit.serviceSuivi.repositories.Tutor.ITutorRepository;
import tn.esprit.serviceSuivi.service.Etudiant.EtudiantService;
import tn.esprit.serviceSuivi.service.Equipe.EquipeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService implements ITutorService {
	EquipeService equipeService;
    ITutorRepository ITutorRepository;
    EtudiantService etudiantService;
    public TutorService(
    		ITutorRepository tutorRepository,
    		EquipeService equipeService,
    		EtudiantService etudiantService){
        this.ITutorRepository = tutorRepository;
        this.equipeService =	equipeService;
        this.etudiantService = etudiantService;
    }

    @Override
    public Tutor addTutor(Tutor tutor) {
       ITutorRepository.save(tutor);
        return tutor;
    }
    
    @Override
    public Tutor copyTutor(Long tutorId) {
//    	Tutor tutor = this.getTutor(tutorId);
//    	Tutor tutorCopy = new Tutor();
//    	tutorCopy.setTitre(tutor.getTitre().concat("(copie)"));
//    	tutorCopy.setStartTime(tutor.getStartTime());
//        ITutorRepository.save(tutorCopy);
//
//    	List<Equipe> equipes = (List<Equipe>) tutor.getEquipes();
//
//    	for (int i = 0; i < equipes.size(); i++) {
//    		Equipe equipe = equipes.get(i);
//    		Equipe equipeCopy = new Equipe();
//    		equipeCopy.setTutor(tutorCopy);
//    		equipeCopy.setTitre(equipe.getTitre());
//    		equipeCopy.setCreneau(equipe.getCreneau());
//    		equipeCopy.setDate(equipe.getDate());
//    		equipeCopy.setIndicationEtudiant(equipe.getIndicationEtudiant());
//    		equipeCopy.setIndicationTuteur(equipe.getIndicationTuteur());
//    		equipeCopy.setObjectif(equipe.getObjectif());
//    		equipeService.addEquipe(equipeCopy);
//
//        	List<Etudiant> etudiants = (List<Etudiant>) equipe.getEtudiants();
//        	for (int y = 0; y < etudiants.size(); y++) {
//        		Etudiant etudiant = etudiants.get(y);
//        		Etudiant etudiantCopy = new Etudiant();
//        		etudiantCopy.setDiscription(etudiant.getDiscription());
//        		etudiantCopy.setEndTime(etudiant.getEndTime());
//        		etudiantCopy.setRendu(etudiant.getRendu());
//        		etudiantCopy.setEquipe(equipeCopy);
//        		etudiantCopy.setStartTime(etudiant.getStartTime());
//        		etudiantCopy.setTitre(etudiant.getTitre());
//
//        		etudiantService.addEtudiant(etudiantCopy);
//        	}
//    	}
        //return tutorCopy;
        return null;
    }
    
    @Override
    public Tutor exportTutor(Tutor tutorToUpdate, Tutor tutor) {
//
//        tutorToUpdate.setTitre(tutor.getTitre() != null ? tutor.getTitre() : tutorToUpdate.getTitre());
//        // tutorToUpdate.setStartTime(tutor.getDiscription() != null ? tutor.getDiscription() : tutorToUpdate.getDiscription());
//        //tutorToUpdate.setRendu(tutor.getRendu() != null ? tutor.getRendu() : tutorToUpdate.getRendu());
//        tutorToUpdate.setStartTime(tutor.getStartTime() != null ? tutor.getStartTime() : tutorToUpdate.getStartTime());
//        //tutorToUpdate.setEquipes(tutor.getEquipes()  != null ? tutor.getEquipes() : tutorToUpdate.getEquipes());
//
//        if (tutor.getEquipes() != null) {
//            tutorToUpdate.setEquipes(tutor.getEquipes());
//        }
//
//        ITutorRepository.save(tutorToUpdate);
//        return tutorToUpdate;
        return null;
    }

    @Override
    public Tutor updateTutor(Tutor tutorToUpdate, Tutor tutor) {

//        tutorToUpdate.setTitre(tutor.getTitre() != null ? tutor.getTitre() : tutorToUpdate.getTitre());
//       // tutorToUpdate.setStartTime(tutor.getDiscription() != null ? tutor.getDiscription() : tutorToUpdate.getDiscription());
//        //tutorToUpdate.setRendu(tutor.getRendu() != null ? tutor.getRendu() : tutorToUpdate.getRendu());
//        tutorToUpdate.setStartTime(tutor.getStartTime() != null ? tutor.getStartTime() : tutorToUpdate.getStartTime());
//        //tutorToUpdate.setEquipes(tutor.getEquipes()  != null ? tutor.getEquipes() : tutorToUpdate.getEquipes());
//        tutorToUpdate.setSujet(tutor.getSujet() != null ? tutor.getSujet() : tutorToUpdate.getSujet());
//        tutorToUpdate.setIntroduction(tutor.getIntroduction() != null ? tutor.getIntroduction() : tutorToUpdate.getIntroduction());
//
//        if (tutor.getEquipes() != null) {
//            tutorToUpdate.setEquipes(tutor.getEquipes());
//        }
//
//        ITutorRepository.save(tutorToUpdate);
//        return tutorToUpdate;
        return null;
    }

//    @Override
//    public Tutor getTutor(Long tutorId) {
//        return null;
//    }

//    @Override
//    public List<Tutor> getTutors() {
//        return null;
//    }

    @Override
    public void deleteTutor(Long tutorId) {

    }

    @Override
    public Tutor getTutor(Long tutorId) {
        Optional<Tutor> tutor = ITutorRepository.findById(tutorId);
        return tutor.orElse(null);
    }

    @Override
    public List<Tutor> getTutors() {
        return (List<Tutor>) ITutorRepository.findAll();
    }
//
//    @Override
//    public void deleteTutor(Long tutorId) {
//        Optional<Tutor> tutor = ITutorRepository.findById(tutorId);
//        tutor.ifPresent(value->ITutorRepository.delete(value));
//    }
}
