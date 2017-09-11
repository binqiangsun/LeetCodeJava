

class Solution(object):
    def trimBST(self, root, L, R):
        return self.dfsTrim(root, L, R)

    def dfsTrim(self, root, L, R):
        if root is None:
            return None
        if root.val > L and root.val < R:
            root.left = self.dfsTrim(root.left, L, R)
            root.right = self.dfsTrim(root.right, L, R)
            return root
        if root.val <=L:
            return self.dfsTrim(root.right, L, R)
        elif root.val >= R:
            return self.dfsTrim(root.left, L, R)



