#ifndef ACTIVITY_00_ARRAYOPS_H
#define ACTIVITY_00_ARRAYOPS_H

#include <vector>

class ArrayOps {
public:
    static void print(const std::vector<int>& array);
    static bool isEmpty(const std::vector<int>& array);
    static std::vector<int> copy(const std::vector<int>& array);
    static bool isEqual(const std::vector<int>& arr1, const std::vector<int>& arr2);
    static std::vector<int> generateArray(int length, int max);
    static int max(const std::vector<int>& array);
    static int min(const std::vector<int>& array);
    static bool exists(const std::vector<int> &array, int val);
};


#endif //ACTIVITY_00_ARRAYOPS_H