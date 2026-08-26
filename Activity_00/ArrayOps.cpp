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
 * Determine whether an array is empty or not
 * @param array an array of ints
 * @return a boolean indicating whether the array is empty or not
 */
bool ArrayOps::isEmpty(const std::vector<int> &array) {
    return array.empty();
}

/**
 * Copies one array into another one
 * @param array an array of ints to copy
 * @return a new array that is the same as the one passed in
 */
std::vector<int> ArrayOps::copy(const std::vector<int> &array) {
    std::vector<int> arrCop = {};
    arrCop.reserve(array.size());

    for (int i = 0; i < array.size(); i++) {
        arrCop.push_back(array[i]);
    }

    return arrCop;
}

/**
 * Checks that the 2 arrays passed contain the same values
 * @param arr1 the first array of ints to check
 * @param arr2 The second array of ints to check
 * @return bool indicating whether the two arrays contain the same values
 */
bool ArrayOps::isEqual(const std::vector<int> &arr1, const std::vector<int> &arr2) {
    if (arr1.size() != arr2.size()) return false;

    for (int i = 0; i < arr1.size(); i++) {
        if (arr1[i] != arr2[i]) return false;
    }

    return true;
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

/**
 * Gets the maximum integer in the array
 * @param array the array to check
 * @return the maxium value
 */
int ArrayOps::max(const std::vector<int> &array) {
    int highest = INT_MIN;

    for (int i = 0; i < array.size(); i ++) {
        if (array[i] > highest) highest = array[i];
    }

    return highest;
}

/**
 * Gets the minimum integer in the array
 * @param array the array to check
 * @return the minimum value
 */
int ArrayOps::min(const std::vector<int> &array) {
    int smallest = INT_MAX;

    for (int i = 0; i < array.size(); i ++) {
        if (array[i] < smallest) smallest = array[i];
    }

    return smallest;
}

/**
 * Checks if the passed value is located in the array
 * @param array the array to check
 * @param val the value to check
 * @return if the value is in the array
 */
bool ArrayOps::exists(const std::vector<int> &array, int val) {
    for (int i = 0; i < array.size(); i++) {
        if (array[i] == val) return true;
    }

    return false;
}

/**
 * Removes the value from the passed array
 * @param array the array to use
 * @param val the value to remove
 * @return the array without that value in it
 */
std::vector<int> ArrayOps::filter(const std::vector<int> &array, int val) {
    std::vector<int> newArr = {};

    for (int i = 0; i < array.size(); i++) {
        if (array[i] != val) newArr.push_back(array[i]);
    }

    return newArr;
}
