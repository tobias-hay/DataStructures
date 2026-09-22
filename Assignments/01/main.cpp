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

    for (int count = 100; count < 20000; count += 100) {

        for (int i = 0; i < 6; i++) {
            std::vector<int> arr = Utils::generateArray(count, count);

            t.Start();
            switch (i) {
                case 0: {
                    StaticSorts::bubble(arr);
                    break;
                }
                case 1: {
                    StaticSorts::selection(arr);
                    break;
                }
                case 2: {
                    StaticSorts::insertion(arr);
                    break;
                }
                case 3: {
                    MergeSort ms(arr);
                    break;
                }
                case 4: {
                    QuickSort qs(arr);
                    break;
                }
                case 5: {
                    RadixSort rs(arr);
                    break;
                }
                default:
                    throw std::invalid_argument("How did you get here");
            }
            t.Stop();

            std::cout << "Completed " << i << " with " << count << " elements, taking  " << t.GetTime() << std::endl;

            c.Log(static_cast<Collector::SortType>(i), count, t.GetTime());
        }
    }

    c.DumpCSV();

    return 0;
}
