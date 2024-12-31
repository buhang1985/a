package iih.pi.reg.s.bp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.dic.patientcategory.i.IPatientcategoryRService;
import iih.pi.reg.dto.d.PiPatBS501CondDTO;
import iih.pi.reg.dto.d.PiPatWSResultDTO;
import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.s.ws.EmpiServiceCaller;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.log.Log;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.d.CountryZoneDO;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import xap.sys.bdfw.bbd.i.ICountryzoneRService;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 同步empi患者数据
 * @author ly
 *
 */
public class SyncPatiInfoFromEmpiBP {

	private IUdidocServiceExt udiSrv = ServiceFinder.find(IUdidocServiceExt.class);
	private ICountryzoneRService countrySrv = ServiceFinder.find(ICountryzoneRService.class);
	
	/**
	 * 同步empi患者数据
	 * @param code 患者编码
	 * @return
	 * @throws BizException
	 */
	public PatiAggDO exec(String code) throws BizException{
		
		//取得empi数据
		EmpiServiceCaller call = new EmpiServiceCaller();
		PiPatBS501CondDTO cond = new PiPatBS501CondDTO();
		cond.setPatient_id(code);
		PiPatWSResultDTO[] result = call.callBS501Service(cond);
		
		if(ArrayUtil.isEmpty(result))
			return null;
		
		//这里只暂时处理第一条数据
		PiPatWSResultDTO dto = result[0];
		
		//插入患者数据
		IPatiCudService patiService = ServiceFinder.find(IPatiCudService.class);
		
		PatiAggDO aggDo = new PatiAggDO();
		this.assemblePatInfo(aggDo, dto);//患者基本信息
		this.assemblePatAddrInfo(aggDo, dto);//患者地址信息
		this.assemblePatContInfo(aggDo, dto);//患者联系人信息
		this.assemblePatHpInfo(aggDo, dto);//患者医保信息
		this.assemblePatCardInfo(aggDo, dto);//患者卡信息
		
		PatiAggDO[] aggDos = patiService.insert(new PatiAggDO[]{aggDo});
		
		return aggDos[0];
	}
	
