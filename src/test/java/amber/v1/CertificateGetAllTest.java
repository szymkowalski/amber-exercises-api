package amber.v1;

import static io.restassured.RestAssured.get;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Certificate Get All Test")
class CertificateGetAllTest {
    @Test
    public void testCertificatePathParams() {
        get("http://localhost:9999/api/rest/v1/certificates/all")
        .then()
            .statusCode(200);
    }
}