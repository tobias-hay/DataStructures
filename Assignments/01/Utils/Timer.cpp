#include <chrono>

#include "Timer.h"

void Timer::Start() {
    startTime = std::chrono::steady_clock::now();
    started = true;
}

std::chrono::duration<double, std::milli> Timer::Stop() {
    if (!started) throw std::runtime_error("Need to start timer before stopping");

    endTime = std::chrono::steady_clock::now();
    ended = true;
    started = false;

    return endTime - startTime;
}

std::chrono::duration<double, std::milli> Timer::GetTime() const {
    if (!ended) throw std::runtime_error("Need to end timer before getting elapsed time");

    return endTime - startTime;
}
