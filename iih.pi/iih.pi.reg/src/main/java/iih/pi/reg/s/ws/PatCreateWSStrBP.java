package iih.pi.reg.s.ws;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.pi.common.idcheck.IDChecker;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.i.IPatientcategoryRService;
import iih.pi.params.PiParams;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.desc.PatDODesc;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.s.bp.util.GetUdidocDOUtil;
import iih.pi.reg.s.customer.guoji.bean.HisGetDataXmlBean;

import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.d.desc.AdminAreaDODesc;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import xap.sys.custcfg.billcode.i.IBillcodeManage;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 患者建档
 * 入参是xml
 * @author ly 2017/08/10
 *
 */
public class PatCreateWSStrBP {

	/**
	 * 患者建档
	 * @param patInfo
	 * @return
	 * @throws BizException
	 */
	public String exec(String patInfo) throws BizException {
		
		String exMsg = null;
		PatiAggDO aggDo = null;
		try {
			HisGetDataXmlBean bean = this.analysisXml(patInfo);
			
			aggDo = this.setPatInfo(bean);
			
			IPatiCudService cudService = ServiceFinder.find(IPatiCudService.class);
			
			aggDo = cudService.insert(new PatiAggDO[]{aggDo})[0];
		} catch (BizException e) {
			e.printStackTrace();
			exMsg = e.getMessage();
		}
		
		//设置返回值
		SAXReader reader = new SAXReader();
		InputStream in = PatCreateWSStrBP.class.getResourceAsStream("hisrtndatatmpl.xml");
		String result = "";
        try {
			Document doc = reader.read(in);
			Element hd = doc.getRootElement().element("head");
			if(!StringUtil.isEmpty(exMsg)){
				hd.element("code").setText("-1");;
				hd.element("errorMsg").setText(exMsg);;
			}else{
				hd.element("code").setText("1");;
				
				PatDO pat = aggDo.getParentDO();
				Element param = doc.getRootElement().element("output_param");
				param.element("P_ID").setText(pat.getCode());
				param.element("P_MZHAO0").setText(pat.getCode_amr_oep() + "");
				param.element("P_ERRMSG").setText("成功");
			}
			
			result = doc.asXML();
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new BizException(e);
		}  
        
        return result;
	}
	
	/**
	 * 解析xml文件
	 * @param patInfo
	 * @return
	 * @throws BizException
	 */
	private HisGetDataXmlBean analysisXml(String patInfo) throws BizException {
		
		if(StringUtil.isEmpty(patInfo))
			throw new BizException("请传入格式正确的参数");
		
		HisGetDataXmlBean bean = new HisGetDataXmlBean();
		try {
			Document doc = DocumentHelper.parseText(patInfo);
			Element ip = doc.getRootElement().element("body").element("input_param");
			
			bean.setP_ZDBH00(ip.element("P_ZDBH00").getText());
			bean.setP_FZXBH0(ip.element("P_FZXBH0").getText());
			bean.setP_CARDNO(ip.element("P_CARDNO").getText());
			bean.setP_ID0000(ip.element("P_ID0000").getText());
			bean.setP_CARDTYPE(ip.element("P_CARDTYPE").getText());
			bean.setP_SFZHAO(ip.element("P_SFZHAO").getText());
			bean.setP_XMING0(ip.element("P_XMING0").getText());
			bean.setP_XBIE00(ip.element("P_XBIE00").getText());
			bean.setP_BRNL00(ip.element("P_BRNL00").getText());
			bean.setP_RYLB00(ip.element("P_RYLB00").getText());
			bean.setP_CSRQ00(ip.element("P_CSRQ00").getText());
			bean.setP_FZXMC0(ip.element("P_FZXMC0").getText());
			bean.setP_GZDWMC(ip.element("P_GZDWMC").getText());
			bean.setP_GRZHYE(ip.element("P_GRZHYE").getText());
			bean.setP_LXDH00(ip.element("P_LXDH00").getText());
			bean.setP_BYRC00(ip.element("P_BYRC00").getText());
			bean.setTEMP_DISTRICT(ip.element("temp_district").getText());
			bean.setTEMP_STREET(ip.element("temp_street").getText());
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new BizException("请传入格式正确的参数");
		}
		
		//校验必须数据
		if(StringUtil.isEmpty(bean.getP_XMING0())){
			throw new BizException("入参患者姓名为空");
		}
		if(StringUtil.isEmpty(bean.getP_XBIE00())){
			throw new BizException("入参性别为空");
		}
		if(StringUtil.isEmpty(bean.getP_CSRQ00())){
			throw new BizException("入参出生日期为空");
		}else{
			if(bean.getP_CSRQ00().length() != 8){
				throw new BizException("出生日期格式不正确,正确格式为yyyyMMdd");
			}
			String inDateStr = bean.getP_CSRQ00();
			String dateStr = inDateStr.substring(0, 4) + "-" +inDateStr.substring(4, 6) + "-" +inDateStr.substring(6, 8) ;
			
			FDate fDate = null;
			try {
				fDate = new FDate(dateStr);
			} catch (Exception e) {
				throw new BizException("出生日期格式不正确,正确格式为yyyyMMdd");
			}
			
			if(fDate.compareTo(new FDate()) > 0){
				throw new BizException("出生日期不能大于当前日期");
			}
			
			bean.setP_CSRQ00(dateStr);
		}
		
		if(StringUtil.isEmpty(bean.getP_LXDH00())){
			throw new BizException("入参手机号码为空");
		}else{
			Pattern ptn = Pattern.compile("^[1]\\d{10}$");
			Matcher matcher = ptn.matcher(bean.getP_LXDH00());
			if(!matcher.find()){
				throw new BizException("手机号码格式不正确");
			}
		}
		if(StringUtil.isEmpty(bean.getP_CARDTYPE())){
			throw new BizException("入参证件类型为空");
		}
		if(StringUtil.isEmpty(bean.getP_SFZHAO())){
			throw new BizException("入参证件号码为空");
		}else if(IPiDictCodeConst.SD_CARD_TYPE_IDENTITY.equals(bean.getP_CARDTYPE())){
			//身份证时
			if(!IDChecker.checkIDCard(bean.getP_SFZHAO())){
				throw new BizException("身份证号码格式不正确");
			}
		}
		
		return bean;
	}
	
