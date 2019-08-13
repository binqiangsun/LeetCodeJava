
class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        frequent_dict = {}
        for i, num in enumerate(nums):
            frequent_dict[num] = frequent_dict.get(num, 0) + 1
            nums[i] = []
        for key, value in frequent_dict.items():
            nums[value].append(key)
        res = []
        for x in range(len(nums)-1, -1, -1):
            if k > 0 and nums[x]:
                res += nums[x]
                k -= len(nums[x])
            if k == 0:
                break
        return res

