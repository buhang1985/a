package iih.mi.device.serializedata.ruralcooperinsure;

import iih.mi.device.util.XmlUtilHelper;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpPayItemResultDTO;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpPayReqParamDTO;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpPayResultDTO;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;
/**
 * 医保结算确认
 * @author LIM
 *
 */
public class InpPayProc extends AbstractTransactProc {
    private InpPayReqParamDTO inpPayReqParamDto;

    public InpPayProc(InpPayReqParamDTO inpPayReqParamDto)
    {
        this.inpPayReqParamDto = inpPayReqParamDto;
        //webservice调用的方法名
        this.methodName = "inpPay";
        this.paramCount =11;
    }
	@Override
	public List<Object> convertTOInputDataParam() throws BizException {
        List<Object> param=new ArrayList<Object>();
        param.add(this.serviceContext.getUserName());
        param.add(this.serviceContext.getPassword());
        param.add((new FDateTime()).toString());
        param.add(this.serviceContext.getHospCode());
        param.add(inpPayReqParamDto.getChareacode());
        param.add(inpPayReqParamDto.getInpno());
        param.add(inpPayReqParamDto.getOperator());
        param.add(inpPayReqParamDto.getRedeemdate());
        param.add(inpPayReqParamDto.getRedeemorgno());
        param.add(inpPayReqParamDto.getPreinppayid());
        return param;
	}

	@Override
	public Object convertToOutputDataParam(String strOutput)
			throws BizException, InstantiationException, IllegalAccessException {
        String[] attributeStrings = new String[] { "Billcode", "Inpno", "Hospcode", "Hospname", "Hosplevelcode", "Hosplevelname", "Chareacode", "Chareaname", "Personcode", "Patname", "Idcard", "Phone", "Sexcode", "Sexname", "Medicalcode", "Enttpcode", "Enttpname", "Householder", "Familyaddress", "Ent_code", "Dt_entry", "Dt_end", "Maindicode", "Maindiname", "Surgerycode", "Surgeryname", "Agenciescode", "Agenciesname", "Amt_all", "Amt_pat", "Hp_amtallactual", "Hppolicy", "Hp_amtall", "Drgsamt", "Bigill_amt", "Bigill_amtactual", "Civilamt", "Hp_ratio", "Accumamt_year", "Times", "Lower_amt", "Top_amt", "Note", "Stunitcode", "Stunitname", "Amtall_deduc", "Reason_deduc", "Amt_advance"};
		Document doc = XmlUtilHelper.readDocument(strOutput);
		// 获取根节点元素对象
		Element root = doc.getRootElement();
		Node node = root.selectSingleNode("/body");
        Node dataNode = node.selectSingleNode("data");
        Node n708Node = dataNode.selectSingleNode("N708");
        InpPayResultDTO preInpPayResultDto = SerializeUtil.deserialize(new InpPayResultDTO(),(Element)n708Node,
            attributeStrings);

        FArrayList arrayList = new FArrayList();
        Node n709sNode = dataNode.selectSingleNode("N709S");
        if (n709sNode != null){
            List<Node> nodeList = n709sNode.selectNodes("N709");
            if (nodeList != null){
                for(Node item : nodeList){
                    InpPayItemResultDTO itemResultDto = SerializeUtil.deserialize(new InpPayItemResultDTO(),(Element)item,
                        new InpPayItemResultDTO().getAttrNames());
                    arrayList.add(itemResultDto);
                }
            }
        }
        preInpPayResultDto.setBillitems(arrayList);
        return preInpPayResultDto;
	}

}
