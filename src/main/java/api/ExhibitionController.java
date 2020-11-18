package api;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.IExhibitionService;
import services.models.Exhibition;
import gallery.exhibitionserver.ExhibitionServerApplication;

import java.util.List;

@RestController
@RequestMapping("api/clients")
@RequiredArgsConstructor
public final class ExhibitionController {
    static final Logger log = LoggerFactory.getLogger(ExhibitionServerApplication.class);

    @Autowired
    private IExhibitionService exhibitionService;

    @GetMapping
    public ResponseEntity<List<Exhibition>> index() {
        return ResponseEntity.ok(exhibitionService.findAll());
    }

    @PostMapping
    public ResponseEntity<Exhibition> create(@RequestBody ExhibitionPayload payload) {
        Exhibition newExhibition = new Exhibition(payload.getName(),
                payload.getOpen());
        return ResponseEntity.ok(exhibitionService.save(newExhibition));
    }


    @GetMapping("{clientId}")
    public ResponseEntity<Exhibition> show(@PathVariable String clientId) throws NotFoundException {
        return ResponseEntity.ok(exhibitionService.getById(clientId));
    }

    @DeleteMapping("{clientId}")
    public ResponseEntity<Void> delete(@PathVariable String clientId) throws NotFoundException {
        exhibitionService.deleteById(clientId);
        return ResponseEntity.noContent().build();
    }
}