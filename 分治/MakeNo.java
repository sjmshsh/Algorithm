public class MakeNo {
    public static int[] makeNo(int size) {
        if (size == 1) {
            return new int[] {1};
        }
        // size
        // 一半长达标来
        // 7 : 4
        // 8 : 4
        // [4个奇数] [3个偶数]
        int halfSize = (size + 1) / 2;  
        int[] base = makeNo(halfSize);
        // base -> 等长奇数达标来
        // base -> 等长偶数达标来
        int[] ans = new int[size];
        int index = 0;
        for (; index < halfSize; index++) {
            ans[index] = base[index] * 2 - 1;
        }
        for (int i = 0; index < size; index++, i++) {
            ans[index] = base[i] * 2;
        }
        return ans;
    }
}
