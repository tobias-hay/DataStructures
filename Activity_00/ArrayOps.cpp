#include "ArrayOps.h"

#include <vector>
#include <iostream>

void ArrayOps::print(const std::vector<int>& array) {
    std::cout << "[ ";

    for (int i = 0; i < array.size(); i++) {
        if (i != 0) std::cout << ", ";
        std::cout << array[i];
    }

    std::cout << " ]" << std::endl;
}

bool ArrayOps::isEmpty(const std::vector<int> &array) {
    return array.empty();
}

std::vector<int> ArrayOps::copy(const std::vector<int> &array) {
    std::vector<int> arrCop = {};

    for (int i = 0; i < array.size(); i++) {
        arrCop.push_back(array[i]);
    }

    return arrCop;
}

bool ArrayOps::isEqual(const std::vector<int> &arr1, const std::vector<int> &arr2) {
    if (arr1.size() != arr2.size()) return false;

    for (int i = 0; i < arr1.size(); i++) {
        if (arr1[i] != arr2[i]) return false;
    }

    return true;
}
