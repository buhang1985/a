package iih.mp.nr.payhgy.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDateTime;
/**
 * 	病理从HIS获取患者报告结果  参数
 * by 千屏病理
 *@author LiYue
 */
public class PayhgyResultParam extends BaseDTO {
	
private static final long serialVersionUID = 1L;
	/**
	 * 申请号
	 * @return String
	 */
	public String getSqh() {
		return ((String) getAttrVal("Sqh"));
	}	
	/**
	 *  申请号
	 * @param Sqh
	 */
	public void setSqh(String Sqh) {
		setAttrVal("Sqh", Sqh);
	}
	
	/**
	 * 病人ID
	 * @return String
	 */
	public String getBrid() {
		return ((String) getAttrVal("Brid"));
	}	
	/**
	 * 病人ID
	 * @param Brid
	 */
	public void setBrid(String Brid) {
		setAttrVal("Brid", Brid);
	}
	
	/**
	 * 病理号
	 * @return String
	 */
	public String Medicalno() {
		return ((String) getAttrVal("Medicalno"));
	}	
	/**
	 * 病理号
	 * @param Medicalno
	 */
	public void setMedicalno(String Medicalno) {
		setAttrVal("Medicalno", Medicalno);
	}

	/**
	 * 门诊号
	 * @return String
	 */
	public String getMzh() {
		return ((String) getAttrVal("Mzh"));
	}	
	/**
	 * 门诊号
	 * @param Rysj
	 */
	public void setMzh(String Mzh) {
		setAttrVal("Mzh", Mzh);
	}
	
	/**
	 * 住院号
	 * @return String
	 */
	public String getZyh() {
		return ((String) getAttrVal("Zyh"));
	}	
	/**
	 * 住院号
	 * @param Rysj
	 */
	public void setZyh(String Zyh) {
		setAttrVal("Zyh", Zyh);
	}
	
	/**
	 * 肉眼所见
	 * @return String
	 */
	public String getRysj() {
		return ((String) getAttrVal("Rysj"));
	}	
	/**
	 * 肉眼所见
	 * @param Rysj
	 */
	public void setRysj(String Rysj) {
		setAttrVal("Rysj", Rysj);
	}
	
	/**
	 * 镜下所见
	 * @return String
	 */
	public String getGjsj() {
		return ((String) getAttrVal("Gjsj"));
	}	
	/**
	 * 镜下所见
	 * @param Gjsj
	 */
	public void setGjsj(String Gjsj) {
		setAttrVal("Gjsj", Gjsj);
	}
	
	/**
	 * 诊断意见
	 * @return String
	 */
	public String getZdyj() {
		return ((String) getAttrVal("Zdyj"));
	}	
	/**
	 * 诊断意见
	 * @param Zdyj
	 */
	public void setZdyj(String Zdyj) {
		setAttrVal("Zdyj", Zdyj);
	}
	
	/**
	 * 诊断医师
	 * @return String
	 */
	public String getZzys() {
		return ((String) getAttrVal("Zzys"));
	}	
	/**
	 * 诊断医师
	 * @param 诊断医师
	 */
	public void setZzys(String Zzys) {
		setAttrVal("Zzys", Zzys);
	}
	
	/**
	 * 审核医师
	 * @return String
	 */
	public String getShys() {
		return ((String) getAttrVal("Shys"));
	}	
	/**
	 * 审核医师
	 * @param Shys
	 */
	public void setShys(String Shys) {
		setAttrVal("Shys", Shys);
	}
	
	/**
	 * 报告日期
	 * @return String
	 */
	public FDateTime getBgrq() {
		return ((FDateTime)  getAttrVal("Bgrq"));
	}	
	/**
	 * 报告日期
	 * @param Bgrq
	 */
	public void setBgrq(FDateTime Bgrq) {
		setAttrVal("Bgrq", Bgrq);
	}
	
}
