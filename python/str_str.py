class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if needle == '':
            return 0
        needle_len = len(needle)
        for idx, _ in enumerate(haystack):
            if haystack.startswith(needle, idx, idx+needle_len):
                return idx
        return -1
