#include <iostream>

#include "LinkedList.h"


int main() {
    LinkedList<int> li1;

    // li1.addFront(10);
    // li1.addFront(20);
    // li1.addFront(30);

    std::cout << "Size: " << li1.size() << std::endl;

    std::cout << "Front: " << li1.getFront() << std::endl;

    return 0;
}
