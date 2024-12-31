package iih.mi.device.serializedata.ruralcooperinsure;

import iih.mi.constant.IMiDeviceConst;
import iih.mi.device.util.XmlUtilHelper;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
/**
 * 处方明细撤销
 * @author LIM
 *
 */
public class ClearInpDetailProc extends AbstractTransactProc{
	//参合地区编码
	private String strAreaCode;
	//待撤销的处方明细
	private String[] strCgItemCodes;
	//住院登记流水号
	private String strInpRegisterNo;
    public ClearInpDetailProc(String strAreaCode,String strInpRegisterNo,String[] strCgItemCodes){
        //参合地区编码
        this.strAreaCode = strAreaCode;
        //记账明细编码
        this.strCgItemCodes = strCgItemCodes;
        //住院登记流水号
        this.strInpRegisterNo = strInpRegisterNo;
        //待调用方法名称
        this.methodName = "clearInpDetails";
    }	
	@Override
	public List<Object> convertTOInputDataParam() throws BizException {
        List<Object> lst=new ArrayList<Object>();
        lst.add(this.serviceContext.getUserName());
        lst.add(this.serviceContext.getPassword());
        lst.add((new FDateTime()).toString());
        lst.add(this.serviceContext.getHospCode());
        lst.add(strAreaCode);
        byte[] bytInpdetails = createXmlInParam();
        lst.add(bytInpdetails);
        return lst;
	}

	@Override
	public Object convertToOutputDataParam(String strOutput)
			throws BizException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		return null;
	}
    private byte[] createXmlInParam(){
        Document inXML = DocumentHelper.createDocument();
        XmlUtilHelper.setElement(inXML, "NDEML","","templateVersion","1.0");
        XmlUtilHelper.setElement(inXML, "header", "");
        XmlUtilHelper.setElement(inXML, "exportDate", (new FDateTime()).toString());
        XmlUtilHelper.setElement(inXML, "dataType", "N707");
        
        //数据来源
        XmlUtilHelper.setElement(inXML, "sourceCode", IMiDeviceConst.RURALCOOPER_SOURCECODE_NAME_HOSPTIAL,"ref",this.serviceContext.getHospCode());
        //平台
        XmlUtilHelper.setElement(inXML, "targetCode", IMiDeviceConst.RURALCOOPER_TARGETCODE_NAME,"ref",IMiDeviceConst.RURALCOOPER_TARGETCODE_CODE);
        //数据来源类型,1：省平台上传；2、区县平台上传；3、医院上传；4、其他来源上传 
        XmlUtilHelper.setElement(inXML, "sourceType", IMiDeviceConst.RURALCOOPER_SOURCETYPE_NAME_HOSPTIAL,"ref",IMiDeviceConst.RURALCOOPER_SOURCETYPE_CODE_HOSPTIAL);
        XmlUtilHelper.setElement(inXML, "body", "");
        XmlUtilHelper.setElement(inXML, "bodyItem", "","itemId",strInpRegisterNo);
        
        
        
        //        Element root = inXML.addElement("NDEML");
//        root.addAttribute("templateVersion", "1.0");
//        Node header = inXML.addElement("header");
//
//        Element xmlExportDateElement = inXML.addElement("exportDate");
//        xmlExportDateElement.addText((new FDateTime()).toString());

//        Element xmlDatatypeElement = inXML.addElement("dataType");
//        xmlDatatypeElement.addText("N707");

//        Element xmlsourceCodeElement = inXML.addElement("sourceCode");
//        xmlsourceCodeElement.addText( "郑州中医骨伤医院");
//        xmlsourceCodeElement.addAttribute("ref", this.serviceContext.getHospCode());
//
//        Element xmltargetCodeElement = inXML.addElement("targetCode");
//        xmltargetCodeElement.addText( "国家平台");
//        xmltargetCodeElement.addAttribute("ref", "00");
//
//        //数据来源类型,1：省平台上传；2、区县平台上传；3、医院上传；4、其他来源上传
//        Element xmlSourceTypeElement = inXML.addElement("sourceType");
//        xmlSourceTypeElement.addAttribute("ref", "1");
//        xmlSourceTypeElement.addText( "医院上传");


        //body字段解析
//        Node body = inXML.addElement("body");
//
//        Element bodyItemNode = inXML.addElement("bodyItem");
//        bodyItemNode.addAttribute("itemId",strInpRegisterNo);


        //取消明细上传模式制定
        Element cancelModeElement = inXML.addElement("cancelMode");
        //0表示部分撤退，1表示撤销该患者本次住院所有上传的费用明细，data中可无内容


        //数据data模块
//        Element dataElement = inXML.addElement("data");
        XmlUtilHelper.setElement(inXML, "data", "");
        //扩展数据，备用，暂时没内容
//        Element extendDataElement = inXML.addElement("extendData");
        XmlUtilHelper.setElement(inXML, "extendData", "");

        if (strCgItemCodes == null || strCgItemCodes.length<=0){
            //全部取消
            cancelModeElement.addText( "1");                
        }
        else
        {
            //部分取消
            cancelModeElement.addText( "0");
            for (int i = 0; i < strCgItemCodes.length; i++)
            {
                Element element = inXML.addElement("N707-02");
                element.addText( strCgItemCodes[i]);
            }
        }
        return inXML.toString().getBytes();
    }
}
