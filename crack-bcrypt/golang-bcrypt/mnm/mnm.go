// PT Dymar Jaya Indonesia
// mnm - mix and match
// mix between bfda and sdbm functionality
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
		fmt.Printf("Usage: %s <bcrypt database file name> <dictionary file name>\n", os.Args[0])
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

	fileName2 := os.Args[2]
	file2, err := os.Open(fileName2)

	if err != nil {
		log.Fatalf("failed opening file: %s", err)
	}
	
	scanner := bufio.NewScanner(file)
	scanner.Split(bufio.ScanLines)
	var txtlines []string

	for scanner.Scan() {
		txtlines = append(txtlines, scanner.Text())
	}
	
	scanner2 := bufio.NewScanner(file2)
	scanner2.Split(bufio.ScanLines)
	var txtlines2 []string

	for scanner2.Scan() {
		txtlines2 = append(txtlines2, scanner2.Text())
	}

	file.Close()
	file2.Close()

	for _, eachline := range txtlines {
		for _, eachline2 := range txtlines2 {
			match := CheckPasswordHash(eachline2, eachline)
			if match == true {
				fmt.Println(eachline +":"+ eachline2)
			}
		}
	}

}
