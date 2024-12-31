package iih.mi.device.serializedata.ruralcooperinsure;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;
import iih.mi.constant.IMiDeviceConst;
import iih.mi.device.util.XmlUtilHelper;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpPayInpDataParamDTO;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpPayItemResultDTO;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpPayReqParamDTO;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpPayResultDTO;
/**
 * 费用预结算
 * @author LIM
 *
 */
public class PreInpPayProc extends AbstractTransactProc{

    // 预结算数据源，拼装xml
    private InpPayInpDataParamDTO preInpPayDto;
    // 请求参数信息
    private InpPayReqParamDTO paramDto;

    public PreInpPayProc(InpPayReqParamDTO paramDto, InpPayInpDataParamDTO preInpPayDto)
    {
        this.paramDto = paramDto;
        this.preInpPayDto = preInpPayDto;
        this.methodName = "preInpPay";
        this.paramCount =10;
    }

	@Override
	public List<Object> convertTOInputDataParam() throws BizException {
        List<Object> param=new ArrayList<Object>();
        param.add(this.serviceContext.getUserName());
        param.add(this.serviceContext.getPassword());
        param.add((new FDateTime()).toString());
        param.add(this.serviceContext.getHospCode());
        param.add(paramDto.getChareacode());
        param.add(paramDto.getInpno());
        param.add(paramDto.getOperator());
        param.add(paramDto.getRedeemdate());
        param.add(paramDto.getRedeemorgno());
        byte[] inpDatasBytes = createXmlInParam();
        param.add(inpDatasBytes);
        return param;
	}

