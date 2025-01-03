package iih.ei.std.s.v1;

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
import iih.ei.std.d.v1.en.visittimesstat.d.VisitTimesStatParamDTO;
import iih.ei.std.d.v1.en.visittimesstat.d.VisitTimesStatResultDTO;
import iih.ei.std.i.v1.IEnApiService;
import iih.ei.std.s.v1.bp.en.CancAptAndRefundBP;
import iih.ei.std.s.v1.bp.en.CancAptBP;
import iih.ei.std.s.v1.bp.en.CancEntBP;
import iih.ei.std.s.v1.bp.en.CfmPaidAptBP;
import iih.ei.std.s.v1.bp.en.GetAptIdByAptCodeBP;
import iih.ei.std.s.v1.bp.en.GetBedInfoBP;
import iih.ei.std.s.v1.bp.en.GetBrokenAptListBP;
import iih.ei.std.s.v1.bp.en.GetCancIpInfoBP;
import iih.ei.std.s.v1.bp.en.GetChlSchStatsBP;
import iih.ei.std.s.v1.bp.en.GetEnPatCaInfoBP;
import iih.ei.std.s.v1.bp.en.GetEntLisByQuebencodeBP;
import iih.ei.std.s.v1.bp.en.GetEntListByDeptcodeBP;
import iih.ei.std.s.v1.bp.en.GetEntListByPatcodeBP;
import iih.ei.std.s.v1.bp.en.GetInvoiceInfoBP;
import iih.ei.std.s.v1.bp.en.GetIpEntBedInfoBP;
import iih.ei.std.s.v1.bp.en.GetIpEntContInfoBP;
import iih.ei.std.s.v1.bp.en.GetIpEntDepTransInfoBP;
import iih.ei.std.s.v1.bp.en.GetIpEntDiInfoBP;
import iih.ei.std.s.v1.bp.en.GetIpEntHpInfoBP;
import iih.ei.std.s.v1.bp.en.GetIpEntStateInfoBP;
import iih.ei.std.s.v1.bp.en.GetIpInfoAllByDepBp;
import iih.ei.std.s.v1.bp.en.GetIpInfoAllByIpCodeBp;
import iih.ei.std.s.v1.bp.en.GetIpInfoAllByPatBp;
import iih.ei.std.s.v1.bp.en.GetIpInfoByDepBp;
import iih.ei.std.s.v1.bp.en.GetIpInfoByIpCodeBp;
import iih.ei.std.s.v1.bp.en.GetIpInfoByPatBp;
import iih.ei.std.s.v1.bp.en.GetOEPDepListBP;
import iih.ei.std.s.v1.bp.en.GetOEPEmpDepMatchBP;
import iih.ei.std.s.v1.bp.en.GetOpAptListBP;
import iih.ei.std.s.v1.bp.en.GetOpAptListByAgentPatCodeBP;
import iih.ei.std.s.v1.bp.en.GetOpEntDiInfoBP;
import iih.ei.std.s.v1.bp.en.GetOpStopSchListBP;
import iih.ei.std.s.v1.bp.en.GetPaidAptDetailBP;
import iih.ei.std.s.v1.bp.en.GetPatInfoByDiBP;
import iih.ei.std.s.v1.bp.en.GetPatOpAptAndEntListBP;
import iih.ei.std.s.v1.bp.en.GetPatOpAptListBP;
import iih.ei.std.s.v1.bp.en.GetPatOpEntListBP;
import iih.ei.std.s.v1.bp.en.GetScAptByPatBP;
import iih.ei.std.s.v1.bp.en.GetSchListBP;
import iih.ei.std.s.v1.bp.en.GetSchTickInfoBP;
import iih.ei.std.s.v1.bp.en.GetSchTicksInfoBP;
import iih.ei.std.s.v1.bp.en.GetUserGroupBP;
import iih.ei.std.s.v1.bp.en.GetVisitTimesStatBP;
import iih.ei.std.s.v1.bp.en.GetWaitQueBP;
import iih.ei.std.s.v1.bp.en.GetWaitQueBySiteBP;
import iih.ei.std.s.v1.bp.en.MakeAptAndPayBP;
import iih.ei.std.s.v1.bp.en.MakeAptBP;
import iih.ei.std.s.v1.bp.en.MakeEntArriveBP;
import iih.ei.std.s.v1.bp.en.PayForAptBP;
import iih.ei.std.s.v1.bp.en.RegPricingBP;
import iih.ei.std.s.v1.bp.en.SaveEntOPNoSchBP;
import iih.ei.std.s.v1.bp.en.SaveRegEntIpBP;
import xap.mw.core.data.BizException;
/***
 * IIH就诊域标准对外接口
 * @author fanlq
 * @date: 2019年8月9日 下午3:44:02
 */
public class EnApiServiceImpl implements IEnApiService{
	
