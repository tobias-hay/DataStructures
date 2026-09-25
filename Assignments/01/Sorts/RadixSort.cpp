#include <cmath>
#include <iostream>

#include "RadixSort.h"

#include "../Utils/Utils.h"

RadixSort::RadixSort(std::vector<int> &passedArr) : arr(passedArr) {
    rs(true);
}

void RadixSort::rs(bool first) {
    if (!first && check == maxDigits)
        return;

    for (int num : arr) {
        int digCount = num == 0 ? 1 : static_cast<int>(std::log10(std::abs(num))) + 1;
        if (digCount > maxDigits) maxDigits = digCount;

        int bucket = (num % static_cast<int>(std::pow(10, check + 1))) / static_cast<int>(std::pow(10, check));
        buckets[bucket].push_back(num);
    }

    int pos = 0;
    for (std::vector<int> &buc : buckets) {
        for (int num : buc) {
            arr[pos++] = num;
        }

        buc.clear();
    }

    check++;
    rs(false);
}
