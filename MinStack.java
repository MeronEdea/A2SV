class MinStack {
  
    private Deque<Integer> arrDeq1 = new ArrayDeque<>();
    private Deque<Integer> arrDeq2 = new ArrayDeque<>();

    /** initialize your data structure here. */
    public MinStack() {
        arrDeq2.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        arrDeq1.push(x);
        arrDeq2.push(Math.min(x, arrDeq2.peek()));
    }

    public void pop() {
        arrDeq1.pop();
        arrDeq2.pop();
    }

    public int top() {
        return arrDeq1.peek();
    }

    public int getMin() {
        return arrDeq2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
