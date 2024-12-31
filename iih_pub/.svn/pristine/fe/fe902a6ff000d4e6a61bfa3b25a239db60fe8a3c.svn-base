package iih.mbh.mp.queryexe.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class QueryPatInfoDTO {

	// 患者姓名
	@RPCField(id = 1)
	private String name_pat;
	// 床号
	@RPCField(id = 2)
	private String bed_code;
	// 执行计划
	@RPCField(id = 3)
	private List<QueryExeInfoDTO> exePlans;
	// 就诊id
	@RPCField(id = 4)
	private String id_ent;

	public String getName_pat() {
		return name_pat;
	}

	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}

	public String getBed_code() {
		return bed_code;
	}

	public void setBed_code(String bed_code) {
		this.bed_code = bed_code;
	}

	public List<QueryExeInfoDTO> getExePlans() {
		return exePlans;
	}

	public void setExePlans(List<QueryExeInfoDTO> exePlans) {
		this.exePlans = exePlans;
	}

	public String getId_ent() {
		return id_ent;
	}

	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}

}
