package iih.bd.bc.udi.pub;

/**
 * 就诊流程管理模块(IIH.EN)相关的基础数据常量定义。
 */
/**
 * @author Founder
 *
 */
public interface IEnDictCodeConst {
	
	/***
	 * 预约状态
	 */
	public static final String SD_ENSTATUS_APT_ORDER = "1"; // 预约未付费
	
	/**
	 * 就诊状态
	 */
	public static final String SD_ENSTATUS_OP_ORDER = "01"; // 门诊预约
	public static final String SD_ENSTATUS_OP_REGISTER = "02"; // 门诊挂号
	public static final String SD_ENSTATUS_OP_ENCOUNTER = "05"; // 门诊就诊
	public static final String SD_ENSTATUS_OP_FINISH = "08"; // 门诊诊毕
	public static final String SD_ENSTATUS_OP_CONTINUE = "0a"; // 门诊续诊
	public static final String SD_ENSTATUS_EM_REGISTER = "11"; // 急诊登记
	public static final String SD_ENSTATUS_EM_ENCOUNTER = "15"; // 急诊接诊
	public static final String SD_ENSTATUS_EM_FINISH = "18"; // 急诊诊毕
	public static final String SD_ENSTATUS_EM_REPORT = "13"; // 急诊出报告
	public static final String SD_ENSTATUS_IN_ORDER = "21"; // 住院预约
	public static final String SD_ENSTATUS_IN_HOSPITALIN = "22"; // 住院入院
	public static final String SD_ENSTATUS_IN_DEPTIN = "25"; // 住院入科
	public static final String SD_ENSTATUS_IN_HOSPITALOUT = "28"; // 住院出院
	public static final String SD_ENSTATUS_IN_HOSPITALQUIT = "2a"; // 住院退院
	public static final String SD_ENSTATUS_PE_REGISTER = "31"; // 体检登记
	public static final String SD_ENSTATUS_PE_ENCOUNTER = "35"; // 体检接诊
	public static final String SD_ENSTATUS_PE_FINISH = "38"; // 体检诊毕
	public static final String SD_ENSTATUS_PE_REPORT = "39"; // 体检出报告

	/***
	 * 就诊类型
	 */
	public static final String ID_REFERALSRC_OUTPATIENT = "@@@@AA1000000001H2IF"; //门诊
    public static final String ID_REFERALSRC_EMERGENCY = "@@@@AA1000000001H2IE";//急诊
    public static final String ID_REFERALSRC_OTHERORG = "@@@@AA1000000001H2IG";//其他医疗机构转入
    public static final String ID_REFERALSRC_OTHER = "@@@@AA1000000001H2IH";

    public static final String SD_REFERALSRC_OUTPATIENT = "2"; //门诊
    public static final String SD_REFERALSRC_EMERGENCY = "1";//急诊
    public static final String SD_REFERALSRC_OTHERORG = "3";//其他医疗机构转入
    public static final String SD_REFERALSRC_OTHER = "9";
    
    /***
     * 病情等级
     */
    public static final String ID_CONDITION_GRADE_DYING = "@@@@AA1000000DFJBKDJ"; //病危
    public static final String ID_CONDITION_GRADE_SEVERITY = "@@@@AA10FDKJSBKJBKFD"; //病重
    public static final String ID_CONDITION_GRADE_ORDINARY = "@@@@AA10FDKDGKDGHFFI"; //普通
    
    public static final String CONDITION_GRADE_DYING = "00"; //病危
    public static final String CONDITION_GRADE_SEVERITY = "01"; //病重
    public static final String CONDITION_GRADE_ORDINARY = "02"; //普通
    
	/**
	 * 转科科室角色
	 */
	public static final String SD_ENTDEPROLE_DEP = "1";// 科室
	public static final String ID_ENTDEPROLE_DEP = "@@@@AA1000000001H2HV";
	public static final String SD_ENTDEPROLE_IA = "2";// 病区
	public static final String ID_ENTDEPROLE_IA = "@@@@AA1000000001H2HW";
	public static final String SD_ENTDEPROLE_MT = "3";// 医技
	public static final String ID_ENTDEPROLE_MT = "@@@@AA1000000001H2HX";

	/**
	 * 转科状态
	 */
	public static final String SD_ENTDEP_STATUS_APP = "0";// 申请转科
	// public static final String ID_ENTDEP_STATUS_APP = "@@@@AA1000000001H2IK";
	public static final String SD_ENTDEP_STATUS_SUC = "1";// 完成
	// public static final String ID_ENTDEP_STATUS_SUC = "@@@@AA1000000001H2IL";

