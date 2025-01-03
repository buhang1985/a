package iih.bd.bc.udi.pub;

/**
 * 基础编码常量类</br>
 * BD.SRV基础编码常量
 */
public interface IBdSrvDictCodeConst {
	// / <summary>
	// / 0515互斥类型
	// / </summary>
	public static final String SD_REACTCA_NONE = "0"; // 不排斥
	public static final String SD_REACTCA_ALL = "1"; // 全排斥
	public static final String SD_REACTCA_INGROUP = "2"; // 组内排斥
	public static final String ID_REACTCA_NONE = "@@@@AA1000000000ELMN"; // 不排斥
	public static final String ID_REACTCA_ALL = "@@@@AA1000000000ELMO"; // 全排斥
	public static final String ID_REACTCA_INGROUP = "@@@@AA1000000000ELMP"; // 组内排斥

	// / <summary>
	// / 1715频次周期类型
	// / </summary>
	public static final String SD_FREQNUNITCT_ONCE = "0";// 一次 once
	public static final String SD_FREQNUNITCT_HOUR = "3"; // 小时
	public static final String SD_FREQNUNITCT_DAY = "2"; // 天
	public static final String SD_FREQNUNITCT_WEEK = "4"; // 周
	public static final String SD_FREQNUNITCT_PLAN = "5"; // 计划
	public static final String SD_FREQNUNITCT_ALWAYS = "1"; // 持续
	public static final String SD_FREQNUNITCT_MINUTE = "6";// 分钟

	public static final String ID_FREQNUNITCT_ONCE = "@@@@AA1000000000ELM4";// 一次
	public static final String ID_FREQNUNITCT_HOUR = "@@@@AA1000000000ELM5"; // 小时
	public static final String ID_FREQNUNITCT_DAY = "@@@@AA1000000000ELM6"; // 天
	public static final String ID_FREQNUNITCT_WEEK = "@@@@AA1000000000ELM7"; // 周
	public static final String ID_FREQNUNITCT_PLAN = "@@@@AA1000000000ELM9"; // 计划
	public static final String ID_FREQNUNITCT_ALWAYS = "@@@@AA100000000037QP"; // 持续
	public static final String ID_FREQNUNITCT_MINUTE = "@@@@YB100000000M2ARB";// 分钟

	// / <summary>
	// / 频次常量
	// / </summary>
	public static final String ID_FREQNUNITCT_ITEM_ONCE = "@@@@Z7100000000D0OYS";// 一次
	public static final String ID_FREQNUNITCT_ITEM_ALWAYS = "@@@@AA1000000006AEHV";// 持续
	public static final String CODE_FREQNUNITCT_ITEM_ONCE = "ONCE";// 一次
	public static final String NAME_FREQNUNITCT_ITEM_ONCE = "一次";// 一次

	// / <summary>
	// / 1545 所属类型编码
	// / </summary>
	public static final String SD_OWTP_HOSPIAL = "0";// 全院
	public static final String SD_OWTP_DEPARTMENT = "1";// 科室
	public static final String SD_OWTP_PERSONAL = "2";// 个人

	// / <summary>
	// / 0780 医嘱诊疗执行申请单类型编码
	// / </summary>
	public static final String SD_APPTREATEXECTP_INJECTION = "01";// 注射执行申请单
	public static final String SD_APPTREATEXECTP_TREAT = "02";// 诊疗执行申请单

	// / <summary>
	// / 0780 医嘱诊疗执行申请单类型ID
	// / </summary>
	public static final String SD_APPTREATEXECTP_INJECTION_ID = "@@@@AA1000000001VN6Q";// 注射执行申请单
	public static final String SD_APPTREATEXECTP_TREAT_ID = "@@@@AA1000000001VN6U";// 诊疗执行申请单

	// / <summary>
	// / 0795临床打印清单类型编码
	// / </summary>
	public static final String SD_CIPRNTP_COSTTP = "01";// 费用类别
	public static final String SD_CIPRNTP_COSTBILL = "0101";// 门诊费用清单

	// / <summary>
	// / 0795临床打印清单类型ID
	// / </summary>
	public static final String SD_CIPRNTP_COSTTP_ID = "@@@@Z7100000000MHZQ1";// 费用类别
	public static final String SD_CIPRNTP_COSTBILL_ID = "@@@@Z7100000000MHZQ3";// 门诊费用清单

	// / <summary>
	// / 1545 所属类型ID
	// / </summary>
	public static final String SD_OWTP_PERSONAL_ID = "@@@@AA1000000000ELNQ";// 个人
	public static final String SD_OWTP_DEPARTMENT_ID = "@@@@AA1000000000ELNR";// 科室
	public static final String SD_OWTP_HOSPIAL_ID = "@@@@AA1000000000ELNS";// 全院

