func moveZeroes(nums []int)  {
    // 定义两个指针
    i := 0
    j := 0 // i在前, j在后
    n := len(nums)
    for i < n && j < n {
        if nums[j] != 0 {
            nums[i] = nums[j]
            i++
        }
        j++
    }
    for i < n {
        nums[i] = 0
        i++
    }
}
