package iih.bd.bc.udi.pub;

/**
 * 临床信息管理模块(IIH.CI)相关的基础数据常量定义。
 */
public interface ICiDictCodeConst {

	//系统标识
	public static final String IIH ="IIH";
	/*
	 * 例 ：如下 public static final String SD_REACTCA_NONE = "0"; //不排斥 public
	 * static final String SD_REACTCA_ALL = "1"; //全排斥 public static final
	 * String SD_REACTCA_INGROUP = "2"; //组内排斥
	 */
	/**
	 * 病历段落
	 */
	public static final String CODE_ELEMENT_MAINSUIT = "S.01"; // 主诉
	public static final String CODE_ELEMENT_NOWDISEASE = "S.03"; // 现病史
	public static final String CODE_ELEMENT_TEST = "S.02"; // 体格检查
	/*
	 * 医嘱状态
	 */
	public static final String SD_SU_OPEN = "0"; // 开立
	public static final String SD_SU_ID_OPEN = "@@@@AA1000000001SG7T"; // 开立
	public static final String SD_SU_SIGN = "10"; // 签署
	public static final String SD_SU_ID_SIGN = "@@@@AA1000000001SG7U"; // 签署
	public static final String SD_SU_CHECKTHROUGH = "20"; // 核对通过
	public static final String SD_SU_ID_CHECKTHROUGH = "@@@@AA1000000001SG7V"; // 核对通过

	public static final String SD_SU_21 = "21";// 执行中
	public static final String SD_SU_22 = "22";// 确认预停
	public static final String SD_SU_23 = "23";// 预停

	public static final String SD_SU_XECUTING = "30"; // 执行中
	public static final String SD_SU_ID_XECUTING = "@@@@AA1000000001Q461"; // 执行中

	public static final String SD_SU_DOCTORSTOP = "40"; // 医生停止
	public static final String SD_SU_ID_DOCTORSTOP = "@@@@AA1000000001SG7Y"; // 医生停止

	public static final String SD_SU_CHECKSTOP = "50"; // 核对停止
	public static final String SD_SU_ID_CHECKSTOP = "@@@@AA1000000001SG7Z"; // 核对停止

	public static final String SD_SU_51 = "51";// 停止

	public static final String SD_SU_CANCEL = "70"; // 作废
	public static final String SD_SU_ID_CANCEL = "@@@@AA1000000003SRM1"; // 作废

	public static final String SD_SU_FINISH = "60"; // 完成
	public static final String SD_SU_ID_FINISH = "@@@@AA1000000001Q462"; // 完成

	public static final String SD_SU_61 = "61";// 取消
	public static final String SD_SU_62 = "62";// 不执行

	public static final String SD_SU_CHECKCANCEL = "80"; // 核对作废
	public static final String SD_SU_ID_CHECKCANCEL = "@@@@AA1000000003SRM2"; // 核对作废

	public static final String SD_SU_11 = "11";// 未知
	// 0 开立；10已 签署；20 核对通过 ；40 医生停止；50 核对停止；70 医生作废；80 核对作废

	/*
	 * 关联医嘱类型
	 */
	public static final String SD_RELTYPE_PMOR = "0"; // 备用医嘱关联
	public static final String SD_RELTYPE_SKINTEST = "1"; // 皮试医嘱关联
	public static final String SD_RELTYPE_BLOOD = "2";// 输血医嘱关联
	public static final String SD_RELTYPE_ID_PMOR = "@@@@AA10000000050QZK"; // 备用医嘱关联
	public static final String SD_RELTYPE_ID_SKINTEST = "@@@@AA10000000050QZL"; // 皮试医嘱关联
	public static final String SD_RELTYPE_ID_BLOOD = "@@@@AA1000000006S4BS"; // 输血医嘱关联
	/*
	 * 医嘱报告结果类型
	 */
	public static final String SD_ORRSTTP_NOOUT = "0"; // 医嘱结果报告未出
	public static final String SD_ORRSTTP_JUSTOUT = "1"; // 医嘱结果报告初出
	public static final String SD_ORRSTTP_AUDITED = "2";// 医嘱结果报告已审核
	/*
	 * 临床事件类型
	 */
	public static final String SD_EVENTTP_CI_DIAG = "0"; // 诊断
	public static final String SD_EVENTTP_CI_OR = "1"; // 医嘱
	public static final String SD_EVENTTP_CI_MR = "2"; // 记录
	public static final String ID_EVENTTP_CI_DIAG = "@@@@AA10000000051O4H"; // 诊断
	public static final String ID_EVENTTP_CI_OR = "@@@@AA10000000051O4I"; // 医嘱
	public static final String ID_EVENTTP_CI_MR = "@@@@AA10000000051O4J"; // 记录

	/*
	 * 会诊申请状态
	 */
	// 以前的会诊状态 废弃
	/*
	 * public static final String SD_SU_CONS_PLAN = "0"; public static final
	 * String SD_SU_CONS_CONFIRMING = "1"; public static final String
	 * SD_SU_CONS_CONFIRMED = "2"; public static final String SD_SU_CONS_PLAN_ID
	 * = "@@@@AA1000000004IXS8"; public static final String
	 * SD_SU_CONS_CONFIRMING_ID = "@@@@AA1000000004IXS9"; public static final
	 * String SD_SU_CONS_CONFIRMED_ID = "@@@@AA1000000004PTHQ";
	 */

	public static final String ID_CI_CONS_DKSSP = "@@@@AA1000000004IXS8";// 待科室审批
	public static final String ID_CI_CONS_KSBH = "@@@@AA1000000004IXS9";// 科室驳回
	public static final String ID_CI_CONS_DYWSP = "@@@@AA1000000004PTHQ";// 待医务审批
	public static final String ID_CI_CONS_YWBH = "@@@@AA1000000005PTHQ";// 医务驳回
	public static final String ID_CI_CONS_DKSYD = "@@@@AA1000000006PTHQ";// 待科室应答
	public static final String ID_CI_CONS_KSBFYD = "@@@@AA1000000007PTHQ";// 科室部分应答
	public static final String ID_CI_CONS_KSYYD = "@@@@AA1000000008PTHQ";// 科室已应答
	public static final String ID_CI_CONS_HZWC = "@@@@AA1000000009PTHQ";// 会诊完成

	public static final String SD_CI_CONS_DKSSP = "0";// 待科室审批
	public static final String SD_CI_CONS_KSBH = "1";// 科室驳回
	public static final String SD_CI_CONS_DYWSP = "2";// 待医务审批
	public static final String SD_CI_CONS_YWBH = "3";// 医务驳回
	public static final String SD_CI_CONS_DKSYD = "4";// 待科室应答
	public static final String SD_CI_CONS_KSBFYD = "5";// 科室部分应答
	public static final String SD_CI_CONS_KSYYD = "6";// 科室已应答
	public static final String SD_CI_CONS_HZWC = "7";// 会诊完成

	/*
	 * 退药类型
	 */
	public static final String SD_BACKTP_ALL = "0"; // 全退
	public static final String SD_BACKTP_ID_ALL = "@@@@AA1000000001SG81"; // 全退
	public static final String SD_BACKTP_PART = "1"; // 部分退
	public static final String SD_BACKTP_ID_PART = "@@@@AA1000000001SG82"; // 部分退
	public static final String SD_BACKTP_NORMAL = "2"; // 正常
	public static final String SD_BACKTP_ID_NORMAL = "@@@@AA1000000001SG83"; // 正常
	/*
	 * 医嘱记账状态
	 */
	public static final String SD_SU_BL_NONE = "0"; // 未记账
	public static final String SD_SU_BL_NONE_ID = "@@@@AA10000000026638"; // 未记账
	public static final String SD_SU_BL_ACCOUNT = "1"; // 已记账
	public static final String SD_SU_BL_ACCOUNT_ID = "@@@@AA10000000026639"; // 已记账
	public static final String SD_SU_BL_REFOUND = "2"; // 已退费
	public static final String SD_SU_BL_REFOUND_ID = "@@@@AA1000000002663A"; // 已退费

	/*
	 * 医嘱执行状态
	 */
	public static final String SD_SU_MP_NONE = "0"; // 未执行
	public static final String SD_SU_MP_NONE_ID = "@@@@AA1000000004KRCA"; // 未执行
	public static final String SD_SU_MP_PERFORMED = "1"; // 已执行
	public static final String SD_SU_MP_PERFORMED_ID = "@@@@AA1000000004KRCB"; // 已执行
	public static final String SD_SU_MP_FINISH = "2"; // 完成
	public static final String SD_SU_MP_FINISH_ID = "@@@@AA1000000004KRCD"; // 完成
	public static final String SD_SU_MP_EXEOK = "20"; // 执行完成
	public static final String SD_SU_MP_EXEOK_ID = "@@@@AA1000000001U6R7"; // 执行完成
	public static final String SD_SU_MP_EXECANC = "21"; // 执行取消
	public static final String SD_SU_MP_EXECANC_ID = "@@@@AA1000000001U6R8"; // 执行取消
	public static final String SD_SU_MP_CANCEL = "22"; // 拒绝执行
	public static final String SD_SU_MP_CANCEL_ID = "@@@@AA1000000004KRCC"; // 拒绝执行
	public static final String SD_SU_DOCTORCANCEL = "70";

