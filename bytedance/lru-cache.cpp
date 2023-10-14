struct Node {
    int k;
    int v;
    Node* prev;
    Node* next;

    Node()
        : k(0)
        , v(0)
        , prev(nullptr)
        , next(nullptr) {}
    
    Node(int key, int val)
        : k(key)
        , v(val)
        , prev(nullptr)
        , next(nullptr) {}
};

class LRUCache {
public:
    LRUCache(int capacity) 
        : cap(capacity)
        , size(0) {
        head = new Node();
        tail = new Node();
        head->next = tail;
        tail->prev = head;
    }
    
    int get(int key) {
        // 如果没有找到这个key的话直接返回-1就可以了
        if (!cache.count(key)) {
            return -1;
        }
        Node* node = cache[key];
        moveToHead(node);
        return node->v;
    }
    
    void put(int key, int value) {
        if (cache.count(key)) {
            // 如果有这个key的话
            Node* node = cache[key];
            node->v = value;
            moveToHead(node);
        } else {
            // 没有
            Node* node = new Node(key, value);
            cache[key] = node;
            addToHead(node);
            ++size;
            if (size > cap) {
                node = removeTail();
                cache.erase(node->k);
                --size;
            }
        }
    }

private:
    unordered_map<int, Node*> cache;
    Node* head;
    Node* tail;
    int cap;
    int size;

    void moveToHead(Node* x) {
        removeNode(x);
        addToHead(x);
    }

    void removeNode(Node* x) {
        x->prev->next = x->next;
        x->next->prev = x->prev;
    }

    Node* removeTail() {
        Node* node = tail->prev;
        removeNode(node);
        return node;
    }

    void addToHead(Node* x) {
        x->next = head->next;
        x->prev = head;
        head->next = x;
        x->next->prev = x;
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */
