package iih.pi.reg.s.customer.guoji;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.params.PiParams;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.d.PiPatHpDO;

import java.io.InputStream;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 由CHIS建档(废弃)
 * @author hehuan
 *
 */
public class PiPatCreateByChisBP {
	
	//private final String WS_URL = "http://10.3.1.38:8080/hisgetdata.asmx?wsdl";
	
	/**
	 * 由CHIS建档
	 * @param patAgg
	 * @return
	 * @throws BizException
	 */
	public void exec(PatiAggDO patAgg) throws BizException{
		
		String sendData = this.aggDO2XML(patAgg);
		
		try {
			JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
			
			String url = new PiParams().PIPAT0006();
			if(StringUtil.isEmpty(url)){
				throw new BizException("请在参数设置中正确定义chis建档web服务地址");
			}
			
			Client client = dcf.createClient(url);
			Object[] objects = client.invoke("his_GetData", sendData);
			if(ArrayUtil.isEmpty(objects)){
				throw new BizException("CHIS建档失败，未取到返回值");
			}
			
			String responseXml = (String)objects[0];
			// test String responseXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><head><code>1</code><errorMsg>成功</errorMsg></head><body><output_param><P_ID>000107083900</P_ID><P_MZHAO0>0001070839</P_MZHAO0><P_ERRMSG>成功</P_ERRMSG></output_param></body></root>";
			String[] strs = this.getResponse(responseXml);
			
			//回写患者编码及chis码
			PatDO pat = patAgg.getParentDO();
			pat.setCode(strs[0]);
			pat.setMnecode(pat.getCode());
			pat.setBarcode_chis(strs[1]);
			
		} catch (Exception e) {
			throw new BizException(e);
		}
	}
	
	/**
	 * 转换aggdo为xml格式
	 * @param patAgg
	 * @return
	 * @throws BizException
	 */
	private String aggDO2XML(PatiAggDO patAgg) throws BizException{
		SAXReader reader = new SAXReader();
		PatDO pat = patAgg.getParentDO();
		try {
			//InputStream in = PiPatCreateByChisBP.class.getResourceAsStream("/iih/pi/reg/s/customer/guoji/hisgetdatatmpl.xml");
			InputStream in = PiPatCreateByChisBP.class.getResourceAsStream("hisgetdatatmpl.xml");
	        Document doc = reader.read(in);  
			Element ip = doc.getRootElement().element("body").element("input_param");
			//ip.element("P_ZDBH00").setText(wrapEmpty(this.getPsnCode()));//终端编号（操作员号5位）
			ip.element("P_FZXBH0").setText("");//参保机构代码
			ip.element("P_CARDNO").setText(wrapEmpty(this.getCardNo(patAgg)));//病人卡号
			ip.element("P_ID0000").setText(wrapEmpty(this.getHpNo(patAgg)));//保险编号
			//ip.element("P_CARDNO").setText(wrapEmpty(this.getHpNo(patAgg)));//病人卡号
			ip.element("P_CARDTYPE").setText(wrapEmpty(pat.getSd_idtp()));//证件类型
			ip.element("P_SFZHAO").setText(wrapEmpty(pat.getId_code()));//证件号码
			ip.element("P_XMING0").setText(wrapEmpty(pat.getName()));//姓名
			ip.element("P_XBIE00").setText(wrapEmpty(pat.getSd_sex()));//性别
			ip.element("P_BRNL00").setText("");//病人年龄
			ip.element("P_RYLB00").setText("");//人员类别(工作状态)
			ip.element("P_CSRQ00").setText(wrapEmpty(getBirthDate(pat)));//出生日期
			ip.element("P_FZXMC0").setText("");//分中心名称
			ip.element("P_GZDWMC").setText(wrapEmpty(pat.getWorkunit()));//工作单位
			ip.element("P_GRZHYE").setText("0");
			ip.element("P_LXDH00").setText(wrapEmpty(pat.getMob()));
			ip.element("P_BYRC00").setText("");//备用入参
			
			PatiAddrDO addrDo = this.getAddrDo(patAgg);
			if(addrDo != null){
				ip.element("temp_district").setText(wrapEmpty(addrDo.getSd_admdiv()));//区域码
				ip.element("temp_street").setText(wrapEmpty(addrDo.getStreet()));//街道地址
			}
			return doc.asXML();
		}
		catch (DocumentException e) {
			throw new BizException("CHIS建档服务：构建xml失败。"+e.getMessage());
		}
	}
	
