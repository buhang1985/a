package iih.en.comm;

/**
 * 就诊规则常量
 * @author yank
 *
 */
public interface IEnRuleConst {
	/***
	 * 退短信发送规则引擎对应规则包编码常量
	 */
	public static final String EN_CANCEREG_SENDMSG_REGRULEPKG_CONST = "EN.CANCEREG.SENDMSG.RULEPKG";
	/***
	 * 挂号短信发送规则引擎对应规则包编码常量
	 */
	public static final String EN_SENDMSG_REGRULEPKG_CONST = "EN.SENDMSG.RULEPKG";
	/**
	 * 门诊挂号规则引擎对应规则包编码常量
	 */
	public static final String EN_REG_REGRULEPKG_CONST = "EN.REG.REGRULEPKG";
	/**
	 * 住院规则引擎对应规则包编码常量
	 */
	public static final String EN_IP_RULEPKG_CONST = "EN.IP.RULEPKG";
	/**
	 * 接诊规则引擎对应规则包编码常量
	 */
	public static final String EN_ACPT_RULEPKG_CONST = "EN.ACPT.RULEPKG";
	/**
	 * 住院-患者信息规则引擎对应规则包编码常量
	 */
	public static final String EN_IP_PATQRY_RULEPKG_CONST = "EN.IP.PATQRY.RULEPKG";
	/**
	 * 诊间挂号规则引擎对应规则包编码常量 fanlq-2019-11-18
	 */
	public static final String EN_OPIN_REGPKG_CONST = "EN.OPIN.REGPKG";
	/**
	 * 医保患者挂号规则引擎对应规则包编码常量 fanlq-2017-10-24
	 */
	public static final String EN_HP_REG_RULEPK_CONST = "EN.HP.REG.RULEPKG";
	/**
	 * 退号补号规则
	 */
	public static final String EN_CANC_SUPPLYTICKET_CODE = "EN.CANC.SUPPLYTICKET";
	/**
	 * 出院其他校验规则
	 */
	public static final String EN_IP_LVHOSCHECK_CODE = "EN.IP.LVHOSCHECK";
	/**
	 * 转科其他校验规则
	 */
	public static final String EN_IP_TRANDEPCHECK_CODE = "EN.IP.TRANDEPCHECK";
	/**
	 * 腕带打印方式规则
	 */
	public static final String EN_IP_PRINTWRISTCARDTYPE = "EN.IP.PRINTWRISTCARDTYPE";
	//wjy添加
	//门诊挂号规则引擎常量(增加一条规则编码，需要在IEnMsgConst类中增加一个对应提示信息常量)
	/**
	 * 年龄规则
	 */
	public static final String EN_REG_AGE_CONST = "EN_REG_AGE";
	/**
	 * 男性规则
	 */
	public static final String EN_REG_SEX_MALE_CONST = "EN_REG_SEX_MALE";
	/**
	 * 女性规则
	 */
	public static final String EN_REG_SEX_FEMALE_CONST = "EN_REG_SEX_FEMALE";
	/**
	 * 不允许在同一天挂多个相同科室大于2个相同服务号
	 */
	public static final String EN_REG_COUNT_CONST = "EN_REG_COUNT";
	/**
	 * 跨节点校验是否已挂该号
	 */
	public static final String EN_REG_REPEAT_CONST = "EN_REG_REPEAT";
	/**
	 * 跨节点校验是否已预约该号
	 */
	public static final String SC_APT_REPEAT_CONST = "SC_APT_REPEAT";
	/**
	 * 同个时间段，患者最多可以挂2个科的号
	 */
	public static final String EN_REG_DLOT_DEP_CONST = "EN_REG_DLOT_DEP";
	/**
	 * 住院期间不允许挂门诊
	 */
	public static final String IP_IS_EXIST_CONST = "IP_IS_EXIST";
	
	/**
	 * 小于14岁患者不能挂此号
	 */
	public static final String EN_REG_JOINT_RULE2 = "EN_REG_JOINT_RULE2";
	/**
	 * 小于14岁患者不能挂此号
	 */
	public static final String EN_REG_SPINE_RULE2 = "EN_REG_SPINE_RULE2";
	/**
	 * 小于14岁患者不能挂此号
	 */
	public static final String EN_REG_RULE_18 = "EN_REG_RULE_18";
	
	//入院登记规则引擎常量(增加一条规则编码，需要在IEnMsgConst类中增加一个对应提示信息常量)
	/**
	 * 年龄规则
	 */
	public static final String EN_IP_AGE_CONST = "EN_IP_AGE";
	/**
	 * 男性规则
	 */
	public static final String EN_IP_SEX_MALE_CONST = "EN_IP_SEX_MALE";
	/**
	 * 女性规则
	 */
	public static final String EN_IP_SEX_FEMALE_CONST = "EN_IP_SEX_FEMALE";
}
