package com.wkcto;

import javax.swing.tree.TreeNode;
import java.util.*;

public class LeetCode {
    public static void main(String[] args) {
        System.out.println("\" +\"");
        System.out.println;
    }
}


class LeetCode1{
    public static int[] solution2(int[] nums, int target)
    {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();  //Map是个接口，HashMap是Map的实现类
        int n = nums.length;
        for (int i=0; i<n;i++)
        {
            if (hashtable.containsKey(target-nums[i]))
                return new int[]{i, hashtable.get(target-nums[i])};
            else
                hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}

class Leetcode2
{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode head = new ListNode(0);
        ListNode pt = head;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        while (p1 != null || p2 != null)
        {
            if (p1 != null && p2 != null)
            {
                pt.next = new ListNode((p1.val+p2.val+carry)%10);
                carry = (p1.val+p2.val+carry)/10;
                pt = pt.next;
                p1 = p1.next;
                p2 = p2.next;
                continue;
            }
            if (p1 !=null)
            {
                pt.next = new ListNode((p1.val+carry)%10);
                carry = (p1.val+carry)/10;
                pt = pt.next;
                p1 = p1.next;
                continue;
            }
            if (p2 !=null)
            {
                pt.next = new ListNode((p2.val+carry)%10);
                carry = (p2.val+carry)/10;
                pt = pt.next;
                p2=p2.next;
            }
        }
        if (carry>0)
        {
            pt.next = new ListNode(carry);
        }
        return head.next;
    }
}

class Leetcode3
{
    public static int lengthOfLongestSubstring(String s)
    {
        if (s==null || s=="")

            return 0;
        int fast = 0;
        int slow = 0;
        Map<Character, Integer> record = new HashMap<Character, Integer>();
        int length = 0;
        int n = s.length();
        while (fast<n && slow<n && slow<=fast)
        {
            char c = s.charAt(fast);
            //record.put(c,record.getOrDefault(c,0)+1);
            record.put(c,record.containsKey(c)? record.get(c)+1:1);

            /*if (record.containsKey(c))
                record.put(c, record.get(c)+1);
            else
                record.put(c,1);*/
            while (record.get(c)>1)
            {
                char d = s.charAt(slow);
                record.put(d, record.get(d)-1);
                slow+=1;
            }
            length = Math.max(length, fast-slow+1);
            fast+=1;
        }
        return length;
    }
}

class Leetcode4
{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int m = nums1.length;
        int n = nums2.length;
        int lens = m+n;
        int left = -1, right=-1;
        int p1=0, p2=0;
        for (int i=0; i<lens/2+1; i++)
        {
            left = right;
            if (p1<m && (p2>=n || nums1[p1]<nums2[p2]))
            {
                right = nums1[p1];
                p1+=1;
            }
            else
            {
                right = nums2[p2];
                p2+=1;
            }
        }
        if (lens%2==0){
            double ans = (left+right)/2.0;
            return ans;
        }
        else
            return right;
    }
}
class ListNode  //单链表的定义
{
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val)
    {
        this.val = val;
    }
    ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }
}

class Leetcode5
{
    public static String longestPalindrome(String s)
    {
        int n = s.length();
        if (n<2)
            return s;
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLength = 1;
        for (int i=0; i<n; i++)
            dp[i][i] = true;
        for (int L=2; L<n+1; L++)
        {
            for (int i=0; i<n; i++)
            {
                int j = L+i-1;
                if(j>=n)
                    break;
                if(s.charAt(i) != s.charAt(j))
                    dp[i][j] = false;
                else
                {
                    if((j-i)<=2)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i+1][j-1];
                    if (dp[i][j]==true && (j-i+1)>maxLength)
                    {
                        start = i;
                        maxLength = j - i + 1;
                    }
                }
            }
        }
        //System.out.println(start);
        //System.out.println(maxLength);
        //System.out.println(Arrays.toString(dp[0]));
        return s.substring(start, start+maxLength);

    }
}

