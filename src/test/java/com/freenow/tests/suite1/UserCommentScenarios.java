package com.freenow.tests.suite1;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.freenow.helpers.CommonHelpers.UrlHelpers;
import com.freenow.models.Comment;
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
    private List<Comment> comments;

    @Parameters("user")
    @Test(description = "Find the given user from query parameters using the username and validate")
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
    @Test(description = "Find the given user by fetching all the users and validate")
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

    @Test(description = "Find all posts of an user and validate",dependsOnMethods = "searchForUser")
    public void validateUserPosts()
    {
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("userId",Integer.toString(Samantha.getId()));
        Response response = api.get(urlUtils
                .generateURL(UrlHelpers.EndpointURL.POSTS,queryParams),api.getDefaultHeaders());
        Assert.assertEquals(response.statusCode(),200);
        posts = postUtils.extractPosts(response.getBody().asString());
        posts.stream()
                .forEach(post-> Assert.assertEquals(post.getUserId(),Samantha.getId()));
    }

    @Test(description = "Find all comments for each post of an user and validate"
            ,dependsOnMethods = "validateUserPosts")
    public void validatePostComments()
    {
        Map<String,String> queryParams = new HashMap<>();
        posts.stream()
                .forEach(post->{
                    queryParams.put("postId",Integer.toString(post.getId()));
                    Response response = api.get(urlUtils.generateURL(UrlHelpers
                            .EndpointURL.COMMENTS,queryParams),api.getDefaultHeaders());
                    Assert.assertEquals(response.statusCode(),200);
                    comments = commentUtil.extractComments(response.getBody().asString());
                    comments.stream()
                            .forEach(comment->
                            {
                                assertionUtil.validate(comment.getEmail());
                                Assert.assertEquals(post.getId(),comment.getPostId());
                            });
                });
    }



}
