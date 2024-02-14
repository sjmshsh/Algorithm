// https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&envId=top-100-liked

func groupAnagrams(strs []string) [][]string {
    // 排序解法
    mp := map[string][]string{}
    for _, str := range strs {
        // 把字符串转换成byte数组方便排序
        b := []byte(str)
        sort.Slice(b, func (i, j int) bool { return b[i] < b[j] })
        // 把byte数组转换回字符串
        sortedStr := string(b)
        mp[sortedStr] = append(mp[sortedStr], str)
    }
    // []string的元素个数是指map的key value的键值对数量
    ans := make([][]string, 0, len(mp))
    for _, v := range mp {
        ans = append(ans, v)
    }
    return ans
}
