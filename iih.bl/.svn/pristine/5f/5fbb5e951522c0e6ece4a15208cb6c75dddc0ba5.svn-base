package iih.bl.cg.s;

import pkuhit.jspt.webservice.IJsInfoWebService;
import iih.bl.cg.bp.Get4CmlInsToXmlBP;
import iih.bl.cg.bp.Read4CmlinsBP;
import iih.bl.cg.i.IBlCgTestService;
import xap.mw.core.annotation.Reference;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces={IBlCgTestService.class}, binding=Binding.JSONRPC)
public class BlCgTestServiceImpl  implements IBlCgTestService{

	@Reference(binding = Binding.WS)
	IJsInfoWebService infoService;
	@Override
	public void testInXML() throws BizException {
//		Get4CmlInsToXmlBP xmlBP=new Get4CmlInsToXmlBP();
//		xmlBP.exec(new String[]{"246"}, "000125598600", "FZRS");
		
		Read4CmlinsBP read=new Read4CmlinsBP();                                                     
		read.exec(infoService);
		

	}
}
