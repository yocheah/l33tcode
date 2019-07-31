class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        idx = 0
        prev = None
        for n in nums:
            if prev is None or prev != n:
                prev = n
                nums[idx] = prev
                idx += 1
        return idx
