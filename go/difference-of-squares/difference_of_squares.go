package diffsquares

func SquareOfSum(n int) int {
	sum := 0
    for i:= n; i > 0; i-- {
        sum += i
    }
    return sum * sum
}

func SumOfSquares(n int) int {
	sum := 0
    for i:= n; i> 0; i-- {
        sum += i * i
    }
    return sum
}

func Difference(n int) int {
	diff := SquareOfSum(n) - SumOfSquares(n)
    if diff < 0 {
        diff *= -1
    }

    return diff
}
