package meli.bootcamp.practicaspring4.repositories;

import meli.bootcamp.practicaspring4.dtos.LinkDTO;

public interface LinkTrackerRepository {

    LinkDTO getLink(Integer linkId);
    LinkDTO addLink(String url, String password);
    LinkDTO updateLink(LinkDTO linkDTO);

}
