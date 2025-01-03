package iih.ei.std.d.v1.sc.mtscdbsrv.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技诊疗项目字典入参 DTO数据 
 * 
 */
public class MtScDbSrvParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医技项目分类id
	 * @return String
	 */
	public String getId_scca() {
		return ((String) getAttrVal("Id_scca"));
	}	
	/**
	 * 医技项目分类id
	 * @param Id_scca
	 */
	public void setId_scca(String Id_scca) {
		setAttrVal("Id_scca", Id_scca);
	}
	/**
	 * 分页信息
	 * @return String
	 */
	public FArrayList getPageinfo() {
		return ((FArrayList) getAttrVal("Pageinfo"));
	}	
	/**
	 * 分页信息
	 * @param Pageinfo
	 */
	public void setPageinfo(FArrayList Pageinfo) {
		setAttrVal("Pageinfo", Pageinfo);
	}
}