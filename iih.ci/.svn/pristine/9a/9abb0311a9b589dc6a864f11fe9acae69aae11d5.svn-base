package iih.ci.ord.s.external.thirdws.ip.apbt;

import java.io.UnsupportedEncodingException;

import org.dom4j.DocumentException;

import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
import iih.ci.ord.s.external.thirdws.ip.base.IpEmsBaseManageBP;
import iih.ci.ord.s.external.thirdws.op.apbt.EmsApbtManageBP;
import xap.mw.core.data.BizException;

public class IpEmsApbtManageBP extends IpEmsBaseManageBP{

	public IpEmsApbtManageBP() {
		super(new IpThirdEmsApBtSaveBP());
	}
	@Override
	public EntWsDTO pareXmlToDTO(String xmlStr) throws BizException, UnsupportedEncodingException, DocumentException {
		// TODO Auto-generated method stub
		return new EmsApbtManageBP().pareXmlToDTO(xmlStr);
	}    
}
