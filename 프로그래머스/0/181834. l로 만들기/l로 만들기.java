class Solution {
    public String solution(String myString) {
        String answer = "";
        return myString.replaceAll("[^l-z]", "l");
    }
}