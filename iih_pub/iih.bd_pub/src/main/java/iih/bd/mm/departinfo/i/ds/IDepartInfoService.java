package iih.bd.mm.departinfo.i.ds;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

public interface IDepartInfoService {
	/**
	 * 获取科室某物品的基数量
	 * @param depId 部门ID
	 * @param materialId 物品ID
	 * @param pkguId 包装单位
	 * @return 基数量
	 * @throws BizException
	 */
	public FDouble getMaterialMaxStockNum(String depId, String materialId,
			String pkguId) throws BizException;
}