	/**
	 * 转科过程状态
	 */
	public static final String SD_SU_TRANS_OPEN = "1";// 开立
	public static final String SD_SU_TRANS_APPLYOUT = "2";// 已申请转出
	public static final String SD_SU_TRANS_RECEIVED = "3";// 已接收完成
	public static final String SD_SU_TRANS_CANCEL = "4";// 已取消

	/**
	 * 服务类型
	 */
	// 药品
	public static final String ID_COMMONDRUG = "@@@@W11000000003UM03";
	public static final String SD_COMMONDRUG = "01";
	// 检查
	public static final String ID_RIS = "@@@@W11000000003UM05";
	public static final String SD_RIS = "02";
	// 检验
	public static final String ID_LIS = "@@@@W11000000003UM07";
	public static final String SD_LIS = "03";
	// 手术
	public static final String ID_OPER = "@@@@W11000000003UM08";
	public static final String SD_OPER = "04";
	/*
	 * //治疗 public static final String 1001W11000000003UM09 public static final
	 * String 05 //护理 public static final String 1001W11000000003UM0A public
	 * static final String 06 //卫材 public static final String
	 * 1001W11000000003UM1K public static final String 07 //嘱托 public static
	 * final String 1001W11000000003UM0B public static final String 08 //诊疗
	 * public static final String 1001W11000000003UM0C public static final
	 * String 09 //健康 public static final String 1001W11000000003UM0D public
	 * static final String 10 //诊疗方案服务包 public static final String
	 * 1001W11000000003UM0E public static final String 11 //患者管理类 public static
	 * final String 1001W11000000003UM0F public static final String 12 //固定费用类
	 * public static final String 1001W11000000003UM0G public static final
	 * String 13 //血液制品 public static final String 1001W11000000003UM0H public
	 * static final String 14 //其他 public static final String
	 * 1001W11000000003UM0I public static final String 99
	 */

	// 离院转归--死亡状态
	public static final String ID_GOWHERE = "@@@@AA1000000001H2IQ";
	public static final String SD_GOWHERE = "5";
	// 就诊状态--出院状态sd_status
	// public static final String ID_STATUS = "";
	public static final String SD_STATUS = "28";
	// 病情等级
	public static final String ID_LEVEL_DISE01 = "@@@@AA10FDKJSBKJBKFD";// 病重
	public static final String LEVEL_DISE_CODE01 = "01";
	public static final String ID_LEVEL_DISE02 = "@@@@AA1000000DFJBKDJ";// 病危
	public static final String LEVEL_DISE_CODE02 = "02";
	public static final String ID_LEVEL_DISE03 = "@@@@AA10FDKDGKDGHFFI";// 普通
	public static final String LEVEL_DISE_CODE03 = "03";



	/**
	 * 诊断使用
	 */
	public static final String ID_process_udidoclist = "@@@@ZZ2000000000004P";
	// 签署
	public static final String ID_SIGN = " 0001AA1000000004A7P5";
	public static final String SD_SIGN = "0";
	// 门诊诊断
	public static final String ID_OPDI = "@@@@Z7100000000PWW43";
	public static final String SD_OPDI = "00";
	// 初步诊断
	public static final String ID_FIRST = "@@@@Z7100000000PWW44";
	public static final String SD_FIRST = "11";
	// 入院诊断
	public static final String ID_INHOSPITAL = "@@@@Z7100000000PWW45";
	public static final String SD_INHOSPITAL = "12";
	// 补充 诊断amend
	public static final String ID_SUPPLY = "@@@@Z7100000000PWW47";
	public static final String SD_SUPPLY = "14";
	// 修正 诊断
	public static final String ID_AMEND = "@@@@Z7100000000PWW46";
	public static final String SD_AMEND = "13";
	// 出院诊断
	public static final String ID_OUTHOSPITAL = "@@@@Z7100000000PWW48";
	public static final String SD_OUTHOSPITAL = "15";
	// 死亡诊断
	public static final String ID_DIE = "@@@@Z7100000000PWW49";
	public static final String SD_DIE = "16";

	/**
	 * 诊断科学类型
	 */
	// 西医
	public static final String ID_DITP_XY = "@@@@AA1000000003N01T";
	public static final String SD_DITP_XY = "0";
	// 中医
	public static final String ID_DITP_ZY = "@@@@AA1000000003N01U";
	public static final String SD_DITP_ZY = "1";

	// 检验结果偏离
	// 正常
	public static final String SD_DEVIATE_NORMAL = "0";

	/**
	 * 检验状态
	 */
	public static final String ID_CI_LAB_SQ = "@@@@AA1000000006JVIH";// 申请
	public static final String ID_CI_LAB_YY = "@@@@AA1000000006JVII";// 预约
	public static final String ID_CI_LAB_CJ = "@@@@AA1000000006JVIJ";// 采集
	public static final String ID_CI_LAB_YQS = "@@@@AA1000000006JVIK";// 已签收
	public static final String ID_CI_LAB_JY = "@@@@AA1000000006JVIL";// 检验
	public static final String ID_CI_LAB_BG = "@@@@AA1000000006JVIM";// 报告
	public static final String ID_CI_LAB_YQX = "@@@@AA1000000006JVIN";// 已取消

	public static final String SD_CI_LAB_SQ = "0";// 申请
	public static final String SD_CI_LAB_YY = "1";// 预约
	public static final String SD_CI_LAB_CJ = "2";// 采集
	public static final String SD_CI_LAB_YQS = "3";// 已签收
	public static final String SD_CI_LAB_JY = "4";// 检验
	public static final String SD_CI_LAB_BG = "5";// 报告
	public static final String SD_CI_LAB_YQX = "6";// 已取消

	/**
	 * 检查申请状态
	 */
	public static final String ID_CI_OBS_SQ = "@@@@AA1000000006JVIO";// 申请
	public static final String ID_CI_OBS_YAP = "@@@@AA1000000006JVIP";// 已安排
	public static final String ID_CI_OBS_YDJ = "@@@@AA1000000006JVIQ";// 已到检
	public static final String ID_CI_OBS_YJC = "@@@@AA1000000006JVIR";// 已检查
	public static final String ID_CI_OBS_BG = "@@@@AA1000000006JVIS";// 报告
	public static final String ID_CI_OBS_YQX = "@@@@AA1000000006JVIT";// 已取消

	public static final String SD_CI_OBS_SQ = "0";// 申请
	public static final String SD_CI_OBS_YAP = "1";// 已安排
	public static final String SD_CI_OBS_YDJ = "2";// 已到检
	public static final String SD_CI_OBS_YJC = "3";// 已检查
	public static final String SD_CI_OBS_BG = "4";// 报告
	public static final String SD_CI_OBS_YQX = "5";// 已取消

	//检查目的

	public static final String Id_CI_OBS_OBJECTIVE ="@@@@AA100000000312PC";//协助诊断
	public static final String NAME_OBS_OBJECTIVE  ="协助诊断";  //todo
	public static final String Sd_CI_OBS_OBJECTIVE ="0";//协助诊断

	/**
	 * 服务套角色
	 */
	public static final String SD_SRVSETITEM_ROLE_ADD = "1";
	public static final String SD_SRVSETITEM_ROLE_MAIN = "0";

	/**
	 * 检查报告状态
	 */
	// 已新建
	public static final String SD_SU_OBSRPT_NEW = "0";
	// 已提交
	public static final String SD_SU_OBSRPT_SUBMIT = "1";
	// 已审核
	public static final String SD_SU_OBSRPT_PASS = "2";
	// 已驳回
	public static final String SD_SU_OBSRPT_REFUSE = "3";
	// 已作废
	public static final String SD_SU_OBSRPT_ABOLISH = "4";
	// 已取消审核
	public static final String SD_SU_OBSRPT_CANCEL = "5";
	// 初步发布
	public static final String SD_SU_OBSRPT_INITDEPLOY = "6";
	// 最终发布
	public static final String SD_SU_OBSRPT_FINALDEPLOY = "7";

	public static final String ID_SU_OBSRPT_FINALDEPLOY = "@@@@AA1000000006TT21";
	// 已召回
	public static final String SD_SU_OBSRPT_RETURN = "8";

	/**
	 * 备血检验结果状态
	 */
	// 开立
	public static final String SD_SU_BTTEST_NEW = "0";
	// 提交
	public static final String SD_SU_BTTEST_SUBMIT = "1";

	// 诊断体系
	public static final String CI_DISYS = "@@@@ZZ2000000000000R";// 诊断体系

	public static final String ID_CI_DISYS_JBZDTX = "@@@@AA10000000076SMD";// 疾病诊断体系
	public static final String ID_CI_DISYS_MYZDTX = "@@@@AA10000000076SMN";// 蒙医诊断体系
	public static final String ID_CI_DISYS_SSZDTX = "@@@@AA10000000076SMO";// 手术诊断体系
	public static final String ID_CI_DISYS_XYZDTX = "@@@@AA10000000076SML";// 西医诊断体系
	public static final String ID_CI_DISYS_YLFWXMTX = "@@@@AA10000000076SMC";// 医疗服务项目体系
	public static final String ID_CI_DISYS_ZYZDTX = "@@@@AA10000000076SMM";// 中医诊断体系

