using System;
using System.Globalization;

namespace template
{
    public static class HexEncoding
    {
        /// <summary>
        /// Lookup table for mapping 4 bit numbers to hex digits.
        /// </summary>
        private static readonly char[] _hexDigitLookup;

        /// <summary>
        /// Initializes lookup tables.
        /// </summary>
        static HexEncoding()
        {
            _hexDigitLookup = new char[16];
            for(int i = 0; i < 10; ++i)
                _hexDigitLookup[i] = (char)('0' + i);
            for(int i = 0; i < 6; ++i)
                _hexDigitLookup[10 + i] = (char)('a' + i);
        }

        /// <summary>
        /// Converts the given byte array to a hex string.
        /// </summary>
        /// <param name="bytes">Byte array.</param>
        /// <param name="hex">Preallocated char array for storing the hex string.</param>
        /// <returns></returns>
        public static void BytesToHexString(Span<byte> bytes, Span<char> hex)
        {
            int n = bytes.Length;
            if(hex.Length < 2 * n)
                throw new ArgumentException("The given char output buffer is too small. It should have at least 2*length(bytes) entries.", nameof(hex));

            for(int i = 0; i < n; ++i)
            {
                hex[2 * i] = _hexDigitLookup[bytes[i] >> 4];
                hex[2 * i + 1] = _hexDigitLookup[bytes[i] & 0xF];
            }
        }
    }
}