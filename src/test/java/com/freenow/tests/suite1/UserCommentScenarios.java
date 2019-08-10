package com.freenow.tests.suite1;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.freenow.helpers.CommonHelpers.UrlHelpers;
import com.freenow.models.Post;
import com.freenow.models.User;
import com.freenow.tests.BaseTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.restassured.response.Response;


public class UserCommentScenarios extends BaseTest {

    private User Samantha;
    private List<User> users;
    private List<Post> posts;

    @Parameters("user")
    @Test(description = "Find the given user from query parameters using the username")
    public void validateUserFromQuery(String user)
    {
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("username",user);
        Response response = api.get(urlUtils
                .generateURL(UrlHelpers.EndpointURL.USERS,queryParams),api.getDefaultHeaders());
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(usersUtil
                .extractUsers(response.getBody().asString()).get(0).getUsername(),user);
    }

    @Parameters("user")
    @Test(description = "Find the given user by fetching all the users")
    public void searchForUser(String testUser)
    {
        Response response = api.get(urlUtils
                .generateURL(UrlHelpers.EndpointURL.USERS),api.getDefaultHeaders());
        Assert.assertEquals(response.statusCode(),200);
        users = usersUtil.extractUsers(response.getBody().asString());
        Samantha = users.stream().filter(user -> testUser.equals(user.getUsername()))
                                        .distinct()
                                        .findAny()
                                        .get();
        Assert.assertEquals(Samantha.getUsername(),testUser);
        assertionUtil.validate(Samantha.getEmail());
    }




}
