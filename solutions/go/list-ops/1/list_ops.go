package listops

// IntList is an abstraction of a list of integers which we can define methods on
type IntList []int

func (s IntList) Foldl(fn func(int, int) int, initial int) int {
	acc := initial

	for _, v := range s {
		acc = fn(acc, v)
	}

	return acc
}

func (s IntList) Foldr(fn func(int, int) int, initial int) int {
	acc := initial
	for i := s.Length() - 1; i >= 0; i-- {
		acc = fn(s[i], acc)
	}

	return acc
}

func (s IntList) Filter(fn func(int) bool) IntList {
	result := IntList{}
	for _, v := range s {
		if fn(v) {
			result = append(result, v)
		}
	}
	return result
}

func (s IntList) Length() int {
	return len(s)
}

func (s IntList) Map(fn func(int) int) IntList {
	result := IntList{}
	for _, v := range s {
		result = append(result, fn(v))
	}
	return result
}

func (s IntList) Reverse() IntList {
	result := IntList{}
	for i := len(s) - 1; i >= 0 ; i-- {
		result = append(result, s[i])
	}

	return result
}

func (s IntList) Append(lst IntList) IntList {
	for _, i := range lst {
		s = append(s, i)
	}
	return s
}

func (s IntList) Concat(lists []IntList) IntList {
	for _, list := range lists {
		for _, i := range list {
			s = append(s, i)
		}
	}
	return s
}