	public static final String SD_CI_DISYS_YLFWXMTX = "0X";// 医疗服务项目体系
	public static final String SD_CI_DISYS_JBZDTX = "1X";// 疾病诊断体系
	public static final String SD_CI_DISYS_ZYZDTX = "12";// 中医诊断体系
	public static final String SD_CI_DISYS_MYZDTX = "13";// 蒙医诊断体系
	public static final String SD_CI_DISYS_XYZDTX = "11";// 西医诊断体系
	public static final String SD_CI_DISYS_SSZDTX = "14";// 手术诊断体系

	/**
	 * 皮试结果编码 可用常量
	 */
	public static final String SD_RST_SKINTEST_L1_MINUS = "0";// 阴
	public static final String SD_RST_SKINTEST_L1_PLUS = "1";// 阳
	public static final String SD_RST_SKINTEST_L2_1MINUS = "00";// 阴性
	public static final String SD_RST_SKINTEST_L2_1PLUS = "10";// 阳性
	/**
	 * 皮试结果ID 可用常量
	 */
	public static final String SD_RST_SKINTEST_L1_MINUS_ID = "@@@@AA100000000312PE";// 阴
	public static final String SD_RST_SKINTEST_L1_PLUS_ID = "@@@@AA100000000312PD";// 阳
	public static final String SD_RST_SKINTEST_L2_1MINUS_ID = "@@@@AA100000000312PF";// 阴性
	public static final String SD_RST_SKINTEST_L2_1PLUS_ID = "@@@@AA100000000312PG";// 阳性

	/**
	 * 备血完成闭环状态
	 */
	public static final String SD_ORPLTPSTA = "37";

	/**
	 * 取整模式
	 */
	public static final String SD_MUPKGUTP_QUAN = "2";

	/**
	 * 会诊申请状态变化类型
	 */
	public static final String CONS_RESPONSE = "0";// 应答
	public static final String CONS_DEPREVIEW = "1";// 科室审批
	public static final String CONS_MADREVIEW = "2";// 医务部审批

	/**
	 * 转科状态
	 */
	public static final String ID_CI_TRANS_KL= "@@@@AA1CVNKJDKHHKDDE";//开立
	public static final String ID_CI_TRANS_YSQZC= "@@@@AAQWEDSAZXCFRVRV";//已申请转出
	public static final String ID_CI_TRANS_YJSWC= "@@@@AAXGJNXKAHSPOHKH";//已接收完成 
	public static final String ID_CI_TRANS_YQX= "@@@@AAMOIJOHJVBMCKAH";//已取消

	public static final String SD_CI_TRANS_KL= "1";//开立
	public static final String SD_CI_TRANS_YSQZC= "2";//已申请转出
	public static final String SD_CI_TRANS_YJSWC= "3";//已接收完成 
	public static final String SD_CI_TRANS_YQX= "4";//已取消


	/**
	 * 备血检验结果状态ID shaoyuan 20160804
	 */
	public static final String ID_BTTEST_KL = "@@@@AA1000000006U3KH";
	public static final String ID_BTTEST_TJ = "@@@@AA1000000006U3KI";
	/**
	 * 备血检验结果状态SD shaoyuan 20160804
	 */
	public static final String SD_BTTEST_KL = "0";
	public static final String SD_BTTEST_TJ = "1";

	/**
	 * 病理结果状态ID 20160808
	 */
	public static final String ID_SU_PATHGY_YSQ = "@@@@AA1000000006SFXD"; //已申请
	public static final String ID_SU_PATHGY_YAP = "@@@@AA1000000006SFXE";//已安排
	public static final String ID_SU_PATHGY_YDJ = "@@@@AA1000000006SFXF";//已到检
	public static final String ID_SU_PATHGY_YJC = "@@@@AA1000000006SFXG";//已检查
	public static final String ID_SU_PATHGY_BG = "@@@@AA1000000006SFXH";//报告
	public static final String ID_SU_PATHGY_YQX = "@@@@AA1000000006SFXI";//已取消
	/**
	 * 备血检验结果状态SD shaoyuan 20160808
	 */
	public static final String SD_SU_PATHGY_YSQ = "0"; //已申请
	public static final String SD_SU_PATHGY_YAP = "1";//已安排
	public static final String SD_SU_PATHGY_YDJ = "2";//已到检
	public static final String SD_SU_PATHGY_YJC = "3";//已检查
	public static final String SD_SU_PATHGY_BG = "4";//报告
	public static final String SD_SU_PATHGY_YQX = "5";//已取消
	/**
	 * 临床医生站打印单据类型 编码
	 */		
	public static final String SD_CIPRNSHEETTP_OR="01";   //01 医嘱相关打印
	public static final String SD_CIPRNSHEETTP_PRES="0101";   //0101 处方
	public static final String SD_CIPRNSHEETTP_POISPRES="010101";   //010101 毒麻处方
	public static final String SD_CIPRNSHEETTP_WESTPRES="010102";   //010102 西药处方
	public static final String SD_CIPRNSHEETTP_HERBPRES="010103";   //010103 草药处方
	public static final String SD_CIPRNSHEETTP_APP="0102";   //0102 申请单
	public static final String SD_CIPRNSHEETTP_RISAPP="010201";   //检查申请单
	public static final String SD_CIPRNSHEETTP_LISAPP="010202";   //检验 申请单
	public static final String SD_CIPRNSHEETTP_TREATAPP="010203";   //诊疗 申请单
	public static final String SD_CIPRNSHEETTP_BTAPP="010204";   //输血 申请单
	public static final String SD_CIPRNSHEETTP_BTUSEAPP="010205";   //取血 申请单
	public static final String SD_CIPRNSHEETTP_OPAPP="010206";   //手术 申请单
	public static final String SD_CIPRNSHEETTP_AUXI="0103";   //0103 辅助执行
	public static final String SD_CIPRNSHEETTP_INJECAPP="010301";   //010301 注射治疗单
	public static final String SD_CIPRNSHEETTP_COSTBILL="010302";   //010302 门诊费用清单
	public static final String SD_CIPRNSHEETTP_WORKMR="02";   //02 临床医生工作文书
	public static final String SD_CIPRNSHEETTP_MR="0201";   //0201 病历

	/**
	 * 临床医生站打印单据类型 ID
	 */		
	public static final String ID_CIPRNSHEETTP_OR="@@@@AA1000000001U6Q5";   //01 医嘱相关打印
	public static final String ID_CIPRNSHEETTP_PRES="@@@@AA1000000001U6Q7";   //0101 处方
	public static final String ID_CIPRNSHEETTP_POISPRES="@@@@AA1000000001U6QB";   //010101 毒麻处方
	public static final String ID_CIPRNSHEETTP_WESTPRES="@@@@AA1000000001U6QC";   //010102 西药处方
	public static final String ID_CIPRNSHEETTP_HERBPRES="@@@@AA1000000001U6QD";   //010103 草药处方
	public static final String ID_CIPRNSHEETTP_APP="@@@@AA1000000001U6Q8";   //0102 申请单
	public static final String ID_CIPRNSHEETTP_RISAPP="@@@@Z7100000000CGQDI";   //检查申请单
	public static final String ID_CIPRNSHEETTP_LISAPP="@@@@Z7100000000CGQDJ";   //检验 申请单
	public static final String ID_CIPRNSHEETTP_TREATAPP="@@@@Z71000000001VSL8";   //诊疗 申请单
	public static final String ID_CIPRNSHEETTP_BTAPP="@@@@Z71000000001VSL9";   //输血 申请单
	public static final String ID_CIPRNSHEETTP_BTUSEAPP="@@@@Z71000000001VSLA";   //取血 申请单
	public static final String ID_CIPRNSHEETTP_OPAPP="@@@@Z71000000001VSLB";   //手术 申请单
	public static final String ID_CIPRNSHEETTP_AUXI="@@@@AA1000000001U6Q9";   //0103 辅助执行
	public static final String ID_CIPRNSHEETTP_INJECAPP="@@@@Z7100000000GD1FD";   //010301 注射治疗单
	public static final String ID_CIPRNSHEETTP_COSTBILL="@@@@Z7100000000N7UG9";   //010302 门诊费用清单
	public static final String ID_CIPRNSHEETTP_WORKMR="@@@@AA1000000001U6Q6";   //02 临床医生工作文书
	public static final String ID_CIPRNSHEETTP_MR="@@@@AA1000000001U6QA";   //0201 病历

	// 皮试医嘱保存处理模式
	public static String CODE_SKIN_SKIN = "0";// 皮试
	public static String CODE_SKIN_FORCEUSE = "1";// 强制使用
	public static String CODE_SKIN_NORESULT = "2";// 皮试了，没有结果
	//自定义诊断编码
	public static final String ID_CISELFDI="@@@@AA100000000CI9VP";
	public static final String SD_CISELFDI="0000";   //

	// 手术状态
	public static final String ID_CI_OPER_YSQ= "@@@@AA1000000004IXS1";//已申请
	public static final String ID_CI_OPER_YYY= "@@@@AA1000000004IXS2";//已预约
	public static final String ID_CI_OPER_YQXPB= "@@@@AA1000000004IXS3";//已取消排班
	public static final String ID_CI_OPER_RSSS= "@@@@AA1000000004IXS4";//入手术室
	public static final String ID_CI_OPER_YZX= "@@@@AA1000000004IXS5";//已执行
	public static final String ID_CI_OPER_CSSS= "@@@@AA1000000004IXS6";//出手术室
	public static final String ID_CI_OPER_YQXSS= "@@@@AA1000000004IXS7";//已取消手术

