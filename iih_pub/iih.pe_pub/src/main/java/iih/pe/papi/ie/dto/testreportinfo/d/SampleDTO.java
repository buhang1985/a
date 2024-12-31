package iih.pe.papi.ie.dto.testreportinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 标本及图像信息 DTO数据 
 * 
 */
public class SampleDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 采集日期
	 * @return FDateTime
	 */
	public FDateTime getEffectivetime() {
		return ((FDateTime) getAttrVal("Effectivetime"));
	}
	/**
	 * 采集日期
	 * @param Effectivetime
	 */
	public void setEffectivetime(FDateTime Effectivetime) {
		setAttrVal("Effectivetime", Effectivetime);
	}
	/**
	 * 采集人编码
	 * @return String
	 */
	public String getCollectionid() {
		return ((String) getAttrVal("Collectionid"));
	}
	/**
	 * 采集人编码
	 * @param Collectionid
	 */
	public void setCollectionid(String Collectionid) {
		setAttrVal("Collectionid", Collectionid);
	}
	/**
	 * 采集人名称
	 * @return String
	 */
	public String getCollectionname() {
		return ((String) getAttrVal("Collectionname"));
	}
	/**
	 * 采集人名称
	 * @param Collectionname
	 */
	public void setCollectionname(String Collectionname) {
		setAttrVal("Collectionname", Collectionname);
	}
	/**
	 * 采集地点编码
	 * @return String
	 */
	public String getCollectionplace() {
		return ((String) getAttrVal("Collectionplace"));
	}
	/**
	 * 采集地点编码
	 * @param Collectionplace
	 */
	public void setCollectionplace(String Collectionplace) {
		setAttrVal("Collectionplace", Collectionplace);
	}
	/**
	 * 采集地点名称
	 * @return String
	 */
	public String getCollectionplacename() {
		return ((String) getAttrVal("Collectionplacename"));
	}
	/**
	 * 采集地点名称
	 * @param Collectionplacename
	 */
	public void setCollectionplacename(String Collectionplacename) {
		setAttrVal("Collectionplacename", Collectionplacename);
	}
	/**
	 * 接受日期
	 * @return FDateTime
	 */
	public FDateTime getReceivetime() {
		return ((FDateTime) getAttrVal("Receivetime"));
	}
	/**
	 * 接受日期
	 * @param Receivetime
	 */
	public void setReceivetime(FDateTime Receivetime) {
		setAttrVal("Receivetime", Receivetime);
	}
	/**
	 * 标本接收人编码
	 * @return String
	 */
	public String getReceiveid() {
		return ((String) getAttrVal("Receiveid"));
	}
	/**
	 * 标本接收人编码
	 * @param Receiveid
	 */
	public void setReceiveid(String Receiveid) {
		setAttrVal("Receiveid", Receiveid);
	}
	/**
	 * 标本接收人名称
	 * @return String
	 */
	public String getReceivename() {
		return ((String) getAttrVal("Receivename"));
	}
	/**
	 * 标本接收人名称
	 * @param Receivename
	 */
	public void setReceivename(String Receivename) {
		setAttrVal("Receivename", Receivename);
	}
	/**
	 * 标本条码号
	 * @return String
	 */
	public String getSampleno() {
		return ((String) getAttrVal("Sampleno"));
	}
	/**
	 * 标本条码号
	 * @param Sampleno
	 */
	public void setSampleno(String Sampleno) {
		setAttrVal("Sampleno", Sampleno);
	}
	/**
	 * 标本类型编码(标本来源编码)
	 * @return String
	 */
	public String getSampletype() {
		return ((String) getAttrVal("Sampletype"));
	}
	/**
	 * 标本类型编码(标本来源编码)
	 * @param Sampletype
	 */
	public void setSampletype(String Sampletype) {
		setAttrVal("Sampletype", Sampletype);
	}
	/**
	 * 标本类型名称(标本来源名称)
	 * @return String
	 */
	public String getSampletypename() {
		return ((String) getAttrVal("Sampletypename"));
	}
	/**
	 * 标本类型名称(标本来源名称)
	 * @param Sampletypename
	 */
	public void setSampletypename(String Sampletypename) {
		setAttrVal("Sampletypename", Sampletypename);
	}
	/**
	 * 标本状态
	 * @return String
	 */
	public String getSpecimenstate() {
		return ((String) getAttrVal("Specimenstate"));
	}
	/**
	 * 标本状态
	 * @param Specimenstate
	 */
	public void setSpecimenstate(String Specimenstate) {
		setAttrVal("Specimenstate", Specimenstate);
	}
	/**
	 * 容器类型编码
	 * @return String
	 */
	public String getContainerid() {
		return ((String) getAttrVal("Containerid"));
	}
	/**
	 * 容器类型编码
	 * @param Containerid
	 */
	public void setContainerid(String Containerid) {
		setAttrVal("Containerid", Containerid);
	}
	/**
	 * 容器类型名称
	 * @return String
	 */
	public String getContainername() {
		return ((String) getAttrVal("Containername"));
	}
	/**
	 * 容器类型名称
	 * @param Containername
	 */
	public void setContainername(String Containername) {
		setAttrVal("Containername", Containername);
	}
	/**
	 * 图像信息
	 * @return FArrayList
	 */
	public FArrayList getImagecontent() {
		return ((FArrayList) getAttrVal("Imagecontent"));
	}
	/**
	 * 图像信息
	 * @param Imagecontent
	 */
	public void setImagecontent(FArrayList Imagecontent) {
		setAttrVal("Imagecontent", Imagecontent);
	}
	/**
	 * 报告号
	 * @return String
	 */
	public String getReportno() {
		return ((String) getAttrVal("Reportno"));
	}
	/**
	 * 报告号
	 * @param Reportno
	 */
	public void setReportno(String Reportno) {
		setAttrVal("Reportno", Reportno);
	}
}