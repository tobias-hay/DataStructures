#include <vector>

#include "Utils/Utils.h"

int main() {
    std::vector<int> arr = Utils::generateArray(10, 20);

    Utils::print(arr);

    return 0;
}