	/**
	 * 床位占用类型
	 */
	public static final String SD_USETYPE_MAIN = "0"; // 主床
	public static final String SD_USETYPE_SUB = "1"; // 包床
	
	/**
	 * 床位占用类型ID
	 */
	public static final String ID_USETYPE_MAIN = "@@@@AA1000000001H2II"; // 主床
	public static final String ID_USETYPE_SUB = "@@@@AA1000000001H2IJ"; // 包床
	
	/**
	 * 就诊医生角色
	 */
	public static final String SD_EMPROLE_OPDOC = "00"; // 门诊接诊医生
	public static final String SD_EMPROLE_DOCTOR = "10"; // 责任医师
	public static final String SD_EMPROLE_ZYDOC = "11"; // 住院医师
	public static final String SD_EMPROLE_ZZDOC = "12"; // 主治医师
	public static final String SD_EMPROLE_ZRDOC = "13"; // 主任/副主任医师
	public static final String SD_EMPROLE_SXDOC = "14"; // 实习医师
	public static final String SD_EMPROLE_JXDOC = "15"; // 进修医师
	public static final String SD_EMPROLE_NURSE = "20"; // 责任护士
	public static final String ID_EMPROLE_OPDOC = "@@@@AA1000000002GB9U"; // 门诊接诊医生
	public static final String ID_EMPROLE_DOCTOR = "@@@@AA1000000001H2HY"; // 主治大夫
	public static final String ID_EMPROLE_ZYDOC = "@@@@AA1000000002GB9P"; // 住院医师
	public static final String ID_EMPROLE_ZZDOC = "@@@@AA1000000002GB9Q"; // 主治医师
	public static final String ID_EMPROLE_ZRDOC = "@@@@AA1000000002GB9R"; // 主任/副主任医师
	public static final String ID_EMPROLE_SXDOC = "@@@@AA1000000002GB9S"; // 实习医师
	public static final String ID_EMPROLE_JXDOC = "@@@@AA1000000002GB9T"; // 进修医师
	public static final String ID_EMPROLE_NURSE = "@@@@AA1000000001H2HZ";// 责任护士

	/**
	 * 就诊医疗组角色
	 */
	public static final String SD_ENWGROLE_PHY = "1";// 医疗组
	public static final String SD_ENWGROLE_NUR = "2";// 护理组
	public static final String ID_ENWGROLE_PHY = "@@@@AA1000000001H2I0";// 医疗组
	public static final String ID_ENWGROLE_NUR = "@@@@AA1000000001H2I1";// 护理组

	/**
	 * 就诊门诊诊疗类型sd
	 */
	public static final String SD_OPDIAGTP_EXPRERT = "1";// 专家
	public static final String SD_OPDIAGTP_ORI = "2";// 普通

	/**
	 * 就诊门诊诊疗类型id
	 */
	public static final String ID_OPDIAGTP_EXPRERT = "@@@@AA1000000001H2I2";// 专家
	public static final String ID_OPDIAGTP_ORI = "@@@@AA1000000001H2I3";// 普通

	/**
	 * 门诊就诊转归(和急诊sd一样，id不一样)
	 */
	public static final String SD_GOWHERE_HOME = "1"; // 1-回家
	public static final String SD_GOWHERE_TRANSDEP = "2"; // 2-转科
	public static final String SD_GOWHERE_INPATIENT = "3"; // 3-住院
	public static final String SD_GOWHERE_DIED = "4"; // 4-死亡
	public static final String SD_GOWHERE_TRANSOUT = "5"; // 5-转外院
	public static final String SD_GOWHERE_STAY = "6"; // 6-留观
	public static final String SD_GOWHERE_LEAVEHOS = "7"; // 7-自动离院

	/**
	 * 通知单状态 0-申请 1-安排 2-审核通过 3-审核拒绝 4-患者入院
	 */
	public static final String SD_STATUS_NOTICE_CREATE = "0"; // 申请
	public static final String SD_STATUS_NOTICE_NOTIFY = "1"; // 安排
	public static final String SD_STATUS_NOTICE_ACC = "2"; // 审核通过
	public static final String SD_STATUS_NOTICE_REFUSE = "3"; // 审核拒绝
	public static final String SD_STATUS_NOTICE_INHOS = "4";// 患者入院

	/**
	 * 1530患者固定费用收费模式
	 */
	public static final String ID_DCG_MODE_DEP = "@@@@AA1000000001H2JC";// 继承科室ID
	public static final String SD_DCG_MODE_DEP = "0";// 继承科室编码
	public static final String ID_DCG_MODE_PAT = "@@@@AA1000000001H2JD";// 患者专有ID
	public static final String SD_DCG_MODE_PAT = "1";// 患者专有编码

