#include <iostream>
#include <vector>
#include "ArrayOps.h"

int main() {
    std::vector numArray = ArrayOps::generateArray(10, 10);

    ArrayOps::bubble(numArray);

    std::cout << "Sorted" << std::endl;

    return 0;
}