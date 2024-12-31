package iih.bl.hp.divideresult.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 分类汇总信息 DTO数据 
 * 
 */
public class MediCatalog1DTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 西药
	 * @return FDouble
	 */
	public FDouble getMedicine() {
		return ((FDouble) getAttrVal("Medicine"));
	}
	/**
	 * 西药
	 * @param Medicine
	 */
	public void setMedicine(FDouble Medicine) {
		setAttrVal("Medicine", Medicine);
	}
	/**
	 * 中成药
	 * @return FDouble
	 */
	public FDouble getTmedicine() {
		return ((FDouble) getAttrVal("Tmedicine"));
	}
	/**
	 * 中成药
	 * @param Tmedicine
	 */
	public void setTmedicine(FDouble Tmedicine) {
		setAttrVal("Tmedicine", Tmedicine);
	}
	/**
	 * 中草药
	 * @return FDouble
	 */
	public FDouble getTherb() {
		return ((FDouble) getAttrVal("Therb"));
	}
	/**
	 * 中草药
	 * @param Therb
	 */
	public void setTherb(FDouble Therb) {
		setAttrVal("Therb", Therb);
	}
	/**
	 * 检查费
	 * @return FDouble
	 */
	public FDouble getExamine() {
		return ((FDouble) getAttrVal("Examine"));
	}
	/**
	 * 检查费
	 * @param Examine
	 */
	public void setExamine(FDouble Examine) {
		setAttrVal("Examine", Examine);
	}
	/**
	 * 手术费
	 * @return FDouble
	 */
	public FDouble getOperation() {
		return ((FDouble) getAttrVal("Operation"));
	}
	/**
	 * 手术费
	 * @param Operation
	 */
	public void setOperation(FDouble Operation) {
		setAttrVal("Operation", Operation);
	}
	/**
	 * 治疗费
	 * @return FDouble
	 */
	public FDouble getTreatment() {
		return ((FDouble) getAttrVal("Treatment"));
	}
	/**
	 * 治疗费
	 * @param Treatment
	 */
	public void setTreatment(FDouble Treatment) {
		setAttrVal("Treatment", Treatment);
	}
	/**
	 * 化验
	 * @return FDouble
	 */
	public FDouble getLabexam() {
		return ((FDouble) getAttrVal("Labexam"));
	}
	/**
	 * 化验
	 * @param Labexam
	 */
	public void setLabexam(FDouble Labexam) {
		setAttrVal("Labexam", Labexam);
	}
	/**
	 * 材料费
	 * @return FDouble
	 */
	public FDouble getMaterial() {
		return ((FDouble) getAttrVal("Material"));
	}
	/**
	 * 材料费
	 * @param Material
	 */
	public void setMaterial(FDouble Material) {
		setAttrVal("Material", Material);
	}
	/**
	 * 其他项目
	 * @return FDouble
	 */
	public FDouble getOther() {
		return ((FDouble) getAttrVal("Other"));
	}
	/**
	 * 其他项目
	 * @param Other
	 */
	public void setOther(FDouble Other) {
		setAttrVal("Other", Other);
	}
	/**
	 * CT
	 * @return FDouble
	 */
	public FDouble getCt() {
		return ((FDouble) getAttrVal("Ct"));
	}
	/**
	 * CT
	 * @param Ct
	 */
	public void setCt(FDouble Ct) {
		setAttrVal("Ct", Ct);
	}
	/**
	 * 核磁
	 * @return FDouble
	 */
	public FDouble getMri() {
		return ((FDouble) getAttrVal("Mri"));
	}
	/**
	 * 核磁
	 * @param Mri
	 */
	public void setMri(FDouble Mri) {
		setAttrVal("Mri", Mri);
	}
	/**
	 * B超
	 * @return FDouble
	 */
	public FDouble getUltrasonic() {
		return ((FDouble) getAttrVal("Ultrasonic"));
	}
	/**
	 * B超
	 * @param Ultrasonic
	 */
	public void setUltrasonic(FDouble Ultrasonic) {
		setAttrVal("Ultrasonic", Ultrasonic);
	}
	/**
	 * 输氧费
	 * @return FDouble
	 */
	public FDouble getOxygen() {
		return ((FDouble) getAttrVal("Oxygen"));
	}
	/**
	 * 输氧费
	 * @param Oxygen
	 */
	public void setOxygen(FDouble Oxygen) {
		setAttrVal("Oxygen", Oxygen);
	}
	/**
	 * 放射
	 * @return FDouble
	 */
	public FDouble getXray() {
		return ((FDouble) getAttrVal("Xray"));
	}
	/**
	 * 放射
	 * @param Xray
	 */
	public void setXray(FDouble Xray) {
		setAttrVal("Xray", Xray);
	}
	/**
	 * 输血费
	 * @return FDouble
	 */
	public FDouble getBloodt() {
		return ((FDouble) getAttrVal("Bloodt"));
	}
	/**
	 * 输血费
	 * @param Bloodt
	 */
	public void setBloodt(FDouble Bloodt) {
		setAttrVal("Bloodt", Bloodt);
	}
	/**
	 * 正畸费
	 * @return FDouble
	 */
	public FDouble getOrthodontics() {
		return ((FDouble) getAttrVal("Orthodontics"));
	}
	/**
	 * 正畸费
	 * @param Orthodontics
	 */
	public void setOrthodontics(FDouble Orthodontics) {
		setAttrVal("Orthodontics", Orthodontics);
	}
	/**
	 * 镶牙费
	 * @return FDouble
	 */
	public FDouble getProsthesis() {
		return ((FDouble) getAttrVal("Prosthesis"));
	}
	/**
	 * 镶牙费
	 * @param Prosthesis
	 */
	public void setProsthesis(FDouble Prosthesis) {
		setAttrVal("Prosthesis", Prosthesis);
	}
	/**
	 * 司法鉴定
	 * @return FDouble
	 */
	public FDouble getForensic() {
		return ((FDouble) getAttrVal("Forensic"));
	}
	/**
	 * 司法鉴定
	 * @param Forensic
	 */
	public void setForensic(FDouble Forensic) {
		setAttrVal("Forensic", Forensic);
	}
}