package iih.ci.ord.s.external.thirdws.ip.apbu;

import java.io.UnsupportedEncodingException;
import org.dom4j.DocumentException;
import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.ip.base.IpEmsBaseManageBP;
import iih.ci.ord.s.external.thirdws.op.apbu.EmsApbuManageBP;
import xap.mw.core.data.BizException;

public class IpEmsApbuManageBP  extends IpEmsBaseManageBP{
	
	public IpEmsApbuManageBP() {
		super(new IpThirdEmsApBuSaveBP());
	}
	
	@Override
	public EntWsDTO pareXmlToDTO(String xmlStr) throws BizException, UnsupportedEncodingException, DocumentException {
		// TODO Auto-generated method stub
		return new EmsApbuManageBP().pareXmlToDTO(xmlStr);
	}    
}


