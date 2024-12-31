package iih.bd.pp.i.external.provide;

import iih.bd.pp.i.external.provide.meta.bl.DrugPriceInfo;
import iih.bd.pp.i.external.provide.meta.bl.TreatPriceInfo;
import iih.bd.pp.incca.d.IncCaItmRelDO;
import xap.mw.core.data.BizException;

/**
 * 提供给费用域查询接口
 * 
 * @author hao_wu 2018-6-12
 *
 */
public interface IBdPpBlQryService {

	/**
	 * 根据拼音码查询药品价格列表
	 * 
	 * @param pyCode
	 *            拼音码
	 * @return
	 * @throws BizException
	 */
	public abstract DrugPriceInfo[] findDrugPriListByPyCode(String pyCode) throws BizException;

	/**
	 * 根据拼音码查询诊疗价格列表
	 * 
	 * @param pyCode
	 *            拼音码
	 * @return
	 * @throws BizException
	 */
	public abstract TreatPriceInfo[] findTreatPriListByPyCode(String pyCode) throws BizException;

	/**
	 * 批量获取票据分类对照
	 * 
	 * @param sdIncca
	 *            票据分类编码
	 * @param srvIds
	 *            服务id数组
	 * @return 票据分类对照
	 * @throws BizException
	 * @author ly 2018/06/28
	 */
	public abstract IncCaItmRelDO[] findCaItmRelBySrv(String sdIncca, String[] srvIds) throws BizException;
}
