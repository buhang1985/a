package iih.ei.std.i.v1;

import iih.ei.std.d.v1.en.aptidbyaptcode.d.AptIdByAptCodeParamDTO;
import iih.ei.std.d.v1.en.aptidbyaptcode.d.AptIdByAptCodeResultDTO;
import iih.ei.std.d.v1.en.bedinfo.d.BedInfoParamDTO;
import iih.ei.std.d.v1.en.bedinfo.d.BedInfoResultDTO;
import iih.ei.std.d.v1.en.brokenaptlist.d.BrokenAptListParamDTO;
import iih.ei.std.d.v1.en.brokenaptlist.d.BrokenAptListResultDTO;
import iih.ei.std.d.v1.en.cancapt.d.CancAptParamDTO;
import iih.ei.std.d.v1.en.cancaptandrefund.d.CancAptAndRefundParamDTO;
import iih.ei.std.d.v1.en.cancaptandrefund.d.CancAptAndRefundResultDTO;
import iih.ei.std.d.v1.en.cancent.d.CancEntParamDTO;
import iih.ei.std.d.v1.en.cancipinfos.d.CancIpInfosParamDTO;
import iih.ei.std.d.v1.en.cancipinfos.d.CancIpInfosResultDTO;
import iih.ei.std.d.v1.en.cfmpaidapt.d.CfmPaidAptParamDTO;
import iih.ei.std.d.v1.en.chlschstats.d.ChlSchStatsParamDTO;
import iih.ei.std.d.v1.en.chlschstats.d.ChlSchStatsResultDTO;
import iih.ei.std.d.v1.en.enpatcainfo.d.EnPatCaInfoParamDTO;
import iih.ei.std.d.v1.en.enpatcainfo.d.EnPatCaInfoResultDTO;
import iih.ei.std.d.v1.en.enstate.d.CodeEntsParamDTO;
import iih.ei.std.d.v1.en.enstate.d.EnStateResultDTO;
import iih.ei.std.d.v1.en.entbeddto.d.EntBedResultDTO;
import iih.ei.std.d.v1.en.entcontdto.d.EntContResultDTO;
import iih.ei.std.d.v1.en.entdeptrans.d.EntDepTransResultDTO;
import iih.ei.std.d.v1.en.entipreginfo.d.EntIpRegInfoParamDTO;
import iih.ei.std.d.v1.en.entipreginfo.d.EntIpRegInfoResultDTO;
import iih.ei.std.d.v1.en.entlistbydeptcode.d.EntListByDeptcodeParamDTO;
import iih.ei.std.d.v1.en.entlistbydeptcode.d.EntListByDeptcodeResultDTO;
import iih.ei.std.d.v1.en.entlistbypatcode.d.EntListByPatcodeParamDTO;
import iih.ei.std.d.v1.en.entlistbypatcode.d.EntListByPatcodeResultDTO;
import iih.ei.std.d.v1.en.entlistbyquebencode.d.EntListByQuebencodeParamDTO;
import iih.ei.std.d.v1.en.entlistbyquebencode.d.EntListByQuebencodeResultDTO;
import iih.ei.std.d.v1.en.getinvoiceinfo.d.GetInvoiceInfoParamDTO;
import iih.ei.std.d.v1.en.getinvoiceinfo.d.GetInvoiceInfoResultDTO;
import iih.ei.std.d.v1.en.getpatinfobydi.d.GetPatInfoByDiParamDTO;
import iih.ei.std.d.v1.en.getpatinfobydi.d.GetPatInfoByDiResultDTO;
import iih.ei.std.d.v1.en.getticksinfo.d.TicksParamDTO;
import iih.ei.std.d.v1.en.getticksinfo.d.TicksResultDTO;
import iih.ei.std.d.v1.en.getusergroup.d.GetUserGroupParamDTO;
import iih.ei.std.d.v1.en.getusergroup.d.GetUserGroupResultDTO;
import iih.ei.std.d.v1.en.ipentdiinfo.d.IpEntDiInfoResultDTO;
import iih.ei.std.d.v1.en.ipenthpinfodto.d.IpEntHpInfoResultDTO;
import iih.ei.std.d.v1.en.ipinfo.d.IpInfoAllResultDTO;
import iih.ei.std.d.v1.en.ipinfo.d.IpInfoByDepParamDTO;
import iih.ei.std.d.v1.en.ipinfo.d.IpInfoByIpCodeParamDTO;
import iih.ei.std.d.v1.en.ipinfo.d.IpInfoByPatParamDTO;
import iih.ei.std.d.v1.en.ipinfo.d.IpInfoResultDTO;
import iih.ei.std.d.v1.en.makeapt.d.MakeAptParamDTO;
import iih.ei.std.d.v1.en.makeapt.d.MakeAptResultDTO;
import iih.ei.std.d.v1.en.makeaptandpay.d.MakeAptAndPayParamDTO;
import iih.ei.std.d.v1.en.makeaptandpay.d.MakeAptAndPayResultDTO;
import iih.ei.std.d.v1.en.makeentarrive.d.MakeEntArriveParamDTO;
import iih.ei.std.d.v1.en.makeentarrive.d.MakeEntArriveResultDTO;
import iih.ei.std.d.v1.en.oepdeplist.d.OEPDepListParamDTO;
import iih.ei.std.d.v1.en.oepdeplist.d.OEPDepListResultDTO;
import iih.ei.std.d.v1.en.oepempdepmatch.d.OEPEmpDepMatchParamDTO;
import iih.ei.std.d.v1.en.oepempdepmatch.d.OEPEmpDepMatchResultDTO;
import iih.ei.std.d.v1.en.opaptlist.d.OpAptListParamDTO;
import iih.ei.std.d.v1.en.opaptlist.d.OpAptListResultDTO;
import iih.ei.std.d.v1.en.opaptlistbyagentpatcode.d.OpAptListByAgentPatCodeParamDTO;
import iih.ei.std.d.v1.en.opaptlistbyagentpatcode.d.OpAptListByAgentPatCodeResultDTO;
import iih.ei.std.d.v1.en.opentdiinfodto.d.OpEntDiInfoParamDTO;
import iih.ei.std.d.v1.en.opentdiinfodto.d.OpEntDiInfoResultDTO;
import iih.ei.std.d.v1.en.opstopschlist.d.OpStopSchListParamDTO;
import iih.ei.std.d.v1.en.opstopschlist.d.OpStopSchListResultDTO;
import iih.ei.std.d.v1.en.opwaitque.d.OpWaitQueParamDTO;
import iih.ei.std.d.v1.en.opwaitque.d.OpWaitQueResultDTO;
import iih.ei.std.d.v1.en.opwaitquebysite.d.OpWaitQueBySiteParamDTO;
import iih.ei.std.d.v1.en.opwaitquebysite.d.OpWaitQueBySiteResultDTO;
import iih.ei.std.d.v1.en.paidaptdetail.d.PaidAptDetailParamDTO;
import iih.ei.std.d.v1.en.paidaptdetail.d.PaidAptDetailResultDTO;
import iih.ei.std.d.v1.en.patopapt.d.PatOpAptListParamDTO;
import iih.ei.std.d.v1.en.patopapt.d.PatOpAptListResultDTO;
import iih.ei.std.d.v1.en.patopaptandent.d.PatOpAptAndEntListParamDTO;
import iih.ei.std.d.v1.en.patopaptandent.d.PatOpAptAndEntListResultDTO;
import iih.ei.std.d.v1.en.patopent.d.PatOpEntListParamDTO;
import iih.ei.std.d.v1.en.patopent.d.PatOpEntListResultDTO;
import iih.ei.std.d.v1.en.payforapt.d.PayForAptParamDTO;
import iih.ei.std.d.v1.en.payforapt.d.PayForAptResultDTO;
import iih.ei.std.d.v1.en.regpricing.d.RegPricingParamDTO;
import iih.ei.std.d.v1.en.regpricing.d.RegPricingResultDTO;
import iih.ei.std.d.v1.en.saveenopnoschdto.d.SaveEntOPNoSchParamDTO;
import iih.ei.std.d.v1.en.saveenopnoschdto.d.SaveEntOPNoSchResultDTO;
import iih.ei.std.d.v1.en.scaptbypat.d.ScAptByPatParamDTO;
import iih.ei.std.d.v1.en.scaptbypat.d.ScAptByPatResultDTO;
import iih.ei.std.d.v1.en.schlist.d.SchListParamDTO;
import iih.ei.std.d.v1.en.schlist.d.SchListResultDTO;
import iih.ei.std.d.v1.en.schtickinfo.d.SchTickInfoParamDTO;
import iih.ei.std.d.v1.en.schtickinfo.d.SchTickInfoResultDTO;
import iih.ei.std.d.v1.en.setentpestatusdto.d.SetEntPeStatusParamDTO;
import iih.ei.std.d.v1.en.visittimesstat.d.VisitTimesStatParamDTO;
import iih.ei.std.d.v1.en.visittimesstat.d.VisitTimesStatResultDTO;
import xap.mw.core.data.BizException;

