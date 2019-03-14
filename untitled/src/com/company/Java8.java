package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java8 {

    public static class Sample {
        public int score;
        public int type;
        public Sample(int score, int type) {
            this.type = type;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Sample{" +
                    "score=" + score +
                    ", type=" + type +
                    '}';
        }
    }

    public static void main(String[] args) throws Exception {
        List<Sample> samples = Arrays.asList(
                new Sample(90, 1),
                new Sample(80, 1),
                new Sample(80, 1),
                new Sample(70, 2),
                new Sample(60, 2),
                new Sample(50, 3));

        // 简单分组
        // {1=[Sample{score=90, type=1}, Sample{score=80, type=1}, Sample{score=80, type=1}], 2=[Sample{score=70, type=2}, Sample{score=60, type=2}], 3=[Sample{score=50, type=3}]}
        System.out.println("简单分组-------------------------");
        Map<Integer, List<Sample>> one = samples.stream().collect(Collectors.groupingBy(x -> x.type));
        System.out.println(one);

        // 二级分组，先按类别分组，再按分数分组
        // {1={80=[Sample{score=80, type=1}, Sample{score=80, type=1}], 90=[Sample{score=90, type=1}]}, 2={70=[Sample{score=70, type=2}], 60=[Sample{score=60, type=2}]}, 3={50=[Sample{score=50, type=3}]}}
        System.out.println("先按类别分组，再按分数分组-------------------------");
        Map<Integer, Map<Integer, List<Sample>>> second = samples.stream().collect(Collectors.groupingBy(x -> x.type, Collectors.groupingBy(x -> x.score)));
        System.out.println(second);
        // 配合其余Collectors里的接口使用
        // 分组后求和
        // {1=250, 2=130, 3=50}
        System.out.println("分组后求和-------------------------");
        Map<Integer, Integer> third = samples.stream().collect(Collectors.groupingBy(x -> x.type, Collectors.summingInt(x -> x.score)));
        System.out.println(third);
        // 分组后获取最大值
        // {1=Optional[Sample{score=90, type=1}], 2=Optional[Sample{score=70, type=2}], 3=Optional[Sample{score=50, type=3}]}
        System.out.println("分组后获取最大值-------------------------");
        Map<Integer, Optional<Sample>> forth = samples.stream().collect(Collectors.groupingBy(x -> x.type, Collectors.maxBy((x, y) -> x.score - y.score)));
        System.out.println(forth);
        // 分组后reduce
        // {1=Optional[250], 2=Optional[130], 3=Optional[50]}
        System.out.println("分组后reduce-------------------------");
        Map<Integer, Optional<Integer>> fifth = samples.stream().collect(Collectors.groupingBy(x -> x.type, Collectors.mapping(x -> x.score, Collectors.reducing((x, y) -> x + y))));//参数有2个x y，返回和
        System.out.println(fifth);
    }
}

