package iih.ci.mr.pub.MrConst;

public interface IMrPubConst {

	public static final String NOCAT = "0";
	public static final String MZ = "01";
	public static final String ZY = "02";
	public static final String QT = "03";
	public static final String TY = "04";
	public static final String DZBL = "09";
	/*
	 * 数据集
	 */
	public static final String DS_RCY24 = "HDSD00.13.02";// 24小时入出院记录
	public static final String DS_RCY24SW = "HDSD00.13.03";// 24小时死亡记录
	public static final String DS_RYJL = "HDSD00.13.01";// 初次入院记录
	public static final String DS_CYXJ = "HDSD00.16.01";// 出院小结
	public static final String DS_SSJL = "HDSD00.06.02";// 手术记录子集==手术操作记录信息服务
	public static final String DS_ZLJL = "HDSD00.06.01";// 治疗记录子集
	public static final String DS_ZQTY1 = "HDSD00.10.01";// 手术同意书子集
	public static final String DS_ZQTY2 = "HDSD00.10.02";// 麻醉知情同意书子集
	public static final String DS_ZQTY3 = "HDSD00.10.03";// 输血治疗同意书子集
	public static final String DS_ZQTY4 = "HDSD00.10.04";// 特殊检查及特殊治疗同意书子集
	public static final String DS_ZQTY5 = "HDSD00.10.05";// 病危(重)通知书子集
	public static final String DS_ZQTY6 = "HDSD00.10.06";// 其他知情同意书子集s
	public static final String DS_MJZBL = "HDSD00.03.01";// 门急诊病历
	public static final String DS_JZLG = "HDSD00.03.02";// 急诊留观
	public static final String DS_SWJL = "HDSD00.14.14";// 死亡记录
	public static final String DS_SQTL = "HDSD00.14.11";// 术前讨论
	public static final String DS_SWTL = "HDSD00.14.15";// 死亡讨论
	public static final String DS_BCJL1 = "HDSD00.14.01";// 首次病程
	public static final String DS_BCJL2 = "HDSD00.14.02";// 日常病程
	public static final String DS_BCJL3 = "HDSD00.14.03";// 上级查房
	public static final String DS_BCJL4 = "HDSD00.14.04";// 疑难病例讨论子集
	public static final String DS_BCJL5 = "HDSD00.14.05";// 交接班记录子集
	public static final String DS_BCJL6 = "HDSD00.14.06";// 转科记录子集
	public static final String DS_BCJL7 = "HDSD00.14.07";// 阶段小结子集
	public static final String DS_BCJL8 = "HDSD00.14.08";// 抢救记录子集
	public static final String DS_BCJL9 = "HDSD00.14.09";// 会诊记录子集
	public static final String DS_BCJL10 = "HDSD00.14.10";// 术前小结子集
	public static final String DS_BCJL11 = "HDSD00.14.12";// 术后首次病程记录子集
	public static final String DS_BCJL12 = "HDSD00.14.13";// 出院记录子集
	public static final String DS_RCBC = "HDSD00.14.02";// 日常病程
	public static final String DS_SCBC = "HDSD00.14.01";// 首次病程
	public static final String DS_SSFX = "HDSD00.50.01";// 手术风险评估表
	public static final String DS_PJFX = "HDSD00.50.02";// 住院超过30天评价分析表
	public static final String DS_BLGY_HZJBXX = "HDSD00.02.01";// 患者基本信息子集
	public static final String DS_BLGY_JBJKXX = "HDSD00.02.02";// 基本健康信息子集
	public static final String DS_BLGY_WSZYSJ = "HDSD00.02.03";// 卫生摘要事件子集
	public static final String DS_BLGY_YLFYJL = "HDSD00.02.04";// 医疗费用记录子集
	public static final String DS_MZJL = "HDSD00.06.04";// 麻醉记录子集
	/*
	 * 公共数据元编码
	 */
	public static final String DG_ZS = "S.01";// 主诉
	public static final String DG_XBS = "S.03";// 现病史
	public static final String DG_JWS = "S.04";// 既往史
	public static final String DG_GMS = "S.04.006";// 过敏史
	public static final String DG_JZS = "S.04.013";// 家族史
	public static final String DG_GRS = "S.04.009";// 个人史
	public static final String DG_HYS = "S.04.010";// 婚育史
	public static final String DG_TGJC = "S.02";// 体格检查
	public static final String DG_ZKJC = "F.05.001";// 专科检查
	public static final String DG_FZJC = "F.05.002";// 辅助检查
	public static final String DG_BCJL = "S.12.001";// 病程记录
	public static final String DG_ZQGZ = "S.10.002";// 知情告知
	public static final String DG_SSS = "S.04.002";// 手术史
	public static final String DG_CRB = "S.03.001";// 传染病（史）
	public static final String DG_YFJZ = "S.09.001";// 预防接种（史）
	public static final String DG_SXS = "S.04.004";// 输血史
	public static final String DG_YJS = "S.04.011";// 月经史
	public static final String DG_SMTZXX = "MR.NU.0102";// 生命体征信息
	public static final String DG_ZYSZ = "S.16";// 中医四诊
	public static final String DG_ZLJG = "S.11.001";// 治疗结果
	public static final String DG_ZLGC = "S.12";// 诊疗过程
	public static final String DG_YZ = "S.12.002";// 医嘱
	public static final String DG_SS = "S.08.001";// 手术
	public static final String DG_SWSJ = "DE02.01.036.00";// 死亡时间
	public static final String DG_SSJG = "CARERECORD.054";// 手术经过
	public static final String DG_SZXM = "CARERECORD.056";// 术者姓名
	public static final String DG_JBMC = "DE05.01.025.00";// 疾病诊断名称
	public static final String DG_SSRQ = "CARERECORD.073";// 手术日期
	public static final String DG_SSKSSJ = "iform.mrfp.ope.002";// 手术开始时间
	public static final String DG_SSJSSJ = "iform.mrfp.ope.003";// 手术结束时间
	public static final String DG_SSJBMC = "iform.mrfp.ope.004";// 手术级别名称
	public static final String DG_RYQK = "iform.mrfp.diag.004";// 入院情况
	public static final String DG_CYQK = "FD01.01.028.00";// 出院情况
	public static final String DG_RYZD = "FD03.OPD.014.08";// 入院诊断
	public static final String DG_CYZD = "NEWBORNLEAVE.27";// 出院诊断
	public static final String DG_CYYZ = "NEWBORN.063";// 出院医嘱（使用出院建议的数据元）
	public static final String DG_TW = "DE04.10.186.00";// 体温
	public static final String DG_MB = "DE20.00.002.00";// 脉搏
	public static final String DG_HXPL = "DE04.10.082.00";// 呼吸频率
	public static final String DG_SSY = "DE04.10.174.00";// 收缩压
	public static final String DG_SZY = "DE04.10.176.00";// 舒张压
	public static final String DG_SG = "DE04.10.167.00";// 身高
	public static final String DG_TZ = "DE04.10.188.00";// 体重
	public static final String DG_TGJC_YBZK = "DE04.10.219.00";// 体格检查：一般状况检查结果
	public static final String DG_TGJC_PFHNM = "DE04.10.126.00";// 体格检查：皮肤和粘膜检查结果
	public static final String DG_TGJC_QBLBJ = "DE04.10.155.00";// 体格检查：浅表淋巴结检查结果
	public static final String DG_TGJC_TBJQQG = "DE04.10.199.00";// 体格检查：五官检查结果（头部及其器官检查结果）
	public static final String DG_TGJC_JB = "DE04.10.103.00";// 体格检查：颈部包块检查结果（颈部检查结果）
	public static final String DG_TGJC_XB = "DE04.30.045.00";// 体格检查：胸部X线检查结果（胸部检查结果）
	public static final String DG_TGJC_FB = "DE04.10.046.00";// 体格检查：腹部检查结果
	public static final String DG_TGJC_GMZZ = "DE04.10.065.00";// 体格检查：肛门指诊检查结果
	public static final String DG_TGJC_WSZQ = "DE04.10.195.00";// 体格检查：外生殖器检查结果
	public static final String DG_TGJC_JZ = "DE04.10.093.00";// 体格检查：脊柱检查结果
	public static final String DG_TGJC_SZ = "DE04.10.179.00";// 体格检查：四肢检查结果
	public static final String DG_TGJC_SJXT = "DE04.30.037.00";// 体格检查：神经肌电图检查结果（神经系统检查结果）
	public static final String DG_ZKQK = "FD01.12.400.34";// 专科情况
	public static final String DG_SWYY = "FD01.12.600.16";// 死亡原因
	public static final String DG_SSMC = "CARERECORD.055";// 手术名称
	public static final String DG_SSCXL = "DE06.00.097.00";// 手术出血量
	public static final String DG_SXL = "PACU.005";// 输血（量）
	public static final String DG_SYL = "DE20.00.052.00";// 输液量
	public static final String DG_ZYSX = "NOTFCBOOK.005";// 注意事项
	public static final String DG_ZZKSSJ = "DE04.01.005.00";// 症状开始时间
	public static final String DG_ZZJSSJ = "DE04.01.005.01";// 症状结束时间
	public static final String DG_ZZMS = "DE04.01.117.00";// 症状描述
	public static final String DG_ZLJH = "S.10";// 诊疗计划
	public static final String DG_MZFS = "iform.mrfp.ope.010";// 麻醉方式
	public static final String DG_MZYS = "iform.mrfp.ope.011";// 麻醉医师
	public static final String DG_SSTW = "OPEPRESSURE.014";// 手术体位
	public static final String DG_NSSSS = "OPEPRESSURE.001";// 拟实施手术
	public static final String DG_SYSJC = "DE04.50.128.00";// 实验室检查信息
	public static final String DG_GMSBZ = "DE02.10.023.00";// 过敏史标志代码
	public static final String DG_CZBZ = "DE06.00.196.00";// 初诊标志
	public static final String DG_BZYJMS = "DE05.10.132.00";// 辩证依据描述
	public static final String DG_ZZZZ = "DE06.00.300.00";// 治则治法
	public static final String DG_JPTY = "DE09.00.115.00";// 解剖同意
	/*
	 * 报卡类型-可用属性定义名称
	 */
	public static final String DB_ZJSWYY = "直接死亡原因";
	/*
	 * 数据集、病历服务及业务事件的对应关系，用于病历内容上传
	 * 数据格式： 数据集编码:服务编码:事件编码
	 * （常量名称的后缀尽量与数据集常量名称的后缀一致）
	 */
	public static final String US_RCY24 = "HDSD00.13.02:BS344:MR_RCY24";// 24小时入出院记录
	public static final String US_RCY24SW = "HDSD00.13.03:BS345:MR_RCY24SW";// 24小时死亡记录
	public static final String US_RYJL = "HDSD00.13.01:BS335:MR_RYJL";// 初次入院记录
	public static final String US_CYXJ = "HDSD00.16.01:BS341:MR_CYXJ";// 出院小结
	public static final String US_SSJL = "HDSD00.06.02:BS337:MR_SSJL";// 手术记录
	public static final String US_ZQTY1 = "HDSD00.10.01:BS428:MR_SSZQTY";// 手术同意书
	public static final String US_ZQTY2 = "HDSD00.10.02:BS429:MR_MZZQTY";// 麻醉知情同意书
	public static final String US_ZQTY3 = "HDSD00.10.03:BS430:MR_SXZLZQTY";// 输血治疗同意书
	public static final String US_ZQTY4 = "HDSD00.10.04:BS431:MR_TSJCTY";// 特殊检查及特殊治疗同意书
	public static final String US_ZQTY5 = "HDSD00.10.05:BS432:MR_BWZTZ";// 病危(重)通知书
	public static final String US_ZQTY6 = "HDSD00.10.06:BS433:MR_QTZQTY";// 其他知情同意书
	public static final String US_MJZBL = "HDSD00.03.01:BS333:MR_MJZBL";// 门急诊病历
	public static final String US_JZLG = "HDSD00.03.02:BS339:MR_JZLG";// 急诊留观病历
	public static final String US_SWJL = "HDSD00.14.14:BS343:MR_SWJL";// 死亡记录
	public static final String US_SQTL = "HDSD00.14.11:BS370:MR_SQTL";// 术前讨论
	public static final String US_SWTL = "HDSD00.14.15:BS373:MR_SWTL";// 死亡讨论
	public static final String US_BCJL1 = "HDSD00.14.01:BS408:MR_SCBC";// 首次病程
	public static final String US_BCJL2 = "HDSD00.14.02:BS336:MR_RCBC";// 日常病程
	public static final String US_BCJL3 = "HDSD00.14.03:BS381:MR_SJYSCFJL";// 上级查房
	public static final String US_BCJL4 = "HDSD00.14.04:BS372:MR_YNWZBLTL";// 疑难病例讨论
	public static final String US_BCJL5 = "HDSD00.14.05:BS446:MR_JJBJL";// 交接班记录
	public static final String US_BCJL6 = "HDSD00.14.06:BS383:MR_ZKJL";// 转科记录
	public static final String US_BCJL7 = "HDSD00.14.07:BS384:MR_JDXJ";// 阶段小结
	public static final String US_BCJL8 = "HDSD00.14.08:BS385:MR_QJJL";// 抢救记录
	public static final String US_BCJL9 = "HDSD00.14.09:BS340:MR_HZJL";// 会诊记录
	public static final String US_BCJL10 = "HDSD00.14.10:BS375:MR_SQXJ";// 术前小结
	public static final String US_BCJL11 = "HDSD00.14.12:BS386:MR_SHSCBCJL";// 术后首次病程记录
	public static final String US_BCJL12 = "HDSD00.14.13:BS371:MR_CYJL";// 出院记录
	public static final String US_BLGY_HZJBXX = "HDSD00.02.01:BS426:MR_BLGY";// 患者基本信息
	public static final String US_BLGY_JBJKXX = "HDSD00.02.02:BS426:MR_BLGY";// 基本健康信息
	public static final String US_BLGY_WSZYSJ = "HDSD00.02.03:BS426:MR_BLGY";// 卫生摘要事件
	public static final String US_BLGY_YLFYJL = "HDSD00.02.04:BS426:MR_BLGY";// 医疗费用记录
	public static final String US_MZJL = "HDSD00.06.04:BS327:MR_MZJL";// 麻醉记录
	/*
	 * 参数
	 */
	public static final String PARAM_CDSSDLLWAY = "CdssDllWay";
	public static final String PARAM_CDSSADDR = "CdssAddr";
	public static final String PARAM_CDSSKEY = "CdssKey";
	public static final String PARAM_CDSSCLASSWAY = "CdssClassWay";

}
