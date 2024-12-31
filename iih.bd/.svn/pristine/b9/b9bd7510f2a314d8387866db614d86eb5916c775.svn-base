package iih.bd.pp.com.s;

import iih.bd.pp.com.bp.UdidocHelperBp;
import iih.bd.pp.com.i.IUdidocHelperService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;


@Service(serviceInterfaces = { IUdidocHelperService.class }, binding = Binding.JSONRPC)
public class IUdidocHelperServiceImpl implements IUdidocHelperService{

	@Override
	public UdidocDO[] findUdidocByIdlist(String id_udidoclist)
			throws BizException {
		UdidocHelperBp bizBp=new UdidocHelperBp();
		return bizBp.getUdidocByIdlist(id_udidoclist);
	}

	@Override
	public UdidocDO[] findByAttrValString(String key, String value) throws BizException {
		IUdidocRService service=ServiceFinder.find(IUdidocRService.class);
		UdidocDO[] udidocDOs = service.findByAttrValString(key, value);
		return udidocDOs;
	}
	
	

}
