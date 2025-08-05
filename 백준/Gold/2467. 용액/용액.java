import java.util.*;

public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int num = sc.nextInt();
      int[] list = new int[num];

      for(int i =0;i<num;i++){
          list[i] = sc.nextInt();
      }
      int start = 0;
      int end = num-1;

      int sum = Math.abs(list[start] + list[end]);


      int answer1 = -1;
      int answer2 = -1;
      while(start!=end){
          if(sum>=Math.abs(list[start] + list[end]))
          {
              sum = Math.abs(list[start] + list[end]);
              answer1 = list[start];
              answer2 = list[end];
          }

          if(Math.abs(list[start])<Math.abs(list[end])){
              end--;
          }
          else if(Math.abs(list[start])>Math.abs(list[end])){
              start++;
          }
          else{
              end--;
              start++;
          }





      }


      System.out.println(answer1 + " " + answer2);




    }
}
