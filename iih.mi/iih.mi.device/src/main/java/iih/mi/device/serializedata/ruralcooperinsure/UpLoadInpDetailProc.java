package iih.mi.device.serializedata.ruralcooperinsure;

import iih.mi.constant.IMiDeviceConst;
import iih.mi.device.util.XmlUtilHelper;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpDetailUpLoadDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
/**
 * 住院处方明细上传
 * @author LIM
 *
 */
public class UpLoadInpDetailProc extends AbstractTransactProc {
    private String strAreaCode;
    private List<InpDetailUpLoadDTO> inpDetailUpLoadDtos;
    public UpLoadInpDetailProc(String strAreaCode,List<InpDetailUpLoadDTO> lst){
        this.inpDetailUpLoadDtos = lst;
        this.strAreaCode = strAreaCode;
        this.methodName = "uploadInpDetails";
    }
	@Override
	public List<Object> convertTOInputDataParam() throws BizException {
        List<Object> param=new ArrayList<Object>();
        param.add(this.serviceContext.getUserName());
        param.add(this.serviceContext.getPassword());
        param.add((new FDateTime()).toString());
        param.add(strAreaCode);
        param.add(this.serviceContext.getHospCode());
        byte[] inpDetails = createXmlInParam();
        param.add(inpDetails);
        return param;
	}
	@Override
	public Object convertToOutputDataParam(String strOutput)
			throws BizException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		return null;
	}
    private byte[] createXmlInParam()
    {
        Document inXML =DocumentHelper.createDocument();
        
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
        //拼装inpDetails
        //1、按住院流水号分组
        HashMap<String,List<InpDetailUpLoadDTO>> groupsMap = new HashMap<String,List<InpDetailUpLoadDTO>>() ;
        groupsMap=getMap();
        for (String key : groupsMap.keySet()){
        	//按住院流水号分组
        	XmlUtilHelper.setElement(inXML, "bodyItem", "","itemId",key);            
            //拼装Data数据源
        	XmlUtilHelper.setElement(inXML, "data", "");
            //扩展数据，备用的
        	XmlUtilHelper.setElement(inXML, "extendData", "");
            //分组后的处方明细
            List<InpDetailUpLoadDTO> lst = groupsMap.get(key);
            for (InpDetailUpLoadDTO inpDetail : lst){
                XmlUtilHelper.setElement(inXML, "N707", "");
                //住院处方流水号
                XmlUtilHelper.setElement(inXML, "N707-01", inpDetail.getPresno());
                //项目序号（费用明细 HIS 系统唯一标识） 
                XmlUtilHelper.setElement(inXML, "N707-02", inpDetail.getItemno());

                XmlUtilHelper.setElement(inXML, "N707-03", inpDetail.getFeetp_code());

                XmlUtilHelper.setElement(inXML, "N707-04", inpDetail.getFeetp_name());
                XmlUtilHelper.setElement(inXML, "N707-05", inpDetail.getHisitemcode());

                XmlUtilHelper.setElement(inXML, "N707-06", inpDetail.getHisitemname());

                //剂型
                XmlUtilHelper.setElement(inXML, "N707-07", inpDetail.getDose());
                //规格
                XmlUtilHelper.setElement(inXML, "N707-08", inpDetail.getSpec());
                //单位
                XmlUtilHelper.setElement(inXML, "N707-09", inpDetail.getUnit());
                //单价
                XmlUtilHelper.setElement(inXML, "N707-10", inpDetail.getPrice());
                //费用总额
                XmlUtilHelper.setElement(inXML, "N707-11", inpDetail.getAmt());
                //医生姓名
                XmlUtilHelper.setElement(inXML, "N707-12", inpDetail.getDoctorname());
                //开单日期
                XmlUtilHelper.setElement(inXML, "N707-13", inpDetail.getPres_date());
                //付数
                XmlUtilHelper.setElement(inXML, "N707-14", inpDetail.getOrders());
                //数量
                XmlUtilHelper.setElement(inXML, "N707-15", inpDetail.getQuan());
                //农合项目代码
                XmlUtilHelper.setElement(inXML, "N707-16", inpDetail.getHpitemcode());
                //农合项目名称
                XmlUtilHelper.setElement(inXML, "N707-17", inpDetail.getHpitemname());
                //可报销金额（元） 
                XmlUtilHelper.setElement(inXML, "N707-18", inpDetail.getAmt_hp());
                //创建时间 
                XmlUtilHelper.setElement(inXML, "N707-19", inpDetail.getCreatetime());
                //更新时间
                XmlUtilHelper.setElement(inXML, "N707-20", inpDetail.getUpdatetime());
                //住院登记流水号
                XmlUtilHelper.setElement(inXML, "N707-21", inpDetail.getInpno());
                //医疗机构代码
                XmlUtilHelper.setElement(inXML, "N707-22", inpDetail.getHospcode());
                //医疗机构名称
                XmlUtilHelper.setElement(inXML, "N707-23", inpDetail.getHospname());
                //国产/进口标识代码
                XmlUtilHelper.setElement(inXML, "N707-24", inpDetail.getSd_abrd());
                //国产/进口标识名称
                XmlUtilHelper.setElement(inXML, "N707-25", inpDetail.getName_abrd());
                //目录属性代码
                XmlUtilHelper.setElement(inXML, "N707-28", inpDetail.getCatalog_code());
                //目录属性名称
                XmlUtilHelper.setElement(inXML, "N707-29", inpDetail.getCatalog_name());
                //集中招标采购项目编码
                XmlUtilHelper.setElement(inXML, "N707-30", inpDetail.getPurchaseitem());
            }
        }       
        
//        Element root = inXML.addElement("NDEML");
//        root.addAttribute("templateVersion", "1.0");
//
//        Node header = inXML.addElement("header");
//
//        Element xmlExportDateElement = inXML.addElement("exportDate");
//        xmlExportDateElement.addText((new FDateTime()).toString());
//
//        Element xmlDatatypeElement = inXML.addElement("dataType");
//        xmlDatatypeElement.addText( "N707");

//        Element xmlsourceCodeElement = inXML.addElement("sourceCode");
//        xmlsourceCodeElement.addText( "郑州中医骨伤医院");
//        xmlsourceCodeElement.addAttribute("ref", this.serviceContext.getHospCode());

//        Element xmltargetCodeElement = inXML.addElement("targetCode");
//        xmltargetCodeElement.addText( "国家平台");
//        xmltargetCodeElement.addAttribute("ref", "00");
//
//        Element xmlSourceTypeElement = inXML.addElement("sourceType");
//        xmlSourceTypeElement.addAttribute("ref", "1");
//        xmlSourceTypeElement.addText( "医院上传");


        //body字段解析
//        Node body = inXML.addElement("body");

//        //拼装inpDetails
//        //1、按住院流水号分组
//        HashMap<String,List<InpDetailUpLoadDTO>> groupsMap = new HashMap<String,List<InpDetailUpLoadDTO>>() ;
//        groupsMap=getMap();
//        for (String key : groupsMap.keySet()){
//            Element bodyItemXmlNode = inXML.addElement("bodyItem");
//            //按住院流水号分组
//            bodyItemXmlNode.addAttribute("itemId", key);
//            //拼装Data数据源
//            Element dataXmlElement = inXML.addElement("data");
//            //扩展数据，备用的
//            Element extendDataXmlElement = inXML.addElement("extendData");
//            //分组后的处方明细
//            List<InpDetailUpLoadDTO> lst = groupsMap.get(key);
//            for (InpDetailUpLoadDTO inpDetail : lst){
//                Element N707Element = inXML.addElement("N707");
//
//                //住院处方流水号
//                Element N01Element = inXML.addElement("N707-01");
//                N01Element.addText(inpDetail.getPresno());
//
//                //项目序号（费用明细 HIS 系统唯一标识） 
//                Element N02Element = inXML.addElement("N707-02");
//                N02Element.addText( inpDetail.getItemno());
//
//                Element N03Element = inXML.addElement("N707-03");
//                N03Element.addText( inpDetail.getFeetp_code());
//
//                Element N04Element = inXML.addElement("N707-04");
//                N04Element.addText( inpDetail.getFeetp_name());
//
//                Element N05Element = inXML.addElement("N707-05");
//                N05Element.addText( inpDetail.getHisitemcode());
//
//                Element N06Element = inXML.addElement("N707-06");
//                N06Element.addText( inpDetail.getHisitemname());
//
//                //剂型
//                Element N07Element = inXML.addElement("N707-07");
//                N07Element.addText( inpDetail.getDose());
//
//                //规格
//                Element N08Element = inXML.addElement("N707-08");
//                N08Element.addText( inpDetail.getSpec());
//                //单位
//                Element N09Element = inXML.addElement("N707-09");
//                N09Element.addText( inpDetail.getUnit());
//                //单价
//                Element N10Element = inXML.addElement("N707-10");
//                N10Element.addText( inpDetail.getPrice());
//                //费用总额
//                Element N11Element = inXML.addElement("N707-11");
//                N11Element.addText( inpDetail.getAmt());
//                //医生姓名
//                Element N12Element = inXML.addElement("N707-12");
//                N12Element.addText( inpDetail.getDoctorname());
//                //开单日期
//                Element N13Element = inXML.addElement("N707-13");
//                N13Element.addText( inpDetail.getPres_date());
//                //付数
//                Element N14Element = inXML.addElement("N707-14");
//                N14Element.addText( inpDetail.getOrders());
//                //数量
//                Element N15Element = inXML.addElement("N707-15");
//                N15Element.addText( inpDetail.getQuan());
//                //农合项目代码
//                Element N16Element = inXML.addElement("N707-16");
//                N16Element.addText( inpDetail.getHpitemcode());
//                //农合项目名称
//                Element N17Element = inXML.addElement("N707-17");
//                N17Element.addText( inpDetail.getHpitemname());
//                //可报销金额（元） 
//                Element N18Element = inXML.addElement("N707-18");
//                N18Element.addText( inpDetail.getAmt_hp());
//                //创建时间 
//                Element N19Element = inXML.addElement("N707-19");
//                N19Element.addText( inpDetail.getCreatetime());
//                //更新时间
//                Element N20Element = inXML.addElement("N707-20");
//                N20Element.addText( inpDetail.getUpdatetime());
//                //住院登记流水号
//                Element N21Element = inXML.addElement("N707-21");
//                N21Element.addText( inpDetail.getInpno());
//                //医疗机构代码
//                Element N22Element = inXML.addElement("N707-22");
//                N22Element.addText( inpDetail.getHospcode());
//                //医疗机构名称
//                Element N23Element = inXML.addElement("N707-23");
//                N23Element.addText( inpDetail.getHospname());
//
//                //国产/进口标识代码
//                Element N24Element = inXML.addElement("N707-24");
//                N24Element.addText( inpDetail.getSd_abrd());
//                //国产/进口标识名称
//                Element N25Element = inXML.addElement("N707-25");
//                N25Element.addText( inpDetail.getName_abrd());
//                //目录属性代码
//                Element N28Element = inXML.addElement("N707-28");
//                N28Element.addText( inpDetail.getCatalog_code());
//                //目录属性名称
//                Element N29Element = inXML.addElement("N707-29");
//                N29Element.addText( inpDetail.getCatalog_name());
//                //                  //集中招标采购项目编码
//                Element N30Element = inXML.addElement("N707-30");
//                N30Element.addText( inpDetail.getPurchaseitem());
//            }
//        }
        return inXML.toString().getBytes();
    }  
    /**
     * 将inpDetailUpLoadDtos 进行分组存入map
     * @return
     */
    private HashMap<String,List<InpDetailUpLoadDTO>> getMap(){
    	HashMap<String,List<InpDetailUpLoadDTO>> map= new HashMap<String,List<InpDetailUpLoadDTO>>();
    	List<InpDetailUpLoadDTO> list= new ArrayList<InpDetailUpLoadDTO>();
    	for(InpDetailUpLoadDTO dto:inpDetailUpLoadDtos){
    		if(!map.containsKey(dto.getInpno())){
    			//查询Inpno相等的数据
    			for(InpDetailUpLoadDTO inDto:inpDetailUpLoadDtos){
    				if(inDto.getInpno().equals(dto.getInpno())){
    					list.add(inDto);
    				}
    			}
    			if(!list.isEmpty()){
    				map.put(dto.getInpno(), list);
    				list.clear();
    			}
    		}
    	}
    	return map;
    }
}