	/**
	 * 组装患者基本信息数据
	 * @param aggDo
	 * @param dto
	 */
	private void assemblePatInfo(PatiAggDO aggDo, PiPatWSResultDTO dto) throws BizException{
		PatDO patDo = new PatDO();
		aggDo.setParentDO(patDo);
		
		patDo.setStatus(DOStatus.NEW);
		patDo.setOrigin(IPiPatConst.PAT_ORIGIN_CHIS);
		patDo.setId_org(Context.get().getOrgId());
		patDo.setId_grp(Context.get().getGroupId());
		patDo.setCode(dto.getPatient_id());//患者编码
		patDo.setName(dto.getName());//患者姓名
		patDo.setBarcode_chis(dto.getP_bar_code());//chis条码
		
		//取得患者默认分类
		PiPatCaDO defaultPatCa = this.getDefaultPatCa();
		if (defaultPatCa != null) {
			patDo.setId_paticate(defaultPatCa.getId_patca());
			patDo.setId_patpritp(defaultPatCa.getId_patpritp());
			patDo.setId_patcrettp(defaultPatCa.getId_patcrettp());
		}
		
		if(!StringUtil.isEmpty(dto.getSex())){//性别
			UdidocDO udidocDO = this.getUdidocData(IPiDictCodeConst.CODE_SEX_DOCLIST, dto.getSex());
			if(udidocDO != null){
				patDo.setId_sex(udidocDO.getId_udidoc());
				patDo.setSd_sex(udidocDO.getCode());
			}
		}
		
		patDo.setDt_birth(this.changeStringTODate(dto.getBirthday()));//出生日期
		
		if(!StringUtil.isEmpty(dto.getCountry_code())){//国家
			CountryZoneDO countryZoneDO = this.getCountryData(dto.getCountry_code());
			patDo.setId_country(countryZoneDO.getId_countryzone());
			patDo.setSd_country(countryZoneDO.getCode());
		}
		
		if(!StringUtil.isEmpty(dto.getNation_code())){//民族
			UdidocDO udidocDO = this.getUdidocData(IPiDictCodeConst.CODE_NATION_DOCLIST, dto.getNation_code());
			if(udidocDO != null){
				patDo.setId_nation(udidocDO.getId_udidoc());
				patDo.setSd_nation(udidocDO.getCode());
			}
		}
		
		if(!StringUtil.isEmpty(dto.getEducation_code())){//文化程度
			UdidocDO udidocDO = this.getUdidocData(IPiDictCodeConst.CODE_EDUCATIONLEVEL_DOCLIST, dto.getEducation_code());
			if(udidocDO != null){
				patDo.setId_educ(udidocDO.getId_udidoc());
				patDo.setSd_educ(udidocDO.getCode());
			}
		}
		
		if(!StringUtil.isEmpty(dto.getOccupation_type())){//职业
			UdidocDO udidocDO = this.getUdidocData(IPiDictCodeConst.CODE_OCCU_DOCLIST, dto.getOccupation_type());
			if(udidocDO != null){
				patDo.setId_occu(udidocDO.getId_udidoc());
				patDo.setSd_occu(udidocDO.getCode());
			}
		}
		
		if(!StringUtil.isEmpty(dto.getMarry_code())){//婚姻
			UdidocDO udidocDO = this.getUdidocData(IPiDictCodeConst.CODE_MARRY_DOCLIST, dto.getMarry_code());
			if(udidocDO != null){
				patDo.setId_marry(udidocDO.getId_udidoc());
				patDo.setSd_marry(udidocDO.getCode());
			}
		}
		
		//主身份标识
		if(!StringUtil.isEmpty(dto.getSocial_no())){
			patDo.setId_idtp(IPiDictCodeConst.ID_IDTP_IDENTITY);
			patDo.setSd_idtp(IPiDictCodeConst.SD_IDTP_IDENTITY);
			patDo.setId_code(dto.getSocial_no());
			
		}else if(!StringUtil.isEmpty(dto.getOther_card_no_jmhkb())){
			patDo.setId_idtp(IPiDictCodeConst.ID_IDTP_JMHKB);
			patDo.setSd_idtp(IPiDictCodeConst.SD_IDTP_JMHKB);
			patDo.setId_code(dto.getOther_card_no_jmhkb());
			
		}else if(!StringUtil.isEmpty(dto.getOther_card_no_hz())){
			patDo.setId_idtp(IPiDictCodeConst.ID_IDTP_HZ);
			patDo.setSd_idtp(IPiDictCodeConst.SD_IDTP_HZ);
			patDo.setId_code(dto.getOther_card_no_hz());
			
		}else if(!StringUtil.isEmpty(dto.getOther_card_no_jgz())){
			patDo.setId_idtp(IPiDictCodeConst.ID_IDTP_JGZ);
			patDo.setSd_idtp(IPiDictCodeConst.SD_IDTP_JGZ);
			patDo.setId_code(dto.getOther_card_no_jgz());

		}else if(!StringUtil.isEmpty(dto.getOther_card_no_jsz())){
			patDo.setId_idtp(IPiDictCodeConst.ID_IDTP_JSZ);
			patDo.setSd_idtp(IPiDictCodeConst.SD_IDTP_JSZ);
			patDo.setId_code(dto.getOther_card_no_jsz());
			
		}else if(!StringUtil.isEmpty(dto.getOther_card_no_gajm())){
			patDo.setId_idtp(IPiDictCodeConst.ID_IDTP_GAJMZ);
			patDo.setSd_idtp(IPiDictCodeConst.SD_IDTP_GAJMZ);
			patDo.setId_code(dto.getOther_card_no_gajm());
			
		}else if(!StringUtil.isEmpty(dto.getOther_card_no_twjm())){
			patDo.setId_idtp(IPiDictCodeConst.ID_IDTP_TWJMZ);
			patDo.setSd_idtp(IPiDictCodeConst.SD_IDTP_TWJMZ);
			patDo.setId_code(dto.getOther_card_no_twjm());
			
		}else if(!StringUtil.isEmpty(dto.getOther_card_no_qtfd())){
			patDo.setId_idtp(IPiDictCodeConst.ID_IDTP_QTFDZ);
			patDo.setSd_idtp(IPiDictCodeConst.SD_IDTP_QTFDZ);
			patDo.setId_code(dto.getOther_card_no_qtfd());
		}
			
		patDo.setTel(dto.getHome_tel());
		patDo.setMob(dto.getMobile());
		patDo.setWorkunit(dto.getBirth_place());
		
		//一些默认值
		patDo.setFg_invd(FBoolean.FALSE);
	}
	
