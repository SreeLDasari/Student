package com.testannotation.studentservice;

import com.testannotation.studentservice.StudentServiceApplication;
import com.testannotation.studentservice.model.Student;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.BDDAssertions.then;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StudentServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerIntegrationTest {
    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testStudentRetrieval() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/student-service/student?rollNo=Y4CS99"),
                HttpMethod.GET, entity, String.class);
        
        String expected = "{\r\n"
		+ "  \"rollNo\": \"Y4CS99\",\r\n"
		+ "  \"name\": \"Manv\",\r\n"
		+ "  \"branch\": \"EEE\",\r\n"
		+ "  \"college\": \"NU\"\r\n"
		+ "}";
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    @Test
    public void testStudentCreation() {
        //Given
        Student student = new Student("Y4CS66","Avyan","ECE","AU");

        //When
        HttpEntity<Student> entity = new HttpEntity<Student>(student, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/student-service/student"),
                HttpMethod.POST, entity, String.class);

        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);

        //Then
        then(actual)
                .as("Verify location header")
                .contains("student-service/student?rollNo=");

    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }

}
