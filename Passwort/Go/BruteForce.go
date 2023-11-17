package main

import (
	"crypto/sha512"
	"encoding/base64"
	"fmt"
)

func main() {
	//example use of hashfunction
	hash := "$42$12salt34$rLGE6snqDMod/fcG1kaBcsaohODHTc27xZpDFvh4UIiA/voH323UOQCLfDG07/NmmID4UAa8BevwDHVVqZu77g=="
	testPassword := "Cybersecurity"
	testSalt := "12salt34"

	test := hashPassword(testSalt, testPassword)

	fmt.Println("Original hash: " + hash)
	fmt.Println("Computed hash: " + test)

}

func hashPassword(salt string, password string) string {
	m := sha512.New()

	// Calculate hash value for message string
	m.Write([]byte(salt))
	m.Write([]byte(password))

	// Return pattern: $our-special-sha-512$salt$hashvalue in Base-64 encoding
	return ("&42&" + salt + "$" + base64.StdEncoding.EncodeToString(m.Sum(nil)))
}
