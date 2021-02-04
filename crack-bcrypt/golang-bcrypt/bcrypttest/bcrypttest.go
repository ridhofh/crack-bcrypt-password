// PT Dymar Jaya Indonesia
// Bcrypt test
// required: go get golang.org/x/crypto/bcrypt
package main

import (
	"flag"
	"fmt"
	"os"

	"golang.org/x/crypto/bcrypt"
)

func HashPassword(password string) (string, error) {
	//cost factor. min:4, max:31
	bytes, err := bcrypt.GenerateFromPassword([]byte(password), 10)
	return string(bytes), err
}

func CheckPasswordHash(password, hash string) bool {
	err := bcrypt.CompareHashAndPassword([]byte(hash), []byte(password))
	return err == nil
}

func main() {

	flag.Usage = func() {
		fmt.Printf("Usage: %s <data>\n", os.Args[0])
		flag.PrintDefaults()
	}

	flag.Parse()
	if flag.NArg() != 1 {
		flag.Usage()
		os.Exit(1)
	}

	data := os.Args[1]
	hash, _ := HashPassword(data) // ignore error for the sake of simplicity
	
	fmt.Println("data: ",data )
	fmt.Println("prefix:", string(hash)[1:1+2])
	fmt.Println("log rounds: ", string(hash)[4:4+2])
	fmt.Println("salt: ", string(hash)[7:7+22])
	fmt.Println("hash: ", string(hash)[29:])
	fmt.Println("bcrypt: ", hash)

	//match := CheckPasswordHash(password, hash)
	//fmt.Println("Match:   ", match)
}
