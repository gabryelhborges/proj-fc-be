package unoeste.fipp.ativooperante_be.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unoeste.fipp.ativooperante_be.db.entities.Feedback;
import unoeste.fipp.ativooperante_be.db.repositories.FeedbackRepository;

import java.util.List;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository rep;

    public List<Feedback> getAll(){
        return rep.findAll();
    }
}
