package iih.ei.std.cr_technology.v1.s;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.TransactionStatus;

import iih.bd.utils.WsXmlUtils;
import iih.ei.std.cr_technology.v1.d.PivasBaseBodyParam;
import iih.ei.std.cr_technology.v1.d.PivasBaseHead;
import iih.ei.std.cr_technology.v1.d.PivasBaseParamBean;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugParamBeanList;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugRstBean;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugRstBeanList;
import iih.ei.std.cr_technology.v1.d.PivasFindDeptDicResultBean;
import iih.ei.std.cr_technology.v1.d.PivasFindDeptDicResultBeanInfo;
import iih.ei.std.cr_technology.v1.d.PivasFindDeptDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.d.PivasFindDoctorDicResultBean;
import iih.ei.std.cr_technology.v1.d.PivasFindDoctorDicResultBeanInfo;
import iih.ei.std.cr_technology.v1.d.PivasFindDoctorDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.d.PivasFindDrugAdmiDicResultBean;
import iih.ei.std.cr_technology.v1.d.PivasFindDrugAdmiDicResultBeanInfo;
import iih.ei.std.cr_technology.v1.d.PivasFindDrugAdmiDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.d.PivasFindDrugDicResultBean;
import iih.ei.std.cr_technology.v1.d.PivasFindDrugDicResultBeanInfo;
import iih.ei.std.cr_technology.v1.d.PivasFindDrugDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.d.PivasFindMpPlansParamBean;
import iih.ei.std.cr_technology.v1.d.PivasFindMpPlansResultBean;
import iih.ei.std.cr_technology.v1.d.PivasFindOperatorDicResultBean;
import iih.ei.std.cr_technology.v1.d.PivasFindOperatorDicResultBeanInfo;
import iih.ei.std.cr_technology.v1.d.PivasFindOperatorDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.d.PivasFindOrdAdviceDicResultBean;
import iih.ei.std.cr_technology.v1.d.PivasFindOrdAdviceDicResultBeanInfo;
import iih.ei.std.cr_technology.v1.d.PivasFindOrdAdviceDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.d.PivasFindPatBedDicResultBean;
import iih.ei.std.cr_technology.v1.d.PivasFindPatBedDicResultBeanInfo;
import iih.ei.std.cr_technology.v1.d.PivasFindPatBedDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.d.PivasFindPatDicResultBean;
import iih.ei.std.cr_technology.v1.d.PivasFindPatDicResultBeanInfo;
import iih.ei.std.cr_technology.v1.d.PivasFindPatDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.d.PivasFindPharlogyTypeDicResultBean;
import iih.ei.std.cr_technology.v1.d.PivasFindPharlogyTypeDicResultBeanInfo;
import iih.ei.std.cr_technology.v1.d.PivasFindPharlogyTypeDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.d.PivasFindPharmStockDicResultBean;
import iih.ei.std.cr_technology.v1.d.PivasFindPharmStockDicResultBeanInfo;
import iih.ei.std.cr_technology.v1.d.PivasFindPharmStockDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.d.PivasFindPharmacyDicResultBean;
import iih.ei.std.cr_technology.v1.d.PivasFindPharmacyDicResultBeanInfo;
import iih.ei.std.cr_technology.v1.d.PivasFindPharmacyDicResultBeanInfoDt;
import iih.ei.std.cr_technology.v1.i.IPivasWebService;
import iih.ei.std.cr_technology.v1.s.bp.PivasDispDrugBp;
import iih.ei.std.cr_technology.v1.s.bp.PivasDispDrugCommBp;
import iih.ei.std.cr_technology.v1.s.bp.PivasDispDrugNewBp;
import iih.ei.std.cr_technology.v1.s.bp.PivasFindDeptDicBp;
import iih.ei.std.cr_technology.v1.s.bp.PivasFindDoctorDicBp;
import iih.ei.std.cr_technology.v1.s.bp.PivasFindDrugAdmiDicBp;
import iih.ei.std.cr_technology.v1.s.bp.PivasFindDrugDicBp;
import iih.ei.std.cr_technology.v1.s.bp.PivasFindMpPlansBp;
import iih.ei.std.cr_technology.v1.s.bp.PivasFindOperatorDicBp;
import iih.ei.std.cr_technology.v1.s.bp.PivasFindOrdAdviceDicBp;
import iih.ei.std.cr_technology.v1.s.bp.PivasFindPatBedDicBp;
import iih.ei.std.cr_technology.v1.s.bp.PivasFindPatDicBp;
import iih.ei.std.cr_technology.v1.s.bp.PivasFindPharlogyTypeDicBp;
import iih.ei.std.cr_technology.v1.s.bp.PivasFindPharmStockDicBp;
import iih.ei.std.cr_technology.v1.s.bp.PivasFindPharmacyDicBp;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;

