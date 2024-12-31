package iih.pis.mbw.dto.pismbwpatinsdto.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class PismbwPatInsDTO {

	// 检验结果
	@RPCField(id = 1)
	private List<PismbwPatLabDTO> lab_list;
	// 检查结果
	@RPCField(id = 2)
	private List<PismbwPatObsDTO> obs_list;

	public List<PismbwPatLabDTO> getLab_list() {
		return lab_list;
	}

	public void setLab_list(List<PismbwPatLabDTO> lab_list) {
		this.lab_list = lab_list;
	}

	public List<PismbwPatObsDTO> getObs_list() {
		return obs_list;
	}

	public void setObs_list(List<PismbwPatObsDTO> obs_list) {
		this.obs_list = obs_list;
	}

}
