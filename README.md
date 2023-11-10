# MP06:Sorting Out Sorting
 

## Groups
```
Seunghyeon Kim
```

## Description
```
The main goal of this project was to create various sorting algorithms, and
make my own utilizing them. Generally most of the sorting algorithms vary
between O(n log n), and O(n^2)
```

## Speed Anaysis
```
Algorithm     |     Ω(f(n))     |     θ(f(n))     |     O(f(n)) 
--------------+-----------------+-----------------+-----------------
FakeSort      |       N/A       |       N/A       |       N/A   
InsertionSort |     f(n) = n    |   f(n) = n^2    |    f(n) = n^2
KimHyeonSort  |     f(n) = n    | f(n) = n log(n) | f(n) = n log(n)
MergeSort     | f(n) = n log(n) | f(n) = n log(n) | f(n) = n log(n)
Quicksort     | f(n) = n log(n) | f(n) = n log(n) |    f(n) = n^2
```

## Files
```
FakeSort.java
FakeSortTester.java
InsertionSort.java
InsertionSortTester.java
KimHyeonSort.java
KimHyeonSortTester.java
MergeSort.java
MergeSortTester.java
Quicksort.java
QuicksortTester.java
Sorter.java
SortTester.java
README.md
```

## Acknowledgements
```
Professor Sam. Rebelsky
https://en.wikipedia.org/wiki/Insertion_sort
https://github.com/seunghk1206/CSC207/tree/Labs/Class2324/lab-merge-sort
https://www.geeksforgeeks.org/timsort/
https://rebelsky.cs.grinnell.edu/Courses/CSC207/2023Fa/mps/mp06.html
MergeSort and QuickSorts
    https://github.com/seunghk1206/CSC207/tree/Labs/Class2324/lab-merge-sort
```