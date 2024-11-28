//package com.election.backendjava.testing.post;
//
//import com.election.backendjava.entities.Post;
//import com.election.backendjava.entities.User;
//import com.election.backendjava.models.post.controllers.PostController;
//import com.election.backendjava.models.post.services.PostServices;
//import com.election.backendjava.models.user.config.JwtAuthenticationFilter;
//import com.election.backendjava.models.user.services.JwtService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.hamcrest.Matchers.is;
//import static org.hamcrest.Matchers.hasSize;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * Test class for the PostController class.
// * It tests the controller for post-related operations.
// */
//@WebMvcTest(PostController.class)
//public class PostControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private PostServices postServices;
//
//    @MockBean
//    private User user;
//
//    @MockBean
//    private JwtService jwtService;
//
//    @BeforeEach
//    public void setUp() {
//        user = new User();
//        user.setId(1);
//    }
//
//    /**
//     * Test the getAllPosts method.
//     */
//    @Test
//    public void testGetAllPosts() throws Exception{
//        // Arrange
//        User user = new User();
//        Post post1 = new Post(user, "title1", "body1");
//        Post post2 = new Post(user, "title2", "body2");
//        List<Post> mockPosts = Arrays.asList(post1, post2);
//
//        when(postServices.getAllPosts()).thenReturn(mockPosts);
//        // Act & Assert
//        mockMvc.perform(get("/api/posts"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].title", is("title1")))
//                .andExpect(jsonPath("$[1].title", is("title2")));
//    }
//
//    /**
//     * Test the getPostById method.
//     */
//    @Test
//    public void testGetPostById() throws Exception {
//        // Arrange
//        Post expectedPost = new Post(user, "JAAAtitle1", "body1");
//        when(postServices.getPostById(1)).thenReturn(expectedPost);
//
//        // Act & Assert
//        mockMvc.perform(get("/api/posts/1"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title", is("JAAAtitle1")))
//                .andExpect(jsonPath("$.body", is("body1")));
//
//        System.out.println("Post retrieved successfully: " + expectedPost.getTitle());
//    }
//
//    @Test
//    public void testGetPostById_PostNotFound() throws Exception {
//        // Arrange
//        int postId = 1;
//        when(postServices.getPostById(postId)).thenReturn(null);
//        System.out.println("PostId given: " + postId);
//        // Act & Assert
//        MvcResult mvcResult = mockMvc.perform(get("/api/posts/{id}", postId))
//                .andExpect(status().isNotFound())
//                .andReturn();
//
//        System.out.println(mvcResult.getResponse().getStatus());
//        String responseContent = mvcResult.getResponse().getContentAsString();
//        System.out.println("Response Content: " + responseContent);
//    }
//
//    /**
//     * Test the CreatePost method.
//     */
//    @Test
//    public void testCreatePost() throws Exception {
//        // Arrange
//        Post postToCreate = new Post(user, "New title1", "New body1");
//        String postJson = "{\"title\": \"New title1\", \"body\": \"New body1\", \"userId\": { \"id\": 1}}";
//
//        when(postServices.createPost(any(Post.class))).thenReturn(postToCreate);
//
//        System.out.println("MockMvc is initialized: " + (mockMvc != null));
//
//        // Act & Assert
//        MvcResult mvcResult = mockMvc.perform(post("/api/posts")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(postJson))
//                .andExpect(status().isCreated())
//                .andReturn();
//
//        String responseContent = mvcResult.getResponse().getContentAsString();
//        System.out.println("Response Content: " + responseContent);
//
//        verify(postServices).createPost(any(Post.class));
//    }
//
//}
