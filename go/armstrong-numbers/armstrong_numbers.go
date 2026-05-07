package armstrongnumbers

import (
	"math"
	"strconv"
)

func IsNumber(n int) bool {
	var strNum = strconv.Itoa(n)
	var total = 0

	if n == 0 {
		return true
	}

	for _, d := range strNum {
		total += int(math.Pow(float64(d - '0'), float64(len(strNum))))
	}


	return total == n
}
