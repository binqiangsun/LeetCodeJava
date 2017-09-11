
import sys

class Solution(object):
    
    def __init__(self):
        self.res = 0
        self.max_length = 0

    def findNumberOfLIS(self, nums):
        if len(nums) == 0:
            return 0
        self.dfsLongestSize(nums, 0, 0-sys.maxint, 0)
        return self.res
        


    def dfsLongestSize(self, nums, level, cur, length):
        if level == len(nums):
            if length > self.max_length:
                self.max_length = length
                self.res = 1
            elif length == self.max_length:
                self.res += 1
            return
        if len(nums) - level < self.max_length - length:
            return
        if nums[level] > cur:
            self.dfsLongestSize(nums, level + 1, nums[level], length + 1)
            self.dfsLongestSize(nums, level + 1, cur, length)
        else:
            self.dfsLongestSize(nums, level + 1, cur, length)


solution = Solution()
print solution.findNumberOfLIS([3,4,4,9,8,2,8,10,1,10,2,8,10,0,10,2,9,-3,2,2,10,1,5,2,0,8,10,3,5,4,4,1,3,4,10,4,6,1,3,8,4,3,8,9,0,10,10,8,10,9,3,6,9,7,2,9,10,0,2,7,5,6,9,4,3,6,9,10,3,4,4,8,5,4,3,8])

