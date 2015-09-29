# Given the results of a hash (digest), reverse engineer it.
# The function takes a 16 byte input and gives a 16 byte output. It uses multiplication (*),
# bit-wise exclusive OR (XOR) and modulo (%) to calculate an element of the digest based on
# elements of the input message:
#
# digest [i] = ( (129 * message[i]) XOR message[i-1]) % 256
#
# For the first element, the value of message[-1] is 0.
#
# For example, if message[0] = 1 and message[1] = 129, then:
# For digest[0]:
# 129*message[0] = 129
# 129 XOR message[-1] = 129
# 129 % 256 = 129
# Thus digest[0] = 129.
#
# For digest[1]:
# 129*message[1] = 16641
# 16641 XOR message[0] = 16640
# 16640 % 256 = 0
# Thus digest[1] = 0.
#
# Write a function answer(digest) that takes an array of 16 integers and returns another array of
# 16 that correspond to the unique message that created this digest. Since each value is a single
# byte, the values are 0 to 255 for both message and digest.

def answer(d):
    for i in xrange(len(d)):
        tmp = d[i] % 256
        if i is 0:
            tmp ^= 0
        else:
            tmp ^= d[i-1]
        tmp *= 129
        tmp %= 256
        d[i] = tmp
    return d
