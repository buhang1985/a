package iih.bd.bc.udi.pub;

/**
 * 医疗记录字典编码常量定义
 * 
 * @author hao_wu
 *
 */
public class ICiMrDictCodeConst {

	/*
	 * 医疗记录自定义分类
	 */
	public static final String ID_MRCACTM_RUYUAN = "01AMMMMMMMMMRM140002";// 入院记录
	public static final String CD_MRCACTM_RUYUAN = "A.01.01";// 入院记录

	public static final String ID_MRCACTM_BINGCHENG = "01AMMMMMMMMMRM140003";// 病程记录
	public static final String CD_MRCACTM_BINGCHENG = "A.01.02";// 病程记录

	public static final String ID_MRCACTM_HUIZHEN = "01AMMMMMMMMMRM140004";// 会诊记录
	public static final String CD_MRCACTM_HUIZHEN = "A.01.03";// 会诊记录

	public static final String ID_MRCACTM_SHOUSHU = "01AMMMMMMMMMRM140005";// 手术资料
	public static final String CD_MRCACTM_SHOUSHU = "A.01.04";// 手术资料

	public static final String ID_MRCACTM_ZHIQING = "01AMMMMMMMMMRM140008";// 知情同意书
	public static final String CD_MRCACTM_ZHIQING = "A.01.05";// 知情同意书

	public static final String ID_MRCACTM_CHUYUAN = "01AMMMMMMMMMRM140009";// 出院(死亡)记录
	public static final String CD_MRCACTM_CHUYUAN = "A.01.06";// 出院(死亡)记录

	/*
	 * 病历文书状态
	 */
	public static final String ID_MRTYPE_RUYUAN = "0001AA1000000004Z001";// 初次入出院记录
	public static final String CD_MRTYPE_RUYUAN = "F.HDSD00.13.01";// 初次入出院记录

	public static final String ID_MRTYPE_BINGCHENG = "0001AA1000000004Z007";// 首次病程记录
	public static final String CD_MRTYPE_BINGCHENG = "F.HDSD00.14.01";// 首次病程记录

	public static final String ID_MRTYPE_SHOUCICHAFANG = "0001AA1000000004Z009";// 上级首次查房记录
	public static final String CD_MRTYPE_SHOUCICHAFANG = "F.HDSD00.14.03";// 上级首次查房记录

	public static final String ID_MRTYPE_HUIZHEN = "0001AA1000000004Z020";// 会诊记录
	public static final String CD_MRTYPE_HUIZHEN = "F.HDSD00.14.09";// 会诊记录

	public static final String ID_MRTYPE_JIAOBAN = "0001AA1000000004Z012";// 交班记录
	public static final String CD_MRTYPE_JIAOBAN = "F.HDSD00.14.05";// 交班记录

	public static final String ID_MRTYPE_JIEBAN = "0001AA1000000004Z013";// 交班记录
	public static final String CD_MRTYPE_JIEBAN = "F.F.HDSD00.14.05.02";// 交班记录

	public static final String ID_MRTYPE_ZHUANCHU = "0001AA1000000004Z014";// 转出记录
	public static final String CD_MRTYPE_ZHUANCHU = "F.HDSD00.14.06";// 转出记录

	public static final String ID_MRTYPE_ZHUANRU = "0001AA1000000004Z015";// 转入记录
	public static final String CD_MRTYPE_ZHUANRU = "F.HDSD00.14.06.02";// 转入记录

	public static final String ID_MRTYPE_QIANGJIU = "0001AA1000000004Z017";// 抢救记录
	public static final String CD_MRTYPE_QIANGJIU = "F.HDSD00.14.08";// 抢救记录

	public static final String ID_MRTYPE_SHOUSHU = "0001AA1000000004Z023";// 手术记录
	public static final String CD_MRTYPE_SHOUSHU = "F.HDSD00.06.02";// 手术记录

	public static final String ID_MRTYPE_SHOUSHUQINGDIAN = "0001AA1000000004Z024";// 手术清点记录
	public static final String CD_MRTYPE_SHOUSHUQINGDIAN = "F.HDSD00.06.02.02";// 手术清点记录

	public static final String ID_MRTYPE_SHOUSHUHECHA = "0001AA1000000004Z025";// 手术安全核查记录
	public static final String CD_MRTYPE_SHOUSHUHECHA = "F.HDSD00.06.02.03";// 手术安全核查记录

	public static final String ID_MRTYPE_SHOUSHUZHIQING = "0001AA1000000004Z032";// 手术知情同意书
	public static final String CD_MRTYPE_SHOUSHUZHIQING = "F.HDSD00.10.01";// 手术知情同意书

	public static final String ID_MRTYPE_MAZUI = "0001AA1000000004Z022";// 麻醉记录
	public static final String CD_MRTYPE_MAZUI = "F.HDSD00.06.04";// 麻醉记录

	public static final String ID_MRTYPE_SIWANG = "0001AA1000000004Z030";// 死亡记录
	public static final String CD_MRTYPE_SIWANG = "F.HDSD00.14.14";// 死亡记录

	public static final String ID_MRTYPE_SIWANGTAOLUN = "0001AA1000000004Z031";// 死亡病例讨论记录
	public static final String CD_MRTYPE_SIWANGTAOLUN = "F.HDSD00.14.15";// 死亡病例讨论记录

	public static final String ID_MRTYPE_BINGWEI = "0001AA1000000004Z035";// 病危
	public static final String CD_MRTYPE_BINGWEI = "F.HDSD00.10.05";// 病危

	public static final String ID_MRTYPE_CHUYUAN = "0001AA1000000004Z029";// 出院记录
	public static final String CD_MRTYPE_CHUYUAN = "F.HDSD00.14.13";// 出院记录