	@Override
	public Object convertToOutputDataParam(String strOutput)
			throws BizException, InstantiationException, IllegalAccessException {
        String[] attributeStrings = new String[] { "Billcode", "Inpno", "Hospcode", "Hospname", "Hosplevelcode", "Hosplevelname", "Chareacode", "Chareaname", "Personcode", "Patname", "Idcard", "Phone", "Sexcode", "Sexname", "Medicalcode", "Enttpcode", "Enttpname", "Householder", "Familyaddress", "Ent_code", "Dt_entry", "Dt_end", "Maindicode", "Maindiname", "Surgerycode", "Surgeryname", "Agenciescode", "Agenciesname", "Amt_all", "Amt_pat", "Hp_amtallactual", "Hppolicy", "Hp_amtall", "Drgsamt", "Bigill_amt", "Bigill_amtactual", "Civilamt", "Hp_ratio", "Accumamt_year", "Times", "Lower_amt", "Top_amt", "Note", "Stunitcode", "Stunitname", "Amtall_deduc", "Reason_deduc", "Amt_advance", "Preinppayid" };
        
		Document doc = XmlUtilHelper.readDocument(strOutput);
		// 获取根节点元素对象
		Element root = doc.getRootElement();
		Node node = root.selectSingleNode("/body");
        Node dataNode = node.selectSingleNode("data");
        Node n708Node = dataNode.selectSingleNode("N708");
        InpPayResultDTO preInpPayResultDto = SerializeUtil.deserialize(new InpPayResultDTO(),(Element)n708Node,
            attributeStrings);

        FArrayList arrayList=new FArrayList();
        Node n709sNode = dataNode.selectSingleNode("N709S");
        if (n709sNode != null){
           List<Node> nodeList = n709sNode.selectNodes("N709");
            if (nodeList != null){
                for (Node item: nodeList){
                    InpPayItemResultDTO itemResultDto = SerializeUtil.deserialize(new InpPayItemResultDTO(),(Element)item,
                        new InpPayItemResultDTO().getAttrNames());
                    arrayList.add(itemResultDto);
                }
            }
        }
        preInpPayResultDto.setBillitems(arrayList);
        return preInpPayResultDto;
	}
	private byte[] createXmlInParam(){
          Document inXML = DocumentHelper.createDocument();

//          Element root = inXML.addElement("NDEML");
//          root.addAttribute("templateVersion", "1.0");
//          Node header = inXML.addElement("header");
          
          XmlUtilHelper.setElement(inXML, "NDEML","","templateVersion","1.0");
          XmlUtilHelper.setElement(inXML, "header", "");
          XmlUtilHelper.setElement(inXML, "exportDate", (new FDateTime()).toString());
          //导出数据的业务类型，填写 N706
          XmlUtilHelper.setElement(inXML, "dataType", "N706");
          //数据来源
          XmlUtilHelper.setElement(inXML, "sourceCode", IMiDeviceConst.RURALCOOPER_SOURCECODE_NAME_HOSPTIAL,"ref",this.serviceContext.getHospCode());
          //平台
          XmlUtilHelper.setElement(inXML, "targetCode", IMiDeviceConst.RURALCOOPER_TARGETCODE_NAME,"ref",IMiDeviceConst.RURALCOOPER_TARGETCODE_CODE);
          //数据来源类型,1：省平台上传；2、区县平台上传；3、医院上传；4、其他来源上传 
          XmlUtilHelper.setElement(inXML, "sourceType", IMiDeviceConst.RURALCOOPER_SOURCETYPE_NAME_HOSPTIAL,"ref",IMiDeviceConst.RURALCOOPER_SOURCETYPE_CODE_HOSPTIAL);
          XmlUtilHelper.setElement(inXML, "body", "");
          XmlUtilHelper.setElement(inXML, "data", "");
          XmlUtilHelper.setElement(inXML, "extendData", "");
          XmlUtilHelper.setElement(inXML, "N706", "");
          //HIS 系统单据编码
          XmlUtilHelper.setElement(inXML, "N706-01", this.preInpPayDto.getBillcode());
          //住院登记流水号
          XmlUtilHelper.setElement(inXML, "N706-02", this.preInpPayDto.getInpno());
          //就医机构代码
          XmlUtilHelper.setElement(inXML, "N706-03", this.preInpPayDto.getHospcode());
          //就医机构名称
          XmlUtilHelper.setElement(inXML, "N706-04", this.preInpPayDto.getHospname());
          //就医机构级别代码
          XmlUtilHelper.setElement(inXML, "N706-05", this.preInpPayDto.getHosplevelcode());
          //就医机构级别名称
          XmlUtilHelper.setElement(inXML, "N706-06", this.preInpPayDto.getHosplevelname());
          //医院信息系统操作者代码
          XmlUtilHelper.setElement(inXML, "N706-07", this.preInpPayDto.getOperatorcode());
          //医院信息系统操作者姓名
          XmlUtilHelper.setElement(inXML, "N706-08", this.preInpPayDto.getOperatorname());
          //患者姓名
          XmlUtilHelper.setElement(inXML, "N706-09", this.preInpPayDto.getPatname());
          //患者性别代码
          XmlUtilHelper.setElement(inXML, "N706-10", this.preInpPayDto.getSexcode());
          //患者性别名称
          XmlUtilHelper.setElement(inXML, "N706-11", this.preInpPayDto.getSexname());
          //患者身份证号
          XmlUtilHelper.setElement(inXML, "N706-12", this.preInpPayDto.getIdcard());
          //年龄
          XmlUtilHelper.setElement(inXML, "N706-13", this.preInpPayDto.getAge());
          //患者通讯地址
          XmlUtilHelper.setElement(inXML, "N706-14", this.preInpPayDto.getAddress());
          //参合省代码
          XmlUtilHelper.setElement(inXML, "N706-15", this.preInpPayDto.getChprovcode());
          //参合省名称
          XmlUtilHelper.setElement(inXML, "N706-16", this.preInpPayDto.getChprovname());
          //参合市代码
          XmlUtilHelper.setElement(inXML, "N706-17", this.preInpPayDto.getChcitycode());
          //参合市名称
          XmlUtilHelper.setElement(inXML, "N706-18", this.preInpPayDto.getChcityname());
          //参合区代码
          XmlUtilHelper.setElement(inXML, "N706-19", this.preInpPayDto.getChareacode());
          //参合区名称
          XmlUtilHelper.setElement(inXML, "N706-20", this.preInpPayDto.getChareaname());
          //联系人姓名
          XmlUtilHelper.setElement(inXML, "N706-21", this.preInpPayDto.getContactor());
          //电话号码
          XmlUtilHelper.setElement(inXML, "N706-22", this.preInpPayDto.getPhone());
          //就诊类型代码
          XmlUtilHelper.setElement(inXML, "N706-23", this.preInpPayDto.getEnttpcode());
          //就诊类型名称
          XmlUtilHelper.setElement(inXML, "N706-24", this.preInpPayDto.getEnttpname());
          //医生姓名
          XmlUtilHelper.setElement(inXML, "N706-25", this.preInpPayDto.getDoctor());
          //入院日期
          XmlUtilHelper.setElement(inXML, "N706-26", this.preInpPayDto.getDt_entry());
          //出院日期
          XmlUtilHelper.setElement(inXML, "N706-27", this.preInpPayDto.getDt_end());
          //结算日期
          XmlUtilHelper.setElement(inXML, "N706-28", this.preInpPayDto.getDt_st());
          //住院号
          XmlUtilHelper.setElement(inXML, "N706-29", this.preInpPayDto.getEnt_code());
          //医疗证/卡号
          XmlUtilHelper.setElement(inXML, "N706-30", this.preInpPayDto.getMedicalcode());
          //主要诊断代码
          XmlUtilHelper.setElement(inXML, "N706-31", this.preInpPayDto.getMaindicode());
          //主要诊断名称
          XmlUtilHelper.setElement(inXML, "N706-32", this.preInpPayDto.getMaindiname());
          //其他诊断代码
          XmlUtilHelper.setElement(inXML, "N706-33", this.preInpPayDto.getOtherdicode());
          //其他诊断名称
          XmlUtilHelper.setElement(inXML, "N706-34", this.preInpPayDto.getOtherdiname());
          //手术名称代码
          XmlUtilHelper.setElement(inXML, "N706-35", this.preInpPayDto.getSurgerycode());
          //手术名称
          XmlUtilHelper.setElement(inXML, "N706-36", this.preInpPayDto.getSurgeryname());
          //入院科室代码
          XmlUtilHelper.setElement(inXML, "N706-37", this.preInpPayDto.getDepincode());
          //入院科室名称
          XmlUtilHelper.setElement(inXML, "N706-38", this.preInpPayDto.getDepinname());
          //出院科室代码
          XmlUtilHelper.setElement(inXML, "N706-39", this.preInpPayDto.getDepoutcode());
          //出院科室名称
          XmlUtilHelper.setElement(inXML, "N706-40", this.preInpPayDto.getDepoutname());
          //入院状态代码
          XmlUtilHelper.setElement(inXML, "N706-41", this.preInpPayDto.getInhos_status());
          //入院状态名称
          XmlUtilHelper.setElement(inXML, "N706-42", this.preInpPayDto.getInhos_statusname());
          //出院状态代码
          XmlUtilHelper.setElement(inXML, "N706-43", this.preInpPayDto.getOuthos_status());
          //出院状态名称
          XmlUtilHelper.setElement(inXML, "N706-44", this.preInpPayDto.getOuthos_statusname());
          //出院情况
          XmlUtilHelper.setElement(inXML, "N706-45", this.preInpPayDto.getOuthosnote());
          //并发症代码
          XmlUtilHelper.setElement(inXML, "N706-46", this.preInpPayDto.getNeopathycode());
          //并发症名称
          XmlUtilHelper.setElement(inXML, "N706-47", this.preInpPayDto.getNeopathyname());
          //居民健康卡号
          XmlUtilHelper.setElement(inXML, "N706-48", this.preInpPayDto.getHealthcard());
          //费用总额（元）
          XmlUtilHelper.setElement(inXML, "N706-49", this.preInpPayDto.getAmt_all());
          //可报销总额（元）
          XmlUtilHelper.setElement(inXML, "N706-50", this.preInpPayDto.getHp_amtall());
          //报销（政策）年度
          XmlUtilHelper.setElement(inXML, "N706-51", this.preInpPayDto.getHppolicy());
          //出生日期
          XmlUtilHelper.setElement(inXML, "N706-60", this.preInpPayDto.getBirth());
          //创建时间
          XmlUtilHelper.setElement(inXML, "N706-52", this.preInpPayDto.getCreatedate());
          //更新时间
          XmlUtilHelper.setElement(inXML, "N706-53", this.preInpPayDto.getUpdatedate());
          //单病种费用定额
          XmlUtilHelper.setElement(inXML, "N706-54", this.preInpPayDto.getDrgsamt());
          //民政救助补偿额
          XmlUtilHelper.setElement(inXML, "N706-55", this.preInpPayDto.getCivilamt());
          //大病保险可补偿额
          XmlUtilHelper.setElement(inXML, "N706-56", this.preInpPayDto.getBigill_amt());          
          //大病保险实际补偿额 
          XmlUtilHelper.setElement(inXML, "N706-57", this.preInpPayDto.getBigill_amtactual());
          
          //          Element xmlExportDateElement = inXML.addElement("exportDate");
//          xmlExportDateElement.addText((new FDateTime()).toString());
//
//          //导出数据的业务类型，填写 N706
//          Element xmlDatatypeElement = inXML.addElement("dataType");
//          xmlDatatypeElement.addText("N706");

          //数据来源
//          Element xmlsourceCodeElement = inXML.addElement("sourceCode");
//          xmlsourceCodeElement.addText(IMiDeviceConst.RURALCOOPER_SOURCECODE_NAME_HOSPTIAL) ;
//          xmlsourceCodeElement.addAttribute("ref", this.serviceContext.getHospCode());

//          Element xmltargetCodeElement = inXML.addElement("targetCode");
//          xmltargetCodeElement.addText(IMiDeviceConst.RURALCOOPER_TARGETCODE_NAME);
//          xmltargetCodeElement.addAttribute("ref", IMiDeviceConst.RURALCOOPER_TARGETCODE_CODE);

//          //数据来源类型,1：省平台上传；2、区县平台上传；3、医院上传；4、其他来源上传 
//          Element xmlSourceTypeElement = inXML.addElement("sourceType");
//          xmlSourceTypeElement.addAttribute("ref", IMiDeviceConst.RURALCOOPER_SOURCETYPE_CODE_HOSPTIAL);
//          xmlSourceTypeElement.addText(IMiDeviceConst.RURALCOOPER_SOURCETYPE_NAME_HOSPTIAL);

//          //body字段解析
//          Node body = inXML.addElement("body");
//          Node dataNode = inXML.addElement("data");
//          Node extendDataNode = inXML.addElement("extendData");

//          Element N706Element = inXML.addElement("N706");
//          //HIS 系统单据编码
//          Element N01Element = inXML.addElement("N706-01");
//          N01Element.addText(this.preInpPayDto.getBillcode());
//          //住院登记流水号
//          Element N02Element = inXML.addElement("N706-02");
//          N02Element.addText(this.preInpPayDto.getInpno());
//          //就医机构代码
//          Element N03Element = inXML.addElement("N706-03");
//          N03Element.addText(this.preInpPayDto.getHospcode());
//          //就医机构名称
//          Element N04Element = inXML.addElement("N706-04");
//          N04Element.addText(this.preInpPayDto.getHospname());
//          //就医机构级别代码
//          Element N05Element = inXML.addElement("N706-05");
//          N05Element.addText(this.preInpPayDto.getHosplevelcode());
//          //           //就医机构级别名称
//          Element N06Element = inXML.addElement("N706-06");
//          N06Element.addText(this.preInpPayDto.getHosplevelname());
//          //医院信息系统操作者代码
//          Element N07Element = inXML.addElement("N706-07");
//          N07Element.addText(this.preInpPayDto.getOperatorcode());
//          //医院信息系统操作者姓名
//          Element N08Element = inXML.addElement("N706-08");
//          N08Element.addText(this.preInpPayDto.getOperatorname());
//          //患者姓名
//          Element N09Element = inXML.addElement("N706-09");
//          N09Element.addText(this.preInpPayDto.getPatname());
//          //患者性别代码
//          Element N10Element = inXML.addElement("N706-10");
//          N10Element.addText(this.preInpPayDto.getSexcode());
//          //患者性别名称
//          Element N11Element = inXML.addElement("N706-11");
//          N11Element.addText(this.preInpPayDto.getSexname());
//          //患者身份证号
//          Element N12Element = inXML.addElement("N706-12");
//          N12Element.addText(this.preInpPayDto.getIdcard());
//          //年龄
//          Element N13Element = inXML.addElement("N706-13");
//          N13Element.addText(this.preInpPayDto.getAge());
//          //患者通讯地址
//          Element N14Element = inXML.addElement("N706-14");
//          N14Element.addText(this.preInpPayDto.getAddress());
//          //参合省代码
//          Element N15Element = inXML.addElement("N706-15");
//          N15Element.addText(this.preInpPayDto.getChprovcode());
//          //参合省名称
//          Element N16Element = inXML.addElement("N706-16");
//          N16Element.addText(this.preInpPayDto.getChprovname());
//          //参合市代码
//          Element N17Element = inXML.addElement("N706-17");
//          N17Element.addText(this.preInpPayDto.getChcitycode());
//          //参合市名称
//          Element N18Element = inXML.addElement("N706-18");
//          N18Element.addText(this.preInpPayDto.getChcityname());
//          //参合区代码
//          Element N19Element = inXML.addElement("N706-19");
//          N19Element.addText(this.preInpPayDto.getChareacode());
//          //          //参合区名称
//          Element N20Element = inXML.addElement("N706-20");
//          N20Element.addText(this.preInpPayDto.getChareaname());
//          //联系人姓名
//          Element N21Element = inXML.addElement("N706-21");
//          N21Element.addText(this.preInpPayDto.getContactor());
//          //电话号码
//          Element N22Element = inXML.addElement("N706-22");
//          N22Element.addText(this.preInpPayDto.getPhone());
//          //就诊类型代码
//          Element N23Element = inXML.addElement("N706-23");
//          N23Element.addText(this.preInpPayDto.getEnttpcode());
//          //就诊类型名称
//          Element N24Element = inXML.addElement("N706-24");
//          N24Element.addText(this.preInpPayDto.getEnttpname());
//          //医生姓名
//          Element N25Element = inXML.addElement("N706-25");
//          N25Element.addText(this.preInpPayDto.getDoctor());
//          //入院日期
//          Element N26Element = inXML.addElement("N706-26");
//          N26Element.addText(this.preInpPayDto.getDt_entry());
//          //出院日期
//          Element N27Element = inXML.addElement("N706-27");
//          N27Element.addText(this.preInpPayDto.getDt_end());
//          //结算日期
//          Element N28Element = inXML.addElement("N706-28");
//          N28Element.addText(this.preInpPayDto.getDt_st());
//          //住院号
//          Element N29Element = inXML.addElement("N706-29");
//          N29Element.addText(this.preInpPayDto.getEnt_code());
//          //医疗证/卡号
//          Element N30Element = inXML.addElement("N706-30");
//          N30Element.addText(this.preInpPayDto.getMedicalcode());
//          //主要诊断代码
//          Element N31Element = inXML.addElement("N706-31");
//          N31Element.addText(this.preInpPayDto.getMaindicode());
//          //主要诊断名称
//          Element N32Element = inXML.addElement("N706-32");
//          N32Element.addText(this.preInpPayDto.getMaindiname());
//          //其他诊断代码
//          Element N33Element = inXML.addElement("N706-33");
//          N33Element.addText(this.preInpPayDto.getOtherdicode());
//          //其他诊断名称
//          Element N34Element = inXML.addElement("N706-34");
//          N34Element.addText(this.preInpPayDto.getOtherdiname());
//          //手术名称代码
//          Element N35Element = inXML.addElement("N706-35");
//          N35Element.addText(this.preInpPayDto.getSurgerycode());
//          //手术名称
//          Element N36Element = inXML.addElement("N706-36");
//          N36Element.addText(this.preInpPayDto.getSurgeryname());
//          //入院科室代码
//          Element N37Element = inXML.addElement("N706-37");
//          N37Element.addText(this.preInpPayDto.getDepincode());
//          //入院科室名称
//          Element N38Element = inXML.addElement("N706-38");
//          N38Element.addText(this.preInpPayDto.getDepinname());
//          //出院科室代码
//          Element N39Element = inXML.addElement("N706-39");
//          N39Element.addText(this.preInpPayDto.getDepoutcode());
//          //出院科室名称
//          Element N40Element = inXML.addElement("N706-40");
//          N40Element.addText(this.preInpPayDto.getDepoutname());
//          //入院状态代码
//          Element N41Element = inXML.addElement("N706-41");
//          N41Element.addText(this.preInpPayDto.getInhos_status());
//          //入院状态名称
//          Element N42Element = inXML.addElement("N706-42");
//          N42Element.addText(this.preInpPayDto.getInhos_statusname());
//          //出院状态代码
//          Element N43Element = inXML.addElement("N706-43");
//          N43Element.addText(this.preInpPayDto.getOuthos_status());
//          //出院状态名称
//          Element N44Element = inXML.addElement("N706-44");
//          N44Element.addText(this.preInpPayDto.getOuthos_statusname());
//          //出院情况
//          Element N45Element = inXML.addElement("N706-45");
//          N45Element.addText(this.preInpPayDto.getOuthosnote());
//          //并发症代码
//          Element N46Element = inXML.addElement("N706-46");
//          N46Element.addText(this.preInpPayDto.getNeopathycode());
//          //并发症名称
//          Element N47Element = inXML.addElement("N706-47");
//          N47Element.addText(this.preInpPayDto.getNeopathyname());
//          //居民健康卡号
//          Element N48Element = inXML.addElement("N706-48");
//          N48Element.addText(this.preInpPayDto.getHealthcard());
//          //费用总额（元）
//          Element N49Element = inXML.addElement("N706-49");
//          N49Element.addText(this.preInpPayDto.getAmt_all());
//          //可报销总额（元）
//          Element N50Element = inXML.addElement("N706-50");
//          N50Element.addText(this.preInpPayDto.getHp_amtall());
//          //报销（政策）年度
//          Element N51Element = inXML.addElement("N706-51");
//          N51Element.addText(this.preInpPayDto.getHppolicy());
//          //出生日期
//          Element N60Element = inXML.addElement("N706-60");
//          N60Element.addText(this.preInpPayDto.getBirth());
//          //创建时间
//          Element N52Element = inXML.addElement("N706-52");
//          N52Element.addText(this.preInpPayDto.getCreatedate());
//          //更新时间
//          Element N53Element = inXML.addElement("N706-53");
//          N53Element.addText(this.preInpPayDto.getUpdatedate());
//          //单病种费用定额
//          Element N54Element = inXML.addElement("N706-54");
//          N54Element.addText(this.preInpPayDto.getDrgsamt());
//          //民政救助补偿额
//          Element N55Element = inXML.addElement("N706-55");
//          N55Element.addText(this.preInpPayDto.getCivilamt());
//          //大病保险可补偿额
//          Element N56Element = inXML.addElement("N706-56");
//          N56Element.addText(this.preInpPayDto.getBigill_amt());
//          //大病保险实际补偿额 
//          Element N57Element = inXML.addElement("N706-57");
//          N57Element.addText(this.preInpPayDto.getBigill_amtactual());
          
          return inXML.toString().getBytes();
      }	
}
