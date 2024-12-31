package iih.bd.pp.mmprice.s;

import iih.bd.pp.mmprice.bp.MMPriceBp;
import iih.bd.pp.mmprice.d.PriSrvRelMMDTO;
import iih.bd.pp.mmprice.i.IMMPriceService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces={IMMPriceService.class}, binding=Binding.JSONRPC)
public class IMMPriceServiceImpl implements IMMPriceService {

	@Override
	public PriSrvRelMMDTO[] GetDTOsByIDSrv(String id_srv) throws BizException {
		MMPriceBp bp=new MMPriceBp();
		return bp.GetDTOsByIDSrv(id_srv);
	}
}
