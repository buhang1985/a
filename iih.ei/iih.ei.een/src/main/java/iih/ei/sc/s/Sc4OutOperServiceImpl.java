package iih.ei.sc.s;

import iih.bd.utils.WsXmlUtils;
import iih.bd.webservice.BaseWsResult;
import iih.bd.webservice.WsResultMsgCode;
import iih.ei.een.log.EnEiLogUtil;
import iih.ei.een.ws.result.EEnResult;
import iih.ei.sc.i.ISc4OutOperService;
import iih.ei.sc.s.bp.oper.CancAptBP;
import iih.ei.sc.s.bp.oper.ChangeAptBP;
import iih.ei.sc.s.bp.oper.MakeAptByApplyBP;
import iih.ei.sc.s.bp.oper.MakeAptNonOrdBP;
import iih.ei.sc.s.param.ChangeAptParam;
import iih.ei.sc.s.param.GetCancScAptParam;
import iih.ei.sc.s.param.GetScAptNonOrdParam;
import iih.ei.sc.s.param.MakeAptByApplyParam;
import iih.ei.sc.ws.bean.CommonReturnBean;
import iih.ei.sc.ws.bean.ReturnScAptNonOrdBean;
/**
 * SC对外查询服务
 * @author yzh
 * @date 2018年10月25日 15:25:50
 */
public class Sc4OutOperServiceImpl implements ISc4OutOperService{

	/**
	 * 医技预约(无申请单)
	 */
	@Override
	public String makeAptNonOrd(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4OutOperService_makeAptNonOrd，入参：" + requestXML);
		EEnResult<ReturnScAptNonOrdBean> result = new EEnResult<ReturnScAptNonOrdBean>();
		try{
			final GetScAptNonOrdParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetScAptNonOrdParam.class);
			ReturnScAptNonOrdBean  bean = new MakeAptNonOrdBP().exec(param.getPatCode(),param.getIdSrv(),param.getChlType(),param.getIdSch(),param.getOrgNameAppl(),param.getDepNameAppl(),param.getPhyNameAppl(),param.getFg_bl(),param.getOprCode());
			result.setResultCode(WsResultMsgCode.SUCCESS);
			result.setData(new ReturnScAptNonOrdBean[]{bean});
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4OutOperService_makeAptNonOrd，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4OutOperService_makeAptNonOrd，出参：" + responsXML);
		return responsXML;
	}

	/**
	 * 取消预约
	 */
	@Override
	public String cancApt(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4OutOperService_cancApt，入参：" + requestXML);
		BaseWsResult result = new BaseWsResult();
		try{
			final GetCancScAptParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetCancScAptParam.class);
			new CancAptBP().exec(param.getIdApt(),param.getPatCode(),param.getChlType(),param.getOprCode(),param.getIsValidChl());
			result.setResultCode(WsResultMsgCode.SUCCESS);
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4OutOperService_cancApt，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4OutOperService_cancApt，出参：" + responsXML);
		return responsXML;
	}

	/**
	 * 选号预约
	 */
	@Override
	public String makeAptByApply(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4OutOperService_makeAptByApply，入参：" + requestXML);
		BaseWsResult result = new BaseWsResult();
		try{
			final MakeAptByApplyParam param = WsXmlUtils.deSerializeBaseDO(requestXML, MakeAptByApplyParam.class);
			CommonReturnBean bean = new MakeAptByApplyBP().exec(param.getId_aptapply(),param.getId_tick(),param.getChlType(),param.getOprCode());
			result.setResultCode(WsResultMsgCode.SUCCESS);
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4OutOperService_makeAptByApply，出错", e);
			result.setResultCode(WsResultMsgCode.ERROR);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4OutOperService_makeAptByApply，出参：" + responsXML);
		return responsXML;
	}
	/**
	 * 改约
	 */
	@Override
	public String changeApt(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4OutOperService_changeApt，入参：" + requestXML);
		BaseWsResult result = new BaseWsResult();
		try{
			final ChangeAptParam param = WsXmlUtils.deSerializeBaseDO(requestXML, ChangeAptParam.class);
			CommonReturnBean bean = new ChangeAptBP().exec(param.getId_aptapply(),param.getId_tick_new(),param.getChlType(),param.getOprCode());
			result.setResultCode(WsResultMsgCode.SUCCESS);
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4OutOperService_changeApt，出错", e);
			result.setResultCode(WsResultMsgCode.ERROR);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4OutOperService_changeApt，出参：" + responsXML);
		return responsXML;
	}
}