	/*
	 * 病历任务状态
	 */
	public static final String ID_MRTASKSTA_TODO = "@@@@AA1000000006JWLT"; // 未完成
	public static final String SD_MRTASKSTA_TODO = "00"; // 未完成
	public static final String ID_MRTASKSTA_DONE = "@@@@AA1000000006JWLU"; // 已完成
	public static final String SD_MRTASKSTA_DONE = "01"; // 已完成
	public static final String ID_MRTASKSTA_DONENO = "@@@@AA1000000006JWLV"; // 逾期已完成
	public static final String SD_MRTASKSTA_DONENO = "02"; // 逾期已完成
	public static final String ID_MRTASKSTA_CANCEL = "@@@@AA1000000006JWLW"; // 取消
	public static final String SD_MRTASKSTA_CANCEL = "03"; // 取消
	/**
	 * 病案状态
	 */
	// 书写中
	public static final String ID_MR_WRITING = "@@@@AA1000000000099S";// 书写中
	public static final String SD_MR_WRITING = "00";// 书写中
	// 书写完成
	public static final String ID_MR_COMWRITE = "@@@@AA1000000000099T";// 书写完成
	public static final String SD_MR_COMWRITE = "01";// 书写完成
	// 已科室质控
	public static final String ID_MR_COMDEPTQC = "@@@@AA1000000000099U";// 已科室质控
	public static final String SD_MR_COMDEPTQC = "02";// 已科室质控
	// 已科室评分
	public static final String ID_MR_COMDEPTSCORE = "@@@@AA1000000000099V";// 已科室评分
	public static final String SD_MR_COMDEPTSCORE = "03";// 已科室评分
	// 已签收
	public static final String ID_MR_COMSIGNOFF = "@@@@AA1000000000099W";// 已签收
	public static final String SD_MR_COMSIGNOFF = "04";// 已签收
	// 已终末质控
	public static final String ID_MR_COMTERMINALQC = "@@@@AA1000000000099X";// 已终末质控
	public static final String SD_MR_COMTERMINALQC = "05";// 已终末质控
	// 已终末评分
	public static final String ID_MR_COMTERMINALSCORE = "@@@@AA1000000000099Y";// 已终末评分
	public static final String SD_MR_COMTERMINALSCORE = "06";// 已终末评分
	// 病案已签收
	public static final String ID_MR_HASSIGNED = "@@@@AA1000000000099Z";
	public static final String SD_MR_HASSIGNED = "07";
	// 病案已编目
	public static final String ID_MR_HASTOCODE = "@@@@AA100000000009A0";
	public static final String SD_MR_HASTOCODE = "08";
	// 病案已归档
	public static final String ID_MR_HASTOFILE = "@@@@AA1000000009AUUR";
	public static final String SD_MR_HASTOFILE = "09";
	// 就诊诊毕
	public static final String ID_MR_ENOVER = "@@@@Z7100000000GROS6";
	public static final String SD_MR_ENOVER = "20";
	/**
	 * 质控
	 */
	// 环节质控
	public static final String ID_EXEC_SEGMENT = "@@@@AA1000000003THUI";
	public static final String SD_EXEC_SEGMENT = "01";
	// 科室质控
	public static final String ID_EXEC_DEPARTMENT = "@@@@AA1000000003THUJ";
	public static final String SD_EXEC_DEPARTMENT = "02";
	// 终末质控
	public static final String ID_EXEC_END = "@@@@AA1000000003THUK";
	public static final String SD_EXEC_END = "03";
	// 自动质控
	public static final String ID_EXEC_AUTOMATIC = "@@@@AA1000000003THUL";
	public static final String SD_EXEC_AUTOMATIC = "04";
	// 质控人：系统id_sbmt_user
	public static final String ID_SBMT_USER = "@@@@AA10000000000000";
	public static final String CD_SBMT_USER = "000000";
	// 门诊质控
	public static final String ID_EXEC_OUTQC = "@@@@Z8100000000PFF92";
	public static final String SD_EXEC_OUTQC = "05";
	// 门诊部质控
	public static final String ID_EXEC_OPDOUTQC = "@@@@Z8100000000Q8JV2";
	public static final String SD_EXEC_OPDOUTQC = "06";
	/**
	 * 门诊抽查质控状态
	 */
	// 已抽查
	public static final String ID_MR_RANDOMQCCHECK_HASCHECK = "@@@@Z7100000000H3EHP";
	public static final String SD_MR_RANDOMQCCHECK_HASCHECK = "00";
	// 待整改
	public static final String ID_MR_RANDOMQCCHECK_NEEDCORRECT = "@@@@Z7100000000H3EHQ";
	public static final String SD_MR_RANDOMQCCHECK_NEEDCORRECT = "01";
	// 待审核
	public static final String ID_MR_RANDOMQCCHECK_NEEDEXAMINE = "@@@@Z7100000000NB6KA";
	public static final String SD_MR_RANDOMQCCHECK_NEEDEXAMINE = "02";
	// 审核通过
	public static final String ID_MR_RANDOMQCCHECK_EXAMINEPASS = "@@@@Z8100000000LY0C8";
	public static final String SD_MR_RANDOMQCCHECK_EXAMINEPASS = "03";
	//已质控
    public static final String ID_MR_RANDOMQCCHECK_HASQC = "@@@@Z8100000000PG05X";
    public static final String SD_MR_RANDOMQCCHECK_HASQC = "04";
    public static final String NAME_MR_RANDOMQCCHECKK_HASQC = "已质控";
	/**
	 * 整改通知
	 */
	// 待整改
	public static final String ID_TO_REFORM = "@@@@AA1000000003ZY3O";
	public static final String SD_TO_REFORM = "01";
	// 整改中
	public static final String ID_RECTIFICATION = "@@@@AA1000000003ZY3P";
	public static final String SD_RECTIFICATION = "02";
	// 已整改
	public static final String ID_HAS_RECTIFICATION = "@@@@AA1000000003ZY3Q";
	public static final String SD_HAS_RECTIFICATION = "03";
	// 已审核
	public static final String ID_AUDIT = "@@@@AA1000000003ZY3R";
	public static final String SD_AUDIT = "04";
	// 无需整改
	public static final String ID_NOTCHANGE = "@@@@Z8100000001UF0E4";
	public static final String SD_NOTCHANGE = "05";
	
	/**
	 * 缺陷通知
	 */
	// 待整改
	public static final String ID_REFORM = "@@@@AA1000000003THUM";
	public static final String SD_REFORM = "01";
	// 已整改
	public static final String ID_HAS_REFORM = "@@@@AA1000000003THUN";
	public static final String SD_HAS_REFORM = "02";
	// 审核通过
	public static final String ID_AUDIT_THROUGH = "@@@@AA1000000003THUO";
	public static final String SD_AUDIT_THROUGH = "03";
	// 扣分
	public static final String ID_POINTS = "@@@@AA1000000003THUP";
	public static final String SD_POINTS = "04";

	/**
	 * 病历任务状态
	 */
	// 未完成
	public static final String ID_MRTASK_TODO = "@@@@AA1000000006JWLT";
	public static final String SD_MRTASK_TODO = "00";
	// 已完成
	public static final String ID_MRTASK_DONE = "@@@@AA1000000006JWLU";
	public static final String SD_MRTASK_DONE = "01";
	// 逾期完成
	public static final String ID_MRTASK_TIMEOUT = "@@@@AA1000000006JWLV";
	public static final String SD_MRTASK_TIMEOUT = "02";
	// 取消
	public static final String ID_MRTASK_CANCEL = "@@@@AA1000000006JWLW";
	public static final String SD_MRTASK_CANCEL = "03";
	
