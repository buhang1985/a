package iih.en.pv.appoint.s;

import iih.bd.utils.WsXmlUtils;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.itf.bp.opapt.xml.WsEnCfmPaidAptXmlBP;
import iih.en.itf.bp.opapt.xml.WsEnMakeAptXmlBP;
import iih.en.itf.bp.opapt.xml.WsEnPayForAptXmlBP;
import iih.en.itf.bp.opapt.xml.WsEnRegPricingXmlBP;
import iih.en.pv.appoint.bean.AptIdByAptCodeParam;
import iih.en.pv.appoint.bean.BrokenAptListParam;
import iih.en.pv.appoint.bean.CancAptAndRefundParam;
import iih.en.pv.appoint.bean.CancAptParam;
import iih.en.pv.appoint.bean.ChlSchStatsParam;
import iih.en.pv.appoint.bean.EnPatCaInfoParam;
import iih.en.pv.appoint.bean.EntArriveParam;
import iih.en.pv.appoint.bean.EntLisByQuebencodeParam;
import iih.en.pv.appoint.bean.EntListByDeptCodeParam;
import iih.en.pv.appoint.bean.EntListByPatcodeParam;
import iih.en.pv.appoint.bean.MakeAptAndPayParam;
import iih.en.pv.appoint.bean.OpAptListByAgentPatCodeParam;
import iih.en.pv.appoint.bean.OpAptListParam;
import iih.en.pv.appoint.bean.OpStopSchListParam;
import iih.en.pv.appoint.bean.PaidAptDetailParam;
import iih.en.pv.appoint.bean.PatOpAptAndEntListParam;
import iih.en.pv.appoint.bean.PatOpAptListParam;
import iih.en.pv.appoint.bean.PatOpEntListParam;
import iih.en.pv.appoint.bean.SchListParam;
import iih.en.pv.appoint.bean.SchTickInfoParam;
import iih.en.pv.appoint.bean.VisitTimesStatParam;
import iih.en.pv.appoint.bean.WaitQueParam;
import iih.en.pv.appoint.i.IAppointExternalService;
import iih.en.pv.appoint.result.AppointResultBean;
import iih.en.pv.appoint.result.AppointResultManage;
import iih.en.pv.appoint.result.AptIdByAptCodeResult;
import iih.en.pv.appoint.result.AptNewResult;
import iih.en.pv.appoint.result.BrokenAptListResult;
import iih.en.pv.appoint.result.ChlSchStatsResult;
import iih.en.pv.appoint.result.EnPatCaInfoResult;
import iih.en.pv.appoint.result.EntArriveResult;
import iih.en.pv.appoint.result.EntLisByQuebencodeResult;
import iih.en.pv.appoint.result.EntListByDeptCodeResult;
import iih.en.pv.appoint.result.EntListByPatcodeResult;
import iih.en.pv.appoint.result.MessageResult;
import iih.en.pv.appoint.result.OEPDepListResult;
import iih.en.pv.appoint.result.OEPEmpDepMatchResult;
import iih.en.pv.appoint.result.OpAptListByAgentPatCodeResult;
import iih.en.pv.appoint.result.OpAptListResult;
import iih.en.pv.appoint.result.OpStopSchListResult;
import iih.en.pv.appoint.result.PaidAptDetailResult;
import iih.en.pv.appoint.result.PatOpAptAndEntListResult;
import iih.en.pv.appoint.result.PatOpAptListResult;
import iih.en.pv.appoint.result.PatOpEntListResult;
import iih.en.pv.appoint.result.ResultDatasBean;
import iih.en.pv.appoint.result.SchListResult;
import iih.en.pv.appoint.result.SchTickInfoResult;
import iih.en.pv.appoint.result.VisitTimesStatResult;
import iih.en.pv.appoint.result.WaitQueResult;
import iih.en.pv.outpatient.dto.d.ArriveResultBean;
import iih.en.pv.outpatient.dto.d.BrokenAptDTO;
import iih.en.pv.outpatient.dto.d.ChlSchStatsDTO;
import iih.en.pv.outpatient.dto.d.EnPatCaInfoDTO;
import iih.en.pv.outpatient.dto.d.EntInfoDTO;
import iih.en.pv.outpatient.dto.d.EntRegInfoDTO;
import iih.en.pv.outpatient.dto.d.OpAptDTO;
import iih.en.pv.outpatient.dto.d.OpEntListDTO;
import iih.en.pv.outpatient.dto.d.OpPatAptDTO;
import iih.en.pv.outpatient.dto.d.OpVisitTimesStatDTO;
import iih.en.pv.outpatient.dto.d.OpWaitQueDTO;
import iih.en.pv.outpatient.dto.d.PatEntInfoDTO;
import iih.en.pv.outpatient.dto.d.ResultBean;
import iih.en.pv.outpatient.dto.d.SchInfoDTO;
import iih.en.pv.outpatient.dto.d.SchTickInfoDTO;
import iih.en.pv.s.bp.GetOEPDepListBP;
import iih.en.pv.s.bp.op.GetBrokenAptListBP;
import iih.en.pv.s.bp.op.ws.CancApt4AppNewBP;
import iih.en.pv.s.bp.op.ws.GetAptInfoBP;
import iih.en.pv.s.bp.op.ws.GetChlSchStatsBP;
import iih.en.pv.s.bp.op.ws.GetEnPatCaInfoBP;
import iih.en.pv.s.bp.op.ws.GetEntLisByQuebencodeBP;
import iih.en.pv.s.bp.op.ws.GetEntListByDeptCodeBP;
import iih.en.pv.s.bp.op.ws.GetEntListByPatcodeBP;
import iih.en.pv.s.bp.op.ws.GetOpAptAndEntListBP;
import iih.en.pv.s.bp.op.ws.GetOpAptListBP;
import iih.en.pv.s.bp.op.ws.GetOpAptListByAgentPatCodeBP;
import iih.en.pv.s.bp.op.ws.GetOpEmpDepMatchBP;
import iih.en.pv.s.bp.op.ws.GetOpStopSchListBP;
import iih.en.pv.s.bp.op.ws.GetPatOpAptListBP;
import iih.en.pv.s.bp.op.ws.GetPatOpEntListBP;
import iih.en.pv.s.bp.op.ws.GetPatPaidOpAptBP;
import iih.en.pv.s.bp.op.ws.GetSchListBP;
import iih.en.pv.s.bp.op.ws.GetSchTickInfoBP;
import iih.en.pv.s.bp.op.ws.GetVisitTimesStatBP;
import iih.en.pv.s.bp.op.ws.GetWaitQueBP;
import iih.en.pv.s.bp.op.ws.GetWaitQueBySiteBP;
import iih.en.pv.s.bp.op.ws.MakeAptAndPayBP;
import iih.en.pv.s.bp.op.ws.MakeEntArriveBP;
import iih.en.pv.s.bp.op.ws.Refund4AppNewBP;
import iih.sc.apt.dto.d.RegResultDTO;
import iih.sc.sch.dto.d.DeptWithSchDTO;
import iih.sc.sch.dto.d.OpEmpDepDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/***
 * 
 * 对外接口-APP预约
 * @author zhangpp
 *
 */
