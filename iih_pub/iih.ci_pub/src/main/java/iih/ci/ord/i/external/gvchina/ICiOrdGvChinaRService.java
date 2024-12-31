package iih.ci.ord.i.external.gvchina;

import iih.ci.ord.i.external.gvchina.meta.GvDrugOrderRstInfo;
import iih.ci.ord.i.external.gvchina.meta.GvEnDiagRstInfo;
import iih.ci.ord.i.external.gvchina.meta.GvLisOrderRstInfo;
import iih.ci.ord.i.external.gvchina.meta.GvRisOrderRstInfo;
import iih.ci.ord.i.external.gvchina.meta.GvSurgeryOrderRstInfo;
import iih.ci.ord.i.external.gvchina.meta.GvTreatOrderRstInfo;
import xap.mw.core.data.BizException;

/**
 * 1.1 临床CI需求文档
 * 1.1.7	药品医嘱接口
 * 1.1.7.1	业务说明
 * 查询患者在眼科本次就诊的有效药品医嘱
 * 
 * @author wangqingzhu
 *
 */
public interface ICiOrdGvChinaRService {

	/**
	 * 查询患者在眼科本次就诊的有效药品医嘱
	 * @param code_en
	 * @return
	 */
	public abstract GvDrugOrderRstInfo[] getPatOrderDrugInfos(String code_en,String code_dept) throws BizException;
	
	/**
	 * 查询患者在眼科本次就诊的有效检查医嘱
	 * @param code_en
	 * @return
	 */
	public abstract GvRisOrderRstInfo[] getPatOrderRisInfos(String code_en,String code_dept) throws BizException;
	
	/**
	 * 查询患者在眼科本次就诊的有效检验医嘱
	 * @param code_en
	 * @return
	 */
	public abstract GvLisOrderRstInfo[] getPatOrderLisInfos(String code_en,String code_dept) throws BizException;
	
	/**
	 * 查询患者在眼科本次就诊的有效手术医嘱
	 * @param code_en
	 * @return
	 */
	public abstract GvSurgeryOrderRstInfo[] getPatOrderSurgeryInfos(String code_en,String code_dept) throws BizException;
	
	/**
	 * 查询患者在眼科本次就诊的有效诊疗医嘱
	 * @param code_en
	 * @return
	 */
	public abstract GvTreatOrderRstInfo[] getPatOrderTreatInfos(String code_en,String code_dept) throws BizException;
	
	/**
	 * 查询患者在眼科本次就诊的当前诊断
	 * @param code_en
	 * @return
	 */
	public abstract GvEnDiagRstInfo[] getPatEnDiagInfos(String code_en,String code_dept) throws BizException;
}
