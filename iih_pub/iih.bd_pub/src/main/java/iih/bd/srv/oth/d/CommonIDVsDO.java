package iih.bd.srv.oth.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 通用主键值实体 DTO数据 
 * 
 */
public class CommonIDVsDO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 业务主键
	 * @return String
	 */
	public String getId_biz() {
		return ((String) getAttrVal("Id_biz"));
	}
	/**
	 * 业务主键
	 * @param Id_biz
	 */
	public void setId_biz(String Id_biz) {
		setAttrVal("Id_biz", Id_biz);
	}
	/**
	 * 值1
	 * @return String
	 */
	public String getV1() {
		return ((String) getAttrVal("V1"));
	}
	/**
	 * 值1
	 * @param V1
	 */
	public void setV1(String V1) {
		setAttrVal("V1", V1);
	}
	/**
	 * 值2
	 * @return String
	 */
	public String getV2() {
		return ((String) getAttrVal("V2"));
	}
	/**
	 * 值2
	 * @param V2
	 */
	public void setV2(String V2) {
		setAttrVal("V2", V2);
	}
	/**
	 * 值3
	 * @return String
	 */
	public String getV3() {
		return ((String) getAttrVal("V3"));
	}
	/**
	 * 值3
	 * @param V3
	 */
	public void setV3(String V3) {
		setAttrVal("V3", V3);
	}
	/**
	 * 值4
	 * @return String
	 */
	public String getV4() {
		return ((String) getAttrVal("V4"));
	}
	/**
	 * 值4
	 * @param V4
	 */
	public void setV4(String V4) {
		setAttrVal("V4", V4);
	}
	/**
	 * 值5
	 * @return String
	 */
	public String getV5() {
		return ((String) getAttrVal("V5"));
	}
	/**
	 * 值5
	 * @param V5
	 */
	public void setV5(String V5) {
		setAttrVal("V5", V5);
	}
}