/***
 * 就诊域对内接口服务
 * @author fanlq
 * @date: 2019年8月9日 下午3:32:16
 */
public interface IEnApiService {
	
	
	/***********************begin--基础数据查询类--begin*******************************/
	/***
	 * @Description:获取用户组织
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public GetUserGroupResultDTO getUserGroup(GetUserGroupParamDTO param)  throws BizException;
	
	/***********************end--基础数据查询类--end*******************************/
	
	
	/***********************begin--门诊查询类--begin*******************************/
	/***
	 * @Description:获取门诊排班列表
	 * @param inParam
	 * @return
	 */
	public SchListResultDTO getSchList(SchListParamDTO param) throws BizException;
	/***
	 * @Description:获取渠道预约统计信息
	 * @param param    入参
	 * @return
	 */
	public ChlSchStatsResultDTO getChlSchStats(ChlSchStatsParamDTO param) throws BizException;
	/***
	 * @Description:获取门诊停诊列表
	 * @param param    入参
	 * @return
	 */
	public OpStopSchListResultDTO getOpStopSchList(OpStopSchListParamDTO param) throws BizException;
	/***
	 * @Description:获取预约详细记录
	 * @param param    入参
	 * @return
	 */
	public OpAptListResultDTO getOpAptList(OpAptListParamDTO param) throws BizException;
	/***
	 * @Description:获取门诊患者爽约记录
     * @param param    入参
	 * @return
	 */
	public BrokenAptListResultDTO getBrokenAptList(BrokenAptListParamDTO param) throws BizException;
	/***
	 * @Description:获取患者候诊队列
	 * @param param    入参
	 * @return
	 */
	public OpWaitQueResultDTO getWaitQue(OpWaitQueParamDTO param) throws BizException;
	/***
	 * @Description:获取医生站点候诊队列
	 * @param param    入参
	 * @return
	 */
	public OpWaitQueBySiteResultDTO getWaitQueBySite(OpWaitQueBySiteParamDTO param) throws BizException;
	/***
	 * @Description:获取患者预约记录
	 * @param param    入参
	 * @return
	 */
	public PatOpAptListResultDTO getPatOpAptList(PatOpAptListParamDTO param) throws BizException;
	/***
	 * @Description:获取患者挂号记录
	 * @param param    入参
	 * @return
	 */
	public PatOpEntListResultDTO getPatOpEntList(PatOpEntListParamDTO param) throws BizException;
	/***
	 * @Description:获取患者挂号和预约记录
	 * @param param    入参
	 * @return
	 */
	public PatOpAptAndEntListResultDTO getPatOpAptAndEntList(PatOpAptAndEntListParamDTO Param) throws BizException;
	/***
	 * @Description:获取代办人预约记录
	 * @param param    入参
	 * @return
	 */
	public OpAptListByAgentPatCodeResultDTO getOpAptListByAgentPatCode(OpAptListByAgentPatCodeParamDTO param) throws BizException;
	/***
	 * @Description:获取预约详细信息
	 * @param param    入参
	 * @return
	 */
	public PaidAptDetailResultDTO getPaidAptDetail(PaidAptDetailParamDTO param) throws BizException;
	/***
	 * @Description:根据预约编码获取预约id
	 * @param param    入参
	 * @return
	 */
	public AptIdByAptCodeResultDTO getAptIdByAptCode(AptIdByAptCodeParamDTO param) throws BizException;
	/***
	 * @Description:获取本次就诊患者分类
	 * @param param    入参
	 * @return	
	 */
	public EnPatCaInfoResultDTO getEnPatCaInfo(EnPatCaInfoParamDTO param)throws BizException;
	/***
	 * @Description:获取排班对应的号位
	 * @param param    入参
	 * @return
	 */
	public SchTickInfoResultDTO getSchTickInfo(SchTickInfoParamDTO param) throws BizException;
	/***
	 * @Description:获取排班对应的号段
	 * @param param    入参
	 * @return
	 */
	public TicksResultDTO getSchTicksInfo(TicksParamDTO param) throws BizException;
	
