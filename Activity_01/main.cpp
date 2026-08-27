#include <iostream>
#include <vector>
#include "ArrayOps.h"

int main() {
    std::vector numArray = ArrayOps::generateArray(100000, 100000);

    // ArrayOps::bubble(numArray);
    // ArrayOps::selection(numArray);
    ArrayOps::insertion(numArray);

    std::cout << "Sorted: ";
    // ArrayOps::print(numArray);

    return 0;
}