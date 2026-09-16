#ifndef INC_01_QUICKSORT_H
#define INC_01_QUICKSORT_H

#include <vector>

class QuickSort {
private:
    std::vector<int> &arr;

public:
    QuickSort(std::vector<int> &passedArr);
private:
    void qs(int lowIdx, int highIdx);
};


#endif //INC_01_QUICKSORT_H
