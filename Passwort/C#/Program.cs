using System;
using System.Security.Cryptography;
using System.Text;

namespace csharp
{
    class Program
    {
        static void Main(string[] args)
        {
            // Example use of hash function
            string hash = "$42$12salt34$rLGE6snqDMod/fcG1kaBcsaohODHTc27xZpDFvh4UIiA/voH323UOQCLfDG07/NmmID4UAa8BevwDHVVqZu77g==";

            string testPassword = "Cybersecurity";
            string testSalt = "12salt34";
            string test = Hash(testPassword, testSalt);

            Console.WriteLine("Original hash: " + hash);
            Console.WriteLine("Computed hash: " + test);

            if(hash == test)
                Console.WriteLine("Match!");
            else
                Console.WriteLine("No match.");
        }

        static string Hash(string password, string salt)
        {
            int inputBytesLength = salt.Length + password.Length;
            Span<byte> inputBytes = inputBytesLength <= 1024 ? stackalloc byte[inputBytesLength] : new byte[inputBytesLength];
            Encoding.ASCII.GetBytes(salt.AsSpan(), inputBytes.Slice(0, salt.Length));
            Encoding.ASCII.GetBytes(password.AsSpan(), inputBytes.Slice(salt.Length, password.Length));

            Span<byte> hash = stackalloc byte[512 / 8];
            SHA512.Create().TryComputeHash(inputBytes, hash, out _);
            return $"$42${salt}${ Convert.ToBase64String(hash) }";
        }
    }
}
