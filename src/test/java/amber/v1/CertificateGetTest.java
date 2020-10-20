package amber.v1;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Certificate Get Test")
class CertificateGetTest {
    // @Before
	// public void setup() {
	//     RestAssured.baseURI = "https://api.github.com";
	// }
    @Test
    public void testCertificate() {
        given()
            .param("id",1)
        .when()
		    .get("http://localhost:9999/api/rest/v1/certificate")
        .then()
            .statusCode(200).assertThat()
	        .body("id", isA(Integer.class))
            .body("name", equalTo("TEST ANALYST"))
            .body("organization", equalTo("ISTQB"))
            .body("period", equalTo("BEZTERMINOWO"))
            .body("trade", equalTo("IT"));
    }
    @Test
    public void testCertificatePathParams() {
        get("http://localhost:9999/api/rest/v1/certificate/1")
        .then()
            .statusCode(200).assertThat()
	        .body("id", isA(Integer.class))
            .body("name", equalTo("TEST ANALYST"))
            .body("organization", equalTo("ISTQB"))
            .body("period", equalTo("BEZTERMINOWO"))
            .body("trade", equalTo("IT"));
    }
}