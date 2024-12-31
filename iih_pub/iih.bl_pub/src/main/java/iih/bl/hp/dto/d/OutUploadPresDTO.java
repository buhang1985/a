package iih.bl.hp.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 处方上传结果DTO DTO数据 
 * 
 */
public class OutUploadPresDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 超治疗自付金额
	 * @return String
	 */
	public String getOverselfamt() {
		return ((String) getAttrVal("Overselfamt"));
	}
	/**
	 * 超治疗自付金额
	 * @param Overselfamt
	 */
	public void setOverselfamt(String Overselfamt) {
		setAttrVal("Overselfamt", Overselfamt);
	}
	/**
	 * 金额
	 * @return String
	 */
	public String getAmt() {
		return ((String) getAttrVal("Amt"));
	}
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(String Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 自理金额
	 * @return String
	 */
	public String getOneselfamt() {
		return ((String) getAttrVal("Oneselfamt"));
	}
	/**
	 * 自理金额
	 * @param Oneselfamt
	 */
	public void setOneselfamt(String Oneselfamt) {
		setAttrVal("Oneselfamt", Oneselfamt);
	}
	/**
	 * 自费金额
	 * @return String
	 */
	public String getSelfamt() {
		return ((String) getAttrVal("Selfamt"));
	}
	/**
	 * 自费金额
	 * @param Selfamt
	 */
	public void setSelfamt(String Selfamt) {
		setAttrVal("Selfamt", Selfamt);
	}
	/**
	 * 项目等级
	 * @return String
	 */
	public String getSrvgrade() {
		return ((String) getAttrVal("Srvgrade"));
	}
	/**
	 * 项目等级
	 * @param Srvgrade
	 */
	public void setSrvgrade(String Srvgrade) {
		setAttrVal("Srvgrade", Srvgrade);
	}
	/**
	 * 全额自费标志
	 * @return String
	 */
	public String getSelfflag() {
		return ((String) getAttrVal("Selfflag"));
	}
	/**
	 * 全额自费标志
	 * @param Selfflag
	 */
	public void setSelfflag(String Selfflag) {
		setAttrVal("Selfflag", Selfflag);
	}
	/**
	 * 列入医保金额
	 * @return String
	 */
	public String getEnterhpamt() {
		return ((String) getAttrVal("Enterhpamt"));
	}
	/**
	 * 列入医保金额
	 * @param Enterhpamt
	 */
	public void setEnterhpamt(String Enterhpamt) {
		setAttrVal("Enterhpamt", Enterhpamt);
	}
	/**
	 * 全额统筹
	 * @return String
	 */
	public String getAllhpamt() {
		return ((String) getAttrVal("Allhpamt"));
	}
	/**
	 * 全额统筹
	 * @param Allhpamt
	 */
	public void setAllhpamt(String Allhpamt) {
		setAttrVal("Allhpamt", Allhpamt);
	}
	/**
	 * 部分统筹
	 * @return String
	 */
	public String getParthpamt() {
		return ((String) getAttrVal("Parthpamt"));
	}
	/**
	 * 部分统筹
	 * @param Parthpamt
	 */
	public void setParthpamt(String Parthpamt) {
		setAttrVal("Parthpamt", Parthpamt);
	}
	/**
	 * 部分自付
	 * @return String
	 */
	public String getPartselfamt() {
		return ((String) getAttrVal("Partselfamt"));
	}
	/**
	 * 部分自付
	 * @param Partselfamt
	 */
	public void setPartselfamt(String Partselfamt) {
		setAttrVal("Partselfamt", Partselfamt);
	}
	/**
	 * 全额自费
	 * @return String
	 */
	public String getAllselfamt() {
		return ((String) getAttrVal("Allselfamt"));
	}
	/**
	 * 全额自费
	 * @param Allselfamt
	 */
	public void setAllselfamt(String Allselfamt) {
		setAttrVal("Allselfamt", Allselfamt);
	}
	/**
	 * 自付比例
	 * @return String
	 */
	public String getSelfratio() {
		return ((String) getAttrVal("Selfratio"));
	}
	/**
	 * 自付比例
	 * @param Selfratio
	 */
	public void setSelfratio(String Selfratio) {
		setAttrVal("Selfratio", Selfratio);
	}
}