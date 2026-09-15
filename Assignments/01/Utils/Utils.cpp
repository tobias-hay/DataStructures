#include "Utils.h"

#include <iostream>
#include <vector>

void Utils::print(const std::vector<int> &arr) {
    std::cout << "[";

    for (int i = 0; i < arr.size(); i++) {
        std::cout << arr[i];
        if (i < arr.size() - 1) std::cout << ", ";
    }

    std::cout << "]" << std::endl;
}

std::vector<int> Utils::generateArray(int length, int maxVal) {
    std::vector<int> arr = {};
    arr.reserve(length);

    
}
