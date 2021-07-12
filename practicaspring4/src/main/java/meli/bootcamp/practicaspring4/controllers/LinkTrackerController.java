package meli.bootcamp.practicaspring4.controllers;

import meli.bootcamp.practicaspring4.dtos.requests.LinkRequestDTO;
import meli.bootcamp.practicaspring4.dtos.responses.LinkIdResponseDTO;
import meli.bootcamp.practicaspring4.dtos.responses.LinkInvalidateResponseDTO;
import meli.bootcamp.practicaspring4.dtos.responses.LinkMetricsResponseDTO;
import meli.bootcamp.practicaspring4.services.LinkTrackerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@RestController
@RequestMapping("/link")
@Validated
public class LinkTrackerController {

    LinkTrackerService linkTrackerService;

    public LinkTrackerController(LinkTrackerService linkTrackerService){
        this.linkTrackerService = linkTrackerService;
    }

    @PostMapping("/")
    public ResponseEntity<LinkIdResponseDTO> createLink(@Valid @RequestBody LinkRequestDTO request){

        return new ResponseEntity<>(linkTrackerService.createLink(request), HttpStatus.OK);
    }

    @GetMapping("/{linkId}")
    public RedirectView redirect(@PathVariable @NotNull(message = "El linkId no puede ser nulo")
                                     @Pattern(regexp = "[0-9]+", message = "El linkId debe ser numerico") String linkId,
                                            @RequestParam(required = false) String password){

        return linkTrackerService.getLink(Integer.valueOf(linkId), password);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkMetricsResponseDTO> getMetrics(@PathVariable @NotNull(message = "El linkId no puede ser nulo")
                                                                 @Pattern(regexp = "[0-9]+") String linkId){

        return new ResponseEntity<>(linkTrackerService.getMetrics(Integer.valueOf(linkId)), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<LinkInvalidateResponseDTO> invalidateLink(@PathVariable @NotNull(message = "El linkId no puede ser nulo")
                                                                        @Pattern(regexp = "[0-9]+", message = "El linkId debe ser un numero entero") String linkId){

        return new ResponseEntity<>(linkTrackerService.invalidateLink(Integer.valueOf(linkId)), HttpStatus.OK);
    }
}
