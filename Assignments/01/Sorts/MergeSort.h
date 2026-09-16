
#ifndef INC_01_MERGESORT_H
#define INC_01_MERGESORT_H

#include <vector>

class MergeSort {
private:
    std::vector<int> tempArr;
    std::vector<int> &arr;

public:
    MergeSort(std::vector<int> &passedArr);
private:
    void split(int lowIdx, int highIdx);
    void merge(int lowIdx, int midIdx, int highIdx);
};


#endif //INC_01_MERGESORT_H
