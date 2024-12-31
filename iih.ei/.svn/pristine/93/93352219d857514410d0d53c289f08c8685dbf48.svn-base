package iih.ei.sc.s;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.utils.WsXmlUtils;
import iih.ei.een.log.EnEiLogUtil;
import iih.ei.een.ws.result.EEnResult;
import iih.ei.sc.i.ISc4WeChatQryService;
import iih.ei.sc.s.bp.qry.GetAptApplyBP;
import iih.ei.sc.s.bp.qry.GetAptRptNoteBP;
import iih.ei.sc.s.bp.qry.GetPatAptListByStatusBP;
import iih.ei.sc.s.bp.qry.GetScTicks4ApplyBP;
import iih.ei.sc.s.bp.qry.GetUnaptApplyBP;
import iih.ei.sc.s.bp.qry.GetValidPeriodBP;
import iih.ei.sc.s.bp.qry.IsSelfAptableBP;
import iih.ei.sc.s.bp.qry.IsSelfCancableBP;
import iih.ei.sc.s.param.GetSc4WebChartQryListParam;
import iih.ei.sc.ws.bean.GetAptApplyBean;
import iih.ei.sc.ws.bean.GetAptRptNoteBean;
import iih.ei.sc.ws.bean.GetPatAptListBean;
import iih.ei.sc.ws.bean.GetScTicks4ApplyBean;
import iih.ei.sc.ws.bean.GetUnaptApplyBean;
import iih.ei.sc.ws.bean.GetValidPeriodBean;
import iih.ei.sc.ws.bean.IsSelfAptableBean;
import iih.ei.sc.ws.bean.IsSelfCancableBean;

/**
 * SC对微信查询服务
 * @author yzh
 * @date 2019年09月25日 15:25:50
 */
public class Sc4WeChatQryServiceImpl implements ISc4WeChatQryService{

	@Override
	public String getValidPeriod(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4WeChatQryService_getValidPeriod，入参：" + requestXML);
		EEnResult<GetValidPeriodBean> result = new EEnResult<GetValidPeriodBean>();
		try{
			final GetSc4WebChartQryListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetSc4WebChartQryListParam.class);
			GetValidPeriodBean[] beans = new GetValidPeriodBP().exec(param.getId_aptapply(),param.getChlType());
			result.setData(beans);	
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4WeChatQryService_getValidPeriod，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4WeChatQryService_getValidPeriod，出参：" + responsXML);
		return responsXML;
	}

	@Override
	public String getAptRptNote(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4WeChatQryService_getAptRptNote，入参：" + requestXML);
		EEnResult<GetAptRptNoteBean> result = new EEnResult<GetAptRptNoteBean>();
		try{
			final GetSc4WebChartQryListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetSc4WebChartQryListParam.class);
			GetAptRptNoteBean[] beans = new GetAptRptNoteBP().exec(param.getId_srv(),param.getCode_prt_tmpl_dep(),param.getId_prt_tmpl_dep());
			result.setData(beans);	
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4WeChatQryService_getAptRptNote，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4WeChatQryService_getAptRptNote，出参：" + responsXML);
		return responsXML;
	}

	@Override
	public String isSelfAptable(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4WeChatQryService_isSelfAptable，入参：" + requestXML);
		EEnResult<IsSelfAptableBean> result = new EEnResult<IsSelfAptableBean>();
		try{
			final GetSc4WebChartQryListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetSc4WebChartQryListParam.class);
			IsSelfAptableBean[] beans = new IsSelfAptableBP().exec(param.getId_aptapply(),param.getChlType());
			result.setData(beans);	
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4WeChatQryService_isSelfAptable，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4WeChatQryService_isSelfAptable，出参：" + responsXML);
		return responsXML;
	}

	@Override
	public String isSelfCancable(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4WeChatQryService_isSelfCancable，入参：" + requestXML);
		EEnResult<IsSelfCancableBean> result = new EEnResult<IsSelfCancableBean>();
		try{
			final GetSc4WebChartQryListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetSc4WebChartQryListParam.class);
			IsSelfCancableBean[] beans = new IsSelfCancableBP().exec(param.getId_aptapply(),IScDictCodeConst.RULE_SC_MT_CANC_APT,param.getChlType());
			result.setData(beans);	
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4WeChatQryService_isSelfCancable，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4WeChatQryService_isSelfCancable，出参：" + responsXML);
		return responsXML;
	}

	@Override
	public String getUnaptApply(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4WeChatQryService_getUnaptApply，入参：" + requestXML);
		EEnResult<GetUnaptApplyBean> result = new EEnResult<GetUnaptApplyBean>();
		try{
			final GetSc4WebChartQryListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetSc4WebChartQryListParam.class);
			GetUnaptApplyBean[] beans = new GetUnaptApplyBP().exec(param.getCode_pat());
			result.setData(beans);	
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4WeChatQryService_getUnaptApply，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4WeChatQryService_getUnaptApply，出参：" + responsXML);
		return responsXML;
	}

	@Override
	public String getScTicks4Apply(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4WeChatQryService_getScTicks4Apply，入参：" + requestXML);
		EEnResult<GetScTicks4ApplyBean> result = new EEnResult<GetScTicks4ApplyBean>();
		try{
			final GetSc4WebChartQryListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetSc4WebChartQryListParam.class);
			GetScTicks4ApplyBean[] beans = new GetScTicks4ApplyBP().exec(param.getId_aptapply(),param.getD_sc(),param.getChlType());
			result.setData(beans);	
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4WeChatQryService_getScTicks4Apply，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4WeChatQryService_getScTicks4Apply，出参：" + responsXML);
		return responsXML;
	}

	@Override
	public String getAptApply(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4WeChatQryService_getAptApply，入参：" + requestXML);
		EEnResult<GetAptApplyBean> result = new EEnResult<GetAptApplyBean>();
		try{
			final GetSc4WebChartQryListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetSc4WebChartQryListParam.class);
			GetAptApplyBean[] beans = new GetAptApplyBP().exec(param.getCode_pat());
			result.setData(beans);	
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4WeChatQryService_getAptApply，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4WeChatQryService_getAptApply，出参：" + responsXML);
		return responsXML;
	}

	@Override
	public String getPatAptListByStatus(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4WeChatQryService_getPatAptListByStatus，入参：" + requestXML);
		EEnResult<GetPatAptListBean> result = new EEnResult<GetPatAptListBean>();
		try{
			final GetSc4WebChartQryListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetSc4WebChartQryListParam.class);
			GetPatAptListBean[] beans = new GetPatAptListByStatusBP().exec(param.getCode_pat(),param.getBeginDate(),param.getEndDate(),param.getChlType(),param.getAptStatus());
			result.setData(beans);	
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4WeChatQryService_getPatAptListByStatus，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4WeChatQryService_getPatAptListByStatus，出参：" + responsXML);
		return responsXML;
	}
}
