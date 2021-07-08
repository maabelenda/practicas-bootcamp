package meli.bootcamp.practicaspring4.repositories;

import meli.bootcamp.practicaspring4.dtos.LinkDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class LinkTrackerRepositoryImp implements LinkTrackerRepository {

    private AtomicInteger index = new AtomicInteger(0);
    private Map<Integer, LinkDTO> links = new HashMap<>();

    @Override
    public LinkDTO getLink(Integer linkId) {

        if(links.containsKey(linkId)) {
            return links.get(linkId);
        }

        return null;
    }

    @Override
    public LinkDTO addLink(String url, String password) {

        LinkDTO linkDTO = new LinkDTO(index.addAndGet(1), url, true, 0L, password);
        links.put(linkDTO.getLinkId(), linkDTO);
        return linkDTO;
    }

    @Override
    public LinkDTO updateLink(LinkDTO linkDTO) {
        if(links.containsKey(linkDTO.getLinkId())) {
            links.put(linkDTO.getLinkId(), linkDTO);
        }

        return null;
    }

}
