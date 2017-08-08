package com.guppy;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class EatleaveApplicationTests {

    @LocalServerPort
    private int port;

	@Before
	public void setup() {
		RestAssured.port = port;
	}

	@Test
	public void 기본path로_접근하면_index_html_호출된다 () throws Exception {
		given()
				.when()
				.get("/")
				.then()
				.statusCode(200)
				.contentType("text/html");
	}


	@Test
    public void 페이스북_로그인_테스트 () {
	    given()
                .when()
                    .redirects().follow(false)
                    .get("/login/facebook")
                .then()
                    .statusCode(302)
                    .log().all();
        //.header("Location", "http://localhost:3000/facebook/complete");

    }


}
