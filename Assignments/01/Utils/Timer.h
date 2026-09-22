
#ifndef INC_01_TIMER_H
#define INC_01_TIMER_H

#include <chrono>

class Timer {
private:
    std::chrono::time_point<std::chrono::steady_clock> startTime{};
    std::chrono::time_point<std::chrono::steady_clock> endTime{};
    bool started = false;
    bool ended = false;

public:
    void Start();
    std::chrono::duration<double, std::milli> Stop();
    std::chrono::duration<double, std::milli> GetTime() const;
};


#endif //INC_01_TIMER_H