	// / <summary>
	// / 0505 服务类型 编码
	// / </summary>
	public static final String SD_SRVTP_DRUG = "01"; // 药品
	public static final String SD_SRVTP_WESTDRUG = "0101"; // 西药
	public static final String SD_SRVTP_WESTDRUG_KF = "010101"; // 口服类药品
	public static final String SD_SRVTP_WESTDRUG_WY = "010102"; // 外用药
	public static final String SD_SRVTP_WESTDRUG_ZX = "010103"; // 注射类药品
	public static final String SD_SRVTP_WESTDRUG_DSY = "010104"; // 溶媒
	public static final String SD_SRVTP_WESTDRUG_PSY = "010105"; // 皮试液
	public static final String SD_SRVTP_WESTDRUG_YM = "010106"; // 疫苗 2017-08-18
																// 王琪铜陵新增 该公卫类型项
	public static final String SD_SRVTP_WESTDRUG_OTHER = "010199"; // 其它
	public static final String SD_SRVTP_CYDRUG = "0102"; // 成药
	public static final String SD_SRVTP_CYDRUG_CHINA = "010201"; // 中成药
	public static final String SD_SRVTP_CYDRUG_MENG = "010202"; // 蒙成药
	public static final String SD_SRVTP_HERBDRUG = "0103"; // 草药
	public static final String SD_SRVTP_HERBDRUG_CHINA = "010301"; // 中药材
	public static final String SD_SRVTP_HERBDRUG_MENG = "010302"; // 蒙药材
	public static final String SD_SRVTP_RIS = "02"; // 检查
	public static final String SD_SRVTP_RIS_TOUSHI = "0201"; // 透视
	public static final String SD_SRVTP_RIS_XRAY = "0202"; // X线
	public static final String SD_SRVTP_RIS_CT = "0203"; // CT
	public static final String SD_SRVTP_RIS_HECI = "0204"; // 核磁
	public static final String SD_SRVTP_RIS_DAOGUAN = "0205"; // 导管介入
	public static final String SD_SRVTP_RIS_BCHAO = "0206"; // B超
	public static final String SD_SRVTP_RIS_BINGLI = "0207"; // 病理
	public static final String SD_SRVTP_RIS_DIANSHENGLI = "0208"; // 电生理
	public static final String SD_SRVTP_RIS_NEIJING = "0209"; // 内镜
	public static final String SD_SRVTP_RIS_FUNCCHECK = "0210"; // 功能性检查（如肺活量检查）
	public static final String SD_SRVTP_RIS_NUCLEAR_A = "0211"; // 核医学
	public static final String SD_SRVTP_RIS_OTHER = "0299"; // 其它1
	public static final String SD_SRVTP_LIS = "03"; // 检验
	public static final String SD_SRVTP_LIS_NORMAL = "0301"; // 常规检验
	public static final String SD_SRVTP_LIS_SHENGHUA = "0302"; // 生化检验
	public static final String SD_SRVTP_LIS_MIANYI = "0303"; // 免疫检验
	public static final String SD_SRVTP_LIS_MICROGERM = "0304"; // 微生物检验
	// public static final String SD_SRVTP_LIS_SKINMINGANTEST = "0305";
	// //临检检查--->皮肤敏感性试验
	public static final String SD_SRVTP_LIS_OTHER = "0399"; // 其它2
	public static final String SD_SRVTP_OP = "04"; // 手术
	public static final String SD_SRVTP_OP_TAICI = "0401"; // 台次手术
	public static final String SD_SRVTP_OP_BESIDEDEB = "0402"; // 床边手术
	public static final String SD_SRVTP_TREAT = "05"; // 治疗
	public static final String SD_SRVTP_TREAT_NORMAL = "0501"; // 普通治疗
	public static final String SD_SRVTP_TREAT_FANGLIAO = "0502"; // 放疗
	public static final String SD_SRVTP_TREAT_XIYANG = "0503"; // 吸氧
	public static final String SD_SRVTP_TREAT_WUHUA = "0504"; // 雾化吸入
	public static final String SD_SRVTP_TREAT_NUT = "0505"; // 膳食(包括肠内外营养)
	public static final String SD_SRVTP_TREAT_SKINMINGANTEST = "0506"; // 治疗--->皮肤敏感性试验
	public static final String SD_SRVTP_TREAT_RESCUE = "0507"; // 抢救
	public static final String SD_SRVTP_TREAT_TOUXI = "0508"; // 透析
	public static final String SD_SRVTP_NURSE = "06"; // 护理
	public static final String SD_SRVTP_NURSE_NSGREED = "0601"; // 护理等级
	public static final String SD_SRVTP_NURSE_TREATNS = "0602"; // 治疗性护理
	public static final String SD_SRVTP_NURSE_VS = "0603"; // 生命体征
	public static final String SD_SRVTP_SANI = "07"; // 卫材
	public static final String SD_SRVTP_SANI_A = "0701"; // 卫生材料
	public static final String SD_SRVTP_SANI_SC = "0702"; // 标本容器
	public static final String SD_SRVTP_ENTRUST = "08"; // 嘱托
	public static final String SD_SRVTP_ENTRUST_A = "0801"; // 嘱托1
	public static final String SD_SRVTP_ENTRUST_PROEDU = "0802"; // 宣教
	public static final String SD_SRVTP_ENTRUST_ILLSTATE = "0803"; // 病情
	public static final String SD_SRVTP_DIAGTREAT = "09"; // 诊疗
	public static final String SD_SRVTP_DIAGTREAT_OP = "0901"; // 门急诊诊疗
	public static final String SD_SRVTP_DIAGTREAT_OP_EXP = "090101"; // 专家
	public static final String SD_SRVTP_DIAGTREAT_OP_NORM = "090102"; // 普通
	public static final String SD_SRVTP_DIAGTREAT_OP_URG = "090103"; // 急诊
	public static final String SD_SRVTP_DIAGTREAT_OP_SPECIAL = "090104"; // 特需
	public static final String SD_SRVTP_DIAGTREAT_OP_CONCROSS = "0902"; // 会诊与跨科
	public static final String SD_SRVTP_HEALTH = "10"; // 健康
	public static final String SD_SRVTP_HEALTH_BASIC = "1001"; // 基本公共卫生服务
	public static final String SD_SRVTP_HEALTH_MAN = "1002"; // 公共卫生管理
	public static final String SD_SRVTP_SRVPKG = "11"; // 诊疗方案服务包
	public static final String SD_SRVTP_SRVPKG_PHYEXAM = "1101"; // 体检包
	public static final String SD_SRVTP_SRVPKG_OTHER = "1199"; // 其它3
	public static final String SD_SRVTP_PATIMAN = "12"; // 患者管理类
	public static final String SD_SRVTP_PATIMAN_TRANSDEPT = "1201"; // 转科
	public static final String SD_SRVTP_PATIMAN_LEAVEHOS = "1202"; // 出院
	public static final String SD_SRVTP_PATIMAN_CLIDEATH = "1203"; // 宣布临床死亡
	public static final String SD_SRVTP_PATIMAN_CROSSDEPT = "1204"; // 跨科
	public static final String SD_SRVTP_PATIMAN_TRANSWARD = "1205"; // 转病区
	public static final String SD_SRVTP_FIXFEE = "13"; // 固定费用类
	public static final String SD_SRVTP_FIXFEE_IP = "1301"; // 住院固定收费
	public static final String SD_SRVTP_BLOODPROD = "14"; // 血液制品
	public static final String SD_SRVTP_BLOODPROD_A = "1401"; // 血液制品1
	public static final String SD_SRVTP_BLOODPROD_PREPARE = "140101"; // 备血
	public static final String SD_SRVTP_BLOODPROD_USE = "140102"; // 用血
	public static final String SD_SRVTP_BLOODPROD_REPL = "1402"; // 血液代用品
	public static final String SD_SRVTP_OTHER = "99"; // 其他