	/**
	 * 住院质控版本常量
	 */
	//住院质控1.0
    public static final String QA_VERSION_ONE = "QaVer 1.0";
    //住院质控2.0。江苏代码合入后产生。
    public static final String QA_VERSION_TWO = "QaVer 2.0";
	/**
	 * 医疗记录状态
	 */
	/**
	 * 新建
	 */
	public static final String SD_SU_MR_NEW = "00";
	public static final String ID_SU_MR_NEW="@@@@AA100000000009A1";
	/**
	 * 已提交
	 */
	public static final String SD_SU_MR_SUBMIT = "01";
	
	public static final String ID_SU_MR_SUBMIT="@@@@AA100000000009A2";
	/**
	 * 二级审签中
	 */
	public static final String SD_SU_MR_INTWOLEVELAUDIT = "02";
	/**
	 * 已二级审签
	 */
	public static final String SD_SU_MR_TWOLEVELSIGNBY = "03";
	/**
	 * 三级审签中
	 */
	public static final String SD_SU_MR_INTHREELEVELAUDIT = "04";
	/**
	 * 已三级审签
	 */
	public static final String SD_SU_MR_THREELEVELSIGNBY = "05";
	/**
	 * 审签中
	 */
	public static final String SD_SU_MR_SIGNING = "95";
	/**
	 * 审签完成
	 */
	public static final String SD_SU_MR_COMPLETE = "96";
	/**
	 * 取回
	 */
	public static final String ID_SU_MR_RETRIEVE = "@@@@AA100000000009A8";
	public static final String SD_SU_MR_RETRIEVE = "98";
	
	/**
	 * 驳回
	 */
	public static final String ID_SU_MR_REJECT = "@@@@AA100000000009A7";
	public static final String SD_SU_MR_REJECT = "99";

	/**
	 * 传染病报卡状态
	 */
	// 新建
	public static final String ID_CONTAGION_STATUS_NEW = "@@@@AA1000000001S7Q9";
	public static final String SD_CONTAGION_STATUS_NEW = "1";
	// 已提交
	public static final String ID_CONTAGION_STATUS_SUBMIT = "@@@@AA1000000001S7QA";
	public static final String SD_CONTAGION_STATUS_SUBMIT = "2";
	// 审核通过
	public static final String ID_CONTAGION_STATUS_PASS = "@@@@AA1000000001S7QB";
	public static final String SD_CONTAGION_STATUS_PASS = "3";
	// 驳回
	public static final String ID_CONTAGION_STATUS_REJECT = "@@@@AA1000000001S7Q9";
	public static final String SD_CONTAGION_STATUS_REJECT = "4";
	
	public static final String ID_CONTAGION_STATUS_INVALID="@@@@Z8100000000AIA2E";
	public static final String SD_CONTAGION_STATUS_INVALID = "5";

	/**
	 * 院感报卡状态
	 */
	// 未上报
	public static final String ID_HOSPINFECTION_STATUS_NEW = "@@@@Z7100000000X22C4";
	public static final String SD_HOSPINFECTION_STATUS_NEW = "01";
	// 待审核
	public static final String ID_HOSPINFECTION_STATUS_SUBMIT = "@@@@Z7100000000X22C5";
	public static final String SD_HOSPINFECTION_STATUS_SUBMIT = "02";
	// 审核通过
	public static final String ID_HOSPINFECTION_STATUS_PASS = "@@@@Z7100000000X22C6";
	public static final String SD_HOSPINFECTION_STATUS_PASS = "03";
	// 驳回
	public static final String ID_HOSPINFECTION_STATUS_REJECT = "@@@@Z7100000000X22C7";
	public static final String SD_HOSPINFECTION_STATUS_REJECT = "04";
	
	/**
	 * 病历召回状态
	 */
   //江苏省人民需要两级审批召回，将添加审批中，zhangjb
   public static final String ID_CIMRRECALL_STATUS_APPLY = "@@@@Z7100000000X0FP2";
   public static final String SD_CIMRRECALL_STATUS_APPLY = "01";
   public static final String NAME_CIMRRECALL_STATUS_APPLY = "未审批";

   public static final String ID_CIMRRECALL_STATUS_AUDITING = "@@@@Z8100000000XFN19";
   public static final String SD_CIMRRECALL_STATUS_AUDITING = "02";
   public static final String NAME_CIMRRECALL_STATUS_AUDITING = "科室已审批";

   public static final String ID_CIMRRECALL_STATUS_AUDIT = "@@@@Z7100000000X0FP3";
   public static final String SD_CIMRRECALL_STATUS_AUDIT = "03";
   public static final String NAME_CIMRRECALL_STATUS_AUDIT = "审批完成";

   public static final String ID_CIMRRECALL_STATUS_REJECT = "@@@@Z7100000000X0FP4";
   public static final String SD_CIMRRECALL_STATUS_REJECT = "04";
   public static final String NAME_CIMRRECALL_STATUS_REJECT = "驳回";

   public static final String ID_CIMRRECALL_STATUS_PIGEONHOLE = "@@@@Z8100000000XBESE";
   public static final String SD_CIMRRECALL_STATUS_PIGEONHOLE = "05";
   public static final String NAME_CIMRRECALL_STATUS_PIGEONHOLE = "提交病案";
   /**
    * do状态
    */
   public static final int DOStatusUnChanged=0;
   public static final int DOStatusUpdate=1;
   public static final int DOStatusNew=2;
   public static final int DOStatusDeleted=3;
   
   /**
    * 就诊类型
    */
   public static final String ID_ENTP_MENZHEN = "@@@@AA10000000004O80";
   public static final String SD_ENTP_MENZHEN = "00";
   public static final String NAME_ENTP_MENZHEN = "门诊";

   public static final String ID_ENTP_JIZHEN = "@@@@AA10000000004O81";
   public static final String SD_ENTP_JIZHEN = "01";
   public static final String NAME_ENTP_JIZHEN = "急诊";

   public static final String ID_ENTP_ZHUYUAN = "@@@@AA10000000004O83";
   public static final String SD_ENTP_ZHUYUAN = "10";
   public static final String NAME_ENTP_ZHUYUAN = "住院";

   public static final String ID_ENTP_TIJIAN = "@@@@AA10000000004O82";
   public static final String SD_ENTP_TIJIAN = "02";
   public static final String NAME_ENTP_TIJIAN = "体检";

   public static final String ID_ENTP_JIATINGBINGFANG = "@@@@AA10000000004O84";
   public static final String SD_ENTP_JIATINGBINGFANG = "20";
   public static final String NAME_ENTP_JIATINGBINGFANG = "家庭病床";
   