	/**
	 * 设置患者do信息
	 * @param patInfo
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO setPatInfo(HisGetDataXmlBean data) throws BizException {
		
		PatiAggDO aggDo = new PatiAggDO(); 
		
		//患者信息
		PatDO pat = new PatDO();
		aggDo.setParentDO(pat);
		pat.setStatus(DOStatus.NEW);
		pat.setId_org(Context.get().getOrgId());
		pat.setId_grp(Context.get().getGroupId());
		
		if(FBoolean.FALSE.equals(new PiParams().PIPAT0002())){
			IBillcodeManage billcodeManage = ServiceFinder.find(IBillcodeManage.class);
			String code = billcodeManage.getPreBillCode_RequiresNew(PatDODesc.CLASS_FULLNAME);
			pat.setCode(code);
			pat.setMnecode(code);
			
			String chisCode = code.length() > 2 ? code.substring(0, code.length() - 2) : code;
			pat.setBarcode_chis(chisCode);
		}
		else {
			pat.setCode("provide by chis");
			pat.setMnecode("provide by chis");
			pat.setBarcode_chis("provide by chis");
		}
		
		pat.setName(data.getP_XMING0());
		pat.setPycode(CnToPy.getPyFirstCode(pat.getName()));//拼音码
		pat.setWbcode(CnToWB.getWBCode(pat.getName()));//五笔码
		pat.setFg_realname(FBoolean.TRUE);
		
		//证件类型
		UdidocDO idtpDoc = GetUdidocDOUtil.getDoc(
				IPiDictCodeTypeConst.SD_IDTP, data.getP_CARDTYPE());
		if(idtpDoc != null){
			pat.setId_idtp(idtpDoc.getId_udidoc());
			pat.setSd_idtp(idtpDoc.getCode());
		}else{
			pat.setId_idtp(IPiDictCodeConst.ID_IDTP_QTFDZ);
			pat.setSd_idtp(IPiDictCodeConst.SD_IDTP_QTFDZ);
		}
		pat.setId_code(data.getP_SFZHAO());
		
		UdidocDO sexDoc = GetUdidocDOUtil.getDoc(IPiDictCodeTypeConst.SD_SEX_CODE, data.getP_XBIE00());
		if(sexDoc != null){
			pat.setId_sex(sexDoc.getId_udidoc());
			pat.setSd_sex(sexDoc.getCode());
		}
		
		pat.setDt_birth(new FDate(data.getP_CSRQ00()));
		pat.setMob(data.getP_LXDH00());
		
		PiPatCaDO caDo = this.getDefPatCa();
		if(caDo != null){
			pat.setId_paticate(caDo.getId_patca());
			pat.setId_patpritp(caDo.getId_patpritp());
			pat.setId_patcrettp(caDo.getId_patcrettp());
		}
		
		pat.setId_patsrctp(IPiDictCodeConst.ID_PATSRCTP_OTHER);
		pat.setSd_patsrctp(IPiDictCodeConst.SD_PATSRCTP_OTHER);
		pat.setWorkunit(data.getP_GZDWMC());
		
		//卡号暂不做处理 TODO
		
		//保险编号(无医保类型，无法处理) TODO
		pat.setFg_invd(FBoolean.FALSE);
		
		//现在住址
		AdminAreaDO area = this.getAddress(data.getTEMP_DISTRICT());
		if(area != null){
			PatiAddrDO addr = new PatiAddrDO();
			addr.setStatus(DOStatus.NEW);
			addr.setSortno(1);
			addr.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
			addr.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
			addr.setId_admdiv(area.getId_adminarea());
			addr.setSd_admdiv(area.getCode());
			addr.setZip(area.getZipcode());
			addr.setStreet(data.getTEMP_STREET());
			
			aggDo.setPatiAddrDO(new PatiAddrDO[]{addr});
		}
		
		return aggDo;
	}
	
	/**
	 * 获取默认患者分类
	 * @return
	 */
	private PiPatCaDO getDefPatCa() throws BizException {
		
		IPatientcategoryRService caService = ServiceFinder.find(IPatientcategoryRService.class);
		
		PiPatCaDO[] caDos = caService.find("a0.fg_def = 'Y' ", null, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(caDos)){
			return null;
		}
		
		return caDos[0];
	}
	
	/**
	 * 取得区县对应的
	 * @param regionCode
	 * @return
	 * @throws BizException
	 */
	private AdminAreaDO getAddress(String regionCode) throws BizException {
		
		IAdminareaRService areaService = ServiceFinder.find(IAdminareaRService.class);
		String whereSql = AdminAreaDODesc.TABLE_ALIAS_NAME + ".code = '" +regionCode+ "'";
		AdminAreaDO[] areas = areaService.find(whereSql, "", FBoolean.FALSE);
		
		if(ArrayUtil.isEmpty(areas))
			return null;
		
		return areas[0];
	}
}
