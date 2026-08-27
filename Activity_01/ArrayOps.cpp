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

void ArrayOps::swap(std::vector<int> &array, int from, int to) {
    int temp = array[from];
    array[from] = array[to];
    array[to] = temp;
}

void ArrayOps::bubble(std::vector<int> &array) {
    for (int i = 0; i < array.size() - 1; i++) {
        for (int j = 0; j < array.size() - i - 1; j++) {
            if (array[j] > array[j + 1]) { // check if left is greater than zero
                swap(array, j, j+1);
            }
        }
    }
}

void ArrayOps::selection(std::vector<int> &array) {
    for (int i = 0; i < array.size(); i++) {
        // index of smallest value found
        int jMin = i; // assume I is smallest;

        // loop through remaining, update the smallest index
        for (int j = i + 1; j < array.size(); j++) {
            if (array[j] < array[jMin]) {
                jMin = j; // update jMin to point to new smallest
            }
        }

        swap(array, jMin, i);
    }
}