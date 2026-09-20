
#ifndef INC_01_RADIXSORT_H
#define INC_01_RADIXSORT_H

#include <vector>

class RadixSort {
private:
    std::vector<int> &arr;
    std::vector<int> buckets[10];
    int maxDigits = 0;
    int check = 0;

public:
    RadixSort(std::vector<int> &passedArr);
private:
    void rs(bool first);
};


#endif //INC_01_RADIXSORT_H
