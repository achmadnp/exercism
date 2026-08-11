package series

func All(n int, s string) []string {
	var result []string

	if len(s) < n || n < 1 {
		return result
	}

	for i := 0; i < len(s) - n + 1; i++ {
		result = append(result, s[i:n+i])
	}
	return result
}

func UnsafeFirst(n int, s string) string {
	return All(n, s)[0]
}
