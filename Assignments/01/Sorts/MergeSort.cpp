
#include "MergeSort.h"

MergeSort::MergeSort(std::vector<int> &passedArr) : arr(passedArr) {
    tempArr.resize(passedArr.size());

    split(0, passedArr.size() - 1);
}

void MergeSort::split(int lowIdx, int highIdx) {
    if (lowIdx == highIdx)
        return;

    int midPoint = (lowIdx + highIdx) / 2;
    split(lowIdx, midPoint);
    split(midPoint + 1, highIdx);

    merge(lowIdx, midPoint, highIdx);
}

void MergeSort::merge(int lowIdx, int midIdx, int highIdx) {
    int i = lowIdx;
    int j = midIdx + 1;
    int tempPos = lowIdx;

    while (i <= midIdx && j <= highIdx) {
        if (arr[i] <= arr[j]) {
            tempArr[tempPos++] = arr[i++];
        } else {
            tempArr[tempPos++] = arr[j++];
        }
    }

    while (i <= midIdx) {
        tempArr[tempPos++] = arr[i++];
    }

    while (j <= highIdx) {
        tempArr[tempPos++] = arr[j++];
    }

    // Copy out sorted temp array to original aray
    for (tempPos = lowIdx; tempPos <= highIdx; tempPos++) {
        arr[tempPos] = tempArr[tempPos];
    }
}
