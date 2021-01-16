# Algo Trials

This repository is my primary playground for the programming and algorithms trials.

I've hosted solutions from multiple websites, Books and courses under this repository. I try to keep the list updated


| Course/Book/Site Link | Repository Link |
| --- | --- |
|**CLRS** - *Cormen, Leiserson, Rivest, Stein* | [here](https://github.com/Shashi-Bhushan/algo-trials/tree/master/src/main/java/in/shabhushan/algo_trials/clrs) |
|[**Algorithms** - *Robert Sedgewick and Kevin Wayne*](https://www.coursera.org/learn/algorithms-part1/home/welcome) | [here](https://github.com/Shashi-Bhushan/algo-trials/tree/master/src/main/java/in/shabhushan/algo_trials/algorithms) |
|**Dynamic Programming** - *Meenakshi, Kamal Rawat* | [here](https://github.com/Shashi-Bhushan/algo-trials/tree/master/src/main/java/in/shabhushan/algo_trials/dynamic_programming) |
|**Advent of Code** | [here](https://github.com/Shashi-Bhushan/algo-trials/tree/master/src/main/java/in/shabhushan/algo_trials/aoc) |


# JMH Benchmarks

Under `src/test/perf` I've added few JMH benchmarks as well. These benchmarks are related to Encryption, Secure Random, String concatenation, Sorting, Compression etc.
Feel free to play around with these If you desire. :D

#### How to Run Benchmarks

Build the project using maven. No need to run test cases
`mvn clean install -D skipTests`

Run the perfs jar (jar containing all the benchmarks)
`java -jar target/algo-trials-1.0-SNAPSHOT-perf-tests.jar `

Note: I've commented out the code for the benchmarks for now. Please uncomment the code in the Benchmarks class you want to run and use maven to run those JMH benchmarks.

## About Me
![Codewars](https://www.codewars.com/users/Shashi-Bhushan/badges/large)