   /**
	* 所属类型
	*/
	public static final String ID_UDIDOLIST_OWTP_HO="@@@@AA1000000000ELNS";
	public static final String SD_UDIDOLIST_OWTP_HO="0";
	public static final String NAME_UDIDOLIST_OWTP_HO="全院";
	
	public static final String ID_UDIDOLIST_OWTP_SE="@@@@AA1000000000ELNR";
	public static final String SD_UDIDOLIST_OWTP_SE="1";
	public static final String NAME_UDIDOLIST_OWTP_SE="科室";
	
	public static final String ID_UDIDOLIST_OWTP_PE="@@@@AA1000000000ELNQ";
	public static final String SD_UDIDOLIST_OWTP_PE="2";
	public static final String NAME_UDIDOLIST_OWTP_PE="个人";
	
	/**
	 * 基础模板状态
	 */
	public static final String ID_UDIDOLIST_BASETPLSATE_NEW="@@@@AA1000000000ELNF";
	public static final String SD_UDIDOLIST_BASETPLSATE_NEW="0";
	public static final String NAME_UDIDOLIST_BASETPLSATE_NEW="新建";
	
	public static final String ID_UDIDOLIST_BASETPLSATE_ACTIVE="@@@@AA1000000000ELNG";
	public static final String SD_UDIDOLIST_BASETPLSATE_ACTIVE="1";
	public static final String NAME_UDIDOLIST_BASETPLSATE_ACTIVE="已启用";
	
	public static final String ID_UDIDOLIST_BASETPLSATE_STOP="@@@@AA1000000000ELNH";
	public static final String SD_UDIDOLIST_BASETPLSATE_STOP="2";
	public static final String NAME_UDIDOLIST_BASETPLSATE_STOP="已停用";

	/**
	 * 自定义档案性别
	 */
	public static final String ID_UDIDOCLIST_SEX_NX="@@@@AA1000000000MNSZ";
	public static final String SD_UDIDOCLIST_SEX_NX="1";
	public static final String NAME_UDIDOCLIST_SEX_NX="男性";
	
	public static final String ID_UDIDOCLIST_SEX_NVX="@@@@AA1000000000MNT0";
	public static final String SD_UDIDOCLIST_SEX_NVX="2";
	public static final String NAME_UDIDOCLIST_SEX_NVX="女性";
	
	public static final String ID_UDIDOCLIST_SEX_WSM="@@@@AA1000000000MNT1";
	public static final String SD_UDIDOCLIST_SEX_WSM="9";
	public static final String NAME_UDIDOCLIST_SEX_WSM="未说明";
	
	public static final String ID_UDIDOCLIST_SEX_WZ="@@@@AA1000000000MNSY";
	public static final String SD_UDIDOCLIST_SEX_WZ="0";
	public static final String NAME_UDIDOCLIST_SEX_WZ="未知";
	/**
	 * 审签级别
	 */
    public static final String ID_MRREVIEW_NONE = "@@@@AA1000000003PZB0";
    public static final String SD_MRREVIEW_NONE = "00";
    public static final String NAME_MRREVIEW_NONE = "无审签";

    public static final String ID_MRREVIEW_ONELEVEL = "@@@@AA1000000003PZAX";
    public static final String SD_MRREVIEW_ONELEVEL = "01";
    public static final String NAME_MRREVIEW_ONELEVEL = "一级审签";

    public static final String ID_MRREVIEW_TWOLEVEL = "@@@@AA1000000003PZAY";
    public static final String SD_MRREVIEW_TWOLEVEL = "02";
    public static final String NAME_MRREVIEW_TWOLEVEL = "二级审签";

    public static final String ID_MRREVIEW_THREELEVEL = "@@@@AA1000000003PZAZ";
    public static final String SD_MRREVIEW_THREELEVEL = "03";
    public static final String NAME_MRREVIEW_THREELEVEL = "三级审签";
    /**
     * 模板状态
     */
    public static final String ID_SUMRPTL_NEW = "@@@@AA1000000000ELNK";
    public static final String SD_SUMRPTL_NEW = "1";
    public static final String NAME_SUMRPTL_NEW = "新建";

    public static final String ID_SUMRPTL_IN_ACTIVATE = "@@@@AA1000000000ELNL";
    public static final String SD_SUMRPTL_IN_ACTIVATE = "2";
    public static final String NAME_SUMRPTL_IN_ACTIVATE = "已启用";

    public static final String ID_SUMRPTL_DEACTIVATE = "@@@@AA1000000000ELNM";
    public static final String SD_SUMRPTL_DEACTIVATE = "3";
    public static final String NAME_SUMRPTL_DEACTIVATE = "已停用";

    public static final String ID_SUMRPTL_REVOKE = "@@@@AA1000000000MNQH";
    public static final String SD_SUMRPTL_REVOKE = "4";
    public static final String NAME_SUMRPTL_REVOKE = "撤回";

    public static final String ID_SUMRPTL_SUBMIT = "@@@@AA1000000000MNQJ";
    public static final String SD_SUMRPTL_SUBMIT = "5";
    public static final String NAME_SUMRPTL_SUBMIT = "提交";

    public static final String ID_SUMRPTL_SIGNBY = "@@@@AA1000000000MNQK";
    public static final String SD_SUMRPTL_SIGNBY = "6";
    public static final String NAME_SUMRPTL_SIGNBY = "已审批";
	/** 
     * 枚举-责任人  
	 * 2017年9月6日16:05:44 yy.zhao
	 */
	public static final String ID_DUTY_PERSON="3615b193-f2a9-4940-a302-09ac841a9791";
	
	/**
	 *病案操作流程定义 
	 */
	 //前进
    public static final String ID_MRM_OP_PROCESS_FORWARD = "@@@@Z8100000000RPPH0";
    public static final String SD_MRM_OP_PROCESS_FORWARD = "01";
    //后退
    public static final String ID_MRM_OP_PROCESS_FORWARDNOT = "@@@@Z8100000000RPPH1";
    public static final String SD_MRM_OP_PROCESS_FORWARDNOT = "02";
    //退回
    public static final String ID_MRM_OP_PROCESS_BACKOFF = "@@@@Z8100000000RPPH2";
    public static final String SD_MRM_OP_PROCESS_BACKOFF = "03";
    //未签名
    public static final String ID_MRM_OP_PROCESS_UNSIGN = "@@@@Z8100000000RPPH3";
    public static final String SD_MRM_OP_PROCESS_UNSIGN = "04";
    //重新签名
    public static final String ID_MRM_OP_PROCESS_AGAINSIGN = "@@@@Z8100000000RPPH4";
    public static final String SD_MRM_OP_PROCESS_AGAINSIGN = "05";
    //重新签收
    public static final String ID_MRM_OP_PROCESS_AGAINSIGNOFF = "@@@@Z8100000000RPPX6";
    public static final String SD_MRM_OP_PROCESS_AGAINSIGNOFF = "06";
    //误操作
    public static final String ID_MRM_OP_PROCESS_MISOPERATION = "@@@@Z8100000000MLCVA";
    public static final String SD_MRM_OP_PROCESS_MISOPERATION = "07";
	
