#include "MergeSort.h"

void MergeSort::split(int low, int high) {
    // Base Case
    if (low == high)
        return;

    int mid = (low + high) / 2; // INT Division
    split(low, mid);
    split(mid + 1, high);

    merge(low, mid, high);
}

void MergeSort::merge(int low, int mid, int high) {
    int i = low;
    int j = mid + 1;
    int tempPos = low;

    while (i <= mid && j <= high) {
        if (array[i] <= array[j]) {
            temp[tempPos++] = array[i++]; // post-fix incrementer: USE, THEN increment
        } else {
            temp[tempPos++] = array[j++];
        }
    }

    // run out rest of left
    while (i <= mid) {
        temp[tempPos++] = array[i++];
    }

    // run out rest of right
    while (j <= high) {
        temp[tempPos++] = array[j++];
    }

    // Copy out sorted temp array to original aray
    for (tempPos = low; tempPos <= high; tempPos++) {
        array[tempPos] = temp[tempPos];
    }
}

MergeSort::MergeSort(std::vector<int>&arr) : array(arr) {
    temp.reserve(arr.size());

    split(0, arr.size() - 1);
}
