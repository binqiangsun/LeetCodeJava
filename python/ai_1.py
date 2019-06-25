
import math

def cal_step(num):
    r = int(math.sqrt(num))
    if r * r == num:
        return r - 1
    r = r + 1 if r % 2 == 0 else r + 2
    row = (num - (r - 2) * (r -2)) % (r - 1)
    return abs(row - (r - 1) / 2) + (r - 1) / 2

if __name__ == "__main__":
    print cal_step(1)
    print cal_step(12)
    print cal_step(23)
    print cal_step(1024)
    print cal_step(100000)
    print cal_step(2345678)