	/***********************begin--基础数据查询类--begin*******************************/
	/***
	 * @Description:获取用户组织
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public GetUserGroupResultDTO getUserGroup(GetUserGroupParamDTO param)  throws BizException{
		return new GetUserGroupBP().exec(param);
	}
	
	/***********************end--基础数据查询类--end*******************************/
	/***********************begin--门诊查询类--begin*******************************/
	/***
	 * @Description:获取门诊排班列表
	 * @param inParam
	 * @return
	 */
	@Override
	public SchListResultDTO getSchList(SchListParamDTO param) throws BizException{
		return new GetSchListBP().exec(param);
	}
	/***
	 * @Description:获取渠道预约统计信息
	 * @param param 入参
	 * @return
	 */
	@Override
	public ChlSchStatsResultDTO getChlSchStats(ChlSchStatsParamDTO param) throws BizException {
		return new GetChlSchStatsBP().exec(param);
	}
	/***
	 * @Description:获取门诊停诊列表
	 * @param param 入参
	 * @return
	 */
	@Override
	public OpStopSchListResultDTO getOpStopSchList(OpStopSchListParamDTO param) throws BizException {
		return new GetOpStopSchListBP().exec(param);
	}
	/***
	 * @Description:获取预约详细记录
	 * @param param 入参
	 * @return
	 */
	@Override
	public OpAptListResultDTO getOpAptList(OpAptListParamDTO param) throws BizException {
		return new GetOpAptListBP().exec(param);
	}
	/***
	 * @Description:获取门诊患者爽约记录
	 * @param param 入参
	 * @return
	 */
	@Override
	public BrokenAptListResultDTO getBrokenAptList(BrokenAptListParamDTO param) throws BizException {
		return new GetBrokenAptListBP().exec(param);
	}
	/***
	 * @Description:获取患者候诊队列
	 * @param param 入参
	 * @return
	 */
	@Override
	public OpWaitQueResultDTO getWaitQue(OpWaitQueParamDTO param) throws BizException {
		return new GetWaitQueBP().exec(param);
	}
	/***
	 * @Description:获取医生站点候诊队列
	 * @param param 入参
	 * @return
	 */
	@Override
	public OpWaitQueBySiteResultDTO getWaitQueBySite(OpWaitQueBySiteParamDTO param) throws BizException {
		return new GetWaitQueBySiteBP().exec(param);
	}
	/***
	 * @Description:获取患者预约记录
	 * @param param    入参
	 * @return
	 */
	@Override
	public PatOpAptListResultDTO getPatOpAptList(PatOpAptListParamDTO param) throws BizException {
		return new GetPatOpAptListBP().exec(param);
	}
	/***
	 * @Description:获取患者挂号记录
	 * @param param    入参 
	 * @return
	 */
	@Override
	public PatOpEntListResultDTO getPatOpEntList(PatOpEntListParamDTO param) throws BizException {
		return new GetPatOpEntListBP().exec(param);
	}
	/***
	 * @Description:获取患者挂号和预约记录
	 * @param param    入参
	 * @return
	 */
	@Override
	public PatOpAptAndEntListResultDTO getPatOpAptAndEntList(PatOpAptAndEntListParamDTO param) throws BizException {
		return new GetPatOpAptAndEntListBP().exec(param);
	}
	/***
	 * @Description:获取代办人预约记录
	 * @param param 入参
	 * @return
	 */
	@Override
	public OpAptListByAgentPatCodeResultDTO getOpAptListByAgentPatCode(OpAptListByAgentPatCodeParamDTO param)	throws BizException {
		return new GetOpAptListByAgentPatCodeBP().exec(param);
	}
	