	/**
	 * 病案邮寄状态定义
	 */
	// 待邮寄
	public static final String ID_MRM_MA_STATE_UNEXECUTED = "@@@@Z8100000000MLCV7";
	public static final String SD_MRM_MA_STATE_UNEXECUTED = "01";
	// 已打印
	public static final String ID_MRM_MA_STATE_PRINTED = "@@@@Z8100000000MLCV8";
	public static final String SD_MRM_MA_STATE_PRINTED = "02";
	// 已邮寄
	public static final String ID_MRM_MA_STATE_EXECUTED = "@@@@Z8100000000MLCVB";
	public static final String SD_MRM_MA_STATE_EXECUTED = "03";
	
	/**
	 * 病案邮寄方式定义
	 */
	// 现付
	public static final String ID_MRM_MA_WAY_SPOTPAY = "@@@@Z8100000000MLCVC";
	public static final String SD_MRM_MA_WAY_SPOTPAY = "01";
	// 到付
	public static final String ID_MRM_MA_WAY_ARRIVALPAY = "@@@@Z8100000000MLCVD";
	public static final String SD_MRM_MA_WAY_ARRIVALPAY = "02";
	
	/**
	 * 医疗记录自定义分类_扫描范围_院内
	 */
    public static final String SD_CACTMSCANTYPE_IN = "1";
    public static final String NAME_CACTMSCANTYPE_IN = "院内";
    /**
     * 医疗记录自定义分类_扫描范围_院外
     */
    public static final String SD_CACTMSCANTYPE_OUT = "2";
    public static final String NAME_CACTMSCANTYPE_OUT = "院外";
    /**
     * 医疗记录自定义分类_扫描范围_无
     */
    public static final String SD_CACTMSCANTYPE_NOTHING = "3";
    public static final String NAME_CACTMSCANTYPE_NOTHING = "无";
    /**
     * 医疗记录自定义分类_扫描范围_复制
     */
    public static final String SD_CACTMSCANTYPE_COPY = "4";
    public static final String NAME_CACTMSCANTYPE_COPY = "复制";//从院内关联复制
    
    /**
     * 传染病既往已报状态
     */
    //既往待审
    public static final String ID_CONPASS_SUBMIT="@@@@Z8100000000Q02BE";
    public static final String SD_CONPASS_SUBMIT="01";
    public static final String NAME_CONPASS_SUBMIT="既往待审";
    
    //既往已报
    public static final String ID_CONPASS_PASS="@@@@Z8100000000Q02BF";
    public static final String SD_CONPASS_PASS="02";
    public static final String NAME_CONPASS_PASS="既往已报";
    
    //既往驳回
    public static final String ID_CONPASS_REJECT="@@@@Z8100000000Q02BG";
    public static final String SD_CONPASS_REJECT="03";
    public static final String NAME_CONPASS_REJECT="既往驳回";
    
    public static final String EDITOR_DEFAULT="UTF-8";//GB2312  UTF-8
    public static final String EDITOR_GB2312="GB2312";//GB2312  UTF-8
    public static final String EDITOR_UTF8="UTF-8";//GB2312  UTF-8
    
    /**
     * 质控抽查记录主状态
     */
    //已分配
    public static final String ID_MR_QC_RANDOM_MAIN_STATUS_YIFENPEI = "@@@@Z8100000000QAE7T";
    public static final String SD_MR_QC_RANDOM_MAIN_STATUS_YIFENPEI = "01";
    //已提交
    public static final String ID_MR_QC_RANDOM_MAIN_STATUS_YITIJIAO = "@@@@Z8100000000QAE7U";
    public static final String SD_MR_QC_RANDOM_MAIN_STATUS_YITIJIAO = "02";
    //已审核
    public static final String ID_MR_QC_RANDOM_MAIN_STATUS_YISHENHE = "@@@@Z8100000000QAE7V";
    public static final String SD_MR_QC_RANDOM_MAIN_STATUS_YISHENHE = "03";
    
    /**
     * 质控抽查类型
     */
    //门诊部抽查
    public static final String ID_MR_QC_RANDOM_TYPE_OPD = "@@@@Z8100000000QAE7W";
    public static final String SD_MR_QC_RANDOM_TYPE_OPD = "01";
    //科室抽查
    public static final String ID_MR_QC_RANDOM_TYPE_DEP = "@@@@Z8100000000QAE7X";
    public static final String SD_MR_QC_RANDOM_TYPE_DEP = "02";
    
    /**
     * 枚举   医护类型
     */
    //医生
    public static final String SD_UDIDOCLIST_MROWNTP_DOC = "10";
    public static final String NAME_UDIDOCLIST_MROWNTP_DOC="医生";
    //护士
    public static final String SD_UDIDOCLIST_MROWNTP_NUR = "20";
    public static final String NAME_UDIDOCLIST_MROWNTP_NUR="护士";
    //医护共享
    public static final String SD_UDIDOCLIST_MROWNTP_ALL = "30";
    public static final String NAME_UDIDOCLIST_MROWNTP_ALL="医护共享";
    
    /**
     * 内涵质控印象评价等级
     */
    // 优
    public static final String ID_MR_QC_CONNONATIONQCITM_STATUS_YOU = "@@@@Z8100000000QCDZ7";
    public static final String SD_MR_QC_CONNONATIONQCITM_STATUS_YOU = "01";
    public static final String NAME_MR_QC_CONNONATIONQCITM_STATUS_YOU = "优";
    //中
    public static final String ID_MR_QC_CONNONATIONQCITM_STATUS_ZHONG = "@@@@Z8100000000QCDZ8";
    public static final String SD_MR_QC_CONNONATIONQCITM_STATUS_ZHONG = "02";
    public static final String NAME_MR_QC_CONNONATIONQCITM_STATUS_ZHONG = "中";
    //差
    public static final String ID_MR_QC_CONNONATIONQCITM_STATUS_CHA = "@@@@Z8100000000QCDZ9";
    public static final String SD_MR_QC_CONNONATIONQCITM_STATUS_CHA = "03";
    public static final String NAME_MR_QC_CONNONATIONQCITM_STATUS_CHA = "差";
    
