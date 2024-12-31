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
import iih.valueobject.country.ruralcooperinsure.dto.d.InpRegisterInfoDTO;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpRegisterSeekReqDTO;
/**
 * 住院登记信息查询
 * @author LIM
 *
 */
public class InpRegisterSeekProc extends AbstractTransactProc {
    private InpRegisterSeekReqDTO inpRegisterSeekReqDto;

    public InpRegisterSeekProc(InpRegisterSeekReqDTO inpRegisterSeekReqDto){
        this.inpRegisterSeekReqDto = inpRegisterSeekReqDto;
        this.methodName = "inpRegisterSeek";
        this.paramCount = 7;
    }
    
    @Override
    public List<Object> convertTOInputDataParam(){
        List<Object> lst=new ArrayList<Object>();
        lst.add(this.serviceContext.getUserName());
        lst.add(this.serviceContext.getPassword());
        lst.add((new FDateTime()).toString());
        lst.add(this.inpRegisterSeekReqDto.getAreacode());
        lst.add(this.serviceContext.getHospCode());
        lst.add(this.inpRegisterSeekReqDto.getMembercode());
        lst.add(this.inpRegisterSeekReqDto.getEnt_code());
        return lst;
    }
    @Override
    public Object convertToOutputDataParam(String strOutput) throws BizException, InstantiationException, IllegalAccessException{
		SAXReader reader = new SAXReader();
		Document doc = XmlUtilHelper.readDocument(strOutput);
		// 获取根节点元素对象
		Element root = doc.getRootElement();
		Node node = root.selectSingleNode("/body");
        Node dataNode = node.selectSingleNode("data");
        //如果没有该节点则查询出数据为空
        if (dataNode == null)
            return null;
        InpRegisterInfoDTO inpRegisterInfoDto = SerializeUtil.deserialize(new InpRegisterInfoDTO(), (Element)dataNode,
            new InpRegisterInfoDTO().getAttrNames());
        return inpRegisterInfoDto;
    }
}
