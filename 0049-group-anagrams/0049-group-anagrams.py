class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        m={}
        n=len(strs)
        for i in strs:
            x=sorted(i)
            y="".join(x)
            if y not in m:
                m[y]=[i]
            else:
                m[y].append(i)
        return list(m.values())

        