	public static final String SD_CI_OPER_YSQ= "00";//已申请
	public static final String SD_CI_OPER_YYY= "10";//已预约
	public static final String SD_CI_OPER_YQXPB= "20";//已取消排班
	public static final String SD_CI_OPER_RSSS= "30";//入手术室
	public static final String SD_CI_OPER_YZX= "40";//已执行
	public static final String SD_CI_OPER_CSSS= "50";//出手术室
	public static final String SD_CI_OPER_YQXSS= "60";//已取消手术

	//输血目的 
	public static final String ID_CI_BT_STX= "@@@@AA100000000496OO";//肾透析
	public static final String ID_CI_BT_GSYZ= "@@@@AA100000000496OP";//骨髓移植
	public static final String ID_CI_BT_CIKZL= "@@@@AA100000000496OQ";//CIK治疗
	public static final String ID_CI_BT_RXXPX= "@@@@AA100000000496OR";//溶血性贫血
	public static final String ID_CI_BT_QGYZ= "@@@@AA100000000496OS";//器官移植
	public static final String ID_CI_BT_NXGNZA= "@@@@AA100000000496OT";//凝血功能障碍
	public static final String ID_CI_BT_SS= "@@@@AA100000000496OU";//烧伤
	public static final String ID_CI_BT_XXBGNYCZCX= "@@@@AA100000000496OV";//血小板功能异常致出血
	public static final String ID_CI_BT_JZXXBSYWX= "@@@@AA100000000496OX";//纠正血小板输液无效
	public static final String ID_CI_BT_XWDBYQF= "@@@@AA100000000496OZ";//纤维蛋白原缺乏
	public static final String ID_CI_BT_ZTSX= "@@@@AA1000000004IXRM";//自体输血
	public static final String ID_CI_BT_XYSX= "@@@@AA1000000004IXRN";//稀有输血
	public static final String ID_CI_BT_DCLBXB= "@@@@AA1000000004IXRO";//单采淋巴细胞
	public static final String ID_CI_BT_DCHXB= "@@@@AA1000000004IXRP";//单采红细胞
	public static final String ID_CI_BT_WZXZXGXBZY= "@@@@AA1000000004IXRR";//外周血造血干细胞转移
	public static final String ID_CI_BT_QT= "@@@@AA1000000004IXRS";//其他
	public static final String ID_CI_BT_JZJXSX= "@@@@AA1000000004IXRT";//纠正急性失血
	public static final String ID_CI_BT_TGXRL= "@@@@AA100000000496OB";//提高血容量
	public static final String ID_CI_BT_BCXXB= "@@@@AA100000000496OC";//补充血小板
	public static final String ID_CI_BT_XYZXPX= "@@@@AA100000000496OD";//血液中心配型
	public static final String ID_CI_BT_XYB= "@@@@AA100000000496OE";//血友病
	public static final String ID_CI_BT_XJZH= "@@@@AA100000000496OF";//血浆置换
	public static final String ID_CI_BT_XYB1= "@@@@AA100000000496OG";//血液病
	public static final String ID_CI_BT_DIC= "@@@@AA100000000496OH";//DIC
	public static final String ID_CI_BT_XHDCX= "@@@@AA100000000496OI";//消化道出血
	public static final String ID_CI_BT_SH= "@@@@AA100000000496OJ";//术后
	public static final String ID_CI_BT_CS= "@@@@AA100000000496OK";//创伤
	public static final String ID_CI_BT_BCBDB= "@@@@AA100000000496OM";//补充白蛋白
	public static final String ID_CI_BT_CX= "@@@@AA100000000496ON";//出血
	public static final String ID_CI_BT_SSBX= "@@@@AA100000000496O8";//手术备血
	public static final String ID_CI_BT_JZPX= "@@@@AA100000000496O9";//纠正贫血
	public static final String ID_CI_BT_BCNXYZ= "@@@@AA100000000496OA";//补充凝血因子
	public static final String ID_CI_BT_DDBXZ= "@@@@AA1000000004IXRL";//低蛋白血症
	public static final String ID_CI_BT_DCXXB= "@@@@AA1000000004IXRQ";//单采血小板
	public static final String ID_CI_BT_XXBJS= "@@@@AA100000000496OL";//血小板减少
	//输血目的 
	public static final String SD_CI_BT_STX= "16";//肾透析
	public static final String SD_CI_BT_GSYZ= "17";//骨髓移植
	public static final String SD_CI_BT_CIKZL= "18";//CIK治疗
	public static final String SD_CI_BT_RXXPX= "19";//溶血性贫血
	public static final String SD_CI_BT_QGYZ= "20";//器官移植
	public static final String SD_CI_BT_NXGNZA= "21";//凝血功能障碍
	public static final String SD_CI_BT_SS= "22";//烧伤
	public static final String SD_CI_BT_XXBGNYCZCX= "23";//血小板功能异常致出血
	public static final String SD_CI_BT_JZXXBSYWX= "24";//纠正血小板输液无效
	public static final String SD_CI_BT_XWDBYQF= "25";//纤维蛋白原缺乏
	public static final String SD_CI_BT_ZTSX= "27";//自体输血
	public static final String SD_CI_BT_XYSX= "28";//稀有输血
	public static final String SD_CI_BT_DCLBXB= "29";//单采淋巴细胞
	public static final String SD_CI_BT_DCHXB= "30";//单采红细胞
	public static final String SD_CI_BT_WZXZXGXBZY= "32";//外周血造血干细胞转移
	public static final String SD_CI_BT_QT= "33";//其他
	public static final String SD_CI_BT_JZJXSX= "34";//纠正急性失血
	public static final String SD_CI_BT_TGXRL= "3";//提高血容量
	public static final String SD_CI_BT_BCXXB= "4";//补充血小板
	public static final String SD_CI_BT_XYZXPX= "5";//血液中心配型
	public static final String SD_CI_BT_XYB= "6";//血友病
	public static final String SD_CI_BT_XJZH= "7";//血浆置换
	public static final String SD_CI_BT_XYB1= "8";//血液病
	public static final String SD_CI_BT_DIC= "9";//DIC
	public static final String SD_CI_BT_XHDCX= "10";//消化道出血
	public static final String SD_CI_BT_SH= "11";//术后
	public static final String SD_CI_BT_CS= "12";//创伤
	public static final String SD_CI_BT_BCBDB= "14";//补充白蛋白
	public static final String SD_CI_BT_CX= "15";//出血
	public static final String SD_CI_BT_SSBX= "0";//手术备血
	public static final String SD_CI_BT_JZPX= "1";//纠正贫血
	public static final String SD_CI_BT_BCNXYZ= "2";//补充凝血因子
	public static final String SD_CI_BT_DDBXZ= "26";//低蛋白血症
	public static final String SD_CI_BT_DCXXB= "31";//单采血小板
	public static final String SD_CI_BT_XXBJS= "13";//血小板减少

	//输血需求状态
	public static final String ID_CI_BT_JJ= "@@@@AA100000000496NV";//紧急
	public static final String ID_CI_BT_BYDTZ= "@@@@AA100000000496NX";//备用待通知
	public static final String ID_CI_BT_SZBY= "@@@@AA100000000496NY";//术中备用
	public static final String ID_CI_BT_CG= "@@@@AA100000000496NW";//常规

	public static final String SD_CI_BT_JJ= "0";//紧急
	public static final String SD_CI_BT_BYDTZ= "2";//备用待通知
	public static final String SD_CI_BT_SZBY= "3";//术中备用
	public static final String SD_CI_BT_CG= "1";//常规
	//输血前检测项目说明
	public static final String ID_CI_BT_1YJJSXYSJCXMDJCBGFCHJSDXKBT= "@@@@AA100000000496O3";//1、因紧急输血，以上检测项目，待检测，报告发出后及时到血库补填。
	public static final String ID_CI_BT_2SXZSXQJCXMYHZHDLRJJJCGWSJ= "@@@@AA100000000496O4";//2、受血者输血前检测项目，因患者（或代理人）拒绝检测，故无数据。

	public static final String SD_CI_BT_1YJJSXYSJCXMDJCBGFCHJSDXKBT= "0";//1、因紧急输血，以上检测项目，待检测，报告发出后及时到血库补填。
	public static final String SD_CI_BT_2SXZSXQJCXMYHZHDLRJJJCGWSJ= "1";//2、受血者输血前检测项目，因患者（或代理人）拒绝检测，故无数据。
	//输血史标识
	public static final String ID_CI_BT_WSXS= "@@@@AA100000000496O5";//无输血史
	public static final String ID_CI_BT_YSXS= "@@@@AA100000000496O6";//有输血史
	public static final String ID_CI_BT_YBLSXS= "@@@@AA100000000496O7";//有不良输血史

	public static final String SD_CI_BT_WSXS= "0";//无输血史
	public static final String SD_CI_BT_YSXS= "1";//有输血史
	public static final String SD_CI_BT_YBLSXS= "2";//有不良输血史
	//备血申请状态
	public static final String ID_CI_BT_YSQ= "@@@@AA1000000006S48N";//已申请
	public static final String ID_CI_BT_BBYQS= "@@@@AA1000000006S48O";//标本已签收
	public static final String ID_CI_BT_YBX= "@@@@AA1000000006S48P";//已备血
	public static final String ID_CI_BT_XYFFWB= "@@@@AA1000000006S48Q";//血液发放完毕

