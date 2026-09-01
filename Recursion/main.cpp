#include <iostream>

static int fact(int n);
static int sum(int n);
static std::string print(const std::string &str);
static int gcd(int x, int y);
static std::string bin(int n);
static void rec(int n);

int main() {
    // std::cout << "Factorial of 5: " << fact(5) << std::endl;
    // std::cout << "Sum of 5: " << sum(5) << std::endl;
    // print("five");
    // std::cout << "GCD of 16 & 100: " << gcd(16, 100) << std::endl;
    // std::cout << "Binary: " << bin(13);

    rec(5);

    return 0;
}

static int fact(const int n) {
    // Base case
    if (n == 1)
        return 1;

    // Recursive Case
    return n * fact(n - 1);
}

static int sum(const int n) {
    if (n == 1)
        return 1;

    return n + sum(n - 1);
}

static std::string print(const std::string &str) {
    if (str.empty())
        return "";

    std::cout << str.at(0) << std::endl;

    return print(str.substr(1));
}

static int gcd(const int x, const int y) {
    // base
    if (y == 0)
        return x;

    // recursive case... % remainder of int division
    return gcd(y, x % y);
}

static std::string bin(int n) {
    if (n == 1)
        return "1";

    return bin(n / 2) + std::to_string(n%2);
}

static void rec(int n) {
    if (n == 0)
        return;

    std::cout << "BEFORE REC CALL n=" << n << std::endl;

    rec (n - 1);

    std::cout << "AFTER REC CALL n=" << n << std::endl;
}