import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        // Add new score
        minHeap.offer(val);

        // Keep only k largest elements in the heap
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // The root of the heap is the kth largest
        return minHeap.peek();
    }
}