	/***
	 * @Description:获取预约详细信息
	 * @param param 入参
	 * @return
	 */
	@Override
	public PaidAptDetailResultDTO getPaidAptDetail(PaidAptDetailParamDTO param) throws BizException {
		return new GetPaidAptDetailBP().exec(param);
	}
	/***
	 * @Description:根据预约编码获取预约id
	 * @param param 入参
	 * @return
	 */
	@Override
	public AptIdByAptCodeResultDTO getAptIdByAptCode(AptIdByAptCodeParamDTO param) throws BizException {
		return new GetAptIdByAptCodeBP().exec(param) ;
	}
	/***
	 * @Description:获取本次就诊患者分类
	 * @param param 入参
	 * @return
	 */
	@Override
	public EnPatCaInfoResultDTO getEnPatCaInfo(EnPatCaInfoParamDTO param) throws BizException {
		return new GetEnPatCaInfoBP().exec(param);
	}
	/***
	 * @Description:获取排班对应的号位
	 * @param param 入参
	 * @return
	 */
	@Override
	public SchTickInfoResultDTO getSchTickInfo(SchTickInfoParamDTO param) throws BizException {
		return new GetSchTickInfoBP().exec(param);
	}
	/***
	 * @Description:获取排班对应的号段
	 * @param param    入参
	 * @return
	 */
	@Override
	public TicksResultDTO getSchTicksInfo(TicksParamDTO param) throws BizException{
		return new GetSchTicksInfoBP().exec(param);
	}
	/***
	 * @Description:获取发票信息
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public GetInvoiceInfoResultDTO getInvoiceInfo(GetInvoiceInfoParamDTO param) throws BizException{
		return new GetInvoiceInfoBP().execTrans(param);
	}
	
	/***
	 * @Description:获取门诊患者诊断
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public OpEntDiInfoResultDTO getOpEntDI(OpEntDiInfoParamDTO param) throws BizException{
		return new GetOpEntDiInfoBP().exec(param);
	}
	
	/***
	 * @Description:对GCP（药物临床实验）等患者无排班挂号接诊，保存患者挂号记录和记账
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public SaveEntOPNoSchResultDTO saveEntOPNoSch(SaveEntOPNoSchParamDTO  param) throws BizException{
		return new SaveEntOPNoSchBP().execTrans(param);
	}
	
	/***********************end--门诊查询类--end*******************************/
	
	
	/**********************begin--住院查询--begin****************************/
	
	/**
	 * 获取住院信息By科室
	 * @param param    入参
	 */
	@Override
	public IpInfoResultDTO getIpInfoByDep(IpInfoByDepParamDTO param) throws BizException {
		return new GetIpInfoByDepBp().exec(param);
	}
	/**
	 * 获取住院信息By患者编号
	 * @param param    入参
	 */
	@Override
	public IpInfoResultDTO getIpInfoByPat(IpInfoByPatParamDTO param) throws BizException {
		return new GetIpInfoByPatBp().exec(param);
	}
	/**
	 * 获取住院信息By住院号
	 * @param param    入参
	 */
	@Override
	public IpInfoResultDTO getIpInfoByIpCode(IpInfoByIpCodeParamDTO param) throws BizException {
		return new GetIpInfoByIpCodeBp().exec(param);
	}
	/**
	 * 获取完整住院信息By科室
	 * @param param    入参
	 */
	@Override
	public IpInfoAllResultDTO getIpInfoAllByDep(IpInfoByDepParamDTO param) throws BizException {
		return new GetIpInfoAllByDepBp().exec(param);
	}
	/**
	 * 获取完整住院信息By患者编号
	 * @param param    入参
	 */
	@Override
	public IpInfoAllResultDTO getIpInfoAllByPat(IpInfoByPatParamDTO param) throws BizException {
		return new GetIpInfoAllByPatBp().exec(param);
	}
	/**
	 * 获取完整住院信息By住院号
	 * @param param    入参
	 */
	@Override
	public IpInfoAllResultDTO getIpInfoAllByIpCode(IpInfoByIpCodeParamDTO param) throws BizException {
		return new GetIpInfoAllByIpCodeBp().exec(param);
	}
	
	/**
	 * 获取住院患者诊断
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	@Override
	public IpEntDiInfoResultDTO getEntDi(CodeEntsParamDTO param) throws BizException {
		return new GetIpEntDiInfoBP().exec(param);
	}
	
	/**
	 * 获取住院患者医保信息
	 * @param param
	 * @return
	 */
	@Override
	public IpEntHpInfoResultDTO getEntHp(CodeEntsParamDTO param) throws BizException {
		return new GetIpEntHpInfoBP().exec(param);
	}
	
	/**
	 * 获取住院患者状况值
	 * @param param
	 * @return
	 */
	@Override
	public EnStateResultDTO getEntState(CodeEntsParamDTO param) throws BizException {
		return new GetIpEntStateInfoBP().exec(param);
	}
	
	/**
	 * 获取住院患者转科记录
	 * @param param
	 * @return
	 */
	@Override
	public EntDepTransResultDTO getEntDepTrans(CodeEntsParamDTO param) throws BizException {
		return new GetIpEntDepTransInfoBP().exec(param);
	}
	
	/**
	 * 获取住院患者转床记录
	 * @param param
	 * @return
	 */
	@Override
	public EntBedResultDTO getEntBed(CodeEntsParamDTO param) throws BizException {
		return new GetIpEntBedInfoBP().exec(param);
	}
	
	/**
	 * 获取住院患者联系人信息
	 * @param param
	 * @return
	 */
	@Override
	public EntContResultDTO getEntCont(CodeEntsParamDTO param) throws BizException {
		return new GetIpEntContInfoBP().exec(param);
	}
	
	/**
	 * 获取病区床位列表
	 * @param param
	 * @return
	 */
	@Override
	public BedInfoResultDTO getBedInfos(BedInfoParamDTO param) throws BizException {
		return new GetBedInfoBP().exec(param);
	}
	
