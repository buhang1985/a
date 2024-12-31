package iih.mp.orm.sugnuremp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 护士工作量统计DTO DTO数据 
 * 
 */
public class SugNurEmpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}
	/**
	 * 执行科室名称
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 手术护士名称
	 * @return String
	 */
	public String getSug_nur_name() {
		return ((String) getAttrVal("Sug_nur_name"));
	}
	/**
	 * 手术护士名称
	 * @param Sug_nur_name
	 */
	public void setSug_nur_name(String Sug_nur_name) {
		setAttrVal("Sug_nur_name", Sug_nur_name);
	}
	/**
	 * 一级手术
	 * @return Integer
	 */
	public Integer getSuglv1() {
		return ((Integer) getAttrVal("Suglv1"));
	}
	/**
	 * 一级手术
	 * @param Suglv1
	 */
	public void setSuglv1(Integer Suglv1) {
		setAttrVal("Suglv1", Suglv1);
	}
	/**
	 * 二级手术
	 * @return Integer
	 */
	public Integer getSuglv2() {
		return ((Integer) getAttrVal("Suglv2"));
	}
	/**
	 * 二级手术
	 * @param Suglv2
	 */
	public void setSuglv2(Integer Suglv2) {
		setAttrVal("Suglv2", Suglv2);
	}
	/**
	 * 三级手术
	 * @return Integer
	 */
	public Integer getSuglv3() {
		return ((Integer) getAttrVal("Suglv3"));
	}
	/**
	 * 三级手术
	 * @param Suglv3
	 */
	public void setSuglv3(Integer Suglv3) {
		setAttrVal("Suglv3", Suglv3);
	}
	/**
	 * 四级手术
	 * @return Integer
	 */
	public Integer getSuglv4() {
		return ((Integer) getAttrVal("Suglv4"));
	}
	/**
	 * 四级手术
	 * @param Suglv4
	 */
	public void setSuglv4(Integer Suglv4) {
		setAttrVal("Suglv4", Suglv4);
	}
	/**
	 * 其它等级手术
	 * @return Integer
	 */
	public Integer getSuglv() {
		return ((Integer) getAttrVal("Suglv"));
	}
	/**
	 * 其它等级手术
	 * @param Suglv
	 */
	public void setSuglv(Integer Suglv) {
		setAttrVal("Suglv", Suglv);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 手术开始时间
	 * @return String
	 */
	public String getDt_st_op() {
		return ((String) getAttrVal("Dt_st_op"));
	}
	/**
	 * 手术开始时间
	 * @param Dt_st_op
	 */
	public void setDt_st_op(String Dt_st_op) {
		setAttrVal("Dt_st_op", Dt_st_op);
	}
	/**
	 * 手术结束时间
	 * @return String
	 */
	public String getDt_et_op() {
		return ((String) getAttrVal("Dt_et_op"));
	}
	/**
	 * 手术结束时间
	 * @param Dt_et_op
	 */
	public void setDt_et_op(String Dt_et_op) {
		setAttrVal("Dt_et_op", Dt_et_op);
	}
	/**
	 * 手术总例数
	 * @return Integer
	 */
	public Integer getSug_num() {
		return ((Integer) getAttrVal("Sug_num"));
	}
	/**
	 * 手术总例数
	 * @param Sug_num
	 */
	public void setSug_num(Integer Sug_num) {
		setAttrVal("Sug_num", Sug_num);
	}
}