class MedianFinder {

    PriorityQueue<Integer> upper;
    PriorityQueue<Integer> lower;

    public MedianFinder() {
        upper = new PriorityQueue<>();
        lower = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(upper.isEmpty() || num > upper.peek()){
            upper.add(num);
            if(upper.size() - lower.size() > 1){
                lower.add(upper.poll());
            }
        }else{
            lower.add(num);
            if(lower.size() - upper.size() > 1){
                upper.add(lower.poll());
            }
        }
    }
    
    public double findMedian() {
        if(upper.size() == lower.size()){
            return (upper.peek() + lower.peek()) / 2.0;
        }else if(upper.size() > lower.size()){
            return upper.peek();
        }else{
            return lower.peek();
        }
    }
}
