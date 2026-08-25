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
