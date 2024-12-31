package iih.ci.ord.i.mi.meta;

import iih.ci.ord.ciorder.d.HpIndicJudgeRstEnum;
import iih.ci.ord.i.common.b.BaseXapJsonSerialization;
import xap.lui.system.hpsrvorca.d.HpIndicationRuleEnum;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医保校验结果返回对象
 * 
 * @author HUMS
 *
 */
public class OrdHpVerifyRstDTO extends BaseXapJsonSerialization {

	private static final long serialVersionUID = 1L;

	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}

	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}

	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}

	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}

	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}

	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}

	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}

	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}

	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}

	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}

	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}

	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}

	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}

	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}

	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}

	public Integer getEu_hpindicjudge() {
		
		//Integer eu_hpindicjudge = ((Integer) getAttrVal("Eu_hpindicjudge"));
		
		/*if(eu_hpindicjudge != null){
			return eu_hpindicjudge;
		}*/
		
		FArrayList ordSrvHpRstList = this.getOrdSrvList();
		if(ordSrvHpRstList == null){
			return HpIndicJudgeRstEnum.WAITING_JUDGE;
		}
		
		for (Object ordSrvObj : ordSrvHpRstList) {
			
			OrdSrvHpVerifyRstDTO ordSrvHpValidateRst = (OrdSrvHpVerifyRstDTO) ordSrvObj;
			Integer eu_hpindicjudge = ordSrvHpValidateRst.getEu_hpindicjudge();
			
			if(eu_hpindicjudge == null || HpIndicJudgeRstEnum.WAITING_JUDGE.equals(eu_hpindicjudge)){
				return HpIndicJudgeRstEnum.WAITING_JUDGE;
			}
		}
		
		// 是否全部为系统确认、含不控制，如果有一项是医生判断，或系统确认医生判断，返回为医生判断
		for (Object ordSrvObj : ordSrvHpRstList) {
			OrdSrvHpVerifyRstDTO ordSrvHpValidateRst = (OrdSrvHpVerifyRstDTO) ordSrvObj;
			
			// 获取医保目录控制类型，如果服务项目全01/11的为系统判断，如果存在fg_selfpay为空的是待判断。否则是医生判断
			String hpsrvctrtp = ordSrvHpValidateRst.getEu_hpsrvctrtp();
			// 存在需要医生判断返回医生判断
			if (HpIndicationRuleEnum.SYS_JUD_DOCCONFIRM.equals(hpsrvctrtp) || HpIndicationRuleEnum.DOC_CONFIRM.equals(hpsrvctrtp)) {
				return HpIndicJudgeRstEnum.DOCTOR_JUDGE;
			}
		}

		// 返回系统判断
		return HpIndicJudgeRstEnum.SYSTEM_JUDGE;		
	}

	public void setEu_hpindicjudge(Integer Eu_hpindicjudge) {
		setAttrVal("Eu_hpindicjudge", Eu_hpindicjudge);
	}	
	
	/**
	 * 判断是否为自费，当明细项全自费时，医嘱为自费，<br>
	 * 当有一项为医保时，医嘱上的标识为医保
	 * 医嘱项目分：临床费用项目和执行操作费用项目。<br>
	 * 该标识为true时标识该医嘱中临床费用项目中至少有一条fg_selfpay=false的。特别说明fg_selfpay=true是保外（自费）、fg_selfpay=false是保内
	 * @return
	 */
	public FBoolean getFg_orhp() {

		FArrayList ordSrvHpRstList = this.getOrdSrvList();
		if(ordSrvHpRstList == null){
			return null;
		}
		
		// 如果有一项为空，代表明细项未全部进行医保判断
		for (Object ordSrvObj : ordSrvHpRstList) {
			OrdSrvHpVerifyRstDTO ordSrv = (OrdSrvHpVerifyRstDTO) ordSrvObj;
			if(ordSrv.getFg_selfpay() == null){
				return null;
			}
		}
		
		// 如果有一项是保内，整个医嘱返回保内
		for (Object ordSrvObj : ordSrvHpRstList) {
			OrdSrvHpVerifyRstDTO ordSrv = (OrdSrvHpVerifyRstDTO) ordSrvObj;
			// 如果有一项是医保
			if (FBoolean.FALSE.equals(ordSrv.getFg_selfpay())) {
				return FBoolean.TRUE;
			}
		}
		
		return FBoolean.FALSE;
	}

	public void setFg_orhp(FBoolean Fg_orhp) {
		setAttrVal("Fg_orhp", Fg_orhp);
	}
	
	/**
	 * 是否需要显示到医保适应症判断界面<br>
	 * 当全部子项都不不显示时，医嘱就不在适应判断界面显示。否则显示到适应症判断界面
	 * @return
	 */
	public FBoolean getFg_display() {
		
		FArrayList ordSrvHpRstList = this.getOrdSrvList();
		if(ordSrvHpRstList == null){
			return FBoolean.FALSE;
		}
		
		for(Object ordSrvHpRstObj : ordSrvHpRstList){
			OrdSrvHpVerifyRstDTO ordSrvHpRst = (OrdSrvHpVerifyRstDTO)ordSrvHpRstObj;
			if(FBoolean.TRUE.equals(ordSrvHpRst.getFg_display())){
				return FBoolean.TRUE;
			}
		}
		
		return FBoolean.FALSE;
	}

	public void setFg_display(FBoolean Fg_display) {
		setAttrVal("Fg_display", Fg_display);
	}
	
	public FArrayList getOrdSrvList() {
		return ((FArrayList) getAttrVal("OrdSrvList"));
	}

	public void setOrdSrvList(FArrayList OrdSrvList) {
		setAttrVal("OrdSrvList", OrdSrvList);
	}
}
