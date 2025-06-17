class Solution:
    def countGoodArrays(self, n: int, m: int, k: int) -> int:
        def power(a, b):
            result = 1
            mod = 1000000007
            a %= mod
            while b > 0:
                if b % 2 == 1:
                    result = (result * a) % mod
                a = (a * a) % mod
                b //= 2
            return result

        def init_factorials(limit):
            mod = 1000000007
            fact = [1] * (limit + 1)
            inv_fact = [1] * (limit + 1)

            for i in range(1, limit + 1):
                fact[i] = (fact[i - 1] * i) % mod

            inv_fact[limit] = power(fact[limit], mod - 2)
            for i in range(limit - 1, -1, -1):
                inv_fact[i] = (inv_fact[i + 1] * (i + 1)) % mod

            return fact, inv_fact

        def comb(n, r, fact, inv_fact):
            mod = 1000000007
            if r < 0 or r > n:
                return 0
            return (fact[n] * inv_fact[r] % mod) * inv_fact[n - r] % mod

        mod = 1000000007
        fact, inv_fact = init_factorials(n)
        choose_positions = comb(n - 1, k, fact, inv_fact)
        ways = choose_positions * m % mod
        ways = ways * power(m - 1, n - 1 - k) % mod

        return ways


        