	public static final String SD_CI_BT_YSQ= "0";//已申请
	public static final String SD_CI_BT_BBYQS= "1";//标本已签收
	public static final String SD_CI_BT_YBX= "2";//已备血
	public static final String SD_CI_BT_XYFFWB= "3";//血液发放完毕

	//EmsOrDrug的关联字段的key值
	public static final String EMSORDRUG_RELATIVE_FIELD_ID_MEASDOC = "Id_measdoc";
	public static final String EMSORDRUG_RELATIVE_FIELD_MEASDOC_NAME = "Measdoc_name";

	//public static final String SD_CI_UIDOC_ORTMPLTP_ID = "@@@@ZZ200000000000A7";
	//public static final String SD_CI_UIDOC_SRVTP_ID = "@@@@ZZ2000000000000T";

	//检验报告状态 id
	public static final String ID_CI_RPT_LAB_CBBG= "@@@@AA1000000006TST8";//初步报告
	public static final String ID_CI_RPT_LAB_QRBG= "@@@@AA1000000006TST9";//确认报告
	public static final String ID_CI_RPT_LAB_FBBG= "@@@@AA1000000006TSTA";//发布报告
	public static final String ID_CI_RPT_LAB_ZH= "@@@@AA10000000000G7D";//召回
	public static final String ID_CI_RPT_LAB_TJ= "@@@@Z7100000000G9R8S";//退检
	//检验报告状态 sd
	public static final String SD_CI_RPT_LAB_CBBG= "0";//初步报告
	public static final String SD_CI_RPT_LAB_QRBG= "1";//确认报告
	public static final String SD_CI_RPT_LAB_FBBG= "2";//发布报告
	public static final String SD_CI_RPT_LAB_ZH= "3";//召回
	public static final String SD_CI_RPT_LAB_TJ= "4";//退检
	/**
	 * 医嘱审核及结果状态显示管理ID
	 */
	public static final String SD_ORAUDITRSTSHOWADM_AUDIT_ID= "@@@@W11000000003VM01";//审核类
	public static final String SD_ORAUDITRSTSHOWADM_AUDIT_CP_ID= "@@@@W11000000003VM02";//临床路径审核
	public static final String SD_ORAUDITRSTSHOWADM_AUDIT_HP_ID= "@@@@W11000000003VM03";//医保审核
	public static final String SD_ORAUDITRSTSHOWADM_AUDIT_PHARM_ID= "@@@@W11000000003VM04";//药品审核
	public static final String SD_ORAUDITRSTSHOWADM_RST_ID= "@@@@W11000000003VM0A";//结果类
	public static final String SD_ORAUDITRSTSHOWADM_RST_MT_ID= "@@@@W11000000003VM0B";//检查结果
	public static final String SD_ORAUDITRSTSHOWADM_RST_SKINTEST_ID= "@@@@W11000000003VM0C";//皮试结果
	/**
	 * 医嘱审核及结果状态显示管理编码
	 */
	public static final String SD_ORAUDITRSTSHOWADM_AUDIT= "01";//审核类
	public static final String SD_ORAUDITRSTSHOWADM_AUDIT_CP= "0101";//临床路径审核
	public static final String SD_ORAUDITRSTSHOWADM_AUDIT_HP= "0102";//医保审核
	public static final String SD_ORAUDITRSTSHOWADM_AUDIT_PHARM= "0103";//药品审核
	public static final String SD_ORAUDITRSTSHOWADM_RST= "02";//结果类
	public static final String SD_ORAUDITRSTSHOWADM_RST_MT= "0201";//检查结果
	public static final String SD_ORAUDITRSTSHOWADM_RST_SKINTEST= "0202";//皮试结果

	/**
	 * 病理状态报告编码
	 */
	// 已新建
	public static final String SD_SU_PATHGYRPT_NEW = "0";
	// 已提交
	public static final String SD_SU_PATHGYRPT_SUBMIT = "1";
	// 已审核
	public static final String SD_SU_PATHGYRPT_PASS = "2";
	// 已驳回
	public static final String SD_SU_PATHGYRPT_REFUSE = "3";
	// 已作废
	public static final String SD_SU_PATHGYRPT_ABOLISH = "4";
	// 已取消审核
	public static final String SD_SU_PATHGYRPT_CANCEL = "5";
	// 初步发布
	public static final String SD_SU_PATHGYRPT_INITDEPLOY = "6";
	// 最终发布
	public static final String SD_SU_PATHGYRPT_FINALDEPLOY = "7";
	// 已召回
	public static final String SD_SU_PATHGYRPT_RETURN = "8";

	/**
	 * 临床打印清单类型编码 
	 * 0795
	 */
	public static final String SD_CIPRNTP_FEETYPE= "01";//费用类型
	public static final String SD_CIPRNTP_FEETYPE_OPFEELIST= "0101";//门诊费用清单
	/**
	 * 临床打印清单类型ID
	 * 0795
	 */
	public static final String ID_CIPRNTP_FEETYPE= "@@@@Z7100000000MHZQ1";//费用类型
	public static final String ID_CIPRNTP_FEETYPE_OPFEELIST= "@@@@Z7100000000MHZQ3";//门诊费用清单
	/**
	 * 多用户操作下医嘱状态校验类型
	 */
	public static final String ORD_VALIDATE_TYPE_OPEN="OPEN";
	public static final String ORD_VALIDATE_TYPE_SIGN="SING";
	public static final String ORD_VALIDATE_TYPE_BACK="BACK";
	public static final String ORD_VALIDATE_TYPE_CANCEL="CANCEL";
	public static final String ORD_VALIDATE_TYPE_STOP="STOP";
	public static final String ORD_VALIDATE_TYPE_REVERTSTOP="REVERTSTOP";
	public static final String ORD_VALIDATE_TYPE_REVERTCANCEL="REVERTCANCEL";



	//处方类型id
	public static final String ID_UDIDOC_PKU_PRESCRIPTION_MZYLYDXY= "@@@@Z7100000000VNHQW";//门诊医疗用毒性药品处方笺
	public static final String ID_UDIDOC_PKU_PRESCRIPTION_MZELJSYP= "@@@@Z7100000000VNHQE";//门诊二类精神药品处方笺
	public static final String ID_UDIDOC_PKU_PRESCRIPTION_MJZMZJYY= "@@@@Z7100000000VNHQB";//门（急）诊麻醉、精一药品处方笺
	public static final String ID_UDIDOC_PKU_PRESCRIPTION_GSBXCFJ= "@@@@Z7100000000VNHPU";//工伤保险处方笺
	public static final String ID_UDIDOC_PKU_PRESCRIPTION_YLBXCFJ= "@@@@Z7100000000VNHKZ";//医疗保险处方笺
	public static final String ID_UDIDOC_PKU_PRESCRIPTION_GFYLCFJ= "@@@@Z7100000000VNHJ4";//公费医疗处方笺
	public static final String ID_UDIDOC_PKU_PRESCRIPTION_JZCFJ= "@@@@Z7100000000VNHI6";//急诊处方笺
	public static final String ID_UDIDOC_PKU_PRESCRIPTION_MZCFJ= "@@@@Z7100000000VNHI2";//门诊处方笺
	//处方类型sd
	public static final String SD_UDIDOC_PRESCRIPTION_MZYLYDXY= "0008";//门诊医疗用毒性药品处方笺
	public static final String SD_UDIDOC_PRESCRIPTION_MZELJSYP= "0007";//门诊二类精神药品处方笺
	public static final String SD_UDIDOC_PRESCRIPTION_MJZMZJYY= "0006";//门（急）诊麻醉、精一药品处方笺
	public static final String SD_UDIDOC_PRESCRIPTION_GSBXCFJ= "0005";//工伤保险处方笺
	public static final String SD_UDIDOC_PRESCRIPTION_YLBXCFJ= "0003";//医疗保险处方笺
	public static final String SD_UDIDOC_PRESCRIPTION_GFYLCFJ= "0004";//公费医疗处方笺
	public static final String SD_UDIDOC_PRESCRIPTION_JZCFJ= "0002";//急诊处方笺
	public static final String SD_UDIDOC_PRESCRIPTION_MZCFJ= "0001";//门诊处方笺
	//处方类型名称
	public static final String NAME_UDIDOC_PRESCRIPTION_MZYLYDXY= "门诊医疗用毒性药品处方笺";//门诊医疗用毒性药品处方笺
	public static final String NAME_UDIDOC_PRESCRIPTION_MZELJSYP= "门诊二类精神药品处方笺";//门诊二类精神药品处方笺
	public static final String NAME_UDIDOC_PRESCRIPTION_MJZMZJYY= "门（急）诊麻醉、精一药品处方笺";//门（急）诊麻醉、精一药品处方笺
	public static final String NAME_UDIDOC_PRESCRIPTION_GSBXCFJ= "工伤保险处方笺";//工伤保险处方笺
	public static final String NAME_UDIDOC_PRESCRIPTION_YLBXCFJ= "医疗保险处方笺";//医疗保险处方笺
	public static final String NAME_UDIDOC_PRESCRIPTION_GFYLCFJ= "公费医疗处方笺";//公费医疗处方笺
	public static final String NAME_UDIDOC_PRESCRIPTION_JZCFJ= "急诊处方笺";//急诊处方笺
	public static final String NAME_UDIDOC_PRESCRIPTION_MZCFJ= "门诊处方笺";//门诊处方笺
	//处方标识 id
	public static final String ID_PRESCRIPTION_FLAG_YB= "@@@@Z7100000000VZXUK";//医保
	public static final String ID_PRESCRIPTION_FLAG_JZ= "@@@@Z7100000000VQYXL";//急诊
	public static final String ID_PRESCRIPTION_FLAG_EK= "@@@@Z7100000000VQYXN";//儿科
	public static final String ID_PRESCRIPTION_FLAG_MZJY= "@@@@Z7100000000VQYXP";//麻醉精一
	public static final String ID_PRESCRIPTION_FLAG_VIP= "@@@@Z7100000000VQYYV";//VIP
	public static final String ID_PRESCRIPTION_FLAG_JE= "@@@@Z7100000000VQYXQ";//精二
	public static final String ID_PRESCRIPTION_FLAG_JSY= "@@@@Z7100000000VQYXU";//基数药
	public static final String ID_PRESCRIPTION_FLAG_WPY= "@@@@Z7100000000VQYY8";//外配药
	public static final String ID_PRESCRIPTION_FLAG_TSB= "@@@@Z7100000000VQYY9";//特殊病
	public static final String ID_PRESCRIPTION_FLAG_YFFBZ= "@@@@Z7100000000VQYZG";//预付费标志
	public static final String ID_PRESCRIPTION_FLAG_KY= "@@@@Z7100000000VQYZK";//科研
	public static final String ID_PRESCRIPTION_FLAG_SYBX= "@@@@Z7100000000VQYZQ";//生育保险
	public static final String ID_PRESCRIPTION_FLAG_DXBZ= "@@@@Z7100000000VZXTA";//毒性标志
	public static final String ID_PRESCRIPTION_FLAG_CY= "@@@@Z8100000000WFKH7";//草药
	public static final String ID_PRESCRIPTION_FLAG_HERBAL = "@@@@Z81000000009TY5Y";//草药片剂
	public static final String ID_PRESCRIPTION_FLAG_GRANULES = "@@@@Z81000000009TY5Z";//草药颗粒

