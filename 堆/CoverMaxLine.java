/*
* 最大线段重合问题
* */
public class CoverMax {
    // 暴力枚举
    // 这个二维数组表示的含义是lines[i][0]是起始位置，lines[i][1]是结束位置
    public static int maxCover1(int[][] lines) {
        // 找到线段包括的最小值和最大值
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < lines.length; i++) {
            min = Math.min(min, lines[i][0]);
            max = Math.max(max, lines[i][1]);
        }
        int cover = 0;
        // 从0.5的位置开始穷举
        for (double p = min + 0.5; p < max; p += 1) {
            // 针对每一个点对所有线段进行穷举
            int cur = 0;
            for (int i = 0; i < lines.length; i++) {
                if (lines[i][0] < p && lines[i][1] > p) {
                    cur++;
                }
            }
            cover = Math.max(cover, cur);
        }
        return cover;
    }

    public static int maxCover2(int[][] m) {
        Line[] lines = new Line[m.length];
        for (int i = 0; i < m.length; i++) {
            lines[i] = new Line(m[i][0], m[i][1]);
        }
        Arrays.sort(lines, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.start - o2.start;
            }
        });
        // 使用默认的小根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < lines.length; i++) {
            // 如果小于前面的数字的，就要把它从小根堆里面剔除
            while (!heap.isEmpty() && heap.peek() <= lines[i].start) {
                heap.poll();
            }
            heap.add(lines[i].end);
            max = Math.max(max, heap.size());
        }
        return max;
    }

    public static class Line {
        public int start;
        public int end;
        public Line(int s, int e) {
            start = s;
            end = e;
        }
    }
}
