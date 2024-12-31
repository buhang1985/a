package iih.bd.fc.querule.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.fc.querule.d.PriorityDTO;
import iih.bd.fc.querule.d.QueRuleItmDO;
import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 规则匹配BP
 * @author yank
 *
 */
public class RuleMatchBP {
	
	public final String TP_VIP_NONE = "0";// 非VIP
	/**
	 * 是否匹配
	 * @param quebenTp 队列分诊台类型编码
	 * @param ruleItm 规则项
	 * @param priDTO 匹配数据
	 * @return
	 * @throws BizException 
	 */
	public boolean isMatchRule(String quebenTp, QueRuleItmDO ruleItm, PriorityDTO priDTO)  {
		boolean match = false;
		switch (quebenTp) {
		case IBdFcDictCodeConst.SD_QUETP_EMP:
			match = this.isMatchOpRule(ruleItm, priDTO);//门诊
			break;
		case IBdFcDictCodeConst.SD_QUETP_MT:
			match = this.isMatchMtRule(ruleItm, priDTO);//医技
			break;
		case IBdFcDictCodeConst.SD_QUETP_PHARMACY:
			match = this.isMatchPharmRule(ruleItm, priDTO);//药房
			break;
		case IBdFcDictCodeConst.SD_QUETP_APPIP:
			match = this.isMatchIpAptRule(ruleItm, priDTO);//住院预约
			break;
		case IBdFcDictCodeConst.SD_QUETP_OPRULE:
			match = this.isMatchOpAPTRule(ruleItm, priDTO);//门诊挂号预约规则
			break;
		case IBdFcDictCodeConst.SD_QUETP_OTHER:
		default:
			match = this.isMatchOtherRule(ruleItm, priDTO);//其他
			break;
		}
		return match;
	}
	/**
	 * 匹配门诊规则
	 * 门诊规则因素：病情等级、患者分类、号别、回诊、年龄
	 * @param ruleItm
	 * @param priDTO
	 * @return
	 * @throws BizException 
	 */
	private boolean isMatchOpRule(QueRuleItmDO ruleItm, PriorityDTO priDTO)  {
		if (ruleItm == null || priDTO == null)
			return false;		
		if (this.isMatchOpt(ruleItm.getCodes_leveldise(), priDTO.getCode_level_dise())
				&& this.isMatchOpt(ruleItm.getIds_patca(), priDTO.getId_patca())
				&& this.isMatchOpt(ruleItm.getIds_scsrv(), priDTO.getId_scsrv())
				&& this.isMeetOpt(ruleItm.getFg_cont_prior(), priDTO.getFg_cont())
				&& this.isAgeMatchRuleOpt(ruleItm.getAge_max(), ruleItm.getAge_min(), priDTO.getD_birth())
				&& this.isMatchOpt(ruleItm.getId_sex(), priDTO.getId_sex())
				&& this.isMatchTag(ruleItm.getId_tagtp(), priDTO.getId_tagtp())
				&& this.isVIP(ruleItm,priDTO))
			return true;

		return false;
	}
	