	//处方标识sd
	public static final String SD_PRESCRIPTION_FLAG_YB= "01";//医保
	public static final String SD_PRESCRIPTION_FLAG_JZ= "02";//急诊
	public static final String SD_PRESCRIPTION_FLAG_EK= "03";//儿科
	public static final String SD_PRESCRIPTION_FLAG_MZJY= "04";//麻醉精一
	public static final String SD_PRESCRIPTION_FLAG_VIP= "09";//VIP
	public static final String SD_PRESCRIPTION_FLAG_JE= "05";//精二
	public static final String SD_PRESCRIPTION_FLAG_JSY= "06";//基数药
	public static final String SD_PRESCRIPTION_FLAG_WPY= "07";//外配药
	public static final String SD_PRESCRIPTION_FLAG_TSB= "08";//特殊病
	public static final String SD_PRESCRIPTION_FLAG_YFFBZ= "10";//预付费标志
	public static final String SD_PRESCRIPTION_FLAG_KY= "11";//科研
	public static final String SD_PRESCRIPTION_FLAG_SYBX= "12";//生育保险
	public static final String SD_PRESCRIPTION_FLAG_DXBZ= "13";//毒性标志
	public static final String SD_PRESCRIPTION_FLAG_CY= "14";//草药
	public static final String SD_PRESCRIPTION_FLAG_HERBAL = "15";//草药片剂
	public static final String SD_PRESCRIPTION_FLAG_GRANULES = "16";//草药颗粒

	//时间量纲
	public static final String DIMENSION_OF_TIME ="@@@@AA1000000000ELLQ";

	/// 计量单位
	public static final String ID_MEASDOC_TIME_DD = "@@@@Z7100000000E5Q2P";//天
	public static final String ID_MEASDOC_TIME_HH = "@@@@Z7100000000E5Q2O";//小时
	public static final String ID_MEASDOC_TIME_MM = "@@@@Z7100000000E5Q2N";//分
	public static final String ID_MEASDOC_TIME_SS = "@@@@Z7100000000E5Q2M";//秒
	public static final String ID_MEASDOC_TIME_μS = "@@@@Z7100000000E5Q2M";//微妙
	public static final String ID_MEASDOC_TIME_MS = "@@@@Z7100000000E5Q2M";//毫妙
	public static final String ID_MEASDOC_TIME_NS = "@@@@Z7100000000E5Q2M";//纳妙

	// 药品超量开单原因ID
	public static final String ID_EXCESSIVE_REASON_NORMAL = "@@@@Z8100000000Q4QIN";//无超量情况
	public static final String ID_EXCESSIVE_REASON_INCONVENIENCE = "@@@@Z8100000000Q4QIO";//行动不便
	public static final String ID_EXCESSIVE_REASON_CHRONIC = "@@@@Z8100000000Q4QIU";//慢性病
	public static final String ID_EXCESSIVE_REASON_SENILE = "@@@@Z8100000000Q4QIV";//老年病
	public static final String ID_EXCESSIVE_REASON_EXCEPTIONAL = "@@@@Z8100000000Q4QIW";//特殊情况

	// 药品超量开单原因SD
	/**
	 * 无超量情况
	 */
	public static final String SD_EXCESSIVE_REASON_NORMAL = "0";//无超量情况
	/**
	 * 行动不便
	 */
	public static final String SD_EXCESSIVE_REASON_INCONVENIENCE = "1";//行动不便
	/**
	 * 慢性病
	 */
	public static final String SD_EXCESSIVE_REASON_CHRONIC = "2";//慢性病
	/**
	 * 老年病
	 */
	public static final String SD_EXCESSIVE_REASON_SENILE = "3";//老年病
	/**
	 * 特殊情况
	 */
	public static final String SD_EXCESSIVE_REASON_EXCEPTIONAL = "4";//特殊情况

	// 物品绑定时机
	public static final String ID_MMBIND_OPEN = "@@@@AA1000000000ELU4";//物品绑定时机_开立绑定
	public static final String ID_MMBIND_EXECUTE = "@@@@AA1000000000ELU5";//物品绑定时机_执行绑定

	public static final String SD_MMBIND_OPEN = "0";//物品绑定时机_开立绑定
	public static final String SD_MMBIND_EXECUTE = "1";//物品绑定时机_执行绑定
	//CiOrSrvHp Key
	public static final String CI_OR_SRV_HP_KEY = "CI_OR_SRV_HP_KEY";
	public static final String CODE_LIS_VAL_STATE="CI.OR.9000";//结果状态

	// 转科状态
	public static final String ID_TRANSE_STATUS_OPEN = "@@@@AA1CVNKJDKHHKDDE"; // 开立
	public static final String SD_TRANSE_STATUS_OPEN = "1"; // 开立
	public static final String NAME_TRANSE_STATUS_OPEN = "开立"; // 开立
	public static final String ID_TRANSE_STATUS_OUT = "@@@@AAQWEDSAZXCFRVRV"; // 已申请转出
	public static final String SD_TRANSE_STATUS_OUT = "2"; // 已申请转出
	public static final String NAME_TRANSE_STATUS_OUT = "已申请转出"; // 已申请转出
	public static final String ID_TRANSE_STATUS_ACCEPT = "@@@@AAXGJNXKAHSPOHKH"; // 已接收完成
	public static final String SD_TRANSE_STATUS_ACCEPT = "3"; // 已接收完成
	public static final String NAME_TRANSE_STATUS_ACCEPT = "已接收完成 "; // 已接收完成
	public static final String ID_TRANSE_STATUS_CANCEL = "@@@@AAMOIJOHJVBMCKAH"; // 已取消
	public static final String SD_TRANSE_STATUS_CANCEL = "4"; // 已取消
	public static final String NAME_TRANSE_STATUS_CANCEL = "已取消 "; // 已取消
	public static final String ID_PATHOLOGY_STATUS_APPLY = "@@@@AA1000000006SFXD"; // 已申请


	//手术角色类型
	public static final String ID_OP_ROLE_ZDYS = "@@@@AA1000000004IXRX"; //主刀医师
	public static final String ID_OP_ROLE_DYZS = "@@@@AA1000000004IXRY"; //第一助手
	public static final String ID_OP_ROLE_DEZS = "@@@@AA1000000004IXRZ"; //第二助手
	public static final String ID_OP_ROLE_MZYS = "@@@@AA1000000004IXS0"; //麻醉医师
	public static final String ID_OP_ROLE_DRMZYS = "@@@@Z8100000000HD18U"; //第二麻醉医师
	public static final String ID_OP_ROLE_QXHS = "@@@@Z8100000000HD19E"; //器械护士(洗手)
	public static final String ID_OP_ROLE_QXHSE = "@@@@Z8100000000HD19O"; //器械护士二
	public static final String ID_OP_ROLE_XHHS = "@@@@Z8100000000HD19T"; //巡回护士
	public static final String ID_OP_ROLE_XHHSE = "@@@@Z8100000000HD19Y"; //巡回护士二
	public static final String ID_OP_ROLE_DSZS = "@@@@LL100000000497F5";//第三助手
	public static final String ID_OP_ROLE_JS = "@@@@LL100000000497FF";//接送
	public static final String ID_OP_ROLE_CG = "@@@@LL100000000497FJ";//参观

