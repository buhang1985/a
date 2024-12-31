package iih.bl.cg.service.d;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList2;
/**
 * 批处理费用结果DTO
 * @author tcy
 *
 */
public class Bl_BatchAppendBillDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 成功补退费DTO
	 * @return BlOrderAppendBillParamDTO
	 */
	public FArrayList2 getBlOrderAppendBillParamDTO() {
		return ((FArrayList2) getAttrVal("BlOrderAppendBillParamDTO"));
	}
	public void setBlOrderAppendBillParamDTO(FArrayList2 BlOrderAppendBillParamDTO) {
		setAttrVal("BlOrderAppendBillParamDTO", BlOrderAppendBillParamDTO);
	}
	
	/**
	 * 校验失败的id_ent.<id_ent,失败原因>
	 * @return
	 */
	public Map<String,String> getFail_Ident_tip() {
		return ((Map<String,String>) getAttrVal("Fail_Ident_tip"));
	}
	public void setFail_Ident_tip(Map<String,String> Fail_Ident_tip) {
		setAttrVal("Fail_Ident_tip", Fail_Ident_tip);
	}
	
	/**
	 * 成功计价的id_ent.
	 * @return
	 */
	public List<String> getSucc_Ident() {
		return ((List<String>) getAttrVal("Succ_Ident"));
	}
	public void setSucc_Ident(List<String> Succ_Ident) {
		setAttrVal("Succ_Ident", Succ_Ident);
	}
}
