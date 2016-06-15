package core.less6;

public class PersonalComputer {

	private final Cpu cpu;
	
	private final Ram ram;
	
	private final Ssd ssd;
	
	private Gpu gpu;

	public PersonalComputer(Cpu cpu, Ram ram, Ssd ssd, Gpu gpu) {
		this.cpu = cpu;
		this.ram = ram;
		this.ssd = ssd;
		this.gpu = gpu;
	}

	public PersonalComputer(Cpu cpu, Ram ram, Ssd ssd) {
		this.cpu = cpu;
		this.ram = ram;
		this.ssd = ssd;
	}
	
	public PersonalComputer(double cpuMHz, int cpuAmountOfCores,
			int ramMHz, int ramCapacity, int ssdCapacity){
		this.cpu=new Cpu(cpuMHz, cpuAmountOfCores);
		this.ram=new Ram(ramMHz, ramCapacity);
		this.ssd=new Ssd(ssdCapacity);
	}
	
	
	public void boost(){
		if(cpu!=null) cpu.boost();
	}
	
	public void addRam(Ram ram) {
		this.ram.addRam(ram);
	}

	public void addGpu(Gpu gpu) {
		this.gpu.addGpu(gpu);
	}

	public Gpu getGpu() {
		return gpu;
	}

	public void setGpu(Gpu gpu) {
		this.gpu = gpu;
	}

	public Cpu getCpu() {
		return cpu;
	}

	public Ram getRam() {
		return ram;
	}

	public Ssd getSsd() {
		return ssd;
	}

	@Override
	public String toString() {
		return "PersonalComputer [cpu=" + cpu + ", ram=" + ram + ", ssd=" + ssd
				+ ", gpu=" + gpu + "]";
	}
}
