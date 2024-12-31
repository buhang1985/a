package iih.mp.ne.transfusiondto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 生命体征明细 DTO数据 
 * 
 */
public class SrvvtDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体征主键
	 * @return String
	 */
	public String getId_srvvt() {
		return ((String) getAttrVal("Id_srvvt"));
	}
	/**
	 * 体征主键
	 * @param Id_srvvt
	 */
	public void setId_srvvt(String Id_srvvt) {
		setAttrVal("Id_srvvt", Id_srvvt);
	}
	/**
	 * 医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 数据元
	 * @return String
	 */
	public String getId_de() {
		return ((String) getAttrVal("Id_de"));
	}
	/**
	 * 数据元
	 * @param Id_de
	 */
	public void setId_de(String Id_de) {
		setAttrVal("Id_de", Id_de);
	}
	/**
	 * 最大值
	 * @return String
	 */
	public String getValmax() {
		return ((String) getAttrVal("Valmax"));
	}
	/**
	 * 最大值
	 * @param Valmax
	 */
	public void setValmax(String Valmax) {
		setAttrVal("Valmax", Valmax);
	}
	/**
	 * 最小值
	 * @return String
	 */
	public String getValmin() {
		return ((String) getAttrVal("Valmin"));
	}
	/**
	 * 最小值
	 * @param Valmin
	 */
	public void setValmin(String Valmin) {
		setAttrVal("Valmin", Valmin);
	}
	/**
	 * 值类型
	 * @return String
	 */
	public String getDatatype() {
		return ((String) getAttrVal("Datatype"));
	}
	/**
	 * 值类型
	 * @param Datatype
	 */
	public void setDatatype(String Datatype) {
		setAttrVal("Datatype", Datatype);
	}
}