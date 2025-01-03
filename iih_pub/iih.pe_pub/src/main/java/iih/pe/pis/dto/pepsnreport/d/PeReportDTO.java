package iih.pe.pis.dto.pepsnreport.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PeReportDTO {

	// 个人基本资料
	@RPCField(id = 1)
	private List<PePsnRptBInfoDTO> binfos;
	// 总检内容
	@RPCField(id = 2)
	private List<PePsnRptOvalDTO> ovals;
	// 一般项目
	@RPCField(id = 3)
	private List<PePsnRptGenDTO> gens;
	// 专科检查
	@RPCField(id = 4)
	private List<PePsnRptPhyDTO> phys;
	// 医技检查
	@RPCField(id = 5)
	private List<PePsnRptPhyDTO> tecs;
	// 实验室检查
	@RPCField(id = 6)
	private List<PePsnRptLisDTO> liss;

	public List<PePsnRptBInfoDTO> getBinfos() {
		return binfos;
	}

	public void setBinfos(List<PePsnRptBInfoDTO> binfos) {
		this.binfos = binfos;
	}

	public List<PePsnRptOvalDTO> getOvals() {
		return ovals;
	}

	public void setOvals(List<PePsnRptOvalDTO> ovals) {
		this.ovals = ovals;
	}

	public List<PePsnRptGenDTO> getGens() {
		return gens;
	}

	public void setGens(List<PePsnRptGenDTO> gens) {
		this.gens = gens;
	}

	public List<PePsnRptPhyDTO> getPhys() {
		return phys;
	}

	public void setPhys(List<PePsnRptPhyDTO> phys) {
		this.phys = phys;
	}

	public List<PePsnRptPhyDTO> getTecs() {
		return tecs;
	}

	public void setTecs(List<PePsnRptPhyDTO> tecs) {
		this.tecs = tecs;
	}

	public List<PePsnRptLisDTO> getLiss() {
		return liss;
	}

	public void setLiss(List<PePsnRptLisDTO> liss) {
		this.liss = liss;
	}

}
