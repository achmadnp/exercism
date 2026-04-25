package phonenumber

import (
	"errors"
	"fmt"
	"strings"
	"unicode"
)

func Number(phoneNumber string) (string, error) {
	if strings.Contains(phoneNumber, "+") {
		phoneNumber = phoneNumber[2:]
	} else if strings.HasPrefix(phoneNumber, "1") {
		phoneNumber = phoneNumber[1:]
	}

	result := strings.Map(func(r rune) rune {
		if !unicode.IsDigit(r) {
			return -1
		}
		return r
	}, phoneNumber)

	if len(result) != 10 {
		return "", errors.New("Invalid Phone Number")
	}

	for i, c := range result {
		if i == 0 || i == 3 {
			if int(c) - '0' < 2 {
				return "", errors.New("N cannot be less than 2")
			}
			if !unicode.IsNumber(c) {
				return "", errors.New("X can only be number")
			}
		}
	}

	return result, nil
}

func AreaCode(phoneNumber string) (string, error) {
	cleanedNumber, err := Number(phoneNumber)

	if err != nil {
		return "", errors.New("Invalid Phone Number")
	}

	return cleanedNumber[:3], nil

}

func Format(phoneNumber string) (string, error) {
	cleanedNumber, err := Number(phoneNumber)

	if err != nil {
		return "", errors.New("Invalid Phone Number")
	}

	area, _ := AreaCode(phoneNumber)

	return fmt.Sprintf("(%s) %s-%s", area, cleanedNumber[3:6], cleanedNumber[6:]), nil

}


