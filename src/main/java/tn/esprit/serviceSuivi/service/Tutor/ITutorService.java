package tn.esprit.serviceSuivi.service.Tutor;

import tn.esprit.serviceSuivi.Model.Tutor;

import java.util.List;

public interface ITutorService {

    public Tutor addTutor(Tutor tutor);
    public Tutor copyTutor(Long tutorId);
    public Tutor exportTutor(Tutor tutorToUpdate, Tutor tutor);
    public Tutor updateTutor(Tutor tutorToUpdate, Tutor tutor);
    public Tutor getTutor(Long tutorId);
    public List<Tutor> getTutors();
    public void deleteTutor(Long tutorId);
}
