
#include "Collector.h"

#include <iostream>
#include <fstream>

bool Collector::Log(SortType type, int size, std::chrono::duration<double, std::milli> time) {
    std::pair<int, double> d = {size, time.count()};

    data[type].push_back(d);

    return true;
}

bool Collector::DumpCSV() {
    std::ofstream csv("output.csv");

    if (!csv.is_open()) {
        std::cerr << "Error opening file, quiting dump operation" << std::endl;
        return false;
    }

    csv << "Name,";
    for (std::pair<int, double> &time : data[0]) {
        csv << time.first << "," ;
    }
    csv << std::endl;

    for (int i = 0; i < data->size(); i++) {
        auto &typeTimes = data[i];

        csv << TypeToString(i) << ",";

        for (std::pair<int, double> &time : typeTimes) {
            csv << time.second << ",";

            std::cout << "Array Length: " << time.first << ", Time Taken (ms): " << time.second << std::endl;
        }

        csv << std::endl;
    }

    csv.close();

    return true;
}

std::string Collector::TypeToString(int type) {
    switch (type) {
        case ST_BUBBLE:
            return "Bubble Sort";
        case ST_SELECTION:
            return "Selection Sort";
        case ST_INSERTION:
            return "Insertion Sort";
        case ST_MERGE:
            return "Merge Sort";
        case ST_QUICK:
            return "Quick Sort";
        case ST_RADIX:
            return "Radix Sort";
        default:
            return "Unknown Sort";
    }
}
