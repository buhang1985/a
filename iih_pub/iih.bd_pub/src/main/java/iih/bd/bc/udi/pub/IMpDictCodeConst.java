package iih.bd.bc.udi.pub;

/**
 * 医疗执行管理模块(IIH.MP)相关的基础数据常量定义。
 */
public interface IMpDictCodeConst {
	/*
	 * 例 ：如下 public static final String SD_REACTCA_NONE = "0"; //不排斥 public
	 * static final String SD_REACTCA_ALL = "1"; //全排斥 public static final
	 * String SD_REACTCA_INGROUP = "2"; //组内排斥 1：门诊 11：审核 12：配药 13：门诊发药 14：门诊退药
	 * 2：住院 21：住院发药 22：住院退药
	 * 
	 */
	public static final String SD_MPDGTP_OP = "1";
	public static final String SD_MPDGTP_OP_AUDIT = "11";
	public static final String SD_MPDGTP_OP_PEIYAO = "12";
	public static final String SD_MPDGTP_OP_DISPENSE = "13";
	public static final String SD_MPDGTP_OP_DRUGRTN = "14";
	public static final String SD_MPDGTP_IP = "2";
	public static final String SD_MPDGTP_IP_DISPENSE = "21";
	public static final String SD_MPDGTP_IP_DRUGRTN = "22";
	public static final String SD_MPDGTP_IP_TAKE = "23";

	public static final String ID_MPDGTP_OP = "@@@@AA1000000001D8EE";// 1：门诊0001AA1000000001D8EE
	public static final String ID_MPDGTP_OP_AUDIT = "@@@@AA1000000001U0JO";// 11：审核0001AA1000000001U0JO
	public static final String ID_MPDGTP_OP_PEIYAO = "@@@@Z7100000000MHZQ2";// 12：配药0001AA1000000001U0JP
	public static final String ID_MPDGTP_OP_DISPENSE = "@@@@AA1000000001U0JQ";// 13：门诊发药0001AA1000000001U0JQ
	public static final String ID_MPDGTP_OP_DRUGRTN = "@@@@AA1000000001U0JR";// 14：门诊退药0001AA1000000001U0JR
	public static final String ID_MPDGTP_IP = "@@@@AA1000000001D8EF";// 2：住院0001AA1000000001D8EF
	public static final String ID_MPDGTP_IP_DISPENSE = "@@@@AA1000000001U0JS";// 21：住院发药0001AA1000000001U0JS
	public static final String ID_MPDGTP_IP_DRUGRTN = "@@@@AA1000000001U0JT";// 22：住院退药0001AA1000000001U0JT
	public static final String ID_MPDGTP_IP_TAKE = "@@@@AA10000000097JIE";// 23：出院带药0001AA10000000097JIE

	// public static final String ID_MPDGTP_IP_APTYPE =
	// "0001ZZ2000000000009F";// 住院药品请领状态
	// public static final String ID_MPDGTP_IP_DESENDTYPE =
	// "0001ZZ200000000000A3";// 住院药品发放类型

	/*
	 * 住院药品发放类型
	 */
	public static final String SD_DGTP_SEND = "21";// 发药
	public static final String SD_DGTP_RETURN = "22";// 退药
	public static final String SD_DGTP_TAKE = "23";// 出院带药

	/**
	 * 住院药品请领状态
	 */
	public static final Integer SD_DGAP_IP_NOT_SEND = 0;// 未发送
	public static final Integer SD_DGAP_IP_SEND = 1;// 已发送,未确认
	public static final Integer SD_DGAP_IP_CONFIRMED = 2;// 已确认
	public static final Integer SD_DGAP_IP_SENDING = 3;// 发药中
	public static final Integer SD_DGAP_IP_FINISHED = 4;// 发药完成
	public static final Integer SD_DGAP_IP_CANCELED = 5;// 已作废

	public static final String ID_DGAP_IP_NOT_SEND = "@@@@AA10000000097JG3";// 未发送
	public static final String ID_DGAP_IP_SEND = "@@@@AA10000000097JG4";// 已发送,未确认
	public static final String ID_DGAP_IP_CONFIRMED = "@@@@AA10000000097JG5";// 已确认
	public static final String ID_DGAP_IP_SENDING = "@@@@AA10000000097JG2";// 发药中
	public static final String ID_DGAP_IP_FINISHED = "@@@@AA10000000097JG6";// 发药完成
	public static final String ID_DGAP_IP_CANCELED = "@@@@AA10000000097JG7";// 已作废

	/**
	 * 联动药单业务类型
	 */
	public static final String SD_SPAUTO_MT_ADDFEE = "1";// 医技补费联动生单
	public static final String SD_SPAUTO_MT_REFUNDFEE = "2";// 医技补费联动生单
	public static final String SD_SPECIAL_HERB_RETURN = "8";// 草药特殊退药单
	public static final String SD_SPECIAL_RETURN = "9";// 特殊退药单