	/**
	 * 获取退院患者列表
	 * @param param
	 * @return
	 */
	@Override
	public CancIpInfosResultDTO getCancIpInfos(CancIpInfosParamDTO param) throws BizException {
		return new GetCancIpInfoBP().exec(param);
	}
	
	/**
	 * 获取入院许可证
	 * @param param
	 * @return
	 */
	@Override
	public ScAptByPatResultDTO getScAptByPat(ScAptByPatParamDTO param) throws BizException {
		return new GetScAptByPatBP().exec(param);
	}


	/***
	 * @Description:获取分诊台可分诊挂号列表
	 * @param param 入参
	 * @return
	 */
	@Override
	public EntListByQuebencodeResultDTO getEntLisByQuebenCode(EntListByQuebencodeParamDTO param) throws BizException {
		return new GetEntLisByQuebencodeBP().exec(param);
	}
	/***
	 * @Description:获取患者就诊记录（通过患者编码）
	 * @param param 入参
	 * @return
	 */
	@Override
	public EntListByPatcodeResultDTO getEntListByPatcode(EntListByPatcodeParamDTO param) throws BizException {
		return new GetEntListByPatcodeBP().exec(param);
	}
	/***
	 * @Description:获取患者就诊记录（通过科室）
	 * @param param 入参
	 * @return
	 */
	@Override
	public EntListByDeptcodeResultDTO getEntListByDeptcode(EntListByDeptcodeParamDTO param) throws BizException {
		return new GetEntListByDeptcodeBP().exec(param);
	}
	/***
	 * @Description:统计门急诊就诊人次
	 * @param param 入参
	 * @return
	 */
	@Override
	public VisitTimesStatResultDTO getVisitTimesStat(VisitTimesStatParamDTO param) throws BizException {
		return new GetVisitTimesStatBP().exec(param);
	}
	/***
	 * @Description:通过诊断编码获取患者信息
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public GetPatInfoByDiResultDTO getPatInfoByDi(GetPatInfoByDiParamDTO param) throws BizException{
		return new GetPatInfoByDiBP().exec(param);
	}
	/*************begin--住院查询--end*******************/
	
	/***********************begin--业务类--begin*******************************/

	/***
	 * @Description:预约门诊号
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public MakeAptResultDTO makeApt(MakeAptParamDTO param)  throws BizException{
		return new MakeAptBP().execTrans(param);
	}
	/***
	 * @Description:划价
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public RegPricingResultDTO regPricing(RegPricingParamDTO param) throws BizException{
		return new RegPricingBP().execTrans(param);
	}
	/****
	 * @Description:收取预约费
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public PayForAptResultDTO payForApt(PayForAptParamDTO param) throws BizException{
		return new PayForAptBP().execTrans(param);
	}
	/***
	 * @Description:预约且收取费用（医保直接取号）
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public MakeAptAndPayResultDTO makeAptAndPay(MakeAptAndPayParamDTO param) throws BizException{
		return new MakeAptAndPayBP().execTrans(param);
	}
	/****
	 * @Description:取消预约
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public void cancApt(CancAptParamDTO param) throws BizException{
		new CancAptBP().execTrans(param);
	}
	/****
	 * @Description:取消预约并退费
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public CancAptAndRefundResultDTO cancAptAndRefund(CancAptAndRefundParamDTO param) throws BizException{
		return new CancAptAndRefundBP().execTrans(param);
	}
	/****
	 * @Description:门诊退号
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public void cancEnt(CancEntParamDTO param) throws BizException{
		new CancEntBP().execTrans(param);
	}
	/****
	 * @Description:签到分诊
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public MakeEntArriveResultDTO makeEntArrive(MakeEntArriveParamDTO param) throws BizException{
		return new MakeEntArriveBP().execTrans(param);
	}
	
	/****
	 * @Description:已收费预约取号
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public void cfmPaidApt(CfmPaidAptParamDTO param)  throws BizException{
		new CfmPaidAptBP().execTrans(param);
	}
	
	/****
	 * @Description:保存住院登记
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public EntIpRegInfoResultDTO saveRegEntIp(EntIpRegInfoParamDTO param)  throws BizException{
		return new SaveRegEntIpBP().execTrans(param);
	}
	/****
	 * @Description:门急诊出诊科室列表
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public OEPDepListResultDTO getOEPDepList(OEPDepListParamDTO param) throws BizException {
		return new GetOEPDepListBP().exec(param);
	}
	/****
	 * @Description:门急诊医生出诊科室列表
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@Override
	public OEPEmpDepMatchResultDTO getOEPEmpDepMatch(OEPEmpDepMatchParamDTO param) throws BizException {
		return new GetOEPEmpDepMatchBP().exec(param);
	}
	
	/***********************end--业务类--end*******************************/
	
}
