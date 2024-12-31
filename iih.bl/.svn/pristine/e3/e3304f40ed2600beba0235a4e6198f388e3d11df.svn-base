package iih.bl.cg.bp.self;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import iih.bd.pp.hp.d.BdHpKindDO;
import iih.bd.pp.hp.d.BdHpPatcaDO;
import iih.bd.pp.hp.i.IBdHpKindDORService;
import iih.bd.pp.hp.i.IBdHpPatcaDORService;
import iih.bl.hp.insurecard.d.CardPersonInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取医保卡信息DTO 
 * @author yang.lu
 *
 */
public class GetCardPersonByXmlBP {

	public CardPersonInfoDTO exec(String xmlStr) throws BizException {
		
		SAXReader reader= new SAXReader();
		Document doc=  null;
		try {
			try {
				doc = reader.read(new ByteArrayInputStream(xmlStr.getBytes("UTF-16")) );
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//获取根节点元素对象
		Element root =doc.getRootElement();	
		Node node = root.selectSingleNode("/root ");
        boolean bRet = this.CheckOutputState(node);
        CardPersonInfoDTO info = new CardPersonInfoDTO();
        
        if (bRet){
        	Node no= node.selectSingleNode("output/ic");
        	info.setIc_code(getNodeValue(no,"ic_no"));
        	info.setCard_code(getNodeValue(no,"card_no"));
        	info.setId_no(getNodeValue(no,"id_no"));
        	info.setPersonname(getNodeValue(no,"personname"));
        	info.setSex(getNodeValue(no,"sex"));
        	info.setBirthday(getDateTime(getNodeValue(no,"birthday")));

        	info.setFromhosp(getNodeValue(no,"fromhosp"));
        	info.setFromhospdate(getNodeValue(no,"fromhospdate"));
        	info.setFundtype(getNodeValue(no,"fundtype"));
        	info.setId_fundtype(GetKindId(info.getFundtype()));
        	info.setIsyt(getNodeValue(no,"isyt"));
        	info.setJclevel(getNodeValue(no,"jclevel"));
        	info.setHospflag(getNodeValue(no,"hospflag"));

        	Node netNo= node.selectSingleNode("output/net");

        	info.setPersontype(getNodeValue(netNo,"persontype"));
        	info.setId_persontype(GetPatcaId(info.getPersontype()));
        	info.setIsinredlist(getNodeValue(netNo,"isinredlist"));
        	info.setIsspecifiedhosp(getNodeValue(netNo,"isspecifiedhosp"));
        	info.setIschronichosp(getNodeValue(netNo,"ischronichosp"));
        	info.setChroniccode(getNodeValue(netNo,"chroniccode"));
        	info.setPersoncount(getNodeValue(netNo,"personcount"));
        	
        }
        return info;
        
	}

	private FDateTime getDateTime(String dtStr){
		String fDt=dtStr.substring(0, 4)+"-"+
				dtStr.substring(4, 6)+"-"+
				dtStr.substring(6, 8)+" 00:00:00";
		return new FDateTime(fDt);
	}
	
	/**
	 * 通过险种code获取险种编号
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private String GetKindId(String code) throws BizException
	{
		IBdHpKindDORService service=ServiceFinder.find(IBdHpKindDORService.class);
		BdHpKindDO[] hpKindDOs= service.findByAttrValString(BdHpKindDO.CODE_HPKIND, code);
		if(hpKindDOs.length>0){
			return hpKindDOs[0].getId_hpkind();
		}
		return "";
	}
	
	/**
	 * 通过医保身份code获取医保身份编号
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private String GetPatcaId(String code) throws BizException
	{
		IBdHpPatcaDORService service=ServiceFinder.find(IBdHpPatcaDORService.class);
		BdHpPatcaDO[] hpPatcaDO= service.findByAttrValString(BdHpPatcaDO.CODE_HPPATCA, code);
		if(hpPatcaDO.length>0){
			return hpPatcaDO[0].getId_hppatca();
		}
		return "";
	}
	
	
	
	/**
	 * 判断返回的消息
	 * @param xmlDoc
	 * @return
	 */
	private boolean CheckOutputState(Node node){		
//		StringBuilder err=new StringBuilder();
		String msg;
        Node no= node.selectSingleNode("state");
        msg=no.valueOf("@success");	
        if((msg).equals("true")){
        	return true;
        }
        return false;
	}
	/**
	 * 获取xml节点值
	 * @param node
	 * @param name
	 * @return
	 */
	   private String getNodeValue(Node node,String name)
	   {
		   Node no= node.selectSingleNode(name);
		   return no.getText();
	   }
}
