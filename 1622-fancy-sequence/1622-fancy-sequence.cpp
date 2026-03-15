class Fancy {
public:
    static const long long MOD = 1'000'000'007;

    vector<long long> arr;     // stores original values
    vector<long long> mulAt;   // multiplier snapshot at append time
    vector<long long> addAt;   // addition snapshot at append time

    long long mul = 1;         // global multiplier
    long long add = 0;         // global addition

    long long modpow(long long a, long long b) {
        long long r = 1;
        while (b > 0) {
            if (b & 1) r = (r * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return r;
    }

    long long modinv(long long x) {
        return modpow(x, MOD - 2);
    }

    Fancy() {}

    void append(int val) {
        arr.push_back(val);
        mulAt.push_back(mul);
        addAt.push_back(add);
    }

    void addAll(int inc) {
        add = (add + inc) % MOD;
    }

    void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }

    int getIndex(int idx) {
        if (idx >= arr.size()) return -1;

        long long val = arr[idx];
        long long oldMul = mulAt[idx];
        long long oldAdd = addAt[idx];

        long long inv = modinv(oldMul);
        long long result = (val * ((mul * inv) % MOD)) % MOD;
        result = (result + (add - (oldAdd * ((mul * inv) % MOD)) % MOD + MOD)) % MOD;

        return (int)result;
    }
};