	/**
	 * 匹配门诊挂号预约规则
	 * 门诊规则因素：病情等级、患者分类、号别、回诊、年龄
	 * @param ruleItm
	 * @param priDTO
	 * @return
	 */
	private boolean isMatchOpAPTRule(QueRuleItmDO ruleItm, PriorityDTO priDTO) {
		if (ruleItm == null || priDTO == null)
			return false;		
		if (this.isMatchOpt(ruleItm.getIds_patca(), priDTO.getId_patca())
				&& this.isAgeMatchRuleOpt(ruleItm.getAge_max(), ruleItm.getAge_min(), priDTO.getD_birth())
				&& this.isMatchOpt(ruleItm.getId_sex(), priDTO.getId_sex()))
			return true;

		return false;
	}
	/**
	 * 匹配药房规则
	 * 药房规则因素：病情等级、患者分类、号别、处方类型
	 * @param ruleItm 规则明细
	 * @param priDTO 优先DTO
	 * @return
	 */
	private boolean isMatchPharmRule(QueRuleItmDO ruleItm, PriorityDTO priDTO) {
		if (ruleItm == null || priDTO == null)
			return false;
		if (this.isMatchOpt(ruleItm.getCodes_leveldise(), priDTO.getCode_level_dise())
				&& this.isMatchOpt(ruleItm.getIds_patca(), priDTO.getId_patca())
				&& this.isMatchOpt(ruleItm.getIds_scsrv(), priDTO.getId_scsrv())
				&& this.isMatchOpt(ruleItm.getIds_prestp(), priDTO.getId_prestp())
				&& this.isMeetOpt(ruleItm.getFg_basedrug(), priDTO.getFg_base()))
			return true;

		return false;
	}
	/**
	 * 匹配医技规则
	 * 医技规则因素：病情等级、患者分类、号别
	 * @param ruleItm
	 * @param priDTO
	 * @return
	 */
	private boolean isMatchMtRule(QueRuleItmDO ruleItm,PriorityDTO priDTO){
		if (ruleItm == null || priDTO == null)
			return false;
		if (this.isMatchOpt(ruleItm.getCodes_leveldise(), priDTO.getCode_level_dise())
				&& this.isMatchOpt(ruleItm.getIds_patca(), priDTO.getId_patca())
				&& this.isMatchOpt(ruleItm.getIds_scsrv(), priDTO.getId_scsrv()))
			return true;

		return false;
	}
	/**
	 * 匹配住院预约规则
	 * 医技规则因素：病情等级、患者分类、计划内入院
	 * @param ruleItm
	 * @param priDTO
	 * @return
	 */
	private boolean isMatchIpAptRule(QueRuleItmDO ruleItm,PriorityDTO priDTO){
		if (ruleItm == null || priDTO == null)
			return false;
		if (this.isMatchOpt(ruleItm.getCodes_leveldise(), priDTO.getCode_level_dise())
				&& this.isMatchOpt(ruleItm.getIds_patca(), priDTO.getId_patca())
				&& this.isMeetOpt(ruleItm.getFg_planip(), priDTO.getFg_planip()))
			return true;

		return false;
	}
	/**
	 * 匹配其他规则
	 * 其他规则因素：病情等级、患者分类、号别
	 * @param ruleItm
	 * @param priDTO
	 * @return
	 */
	private boolean isMatchOtherRule(QueRuleItmDO ruleItm,PriorityDTO priDTO){
		if (ruleItm == null || priDTO == null)
			return false;
		if (this.isMatchOpt(ruleItm.getCodes_leveldise(), priDTO.getCode_level_dise())
				&& this.isMatchOpt(ruleItm.getIds_patca(), priDTO.getId_patca())
				&& this.isMatchOpt(ruleItm.getIds_scsrv(), priDTO.getId_scsrv()))
			return true;

		return false;
	}
	/**
	 * 是否符合
	 * 1、规则中未定义，则认为符合
	 * 2、如果预匹配的项为NULL，如果规则定义为false，则认为符合
	 * 3、规则中包含则符合
	 * @param rule 规则值
	 * @param input 校验值
	 * @return
	 */
	private boolean isMeetOpt(FBoolean rule,FBoolean input){
		//规则为空则符合
		if(rule==null){
			return true;
		}else if(input==null){
			return FBoolean.FALSE.equals(rule);
		}
		
		return rule.equals(input);
	}
	/**
	 * 是否符合
	 * 1、规则中未定义，则认为符合
	 * 2、规则中包含则符合
	 * @param rule 规则值
	 * @param input 校验值
	 * @return
	 */
	private boolean isMatchOpt(String rule,String input){
		//规则为空则符合
		if(StringUtil.isEmpty(rule)){
			return true;
		}else if(StringUtil.isEmpty(input)){
			return false;
		}else{
			return rule.indexOf(input)>=0;
		}
	}
	
	
	/**
	 * 是否符合
	 * 1、规则中未定义，则认为符合
	 * 2、规则中包含则符合
	 * @param rule 规则值
	 * @param input 校验值
	 * @return
	 */
	private boolean isMatchTag(String rule,String input){
		//规则为空则符合
		if(StringUtil.isEmpty(rule)){
			return true;
		}else if(StringUtil.isEmpty(input)){
			return false;
		}else{
			return input.indexOf(rule)>=0;
		}
	}
	/**
	 * 是否符合
	 * 1、规则中未定义，则认为符合
	 * 2、符合规则的返回则认为符合
	 * @param maxAge 规则规定的最大年龄
	 * @param minAge 规则规定的最小年龄
	 * @param birthDate 出生日期
	 * @return
	 */
	private boolean isAgeMatchRuleOpt(Integer maxAge, Integer minAge, FDate birthDate) {
		// 规则为空则符合
		if (maxAge == null && minAge == null) {
			return true;
		}
		Integer age = this.getAge(birthDate);
		if(age==null){
			return false;//年龄为空不符合
		}
		if (maxAge != null && minAge != null) {
			return (age <= maxAge) & (age >= minAge);
		} else {
			return maxAge != null ? (age <= maxAge) : (age >= minAge);
		}
	}
	/**
	 * 计算年龄
	 * @param birthDate 出生日期
	 * @return
	 */
	private Integer getAge(FDate birthDate){
		if(birthDate==null)
			return null;
		TimeService ts = ServiceFinder.find(TimeService.class);
		FDateTime currentTime = ts.getUFDateTime();
		int days = currentTime.getDate().getDaysAfter(birthDate);
		int age = days/365;
		return age;		
	}
	/**
	 * 判定是不是VIP
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	private boolean  isVIP(QueRuleItmDO ruleItm,PriorityDTO priDTO){
	 if(ruleItm.getFg_vip()==null || !ruleItm.getFg_vip().booleanValue())
			return true;
	 else if(priDTO.getFg_vip() ==null){
		 return false;
	 }else {
		 return (priDTO.getFg_vip().booleanValue()&&ruleItm.getFg_vip().booleanValue());
	}

	}
}
