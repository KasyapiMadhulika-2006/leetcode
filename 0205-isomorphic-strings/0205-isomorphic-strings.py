class Solution(object):
    def isIsomorphic(self, s, t):
        l1=[]
        l2=[]
        for i in s:
            l1.append(s.index(i))
        for i in t:
            l2.append(t.index(i))
        if l1 == l2:
            return True
        return False

        """
        :type s: str
        :type t: str
        :rtype: bool
        """

        