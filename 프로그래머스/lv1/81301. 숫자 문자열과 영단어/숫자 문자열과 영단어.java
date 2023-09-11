import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String ans = "";
        char[] ch = s.toCharArray();
        int i = 0;
        //48 58
        while (i < ch.length) {
            if (ch[i] >= 48 && ch[i] <= 58) {
                ans += ch[i];
                i++;
                continue;
            }
            switch (ch[i]) {
                case 'o':
                    i += 3;
                    ans += '1';
                    break;
                case 't':
                    if (ch[i + 1] == 'w') {
                        i += 3;
                        ans += '2';
                        break;
                    } else {
                        i += 5;
                        ans += '3';
                        break;
                    }
                case 'f':
                    if (ch[i + 1] == 'o') {
                        ans += '4';
                    } else {
                        ans += '5';
                    }
                    i += 4;
                    break;
                case 's':
                    if (ch[i + 1] == 'i') {
                        i += 3;
                        ans += '6';
                        break;
                    } else {
                        i += 5;
                        ans += '7';
                        break;
                    }
                case 'e':
                    i += 5;
                    ans += '8';
                    break;
                case 'n':
                    i += 4;
                    ans += '9';
                    break;
                case 'z':
                    i += 4;
                    ans += '0';
                    break;
            }
        }
        answer = Integer.parseInt(ans);
        return answer;
    }
}