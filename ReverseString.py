class Solution(object):
    def reverseStrng(self, strng):
        """
        :type s: str
        :rtype: str
        """
        length = len(strng)
        st = []

        for i in range(length):

            # add the index of opening bracket
            if (strng[i] == '('):
                st.append(i)

            # reversing the substring after last opening bracket
            elif (strng[i] == ')'):
                temp = strng[st[-1]:i + 1]
                strng = strng[:st[-1]] + temp[::-1] + \
                       strng[i + 1:]
                del st[-1]

        # To store the modified string
        result = ""
        for i in range(length):
            if (strng[i] != ')' and strng[i] != '('):
                result += (strng[i])
        return result

    if __name__ == '__main__':
        strng = "(abc)"
        strng1 = "(ed(et(oc))el)"
        strng2 = "(u(love)i)"
        strng3= "a(bcdefghijkl(mno)p)q"
        print(reverseStrng(__name__, strng))
        print(reverseStrng(__name__, strng1))
        print(reverseStrng(__name__, strng2))
        print(reverseStrng(__name__, strng3))
