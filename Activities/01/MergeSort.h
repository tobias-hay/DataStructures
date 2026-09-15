#ifndef ACTIVITY_01_MERGESORT_H
#define ACTIVITY_01_MERGESORT_H

#include <vector>

class MergeSort {
private:
    std::vector<int> temp;
    std::vector<int> &array; // Global Scoped
    void split(int low, int high);
    void merge(int low, int mid, int high);
public:
    MergeSort(std::vector<int> &arr);
};


#endif //ACTIVITY_01_MERGESORT_H