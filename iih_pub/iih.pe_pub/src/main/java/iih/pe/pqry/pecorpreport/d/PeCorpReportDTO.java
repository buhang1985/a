package iih.pe.pqry.pecorpreport.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检团体汇总报告 DTO数据 
 * 
 */
public class PeCorpReportDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 体检疾病定义ID
	 * @return String
	 */
	public String getId_perstillness() {
		return ((String) getAttrVal("Id_perstillness"));
	}
	/**
	 * 体检疾病定义ID
	 * @param Id_perstillness
	 */
	public void setId_perstillness(String Id_perstillness) {
		setAttrVal("Id_perstillness", Id_perstillness);
	}
	/**
	 * 参检人数
	 * @return Integer
	 */
	public Integer getParticipants() {
		return ((Integer) getAttrVal("Participants"));
	}
	/**
	 * 参检人数
	 * @param Participants
	 */
	public void setParticipants(Integer Participants) {
		setAttrVal("Participants", Participants);
	}
	/**
	 * 异常人数
	 * @return Integer
	 */
	public Integer getAbnormal() {
		return ((Integer) getAttrVal("Abnormal"));
	}
	/**
	 * 异常人数
	 * @param Abnormal
	 */
	public void setAbnormal(Integer Abnormal) {
		setAttrVal("Abnormal", Abnormal);
	}
	/**
	 * 检出率
	 * @return FDouble
	 */
	public FDouble getDetectionrate() {
		return ((FDouble) getAttrVal("Detectionrate"));
	}
	/**
	 * 检出率
	 * @param Detectionrate
	 */
	public void setDetectionrate(FDouble Detectionrate) {
		setAttrVal("Detectionrate", Detectionrate);
	}
	/**
	 * 排序
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 排序
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 疾病编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 疾病编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 疾病名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 疾病名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
}