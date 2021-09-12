package tn.esprit.serviceSuivi.Controller;
import tn.esprit.serviceSuivi.Model.Etudiant;
import tn.esprit.serviceSuivi.service.Suivi.ISuiviService;
import tn.esprit.serviceSuivi.Model.Suivi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SuiviController {
    ISuiviService suiviService;

    public SuiviController(ISuiviService suiviService) {
        this.suiviService = suiviService;
    }

//    @PostMapping("/suivi")
//    public ResponseEntity<?> addSuivi(@RequestBody Suivi suivi) {
//        return new ResponseEntity<>(suiviService.addSuivi(suivi), HttpStatus.CREATED);
//    }
    @PostMapping("/suivi")
    public ResponseEntity<Suivi> addSuivi(@RequestBody Suivi suivi) {
        suivi=suiviService.addSuivi(suivi);
        return new ResponseEntity<>(suivi, HttpStatus.CREATED);
    }

    @PutMapping("/suivi/{id}")
    public ResponseEntity<?> updateSuivi(@PathVariable Long id, @RequestBody Suivi suivi) {
        Suivi suiviToUpdate = suiviService.getSuivi(id);
        if (suiviToUpdate != null) {
            return new ResponseEntity<> (suiviService.updateSuivi(suiviToUpdate, suivi), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/suivi/{id}")
    public ResponseEntity<?> getSuivi(@PathVariable Long id) {
        Suivi suivi = suiviService.getSuivi(id);
        HttpStatus responseStatus = suivi != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(suivi, responseStatus);
    }

    @GetMapping("/suivis")
    public ResponseEntity<?> getSuivis() {
        return new ResponseEntity<>(suiviService.getSuivis(), HttpStatus.OK);
    }

    @DeleteMapping("/suivi/{id}")
    public ResponseEntity<?> deleteSuivi(@PathVariable Long id) {
        suiviService.deleteSuivi(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
