import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FailRatio {

  public static void main(String[] args) {
   // int[] stages = {4,4,4,4,4};
    int[] stages = {1, 1, 2, 2, 3, 5};
   //  int[] stages = {1, 1, 1, 1, 1};
   //  int[] stages = {5, 5, 5, 5, 5};
    int[] solution = solution(4, stages);
    System.out.println("answer : ");
    System.out.println(Arrays.toString(solution));

  }
  public static int[] solution(int N, int[] stages) {
    int[] answer = new int[N];
    Map<String, Long> stageMap = Arrays.stream(stages)
        .filter(stage -> stage <= N)
        .mapToObj(String::valueOf)
        .collect(groupingBy(Function.identity(), Collectors.counting()));

    System.out.println("stage group by : ");
    System.out.println(stageMap);

    Map<String, Double> failRatioMap = new HashMap<>();

    int challenger = stages.length;
    for(int i = 1; i <= N; i++) {

      if (stageMap.get(Integer.toString(i)) != null){
        Double failRatio = stageMap.get(Integer.toString(i)) / (double) challenger;
        challenger -= stageMap.get(Integer.toString(i));
        failRatioMap.put(Integer.toString(i), failRatio);
      } else {
        failRatioMap.put(Integer.toString(i), 0d);
      }

    }

    System.out.println("fail ratio by stage : ");
    System.out.println(failRatioMap);

    List<String> setList = new ArrayList<>(failRatioMap.keySet());

    Collections.sort(setList, ((o1, o2) -> (failRatioMap.get(o2).compareTo(failRatioMap.get(o1)))));

    return setList.stream().map(Integer::parseInt).mapToInt(Integer::intValue).toArray();
  }
}
