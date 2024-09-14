#include <stdio.h>

int toUpperCase()
{
	printf("Type string to turn into upper case (at most 9 letters): ");
	char str[10];
	if(fgets(str, 10, stdin) == 0)
		return 0;
	
	// Run through characters and turn into upper case
	for(int i = 0; i < 9; ++i)
	{
		// Lower case letter?
		char c = str[i];
		if('a' <= c && c <= 'z')
			str[i] = c - ('a' - 'A');
	}
	printf("Upper case string: %s\n", str);
}

int main()
{
	toUpperCase();
}