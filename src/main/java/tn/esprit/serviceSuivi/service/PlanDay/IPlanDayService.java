package tn.esprit.serviceSuivi.service.PlanDay;


import tn.esprit.serviceSuivi.Model.PlanDay;
import java.util.List;

public interface IPlanDayService {
    public PlanDay addPlanDay(PlanDay planDay);
    public PlanDay updatePlanDay(PlanDay planDayToUpdate, PlanDay planDay);
    public PlanDay getPlanDay(Long planDayId);
    public List<PlanDay> getPlanDays();
    public void deletePlanDay(Long planDayId);
}
