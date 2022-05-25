    public void heapSort(int[] array) { // 堆排序,这个是我要排序的数组
        //先建立一个堆
        createHeap(array); //这个是大堆，所以我们排完序了之后是升序
        //定义end变量
        int end = usedSize - 1;
        while(end >= 0) {
            int temp = elem[0];
            elem[0] = elem[end];
            elem[end] = temp;
            shiftDown(0, end); //先调整后--
            end--;
        }
    }
