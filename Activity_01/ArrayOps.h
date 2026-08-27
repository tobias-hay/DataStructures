#ifndef ACTIVITY_01_ARRAYOPS_H
#define ACTIVITY_01_ARRAYOPS_H

#include <vector>

class ArrayOps {
public:
    static void print(const std::vector<int>& array);
    static std::vector<int> generateArray(int length, int max);
    static void bubble(std::vector<int>&array);
};


#endif //ACTIVITY_01_ARRAYOPS_H