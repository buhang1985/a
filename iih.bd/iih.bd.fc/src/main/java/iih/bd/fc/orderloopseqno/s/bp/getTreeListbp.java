package iih.bd.fc.orderloopseqno.s.bp;

import iih.bd.fc.orderloopseqno.d.OrderLoopSeqnoDTO;
import iih.bd.fc.orderloopseqno.s.bp.qry.getTreeListSql;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class getTreeListbp {

	/**
	 * 获取医嘱闭环顺序维护树数据
	 * 
	 * @return
	 * @throws BizException
	 */
	public OrderLoopSeqnoDTO[] exec() throws BizException {

		getTreeListSql Sql = new getTreeListSql();

		OrderLoopSeqnoDTO[] DTOS = (OrderLoopSeqnoDTO[]) AppFwUtil.getDORstWithDao(Sql, OrderLoopSeqnoDTO.class);

		return DTOS;
	}

}
