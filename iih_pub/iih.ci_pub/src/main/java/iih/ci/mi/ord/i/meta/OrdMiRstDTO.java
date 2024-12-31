package iih.ci.mi.ord.i.meta;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordext.d.HpJudgeEnum;
import iih.ci.ord.ordext.d.HpJudgeRstEnum;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.sie.common.utils.StringUtils;

/**
 * 前后台数据交互对象医嘱信息
 * @author HUMS
 *
 */
public class OrdMiRstDTO extends BaseDTO{

	private static final long serialVersionUID = 1L;

	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊ID
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	
	/**
	 * 医保计划id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划id
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	
	/**
	 * 医保计划类型
	 * @return String
	 */
	public String getSd_hptp() {
		return ((String) getAttrVal("Sd_hptp"));
	}
	/**
	 * 医保计划类型
	 * @param Sd_hptp
	 */
	public void setSd_hptp(String Sd_hptp) {
		setAttrVal("Sd_hptp", Sd_hptp);
	}

	/**
	 * 基金支付标识
	 * @return String
	 */
	public FBoolean getFg_hpfundpay() {
		return ((FBoolean) getAttrVal("Fg_hpfundpay"));
	}
	/**
	 * 基金支付标识
	 * @param Fg_hpfundpay
	 */
	public void setFg_hpfundpay(FBoolean Fg_hpfundpay) {
		setAttrVal("Fg_hpfundpay", Fg_hpfundpay);
	}
	
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	
	/**
	 * 医嘱医保判断方式
	 * @return String
	 */
	public String getEu_hpjudge() {
		
		String eu_hpjudge = ((String) getAttrVal("Eu_hpjudge"));
		if(StringUtils.isNotEmpty(eu_hpjudge)){
			return eu_hpjudge;
		}
		
		boolean isNotJudge = true;
		
		List<OrdSrvMiRstDTO> ordSrvMiRstList = this.getOrdSrvMiRstlist();
		for(OrdSrvMiRstDTO ordSrvMiRst : ordSrvMiRstList ){
			
			if(HpJudgeEnum.DOCTOR_JUDGE.equals(ordSrvMiRst.getEu_hpjudge())){
				return HpJudgeEnum.DOCTOR_JUDGE;
			}else if(HpJudgeEnum.WAITING_JUDGE.equals(ordSrvMiRst.getEu_hpjudge())){
				return HpJudgeEnum.WAITING_JUDGE;
			}else if(HpJudgeEnum.NON_MEDICAL.equals(ordSrvMiRst.getEu_hpjudge())){
				return HpJudgeEnum.NON_MEDICAL;
			} 
			if(!HpJudgeEnum.NOT_JUDGE.equals(ordSrvMiRst.getEu_hpjudge())){
				isNotJudge = false;
			}
		}
		
		if(isNotJudge){
			return HpJudgeEnum.NOT_JUDGE;
		}
		
		return HpJudgeEnum.SYSTEM_JUDGE;
	}
	/**
	 * 医嘱医保判断方式
	 * @param Eu_orhp
	 */
	public void setEu_hpjudge(String Eu_hpjudge) {
		setAttrVal("Eu_hpjudge", Eu_hpjudge);
	}
	
	/**
	 * 医嘱医保判断结果
	 * @return String
	 */
	public String getEu_orhp() {
		String eu_orhp = ((String) getAttrVal("Eu_orhp"));
		if(StringUtils.isNotEmpty(eu_orhp)){
			return eu_orhp;
		}
		
		List<OrdSrvMiRstDTO> ordSrvMiRstList = this.getOrdSrvMiRstlist();

		// 是否全为不判断，不计费医嘱，自备、外配、科研等
		boolean isAllNotJudge = true; 
		// 是否全自费
		boolean isAllSelfpay = true;
		
		for(OrdSrvMiRstDTO ordSrvMiRst : ordSrvMiRstList){
			
			if(HpJudgeRstEnum.WAITING_JUDGE.equals(ordSrvMiRst.getEu_orsrvhp())){
				return HpJudgeRstEnum.WAITING_JUDGE;				
			}
			
			if(HpJudgeRstEnum.HP.equals(ordSrvMiRst.getEu_orsrvhp())){
				return HpJudgeRstEnum.HP;
			}
			
			if(!HpJudgeRstEnum.SELFPAY.equals(ordSrvMiRst.getEu_orsrvhp()) && !HpJudgeRstEnum.NOT_JUDGE.equals(ordSrvMiRst.getEu_orsrvhp())){
				isAllSelfpay = false;
			}
			
			if(!HpJudgeRstEnum.NOT_JUDGE.equals(ordSrvMiRst.getEu_orsrvhp())){
				isAllNotJudge = false;
			}
		}
		
		if(isAllNotJudge){
			return HpJudgeRstEnum.NOT_JUDGE;
		}
		
		if(isAllSelfpay){
			return HpJudgeRstEnum.SELFPAY;
		}else{
			return HpJudgeRstEnum.NOT_JUDGE;
		}
	}
	
	/**
	 * 医嘱医保判断结果
	 * @param Eu_orhp
	 */
	public void setEu_orhp(String Eu_orhp) {
		setAttrVal("Eu_orhp", Eu_orhp);
	}
	
	/**
	 * 医嘱服务项目医保信息
	 * @return FArrayList
	 */
	public FArrayList getOrdSrvMiRstFlist() {
		return ((FArrayList) getAttrVal("OrdSrvMiRstFlist"));
	}
	/**
	 * 医嘱服务项目医保信息
	 * @param OrdSrvMiRstFlist
	 */
	public void setOrdSrvMiRstFlist(FArrayList OrdSrvMiRstFlist) {
		setAttrVal("OrdSrvMiRstFlist", OrdSrvMiRstFlist);
	}
	
	public List<OrdSrvMiRstDTO> getOrdSrvMiRstlist() {
		
		List<OrdSrvMiRstDTO> ordSrvMiRstList = new ArrayList<OrdSrvMiRstDTO>();
		FArrayList list = ((FArrayList) getAttrVal("OrdSrvMiRstFlist"));
		for(Object obj : list){
			OrdSrvMiRstDTO ordSrvMiRst = (OrdSrvMiRstDTO)obj;	
			ordSrvMiRstList.add(ordSrvMiRst);
		}
		return ordSrvMiRstList;
	}
}
