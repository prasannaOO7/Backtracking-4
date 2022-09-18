// TC: O(k^n)
// SC: O(n)

class Solution {
    List<List<Character>> blocks;
    List<String> result;
    public String[] expand(String s) {
        if(s==null || s.length()==0) return new String[]{};
        
        blocks = new ArrayList<>();
        result = new ArrayList<>();
        
        int n = s.length();
        int i=0;
        while(i!=n){
            List<Character> block = new ArrayList<>();
            if(s.charAt(i)=='{'){
                i++;
                while(s.charAt(i)!='}'){
                    if(s.charAt(i)!=','){
                        block.add(s.charAt(i));
                    }
                    i++;
                }
            }else{
                block.add(s.charAt(i));
            }
            Collections.sort(block);
            blocks.add(block);
            i++;
        }
        
        backtrack(0,new StringBuilder());
        
        String[] ans = new String[result.size()];
        for(int j=0;j<ans.length;j++){
            ans[j]=result.get(j);
        }
        
        return ans;
    
    }
    private void backtrack(int idx,StringBuilder sb){
        // base case
        if(idx==blocks.size()){
            result.add(sb.toString());
            return;
        }
        
        // logic 
        
        List<Character> block = blocks.get(idx);
        for(int i=0;i<block.size();i++){
            // action 
            sb.append(block.get(i));
            // reccursion
            backtrack(idx+1,sb);
            //backtrack
            sb.setLength(sb.length()-1);
            
        }
    }
}
