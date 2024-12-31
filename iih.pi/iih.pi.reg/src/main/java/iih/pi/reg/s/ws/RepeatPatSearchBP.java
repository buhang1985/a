package iih.pi.reg.s.ws;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.pi.params.PiParams;
import iih.pi.reg.dto.d.PiPatBS501CondDTO;
import iih.pi.reg.dto.d.PiPatBS520CondDTO;
import iih.pi.reg.dto.d.PiPatRepeatDTO;
import iih.pi.reg.dto.d.PiPatWSResultDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.log.Log;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.i.IAdminareaRService;

/**
 * 患者信息查询
 * 
 * @author ly
 *
 */
public class RepeatPatSearchBP {

	/**
	 * 通过患者基本信息查询服务查询数据
	 * 
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	public PiPatRepeatDTO[] searchPatByBS501(PiPatBS501CondDTO cond)
			throws BizException {

		//empi关闭时，进行简单查重
		if(!FBoolean.TRUE.equals(new PiParams().PIPAT0005())){
			String[] params = this.getIdCode(cond);
			return new SimpleCheckWhenEmpiIsOffBP().exec(cond.getName(),params[0],params[1]);
		}
		
		EmpiServiceCaller call = new EmpiServiceCaller();
		PiPatWSResultDTO[] result = call.callBS501Service(cond);

		if (ArrayUtil.isEmpty(result))
			return null;

		List<PiPatRepeatDTO> repeatList = new ArrayList<PiPatRepeatDTO>();
		for (PiPatWSResultDTO dto : result) {

			if (this.checkNull(dto))
				continue;

			PiPatRepeatDTO repeat = new PiPatRepeatDTO();
			this.copyData(repeat, dto);
			repeatList.add(repeat);
		}

		return repeatList.toArray(new PiPatRepeatDTO[repeatList.size()]);

		// return this.testMeth(cond.getSocial_no());
	}

	/**
	 * 通过HIS专用患者基本信息查询服务查询数据
	 * 
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	public PiPatRepeatDTO[] searchPatByBS520(PiPatBS520CondDTO cond)
			throws BizException {

		//empi关闭时，进行简单查重
		if(!FBoolean.TRUE.equals(new PiParams().PIPAT0005())){
			return new SimpleCheckWhenEmpiIsOffBP().exec(cond.getName(),IPiDictCodeConst.SD_IDTP_IDENTITY,cond.getSocial_no());
		}
		
		EmpiServiceCaller call = new EmpiServiceCaller();
		PiPatWSResultDTO[] result = call.callBS520Service(cond);

		if (ArrayUtil.isEmpty(result))
			return null;

		List<String> admdivList = new ArrayList<String>();
		List<PiPatRepeatDTO> repeatList = new ArrayList<PiPatRepeatDTO>();
		for (PiPatWSResultDTO dto : result) {

			if (this.checkNull(dto))
				continue;

			PiPatRepeatDTO repeat = new PiPatRepeatDTO();
			this.copyData(repeat, dto);
			repeatList.add(repeat);
			
			if(!admdivList.contains(repeat.getSd_admdiv_live()))
				admdivList.add(repeat.getSd_admdiv_live());
			
			if(!admdivList.contains(repeat.getSd_admdiv_home()))
				admdivList.add(repeat.getSd_admdiv_home());
			
			if(!admdivList.contains(repeat.getSd_admdiv_work()))
				admdivList.add(repeat.getSd_admdiv_work());
			
			if(!admdivList.contains(repeat.getSd_admdiv_native()))
				admdivList.add(repeat.getSd_admdiv_native());	
		}
		
		//取得区县地址
		Map<String,AdminAreaDO> areaMap = this.getAdminDos(admdivList);
		//处理地址
		for (PiPatRepeatDTO repeat : repeatList) {
			if(!StringUtil.isEmpty(repeat.getSd_admdiv_live())){
				AdminAreaDO area = areaMap.get(repeat.getSd_admdiv_live());
				if(area != null){
					repeat.setId_admdiv_live(area.getId_adminarea());
					repeat.setLive_street(repeat.getLive_address());
					repeat.setLive_address(area.getFullname());
					repeat.setLive_postcode(area.getZipcode());
				}
			}
			
			if(!StringUtil.isEmpty(repeat.getSd_admdiv_home())){
				AdminAreaDO area = areaMap.get(repeat.getSd_admdiv_home());
				if(area != null){
					repeat.setId_admdiv_home(area.getId_adminarea());
					repeat.setHome_street(repeat.getHome_address());
					repeat.setHome_address(area.getFullname());
					repeat.setHome_postcode(area.getZipcode());
				}
			}
			
			if(!StringUtil.isEmpty(repeat.getSd_admdiv_work())){
				AdminAreaDO area = areaMap.get(repeat.getSd_admdiv_work());
				if(area != null){
					repeat.setId_admdiv_work(area.getId_adminarea());
					repeat.setWork_street(repeat.getWork_address());
					repeat.setWork_address(area.getFullname());
					repeat.setWork_postcode(area.getZipcode());
				}
			}
			
			if(!StringUtil.isEmpty(repeat.getSd_admdiv_native())){
				AdminAreaDO area = areaMap.get(repeat.getSd_admdiv_native());
				if(area != null){
					repeat.setId_admdiv_native(area.getId_adminarea());
					repeat.setNative_street(repeat.getNative_address());
					repeat.setNative_address(area.getFullname());
					repeat.setNative_postcode(area.getZipcode());
				}
			}
		}

		return repeatList.toArray(new PiPatRepeatDTO[repeatList.size()]);

		// return this.testMeth(cond.getSocial_no());
	}

	/**
	 * 校验检索数据关键数据是否为空
	 * 
	 * @return
	 */
	private boolean checkNull(PiPatWSResultDTO dto) {

		if (StringUtil.isEmpty(dto.getName())
				|| StringUtil.isEmpty(dto.getPatient_id()))
			return true;

		return false;

	}

