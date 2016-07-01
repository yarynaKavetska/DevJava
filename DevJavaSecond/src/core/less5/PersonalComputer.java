package core.less5;

public class PersonalComputer {

	private Cpu cpu = new Cpu();
	
	private Ram ram = new Ram();
	
	private Ssd ssd;
	
	public PersonalComputer(){}
	
	public PersonalComputer(int cpuCountOfCores, int cpuMHz,
			int ramCapacity){
		this.cpu = new Cpu(cpuCountOfCores, cpuMHz);
		this.ram = new Ram(ramCapacity);
	}
	
	public PersonalComputer(int cpuCountOfCores, int cpuMHz,
			int ramCapacity, int ssdCapacity){
		this(cpuCountOfCores, cpuMHz, ramCapacity);
		this.ssd = new Ssd(ssdCapacity);
	}

	public PersonalComputer(Cpu cpu, Ram ram, Ssd ssd) {
		this.cpu = cpu;
		this.ram = ram;
		this.ssd = ssd;
	}
	
	public void boost(){
		cpu.boost();
	}

	public Cpu getCpu() {
		return cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public Ssd getSsd() {
		return ssd;
	}

	public void setSsd(Ssd ssd) {
		this.ssd = ssd;
	}

	@Override
	public String toString() {
		return "PersonalComputer [cpu=" + cpu + ", ram=" + ram + ", ssd=" + ssd
				+ "]";
	}
}
