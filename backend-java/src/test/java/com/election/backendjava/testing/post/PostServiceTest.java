//package com.election.backendjava.testing.post;
//
//import com.election.backendjava.entities.Post;
//import com.election.backendjava.entities.User;
//import com.election.backendjava.models.post.services.PostServices;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import com.election.backendjava.models.post.repositories.PostRepository;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
///**
// * Test class for the PostServices class.
// * It tests the business logic for post-related operations.
// */
//@ExtendWith(MockitoExtension.class)
//public class PostServiceTest {
//    /**
//     * The repository used to interact with the database for post operations.
//     */
//    @Mock
//    private PostRepository postRepository;
//
//    /**
//     * The service that provides post-related business logic.
//     */
//    @InjectMocks
//    private PostServices postServices;
//
//    private User user;
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
//    public void testGetAllPosts() {
//        // Arrange
//        Post post1 = new Post(user, "title1", "body1");
//        Post post2 = new Post(user, "title2", "body2");
//        List<Post> mockPosts = Arrays.asList(post1, post2);
//
//        when(postRepository.findAll()).thenReturn(mockPosts);
//        // Act
//        List<Post> result = postServices.getAllPosts();
//
//        // Assert
//        assertEquals(2, result.size());
//        assertEquals("title1", result.get(0).getTitle());
//        assertEquals("title2", result.get(1).getTitle());
//    }
//
//    /**
//     * Test the getPostById method.
//     */
//    @Test
//    public void testGetPostById() {
//        // Arrange
//        Post expectedPost = new Post(user, "title1", "body1");
//        when(postRepository.findById(1)).thenReturn(java.util.Optional.of(expectedPost));
//
//        // Act
//        Post actualPost = postServices.getPostById(1);
//
//        // Assert
//        assertNotNull(actualPost);
//        assertEquals(expectedPost.getTitle(), actualPost.getTitle());
//        assertEquals(expectedPost.getBody(), actualPost.getBody());
//        assertEquals(expectedPost.getUserId(), actualPost.getUserId());
//        verify(postRepository).findById(1);
//
//        System.out.println("Expected Post Title: " + expectedPost.getTitle());
//        System.out.println("Actual Post Title: " + actualPost.getTitle());
//        System.out.println("Expected Post Body: " + expectedPost.getBody());
//        System.out.println("Actual Post Body: " + actualPost.getBody());
//    }
//
//    /**
//     * Test the getPostById method when the post is not found.
//     */
//    @Test
//    public void testGetPostById_NotFound() {
//        // Arrange
//        when(postRepository.findById(1)).thenReturn(java.util.Optional.empty());
//
//        // Act
//        Post actualPost = postServices.getPostById(1);
//
//        // Assert
//        assertNull(actualPost);
//        verify(postRepository).findById(1);
//
//        System.out.println("Post with ID 1 not found: " + true);
//    }
//
//    /**
//     * Test the createPost method.
//     */
//    @Test
//    public void testCreatePost() {
//        // Arrange
//        Post postToCreate = new Post(user, "title2", "body2");
//        when(postRepository.save(any(Post.class))).thenReturn(postToCreate);
//
//        // Act
//        Post result = postServices.createPost(postToCreate);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals("title2", result.getTitle());
//        assertEquals("body2", result.getBody());
//        assertEquals(user, result.getUserId());
//        verify(postRepository).save(postToCreate);
//
//        System.out.println("Result Title: " + result.getTitle());
//        System.out.println("Result Body: " + result.getBody());
//        System.out.println("Result User: " + result.getUserId());
//
//    }
//
//}
//
