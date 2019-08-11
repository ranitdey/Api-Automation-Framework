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
        assert jsonUtil.jsonSchemaValidator(response,"userSchema");
        User testUser = usersUtil.extractUsers(response.getBody().asString()).get(0);
        Assert.assertEquals(testUser.getUsername(),user);
        Assert.assertNotEquals(testUser.getUsername().length(),0);
        Assert.assertNotEquals(testUser.getEmail().length(),0);
        assertionUtil.validate(testUser.getEmail());
    }

    @Parameters("user")
    @Test(description = "Find the given user by fetching all the users and validate")
    public void searchForUser(String testUser)
    {
        Response response = api.get(urlUtils
                .generateURL(UrlHelpers.EndpointURL.USERS),api.getDefaultHeaders());
        Assert.assertEquals(response.statusCode(),200);
        assert jsonUtil.jsonSchemaValidator(response,"userSchema");
        users = usersUtil.extractUsers(response.getBody().asString());
        Samantha = users.stream().filter(user -> testUser.equals(user.getUsername()))
                                        .distinct()
                                        .findAny()
                                        .get();
        Assert.assertEquals(Samantha.getUsername(),testUser);
        assertionUtil.validate(Samantha.getEmail());
        Assert.assertNotEquals(Samantha.getUsername().length(),0);
        Assert.assertNotEquals(Samantha.getEmail().length(),0);
    }

    @Test(description = "Find all posts of an user and validate",dependsOnMethods = "searchForUser")
    public void validateUserPosts()
    {
        Map<String,String> queryParams = new HashMap<>();
        queryParams.put("userId",Integer.toString(Samantha.getId()));
        Response response = api.get(urlUtils
                .generateURL(UrlHelpers.EndpointURL.POSTS,queryParams),api.getDefaultHeaders());
        Assert.assertEquals(response.statusCode(),200);
        assert jsonUtil.jsonSchemaValidator(response,"postSchema");
        posts = postUtils.extractPosts(response.getBody().asString());
        posts.forEach(post->{
            Assert.assertEquals(post.getUserId(),Samantha.getId());
            Assert.assertNotEquals(post.getBody().length(),0);
            Assert.assertNotEquals(post.getTitle().length(),0);
        });
    }

    @Test(description = "Find all comments for each post of an user and validate the email format"
            ,dependsOnMethods = "validateUserPosts")
    public void validatePostComments()
    {
        Map<String,String> queryParams = new HashMap<>();
        posts
            .forEach(post->{
                queryParams.put("postId",Integer.toString(post.getId()));
                Response response = api.get(urlUtils.generateURL(UrlHelpers
                        .EndpointURL.COMMENTS,queryParams),api.getDefaultHeaders());
                Assert.assertEquals(response.statusCode(),200);
                assert jsonUtil.jsonSchemaValidator(response,"commentSchema");
                comments = commentUtil.extractComments(response.getBody().asString());
                comments
                        .forEach(comment->
                        {
                            assertionUtil.validate(comment.getEmail());
                            Assert.assertEquals(post.getId(),comment.getPostId());
                            Assert.assertNotEquals(comment.getBody(),0);
                            Assert.assertNotEquals(comment.getName(),0);
                        });
            });
    }

    @Test(description = "For the test user find each of his posts using query parameters in URL"
            ,dependsOnMethods = "validateUserPosts")
    public void validatePostsByQueryParam()
    {
        Map<String,String> queryParams = new HashMap<>();
        posts.forEach(post->{
            queryParams.put("userId",Integer.toString(Samantha.getId()));
            queryParams.put("id",Integer.toString(post.getId()));
            Response response = api.get(urlUtils.generateURL(UrlHelpers
                    .EndpointURL.POSTS,queryParams),api.getDefaultHeaders());
            Assert.assertEquals(response.statusCode(),200);
            Post testPost = postUtils.extractPosts(response.getBody().asString()).get(0);
            Assert.assertEquals(testPost.getUserId(),Samantha.getId());
            Assert.assertEquals(testPost.getId(),post.getId());
        });
    }

    @Test(description = "Find each comments in test user's posts using query parameters in URL"
            ,dependsOnMethods = "validatePostComments")
    public void validateCommentsByQueryParam()
    {
        Map<String,String> queryParams = new HashMap<>();
        comments.forEach(comment->{
            queryParams.put("postId",Integer.toString(comment.getPostId()));
            queryParams.put("id",Integer.toString(comment.getId()));
            Response response = api.get(urlUtils.generateURL(UrlHelpers
                    .EndpointURL.COMMENTS,queryParams),api.getDefaultHeaders());
            Assert.assertEquals(response.statusCode(),200);
            Comment testComment = commentUtil.extractComments(response.getBody().asString()).get(0);
            Assert.assertEquals(testComment.getPostId(),comment.getPostId());
            Assert.assertEquals(testComment.getId(),comment.getId());
        });
    }


}
