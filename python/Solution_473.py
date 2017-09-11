


class Solution(object):
    def makesquare(self, nums):
        if len(nums) < 4:
            return False
        s = sum(nums)
        if s % 4 != 0:
            return False
        nums.sort()
        nums.reverse()
        return self.dfsSquare([0, 0, 0, 0], nums, 0, s / 4)


    def dfsSquare(self, side_list, nums, level, length):
        if level == len(nums):
            for side in side_list:
                if side != length:
                    return False
            return True
        for i in range(len(side_list)):
            if side_list[i] + nums[level] > length:
                continue
            side_list[i] += nums[level]
            if self.dfsSquare(side_list, nums, level+1, length):
                return True
            side_list[i] -= nums[level]
            
        return False

if __name__=="__main__":
    solution = Solution()
    print solution.makesquare([1,2,3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15])