    /**
     * 质控事件调用方法
     */
    // 文书有无
    public static final String ID_MR_AUTOQC_ISHAVEMR = "@@@@AA1000000001Q2JA";
    public static final String SD_MR_AUTOQC_ISHAVEMR = "00";
    //内容有无
    public static final String ID_MR_AUTOQC_ISHAVEMRELEMENT = "@@@@AA1000000001Q2JB";
    public static final String SD_MR_AUTOQC_ISHAVEMRELEMENT = "01";
    
    /**
     * 病历书写任务触发事件
     */
    // 入科
    public static final String ID_MR_TASK_EVENT_RUKE = "@@@@Z81000000008F59D";
    public static final String SD_MR_TASK_EVENT_RUKE = "01";
    //出院
    public static final String ID_MR_TASK_EVENT_CHUYUAN = "@@@@Z81000000008F59E";
    public static final String SD_MR_TASK_EVENT_CHUYUAN = "02";
    // 手术医嘱
    public static final String ID_MR_TASK_EVENT_SHOUSHU = "@@@@Z81000000008F59F";
    public static final String SD_MR_TASK_EVENT_SHOUSHU = "03";
    //死亡医嘱
    public static final String ID_MR_TASK_EVENT_SIWANG = "@@@@Z81000000008F59G";
    public static final String SD_MR_TASK_EVENT_SIWANG = "04";
    // 转入
    public static final String ID_MR_TASK_EVENT_ZHUANRU = "@@@@Z81000000008F59H";
    public static final String SD_MR_TASK_EVENT_ZHUANRU = "05";
    //转出
    public static final String ID_MR_TASK_EVENT_ZHUANCHU = "@@@@Z81000000008F59I";
    public static final String SD_MR_TASK_EVENT_ZHUANCHU = "06";
    // 抢救医嘱
    public static final String ID_MR_TASK_EVENT_QIANGJIU = "@@@@Z81000000008TEEB";
    public static final String SD_MR_TASK_EVENT_QIANGJIU = "07";
    //病危医嘱
    public static final String ID_MR_TASK_EVENT_BINGWEI = "@@@@Z81000000008TEEE";
    public static final String SD_MR_TASK_EVENT_BINGWEI = "08";
    //会诊医嘱
    public static final String ID_MR_TASK_EVENT_HUIZHEN = "@@@@Z8100000000D1FUS";
    public static final String SD_MR_TASK_EVENT_HUIZHEN = "09";
    // 转入病区
    public static final String ID_MR_TASK_EVENT_ZHUANRUBQ = "@@@@Z8100000000HYWMF";
    public static final String SD_MR_TASK_EVENT_ZHUANRUBQ = "10";
    
    /*  
     * //药品医嘱
    	public static final String ID_MR_TASK_EVENT_DRUG = "@@@@Z8100000001LUXCV";
    	public static final String SD_MR_TASK_EVENT_DRUG  = "09";
     */
    //检查医嘱
    public static final String ID_MR_TASK_EVENT_RIS = "@@@@Z8100000001LUXCW";
    public static final String SD_MR_TASK_EVENT_RIS  = "10";
    //检验医嘱
    public static final String ID_MR_TASK_EVENT_LIS = "@@@@Z8100000001LUXCX";
    public static final String SD_MR_TASK_EVENT_LIS  = "11";
    //治疗医嘱
    public static final String ID_MR_TASK_EVENT_TREAT = "@@@@Z8100000001LUXCY";
    public static final String SD_MR_TASK_EVENT_TREAT  = "12";
    //其他医嘱
    public static final String ID_MR_TASK_EVENT_OTHER = "@@@@Z8100000001UECH1";
    public static final String SD_MR_TASK_EVENT_OTHER  = "13";
      
	/**
	 * 病历超时申请状态
	 */
	public static final String ID_OVERAPPLY_UNAPPLY = "@@@@Z8100000000NDD1Z";
	public static final String SD_OVERAPPLY_UNAPPLY = "01";
	public static final String NAME_OVERAPPLY_UNAPPLY = "未提交";

	public static final String ID_OVERAPPLY_UNSUBMIT = "@@@@Z8100000000NDD20";
	public static final String SD_OVERAPPLY_UNSUBMIT = "02";
	public static final String NAME_OVERAPPLY_UNSUBMIT = "未审核";

	public static final String ID_OVERAPPLY_REJECT = "@@@@Z8100000000NDD21";
	public static final String SD_OVERAPPLY_REJECT = "03";
	public static final String NAME_OVERAPPLY_REJECT = "已驳回";

	public static final String ID_OVERAPPLY_SUBMIT = "@@@@Z8100000000NDD22";
	public static final String SD_OVERAPPLY_SUBMIT = "04";
	public static final String NAME_OVERAPPLY_SUBMIT = "已审核";
	
	/**
	 * 病历召回申请状态
	 */
	public static final String ID_RECALL_APPLY_UNSUBMIT = "@@@@Z8100000000NJVXW";
	public static final String SD_RECALL_APPLY_UNSUBMIT = "01";
	public static final String NAME_RECALL_APPLY_UNSUBMIT = "未审核";

	public static final String ID_RECALL_APPLY_DEPSUBMIT = "@@@@Z8100000000NJVXX";
	public static final String SD_RECALL_APPLY_DEPSUBMIT = "02";
	public static final String NAME_RECALL_APPLY_DEPSUBMIT = "科室已审核";

	public static final String ID_RECALL_APPLY_DEPREJECT = "@@@@Z8100000000NJVXY";
	public static final String SD_RECALL_APPLY_DEPREJECT = "03";
	public static final String NAME_RECALL_APPLY_DEPREJECT = "科室已驳回";
	
	public static final String ID_RECALL_APPLY_MEDSUBMIT = "@@@@Z8100000000NJVXZ";
	public static final String SD_RECALL_APPLY_MEDSUBMIT = "04";
	public static final String NAME_RECALL_APPLY_MEDSUBMIT = "医务已审核";

	public static final String ID_RECALL_APPLY_MEDREJECT = "@@@@Z8100000000NJVY0";
	public static final String SD_RECALL_APPLY_MEDREJECT = "05";
	public static final String NAME_RECALL_APPLY_MEDREJECT = "医务已驳回";
	
	/**
	 * 病案编目--审核类型自定义档案
	 */
     public static final String ID_AUDITTYPE_CONTRAINT = "@@@@Z8100000000JWE4P";
     public static final String SD_AUDITTYPE_CONTRAINT = "0";
     public static final String NAME_AUDITTYPE_CONTRAINT = "强制";

