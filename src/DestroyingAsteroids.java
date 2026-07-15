import java.util.Arrays;

public class DestroyingAsteroids {
    public static void main(String[] args) {
        int[] asteroids = {3,9,19,5,21};
        int mass = 10;
        System.out.println(asteroidsDestroyed(mass, asteroids));
    }
    static boolean asteroidsDestroyed(int mass, int[] asteroids){
        long totalMass = mass;
        Arrays.sort(asteroids);
        for(int asteroid : asteroids){
            if(asteroid <= totalMass){
                totalMass += asteroid;
            }else {
                return false;
            }
        }
        return true;
    }
}
