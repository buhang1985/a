package iih.bd.pp.dto.d;
import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;

import java.math.BigDecimal;
import java.util.Map;
/**
 * 服务价格计算的DTO
 * @author tcy
 *
 */
public class PricalSrvDTO extends BaseDTO{
private static final long serialVersionUID = 1L;

	/**
	 * 主键，用户自定义
	 * @return
	 */
	public String getPK() {
		return ((String) getAttrVal("PK"));
	}	
	public void setPK(String PK) {
		setAttrVal("PK", PK);
	}
	/**
	 * 服务ID:必填项
	 * @return
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	
	/**
	 * 该服务对应的定价模式ID
	 * @return
	 */
	public String getId_primd() {
		return ((String) getAttrVal("Id_primd"));
	}	
	public void setId_primd(String Id_primd) {
		setAttrVal("Id_primd", Id_primd);
	}
	/**
	 * 
	 * @return
	 */
	public String getSrvsetadds() {
		return ((String) getAttrVal("Srvsetadds"));
	}	
	public void setSrvsetadds(String Srvsetadds) {
		setAttrVal("Srvsetadds", Srvsetadds);
	}
	/**
	 * 服务数量
	 * @return
	 */
	public FDouble getAmount(){
		return ((FDouble) getAttrVal("Amount"));
	}
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 标准金额：标准单价*数量
	 * @return
	 */
	public FDouble getAmtStd(){
		return ((FDouble) getAttrVal("AmtStd"));
	}
	public void setAmtStd(FDouble AmtStd) {
		setAttrVal("AmtStd", AmtStd);
	}
	/**
	 * 实际
	 * @return
	 */
	public FDouble getAmt(){
		return ((FDouble) getAttrVal("Amt"));
	}
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	
	////////////////////////////////////
	//以下是服务套需要的字段
	////////////////////////////////////
	/**
	 * 服务套ID
	 * @return
	 */
	public String getId_srvset() {
		return ((String) getAttrVal("Id_srvset"));
	}	
	public void setId_srvset(String Id_srvset) {
		setAttrVal("Id_srvset", Id_srvset);
	}
	
	/**
	 * 02服务套成员项目部位个数加收
	 * @return
	 */
	public FDouble getPartAddAmount02(){
		return ((FDouble) getAttrVal("PartAddAmount02"));
	}
	public void setPartAddAmount02(FDouble PartAddAmount02) {
		setAttrVal("PartAddAmount02", PartAddAmount02);
	}
	
	/**
	 * 03服务套成员项目个数加收
	 * @return
	 */
	public FDouble getItemAddAmount03(){
		return ((FDouble) getAttrVal("ItemAddAmount03"));
	}
	public void setItemAddAmount03(FDouble ItemAddAmount03) {
		setAttrVal("ItemAddAmount03", ItemAddAmount03);
	}
	
	/**
	 * 
	 * @return
	 */
	public Map<String,FDouble> getSrvSetItems(){
		return ((Map<String,FDouble>) getAttrVal("SrvSetItems"));
	}
	public void setSrvSetItems(Map<String,FDouble> SrvSetItems) {
		setAttrVal("SrvSetItems", SrvSetItems);
	}
}
