/**
 * Created by student on 29.09.2014.
 */
public class life {
    public static void main(String[] args) {
        boolean[][] mask = new boolean[100][100];
        mask[11][11] = true;
        mask[12][12] = true;
        mask[13][12] = true;
        mask[13][11] = true;
        mask[13][10] = true;
        Display d = new Display();
        d.setMask(mask);
        while (true) {
            boolean[][] mask1 = new boolean[100][100];
            for (int y = 1; y < 99; y++) {
                for (int x = 1; x < 99; x++) {
                    int count = 0;
                    for (int y1 = y - 1; y1 <= y + 1; y1++) {
                        for (int x1 = x - 1; x1 <= x + 1; x1++) {
                            if (x1 == x && y1 == y) {
                                continue;
                            }
                            if (mask[y1][x1]) {
                                count++;
                            }
                        }
                    }
                    if (mask[y][x] &&(count == 2 || count == 3)) {
                        mask1[y][x]= mask[y][x];
                    }
                    if (mask[y][x] && (count < 2 || count > 3)) {
                        mask1[y][x] = false;
                    }
                    if (!mask[y][x] && count == 3) {
                        mask1[y][x] = true;
                    }
                }
            }
            mask=mask1;
            d.setMask(mask);
        }
    }
}