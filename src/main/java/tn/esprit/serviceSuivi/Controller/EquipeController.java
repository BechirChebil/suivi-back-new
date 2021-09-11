package tn.esprit.serviceSuivi.Controller;
import tn.esprit.serviceSuivi.Model.Etudiant;
import tn.esprit.serviceSuivi.service.Equipe.IEquipeService;
import tn.esprit.serviceSuivi.Model.Equipe;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EquipeController {
    IEquipeService equipeService;

    public EquipeController(IEquipeService equipeService) {
        this.equipeService = equipeService;
    }

//    @PostMapping("/equipe")
//    public ResponseEntity<?> addEquipe(@RequestBody Equipe equipe) {
//        return new ResponseEntity<>(equipeService.addEquipe(equipe), HttpStatus.CREATED);
//    }
    @PostMapping("/equipe")
    public ResponseEntity<Equipe> addEquipe(@RequestBody Equipe equipe) {
        equipe=equipeService.addEquipe(equipe);
        return new ResponseEntity<>(equipe, HttpStatus.CREATED);
    }

    @PutMapping("/equipe/{id}")
    public ResponseEntity<?> updateEquipe(@PathVariable Long id, @RequestBody Equipe equipe) {
        Equipe equipeToUpdate = equipeService.getEquipe(id);
        if (equipeToUpdate != null) {
            return new ResponseEntity<> (equipeService.updateEquipe(equipeToUpdate, equipe), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/equipe/{id}")
    public ResponseEntity<?> getEquipe(@PathVariable Long id) {
        Equipe equipe = equipeService.getEquipe(id);
        HttpStatus responseStatus = equipe != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(equipe, responseStatus);
    }

    @GetMapping("/equipes")
    public ResponseEntity<?> getEquipes() {
        return new ResponseEntity<>(equipeService.getEquipes(), HttpStatus.OK);
    }

    @DeleteMapping("/equipe/{id}")
    public ResponseEntity<?> deleteEquipe(@PathVariable Long id) {
        equipeService.deleteEquipe(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
