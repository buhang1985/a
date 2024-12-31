package iih.ci.mr.s;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.i.IIpMrMaintainService;
import iih.ci.mr.s.bp.ipmr.IpMrSaveBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.service.constant.Binding;


@Service(serviceInterfaces={IIpMrMaintainService.class}, binding=Binding.JSONRPC)
public class IpMrMaintainServiceImpl implements IIpMrMaintainService{

	/** 病历产生电子文档
	 * @param lsImage
	 * @param ciMrDo
	 * @return
	 * @throws BizException
	 */
	public FArrayList2 engenderMrEleDoc(String[] lsImage,CiMrDO ciMrDo) throws BizException{	
		IpMrSaveBp bp=new IpMrSaveBp();
		return bp.engenderMrEleDoc(lsImage, ciMrDo);
	}
}
