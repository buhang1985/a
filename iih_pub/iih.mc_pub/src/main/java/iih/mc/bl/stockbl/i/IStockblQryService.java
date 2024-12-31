package iih.mc.bl.stockbl.i;

import java.util.List;
import java.util.Map;

import iih.mc.bl.stockbl.d.McStockBlDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface IStockblQryService {
	
	/**
	 * 获取物品结存信息
	 * @param id_wh 仓库
	 * @param id_mms 物品主键列表
	 * @param fg_out 出库标识
	 * @throws BizException
	 */
	public Map<String, List<McStockBlDO>> getMmStockBlInfo(String id_wh, String[] id_mms, FBoolean fg_out) throws BizException;
	
	/**
	 * 获取物品结存信息(出库时批次修改用)
	 * @param id_wh 仓库
	 * @param id_mm 物品主键
	 * @param id_mm_pkgu 包装单位
	 * @param fg_out 出库标识
	 * @throws BizException
	 */
	public McStockBlDO[] getMmStockBlInfoForEditBatch(String id_wh, String id_mm, String id_mm_pkgu, FBoolean fg_out) throws BizException;
	
	/**
	 * 获取物品结存信息(盘点结果录入时、手动录入物品后匹配结存信息用)
	 * @param id_wh 仓库
	 * @param id_mm 物品主键
	 * @throws BizException
	 */
	public Map<String, McStockBlDO> getMmStockBlInfoMap(String id_wh, String id_mm) throws BizException;
}
