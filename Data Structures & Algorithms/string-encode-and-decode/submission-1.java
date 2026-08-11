class Solution {

    public String encode(List<String> strs) {
        String encoding = "";

        for(String s : strs){
            encoding += s.length() + "#" + s;
        }

        return encoding;
    }

    public List<String> decode(String str) {
        List<String> decoding = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }

            int strLength = Integer.parseInt(str.substring(i, j));
            decoding.add(str.substring(j + 1, j + 1 + strLength));
            i = j + 1 + strLength;
        }

        return decoding;
    }
}