	/**
	 * 输液执行类型
	 */
	public static final String ID_INFUTP_UNPREPARED = "@@@@Z8100000000MLESX";// 未开始
	public static final String ID_INFUTP_PREPARE = "@@@@Z7100000000NKHKM";// 配液
	public static final String ID_INFUTP_BEGIN = "@@@@Z7100000000NKHKN";// 穿刺，开始输液
	public static final String ID_INFUTP_PATROL = "@@@@Z7100000000NKHKO";// 巡视
	public static final String ID_INFUTP_END = "@@@@Z7100000000NKHKP";// 输液结束
	public static final String ID_INFUTP_PAUSE = "@@@@Z8100000000MLCAR";// 暂停
	public static final String ID_INFUTP_STOP = "@@@@Z8100000000MLCAS";// 停止
	public static final String ID_INFUTP_SKIN = "@@@@Z81000000008TMI2";//穿刺
	public static final String ID_INFUTP_INJECTFINISH = "@@@@Z81000000008Z73S";// 注射完成

	
	public static final String SD_INFUTP_UNPREPARED = "0";// 未开始
	public static final String SD_INFUTP_PREPARE = "1";// 配液
	public static final String SD_INFUTP_BEGIN = "2";// 开始输液
	public static final String SD_INFUTP_PATROL = "3";// 巡视
	public static final String SD_INFUTP_END = "4";// 输液结束
	public static final String SD_INFUTP_PAUSE = "5";// 暂停
	public static final String SD_INFUTP_STOP = "6";// 停止
	

	/**
	 * 护士交接班班次ID,SD
	 */
	public static final String ID_SH_MO = "@@@@AA10000000056YPX";// 早班
	public static final String SD_SH_MO = "1";// 早班
	public static final String ID_SH_NO = "@@@@AA10000000056YPY";// 中班
	public static final String SD_SH_NO = "2";// 中班
	public static final String ID_SH_NI = "@@@@AA10000000056YPZ";// 晚班
	public static final String SD_SH_NI = "3";// 晚班

	/**
	 * 护士交接班病区汇总信息项目
	 */

	public static final String ID_ENTERHOSPITAL = "@@@@AA1000000004UC8I";
	public static final String CODE_ENTERHOSPITAL = "01";// 入院
	public static final String ID_TRANSFERIN = "@@@@AA1000000004UC8J";
	public static final String CODE_TRANSFERIN = "02";// 轉入
	public static final String ID_OUTHOSPITAL = "@@@@AA1000000004UC8K";
	public static final String CODE_OUTHOSPITAL = "03";// 出院
	public static final String ID_TRANSFEROUT = "@@@@AA1000000004UC8L";
	public static final String CODE_TRANSFEROUT = "04";// 轉出
	public static final String ID_DEATH = "@@@@AA1000000004UC8M";
	public static final String CODE_DEATH = "05";// 死亡
	public static final String ID_OPERATION = "@@@@AA1000000004UC8N";
	public static final String CODE_OPERATION = "06";// 手術
	public static final String ID_DISEASESEVERITY = "@@@@AA1000000004UC8O";
	public static final String CODE_DISEASESEVERITY = "07";// 病重
	public static final String ID_DELIVERY = "@@@@AA1000000004UC8P";
	public static final String CODE_DELIVERY = "08";// 分娩

	/**
	 * 异常编码--综合窗口
	 */
	public static final int EXCEPTION_CODE_SYNTH = 1024;//
	/**
	 * 性别(自定义档案)
	 */
	public static final String ID_UDIDOCLIST_SEX = "@@@@ZZ20000000000035";//性别
		
	/**
	 * 医疗服务类型(出院)
	 */
	public static final String ID_SRVTP_LEVHOS = "@@@@W11000000003UM1W";//出院
	/**
	 * 医疗服务类型(死亡)
	 */
		public static final String ID_SRVTP_DIE = "@@@@W11000000003UM1X";//出院

	/**
	 * 首日摆药状态_首日不摆
	 */
	public static final String SD_FIRSTDAYDRUGSTATE_FIRSTDAYNOTSET = "01";
	public static final String ID_FIRSTDAYDRUGSTATE_FIRSTDAYNOTSET = "@@@@Z8100000000QB7JS";
	
	/**
	 * 首日摆药状态_首日摆药
	 */
	public static final String SD_FIRSTDAYDRUGSTATE_FIRSTDAYSET = "02";
	public static final String ID_FIRSTDAYDRUGSTATE_FIRSTDAYSET = "@@@@Z8100000000QB7JT";

	/**
	 * 首日摆药状态_首日特殊摆药
	 */
	public static final String SD_FIRSTDAYDRUGSTATE_FIRSTDAYSPEDISP = "03";
	public static final String ID_FIRSTDAYDRUGSTATE_FIRSTDAYSPEDISP = "@@@@Z8100000000QB7JU";
	
