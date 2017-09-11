


class Solution(object):
    def dfsDecode(self, s, index):
        char_list = list(s)
        size = len(char_list)
        if index == size :
            return ''
        result = ''
        count = 0

        while index < size:
            c = char_list[index]
            while c.isdigit():
                count = count * 10 + int(c)
                index += 1
                c = char_list[index]
            
            if c == '[':
                index += 1
                per, index = self.dfsDecode(s, index)
                if count == 0:
                    count = 1
                while count > 0:
                    result += per
                    count -= 1
            elif c == ']':
                index += 1
                return result, index
            else :
                result += char_list[index]
                index += 1
                
        return result, size

    def decodeString(self, s):
        res, index = self.dfsDecode(s, 0)
        return res

solution = Solution()
print solution.decodeString('3[abc]4[xyz]')
print solution.decodeString('2[abc]3[cd]ef')
print solution.decodeString('3[a2[c]]')
                

