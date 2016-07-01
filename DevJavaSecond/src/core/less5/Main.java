package core.less5;

public class Main {

	public static void main(String[] args) {
		PersonalComputer pc = new PersonalComputer();
		System.out.println(pc);
		PersonalComputer pc1 = new PersonalComputer(4, 3, 8, 128);
		System.out.println(pc1);
		Cpu cpu = new Cpu();
		Ram ram = new Ram();
		Ssd ssd = new Ssd();
		PersonalComputer pc2 = new PersonalComputer(cpu, ram, ssd);
		System.out.println(pc2);
		PersonalComputer pc3 = new PersonalComputer(new Cpu(), new Ram(), new Ssd());
		System.out.println(pc3);
		pc3.boost();
		System.out.println(pc3);
	}
}
