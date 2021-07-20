package meli.bootcamp.practicaspring4.units.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import meli.bootcamp.practicaspring4.dtos.LinkDTO;
import meli.bootcamp.practicaspring4.repositories.LinkTrackerRepository;
import meli.bootcamp.practicaspring4.repositories.LinkTrackerRepositoryImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@DisplayName("Unit Tet - Ingreditnet Repository Impl")
public class RepositoryTest {

    LinkTrackerRepository repo = new LinkTrackerRepositoryImp();

    @BeforeEach
    void setup(){
        /*String database = "[{\"linkId\":1,\"url\":\"https://google.com\",\"isValid\":true,\"cantRedirect\":2,\"password\":null},{\"linkId\":2,\"url\":\"https://facebook.com\",\"isValid\":true,\"cantRedirect\":0,\"password\":\"pepe\"},{\"linkId\":3,\"url\":\"https://twitter.com\",\"isValid\":false,\"cantRedirect\":15,\"password\":null}]";
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:links.json");
            if (file.exists()) {
                file.delete(); //you might want to check if delete was successfull
            }
            file.createNewFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(file, database);
        } catch (IOException e) {
            e.printStackTrace();
        }
        repo = new LinkTrackerRepositoryImp();*/
    }

    @Test
    @DisplayName("Found Link by Id")
    void foundLink() {
        //arrange
        Integer linkId = 1;
        LinkDTO expected =  new LinkDTO(1, "https://google.com", true, 2L, null);

        //act
        LinkDTO current = repo.getLink(linkId);

        //assert
        Assertions.assertEquals(expected, current);
    }

    @Test
    @DisplayName("Not found Link")
    void notFoundLink() {
        //arrange

        //arrange
        Integer linkId = 5;

        //act
        LinkDTO current = repo.getLink(linkId);

        //assert
        Assertions.assertNull(current);

    }

    @Test
    @DisplayName("Add link with password")
    void addLinkWithPassword() {
        //arrange
        String linkUrl = "https://google.com.ar";
        String linkPassword = "pepe";
        LinkDTO expected =  new LinkDTO(5, "https://google.com.ar", true, 0L, "pepe");

        //act
        LinkDTO current = repo.addLink(linkUrl, linkPassword);

        //assert
        Assertions.assertEquals(expected, current);
    }

    @Test
    @DisplayName("Add link without password")
    void addLinkWithoutPassword() {
        //arrange
        String linkUrl = "https://google.com.ar";
        LinkDTO expected =  new LinkDTO(5, "https://google.com.ar", true, 0L, null);

        //act
        LinkDTO current = repo.addLink(linkUrl, null);

        //assert
        Assertions.assertEquals(expected, current);
    }

    @Test
    @DisplayName("update Link")
    void updateLink() {
        //arrange
        LinkDTO linkDTO =  new LinkDTO(1, "https://google.com", true, 3L, null);
        LinkDTO expected =  new LinkDTO(1, "https://google.com", true, 3L, null);


        //act
        LinkDTO current = repo.updateLink(linkDTO);

        //assert
        Assertions.assertEquals(current, expected);

    }

    @Test
    @DisplayName("update Link - Not Found")
    void notFoundUpdateLink() {
        //arrange
        LinkDTO linkDTO =  new LinkDTO(5, "https://google.com", true, 3L, null);

        //act
        LinkDTO current = repo.updateLink(linkDTO);

        //assert
        Assertions.assertNull(current);

    }

}
