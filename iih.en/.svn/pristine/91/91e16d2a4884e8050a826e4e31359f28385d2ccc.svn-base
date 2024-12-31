package iih.en.comm.util;

import iih.en.comm.IEnConst;
import iih.en.comm.validator.EnValidator;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.orgfw.org.i.IOrgConst;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 参数读取帮助类，框架提供好后,需进行修改
 * 
 * @author yankan
 * @since 2015-12-01
 *
 */
public class EnParamUtils {
	
	//诊间挂号结算模式结算操作员类型
	private static final String KEY_EN_STEMP_TPYE = "ENOP0027";
	//诊间结算虚拟结算人员
	private static final String KEY_BL_VIRTUAL_OPREMP = "BLSTOEP0050";
	//门诊挂号结算是否使用医保结算
	private static final String KEY_EN_REH_USE_HP_ST ="BDMHI3015";
	//药房分窗口候诊是否包含配药
	private static final String KEY_EN_HAVA_PHRAM_PREPARE ="ENOP0351";
	
	private static final String KEY_EN_MAXCALLNUM ="ENOP0025";
	//最大叫号次数-药房队列使用
	private static final String PK_EN_OP_IS_OPINREGST ="EN000090";
	//挂号接诊病人结算模式
	private static final String KEY_OP_UNREG_BLTP = "ENOP0019";
	//大屏叫号患者信息显示模板
	public static final String KEY_BRD_CALL_PATINFO = "ENPC1061";
	//大屏过号患者信息显示模板
	public static final String KEY_BRD_PASS_PATINFO = "ENPC1062";
	//门诊挂号号条打印机设置，fanlq-2018-06-25
	public static final String PK_OP_PRINTER_PARAM = "ENPC1040";
	// 门诊分诊台配置参数key
	private static final String PK_OP_TRIAGE_BEN_ID = "ENPC1000";
	// 门诊接诊刷新时间key
	private static final String PK_OP_ACPT_REFRESH_TIME = "ENOP0004";
	// 医技分诊台参数Key
	private static final String PK_TECH_TRIAGE_BEN_ID = "ENPC1000";
	// 医技分诊刷新时间key
	private static final String PK_TECH_TRIAGE_REFRESH_TIME = "ENTH0010";
	// 允许退院的时限
	private static final String PK_DISCHARGE_HOURS_LIMIT = "ENIP0090";
	// 跨科接诊标识
	private static final String KEY_ACPT_CROSS_DEPT = "ENOP0011";
	// 门诊挂号有效期标识
	private static final String KEY_OP_VALID_PERIOD = "ENOP0001";
	// 诊间候诊数量是否包含过号患者
	private static final String KEY_OP_IS_INCLUDE_OVERNUMBER_PAT = "ENOP0026";
	// 急诊挂号有效期标识
	private static final String KEY_EMG_VALID_PERIOD = "ENER0080";
	// 是否调用挂号规则引擎
	private static final String KEY_EN_OP_REG_MVEL = "en_op_reg_mvel";
	// 门诊打印标识,PC参数
	private static final String KEY_OP_REG_PRNTPS = "ENPC1020";
	// PC管理的所有科室的排班
	private static final String KEY_EN_PC_MG_DEPIDS = "ENPC1010";
	// 就诊队列有效期(天)
	private static final String KEY_QUE_VALID_PERIOD = "ENIP0060";
	// 门诊医生诊断最大时长，以分钟为单位
	private static final String KEY_OP_MAX_DI_PERIODM = "ENOP0080";
	private static final String KEY_SC_NOTE_EXCL_CHLTP = "SC0060";//预约无需短信通知的渠道类型
	private static final String KEY_SC_GCVIP_NOTE_TEL = "SC0080";//绿色通道预约通知电话-预约中心负责人电话
	private static final String KEY_SC_NOTE_RTN_DEPIDS = "SC0090";//需短信通知复诊的科室ID
	
	private static final String KEY_EN_IP_OUT_PATS  = "ENIP0173";//出院、出科患者是否显示归档患者
	
	//转科检查
	// 转科--转科室检查标识
	private static final String PK_TRANS_DEP_CHK = "ENIP0020";
	// 转科--转病区检查标识
	private static final String PK_TRANS_WARD_CHK = "ENIP0021";
	// 转科检查--医技项目类型
	private static final String KEY_TRANS_DEP_SRVTPS_TECH = "ENIP0026";
	// 转科检查--非医技项目类型
	private static final String KEY_TRANS_DEP_SRVTPS_NONTECH = "ENIP0028";
    // 转科不需核查的科室
    private static final String KEY_TRANS_IDSNOCHECK = "ENIP0038";
	
    //出院、转科核查医技项目,执行项目的核查方式 0-按执行核查 1-按费用核查 2-按闭环中是否可出科核查(暂未使用）
    private static final String KEY_EN_CHECKMT_TP= "ENIP0034";
	// 出院检查标识
	// 出院检查内容标志串
	private static final String PK_LEAVE_HOS_CHK = "ENIP0022";
	// 出院检查--医技项目类型
	private static final String KEY_LEAVE_HOS_SRVTPS_TECH = "ENIP0023";
	
	//中止预住院检查内容标志串
	private static final String PK_IPPRE_CANCEL_HOS_CHK = "ENIP0024";
	
	// 出院检查--非医技项目类型
	private static final String KEY_LEAVE_HOS_SRVTPS_NONTECH = "ENIP0030";
	//新生儿是否校验出院医嘱
	private static final String KEY_EN_IP_NBCHKLEAVEORD = "ENIP0190";
	
	private static final String KEY_IPNT_VALID_DAYAS = "ENIP0050";

	// 预约需要确认
	private static final String KEY_APT_NEEDCFM = "SC0020";
	//取消预约中退款记录使用的退款人
	private static final String KEY_SC_CANC_APT_REFUND_OPERATOR = "SC0320";
	// 可以不挂号接诊
	private static final String KEY_OP_ACPT_UNREG = "ENOP0013 ";
	// 先诊疗后付费标识
	private static final String KEY_OP_FCTCURE = "ENOP0050";
	// 门诊换号标识
	private static final String KEY_OP_CHANGE_PAT = "ENOP0070";

	private static final String KEY_REG_DEP = " en_reg_dep_bookable";
	// 住院天数的计算方式  0-记出不计入计算方式（11234） 1-临床计算方式（12345）
	private static final String KEY_CALCULATE_HOSDAYS_TYPE = "ENIP0210"; 
	
