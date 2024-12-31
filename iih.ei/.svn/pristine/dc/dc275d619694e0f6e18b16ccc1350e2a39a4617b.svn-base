package iih.ei.std.consis.v1.task.bp;

import org.apache.commons.lang.StringUtils;

import com.founder.i.IHisService;

import iih.bd.utils.CommDAFacade;
import iih.bd.utils.WsXmlUtils;
import iih.ei.std.consis.v1.s.bp.BaseCallWsBp;
import iih.ei.std.consis.v1.task.bp.qry.FindPharmacyPsnDicQry;
import iih.ei.std.consis.v1.task.d.PharmacBaseInfoDateBean;
import iih.ei.std.consis.v1.task.d.PharmacBaseInfoDateBeanList;
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
 * 推送药房药师字典业务逻辑
 * 
 * @author hao_wu 2018-12-14
 *
 */
public class PushPharmacyPsnDicBp extends BaseCallWsBp {

	/**
	 * 推送药房药师字典
	 * 
	 * @param pharmacyId 药房主键
	 * @return
	 * @throws BizException
	 */
	public String exec(String pharmacyId) throws BizException {

		validationParam(pharmacyId);

		PharmacBaseInfoDateBeanList paramBeanList = getParamBeanList(pharmacyId);
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
	 * 获取药师基本信息数据JavaBean集合
	 * 
	 * @param pharmacyId 药房主键
	 * @return
	 * @throws BizException
	 */
	protected PharmacBaseInfoDateBeanList getParamBeanList(String pharmacyId) throws BizException {
		PharmacBaseInfoDateBeanList prescBeanList = new PharmacBaseInfoDateBeanList();
		prescBeanList.setOpsystem("HIS");
		prescBeanList.setOptype("107");
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
		PharmacBaseInfoDateBean[] paramBeans = getParamBeans(pharmacyId);
		prescBeanList.set_pharmacBaseInfoBeans(paramBeans);
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
	 * 获取药师基本信息数据JavaBean
	 * 
	 * @param pharmacyId 药房主键
	 * @return
	 * @throws BizException
	 */
	protected PharmacBaseInfoDateBean[] getParamBeans(String pharmacyId) throws BizException {
		FindPharmacyPsnDicQry qry = new FindPharmacyPsnDicQry(pharmacyId);
		PharmacBaseInfoDateBean[] execQuery = CommDAFacade.execQuery(qry, PharmacBaseInfoDateBean.class);
		PharmacBaseInfoDateBean[] result = setNullField(execQuery);
		return result;
	}

	/**
	 * 设置可以为空的字段
	 * 
	 * @param execQuery
	 * @return
	 */
	protected PharmacBaseInfoDateBean[] setNullField(PharmacBaseInfoDateBean[] execQuery) {
		for (PharmacBaseInfoDateBean pharmacBean : execQuery) {
			pharmacBean.setStafferno("");
			pharmacBean.setJob("");
			pharmacBean.setTitle("");
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
