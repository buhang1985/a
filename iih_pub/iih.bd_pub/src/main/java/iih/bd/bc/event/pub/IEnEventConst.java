package iih.bd.bc.event.pub;

/**
 * 就诊域事件
 * @author yank
 *
 */
public class IEnEventConst {
	//门诊事件源
	public static final String EVENT_SOURCE_EN_PREPE_BF_REG = "en_prepe_before_reg";    //挂号前预检
	public static final String EVENT_SOURCE_EN_OP_REG = "iih.en.pv.dto.d.OpReg4EsDTO";    //门诊挂号
	public static final String EVENT_SOURCE_EN_OP_PREPE = "en_op_prepe";    //门诊预检
	public static final String EVENT_SOURCE_SC_OP_APT = "en_op_apt";//门诊预约
	public static final String EVENT_SOURCE_SC_OP_APT_CANC = "en_op_apt_canc";//门诊预约取消事件源
	public static final String EVENT_SOURCE_EN_OP_QUE = "iih.en.que.dto.d.OpQue4EsDTO";//门诊医生操作事件源
	
	//通用队列事件源
	public static final String EVENT_SOURCE_EN_ALL_QUE = "iih.en.que.dto.d.AllQue4EsDTO";//通用队列操作事件源
	
	//医技事件源
	public static final String EVENT_SOURCE_EN_MT_SING = "en_mt_sign";//医技签到
	public static final String EVENT_SOURCE_EN_MT_CANC_SIGN = "en_mt_canc_sign";//医技取消签到
	
	//住院事件源
	public static final String EVENT_SOURCE_EN_IP_REG = "iih.en.pv.inpatient.dto.d.IpReg4EsDTO"; //入院登记
	public static final String EVENT_SOURCE_EN_IP_CANC_REG = "en_ip_canc_reg"; //取消入院登记
	public static final String EVENT_SOURCE_EN_IP_IN_DEPT = "iih.en.pv.inpatient.dto.d.EnterDept4EsDTO";//入科
	public static final String EVENT_SOURCE_EN_IP_CANCEL_IN_DEPT = "iih.en.pv.inpatient.dto.d.CancelEnterDept4EsDTO";//取消入科
	public static final String EVENT_SOURCE_EN_IP_CHANGE_BED = "iih.en.pv.inpatient.dto.d.ChgBed4EsDTO";//换床
	public static final String EVENT_SOURCE_EN_IP_RENT_BED = "iih.en.pv.inpatient.dto.d.RentBed4EsDTO";//包床
	public static final String EVENT_SOURCE_EN_IP_RENT_BED_TWO = "iih.en.ip.dto.d.RentBed4EsDTO";//包床2.0
	public static final String EVENT_SOURCE_EN_IP_CHG_EMP = "iih.en.pv.inpatient.dto.d.ChgEmp4EsDTO";//医护人员修改
	public static final String EVENT_SOURCE_EN_IP_TRANS_DEPT = "iih.en.pv.inpatient.dto.d.TransDept4EsDTO";//转科,转病区
	public static final String EVENT_SOURCE_EN_IP_LEAVE = "iih.en.pv.inpatient.dto.d.LvHos4EsDTO";    //出院
	public static final String EVENT_SOURCE_EN_IP_LEAVE_DEP = "iih.en.pv.inpatient.dto.d.LvDep4EsDTO";    //出科
	public static final String EVENT_SOURCE_EN_IP_RECALL = "iih.en.pv.inpatient.dto.d.Recall4EsDTO";    //出院召回
	public static final String EVENT_SOURCE_EN_IP_DISCHARGE = "iih.en.pv.inpatient.dto.d.DisHos4EsDTO";//当日退院
	public static final String EVENT_SOURCE_EN_IP_CHGHP = "iih.en.pv.inpatient.dto.d.ChgHp4EsDTO";//住院医保改变事件
	public static final String EVENT_SOURCE_EN_IP_SYNCHROEMPDEP = "xap.sys.permfw.resp.d.SubjectOrgDO";    //修改用户 - 组织关系后,同步到科室员工关系表
	public static final String EVENT_SOURCE_EN_IP_ENT = "iih.en.pv.out.d.EnEvtDTO"; //就诊变更事件
	
	//门诊病历内容发送就诊域
	public static final String ENEVT_SOURCE_EN_OP_MEIDCALRECORD  ="OP_MR_TO_EN";//  监听门诊病历保存事件
	
	//事件类型只能4位数字，前两位为模块ID，就诊域模块ID为44
	//门诊事件类型4401-4420
	public static final String EVENT_EN_OP_REG = "4401";    //门诊挂号	
	public static final String EVENT_EN_OP_CANC_REG = "4402";//门诊退号
	
