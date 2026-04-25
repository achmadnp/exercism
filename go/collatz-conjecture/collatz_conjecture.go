package collatzconjecture

import "errors"

func CollatzConjecture(n int) (int, error) {
    if n < 1 {
        return n, errors.New("Number cannot be lower than 1")
    }
    step := 0
    num := n
    
    for num != 1 {
        if num % 2 == 0 {
            num = num / 2
        } else {
            num = num * 3 + 1
        }
        step++
    }

    return step, nil
}
