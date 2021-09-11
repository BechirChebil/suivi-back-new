package tn.esprit.serviceSuivi.Controller;

import tn.esprit.serviceSuivi.Model.Etudiant;
import tn.esprit.serviceSuivi.service.Etudiant.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class EtudiantController {
    @Autowired
    IEtudiantService etudiantService;
   // @CrossOrigin(origins = "http://localhost:3000/")


    public EtudiantController(IEtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping("/hello")
    public String getHello(){
        return "Hello";
    }

    @PostMapping("/etudiant")
    public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant) {
        etudiant=etudiantService.addEtudiant(etudiant);
        return new ResponseEntity<>(etudiant, HttpStatus.CREATED);
    }

    @PutMapping("/etudiant/{id}")
    public ResponseEntity<?> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        Etudiant etudiantToUpdate = etudiantService.getEtudiant(id);
        if (etudiantToUpdate != null) {
            return new ResponseEntity<> (etudiantService.updateEtudiant(etudiantToUpdate, etudiant), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/etudiant/{id}")
    public ResponseEntity<?> getEtudiant(@PathVariable Long id) {
        Etudiant etudiant = etudiantService.getEtudiant(id);
        HttpStatus responseStatus = etudiant != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(etudiant, responseStatus);
    }

//    @GetMapping("/etudiants/")
//    public ResponseEntity<?> getEtudiants() {
//        return new ResponseEntity<>(etudiantService.getEtudiants(), HttpStatus.OK);
//    }
//
//    public List<Etudiant> getEtudiants();

    @GetMapping("/etudiants")
    @ResponseBody
        public List<Etudiant> getEtudiants() {
        List<Etudiant> list = etudiantService.getEtudiants();
        return list;
    }

//    //Produits
//    @GetMapping(value = "/etudiants/")
//    public List<Etudiant> listeEtudiants() {
//        return etudiantService.getEtudiants();
//    }

    @DeleteMapping("/etudiant/{id}")
    public ResponseEntity<?> deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiant(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
