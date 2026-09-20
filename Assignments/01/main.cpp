#include <vector>
#include <iostream>

#include "Sorts/MergeSort.h"
#include "Sorts/QuickSort.h"
#include "Sorts/RadixSort.h"
#include "Sorts/StaticSorts.h"
#include "Utils/Utils.h"

int main() {
    std::vector<int> arr = Utils::generateArray(10, 10000);

    std::cout << "Unsorted: ";
    Utils::print(arr);

    RadixSort rs(arr);

    std::cout << "Sorted: ";
    Utils::print(arr);

    return 0;
}
