package day37;

/**
 * 1529. 灯泡开关 IV
 * medium
 */
public class LightFlips {
    public int minFlips(String target) {
        char[] cs = target.toCharArray();
        int times = 0;
        for (int i = 0; i < cs.length; i++) {
            if (i == 0 && cs[i] == '1') {
                times = 1;
            }
            if (i > 0 && cs[i] != cs[i-1]) {
                times++;
            }
        }
        return times;
    }
}
