package Leetcode3001;

public class Solution {
    public static void main(String[] args) {
        int a = 4, b = 3, c = 3, d = 4, e = 5, f = 2;
        System.out.println(new Solution().minMovesToCaptureTheQueen2(a,b,c,d,e,f));
    }
    int[] rook;
    int[] bishop;
    int[] queen;
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        rook = new int[]{a, b};
        bishop = new int[]{c, d};
        queen = new int[]{e, f};
        if (rook[0] == queen[0]) {

            if (!(bishop[0] == rook[0] &&
                    bishop[1] > Math.min(rook[1], queen[1]) &&
                    bishop[1] < Math.max(rook[1], queen[1]))) {

                return 1;
            }
        }
        if (rook[1] == queen[1]) {

            if (!(bishop[1] == rook[1] &&
                    bishop[0] > Math.min(rook[0], queen[0]) &&
                    bishop[0] < Math.max(rook[0], queen[0]))) {

                return 1;
            }
        }
        if (Math.abs(bishop[0] - queen[0]) == Math.abs(bishop[1] - queen[1])) {

            if (bishop[0] < queen[0] && bishop[1] < queen[1]) {

                if (move(bishop[0], bishop[1], 1, 1))
                    return 1;
            }

            if (bishop[0] < queen[0] && bishop[1] > queen[1]) {

                if (move(bishop[0], bishop[1], 1, -1))
                    return 1;
            }

            if (bishop[0] > queen[0] && bishop[1] < queen[1]) {

                if (move(bishop[0], bishop[1], -1, 1))
                    return 1;
            }

            if (bishop[0] > queen[0] && bishop[1] > queen[1]) {

                if (move(bishop[0], bishop[1], -1, -1))
                    return 1;
            }
        }
        return 2;
    }
    private boolean move(int r, int c, int dr, int dc) {
        while (true) {
            r += dr;
            c += dc;
            if (r < 1 || r > 8 || c < 1 || c > 8)
                return false;
            if (r == rook[0] && c == rook[1])
                return false;
            if (r == queen[0] && c == queen[1])
                return true;
        }
    }
    public int minMovesToCaptureTheQueen2(int a, int b, int c, int d, int e, int f) {
        if (a == e) {
            if (!(c == a &&
                    d > Math.min(b, f) &&
                    d < Math.max(b, f))) {
                return 1;
            }
        }

        if (b == f) {
            if (!(d == b &&
                    c > Math.min(a, e) &&
                    c < Math.max(a, e))) {
                return 1;
            }
        }

        if (Math.abs(c - e) == Math.abs(d - f)) {
            if (!(Math.abs(a - c) == Math.abs(b - d) &&
                    Math.abs(a - e) == Math.abs(b - f) &&
                    a > Math.min(c, e) &&
                    a < Math.max(c, e) &&
                    b > Math.min(d, f) &&
                    b < Math.max(d, f))) {
                return 1;
            }
        }

        return 2;
    }
}
