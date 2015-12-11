# Hanoi Tower Game in Java
Implementation of Hanoi Tower game, with a matrix of List&lt;Stack&lt;Disc>>

## The idea

Use in our favor the stack propreties. A stack is LIFO (last in first out) kind, perfect to pile the discs, only have access to last added disc. The arrayList in representation of the rod, that we can get any element(in this case rod, which is our stack) by index. The Disc class contain one attribute that is the diameter of the disc, perfect to compare.
