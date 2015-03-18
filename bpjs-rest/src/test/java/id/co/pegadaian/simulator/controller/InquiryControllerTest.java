package id.co.pegadaian.simulator.controller;

import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.with;
import com.jayway.restassured.http.ContentType;
import id.co.pegadaian.simulator.App;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebIntegrationTest
public class InquiryControllerTest {
    
    @Value("${local.server.port}")
    private Integer port;
    
    @Before
    public void persiapan(){
        RestAssured.port = port;
    }
    
    @Test
    public void testInquiryKesehatan(){
        with()
            .accept(ContentType.JSON)
        .expect()
            .statusCode(200)
            .body("[0].peserta.nama", equalTo("Endy Muhardin"), "[0].id", equalTo("t001"))
        .when()
            .get("/inquiry/kesehatan/1234567890");
                
                
    }
}
