package iih.bd.pp.external.provide.en.i;

import iih.bd.pp.external.provide.en.d.DrugMaxPriceDTO;
import xap.mw.core.data.BizException;

/**
 * 提供给就诊域查询接口
 * 
 * @author hao_wu 2018-11-27
 *
 */
public interface IBdPpEnQryService {

	/**
	 * 根据拼音码查询药品最高价格列表</br>
	 * 价格使用库存最高价
	 * 
	 * @param pyCode 拼音码
	 * @return
	 * @throws BizException
	 */
	public abstract DrugMaxPriceDTO[] findDrugMaxPriListByPyCode(String pyCode) throws BizException;
}
