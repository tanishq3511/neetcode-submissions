class MedianFinder {

    PriorityQueue<Integer> right; // minHeap, larger vals
    PriorityQueue<Integer> left; // maxHeap, smaller vals

    public MedianFinder() {
        right = new PriorityQueue<>();
        left = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        left.add(num);
        if(left.size() - right.size() > 1 || !right.isEmpty() && left.peek() > right.peek()){
            right.add(left.poll());
        }
        if(right.size() - left.size() > 1){
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size()){
            return (double) (left.peek()+right.peek()) / 2;
        }else if(left.size() > right.size()){
            return (double) left.peek();
        }

        return (double) right.peek();

    }
}
