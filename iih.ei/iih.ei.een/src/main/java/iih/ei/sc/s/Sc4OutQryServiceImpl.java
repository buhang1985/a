package iih.ei.sc.s;

import java.net.InetAddress;

import iih.bd.utils.WsXmlUtils;
import iih.ei.een.log.EnEiLogUtil;
import iih.ei.een.ws.result.EEnResult;
import iih.ei.sc.i.ISc4OutQryService;
import iih.ei.sc.s.bp.qry.GetAptNoteRptBP;
import iih.ei.sc.s.bp.qry.GetAptPhotoUrlBP;
import iih.ei.sc.s.bp.qry.GetBrokenAptListBP;
import iih.ei.sc.s.bp.qry.GetMtScCaListBP;
import iih.ei.sc.s.bp.qry.GetMtScDbSrvListBP;
import iih.ei.sc.s.bp.qry.GetPatAptByIdAptBP;
import iih.ei.sc.s.bp.qry.GetPatAptListBP;
import iih.ei.sc.s.bp.qry.GetSchListBP;
import iih.ei.sc.s.bp.qry.GetStopSchListBP;
import iih.ei.sc.s.param.GetScQryListParam;
import iih.ei.sc.ws.bean.GetAptNoteRptBean;
import iih.ei.sc.ws.bean.GetAptPhotoUrlBean;
import iih.ei.sc.ws.bean.GetBrokenAptListBean;
import iih.ei.sc.ws.bean.GetMtScCaListBean;
import iih.ei.sc.ws.bean.GetMtScDbSrvListBean;
import iih.ei.sc.ws.bean.GetPatAptListBean;
import iih.ei.sc.ws.bean.GetSchListBean;
import iih.ei.sc.ws.bean.GetStopSchListBean;
import xap.mw.core.data.Context;

/**
 * SC对外查询服务
 * @author yzh
 * @date 2018年10月25日 15:25:50
 */
public class Sc4OutQryServiceImpl implements ISc4OutQryService{

	private static String repUrl = "http://%s/reportweb/rptexport?_action_type=export&as=pdf&file=iih_report/SC/%s.xml%s";
	@Override
	public String getMtScCa(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getMtScCa，入参：" + requestXML);
		EEnResult<GetMtScCaListBean> result = new EEnResult<GetMtScCaListBean>();
		try{
			final GetScQryListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetScQryListParam.class);
			GetMtScCaListBean[] beans = new GetMtScCaListBP().exec();
			result.setData(beans);
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4OutQryService_getMtScCa，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getMtScCa，出参：" + responsXML);
		return responsXML;
	}

	@Override
	public String getMtScDbSrv(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getMtScDbSrv，入参：" + requestXML);
		EEnResult<GetMtScDbSrvListBean> result = new EEnResult<GetMtScDbSrvListBean>();
		try{
			final GetScQryListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetScQryListParam.class);
			GetMtScDbSrvListBean[] beans = new GetMtScDbSrvListBP().exec(param.getIdScca());
			result.setData(beans);
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4OutQryService_getMtScDbSrv，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getMtScDbSrv，出参：" + responsXML);
		return responsXML;
	}

	/**
	 * 取患者医技预约记录
	 * @param requestXML
	 * @return
	 * @auther yaohl
	 */
	@Override
	public String getPatAptList(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getPatAptList，入参：" + requestXML);
		EEnResult<GetPatAptListBean> result = new EEnResult<GetPatAptListBean>();
		try{
			final GetScQryListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetScQryListParam.class);
			GetPatAptListBean[] beans = new GetPatAptListBP().exec(param.getPatCode(),param.getBeginDate(),param.getEndDate(),param.getChlType());
			result.setData(beans);
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4OutQryService_getPatAptList，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getPatAptList，出参：" + responsXML);
		return responsXML;
	}


	/**
	 * 获取医技排班列表
	 * @param requestXML
	 * @return
	 */
	@Override
	public String getSchList(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getSchList，入参：" + requestXML);
		EEnResult<GetSchListBean> result = new EEnResult<GetSchListBean>();
		try{
			final GetScQryListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetScQryListParam.class);
			GetSchListBean[] beans = new GetSchListBP().exec(param.getDateB(),param.getDateE(),param.getIdSrv(),param.getChlType(),param.getOprCode());
			result.setData(beans);
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4OutQryService_getSchList，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getSchList，出参：" + responsXML);
		return responsXML;
	}

	/**
	 * 获取患者爽约记录
	 * @param requestXML
	 * @return
	 */
	@Override
	public String getBrokenAptList(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getBrokenAptList，入参：" + requestXML);
		EEnResult<GetBrokenAptListBean> result = new EEnResult<GetBrokenAptListBean>();
		try{
			final GetScQryListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetScQryListParam.class);
			GetBrokenAptListBean[] beans = new GetBrokenAptListBP().exec(param.getPatCode(),param.getEus_bbrtp());
			result.setData(beans);
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4OutQryService_getBrokenAptList，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getBrokenAptList，出参：" + responsXML);
		return responsXML;
	}
	/**
	 * 根据预约ID获取患者医技预约记录
	 * @param requestXML
	 * @return
	 * @auther yaohl
	 * @date 2018年10月30日
	 */
	@Override
	public String getPatAptByIdApt(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getPatAptList，入参：" + requestXML);
		EEnResult<GetPatAptListBean> result = new EEnResult<GetPatAptListBean>();
		try{
			final GetScQryListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetScQryListParam.class);
			GetPatAptListBean[] beans = new GetPatAptByIdAptBP().exec(param.getIdApt());
			result.setData(beans);
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4OutQryService_getPatAptList，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getPatAptList，出参：" + responsXML);
		return responsXML;
	}

	/**
	 * 获取医技停诊列表
	 */
	@Override
	public String getStopSchList(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getStopSchList，入参：" + requestXML);
		EEnResult<GetStopSchListBean> result = new EEnResult<GetStopSchListBean>();
		try{
			final GetScQryListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetScQryListParam.class);
			GetStopSchListBean[] beans = new GetStopSchListBP().exec(param.getBeginDate(),param.getEndDate());
			result.setData(beans);
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4OutQryService_getStopSchList，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getStopSchList，出参：" + responsXML);
		return responsXML;
	}

	@Override
	public String getAptNoteRpt(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getAptNoteRpt，入参：" + requestXML);
		EEnResult<GetAptNoteRptBean> result = new EEnResult<GetAptNoteRptBean>();
		try{
			//Context.get().
			String address = InetAddress.getLocalHost().getHostAddress().toString();
			final GetScQryListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetScQryListParam.class);
			GetAptNoteRptBean[] beans = new GetAptNoteRptBP().exec(param.getIdApt());
			result.setData(beans);
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4OutQryService_getAptNoteRpt，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getAptNoteRpt，出参：" + responsXML);
		return responsXML;
	}

	@Override
	public String getAptPhotoUrl(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getAptPhotoUrl，入参：" + requestXML);
		EEnResult<GetAptPhotoUrlBean> result = new EEnResult<GetAptPhotoUrlBean>();
		try{
			final GetScQryListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetScQryListParam.class);
			GetAptPhotoUrlBean[] beans = new GetAptPhotoUrlBP().exec(param.getApplyNo(),param.getCodeOr());
			result.setData(beans);
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("ISc4OutQryService_getAptPhotoUrl，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("ISc4OutQryService_getAptPhotoUrl，出参：" + responsXML);
		return responsXML;
	}

}
