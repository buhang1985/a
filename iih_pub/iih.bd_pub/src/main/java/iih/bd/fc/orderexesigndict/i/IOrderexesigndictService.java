package iih.bd.fc.orderexesigndict.i;

import xap.mw.core.data.BizException;
import iih.bd.fc.orpltp.d.OrpltpStaDO;

public interface IOrderexesigndictService {

	/**
	 * 获取医嘱闭环类型状态数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract OrpltpStaDO[] getList() throws BizException;	

}
