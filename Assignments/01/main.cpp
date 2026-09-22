#include <vector>
#include <iostream>

#include "Sorts/MergeSort.h"
#include "Sorts/QuickSort.h"
#include "Sorts/RadixSort.h"
#include "Sorts/StaticSorts.h"
#include "Utils/Collector.h"
#include "Utils/Timer.h"
#include "Utils/Utils.h"

int main() {
    auto t = Timer();
    auto c = Collector();

    for (int count = 100; count < 10000; count += 100) {
        std::vector<int> arr = Utils::generateArray(count, count);

        t.Start();
        StaticSorts::bubble(arr);
        t.Stop();

        c.Log(Collector::ST_BUBBLE, count, t.GetTime());
    }

    c.DumpCSV();

    return 0;
}
