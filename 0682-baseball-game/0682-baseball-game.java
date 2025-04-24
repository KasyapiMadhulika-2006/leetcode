class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String op:operations){
            switch(op){
                case "C":stack.pop();
                    break;
                case "D":stack.push(2*stack.peek());
                    break;
                case "+":int top = stack.pop();
                    int newTop = top+stack.peek();
                    stack.push(top);
                    stack.push(newTop);
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }
        int total = 0;
        for(int score :stack){
            total+=score;
        }
    
    return total;
}
}