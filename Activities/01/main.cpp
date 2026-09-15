#include <iostream>
#include <vector>
#include "ArrayOps.h"
#include "MergeSort.h"

int main() {
    std::vector numArray = ArrayOps::generateArray(10, 10);

    std::cout << "Unsorted: ";
    ArrayOps::print(numArray);

    // ArrayOps::bubble(numArray);
    // ArrayOps::selection(numArray);
    // ArrayOps::insertion(numArray);
    // ArrayOps::qs(numArray, 0, numArray.size() - 1);
    MergeSort ms(numArray);

    std::cout << "Sorted: ";
    ArrayOps::print(numArray);

    return 0;
}
