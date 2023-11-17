using System;
using System.IO;
using System.Net;
using System.Security.Cryptography;
using System.Text;

namespace template
{
    class Program
    {
        static void Main(string[] args)
        {
            // Example use of hash function
            string hash = "5c5765aa7224eab733473471dd6abcb9d15d5e18";

            string testPassword = "Luebeck";
            string test = Hash(testPassword);

            Console.WriteLine("Original hash: " + hash);
            Console.WriteLine("Computed hash: " + test);

            if(hash == test)
                Console.WriteLine("Match!");
            else
                Console.WriteLine("No match.");

            // Example HTTP request
            Console.WriteLine("HTTP Response:");
            Console.WriteLine(HttpGetRequest("https://moodle.uni-luebeck.de/"));
        }

        static string Hash(string password)
        {
            Span<byte> inputBytes = password.Length <= 1024 ? stackalloc byte[password.Length] : new byte[password.Length];
            Encoding.ASCII.GetBytes(password, inputBytes);

            Span<byte> hash = stackalloc byte[160 / 8];
            SHA1.Create().TryComputeHash(inputBytes, hash, out _);

            Span<char> outChars = stackalloc char[160 / 4];
            HexEncoding.BytesToHexString(hash, outChars);
            return new string(outChars);
        }

        static string HttpGetRequest(string url)
        {
            // Run request
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);
            request.AutomaticDecompression = DecompressionMethods.GZip | DecompressionMethods.Deflate;
            using HttpWebResponse response = (HttpWebResponse)request.GetResponse();
            
            // Extract response
            using Stream stream = response.GetResponseStream();
            using StreamReader reader = new StreamReader(stream);
            return reader.ReadToEnd();
        }
    }
}