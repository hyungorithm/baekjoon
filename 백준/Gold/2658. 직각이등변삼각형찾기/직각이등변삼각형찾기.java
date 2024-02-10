import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] arr = new int[10][10];
		int[] ans = {1,1,1,1,1,1};
		
		int[] case1 = {1,3,6,10,15,21,28,36,45,55};
		int[] case2 = {1,4,9,16,25};
		
		int sum = 0;
		for(int r = 0 ; r < 10 ; r++) {
			String str = br.readLine();
			for(int c = 0 ; c < 10 ; c++) {
				arr[r][c] = str.charAt(c) - '0';
				sum += arr[r][c];
			}
		}
		
		int errCount = 0;
		
		case1:
		for(int i = 1 ; i < case1.length ; i++) {
			if(sum == case1[i]) {
				for(int r = 0 ; r < 10 ; r++) {
					for(int c = 0 ; c < 10 ; c++) {
						if(arr[r][c] == 1) {
							if(c == 9 || arr[r][c+1] == 0) {
								if(r+i < 10 && c-i >= 0) {
									case1_1:
										for(int ri = 0 ; ri <= i ; ri++) {
											for(int ci = 0 ; ci <= ri ; ci++) {
												if(arr[r+ri][c-ci] == 0) {
													errCount++;
													break case1_1;
												}
											}
										}
									if(errCount == 0) {
										ans[0] += r; ans[1] += c;
										ans[2] += r+i; ans[3] += c-i;
										ans[4] += r+i; ans[5] += c;
										break case1;
									}
									errCount = 0;
								}
								
								if(r+i < 10 && c+i < 10) {
									case1_2:
										for(int ri = 0 ; ri <= i ; ri++) {
											for(int ci = 0 ; ci <= ri ; ci++) {
												if(arr[r+ri][c+ci] == 0) {
													errCount++;
													break case1_2;
												}
											}
										}
									if(errCount == 0) {
										ans[0] += r; ans[1] += c;
										ans[2] += r+i; ans[3] += c;
										ans[4] += r+i; ans[5] += c+i;
										break case1;
									}
									errCount = 0;
								}
								
								break case1;
							}
							
							else {
								if(r+i < 10 && c+i < 10) {
									case1_3:
										for(int ri = 0 ; ri <= i ; ri++) {
											for(int ci = 0 ; ci <= i - ri ; ci++) {
												if(arr[r+ri][c+ci] == 0) {
													errCount++;
													break case1_3;
												}
											}
										}
									if(errCount == 0) {
										ans[0] += r; ans[1] += c;
										ans[2] += r; ans[3] += c+i;
										ans[4] += r+i; ans[5] += c;
										break case1;
									}
									errCount = 0;
								}
								
								if(r+i < 10 && c+i < 10) {
									case1_4:
										for(int ri = 0 ; ri <= i ; ri++) {
											for(int ci = ri ; ci <= i ; ci++) {
												if(arr[r+ri][c+ci] == 0) {
													errCount++;
													break case1_4;
												}
											}
										}
									if(errCount == 0) {
										ans[0] += r; ans[1] += c;
										ans[2] += r; ans[3] += c+i;
										ans[4] += r+i; ans[5] += c+i;
										break case1;
									}
									errCount = 0;
								}
								
								break case1;
							}
						}
					}
				}
			}
		}
		
		case2:
			for(int i = 1 ; i < case2.length ; i++) {
				if(sum == case2[i]) {
					for(int r = 0 ; r < 10 ; r++) {
						for(int c = 0 ; c < 10 ; c++) {
							if(arr[r][c] == 1) {
								if(c == 9 || arr[r][c+1] == 1) {
									if(r+i < 10 && c+i*2 < 10) {
										case2_1:
											for(int ri = 0 ; ri <= i ; ri++) {
												for(int ci = ri ; ci <= i*2 - ri ; ci++) {
													if(arr[r+ri][c+ci] == 0) {
														errCount++;
														break case2_1;
													}
												}
											}
										if(errCount == 0) {
											ans[0] += r; ans[1] += c;
											ans[2] += r; ans[3] += c+i*2;
											ans[4] += r+i; ans[5] += c+i;
											break case2;
										}
										errCount = 0;
									}
									
									break case2;
								}
								
								else {
									if(r+i < 10 && c-i >= 0 && c+i < 10) {
										case2_2:
											for(int ri = 0 ; ri <= i ; ri++) {
												for(int ci = -ri ; ci <= ri ; ci++) {
													if(arr[r+ri][c+ci] == 0) {
														errCount++;
														break case2_2;
													}
												}
											}
										if(errCount == 0) {
											ans[0] += r; ans[1] += c;
											ans[2] += r+i; ans[3] += c-i;
											ans[4] += r+i; ans[5] += c+i;
											break case2;
										}
										errCount = 0;
									}
									
									if(r+i*2 < 10 && c-i >= 0) {
										case2_3:
											for(int ri = 0 ; ri <= i*2 ; ri++) {
												if(ri < i) {
													for(int ci = 0 ; ci <= ri ; ci++) {
														if(arr[r+ri][c-ci] == 0) {
															errCount++;
															break case2_3;
														}
													}
												}
												else {
													for(int ci = 0 ; ci <= i*2 - ri ; ci++) {
														if(arr[r+ri][c-ci] == 0) {
															errCount++;
															break case2_3;
														}
													}
												}
											}
										if(errCount == 0) {
											ans[0] += r; ans[1] += c;
											ans[2] += r+i; ans[3] += c-i;
											ans[4] += r+i*2; ans[5] += c;
											break case2;
										}
										errCount = 0;
									}
									
									if(r+i*2 < 10 && c+i < 10) {
										case2_4:
											for(int ri = 0 ; ri <= i*2 ; ri++) {
												if(ri < i) {
													for(int ci = 0 ; ci <= ri ; ci++) {
														if(arr[r+ri][c+ci] == 0) {
															errCount++;
															break case2_4;
														}
													}
												}
												else {
													for(int ci = 0 ; ci <= i*2 - ri ; ci++) {
														if(arr[r+ri][c+ci] == 0) {
															errCount++;
															break case2_4;
														}
													}
												}
											}
										if(errCount == 0) {
											ans[0] += r; ans[1] += c;
											ans[2] += r+i; ans[3] += c+i;
											ans[4] += r+i*2; ans[5] += c;
											break case2;
										}
										errCount = 0;
									}
									
									break case2;
								}
							}
						}
					}
				}
			}
		
		if(ans[4] == 1) {
			System.out.println(0);
		}
		
		else {
			for(int i = 0 ; i < 6 ; i++) {
				System.out.print(ans[i]+" ");
				if(i % 2 == 1) {
					System.out.println();
				}
			}
		}
		
	}
}