	/**
	 * 接受状态
	 */
	public static final String SD_STATUS_ACPT_NOTARRIVED = "-1"; // 未到诊
	public static final String SD_STATUS_ACPT_UNACCEPT = "0"; // 到诊
	public static final String SD_STATUS_ACPT_CALL = "1"; // 叫号
	public static final String SD_STATUS_ACPT_CALLBUTNOTCOME = "2"; // 叫号未到
	public static final String SD_STATUS_ACPT_ACCEPTED = "3"; // 已接受
	public static final String SD_STATUS_ACPT_CHECKED = "7"; // 检查
	public static final String SD_STATUS_ACPT_FINCHECKED = "8"; // 检查完毕
	
	/**
	 * 队列类型
	 */
	public static final String SD_QUEUE_OP = "0"; // 门诊
	public static final String SD_QUEUE_MT = "1"; // 医技 
	public static final String SD_QUEUE_PHARM = "2"; // 药房 
	public static final String SD_QUEUE_IPSC = "3"; // 住院预约 
	public static final String SD_QUEUE_OPREGSC = "4"; // 门诊挂号预约
	public static final String SD_QUEUE_CURRENCY = "9"; // 通用  
	
	// 药房： 20-签到 21-配药 22-叫号 23-叫号未到 24-发药
	public static final String SD_STATUS_ACPT_PHRAM_UNACCEPT = "20"; // 药房签到
	public static final String SD_STATUS_ACPT_PHRAM_PREPARE = "21"; // 配药
	public static final String SD_STATUS_ACPT_PHRAM_CALL = "22";// 药房叫号
	public static final String SD_STATUS_ACPT_PHRAM_CALLBUTNOTCOME = "23";// 药房叫号未到
	public static final String SD_STATUS_ACPT_PHRAM_DISPENSE = "24";// 药房发药
	/*
	 * 诊断类型
	 */
	public static final String SD_DIAGTYPE_OUTPATIENT = "00"; // 门诊诊断
	public static final String SD_DIAGTYPE_HOSPITAL_IN = "10"; // 入院诊断
	public static final String SD_DIAGTYPE_OPERATION = "11"; // 手术诊断
	public static final String SD_DIAGTYPE_HOSPITAL_OUT = "12"; // 出院诊断
	public static final String SD_DIAGTYPE_RADIATION = "20"; // 放射诊断
	public static final String SD_DIAGTYPE_PATHOLOGY = "21"; // 病理诊断

	/*
	 * 诊断学科类型
	 */
	public static final String SD_DI_SUNJ_TYPE_WEST = "0";// 西医
	public static final String SD_DI_SUNJ_TYPE_CHINA = "1"; // 中医

	/*
	 * 转科过程状态
	 */
	public static final String SD_SU_OPEN = "1"; // 开立
	public static final String SD_SU_APPLY = "2"; // 已申请转出
	public static final String SD_SU_RECEIVE = "3"; // 已接收完成
	public static final String SD_SU_CANCEL = "4"; // 已取消

	/*
	 * 医疗服务类型
	 */

	public static final String SD_TRANS_DEP = "1301";

	/*
	 * 医技分诊定义了个Triage_status 区分状态，就是页面下面的 combox那个状态
	 */
	public static final String SD_TRIAGE_NOTARRIVED = "-1";// 未到诊
	public static final String SD_TRIAGE_ARRIVED = "0"; // 到诊
	public static final String SD_TRIAGE_TRIGE = "1"; // 已分诊
	public static final String SD_TRIAGE_INFOMARTION = "2"; // 通知
	public static final String SD_TRIAGE_START_CHECK = "3"; // 开始检查
	public static final String SD_TRIAGE_CHECKED = "4"; // 已检查
	public static final String SD_TRIAGE_ALL = "99"; // 全部
	
	/*
	 * 诊断类型ID
	 */
	public static final String SD_DIPROVETP_DIPROVE_ID = "@@@@Z7100000000FMIA6"; //诊断证明书
	/*
	 * 诊断类型ID
	 */
	public static final String SD_DIPROVETP_DIPROVE = "01"; //诊断证明书
	
	/**
	 * 就诊类型 Code 定义
	 */
	public static final String SD_ENTP_EMERGENCY = "01";
	public static final String SD_ENTP_HOME = "20";
	public static final String SD_ENTP_INPATIENT = "10";
	public static final String SD_ENTP_OUTPATIENT = "00";
	public static final String SD_ENTP_PHYSICALEXAM = "02";
	public static final String SD_ENTP_IPPRE = "11";
	
	/*
	 * 医疗类别Code 定义
	 */
	public static final String SD_SINGLEDRGS = "33"; //单病种
	
	public static final Integer DEFLEVELPRI = 0; //默认的优先级别
	
