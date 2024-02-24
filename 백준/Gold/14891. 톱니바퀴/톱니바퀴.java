import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[][] arr = new int[4][8];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		for(int i = 0 ; i < 4 ; i++) {
			String str = br.readLine();
			for(int j = 0 ; j < 8 ; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < n ; i++) {
			st = new StringTokenizer(br.readLine());
			int nth = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			if(nth == 1) {
				if(dir == -1) {
					if(arr[0][2] != arr[1][6]) {
						if(arr[1][2] != arr[2][6]) {
							if(arr[2][2] != arr[3][6]) {
								rr(0); rc(1); rr(2); rc(3);
							} else {
								rr(0); rc(1); rr(2);
							}
						} else {
							rr(0); rc(1);
						}
					} else {
						rr(0);
					}
				}
				else if(dir == 1) {
					if(arr[0][2] != arr[1][6]) {
						if(arr[1][2] != arr[2][6]) {
							if(arr[2][2] != arr[3][6]) {
								rc(0); rr(1); rc(2); rr(3);
							} else {
								rc(0); rr(1); rc(2);
							}
						} else {
							rc(0); rr(1);
						}
					} else {
						rc(0);
					}
				}
			}
			
			else if(nth == 2) {
				if(dir == -1) {
					if(arr[0][2] != arr[1][6]) {
						if(arr[1][2] != arr[2][6]) {
							if(arr[2][2] != arr[3][6]) {
								rc(0); rr(1); rc(2); rr(3);
							} else {
								rc(0); rr(1); rc(2);
							}
						} else {
							rc(0); rr(1);
						}
					} else {
						if(arr[1][2] != arr[2][6]) {
							if(arr[2][2] != arr[3][6]) {
								rr(1); rc(2); rr(3);
							} else {
								rr(1); rc(2);
							}
						} else {
							rr(1);
						}
					}
				}
				else if(dir == 1) {
					if(arr[0][2] != arr[1][6]) {
						if(arr[1][2] != arr[2][6]) {
							if(arr[2][2] != arr[3][6]) {
								rr(0); rc(1); rr(2); rc(3);
							} else {
								rr(0); rc(1); rr(2);
							}
						} else {
							rr(0); rc(1);
						}
					} else {
						if(arr[1][2] != arr[2][6]) {
							if(arr[2][2] != arr[3][6]) {
								rc(1); rr(2); rc(3);
							} else {
								rc(1); rr(2);
							}
						} else {
							rc(1);
						}
					}
				}
			}
			
			else if(nth == 3) {
				if(dir == -1) {
					if(arr[2][2] != arr[3][6]) {
						if(arr[1][2] != arr[2][6]) {
							if(arr[0][2] != arr[1][6]) {
								rr(0); rc(1); rr(2); rc(3);
							} else {
								rc(1); rr(2); rc(3);
							}
						} else {
							rr(2); rc(3);
						}
					} else {
						if(arr[1][2] != arr[2][6]) {
							if(arr[0][2] != arr[1][6]) {
								rr(0); rc(1); rr(2);
							} else {
								rc(1); rr(2);
							}
						} else {
							rr(2);
						}
					}
				}
				else if(dir == 1) {
					if(arr[2][2] != arr[3][6]) {
						if(arr[1][2] != arr[2][6]) {
							if(arr[0][2] != arr[1][6]) {
								rc(0); rr(1); rc(2); rr(3);
							} else {
								rr(1); rc(2); rr(3);
							}
						} else {
							rc(2); rr(3);
						}
					} else {
						if(arr[1][2] != arr[2][6]) {
							if(arr[0][2] != arr[1][6]) {
								rc(0); rr(1); rc(2);
							} else {
								rr(1); rc(2);
							}
						} else {
							rc(2);
						}
					}
				}
			}
			
			else if(nth == 4) {
				if(dir == -1) {
					if(arr[2][2] != arr[3][6]) {
						if(arr[1][2] != arr[2][6]) {
							if(arr[0][2] != arr[1][6]) {
								rc(0); rr(1); rc(2); rr(3);
							} else {
								rr(1); rc(2); rr(3);
							}
						} else {
							rc(2); rr(3);
						}
					} else {
						rr(3);
					}
				}
				else if(dir == 1) {
					if(arr[2][2] != arr[3][6]) {
						if(arr[1][2] != arr[2][6]) {
							if(arr[0][2] != arr[1][6]) {
								rr(0); rc(1); rr(2); rc(3);
							} else {
								rc(1); rr(2); rc(3);
							}
						} else {
							rr(2); rc(3);
						}
					} else {
						rc(3);
					}
				}
			}
		}
		
		System.out.println(arr[0][0]+2*arr[1][0]+4*arr[2][0]+8*arr[3][0]);
		
	}
	
	public static void rr(int num) {
		int tmp = arr[num][0];
		for(int idx = 0 ; idx < 7 ; idx++) {
			arr[num][idx] = arr[num][idx+1];
		}
		arr[num][7] = tmp;
	}
	
	public static void rc(int num) {
		int tmp = arr[num][7];
		for(int idx = 7 ; idx > 0 ; idx--) {
			arr[num][idx] = arr[num][idx-1];
		}
		arr[num][0] = tmp;
	}
	
}