	// / <summary>
	// / 0505 服务类型 ID
	// / </summary>
	public static final String SD_SRVTP_DRUG_ID = "@@@@W11000000003UM03";// "01";
																			// //药品
	public static final String SD_SRVTP_WESTDRUG_ID = "@@@@W11000000003UM0L";// "0101";
																				// //西药
	public static final String SD_SRVTP_WESTDRUG_KF_ID = "@@@@W11000000003UM0Q";// "010101
																				// ";
																				// //口服类药品
	public static final String SD_SRVTP_WESTDRUG_WY_ID = "@@@@W11000000003UM0R";// "010102";
																				// //外用药
	public static final String SD_SRVTP_WESTDRUG_ZX_ID = "@@@@W11000000003UM0S";// "010103";
																				// //注射类药品
	public static final String SD_SRVTP_WESTDRUG_DXY_ID = "@@@@W11000000003UM0J";// "010104";
																					// //溶媒
	public static final String SD_SRVTP_WESTDRUG_PSY_ID = "@@@@W11000000003UM0K";// "010105";
																					// //皮试液
	public static final String SD_SRVTP_WESTDRUG_YM_ID = "@@@@Z8100000000LQ3Z6"; // 010106
																					// 疫苗
																					// 2017-08-18
																					// 王琪铜陵新增
																					// 该公卫类型项
	public static final String SD_SRVTP_WESTDRUG_OTHER_ID = "@@@@W11000000003UM0P";// "010199
																					// ";
																					// //其它
	public static final String SD_SRVTP_CYDRUG_ID = "@@@@W11000000003UM0M";// "0102";
																			// //成药
	public static final String SD_SRVTP_CYDRUG_CHINA_ID = "@@@@W11000000003UM0T";// "010201";
																					// //中成药
	public static final String SD_SRVTP_CYDRUG_MENG_ID = "@@@@W11000000003UM0U";// "010202";
																				// //蒙成药
	public static final String SD_SRVTP_HERBDRUG_ID = "@@@@W11000000003UM0N";// "0103";
																				// //草药
	public static final String SD_SRVTP_HERBDRUG_CHINA_ID = "@@@@W11000000003UM0V";// "010301";
																					// //中药材
	public static final String SD_SRVTP_HERBDRUG_MENG_ID = "@@@@W11000000003UM0W";// "010302";
																					// //蒙药材
	public static final String SD_SRVTP_RIS_ID = "@@@@W11000000003UM05";// "02";
																		// //检查
	public static final String SD_SRVTP_RIS_TOUSHI_ID = "@@@@W11000000003UM0X";// "0201";
																				// //透视
	public static final String SD_SRVTP_RIS_XRAY_ID = "@@@@W11000000003UM06";// "0202";
																				// //X线
	public static final String SD_SRVTP_RIS_CT_ID = "@@@@W11000000003UM0Y";// "0203";
																			// //CT
	public static final String SD_SRVTP_RIS_HECI_ID = "@@@@W11000000003UM0Z";// "0204";
																				// //核磁
	public static final String SD_SRVTP_RIS_DAS_ID = "@@@@W11000000003UM10";// "0205";
																			// //DSA检查
	public static final String SD_SRVTP_RIS_BCHAO_ID = "@@@@W11000000003UM11";// "0206";
																				// //B超
	public static final String SD_SRVTP_RIS_BINGLI_ID = "@@@@W11000000003UM12";// "0207";
																				// //病理
	public static final String SD_SRVTP_RIS_DIANSHENGLI_ID = "@@@@W11000000003UM13";// "0208";
																					// //电生理
	public static final String SD_SRVTP_RIS_NEIJING_ID = "@@@@W11000000003UM14";// "0209
																				// ";
																				// //内镜
	public static final String SD_SRVTP_RIS_FUNCCHECK_ID = "@@@@W11000000003UM2S";// "0210";
																					// //功能性检查（如肺活量）
	public static final String SD_SRVTP_RIS_NUCLEAR_A_ID = "@@@@W11000000003UM22";// "0211";
																					// //核医学
	public static final String SD_SRVTP_RIS_OTHER_ID = "@@@@W11000000003UM21";// "0299";
																				// //其它1
	public static final String SD_SRVTP_LIS_ID = "@@@@W11000000003UM07";// "03";
																		// //检验
	public static final String SD_SRVTP_LIS_NORMAL_ID = "@@@@W11000000003UM15";// "0301";
																				// //常规检验
	public static final String SD_SRVTP_LIS_SHENGHUA_ID = "@@@@W11000000003UM16";// "0302";
																					// //生化检验
	public static final String SD_SRVTP_LIS_MIANYI_ID = "@@@@W11000000003UM17";// "0303";
																				// //免疫检验
	public static final String SD_SRVTP_LIS_MICROGERM_ID = "@@@@W11000000003UM18";// "0304";
																					// //微生物检验
	// public static final String SD_SRVTP_LIS_SKINMINGANTEST_ID =
	// "@@@@W11000000003UM19";// "0305"; //临检检查--》皮肤敏感性试验
	public static final String SD_SRVTP_LIS_OTHER_ID = "@@@@W11000000003UM23";// "0399";
																				// //其它2

