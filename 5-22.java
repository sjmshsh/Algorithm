    //这里仍然是大堆
	//向上调整
    private void shiftUp(int child) { //这里传的是我要向上调整的孩子的坐标
        int parent = (child - 1) / 2;
        while (child > 0) {
            if(elem[child] > elem[parent]) {
                int temp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = temp;
                child = parent;
                parent = (child - 1) / 2;
            } else {
                break;
            }
        }
    }

    public void offer(int val) {
        if(isFull()) { //扩容
            elem = Arrays.copyOf(elem, 2 * elem.length);
        }
        elem[usedSize++] = val;
        shiftUp(usedSize - 1);
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }
