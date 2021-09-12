package tn.esprit.serviceSuivi.Controller;
import tn.esprit.serviceSuivi.service.PlanDay.IPlanDayService;
import tn.esprit.serviceSuivi.Model.PlanDay;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlanDayController {
    IPlanDayService planDayService;

    public PlanDayController(IPlanDayService planDayService) {
        this.planDayService = planDayService;
    }

//    @PostMapping("/planDay")
//    public ResponseEntity<?> addPlanDay(@RequestBody PlanDay planDay) {
//        return new ResponseEntity<>(planDayService.addPlanDay(planDay), HttpStatus.CREATED);
//    }
    @PostMapping("/planDay")
    public ResponseEntity<PlanDay> addPlanDay(@RequestBody PlanDay planDay) {
        planDay=planDayService.addPlanDay(planDay);
        return new ResponseEntity<>(planDay, HttpStatus.CREATED);
    }

    @PutMapping("/planDay/{id}")
    public ResponseEntity<?> updatePlanDay(@PathVariable Long id, @RequestBody PlanDay planDay) {
        PlanDay planDayToUpdate = planDayService.getPlanDay(id);
        if (planDayToUpdate != null) {
            return new ResponseEntity<> (planDayService.updatePlanDay(planDayToUpdate, planDay), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/planDay/{id}")
    public ResponseEntity<?> getPlanDay(@PathVariable Long id) {
        PlanDay planDay = planDayService.getPlanDay(id);
        HttpStatus responseStatus = planDay != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(planDay, responseStatus);
    }

    @GetMapping("/planDays")
    public ResponseEntity<?> getPlanDays() {
        return new ResponseEntity<>(planDayService.getPlanDays(), HttpStatus.OK);
    }

    @DeleteMapping("/planDay/{id}")
    public ResponseEntity<?> deletePlanDay(@PathVariable Long id) {
        planDayService.deletePlanDay(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
