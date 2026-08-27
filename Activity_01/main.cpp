#include <iostream>
#include <vector>
#include "ArrayOps.h"

int main() {
    std::vector numArray = ArrayOps::generateArray(10, 10);

    // ArrayOps::bubble(numArray);
    ArrayOps::selection(numArray);

    std::cout << "Sorted: ";
    ArrayOps::print(numArray);

    return 0;
}