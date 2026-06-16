// This is a "stub" file.  It's a little start on your solution.
// It's not a complete solution though; you have to write some code.

// Package triangle should have a package comment that summarizes what it's about.
// https://golang.org/doc/effective_go.html#commentary
package triangle

// Notice KindFromSides() returns this type. Pick a suitable data type.
type Kind string

const (
	NaT Kind = "NaT" // not a triangle
	Equ Kind = "Equilateral" // equilateral
	Iso Kind = "Isosceles" // isosceles
	Sca Kind = "Scalene" // scalene
)

// KindFromSides should have a comment documenting it.
func KindFromSides(a, b, c float64) Kind {
	var k Kind

	if a <= 0 || b <= 0 || c <= 0 {
		return NaT
	}

	if a + b < c || a + c < b || b + c < a {
		return NaT
	} 

	if a == b && b == c {
		k = Equ
	} else if a == b || b == c || a == c {
		k = Iso
	} else if a != b && a != c && b != c {
		k = Sca
	} else {
		k = NaT
	}

	return k
}
