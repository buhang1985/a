package iih.mi.device.serializedata.ruralcooperinsure;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import iih.mi.constant.IMiDeviceConst;
import iih.mi.device.util.XmlUtilHelper;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpRegisterInfoDTO;
import iih.valueobject.country.ruralcooperinsure.dto.d.InpRegisterResultDTO;
/**
 * 住院登记信息上传
 * @author LIM
 *
 */
public class UploadInpRegisterProc extends AbstractTransactProc {
	private InpRegisterInfoDTO registerInfoDto;
    public UploadInpRegisterProc(InpRegisterInfoDTO registerInfoDto)
    {
        this.paramCount = 4;
        //函数名称
        this.methodName = "uploadInpRegister";
        //入参
        this.registerInfoDto = registerInfoDto;
    }
	@Override
	public List<Object> convertTOInputDataParam() throws BizException {
        byte[] inpRegisterInfo=createXmlInParam();
        List<Object> lst=new ArrayList<Object>();
        //用户名
        lst.add(this.serviceContext.getUserName());
        //密码
        lst.add(this.serviceContext.getPassword());
        //invokeDate
        lst.add(new FDateTime());
        //参合地地区编码
        lst.add(registerInfoDto.getChdistrictcode());
        //hospCode 医院编码
        lst.add(this.serviceContext.getHospCode());
        //住院登记信息
        lst.add(inpRegisterInfo);
        return lst;
	}
	@Override
	public Object convertToOutputDataParam(String strOutput)throws BizException, InstantiationException, IllegalAccessException {
		Document doc = XmlUtilHelper.readDocument(strOutput);
		// 获取根节点元素对象
		Element root = doc.getRootElement();
		Node node = root.selectSingleNode("/body");
        Node dataNode = node.selectSingleNode("data");
        InpRegisterResultDTO registerResultDto =SerializeUtil.deserialize(new InpRegisterResultDTO(), (Element)dataNode, new InpRegisterResultDTO().getAttrNames());   
        return registerResultDto;
	}
	private byte[] createXmlInParam()
    {
        Document inXML = DocumentHelper.createDocument();
        XmlUtilHelper.setElement(inXML, "NDEML","","templateVersion","1.0");
        XmlUtilHelper.setElement(inXML, "header", "");
        XmlUtilHelper.setElement(inXML, "exportDate", (new FDateTime()).toString());
        XmlUtilHelper.setElement(inXML, "dataType", "N801");
        
        //数据来源
        XmlUtilHelper.setElement(inXML, "sourceCode", IMiDeviceConst.RURALCOOPER_SOURCECODE_NAME_PROVINCE,"ref",IMiDeviceConst.RURALCOOPER_SOURCECODE_CODE_PROVINCE);
        //平台
        XmlUtilHelper.setElement(inXML, "targetCode", IMiDeviceConst.RURALCOOPER_TARGETCODE_NAME,"ref",IMiDeviceConst.RURALCOOPER_TARGETCODE_CODE);
        //数据来源类型,1：省平台上传；2、区县平台上传；3、医院上传；4、其他来源上传 
        XmlUtilHelper.setElement(inXML, "sourceType", IMiDeviceConst.RURALCOOPER_SOURCETYPE_NAME_PROVINCE,"ref",IMiDeviceConst.RURALCOOPER_SOURCETYPE_CODE_PROVINCE);
        
        XmlUtilHelper.setElement(inXML, "operateFlag", "","ref","1");
        XmlUtilHelper.setElement(inXML, "body", "");
        XmlUtilHelper.setElement(inXML, "data", "");
        XmlUtilHelper.setElement(inXML, "extendData", "");
        //开始数据源的转化
        //住院登记流水号
        XmlUtilHelper.setElement(inXML, "N801-01", this.registerInfoDto.getIncno());
        //就医机构代码
        XmlUtilHelper.setElement(inXML, "N801-02", this.registerInfoDto.getJyhoscode());       
        //就医机构名称
        XmlUtilHelper.setElement(inXML, "N801-03", this.registerInfoDto.getJyhosname());   
        //患者姓名
        XmlUtilHelper.setElement(inXML, "N801-04", this.registerInfoDto.getPatname());
        //患者性别代码
        XmlUtilHelper.setElement(inXML, "N801-05", this.registerInfoDto.getSexcode());
        //患者性别名称
        XmlUtilHelper.setElement(inXML, "N801-06", this.registerInfoDto.getSexname());
        //患者身份证号
        XmlUtilHelper.setElement(inXML, "N801-07", this.registerInfoDto.getIdcard());
        //年龄
        XmlUtilHelper.setElement(inXML, "N801-08", this.registerInfoDto.getAge());
        //患者通讯地址
        XmlUtilHelper.setElement(inXML, "N801-09", this.registerInfoDto.getAddress());
        //参合省代码
        XmlUtilHelper.setElement(inXML, "N801-10", this.registerInfoDto.getChprovincecode());
        //参合省名称
        XmlUtilHelper.setElement(inXML, "N801-11", this.registerInfoDto.getChprovincename());
        //参合市代码
        XmlUtilHelper.setElement(inXML, "N801-12", this.registerInfoDto.getChcitycode());
        //参合市名称
        XmlUtilHelper.setElement(inXML, "N801-13", this.registerInfoDto.getChcityname());
        //参合区代码
        XmlUtilHelper.setElement(inXML, "N801-14", this.registerInfoDto.getChdistrictcode());
        //参合区名称
        XmlUtilHelper.setElement(inXML, "N801-15", this.registerInfoDto.getChdistrictname());
        //家庭编码
        XmlUtilHelper.setElement(inXML, "N801-16", this.registerInfoDto.getFamilycode());
        //个人编码
        XmlUtilHelper.setElement(inXML, "N801-17", this.registerInfoDto.getPersoncode());
        //身高
        XmlUtilHelper.setElement(inXML, "N801-18", this.registerInfoDto.getHeight());
        //体重
        XmlUtilHelper.setElement(inXML, "N801-19", this.registerInfoDto.getWeight());
        //住院疾病诊断代码
        XmlUtilHelper.setElement(inXML, "N801-20", this.registerInfoDto.getInpdicode());
        //住院疾病诊断名称
        XmlUtilHelper.setElement(inXML, "N801-21", this.registerInfoDto.getInpdiname());
        //第二疾病诊断代码
        XmlUtilHelper.setElement(inXML, "N801-22", this.registerInfoDto.getInpdicode2());
        //第二疾病诊断名称
        XmlUtilHelper.setElement(inXML, "N801-23", this.registerInfoDto.getInpdiname2());
        //手术编码
        XmlUtilHelper.setElement(inXML, "N801-24", this.registerInfoDto.getSurgerycode());
        //手术名称
        XmlUtilHelper.setElement(inXML, "N801-25", this.registerInfoDto.getSurgeryname());
        //治疗编码
        XmlUtilHelper.setElement(inXML, "N801-26", this.registerInfoDto.getCurecode());
        //治疗名称
        XmlUtilHelper.setElement(inXML, "N801-27", this.registerInfoDto.getCurename());
        //入院科室代码
        XmlUtilHelper.setElement(inXML, "N801-28", this.registerInfoDto.getDepcode());
        //入院科室名称
        XmlUtilHelper.setElement(inXML, "N801-29", this.registerInfoDto.getDepname());
        //就诊类型代码
        XmlUtilHelper.setElement(inXML, "N801-30", this.registerInfoDto.getHp_enttp());
        //就诊类型名称
        XmlUtilHelper.setElement(inXML, "N801-31", this.registerInfoDto.getHp_enttpname());
        //并发症编码
        XmlUtilHelper.setElement(inXML, "N801-32", this.registerInfoDto.getComplicationcode());
        //并发症名称
        XmlUtilHelper.setElement(inXML, "N801-33", this.registerInfoDto.getComplicationname());
        //来院状态代码
        XmlUtilHelper.setElement(inXML, "N801-34", this.registerInfoDto.getInhos_status());
        //来院状态名称
        XmlUtilHelper.setElement(inXML, "N801-35", this.registerInfoDto.getInhos_statusname());
        //联系人姓名
        XmlUtilHelper.setElement(inXML, "N801-36", this.registerInfoDto.getContactor());
        //电话号码
        XmlUtilHelper.setElement(inXML, "N801-37", this.registerInfoDto.getPhone());
        //医生姓名
        XmlUtilHelper.setElement(inXML, "N801-38", this.registerInfoDto.getDoctorname());
        //入院日期
        XmlUtilHelper.setElement(inXML, "N801-39", this.registerInfoDto.getDt_entry());
        //住院号
        XmlUtilHelper.setElement(inXML, "N801-40", this.registerInfoDto.getEnt_code());
        //床位号
        XmlUtilHelper.setElement(inXML, "N801-41", this.registerInfoDto.getBedno());
        //入院病区
        XmlUtilHelper.setElement(inXML, "N801-42", this.registerInfoDto.getNurdep());
        //转诊类型代码
        XmlUtilHelper.setElement(inXML, "N801-43", this.registerInfoDto.getReferraltp());
        //转诊类型名称
        XmlUtilHelper.setElement(inXML, "N801-44", this.registerInfoDto.getReferraltpname());
        //转诊单号
        XmlUtilHelper.setElement(inXML, "N801-45", this.registerInfoDto.getReferralcode());
        //转院日期
        XmlUtilHelper.setElement(inXML, "N801-47", this.registerInfoDto.getReferraldate());
        //医院住院收费收据号
        XmlUtilHelper.setElement(inXML, "N801-48", this.registerInfoDto.getIncno());
        //民政通知书号
        XmlUtilHelper.setElement(inXML, "N801-49", this.registerInfoDto.getCivilnoticecode());
        //生育证号
        XmlUtilHelper.setElement(inXML, "N801-50", this.registerInfoDto.getBirthcerticode());
        //医疗证/卡号
        XmlUtilHelper.setElement(inXML, "N801-51", this.registerInfoDto.getMedicalcerticode());
        //生日
        XmlUtilHelper.setElement(inXML, "N801-52", this.registerInfoDto.getBirth());
        //创建时间
        XmlUtilHelper.setElement(inXML, "N801-53", this.registerInfoDto.getCreatedate());
        //更新时间
        XmlUtilHelper.setElement(inXML, "N801-54", this.registerInfoDto.getUpdatetdate());
        //医院信息系统操作者代码
        XmlUtilHelper.setElement(inXML, "N801-55", this.registerInfoDto.getOperatorcode());
        //医院信息系统操作者名称
        XmlUtilHelper.setElement(inXML, "N801-56", this.registerInfoDto.getOperatorname());
                
//        Element root = inXML.addElement("NDEML");
//        root.addAttribute("templateVersion", "1.0");
//        Node header = inXML.addElement("header");
//
//        Element xmlExportDateElement = inXML.addElement("exportDate");
//        xmlExportDateElement.setText((new FDateTime()).toString());
//
//        Element xmlDatatypeElement = inXML.addElement("dataType");
//        xmlDatatypeElement.setText("N801");
//
//        Element xmlsourceCodeElement = inXML.addElement("sourceCode");
//        xmlsourceCodeElement.setText(IMiDeviceConst.RURALCOOPER_SOURCECODE_NAME_PROVINCE);
//        xmlsourceCodeElement.addAttribute("ref", IMiDeviceConst.RURALCOOPER_SOURCECODE_CODE_PROVINCE);
//
//        Element xmltargetCodeElement = inXML.addElement("targetCode");
//        xmltargetCodeElement.setText("国家平台");
//        xmltargetCodeElement.addAttribute("ref", "00");
//
//        Element xmlSourceTypeElement = inXML.addElement("sourceType");
//        xmlSourceTypeElement.addAttribute("ref", "1");
//        xmlSourceTypeElement.setText("省平台上传");

//        Element xmloperateFlagElement = inXML.addElement("operateFlag");
//        xmloperateFlagElement.addAttribute("ref", "1");

        //body字段解析
//        Node body = inXML.addElement("body");
//
//        Node dataXmlNode = inXML.addElement("data");
//
//        Node extenddataXmlNode = inXML.addElement("extendData");

//        //开始数据源的转化
//        Node dataItem1 = inXML.addElement("N801-01");
//        //住院登记流水号
//        dataItem1.setText( this.registerInfoDto.getIncno());
//
//        Node dataItem2 = inXML.addElement("N801-02");
//        //就医机构代码
//        dataItem2.setText(this.registerInfoDto.getJyhoscode());
//
//        Node dataItem3 = inXML.addElement("N801-03");
//        //就医机构名称
//        dataItem3.setText(this.registerInfoDto.getJyhosname());
//
//        Node dataItem4 = inXML.addElement("N801-04");
//        //患者姓名
//        dataItem4.setText(this.registerInfoDto.getPatname());
//
//        Node dataItem5 = inXML.addElement("N801-05");
//        //患者性别代码
//        dataItem5.setText(this.registerInfoDto.getSexcode());
//
//        Node dataItem6 = inXML.addElement("N801-06");
//        //患者性别名称
//        dataItem6.setText(this.registerInfoDto.getSexname());
//
//        Node dataItem7 = inXML.addElement("N801-07");
//        //患者身份证号
//        dataItem7.setText(this.registerInfoDto.getIdcard());
//
//        Node dataItem8 = inXML.addElement("N801-08");
//        //年龄
//        dataItem8.setText(this.registerInfoDto.getAge());
//
//        Node dataItem9 = inXML.addElement("N801-09");
//        //患者通讯地址
//        dataItem9.setText(this.registerInfoDto.getAddress());
//
//        Node dataItem10 = inXML.addElement("N801-10");
//        //参合省代码
//        dataItem10.setText(this.registerInfoDto.getChprovincecode());
//        
//        Node dataItem11 = inXML.addElement("N801-11");
//        //参合省名称
//        dataItem11.setText(this.registerInfoDto.getChprovincename());
//
//
//        Node dataItem12 = inXML.addElement("N801-12");
//        //参合市代码
//        dataItem12.setText(this.registerInfoDto.getChcitycode());
//
//
//        Node dataItem13 = inXML.addElement("N801-13");
//        //参合市名称
//        dataItem13.setText(this.registerInfoDto.getChcityname());
//
//
//        Node dataItem14 = inXML.addElement("N801-14");
//        //参合区代码
//        dataItem14.setText(this.registerInfoDto.getChdistrictcode());
//
//
//        Node dataItem15 = inXML.addElement("N801-15");
//        //参合区名称
//        dataItem15.setText(this.registerInfoDto.getChdistrictname());
//
//        Node dataItem16 = inXML.addElement("N801-16");
//        //家庭编码
//        dataItem16.setText(this.registerInfoDto.getFamilycode());
//
//        Node dataItem17 = inXML.addElement("N801-17");
//        //个人编码
//        dataItem17.setText(this.registerInfoDto.getPersoncode());
//
//        Node dataItem18 = inXML.addElement("N801-18");
//        //身高
//        dataItem18.setText( this.registerInfoDto.getHeight());
//
//        Node dataItem19 = inXML.addElement("N801-19");
//        //体重
//        dataItem19.setText( this.registerInfoDto.getWeight());
//
//        Node dataItem20 = inXML.addElement("N801-20");
//        //住院疾病诊断代码
//        dataItem20.setText( this.registerInfoDto.getInpdicode());
//
//        Node dataItem21 = inXML.addElement("N801-21");
//        //住院疾病诊断名称
//        dataItem21.setText( this.registerInfoDto.getInpdiname());
//
//        Node dataItem22 = inXML.addElement("N801-22");
//        //第二疾病诊断代码
//        dataItem22.setText( this.registerInfoDto.getInpdicode2());
//
//        Node dataItem23 = inXML.addElement("N801-23");
//        //第二疾病诊断名称
//        dataItem23.setText( this.registerInfoDto.getInpdiname2());
//
//
//        Node dataItem24 = inXML.addElement("N801-24");
//        //手术编码
//        dataItem24.setText( this.registerInfoDto.getSurgerycode());
//
//
//        Node dataItem25 = inXML.addElement("N801-25");
//        //手术名称
//        dataItem25.setText( this.registerInfoDto.getSurgeryname());
//
//
//        Node dataItem26 = inXML.addElement("N801-26");
//        //治疗编码
//        dataItem26.setText( this.registerInfoDto.getCurecode());
//
//        Node dataItem27 = inXML.addElement("N801-27");
//        //治疗名称
//        dataItem27.setText( this.registerInfoDto.getCurename());
//
//
//        Node dataItem28 = inXML.addElement("N801-28");
//        //入院科室代码
//        dataItem28.setText( this.registerInfoDto.getDepcode());
//
//        Node dataItem29 = inXML.addElement("N801-29");
//        //入院科室名称
//        dataItem29.setText( this.registerInfoDto.getDepname());
//
//        Node dataItem30 = inXML.addElement("N801-30");
//        //就诊类型代码
//        dataItem30.setText( this.registerInfoDto.getHp_enttp());
//
//
//        Node dataItem31 = inXML.addElement("N801-31");
//        //就诊类型名称
//        dataItem31.setText( this.registerInfoDto.getHp_enttpname());
//
//        Node dataItem32 = inXML.addElement("N801-32");
//        //并发症编码
//        dataItem32.setText( this.registerInfoDto.getComplicationcode());
//
//        Node dataItem33 = inXML.addElement("N801-33");
//        //并发症名称
//        dataItem33.setText( this.registerInfoDto.getComplicationname());
//
//        Node dataItem34 = inXML.addElement("N801-34");
//        // 来院状态代码
//        dataItem34.setText( this.registerInfoDto.getInhos_status());
//
//        Node dataItem35 = inXML.addElement("N801-35");
//        //来院状态名称
//        dataItem35.setText( this.registerInfoDto.getInhos_statusname());
//
//        Node dataItem36 = inXML.addElement("N801-36");
//        //联系人姓名
//        dataItem36.setText( this.registerInfoDto.getContactor());
//
//        Node dataItem37 = inXML.addElement("N801-37");
//        //电话号码
//        dataItem37.setText( this.registerInfoDto.getPhone());
//
//        Node dataItem38 = inXML.addElement("N801-38");
//        //医生姓名
//        dataItem38.setText( this.registerInfoDto.getDoctorname());
//
//        Node dataItem39 = inXML.addElement("N801-39");
//        //入院日期
//        dataItem39.setText( this.registerInfoDto.getDt_entry());
//
//        Node dataItem40 = inXML.addElement("N801-40");
//        //住院号
//        dataItem40.setText( this.registerInfoDto.getEnt_code());
//
//        Node dataItem41 = inXML.addElement("N801-41");
//        //床位号
//        dataItem41.setText( this.registerInfoDto.getBedno());
//
//        Node dataItem42 = inXML.addElement("N801-42");
//        //入院病区
//        dataItem42.setText( this.registerInfoDto.getNurdep());
//
//        Node dataItem43 = inXML.addElement("N801-43");
//        //转诊类型代码
//        dataItem43.setText( this.registerInfoDto.getReferraltp());
//
//        Node dataItem44 = inXML.addElement("N801-44");
//        //转诊类型名称
//        dataItem44.setText( this.registerInfoDto.getReferraltpname());
//
//        Node dataItem45 = inXML.addElement("N801-45");
//        //转诊单号
//        dataItem45.setText( this.registerInfoDto.getReferralcode());
//
//        Node dataItem47 = inXML.addElement("N801-47");
//        //转院日期
//        dataItem47.setText( this.registerInfoDto.getReferraldate());
//
//        Node dataItem48 = inXML.addElement("N801-48");
//        //医院住院收费收据号
//        dataItem48.setText( this.registerInfoDto.getIncno());
//
//        Node dataItem49 = inXML.addElement("N801-49");
//        //民政通知书号
//        dataItem49.setText( this.registerInfoDto.getCivilnoticecode());
//
//        Node dataItem50 = inXML.addElement("N801-50");
//        //生育证号
//        dataItem50.setText( this.registerInfoDto.getBirthcerticode());
//
//        Node dataItem51 = inXML.addElement("N801-51");
//        //医疗证/卡号
//        dataItem51.setText( this.registerInfoDto.getMedicalcerticode());
//
//        Node dataItem52 = inXML.addElement("N801-52");
//        //生日
//        dataItem52.setText( this.registerInfoDto.getBirth());
//
//        Node dataItem53 = inXML.addElement("N801-53");
//        //创建时间
//        dataItem53.setText( this.registerInfoDto.getCreatedate());
//
//        Node dataItem54 = inXML.addElement("N801-54");
//        //更新时间
//        dataItem54.setText( this.registerInfoDto.getUpdatetdate());
//
//        Node dataItem55 = inXML.addElement("N801-55");
//        //医院信息系统操作者代码
//        dataItem55.setText( this.registerInfoDto.getOperatorcode());
//
//        Node dataItem56 = inXML.addElement("N801-56");
//        //医院信息系统操作者名称
//        dataItem56.setText( this.registerInfoDto.getOperatorname());

        return inXML.toString().getBytes();
    }
}
