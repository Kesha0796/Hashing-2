class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> count=new HashMap<>();
        boolean one=false;
        int answer=0;
        if(s==null || s.length()==0)
            return 0;
        // Time Complexity: O(n) , n= no of characters in string
        for(int i=0;i<s.length();i++)
        {
            if(count.containsKey(s.charAt(i)))
            {
                int c=count.get(s.charAt(i));
                count.put(s.charAt(i),c+1);
            }
            else
            {
                count.put(s.charAt(i),1);
            }
        }
        // Time Complexity: O(k), k= no of key-value pairs in HashMap
        for (Character alphabet : count.keySet())
        {
                int digit=count.get(alphabet);
                if(digit%2==1)
                {
                    if(!one)
                    {
                        answer+=digit;
                        one=true;
                    } 
                    else
                        answer+=(digit-1);
                }
                if(count.get(alphabet)%2==0)
                    answer+=digit;
        }
        return answer;
    }
}

// Time Complexity: O(n+k) --> O(n) 
// Space Complexity: O(n)