	public static final String SD_SRVTP_OP_ID = "@@@@W11000000003UM08";// "05";
																		// //手术
	public static final String SD_SRVTP_OP_TAICI_ID = "@@@@W11000000003UM1A";// "0501";
																				// //台次手术
	public static final String SD_SRVTP_OP_BESIDEDEB_ID = "@@@@W11000000003UM1B";// "0502";
																					// //床边手术
	public static final String SD_SRVTP_TREAT_ID = "@@@@W11000000003UM09";// "06";
																			// //治疗
	public static final String SD_SRVTP_TREAT_NORMAL_ID = "@@@@W11000000003UM1C";// "0601";
																					// //普通治疗
	public static final String SD_SRVTP_TREAT_FANGLIAO_ID = "@@@@W11000000003UM1D";// "0602";
																					// //放疗
	public static final String SD_SRVTP_TREAT_XIYANG_ID = "@@@@W11000000003UM1E";// "0603";
																					// //吸氧
	public static final String SD_SRVTP_TREAT_WUHUA_ID = "@@@@W11000000003UM1F";// "0604";
																				// //雾化吸入
	public static final String SD_SRVTP_TREAT_NUT_ID = "@@@@W11000000003UM1G";// "0605";
																				// //膳食(包括肠内外营养)
	public static final String SD_SRVTP_TREAT_SKINMINGANTEST_ID = "@@@@W11000000003UM19";// "0506";
																							// //临检检查--》皮肤敏感性试验
	public static final String SD_SRVTP_TREAT_RESCUE_ID = "@@@@W11000000003UM2Z";// "0507";
																					// //抢救
	public static final String SD_SRVTP_TREAT_TOUXI_ID = "@@@@W11000000003UM2K"; // 0508
																					// 透析
	public static final String SD_SRVTP_NURSE_ID = "@@@@W11000000003UM0A";// "07";
																			// //护理
	public static final String SD_SRVTP_NURSE_NSGREED_ID = "@@@@W11000000003UM1H";// "0701";
																					// //护理等级
	public static final String SD_SRVTP_NURSE_TREATNS_ID = "@@@@W11000000003UM1I";// "0702";
																					// //治疗性护理
	public static final String SD_SRVTP_NURSE_VS_ID = "@@@@W11000000003UM1J";// "0703";
																				// //生命体征
	public static final String SD_SRVTP_SANI_ID = "@@@@W11000000003UM1K";// "08";
																			// //卫材
	public static final String SD_SRVTP_SANI_A_ID = "@@@@W11000000003UM1L";// "0801";
																			// //卫生材料
	public static final String SD_SRVTP_SANI_SC_ID = "@@@@W11000000003UM2L"; // 0702标本容器
	public static final String SD_SRVTP_ENTRUST_ID = "@@@@W11000000003UM0B";// "09";
																			// //嘱托
	public static final String SD_SRVTP_ENTRUST_A_ID = "@@@@W11000000003UM20";// "0901";
																				// //嘱托1
	public static final String SD_SRVTP_ENTRUST_PROEDU_ID = "@@@@W11000000003UM1M";// "0902
																					// ";
																					// //宣教
	public static final String SD_SRVTP_ENTRUST_ILLSTATE_ID = "@@@@W11000000003UM3M"; // 病情
	public static final String SD_SRVTP_DIAGTREAT_ID = "@@@@W11000000003UM0C";// "10";
																				// //诊疗
	public static final String SD_SRVTP_DIAGTREAT_OP_ID = "@@@@W11000000003UM1N";// "1001";
																					// //门急诊诊疗
	public static final String SD_SRVTP_DIAGTREAT_OP_EXP_ID = "@@@@W11000000003UM1P";// "100101";
																						// //专家
	public static final String SD_SRVTP_DIAGTREAT_OP_NORM_ID = "@@@@W11000000003UM1Q";// "100102";
																						// //普通
	public static final String SD_SRVTP_DIAGTREAT_OP_URG_ID = "@@@@W11000000003UM1R";// "100103";
																						// //急诊
	public static final String SD_SRVTP_DIAGTREAT_OP_SPECIAL_ID = "@@@@Z7100000000G43FO"; // 090104特需
	public static final String SD_SRVTP_DIAGTREAT_OP_CONCROSS_ID = "@@@@W11000000003UM1O";// "1002";
																							// //会诊与跨科
	public static final String SD_SRVTP_HEALTH_ID = "@@@@W11000000003UM0D";// "11";
																			// //健康
	public static final String SD_SRVTP_HEALTH_BASIC_ID = "@@@@W11000000003UM1S";// "1101";
																					// //基本公共卫生服务
	public static final String SD_SRVTP_HEALTH_MAN_ID = "@@@@W11000000003UM1T";// "1102";
																				// //公共卫生管理
	public static final String SD_SRVTP_SRVPKG_ID = "@@@@W11000000003UM0E";// "12";
																			// //诊疗方案服务包
	public static final String SD_SRVTP_SRVPKG_PHYEXAM_ID = "@@@@W11000000003UM1U";// "1201";
																					// //体检包
	public static final String SD_SRVTP_SRVPKG_OTHER_ID = "@@@@W11000000003UM24";// "1299";
																					// //其它3
	public static final String SD_SRVTP_PATIMAN_ID = "@@@@W11000000003UM0F";// "12";
																			// 患者管理类
	public static final String SD_SRVTP_PATIMAN_TRANSDEPT_ID = "@@@@W11000000003UM1V";// "1201";
																						// 转科
	public static final String SD_SRVTP_PATIMAN_LEAVEHOS_ID = "@@@@W11000000003UM1W";// "1202";
																						// 出院
	public static final String SD_SRVTP_PATIMAN_CLIDEATH_ID = "@@@@W11000000003UM1X";// "1203"
																						// 宣布临床死亡
	public static final String SD_SRVTP_PATIMAN_CROSSDEPT_ID = "@@@@AA1000000001Q2J8";// "1204"
																						// 跨科
	public static final String SD_SRVTP_PATIMAN_TRANSWARD_ID = "@@@@W11000000003UM2V";// "1205"
																						// 转病区

	public static final String SD_SRVTP_FIXFEE_ID = "@@@@W11000000003UM0G";// "14";
																			// //固定费用类
	public static final String SD_SRVTP_FIXFEE_IP_ID = "@@@@W11000000003UM1Y";// "1401";
																				// //住院固定收费
	public static final String SD_SRVTP_BLOODPROD_ID = "@@@@W11000000003UM0H";// //血液制品
	public static final String SD_SRVTP_BLOODPROD_A_ID = "@@@@W11000000003UM25";// //血液制品1
	public static final String SD_SRVTP_BLOODPROD_REPL_ID = "@@@@W11000000003UM1Z";// //血液代用品
	public static final String SD_SRVTP_BLOODPROD_PREPARE_ID = "@@@@W11000000003UM27"; // 备血
	public static final String SD_SRVTP_BLOODPROD_USE_ID = "@@@@W11000000003UM57"; // 用血
	public static final String SD_SRVTP_OTHER_ID = "@@@@W11000000003UM0I";// "99";
																			// //其他
	/**
	 * 服务套开立模式
	 */
	public static final String SD_SETORD_ORMODE = "0"; // 医嘱模式
	public static final String SD_SETORD_SRVMODE = "1"; // 服务模式
	public static final String SD_SETORD_COMBINATION = "2"; // 服务组合模式
	public static final String ID_SETORD_ORMODE = "@@@@AA1000000002MI3V";
	public static final String ID_SETORD_SRVMODE = "@@@@AA1000000002MI3W";
	public static final String ID_SETORD_COMBINATION = "@@@@AA1000000002MI3X";

	/* 预检 */
	public static final String SD_PRE_OUTPATIENT = "F.HDSD00.03.02"; // 门诊预检
	public static final String SD_PRE_EMERGENCY = "F.HDSD00.03.03"; // 急诊预检

