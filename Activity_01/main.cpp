#include <iostream>
#include <vector>
#include "ArrayOps.h"

int main() {
    std::vector numArray = ArrayOps::generateArray(50, 200);

    // ArrayOps::bubble(numArray);
    // ArrayOps::selection(numArray);
    // ArrayOps::insertion(numArray);
    ArrayOps::qs(numArray, 0, numArray.size() - 1);

    std::cout << "Sorted: ";
    // ArrayOps::print(numArray);

    return 0;
}