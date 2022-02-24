package com.bridgelabz.restassuredtest;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class TwitterAPITesting {

    @Test
       public void postTweet() {

        Response response = RestAssured.given().auth()
                .oauth("IpFgDwHYka49ani92n1Jqpxva",
                        "eupFcDQV0PINrpjBA6rdIhglpgxngbH1omBjwDQtmmnPFXIXLq",
                        "1496182275834191874-sURMaLUhRIeEZDdSOTPvBziQDUQfgy",
                        "T2t62J4Pb0KsxpvpuNvwIDKhsFZYB8ChgiOWHRsmZDgKV")
                .post("https://api.twitter.com/1.1/statuses/update.json?status=Good Evening");

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
                .oauth("IpFgDwHYka49ani92n1Jqpxva",
                        "eupFcDQV0PINrpjBA6rdIhglpgxngbH1omBjwDQtmmnPFXIXLq",
                        "1496182275834191874-sURMaLUhRIeEZDdSOTPvBziQDUQfgy",
                        "T2t62J4Pb0KsxpvpuNvwIDKhsFZYB8ChgiOWHRsmZDgKV")
                .post("https://api.twitter.com/1.1/statuses/retweet/1496835727610372098.json");

        System.out.println("Response code: " + response.getStatusCode());
        System.out.println("Response jason Body: " + response.jsonPath().prettyPrint());
    }

    @Test
    public void delete() {

        Response response = RestAssured.given().auth().
                oauth("IpFgDwHYka49ani92n1Jqpxva",
                        "eupFcDQV0PINrpjBA6rdIhglpgxngbH1omBjwDQtmmnPFXIXLq",
                        "1496182275834191874-sURMaLUhRIeEZDdSOTPvBziQDUQfgy",
                        "T2t62J4Pb0KsxpvpuNvwIDKhsFZYB8ChgiOWHRsmZDgKV")
                .delete("https://api.twitter.com/2/tweets/1496844786791174151");

        System.out.println("Response code: " + response.getStatusCode());
        response.prettyPrint();
    }
}