	/**
	 * 体温医疗记录类型
	 */
	public static final String ID_MRTPL_TEMPERATURE = "@@@@AA1000000004Z046";
	public static final String SD_MRTPL_TEMPERATURE = "F.HDSD00.19.01";

	/**
	 * 体温医疗记录自定义分类
	 */
	public static final String ID_MRCA_CTM = "0001AA1000000005DBX6";
	public static final String SD_MRCA_CTM = "A.02.01";

	// / <summary>
	// / 1805互斥类型
	// / </summary>
	public static final String SD_REACTTP_EXCLUDEALL = "1"; // 全排斥
	public static final String SD_REACTTP_GRPINEXCLUDE = "2"; // 非全排

	// / <summary>
	// / 1805互斥类型
	// / </summary>
	public static final String SD_REACTTP_EXCLUDEALL_ID = "@@@@AA1000000000ELMQ"; // 全排斥
	public static final String SD_REACTTP_GRPINEXCLUDE_ID = "@@@@AA1000000000ELMR"; // 非全排

	/*
	 * 检验结果值类型编码
	 */
	public static final String SD_RSTRPTLABTP_NUM = "0"; // 数值
	public static final String SD_RSTRPTLABTP_TEXT = "1"; // 字符
	public static final String SD_RSTRPTLABTP_COMB = "2"; // 枚举
	/*
	 * 检验结果值类型ID
	 */
	public static final String ID_RSTRPTLABTP_NUM = "@@@@AA1000000000ELI6"; // 数值
	public static final String ID_RSTRPTLABTP_TEXT = "@@@@AA1000000000ELI7"; // 字符
	public static final String ID_RSTRPTLABTP_COMB = "@@@@AA1000000000ELI8"; // 枚举

	/*
	 * 护理等级 by ren_ying
	 */
	public static final String ID_SRV_NUR_FIRST = "@@@@AA1000000006GEQ9";
	public static final String ID_SRV_NUR_SERCOND = "@@@@AA1000000006GER1";
	public static final String ID_SRV_NUR_THIRD = "@@@@AA1000000008DLBW";
	public static final String ID_SRV_NUR_SPECIAL = "@@@@AA1000000006GEPH";

	/*
	 * 病情等级 by ren_ying
	 */
	public static final String ID_SRV_DIS_ORI = "";
	public static final String ID_SRV_DIS_SER = "";
	public static final String ID_SRV_DIS_DYING = "";

	/*
	 * 营养类型 by ren_ying
	 */
	public static final String ID_SRV_FOOD_FLU = "@@@@AA1000000006GESP";// 流食
	public static final String ID_SRV_FOOD_HALFFLU = "@@@@AA1000000006B70L";// 半流食
	public static final String ID_SRV_FOOD_BIDFLU = "@@@@AA1000000008DLCS"; // 禁食
	public static final String ID_SRV_FOOD_ORIFLU = "@@@@AA1000000007JLF9";// 普通禁食

	/*
	 * 医嘱模板类型 编码
	 */
	public static final String SD_ORTMPLTP_BASE = "0";// 基础医嘱模板
	public static final String SD_ORTMPLTP_BASE_WEST = "01";// 成组西成药
	public static final String SD_ORTMPLTP_BASE_HERB = "02";// 草药方剂
	public static final String SD_ORTMPLTP_COMPOUND = "1";// 复合医嘱模板
	public static final String SD_ORTMPLTP_COMPOUND_A = "11"; // 11 复合模板
	/*
	 * 医嘱模板类型 ID
	 */
	public static final String ID_ORTMPLTP_BASE = "@@@@AA100000000A741V";// 基础医嘱模板
	public static final String ID_ORTMPLTP_BASE_WEST = "@@@@AA100000000A741X";// 成组西成药
	public static final String ID_ORTMPLTP_BASE_HERB = "@@@@AA100000000A7420";// 草药方剂
	public static final String ID_ORTMPLTP_COMPOUND = "@@@@AA100000000A741W";// 复合医嘱模板
	public static final String ID_ORTMPLTP_COMPOUND_A = "@@@@AA100000000A742W"; // 11
																				// 复合模板
	/*
	 * 关联医嘱类型
	 */
	public static final String ID_RELORDTYPE_BDCKUP = "@@@@AA10000000050QZK";// 备用医嘱
	public static final String ID_RELORDTYPE_SKIN = "@@@@AA10000000050QZL";// 皮试医嘱
	public static final String ID_RELORDTYPE_BLOOD = "@@@@AA1000000006S4BS";// 输血医嘱关联

	public static final String SD_RELORDTYPE_BDCKUP = "0";// 备用医嘱
	public static final String SD_RELORDTYPE_SKIN = "1";// 皮试医嘱
	public static final String SD_RELORDTYPE_BLOOD = "2";// 输血医嘱关联

	/*
	 * 套内项目执行科室计算模式编码
	 */
	public static final String SD_ORTMPLTP_WITHSRVSET = "01"; // 01 套模式（跟随套）
	public static final String SD_ORTMPLTP_ORWFMD = "02"; // 02 流向模式
	public static final String SD_ORTMPLTP_PVDEPT = "03"; // 03 就诊科室
	public static final String SD_ORTMPLTP_PVWARD = "04"; // 04 就诊病区
	public static final String SD_ORTMPLTP_ORDEPT = "05"; // 05 开单科室
	public static final String SD_ORTMPLTP_CONSTDEPT = "06"; // 06 固定科室

	/*
	 * 套内项目执行科室计算模式ID
	 */
	public static final String ID_ORTMPLTP_WITHSRVSET = "@@@@AA1000000001Q1T2"; // 01
																				// 套模式（跟随套）
	public static final String ID_ORTMPLTP_ORWFMD = "@@@@AA1000000001Q1T3"; // 02
																			// 流向模式
	public static final String ID_ORTMPLTP_PVDEPT = "@@@@AA1000000001Q1T4"; // 03
																			// 就诊科室
	public static final String ID_ORTMPLTP_PVWARD = "@@@@AA1000000001Q1T5"; // 04
																			// 就诊病区
	public static final String ID_ORTMPLTP_ORDEPT = "@@@@AA1000000001Q1T6"; // 05
																			// 开单科室
	public static final String ID_ORTMPLTP_CONSTDEPT = "@@@@AA1000000001Q1T7"; // 06
																				// 固定科室

