package iih.ci.event.ord.utils;
/**
 * 事件源
 * 医嘱类型 ，各个服务入口事件源 ，发往集成平台事件源 三者都是分开的，便于客开，没有必然联系
 * @author F
 *
 * @date 2019年8月19日上午10:10:10
 *
 * @classpath iih.ci.event.ord.utils.IOrdEventSources
 */
public interface IOrdEventSources {

	//对外提供 ----------------------门诊住院签署总入口-------------------------------------
	public static final String OP_IP_SIGN_ENTER="iih.ci.ord.event.signenter";//门诊住院签署总入口事件源
	//-------------------------------门诊签署入口---------------------------------------------
	public static final String OP_SIGN_ENTER="iih.ci.ord.event.opsignenter";
	//对外提供-----------------------门诊撤回入口---------------------------------------------
	public static final String OP_REVERT_ENTER="iih.ci.ord.event.oprevertenter";
	//对外提供-----------------------门诊重新分方入口---------------------------------------------
	public static final String OP_REPRES_ENTER="iih.ci.ord.event.oprepresenter";
	//-------------------------------住院签署入口---------------------------------------------
	public static final String IP_SIGN_ENTER="iih.ci.ord.event.ipsignenter";
	//对外提供-----------------------住院停止总入口---------------------------------------------------
	public static final String IP_STOP_ENTER="iih.ci.ord.event.ipstopenter";//住院停止总入口事件源
	//对外提供-----------------------住院作废总入口--------------------------------------------------
	public static final String IP_CANCEL_ENTER="iih.ci.ord.event.ipcancelenter";//住院作废总入口事件源
	//对外提供-----------------------门诊住院诊断总入口---------------------------------------------------
	public static final String OP_IP_DIAG_ENTER="iih.ci.ord.event.opipdiagenter";
	//-------------------------------门诊诊断入口---------------------------------------------------
	public static final String OP_DIAG_ENTER="iih.ci.ord.event.opdiagenter";
	//-------------------------------住院诊断入口---------------------------------------------------
	public static final String IP_DIAG_ENTER="iih.ci.ord.event.ipdiagenter";
	
	
	
	
	//-------------------------------医嘱类型 ------------------------------------
	//这不是事件源 但这些大部分与各个服务调用总入口相对应，故放一起便于比对，将医嘱类型和调用各个服务事件源分开，是为了避免以后奇葩需求的出现，如检查的要触发其它类型的消息
	//门诊 
	public static final String OP_WC="op_wc";//西药
	public static final String OP_HERB="op_herb";//草药
	public static final String OP_RIS="op_ris";//检查
	public static final String OP_PATH="op_path";//病理
	public static final String OP_LIS="op_lis";//检验
	public static final String OP_OPERATION="op_operation";//手术
	public static final String OP_BT="op_bt";//备血
	public static final String OP_BU="op_bu";//用血
	public static final String OP_TREAT="op_treat";//治疗
	public static final String OP_REVERT="op_revert";//医嘱撤回-门诊暂无 貌似目前并没这样的需求要用到
	public static final String OP_OTHER="op_other";//其他
	public static final String OP_NS="op_ns";//护理-门诊暂无
	public static final String OP_CON="op_con";//会诊-门诊暂无
	//住院
	public static final String IP_WC="ip_wc";//西药
	public static final String IP_HERB="ip_herb";//草药
	public static final String IP_RIS="ip_ris";//检查
	public static final String IP_PATH="ip_path";//病理
	public static final String IP_LIS="ip_lis";//检验
	public static final String IP_OPERATION="ip_operation";//手术
	public static final String IP_BT="ip_bt";//备血
	public static final String IP_BU="ip_bu";//用血
	public static final String IP_TREAT="ip_treat";//治疗
	public static final String IP_NS="ip_ns";//护理
	public static final String IP_CON="ip_con";//会诊
	public static final String IP_STOP="ip_stop";//医嘱停止
	public static final String IP_CANCEL="ip_cancel";//医嘱作废
	public static final String IP_OTHER="ip_other";//其他
	
	
	
	
	//---------------------------各个服务(检查 检验 手术等)调用入口------------------------
	//门诊签署
	public static final String OP_DRUG_SIGN="iih.ci.ord.event.opdrugsign";//门诊处方/药品签署入口事件源
	public static final String OP_RIS_SIGN="iih.ci.ord.event.oprissign";//门诊检查签署入口事件源
	public static final String OP_PATH_SIGN="iih.ci.ord.event.oppathsign";//门诊病理签署入口事件源
	public static final String OP_LIS_SIGN="iih.ci.ord.event.oplissign";//门诊检验签署入口事件源
	public static final String OP_OP_SIGN="iih.ci.ord.event.opopsign";//门诊手术签署入口事件源
	public static final String OP_BT_SIGN="iih.ci.ord.event.opbtsign";//门诊备血签署入口事件源
	public static final String OP_BU_SIGN="iih.ci.ord.event.opbusign";//门诊用血签署入口事件源
	public static final String OP_TREAT_SIGN="iih.ci.ord.event.optreatsign";//门诊治疗签署入口事件源
	public static final String OP_CON_SIGN="iih.ci.ord.event.opconsign";//门诊会诊签署入口事件源
	//门诊撤回
	public static final String OP_DRUG_REVERT="iih.ci.ord.event.opdrugrevert";//门诊处方/药品撤回入口事件源
	public static final String OP_RIS_REVERT="iih.ci.ord.event.oprisrevert";//门诊检查撤回入口事件源
	public static final String OP_PATH_REVERT="iih.ci.ord.event.oppathrevert";//门诊病理撤回入口事件源
	public static final String OP_LIS_REVERT="iih.ci.ord.event.oplisrevert";//门诊检验撤回入口事件源
	public static final String OP_OP_REVERT="iih.ci.ord.event.opoprevert";//门诊手术撤回入口事件源
	public static final String OP_TREAT_REVERT="iih.ci.ord.event.optreatrevert";//门诊治疗撤回入口事件源
	public static final String OP_BT_REVERT="iih.ci.ord.event.opbtrevert";//门诊备血撤回入口事件源
	public static final String OP_BU_REVERT="iih.ci.ord.event.opburevert";//门诊用血撤回入口事件源
	public static final String OP_CON_REVERT="iih.ci.ord.event.opconrevert";//门诊会诊撤回入口事件源
	//门诊重新分方
	public static final String OP_DRUG_REPRES="iih.ci.ord.event.opdrugrepres";//门诊药品重新分方入口事件源
	//门诊收费
	public static final String OP_RIS_CHARGE="iih.ci.ord.event.oprischarge";//门诊检查收费入口事件源
	public static final String OP_PATH_CHARGE="iih.ci.ord.event.oppathcharge";//门诊病理收费入口事件源
	public static final String OP_LIS_CHARGE="iih.ci.ord.event.oplischarge";//门诊检验收费入口事件源
	public static final String OP_TREAT_CHARGE="iih.ci.ord.event.optreatcharge";//门诊治疗收费入口事件源
	public static final String OP_OP_CHARGE="iih.ci.ord.event.opopcharge";//门诊手术收费入口事件源
	//门诊退费
	public static final String OP_DRUG_REFUND="iih.ci.ord.event.opdrugrefund";//门诊药品退费入口事件源
	public static final String OP_RIS$LIS_REFUND="iih.ci.ord.event.opris$lisrefund";//门诊检查检验退费入口事件源
	public static final String OP_TREAT_REFUND="iih.ci.ord.event.optreatrefund";//门诊诊疗退费入口事件源
	//住院签署
	public static final String IP_DRUG_SIGN="iih.ci.ord.event.ipdrugsign";//住院用药签署入口事件源
	public static final String IP_RIS_SIGN="iih.ci.ord.event.iprissign";//住院检查签署入口事件源
	public static final String IP_PATH_SIGN="iih.ci.ord.event.ippathsign";//住院病理签署入口事件源
	public static final String IP_LIS_SIGN="iih.ci.ord.event.iplissign";//住院检验签署入口事件源
	public static final String IP_OP_SIGN="iih.ci.ord.event.ipopsign";//住院手术签署入口事件源
	public static final String IP_CON_SIGN="iih.ci.ord.event.ipconsign";//住院会诊签署入口事件源
	public static final String IP_BT_SIGN="iih.ci.ord.event.ipbtsign";//住院备血签署入口事件源
	public static final String IP_BU_SIGN="iih.ci.ord.event.ipbusign";//住院用血签署入口事件源
	public static final String IP_NS_SIGN="iih.ci.ord.event.ipnssign";//住院护理签署入口事件源
	public static final String IP_TREAT_SIGN="iih.ci.ord.event.iptreatsign";//住院治疗签署入口事件源
	public static final String IP_OTHER_SIGN="iih.ci.ord.event.ipothersign";//住院其他签署入口事件源
	//住院会诊完成
	public static final String IP_CON_COMPLETE = "iih.ci.mr.cimripbasedto.d.CiMrIPBaseDTO";//住院会诊完成入口事件源
	//住院停止作废
	public static final String IP_STOP_SIGN="iih.ci.ord.event.ipstopsign";//住院停止入口事件源
	public static final String IP_CANCEL_SIGN="iih.ci.ord.event.ipcancelsign";//住院作废入口事件源
	//科室手术审批
	public static final String IP_OP_APT_SIGN="iih.ci.ord.event.ipopaptsign";//住院手术签署入口事件源
	
	
	
	
	//----------------------------发往集成平台时触发器----------------------------------------
	//特别注意：要用返回的DTO数据类型的全路径名进行事件源的命名  与轻量级相匹配 
	//这个地方最好别自己定义，因为现在各个医院 都用的这个，改了就都炸了 只能说改的代价太大，模板需要重新配 事件也要再注册
	//这些触发器本来设计的是门诊住院分开，但目前来看 貌似并没 有的还是在共用，可能是当时某些特殊原因才这样的吧
	//老版IBdSrvDictCodeConst ICiIEEventConst记录事件源和服务类型
	//这个事件源和集成平台模板设置时的触发器保持一致即可，不一定非要这种格式
	//门诊
	public static final String EVENT_IE_CIOR_OP_DRUG = "iih.ci.ord.iemsg.d.IEOpPharmOrEnDTO";    //药品医嘱开立-触发事件
	public static final String EVENT_IE_CIOR_OP_DRUG_HERB = "iih.ci.ord.iemsg.d.IEOpPharmHerbOrDTO";//草药医嘱开立 
	public static final String EVENT_IE_CIOR_OP_DRUG_WC = "iih.ci.ord.iemsg.d.IEOpPharmWcOrDTO"; //西成药医嘱开立
	public static final String EVENT_IE_CIOR_OP_RIS = "iih.ci.ord.iemsg.d.IEOpRisOrEnDTO";//检查医嘱开立
	public static final String EVENT_IE_CIOR_OP_PATH = "iih.ci.ord.iemsg.d.IEOpPathEntDTO";//病理医嘱开立
	public static final String EVENT_IE_CIOR_OP_LIS = "iih.ci.ord.iemsg.d.IEOpLisOrEnDTO";//检验医嘱开立
	public static final String EVENT_IE_CIOR_OP_OP = "iih.ci.ord.iemsg.d.IEOpOpOrEnDTO";//手术医嘱开立
	public static final String EVENT_IE_CIOR_OP_PBT = "iih.ci.ord.iemsg.d.IEOpBtOrEnDTO";    //备血医嘱开立
	public static final String EVENT_IE_CIOR_OP_UBT = "iih.ci.ord.iemsg.d.IEOpBtUseOrDTO";    //用血医嘱开立
	public static final String EVENT_IE_CIOR_OP_TREAT = "iih.ci.ord.iemsg.d.IEOpTreatOrEnDTO";    //治疗医嘱开立
	public static final String EVENT_IE_CIOR_OP_CON = "iih.ci.ord.iemsg.d.IEOpOpConsulationDTO";    //会诊医嘱开立 这个dto名字和门诊的只多一个Op,原因是最初取名字时弄混了
	public static final String EVENT_IE_CIOR_OP_CANC_STOP = "iih.ci.ord.iemsg.d.IEOpOrCancStpEnDTO";//医嘱作废与停止
	public static final String EVENT_IE_CIDIAG_OP_SIGN = "iih.ci.ord.iemsg.d.IEOpPvDiagEnDTO";  //门诊临床诊断下达
	//住院
	public static final String EVENT_IE_CIOR_NSCHK_DRUG = "iih.ci.ord.iemsg.d.IEPharmOrEnDTO";    //药品医嘱开立-触发事件
	public static final String EVENT_IE_CIOR_NSCHK_DRUG_HERB = "iih.ci.ord.iemsg.d.IEPharmHerbOrDTO";//草药医嘱开立 
	public static final String EVENT_IE_CIOR_NSCHK_DRUG_WC = "iih.ci.ord.iemsg.d.IEPharmWcOrDTO"; //西成药医嘱开立
	public static final String EVENT_IE_CIOR_NSCHK_RIS = "iih.ci.ord.iemsg.d.IERisOrEnDTO";    //检查医嘱开立
	public static final String EVENT_IE_CIOR_IP_PATH = "iih.ci.ord.iemsg.d.IEIpPathEntDTO";//病理医嘱开立
	public static final String EVENT_IE_CIOR_NSCHK_LIS = "iih.ci.ord.iemsg.d.IELisOrEnDTO";    //检验医嘱开立
	public static final String EVENT_IE_CIOR_NSCHK_OP = "iih.ci.ord.iemsg.d.IEOpOrEnDTO";    //手术医嘱开立
	public static final String EVENT_IE_CIOR_NSCHK_PBT = "iih.ci.ord.iemsg.d.IEBtOrEnDTO";    //备血医嘱开立
	public static final String EVENT_IE_CIOR_NSCHK_UBT = "iih.ci.ord.iemsg.d.IEBtUseOrDTO";    //用血医嘱开立
	public static final String EVENT_IE_CIOR_NSCHK_NS = "iih.ci.ord.iemsg.d.IENsOrEnDTO";    //护理医嘱开立-02
	public static final String EVENT_IE_CIOR_NSCHK_TREAT = "iih.ci.ord.iemsg.d.IETreatOrEnDTO";    //治疗医嘱开立
	public static final String EVENT_IE_CIOR_NSCHK_CON = "iih.ci.ord.iemsg.d.IEOpConsulationDTO";    //会诊医嘱开立-02
	public static final String EVENT_IE_CIOR_NSCHK_OTH = "iih.ci.ord.iemsg.d.IEOthOrEnDTO";    //其它医嘱开立-02
	public static final String EVENT_IE_CIOR_NSCHK_CANC_STOP = "iih.ci.ord.iemsg.d.IEOrCancStpEnDTO";    //医嘱作废与停止
	
	public static final String EVENT_IE_CIOR_NSCHK_CON_COMPLETE = "MR_HZJL";//会诊完成-02
}
