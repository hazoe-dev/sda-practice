package dev.hazoe.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Post {
    String postId;
    int likeCount;
    long timestamp;

    public Post(String postId, int likeCount, long timestamp) {
        this.postId = postId;
        this.likeCount = likeCount;
        this.timestamp = timestamp;
    }
}

public class TrendingRanking {

    public static List<Post> getTopK(List<Post> posts, int k) {


        PriorityQueue<Post> minHeap = new PriorityQueue<>(
                (a, b) -> {
                    if (a.likeCount != b.likeCount) {
                        return Integer.compare(a.likeCount, b.likeCount);
                    }
                    if (a.timestamp != b.timestamp) {
                        return Long.compare(a.timestamp, b.timestamp);
                    }
                    return b.postId.compareTo(a.postId);
                }
        );

        for (Post post : posts) {
            if (minHeap.size() < k) {
                minHeap.add(post);
            } else {
                Post worst = minHeap.peek();
                if (compare(post, worst) > 0) {
                    minHeap.poll();
                    minHeap.offer(post);
                }
            }
        }

        List<Post> result = new ArrayList<>(minHeap);
        result.sort(
                (a, b) -> {
                    if (a.likeCount != b.likeCount) {
                        return Integer.compare(b.likeCount, a.likeCount);
                    }
                    if (a.timestamp != b.timestamp) {
                        return Long.compare(b.timestamp, a.timestamp);
                    }
                    return a.postId.compareTo(b.postId);
                }
        );
        return result;
    }

    private static int compare(Post a, Post b) {
        if (a.likeCount != b.likeCount) {
            return Integer.compare(a.likeCount, b.likeCount);
        }
        if (a.timestamp != b.timestamp) {
            return Long.compare(a.timestamp, b.timestamp);
        }
        return b.postId.compareTo(a.postId);
    }
}
