#include <vector>
#include <iostream>

#include "Sorts/MergeSort.h"
#include "Sorts/QuickSort.h"
#include "Sorts/StaticSorts.h"
#include "Utils/Utils.h"

int main() {
    std::vector<int> arr = Utils::generateArray(20, 20);

    std::cout << "Unsorted: ";
    Utils::print(arr);

    MergeSort ms(arr);

    std::cout << "Sorted: ";
    Utils::print(arr);

    return 0;
}
