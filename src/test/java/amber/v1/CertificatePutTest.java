package amber.v1;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

@DisplayName("Certificate Put Test")
public class CertificatePutTest {
    @Test
    public void testCertificatePut() {
        String postBody = "{\"name\": \"TEST MAN\"}";
		with()
            .contentType(ContentType.JSON)
            .body(postBody)
        .when()
            .put("http://localhost:9999/api/rest/v1/certificate/2")
        .then()
            .statusCode(200).assertThat()
	        .body("id", isA(Integer.class)) 
            .body("name", equalTo("TEST MAN"))
            .body("organization", equalTo(null))
            .body("period", equalTo(null))
            .body("trade", equalTo(null));
    }
    
}
