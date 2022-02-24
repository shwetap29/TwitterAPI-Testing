package com.bridgelabz.restassuredtest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.post;

public class SampleTwitterTest {

    @Test
    public void postTweet() {
        Response response = RestAssured.given().auth()
                .oauth("TTQQO4y0DJGZLBU2LcU1VJECQ",
                        "qkf8Rj3kggsjkvc2mF5sBLvE8k93ZL9Q74nPzKujFwJ8QAofoV",
                        "4003503614-NqJnAeZ2s6oHIPEWsNJnKDoKB4TtIPD2oOFUSuW",
                        "CsW3W4jEd4OarUqbqaJSSVzy808HEAB5uyGyZDA9QrLZR")
                .post("https://api.twitter.com/1.1/statuses/update.json?status=Goodmorning twitter Family");

            System.out.println("status code: " + response.getStatusCode());
            System.out.println("time taken: " + response.getTime());
            response.prettyPrint();

            JsonPath jsonPath = response.jsonPath();

            String id_str = jsonPath.getString("id_str");
            System.out.println("***************");
            System.out.println(id_str);


    }

    @Test
    public void retweetTest() {

        Response response = RestAssured.given()
                .auth()
                .oauth("NCfc3ZvrXvqqU9jyUnEe3ixGx",
                        "Tlg3OmdqMLHmL9Q3NtUQND2biDNVmY8mEYdy1NlqJbgdxwI7Jf",
                        "1496182275834191874-ysDo7sc9IGDbwShSycdo8bZ7Xsy31d",
                        "V0uXcl6UzExTveFhbbNVMIhMzrJeVwJ3Cei2y3TTGTjzf")
                .post("https://api.twitter.com/1.1/statuses/retweet/1496682445416333315.json");

                System.out.println("Response code: " + response.getStatusCode());
                System.out.println("Response jason Body: " + response.jsonPath().prettyPrint());

    }

    @Test
    public void delete() {

        Response response = RestAssured.given().auth().
                oauth("TTQQO4y0DJGZLBU2LcU1VJECQ",
                        "qkf8Rj3kggsjkvc2mF5sBLvE8k93ZL9Q74nPzKujFwJ8QAofoV",
                        "4003503614-NqJnAeZ2s6oHIPEWsNJnKDoKB4TtIPD2oOFUSuW",
                        "CsW3W4jEd4OarUqbqaJSSVzy808HEAB5uyGyZDA9QrLZR")
                .delete("https://api.twitter.com/2/tweets/1496688755977355265");

                System.out.println("Response code: " + response.getStatusCode());
                response.prettyPrint();
    }

}