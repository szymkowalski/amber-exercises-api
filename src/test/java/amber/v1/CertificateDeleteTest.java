package amber.v1;

import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

@DisplayName("Certificate Delete Test")
public class CertificateDeleteTest {

    @Test
    public void testCertificateDelete() {

        Integer id = prepareCertificate();
        
        delete("http://localhost:9999/api/rest/v1/certificate/"+id)
        .then()
            .statusCode(200);
        get("http://localhost:9999/api/rest/v1/certificate/"+id)
            .then()
                .statusCode(404);
                
    }
    private Integer prepareCertificate(){
        String postBody = "{\"name\": \"JOHN FREEMAN\","+
                "\"organization\": \"GOOGLE\",\"period\": \"TWO YEARS\",\"trade\": \"IT\"}";
		Integer id = with()
            .contentType(ContentType.JSON)
            .body(postBody)
        .when()
            .post("http://localhost:9999/api/rest/v1/certificate").andReturn().jsonPath().get("id");
        
            return id;
    }
    
}
