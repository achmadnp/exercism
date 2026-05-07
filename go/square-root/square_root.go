package squareroot

func SquareRoot(number int) (int, error) {
	l := 0
	r := number + 1

	for (l != r - 1) {
		m := (l + r ) / 2
		if m * m <= number {
			l = m
		} else {
			r = m
		}
	}

	return l, nil
}
