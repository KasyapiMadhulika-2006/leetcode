class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();
        Map<Character, Integer> lastOccurence = new HashMap<>();
        for(int i=0;i<s.length();i++){
            lastOccurence.put(s.charAt(i),i);
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(seen.contains(c)){
                continue;
            }
            while(!stack.isEmpty()&&c<stack.peek()&&lastOccurence.get(stack.peek())>i){
                seen.remove(stack.pop());
            }
            stack.push(c);
            seen.add(c);
        }
        StringBuilder result = new StringBuilder();
        for(char ch:stack){
            result.append(ch);
        }
        return result.toString();
    }
}