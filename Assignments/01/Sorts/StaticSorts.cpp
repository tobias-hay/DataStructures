
#include "StaticSorts.h"

#include "../Utils/Utils.h"

void StaticSorts::bubble(std::vector<int> &arr) {
    for (int i = 0; i < arr.size(); i++) {
        for (int j = 0; j < arr.size() - i - 1; j++) {
            if (arr[j] > arr[j + 1])
                Utils::swap(arr, j, j + 1);
        }
    }
}

void StaticSorts::selection(std::vector<int> &arr) {
    for (int i = 0; i < arr.size(); i++) {
        int minIndex = i;

        for (int j = i + 1; j < arr.size(); j++) {
            if (arr[minIndex] > arr[j])
                minIndex = j;
        }

        Utils::swap(arr, minIndex, i);
    }
}

void StaticSorts::insertion(std::vector<int> &arr) {
    for (int i = 1; i < arr.size(); i++) {
        int currVal = arr[i];
        int j = i - 1;

        while (j >= 0 && arr[j] > currVal) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = currVal;
    }
}