	/**
	 * 组装患者地址信息
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	private void assemblePatAddrInfo(PatiAggDO aggDo, PiPatWSResultDTO dto) throws BizException{
		
		List<PatiAddrDO> addrList = new ArrayList<PatiAddrDO>();
		//获取区县信息
		List<String> codeList = new ArrayList<String>();
		this.addToList(dto.getLive_district_code(), codeList);
		this.addToList(dto.getHome_district_code(), codeList);
		this.addToList(dto.getNative_district_code(), codeList);
		this.addToList(dto.getWork_district_code(), codeList);
		
		if(codeList.size() == 0)
			return;

		//获取区县数据
		IAdminareaRService areaRSrv = ServiceFinder.find(IAdminareaRService.class);
		String whereSql = this.convertArrayToInSql(codeList);
		AdminAreaDO[] areaDos = areaRSrv.find("a0.code in " + whereSql, "", FBoolean.FALSE);
		
		Map<String, AdminAreaDO> areaMap = new HashMap<String, AdminAreaDO>();
		if (!ArrayUtil.isEmpty(areaDos)) {
			for (AdminAreaDO adminAreaDO : areaDos) {
				areaMap.put(adminAreaDO.getCode(), adminAreaDO);
			}
		}
		
		//现住地址
		if(!StringUtil.isEmpty(dto.getLive_district_code())){
			PatiAddrDO addrDo = new PatiAddrDO();
			addrDo.setStatus(DOStatus.NEW);
			addrDo.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
			addrDo.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
			
			AdminAreaDO areaDo = areaMap.get(dto.getLive_district_code());
			if(areaDo != null){
				addrDo.setId_admdiv(areaDo.getId_adminarea());
			}
			addrDo.setSd_admdiv(dto.getLive_district_code());
			addrDo.setStreet(dto.getLive_street());
			addrDo.setZip(dto.getLive_postcode());
			
			addrList.add(addrDo);
		}
		
		//家庭地址
		if(!StringUtil.isEmpty(dto.getHome_district_code())){
			PatiAddrDO addrDo = new PatiAddrDO();
			addrDo.setStatus(DOStatus.NEW);
			addrDo.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_FAMILY);
			addrDo.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_FAMILY);
			
			AdminAreaDO areaDo = areaMap.get(dto.getHome_district_code());
			if(areaDo != null){
				addrDo.setId_admdiv(areaDo.getId_adminarea());
			}
			addrDo.setSd_admdiv(dto.getHome_district_code());
			addrDo.setStreet(dto.getHome_street());
			addrDo.setZip(dto.getHome_zipcode());
			
			addrList.add(addrDo);
			
		}
		
		//户籍地址
		if(!StringUtil.isEmpty(dto.getNative_district_code())){
			PatiAddrDO addrDo = new PatiAddrDO();
			addrDo.setStatus(DOStatus.NEW);
			addrDo.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_CENCUS);
			addrDo.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_CENCUS);
			
			AdminAreaDO areaDo = areaMap.get(dto.getNative_district_code());
			if(areaDo != null){
				addrDo.setId_admdiv(areaDo.getId_adminarea());
			}
			addrDo.setSd_admdiv(dto.getNative_district_code());
			addrDo.setStreet(dto.getNative_street());
			addrDo.setZip(dto.getNative_postcode());
			
			addrList.add(addrDo);
			
		}
		
		//工作单位地址
		if(!StringUtil.isEmpty(dto.getWork_district_code())){
			PatiAddrDO addrDo = new PatiAddrDO();
			addrDo.setStatus(DOStatus.NEW);
			addrDo.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_WORK);
			addrDo.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_WORK);
			
			AdminAreaDO areaDo = areaMap.get(dto.getWork_district_code());
			if(areaDo != null){
				addrDo.setId_admdiv(areaDo.getId_adminarea());
			}
			addrDo.setSd_admdiv(dto.getWork_district_code());
			addrDo.setStreet(dto.getWork_street());
			addrDo.setZip(dto.getWork_postcode());
			
			addrList.add(addrDo);
			
		}
		
		if(addrList.size() > 0){
			aggDo.setPatiAddrDO(addrList.toArray(new PatiAddrDO[addrList.size()]));
		}
	}
	
	/**
	 * 组装患者联系人信息
	 * @param aggDo
	 * @param dto
	 * @throws BizException
	 */
	private void assemblePatContInfo(PatiAggDO aggDo, PiPatWSResultDTO dto) throws BizException{
		
	}
	
