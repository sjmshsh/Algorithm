public class ReturnGroup {

    static class Binary {
        public int firstIndex;
        public int secondIndex;
    }

    // left和right是我指定的binaryReturn的范围  [left, right)
    public static ArrayList<Binary> binaryReturn(int[] arr, int aim, int left, int right) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ArrayList<Binary> list = new ArrayList<>();
        int N = arr.length;
        int L = left;
        int R = right;
        for (int i = left; i < right; i++) {
            if (arr[L] + arr[R] < aim) {
                L++;
            } else if (arr[L] + arr[R] > aim) {
                R--;
            } else {
                if (arr[L] == arr[L - 1]) {
                    L++;
                } else {
                    Binary binary = new Binary();
                    binary.firstIndex = L;
                    binary.secondIndex = R;
                    list.add(binary);
                }
            }
        }
        return list;
    }

    static class Triples {
        public int firstIndex;
        public int secondIndex;
        public int thirdIndex;
    }
    
    public static ArrayList<Triples> triplesReturn(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ArrayList<Triples> list = new ArrayList<>();
        int N = arr.length;
        int L = 0;
        for (int i = 0; i < N; i++) {
            if (L > 0 && arr[L] != arr[L - 1]) {
                int target = aim - arr[L];
                ArrayList<Binary> binaries = binaryReturn(arr, target, L + 1, N);
                for (int j = 0; j < binaries.size(); j++) {
                    Triples triples = new Triples();
                    triples.firstIndex = i;
                    triples.secondIndex = binaries.get(j).firstIndex;
                    triples.thirdIndex = binaries.get(j).secondIndex;
                    list.add(triples);
                }
            }
        }
        return list;
    }
}
