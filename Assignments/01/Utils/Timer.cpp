#include <chrono>

#include "Timer.h"

void Timer::Start() {
    startTime = std::chrono::steady_clock::now();
}

std::chrono::duration<double, std::milli> Timer::Stop() {
    endTime = std::chrono::steady_clock::now();

    return endTime - startTime;
}

std::chrono::duration<double, std::milli> Timer::GetTime() const {
    return endTime - startTime;
}