	/**
	 * 设置数据
	 * 
	 * @param to
	 *            设置对象
	 * @param from
	 *            设置源
	 */
	private void copyData(PiPatRepeatDTO to, PiPatWSResultDTO from) {

		to.setEmpi_id(from.getEmpi_id());
		to.setId_pat(from.getPatient_id());
		to.setCode(from.getPatient_id());//编码
		to.setData_flag(from.getData_flag());
		to.setDomain_id(from.getDomain_id());
		to.setDomain_id_name(from.getDomain_id_name());
		
		to.setCode_amr_oep(from.getP_bar_code());
		to.setCode_amr_ip(from.getInpatient_no());
		to.setNo_hp(from.getAddition_no1());
		to.setName(from.getName());
		to.setName_sex(from.getSex_name());
		to.setDt_birth(this.changeStringTODate(from.getBirthday()));
		to.setMed_cred(null);
		to.setId_code(from.getSocial_no());
		//to.setMobile(from.getMobile());
		//to.setConttel(from.getRelation_tel());
		to.setMobile(from.getHome_tel());//家庭电话
		to.setConttel(from.getMobile());//联系电话
		
		to.setHome_address(from.getHome_address());
		to.setBirth_place(from.getBirth_place());
		
		to.setName_cont(from.getRelation_name());
		to.setRelation_code(from.getRelation_code());
		to.setRelation_code_name(from.getRelation_code_name());
		to.setRelation_tel(from.getRelation_tel());
		to.setRelation_street(from.getRelation_address() + from.getRelation_street());
		to.setRelation_zip(from.getRelation_postcode());
		
		String otherCode = "";
		if (!StringUtil.isEmpty(from.getOther_card_no_qtfd())) {
			otherCode=from.getOther_card_no_qtfd();
		}
		if (!StringUtil.isEmpty(from.getOther_card_no_jmhkb())) {
			otherCode=from.getOther_card_no_jmhkb();
		}
		if (!StringUtil.isEmpty(from.getOther_card_no_hz())) {
			otherCode=from.getOther_card_no_hz();
		}
		if (!StringUtil.isEmpty(from.getOther_card_no_jgz())) {
			otherCode=from.getOther_card_no_jgz();
		}
		if (!StringUtil.isEmpty(from.getOther_card_no_jgz())) {
			otherCode=from.getOther_card_no_jgz();
		}
		if (!StringUtil.isEmpty(from.getOther_card_no_gajm())) {
			otherCode=from.getOther_card_no_gajm();
		}
		to.setOther_card_no_qtfd(otherCode);
		to.setSd_country(from.getCountry_code());
		to.setCountry_code_name(from.getCountry_code_name());
		to.setSd_nation(from.getNation_code());
		to.setNation_code_name(from.getNation_code_name());
		to.setBorn_place(from.getBorn_place());
		to.setSd_educ(from.getEducation_code());
		to.setEducation_code_name(from.getEducation_code_name());
		to.setSd_occu(from.getOccupation_type());
		to.setOccupation_type_name(from.getOccupation_type_name());
		to.setMarry_code(from.getMarry_code());
		to.setMarry_code_name(from.getMarry_code_name());
		to.setSd_admdiv_live(from.getLive_district_code());
		to.setLive_street(from.getLive_street());
		to.setLive_address(from.getLive_address());
		to.setLive_postcode(from.getLive_postcode());
		to.setSd_admdiv_home(from.getHome_district_code());
		to.setHome_address(from.getHome_address());
		to.setHome_street(from.getHome_street());
		to.setSd_admdiv_work(from.getWork_district_code());
		to.setWork_street(from.getWork_street());
		to.setWork_address(from.getWork_address());
		to.setWork_tel(from.getWork_phone());
		to.setSd_admdiv_native(from.getNative_district_code());
		to.setNative_street(from.getNative_street());
		to.setNative_address(from.getNative_address());
		
		
		to.setScore(from.getScore());
	}

