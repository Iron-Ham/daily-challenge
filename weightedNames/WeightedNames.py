# You must select the name with the largest value.
# If you assign 1 to the letter a, 2 to be, etc..., and add up the values for all the letters
# the names with the highest total values will be the best.
#
# So given a list of names, return the list sorted in descending order of value.
#
# There will be at least 1 and no more than 1000 names. Each name will consist only of lowercase
# letters. The length of each name will be at least one and no more than eight.
#
# Test cases
# ==========
#
# Inputs:
#     (string list) names = ["annie", "bonnie", "liz"]
# Output:
#     (string list) ["bonnie", "liz", "annie"]
#
# Inputs:
#     (string list) names = ["abcdefg", "vi"]
# Output:
#     (string list) ["vi", "abcdefg"]

def answer(names):
    name_with_values = []
    for name in names: name_with_values.append(
        (name, sum([ord(char) - 96 for char in name]))
    )
    return [name for (name, cardinal) in sorted(
        name_with_values,
        key=lambda element: (element[1], element[0]),
        reverse=True
    )]
