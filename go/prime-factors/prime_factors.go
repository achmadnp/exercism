package primefactors

func Factors(n int64) []int64 {
	var factors []int64 
	var divisor int64 = 2

	if n <= 1 {
		return factors
	}

	for n > 1 {
		if n % divisor == 0 {
			factors = append(factors, divisor)
			n = n / divisor
		} else {
			divisor++
		}
	}

	return factors
	
}