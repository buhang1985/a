package iih.mp.dg.dto.opdgdisp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 摆药单打印条件 DTO数据 
 * 
 */
public class PresDispPrintCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 打印范围
	 * @return Integer
	 */
	public Integer getEu_printrange() {
		return ((Integer) getAttrVal("Eu_printrange"));
	}
	/**
	 * 打印范围
	 * @param Eu_printrange
	 */
	public void setEu_printrange(Integer Eu_printrange) {
		setAttrVal("Eu_printrange", Eu_printrange);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDesc() {
		return ((String) getAttrVal("Desc"));
	}
	/**
	 * 描述
	 * @param Desc
	 */
	public void setDesc(String Desc) {
		setAttrVal("Desc", Desc);
	}
	/**
	 * 站点id
	 * @return String
	 */
	public String getId_quesite() {
		return ((String) getAttrVal("Id_quesite"));
	}
	/**
	 * 站点id
	 * @param Id_quesite
	 */
	public void setId_quesite(String Id_quesite) {
		setAttrVal("Id_quesite", Id_quesite);
	}
	/**
	 * 窗口名称
	 * @return String
	 */
	public String getQuesite_name() {
		return ((String) getAttrVal("Quesite_name"));
	}
	/**
	 * 窗口名称
	 * @param Quesite_name
	 */
	public void setQuesite_name(String Quesite_name) {
		setAttrVal("Quesite_name", Quesite_name);
	}
	/**
	 * 药房名称
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}
	/**
	 * 药房名称
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	/**
	 * 预交金模式
	 * @return String
	 */
	public String getPrepaymode() {
		return ((String) getAttrVal("Prepaymode"));
	}
	/**
	 * 预交金模式
	 * @param Prepaymode
	 */
	public void setPrepaymode(String Prepaymode) {
		setAttrVal("Prepaymode", Prepaymode);
	}
	/**
	 * 分窗口模式
	 * @return Integer
	 */
	public Integer getWindmode() {
		return ((Integer) getAttrVal("Windmode"));
	}
	/**
	 * 分窗口模式
	 * @param Windmode
	 */
	public void setWindmode(Integer Windmode) {
		setAttrVal("Windmode", Windmode);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_routes() {
		return ((String) getAttrVal("Id_routes"));
	}
	/**
	 * 用法
	 * @param Id_routes
	 */
	public void setId_routes(String Id_routes) {
		setAttrVal("Id_routes", Id_routes);
	}
}