     public static final String ID_AUDITTYPE_LOGIC = "@@@@Z8100000000JWE4Q";
     public static final String SD_AUDITTYPE_LOGIC = "1";
     public static final String NAME_AUDITTYPE_LOGIC = "逻辑";

     public static final String ID_AUDITTYPE_COMPLET = "@@@@Z8100000000JWE4S";
     public static final String SD_AUDITTYPE_COMPLET = "2";
     public static final String NAME_AUDITTYPE_COMPLET = "上报完整度";
	 
	 /**
	 * 病案编目--审核范围自定义档案
	 */
	 public static final String ID_AUDITSCOPE_CATALOGUE = "@@@@Z8100000000JWE4V";
     public static final String SD_AUDITSCOPE_CATALOGUE = "0";
     public static final String NAME_AUDITSCOPE_CATALOGUE = "编目";

     public static final String ID_AUDITSCOPE_CLINIC = "@@@@Z8100000000K92LT";
     public static final String SD_AUDITSCOPE_CLINIC = "1";
     public static final String NAME_AUDITTYPE_CLINIC = "临床";
     
     /**
      * 生命体征项目
      */
     public static final String ID_VITALSIGNS_RESTINGPAINSCORE = "@@@@Z8100000000AGVKY";
     public static final String SD_VITALSIGNS_RESTINGPAINSCORE = "4022";
     public static final String NAME_VITALSIGNS_RESTINGPAINSCORE = "静息疼痛评分";

     public static final String ID_VITALSIGNS_WEIGHT = "@@@@Z8100000000AGVKZ";
     public static final String SD_VITALSIGNS_WEIGHT = "4009";
     public static final String NAME_VITALSIGNS_WEIGHT = "体重kg";

     public static final String ID_VITALSIGNS_TOTALDISCHARGE = "@@@@Z8100000000AGVL0";
     public static final String SD_VITALSIGNS_TOTALDISCHARGE = "4007";
     public static final String NAME_VITALSIGNS_TOTALDISCHARGE = "总排出ml";

     public static final String ID_VITALSIGNS_DISEASERECORD = "@@@@Z8100000000AGVL1";
     public static final String SD_VITALSIGNS_DISEASERECORD = "4050";
     public static final String NAME_VITALSIGNS_DISEASERECORD = "病情记录";

     public static final String ID_VITALSIGNS_TEMPERATURE = "@@@@Z8100000000AGVL2";
     public static final String SD_VITALSIGNS_TEMPERATURE = "4001";
     public static final String NAME_VITALSIGNS_TEMPERATURE = "体温℃";

     public static final String ID_VITALSIGNS_BLOODPRESSURE = "@@@@Z8100000000AGVL3";
     public static final String SD_VITALSIGNS_BLOODPRESSURE = "4008";
     public static final String NAME_VITALSIGNS_BLOODPRESSUREE = "血压mmHg";

     public static final String ID_VITALSIGNS_HEARTRATE = "@@@@Z8100000000AGVL5";
     public static final String SD_VITALSIGNS_HEARTRATE = "4020";
     public static final String NAME_VITALSIGNS_HEARTRATE = "心率次/分";

     public static final String ID_VITALSIGNS_BREATH = "@@@@Z8100000000AGVL4";
     public static final String SD_VITALSIGNS_BREATH = "4003";
     public static final String NAME_VITALSIGNS_BREATH = "呼吸次/分";

     public static final String ID_VITALSIGNS_SPIRIT = "@@@@Z8100000000AGVL9";
     public static final String SD_VITALSIGNS_SPIRIT = "4014";
     public static final String NAME_VITALSIGNS_SPIRIT = "神志";

     public static final String ID_VITALSIGNS_LEFTPUPILLIGHTINVERSE = "@@@@Z8100000000AGVLM";
     public static final String SD_VITALSIGNS_LEFTPUPILLIGHTINVERSE = "4018";
     public static final String NAME_VITALSIGNS_LEFTPUPILLIGHTINVERSE = "左瞳光反";

     public static final String ID_VITALSIGNS_RIGHTPUPILLIGHTINVERSE = "@@@@Z8100000000AGVLO";
     public static final String SD_VITALSIGNS_RIGHTPUPILLIGHTINVERSE = "4019";
     public static final String NAME_VITALSIGNS_RIGHTPUPILLIGHTINVERSE = "右瞳光反";

     public static final String ID_VITALSIGNS_ACTIVITYPAINSCORE = "@@@@Z8100000000AGVLQ";
     public static final String SD_VITALSIGNS_ACTIVITYPAINSCORE = "4026";
     public static final String NAME_VITALSIGNS_ACTIVITYPAINSCORE = "活动疼痛评分";

     public static final String ID_VITALSIGNS_BLOODGLUCOSE = "@@@@Z8100000000AGVLR";
     public static final String SD_VITALSIGNS_BLOODGLUCOSE = "4013";
     public static final String NAME_VITALSIGNS_BLOODGLUCOSE = "血糖mmol/L";

     public static final String ID_VITALSIGNS_URINEVOLUME = "@@@@Z8100000000AGVLS";
     public static final String SD_VITALSIGNS_URINEVOLUME = "4005";
     public static final String NAME_VITALSIGNS_URINEVOLUME = "尿量ml";

     public static final String ID_VITALSIGNS_STOOLTIMES = "@@@@Z8100000000AGVLU";
     public static final String SD_VITALSIGNS_STOOLTIMES = "4004";
     public static final String NAME_VITALSIGNS_STOOLTIMES = "大便次数";

     public static final String ID_VITALSIGNS_INFUSIONVOLUME = "@@@@Z8100000000AGVLV";
     public static final String SD_VITALSIGNS_INFUSIONVOLUME = "4006";
     public static final String NAME_VITALSIGNS_INFUSIONVOLUME = "输液量ml";

     public static final String ID_VITALSIGNS_BLOODOXYGENSATURATION = "@@@@Z8100000000AGVMG";
     public static final String SD_VITALSIGNS_BLOODOXYGENSATURATION = "4015";
     public static final String NAME_VITALSIGNS_BLOODOXYGENSATURATION = "血氧饱和度%";

     public static final String ID_VITALSIGNS_INPUTLIQUIDVOLUME = "@@@@Z8100000000AGVM4";
     public static final String SD_VITALSIGNS_INPUTLIQUIDVOLUME = "4010";
     public static final String NAME_VITALSIGNS_INPUTLIQUIDVOLUME = "输入液量ml";

     public static final String ID_VITALSIGNS_PULSE = "@@@@Z8100000000AGVM1";
     public static final String SD_VITALSIGNS_PULSEE = "4002";
     public static final String NAME_VITALSIGNS_PULSE = "脉搏次/分";

