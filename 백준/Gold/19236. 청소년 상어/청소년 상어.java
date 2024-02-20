import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int[][] origin = new int [4][4];
	public static int max = 0;
	public static int sum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int r = 0 ; r < 4 ; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c = 0 ; c < 4 ; c++) {
				origin[r][c] += Integer.parseInt(st.nextToken()) * 10;
				origin[r][c] += Integer.parseInt(st.nextToken());
			}
		}
		
		sum += origin[0][0] /10;
		origin[0][0] = 990 + origin[0][0] %10;
		
		sharkMove(fishMove(origin));
		System.out.println(max);
		
	}
	
	public static int[][] fishMove(int[][] a) {
		int[][] arr = new int[4][4];
		for(int r = 0 ; r < 4 ; r++) {
			arr[r] = Arrays.copyOf(a[r], 4);
		}
		
		for(int i = 1 ; i <= 16 ; i++) {
			find:
			for(int r = 0 ; r < 4 ; r++) {
				for(int c = 0 ; c < 4 ; c++) {
					if(arr[r][c] /10 == i) {
						while(true) {
							if(arr[r][c] %10 == 1) {
								if(r==0 || arr[r-1][c]/10 == 99) {
									arr[r][c]++; continue;
								} else {
									int tmp = arr[r][c];
									arr[r][c] = arr[r-1][c];
									arr[r-1][c] = tmp; break;
								}
							} else if(arr[r][c] %10 == 2) {
								if(r==0 || c==0 || arr[r-1][c-1]/10 == 99) {
									arr[r][c]++; continue; 
								} else {
									int tmp = arr[r][c];
									arr[r][c] = arr[r-1][c-1];
									arr[r-1][c-1] = tmp; break;
								}
							} else if(arr[r][c] %10 == 3) {
								if(c==0 || arr[r][c-1]/10 == 99) {
									arr[r][c]++; continue; 
								} else {
									int tmp = arr[r][c];
									arr[r][c] = arr[r][c-1];
									arr[r][c-1] = tmp; break;
								}
							} else if(arr[r][c] %10 == 4) {
								if(r==3 || c==0 || arr[r+1][c-1]/10 == 99) {
									arr[r][c]++; continue; 
								} else {
									int tmp = arr[r][c];
									arr[r][c] = arr[r+1][c-1];
									arr[r+1][c-1] = tmp; break;
								}
							} else if(arr[r][c] %10 == 5) {
								if(r==3 || arr[r+1][c]/10 == 99) {
									arr[r][c]++; continue; 
								} else {
									int tmp = arr[r][c];
									arr[r][c] = arr[r+1][c]; 
									arr[r+1][c] = tmp; break;
								}
							} else if(arr[r][c] %10 == 6) {
								if(r==3 || c==3 || arr[r+1][c+1]/10 == 99) {
									arr[r][c]++; continue; 
								} else {
									int tmp = arr[r][c];
									arr[r][c] = arr[r+1][c+1]; 
									arr[r+1][c+1] = tmp; break;
								}
							} else if(arr[r][c] %10 == 7) {
								if(c==3 || arr[r][c+1]/10 == 99) {
									arr[r][c]++; continue; 
								} else {
									int tmp = arr[r][c];
									arr[r][c] = arr[r][c+1];
									arr[r][c+1] = tmp; break;
								}
							} else if(arr[r][c] %10 == 8) {
								if(r==0 || c==3 || arr[r-1][c+1]/10 == 99) {
									arr[r][c] -= 7; continue; 
								} else {
									int tmp = arr[r][c];
									arr[r][c] = arr[r-1][c+1];
									arr[r-1][c+1] = tmp; break;
								}
							} 
						}
						break find;
					}
				}
			}
		}
		return arr;
	}
	
	
	public static void sharkMove(int[][] a) {
		int[][] arr = new int[4][4];
		for(int r = 0 ; r < 4 ; r++) {
			arr[r] = Arrays.copyOf(a[r], 4);
		}
		
		for(int r = 0 ; r < 4 ; r++) {
			for(int c = 0 ; c < 4 ; c++) {
				if(arr[r][c] /10 == 99) {
					for(int i = 1 ; i <= 3 ; i++) {
						if(arr[r][c] %10 == 1) {
							if(r==0) {
								if(sum > max) {
									max = sum;
								} return;
							} else if(r-i >= 0) {
								sum += arr[r-i][c] /10;
								arr[r-i][c] = 990 + arr[r-i][c] %10;
								arr[r][c] = 0;
								sharkMove(fishMove(arr));
								for(int rr = 0 ; rr < 4 ; rr++) {
									arr[rr] = Arrays.copyOf(a[rr], 4);
								}
								sum -= arr[r-i][c] /10;
							} else {
								if(sum > max) {
									max = sum;
								} return;
							}
						} else if(arr[r][c] %10 == 2) {
							if(r==0 || c==0) {
								if(sum > max) {
									max = sum;
								} return;
							} else if(r-i >= 0 && c-i >= 0) {
								sum += arr[r-i][c-i] /10;
								arr[r-i][c-i] = 990 + arr[r-i][c-i] %10;
								arr[r][c] = 0;
								sharkMove(fishMove(arr));
								for(int rr = 0 ; rr < 4 ; rr++) {
									arr[rr] = Arrays.copyOf(a[rr], 4);
								}
								sum -= arr[r-i][c-i] /10;
							} else {
								if(sum > max) {
									max = sum;
								} return;
							}
						} else if(arr[r][c] %10 == 3) {
							if(c==0) {
								if(sum > max) {
									max = sum;
								} return;
							} else if(c-i >= 0) {
								sum += arr[r][c-i] /10;
								arr[r][c-i] = 990 + arr[r][c-i] %10;
								arr[r][c] = 0;
								sharkMove(fishMove(arr));
								for(int rr = 0 ; rr < 4 ; rr++) {
									arr[rr] = Arrays.copyOf(a[rr], 4);
								}
								sum -= arr[r][c-i] /10;
							} else {
								if(sum > max) {
									max = sum;
								} return;
							}
						} else if(arr[r][c] %10 == 4) {
							if(r==3 || c==0) {
								if(sum > max) {
									max = sum;
								} return;
							} else if(r+i <= 3 && c-i >= 0) {
								sum += arr[r+i][c-i] /10;
								arr[r+i][c-i] = 990 + arr[r+i][c-i] %10;
								arr[r][c] = 0;
								sharkMove(fishMove(arr));
								for(int rr = 0 ; rr < 4 ; rr++) {
									arr[rr] = Arrays.copyOf(a[rr], 4);
								}
								sum -= arr[r+i][c-i] /10;
							} else {
								if(sum > max) {
									max = sum;
								} return;
							}
						} else if(arr[r][c] %10 == 5) {
							if(r==3) {
								if(sum > max) {
									max = sum;
								} return;
							} else if(r+i <= 3) {
								sum += arr[r+i][c] /10;
								arr[r+i][c] = 990 + arr[r+i][c] %10;
								arr[r][c] = 0;
								sharkMove(fishMove(arr));
								for(int rr = 0 ; rr < 4 ; rr++) {
									arr[rr] = Arrays.copyOf(a[rr], 4);
								}
								sum -= arr[r+i][c] /10;
							} else {
								if(sum > max) {
									max = sum;
								} return;
							}
						} else if(arr[r][c] %10 == 6) {
							if(r==3 || c==3) {
								if(sum > max) {
									max = sum;
								} return;
							} else if(r+i <= 3 && c+i <= 3) {
								sum += arr[r+i][c+i] /10;
								arr[r+i][c+i] = 990 + arr[r+i][c+i] %10;
								arr[r][c] = 0;
								sharkMove(fishMove(arr));
								for(int rr = 0 ; rr < 4 ; rr++) {
									arr[rr] = Arrays.copyOf(a[rr], 4);
								}
								sum -= arr[r+i][c+i] /10;
							} else {
								if(sum > max) {
									max = sum;
								} return;
							}
						} else if(arr[r][c] %10 == 7) {
							if(c==3) {
								if(sum > max) {
									max = sum;
								} return;
							} else if(c+i <= 3) {
								sum += arr[r][c+i] /10;
								arr[r][c+i] = 990 + arr[r][c+i] %10;
								arr[r][c] = 0;
								sharkMove(fishMove(arr));
								for(int rr = 0 ; rr < 4 ; rr++) {
									arr[rr] = Arrays.copyOf(a[rr], 4);
								}
								sum -= arr[r][c+i] /10;
							} else {
								if(sum > max) {
									max = sum;
								} return;
							}
						} else if(arr[r][c] %10 == 8) {
							if(r==0 || c==3) {
								if(sum > max) {
									max = sum;
								} return;
							} else if(r-i >= 0 && c+i <= 3) {
								sum += arr[r-i][c+i] /10;
								arr[r-i][c+i] = 990 + arr[r-i][c+i] %10;
								arr[r][c] = 0;
								sharkMove(fishMove(arr));
								for(int rr = 0 ; rr < 4 ; rr++) {
									arr[rr] = Arrays.copyOf(a[rr], 4);
								}
								sum -= arr[r-i][c+i] /10;
							} else {
								if(sum > max) {
									max = sum;
								} return;
							}
						}
					}
				}
			}
		}
	}
}