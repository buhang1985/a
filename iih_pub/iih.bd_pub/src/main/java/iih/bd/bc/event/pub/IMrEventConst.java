package iih.bd.bc.event.pub;

public interface IMrEventConst {

	public static final String EVENT_SOURCE_MR_AMR_COMPLETE = "MR_AMR_COMPLETE";// 完成病历

	public static final String EVENT_SOURCE_MR_FP_COMPLETE = "MR_FP_COMPLETE";// 完成首页
	
	public static final String EVENT_SOURCE_MR_ZYFP_COMPLETE = "MR_ZYFP_COMPLETE";// 中医住院病案首页信息服务

	public static final String EVENT_SOURCE_MR_MR_RCY24 = "MR_RCY24";// 24小时入出院记录信息服务

	public static final String EVENT_SOURCE_MR_MR_RCY24SW = "MR_RCY24SW";// 24小时死亡记录信息服务

	public static final String EVENT_SOURCE_MR_MR_RYJL = "MR_RYJL";// 入院记录信息服务

	public static final String EVENT_SOURCE_MR_MR_CYXJ = "MR_CYXJ";// 出院小结信息服务

	public static final String EVENT_SOURCE_MR_MR_SSJL = "MR_SSJL";// 手术操作记录信息服务

	public static final String EVENT_SOURCE_MR_MR_SWJL = "MR_SWJL";// 死亡记录信息服务

	public static final String EVENT_SOURCE_MR_MR_RCBC = "MR_RCBC";// 病程记录信息服务
	
	public static final String EVENT_SOURCE_MR_MR_JDXJ = "MR_JDXJ";// 阶段小结信息服务
	
	public static final String EVENT_SOURCE_MR_MR_QJJL = "MR_QJJL";// 抢救记录信息服务
	
	public static final String EVENT_SOURCE_MR_MR_ZKJL = "MR_ZKJL";// 转科记录信息服务
	
	public static final String EVENT_SOURCE_MR_MR_HZJL = "MR_HZJL";// 会诊记录信息服务
	
	public static final String EVENT_SOURCE_MR_MR_SQXJ = "MR_SQXJ";// 术前小结信息服务
	
	public static final String EVENT_SOURCE_MR_MR_CYJL = "MR_CYJL";// 出院记录信息服务
	
	public static final String EVENT_SOURCE_MR_MR_SCBC = "MR_SCBC";// 首次病程信息服务
	
	public static final String EVENT_SOURCE_MR_MR_JJBJL = "MR_JJBJL";// 交接班记录信息服务
	
	public static final String EVENT_SOURCE_MR_MR_SHSCBCJL = "MR_SHSCBCJL";// 术后首次病程记录信息服务
	
	public static final String EVENT_SOURCE_MR_MR_YNWZBLTL = "MR_YNWZBLTL";// 疑难危重病例讨论信息服务
	
	public static final String EVENT_SOURCE_MR_MR_SJYSCFJL = "MR_SJYSCFJL";// 上级医师查房记录信息服务

	public static final String EVENT_SOURCE_MR_MR_ZQTY = "MR_ZQTY";// 知情同意和讨论记录信息服务
	
	public static final String EVENT_SOURCE_MR_MR_SSZQTY = "MR_SSZQTY";// 手术知情同意书信息服务
	
	public static final String EVENT_SOURCE_MR_MR_MZZQTY = "MR_MZZQTY";// 麻醉知情同意书信息服务
	
	public static final String EVENT_SOURCE_MR_MR_SXZLZQTY = "MR_SXZLZQTY";// 输血或血液制品治疗知情同意书信息服务
	
	public static final String EVENT_SOURCE_MR_MR_TSJCTY = "MR_TSJCTY";// 特殊检查同意书信息服务
	
	public static final String EVENT_SOURCE_MR_MR_BWZTZ = "MR_BWZTZ";// 病危（重）通知书信息服务
	
	public static final String EVENT_SOURCE_MR_MR_QTZQTY = "MR_QTZQTY";// 其他知情同意书信息服务

	public static final String EVENT_SOURCE_MR_MR_MJZBL = "MR_MJZBL";// 门急诊病历信息服务

	public static final String EVENT_SOURCE_MR_MR_JZLG = "MR_JZLG";// 急诊留观记录信息服务

	public static final String EVENT_SOURCE_MR_MR_SQTL = "MR_SQTL";// 术前讨论记录信息服务

	public static final String EVENT_SOURCE_MR_MR_SWTL = "MR_SWTL";// 死亡讨论记录信息服务

	public static final String EVENT_SOURCE_MR_REPORT_PASS = "MR_REPORT_PASS";// 院感审核后

	public static final String EVENT_SOURCE_MR_CONTAGION_PASS = "MR_CONTAGION_PASS";// 传染病审核后\

	public static final String EVENT_SOURCE_MR_DEATHCERT_PASS = "MR_DEATHCERT_PASS";// 死亡证明书审核后

	public static final String EVENT_SOURCE_MR_BILLTYPE_ZDLB = "EVENT_SOURCE_MR_BILLTYPE_ZDLB";// 账单类别信息服务

	public static final String EVENT_SOURCE_MR_REPORT_PASS2 = "4666";// 院感审核后
	
	public static final String EVENT_SOURCE_MR_MR_BLGY = "MR_BLGY";// 病历概要信息服务
	
	public static final String MR_FP_INCICONDI_MSG = "MR_FP_INCICONDI_MSG";// 手术切口愈合等级代码数据更新通知服务
	
	public static final String EVENT_SOURCE_MR_MR_MZJL = "MR_MZJL";// 麻醉记录信息服务
	
	public static final String EVENT_SOURCE_MR_UPLOAD = "MR_UPLOAD";// 病历内容上传集成平台统一服务
	
	public static final String EVENT_SOURCE_MR_AUTO_UPLOAD = "iih.en.que.dto.d.OpQue4EsDTO";// 自动诊毕时门诊病历上传集成平台服务
	
	public static final String EVENT_SOURCE_MR_SUBMIT = "MR_SUBMIT";// 单篇病历提交
	
	public static final String EVENT_SOURCE_MRFP_SUBMIT = "MRFP_SUBMIT";// 病案首页提交
	
	public static final String EVENT_SOURCE_MR_SAVED = "MR_SAVED";// 单篇病历保存
	
	public static final String EVENT_SOURCE_MR_DELETE = "MR_DELETE";// 单篇病历保存
	
}