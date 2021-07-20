package meli.bootcamp.practicaspring4.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import meli.bootcamp.practicaspring4.dtos.LinkDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class LinkTrackerRepositoryImp implements LinkTrackerRepository {

    private final AtomicInteger index = new AtomicInteger(lastLinkId());
    private final Map<Integer, LinkDTO> links = loadLinks();

    private static Map<Integer, LinkDTO> loadLinks() {
        List<LinkDTO> list = loadDatabase();
        Map<Integer, LinkDTO> linkDTOMap = new HashMap<>();
        if(Objects.isNull(list)) {
            return linkDTOMap;
        }
        for(LinkDTO l : list) {
            linkDTOMap.put(l.getLinkId(), l);
        }
        return linkDTOMap;
    }

    private static Integer lastLinkId() {
        List<LinkDTO> list = loadDatabase();
        if(Objects.isNull(list)) {
            return 0;
        }
        Optional<LinkDTO> max = list.stream().max(Comparator.comparing(LinkDTO::getLinkId));
        return max.isPresent() ? max.get().getLinkId() : 0;
    }

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
        //saveFile(new ArrayList<>(links.values()));
        return linkDTO;
    }

    @Override
    public LinkDTO updateLink(LinkDTO linkDTO) {
        if(links.containsKey(linkDTO.getLinkId())) {
            //saveFile(new ArrayList<>(links.values()));
            links.put(linkDTO.getLinkId(), linkDTO);
            return links.get(linkDTO.getLinkId());
        }

        return null;
    }

    private void saveFile(List<LinkDTO> linkDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            objectMapper.writeValue(ResourceUtils.getFile("classpath:links.json"), linkDTO);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static List<LinkDTO> loadDatabase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:links.json");
        }catch (FileNotFoundException e){
            //e.printStackTrace();
        }

        return mapObject(file);
    }

    private static List<LinkDTO> mapObject(File file){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<LinkDTO>> typeReference = new TypeReference<>(){};
        List<LinkDTO> linkDTOS = null;
        try {
            linkDTOS = objectMapper.readValue(file, typeReference);
        }catch (IOException e){
            //e.printStackTrace();
        }

        return linkDTOS;
    }

}
