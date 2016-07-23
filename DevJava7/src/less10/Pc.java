package less10;

public class Pc {

	private Cpu cpu;
	
	private Hdd hdd;
	
	private Memory memory;

	public Pc(Cpu cpu, Hdd hdd, Memory memory) {
		this.cpu = cpu;
		this.hdd = hdd;
		this.memory = memory;
	}
	
	public Pc(double mHz, int hddGb, int memoryGb) {
		cpu = new Cpu(mHz);
		hdd = new Hdd(hddGb);
		memory = new Memory(memoryGb);
	}

	public void raise() {
		cpu.raise();
	}

	public Cpu getCpu() {
		return cpu;
	}

	public void setCpu(Cpu cpu) {
		this.cpu = cpu;
	}

	public Hdd getHdd() {
		return hdd;
	}

	public void setHdd(Hdd hdd) {
		this.hdd = hdd;
	}

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	@Override
	public String toString() {
		return "Pc [cpu=" + cpu + ", hdd=" + hdd + ", memory=" + memory + "]";
	}
}
