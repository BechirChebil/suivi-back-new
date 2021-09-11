package tn.esprit.serviceSuivi.Controller;

import tn.esprit.serviceSuivi.Model.Tutor;
import tn.esprit.serviceSuivi.service.Tutor.ITutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TutorController {
    ITutorService tutorService;

    public TutorController(ITutorService tutorService) {
        this.tutorService = tutorService;
    }

    @PostMapping("/tutor")
    public ResponseEntity<?> addTutor(@RequestBody Tutor tutor) {
        return new ResponseEntity<>(tutorService.addTutor(tutor), HttpStatus.CREATED);
    }
    
    @PostMapping("/tutor-copy/{id}")
    public ResponseEntity<?> copyTutor(@PathVariable Long id) {
    	
        return new ResponseEntity<>(tutorService.copyTutor(id), HttpStatus.CREATED);
    }
    
//    @PostMapping("/tutor/{id}")
//    public ResponseEntity<?> exportTutor(@PathVariable Long id, @RequestBody Tutor tutor) {
//        Tutor tutorToUpdate = tutorService.getTutor(id);
//        if (tutorToUpdate != null) {
//            return new ResponseEntity<> (tutorService.exportTutor(tutorToUpdate, tutor), HttpStatus.OK);
//        }
//        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//    }

    @PutMapping("/tutor/{id}")
    public ResponseEntity<?> updateTutor(@PathVariable Long id, @RequestBody Tutor tutor) {
        Tutor tutorToUpdate = tutorService.getTutor(id);
        if (tutorToUpdate != null) {
            return new ResponseEntity<> (tutorService.updateTutor(tutorToUpdate, tutor), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/tutor/{id}")
    public ResponseEntity<?> getTutor(@PathVariable Long id) {
        Tutor tutor = tutorService.getTutor(id);
        HttpStatus responseStatus = tutor != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(tutor, responseStatus);
    }

    @GetMapping("/tutors")
    public ResponseEntity<?> getTutors() {
        return new ResponseEntity<>(tutorService.getTutors(), HttpStatus.OK);
    }

    @DeleteMapping("/tutor/{id}")
    public ResponseEntity<?> deleteTutor(@PathVariable Long id) {
        tutorService.deleteTutor(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

}