	/***
	 * @Description:获取发票信息
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public GetInvoiceInfoResultDTO getInvoiceInfo(GetInvoiceInfoParamDTO param) throws BizException;
	/***
	 * @Description:获取门诊患者诊断
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OpEntDiInfoResultDTO getOpEntDI(OpEntDiInfoParamDTO param) throws BizException;

	/***********************end--门诊查询类--end*******************************/
	
	
	/*************begin--住院查询--begin*******************/
	
	/**
	 * 获取住院信息By科室
	 * @param param    入参
	 */
	public IpInfoResultDTO getIpInfoByDep(IpInfoByDepParamDTO param) throws BizException;
	
	/**
	 * 获取住院信息By患者编号
	 * @param param    入参
	 */
	public IpInfoResultDTO getIpInfoByPat(IpInfoByPatParamDTO param) throws BizException;
	
	/**
	 * 获取住院信息By住院号
	 * @param param    入参
	 */
	public IpInfoResultDTO getIpInfoByIpCode(IpInfoByIpCodeParamDTO param) throws BizException;
	
	/**
	 * 获取完整住院信息By科室
	 * @param param    入参
	 */
	public IpInfoAllResultDTO getIpInfoAllByDep(IpInfoByDepParamDTO param) throws BizException;
	
	/**
	 * 获取完整住院信息By患者编号
	 * @param param    入参
	 */
	public IpInfoAllResultDTO getIpInfoAllByPat(IpInfoByPatParamDTO param) throws BizException;
	
