Levenshtein Distance is a common algorithm used to measure the similarity between two strings.

The current version on this repository has two methods with two different approaces: naive and dynamic.

The naive approach works in a recursive fashion checking the similarity of all possible substrings. The overlapping states in the call stack yield a massive runtime of the order O(3^m+n-1).

The dynamic approach works by starting with a matrix of size m x n. We then fill that matrix's first row and column with base case values and then using those values to calculate the Levenshtein Distance for all possible subtrings of the input strings. Currently the program just returns the Levenshtein Distance for the inputted strings.

How to run:

javac LevenshteinDistance.java

java LevenshteinDistance string1 string2
