
#ifndef LINKED_LIST_LINKEDLIST_H
#define LINKED_LIST_LINKEDLIST_H

template <typename E>
class LinkedList {
private:
    class Node {
    public:
        Node(E obj);

        Node* next;
        E data;
    };

    Node* head;
    int currentSize;

public:
    LinkedList();

    int size() const;
    void addFront(E obj);
    E getFront();
};

template<typename E>
LinkedList<E>::Node::Node(E obj) {
    next = nullptr;
    data = obj;
}

template<typename E>
LinkedList<E>::LinkedList() {
    head = nullptr;
    currentSize = 0;
}

template<typename E>
int LinkedList<E>::size() const {
    return currentSize;
}

template<typename E>
void LinkedList<E>::addFront(E obj) {
    Node* node = new Node(obj);

    node->next = head;
    head = node;

    currentSize++;
}

template<typename E>
E LinkedList<E>::getFront() {
    if (head == nullptr) throw std::out_of_range("Linked List is Empty");

    return head->data;
}


#endif //LINKED_LIST_LINKEDLIST_H
