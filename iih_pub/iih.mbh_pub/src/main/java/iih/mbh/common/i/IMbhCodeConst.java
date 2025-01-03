package iih.mbh.common.i;

public interface IMbhCodeConst {

	/**
	 * 应用装配参数类型
	 */
	// 就诊科室
	public static final String ID_DEP_PHY = "@@@@Z8100000000KB8Y2";
	public static final String SD_DEP_PHY = "0101";
	// 就诊病区
	public static final String ID_DEP_NUR = "@@@@Z8100000000KB8Y3";
	public static final String SD_DEP_NUR = "0102";
	// 责任护士
	public static final String ID_EMP_NUR = "@@@@Z8100000000KB8Y5";
	public static final String SD_EMP_NUR = "0103";
	// 入院日期
	public static final String ID_ENTRY = "@@@@Z8100000000KB8Y7";
	public static final String SD_ENTRY = "0104";
	// 护理等级
	public static final String ID_LEVEL_NUR = "@@@@Z8100000000KB8YB";
	public static final String SD_LEVEL_NUR = "0105";
	// 病情等级
	public static final String ID_DISEASE_LEVEL = "@@@@Z8100000000KB8YD";
	public static final String SD_DISEASE_LEVEL = "0106";
	// 闭环类型
	public static final String ID_ORPLTP = "@@@@Z8100000000KB8YF";
	public static final String SD_ORPLTP = "0201";
	// 闭环状态
	public static final String ID_ORPLTP_STA = "@@@@Z8100000000KB8YH";
	public static final String SD_ORPLTP_STA = "0202";
	// 执行状态
	public static final String ID_EXEC_STA = "@@@@Z8100000000KB8YN";
	public static final String SD_EXEC_STA = "0203";
	// 标签状态
	public static final String ID_LABLE_STA = "@@@@Z8100000000KB92H";
	public static final String SD_LABLE_STA = "0204";
	// 服务类型
	public static final String ID_SRVTP = "@@@@Z8100000000KB8YJ";
	public static final String SD_SRVTP = "0301";
	// 用法参数
	public static final String ID_ROUTE_PARAM = "@@@@Z8100000000KB8YK";
	public static final String SD_ROUTE_PARAM = "0302";
	// 功能编码
	public static final String ID_FUN_CODE = "@@@@Z8100000000KB8YL";
	public static final String SD_FUN_CODE = "0303";
	// 宽度
	public static final String ID_WIDTH = "@@@@Z8100000000KB8YP";
	public static final String SD_WIDTH = "0304";
	// 高度
	public static final String ID_HEIGHT = "@@@@Z8100000000KB8YR";
	public static final String SD_HEIGHT = "0305";
	// 时间区间
	public static final String ID_SECTION = "@@@@Z9100000000MR67H";
	public static final String SD_SECTION = "0310";
	// 皮试标记
	public static final String ID_SKINTEST = "@@@@Z9100000000MRK35";
	public static final String SD_SKINTEST = "0311";
	// 打印
	public static final String ID_PRINT = "@@@@Z8100000000K84YZ";
	public static final String SD_PRINT = "01";
	// 采集
	public static final String ID_COLLECT = "@@@@Z8100000000K84Z1";
	public static final String SD_COLLECT = "02";
	// 送检
	public static final String ID_SEND = "@@@@Z8100000000K84Z2";
	public static final String SD_SEND = "03";

	// 护理巡房
	public static final String ID_PATROL = "0001Z8100000000MP8BF";
	public static final String SD_PATROL = "01";
	// 输液巡视
	public static final String ID_INSPEC = "0001Z8100000000MP8BG";
	public static final String SD_INSPEC = "02";
	// 护理巡房类型coee
	public static final String PATROLTP_CODE = "MP.NU.1085";

	// 发烧
	public static final String ID_TEMP_NORMAL = "@@@@AA100000000991UE";
	public static final String SD_TEMP_STATETP = "0113";
	// 疼痛
	public static final String ID_PAIN_NORMAL = "@@@@Z81000000002YXD9";
	public static final String SD_PAIN_STATETP = "0114";

	// 皮试标记
	public static final String ID_SKINFLAG = "@@@@Z9100000000MRK35";
	public static final String SD_SKINFLAG = "0311";

	// 功能锁定
	public static final String ID_FUNLOCK = "@@@@Z9100000000MRKV0";
	public static final String SD_FUNLOCK = "0401";

	
	// 在科
	public static final String ID_INDEP = "@@@@Z8100000000CTT3A";
	public static final String SD_INDEP = "1";
	
	// 自由体位
	public static final String ID_FREEPOS = "@@@@Z8100000000CTT3I";
	public static final String SD_FREEPOS = "1";
	
	// 无约束
	public static final String ID_NOCONSTRAINT = "@@@@Z8100000000CTT3Q";
	public static final String SD_NOCONSTRAINT = "1";
	
	// 患者外出档案
	public static final String PAT_GOING_CODE = "MBH.MP.1005";
	public static final String PAT_GOING_ID = "@@@@ZZ2000000000012T";
	
	//患者体位档案
	public static final String PAT_POS_CODE = "MBH.MP.1010";
	public static final String PAT_POS_ID = "@@@@ZZ2000000000012U";
	
	//患者保护约束档案
	public static final String PAT_PRO_CON_CODE = "MBH.MP.1015";
	public static final String PAT_PRO_CON_ID = "@@@@ZZ2000000000012V";
	
	//小批量范围执行，分隔符标记
	public static final String SPLIT_FLAG = ",";
	
	//用法id_udidoclist
	public static final String ROUTEID = "@@@@BZ400000000001EG";
	
	//长临id_udidoclist
	public static final String LONGID = "@@@@LL2000000000015Q";
	
	//服务类型id_udidoclist
	public static final String SRVTPID = "@@@@ZZ2000000000000T";
	
	//全部标记all
	public static final String ALLFLAG = "all";
	
	//滴速单位ml/min
	public static final String ID_UNIT_ML_MIN="@@@@Z7100000000WE0XO";
	
	//滴速单位ml/h
	public static final String ID_UNIT_ML_HOUR="@@@@Z7100000000WE0XP";
	
	//剂量单位ml
	public static final String ID_MEDU_ML="@@@@Z7100000000NY5UI";
	
	//消毒包状态档案
	public static final String SD_DFP_STATUS = "CSSD.DPBD.0112";
	
	//药品配液功能编码
	public static final String FUN_CODE_DGPEIYE = "58101012";
}
