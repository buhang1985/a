package iih.bl.inc.Service.s;

import iih.bl.inc.blcpnin.d.BlCpnInDO;
import iih.bl.inc.bp.CpnInSaveBp;
import iih.bl.inc.ep.CpnInEp;
import iih.bl.inc.service.i.IBLIncMaintainService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

@Service(serviceInterfaces={IBLIncMaintainService.class}, binding=Binding.JSONRPC)
public class IBLIncMaintainServiceImpl implements IBLIncMaintainService {

	@Override
	public FBoolean inserBlCpnInInfo(BlCpnInDO blCpnInDO,Integer blCpnAddCodeLen) throws BizException {
		CpnInSaveBp bp=new  CpnInSaveBp();
	    return 	bp.execInsertBlCpnInInfo(blCpnInDO, blCpnAddCodeLen);
		
		//BlCpnIpDp blCpnIpDp = new BlCpnIpDp();
		//return blCpnIpDp.insertBlCpnInInfo(blCpnInDO, blCpnAddCodeLen);
	}

	@Override
	public FBoolean deleteBlCpnInInfo(BlCpnInDO blCpnInDO) throws BizException {
		CpnInEp ep =new  CpnInEp();
	return 	ep.deleteBlCpnInInfo(blCpnInDO) ;
		
	//	BlCpnIpDp blCpnIpDp = new BlCpnIpDp();
	//	return blCpnIpDp.deleteBlCpnInInfo(blCpnInDO);
	}

}