	/**
	 * 组装患者医保信息
	 * @param aggDo
	 * @param dto
	 * @throws BizException
	 */
	private void assemblePatHpInfo(PatiAggDO aggDo, PiPatWSResultDTO dto) throws BizException{
		
	}
	
	/**
	 * 组装患者卡信息
	 * @param aggDo
	 * @param dto
	 * @throws BizException
	 */
	private void assemblePatCardInfo(PatiAggDO aggDo, PiPatWSResultDTO dto) throws BizException{
		
	}
	
	/**
	 * 获取默认患者分类
	 * @return
	 * @throws BizException
	 */
	private PiPatCaDO getDefaultPatCa() throws BizException{
		
		IPatientcategoryRService caService = ServiceFinder.find(IPatientcategoryRService.class);
		
		PiPatCaDO[] csDos =  caService.find("a0.fg_def = 'Y' ", "", FBoolean.FALSE);
		
		if(ArrayUtil.isEmpty(csDos))
			return null;
		
		return csDos[0];
	}
	
	/**
	 * 查询自定义档案数据
	 * @param ieCode
	 * @return
	 * @throws BizException
	 */
	private UdidocDO getUdidocData(String udilistCode,String ieCode) throws BizException{
		
		UdidocDO[] udiDos = udiSrv.findByUdidoclistCode(udilistCode);
		
		if(ArrayUtil.isEmpty(udiDos))
			return null;
		
		//找到iecode匹配项目
		for (UdidocDO udidocDO : udiDos) {
			if(ieCode.equals(udidocDO.getCode_ie()))
				return udidocDO;
		}
		
		//找到code匹配项目
		for (UdidocDO udidocDO : udiDos) {
			if(ieCode.equals(udidocDO.getCode()))
				return udidocDO;
		}
		
		return null;
	}
	
	/**
	 * 获取国家信息
	 * @param countryCode
	 * @return
	 * @throws BizException
	 */
	private CountryZoneDO getCountryData(String countryCode) throws BizException{
		
		CountryZoneDO[] countryZoneDOs =  countrySrv.find("UPPER(code) = '" +countryCode.toUpperCase()+ "' ", "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(countryZoneDOs))
			return null;
		
		return countryZoneDOs[0];
	}
	
	/**
	 * 将字符串转为时间类型
	 * @param datetime
	 *            格式为yyyyMMddhhmmss
	 * @return
	 */
	private FDate changeStringTODate(String datetime) {

		FDate date = null;
		if (StringUtil.isEmpty(datetime) || datetime.length() < 9)
			return date;

		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			date = new FDate(format.parse(datetime.substring(0, 8)));
		} catch (Exception e) {
			Log.error(e);
		}

		return date;
	}

	/**
	 * 集合中添加字符串
	 * @param str
	 * @param list
	 */
	private void addToList(String str,List<String> list){
		if(!StringUtil.isEmpty(str) && !list.contains(str)){
			list.add(str);
		}
	}

	/**
	 * 数组转为insql
	 * @param array
	 * @return
	 */
	private String convertArrayToInSql(List<String> list){
		
		if(ListUtil.isEmpty(list))
			return null;
		
		String inSql = "(";
		for (String str : list) {
			inSql += "'" + str + "',";
		}
		
		inSql = inSql.substring(0, inSql.length() - 1);
		inSql += ")";
		
		return inSql;
	}
}
