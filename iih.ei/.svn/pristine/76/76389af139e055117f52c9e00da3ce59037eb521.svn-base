package iih.ei.std.consis.v1.task.bp;

import org.apache.commons.lang.StringUtils;

import com.founder.i.IHisService;

import iih.bd.utils.CommDAFacade;
import iih.bd.utils.WsXmlUtils;
import iih.ei.std.consis.v1.s.bp.BaseCallWsBp;
import iih.ei.std.consis.v1.task.bp.qry.FindWinDicQry;
import iih.ei.std.consis.v1.task.d.DispDrugWinDateBean;
import iih.ei.std.consis.v1.task.d.DispDrugWinDateBeanList;
import iih.mp.dg.ws.log.utils.WebServiceLog;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.bdfw.bbd.i.IPsndocRService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 推送药房窗口字典业务逻辑
 * 
 * @author hao_wu 2018-12-14
 *
 */
public class PushWinDicBp extends BaseCallWsBp {

	/**
	 * 推送药房窗口字典
	 * 
	 * @param pharmacyId 药房主键
	 * @return
	 * @throws BizException
	 */
	public String exec(String pharmacyId) throws BizException {

		validationParam(pharmacyId);

		DispDrugWinDateBeanList paramBeanList = getParamBeanList(pharmacyId);
		String paramString = WsXmlUtils.serialize(paramBeanList, true);
		String result = callWebService(paramString);
		return result;
	}

	/**
	 * 验证参数
	 * 
	 * @param pharmacyId
	 * @throws BizException
	 */
	protected void validationParam(String pharmacyId) throws BizException {
		if (StringUtils.isEmpty(pharmacyId)) {
			throw new BizException("药房主键不允许为空。");
		}

		DAFacade daFacade = new DAFacade();
		DeptDO dep = (DeptDO) daFacade.findByPK(DeptDO.class, pharmacyId);
		if (dep == null) {
			String msg = String.format("未查询药房科室，药房主键：%s。", pharmacyId);
			throw new BizException(msg);
		}
	}

	/**
	 * 获取发药窗口基本数据集合
	 * 
	 * @param pharmacyId 药房主键
	 * @return
	 * @throws BizException
	 */
	protected DispDrugWinDateBeanList getParamBeanList(String pharmacyId) throws BizException {
		DispDrugWinDateBeanList prescBeanList = new DispDrugWinDateBeanList();
		prescBeanList.setOpsystem("HIS");
		prescBeanList.setOptype("106");
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
		DispDrugWinDateBean[] paramBeans = getParamBeans(pharmacyId);
		prescBeanList.set_dDispDrugWinDateBeans(paramBeans);
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
	 * 获取发药窗口基本数据JavaBean
	 * 
	 * @param pharmacyId 药房主键
	 * @return
	 * @throws BizException
	 */
	protected DispDrugWinDateBean[] getParamBeans(String pharmacyId) throws BizException {
		FindWinDicQry qry = new FindWinDicQry(pharmacyId);
		DispDrugWinDateBean[] execQuery = CommDAFacade.execQuery(qry, DispDrugWinDateBean.class);
		DispDrugWinDateBean[] result = setNullField(execQuery);
		return result;
	}

	/**
	 * 设置可以为空的字段
	 * 
	 * @param execQuery
	 * @return
	 */
	protected DispDrugWinDateBean[] setNullField(DispDrugWinDateBean[] execQuery) {
		for (DispDrugWinDateBean pharmacBean : execQuery) {
			if (StringUtils.isEmpty(pharmacBean.getOpwinid_name())) {
				pharmacBean.setOpwinid_name("");
			}
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
