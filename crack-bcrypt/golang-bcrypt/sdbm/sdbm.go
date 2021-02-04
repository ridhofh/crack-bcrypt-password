// PT Dymar Jaya Indonesia
// sdbm - search database matching
// searching list bcrypt database with spesific password
// required: go get golang.org/x/crypto/bcrypt
package main

import (
	"bufio"
	"flag"
	"fmt"
	"log"
	"os"

	"golang.org/x/crypto/bcrypt"
)

func HashPassword(password string) (string, error) {
	bytes, err := bcrypt.GenerateFromPassword([]byte(password), 14)
	return string(bytes), err
}

func CheckPasswordHash(password, hash string) bool {
	err := bcrypt.CompareHashAndPassword([]byte(hash), []byte(password))
	return err == nil
}

func main() {

	flag.Usage = func() {
		fmt.Printf("Usage: %s <bcrypt database file name> <clear password>\n", os.Args[0])
		flag.PrintDefaults()
	}

	flag.Parse()
	if flag.NArg() != 2 {
		flag.Usage()
		os.Exit(1)
	}

	fileName := os.Args[1]
	file, err := os.Open(fileName)

	if err != nil {
		log.Fatalf("failed opening file: %s", err)
	}

	scanner := bufio.NewScanner(file)
	scanner.Split(bufio.ScanLines)
	var txtlines []string

	for scanner.Scan() {
		txtlines = append(txtlines, scanner.Text())
	}

	file.Close()

	password := os.Args[2]

	for _, eachline := range txtlines {
		match := CheckPasswordHash(password, eachline)
		if match == true {
			fmt.Println(eachline)
		}
	}

}