	/**
	 * 刷单校验类型_库存不足
	 */
	public static final String SD_BRUSHCHECKTYPE_LACKSTOCK = "00";
	public static final String ID_BRUSHCHECKTYPE_LACKSTOCK = "@@@@Z81000000004WON7";
	/**
	 * 刷单校验类型_患者欠费
	 */
	public static final String SD_BRUSHCHECKTYPE_PATARREARS = "01";
	public static final String ID_BRUSHCHECKTYPE_PATARREARS = "@@@@Z81000000004WONA";
	/**
	 * 刷单校验类型_物品停发
	 */
	public static final String SD_BRUSHCHECKTYPE_PARARTICLES = "02";
	public static final String ID_BRUSHCHECKTYPE_PARARTICLES = "@@@@Z81000000004WOND";
	/**
	 * 刷单校验类型_首日不摆
	 */
	public static final String SD_BRUSHCHECKTYPE_FIRSTDAYNOTSET = "03";
	public static final String ID_BRUSHCHECKTYPE_FIRSTDAYNOTSET = "@@@@Z81000000004WONF";
	
	/**
	 * 药单使用场景_发送草药单
	 */
	public static final String SD_DRUGUSESCENE_HERBLIST = "00";

	/**
	 * 药单使用场景_发送西成药单
	 */
	public static final String SD_DRUGUSESCENE_WESTERNLIST = "01";

	/**
	 * 药单使用场景_单药发药
	 */
	public static final String SD_DRUGUSESCENE_SIDGDISP = "02";

	/**
	 * 药单使用场景_西成药发药
	 */
	public static final String SD_DRUGUSESCENE_WESTERNDGDISP = "03";

	/**
	 * 药单使用场景_医技补费
	 */
	public static final String SD_DRUGUSESCENE_DGTECHNOSUPP = "04";

	/**
	 * 药单使用场景_西成药批量发药
	 */
	public static final String SD_DRUGUSESCENE_WESTERNDGBULKDEL = "05";
    
    
    /**
     * 药单异常控制结果_不校验
     */
    public static final String SD_DRUGEXCCTRLRESU_NOCHECK = "00" ;
    
    /**
     * 药单异常控制结果_可转正常
     */
    public static final String SD_DRUGEXCCTRLRESU_NORMAL = "01" ;
    
    /**
     * 药单异常控制结果_不可转
     */
    public static final String SD_DRUGEXCCTRLRESU_ABNORMAL = "02" ;
    

    /**
     * 拆分1.0逻辑标记
     */
    public static final String SPLIT_V1 = "v1" ;
    
    /**
     * 拆分2.0逻辑标记
     */
    public static final String SPLIT_V2 = "v2" ;
    
    /**
     * 通用医嘱执行计划闭环状态更新1.0逻辑标记
     */
    public static final String UPDATEORPLTPBYOR_V1 = "v1" ;
    
    /**
     * 通用医嘱执行计划闭环状态更新2.0逻辑标记
     */
    public static final String UPDATEORPLTPBYOR_V2 = "v2" ;
    
    /**
     * 通用医嘱执行计划闭环状态更新1.0逻辑标记
     */
    public static final String UPDATEORPLTPBYPLAN_V1 = "v1" ;
    
    /**
     * 通用医嘱执行计划闭环状态更新2.0逻辑标记
     */
    public static final String UPDATEORPLTPBYPLAN_V2 = "v2" ;
    
    /**
	 * 病区执行打印单据分类类型自定义档案id
	 */
	public static final String TYPEOFMPORPRNCA = "@@@@ZZ200000000000SI";
	
	/**
	 * 门急诊签到刷卡模式
	 */
	public static final String SIGN_SWIP_MODE_ENTCARD = "0";//就诊卡号
	public static final String SIGN_SWIP_MODE_PATCODE = "1";//患者编码
	public static final String SIGN_SWIP_MODE_PATID = "2";//患者主键
	public static final String SIGN_SWIP_MODE_IDCODE = "3";//证件号码
	public static final String SIGN_SWIP_MODE_ELEHEALTHCARD  = "4";//电子健康卡
	
	/**
	 * 药品执行规则集
	 */
	public static final String MP_DG_PRESCHECK = "MP.DG.PRESCHECK";//门急诊需审核处方规则
	public static final String PRES_NEED_CHK = "PRES_NEED_CHK";//门急诊需审核处方规则离休医保病人在保健科开的处方
    
	/**
	 * 药品执行规则集
	 */
	public static final String MP_DG_OPRULE = "MP.DG.OPRULE";//门急诊发药相关规则
	public static final String OPDISP_OTHERWH_INFO = "OPDISP_OTHERWH_INFO";//患者在其他药房存在未取药处方时给出提示
	
	/**
	 * 医嘱闭环匹配开单部门关系__自定义档案
	 */
	public static final String MP_BD_DEPNODE= "@@@@Z8100000003JJXA8";//医嘱闭环匹配开单部门关系__不限制
	public static final String MP_BD_DEPCTRL= "@@@@Z8100000003JJXA9";//医嘱闭环匹配开单部门关系__就诊科室开单
	public static final String MP_BD_DEPEXCLUDE= "@@@@Z8100000003JJXAA";//医嘱闭环匹配开单部门关系__非就诊科室开单
	
	/**
	 * 领药方式
	 */
	public static final String MP_BD_DDM = "@@@@Z8100000000YC5JO";// 领药方式 退药
}