	/**
	 * 将字符串转为时间类型
	 * 
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
	 * 检索区县
	 * @param admdivList
	 * @return
	 * @throws BizException
	 */
	private Map<String,AdminAreaDO> getAdminDos(List<String> admdivList) throws BizException {
		
		Map<String,AdminAreaDO> map = new HashMap<String,AdminAreaDO>();
		
		if(ListUtil.isEmpty(admdivList))
			return map;
		
		String inSql = "(";
		for (String str : admdivList) {
			inSql += "'" + str + "',";
		}
		
		inSql = inSql.substring(0, inSql.length() - 1);
		inSql += ")";
		
		IAdminareaRService areaService = ServiceFinder.find(IAdminareaRService.class);
		AdminAreaDO[] areas = areaService.find("a0.code in" + inSql, "", FBoolean.FALSE);
		
		if(!ArrayUtil.isEmpty(areas)){
			
			for (AdminAreaDO area : areas) {
				map.put(area.getCode(), area);
			}
		}
			
		return map;
	}
	
	/**
	 * 测试代码
	 * 
	 * @param code
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private PiPatRepeatDTO[] testMeth(String code) throws BizException {

		IPatiMDORService service = ServiceFinder.find(IPatiMDORService.class);
		String whereSql = "id_code = '" + code + "' and fg_invd = 'N' ";

		PatDO[] pats = service.find(whereSql, "", FBoolean.FALSE);
		if (ArrayUtil.isEmpty(pats))
			return null;

		List<PiPatRepeatDTO> result = new ArrayList<PiPatRepeatDTO>();
		for (PatDO pat : pats) {
			PiPatRepeatDTO repeat = new PiPatRepeatDTO();
			repeat.setId_pat(pat.getId_pat());
			repeat.setCode_amr_oep(pat.getCode_amr_oep());
			repeat.setCode_amr_ip(pat.getCode_amr_ip());
			repeat.setName(pat.getName());
			repeat.setName_sex(pat.getName_sex());
			repeat.setDt_birth(pat.getDt_birth());
			repeat.setId_code(pat.getId_code());
			result.add(repeat);
		}

		return result.toArray(new PiPatRepeatDTO[0]);
	}

	/**
	 * 获取
	 * @param cond
	 * @return
	 */
	private String[] getIdCode(PiPatBS501CondDTO cond){
		
		if(StringUtil.isEmpty(cond.getSocial_no())){
			return new String[]{IPiDictCodeConst.SD_IDTP_IDENTITY,cond.getSocial_no()};
		}
		if(StringUtil.isEmpty(cond.getOther_card_no_jmhkb())){
			return new String[]{IPiDictCodeConst.SD_IDTP_JMHKB,cond.getOther_card_no_jmhkb()};
		}
		if(StringUtil.isEmpty(cond.getOther_card_no_hz())){
			return new String[]{IPiDictCodeConst.SD_IDTP_HZ,cond.getOther_card_no_hz()};
		}
		if(StringUtil.isEmpty(cond.getOther_card_no_jgz())){
			return new String[]{IPiDictCodeConst.SD_IDTP_JGZ,cond.getOther_card_no_jgz()};
		}
		if(StringUtil.isEmpty(cond.getOther_card_no_jsz())){
			return new String[]{IPiDictCodeConst.SD_IDTP_JSZ,cond.getOther_card_no_jsz()};
		}
		if(StringUtil.isEmpty(cond.getOther_card_no_gajm())){
			return new String[]{IPiDictCodeConst.SD_IDTP_GAJMZ,cond.getOther_card_no_gajm()};
		}
		if(StringUtil.isEmpty(cond.getOther_card_no_twjm())){
			return new String[]{IPiDictCodeConst.SD_IDTP_TWJMZ,cond.getOther_card_no_twjm()};
		}
		if(StringUtil.isEmpty(cond.getOther_card_no_qtfd())){
			return new String[]{IPiDictCodeConst.SD_IDTP_QTFDZ,cond.getOther_card_no_qtfd()};
		}
		
		return new String[2];
	}
}
