package amber.v1;

import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isA;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

@DisplayName("Certificate Add Test")
class CertificateAddTest {
    @Test
    public void testCertificatePost() {
        String postBody = "{\"name\": \"JOHN FREEMAN\","+
                "\"organization\": \"GOOGLE\",\"period\": \"TWO YEARS\",\"trade\": \"IT\"}";
		with()
            .contentType(ContentType.JSON)
            .body(postBody)
        .when()
            .post("http://localhost:9999/api/rest/v1/certificate")
        .then()
            .statusCode(201).assertThat()
	        .body("id", isA(Integer.class)) 
            .body("name", equalTo("JOHN FREEMAN"))
            .body("organization", equalTo("GOOGLE"))
            .body("period", equalTo("TWO YEARS"))
            .body("trade", equalTo("IT"));
    }
}