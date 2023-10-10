package main

import (
	"fmt"
	"sync"
)

func main() {
	wg := sync.WaitGroup{}
	ch1 := make(chan struct{}) // 同于通知奇数
	ch2 := make(chan struct{}) // 同于通知偶数
	i := 1

	// 打印奇数的协程
	go func() {
		for {
			select {
			case <-ch1:
				fmt.Println(i)
				i++
				ch2 <- struct{}{}
			}
		}
	}()

	wg.Add(1)
	// 打印偶数的协程
	go func(wait *sync.WaitGroup) {
		for {
			select {
			case <-ch2:
				if i == 100 {
					fmt.Println(i)
					wait.Done()
					return
				}
				fmt.Println(i)
				i++
				ch1 <- struct{}{}
			}
		}
	}(&wg)

	ch1 <- struct{}{}
	wg.Wait()
}