	//入院登记时是否需要先注册患者
    private static final String KEY_EN_ADM_NEEDREG = "ENIP0102";
    
    //病区床位就诊信息显示手术来源
    private static final String KEY_EN_DISPLAY_OPERA = "ENIP0235";
	/**
	 * 住院科室使用预约标识
	 */
	private static final String KEY_DEP_USE_APPT = "ENIP0070";
	/**
	 * 门诊没用医保需提示
	 */
	private static final String KEY_OP_NONHP_NEED_TIP = "ENOP0100";
	// 门诊就诊查询--全院查询权限
	private static final String KEY_OP_QRY_HOSPITAL = "ENAU0001";
	// 住院就诊查询--全院查询权限
	private static final String KEY_IP_QRY_HOSPITAL = "ENAU0002";

	// 医技预约检查项目类型
	private static final String SC_APT_CHK_OBS_ITM = "SC0030"; // 医技预约检查项目类型
	// GCP系统接诊挂号的排班服务id
	private static final String SC_APR_NOSCH_SCSRV = "SC0112" ;//GCP系统接诊挂号的排班服务id
	
	// 默认发药天数
	private static final String KEY_MP_DRUG_DAYS = "MPDGOP0003";
	//门诊药房是否对未配药处方叫号
	private static final String KEY_MP_DRUG_NOTPREPARE_CALL = "MPDGOP0110";
	// 把上一午别签到未接诊的门诊患者移入下一午别队列的优先级别
	private static final String KEY_OP_DS_LEVELPRI = "ENOP0020";

	// 绿色通道支持的患者价格分类
	private static final String KEY_EN_GCVIP_PRICCAIDS = "EN000030";
	// 绿色通道支持的排班服务
	private static final String KEY_EN_GCVIP_SCSRVIDS = "EN000040";
	// 是否同步chis
	private static final String KEY_EN_SYS_CHIS = "EN000060";
	// 是否同步用户科室关系表
	private static final String KEY_EN_SYS_EMPDEP = "EN000150";
	//门诊是否需要实名认证
	private static final String KEY_EN_OP_REQ_REALNAME = "ENOP0090";
	//最大叫号次数
	private static final String KEY_EN_OP_MAXCALLNUM = "ENOP0180";
	// VIP科室或病区
	private static final String KEY_EN_GCVIP_DEPIDS = "EN000042";
	//患者账户余额警示限
	private static final String KEY_PAT_ACC_BAL_WARN = "ENOP0190";
    //医保默认患者分类
    private static final String KEY_EN_OP_HP_DEFPATCAID = "ENOP0170";
    //门诊就诊次数开始值
    private static final String KEY_EN_OP_DEF_TIMESOP = "ENOP0150";
  	//门诊医生是否共享科室中待回诊的患者
    private static final String KEY_EN_OP_PATLIST_DEPSHARERET = "ENOP0201";
    //挂号即签到标志
    private static final String KEY_EN_OP_REGAUTOSIGN = "ENOP0210";
    //整个科室接诊权限
    private static final String KEY_EN_AU_WHOLEDEPTACPT = "ENAU0013";
    //入院登记可以使用的床位类型
    private static final String KEY_EN_IP_USE_BEDTP = "ENIP0108";
    //主任医师和住院医师是否可以相同
    private static final String KEY_EN_IP_ISZRANDZYSAME = "ENIP0110";
    //新生儿低烧体温
    private static final String KEY_EN_IP_NB_LOWFEVER = "ENIP0120";
    //新生儿高烧体温
    private static final String KEY_EN_IP_NB_HIGHTFEVER = "ENIP0130";
    //单患者多条在院记录
    private static final String KEY_EN_IP_MULTIP = "ENIP0140";
    //分诊使用加号大屏类型
  	private static final String KEY_EN_OP_BOARDTP = "ENOP0340";
  	//出科时间设置模式
  	private static final String KEY_EN_IP_LVHOSTIMETP = "ENIP0160";
    //可提前接诊时间
    private static final String KEY_EN_OP_ADVANCEACPTTIME = "ENOP0240";
    //区分床位性别
    private static final String KEY_EN_BED_HAS_SEX = "EN000070";
    //是否是共管科室
    private static final String KEY_EN_DEP_IDSHARE = "EN000100";
    //药房发药插入队列规则模式
    private static final String KEY_EN_PHM_QUEDISPENRULETP = "ENPH0010";
    //有排班医生是否可以使用科室普通号
    private static final String KEY_EN_OP_USEDEPSCH = "ENOP0300";
    //分诊大屏服务器设置
    private static final String KEY_EN_OP_BOARDSRVSETTING= "ENOP0341";
    //0-护士指定三级医师 1-医生指定三级医师 2-可以不指定三级医师
    private static final String KEY_EN_IP_ARRANGEPHYTP = "ENIP0180";
    //免挂号费挂号使用的排班服务
    private static final String KEY_SC_FREE_REGIST_SCSRVID = "SC0110";
    //挂号接诊时使用的号别类型
    private static final String KEY_EN_OP_UNREG_SRVTP= "ENOP0290";
    //患者是否一天只收一次挂号费
    private static final String KEY_EN_OP_UNREG_ISCHGONE = "ENOP0030";
    //是否叫号后候诊队列才上屏
    private static final String KEY_EN_OP_ISONDISPLAY_AFTERCALL = "ENOP0344";
    //门诊分诊中站点下的已诊患者是否显示全天患者
    private static final String KEY_EN_OP_IS_CURRENTDAYSLOT_ALLDAY = "ENOP0349";
    //患者分类为医保时 接诊是否保存医保信息
    private static final String KEY_EN_OP_ISSAVEHP = "ENOP0211";
    // 新生儿是否允许母婴分床
    private static final String KEY_IP_CAN_MMBBSEPA = "ENIP0191";
    
