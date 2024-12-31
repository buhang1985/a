package iih.en.que.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 接诊工作站点 DTO数据 
 * 
 */
public class WorkSiteDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 工作站
	 * @return String
	 */
	public String getId_worksite() {
		return ((String) getAttrVal("Id_worksite"));
	}
	/**
	 * 工作站
	 * @param Id_worksite
	 */
	public void setId_worksite(String Id_worksite) {
		setAttrVal("Id_worksite", Id_worksite);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getSitedesc() {
		return ((String) getAttrVal("Sitedesc"));
	}
	/**
	 * 描述
	 * @param Sitedesc
	 */
	public void setSitedesc(String Sitedesc) {
		setAttrVal("Sitedesc", Sitedesc);
	}
	/**
	 * 队列
	 * @return String
	 */
	public String getQueid() {
		return ((String) getAttrVal("Queid"));
	}
	/**
	 * 队列
	 * @param Queid
	 */
	public void setQueid(String Queid) {
		setAttrVal("Queid", Queid);
	}
	/**
	 * 诊断科室
	 * @return String
	 */
	public String getDepid() {
		return ((String) getAttrVal("Depid"));
	}
	/**
	 * 诊断科室
	 * @param Depid
	 */
	public void setDepid(String Depid) {
		setAttrVal("Depid", Depid);
	}
	/**
	 * 排班服务
	 * @return String
	 */
	public String getSchsrvid() {
		return ((String) getAttrVal("Schsrvid"));
	}
	/**
	 * 排班服务
	 * @param Schsrvid
	 */
	public void setSchsrvid(String Schsrvid) {
		setAttrVal("Schsrvid", Schsrvid);
	}
	/**
	 * 队列分诊模式
	 * @return String
	 */
	public String getSdmodel() {
		return ((String) getAttrVal("Sdmodel"));
	}
	/**
	 * 队列分诊模式
	 * @param Sdmodel
	 */
	public void setSdmodel(String Sdmodel) {
		setAttrVal("Sdmodel", Sdmodel);
	}
	/**
	 * 最大申请量
	 * @return Integer
	 */
	public Integer getApplymax() {
		return ((Integer) getAttrVal("Applymax"));
	}
	/**
	 * 最大申请量
	 * @param Applymax
	 */
	public void setApplymax(Integer Applymax) {
		setAttrVal("Applymax", Applymax);
	}
	/**
	 * 资源名
	 * @return String
	 */
	public String getResname() {
		return ((String) getAttrVal("Resname"));
	}
	/**
	 * 资源名
	 * @param Resname
	 */
	public void setResname(String Resname) {
		setAttrVal("Resname", Resname);
	}
	/**
	 * 工作站名
	 * @return String
	 */
	public String getSitename() {
		return ((String) getAttrVal("Sitename"));
	}
	/**
	 * 工作站名
	 * @param Sitename
	 */
	public void setSitename(String Sitename) {
		setAttrVal("Sitename", Sitename);
	}
}