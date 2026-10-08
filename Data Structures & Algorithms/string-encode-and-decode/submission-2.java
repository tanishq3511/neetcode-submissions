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
            int j = i + 1;
            while(str.charAt(j) != '#') j++;

            int length = Integer.parseInt(str.substring(i, j));
            decoding.add(str.substring(j + 1, j + length + 1));
            i = j + length + 1;
        }

        return decoding;
    }
}
