package tn.esprit.serviceSuivi.service.PlanDay;

import tn.esprit.serviceSuivi.Model.PlanDay;
import tn.esprit.serviceSuivi.Model.Etudiant;
import tn.esprit.serviceSuivi.repositories.PlanDay.IPlanDayRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanDayService implements IPlanDayService {

    IPlanDayRepository planDayRepository;

    public PlanDayService(IPlanDayRepository planDayRepository) {
        this.planDayRepository = planDayRepository;
    }

    @Override
    public PlanDay addPlanDay(PlanDay planDay) {
        //planDayRepository.save(planDay);
        return planDayRepository.save(planDay);
    }


    @Override
    public PlanDay updatePlanDay(PlanDay planDayToUpdate, PlanDay planDay) {
    	planDayToUpdate.setDay_date(planDay.getDay_date() != null ? planDay.getDay_date() : planDayToUpdate.getDay_date());
    	planDayToUpdate.setCreneau(planDay.getCreneau() != null ? planDay.getCreneau() : planDayToUpdate.getCreneau());

        planDayRepository.save(planDayToUpdate);
        return planDayToUpdate;
    }

    @Override
    public PlanDay getPlanDay(Long planDayId) {
        Optional<PlanDay> planDay = planDayRepository.findById(planDayId);
        return planDay.orElse(null);
    }

    @Override
    public List<PlanDay> getPlanDays() {
        return (List<PlanDay>) planDayRepository.findAll();
    }

    @Override
    public void deletePlanDay(Long planDayId) {
        Optional<PlanDay> planDay = planDayRepository.findById(planDayId);
        // equivalent to if planDay.isPresent ---> delete planDay object
        planDay.ifPresent(value -> planDayRepository.delete(value));
    }
}
