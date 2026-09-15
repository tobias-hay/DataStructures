#include "Utils.h"

#include <iostream>
#include <vector>
#include <random>

void Utils::print(const std::vector<int> &arr) {
    std::cout << "[";

    for (int i = 0; i < arr.size(); i++) {
        std::cout << arr[i];
        if (i < arr.size() - 1) std::cout << ", ";
    }

    std::cout << "]" << std::endl;
}

std::vector<int> Utils::generateArray(const int length, const int maxVal) {
    /*
     *  Setup & seed random # gen
     *  ref https://en.cppreference.com/cpp/numeric/random/uniform_int_distribution#Example
    */
    std::random_device randomDevice;
    std::mt19937 gen(randomDevice());
    std::uniform_int_distribution<> rand(0, maxVal);

    std::vector<int> arr = {};
    arr.reserve(length);

    for (int i = 0; i < length; i++) {
        arr.push_back(rand(gen));
    }

    return arr;
}

void Utils::swap(std::vector<int> &arr, int fromIdx, int toIdx) {
    int fromVal = arr[fromIdx];
    arr[fromIdx] = arr[toIdx];
    arr[toIdx] = fromVal;
}
