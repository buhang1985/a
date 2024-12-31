package iih.ci.ord.s.ie;


import iih.ci.ord.i.ie.ICiIEMainService;
import iih.ci.ord.iemsg.d.IELisQryInDTO;
import iih.ci.ord.iemsg.d.IELisQryOutDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.ip.client.FuncClient;
import xap.ip.client.FuncClientFactory;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;

@Service(serviceInterfaces = { ICiIEMainService.class }, binding = Binding.JSONRPC)
public class CiIEMainServiceImpl implements ICiIEMainService {

	@Override
	public IELisQryOutDTO ieLisQry(FArrayList inDtos) throws BizException {
		
		IELisQryInDTO inDto = new IELisQryInDTO();
		inDto.setCreate_time(CiOrdAppUtils.getServerDateTime());
		inDto.setItems(inDtos);
		FuncClientFactory clientFactory = ServiceFinder.find(FuncClientFactory.class);
		FuncClient client = clientFactory.createClientByDomain("BS013", "01");
		FArrayList2 list = (FArrayList2)client.invoke(inDto);
		IELisQryOutDTO rt = (IELisQryOutDTO)list.get(0);
		return rt;
	}
	
}
