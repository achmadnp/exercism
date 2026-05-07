package highscores

type HighScores struct{
	scores []int
}

// NewHighScores returns a new HighScores object.
func NewHighScores(scores []int) *HighScores {
	return &HighScores{
		scores: scores,
	}
}

// Scores returns all the scores.
func (s *HighScores) Scores() []int {
	return s.scores
}

// Latest returns the latest (last) score.
func (s *HighScores) Latest() int {
	return s.scores[len(s.scores) - 1]
}

// PersonalBest returns the best (highest) score.
func (s *HighScores) PersonalBest() int {
	var best = 0
	for _, s := range s.scores {
		if s > best {
			best = s
		}
	}
	return best
}

func (s *HighScores) GetBestIndex() int {
	var best = 0
	var index = 0
	for i, s := range s.scores {
		if s > best {
			best = s
			index = i
		}
	}
			return index
}

// TopThree returns the top three scores.
func (s *HighScores) TopThree() []int {
	var topThree []int
	

	copiedScores := make([]int, len(s.scores))
	copy(copiedScores, s.scores)
	dst := HighScores{
		scores: copiedScores,
	}
	
	for range 3 {
		topThree = append(topThree, dst.PersonalBest())
		dst.scores = append(dst.scores[:dst.GetBestIndex()], dst.scores[(dst.GetBestIndex()+1):]...)
		if len(dst.scores) < 1 {
			break
		}
	}



	return topThree
}
