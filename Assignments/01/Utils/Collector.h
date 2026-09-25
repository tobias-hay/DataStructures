
#ifndef INC_01_COLLECTOR_H
#define INC_01_COLLECTOR_H

#include <chrono>
#include <vector>

class Collector {
public:
    enum SortType {
        ST_BUBBLE,
        ST_SELECTION,
        ST_INSERTION,
        ST_MERGE,
        ST_QUICK,
        ST_RADIX
    };

private:
    std::vector<std::pair<int, double>> data[6];

public:
    bool Log(SortType type, int size, std::chrono::duration<double, std::milli> time);
    bool DumpCSV();

private:
    std::string TypeToString(int type);
};


#endif //INC_01_COLLECTOR_H
