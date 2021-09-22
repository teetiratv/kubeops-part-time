import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer servers = scanner.nextInt();
        Integer tasks = scanner.nextInt();
        scanner.close();

        List<Integer> v = new ArrayList<>();
        for(int i = 0;i < tasks;i++) {
            v.add(i);
        }

        List<List<Integer>> lists = group(v,servers);
        System.out.println(lists);

    }

    public static List<List<Integer>> group(List<Integer> input, final Integer serverCount) {
        List<List<Integer>> servers = IntStream.range(0, serverCount)
          .mapToObj(i -> new ArrayList<Integer>())
          .collect(Collectors.toList());
         
        for (int i = 0; i < input.size(); i++) {
          System.out.println(i % serverCount + " " + input.get(i));
          servers.get(i % serverCount).add(input.get(i));
        }
        return servers;
      }
   
}

