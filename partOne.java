package part2;

import part2.mainClass.Computer;

public class partOne {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Computer c1 = new Computer("msi", "GAC1111", 111885654, 1000.00);
		Computer c2 = new Computer("hp", "GAC2222", 222885654, 2000.00);
		Computer c3 = new Computer("dell", "GAC3333", 333885654, 3000.00);
		Computer c4 = new Computer("apple", "GAC4444", 444885654, 4000.00);
		Computer c5 = new Computer("msi", "GAC1111", 1118834654, 1000.00);
		System.out.println("Are Equal: " + c1.areEqualObjects(c2, c5));
		System.out.println("Get all data: " + c1.getAllData());
		System.out.println("All data: " + Computer.getMaster().toString());
	}
}
