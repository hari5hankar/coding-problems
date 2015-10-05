import java.util.ArrayList;
import java.util.List;

/*
 * find out all prime numbers less than N
 * sieve of eratosthenes
 */
public class PrimeNumbers {

	public static List<Integer> primes(int n) {

		/* boolean array indexed by numbers <= n */
		/* to indicate if number is prime */
		int N = n + 1;
		boolean[] isPrime = new boolean[N];

		/* initially all numbers from 2...n are prime */
		for (int i = 2; i < N; i++) {
			isPrime[i] = true;
		}

		/*
		 * starting with i = 2, if i is prime, mark all multiples of i as
		 * non-prime. continue with the next prime i = 3, and so on. It is
		 * sufficient to do this for primes i <= srqt(N). Reason: all numbers
		 * less than N which are multiples of any i > sqrt(N) are also multiples of smaller primes, and
		 * they would have been marked as non -prime when they were being
		 * processed.
		 */
		for (int i = 2; i * i < N; i++) {

			if (isPrime[i] == true) {
				for (int j = i + i; j < N; j += i) {
					isPrime[j] = false;
				}
			}
		}

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 2; i < N; i++) {
			if (isPrime[i] == true)
				list.add(i);
		}
		return list;
	}

	public static void main(String[] args) {
		System.out.println(primes(5).toString());
	}

}