public class AppointExternalServieImpl implements IAppointExternalService {

	/**
	 * 获取排班信息
	 */
	@Override
	public String getSchList(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getSchList入参为:params:" + params);
		AppointResultBean<SchListResult> resultbean = new AppointResultBean<SchListResult>();
		try {
			final SchListParam bean = WsXmlUtils.deSerializeBaseDO(params, SchListParam.class);
			GetSchListBP bp = new GetSchListBP();
			SchInfoDTO[] schInfoDTOs = bp.exec(bean.getDeptCode(), bean.getResName(), 
					bean.getBeginDate(), bean.getEndDate(), bean.getSrvType(), bean.getChlType());
			SchListResult[] results = AppointResultManage.getSchListResult(schInfoDTOs);
			resultbean.setDatas(new ResultDatasBean<SchListResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getHisPats出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 获取渠道统计信息
	 */
	@Override
	public String getChlSchStats(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getChlSchStats入参为:params:" + params);
		AppointResultBean<ChlSchStatsResult> resultbean = new AppointResultBean<ChlSchStatsResult>();
		try {
			final ChlSchStatsParam bean = WsXmlUtils.deSerializeBaseDO(params, ChlSchStatsParam.class);
			GetChlSchStatsBP bp = new GetChlSchStatsBP();
			ChlSchStatsDTO[] chlSchStatsDTOs = bp.exec(bean.getDeptCode(), bean.getDeptName(), 
					bean.getBeginDate(), bean.getEndDate(), bean.getSrvType(), bean.getChlType());
			ChlSchStatsResult[] results = AppointResultManage.getChlSchStatsResult(chlSchStatsDTOs);
			resultbean.setDatas(new ResultDatasBean<ChlSchStatsResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getChlSchStats出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 获取门诊停诊列表
	 */
	@Override
	public String getOpStopSchList(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getOpStopSchList入参为:params:" + params);
		AppointResultBean<OpStopSchListResult> resultbean = new AppointResultBean<OpStopSchListResult>();
		try {
			final OpStopSchListParam bean = WsXmlUtils.deSerializeBaseDO(params, OpStopSchListParam.class);
			GetOpStopSchListBP bp = new GetOpStopSchListBP();
			SchInfoDTO[] schInfoDTOs = bp.exec(bean.getBeginDate(),bean.getEndDate());
			OpStopSchListResult[] results = AppointResultManage.getOpStopSchListResult(schInfoDTOs);
			resultbean.setDatas(new ResultDatasBean<OpStopSchListResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getOpStopSchList出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 获取患者预约明细
	 */
	@Override
	public String getOpAptList(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getOpAptList入参为:params:" + params);
		AppointResultBean<OpAptListResult> resultbean = new AppointResultBean<OpAptListResult>();
		try {
			final OpAptListParam bean = WsXmlUtils.deSerializeBaseDO(params, OpAptListParam.class);
			GetOpAptListBP bp = new GetOpAptListBP();
			OpAptDTO[] opAptDTOs = bp.exec(bean.getBeginDate(), bean.getEndDate(), bean.getSrvType(),
					bean.getChlType(), bean.getStatus(), bean.getDeptName(), bean.getPatName(), bean.getPatCode());
			OpAptListResult[] results = AppointResultManage.getOpAptListResult(opAptDTOs);
			resultbean.setDatas(new ResultDatasBean<OpAptListResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getOpAptList出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 获取门诊患者爽约记录
	 */
	@Override
	public String getBrokenAptList(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getBrokenAptList入参为:params:" + params);
		AppointResultBean<BrokenAptListResult> resultbean = new AppointResultBean<BrokenAptListResult>();
		try {
			final BrokenAptListParam bean = WsXmlUtils.deSerializeBaseDO(params, BrokenAptListParam.class);
			GetBrokenAptListBP bp = new GetBrokenAptListBP();
			BrokenAptDTO[] brokenAptDTOs = bp.exec(bean.getPatCode());
			BrokenAptListResult[] results = AppointResultManage.getBrokenAptListResult(brokenAptDTOs);
			resultbean.setDatas(new ResultDatasBean<BrokenAptListResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getBrokenAptList出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 获取患者候诊列表
	 */
	@Override
	public String getWaitQue(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getWaitQue入参为:params:" + params);
		AppointResultBean<WaitQueResult> resultbean = new AppointResultBean<WaitQueResult>();
		try {
			final WaitQueParam bean = WsXmlUtils.deSerializeBaseDO(params, WaitQueParam.class);
			GetWaitQueBP bp = new GetWaitQueBP();
			
			OpWaitQueDTO[] opWaitQueDTOs = bp.exec(bean.getPatCode(), bean.getDeptCode(), bean.getOpTimes(),FBoolean.valueOf(bean.getIsGetAllData()).booleanValue());
			WaitQueResult[] results = AppointResultManage.getWaitQueResult(opWaitQueDTOs);
			resultbean.setDatas(new ResultDatasBean<WaitQueResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getWaitQue出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 获取患者预约记录
	 */
	@Override
	public String getPatOpAptList(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getPatOpAptList入参为:params:" + params);
		AppointResultBean<PatOpAptListResult> resultbean = new AppointResultBean<PatOpAptListResult>();
		try {
			final PatOpAptListParam bean = WsXmlUtils.deSerializeBaseDO(params, PatOpAptListParam.class);
			GetPatOpAptListBP bp = new GetPatOpAptListBP();
			OpPatAptDTO[] opPatAptDTOs = bp.exec(bean.getPatCode(), bean.getBeginDate(), bean.getEndDate());
			PatOpAptListResult[] results = AppointResultManage.getPatOpAptListResult(opPatAptDTOs);
			resultbean.setDatas(new ResultDatasBean<PatOpAptListResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getPatOpAptList出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 获取患者挂号记录列表
	 */
	@Override
	public String getPatOpEntList(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getPatOpEntList入参为:params:" + params);
		AppointResultBean<PatOpEntListResult> resultbean = new AppointResultBean<PatOpEntListResult>();
		try {
			final PatOpEntListParam bean = WsXmlUtils.deSerializeBaseDO(params, PatOpEntListParam.class);
			GetPatOpEntListBP bp = new GetPatOpEntListBP();
			OpEntListDTO[] opEntListDTOs = bp.exec(bean.getPatCode(), bean.getBeginDate(), bean.getEndDate());
			PatOpEntListResult[] results = AppointResultManage.getPatOpEntListResult(opEntListDTOs);
			resultbean.setDatas(new ResultDatasBean<PatOpEntListResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getPatOpEntList出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 获取患者挂号和记录(预约未取消，挂号包含取消)
	 */
	@Override
	public String getPatOpAptAndEntList(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getPatOpAptAndEntList入参为:params:" + params);
		AppointResultBean<PatOpAptAndEntListResult> resultbean = new AppointResultBean<PatOpAptAndEntListResult>();
		try {
			final PatOpAptAndEntListParam bean = WsXmlUtils.deSerializeBaseDO(params, PatOpAptAndEntListParam.class);
			GetOpAptAndEntListBP bp = new GetOpAptAndEntListBP();
			OpPatAptDTO[] opPatAptDTOs = bp.exec(bean.getPatCode(), bean.getBeginDate(), bean.getEndDate(), bean.getAgentPatCode());
			PatOpAptAndEntListResult[] results = AppointResultManage.getPatOpAptAndEntListResult(opPatAptDTOs);
			resultbean.setDatas(new ResultDatasBean<PatOpAptAndEntListResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getPatOpAptAndEntList出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 获取代办人预约记录
	 */
	@Override
	public String getOpAptListByAgentPatCode(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getOpAptListByAgentPatCode入参为:params:" + params);
		AppointResultBean<OpAptListByAgentPatCodeResult> resultbean = new AppointResultBean<OpAptListByAgentPatCodeResult>();
		try {
			final OpAptListByAgentPatCodeParam bean = WsXmlUtils.deSerializeBaseDO(params, OpAptListByAgentPatCodeParam.class);
			GetOpAptListByAgentPatCodeBP bp = new GetOpAptListByAgentPatCodeBP();
			OpPatAptDTO[] opPatAptDTOs = bp.exec(bean.getAgentPatCode(), bean.getBeginDate(), bean.getEndDate());
			OpAptListByAgentPatCodeResult[] results = AppointResultManage.getOpAptListByAgentPatCodeResult(opPatAptDTOs);
			resultbean.setDatas(new ResultDatasBean<OpAptListByAgentPatCodeResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getOpAptListByAgentPatCode出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 获取预约详细信息
	 */
	@Override
	public String getPaidAptDetail(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getPaidAptDetail入参为:params:" + params);
		AppointResultBean<PaidAptDetailResult> resultbean = new AppointResultBean<PaidAptDetailResult>();
		try {
			final PaidAptDetailParam bean = WsXmlUtils.deSerializeBaseDO(params, PaidAptDetailParam.class);
			GetPatPaidOpAptBP bp = new GetPatPaidOpAptBP();
			OpPatAptDTO opPatAptDTO = bp.exec(bean.getId_apt());
			PaidAptDetailResult result = AppointResultManage.getPaidAptDetailResult(opPatAptDTO);
			resultbean.setDatas(new ResultDatasBean<PaidAptDetailResult>(new PaidAptDetailResult[]{result}));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getPaidAptDetail出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 通过预约code获取预约Id
	 */
	@Override
	public String getAptIdByAptCode(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getAptIdByAptCode入参为:params:" + params);
		AppointResultBean<AptIdByAptCodeResult> resultbean = new AppointResultBean<AptIdByAptCodeResult>();
		try {
			final AptIdByAptCodeParam bean = WsXmlUtils.deSerializeBaseDO(params, AptIdByAptCodeParam.class);
			GetAptInfoBP bp = new GetAptInfoBP();
			String str = bp.getAptIdByAptCode(bean.getAptCodeEx());
			AptIdByAptCodeResult result = AppointResultManage.getAptIdByAptCodeResult(str);
			if(EnValidator.isEmpty(str)){
				resultbean.setResultCode("-1");
				resultbean.setResultMessage("不存在该预约！");
			}
			resultbean.setDatas(new ResultDatasBean<AptIdByAptCodeResult>(new AptIdByAptCodeResult[]{result}));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getAptIdByAptCode出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 获取本次就诊患者分类
	 */
	@Override
	public String getEnPatCaInfo(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getEnPatCaInfo入参为:params:" + params);
		AppointResultBean<EnPatCaInfoResult> resultbean = new AppointResultBean<EnPatCaInfoResult>();
		try {
			final EnPatCaInfoParam bean = WsXmlUtils.deSerializeBaseDO(params, EnPatCaInfoParam.class);
			GetEnPatCaInfoBP bp = new GetEnPatCaInfoBP();
			EnPatCaInfoDTO enPatCaInfoDTO = bp.exec(bean.getPatCode(), bean.getOpTimes());
			EnPatCaInfoResult result = AppointResultManage.getEnPatCaInfoResult(enPatCaInfoDTO);
			resultbean.setDatas(new ResultDatasBean<EnPatCaInfoResult>(new EnPatCaInfoResult[]{result}));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getEnPatCaInfo出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 获取排班对应的号位
	 */
	@Override
	public String getSchTickInfo(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getSchTickInfo入参为:params:" + params);
		AppointResultBean<SchTickInfoResult> resultbean = new AppointResultBean<SchTickInfoResult>();
		try {
			final SchTickInfoParam bean = WsXmlUtils.deSerializeBaseDO(params, SchTickInfoParam.class);
			GetSchTickInfoBP bp = new GetSchTickInfoBP();
			SchTickInfoDTO[] schTickInfoDTOs = bp.exec(bean.getSchIds(), bean.getChlType(), bean.getTicksIds(),bean.getCtrl1(),
					bean.getCtrl2(), bean.getCtrl3(), bean.getCtrl4(), bean.getCtrl5());
			SchTickInfoResult[] results = AppointResultManage.getSchTickInfoResult(schTickInfoDTOs);
			resultbean.setDatas(new ResultDatasBean<SchTickInfoResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getSchTickInfo出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 获取患者就诊记录
	 */
	@Override
	public String getEntListByPatcode(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getEntListByPatcode入参为:params:" + params);
		AppointResultBean<EntListByPatcodeResult> resultbean = new AppointResultBean<EntListByPatcodeResult>();
		try {
			final EntListByPatcodeParam bean = WsXmlUtils.deSerializeBaseDO(params, EntListByPatcodeParam.class);
			GetEntListByPatcodeBP bp = new GetEntListByPatcodeBP();
			PatEntInfoDTO[] patEntInfoDTOs = bp.exec(bean.getPatCode(), bean.getDtBegin(), bean.getDtEnd(), bean.getEntpCode());
			EntListByPatcodeResult[] results = AppointResultManage.getEntListByPatcodeResult(patEntInfoDTOs);
			resultbean.setDatas(new ResultDatasBean<EntListByPatcodeResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getEntListByPatcode出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 统计门急诊就诊人次
	 */
	@Override
	public String getVisitTimesStat(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getEntListByPatcode入参为:params:" + params);
		AppointResultBean<VisitTimesStatResult> resultbean = new AppointResultBean<VisitTimesStatResult>();
		try {
			final VisitTimesStatParam bean = WsXmlUtils.deSerializeBaseDO(params, VisitTimesStatParam.class);
			GetVisitTimesStatBP bp = new GetVisitTimesStatBP();
			OpVisitTimesStatDTO[] opVisitTimesStatDTOs = bp.exec(bean.getDate());
			VisitTimesStatResult[] results = AppointResultManage.getVisitTimesStatResult(opVisitTimesStatDTOs);
			resultbean.setDatas(new ResultDatasBean<VisitTimesStatResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getEntListByPatcode出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 门急诊出诊科室列表
	 */
	@Override
	public String getOEPDepList() throws BizException {
		AppointResultBean<OEPDepListResult> resultbean = new AppointResultBean<OEPDepListResult>();
		try {
			GetOEPDepListBP bp = new GetOEPDepListBP();
			DeptWithSchDTO[] deptWithSchDTOs = bp.exec();
			OEPDepListResult[] results = AppointResultManage.getOEPDepListResult(deptWithSchDTOs);
			resultbean.setDatas(new ResultDatasBean<OEPDepListResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getOEPDepList出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 门急诊医生出诊科室列表
	 */
	@Override
	public String getOEPEmpDepMatch() throws BizException {
		AppointResultBean<OEPEmpDepMatchResult> resultbean = new AppointResultBean<OEPEmpDepMatchResult>();
		try {
			GetOpEmpDepMatchBP bp = new GetOpEmpDepMatchBP();
			OpEmpDepDTO[] opEmpDepDTOs = bp.exec();
			OEPEmpDepMatchResult[] results = AppointResultManage.getOEPEmpDepMatchResult(opEmpDepDTOs);
			resultbean.setDatas(new ResultDatasBean<OEPEmpDepMatchResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getOEPEmpDepMatch出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 签到分诊
	 */
	@Override
	public String makeEntArrive(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：makeEntArrive入参为:params:" + params);
		AppointResultBean<EntArriveResult> resultbean = new AppointResultBean<EntArriveResult>();
		try {
			final EntArriveParam bean = WsXmlUtils.deSerializeBaseDO(params, EntArriveParam.class);
			MakeEntArriveBP bp = new MakeEntArriveBP();
			ArriveResultBean arriveResult = bp.exec(bean.getPatCode(), 
					bean.getOpTimes(), bean.getQueBenCode(), bean.getOprCode());
			EntArriveResult result = AppointResultManage.getEntArriveResult(arriveResult);
			resultbean.setDatas(new ResultDatasBean<EntArriveResult>(new EntArriveResult[]{result}));
			result.setCode(null);
			if(!EnValidator.isEmpty(result.getErrMsg())){
				resultbean.setResultCode("-1");
				resultbean.setResultMessage(result.getErrMsg());
				result.setErrMsg(null);
			}
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：makeEntArrive出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 取分诊台可分诊挂号记录
	 */
	@Override
	public String getEntLisByQuebencode(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getEntLisByQuebencode入参为:params:" + params);
		AppointResultBean<EntLisByQuebencodeResult> resultbean = new AppointResultBean<EntLisByQuebencodeResult>();
		try {
			final EntLisByQuebencodeParam bean = WsXmlUtils.deSerializeBaseDO(params, EntLisByQuebencodeParam.class);
			GetEntLisByQuebencodeBP bp = new GetEntLisByQuebencodeBP();
			EntRegInfoDTO[] entRegInfoDTOs = bp.exec(bean.getPatCode(), bean.getQueBenCode(), bean.getOprCode());
			EntLisByQuebencodeResult[] results = AppointResultManage.getEntLisByQuebencodeResult(entRegInfoDTOs);
			resultbean.setDatas(new ResultDatasBean<EntLisByQuebencodeResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getEntLisByQuebencode出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 预约
	 */
	@Override
	public String makeApt(String params) throws BizException {
		WsEnMakeAptXmlBP bp = new WsEnMakeAptXmlBP();
		return bp.exec(params);
	}
	/**
	 * 挂号划价
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@Override
	public String regPricing(String params) throws BizException {
		WsEnRegPricingXmlBP bp = new WsEnRegPricingXmlBP();
		return bp.exec(params);
	}
	/**
	 * 付费
	 */
	@Override
	public String payForApt(String params) throws BizException {
		WsEnPayForAptXmlBP bp = new WsEnPayForAptXmlBP();
		return bp.exec(params);
	}
	/**
	 * 预约并付费
	 * @param params
	 * @return
	 * @throws BizException
	 */
	@Override
	public String makeAptAndPay(String params) throws BizException{
		EnLogUtil.getInstance().logInfo("方法：makeAptAndPay入参为:params:" + params);
		AppointResultBean<AptNewResult> resultbean = new AppointResultBean<AptNewResult>();
		try {
			final MakeAptAndPayParam bean = WsXmlUtils.deSerializeBaseDO(params, MakeAptAndPayParam.class);
			MakeAptAndPayBP bp = new MakeAptAndPayBP();
			RegResultDTO regResultDTO = bp.exec(bean);
			AptNewResult result = AppointResultManage.getAptNewResult(regResultDTO);
			resultbean.setDatas(new ResultDatasBean<AptNewResult>(new AptNewResult[]{result}));
			if(result != null && !EnValidator.isEmpty(result.getRegMsg())){
				resultbean.setResultCode("-1");
				resultbean.setResultMessage(result.getRegMsg());
				resultbean.setDatas(null);
				result.setRegMsg(null);
			}
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：makeAptAndPay出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 取消预约并退费
	 */
	@Override
	public String cancAptAndRefund(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：cancAptAndRefund入参为:params:" + params);
		AppointResultBean<MessageResult> resultbean = new AppointResultBean<MessageResult>();
		try {
			final CancAptAndRefundParam bean = WsXmlUtils.deSerializeBaseDO(params, CancAptAndRefundParam.class);
			Refund4AppNewBP bp = new Refund4AppNewBP();
			ResultBean resultBean = bp.exec(bean.getId_apt(), bean.getMoney(),bean.getOpTimes(),
					bean.getSettleTimes(), bean.getFlag(), bean.getOprCode());
			MessageResult result = AppointResultManage.getMessageResult(resultBean);
			resultbean.setDatas(new ResultDatasBean<MessageResult>(new MessageResult[]{result}));
			result.setCode(null);
			if(!EnValidator.isEmpty(result.getMsg())){
				resultbean.setResultCode("-1");
				resultbean.setResultMessage(result.getMsg());
				result.setMsg(null);
			}
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：cancAptAndRefund出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 取消预约
	 */
	@Override
	public String cancApt(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：cancApt入参为:params:" + params);
		AppointResultBean<MessageResult> resultbean = new AppointResultBean<MessageResult>();
		try {
			final CancAptParam bean = WsXmlUtils.deSerializeBaseDO(params, CancAptParam.class);
			CancApt4AppNewBP bp = new CancApt4AppNewBP();
			String str = bp.exec(bean.getId_apt(), bean.getOprCode());
			MessageResult result = AppointResultManage.getStrToMessageResult(str);
			resultbean.setDatas(new ResultDatasBean<MessageResult>(new MessageResult[]{result}));
			result.setCode(null);
			if(!EnValidator.isEmpty(result.getMsg())){
				resultbean.setResultCode("-1");
				resultbean.setResultMessage(result.getMsg());
				result.setMsg(null);
			}
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：cancApt出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 已收费预约取号
	 */
	@Override
	public String cfmPaidApt(String params) throws BizException {
		WsEnCfmPaidAptXmlBP bp = new WsEnCfmPaidAptXmlBP();
		return bp.exec(params);
	}
	/**
	 * 获取就诊记录
	 */
	@Override
	public String getEntListByDeptCode(String params) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getEntListByDeptCode入参为:params:" + params);
		AppointResultBean<EntListByDeptCodeResult> resultbean = new AppointResultBean<EntListByDeptCodeResult>();
		try {
			final EntListByDeptCodeParam bean = WsXmlUtils.deSerializeBaseDO(params, EntListByDeptCodeParam.class);
			GetEntListByDeptCodeBP bp = new GetEntListByDeptCodeBP();
			EntInfoDTO[] entInfoDTOs = bp.exec(bean.getDtBegin(), bean.getDtEnd(), bean.getDeptCode(),
					bean.getEntCode(), bean.getEntpCode());
			EntListByDeptCodeResult[] results = AppointResultManage.getEntListByDeptCodeResult(entInfoDTOs);
			resultbean.setDatas(new ResultDatasBean<EntListByDeptCodeResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getEntListByDeptCode出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
	/**
	 * 根据站点信息获取医生候诊队列
	 * 
	 * @param requestXML
	 * @return
	 * @throws BizException
	 */
	@Override
	public String getWaitQueBySite(String requestXML) throws BizException {
		EnLogUtil.getInstance().logInfo("方法：getWaitQueBySite入参为:params:" + requestXML);
		AppointResultBean<WaitQueResult> resultbean = new AppointResultBean<WaitQueResult>();
		try {
			final WaitQueParam bean = WsXmlUtils.deSerializeBaseDO(requestXML, WaitQueParam.class);
			GetWaitQueBySiteBP bp = new GetWaitQueBySiteBP();
			OpWaitQueDTO[] opWaitQueDTOs = bp.exec(bean.getSiteCode(), bean.getOprCode());
			WaitQueResult[] results = AppointResultManage.getWaitQueResult(opWaitQueDTOs);
			resultbean.setDatas(new ResultDatasBean<WaitQueResult>(results));
		} catch (Exception e) {
			resultbean.setException(e);
		}
		EnLogUtil.getInstance().logInfo("方法：getWaitQue出参为:result:" + WsXmlUtils.serialize(resultbean));
		return WsXmlUtils.serialize(resultbean);
	}
}
