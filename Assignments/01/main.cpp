#include <vector>
#include <iostream>

#include "Sorts/MergeSort.h"
#include "Sorts/QuickSort.h"
#include "Sorts/RadixSort.h"
#include "Sorts/StaticSorts.h"
#include "Utils/Timer.h"
#include "Utils/Utils.h"

int main() {
    std::vector<int> arr = Utils::generateArray(1000000, 10000);

    std::cout << "Unsorted: " << std::endl;;
    // Utils::print(arr);

    auto t = Timer();
    t.Start();

    RadixSort rs(arr);

    std::cout << "Elapsed time: " << t.Stop() << std::endl;

    std::cout << "Sorted: " << std::endl;
    // Utils::print(arr);

    return 0;
}
