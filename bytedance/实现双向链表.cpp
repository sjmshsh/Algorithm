#include <algorithm>
#include <unordered_map>

using namespace std;

class Node {
public:
	int key, val;
	Node* next;
	Node* prev;
	Node(int k, int v) {
		this->key = k;
		this->val = v;
	}
};

class DoubleList {
private:
	// 头尾虚节点
	Node* head;
	Node* tail;
	int size; // 链表元素个数
public:

	DoubleList() {
		// 初始化双向链表的数据
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head->next = tail;
		tail->prev = head;
		size = 0;
	}

	int getSize() {
		return this->size;
	}

	// 在链表尾部添加节点
	void addLast(Node* x) {
		x->prev = tail->prev;
		x->next = tail;
		tail->prev->next = x;
		tail->prev = x;
		size++;
	}

	// 删除链表中的x节点
	// 由于是双向链表且给的是目标Node节点, 时间O(1)
	Node* remove(Node* x) {
		x->prev->next = x->next;
		x->next->prev = x->prev;
		size--;
	}

	// 删除链表中的第一个节点, 并返回该节点, 时间O(1)
	Node* removeFirst() {
		if (head->next == tail) {
			return nullptr;
		}
		Node* first = head->next;
		remove(first);
		return first;
	}
};
