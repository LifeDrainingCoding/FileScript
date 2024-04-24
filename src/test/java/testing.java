import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class testing
{
    public static void main(String[] args) {
        ArrayList<Integer> ints =  new ArrayList<>();
        for (int i = 0 ; i<11;i++){
            ints.add(i);
        }
        ints.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        });
      ArrayList<String> parts =  new ArrayList<>(Arrays.asList("123456789".split("")));

   parts = new ArrayList<>(parts.stream().limit(4).toList());


       System.out.println(Arrays.deepToString(parts.toArray()));
       System.out.println(System.getProperty("user.dir"));

    }
}
