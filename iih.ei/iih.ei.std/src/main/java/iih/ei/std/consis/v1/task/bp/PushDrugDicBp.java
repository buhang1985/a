package iih.ei.std.consis.v1.task.bp;

import com.founder.i.IHisService;

import iih.bd.utils.CommDAFacade;
import iih.bd.utils.WsXmlUtils;
import iih.ei.std.consis.v1.s.bp.BaseCallWsBp;
import iih.ei.std.consis.v1.task.bp.qry.FindDrugDicQry;
import iih.ei.std.consis.v1.task.d.DgDicDataParamBean;
import iih.ei.std.consis.v1.task.d.DgDicDataParamBeanList;
import iih.mp.dg.ws.log.utils.WebServiceLog;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.bdfw.bbd.i.IPsndocRService;

/**
 * 推送药品字典业务逻辑
 * 
 * @author hao_wu 2018-12-14
 *
 */
public class PushDrugDicBp extends BaseCallWsBp {

	/**
	 * 执行逻辑
	 * 
	 * @return
	 * @throws BizException
	 */
	public String exec() throws BizException {
		DgDicDataParamBeanList paramBeanList = getParamBeanList();
		String paramString = WsXmlUtils.serialize(paramBeanList, true);
		String result = callWebService(paramString);
		return result;
	}

	/**
	 * 获取JavaBean集合BeanList
	 * 
	 * @return
	 * @throws BizException
	 */
	protected DgDicDataParamBeanList getParamBeanList() throws BizException {
		DgDicDataParamBeanList paramBeanList = new DgDicDataParamBeanList();
		paramBeanList.setOpsystem("HIS");
		paramBeanList.setOptype("101");
		paramBeanList.setOpwinid("");
		paramBeanList.setOpip("");
		// 终端操作员编码 姓名
		PsnDocDO checkInMachine = getOpreratInfo();
		if (checkInMachine != null) {
			paramBeanList.setOpmanno(checkInMachine.getCode());
			paramBeanList.setOpmanname(checkInMachine.getName());
		} else {
			paramBeanList.setOpmanno("");
			paramBeanList.setOpmanname("");
		}
		DgDicDataParamBean[] paramBean = getParamBean();
		paramBeanList.set_dgDicDataParamBean(paramBean);
		return paramBeanList;
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
	 * 获取JavaBean
	 * 
	 * @return
	 * @throws BizException
	 */
	protected DgDicDataParamBean[] getParamBean() throws BizException {
		FindDrugDicQry sql = new FindDrugDicQry();
		DgDicDataParamBean[] execQuery = CommDAFacade.execQuery(sql, DgDicDataParamBean.class);
		DgDicDataParamBean[] result = setNullField(execQuery);
		return result;
	}

	/**
	 * 设置可以为空的字段
	 * 
	 * @param getBeans
	 * @return
	 */
	protected DgDicDataParamBean[] setNullField(DgDicDataParamBean[] execQuery) {
		for (DgDicDataParamBean dgDicDataBean : execQuery) {
			dgDicDataBean.setTradename("");
			dgDicDataBean.setEnglishname("");
			dgDicDataBean.setPinyin("");
			dgDicDataBean.setSorttype1("");
			dgDicDataBean.setSorttype2("");
			dgDicDataBean.setMinspecs("");
			dgDicDataBean.setDosageunit("");
			dgDicDataBean.setBarcode("");
			dgDicDataBean.setStoragecondition("");
		}
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
