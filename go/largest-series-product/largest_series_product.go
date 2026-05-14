package largestseriesproduct

import (
	"errors"
	"unicode"
)

func LargestSeriesProduct(digits string, span int) (int64, error) {
	var series []string

	if span < 0 {
		return 0, errors.New("span must not be negative")
	}

	for i := 0; i < len(digits); i++ {
		if i + span > len(digits) {
			break
		}
		series = append(series, digits[i:i+span])
	}

	if len(series) == 0 {
		return 0, errors.New("Error")
	}

	var largestProduct = 0
	for _, v := range series {
		calc := 1
		for _, d := range v {
			if !unicode.IsNumber(d) {
				return 0, errors.New("digits input must only contain digits")
			}
			calc = calc * int(d - '0')
		}
		if largestProduct < calc {
			largestProduct = calc
		}
	}

	return int64(largestProduct), nil
}
