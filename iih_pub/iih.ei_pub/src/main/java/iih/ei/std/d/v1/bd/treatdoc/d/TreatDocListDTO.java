package iih.ei.std.d.v1.bd.treatdoc.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;
import iih.ei.std.d.v1.commdto.d.PageInfoDTO;

/**
 * 诊疗项目档案列表DTO DTO数据 
 * 
 */
public class TreatDocListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	/**
	 * 诊疗项目档案
	 * @return String
	 */
	public String getTreatdoc() {
		return ((String) getAttrVal("Treatdoc"));
	}	
	/**
	 * 诊疗项目档案
	 * @param Treatdoc
	 */
	public void setTreatdoc(String Treatdoc) {
		setAttrVal("Treatdoc", Treatdoc);
	}
}