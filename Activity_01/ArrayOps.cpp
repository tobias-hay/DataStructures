#include "ArrayOps.h"

#include <vector>
#include <iostream>

/**
 * Prints the given array to the console
 * @param array an array of ints
 */
void ArrayOps::print(const std::vector<int>& array) {
    std::cout << "[ ";

    for (int i = 0; i < array.size(); i++) {
        if (i != 0) std::cout << ", ";
        std::cout << array[i];
    }

    std::cout << " ]" << std::endl;
}

/**
 * Generates a new array that is the length passed and contains random values from 0 to the maximum
 * @param length the length of the array to make
 * @param max the maximum the random value should be
 * @return a new array
 */
std::vector<int> ArrayOps::generateArray(int length, int max) {
    std::vector<int> newArr = {};
    newArr.reserve(length);

    for (int i = 0; i < length; i++) {
        newArr.push_back(static_cast<int>(round(rand() % max)));
    }

    return newArr;
}

void ArrayOps::bubble(std::vector<int> &array) {
    // Outer loop, red pointer
    for (int i = 0; i < array.size() - 1; i++) {
        // Inner loop, green pointer
        for (int j = 0; j < array.size() - i - 1; j++) {
            if (array[j] > array[j + 1]) { // check if left is greater than zero
                // Swap
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
}
