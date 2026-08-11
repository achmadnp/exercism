package anagram

import (
	"sort"
	"strings"
)


func Detect(subject string, candidates []string) []string {
	anagrams := []string{}

	input := SortString(strings.ToLower(subject))

	for _, v := range candidates {
		if len(input) != len(v) || strings.EqualFold(subject, v) {
			continue
		}

		if input == SortString(strings.ToLower(v)) {
			anagrams = append(anagrams, v)
		}
	}

	return anagrams
}


func SortString(input string) string {
	split := strings.Split(input, "")
	sort.Strings(split)

	return strings.Join(split, "")

}