	//门诊队列事件类型4420-4440
	public static final String EVENT_EN_OP_SIGNIN = "4420";//到诊
	public static final String EVENT_EN_OP_CANC_SIGNIN = "4421";//取消到诊
	public static final String EVENT_EN_OP_TRIAGE = "4422";//分诊
	public static final String EVENT_EN_OP_CANC_TRIAGE = "4423";//取消分诊
	
	public static final String EVENT_EN_OP_DOC_ONLINE = "4430";//医生上线
	public static final String EVENT_EN_OP_DOC_OFFLINE = "4431";//医生下线
	public static final String EVENT_EN_OP_CALLNUM = "4432";//叫号
	public static final String EVENT_EN_OP_CANC_CALLNUM = "4433";//取消叫号
	public static final String EVENT_EN_OP_PASSNUM = "4434";//过号
	public static final String EVENT_EN_OP_DOC_ACPT = "4435";//医生接诊
	public static final String EVENT_EN_OP_DOC_CANC_ACPT = "4436";//医生取消接诊
	public static final String EVENT_EN_OP_DIAGNOSECONTINUE = "4437";//待回诊
	public static final String EVENT_EN_OP_DIAGEND = "4440";//诊毕

	
	
	//住院事件类型，4441开始
	public static final String EVENT_EN_IP_REG = "4441";//入院登记
	public static final String EVENT_EN_IP_CANC_REG = "4442";//取消入院登记
	public static final String EVENT_EN_IP_ENTER_DEPT = "4443";//入科
	public static final String EVENT_EN_URGPAT_ENTER_DEPT = "444301";//抢救患者入科
	public static final String EVENT_EN_IP_CHANGE_EMP = "4444";//医护人员修改
	public static final String EVENT_EN_IP_FIRST_ENTRY_EMP = "444401";//首次录入责任医生
	public static final String EVENT_EN_IP_CHANGE_BED = "4445";//换床
	public static final String EVENT_EN_IP_RENT_BED = "4446";//包床	
	
    public static final String EVENT_EN_IP_TRANSOUT_DEPT = "4450";//住院转出	public static final String EVENT_EN_IP_TRANS_DEPT = "4455";//转科
	public static final String EVENT_EN_IP_TRANS_WARD = "4451";//转病区	
	public static final String EVENT_EN_IP_LEAVE_HOS = "4460";//出院
	public static final String EVENT_EN_IP_RECALL= "4461";//出院召回
	
	//通用队列事件类型4470-4490
	public static final String EVENT_EN_ALL_SIGNIN = "4484";//到诊
	public static final String EVENT_EN_ALL_CANC_SIGNIN = "4483";//取消到诊
	public static final String EVENT_EN_ALL_TRIAGE = "4480";//分诊
	public static final String EVENT_EN_ALL_CANC_TRIAGE = "4481";//取消分诊
	
	public static final String EVENT_EN_ALL_DOC_ONLINE = "4471";//医生上线
	public static final String EVENT_EN_ALL_DOC_PAUSE = "4472";//医生暂停
	public static final String EVENT_EN_ALL_DOC_CONTINUE = "4473";//医生继续
	public static final String EVENT_EN_ALL_DOC_OFFLINE = "4474";//医生下线

	public static final String EVENT_EN_ALL_CALLNUM = "4475";//叫号
	public static final String EVENT_EN_ALL_SELECTED_CALLNUM = "4476";//选择叫号
	public static final String EVENT_EN_ALL_PASSNUM = "4482";//过号
	
	public static final String EVENT_EN_ALL_DOC_ACPT = "4477";//医生处置
	public static final String EVENT_EN_ALL_DOC_CANC_ACPT = "4479";//医生取消处置
	public static final String EVENT_EN_ALL_DIAGEND = "4478";//处置完成

	//药房队列事件类型
	public static final String EVENT_DRUG_ONLIN = "470501";//上线
	public static final String EVENT_DRUG_OFFLIN = "470502";//下线
	public static final String EVENT_DRUG_CALLNUM = "470505";//叫号
	public static final String EVENT_DRUG_SIGNIN = "470515";//处方分到窗口
	public static final String EVENT_DRUG_DISPENSING = "470510";//发药
	public static final String EVENT_DRUG_DOSAGE = "470503";//药房配药
	public static final String EVENT_DRUG_CALLNOARRIVAL = "470504";//药房叫号未到
	
	//预住院事件
	public static final String EVENT_EN_PRE_IP = "441011";//预住院事件
	//修改入院时间、入科时间事件
	public static final String EVENT_ENIP_MODIFY_ENTRYACPT = "441012";//入院时间、入科时间事件
}
