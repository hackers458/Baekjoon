import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class Main {

    static int[] global_array; // count 모음
    static int[] array;
    public static void dp(int start, int middle, int end,int index){
        int is = 0;
        for(int i = 0;i<index;i++) {
            if (end > array[i] && global_array[index] <= global_array[i]) {
                global_array[index] = global_array[i];
                is = 1;

            }
        }
        if (is == 1){
            global_array[index]++;
        }
    }







    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int end = 2;
        array = new int[a+1];
        global_array = new int[a+1];
        for(int i = 0; i<a;i++){
            array[i] = scanner.nextInt();
        }
        for(int i = 0; i<a;i++){
            global_array[i] = 1;
        }


        if (a == 1){
            System.out.println(1);
        }
        else if(a == 2){
            if(array[0] < array[1]){
                System.out.println(2);
            }
            else{
                System.out.println(1);
            }
        }

        else if (a >=3){  // 3개 이상일때
            if(array[0] < array[1]){
                global_array[0] = 1;
                global_array[1] = 2;
            }
            else{
                global_array[0] = 1;
                global_array[1] = 1;
            }




            while(end != a){
                dp(array[end-2],array[end-1],array[end],end);
                end++;
            }


            System.out.println(Arrays.stream(global_array).max().getAsInt());





        }
        }

    }