	/*
	 * 关联因素类型编码
	 */
	public static final String SD_RELFACTORTP_SRV = "01"; // 01 服务
	public static final String SD_RELFACTORTP_SETSETITM = "02"; // 02 套+套内项目

	/*
	 * 关联因素类型ID
	 */
	public static final String ID_RELFACTORTP_SRV = "@@@@AA1000000001R9TN"; // 01
																			// 服务
	public static final String ID_RELFACTORTP_SETSETITM = "@@@@AA1000000001R9TO"; // 02
																					// 套+套内项目

	/*
	 * 用量计算策略编码
	 */
	public static final String SD_QUANCALMD_FIXV = "01"; // 01 定值
	public static final String SD_QUANCALMD_RATIO = "02"; // 02 比例法
	public static final String SD_QUANCALMD_EXTERNALFUNC = "09"; // 09 外挂函数

	/*
	 * 用量计算策略ID
	 */
	public static final String ID_QUANCALMD_FIXV = "@@@@AA1000000001R9TS"; // 01
																			// 定值
	public static final String ID_QUANCALMD_RATIO = "@@@@AA1000000001R9TT"; // 02
																			// 比例法
	public static final String ID_QUANCALMD_EXTERNALFUNC = "@@@@AA1000000001TB4D"; // 09
																					// 外挂函数

	/*
	 * 舍入规则编码
	 */
	public static final String SD_ROUNDMD_TRUNC = "01"; // 01 舍位
	public static final String SD_ROUNDMD_CARRY = "02"; // 02 进位
	public static final String SD_ROUNDMD_ROUND = "03"; // 03 四舍五入

	/*
	 * 舍入规则ID
	 */
	public static final String ID_ROUNDMD_TRUNC = "@@@@AA1000000001R9TU"; // 01
																			// 舍位
	public static final String ID_ROUNDMD_CARRY = "@@@@AA1000000001R9TV"; // 02
																			// 进位
	public static final String ID_ROUNDMD_ROUND = "@@@@AA1000000001R9TW"; // 03
																			// 四舍五入

	/*
	 * 科室类型SD
	 */
	public static final String SD_DEPTP_EN = "01"; // 01 就诊科室
	public static final String SD_DEPTP_OR = "02"; // 02 开单科室
	public static final String SD_DEPTP_WARD = "03"; // 03 护理病区

	/*
	 * 科室类型ID
	 */
	public static final String ID_DEPTP_EN = "@@@@AA1000000001TWCI"; // 01 就诊科室
	public static final String ID_DEPTP_OR = "@@@@AA1000000001TWCJ"; // 02 开单科室
	public static final String ID_DEPTP_WARD = "@@@@AA1000000001TWCK"; // 03
																		// 护理病区

	/*
	 * 服务剂型
	 */
	public static final String ID_DRUG_CAOYAO_DOSAGE = "@@@@AA1000000002ELPL";
	public static final String ID_DRUG_XICHENGYAO_DOSAGE = "@@@@AA1000000001ELPL";
	public static final String ID_DRUG_CAILIAO_DOSAGE = "@@@@AA1000000003ELPL";
	public static final String ID_DRUG_QITAJIXING_DOSAGE = "@@@@AA1000000000ELPL";

	public static final String CODE_DRUG_CAOYAO_DOSAGE = "2";
	public static final String CODE_DRUG_XICHENGYAO_DOSAGE = "1";
	public static final String CODE_DRUG_CAILIAO_DOSAGE = "3";
	public static final String CODE_DRUG_QITAJIXING_DOSAGE = "MISC";

	// 模板类型
	/// <summary>
	/// 成组西成药
	/// </summary>
	public static final String SD_ORTMPLTP_CZXCY = "01";
	/// <summary>
	/// 草药方剂
	/// </summary>
	public static final String SD_ORTMPLTP_CYFJ = "02";
	/// <summary>
	/// 复合模板
	/// </summary>
	public static final String SD_ORTMPLTP_FHMBA = "11";

	/// <summary>
	/// 复合模板
	/// </summary>
	// public static final String SD_ORTMPLTP_FHMB = "1";

	/// <summary>
	/// 检查模板
	/// </summary>
	public static final String SD_ORTMPLTP_RIS = "12";
	/// <summary>
	/// 检验模板
	/// </summary>
	public static final String SD_ORTMPLTP_LIS = "13";
	/// <summary>
	/// 诊疗模板
	/// </summary>
	public static final String SD_ORTMPLTP_TREAT = "14";

	// 物品绑定时机
	public static final String SD_MMBIND_DRAW = "0";
	public static final String SD_MMBIND_IMPL = "1";

	/**
	 * 非毒麻药品
	 */
	public static final String SD_POIS_NONTOXIC = "0";
	/**
	 * 麻醉药品
	 */
	public static final String SD_POIS_NARCOTIC = "1";
	/**
	 * 一类精神药品
	 */
	public static final String SD_POIS_ONETYPEPSYCHIC = "2";
	/**
	 * 二类精神药品
	 */
	public static final String SD_POIS_TWOTYPEPSYCHIC = "3";
	/**
	 * 毒性药品
	 */
	public static final String SD_POIS_TOXIC = "4";
	/**
	 * 放射性药品
	 */
	public static final String SD_POIS_RADOIACTIVITY = "5";

	/**
	 * 非抗菌药物
	 */
	public static final String SD_ANTI_NONANTIBACTERIAL = "0";
	/**
	 * 非限制使用级
	 */
	public static final String SD_ANTI_NONLIMITUSELEVEL = "1";
	/**
	 * 限制使用级
	 */
	public static final String SD_ANTI_LIMITUSELEVEL = "2";
	/**
	 * 特殊使用级
	 */
	public static final String SD_ANTI_SPECIALUSELEVEL = "3";

	/**
	 * 传染病种类
	 */
	public static final String ID_INFECTP_A = "@@@@Z8100000000VGOYS";// 甲类
	public static final String ID_INFECTP_B = "@@@@Z8100000000VGP43";// 乙类
	public static final String ID_INFECTP_C = "@@@@Z8100000000VGP5D";// 丙类
	public static final String ID_INFECTP_OTH = "@@@@Z8100000000VGP61";// 其他
	/**
	 * 传染病种类编码
	 */
	public static final String SD_INFECTP_A = "01";// 甲类
	public static final String SD_INFECTP_B = "02";// 乙类
	public static final String SD_INFECTP_C = "03";// 丙类
	public static final String SD_INFECTP_OTH = "99";// 其他
	/**
	 * 医保返回状态码
	 */
	public static final String SD_HP_JUDGE_METHOD_DOC_CONFIRM = "21";
	public static final String SD_HP_JUDGE_METHOD_NO_CONTROL = "01";
	public static final String SD_HP_JUDGE_METHOD_SYS_CONFIRM = "11";
	public static final String SD_HP_JUDGE_METHOD_SYS_JUD_DOCCONFIRM = "12";

