class WordDictionary {
    class Trie{
        Trie children[]= new Trie[26];
        boolean isEnd;
    }
    Trie root;
    public WordDictionary() {
        root= new Trie();
    }

    public void addWord(String word) {
        Trie curr=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(curr.children[ch-'a']==null){
                Trie newNode= new Trie();
                curr.children[ch-'a']=newNode;
            }
            curr=curr.children[ch-'a'];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        return searchHelper(root,0,word);
    }

    public boolean searchHelper(Trie r, int index, String word){
        Trie curr=r;
        for(int i=index;i<word.length();i++){
            char ch=word.charAt(i);
            if(ch=='.'){
                boolean present=false;
                for(int j=0;j<26;j++){
                    boolean temp=false;
                    if(curr.children[j]!=null)
                        temp=searchHelper(curr.children[j],i+1,word);
                    present=present||temp;
                }
                return present;
            }
            if(curr.children[ch-'a']==null){
                return false;
            }
            curr=curr.children[ch-'a'];
        }
        if(curr.isEnd)
            return true;
        else
            return false;
    }
}
