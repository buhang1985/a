package iih.ei.std.consis.v1.task.bp;

import com.founder.i.IHisService;

import iih.bd.utils.CommDAFacade;
import iih.bd.utils.WsXmlUtils;
import iih.ei.std.consis.v1.s.bp.BaseCallWsBp;
import iih.ei.std.consis.v1.task.bp.qry.FindDeptDicQry;
import iih.ei.std.consis.v1.task.d.HosDepartBaseInfoBean;
import iih.ei.std.consis.v1.task.d.HosDepartBaseInfoBeanList;
import iih.mp.dg.ws.log.utils.WebServiceLog;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.bdfw.bbd.i.IPsndocRService;

/**
 * 推送科室字典业务逻辑
 * 
 * @author hao_wu 2018-12-14
 *
 */
public class PushDeptDicBp extends BaseCallWsBp {

	/**
	 * 执行逻辑
	 * 
	 * @return
	 * @throws BizException
	 */
	public String exec() throws BizException {
		HosDepartBaseInfoBeanList paramBeanList = getParamBeanList();
		String paramString = WsXmlUtils.serialize(paramBeanList, true);
		String result = callWebService(paramString);
		return result;
	}

	/**
	 * 获取主信息
	 * 
	 * @param paramBean
	 * @return
	 * @throws BizException
	 */
	protected HosDepartBaseInfoBeanList getParamBeanList() throws BizException {
		HosDepartBaseInfoBeanList prescBeanList = new HosDepartBaseInfoBeanList();
		prescBeanList.setOpsystem("HIS");
		prescBeanList.setOptype("104");
		prescBeanList.setOpwinid("");
		prescBeanList.setOpip("");
		// 终端操作员编码 姓名
		PsnDocDO checkInMachine = getOpreratInfo();
		if (checkInMachine != null) {
			prescBeanList.setOpmanno(checkInMachine.getCode());
			prescBeanList.setOpmanname(checkInMachine.getName());
		} else {
			prescBeanList.setOpmanno("");
			prescBeanList.setOpmanname("");
		}
		HosDepartBaseInfoBean[] hosDepartBaseInfo = getParamBeans();
		prescBeanList.set_hosDepartBaseInfo(hosDepartBaseInfo);
		return prescBeanList;
	}

	/**
	 * 获取操作员(签到机)编码和姓名
	 * 
	 * @throws BizException
	 */
	protected PsnDocDO getOpreratInfo() throws BizException {
		String userId = Context.get().getStuffId();
		IPsndocRService psndocRService = ServiceFinder.find(IPsndocRService.class);
		PsndocAggDO psndocAggDO = psndocRService.findById(userId);
		PsnDocDO checkInMachine = (PsnDocDO) psndocAggDO.getParent();
		return checkInMachine;
	}

	/**
	 * @param paramBean
	 * @return
	 * @throws BizException
	 */
	protected HosDepartBaseInfoBean[] getParamBeans() throws BizException {
		FindDeptDicQry qry = new FindDeptDicQry();
		HosDepartBaseInfoBean[] execQuery = CommDAFacade.execQuery(qry, HosDepartBaseInfoBean.class);
		return execQuery;
	}

	@Override
	protected String callWebService(String paramStr) throws BizException {

		WebServiceLog log = new WebServiceLog(IHisService.class.getName());
		String result = null;
		try {
			log.begin(paramStr);
			IHisService hisService = ServiceFinder.find(IHisService.class);
			result = hisService.hisTransData(paramStr);
			log.end(result);
		} catch (Exception e) {
			log.end(e);
		}

		return result;
	}

}
