/*
 * @lc app=leetcode id=2761 lang=cpp
 *
 * [2761] Prime Pairs With Target Sum
 */

#include <string>
#include <iostream>
#include <vector>
#include <map>
#include <cmath>

using namespace std;

// @lc code=start
class Solution
{
public:
    vector<vector<int>> findPrimePairs(int n)
    {
        vector<vector<int>> res{};

        if (n % 2)
        {
            return isPrimeNum(n - 2) ? vector<vector<int>>({{2, n - 2}}) : vector<vector<int>>({});
        }

        int halfN = n / 2;
        map<int, bool> mp;
        primeSeive(n, mp);

        for (auto [prime, _] : mp)
        {
            if (prime <= halfN && mp.count(n - prime))
            {
                res.push_back({prime, n - prime});
            }
        }
        return res;
    }

    void primeSeive(int n, map<int, bool> &mp)
    {
        vector<bool> isPrime(n + 1, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= n; i++)
        {

            if (isPrime[i])
            {
                if (sqrt(n) < i)
                {
                    break;
                }

                for (int j = i * i; j <= n; j += i)
                {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= n; i++)
        {
            if (isPrime[i])
            {
                mp[i] = true;
            }
        }
    }

    [[deprecated]] bool isPrimeNum(int n)
    {
        static map<int, bool> cache;
        if (n < 2)
        {
            return false;
        }
        if (n == 2)
        {
            cache[n] = true;
            return true;
        }

        if (cache.count(n))
        {
            return cache[n];
        }

        bool isPrime = true;
        int sqrtN = ceil(sqrt(n));
        for (int i = 2; i <= sqrtN; i++)
        {
            if (n % i == 0)
            {
                isPrime = false;
                break;
            }
        }
        cache[n] = isPrime;
        return isPrime;
    };
};
// @lc code=end

int main()
{
    Solution sol;
    auto res = sol.findPrimePairs(10);
}
