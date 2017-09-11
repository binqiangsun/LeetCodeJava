
class Solution(object):
    def findSecondMinimumValue(self, root):
        self.dfsNodes(root, set_list)
        if len(set_list) < 2 :
            return -1
        return set_list.get(1)


    def dfsNodes(self, root, set_list):
        if root not None:
            set_list.add(root.val)
        self.dfsNodes(root.left, set_list)
        self.dfsNodes(root.right, set_list)
            
