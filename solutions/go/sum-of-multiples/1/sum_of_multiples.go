package sumofmultiples

func SumMultiples(limit int, divisors ...int) int {
	energy := 0


	for i := 1; i < limit; i++ {
		for _, d := range divisors {
			if d != 0 && i % d == 0 {
				energy += i
				break
			}
		}
	}

	return energy

}
