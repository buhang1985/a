package iih.bd.fc.orderloopseqno.s;

import iih.bd.fc.orderloopseqno.d.OrderLoopSeqnoDTO;
import iih.bd.fc.orderloopseqno.i.IOrderLoopSeqnoService;
import iih.bd.fc.orderloopseqno.s.bp.getTreeListbp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { IOrderLoopSeqnoService.class }, binding = Binding.JSONRPC)
public class IOrderLoopSeqnoServiceImpl implements IOrderLoopSeqnoService {

	/*
	 * 获取医嘱闭环顺序维护树数据
	 * */
	@Override
	public OrderLoopSeqnoDTO[] getTreeList() throws BizException {
		
		getTreeListbp bp=new getTreeListbp();
		
		return bp.exec();
	}

	
}
