package iih.mi.device.serializedata.ruralcooperinsure;

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
import xap.mw.coreitf.d.FDateTime;
import iih.mi.device.util.XmlUtilHelper;
import iih.valueobject.country.ruralcooperinsure.dto.d.ReferralInformationDTO;
import iih.valueobject.country.ruralcooperinsure.dto.d.ReferralSearchInfoDTO;
/**
 * 下载患者转诊单
 * @author LIM
 *
 */
public class ReferralDownLoadProc extends AbstractTransactProc {
    private ReferralSearchInfoDTO searchInfoDto;
    public ReferralDownLoadProc(ReferralSearchInfoDTO searchInfoDto)
    {
        this.paramCount = 4;
        //新农合平台调用方法名
        this.methodName = "downloadZZRecords";
        this.searchInfoDto = searchInfoDto;
    }
    @Override
    public List<Object> convertTOInputDataParam() throws BizException{
    	
        List<Object> lst = new ArrayList<Object>();
        //用户名
        lst.add(this.serviceContext.getUserName());
        //密码
        lst.add(this.serviceContext.getPassword());
        //invokeDate
        lst.add(new FDateTime());
        //hospCode 医院编码
        lst.add(this.serviceContext.getHospCode());
        //就医地编码
        lst.add(this.searchInfoDto.getJyareacode());
        //参合地编码
        lst.add(this.searchInfoDto.getChareacode());
        //转诊单号码
        lst.add(this.searchInfoDto.getReferralcode());
        //身份证号码
        lst.add(this.searchInfoDto.getIdcard());
        return lst;
    }
    @Override
    public Object convertToOutputDataParam(String strOutput) throws BizException, InstantiationException, IllegalAccessException {
		Document doc = XmlUtilHelper.readDocument(strOutput);
		// 获取根节点元素对象
		Element root = doc.getRootElement();
		Node node = root.selectSingleNode("/body");
        List<Node> bodyItems = node.selectNodes("bodyItem");
        String[] attributeStrings =new String[]{ "Referralcode", "Personcode", "Patname", "Dicode", "Applydate", "Applynote", "Agenciescode", "Hosfromcode", "Hosincode", "Referralstatus", "Auditdate", "Chareacode", "Diname", "Agenciesname", "Hosfromname", "Hosinname", "Auditorname", "Auditnote", "Chareaname", "Auditstatusname", "Idcard", "Idcardstore", "Medicalcode", "Medicalcodestore", "Dt_entry", "Sexcode", "Sexname", "Institucontactor", "Institucontactway", "Institumail", "Birthday", "Createtime", "Updatetime", "Drgs_code", "Drgs_name", "Patcontactor", "Patphone", "Civilassist_ident", "Graveassist_ident", "Familycode", "Hosin2code", "Hosin2name", "Hosin3code", "Hosin3name", "Accumulamt", "Bankaccount_name", "Bankaccount_no", "Bankname", "Paytp_code", "Paytp_name", "Chprovcode", "Chprovname", "Chcitycode", "Chcityname"};
        List<ReferralInformationDTO> lst=new ArrayList<ReferralInformationDTO>();
        for(Node item : bodyItems){
			Node node1 = item.selectSingleNode("data");
            ReferralInformationDTO referralInformationDto = SerializeUtil.deserialize(new ReferralInformationDTO(), (Element)node1, attributeStrings);           		
            lst.add(referralInformationDto);
        }
        return lst;
    }
}
