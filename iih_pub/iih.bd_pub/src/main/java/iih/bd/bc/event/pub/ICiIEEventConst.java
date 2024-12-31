package iih.bd.bc.event.pub;

/**
 * 临床诊疗事件常量（医嘱、诊断）
 * （集成平台版）
 */
public interface ICiIEEventConst {
	/**
	 * 医嘱护士确认事件
	 * 不含作废与停止
	 * （集成平台）
	 * 特别注意：要用返回的DTO数据类型的全路径名进行事件源的命名
	 */
	public static final String EVENT_IE_CIOR_NSCHK_DRUG = "iih.ci.ord.iemsg.d.IEPharmOrEnDTO";    //药品医嘱开立   触发事件依据
	public static final String EVENT_IE_CIOR_NSCHK_DRUG_WC = "iih.ci.ord.iemsg.d.IEPharmWcOrDTO";    //西成药医嘱开立   数据组织依据但非触发事件依据
	public static final String EVENT_IE_CIOR_NSCHK_DRUG_HERB = "iih.ci.ord.iemsg.d.IEPharmHerbOrDTO";//草药医嘱开立        数据组织依据但非触发事件依据
	public static final String EVENT_IE_CIOR_NSCHK_RIS = "iih.ci.ord.iemsg.d.IERisOrEnDTO";    //检查医嘱开立
	public static final String EVENT_IE_CIOR_NSCHK_LIS = "iih.ci.ord.iemsg.d.IELisOrEnDTO";    //检验医嘱开立
	public static final String EVENT_IE_CIOR_NSCHK_OP = "iih.ci.ord.iemsg.d.IEOpOrEnDTO";    //手术医嘱开立
	public static final String EVENT_IE_CIOR_NSCHK_CON = "iih.ci.ord.iemsg.d.IEOpConsulationDTO";    //会诊医嘱开立
	public static final String EVENT_IE_CIOR_NSCHK_PBT = "iih.ci.ord.iemsg.d.IEBtOrEnDTO";    //备血医嘱开立
	public static final String EVENT_IE_CIOR_NSCHK_UBT = "iih.ci.ord.iemsg.d.IEBtUseOrDTO";    //用血医嘱开立
	public static final String EVENT_IE_CIOR_NSCHK_OUT = "iih.ci.ord.iemsg.d.outor";    //出院医嘱开立
	public static final String EVENT_IE_CIOR_NSCHK_NS = "iih.ci.ord.iemsg.d.IENsOrEnDTO";    //护理医嘱开立
	public static final String EVENT_IE_CIOR_NSCHK_TREAT = "iih.ci.ord.iemsg.d.IETreatOrEnDTO";    //治疗医嘱开立
	public static final String EVENT_IE_CIOR_NSCHK_TRANDEP = "iih.ci.ord.iemsg.d.trandepor";    //转科医嘱开立
	public static final String EVENT_IE_CIOR_NSCHK_OTH = "iih.ci.ord.iemsg.d.IEOthOrEnDTO";    //其它医嘱开立
	
	/**
	 * 门诊医嘱签署事件
	 * （集成平台）
	 */
	public static final String EVENT_IE_CIOR_OP_DRUG = "iih.ci.ord.iemsg.d.IEOpPharmOrEnDTO";    //药品医嘱开立   触发事件依据
	public static final String EVENT_IE_CIOR_OP_DRUG_WC = "iih.ci.ord.iemsg.d.IEOpPharmWcOrDTO";    //西成药医嘱开立   数据组织依据但非触发事件依据
	public static final String EVENT_IE_CIOR_OP_DRUG_HERB = "iih.ci.ord.iemsg.d.IEOpPharmHerbOrDTO";//草药医嘱开立        数据组织依据但非触发事件依据
	public static final String EVENT_IE_CIOR_OP_RIS = "iih.ci.ord.iemsg.d.IEOpRisOrEnDTO";    //检查医嘱开立
	public static final String EVENT_IE_CIOR_OP_LIS = "iih.ci.ord.iemsg.d.IEOpLisOrEnDTO";    //检验医嘱开立
	public static final String EVENT_IE_CIOR_OP_OP = "iih.ci.ord.iemsg.d.IEOpOpOrEnDTO";    //手术医嘱开立
	public static final String EVENT_IE_CIOR_OP_CON = "iih.ci.ord.iemsg.d.opcon";    //会诊医嘱开立
	public static final String EVENT_IE_CIOR_OP_PBT = "iih.ci.ord.iemsg.d.IEOpBtOrEnDTO";    //备血医嘱开立
	public static final String EVENT_IE_CIOR_OP_UBT = "iih.ci.ord.iemsg.d.IEOpBtUseOrDTO";    //用血医嘱开立
	public static final String EVENT_IE_CIOR_OP_TREAT = "iih.ci.ord.iemsg.d.IEOpTreatOrEnDTO";    //治疗医嘱开立

	/**
	 * 医嘱护士确认事件
	 * 仅作废与停止
	 */
	public static final String EVENT_IE_CIOR_NSCHK_CANC_STOP = "iih.ci.ord.iemsg.d.IEOrCancStpEnDTO";    //医嘱作废与停止
	
	/**
	 * 门诊医嘱作废停止事件
	 * 仅作废与停止
	 */
	public static final String EVENT_IE_CIOR_OP_CANC_STOP = "iih.ci.ord.iemsg.d.IEOpOrCancStpEnDTO";    //医嘱作废与停止

	/**
	 * 临床诊断下达事件
	 */
	//public static final String EVENT_IE_CIDIAG_SIGN = "CIDIAG_SIGN";  //临床诊断下达
	public static final String EVENT_IE_CIDIAG_SIGN = "iih.ci.ord.iemsg.d.IEPvDiagEnDTO";  //临床诊断下达
	
	/**
	 * 门诊临床诊断下达事件
	 */
	//public static final String EVENT_IE_CIDIAG_OP_SIGN = "CIDIAG_SIGN_OP";  //门诊临床诊断下达
	public static final String EVENT_IE_CIDIAG_OP_SIGN = "iih.ci.ord.iemsg.d.IEOpPvDiagEnDTO";  //门诊临床诊断下达
	
	/**
	 * 门诊就诊号
	 */
	//public static final String EVENT_IE_CIDIAG_OP_SIGN = "CIDIAG_SIGN_OP";  //门诊临床诊断下达
	public static final String EVENT_IE_ID_ENT = "iden";  //门诊临床诊断下达
	
	/**
	 * 门诊医嘱号
	 */
	public static final String EVENT_IE_ID_OR = "idor";  //门诊临床诊断下达
}
