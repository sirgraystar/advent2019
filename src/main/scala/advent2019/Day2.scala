package advent2019

import scalaadventutils.Problem

object Day2 {

    def main(args: Array[String]): Unit = {
        val input = Problem.parseInputToString("day2")
        println(part1(input))
        println(part2(input))
    }

    def part1(input: String) =
        Intcode.run(input, List(), Map(1L -> 12L, 2L -> 2L)).pm(0)

    def part2(input: String): Int = {
        val combs = (0 to 99).combinations(2).flatMap(_.permutations)
        val res = combs.dropWhile(c => {
            Intcode.run(input, List(), Map(1L -> c(0), 2L -> c(1))).pm(0) != 19690720
        }).next()
        100 * res(0) + res(1)
    }
}
