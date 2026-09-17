#include <iostream>

#include "LinkedList.h"

int main() {
    LinkedList<int> li1;

    li1.addFront(10);
    li1.addFront(20);
    li1.addFront(30);

    std::cout << "Size: " << li1.size() << std::endl;

    std::cout << "Remove: " << li1.removeBack().value_or(-1) << std::endl;

    std::cout << "Front: " << li1.getFront() << std::endl;
    std::cout << "Size: " << li1.size() << std::endl;

    return 0;
}
