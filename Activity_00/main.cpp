#include <iostream>
#include <vector>
#include "ArrayOps.h"

int main() {
    const std::vector numArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    const std::vector<int> emptyArray = {};
    const std::vector<int> nullArray;

    ArrayOps::print(numArray);

    std::cout << "isNumArrayEmpty? " << ArrayOps::isEmpty(numArray) << std::endl;
    std::cout << "isEmptyArrayEmpty? " << ArrayOps::isEmpty(emptyArray) << std::endl;
    std::cout << "isNullArrayEmpty? " << ArrayOps::isEmpty(nullArray) << std::endl;

    const std::vector<int> arrayCopy = ArrayOps::copy(numArray);
    std::cout << "numArray: ";
    ArrayOps::print(numArray);
    std::cout << "arrayCopy: ";
    ArrayOps::print(arrayCopy);

    return 0;
}