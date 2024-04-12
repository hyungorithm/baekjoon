import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] maze = new char[N][M];
		boolean[][] visited = new boolean[N][M];

		for (int n = 0; n < N; n++) {
			maze[n] = br.readLine().toCharArray();
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		Queue<int[]> q = new LinkedList<>();
		int[] tmp = { 0, 0 };
		q.add(tmp);
		visited[0][0] = true;
		int count = 1;

		while (!q.isEmpty()) {

			int qSize = q.size();
			while (qSize > 0) {
				qSize--;

				int[] cur = q.poll();
//				System.out.println("q에서 뽑음 " + Arrays.toString(cur));
				int row = cur[0];
				int col = cur[1];

				for (int i = 0; i < 4; i++) {

					int rr = row + dr[i];
					int cc = col + dc[i];

					if (rr == N - 1 && cc == M - 1) {
						System.out.println(count + 1);
						return;
					}

					if (rr < 0 || cc < 0 || rr >= N || cc >= M) {
						continue;
					}

					if (visited[rr][cc] || maze[rr][cc] == '0') {
						continue;
					}

//					System.out.println(rr + " " + cc);
					int[] tmpQ = { rr, cc };
//					System.out.println(Arrays.toString(tmpQ));
					visited[rr][cc] = true;
					q.add(tmpQ);

				}

			}
			count++;
		}

	}
}