	/**
	 * 是否区分床位性别
	 */
	public static final Integer BED_HAS_SEX = 1; //床位区分性别
	public static final Integer BED_HAS_NO_SEX = 0; //床位不区分性别
	
	/**
	 * 出科时间设置模式
	 */
	public static final Integer VAL_LVHOSTIMETP_ORDER = 1; //取医嘱中的出院时间
	public static final Integer VAL_LVHOSTIMETP_SYS = 0; //取出科的操作时间
	
	/**
	 * 急诊预检状态
	 */
	public static final String SD_STATUS_ERPRE_NEW = "0";  // 患者就诊状态为新建
	public static final String SD_STATUS_ERPRE_VISIT = "1";  // 患者就诊状态为就诊
	public static final String SD_STATUS_ERPRE_END = "2";  // 患者就诊状态为结束
	public static final String SD_STATUS_ERPRE_CANCEL = "3";  // 患者就诊状态为取消
	
	/**
	 * 急诊分诊去向
	 */
	public static final String SD_TRIAGETO_ERCOMM = "01";//急诊流水
	public static final String SD_TRIAGETO_ERSTAY = "02";//急诊留观
	public static final String SD_TRIAGETO_ERRESCUE = "03";//急诊抢救
	public static final String SD_TRIAGETO_INPATIENT = "04";//转住院
	public static final String SD_TRIAGETO_LVHOS = "90";//离院
	
	/**
	 * 就诊事件类型
	 */
	public static final String SD_ENTEVT_ARRIVEHOS = "000";//到院
	public static final String SD_ENTEVT_ERPRE = "001";//预检
	public static final String SD_ENTEVT_OPREGIST = "002";//挂号
	public static final String SD_ENTEVT_TRIAGE = "003";//分诊
	public static final String SD_ENTEVT_ACPT = "004";//接诊
	public static final String SD_ENTEVT_ERTPCHG = "005";//流水转留观/抢救
	public static final String SD_ENTEVT_CANCOPREGIST = "009";//退号
	public static final String SD_ENTEVT_IPREGIST = "010";//入院登记
	public static final String SD_ENTEVT_ENTERDEP = "011";//入科
	public static final String SD_ENTEVT_TRANSDEP = "012";//转科/转病区
	public static final String SD_ENTEVT_DISTRIBUTIONBED = "013";//分配床位
	public static final String SD_ENTEVT_RENTBED = "014";//包床
	public static final String SD_ENTEVT_LVHOS = "018";//出院
	public static final String SD_ENTEVT_RECALLHOS = "019";//出院召回
	public static final String SD_ENTEVT_DISCHARGE = "020";//退院
	public static final String SD_ENTEVT_CHANELENTRY = "021";//取消入科
	public static final String SD_ENTEVT_PATCACHG = "030";//修改患者分类
	public static final String SD_ENTEVT_PATCHG = "031";//换患者
	public static final String SD_ENTEVT_PRTWRIST = "032";//打印腕带
	public static final String SD_ENTEVT_MODIFY_ENTRY = "033";//修改入院时间
	public static final String SD_ENTEVT_MODIFY_ACPT = "034";//修改入科时间
	public static final String SD_ENTEVT_ENIPPRE = "040";//接受预住院
	public static final String SD_ENTEVT_TRANSHOS = "042";//预住院转住院
	public static final String SD_ENTEVT_IPPRELVHOS = "043";//预住院出院
	public static final String SD_ENTEVT_CANCELHOS = "044";//预住院中止入院
	public static final String SD_ENTEVT_CANCELSUSPENDHOS = "045";//预住院撤销中止住院
	public static final String SD_ENTEVT_IPPRERECALLHOS = "046";//预住院出院召回
	public static final String SD_ENTEVT_TRANSHOS_ACPT = "047";//预住院转住院转入
	public static final String SD_ENTEVT_OUTHOS = "050";//离院
	
	/**
	 * 住院类型
	 */
	public static final String SD_IPTYPE_CUSTOM = "00";//住院
	public static final String SD_IPTYPE_HEMODI = "01";//血透患者
	public static final String SD_IPTYPE_OBSER = "02";//留观患者
	
	/**
	 * 预住院状态
	 */
	public static final String SD_STATUS_IPPRE_HOS_ENTER = "1";//入院登记
	public static final String SD_STATUS_IPPRE_HOS_ENTER_PRE = "2";//入院准备中心
	public static final String SD_STATUS_IPPRE_DEP_ENTER = "3";//入科患者
	public static final String SD_STATUS_IPPRE_HOS_OUTER = "8";//出院
	public static final String SD_STATUS_IPPRE_HOS_STOP = "9";//终止住院
}
