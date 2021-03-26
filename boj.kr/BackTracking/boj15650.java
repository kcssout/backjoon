package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class boj15650 {
    static int[] arr = new int[10];
    static Boolean[] issued = new Boolean[10];
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(issued,Boolean.FALSE);
        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        solution(0);
        //4,3
    }

    static void solution(int k){
        if(k==m){
            // System.out.println(" k " + k);
            for(int i=0; i<m; i++){
                System.out.print(arr[i]+ " ");
            }
            System.out.println();
            return;
        }

        for(int i=k+1; i<=n; i++){
            if(!issued[i]){
                issued[i]=true;
                arr[k]= i; //1->2 
                if(k-1 >= 0 && arr[k] < arr[k-1] ){ //앞에 쓰였던 수 통과
                    issued[i]=false;
                    arr[k]=0;
                    continue;
                }
                solution(k+1);

                issued[i]=false;
                arr[k]=0;
            }

        }


    }

}

