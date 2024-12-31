package iih.ems.einv.emin.i;

import iih.ems.einv.emin.d.EminAggDO;
import iih.ems.einv.emin.d.EmsInDO;
import iih.ems.einv.emin.d.EmsInItmDO;
import xap.mw.core.data.BizException;

public interface IEminMaintainService {

	/**
	 * 初始化入库单
	 * @param stca_code 库存交易分类
	 * @throws BizException
	 */
	public EminAggDO initAggDo(String sd_sttp) throws BizException;
	
	/**
	 * 初始化入库明细信息
	 * @param inOrderDO 入库单
	 * @param inItemDO 入库单明细
	 * @throws BizException
	 */
	public EmsInItmDO initEminItemInfo(EmsInDO inOrderDO, EmsInItmDO inItemDO) throws BizException;
	
	/**
	 * 入库单提交
	 * @param inOrderDO 入库单
	 * @throws BizException
	 */
	public EmsInDO[] submitMainDO(EmsInDO[] inOrderDOS) throws BizException;
	
	/**
	 * 入库单提交
	 * @param inAggDO 入库单
	 * @throws BizException
	 */
	public EminAggDO submitAggDO(EminAggDO inAggDO) throws BizException;
	
	/**
	 * 加载退货单
	 * @param 
	 * @throws BizException
	 */
	public EminAggDO loadAggDO(String id_card) throws BizException;
	
}