     public static final String ID_VITALSIGNS_LEFTPUPILSIZE = "@@@@Z8100000000AGVMI";
     public static final String SD_VITALSIGNS_LEFTPUPILSIZE = "4016";
     public static final String NAME_VITALSIGNS_LEFTPUPILSIZE = "左瞳大小mm";

     public static final String ID_VITALSIGNS_RIGHTPUPILSIZE = "@@@@Z8100000000AGVLX";
     public static final String SD_VITALSIGNS_RIGHTPUPILSIZE = "4017";
     public static final String NAME_VITALSIGNS_RIGHTPUPILSIZE = "右瞳大小mm";
     
     /**
      * 编码系统
      */
     public static final String ID_CODESYSTEM_WJT4 = "@@@@Z810000000091T6B";
     public static final String SD_CODESYSTEM_WJT4 = "WJT4";
     public static final String NAME_CODESYSTEM_WJT4 = "卫健统4";  
 
    /**
     * 手术风险评估表数据源
     */
	//手术切口清洁度
	public static final String SSQKQJD = "FD.MR.01.027";
	//手术切口清洁度分值
	public static final String SSQKQJDFZ = "FD.MR.01.028";
	//麻醉分级
	public static final String MZFJ = "FD.MR.01.029";
	//麻醉分级分值
	public static final String MZFJFZ = "FD.MR.01.030";
	//持续时间
	public static final String CXSJ = "FD.MR.01.031";
	//持续时间分值
	public static final String CXSJFZ = "FD.MR.01.032";
	//总分
	public static final String ZF = "FD.MR.01.033";
	//NNIS
	public static final String NNIS = "FD.MR.01.034";
	//切口愈合
	public static final String QKYH = "FD.MR.01.035";
	//手术类别
	public static final String SSLB = "FD.MR.01.036";
	//是否急诊
	public static final String SFJZ = "FD.MR.01.037";
	//手术日期
	public static final String SSRQ = "FD.MR.SS.02";
    
    /**
     * 质控事件调用方法
     */
    public static final String SD_ISHAVEMR = "00";//文书是否存在
    public static final String SD_ISHAVEMRLIMIT = "03";//文书是否当日存在
    public static final String SD_ISHAVEMRAFTER = "02";//文书存在是否超时（向后）
    public static final String SD_ISHAVEMRAFTERORNONE = "0201";//文书不存在或超时（向后）
    public static final String SD_ISHAVEMRBEFORE = "01";//文书存在是否超时（向前）
    public static final String SD_ISHAVEMRBEFOREORNONE = "0101";//文书不存在或超时（向前）
    public static final String SD_ISHAVETIMESMR = "04";//区间内是否存在指定份数文书
    
    /**
     * 质量自评自动质控
     */
    public static final String ID_REVISION = "DOCTORAUTOQCSELF";
   
    /**
     * 扫描格式定义
     */
    //图片格式
    public static final String ID_BD_MRM_DATAFORAMT_IMAGE = "@@@@Z7100000001B6NR3";
    public static final String SD_BD_MRM_DATAFORAMT_IMAGE = "1001";
    //pdf格式
    public static final String ID_BD_MRM_DATAFORAMT_PDF = "@@@@Z8100000001B7OBX";
    public static final String SD_BD_MRM_DATAFORAMT_PDF = "1002";
    
    /**
     *甲类传染病 
     */
    public static final String ID_TYPE_CONGATION_A = "@@@@ZZ200000000000AV";
    public static final String SD_TYPE_CONGATION_A = "atypecontagion";
    
    /**
     *乙类传染病 
     */
    public static final String ID_TYPE_CONGATION_B = "@@@@ZZ200000000000AW";
    public static final String SD_TYPE_CONGATION_B = "btypecongation";
    
    /**
     *丙类传染病 
     */
    public static final String ID_TYPE_CONGATION_C = "@@@@ZZ200000000000AT";
    public static final String SD_TYPE_CONGATION_C = "c_type_contagion";
    
    /**
     *其它传染病 
     */
    public static final String ID_TYPE_CONGATION_OTHER = "@@@@ZZ200000000000BS";
    public static final String SD_TYPE_CONGATION_OTRER = "otherdiseases";
    
    /**
     * 病案首页模式判断（1：中医，2：西医）
     */
    public static final String MR_FP_XY_TYPE = "2";
    public static final String MR_FP_ZY_TYPE = "1";
    
    /**
     *业务组类型 
     */
    public static final String SD_TYPE_BIZGROUP_LCYW = "01";//临床业务
    public static final String SD_TYPE_BIZGROUP_ZYZL = "0101";//住院诊疗组
    public static final String SD_TYPE_BIZGROUP_ZYZLZ = "0105";//专用诊疗组
    public static final String SD_TYPE_BIZGROUP_MZYLZ = "0110";//门诊医疗组
    
    /**
     * 病案操作类型
     */
    //病案签收
    public static final String SD_MRM_OP_TYPE_SIGNOFF = "01";
    //病案整理
    public static final String SD_MRM_OP_TYPE_ARRANGE = "02";
    //病案装订
    public static final String SD_MRM_OP_TYPE_BIND = "03";
    //病案入库
    public static final String SD_MRM_OP_TYPE_STORAGE = "04";
    //病案退回
    public static final String SD_MRM_OP_TYPE_BACKOFF = "05";
    //病案未签名
    public static final String SD_MRM_OP_TYPE_UNSIGN = "06";
    //病案误操作
    public static final String SD_MRM_OP_TYPE_MISOPERATION = "07";
    //病案待签收
    public static final String SD_MRM_OP_TYPE_NEEDSIGNOFF = "99";
    
    /**
	 * 病历审签操作类型
	 */
	//审签通过
	public static final String ID_MRCHECKPASS = "@@@@Z8100000001VQYHN";
	public static final String SD_MRCHECKPASS = "01";
	public static final String NAME_MRCHECKPASS = "审签通过";
	//审签驳回
	public static final String ID_MRCHECKREJECT = "@@@@Z8100000001VQYHO";
	public static final String SD_MRCHECKREJECT = "02";
	public static final String NAME_MRCHECKREJECT = "审签驳回";
	
	/**
	 * 书写任务提醒判定
	 */
	//创建
	public static final String ID_MR_TASK_CREATE = "@@@@Z8100000003N5XAM";
	public static final String SD_MR_TASK_CREATE = "01";
	//签署
	public static final String ID_MR_TASK_SIGN = "@@@@Z8100000003N5XAN";
	public static final String SD_MR_TASK_SIGN = "02";
}
