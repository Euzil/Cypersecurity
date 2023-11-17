package banking.server;

/**
 * Helper class for tuples.
 *
 * @param <X> The first tuple type.
 * @param <Y> The second tuple type.
 * @param x   The first value.
 * @param y   The second value.
 */
public record Tuple<X, Y>(X x, Y y)
{
}