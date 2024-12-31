package iih.ei.een.s;

import iih.bd.utils.WsXmlUtils;
import iih.ei.een.i.IEn4TriageQryService;
import iih.ei.een.log.EnEiLogUtil;
import iih.ei.een.s.bp.qry.GetDepListBP;
import iih.ei.een.s.bp.qry.GetEmpListBP;
import iih.ei.een.s.bp.qry.GetOpQueListBP;
import iih.ei.een.s.bp.qry.GetPatInfoBP;
import iih.ei.een.ws.bean.GetDepListBean;
import iih.ei.een.ws.bean.GetEmpListBean;
import iih.ei.een.ws.bean.GetOpQueListBean;
import iih.ei.een.ws.bean.GetPatInfoBean;
import iih.ei.een.ws.param.GetDepListParam;
import iih.ei.een.ws.param.GetEmpListParam;
import iih.ei.een.ws.param.GetOpQueListParam;
import iih.ei.een.ws.param.GetPatInfoParam;
import iih.ei.een.ws.result.EEnResult;

/**
 * EN对外分诊查询服务
 * 
 * @author liubin
 *
 */
public class En4TriageQryServiceImpl implements IEn4TriageQryService {

	/**
	 * 取科室列表
	 * 
	 * @author liubin
	 * 
	 * @param requestXML
	 * @return
	 */
	@Override
	public String getDepList(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("IEn4TriageQryService_getDepList，入参：" + requestXML);
		EEnResult<GetDepListBean> result = new EEnResult<GetDepListBean>();
		try{
			final GetDepListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetDepListParam.class);
			GetDepListBean[] beans = new GetDepListBP().exec(param.getFg_only_leaf());
			result.setData(beans);	
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("IEn4TriageQryService_getDepList，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("IEn4TriageQryService_getDepList，出参：" + responsXML);
		return responsXML;
	}
	/**
	 * 获取员工用户列表
	 * 
	 * @author liubin
	 * 
	 * @param requestXML
	 * @return
	 */
	@Override
	public String getEmpList(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("IEn4TriageQryService_getEmpList，入参：" + requestXML);
		EEnResult<GetEmpListBean> result = new EEnResult<GetEmpListBean>();
		try{
			final GetEmpListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetEmpListParam.class);
			GetEmpListBean[] beans = new GetEmpListBP().exec(param.getCode_dept());
			result.setData(beans);
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("IEn4TriageQryService_getEmpList，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("IEn4TriageQryService_getEmpList，出参：" + responsXML);
		return responsXML;
	}
	/**
	 * 取门诊有效的医生排班队列
	 * 
	 * @author liubin
	 * 
	 * @param requestXML
	 * @return
	 */
	@Override
	public String getOpQueList(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("IEn4TriageQryService_getOpQueList，入参：" + requestXML);
		EEnResult<GetOpQueListBean> result = new EEnResult<GetOpQueListBean>();
		try{
			final GetOpQueListParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetOpQueListParam.class);
			GetOpQueListBean[] beans = new GetOpQueListBP().exec(param.getCode_dept());
			result.setData(beans);
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("IEn4TriageQryService_getOpQueList，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("IEn4TriageQryService_getOpQueList，出参：" + responsXML);
		return responsXML;
	}
	/**
	 * 根据患者刷卡取患者信息
	 * 
	 * @author liubin
	 * 
	 * @param requestXML
	 * @return
	 */
	@Override
	public String getPatInfo(String requestXML) {
		EnEiLogUtil.getInstance().logInfo("IEn4TriageQryService_getPatInfo，入参：" + requestXML);
		EEnResult<GetPatInfoBean> result = new EEnResult<GetPatInfoBean>();
		try{
			final GetPatInfoParam param = WsXmlUtils.deSerializeBaseDO(requestXML, GetPatInfoParam.class);
			GetPatInfoBean[] beans = new GetPatInfoBP().exec(param.getCard_type(), param.getCard_no());
			result.setData(beans);
		}catch(Exception e){
			EnEiLogUtil.getInstance().logError("IEn4TriageQryService_getPatInfo，出错", e);
			result.setException(e);
		}
		String responsXML = WsXmlUtils.serialize(result);
		EnEiLogUtil.getInstance().logInfo("IEn4TriageQryService_getPatInfo，出参：" + responsXML);
		return responsXML;
	}

}
