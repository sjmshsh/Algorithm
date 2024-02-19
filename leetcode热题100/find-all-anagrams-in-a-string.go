func findAnagrams(s string, p string) []int {
    res := []int{}
    need := make(map[byte]int)
	for i := 0; i < len(p); i++ {
        ch := p[i]
		need[ch]++
	}
    windows := make(map[byte]int)
    valid := 0 // 记录当前有效的字母有多少个
    // 定义左右指针
    left := 0
    right := 0
    n := len(s)
    for right < n && left < n {
        // 尝试扩张窗口
        ch := s[right]
        right++
        // 查看是否可以增加valid
        if need[ch] > 0 {
            // 如果这个字母在need里面存在
            windows[ch]++
            if (windows[ch] == need[ch]) {
                valid++
            }
        }
        // 尝试缩小左边的指针
        for right - left + 1 > len(p) {
            // 在缩小之前可以看看是否有结果已经满足了条件
            if valid == len(need) {
                res = append(res, left)
            }
            l := s[left]
            left++
            // 判断valid是否需要减少
            if need[l] > 0 {
                if windows[l] == need[l] {
                    valid--
                }
                windows[l]--
            }
        }
    }
    return res
}
