package iih.ci.ord.i.mi.meta;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.hpsrvorca.d.HpIndicationRuleEnum;
import iih.ci.ord.ciorder.d.HpIndicJudgeRstEnum;
import iih.ci.ord.i.external.obtain.meta.hp.HpVerifyRstDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 临床医保适应症校验返回结果
 * 
 * @author HUMS
 *
 */
public class OrdSrvHpVerifyRstDTO extends HpVerifyRstDTO {

	private static final long serialVersionUID = 1L;

	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}

	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}

	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}

	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}

	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}

	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}

	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}

	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}

	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}

	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}

	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}

	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}

	public Integer getEu_hpindicjudge() {

		Integer eu_hpindicjudge = ((Integer) getAttrVal("Eu_hpindicjudge"));
		if (eu_hpindicjudge != null) {
			return eu_hpindicjudge;
		}

		// 控制类型 01 不控制 ，11 系统判断 12 系统判断医生确认 21 医生确认
		// 当控制类型为 01、 11时 ，如果适应症为true， 返回非自费（医保），否则返回自费，12 、 21 返回前台医生判断
		// 当控制类型为21 是，适应症返回为空，完全有医生判断
		String hpsrvctrtp = this.getEu_hpsrvctrtp();

		// 医保目录类别，丙类自费
		String sd_hpsrvtp = this.getSd_hpsrvtp();

		// 医保控制类型为空的、丙类的返回自费 控制类型不应该返回空
		if (IBdPpCodeTypeConst.SD_HP_BJ_THREE.equals(sd_hpsrvtp)) {

			return HpIndicJudgeRstEnum.SYSTEM_JUDGE;
		}

		// 如果需要医生判断，返回待判断（诊断依赖需要医生判断）
		if(FBoolean.TRUE.equals(this.getFg_doctor_judge())){
			return HpIndicJudgeRstEnum.WAITING_JUDGE;
		}
		
		// 如果是适应症，返回非自费（医保Fg_selfpay=false），否则返回自费，患者就诊为全保内时，医保目录为丙类，返回控制类型为不控制，适应症为符合
		if (HpIndicationRuleEnum.NO_CONTROL.equals(hpsrvctrtp) ) {// || HpIndicationRuleEnum.SYS_CONFIRM.equals(hpsrvctrtp) 医保已经去掉系统判断
			return HpIndicJudgeRstEnum.SYSTEM_JUDGE;
		}

		return HpIndicJudgeRstEnum.WAITING_JUDGE;
	}

	public void setEu_hpindicjudge(Integer Eu_hpindicjudge) {
		setAttrVal("Eu_hpindicjudge", Eu_hpindicjudge);
	}

	public FBoolean getFg_selfpay() {

		// 通过set方法赋值，直接返回设置的值
		FBoolean fg_selfpay = ((FBoolean) getAttrVal("Fg_selfpay"));
		if (fg_selfpay != null) {
			return fg_selfpay;
		}

		// 1.控制类型为 01 11，适应症为False时，返回自费，适应症为True 时返回医保<br>
		// 全保内，存在医保目录类型为丙类，适应症返回True，控制类型为不控制，返回自费标识为False
		// 2.丙类返回自费
		// 3.控制类型为11返回自费时，需要提醒医生

		// 医保目录类别，丙类自费
		String sd_hpsrvtp = this.getSd_hpsrvtp();
		// 适应症标识，
		FBoolean fg_indic = this.getFg_indic();
		// 控制类型 01 不控制 ，11 系统判断 12 系统判断医生确认 21 医生确认
		// 当控制类型为 01、 11时 ，如果适应症为true， 返回非自费（医保），否则返回自费，12 、 21 返回前台医生判断
		// 当控制类型为21 是，适应症返回为空，完全有医生判断
		String hpsrvctrtp = this.getEu_hpsrvctrtp();

		// 如果是适应症，返回非自费（医保Fg_selfpay=false），否则返回自费，患者就诊为全保内时，医保目录为丙类，返回控制类型为不控制，适应症为符合
		if (HpIndicationRuleEnum.NO_CONTROL.equals(hpsrvctrtp)) { // || HpIndicationRuleEnum.SYS_CONFIRM.equals(hpsrvctrtp) 医保已经去掉系统判断
			return FBoolean.TRUE.equals(fg_indic) ? FBoolean.FALSE : FBoolean.TRUE;
		}

		// 医保控制类型为空的、丙类的返回自费 控制类型不应该返回空
		if (IBdPpCodeTypeConst.SD_HP_BJ_THREE.equals(sd_hpsrvtp)) {

			return FBoolean.TRUE;
		}

		return fg_indic == null ? null : FBoolean.TRUE.equals(fg_indic) ? FBoolean.FALSE : FBoolean.TRUE;
	}

	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}

	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}

	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}

	/**
	 * 适应症为false, 控制类型为11 系统判断时，根据参数确定是否显示到医生判断界面<br>
	 * 参数 CIOR0145
	 * 
	 * @return
	 */
	public FBoolean getFg_remind() {
		return ((FBoolean) getAttrVal("Fg_remind"));
	}

	public void setFg_remind(FBoolean Fg_remind) {
		setAttrVal("Fg_remind", Fg_remind);
	}

	/**
	 * 是否需要医生判断
	 * 
	 * @return
	 */
	public FBoolean getFg_doctor_judge() {
		return ((FBoolean) getAttrVal("Fg_doctor_judge"));
	}

	/**
	 * 是否需要医生判断<br/>
	 * 存自费诊断时，需要医生确认是否自费开立
	 * 
	 * @param Fg_doctor_judge
	 */
	public void setFg_doctor_judge(FBoolean Fg_doctor_judge) {
		setAttrVal("Fg_doctor_judge", Fg_doctor_judge);
	}

	/**
	 * 是否显示到判断列表<br>
	 * 适应症为false, 控制类型为11 系统判断时，根据参数确定是否显示到医生判断界面<br>
	 * 控制类型为12 、21时，返回需要医生判断
	 * 
	 * @return
	 */
	public FBoolean getFg_display() {

		FBoolean fg_indic = this.getFg_indic();
		String hpsrvctrtp = this.getEu_hpsrvctrtp();
		// 需要医生确认的，返回提醒
		if (HpIndicationRuleEnum.SYS_JUD_DOCCONFIRM.equals(hpsrvctrtp) || HpIndicationRuleEnum.DOC_CONFIRM.equals(hpsrvctrtp)) {
			return FBoolean.TRUE;
		}

		// 为true 时对应 参数 "CIOR0145"配置，非适应症时是否提醒医生 默认值False
		FBoolean fg_remind = this.getFg_remind();
		if (!FBoolean.TRUE.equals(fg_remind)) {
			return FBoolean.FALSE;
		}

		// 如果是系统确认，并且非适应症的需要提示，并且参数配置需要提醒，显示到提示页面
		//if (HpIndicationRuleEnum.SYS_CONFIRM.equals(hpsrvctrtp) && FBoolean.FALSE.equals(fg_indic)) { // || HpIndicationRuleEnum.SYS_CONFIRM.equals(hpsrvctrtp) 医保已经去掉系统判断
		//	return FBoolean.TRUE;
		//}

		return FBoolean.FALSE;
	}

	public void setFg_display(FBoolean Fg_display) {
		setAttrVal("Fg_display", Fg_display);
	}

	/**
	 * 是否允许操作自费标识
	 * 
	 * @return
	 */
	public FBoolean getFg_allow_edit() {
		FBoolean fg_allow_edit = ((FBoolean) getAttrVal("Fg_allow_edit"));
		if (fg_allow_edit != null) {
			return fg_allow_edit;
		}

		if (IBdPpCodeTypeConst.SD_HP_BJ_THREE.equals(this.getSd_hpsrvtp())) {
			return FBoolean.FALSE;
		}

		if (FBoolean.FALSE.equals(this.getFg_indic())) {
			return FBoolean.FALSE;
		}

		// 除丙类都可以编辑
		/*String hpsrvctrtp = this.getEu_hpsrvctrtp();
		if (HpIndicationRuleEnum.NO_CONTROL.equals(hpsrvctrtp) || HpIndicationRuleEnum.NO_CONTROL.equals(hpsrvctrtp)) {
			return FBoolean.FALSE;
		}*/
		return FBoolean.TRUE;
	}

	public void setFg_allow_edit(FBoolean Fg_allow_edit) {
		setAttrVal("Fg_allow_edit", Fg_allow_edit);
	}

}
