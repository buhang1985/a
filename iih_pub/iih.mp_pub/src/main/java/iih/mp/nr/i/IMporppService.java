package iih.mp.nr.i;

import iih.mp.nr.dto.d.BedQuanDTO;
import xap.mw.core.data.BizException;

public interface IMporppService {


	/**
	 * 获取医嘱床旁余量列表
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public abstract BedQuanDTO[] getOrderSrvBedQuan(String id_or) throws BizException;

	/**
	 * 获取医嘱床旁余量更新
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public abstract String updateOrderSrvBedQuan(BedQuanDTO[] quanDTOS) throws BizException;
}
