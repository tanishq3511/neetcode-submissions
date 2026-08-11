class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || beginWord.equals(endWord)){
            return 0;
        }

        Set<String> words = new HashSet<>(wordList);
        int res = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        while(!q.isEmpty()){
            res++;
            for(int x = q.size(); x>0; x--){
                String node = q.poll();
                if(node.equals(endWord)){
                    return res;
                }
                for(int y=0; y < node.length(); y++){
                    for(char c = 'a'; c<= 'z'; c++){
                        String nei = node.substring(0, y) + c + node.substring(y+1);
                        if(words.contains(nei)){
                            q.offer(nei);
                            words.remove(nei);
                        }
                    }    
                }
            }
        }

        return 0;
    }
}
