

class Solution(object):
    def findLengthOfLCIS(self, nums):
        if len(nums) == 0:
            return 0
        dpCIS = [] 
        dpCIS.append(1)
        max = 1;
        for i in range(1, len(nums)):
            num = nums[i]
            if num > nums[i-1]:
                dpCIS.append(dpCIS[i-1] + 1)
            else:
                dpCIS.append(1)
            if dpCIS[i] > max:
                max = dpCIS[i]
        return max


solution = Solution()
print solution.findLengthOfLCIS([1,3,5,4,2,3,4,5])

