#include <stdio.h>
#include <stdlib.h>

static void copy_reverse(int *source, int *destination, int length)
{
	int *srcPtr = &source[length];
	int *destPtr = destination;
	while(srcPtr > source)
		*destPtr++ = *--srcPtr;
}

int main(int argc, char **argv)
{
	printf("How many numbers? ");
	int count;
	scanf("%d", &count);
	
	int *input = malloc(count * sizeof(int));
	int *output = malloc(count * sizeof(int));
	
	printf("Type %d numbers: \n", count);
	for(int i = 0; i < count; ++i)
		scanf("%d", &input[i]);
	
	copy_reverse(input, output, count);
	
	printf("Reversed: ");
	for(int i = 0; i < count; ++i)
		printf("%d ", output[i]);
	printf("\n");
	
	free(input);
	free(output);
	
	return 0;
}