	/**
	 * 获取完整住院信息By住院号
	 * @param param    入参
	 */
	public IpInfoAllResultDTO getIpInfoAllByIpCode(IpInfoByIpCodeParamDTO param) throws BizException;
	/**
	 * 获取分诊台可分诊挂号列表
	 * @param param    入参
	 */
	public EntListByQuebencodeResultDTO getEntLisByQuebenCode(EntListByQuebencodeParamDTO param) throws BizException;
	/**
	 * 获取患者就诊记录（通过患者编码）
	 * @param param    入参
	 */
	public EntListByPatcodeResultDTO getEntListByPatcode(EntListByPatcodeParamDTO param) throws BizException;
	/**
	 * 获取患者就诊记录（通过科室）
	 * @param param    入参
	 */
	public EntListByDeptcodeResultDTO getEntListByDeptcode(EntListByDeptcodeParamDTO param) throws BizException;
	/**
	 * 统计门急诊就诊人次
	 * @param param    入参
	 */
	public VisitTimesStatResultDTO getVisitTimesStat(VisitTimesStatParamDTO param) throws BizException;
	
	/**
	 * 获取住院患者诊断
	 * @param param
	 * @return
	 */
	public IpEntDiInfoResultDTO getEntDi(CodeEntsParamDTO param) throws BizException;
	/**
	 * 获取住院患者医保信息
	 * @param param
	 * @return
	 */
	public IpEntHpInfoResultDTO getEntHp(CodeEntsParamDTO param) throws BizException;
	/**
	 * 获取住院患者状况值
	 * @param param
	 * @return
	 */
	public EnStateResultDTO getEntState(CodeEntsParamDTO param) throws BizException;
	/**
	 * 获取住院患者转科记录
	 * @param param
	 * @return
	 */
	public EntDepTransResultDTO getEntDepTrans(CodeEntsParamDTO param) throws BizException;
	/**
	 * 获取住院患者转床记录
	 * @param param
	 * @return
	 */
	public EntBedResultDTO getEntBed(CodeEntsParamDTO param) throws BizException;
	
