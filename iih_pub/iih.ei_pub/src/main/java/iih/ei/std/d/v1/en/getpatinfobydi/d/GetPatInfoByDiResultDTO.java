package iih.ei.std.d.v1.en.getpatinfobydi.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;

/**
 * 获取患者信息by诊断出参 DTO数据 
 * 
 */
public class GetPatInfoByDiResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者信息
	 * @return String
	 */
	public FArrayList getPatinfo() {
		return ((FArrayList) getAttrVal("Patinfo"));
	}	
	/**
	 * 患者信息
	 * @param Patinfo
	 */
	public void setPatinfo(FArrayList Patinfo) {
		setAttrVal("Patinfo", Patinfo);
	}
	/**
	 * 分页信息
	 * @return String
	 */
	public PageInfoDTO getPageinfo() {
		return ((PageInfoDTO) getAttrVal("Pageinfo"));
	}	
	/**
	 * 分页信息
	 * @param Pageinfo
	 */
	public void setPageinfo(PageInfoDTO Pageinfo) {
		setAttrVal("Pageinfo", Pageinfo);
	}
}