	// 处方标识 id
	public static final String ID_PRESCRIPTION_FLAG_YB = "@@@@Z7100000000VZXUK";// 医保
	public static final String ID_PRESCRIPTION_FLAG_JZ = "@@@@Z7100000000VQYXL";// 急诊
	public static final String ID_PRESCRIPTION_FLAG_EK = "@@@@Z7100000000VQYXN";// 儿科
	public static final String ID_PRESCRIPTION_FLAG_MZJY = "@@@@Z7100000000VQYXP";// 麻醉精一
	public static final String ID_PRESCRIPTION_FLAG_VIP = "@@@@Z7100000000VQYYV";// VIP
	public static final String ID_PRESCRIPTION_FLAG_JE = "@@@@Z7100000000VQYXQ";// 精二
	public static final String ID_PRESCRIPTION_FLAG_JSY = "@@@@Z7100000000VQYXU";// 基数药
	public static final String ID_PRESCRIPTION_FLAG_WPY = "@@@@Z7100000000VQYY8";// 外配药
	public static final String ID_PRESCRIPTION_FLAG_TSB = "@@@@Z7100000000VQYY9";// 特殊病
	public static final String ID_PRESCRIPTION_FLAG_YFFBZ = "@@@@Z7100000000VQYZG";// 预付费标志
	public static final String ID_PRESCRIPTION_FLAG_KY = "@@@@Z7100000000VQYZK";// 科研
	public static final String ID_PRESCRIPTION_FLAG_SYBX = "@@@@Z7100000000VQYZQ";// 生育保险
	public static final String ID_PRESCRIPTION_FLAG_DXBZ = "@@@@Z7100000000VZXTA";// 毒性标志
	public static final String ID_PRESCRIPTION_FLAG_CY = "@@@@Z8100000000WFKH7";// 草药
	public static final String ID_PRESCRIPTION_FLAG_CYYP = "@@@@Z81000000009TY5Y";// 草药饮片
	public static final String ID_PRESCRIPTION_FLAG_CYKLJ = "@@@@Z81000000009TY5Z";// 草药颗粒剂
	public static final String ID_PRESCRIPTION_FLAG_MZ = "@@@@Z8100000000ETRAX";// 麻醉
	public static final String ID_PRESCRIPTION_FLAG_JY = "@@@@Z8100000000ETRAY";// 精一
	public static final String ID_PRESCRIPTION_FLAG_MXB = "@@@@Z8100000000GLMVR";// 慢性病

	// 处方标识sd
	public static final String SD_PRESCRIPTION_FLAG_YB = "01";// 医保
	public static final String SD_PRESCRIPTION_FLAG_JZ = "02";// 急诊
	public static final String SD_PRESCRIPTION_FLAG_EK = "03";// 儿科
	public static final String SD_PRESCRIPTION_FLAG_MZJY = "04";// 麻醉精一
	public static final String SD_PRESCRIPTION_FLAG_VIP = "09";// VIP
	public static final String SD_PRESCRIPTION_FLAG_JE = "05";// 精二
	public static final String SD_PRESCRIPTION_FLAG_JSY = "06";// 基数药
	public static final String SD_PRESCRIPTION_FLAG_WPY = "07";// 外配药
	public static final String SD_PRESCRIPTION_FLAG_TSB = "08";// 特殊病
	public static final String SD_PRESCRIPTION_FLAG_YFFBZ = "10";// 预付费标志
	public static final String SD_PRESCRIPTION_FLAG_KY = "11";// 科研
	public static final String SD_PRESCRIPTION_FLAG_SYBX = "12";// 生育保险
	public static final String SD_PRESCRIPTION_FLAG_DXBZ = "13";// 毒性标志
	public static final String SD_PRESCRIPTION_FLAG_CY = "14";// 草药
	public static final String SD_PRESCRIPTION_FLAG_CYYP = "15";// 草药饮片
	public static final String SD_PRESCRIPTION_FLAG_CYKLJ = "16";// 草药颗粒剂
	public static final String SD_PRESCRIPTION_FLAG_MZ = "17";// 麻醉
	public static final String SD_PRESCRIPTION_FLAG_JY = "18";// 精一
	public static final String SD_PRESCRIPTION_FLAG_MXB = "19";// 慢性病

	/**
	 * 草药制剂类型
	 */
	public static final String ID_HERB_PREPARATIONTP_YP = "@@@@Z81000000009JIJK";// 饮片
    public static final String ID_HERB_PREPARATIONTP_KL = "@@@@Z81000000009JIJL";// 颗粒
    public static final String ID_HERB_PREPARATIONTP_FJ = "@@@@Z8100000000ICSP8";// 粉剂

    public static final String SD_HERB_PREPARATIONTP_YP = "0";// 饮片
    public static final String SD_HERB_PREPARATIONTP_KL = "1";// 颗粒
    public static final String SD_HERB_PREPARATIONTP_FJ = "2";// 粉剂
	/**
	 * 剂型 : 草药作为特殊的剂型用于关联草药的用法因此作为SD
	 */
	public static final String ID_DOSAGE_HERB = "@@@@Z7100000000H8V84"; // 中草药

	public static final String SD_DOSAGE_HERB = "010103"; // 中草药

	/**
	 * 1775_新建
	 */
	public static final String SD_SU_MRTPL_NEW = "1";
	/**
	 * 1775_已启用
	 */
	public static final String SD_SU_MRTPL_ACTIVATE = "2";
	/**
	 * 1775_已停用
	 */
	public static final String SD_SU_MRTPL_DEACTIVATE = "3";
	/**
	 * 1775_撤回
	 */
	public static final String SD_SU_MRTPL_REVOKE = "4";
	/**
	 * 1775_提交
	 */
	public static final String SD_SU_MRTPL_SUBMIT = "5";
	/**
	 * 1775_已审批
	 */
	public static final String SD_SU_MRTPL_SIGNBY = "6";

	// 打印单据类型 类型 01 药品，02 检查，03检验 ，04 诊疗 TODO 以后会追加

