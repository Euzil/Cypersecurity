#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct
{
	/* TODO */
} row_t;

static int compare(const void *a, const void *b)
{
	const row_t *rowA = (const row_t *)a;
	const row_t *rowB = (const row_t *)b;
	
	int result;
	/* TODO: result<0 if a<b, result>0 if a>b, result=0 if a==b */
	
	
	return result;
}

int main(int argc, char **argv)
{
	// Read input
	int count;
	scanf("%d", &count);
	/* TODO: Read input */
	
	// Sort
	qsort(/* TODO: ?, ?, ? */, compare);
	
	// Store results
	/* TODO */
	
	// Done
	return 0;
}
