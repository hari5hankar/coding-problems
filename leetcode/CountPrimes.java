import java.util.Arrays;

public class CountPrimes {

	public static int countPrimes(int N) {

		// 0...N-1 boolean indexed array
		boolean primes[] = new boolean[N];

		// always start with 2, 0 and 1 are not prime.
		for (int i = 2; i < primes.length; i++)
			primes[i] = true;

		// starting with 2...sqrt(n), mark all multiples of primes as non-prime
		for (int i = 2; i * i < N; i++)
			if (primes[i] == true)
				for (int j = i + i; j < N; j += i)
					primes[j] = false;

		System.out.println(Arrays.toString(primes));
		int count = 0;
		for (int i = 2; i < primes.length; i++)
			if (primes[i])
				count++;

		return count;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(10));
	}

}
