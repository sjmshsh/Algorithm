/*
* 这里写个简化版本的
* */
public class Union {
    // 这里的parent存放的此节点下标的上级节点的下标
    private List<Integer> parent = new ArrayList<Integer>();
    // 用来存放关键节点底下有多少个节点
    private List<Integer> size = new ArrayList<>();
    // 模拟栈，用来压缩路径
    private List<Integer> help = new ArrayList<>();
    // 用来记录当前有多少个集合
    private int sets;

    // 初始化并查集，这里传进来一个数组
    public Union(int[] a) {
        sets = a.length;
        for (int i = 0; i < a.length; i++) {
            parent.add(i); // 这里代表的是当前下标的关键节点下标就是它自己
            size.add(1); // 而且数量必定为1
        }
    }

    // 找到当前下标的关键节点下标，i传的是当前节点的下标
    public int findFather(int i) {
        while (i != parent.get(i)) {
            i = parent.get(i);
            help.add(i); //记录当前的i
        }
        while (!help.isEmpty()) {
            parent.set(help.get(help.size() - 1), i);
            help.remove(help.size() - 1);
        }
        return i;
    }

    public boolean isSameFather(int i, int j) {
        return findFather(i) == findFather(j);
    }

    public int getSets() {
        return sets;
    }

    public void together(int i, int j) {
        int A = findFather(i);
        int B = findFather(j);
        if (A != B) {
            int big = size.get(A) > size.get(B) ? A : B;
            int small = size.get(A) > size.get(B) ? B : A;
            parent.set(small, big);
            size.set(big, big + small);
            size.set(small, 0);
            sets--;
        }
    }
}
