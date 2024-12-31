package iih.bd.fc.orderexesigndict.s;

import iih.bd.fc.orderexesigndict.i.IOrderexesigndictService;
import iih.bd.fc.orderexesigndict.s.bp.getListbp;
import iih.bd.fc.orpltp.d.OrpltpStaDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { IOrderexesigndictService.class }, binding = Binding.JSONRPC)
public class IOrderexesigndictServiceImpl implements IOrderexesigndictService {

	/*
	 * 4.3.6.6 医嘱执行标志配置获取OrpltpStaDO列表
	 * 李俊明   2016-3-17 15:03:13
	 */
	@Override
	public OrpltpStaDO[] getList() throws BizException {

		getListbp bp = new getListbp();

		return bp.exec();
	}

}