class Leetcode6
{
    public static String convert(String s, int numRows)
    {
        if (numRows==1)
            return s;
        int length = s.length();
        if (length<=numRows)
            return s;
        int loop = 2*numRows - 2;
        String ans = "";
        for (int row=0; row<numRows; row++)
        {
            for (int j=0; j<length; j++)
            {
                int k = j%loop;
                if (k==row || k==(loop-row)) {
                    ans += (s.charAt(j));
                }
            }
        }
        return ans;
    }
}
class Leetcode7
{
    public static int reserve(int x) {
        if (x == 0)
            return 0;
        //boolean flag = (x>0?true:false);  //不需要正负数分类
        //if (flag == false)
        //   x = -x;
        int ans = 0;
        while (x != 0) {
            if (ans < Integer.MIN_VALUE / 10 || ans > Integer.MAX_VALUE / 10)
                return 0;
            ans *= 10;
            int value = x % 10;
            ans += value;
            x /= 10;
        }
        return ans;
    }
}

class Leetcode8
{
    public static int myAtoi(String s)
    {
        if (s==null || s.length()==0)
            return 0;
        String digits = "1234567890";
        String signs = "-+";
        String charNum = "";
        int length = s.length();
        for (int i=0; i<length; i++)
        {
            char si = s.charAt(i);
            if (charNum.length()==0 && si!=' ' && !digits.contains(String.valueOf(si)) && !signs.contains(String.valueOf(si)))
                break;
            else if (digits.contains(String.valueOf(si)))
                charNum+=si;
            else if (signs.contains(String.valueOf(si)))
            {
                if (i+1<length && digits.contains(String.valueOf(s.charAt(i+1)))){
                    if (charNum.length()==0)
                        charNum+=si;
                    else
                        break;
                }
                else
                    break;
            }
            else if (charNum.length()>0 && !digits.contains(String.valueOf(si)))
                break;
        }
        if (charNum.length()==0)
            return 0;

        boolean flag = charNum.charAt(0)=='-'? false : true;
        int start = 0;
        if (charNum.charAt(0) == '+' || charNum.charAt(0)=='-')
            start=1;
        long ans = 0;
        if (flag)
        {
            for (int i=start; i<charNum.length(); i++)
            {
                ans *=10;
                int k = charNum.charAt(i) - '0';
                ans += k;
                if (ans>(long) Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
            }
        }
        else
        {
            for (int i=start; i<charNum.length(); i++){


                ans *= 10;
                int k = charNum.charAt(i) - '0';
                ans -= k;
                if (ans<(long) Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }
        }
        return (int) ans;
    }
}
class Leetcode9
{
    public static boolean isPalindrome(int x)
    {
        if (x<0 || (x!=0 && x%10==0))
            return false;
        int reverseNum = 0;
        while (x>reverseNum)
        {
            reverseNum = reverseNum*10 + x%10;
            x/=10;
        }
        return x==reverseNum || x == (reverseNum/10);
    }
}
class Leetcode10{
    public static boolean isMatch(String s, String p){
        s = " "+s;
        p = " "+p;
        int lens = s.length();
        int lenp = p.length();
        boolean[][] dp = new boolean[lens][lenp];
        dp[0][0] = true;
        for (int j=2; j<lenp; j++)
        {
            if (p.charAt(j)=='*')
                dp[0][j] = dp[0][j-2];
        }
        for (int i=1; i<lens; i++){
            for (int j=1; j<lenp;j++){
                if (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')
                    dp[i][j] = dp[i-1][j-1];
                else if (p.charAt(j)=='*'){
                    if (s.charAt(i) != p.charAt(j-1) && p.charAt(j-1)!='.')
                        dp[i][j] = dp[i][j-2];
                    else
                        dp[i][j] = (dp[i-1][j] || dp[i][j-1] || dp[i][j-2]);
                }
            }
        }
        return dp[lens-1][lenp-1];
    }
}

class Leetcode11{
    public static int maxArea(int[] height){
        int ans = 0;
        int left = 0;
        int right = height.length -1;
        while (left<right){
            int area = Math.min(height[left], height[right]) * (right-left);
            ans = Math.max(ans, area);
            if (height[left]>=height[right])
                right--;
            else
                left++;
        }
        return ans;
    }
}
class Leetcode26
{
    public static int removeDuplicates(int[] nums){
        int n = nums.length;
        if (n ==0)
            return 0;
        int slow = 0;
        int fast = 0;

        while (fast<n){
            if (nums[fast] != nums[slow]) {
                slow +=1;
                nums[slow] = nums[fast];
            }
            fast +=1;
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, slow+1)));
        return slow+1;
    }
}

class LeetCode27 {
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;

