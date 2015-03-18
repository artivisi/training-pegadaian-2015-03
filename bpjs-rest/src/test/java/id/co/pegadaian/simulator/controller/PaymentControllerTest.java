package id.co.pegadaian.simulator.controller;

import com.jayway.restassured.RestAssured;
import static com.jayway.restassured.RestAssured.given;
import com.jayway.restassured.http.ContentType;
import id.co.pegadaian.simulator.App;
import id.co.pegadaian.simulator.dto.PaymentRequest;
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
public class PaymentControllerTest {
    
    
    @Value("${local.server.port}")
    private Integer port;
    
    
    @Before
    public void persiapan(){
        RestAssured.port = port;
    }
    
    @Test
    public void testPaymentKesehatan(){
        PaymentRequest payReq = new PaymentRequest();
        payReq.setIdTagihan("t001");
        payReq.setUserLoket("usertestrestassured");
        payReq.setKodeLoket("lokettestrestassured");
        
        given()
                .contentType(ContentType.JSON)
                .body(payReq)
        .expect()
                .statusCode(201)
        .when()
                .post("/payment/kesehatan");
    }
}
