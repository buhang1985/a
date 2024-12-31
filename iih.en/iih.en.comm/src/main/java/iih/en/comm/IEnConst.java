package iih.en.comm;

/**
 * 就诊常量
 * 
 * @author yank
 *
 */
public interface IEnConst {
	
	public static final String SENDEDMSG_SUC_CONST= "0";//发送短信成功时返回值
	
	public static final Integer DEFAULT_OP_VALID_HOURS = 24;// 门诊默认有效期
	public static final Integer DEFAULT_EM_VALIDA_HOURS = 24;// 急诊默认有效期
	public static final Integer POL_CN_REG = 0;// 默认挂号号源池为0
	public static final String EM_SRV_ID = "1001Z7100000000H046K";// 急诊排班服务ID，//TODO delete 后续删除

	// 接诊状态
	public final String SD_STATUS_ACPT_NOTARRIVED = "-1"; // 未到诊
	public final String SD_STATUS_ACPT_UNACCEPT = "0"; // 到诊
	public final String SD_STATUS_ACPT_CALL = "1"; // 叫号
	public final String SD_STATUS_ACPT_CALLBUTNOTCOME = "2"; // 叫号未到
	public final String SD_STATUS_ACPT_ACCEPTED = "3"; // 已接受
	public final String SD_STATUS_ACPT_CHECKED = "7"; // 检查
	public final String SD_STATUS_ACPT_FINCHECKED = "8"; // 检查完毕

	// 就诊的VIP类型
	public final String TP_VIP_NONE = "0";// 非VIP
	public final String TP_VIP_PRI = "1";// 价格分类VIP
	public final String TP_VIP_SRV = "2";// 号别VIP
	public final String TP_VIP_ALL = "3";// 价格分类VIP且号别VIP
	public final String TP_VIP_DEP = "4";//科室或病区VIP 原来此处4是患者标签VIP，修改成同开发文档一致
	public final String TP_VIP_TAG = "5";//患者标签VIP
	public final String TP_VIP_EXT = "8";// 手动加V
	
	
	
	//======================以下为集成平台常量==========================//
	
	public final String NAME_GRADE_ORDINARY ="常规 ";
	public final String NAME_GRADE_SEVERITY ="重";
	public final String NAME_GRADE_DYING ="危";
	public final String NAME_GRADE_EM ="急";
	//住院编码
	public final String UPDATE= "update";
	public final String NEW = "new";
	
	public final String AREA = "02";
	
	//出院状态
	public static final String SD_CDR_NEW= "new";
	public static final String SD_LV_DISCHARGE= "cancel";
	public static final String SD_CDR_UPDATE= "update";
	
	//住院还是门诊
	public static final String SD_ENTP_OP = "01";
	public static final String SD_ENTP_IP = "02";
	
	//标版集成平台常量
	public final String HISAREA = "01"; //HIS域ID
	public final String PEAREA = "02"; //体检域ID

	public final String OPENTTP = "01"; //就诊类别：门诊
	public final String EMENTTP = "0201"; //就诊类别：急诊
	public final String IPENTTP = "03"; //就诊类别：住院
	public final String PEENTTP = "0401"; //就诊类别：住院
	
	//转床转科类型编码
	public final String CHGBED = "5";//转床转病区
	public final String TRANSDEPT = "6";//转科
	
	//职称类别名称
	public final String NAME_EMPROLE_ZZ = "主治医师";
	public final String NAME_EMPROLE_ZR = "主任医师";
	public final String NAME_EMPROLE_ZY = "住院医师";
	public final String NAME_EMPROLE_ZG = "主管医师";
	public final String NAME_EMPROLE_NURSE = "主管护师";
	
    //======================大屏消息编码==========================//
	
	//发送大屏站点消息
	public static final String SEND_BRD_SITE_MSG_CODE = "en_brd_site_msg";
	//发送大屏叫号消息
	public static final String SEND_BRD_CALL_MSG_CODE = "en_brd_call_msg";
	//药房窗口消息
	public static final String DRUG_BRD_SITE_MSG_CODE = "drug_brd_site_msg";
	//药房叫号消息
	public static final String DRUG_BRD_CALL_MSG_CODE = "drug_brd_call_msg";
	
	//======================团检==========================//
    
    //性别
    public static final String SEX_ID_BOY  = "@@@@AA1000000000MNSZ";
    public static final String SEX_ID_GIRL = "@@@@AA1000000000MNT0";
    public static final String SEX_ID_UNDECLARED = "@@@@AA1000000000MNT1";
    public static final String SEX_ID_UNKNOWN = "@@@@AA1000000000MNSY";
    
    //性别code
    public static final String SEX_ID_BOY_CODE  = "1";
    public static final String SEX_ID_GIRL_CODE = "2";
    public static final String SEX_ID_UNDECLARED_CODE = "9";
    public static final String SEX_ID_UNKNOWN_CODE = "0";
    
    //性别汉语
    public static final String SEX_NAME_BOY  = "男";
    public static final String SEX_NAME_GIRL = "女";
    public static final String SEX_NAME_UNDECLARED = "未说明";
    public static final String SEX_NAME_UNKNOWN = "未知";
    
    //团检状态
    public static final String STATUS_PE_INHOS = "在院";
    public static final String STATUS_PE_OUTHOS = "出院";

	//团检常量
    public final Integer EN_ENT_COUNT_ONE = 1;//就诊次数
    //患者就诊 住院属性   团检标识
    public static final String SD_PE_PSNTP = "02";
		   
    /**
     * 档案状态
     */
    public static final Integer CONST_DOC_APPOINTMENT = 1;//预约
    public static final Integer CONST_DOC_CREATEDOC = 2;//建档
    public static final Integer CONST_DOC_ACCOMPLISH = 5;//完成
    public static final Integer CONST_DOC_CANCEL = 9;//取消
    
	/**
	 * 产科预约建档 状态
	 * //预约
	 */
    public static final String STATE_RESERVE= "1";
    /**
     * 建档
     */
    public static final String STATE_DOC= "2";
    /**
     * 取消预约
     */
    public static final String STATE_CANCEL= "9";
    
    //在院出院状态
    public static final String STATUS_INHOS = "1";
    public static final String STATUS_OUTHOS = "2";
    public static final String STATUS_HOSPITALIN = "3";
    
    //业务线类型自定义档案
    public static final String SD_DEPL_NB = "0150";
    
    //组织参数 @@en_ip_arrangePhyTp 0-护士指定三级医师 1-医生指定三级医师 2-可以不指定三级医师 （ENIP0180）
    public static final int NURSE_APPOINT = 0;
    public static final int DOCTOR_APPOINT = 1;
    public static final int NO_APPOINT = 2;
    /**
     * 参数ENOP0017的值
     */
    public static final String ENOP0017_PAT = "1";
    
    /*
     * 出院，转科校验
     */
    public static final String CHECK_FORBID = "1";//禁止
    public static final String CHECK_WARM = "2";//提示
    
    public static final String KEYCTX_RULE_DEALTIPS = "Keyctx_Rule_Dealtips";//上下文_规则是否处理提示
    
}
