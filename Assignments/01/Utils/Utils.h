
#ifndef INC_01_UTILS_H
#define INC_01_UTILS_H

#include <vector>

class Utils {
public:
    static void print(const std::vector<int> &arr);
    static std::vector<int> generateArray(int length, int maxVal);
    static void swap(std::vector<int> &arr, int fromIdx, int toIdx);
};


#endif //INC_01_UTILS_H
