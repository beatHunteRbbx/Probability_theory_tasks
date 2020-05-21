public class Task16_11 {

    /**
     * Случайные величины X и Y связаны соотношением mX+nY=c, где m,n и c – неслучайные величины (m≠0,n≠0)
     * Найти:
     * 	а) коэффициент корреляции r_xy
     * 	б) отношение среднеквадратических отклонений σ_x/σ_y
     * */

    public static void solve() {
        for (int i = 0; i < 5; i++) {
            calculate(  getRandomIntegerBetweenRange(-10, 10),
                        getRandomIntegerBetweenRange(-10, 10));
        }
    }

    private static void calculate(double m, double n) {
        //расчёт коэффициента корреляции
        double r = 0.0;
        if (n/m < 0) r = 1;
        if (n/m > 0) r = -1;

        //расчёт отнощения среднеквадратических отклонений
        double sigma = Math.abs(n/m);

        System.out.println("m=" + m + ", n=" + n + ":");
        System.out.println("    r_XY =" + r + "     σ_x/σ_y=" + sigma);
        System.out.println();
    }

    private static int getRandomIntegerBetweenRange(int min, int max){
        int answer;
        do {
            answer = (int) (Math.random()*((max-min)+1))+min;
        } while (answer == 0);
        return answer;
    }

}
