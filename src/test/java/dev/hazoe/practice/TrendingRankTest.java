package dev.hazoe.practice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;

class TrendingRankingTest {


    @Test
    void testBasicRanking() {
        List<Post> posts = List.of(
                new Post("A", 100, 1000),
                new Post("B", 100, 900),
                new Post("C", 90, 2000),
                new Post("D", 100, 1000)
        );

        List<Post> result = TrendingRanking.getTopK(posts, 3);

        assertEquals(3, result.size());

        assertEquals("A", result.get(0).postId);
        assertEquals("D", result.get(1).postId);
        assertEquals("B", result.get(2).postId);
    }

    @Test
    void testTieLikeAndTimestamp_postIdLexicographically() {
        List<Post> posts = List.of(
                new Post("post2", 100, 1000),
                new Post("post1", 100, 1000),
                new Post("post3", 100, 1000)
        );

        List<Post> result = TrendingRanking.getTopK(posts, 3);

        assertEquals("post1", result.get(0).postId);
        assertEquals("post2", result.get(1).postId);
        assertEquals("post3", result.get(2).postId);
    }

    @Test
    void testKEqualsOne() {
        List<Post> posts = List.of(
                new Post("A", 10, 100),
                new Post("B", 20, 200),
                new Post("C", 15, 300)
        );

        List<Post> result = TrendingRanking.getTopK(posts, 1);

        assertEquals(1, result.size());
        assertEquals("B", result.get(0).postId);
    }

    @Test
    void testKEqualsN() {
        List<Post> posts = List.of(
                new Post("A", 10, 100),
                new Post("B", 20, 200),
                new Post("C", 15, 300)
        );

        List<Post> result = TrendingRanking.getTopK(posts, 3);

        assertEquals(3, result.size());

        assertEquals("B", result.get(0).postId);
        assertEquals("C", result.get(1).postId);
        assertEquals("A", result.get(2).postId);
    }

    @Test
    void testAllSameLikeDifferentTimestamp() {
        List<Post> posts = List.of(
                new Post("A", 100, 1000),
                new Post("B", 100, 3000),
                new Post("C", 100, 2000)
        );

        List<Post> result = TrendingRanking.getTopK(posts, 3);

        assertEquals("B", result.get(0).postId);
        assertEquals("C", result.get(1).postId);
        assertEquals("A", result.get(2).postId);
    }

    @Test
    void testLargeInputTopKLogic() {
        List<Post> posts = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            posts.add(new Post("post" + i, i, i));
        }

        List<Post> result = TrendingRanking.getTopK(posts, 5);

        assertEquals(5, result.size());

        assertEquals("post100", result.get(0).postId);
        assertEquals("post99", result.get(1).postId);
        assertEquals("post98", result.get(2).postId);
        assertEquals("post97", result.get(3).postId);
        assertEquals("post96", result.get(4).postId);
    }
}