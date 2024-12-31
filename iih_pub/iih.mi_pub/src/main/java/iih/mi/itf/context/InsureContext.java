package iih.mi.itf.context;

import iih.mi.biz.dto.d.ReadCardPatternDTO;
import xap.mw.core.data.BaseDTO;


public class InsureContext extends BaseDTO {
	
	private static final long serialVersionUID = 1938974517895175899L;
	
	public InsureContext() {
		super();
	}
	
	//医保产品主键
	public String getIdHp() {
		return (String)getAttrVal("IdHp");
	}
	public void setIdHp(String hpId) {
		setAttrVal("IdHp", hpId);
	}
	
	//医保产品编码
	public String getCodeHp() {
		return (String)getAttrVal("CodeHp");
	}
	public void setCodeHp(String codeHp) {
		setAttrVal("CodeHp", codeHp);
	}

	//医保产品险种编码
	public String getCodeHpKind() {
		return (String)getAttrVal("CodeHpKind");
	}
	public void setCodeHpKind(String codeHpKind) {
		setAttrVal("CodeHpKind", codeHpKind);
	}
	
	//医保产品类别编码
	public String getCodeHpCategory() {
		return (String)getAttrVal("CodeHpCategory");
	}
	public void setCodeHpCategory(String codeHpCategory) {
		setAttrVal("CodeHpCategory", codeHpCategory);
	}

	//业务类型
	public String getBizTypeEnum() {
		return (String)getAttrVal("BizTypeEnum");
	}
	public void setBizTypeEnum(String bizTypeEnum) {
		setAttrVal("BizTypeEnum", bizTypeEnum);
	}

	//患者读卡类型
	public ReadCardPatternDTO getReadCardPattern() {
		return (ReadCardPatternDTO)getAttrVal("ReadCardPattern");
	}
	public void setReadCardPattern(ReadCardPatternDTO readCardPattern) {
		setAttrVal("ReadCardPattern", readCardPattern);
	}

	//业务周期号
	public String getBizNo() {
		return (String)getAttrVal("BizNo");
	}
	public void setBizNo(String bizNo) {
		setAttrVal("BizNo", bizNo);
	}
	
	//中心编码
	public String getCenterCode() {
		return (String)getAttrVal("CenterCode");
	}
	public void setCenterCode(String centerCode) {
		setAttrVal("CenterCode", centerCode);
	}
}

