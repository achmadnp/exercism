package proteintranslation

import "errors"

var ErrStop = errors.New("stop codon")
var ErrInvalidBase = errors.New("invalid base")

var codonTable = map[string]string{
	"AUG": "Methionine",
	"UUU": "Phenylalanine", "UUC": "Phenylalanine",
	"UUA": "Leucine", "UUG": "Leucine",
	"UCU": "Serine", "UCC": "Serine", "UCA": "Serine", "UCG": "Serine",
	"UAU": "Tyrosine", "UAC": "Tyrosine",
	"UGU": "Cysteine", "UGC": "Cysteine",
	"UGG": "Tryptophan",
	"UAA": "", "UAG": "", "UGA": "",
}


func FromCodon(codon string) (string, error) {
	protein, ok := codonTable[codon]
	if !ok {
		return "", ErrInvalidBase
	}
	if codon == "UAA" || codon == "UAG" || codon == "UGA" {
		return "", ErrStop
	}
	return protein, nil
}

func FromRNA(rna string) ([]string, error) {
	var proteins []string
	for i := 0; i+3 <= len(rna); i += 3 {
		protein, err := FromCodon(rna[i : i+3])
		if err == ErrStop {
			return proteins, nil
		}
		if err != nil {
			return nil, err
		}
		proteins = append(proteins, protein)
	}
	if len(rna)%3 != 0 {
		return nil, ErrInvalidBase
	}
	return proteins, nil
}