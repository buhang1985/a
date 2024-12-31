package iih.ems.einv.emout.i;

import iih.ems.einv.emda.d.EmdaAggDO;
import iih.ems.einv.emda.d.EmsDaDO;
import iih.ems.einv.emout.d.EmoutAggDO;
import iih.ems.einv.emout.d.EmsOutDO;
import xap.mw.core.data.BizException;

public interface IEmoutMaintainService {

	//初始化领用出库单
	public abstract EmoutAggDO initAggDO() throws BizException; 
	/**
	 * 申请单提交
	 * @param inOrderDO 入库单
	 * @throws BizException
	 */
	public EmsOutDO[] submitMainDO(EmsOutDO[] emoutDOS) throws BizException;
	
	/**
	 * 申请单提交
	 * @param inAggDO 入库单
	 * @throws BizException
	 */
	public EmoutAggDO submitAggDO(EmoutAggDO AggDO) throws BizException;
	
}
