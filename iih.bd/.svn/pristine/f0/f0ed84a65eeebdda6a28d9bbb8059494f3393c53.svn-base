package iih.bd.res.workstation.s;

import iih.bd.res.workstation.i.IHostRegService;
import iih.bd.res.workstation.s.bp.HostRegBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { IHostRegService.class }, binding = Binding.JSONRPC)
public class HostRegServiceImpl implements IHostRegService {

	@Override
	public boolean HostReg(String hostId, String hostName, String ip_Addr, String desc, String osName, String memInfo,
			String macAddr) throws BizException {
		HostRegBp bp = new HostRegBp();
		return bp.exec(hostId, hostName, ip_Addr, desc, osName, memInfo,macAddr);
	}
}
