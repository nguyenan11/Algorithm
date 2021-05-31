# Algorithm practice

* Java documentations and extra notes are in each file.
* Solutions displayed here are preferably the most optimal
    * Alternative (less optimal) solutions might also be available within each 
    file

# Week 4: 05/31 - 06/06/2021

# Category for this week: 
**[Array](#array)**<br>
**[Strings](#strings)**<br>
**[Sorting](#sorting)**<br>


---

# Sorting

## [Three Numbers Sort](Sortings/src/main/java/ThreeNumSort.java)

#### Level: Medium 📘

> You're given an array of integers and another array of three distinct integers. The first array is guaranteed to only contain integers that are in the second array, and the second array represents a desired order for the integers in the first array. For example, a second array of `[x, y, z]` represents a desired order of `[x, x, ..., x, y, y, ..., y, z, z, ..., z]` in the first array.
>
> Write a function that sorts the first array according to the desired order in the second array.
> The function should perform this in place (i.e., it should mutate the input array), and it shouldn't use any auxiliary space (i.e., it should run with constant space: `O(1)` space).
>
> Note that the desired order won't necessarily be ascending or descending and that the first array won't necessarily contain all three integers found in the second array—it might only contain one or two.
