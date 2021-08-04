package meli.bootcamp.practicaspring5.units.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
/*
    @Mock
    LinkTrackerRepository repo;

    @InjectMocks
    LinkTrackerServiceImp service;

    @Test
    void getLink() {
        //arrange
        Integer linkId = 1;
        String expectedUrl = "https://google.com";

        //mocks
        LinkDTO returnRepo = new LinkDTO(1, "https://google.com", true, 3L, null);

        when(repo.getLink(1)).thenReturn(returnRepo);

        //act
        RedirectView current = service.getLink(linkId, null);

        //assert
        Mockito.verify(repo, Mockito.atLeast(1)).getLink(Mockito.anyInt());
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedUrl, current.getUrl())
        );
    }

    @Test
    void getLinkWithPassword() {
        //arrange
        Integer linkId = 1;
        String password = "pepe";
        String expectedUrl = "https://google.com";

        //mocks
        LinkDTO returnRepo = new LinkDTO(1, "https://google.com", true, 3L, "pepe");

        when(repo.getLink(1)).thenReturn(returnRepo);

        //act
        RedirectView current = service.getLink(linkId, password);

        //assert
        Mockito.verify(repo, Mockito.atLeast(1)).getLink(Mockito.anyInt());
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedUrl, current.getUrl())
        );
    }

    @Test
    void getLinkBadPassword() {
        //arrange
        Integer linkId = 1;
        String password = "pepe1";
        Map<String, String> errors = new HashMap<>();
        errors.put("password", "bad password");
        ErrorMessage expected = new ErrorMessage(400, "bad password", errors);

        //mocks
        LinkDTO returnRepo = new LinkDTO(1, "https://google.com", true, 3L, "pepe");

        when(repo.getLink(1)).thenReturn(returnRepo);

        //act && assert
        ApiException exception = Assertions.assertThrows(ApiException.class, () -> service.getLink(linkId, password));
        Mockito.verify(repo, Mockito.atLeast(1)).getLink(Mockito.anyInt());
        Assertions.assertEquals(expected, exception.getErrorMessage());
    }

    @Test
    void getLinkNotFound() {
        //arrange
        Integer linkId = 1;
        String password = "pepe";
        Map<String, String> errors = new HashMap<>();
        errors.put("linkId", "linkId not exist");
        ErrorMessage expected = new ErrorMessage(404, "not found", errors);

        //mocks
        LinkDTO returnRepo = null;
        when(repo.getLink(1)).thenReturn(returnRepo);

        //act && assert
        ApiException exception = Assertions.assertThrows(ApiException.class, () -> service.getLink(linkId, password));
        Mockito.verify(repo, Mockito.atLeast(1)).getLink(Mockito.anyInt());
        Assertions.assertEquals(expected, exception.getErrorMessage());
    }

    @Test
    void getLinkInvalidatedLink() {
        //arrange
        Integer linkId = 1;
        String password = "pepe";
        Map<String, String> errors = new HashMap<>();
        errors.put("linkId", "linkId is invalidated");
        ErrorMessage expected = new ErrorMessage(400, "invalid link", errors);

        //mocks
        LinkDTO returnRepo = new LinkDTO(1, "https://google.com", false, 3L, "pepe");

        when(repo.getLink(1)).thenReturn(returnRepo);

        //act && assert
        ApiException exception = Assertions.assertThrows(ApiException.class, () -> service.getLink(linkId, password));
        Mockito.verify(repo, Mockito.atLeast(1)).getLink(Mockito.anyInt());
        Assertions.assertEquals(expected, exception.getErrorMessage());
    }

    @Test
    void getLinkNotWork() {
        //arrange
        Integer linkId = 1;
        String password = "pepe";
        Map<String, String> errors = new HashMap<>();
        ErrorMessage expected = new ErrorMessage(400, "El link ingresado no funciona", errors);

        //mocks
        LinkDTO returnRepo = new LinkDTO(1, "google.com", true, 3L, "pepe");

        //when(repo.getLink(1)).thenReturn(returnRepo);

        //act && assert
        //ApiException exception = Assertions.assertThrows(ApiException.class, () -> service.getLink(linkId, password));
        //Mockito.verify(repo, Mockito.atLeast(1)).getLink(Mockito.anyInt());
        //Assertions.assertEquals(expected, exception.getErrorMessage());
    }

    @Test
    void getMetrics() {
        //arrange
        Integer linkId = 1;

        //mocks
        LinkDTO returnRepo = new LinkDTO(1, "https://google.com", true, 3L, "pepe");

        when(repo.getLink(1)).thenReturn(returnRepo);

        //act
        LinkMetricsResponseDTO current = service.getMetrics(linkId);

        //assert
        Mockito.verify(repo, Mockito.atLeast(1)).getLink(Mockito.anyInt());
        Assertions.assertAll(
                () -> Assertions.assertEquals(3L, current.getCantRedirect()),
                () -> Assertions.assertEquals(1, current.getLinkId())
        );
    }

    @Test
    void getInvalidateLink() {
        //arrange
        Integer linkId = 1;

        //mocks
        LinkDTO returnRepo = new LinkDTO(1, "https://google.com", true, 3L, "pepe");

        when(repo.getLink(1)).thenReturn(returnRepo);

        //act
        LinkInvalidateResponseDTO current = service.invalidateLink(linkId);

        //assert
        Mockito.verify(repo, Mockito.atLeast(1)).getLink(Mockito.anyInt());
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, current.getLinkId()),
                () -> Assertions.assertEquals(true, current.getInvalidate())
        );
    }

    @Test
    void getCreateLink() {
        //arrange
        LinkRequestDTO linkRequestDTO = new LinkRequestDTO();
        linkRequestDTO.setPassword("pepe");
        linkRequestDTO.setUrl("https://google.com");

        //mocks
        String url = "https://google.com";
        String password = "pepe";
        LinkDTO returnRepo = new LinkDTO(1, "https://google.com", true, 3L, "pepe");

        when(repo.addLink(url, password)).thenReturn(returnRepo);

        //act
        LinkIdResponseDTO current = service.createLink(linkRequestDTO);

        //assert
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, current.getLinkId()),
                () -> Assertions.assertEquals("https://google.com", current.getUrl())
        );
    }*/
}
