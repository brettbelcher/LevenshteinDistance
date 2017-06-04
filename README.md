Levenshtein Distance is a common algorithm used to measure the similarity between two strings.

The current version on this repository has two methods with two different approaces: naive and dynamic.

The naive approach works in a recursive fashion checking the similarity of all possible substrings. The overlapping states in the call stack yield a massive runtime of the order O(3^m+n-1).

The dynamic approach works by starting with a matrix of size m x n. We then fill that matrix's first row and column with base case values and then using those values to calculate the Levenshtein Distance for all possible subtrings of the input strings. This runs on the O(mn) as it only has to traverse the matrix a constant number of times. Currently the program returns the Levenshtein Distance of each line of two input files with the ith line of the first input file being compared with the ith line of the second input file.

How to run:

javac LSDistance.java

java LSDistance inputfile1 inputfile2
