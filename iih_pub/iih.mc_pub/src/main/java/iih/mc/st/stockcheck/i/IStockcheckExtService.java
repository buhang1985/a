package iih.mc.st.stockcheck.i;

import iih.mc.st.stockcheck.d.McStockCaspItemDO;
import iih.mc.st.stockcheck.d.McStockCheckItmDO;
import iih.mc.st.stockcheck.d.StockcheckAggDO;
import iih.mc.st.stockcheckitemdto.d.StockCheckItemDTO;
import xap.mw.core.data.BizException;

/**
 * 耗材库存盘点接口2.0
 * @author liuyilin
 *
 */
public interface IStockcheckExtService {

	/**
	 * 新增、编辑进入AGG卡时，点击新增，弹出窗口，获取和仓库关联的所有耗材的结存信息
	 * @param idWh
	 * @return
	 * @throws BizException
	 */
	public abstract StockCheckItemDTO[] getStockItemInfo(StockcheckAggDO aggDo, String locId, String searchMm) throws BizException;
	
	/**
	 * 盘点数据录入进入AGG卡，点击新增，弹出窗口，根据填写的物品查询结存信息
	 * @param itemDo
	 * @param idWh
	 * @return
	 * @throws BizException
	 */
	public abstract McStockCheckItmDO getItemBlInfo(McStockCheckItmDO itemDo, String idWh) throws BizException;
	public abstract McStockCaspItemDO getCaspBlInfo(McStockCaspItemDO caspDo, String idWh) throws BizException;
}
