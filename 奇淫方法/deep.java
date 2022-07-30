public static int deep (String s) {
    char[] str = s.toCharArray();
    if (!valid(s)) {
        return 0;
    }
    int count = 0;
    int max = 0;
    for (int i = 0; i < str.length; i++) {
        if (str[i] == '(') {
            max = Math.max(max, ++count);
        } else {
            count--;
        }
    }
    return max;
}
