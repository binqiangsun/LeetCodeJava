# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def binaryTreePaths(self, root):
        result = []
        self.dfsPath(root, "", result)
        return result

    def dfsPath(self, root, path, result):
        if not root:
            return
        if path == "":
            path = str(root.val)
        else:
            path += '->'
            path += str(root.val)
        if not root.left and not root.right:
            result.append(path)
        self.dfsPath(root.left, path, result)
        self.dfsPath(root.right, path, result)
