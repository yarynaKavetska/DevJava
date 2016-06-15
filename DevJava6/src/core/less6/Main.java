package core.less6;

public class Main {

	public static void main(String[] args) {
		Cpu cpu = new Cpu(3.2, 4);
		Ram ram = new Ram(1600, 4);
		Ssd ssd = new Ssd(128);
		PersonalComputer computer = 
				new PersonalComputer(cpu, ram, ssd);
		System.out.println(computer);
		computer.boost();
		computer.addRam(new Ram(1600, 4));
		System.out.println(computer);
		PersonalComputer computer1 = 
			new PersonalComputer(new Cpu(4, 8), new Ram(2100, 16), new Ssd(256));
		PersonalComputer computer2 = new PersonalComputer(3, 4, 2100, 4, 128);
		computer1.setGpu(new Gpu(2, 4000));
		computer1.addGpu(new Gpu(2, 4000));
		System.out.println(computer1);
	}

}
