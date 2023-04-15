package org.example.매칭점수;
import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public int solution(String word, String[] pages) {

        word = word.toLowerCase();
        int answer = 0;
        HashMap<String,Integer> map = new HashMap<>();      //스트링 to index
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] score = new int[pages.length];
        int[] linkCnt = new int[pages.length];
        for(int i=0;i<pages.length;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<pages.length;i++){

            String page = pages[i];

            //content 뽑아내기
            String content = page.split("<head>")[1].split("</head>")[0].split(" content=")[1].trim().replace("/>","");
            map.put(content,i);

            //body 뽑아내기
            String body = page.split("<body>")[1].split("</body>")[0].trim();
            String[] bodyList = body.split("<a href=");
            int cnt = 0;
            for(String s:bodyList){

                //System.out.println("num : " + idx++ + s.trim());
                if(s.trim().startsWith("\"https://")){

                    String[] divide = s.split("</a>");
                    //뒤가 있으면
                    if(divide.length>1){
                        cnt += countWord(divide[1].trim().toLowerCase(),word);
                    }
                    String link = divide[0].split("> Link to")[0].replace(">","");
                    linkCnt[i]++;
                    if(map.containsKey(link)){
                        int parentIdx = map.get(link);
                        list.get(parentIdx).add(i);
                    }
                    //System.out.println("check " + s);
                }else{
                    s = s.trim().toLowerCase();
                    cnt += countWord(s,word);
                    //여기에 더해주어야 함
                }
            }
            //System.out.println("cnt : " + cnt);
            score[i] = cnt;

        }

        for(int i=0;i<pages.length;i++){

            double nowScore = score[i];
            for(int j=0;j<list.get(i).size();j++){
                int index = list.get(i).get(j);
                nowScore += (double)score[index]/linkCnt[index];
            }
            System.out.println(nowScore);

        }

        //System.out.println(Arrays.toString(score));
        return answer;
    }

    int countWord(String s, String word){


        int cnt = 0;
        String pattern = "[a-zA-Z]";
        for(int i=0;i<s.length()-word.length()+1;i++){

            boolean flag = true;
            for(int j=0;j<word.length();j++){
                if(word.charAt(j)!=s.charAt(i+j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                if(i>0&& Pattern.matches(String.valueOf(s.charAt(i-1)),pattern)
                        ||i<s.length()-word.length()&&Pattern.matches(String.valueOf(s.charAt(i+word.length())),pattern)){
                    cnt++;
                }

            }
        }


        return cnt;
    }
}