    //未挂号接诊病人的患者分类
    private static final String KEY_EN_OP_ACPT_PATCA = "ENOP0017";
    //分诊模式(0-分诊到站点；1-分诊到医生)
    private static final String KEY_EN_OP_TRIAGEMODE = "ENOP0345";
    //当日退院是否需先取消入科
    private static final String KEY_EN_CANCIP_NEED_CANCAPT = "ENIP0091";
    //新生儿最大年龄天数
    private static final String KEY_EN_NEWBB_MAX_DAYS = "ENIP0162";
    //患者每次住院，住院号是否变化
    private static final String KEY_EN_IP_ISCODECHANGE = "ENIP0196";
    //队列管理模式
    private static final String KEY_EN_MODE_QUEMGR = "ENOP0347";
    //顺序接诊回诊时间限制(分钟)
    private static final String KEY_EN_PVORDERACPT_RTNTM = "ENOP0022";
    //顺序接诊就诊优先级限制
    private static final String KEY_EN_PVORDERACPT_LEVEL = "ENOP0023";
    //是否使用未挂号分诊
    private static final String KEY_EN_OP_ISUSENOREGTRIAGE = "ENOP0342";
    //门诊挂号，入院登记是否同步患者分类，价格分类，信用分类
    private static final String KEY_EN_SYNCPATCA = "EN000160"; 
    //门急诊患者回诊是否重新分配顺序号
    private static final String KEY_EN_OP_RECREATESORTNO = "ENOP0348";
    //在门诊预约中直接使用的患者分类
    private static final String KEY_SC_PATCA_APTSELFPAY = "SC0021";
    //诊间预约医生查询权限0-医生预约权限；1-预约科室内；2-预约全院
    private static final String KEY_SC_CLINIC_DOC = "ENAU0007";
    ///////////////////////---急诊参数---//////////////////////////////
    //急诊流水接诊急诊类型
    private static final String KEY_EN_ER_ERTPCOMM = "ENER0040";
    //非流水接诊急诊类型
    private static final String KEY_EN_ER_ERTPNOCOMM = "ENER0050";
    //急诊处理患者列表中显示多长时间内的患者（小时）
    private static final String KEY_EN_ER_LEAVELIST_HOURS = "ENER0020";
    //急诊留观就诊次数的开始值
    private static final String KEY_EN_ER_DEF_TIMESOBS = "ENER0070";
    //急诊预检有效期(小时)
    private static final String KEY_EN_ER_ERPREVALID = "ENER0090";
    //急诊留观使用的住院特定类型 （00-住院 02-留观患者），默认为00-住院
    private static final String KEY_EN_ER_SD_IPTYPE = "ENER0100";
    //////////////////////////////预住院//////////////////////////////
    //预住院转住院是否需要转出转入
    private static final String KEY_EN_IP_IPPRE_TRANCS = "ENIP0300";
    //预住院转住院转出校验
    private static final String KEY_EN_IP_IPPRE_TRANCSCHECK = "ENIP0310";
    //预住院出院患者列表患者显示天数
    private static final String KEY_EN_IP_IPPRE_LVHOSPATSDISPLAYDAYS = "ENIP0303";
    
    ////////////////////////////////////////////////////////////////
    
