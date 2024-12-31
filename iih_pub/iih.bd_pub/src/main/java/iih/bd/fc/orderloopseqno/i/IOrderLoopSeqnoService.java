package iih.bd.fc.orderloopseqno.i;

import iih.bd.fc.orderloopseqno.d.OrderLoopSeqnoDTO;
import xap.mw.core.data.BizException;

public interface IOrderLoopSeqnoService {

	/**
	 * 获取医嘱闭环顺序维护树数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract OrderLoopSeqnoDTO[] getTreeList() throws BizException;
}
