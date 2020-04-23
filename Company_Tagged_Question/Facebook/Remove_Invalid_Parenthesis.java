import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RemoveInvalidParentheses {
    int min = Integer.MAX_VALUE;
    List<String> answer = new ArrayList<>();

    public List<String> removeInvalidParentheses(String s) {

        System.out.println("Hello");
        // dfs_1(s, 0, 0);
        // dfs_2(s, 0, 0, 0, 0);
        // dfs_3(s, 0, 0, new StringBuilder());
        dfs_4(s, 0, 0, new StringBuilder(), 0, 0);
        Set<String> set = new HashSet<>(answer);
        List<String> list = new ArrayList<>(set);
        System.out.println(list);
        return null;
    }

    public void dfs_4(String str, int idx, int rem, StringBuilder cur_str, int left, int right) {

        if (idx == str.length()) {
            if (valid(cur_str.toString())) {
                if (rem == min) {
                    answer.add(cur_str.toString());
                } else if (rem < min) {
                    answer.clear();
                    answer.add(cur_str.toString());
                    min = rem;
                }
            }
        } else {
            char ch = str.charAt(idx);
            if (ch == '(' || ch == ')') {

                if (ch == '(') {
                    dfs_4(str, idx + 1, rem + 1, cur_str, left, right);
                    cur_str.append(ch);
                    dfs_4(str, idx + 1, rem, cur_str, left + 1, right);
                    cur_str.deleteCharAt(cur_str.length() - 1);
                } else {
                    dfs_4(str, idx + 1, rem + 1, cur_str, left, right);
                    if (left > right) {
                        cur_str.append(ch);
                        dfs_4(str, idx + 1, rem, cur_str, left, right + 1);
                        cur_str.deleteCharAt(cur_str.length() - 1);
                    }
                }
            } else {
                cur_str.append(ch);
                dfs_4(str, idx + 1, rem, cur_str, left, right);
                cur_str.deleteCharAt(cur_str.length() - 1);
            }

        }

    }

    public void dfs_3(String str, int idx, int rem, StringBuilder cur_str) {

        if (idx == str.length()) {
            if (valid(cur_str.toString())) {
                if (rem == min) {
                    answer.add(cur_str.toString());
                } else if (rem < min) {
                    answer.clear();
                    answer.add(cur_str.toString());
                    min = rem;
                }
            }
        } else {
            char ch = str.charAt(idx);
            if (ch == '(' || ch == ')') {
                dfs_3(str, idx + 1, rem + 1, cur_str);
                cur_str.append(ch);
                dfs_3(str, idx + 1, rem, cur_str);
                cur_str.deleteCharAt(cur_str.length() - 1);
            } else {
                cur_str.append(ch);
                dfs_3(str, idx + 1, rem, cur_str);
                cur_str.deleteCharAt(cur_str.length() - 1);
            }

        }

    }

    public void dfs_1(String str, int idx, int rem) {

        if (idx == str.length()) {
            if (valid(str)) {
                if (rem == min) {
                    answer.add(str);
                } else if (rem < min) {
                    answer.clear();
                    answer.add(str);
                    min = rem;
                }
            }
        } else {

            char ch = str.charAt(idx);
            if (ch == '(' || ch == ')') {

                String remStr = str.substring(0, idx) + str.substring(idx + 1, str.length());

                dfs_1(remStr, idx, rem + 1);
                dfs_1(str, idx + 1, rem);
            } else {
                dfs_1(str, idx + 1, rem);
            }

        }

    }

    private boolean valid(String str) {

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                count += 1;
            else if (str.charAt(i) == ')')
                count -= 1;
            if (count < 0)
                return false;
        }
        if (count == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses obj = new RemoveInvalidParentheses();
        obj.removeInvalidParentheses("(a)())()");
    }
}