    /***
     * @Description:诊间挂号结算模式结算操作员类型
     * @param ctx
     * @return
     */
    public static String getEnStEmpTpForOpinReg()
    {
        String param = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_STEMP_TPYE);
        return param;
    }
    /***
     * @Description:诊间结算虚拟结算人员
     * @param ctx
     * @return
     */
    public static String getBlVirtualOprEmp()
    {
        String param = getOrgParamValue(EnContextUtils.getOrgId(), KEY_BL_VIRTUAL_OPREMP);
        return param;
    }
    
    /***
     * @Description:药房分窗口候诊是否包含配药
     * @param ctx
     * @return
     */
    public static boolean havePrepare()
    {
        String param = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_HAVA_PHRAM_PREPARE);
        return Boolean.parseBoolean(param);
    }
    
    /***
     * @Description:门诊挂号是否使用医保结算
     * @param ctx
     * @return
     */
    public static boolean userHpStForReg(String id_hp)
    {
        String param = getInstanceParamValue(id_hp, KEY_EN_REH_USE_HP_ST);
        return Boolean.parseBoolean(param);
    }
    
    /***
     * @Description:诊间挂号接诊结算模式,默认 0-记账模式
     * @param ctx
     * @return
     */
    public static boolean isOpinregSt(String depId)
    {
        String param = getDepParamValue(depId, KEY_EN_MAXCALLNUM);
        return "1".equals(param);
    }
    
    /**
     * 获取在门诊预约中直接使用的患者分类
     * 
     * @return
     */
    public static String getAptSelfPayPatCaIds(){
    	return getOrgParamValue(EnContextUtils.getOrgId(), KEY_SC_PATCA_APTSELFPAY);
    }
    /**
     * 门急诊患者回诊是否重新分配顺序号
     * 
     * @return
     */
    public static boolean isReCreateSortNo(){
    	String param = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_OP_RECREATESORTNO);
    	return Boolean.parseBoolean(param);
    }
    /**
     * 门诊挂号，入院登记是否同步患者分类，价格分类，信用分类
     * 
     * @return
     */
    public static boolean isSyncPatCa(){
    	String param = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_SYNCPATCA);
    	return Boolean.parseBoolean(param);
    }
    
    /**
     * 是否使用未挂号分诊
     * 
     * @return
     */
    public static final boolean isUseNoRegTriage(){
    	String param = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_OP_ISUSENOREGTRIAGE);
    	return Boolean.parseBoolean(param);
    }
    /**
     * 是否是共管科室
     * 
     * @param depId
     * @return
     */
    public static final boolean isShareDep(String depId){
    	String param = getDepParamValue(depId, KEY_EN_DEP_IDSHARE);
    	if(!EnValidator.isEmpty(param)){
    		return Integer.parseInt(param) == 1;
    	}
    	return false;
    }
    /**
     * 获取顺序接诊回诊时间限制(分钟)
     * 
     * @return
     */
    public static final int getPvOrderAcptRtnMin(String depId){
    	String paramValue = getDepParamValue(depId, KEY_EN_PVORDERACPT_RTNTM);
		if (!EnValidator.isEmpty(paramValue)) {
			return Integer.parseInt(paramValue);
		}
		return 0; 
    }
    /**
     * 顺序接诊就诊优先级限制(默认100)
     * 
     * @return
     */
    public static final int getPvOrderAcptLevel(){
    	String paramValue = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_PVORDERACPT_LEVEL);
		if (!EnValidator.isEmpty(paramValue)) {
			return Integer.parseInt(paramValue);
		}
		return 100; 
    }
    /**
     * 是否是分诊台管理模式
     * 
     * @return
     */
    public static boolean isBenQueMgr(){
    	String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_MODE_QUEMGR);
    	return "1".equals(paramValue);
    }
    /**
     * 新生儿最大年龄天数
     * 
     * @return
     */
    public static int getMaxNewbbDays(){
    	String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_NEWBB_MAX_DAYS);
		if (!EnValidator.isEmpty(paramValue)) {
			return Integer.parseInt(paramValue);
		}
		return 0; 
    }
    /**
     * 当日退院是否需先取消入科,0-不需要；1-需要
     * 
     * @return
     */
    public static int getNeedCancAptForCancIp(){
    	String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_CANCIP_NEED_CANCAPT);
		if (!EnValidator.isEmpty(paramValue)) {
			return Integer.parseInt(paramValue);
		}
		return 0; 
    }
	/**
     * 是否分诊到医生
     * 分诊模式(0-分诊到站点；1-分诊到医生)
     * 
     * @return
     */
    public static boolean isTriageToEmp(){
    	String param = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_OP_TRIAGEMODE);
    	return "1".equals(param);
    }
    /**
	 * 获取最大叫号次数-药房队列使用
	 * 
	 * @return
	 */
	public static int getMaxCallNumParam(String depId) {
		String bedSexParam = getDepParamValue(depId, PK_EN_OP_IS_OPINREGST);
			return Integer.parseInt(bedSexParam);
	}
    /**
     * 获取挂号接诊患者结算模式
     * 
     * @return
     */
    public static int getEnUnregBlTp(){
    	String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_OP_UNREG_BLTP);
		if (!EnValidator.isEmpty(paramValue)) {
			return Integer.parseInt(paramValue);
		}
		return 0; 
    }
    /**
     * 获取可提前接诊时间
     * 
     * @return
     */
    public static int getAdvanceAcptTime(){
    	String paramValue = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_OP_ADVANCEACPTTIME);
		if (!EnValidator.isEmpty(paramValue)) {
			return Integer.parseInt(paramValue);
		}
		return 0; 
    }
      
    /**
     * 获取分诊使用加号大屏类型,0-iih本系统大屏；1-威发大屏
     * 
     * @return
     */
    public static int getEnBrdTp(){
    	String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_OP_BOARDTP);
		if (!EnValidator.isEmpty(paramValue)) {
			return Integer.parseInt(paramValue);
		}
		return 0; 
    }
    /**
     * 是否有全科接诊权限
     * 
     * @param psnId
     * @return
     */
    public static boolean hasWholeDeptAcptAuth(String psnId){
    	String hasAuth = getInstanceParamValue(psnId, KEY_EN_AU_WHOLEDEPTACPT);
		return Boolean.parseBoolean(hasAuth);
    }
    /**
     * 获取诊间预约查询权限
     * @param psnId
     * @return
     */
    public static String getDeptAuthClicDoc(String psnId){
    	return getInstanceParamValue(psnId, KEY_SC_CLINIC_DOC);
    }
    /**
     * 患者分类为医保时 接诊是否保存医保信息
     * 
     * @param psnId
     * @return
     */
    public static boolean isSaveHPAtAcpt(){
    	String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_OP_ISSAVEHP);
		if (!EnValidator.isEmpty(paramValue)) {
			return Boolean.parseBoolean(paramValue);
		}
		return  false;
    }
    /**
     * 是否叫号后才上屏
     * 
     * @param psnId
     * @return
     */
    public static boolean isOnDisplayAfterCall(){
    	String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_OP_ISONDISPLAY_AFTERCALL);
		if (!EnValidator.isEmpty(paramValue)) {
			return Boolean.parseBoolean(paramValue);
		}
		return  false;
    }
    /**
     * 门诊分诊中站点下的已诊患者是否显示全天患者
     * 
     * @param 
     * @return
     */
    public static int isCurrentDaysltAllDay(){
    	String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_OP_IS_CURRENTDAYSLOT_ALLDAY);
		if (!EnValidator.isEmpty(paramValue)) {
			return Integer.parseInt(paramValue);
		}
		return  0;
    }
    /**
     * 是否是挂号即签到
     * @return
     */
    public static boolean isRegAutoSign(String benId){
    	String paramValue = getInstanceParamValue(benId, KEY_EN_OP_REGAUTOSIGN);
    	if(!EnValidator.isEmpty(paramValue)){
    		return "1".equals(paramValue.trim());
    	}
    	return false;
    }
    /**
     * 门诊医生是否共享科室中待回诊的患者
     * 0-不共享 1-共享
     * @return
     */
    public static int getPatListShareRet(){
    	String paramValue = getDepParamValue(EnContextUtils.getDeptId(),KEY_EN_OP_PATLIST_DEPSHARERET);
		if (!EnValidator.isEmpty(paramValue)) {
			return Integer.parseInt(paramValue);
		}
		return 0; 
    }
    /**
     * 获取门诊就诊次数开始值
     * 
     * @return
     */
    public static int getDefTimesOp(){
    	String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_OP_DEF_TIMESOP);
		if (!EnValidator.isEmpty(paramValue)) {
			return Integer.parseInt(paramValue);
		}
		return 0; 
    }
    /**
     * 获取刷医保默认患者分类
     * 
     * @return
     */
    public static String getHpDefPatcaId(){
    	return getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_OP_HP_DEFPATCAID);
    }    
    
    /**
     * 获取患者分类
     * 
     * @return
     */
    public static String getAcptPatca(){
    	return getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_OP_ACPT_PATCA);
    }
	/**
	 * 把上一午别签到未接诊的门诊患者移入下一午别队列的优先级别
	 * 
	 * @return
	 */
	public static int getOpDsLevelPri() {
		String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_OP_DS_LEVELPRI);
		if (!EnValidator.isEmpty(paramValue)) {
			return Integer.parseInt(paramValue);
		}
		return 0;
	}
	
	/**
	 * 判定是否同步chis
	 * 
	 * @return
	 */
	public static Boolean getIsSysChis() {
		String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_SYS_CHIS);
		if (!EnValidator.isEmpty(paramValue)) {
			return Boolean.parseBoolean(paramValue);
		}
		return false;
	}
	
	/**
	 * 判定是否同步用户科室关系表  (0不同步 1同步)
	 * 
	 * @return
	 */
	public static Boolean getIsSysEmpDep(String id_org) {
		if(id_org == null){
			return false;
		}
		String paramValue = getOrgParamValue(id_org,KEY_EN_SYS_EMPDEP);
		if (0 == Integer.parseInt(paramValue)) {
			return false;
		}
		return true;
	}
	/**
	 * 0-护士指定三级医师 1-医生指定三级医师 2-可以不指定三级医师
	 * 
	 * @return
	 */
	public static int getEnIpArrangePhyTp () {
		String paramValue = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_IP_ARRANGEPHYTP);
		if (EnValidator.isEmpty(paramValue)) {
			return IEnConst.NURSE_APPOINT;
		}
		return Integer.parseInt(paramValue);
	}
	

	/**
	 * 获取默认发药天数
	 * 
	 * @param depId
	 * @return
	 */
	public static int getDrugDays(String depId) {
		String paramValue = getOrgParamValue(depId, KEY_MP_DRUG_DAYS);
		if (!EnValidator.isEmpty(depId)) {
			return Integer.parseInt(paramValue);
		}
		return 0;
	}
	
	/**
	 * 门诊药房是否对未配药处方叫号
	 * 
	 * @param depId
	 * @return
	 */
	public static boolean getDrugNotPrepareCall(String depId) {
		String paramValue = getDepParamValue(depId, KEY_MP_DRUG_NOTPREPARE_CALL);
		if (!EnValidator.isEmpty(depId)) {
			return "1".equals(paramValue);
		}
		return false;
	}
	
	/**
	 * 获取门诊挂号有效期 默认为24小时
	 * 
	 * @return
	 * @throws BizException 
	 */
	public static int getOpValidHours(String id_dep) throws BizException {
		try{
			Integer param = ParamsetQryUtil.getParaIntByComplex(new String[]{id_dep,EnContextUtils.getOrgId()},null,KEY_OP_VALID_PERIOD);
			if(param == null){
				return IEnConst.DEFAULT_OP_VALID_HOURS;
			}
			return param;
		}catch(BizException e){
			return IEnConst.DEFAULT_OP_VALID_HOURS;
		}
	}
	
	/**
	 * 诊间候诊数量是否包含过号患者
	 * 
	 * @param depId
	 * @return
	 */
	public static boolean getIncludeOverNumberPat(String depId) {
		String paramValue = getDepParamValue(depId, KEY_OP_IS_INCLUDE_OVERNUMBER_PAT);
		if (!EnValidator.isEmpty(depId)) {
			return "0".equals(paramValue);
		}
		return false;
	}
	
	/**
	 * 获取急诊挂号有效期 默认为24小时
	 * 
	 * @return
	 */
	public static int getEmgValidHours() {
		// String paramValue =
		// getParamValue(EnContextUtils.getOrgId(),KEY_EMG_VALID_PERIOD);
		String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_EMG_VALID_PERIOD);
		if (!EnValidator.isEmpty(paramValue)) {
			return Integer.parseInt(paramValue);
		}
		return IEnConst.DEFAULT_EM_VALIDA_HOURS;
	}

	/**
	 * 获取挂号规则引擎是否调用参数
	 * 
	 * @return
	 */
	public static Boolean getEnOpRegMvel() {
		String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_OP_REG_MVEL);
		return Boolean.parseBoolean(paramValue);
	}

	/**
	 * 获取就诊队列有效期(天)
	 * 
	 * @return
	 */
	public static int getQueValidPeriod() {
		String days = getOrgParamValue(EnContextUtils.getOrgId(),KEY_QUE_VALID_PERIOD);
		if (!EnValidator.isEmpty(days)) {
			return Integer.parseInt(days);
		}
		return 0;
	}

	/**
	 * 获取门诊医生诊断最大时长，以分钟为单位
	 * 
	 * @return
	 */
	public static int getOpMaxDiPeriodm() {
		String mins = getOrgParamValue(EnContextUtils.getOrgId(),KEY_OP_MAX_DI_PERIODM);
		if (!EnValidator.isEmpty(mins)) {
			return Integer.parseInt(mins);
		}
		return 0;
	}

	/**
	 * 门诊是否可换号
	 * 
	 * @return
	 */
	public static Boolean canChangeOpRegPat() {
		String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_OP_CHANGE_PAT);
		return Boolean.parseBoolean(paramValue);
	}

	/**
	 * 住院天数的计算方式
	 * 0-记出不计入计算方式（11234） 1-临床计算方式（12345）
	 * @return
	 */
	public static Integer GetCalculateHosDaysType(){
		String param = getOrgParamValue(EnContextUtils.getOrgId(), KEY_CALCULATE_HOSDAYS_TYPE);
		if(!EnValidator.isEmpty(param))
			return Integer.parseInt(param);
		return null;
	}
	
	/**
	 * Pc可挂号的科室
	 * 
	 * @param pcId 计算机ID
	 * @return
	 */
	public static String getPcAvlRegDepIds(String pcId) {
		String paramValue = getPcParamValue(pcId, KEY_EN_PC_MG_DEPIDS);
		return paramValue;
	}

	/**
	 * 大屏叫号患者信息显示模板
	 * @param pcId
	 * @return
	 */
	public static String getPcCallInfoModel(String pcId){
		return getPcParamValue(pcId, KEY_BRD_CALL_PATINFO);
	}
	
	/**
	 * 大屏过号患者信息显示模板
	 * @param pcId
	 * @return
	 */
	public static String getPcPassInfoModel(String pcId){
		return getPcParamValue(pcId, KEY_BRD_PASS_PATINFO);
	}
	
	/**
	 * 得到科室的跨科接诊标识
	 * 
	 * @param depId
	 * @return 1.该科室的挂号患者可被别的科跨科接诊 2.该科室可跨科接诊别的科的病人
	 */
	public static String getCrossDepAcpt(String depId) {
		String paramValue = getDepParamValue(depId, KEY_ACPT_CROSS_DEPT);
		return paramValue;
	}

	/**
	 * 是否可以不挂号接诊
	 * 
	 * @return
	 */
	public static Boolean canAcptUnReg() {
		String paramValue = getDepParamValue(EnContextUtils.getOrgId(),KEY_OP_ACPT_UNREG);
		return Boolean.parseBoolean(paramValue);
	}

	/**
	 * 是否可以不挂号接诊
	 * 
	 * @return
	 */
	public static Boolean canPayAfterDi() {
		String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_OP_FCTCURE);
		return Boolean.parseBoolean(paramValue);
	}

	/**
	 * 门诊就诊，没用医保是否需要提示
	 * 
	 * @return
	 */
	public static Boolean opNonHpNeedNotice() {
		String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_OP_NONHP_NEED_TIP);
		return Boolean.parseBoolean(paramValue);
	}

	/**
	 * 获取预约是否确认
	 * 
	 * @return
	 */
	public static Boolean getAptNeedCfm() {
		String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_APT_NEEDCFM);
		return Boolean.parseBoolean(paramValue);
	}
	/**
	 * 获取取消预约中退款记录使用的退款人
	 * @return
	 * @throws BizException
	 */
	public static String getScCancAptRefundOperator() throws BizException {
		String param = getOrgParamValue(EnContextUtils.getOrgId(), KEY_SC_CANC_APT_REFUND_OPERATOR);
		return param;
	}
	/**
	 * 获取预约无需短信通知的渠道类型
	 *
	 * @param orgId 组织ID
	 * @return 渠道类型，用逗号分隔
	 * @author yank
	 */
	public static String getNoteExclChlTp(String orgId) {
		String paramValue = getOrgParamValue(orgId,KEY_SC_NOTE_EXCL_CHLTP);
		return paramValue;
	}
	/**
	 * 获取绿色通道预约通知电话
	 *
	 * @param orgId 组织ID
	 * @return 电话号码，多个用逗号分隔
	 * @author yank
	 */
	public static String getGcVipNoteTel(String orgId) {
		String paramValue = getOrgParamValue(orgId,KEY_SC_GCVIP_NOTE_TEL);
		return paramValue;
	}
	/**
	 * 获取需短信通知复诊的科室ID
	 *
	 * @param orgId 组织ID
	 * @return 科室ID，用逗号分隔
	 * @author yank
	 */
	public static String getNoteRtnDepIds(String orgId) {
		String paramValue = getOrgParamValue(orgId,KEY_SC_NOTE_RTN_DEPIDS);
		return paramValue;
	}
	/**
	 * 获取患者账户余额警示值
	 * @param orgId
	 * @return
	 */
	public static FDouble getPatAccBalWarn(String orgId){
		String paramValue = getOrgParamValue(orgId, KEY_PAT_ACC_BAL_WARN);
		return new FDouble(paramValue);
	}
	/**
	 * 获取药房发药插队列规则模式 
	 * 01-按队列产生  
	 * 02-各在线窗口循环发药
	 * 
	 * @return
	 */
	public static String getQueDispenRuleTp(){
		return getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_PHM_QUEDISPENRULETP);
	}
	/**
	 * 有排班医生是否可以使用科室普通号
	 * 
	 * @return
	 */
	public static boolean isUseDeptSch(String depId){
		String param = getDepParamValue(depId, KEY_EN_OP_USEDEPSCH);
		return Boolean.parseBoolean(param);
	}
	/**
	 * 获取分诊大屏服务器设置
	 * 
	 * @return
	 */
	public static String getBoardSrvSetting(){
		return getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_OP_BOARDSRVSETTING);
	}
	/**
	 * 获取零挂的排班服务
	 * 
	 * @return
	 */
	public static String GetFreeRegistScSrvId(){
        return getOrgParamValue(EnContextUtils.getOrgId(), KEY_SC_FREE_REGIST_SCSRVID);
    }
	/**
	 * 挂号接诊时使用的号别
	 * 0-默认选择的排班的号别  1-医生个人队列的主排班服务
	 * 
	 * @return
	 */
	public static String GetUnregSrvTp(){
		return getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_OP_UNREG_SRVTP);
	}
	/**
	 * 患者是否一天只收一次挂号费
	 * 
	 * @author liubin
	 * 
	 * @return
	 */
	public static boolean IsUnregChagOne(){
		String param = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_OP_UNREG_ISCHGONE);
		if(!EnValidator.isEmpty(param)){
			return 1 == Integer.parseInt(param);
		}
		return false;		
	}
	
	/*-----------------------住院----------------------------------------*/
	
	/**
	 * 获取入院通知到有效时间
	 * 
	 * @return
	 */
	public static Integer getIpntValidTime() {
		String validDays = getOrgParamValue(EnContextUtils.getOrgId(),KEY_IPNT_VALID_DAYAS);
		if (validDays != null) {
			return Integer.parseInt(validDays);
		}
		return null;
	}

	/**
	 * 科室是否使用预约
	 * 
	 * @param depId 科室id
	 * @return
	 */
	public static boolean isDepUseApt(String depId) {
		String paramValue = getDepParamValue(depId, KEY_DEP_USE_APPT);
		return Boolean.parseBoolean(paramValue);
	}

	/**
	 * 获取转科--转科室检查配置参数
	 * 
	 * @return
	 */
	public static String getTransDepCheckCfg() {
		return getOrgParamValue(EnContextUtils.getOrgId(),PK_TRANS_DEP_CHK);
	}

	/**
	 * 获取转科--转病区检查配置参数
	 * 
	 * @return
	 */
	public static String getTransWardCheckCfg() {
		return getOrgParamValue(EnContextUtils.getOrgId(),PK_TRANS_WARD_CHK);
	}
	/**
	 * 获取转科检查的医技服务类型
	 * 
	 * @return
	 */
	public static String getTransDepCheckTechSrvTps() {
		return getOrgParamValue(EnContextUtils.getOrgId(),KEY_TRANS_DEP_SRVTPS_TECH);
	}

	/**
	 * 获取转科检查的非医技服务类型
	 * 
	 * @return
	 */
	public static String getTransDepCheckNonTechSrvTps() {
		return getOrgParamValue(EnContextUtils.getOrgId(),KEY_TRANS_DEP_SRVTPS_NONTECH);
	}
	/**
	 * 获取转科不需核查的科室
	 * 
	 * @returnKEY_TRANS_IDSNOCHECK
	 */
	public static String GetTranNoCheckIds(){
		return getOrgParamValue(EnContextUtils.getOrgId(), KEY_TRANS_IDSNOCHECK);
	}
	/**
	 * 出院、转科核查医技项目,执行项目的核查方式 0-按执行核查 1-按费用核查 2-按闭环中是否可出科核查(暂未使用）
	 * 
	 * @return
	 */
	public static Integer GetCheckMtTp(){
		String param = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_CHECKMT_TP);
		if(!EnValidator.isEmpty(param))
			return Integer.parseInt(param);
		return null;
	}
	/**
	 * 获取出院检查配置参数
	 * 
	 * @return
	 */
	public static String getLeaveHosCheckCfg() {
		return getOrgParamValue(EnContextUtils.getOrgId(),PK_LEAVE_HOS_CHK);
	}
	/**
	 * 获取出院检查的医技服务类型
	 * 
	 * @return
	 */
	public static String getLvHosCheckTechSrvTps() {
		return getOrgParamValue(EnContextUtils.getOrgId(),KEY_LEAVE_HOS_SRVTPS_TECH);
	}

	/**
	 * 获取配置参数-中止预住院检查内容标志串
	 * 
	 * @return
	 */
	public static String getIppreCancHosCheckCfg() {
		return getOrgParamValue(EnContextUtils.getOrgId(),PK_IPPRE_CANCEL_HOS_CHK);
	}
	
	/**
	 * 获取出院检查的非医技服务类型
	 * 
	 * @return
	 */
	public static String getLvHosCheckNonTechSrvTps() {
		return getOrgParamValue(EnContextUtils.getOrgId(),KEY_LEAVE_HOS_SRVTPS_NONTECH);
	}
	
	/**
	 * 新生儿是否校验出院医嘱
	 * 
	 * @return
	 */
	public static boolean getNBChkLeaveOrd() {
		return Boolean.parseBoolean(getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_IP_NBCHKLEAVEORD));
	}

	/**
	 * 是否打印号条
	 * 
	 * @return
	 */
	public static boolean isPrintTicket() {
		String prnTps = getPcParamValue(EnContextUtils.getPcId(),KEY_OP_REG_PRNTPS);
		return (prnTps != null && prnTps.contains("01"));
	}

	/**
	 * 是否打印发票
	 * 
	 * @return
	 */
	public static boolean isPrintInvoice() {
		String prnTps = getPcParamValue(EnContextUtils.getPcId(),KEY_OP_REG_PRNTPS);
		return (prnTps != null && prnTps.contains("02"));
	}

	/**
	 * 获取医技分诊台id
	 * 
	 * @return
	 */
	public static String getMedTechBenId(String pcId) {
		// return getSysParamValue(PK_TECH_TRIAGE_BEN_ID);
		return getPcParamValue(pcId, PK_TECH_TRIAGE_BEN_ID);
	}

	/**
	 * 是否含有门诊全院查询权限
	 * 
	 * @param psnId 人员ID
	 * @return boolean
	 */
	public static boolean hasOpQryInHos(String psnId) {
		String hasAuth = getInstanceParamValue(psnId, KEY_OP_QRY_HOSPITAL);
		return Boolean.parseBoolean(hasAuth);
	}

	/**
	 * 是否含有住院全院查询权限
	 * 
	 * @param psnId 人员ID
	 * @return boolean
	 */
	public static boolean hasIpQryInHos(String psnId) {
		String hasAuth = getInstanceParamValue(psnId, KEY_IP_QRY_HOSPITAL);
		return Boolean.parseBoolean(hasAuth);
	}

	/**
	 * 获取是否为医技预约检查项目类型
	 * 
	 * @return
	 */
	public static FBoolean getscAptCOI() {
		String fbool =getOrgParamValue(EnContextUtils.getOrgId(),SC_APT_CHK_OBS_ITM);
		return new FBoolean(fbool);
	}
	
	/**
	 * GCP系统接诊挂号的排班服务id
	 * 
	 * @return
	 */
	public static String geNoSchScSrv() {
		return getOrgParamValue(EnContextUtils.getOrgId(),SC_APR_NOSCH_SCSRV);
	}
	
	/**
	 * 获取绿色通道支持的患者价格分类参数
	 *
	 * @return
	 * @author zhengcm
	 */
	public static String getEnGcvipPriccaIds() {
		return getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_GCVIP_PRICCAIDS);
	}

	/**
	 * 绿色通道支持的排班服务参数
	 *
	 * @return
	 * @author zhengcm
	 */
	public static String getEnGcvipScsrvIds() {
		return getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_GCVIP_SCSRVIDS);
	}
	
	/**
	 * VIP科室或病区
	 *
	 * @return
	 */
	public static String getEnGcvipDepIds() {
		return getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_GCVIP_DEPIDS);
	}
	/**
	 * 获取门诊实名认证参数
	 * @return
	 */
	public static Integer getEnOpReqRealName(){
		String reqRealNameParam = getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_OP_REQ_REALNAME);
		return Integer.parseInt(reqRealNameParam);
	}
	/**
	 * 获取最大叫号次数
	 * 
	 * @return
	 */
	public static int getMaxCallNum(String depId){
		String maxValue = getDepParamValue(depId, KEY_EN_OP_MAXCALLNUM);
		if(!EnValidator.isEmpty(maxValue))
			return Integer.parseInt(maxValue);
		return 0;
	}
	/**
	 * 入院登记可以使用的床位类型
	 * @return
	 */
	public static String getEnIpUseBedTp(String depId){
		return getDepParamValue(depId, KEY_EN_IP_USE_BEDTP);
	}
	/**
	 * 主任医师和住院医师是否可以相同
	 * 
	 * @return
	 */
	public static boolean isZrZyCanSame(){
		String value = getDepParamValue(EnContextUtils.getDeptId(), KEY_EN_IP_ISZRANDZYSAME);
		return Boolean.parseBoolean(value);
	}
	/**
	 * 获取新生儿低烧体温
	 * 
	 * @return
	 */
	public static FDouble getNbLowFever(){
		String value = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_IP_NB_LOWFEVER);
		FDouble fever = null;
		try{
			fever = new FDouble(value);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return fever;
	}
	/**
	 * 获取新生儿高烧体温
	 * 
	 * @return
	 */
	public static FDouble getNbHightFever(){
		String value = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_IP_NB_HIGHTFEVER);
		FDouble fever = null;
		try{
			fever = new FDouble(value);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return fever;
	}
	/**
	 * 单患者是否可以多条在院记录
	 * 
	 * @return
	 */
	public static boolean isMultIp(){
		String value = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_IP_MULTIP);
		if(value==null)
			return false;
		try {
			return Integer.parseInt(value) == 1;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 出科时间设置模式
	 * 
	 * @return
	 */
	public static Integer getLvHosTimeTP() {
		return Integer.parseInt(getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_IP_LVHOSTIMETP));
	}
	
	/**
	 * 获取区分床位性别参数
	 * 
	 * @return
	 */
	public static int getBedSexParam(String depId) {
		String bedSexParam = getDepParamValue(depId, KEY_EN_BED_HAS_SEX);
		return Integer.parseInt(bedSexParam);
	}
	
	/**
	 * 患者多次住院 住院号是否改变
	 * @return
	 */
	public static boolean getIsChangeIpCode(){
		String value = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_IP_ISCODECHANGE);
		return Boolean.parseBoolean(value);
	}
	
	/**
	 * 患者多次住院 住院号是否改变
	 * @return
	 */
	public static boolean getIsCanMmBbSepa(){
		String value = getOrgParamValue(EnContextUtils.getOrgId(), KEY_IP_CAN_MMBBSEPA);
		return "1".equals(value);
	}
	
    ///////////////////////---急诊参数方法---//////////////////////////////
    /**
     * 获取急诊留观就诊次数开始值
     * 
     * @return
     */
    public static int getDefTimesObs(){
    	String paramValue = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_ER_DEF_TIMESOBS);
		if (!EnValidator.isEmpty(paramValue)) {
			return Integer.parseInt(paramValue);
		}
		return 0; 
    }
    /**
     * 获取急诊流水接诊急诊类型
     * @return
     */
    public static String[] getErTpComm(){
    	String param = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_ER_ERTPCOMM);
    	if(EnValidator.isEmpty(param))
    		return null;
    	return param.split(",");
    }
    /**
     * 获取非流水接诊急诊类型
     * @return
     */
    public static String[] getErTpNoComm() throws BizException{
    	String param = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_ER_ERTPNOCOMM);
    	if(EnValidator.isEmpty(param))
    		throw new BizException(String.format("参数[%s]配置错误！", KEY_EN_ER_ERTPNOCOMM));
    	return param.split(",");
    }
    /**
     * 获取患者列表中显示多长时间内的患者（小时）
     * @return
     */
    public static int getErLeaveListHours(){
    	String param = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_ER_LEAVELIST_HOURS);
    	if (!EnValidator.isEmpty(param)) {
			return Integer.parseInt(param);
		}
		return 0; 
    }
    /**
     * 病区床位就诊信息显示手术来源
     * @author lilei
     * @date 2020年4月26日
     */
    public static int getDisplayOpera(){
    	String paramValue = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_DISPLAY_OPERA);
		if (!EnValidator.isEmpty(paramValue)) {
			return Integer.parseInt(paramValue);
		}
		return 0; 
    }
	/**
	 * 急诊预检有效期(小时)
	 * 
	 * @return
	 */
    public static int getErPreValid(){
    	String param = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_ER_ERPREVALID);
    	int erPreValid = 0;
    	if(!EnValidator.isEmpty(param)){
    		erPreValid = Integer.parseInt(param);
    	}
    	return erPreValid <= 0 ? 24 : erPreValid;
    }
    /**
     * 急诊留观使用的住院特定类型（00-住院 02-留观患者），默认为00-住院
     * @author lilei
     * @date 2020年4月28日
     */
    public static String getErSdIptype(){
    	String paramValue = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_ER_SD_IPTYPE);
		if (EnValidator.isEmpty(paramValue)) {
			paramValue = "00";
		}
		return paramValue; 
    }
    
	// ///////////////////////////////////////////////////////////////////////////////
	/**
	 * 获取PC参数
	 * 
	 * @param pcId PC的KEY
	 * @param paramCode 参数编码
	 * @return
	 */
	private static String getPcParamValue(String pcId, String paramCode) {
		try {
			return ParamsetQryUtil.getParaStringByInstance(pcId, paramCode);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取部门参数
	 * 
	 * @param depId 部门id
	 * @param paramCode 参数编码
	 * @return
	 */
	private static String getDepParamValue(String depId, String paramCode) {
		return getParamValue(depId, paramCode);
	}

	/**
	 * 获取组织参数
	 * 
	 * @param orgId 组织id
	 * @param paramCode 参数编码
	 * @return
	 */
	private static String getOrgParamValue(String orgId, String paramCode) {
		return getParamValue(orgId, paramCode);
	}

	/**
	 * 获取集团参数
	 * 
	 * @param groupId 集团id
	 * @param paramCode 参数编码
	 * @return
	 */
	private static String getGrpParamValue(String groupId, String paramCode) {
		return getParamValue(groupId, paramCode);
	}

	/**
	 * 获取全局参数
	 * 
	 * @param paramCode 参数编码
	 * @return
	 */
	private static String getGlobalParamValue(String paramCode) {
		return getParamValue(IOrgConst.GLOBEORG, paramCode);
	}

	/**
	 * 获取系统参数
	 * 
	 * @param paramCode 参数编码
	 * @return
	 */
	private static String getSysParamValue(String paramCode) {
		return getParamValue(IOrgConst.GLOBEORG, paramCode);
	}

	/**
	 * 获取参数
	 * 
	 * @param dataId
	 * @param paramCode
	 * @return
	 */
	private static String getParamValue(String dataId, String paramCode) {
		// 框架提供的方法
		String val = "";
		try {
			val = ParamsetQryUtil.getParaString(dataId, paramCode);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return val;
	}

	/**
	 * 获取参数
	 * 
	 * @param dataId
	 * @param paramCode
	 * @return
	 */
	private static String getInstanceParamValue(String dataId, String paramCode) {
		try {
			return ParamsetQryUtil.getParaStringByInstance(dataId, paramCode);
		} catch (BizException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 出科患者是否显示归档患者 0-不显示 1-显示	
	 * 
	 * @return
	 */
	public static Boolean getKeyEnIpOut() {	
		String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_IP_OUT_PATS);
		if (!EnValidator.isEmpty(paramValue)) {
			if(0==Integer.parseInt(paramValue)){
				return false;
			}else{
				return true;
			}
		}
		return false;
	}
	/**
     * 入院登记时是否需要先注册患者
     */
    public static boolean isEnAdmNeedReg()
    {
        //0-不需要先注册；1-需要先注册
    	String paramValue = getOrgParamValue(EnContextUtils.getOrgId(), KEY_EN_ADM_NEEDREG);
    	if (!EnValidator.isEmpty(paramValue)) {
			return Integer.parseInt(paramValue) == 1;
		}
        return false;
    }
    /**
	 * 预住院转住院是否需要转出转入 0-直接转入 1-转出后转入
	 * 
	 * @return
	 */
	public static Boolean getIppreTransMethod() {	
		String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_IP_IPPRE_TRANCS);
		if (!EnValidator.isEmpty(paramValue)) {
			if(0==Integer.parseInt(paramValue)){
				return false;
			}else{
				return true;
			}
		}
		return false;
	}

	/**
	 * 预住院转住院检查内容标志串 0000-1111
	 * 
	 * @return
	 */
	public static String getIppreTransCheck() {	
		String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_IP_IPPRE_TRANCSCHECK);
		return paramValue;
	}
	
	/**
	 * 预住院出院患者列表患者显示天数
	 * 
	 * @return
	 */
	public static int getLvHosPatsDisplayDays() {
		String paramValue = getOrgParamValue(EnContextUtils.getOrgId(),KEY_EN_IP_IPPRE_LVHOSPATSDISPLAYDAYS);
		if (!EnValidator.isEmpty(paramValue)) {
			return Integer.parseInt(paramValue);
		}
		return -1;
	}
}
