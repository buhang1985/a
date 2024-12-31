//package iih.ei.std.s.v1.bp.ci.thirdws.ip.base;
//
//import java.io.UnsupportedEncodingException;
//
//import org.dom4j.DocumentException;
//
//import iih.ci.ord.i.external.thirdws.ent.d.EntWsDTO;
//import iih.ci.ord.s.external.thirdws.base.EmsBaseManageBP;
//import iih.ci.ord.s.external.thirdws.base.IEmsSaveBP;
//import iih.ci.ord.s.external.thirdws.utils.LogUtils;
//import iih.ci.ord.s.external.thirdws.utils.RstMsgBP;
//import xap.mw.core.data.BizException;
//
//public class IpEmsBaseManageBP extends EmsBaseManageBP{
//	
//	public IpEmsBaseManageBP(){
//		super();
//	};
//	public IpEmsBaseManageBP(IEmsSaveBP emssavebp){
//		super(emssavebp);
//	}
//
//	@Override
//	public EntWsDTO pareXmlToDTO(String xmlStr) throws BizException, UnsupportedEncodingException, DocumentException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String save(String xmlStr) {
//		// TODO Auto-generated method stub
//		LogUtils.Logger(xmlStr);
//		try{
//			EntWsDTO entwsdto = this.pareXmlToDTO(xmlStr);
//			return this.getEmssavebp().save(entwsdto);
//		}catch(Exception e){
//			return RstMsgBP.getRstMsg("1", e.getMessage());
//		}
//	}
//	
//	
//
//}