	public static final String SD_OP_ROLE_ZDYS = "00"; //主刀医师
	public static final String SD_OP_ROLE_DYZS = "01"; //第一助手
	public static final String SD_OP_ROLE_DEZS = "02"; //第二助手
	public static final String SD_OP_ROLE_MZYS = "03"; //麻醉医师
	public static final String SD_OP_ROLE_DRMZYS = "04"; //第二麻醉医师
	public static final String SD_OP_ROLE_QXHS = "05"; //器械护士(洗手)
	public static final String SD_OP_ROLE_QXHSE = "06"; //器械护士二
	public static final String SD_OP_ROLE_XHHS = "07"; //巡回护士
	public static final String SD_OP_ROLE_XHHSE = "08"; //巡回护士二
	public static final String SD_OP_ROLE_DSZS = "09"; //第三助手
	public static final String SD_OP_ROLE_JS = "10"; //接送
	public static final String SD_OP_ROLE_CG = "11"; //参观

	//手术申请状态
	public static final String ID_SU_OP_YSQ = "@@@@AA1000000004IXS1"; //已申请
	public static final String ID_SU_OP_YYY = "@@@@AA1000000004IXS2"; //已预约
	public static final String ID_SU_OP_YSH = "@@@@AA1000000004IXS3"; //已审核
	public static final String ID_SU_OP_RSSS = "@@@@AA1000000004IXS4"; //入手术室
	public static final String ID_SU_OP_YMZ = "@@@@AA1000000004IXS5"; //已麻醉
	public static final String ID_SU_OP_YKS = "@@@@AA1000000004IXS6"; //已开始
	public static final String ID_SU_OP_YJS = "@@@@AA1000000004IXS7"; //已结束
	public static final String ID_SU_OP_CSHS = "@@@@Z8100000000HDN7H"; //出手术室

	public static final String SD_SU_OP_YSQ = "00"; //已申请
	public static final String SD_SU_OP_YYY = "10"; //已预约
	public static final String SD_SU_OP_YSH = "20"; //已审核
	public static final String SD_SU_OP_RSSS = "30"; //入手术室
	public static final String SD_SU_OP_YMZ = "40"; //已麻醉
	public static final String SD_SU_OP_YKS = "50"; //已开始
	public static final String SD_SU_OP_YJS = "60"; //已结束
	public static final String SD_SU_OP_CSHS = "70"; //出手术室

	// 手术角色类型
	public static final String ID_OP_ROLE_SURG = "@@@@AA1000000004IXRX";// 主刀医师
	public static final String SD_OP_ROLE_SURG = "00";// 主刀医师
	public static final String NAME_OP_ROLE_SURG = "主刀医师";// 主刀医师

	public static final String ID_OP_ROLE_FIRST = "@@@@AA1000000004IXRY";// 第一助手
	public static final String SD_OP_ROLE_FIRST = "01";// 第一助手
	public static final String NAME_OP_ROLE_FIRST = "第一助手";// 第一助手

	public static final String ID_OP_ROLE_SECOND = "@@@@AA1000000004IXRZ";// 第二助手
	public static final String SD_OP_ROLE_SECOND = "02";// 第二助手
	public static final String NAME_OP_ROLE_SECOND = "第二助手";// 第二助手

	public static final String ID_OP_ROLE_ANES = "@@@@AA1000000004IXS0";// 麻醉医生
	public static final String SD_OP_ROLE_ANES = "03";// 麻醉医生
	public static final String NAME_OP_ROLE_ANES = "麻醉医生";// 麻醉医生

	// 离院方式
	public static final String ID_OUTTP_1 = "@@@@AA10000000063ST5";// 医嘱离院
	public static final String SD_OUTTP_1 = "1";// 医嘱离院
	public static final String NAME_OUTTP_1 = "医嘱离院";// 医嘱离院   

	public static final String ID_OUTTP_2 = "@@@@AA10000000063ST6";// 医嘱转院
	public static final String SD_OUTTP_2 = "2";// 医嘱转院
	public static final String NAME_OUTTP_2 = "医嘱转院";// 医嘱转院

	public static final String ID_OUTTP_3 = "@@@@AA10000000063ST7";// 医嘱转社区
	public static final String SD_OUTTP_3 = "3";// 医嘱转社区
	public static final String NAME_OUTTP_3 = "医嘱转社区";// 医嘱转社区

	public static final String ID_OUTTP_4 = "@@@@AA10000000063ST8";// 非医嘱离院
	public static final String SD_OUTTP_4 = "4";// 非医嘱离院
	public static final String NAME_OUTTP_4 = "非医嘱离院";// 非医嘱离院

	public static final String ID_OUTTP_5 = "@@@@AA10000000063ST9";// 死亡
	public static final String SD_OUTTP_5 = "5";// 死亡
	public static final String NAME_OUTTP_5 = "死亡";// 死亡

	public static final String ID_OUTTP_9 = "@@@@AA10000000063STA";// 其他
	public static final String SD_OUTTP_9 = "9";// 其他
	public static final String NAME_OUTTP_9 = "其他";// 其他
	// 手术期限
	public static final String ID_OPDATE_LIMITTP_ER = "@@@@AA1000000004IXRI";// 急症
	public static final String SD_OPDATE_LIMITTP_ER = "0";// 急症
	public static final String NAME_OPDATE_LIMITTP_ER = "急症";// 急症

	public static final String ID_OPDATE_LIMITTP_XQ = "@@@@AA1000000004IXRJ";// 限期
	public static final String SD_OPDATE_LIMITTP_XQ = "1";// 限期
	public static final String NAME_OPDATE_LIMITTP_XQ = "限期";// 限期

	public static final String ID_OPDATE_LIMITTP_ZQ = "@@@@AA1000000004IXRK";// 择期
	public static final String SD_OPDATE_LIMITTP_ZQ = "2";// 择期
	public static final String NAME_OPDATE_LIMITTP_ZQ = "急症";// 急症

	/**
	 * CI.OR.0835-特殊使用级抗菌药会诊状态
	 */
	public static final String ID_SPECANTICONS_STATUS_APP = "@@@@Z8100000000A8Y3Q";// 申请
	public static final String SD_SPECANTICONS_STATUS_APP = "00";// 申请
	public static final String NAME_SPECANTICONS_STATUS_APP = "申请";// 申请

	public static final String ID_SPECANTICONS_STATUS_CMT = "@@@@Z8100000000RSCCK";// 申请提交
	public static final String SD_SPECANTICONS_STATUS_CMT = "01";// 申请提交
	public static final String NAME_SPECANTICONS_STATUS_CMT = "申请提交";// 申请提交
	/**
	 * CI.OR.0840-预防用药目的
	 */
	public static final String ID_PREPURPOSE_OP = "@@@@Z8100000000QD1WA";// 手术预防用
	public static final String SD_PREPURPOSE_OP = "01";// 手术预防用
	public static final String NAME_PREPURPOSE_OP = "手术预防用";// 手术预防用

	public static final String ID_PREPURPOSE_OTHER = "@@@@Z8100000000QD1WB";// 非手术预防用
	public static final String SD_PREPURPOSE_OTHER = "02";// 非手术预防用
	public static final String NAME_PREPURPOSE_OTHER = "非手术预防用";// 非手术预防用

	/**
	 * CI.OR.0845-手术预防用切口等级
	 */
	public static final String ID_PREINCITP_I = "@@@@Z8100000000QD1WC";// I类切口
	public static final String SD_PREINCITP_I = "01";// I类切口
	public static final String NAME_PREINCITP_I = "I类切口";// I类切口

	public static final String ID_PREINCITP_OTHER = "@@@@Z8100000000QD1WD";// 非I类切口
	public static final String SD_PREINCITP_OTHER = "02";// 非I类切口
	public static final String NAME_PREINCITP_OTHER = "非I类切口";// 非I类切口


	/**
	 * CI.OR.0850-用药原因
	 */
	public static final String ID_PREDRUGREASON_01 = "@@@@Z8100000000QD1WE";// 有植入物
	public static final String SD_PREDRUGREASON_01 = "01";// 有植入物
	public static final String NAME_PREDRUGREASON_01 = "有植入物";// 有植入物

	public static final String ID_PREDRUGREASON_02 = "@@@@Z8100000000QD1WF";// 高危因素
	public static final String SD_PREDRUGREASON_02 = "02";// 高危因素
	public static final String NAME_PREDRUGREASON_02 = "高危因素";// 高危因素

	public static final String ID_PREDRUGREASON_03 = "@@@@Z8100000000QD1WG";// 重要器官
	public static final String SD_PREDRUGREASON_03 = "03";// 重要器官
	public static final String NAME_PREDRUGREASON_03 = "重要器官";// 重要器官

	public static final String ID_PREDRUGREASON_04 = "@@@@Z8100000000QD1WH";// 超长失血
	public static final String SD_PREDRUGREASON_04 = "04";// 超长失血
	public static final String NAME_PREDRUGREASON_04 = "超长失血";// 超长失血

	/**
	 * CI.OR.0855-抗菌药用药目的
	 */
	public static final String ID_ANTIPURPOSE_DEFEND = "@@@@Z8100000000QD4ZS";// 预防
	public static final String SD_ANTIPURPOSE_DEFEND = "01";// 预防
	public static final String NAME_ANTIPURPOSE_DEFEND = "预防";// 预防

	public static final String ID_ANTIPURPOSE_TREATE = "@@@@Z8100000000QD4ZT";// 治疗
	public static final String SD_ANTIPURPOSE_TREATE = "02";// 治疗
	public static final String NAME_ANTIPURPOSE_TREATE = "治疗";// 治疗