        if (n==0)
            return 0;
        int slow = 0;
        for (int fast=0; fast<n; fast++){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow += 1;
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 0, slow)));
        return slow;
    }
}
class Leetcode12{
    public static String intToRoman(int num){
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String ans = "";
        for (int i=0; i<values.length;i++)
        {
            int value = values[i];
            String symbol = symbols[i];
            while (num>=value){
                num-=value;
                ans+=symbol;
            }
            if (num==0)
                break;
        }
        return ans;
    }
}
class LeetCode13 {
    public static int romanToInt(String s) {
        Map<Character, Integer> symbolToInteger = new HashMap<Character, Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C',100);
            put('D', 500);
            put('M', 1000);
        }};
        int ans =0;
        int n=s.length();
        int i=0;
        while (i<n)
        {
            int val = symbolToInteger.get(s.charAt(i));
            if (i<n-1 && val<symbolToInteger.get(s.charAt(i+1)))
                ans-=val;
            else
                ans+=val;
            i+=1;
        }
        return ans;
    }
}

class Leetcode17{
    public static List<String> letterCombinations(String digits){
        List<String> anss = new ArrayList<String>();
        int n = digits.length();
        if (n==0){
            return anss;
        }
        Map<Character, String> mapping = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        StringBuilder ans = new StringBuilder();
        dfs(0, n, ans, anss, digits, mapping);
        return anss;
    }
    public static void dfs(int index, int n, StringBuilder ans, List<String> anss, String digits, Map<Character, String> mapping){
        if (index==n)
            anss.add(ans.toString());
        else{
            char digit = digits.charAt(index);
            for (int i=0; i<mapping.get(digit).length(); i++){
                ans.append(mapping.get(digit).charAt(i));
                dfs(index+1, n, ans, anss, digits, mapping);
                ans.deleteCharAt(ans.length()-1);
            }
        }
    }
}

class Leetcode20{
    public static boolean isValid(String s){
        int n = s.length();
        if (n%2==1)
            return false;
        Map<Character, Character> mapping = new HashMap<Character, Character>(){{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i=0; i<n; i++){
            char c = s.charAt(i);
            if (mapping.containsValue(c))
                stack.push(c);
            else if (mapping.containsKey(c)){
                if (stack.isEmpty() || mapping.get(c)!= stack.pop())
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
class Leetcode22{
    public List<String> generateParenthesis(int n){
        List<String> ans = new ArrayList<String>();
        StringBuilder track = new StringBuilder();
        dfs(ans, track, 0,0,n);
        return ans;

    }
    public void dfs(List<String> ans, StringBuilder track, int left, int right, int n)
    {
        if (track.length()==2*n)
        {
            ans.add(track.toString());
            return;
        }
        if (left<n)
        {
            track.append('(');
            dfs(ans, track, left+1, right,n);
            track.deleteCharAt(track.length()-1);
        }
        if (right<left)
        {
            track.append(')');
            dfs(ans, track, left, right+1,n);
            track.deleteCharAt((track.length()-1));
        }
    }
}


class LeetCode50{
    public  static double myPow(double x, int n){
        //IEEE 754标准规定运算结果太大溢出后返回无限值Infinity，太小返回0
        long N=n;   //小心精度丢失
        if (n==0)
            return 1;
        boolean flag = true;
        if (N<0){
            flag = false;
            N = (-N);
        }
        double contribute = x;
        double ans=1.0;
        while (N>0){
            long bit = N%2;
            if (bit==1)
                ans *= contribute;
            contribute *= contribute;
            N/=2;
        }
        if (flag==true)
            return ans;
        else
            return 1.0/ans;
    }
}

class Leetcode66{
    public static int[] plusOne(int[] digits){
        int n = digits.length;
        for (int i=n-1; i>=0; i--){
            if(digits[i] != 9){
                digits[i] +=1;
                return digits;
            }
            else
                digits[i] = 0;
        }
        int[] ans = new int[n+1];
        ans[0] = 1;
        return ans;
    }
}

class MinNumber{
    public static void minNum(){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(",");
        int[] newArr = null;
        if (split.length < 3) {
            newArr = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                newArr[i] = Integer.parseInt(split[i]);
            }
        } else {
            int[] intArr = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                intArr[i] = Integer.parseInt(split[i]);
            }
            Arrays.sort(intArr);
            newArr = Arrays.copyOf(intArr, 3);
        }

        // 新数组最小组合
        String minCombine = printMinNumber(newArr);
        System.out.println(minCombine);
    }
    private static String printMinNumber(int[] newArr) {
        if (newArr == null || newArr.length == 0) {
            return "";
        }
        int length = newArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = String.valueOf(newArr[i]);
        }
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String c1 = o1 + o2;
                String c2 = o2 + o1;
                return c1.compareTo(c2);
            }
        });

