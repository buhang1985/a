package iih.bl.pay.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 专用款销售用服务包dto3 DTO数据 
 * 
 */
public class BdPriSrvPkgVsItmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务包
	 * @return String
	 */
	public String getId_srvpkg() {
		return ((String) getAttrVal("Id_srvpkg"));
	}
	/**
	 * 服务包
	 * @param Id_srvpkg
	 */
	public void setId_srvpkg(String Id_srvpkg) {
		setAttrVal("Id_srvpkg", Id_srvpkg);
	}
	/**
	 * 费用包明细
	 * @return String
	 */
	public String getId_pripkgitm() {
		return ((String) getAttrVal("Id_pripkgitm"));
	}
	/**
	 * 费用包明细
	 * @param Id_pripkgitm
	 */
	public void setId_pripkgitm(String Id_pripkgitm) {
		setAttrVal("Id_pripkgitm", Id_pripkgitm);
	}
	/**
	 * 服务包明细项目对照
	 * @return String
	 */
	public String getId_srvpkgitmcomp() {
		return ((String) getAttrVal("Id_srvpkgitmcomp"));
	}
	/**
	 * 服务包明细项目对照
	 * @param Id_srvpkgitmcomp
	 */
	public void setId_srvpkgitmcomp(String Id_srvpkgitmcomp) {
		setAttrVal("Id_srvpkgitmcomp", Id_srvpkgitmcomp);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
}