	public static final String DRUG_TYPE = "01"; // 01 药品
	public static final String RIS_TYPE = "02";// 02 检查
	public static final String LIS_TYPE = "03";// 03检验
	public static final String TREATMENT_TYPE = "04";// 04 诊疗
	public static final String PATHGY_TYPE = "05";// 05 检查

	// 开单校验提示信息中的单位 草药为 付 西药为天
	public static final String ORDER_UNIT = "付";
	public static final String DAYS_UNIT = "天";
	/**
	 * 1770_新建
	 */
	public static final String SD_SU_BASEMRTPL_NEW = "0";
	/**
	 * 1770_启用
	 */
	public static final String SD_SU_BASEMRTPL_ENABLE = "1";
	/**
	 * 1770_停用
	 */
	public static final String SD_SU_BASEMRTPL_DISABLE = "2";

	/**
	 * 药品剂型 注射剂
	 */
	public static final String CODE_DOSAGE_SYRN = "SYRN";

	public static final String SD_MRTPLSTMD_DEDICATEDFORM = "2";
	public static final String SD_MRTPLSTMD_FILE = "3";
	public static final String SD_MRTPLSTMD_FILEANDXML = "0";
	public static final String SD_MRTPLSTMD_INTELLIGENTFORM = "1";

	/**
	 * 宏元素自定义
	 */
	public static final String SD_BD_MACRO_OS_WRITE = "01"; // 门诊书写
	public static final String SD_BD_MACRO_OS_PRINT = "02"; // 门诊打印
	public static final String SD_BD_MACRO_IPD_WRITE = "03"; // 住院书写
	public static final String SD_BD_MACRO_IPD_PRINT = "04"; // 住院打印
	public static final String SD_BD_MACRO_ET_WRITE = "05"; // 急诊书写
	public static final String SD_BD_MACRO_ET_PRINT = "06"; // 急诊打印

	// 手术等级
	public static final String ID_OP_SUG_LEVEL_ONE = "@@@@AA1000000004IXQP";// 一级
	public static final String ID_OP_SUG_LEVEL_TWO = "@@@@AA1000000004IXQQ";// 二级
	public static final String ID_OP_SUG_LEVEL_THREE = "@@@@AA1000000004IXQR";// 三级
	public static final String ID_OP_SUG_LEVEL_FOUR = "@@@@AA1000000004IXQS";// 四级

	public static final String SD_OP_SUG_LEVEL_CODE_IE_ONE = "4";// 一级
	public static final String SD_OP_SUG_LEVEL_CODE_IE_TWO = "3";// 二级
	public static final String SD_OP_SUG_LEVEL_CODE_IE_THREE = "2";// 三级
	public static final String SD_OP_SUG_LEVEL_CODE_IE_FOUR = "1";// 四级

	// 1965 总量开单方式
	/**
	 * 按周期开立
	 */
	public static final String SD_TOTALOPENMODE_CYCLE = "0";

	/**
	 * 按总次数开立
	 */
	public static final String SD_TOTALOPENMODE_TOTALNUM = "1";

	/**
	 * 特殊级抗菌药会诊审批结果
	 */
	public static final String ID_SPECONS_RST_AGREE = "@@@@Z8100000000A3TQU";// 同意
	public static final String ID_SPECONS_RST_REJECT = "@@@@Z8100000000A3TQT";// 不同意

	public static final String SD_SPECONS_RST_AGREE = "0";// 同意
	public static final String SD_SPECONS_RST_REJECT = "1";// 不同意

	/**
	 * 未审批 (医嘱审批状态 )
	 */
	public static final String ORDER_APPROVAL_NOTEXAMINED = "0";
	/**
	 * 审批通过 (医嘱审批状态)
	 */
	public static final String ORDER_APPROVAL_AGREE = "1";
	/**
	 * 审批驳回 (医嘱审批状态)
	 */
	public static final String ORDER_APPROVAL_REJECT = "2";

	// / <summary>
	// / BD.WF.0520 星期_自定义档案
	// / </summary>
	public static final String ID_WEEK_MONDAY = "@@@@Z8100000000Q594S";// 周一
	public static final String ID_WEEK_TUESDAY = "@@@@Z8100000000Q594T";// 周二
	public static final String ID_WEEK_WEDNESDAY = "@@@@Z8100000000Q594U";// 周三
	public static final String ID_WEEK_THURSDAY = "@@@@Z8100000000Q594V";// 周四
	public static final String ID_WEEK_FRIDAY = "@@@@Z8100000000Q594W";// 周五
	public static final String ID_WEEK_SATURDAY = "@@@@Z8100000000Q594X";// 周六
	public static final String ID_WEEK_SUNDAY = "@@@@Z8100000000Q594Y";// 周日

	public static final String SD_WEEK_MONDAY = "01";// 周一
	public static final String SD_WEEK_TUESDAY = "02";// 周二
	public static final String SD_WEEK_WEDNESDAY = "03";// 周三
	public static final String SD_WEEK_THURSDAY = "04";// 周四
	public static final String SD_WEEK_FRIDAY = "05";// 周五
	public static final String SD_WEEK_SATURDAY = "06";// 周六
	public static final String SD_WEEK_SUNDAY = "07";// 周日

	// / <summary>
	// / BD.WF.0520 人员聘任职称_自定义档案
	// / </summary>
	public static final String ID_EMPLOYMEN_TTITLE = "@@@@ZZ2000000000003V";// 职称档单编码

	// 1975 对照编码标准
	/**
	 * 临床外部编码标准
	 */
	public static final String SD_CDSTD_CLINICAL = "100";
	/**
	 * 价表外部编码标准
	 */
	public static final String SD_CDSTD_PRICE = "200";
	/**
	 * 物价（外部）标准编码
	 */
	public static final String SD_CDSTD_PRICE_PRICE = "201";

	// 1990 关联服务执行流向模式
	/**
	 * 医嘱跟随
	 */
	public static final String SD_MPDEPCALMD_FOLLOW = "01";
	/**
	 * 流向模式
	 */
	public static final String SD_MPDEPCALMD_USG_FLOW = "02";
	/**
	 * 就诊科室
	 */
	public static final String SD_MPDEPCALMD_USG_ENTDEP = "03";
	/**
	 * 就诊病区
	 */
	public static final String SD_MPDEPCALMD_USG_ENTWARD = "04";
	/**
	 * 开单科室
	 */
	public static final String SD_MPDEPCALMD_USG_OPENORDDEP = "05";
}