        for (int i = 0; i < length; i++) {
            sb.append(strArr[i]);
        }
        return sb.toString();
    }
}

class treeNode{
    int val;
    treeNode left;
    treeNode right;
    treeNode() {}
    treeNode(int val){
        this.val = val;
    }
    treeNode(int val,treeNode left, treeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Leetcode94{
    public List<Integer> inorderTraversal(treeNode root){
        List<Integer> ans = new ArrayList<>();
        recur(root, ans);
        return ans;
    }
    public void recur(treeNode root, List<Integer> ans){
        if (root == null)
            return;
        recur(root.left, ans);
        ans.add(root.val);
        recur(root.right, ans);
    }
    public List<Integer> inorderTraversal1(treeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        Deque<treeNode> stack = new LinkedList<treeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }
}

class Leetcode144{
    public List<Integer> preorderTraversal(treeNode root){
        List<Integer> ans = new ArrayList<Integer>();
        recur(root, ans);
        return ans;
    }
    public void recur(treeNode root, List<Integer> ans) {
        if (root == null)
            return;
        ans.add(root.val);
        recur(root.left, ans);
        recur(root.right, ans);
    }
    public List<Integer> preorderTraversal1(treeNode root){
        List<Integer> ans = new ArrayList<Integer>();
        if (root==null)
            return ans;
        Deque<treeNode> stack = new LinkedList<treeNode>();
        stack.push(root);
        while (!stack.isEmpty()){
            treeNode node = stack.pop();
            ans.add(node.val);
            if (node.right != null)
                stack.push(node.right);
            if (node.left!= null)
                stack.push(node.left);
        }
        return ans;
    }
}

class Leetcode145 {
    public List<Integer> postorderTraversal(treeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        recur(root, ans);
        return ans;

    }
    public void recur(treeNode root, List<Integer> ans){
        if (root == null)
            return;
        recur(root.left, ans);
        recur(root.right, ans);
        ans.add(root.val);
    }
}

class Leetcode45{
    public static int jump(int[] nums){
        int n = nums.length;
        int maxposition = 0;
        int end = 0;
        int step = 0;
        for (int i=0; i<n-1; i++){
            maxposition = Math.max(i+nums[i], maxposition);
            if (end == i){
                end = maxposition;
                step++;
            }
        }
        return step;
    }
}

class Leetcode121 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = prices[0];
        int n = prices.length;
        for (int i=1; i<n; i++){
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }
            else{
                profit = Math.max(profit, prices[i] - minPrice);
            }
        }
        return profit;
    }
}
class Leetcode122{
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i=1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
        }
        return dp[n-1][0];
    }
    public int maxProfit2(int[] prices){
        int n = prices.length;
        int profit = 0;
        for (int i=1; i<n; i++){
            profit += Math.max(0, prices[i]-prices[i-1]);
        }
        return profit;
    }
}
