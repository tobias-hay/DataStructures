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
    arrCop.reserve(array.size());

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

std::vector<int> ArrayOps::generateArray(int length, int max) {
    std::vector<int> newArr = {};
    newArr.reserve(length);

    for (int i = 0; i < length; i++) {
        newArr.push_back(static_cast<int>(round(rand() % max)));
    }

    return newArr;
}

int ArrayOps::max(const std::vector<int> &array) {
    int highest = INT_MIN;

    for (int i = 0; i < array.size(); i ++) {
        if (array[i] > highest) highest = array[i];
    }

    return highest;
}

int ArrayOps::min(const std::vector<int> &array) {
    int smallest = INT_MAX;

    for (int i = 0; i < array.size(); i ++) {
        if (array[i] < smallest) smallest = array[i];
    }

    return smallest;
}

bool ArrayOps::exists(const std::vector<int> &array, int val) {
    for (int i = 0; i < array.size(); i++) {
        if (array[i] == val) return true;
    }

    return false;
}

std::vector<int> ArrayOps::filter(const std::vector<int> &array, int val) {
    std::vector<int> newArr = {};

    for (int i = 0; i < array.size(); i++) {
        if (array[i] != val) newArr.push_back(array[i]);
    }

    return newArr;
}
