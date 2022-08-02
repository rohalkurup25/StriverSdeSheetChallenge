    import java.util.*;
    class Solution {
      static class Node
       {
           Node child[] = new Node[26];
           boolean end;
           int count=1;
           Node()
           {

           }

           Node get(char ch)
           {
               return child[ch-'a'];
           }

           boolean containsKey(char ch)
           {
               return child[ch-'a']!=null;
           }

           void setEnd()
           {
               end = true;
           }

           boolean getEnd()
           {
               return end;
           }

           void put(char ch ,Node node)
           {
               child[ch-'a'] = node;
           }

           void incCount()
           {
               count++;
           }
       }   



     static class Trie
    {
        private static Node root;
        Trie()
        {
            root = new Node();
        }
         public static void insert(String str)
         {
             Node node = root;
             for(int i=0;i<str.length();i++)
             {
                 char ch = str.charAt(i);
                 if(!node.containsKey(ch))
                 {
                     Node node1 = new Node();
                     node.put(ch,node1);
                     node = node.get(ch);
                 }
                 else
                 {
                     node = node.get(ch);
                     node.incCount();
                 }
             }
             node.setEnd();
         }

    }
         public static String completeString(int n, String[] a) {
         Trie obj = new Trie();
           for(String s: a)
               obj.insert(s);
           int maxLength = 0;
           String ans = "None";
           for(String s: a)
           {
               Node node = Trie.root;
               boolean flag = false;
               for(int i=0;i<s.length();i++)
               {
                   char ch = s.charAt(i);
                   if(node.containsKey(ch))
                   {
                       node = node.get(ch);
                       if(!node.getEnd()) {
                           flag  = true;
                           break;

                       }
                   }

               }
               if(!flag)
               {
                   if(s.length()>maxLength)
                   {
                       maxLength = s.length();
                       ans=s;
                   }
                   else if(s.length()==maxLength)
                   {
                       if(s.compareTo(ans)<0)
                       ans = s;
                   }
               }
           }
         return ans;
     }
    }