package dev.hazoe.practice;

import java.util.*;

class Post {
    final String postId;
    final int likeCount;
    final long timestamp;

    public Post(String postId, int likeCount, long timestamp) {
        this.postId = postId;
        this.likeCount = likeCount;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return postId + " (" + likeCount + ", " + timestamp + ")";
    }
}

public class TrendingRanking {

    // Worst-first comparator (minHeap)
    private static final Comparator<Post> WORST_FIRST =
            Comparator.comparingInt((Post p) -> p.likeCount)
                    .thenComparingLong(p -> p.timestamp)
                    .thenComparing((a, b) -> b.postId.compareTo(a.postId));

    // Best-first comparator (final result)
    private static final Comparator<Post> BEST_FIRST =
            Comparator.comparingInt((Post p) -> p.likeCount).reversed()
                    .thenComparing(Comparator.comparingLong((Post p) -> p.timestamp).reversed())
                    .thenComparing(p -> p.postId);

    public static List<Post> getTopK(List<Post> posts, int k) {

        if (posts == null || k <= 0) {
            return Collections.emptyList();
        }

        PriorityQueue<Post> minHeap = new PriorityQueue<>(WORST_FIRST);

        for (Post post : posts) {
            if (minHeap.size() < k) {
                minHeap.offer(post);
            } else if (WORST_FIRST.compare(post, minHeap.peek()) > 0) {
                minHeap.poll();
                minHeap.offer(post);
            }
        }

        List<Post> result = new ArrayList<>(minHeap);
        result.sort(BEST_FIRST);
        return result;
    }
}