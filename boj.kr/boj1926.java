import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1926 {
    //boj.kr/1926 BFS
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");

        Boolean[][] visit= new Boolean[500][500];
        // Arrays.fill(visit,Boolean.FALSE); 1차원

        for(Boolean[] a: visit) {//2차원 배열 fill
            Arrays.fill(a,false);
        }

        int mx = 0;
        int num = 0;
        int[][] board = new int[500][500];

        int[] x = {1,0,-1,0};
        int[] y = {0,1,0,-1};
        Queue<Pair<Integer,Integer>> q = new Queue<>();

        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);
        for(int i=0; i<n; i++){//열
            String[] temp = br.readLine().split(" ");
            for(int j=0; j<m; j++ ){//행
                board[i][j]= Integer.parseInt(temp[j]);
            }
        }

        for(int i=0; i< n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 0 || visit[i][j]) continue;
                    //i,j 시작
                    num++;
                    visit[i][j]=true;
                    q.add(new Pair<>(i,j));
                    int area = 0;//그림너비

                    while(!q.isEmpty()){
                        area++;
                        Pair<Integer,Integer> cur = q.peek(); q.remove(); 
                        for(int dir = 0; dir<4; dir++){
                                    int nx = cur.first + x[dir];
                                    int ny = cur.second + y[dir];// nx, ny에 dir에서 정한 방향의 인접한 칸의 좌표가 들어감
                                    if(nx <0 || nx >=n || ny <0|| ny>=m ) continue;
                                    if(visit[nx][ny] || board[nx][ny] !=1){
                                        //방문했거나, 1이 아닌경우 pass
                                        continue;
                                    }
                        visit[nx][ny] = true;
                        q.add(new Pair<>(nx,ny));
                      }
                    }
                    mx= Math.max(mx, area);
            }
        }

        System.out.println("num = "+ num + " mx : "+mx);
    }
}

class Pair<T,S> {
    T first;
    S second;

    public Pair(T first, S second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){
        return first;
    }

    public S getSecond(){
        return second;
    }
}