/**
 * 静脉药物配置中心WebService实现
 * 
 * @author hao_wu 2018-5-29
 * @author hao_wu 2018-6-26 新增查询药品执行计划接口
 *
 */
public class PivasWebService implements IPivasWebService {
	/**
	 * 发药计费
	 * 
	 * @param inputParam 入参
	 * @return
	 */
	@Override
	public String dispDrug(final String inputParam) {

		final PivasDispDrugRstBeanList resultBean = new PivasDispDrugRstBeanList();
		final List<PivasDispDrugRstBean> rstbeanlsit = new ArrayList<PivasDispDrugRstBean>();
		final PivasDispDrugBp bp = new PivasDispDrugBp();
		try {
			final PivasDispDrugParamBeanList paramBeanList = WsXmlUtils.deSerializeBaseDO(inputParam,
					PivasDispDrugParamBeanList.class);
			TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
				@Override
				public String doInTransaction(TransactionStatus arg0) {
					try {
						bp.exec(paramBeanList.getPivasDispDrugParamBean(), resultBean);
						return null;
					} catch (Exception e) {
						throw new BizRuntimeException(e.getMessage(), e);
					}
				}
			});
		} catch (Exception e) {
			PivasDispDrugRstBean rstbean = bp.initRstBean(null, e);
			rstbeanlsit.add(rstbean);
		}

		if (rstbeanlsit != null && rstbeanlsit.size() > 0) {
			resultBean.setPivasDispDrugRstBean(rstbeanlsit.toArray(new PivasDispDrugRstBean[0]));
		}
		String rtnXml = WsXmlUtils.serialize(resultBean);
		return rtnXml;
	}

	/**
	 * 发药计费
	 * 
	 * @param inputParam 入参
	 * @return
	 */
	@Override
	public String dispDrugBat(final String inputParam) {

		final PivasDispDrugRstBeanList resultBean = new PivasDispDrugRstBeanList();
		final List<PivasDispDrugRstBean> rstbeanlsit = new ArrayList<PivasDispDrugRstBean>();
		final PivasDispDrugNewBp bp = new PivasDispDrugNewBp();
		try {
			final PivasDispDrugParamBeanList paramBeanList = WsXmlUtils.deSerializeBaseDO(inputParam,
					PivasDispDrugParamBeanList.class);
			TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
				@Override
				public String doInTransaction(TransactionStatus arg0) {
					try {
						bp.exec(paramBeanList.getPivasDispDrugParamBean(), resultBean);
						return null;
					} catch (Exception e) {
						throw new BizRuntimeException(e.getMessage(), e);
					}
				}
			});
		} catch (Exception e) {
			rstbeanlsit.add(PivasDispDrugCommBp.initExcRstBean(null, e));
		}

		if (rstbeanlsit != null && rstbeanlsit.size() > 0)
			resultBean.setPivasDispDrugRstBean(rstbeanlsit.toArray(new PivasDispDrugRstBean[0]));
		String rtnXml = WsXmlUtils.serialize(resultBean);
		return rtnXml;
	}

	/**
	 * 查询药品执行计划</br>
	 * Pivas轮询调用，查询药品执行计划
	 * 
	 * @param inputParam 入参
	 * @return 药品执行计划
	 */
	@Override
	public String findMpPlans(String inputParam) {

		PivasFindMpPlansResultBean resultBean = new PivasFindMpPlansResultBean();

		try {
			PivasFindMpPlansParamBean paramBean = WsXmlUtils.deSerializeBaseDO(inputParam,
					PivasFindMpPlansParamBean.class);
			PivasFindMpPlansBp bp = new PivasFindMpPlansBp();
			resultBean = bp.exec(paramBean);
		} catch (Exception e) {
			resultBean.setException(e);
		}

		String rtnXml = WsXmlUtils.serialize(resultBean);
		return rtnXml;
	}

	/**
	 * 查询药品字典
	 * 
	 * @param inputParam 入参
	 * @return 药品执行计划
	 */
	@Override
	public String findDrugDic(String inputParam) {
		PivasFindDrugDicResultBean resultBean = new PivasFindDrugDicResultBean();
		PivasFindDrugDicResultBeanInfo beanInfo = new PivasFindDrugDicResultBeanInfo();
		PivasBaseHead headParam = null;
		String seqid = null;
		try {
			PivasBaseParamBean paramBean = WsXmlUtils.deSerializeBaseDO(inputParam, PivasBaseParamBean.class);
			paramBean.getHeadParam();
			headParam = paramBean.getHeadParam();
			PivasBaseBodyParam bodyParam = paramBean.getBodyParam();
			seqid = bodyParam.getSeqid();
			PivasFindDrugDicBp bp = new PivasFindDrugDicBp();
			PivasFindDrugDicResultBeanInfoDt[] beanInfoDt = bp.exec(paramBean);
			beanInfo.setCode("0");
			beanInfo.setMessage("成功");
			beanInfo.setBeanInfoDt(beanInfoDt);
		} catch (Exception e) {
			beanInfo.setCode("1");
			beanInfo.setMessage("失败");
		} finally {
			resultBean.setPivasBaseHead(headParam);
			beanInfo.setSeqid(seqid);
			resultBean.setBeanInfo(beanInfo);
		}
		String rtnXml = WsXmlUtils.serialize(resultBean);
		return rtnXml;
	}

	/**
	 * 药品药理分类信息
	 * 
	 * @param inputParam
	 * @return
	 */
	@Override
	public String findPharlogyTypeDic(String inputParam) {
		PivasFindPharlogyTypeDicResultBean resultBean = new PivasFindPharlogyTypeDicResultBean();
		PivasFindPharlogyTypeDicResultBeanInfo beanInfo = new PivasFindPharlogyTypeDicResultBeanInfo();
		PivasBaseHead headParam = null;
		String seqid = null;
		try {
			PivasBaseParamBean paramBean = WsXmlUtils.deSerializeBaseDO(inputParam, PivasBaseParamBean.class);
			paramBean.getHeadParam();
			headParam = paramBean.getHeadParam();
			PivasBaseBodyParam bodyParam = paramBean.getBodyParam();
			seqid = bodyParam.getSeqid();
			PivasFindPharlogyTypeDicBp bp = new PivasFindPharlogyTypeDicBp();
			PivasFindPharlogyTypeDicResultBeanInfoDt[] beanInfoDt = bp.exec(paramBean);
			beanInfo.setCode("0");
			beanInfo.setMessage("成功");
			beanInfo.setBeanInfoDt(beanInfoDt);
		} catch (Exception e) {
			beanInfo.setCode("1");
			beanInfo.setMessage("失败");
		} finally {
			resultBean.setPivasBaseHead(headParam);
			beanInfo.setSeqid(seqid);
			resultBean.setBeanInfo(beanInfo);
		}
		String rtnXml = WsXmlUtils.serialize(resultBean);
		return rtnXml;
	}

	/**
	 * 医生基本信息
	 * 
	 * @param inputParam
	 * @return
	 */
	@Override
	public String findDoctorDic(String inputParam) {
		PivasFindDoctorDicResultBean resultBean = new PivasFindDoctorDicResultBean();
		PivasFindDoctorDicResultBeanInfo beanInfo = new PivasFindDoctorDicResultBeanInfo();
		PivasBaseHead headParam = null;
		String seqid = null;
		try {
			PivasBaseParamBean paramBean = WsXmlUtils.deSerializeBaseDO(inputParam, PivasBaseParamBean.class);
			paramBean.getHeadParam();
			headParam = paramBean.getHeadParam();
			PivasBaseBodyParam bodyParam = paramBean.getBodyParam();
			seqid = bodyParam.getSeqid();
			PivasFindDoctorDicBp bp = new PivasFindDoctorDicBp();
			PivasFindDoctorDicResultBeanInfoDt[] beanInfoDt = bp.exec(paramBean);
			beanInfo.setCode("0");
			beanInfo.setMessage("成功");
			beanInfo.setBeanInfoDt(beanInfoDt);
		} catch (Exception e) {
			beanInfo.setCode("1");
			beanInfo.setMessage("失败");
		} finally {
			resultBean.setPivasBaseHead(headParam);
			beanInfo.setSeqid(seqid);
			resultBean.setBeanInfo(beanInfo);
		}
		String rtnXml = WsXmlUtils.serialize(resultBean);
		return rtnXml;
	}

	/**
	 * 在院病人基本信息接口
	 * 
	 * @param inputParam
	 * @return
	 */
	@Override
	public String findPatDic(String inputParam) {
		PivasFindPatDicResultBean resultBean = new PivasFindPatDicResultBean();
		PivasFindPatDicResultBeanInfo beanInfo = new PivasFindPatDicResultBeanInfo();
		PivasBaseHead headParam = null;
		String seqid = null;
		try {
			PivasBaseParamBean paramBean = WsXmlUtils.deSerializeBaseDO(inputParam, PivasBaseParamBean.class);
			paramBean.getHeadParam();
			headParam = paramBean.getHeadParam();
			PivasBaseBodyParam bodyParam = paramBean.getBodyParam();
			seqid = bodyParam.getSeqid();
			PivasFindPatDicBp bp = new PivasFindPatDicBp();
			PivasFindPatDicResultBeanInfoDt[] beanInfoDt = bp.exec(paramBean);
			beanInfo.setCode("0");
			beanInfo.setMessage("成功");
			beanInfo.setBeanInfoDt(beanInfoDt);
		} catch (Exception e) {
			beanInfo.setCode("1");
			beanInfo.setMessage("失败");
		} finally {
			resultBean.setPivasBaseHead(headParam);
			beanInfo.setSeqid(seqid);
			resultBean.setBeanInfo(beanInfo);
		}
		String rtnXml = WsXmlUtils.serialize(resultBean);
		return rtnXml;
	}

	/**
	 * 科室基本信息
	 * 
	 * @param inputParam
	 * @return
	 */
	@Override
	public String findDeptDic(String inputParam) {
		PivasFindDeptDicResultBean resultBean = new PivasFindDeptDicResultBean();
		PivasFindDeptDicResultBeanInfo beanInfo = new PivasFindDeptDicResultBeanInfo();
		PivasBaseHead headParam = null;
		String seqid = null;
		try {
			PivasBaseParamBean paramBean = WsXmlUtils.deSerializeBaseDO(inputParam, PivasBaseParamBean.class);
			paramBean.getHeadParam();
			headParam = paramBean.getHeadParam();
			PivasBaseBodyParam bodyParam = paramBean.getBodyParam();
			seqid = bodyParam.getSeqid();
			PivasFindDeptDicBp bp = new PivasFindDeptDicBp();
			PivasFindDeptDicResultBeanInfoDt[] beanInfoDt = bp.exec(paramBean);
			beanInfo.setCode("0");
			beanInfo.setMessage("成功");
			beanInfo.setBeanInfoDt(beanInfoDt);
		} catch (Exception e) {
			beanInfo.setCode("1");
			beanInfo.setMessage("失败");
		} finally {
			resultBean.setPivasBaseHead(headParam);
			beanInfo.setSeqid(seqid);
			resultBean.setBeanInfo(beanInfo);
		}
		String rtnXml = WsXmlUtils.serialize(resultBean);
		return rtnXml;
	}

	/**
	 * 药局(房)基本信息
	 * 
	 * @param inputParam
	 * @return
	 */
	@Override
	public String findPharmacyDic(String inputParam) {
		PivasFindPharmacyDicResultBean resultBean = new PivasFindPharmacyDicResultBean();
		PivasFindPharmacyDicResultBeanInfo beanInfo = new PivasFindPharmacyDicResultBeanInfo();
		PivasBaseHead headParam = null;
		String seqid = null;
		try {
			PivasBaseParamBean paramBean = WsXmlUtils.deSerializeBaseDO(inputParam, PivasBaseParamBean.class);
			paramBean.getHeadParam();
			headParam = paramBean.getHeadParam();
			PivasBaseBodyParam bodyParam = paramBean.getBodyParam();
			seqid = bodyParam.getSeqid();
			PivasFindPharmacyDicBp bp = new PivasFindPharmacyDicBp();
			PivasFindPharmacyDicResultBeanInfoDt[] beanInfoDt = bp.exec(paramBean);
			beanInfo.setCode("0");
			beanInfo.setMessage("成功");
			beanInfo.setBeanInfoDt(beanInfoDt);
		} catch (Exception e) {
			beanInfo.setCode("1");
			beanInfo.setMessage("失败");
		} finally {
			resultBean.setPivasBaseHead(headParam);
			beanInfo.setSeqid(seqid);
			resultBean.setBeanInfo(beanInfo);
		}
		String rtnXml = WsXmlUtils.serialize(resultBean);
		return rtnXml;
	}

	/**
	 * 给药方式基本信息
	 * 
	 * @param inputParam
	 * @return
	 */
	@Override
	public String findDrugAdmiDic(String inputParam) {
		PivasFindDrugAdmiDicResultBean resultBean = new PivasFindDrugAdmiDicResultBean();
		PivasFindDrugAdmiDicResultBeanInfo beanInfo = new PivasFindDrugAdmiDicResultBeanInfo();
		PivasBaseHead headParam = null;
		String seqid = null;
		try {
			PivasBaseParamBean paramBean = WsXmlUtils.deSerializeBaseDO(inputParam, PivasBaseParamBean.class);
			paramBean.getHeadParam();
			headParam = paramBean.getHeadParam();
			PivasBaseBodyParam bodyParam = paramBean.getBodyParam();
			seqid = bodyParam.getSeqid();
			PivasFindDrugAdmiDicBp bp = new PivasFindDrugAdmiDicBp();
			PivasFindDrugAdmiDicResultBeanInfoDt[] beanInfoDt = bp.exec(paramBean);
			beanInfo.setCode("0");
			beanInfo.setMessage("成功");
			beanInfo.setBeanInfoDt(beanInfoDt);
		} catch (Exception e) {
			beanInfo.setCode("1");
			beanInfo.setMessage("失败");
		} finally {
			resultBean.setPivasBaseHead(headParam);
			beanInfo.setSeqid(seqid);
			resultBean.setBeanInfo(beanInfo);
		}
		String rtnXml = WsXmlUtils.serialize(resultBean);
		return rtnXml;
	}

	/**
	 * 在院病人床位基本信息
	 * 
	 * @param inputParam
	 * @return
	 */
	@Override
	public String findPatBedDic(String inputParam) {
		PivasFindPatBedDicResultBean resultBean = new PivasFindPatBedDicResultBean();
		PivasFindPatBedDicResultBeanInfo beanInfo = new PivasFindPatBedDicResultBeanInfo();
		PivasBaseHead headParam = null;
		String seqid = null;
		try {
			PivasBaseParamBean paramBean = WsXmlUtils.deSerializeBaseDO(inputParam, PivasBaseParamBean.class);
			paramBean.getHeadParam();
			headParam = paramBean.getHeadParam();
			PivasBaseBodyParam bodyParam = paramBean.getBodyParam();
			seqid = bodyParam.getSeqid();
			PivasFindPatBedDicBp bp = new PivasFindPatBedDicBp();
			PivasFindPatBedDicResultBeanInfoDt[] beanInfoDt = bp.exec(paramBean);
			beanInfo.setCode("0");
			beanInfo.setMessage("成功");
			beanInfo.setBeanInfoDt(beanInfoDt);
		} catch (Exception e) {
			beanInfo.setCode("1");
			beanInfo.setMessage("失败");
		} finally {
			resultBean.setPivasBaseHead(headParam);
			beanInfo.setSeqid(seqid);
			resultBean.setBeanInfo(beanInfo);
		}
		String rtnXml = WsXmlUtils.serialize(resultBean);
		return rtnXml;
	}

	/**
	 * 操作员基本信息
	 * 
	 * @param inputParam
	 * @return
	 */
	@Override
	public String findOperatorDic(String inputParam) {
		PivasFindOperatorDicResultBean resultBean = new PivasFindOperatorDicResultBean();
		PivasFindOperatorDicResultBeanInfo beanInfo = new PivasFindOperatorDicResultBeanInfo();
		PivasBaseHead headParam = null;
		String seqid = null;
		try {
			PivasBaseParamBean paramBean = WsXmlUtils.deSerializeBaseDO(inputParam, PivasBaseParamBean.class);
			paramBean.getHeadParam();
			headParam = paramBean.getHeadParam();
			PivasBaseBodyParam bodyParam = paramBean.getBodyParam();
			seqid = bodyParam.getSeqid();
			PivasFindOperatorDicBp bp = new PivasFindOperatorDicBp();
			PivasFindOperatorDicResultBeanInfoDt[] beanInfoDt = bp.exec(paramBean);
			beanInfo.setCode("0");
			beanInfo.setMessage("成功");
			beanInfo.setBeanInfoDt(beanInfoDt);
		} catch (Exception e) {
			beanInfo.setCode("1");
			beanInfo.setMessage("失败");
		} finally {
			resultBean.setPivasBaseHead(headParam);
			beanInfo.setSeqid(seqid);
			resultBean.setBeanInfo(beanInfo);
		}
		String rtnXml = WsXmlUtils.serialize(resultBean);
		return rtnXml;
	}

	/**
	 * 药局(房)库存基本信息
	 * 
	 * @param inputParam
	 * @return
	 */
	@Override
	public String findPharmStockDic(String inputParam) {
		PivasFindPharmStockDicResultBean resultBean = new PivasFindPharmStockDicResultBean();
		PivasFindPharmStockDicResultBeanInfo beanInfo = new PivasFindPharmStockDicResultBeanInfo();
		PivasBaseHead headParam = null;
		String seqid = null;
		try {
			PivasBaseParamBean paramBean = WsXmlUtils.deSerializeBaseDO(inputParam, PivasBaseParamBean.class);
			paramBean.getHeadParam();
			headParam = paramBean.getHeadParam();
			PivasBaseBodyParam bodyParam = paramBean.getBodyParam();
			seqid = bodyParam.getSeqid();
			PivasFindPharmStockDicBp bp = new PivasFindPharmStockDicBp();
			PivasFindPharmStockDicResultBeanInfoDt[] beanInfoDt = bp.exec(paramBean);
			beanInfo.setCode("0");
			beanInfo.setMessage("成功");
			beanInfo.setBeanInfoDt(beanInfoDt);
		} catch (Exception e) {
			beanInfo.setCode("1");
			beanInfo.setMessage("失败");
		} finally {
			resultBean.setPivasBaseHead(headParam);
			beanInfo.setSeqid(seqid);
			resultBean.setBeanInfo(beanInfo);
		}
		String rtnXml = WsXmlUtils.serialize(resultBean);
		return rtnXml;
	}

	/**
	 * 医嘱用法资料信息
	 * 
	 * @param inputParam
	 * @return
	 */
	@Override
	public String findOrdAdviceDic(String inputParam) {
		PivasFindOrdAdviceDicResultBean resultBean = new PivasFindOrdAdviceDicResultBean();
		PivasFindOrdAdviceDicResultBeanInfo beanInfo = new PivasFindOrdAdviceDicResultBeanInfo();
		PivasBaseHead headParam = null;
		String seqid = null;
		try {
			PivasBaseParamBean paramBean = WsXmlUtils.deSerializeBaseDO(inputParam, PivasBaseParamBean.class);
			paramBean.getHeadParam();
			headParam = paramBean.getHeadParam();
			PivasBaseBodyParam bodyParam = paramBean.getBodyParam();
			seqid = bodyParam.getSeqid();
			PivasFindOrdAdviceDicBp bp = new PivasFindOrdAdviceDicBp();
			PivasFindOrdAdviceDicResultBeanInfoDt[] beanInfoDt = bp.exec(paramBean);
			beanInfo.setCode("0");
			beanInfo.setMessage("成功");
			beanInfo.setBeanInfoDt(beanInfoDt);
		} catch (Exception e) {
			beanInfo.setCode("1");
			beanInfo.setMessage("失败");
		} finally {
			resultBean.setPivasBaseHead(headParam);
			beanInfo.setSeqid(seqid);
			resultBean.setBeanInfo(beanInfo);
		}
		String rtnXml = WsXmlUtils.serialize(resultBean);
		return rtnXml;
	}

}