	/**
	 * 获取返回值
	 * @param response
	 * @return 病人id,病人门诊号
	 */
	private String[] getResponse(String response) throws BizException{
		try {
			Document doc = DocumentHelper.parseText(response);
			Element hd = doc.getRootElement().element("head");
			String state = hd.elementText("code");
			String msg = hd.elementText("errorMsg");
			if("-1".equals(state)){
				throw new BizException("CHIS建档失败，原因: " + msg);
			}
			
			//解析返回值
			Element op = doc.getRootElement().element("body").element("output_param");
			return new String[]{op.elementText("P_ID"),op.elementText("P_MZHAO0")} ;
		}
		catch (DocumentException e) {
			throw new BizException("CHIS建档服务：解析返回值xml失败");
		}
	}
	
	/**
	 * null转empty
	 * @param s
	 * @return
	 */
	private String wrapEmpty(String s) {
		return s == null ? "" : s;
	}
	
	/**
	 * 获取人员编码
	 * @return
	 */
	@SuppressWarnings("unused")
	private String getPsnCode() {
		DAFacade da = new DAFacade();
		SqlParam sp = new SqlParam();
		sp.addParam(Context.get().getStuffId());
		try {
			String sql = "select code from bd_psndoc where id_psndoc = ?";
			String code = (String)da.execQuery(sql, sp, new ColumnHandler());
			if(!StringUtil.isEmpty(code) && code.length() > 5){
				code = code.substring(0, 5);
			}
			return code;
		}
		catch (DAException e) {
			return "";
		}
	}
	
	/**
	 * 获取就诊卡号
	 * @param patAgg
	 * @return
	 */
	private String getCardNo(PatiAggDO patAgg) {
		PiPatCardDO[] cards = patAgg.getPiPatCardDO();
		if (ArrayUtil.isEmpty(cards)) 
			return "";
		for (PiPatCardDO card : cards) {
			if (IPiDictCodeConst.SD_CARD_TYPE_TREATMENT.equals(card.getSd_patcardtp_udi())) {
				return card.getCode();
			}
		}
		return "";
	}	
	
	/**
	 * 获取医保号
	 * @param patAgg
	 * @return
	 */
	private String getHpNo(PatiAggDO patAgg) {
		PiPatHpDO[] hps = patAgg.getPiPatHpDO();
		if (ArrayUtil.isEmpty(hps)) 
			return "";
		for (PiPatHpDO hp : hps) {
			if (FBoolean.TRUE.equals(hp.getFg_deft())){
				return hp.getNo_hp();
			}
		}
		return hps[0].getNo_hp();		
	}
	
	/**
	 * format出生日期
	 * @param pat
	 * @return
	 */
	private String getBirthDate(PatDO pat) {
		return pat.getDt_birth().toString().replace("-", "");
	}
	
	/**
	 * 获得现住址
	 * @param patAgg
	 * @return
	 */
	private PatiAddrDO getAddrDo(PatiAggDO patAgg) {
		PatiAddrDO[] addrs = patAgg.getPatiAddrDO();
		if (ArrayUtil.isEmpty(addrs)) 
			return null;
		for (PatiAddrDO addr : addrs) {
			if (IPiDictCodeConst.SD_ADDR_TYPE_NOW.equals(addr.getSd_addrtp())) {
				return addr;
			}
		}
		return null;
	}
}
