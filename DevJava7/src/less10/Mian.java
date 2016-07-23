package less10;

public class Mian {

	public static void main(String[] args) {
		Pc pc = new Pc(new Cpu(3.4), new Hdd(500), new Memory(4));
		System.out.println(pc);
		Pc pc2 = new Pc(2.3, 1000, 4);
		System.out.println(pc2);
		Pc[] pcs = new Pc[2];
		pcs[0] = pc;
		pcs[1] = pc2;
		int i = 5;
		Integer in = new Integer(5);
		if(in!=null){
			
		}
		
	}
}
