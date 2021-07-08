package meli.bootcamp.practicaspring4.services;

import meli.bootcamp.practicaspring4.dtos.requests.LinkRequestDTO;
import meli.bootcamp.practicaspring4.dtos.responses.LinkIdResponseDTO;
import meli.bootcamp.practicaspring4.dtos.responses.LinkInvalidateResponseDTO;
import meli.bootcamp.practicaspring4.dtos.responses.LinkMetricsResponseDTO;

public interface LinkTrackerService {


    LinkIdResponseDTO createLink(LinkRequestDTO request);

    String getLink(Integer linkId, String password);

    LinkMetricsResponseDTO getMetrics(Integer linkId);

    LinkInvalidateResponseDTO invalidateLink(Integer linkId);

}
