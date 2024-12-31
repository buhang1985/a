package iih.bl.cg.bp.self;

import iih.bl.hp.divideresult.d.DivideResultDTO;
import iih.bl.hp.divideresult.d.FeeBreakDTO;
import iih.bl.hp.divideresult.d.MediCatalog1DTO;
import iih.bl.hp.divideresult.d.MediCatalog2DTO;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.sys.message.notice.d.priorityenum;

/**
 * 获取医保分解DTO
 * 
 * @author LIM
 *
 */
public class DivideResultByXmlBp {

	public DivideResultDTO exec(String xmlStr) throws BizException {
		SAXReader reader = new SAXReader();
		Document doc = null;
		try {
			if (xmlStr.toLowerCase().indexOf("utf-16")>0){
				xmlStr =xmlStr.replaceFirst("encoding[a-zA-Z0-9\"-=]{1,}","encoding=\"UTF-8\"");
				doc = reader.read(new ByteArrayInputStream(xmlStr.getBytes()));
			}else{
				try {				
					doc = reader.read(new ByteArrayInputStream(xmlStr.getBytes("UTF-8")));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 获取根节点元素对象
		Element root = doc.getRootElement();
		Node node = root.selectSingleNode("/root");
		boolean bRet = this.CheckOutputState(node);
		DivideResultDTO fy = new DivideResultDTO();
		if (bRet) {
			Node no = node.selectSingleNode("output/tradeinfo");

			fy.setTradeno(getNodeValue(no, "tradeno"));
			fy.setFeeno(getNodeValue(no, "feeno"));
			fy.setTradedate(getDateTime(getNodeValue(no, "tradedate")));

			no = node.selectSingleNode("output/feeitemarray");
			List<Node> feeitems = node.selectNodes("feeitem");
			fy.setFeebreaks(new FArrayList());
			for (Node noFee : feeitems) {
				FeeBreakDTO f = new FeeBreakDTO();

				f.setItemno(noFee.valueOf("@itemno"));
				f.setRecipeno(noFee.valueOf("recipeno"));
				f.setHisitemcode(noFee.valueOf("hiscode"));
				f.setItemcode(noFee.valueOf("itemcode"));
				f.setItemname(noFee.valueOf("itemname"));
				f.setItemtype(noFee.valueOf("itemtype"));
				f.setUnitprice(new FDouble(noFee.valueOf("unitprice")));
				f.setCount(new FDouble(noFee.valueOf("count")));
				f.setFee(new FDouble(noFee.valueOf("fee")));
				f.setFeein(new FDouble(noFee.valueOf("feein")));
				f.setFeeout(new FDouble(noFee.valueOf("feeout")));
				f.setSelfpay2(new FDouble(noFee.valueOf("selfpay2")));
				f.setState(noFee.valueOf("state"));
				f.setFee_type(noFee.valueOf("fee_type"));

				String scale = noFee.valueOf("preferentialscale");
				String fee = noFee.valueOf("preferentialfee");
				f.setPreferentialfee(fee == null ? new FDouble(fee) : FDouble.ZERO_DBL);
				f.setPreferentialscale(scale == null ? new FDouble(scale) : FDouble.ZERO_DBL);
				fy.getFeebreaks().add(f);
			}
			no = node.selectSingleNode("output/sumpay");
			fy.setFeeall(new FDouble(no.valueOf("feeall")));
			fy.setFund(new FDouble(no.valueOf("fund")));
			fy.setCash(new FDouble(no.valueOf("cash")));
			fy.setAccpay(new FDouble(no.valueOf("personcountpay")));
			fy.setBalance(new FDouble(no.valueOf("personcount")));

			no = node.selectSingleNode("output/payinfo");
			fy.setMzfee(new FDouble(no.valueOf("mzfee")));
			fy.setMzfeein(new FDouble(no.valueOf("mzfeein")));
			fy.setMzfeeout(new FDouble(no.valueOf("mzfeeout")));
			fy.setMzpayfirst(new FDouble(no.valueOf("mzpayfirst")));
			fy.setMzselfpay2(new FDouble(no.valueOf("mzselfpay2")));
			fy.setMzbigpay(new FDouble(no.valueOf("mzbigpay")));
			fy.setMzbigselfpay(new FDouble(no.valueOf("mzbigselfpay")));
			fy.setMzoutofbig(new FDouble(no.valueOf("mzoutofbig")));
			fy.setBcpay(new FDouble(no.valueOf("bcpay")));
			fy.setJcbz(new FDouble(no.valueOf("jcbz")));

			no = node.selectSingleNode("output/medicatalog");
			MediCatalog1DTO cata1 = new MediCatalog1DTO();

			cata1.setMedicine(new FDouble(no.valueOf("medicine")));
			cata1.setTmedicine(new FDouble(no.valueOf("tmedicine")));
			cata1.setTherb(new FDouble(no.valueOf("therb")));
			cata1.setLabexam(new FDouble(no.valueOf("labexam")));
			cata1.setXray(new FDouble(no.valueOf("xray")));
			cata1.setUltrasonic(new FDouble(no.valueOf("ultrasonic")));
			cata1.setCt(new FDouble(no.valueOf("ct")));
			cata1.setMri(new FDouble(no.valueOf("mri")));
			cata1.setExamine(new FDouble(no.valueOf("examine")));
			cata1.setTreatment(new FDouble(no.valueOf("treatment")));
			cata1.setMaterial(new FDouble(no.valueOf("material")));
			cata1.setOperation(new FDouble(no.valueOf("operation")));
			cata1.setOxygen(new FDouble(no.valueOf("oxygen")));
			cata1.setBloodt(new FDouble(no.valueOf("bloodt")));
			cata1.setOrthodontics(new FDouble(no.valueOf("orthodontics")));
			cata1.setProsthesis(new FDouble(no.valueOf("prosthesis")));
			cata1.setForensic(new FDouble(no.valueOf("forensic_expertise")));
			cata1.setOther(new FDouble(no.valueOf("other")));
			FArrayList catalog1 = new FArrayList();
			catalog1.add(cata1);
			fy.setCatalog1(catalog1);

			no = node.selectSingleNode("output/medicatalog2");
			MediCatalog2DTO cata2 = new MediCatalog2DTO();

			cata2.setDiagnosis(new FDouble(no.valueOf("diagnosis")));
			cata2.setExamine(new FDouble(no.valueOf("examine")));
			cata2.setLabexam(new FDouble(no.valueOf("labexam")));
			cata2.setTreatment(new FDouble(no.valueOf("treatment")));
			cata2.setOperation(new FDouble(no.valueOf("operation")));
			cata2.setMaterial(new FDouble(no.valueOf("material")));
			cata2.setMedicine(new FDouble(no.valueOf("medicine")));
			cata2.setTherb(new FDouble(no.valueOf("therb")));
			cata2.setTmedicine(new FDouble(no.valueOf("tmedicine")));
			cata2.setMedicalservice(new FDouble(no.valueOf("medicalservice")));
			cata2.setCommonservice(new FDouble(no.valueOf("commonservice")));
			cata2.setRegistfee(new FDouble(no.valueOf("registfee")));
			cata2.setOther(new FDouble(no.valueOf("otheropfee")));

			FArrayList catalog2 = new FArrayList();
			catalog2.add(cata2);
			fy.setCatalog2(catalog2);
		}
		return fy;
	}

	private FDateTime getDateTime(String dtStr) {
		String fDt = dtStr.substring(0, 4) + "-" + dtStr.substring(4, 6) + "-" + dtStr.substring(6, 8) + " " + dtStr.substring(8, 10) + ":" + dtStr.substring(10, 12) + ":" + dtStr.substring(12, 14);
		return new FDateTime(fDt);
	}

	/**
	 * 判断返回的消息
	 * 
	 * @param xmlDoc
	 * @return
	 */
	private boolean CheckOutputState(Node node) {
		// StringBuilder err=new StringBuilder();
		String msg;
		Node no = node.selectSingleNode("state");
		msg = no.valueOf("@success");
		if ((msg).equals("true")) {
			return true;
		} else {
			return false;
		}
		// Node no= node.selectSingleNode("state");

		// err.append(getNodeValue(no,"success"));
		// List<Node> errNodeList= node.selectNodes("state/error");
		// for(Node no:errNodeList)
		// {
		// err.append(no.valueOf("@info"));
		// }
		// List<Node> warNodeList= node.selectNodes("state/warning");
		// for(Node no:warNodeList)
		// {
		// err.append(no.valueOf("@info"));
		// }
		// return err.toString()==null?true:false;
		// return true;
	}

	/**
	 * 获取xml节点值
	 * 
	 * @param node
	 * @param name
	 * @return
	 */
	public String getNodeValue(Node node, String name) {
		Node no = node.selectSingleNode(name);
		return no.getText();
	}
}