	/**
	 * CI.OR.0860 门诊医生站类型
	 */
	public static final String ID_OPSTATIONTP_0 = "@@@@Z81000000007BP4K";// 慢病门诊医生站
	public static final String SD_OPSTATIONTP_0 = "0";// 慢病门诊医生站
	public static final String NAME_OPSTATIONTP_0 = "慢病门诊医生站";// 慢病门诊医生站

	/**
	 * CI.OR.0865 不摆药类型
	 */
	public static final String ID_NODISPENSE_SELF = "@@@@Z81000000008AVOW"; // 自备
	public static final String SD_NODISPENSE_SELF = "0"; // 自备
	public static final String NAME_NODISPENSE_SELF = "自备"; // 自备

	public static final String ID_NODISPENSE_ENTRUST  = "@@@@Z81000000008AVP0"; // 嘱托
	public static final String SD_NODISPENSE_ENTRUST = "1"; // 嘱托
	public static final String NAME_NODISPENSE_ENTRUST = "嘱托"; // 嘱托
	
	public static final String ID_NODISPENSE_FOREIGN ="@@@@Z8100000003LXF2Z";// 外配
	public static final String SD_NODISPENSE_FOREIGN ="2";// 外配
	public static final String NAME_NODISPENSE_FOREIGN ="外配";// 外配

	/**
	 * CI.OR.0870-特殊使用级抗菌药会诊方式
	 */
	public static final String ID_SPECANTICONS_MODE_MEETING = "@@@@Z8100000000A3TQR";// 现场会议
	public static final String SD_SPECANTICONS_MODE_MEETING = "0";// 现场会议
	public static final String NAME_SPECANTICONS_MODE_MEETING = "现场会议";// 现场会议

	/**
	 * CI.OR.0875-特殊使用级抗菌药会诊結果
	 */
	public static final String ID_SPECANTICONS_RST_AGREE = "@@@@Z8100000000A3TQT";// 同意
	public static final String SD_SPECANTICONS_RST_AGREE = "0";// 同意
	public static final String NAME_SPECANTICONS_RST_AGREE = "同意";// 同意

	public static final String ID_SPECANTICONS_RST_DISAGREE = "@@@@Z8100000000A3TQU";// 不同意
	public static final String SD_SPECANTICONS_RST_DISAGREE = "1";// 不同意
	public static final String NAME_SPECANTICONS_RST_DISAGREE = "不同意";// 不同意
	/**
	 * CI.OR.0905 医嘱来源功能
	 */
	public static final String ID_ORDSRCFUN_DOC = "@@@@Z8100000000UG42R";// 医嘱医生站
	public static final String ID_ORDSRCFUN_NUR = "@@@@Z8100000000UG42V";// 护嘱医生站
	public static final String ID_ORDSRCFUN_MT = "@@@@Z8100000000UG42Y";// 医技医生站

	public static final String SD_ORDSRCFUN_DOC = "1";// 医嘱医生站
	public static final String SD_ORDSRCFUN_NUR = "2";// 护嘱医生站
	public static final String SD_ORDSRCFUN_MT = "3";// 医技医生站

	/**
	 * CI.OR.0920 领药方式_自定义档案
	 */
	public static final String ID_DRUG_DELIVERY_METHOD_WHOLE_COLLAR = "@@@@Z8100000000UF5XY";// 在院整领
	public static final String SD_DRUG_DELIVERY_METHOD_WHOLE_COLLAR = "1";// 在院整领
	public static final String NAME_DRUG_DELIVERY_METHOD_WHOLE_COLLAR = "在院整领";

	public static final String ID_DRUG_DELIVERY_METHOD_PRES_OUT = "@@@@Z8100000000UF5XZ";// 出院带药
	public static final String SD_DRUG_DELIVERY_METHOD_PRES_OUT = "2";// 出院带药
	public static final String NAME_DRUG_DELIVERY_METHOD_PRES_OUT = "出院带药";

	public static final String ID_DRUG_DELIVERY_METHOD_PRES_BACK="@@@@Z8100000000YC5JO";// 退药
	public static final String SD_DRUG_DELIVERY_METHOD_PRES_BACK="3";// 退药
	public static final String NAME_DRUG_DELIVERY_METHOD_PRES_BACK="退药";// 退药

	/**
	 * CI.OR.0990 医嘱开单类型
	 */
	public static final String CODE_ORDER_CREATE_EMS_TYPE = "CI.OR.0990";// 医嘱开单类型编码
	public static final String ID_ORDER_CREATE_EMS_TYPE = "@@@@ZZ20000000000125";// 医嘱开单类型主键

	public static final String ID_ORDER_CREATE_EMS_TYPE_DRUG = "@@@@Z8100000001EG4EL";	// (00)西药
	public static final String ID_ORDER_CREATE_EMS_TYPE_HERB = "@@@@Z8100000001EG4EM";	// (01)草药
	public static final String ID_ORDER_CREATE_EMS_TYPE_TREAT = "@@@@Z8100000001EG4EN";	// (02)治疗
	public static final String ID_ORDER_CREATE_EMS_TYPE_NURS = "@@@@Z8100000001EG4EO";	// (03)护理
	public static final String ID_ORDER_CREATE_EMS_TYPE_LIS = "@@@@Z8100000001EG4EP";	// (04)检验
	public static final String ID_ORDER_CREATE_EMS_TYPE_RIS = "@@@@Z8100000001EG4EQ";	// (05)检查
	public static final String ID_ORDER_CREATE_EMS_TYPE_OPR = "@@@@Z8100000001EG4ER";	// (06)手术
	public static final String ID_ORDER_CREATE_EMS_TYPE_CONS = "@@@@Z8100000001EG4ES";	// (07)会诊
	public static final String ID_ORDER_CREATE_EMS_TYPE_ENTRUST = "@@@@Z8100000001EG4ET";	// (08)嘱托
	public static final String ID_ORDER_CREATE_EMS_TYPE_NUTRITION = "@@@@Z8100000001EG4EU";	// (09)营养
	public static final String ID_ORDER_CREATE_EMS_TYPE_ILLNESS = "@@@@Z8100000001EG4EV";	// (10)病情
	public static final String ID_ORDER_CREATE_EMS_TYPE_SELFDRUG = "@@@@Z8100000001EG4EW";	// (11)自备药
	public static final String ID_ORDER_CREATE_EMS_TYPE_DRUGSHOP = "@@@@Z8100000001EG4EX";	// (12)药店医嘱


	/**
	 * CI.OR.0992 服务关联业务类型
	 */
	public static final String ID_RELSRVTRIGGERTP_ORDER = "@@@@Z8100000000EYB7S";// 医嘱
	public static final String ID_RELSRVTRIGGERTP_APPSHEET = "@@@@Z8100000000EYB7T";// 管理单据

	public static final String SD_RELSRVTRIGGERTP_ORDER = "0";// 医嘱
	public static final String SD_RELSRVTRIGGERTP_APPSHEET = "1";// 管理单据

	/**
	 * CI.OR.0993 生成项目类型
	 */
	public static final String ID_RELSRVBUILDTP_SRV = "@@@@Z8100000000EYB7U";// 服务
	public static final String ID_RELSRVBUILDTP_ORDER = "@@@@Z8100000000EYB7V";// 医嘱

	public static final String SD_RELSRVBUILDTP_SRV = "0";// 服务
	public static final String SD_RELSRVBUILDTP_ORDER = "1";// 医嘱


	/**
	 * CI.OR.0999 医嘱高值耗材申请单状态
	 */
	public static final String ID_APHV_NEW = "@@@@Z8100000001STA2C";// 开立
	public static final String SD_APHV_NEW = "0";// 开立

	public static final String ID_APHV_SUBMIT = "@@@@Z8100000001STBX5";// 提交
	public static final String SD_APHV_SUBMIT = "1";// 提交

	public static final String ID_APHV_CHECK = "@@@@Z8100000001STBX6";// 审核
	public static final String SD_APHV_CHECK = "2";// 审核

	public static final String ID_APHV_PLAN = "@@@@Z8100000001STL73";// 已入计划
	public static final String SD_APHV_PLAN = "3";// 已入计划

	public static final String ID_APHV_IN = "@@@@Z8100000001STOWO";// 入库完成
	public static final String SD_APHV_IN = "4";// 入库完成

	public static final String ID_APHV_REJECT = "@@@@Z8100000003C6H6Y";// 入库完成
	public static final String SD_APHV_REJECT = "5";// 入库完成
	//方案医嘱来源方式
	public static final String SD_TSORSRCMDTP_SRVREF = "0";// 服务参照
	public static final String SD_TSORSRCMDTP_DIC = "1";// 方案字典
	public static final String SD_TSORSRCMDTP_TMPL = "2";//治疗方案模板
	//方案类型
	public static final String SD_TSTP_PREOP = "0";// 预住院申请
	public static final String SD_TSTP_RECURE = "1";// 康复方案
	public static final String SD_TSTP_CHEMOTPY = "2";//化疗方案
	//方案医嘱生成状态
	public static final String SD_SU_TS_MP_NONE = "0";// 未生成
	public static final String SD_SU_TS_MP_ING = "1";// 生成中
	public static final String SD_SU_TS_MP_DONE = "20";//已生成
}
