package iih.mbh.mp.orplan.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class MpOrPlanDTO {

	// 操作类型
	@RPCField(id = 1)
	private String opertype;
	// 执行计划集合
	@RPCField(id = 2)
	private List<MOrPlanDTO> morplandtos;
	// 原因档案集合
	@RPCField(id = 3)
	private List<MBHUdidocDTO> udidoclist;

	public String getOpertype() {
		return opertype;
	}

	public void setOpertype(String opertype) {
		this.opertype = opertype;
	}

	public List<MOrPlanDTO> getMorplandtos() {
		return morplandtos;
	}

	public void setMorplandtos(List<MOrPlanDTO> morplandtos) {
		this.morplandtos = morplandtos;
	}

	public List<MBHUdidocDTO> getUdidoclist() {
		return udidoclist;
	}

	public void setUdidoclist(List<MBHUdidocDTO> udidoclist) {
		this.udidoclist = udidoclist;
	}

}
