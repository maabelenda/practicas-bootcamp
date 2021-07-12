package meli.bootcamp.practicaspring4.services;

import meli.bootcamp.practicaspring4.dtos.LinkDTO;
import meli.bootcamp.practicaspring4.dtos.requests.LinkRequestDTO;
import meli.bootcamp.practicaspring4.dtos.responses.LinkIdResponseDTO;
import meli.bootcamp.practicaspring4.dtos.responses.LinkInvalidateResponseDTO;
import meli.bootcamp.practicaspring4.dtos.responses.LinkMetricsResponseDTO;
import meli.bootcamp.practicaspring4.exceptions.ApiException;
import meli.bootcamp.practicaspring4.repositories.LinkTrackerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LinkTrackerServiceImp implements LinkTrackerService {

    LinkTrackerRepository linkTrackerRepository;

    public LinkTrackerServiceImp(LinkTrackerRepository linkTrackerRepository){
        this.linkTrackerRepository = linkTrackerRepository;
    }

    @Override
    public LinkIdResponseDTO createLink(LinkRequestDTO request) {
        LinkDTO linkDTO = linkTrackerRepository.addLink(request.getUrl(), request.getPassword());
        return new LinkIdResponseDTO(linkDTO.getUrl(), linkDTO.getLinkId());
    }

    @Override
    public RedirectView getLink(Integer linkId, String password) {

        LinkDTO linkDTO = linkTrackerRepository.getLink(linkId);

        validLinkDTO(linkDTO);

        if(Objects.nonNull(linkDTO.getPassword()) && !linkDTO.getPassword().equals(password)) {
            Map<String, String> errors = new HashMap<>();
            errors.put("password", "bad password");
            throw new ApiException(400, "bad password", errors);
        }

        linkDTO.setCantRedirect(linkDTO.getCantRedirect()+1);
        linkTrackerRepository.updateLink(linkDTO);

        try {
            return new RedirectView(linkDTO.getUrl());
        } catch (MethodArgumentTypeMismatchException e) {
            Map<String, String> errors = new HashMap<>();
            throw new ApiException(HttpStatus.BAD_GATEWAY.value(), "El link ingresado no funciona", errors);
        }
    }

    @Override
    public LinkMetricsResponseDTO getMetrics(Integer linkId) {
        LinkDTO linkDTO = linkTrackerRepository.getLink(linkId);

        validLinkDTO(linkDTO);

        return new LinkMetricsResponseDTO(linkDTO.getCantRedirect(), linkDTO.getLinkId());
    }

    @Override
    public LinkInvalidateResponseDTO invalidateLink(Integer linkId) {
        LinkDTO linkDTO = linkTrackerRepository.getLink(linkId);

        validLinkDTO(linkDTO);

        linkDTO.setValid(false);
        linkTrackerRepository.updateLink(linkDTO);

        return new LinkInvalidateResponseDTO(!linkDTO.isValid(),linkDTO.getLinkId());
    }

    private void validLinkDTO(LinkDTO linkDTO) {
        if(Objects.isNull(linkDTO)) {
            Map<String, String> errors = new HashMap<>();
            errors.put("linkId", "linkId not exist");
            throw new ApiException(404, "not found", errors);
        }

        if(!linkDTO.isValid()) {
            Map<String, String> errors = new HashMap<>();
            errors.put("linkId", "linkId is invalidated");
            throw new ApiException(400, "invalid link", errors);
        }
    }
}
