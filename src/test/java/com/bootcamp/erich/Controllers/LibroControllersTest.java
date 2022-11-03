package com.bootcamp.erich.Controllers;

import com.bootcamp.erich.Entity.Libro;
import io.swagger.v3.oas.annotations.media.Schema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LibroControllersTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        /*CONTRUIMOS EL OBJETO RESTEMPLATE*/
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @DisplayName("Comprobar lista desde los controladores Spring Rest")
    @Test
    void findAll() {
        ResponseEntity<Libro[]> response = testRestTemplate.getForEntity("/v1/listar", Libro[].class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(200,response.getStatusCodeValue());
        List<Libro> libros = Arrays.asList(response.getBody());
        System.out.println(libros.size());
    }

    @Test
    void crear() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        /*SE UTILZIA ESTE JSON APARTIR DE JAVA 15 PARA PROBARLO CON TRIPE COMILLA*/
//        String json = """
//                {
//                "title":"Libro probando",
//                "autor":"er",
//                "nroPages":5,
//                "precio":20,
//                "releaseDate":"2022-11-02",
//                "online":false
//                }
//                """;
//
//        HttpEntity<String> request = new HttpEntity<>(json,headers);
//        ResponseEntity<Libro> response = testRestTemplate.exchange("/v1/crear", HttpMethod.POST, request, Libro.class);
//        Libro body = response.getBody();
//        assertEquals(1L,body.getId());
//        assertEquals("Libro creado desde spring",body.getTitulo());
    }

    @Test
    void buscar() {
        ResponseEntity<Libro> response = testRestTemplate.getForEntity("/v1/libro/1", Libro.class);
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }
}