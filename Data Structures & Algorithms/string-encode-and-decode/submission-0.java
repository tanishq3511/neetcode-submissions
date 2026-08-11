class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for(String s : strs){
            res += (s.length() + "^" + s);
        }
        return res;
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int x = 0;
        while(x < str.length()){
            int y = x;
            while(!str.substring(y, y+1).equals("^")){
                y++;
            }

            int strLen = Integer.parseInt(str.substring(x, y));
            x = y+1;
            y = x + strLen;
            res.add(str.substring(x, y));
            x = y;
        }

        return res;
    }
}
