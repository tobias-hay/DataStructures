#include "QuickSort.h"

#include "../Utils/Utils.h"

QuickSort::QuickSort(std::vector<int> &passedArr) : arr(passedArr) {
    qs(0, passedArr.size() - 1);
}

void QuickSort::qs(int lowIdx, int highIdx) {
    if (lowIdx >= highIdx)
        return;

    int pivot = arr[highIdx];
    int counter = lowIdx;

    for (int i = lowIdx; i < highIdx; i++) {
        if (arr[i] < pivot) {
            Utils::swap(arr, i, counter);
            counter++;
        }
    }

    Utils::swap(arr, counter, highIdx);

    qs(lowIdx, counter - 1);
    qs(counter + 1, highIdx);
}
