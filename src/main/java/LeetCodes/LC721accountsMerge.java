package LeetCodes;

import java.util.*;

public class LC721accountsMerge {

    public static List<List<String>> accountsMerge(List<List<String>> accounts){
        Map<String,Integer> emailToIndex = new HashMap<String,Integer>();
        Map<String,String> emailToName = new HashMap<String,String>();
        int emailIndex = 0;

        for(List<String> account : accounts){
            String name = account.get(0);
            for(int i = 1; i < account.size();i++){
                emailToIndex.putIfAbsent(account.get(i),emailIndex++);
                emailToName.putIfAbsent(account.get(i),name);
            }
        }

        UnionFind uf = new UnionFind(emailIndex);
        for(List<String> account : accounts){
            String firstEmail = account.get(1);
            int firstEmailIndex = emailToIndex.get(firstEmail);
            int size = account.size();
            for(int i = 2; i < size; i++){
                String nextEmail = account.get(i);
                int nextEmailIndex = emailToIndex.get(nextEmail);
                uf.union(firstEmailIndex, nextEmailIndex);
            }
        }

        Map<Integer,List<String>> indexToEmails = new HashMap<>();
        for(String email : emailToIndex.keySet()){
            int index = uf.find(emailToIndex.get(email));
            List<String> account = indexToEmails.getOrDefault(index,new ArrayList<>());
            account.add(email);
            indexToEmails.put(index,account);
        }

        List<List<String>> merged = new ArrayList<List<String>>();

        for(List<String> emails : indexToEmails.values()){
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            List<String> account = new ArrayList<>();
            account.add(name);
            account.addAll(emails);
            merged.add(account);
        }

        return merged;
    }

    public static class UnionFind{
        int[] parent;

        public UnionFind(int n){
            this.parent = new int[n];
            for(int i = 0; i < parent.length; i++){
                this.parent[i] = i;
            }
        }

        public void union(int index1, int index2){
            this.parent[find(index2)] = find(index1);
        }

        public int find(int index){
            return this.parent[index] == index? index : (this.parent[index] = find(parent[index]));
        }

    }
}
