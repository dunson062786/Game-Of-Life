    
import java.io.*;

public class GOL {

    public static String boardToString(boolean[][] board, int xsize, int ysize) {
        StringBuffer sb = new StringBuffer();  // used to print out the board at the end
        for (int j = 0; j < ysize; j++) {
            for (int i = 0; i < xsize; i++) {
                if (board[j][i]) {
                    sb.append('*');
                } else {
                    sb.append(' ');
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static boolean[][] strToBoolMatrix(String str, int xsize, int ysize) {
        boolean[][] board = new boolean[ysize][xsize];  // converts an input string into the
        // boolean[][] used internally
        for (int j = 0; j < ysize; j++) {
            for (int i = 0; i < xsize; i++) {
                board[j][i] = str.charAt((j * xsize) + i) != '0';
            }
        }
        return board;
    }

    public static int getNeighborCount(boolean[][] board, int x, int y, int xsize, int ysize) {
        int nc = 0;
        if (y > 0) {
            if (x > 0) {
                if (board[y - 1][x - 1]) {
                    nc++;
                }
            }
            if (board[y - 1][x]) {
                nc++;
            }
            if (x < xsize - 1) {
                if (board[y - 1][x + 1]) {
                    nc++;
                }
            }
        }
        if (x > 0) {
            if (board[y][x - 1]) {
                nc++;
            }
        }
        if (x < xsize - 1) {
            if (board[y][x + 1]) {
                nc++;
            }
        }
        if (y < ysize - 1) {
            if (x > 0) {
                if (board[y + 1][x - 1]) {
                    nc++;
                }
            }
            if (board[y + 1][x]) {
                nc++;
            }
            if (x < xsize - 1) {
                if (board[y + 1][x + 1]) {
                    nc++;
                }
            }
        }
        return nc;
    }

    public static boolean getDot(boolean[][] board, int x, int y, int xsize, int ysize) {
        // this function applies the rules of the game on one square

        return board[y][x] && getNeighborCount(board, x, y, xsize, ysize) == 2
                || getNeighborCount(board, x, y, xsize, ysize) == 3;
    }

    public static void main(String[] args) throws Exception {
        int xsize = Integer.parseInt(args[0]);  // takes board size off command line
        int ysize = Integer.parseInt(args[1]);
        int gen = Integer.parseInt(args[2]);    // number of generations
        BufferedReader br = new BufferedReader(new FileReader(args[3]));
        StringBuffer sb = new StringBuffer();
        String line = new String(br.readLine());
        while (line != null) { // reading file
            sb.append(line);
            line = br.readLine();
        }
        String s = sb.toString();
        boolean[][] board = strToBoolMatrix(s, xsize, ysize); // this is the game board
        for (int i = 0; i < gen; i++) {  // loops through the generations
            boolean[][] next = new boolean[ysize][xsize];  // empty board
            for (int j = 0; j < ysize; j++) {
                for (int k = 0; k < xsize; k++) {
                    next[j][k] = getDot(board, k, j, xsize, ysize);
                }
            }
            board = next;    // use the 'next' array as the new 'board' array
        }
        System.out.println(boardToString(board, xsize, ysize)); // prints the board
    }
}
