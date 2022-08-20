class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int res = 0;
        int L = 0;
        int R = n - 1;
        while (L <= R) {
            if (people[L] + people[R] <= limit) {
                L++;
            }
            R--;
            res++;
        }
        return res;
    }
}
