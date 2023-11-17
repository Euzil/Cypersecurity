import sys
import hashlib
import base64
import itertools


def example() -> None:
    # example use of hashfunction
    test_hash = "$42$12salt34$rLGE6snqDMod/fcG1kaBcsaohODHTc27xZpDFvh4UIiA/voH323UOQCLfDG07/NmmID4UAa8BevwDHVVqZu77g=="
    test_password = "Cybersecurity"
    test_salt = "12salt34"

    test = "$42$" + test_salt + "$" + hash(test_password, test_salt)

    print("Original hash: " + test_hash)
    print("Computed hash: " + test)

    if test_hash == test:
        print("Match!")
    else:
        print("No match.")


def hash(password: str, salt: str) -> str:
    try:
        m = hashlib.sha512()
        m.update(salt.encode())
        m.update(password.encode())
        return f"{base64.b64encode(m.digest()).decode()}"
    except Exception as e:
        print("Exception:", e)
        return ""


if __name__ == '__main__':
    example()
