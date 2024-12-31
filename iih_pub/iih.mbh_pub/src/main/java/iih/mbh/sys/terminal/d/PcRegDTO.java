package iih.mbh.sys.terminal.d;


/**
 * 终端注册参数
 * 
 */
public class PcRegDTO{
	
	/** 终端标识 */
	private String pcid;
	/** 名称 */
	private String name;
	/** 操作系统 */
	private String osname;
	/** 内存信息 */
	private String meminfo;
	/** IP地址 */
	private String ip_addr;
	/** Mac地址 */
	private String macaddr;
	/** 扩展字段1 */
	private String def1;
	/** 扩展字段2 */
	private String def2;
	/** 扩展字段3 */
	private String def3;
	/** 扩展字段4 */
	private String def4;

	/** getter and setter */
	
	public String getPcid(){
		return this.pcid;
	}

	public void setPcid(String pcid){
		this.pcid = pcid;
	}
	
	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public String getOsname(){
		return this.osname;
	}

	public void setOsname(String osname){
		this.osname = osname;
	}
	
	public String getMeminfo(){
		return this.meminfo;
	}

	public void setMeminfo(String meminfo){
		this.meminfo = meminfo;
	}
	
	public String getIp_addr(){
		return this.ip_addr;
	}

	public void setIp_addr(String ip_addr){
		this.ip_addr = ip_addr;
	}
	
	public String getMacaddr(){
		return this.macaddr;
	}

	public void setMacaddr(String macaddr){
		this.macaddr = macaddr;
	}
	
	public String getDef1(){
		return this.def1;
	}

	public void setDef1(String def1){
		this.def1 = def1;
	}
	
	public String getDef2(){
		return this.def2;
	}

	public void setDef2(String def2){
		this.def2 = def2;
	}
	
	public String getDef3(){
		return this.def3;
	}

	public void setDef3(String def3){
		this.def3 = def3;
	}
	
	public String getDef4(){
		return this.def4;
	}

	public void setDef4(String def4){
		this.def4 = def4;
	}
}