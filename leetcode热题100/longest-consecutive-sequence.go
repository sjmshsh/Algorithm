func longestConsecutive(nums []int) int {
    numSet := map[int]bool{}
    for _, num := range nums {
        numSet[num] = true   
    }
    longestSteak := 0
    // 遍历set
    for num := range numSet {
        // 判断x-1是否存在于set当中
        if !numSet[num - 1] {
            // 如果不存在于set当中, 从0开始计数, 代表它是起始位置
            curNum := num
            curSteak := 0
            for numSet[curNum] {
                curNum++
                curSteak++
            }
            if curSteak > longestSteak {
                longestSteak = curSteak
            }
        }
    }
    return longestSteak
}
