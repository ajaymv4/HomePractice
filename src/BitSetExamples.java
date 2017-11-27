import java.util.BitSet;

public class BitSetExamples {

	public static void main(String[] args) {

		BitSet bs = new BitSet();

		bs.set(33);

		int[] intArray = bits2Ints(bs);

		System.out.println("Size of one Bitset " + bs.size());

		System.out.println("value " + bs.get(2));

		int[] arr = new int[64];

		arr[0] = 2;
		
		arr[0] |= 1 << 4;
				
				System.out.println(arr[0]);

		
		for (int i = bs.size() - 1; i >= 0; i--) {

			if (bs.get(i)) {
				System.out.print("1");
				arr[i] = 1;
			} else {
				arr[i] = 0;
				System.out.print("0");
			}
		}
		
		
				System.out.println(intArray[0]);
				
		
		  for (int i = 0; i < intArray.length; i++)
		  System.out.println(toBinary(intArray[i]));
		 
	}

	static int[] bits2Ints(BitSet bs) {
		int[] temp = new int[bs.size() / 32];

		for (int i = 0; i < temp.length; i++)
			for (int j = 0; j < 32; j++)
				if (bs.get(i * 32 + j))
					temp[i] |= 1 << j;

		return temp;
	}

	static String toBinary(int num) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < 32; i++) {
			sb.append(((num & 1) == 1) ? '1' : '0');
			num >>= 1;
		}

		return sb.reverse().toString();
	}

}
