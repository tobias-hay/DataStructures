#include <vector>
#include <iostream>
#include <thread>
#include <functional>

#include "Sorts/MergeSort.h"
#include "Sorts/QuickSort.h"
#include "Sorts/RadixSort.h"
#include "Sorts/StaticSorts.h"
#include "Utils/Collector.h"
#include "Utils/Timer.h"
#include "Utils/Utils.h"

void Sorter(int maxCount, Collector::SortType type, Collector &c) {
    auto t = Timer();

    for (int count = 100; count <= maxCount; count += 100) {
        std::vector<int> arr = Utils::generateArray(count, count);

        t.Start();
        switch (type) {
            case Collector::ST_BUBBLE: {
                StaticSorts::bubble(arr);
                break;
            }
            case Collector::ST_SELECTION: {
                StaticSorts::selection(arr);
                break;
            }
            case Collector::ST_INSERTION: {
                StaticSorts::insertion(arr);
                break;
            }
            case Collector::ST_MERGE: {
                MergeSort ms(arr);
                break;
            }
            case Collector::ST_QUICK: {
                QuickSort qs(arr);
                break;
            }
            case Collector::ST_RADIX: {
                RadixSort rs(arr);
                break;
            }
            default:
                throw std::invalid_argument("How did you get here");
        }
        t.Stop();

        if (count % 25000 == 0) {
            std::cout << "Completed " << count << " element milestone using sort #" << type << ", taking  " << t.GetTime() << std::endl;
        }

        c.Log(type, count, t.GetTime());
    }
}

int main() {
    auto c = Collector();
    constexpr int MAX_ARRAY_LENGTH = 100000;

    int sortNum = 5;
    int iters = 0;
    unsigned int maxThreads = std::thread::hardware_concurrency();
    if (maxThreads == 0) maxThreads = 1;

    std::cout << "Using " << maxThreads << " (max 6) threads..." << std::endl;

    while (sortNum >= 0) {
        std::vector<std::thread> sorterThreads{};

        while (iters < maxThreads && sortNum >= 0) {
            sorterThreads.emplace_back(Sorter, MAX_ARRAY_LENGTH, static_cast<Collector::SortType>(sortNum), std::ref(c));
            sortNum--;
            iters++;
        }

        for (auto& th : sorterThreads) {
            if (th.joinable()) {
                th.join();
            }
        }

        iters = 0;
    }


    c.DumpCSV();

    return 0;
}