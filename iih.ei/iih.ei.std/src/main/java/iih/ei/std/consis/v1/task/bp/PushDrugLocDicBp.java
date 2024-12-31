package iih.ei.std.consis.v1.task.bp;

import com.founder.i.IHisService;

import iih.bd.utils.CommDAFacade;
import iih.bd.utils.WsXmlUtils;
import iih.ei.std.consis.v1.s.bp.BaseCallWsBp;
import iih.ei.std.consis.v1.task.bp.qry.FindDrugLocDicQry;
import iih.ei.std.consis.v1.task.d.PharmDgLocDateBean;
import iih.ei.std.consis.v1.task.d.PharmDgLocDateBeanList;
import iih.mp.dg.ws.log.utils.WebServiceLog;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.bdfw.bbd.i.IPsndocRService;

/**
 * 推送药品货位字典逻辑
 * 
 * @author hao_wu 2018-12-14
 *
 */
public class PushDrugLocDicBp extends BaseCallWsBp {

	public String exec() throws BizException {
		PharmDgLocDateBeanList paramBeanList = getParamBeanList();
		String paramXml = WsXmlUtils.serialize(paramBeanList, true);
		String result = callWebService(paramXml);
		return result;
	}

	/**
	 * 获取药房药品货位数据JavaBean集合
	 * 
	 * @return
	 * @throws BizException
	 */
	protected PharmDgLocDateBeanList getParamBeanList() throws BizException {
		PharmDgLocDateBeanList prescBeanList = new PharmDgLocDateBeanList();
		prescBeanList.setOpsystem("HIS");
		prescBeanList.setOptype("102");
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
		PharmDgLocDateBean[] paramBeans = getParamBeans();
		prescBeanList.set_pPharmDgLocDateBeans(paramBeans);
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
	 * 获取药房药品货位数据JavaBean
	 * 
	 * @return
	 * @throws BizException
	 */
	protected PharmDgLocDateBean[] getParamBeans() throws BizException {
		FindDrugLocDicQry qry = new FindDrugLocDicQry();
		PharmDgLocDateBean[] result = CommDAFacade.execQuery(qry, PharmDgLocDateBean.class);
		setNullField(result);
		return result;
	}

	/**
	 * 设置可以为null字段
	 * 
	 * @param execQuery
	 * @return
	 */
	protected void setNullField(PharmDgLocDateBean[] result) {
		for (PharmDgLocDateBean pharmBean : result) {
			pharmBean.setBatchid("");
			pharmBean.setBatchno("");
			pharmBean.setProducedate("");
			pharmBean.setDisableddate("");
		}
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