	/**
	 * 获取住院患者联系人信息
	 * @param param
	 * @return
	 */
	public EntContResultDTO getEntCont(CodeEntsParamDTO param) throws BizException;
	
	/**
	 * 获取病区床位列表
	 * @param param
	 * @return
	 */
	public BedInfoResultDTO getBedInfos(BedInfoParamDTO param) throws BizException;
	
	/**
	 * 获取退院患者列表
	 * @param param
	 * @return
	 */
	public CancIpInfosResultDTO getCancIpInfos(CancIpInfosParamDTO param) throws BizException;
	
	/**
	 * 获取入院许可证
	 * @param param
	 * @return
	 */
	public ScAptByPatResultDTO getScAptByPat(ScAptByPatParamDTO param) throws BizException;
	
	
	/*************begin--住院查询--end*******************/

	
	/***********************begin--业务类--begin*******************************/
	
	/***
	 * @Description:预约门诊号
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public MakeAptResultDTO makeApt(MakeAptParamDTO param) throws BizException;
	/***
	 * @Description:预约且收取费用（医保直接取号）
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public MakeAptAndPayResultDTO makeAptAndPay(MakeAptAndPayParamDTO param) throws BizException;
	/***
	 * @Description:划价
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public RegPricingResultDTO regPricing(RegPricingParamDTO param) throws BizException;
	/****
	 * @Description:收取预约费
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public PayForAptResultDTO payForApt(PayForAptParamDTO param) throws BizException;
	/****
	 * @Description:取消预约
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public void cancApt(CancAptParamDTO param) throws BizException;
	/****
	 * @Description:取消预约并退费
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public CancAptAndRefundResultDTO cancAptAndRefund(CancAptAndRefundParamDTO param) throws BizException;
	/****
	 * @Description:门诊退号
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public void cancEnt(CancEntParamDTO param) throws BizException;
	/****
	 * @Description:签到分诊
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public MakeEntArriveResultDTO makeEntArrive(MakeEntArriveParamDTO param) throws BizException;
	/****
	 * @Description:已收费预约取号
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public void cfmPaidApt(CfmPaidAptParamDTO param) throws BizException;
	/****
	 * @Description:保存住院登记
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public EntIpRegInfoResultDTO saveRegEntIp(EntIpRegInfoParamDTO param) throws BizException;
	/****
	 * @Description:门急诊出诊科室列表
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OEPDepListResultDTO getOEPDepList(OEPDepListParamDTO param) throws BizException;
	/****
	 * @Description:门急诊医生出诊科室列表
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public OEPEmpDepMatchResultDTO getOEPEmpDepMatch(OEPEmpDepMatchParamDTO param) throws BizException;
	/***
	 * @Description:通过诊断编码获取患者信息
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public GetPatInfoByDiResultDTO getPatInfoByDi(GetPatInfoByDiParamDTO param) throws BizException;
	/***
	 * @Description:对GCP（药物临床实验）等患者无排班挂号接诊，保存患者挂号记录和记账
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public SaveEntOPNoSchResultDTO saveEntOPNoSch(SaveEntOPNoSchParamDTO  param) throws BizException;
	/***********************end--业务类--end*******************************/
}
