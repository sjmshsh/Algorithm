public class trieTree {
    // 前缀树节点类型
    public static class Node1 {
        public int pass;
        public int end;
        public Node1[] nexts;


        // char tmp = 'a'; (tmp - 'a')
        public Node1() {
            pass = 0;
            end = 0;
            // 0   a
            // 1   b
            // 2   c
            // ..  ..
            // 25  z
            // nexts[i] == null
            // nexts[i] != null i方向的路存在
            nexts = new Node1[26]; //这里默认只放字符串
        }

        public static class Trie1 {
            private Node1 root;

            public Trie1() {
                root = new Node1();
            }

            public void insert(String word) {
                if (word == null) {
                    return;
                }
                char[] str = word.toCharArray();
                Node1 node = root;
                node.pass++;
                int path = 0;
                for (int i = 0; i < str.length; i++) {
                    path = str[i] - 'a'; //由字符确定走哪条路
                    if (node.nexts[path] == null) {
                        node.nexts[path] = new Node1();
                    }
                    node = node.nexts[path];
                    node.pass++;
                }
                node.end++;
            }

            public void delete(String word) {
                if (search(word) != 0) {
                    char[] chs = word.toCharArray();
                    Node1 node = root;
                    node.pass--;
                    int path = 0;
                    for (int i = 0; i < chs.length; i++) {
                        path = chs[i] - 'a';
                        if (--node.nexts[path].pass == 0) {
                            node.nexts[path] = null;
                            return;
                        }
                        node = node.nexts[path];
                    }
                    node.end--;
                }
            }

            // word这个单词之前加入过几次
            public int search(String word) {
                if (word == null) {
                    return 0;
                }
                char[] chs = word.toCharArray();
                Node1 node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
                return node.end;
        }

            // 所有加入的字符串中，有几分是以pre这个字符串为前缀的
            public int prefixNumber(String pre) {
                if (pre == null) {
                    return 0;
                }
                char[] chs = pre.toCharArray();
                Node1 node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (node.nexts[index] == null) {
                        return 0;
                    }
                    node = node.nexts[index];
                }
                return node.pass;
            }
        }
    }
}
