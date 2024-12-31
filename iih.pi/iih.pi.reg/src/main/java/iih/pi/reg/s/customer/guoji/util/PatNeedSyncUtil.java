package iih.pi.reg.s.customer.guoji.util;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.pripat.d.PriPatDO;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.reg.dto.patap.d.PiPatChisInfoDTO;
import iih.pi.reg.i.IPiPatConst;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.s.bp.util.GetUdidocDOUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import xap.lui.tools.pinyin.CnToPy;
import xap.lui.tools.pinyin.CnToWB;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.AdminAreaDO;
import xap.sys.bdfw.bbd.d.desc.AdminAreaDODesc;
import xap.sys.bdfw.bbd.i.IAdminareaRService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 患者同步验证工具类
 * @author ly 2017/08/18
 *
 */
public class PatNeedSyncUtil {
	
	/**
	 * 校验是否同步
	 * @param chisPat
	 * @param aggDo
	 * @return
	 * @throws BizException
	 */
	public static boolean needSync(PiPatChisInfoDTO chisPat,PatiAggDO aggDo) throws BizException{
		
		boolean ifChange = false;
		
		PatDO pat = aggDo.getParentDO();
		
		//姓名
		if(!pat.getName().equals(chisPat.getName())){
			pat.setName(chisPat.getName());
			pat.setPycode(CnToPy.getPyFirstCode(pat.getName()));//拼音码
			pat.setWbcode(CnToWB.getWBCode(pat.getName()));//五笔码
			ifChange = true;
		}
		
		//患者条码
		if(!pat.getBarcode_chis().equals(chisPat.getP_bar_code())){
			pat.setBarcode_chis(chisPat.getP_bar_code());
			ifChange = true;
		}
		
		//出生日期
		if (chisPat.getBirthday() != null && 
				(pat.getDt_birth() == null || 
				!pat.getDt_birth().toString().equals(chisPat.getBirthday().toString()))){
			pat.setDt_birth(chisPat.getBirthday());
			ifChange = true;
		}
		
		//性别
		if(!StringUtil.isEmpty(chisPat.getSex()) && !chisPat.getSex().equals(pat.getSd_sex())){
			if(IPiPatConst.OLDCHIS_SEX_MAN.equals(chisPat.getSex())){//性别
				pat.setId_sex(IPiDictCodeConst.ID_SEX_MALE);
				pat.setSd_sex(IPiDictCodeConst.SD_SEX_MALE);
				pat.setName_sex(IPiDictCodeConst.NAME_SEX_MALE);
			}else if(IPiPatConst.OLDCHIS_SEX_WOMAN.equals(chisPat.getSex())){
				pat.setId_sex(IPiDictCodeConst.ID_SEX_FEMALE);
				pat.setSd_sex(IPiDictCodeConst.SD_SEX_FEMALE);
				pat.setName_sex(IPiDictCodeConst.NAME_SEX_FEMALE);
			}else{
				pat.setId_sex(IPiDictCodeConst.ID_SEX_UNEXPLAIN);
				pat.setSd_sex(IPiDictCodeConst.SD_SEX_UNEXPLAIN);
				pat.setName_sex(IPiDictCodeConst.NAME_SEX_UNEXPLAIN);
			}
			ifChange = true;
		}
		
		//患者身份
		if(!StringUtil.isEmpty(chisPat.getResponse_type()) && 
				!chisPat.getResponse_type().equals(pat.getPaticate_code())){
			PiPatCaDO caDo = getPatCa(chisPat.getResponse_type());
			if(caDo != null){
				pat.setId_paticate(caDo.getId_patca());//患者分类
				pat.setPaticate_code(caDo.getCode());
				pat.setPaticate_name(caDo.getName());
				ifChange = true;
			}
		}
		
		//价格分类
		if(!StringUtil.isEmpty(chisPat.getCharge_grade()) && 
				!chisPat.getCharge_grade().equals(pat.getPatpritp_code())){
			PriPatDO priDo = getPatPri(chisPat.getCharge_grade());
			if(priDo != null){
				pat.setId_patpritp(priDo.getId_pripat());
				pat.setPatpritp_code(priDo.getCode());
				pat.setPatpritp_name(priDo.getName());
				ifChange = true;
			}
		}
		
		//证件类型
		if (!(chisPat.getBlack_flag() + "").equals(pat.getSd_idtp() + "")) {
			UdidocDO doc = GetUdidocDOUtil.getDoc(IPiDictCodeTypeConst.SD_IDTP, chisPat.getBlack_flag());
			if(doc != null){
				pat.setId_idtp(doc.getId_udidoc());
				pat.setSd_idtp(doc.getCode());
				pat.setIdtp_name(doc.getName());
				ifChange = true;
			}
		}
		
		//证件号
		if (!(chisPat.getSocial_no() + "").toUpperCase().equals(pat.getId_code() + "")) {
			pat.setId_code(chisPat.getSocial_no().toUpperCase());
			ifChange = true;
		}
		
		//联系电话
		String tel = !StringUtil.isEmpty(pat.getMob()) ? pat.getMob() : 
			!StringUtil.isEmpty(pat.getTel()) ? pat.getTel() : "";
		if(!StringUtil.isEmpty(chisPat.getHome_tel()) && !tel.equals(chisPat.getHome_tel())){
			if(chisPat.getHome_tel().indexOf("1") == 0 && chisPat.getHome_tel().length() == 11){
				pat.setMob(chisPat.getHome_tel());
			}else{
				pat.setTel(chisPat.getHome_tel());
			}
			ifChange = true;
		}
		
		//户籍类型
		if(!(pat.getSd_srcregiontp() + "").equals(chisPat.getHome_district() + "")){
			
			UdidocDO doc = GetUdidocDOUtil.getDoc(IPiDictCodeTypeConst.SD_SRCREGIONTP_CODE, chisPat.getHome_district());
			if(doc != null){
				pat.setId_srcregiontp(doc.getId_udidoc());
				pat.setSd_srcregiontp(doc.getCode());
				pat.setName_srcregiontp(doc.getName());
				ifChange = true;
			}
		}
		
		//实名标志
		if((IPiPatConst.OLDCHIS_FG_REALNAME.equals(chisPat.getIdentify_flag()) || chisPat.getIdentify_flag() == null) && 
				!FBoolean.TRUE.equals(pat.getFg_realname())){
			pat.setFg_realname(FBoolean.TRUE);
			ifChange = true;
		}
		
		//现在住址
		PatiAddrDO addr = getNowAddr(aggDo);
		if(!StringUtil.isEmpty(chisPat.getTemp_district()) || 
				!StringUtil.isEmpty(chisPat.getTemp_street())){
			if(addr == null){
				addr = new PatiAddrDO();
				addr.setStatus(DOStatus.NEW);
				addr.setId_pat(pat.getId_pat());
				addr.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
				addr.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
				addr.setAddrtp_name("现住址");
				
				AdminAreaDO area = getAddress(chisPat.getTemp_district());
				if(area != null){
					addr.setId_admdiv(area.getId_adminarea());
					addr.setSd_admdiv(area.getCode());
					addr.setAdmdiv_fullname(area.getFullname());
					addr.setZip(area.getZipcode());
				}
				addr.setStreet(chisPat.getTemp_street());
				PatiAddrDO[] oldaddrs  = aggDo.getPatiAddrDO();
				List<PatiAddrDO> newAddrList = new ArrayList<PatiAddrDO>();
				if(!ArrayUtil.isEmpty(oldaddrs)){
					newAddrList.addAll(Arrays.asList(oldaddrs));
				}
				newAddrList.add(addr);
				aggDo.setPatiAddrDO(newAddrList.toArray(new PatiAddrDO[0]));
				ifChange = true;
			}else{
				if(!(addr.getSd_admdiv() + "").equals(chisPat.getTemp_district() + "") || 
						!(addr.getStreet() + "").equals(chisPat.getTemp_street() + "")){
					addr.setStatus(DOStatus.UPDATED);
					AdminAreaDO area = getAddress(chisPat.getTemp_district());
					if(area != null){
						addr.setId_admdiv(area.getId_adminarea());
						addr.setSd_admdiv(area.getCode());
						addr.setAdmdiv_fullname(area.getFullname());
						addr.setZip(area.getZipcode());
					}
					addr.setStreet(chisPat.getTemp_street());
					ifChange = true;
				}
			}
		}
		
		//医保号
		PiPatHpDO hpDo = getBJHp(aggDo);
		if(!StringUtil.isEmpty(chisPat.getAddition_no1())){
			if(hpDo == null){
				hpDo = new PiPatHpDO();
				hpDo.setStatus(DOStatus.NEW);
				hpDo.setId_pat(pat.getId_pat());
				hpDo.setNo_hp(chisPat.getAddition_no1());
				hpDo.setId_hp(IPiPatConst.BJ_ID_HP);
				hpDo.setFg_deft(FBoolean.TRUE);
				hpDo.setMode_hp(IPiDictCodeConst.ID_HP_ENABLE);
				hpDo.setFg_act(FBoolean.TRUE);
				
				HPDO hpDic = (HPDO)new DAFacade().findByPK(HPDO.class, IPiPatConst.BJ_ID_HP);
				if(hpDic != null){
					hpDo.setHp_name(hpDic.getName());
				}
				
				PiPatHpDO[] oldHpDos = aggDo.getPiPatHpDO();
				List<PiPatHpDO> newHpDoList = new ArrayList<PiPatHpDO>();
				if(ArrayUtil.isEmpty(oldHpDos)){
					hpDo.setSortno(1);
				}else{
					hpDo.setSortno(oldHpDos.length + 1);
				}
				newHpDoList.add(hpDo);
				aggDo.setPiPatHpDO(newHpDoList.toArray(new PiPatHpDO[0]));
				ifChange = true;
			}else{
				if(!chisPat.getAddition_no1().equals(hpDo.getNo_hp())){
					hpDo.setStatus(DOStatus.UPDATED);
					hpDo.setNo_hp(chisPat.getAddition_no1());
					ifChange = true;
				}
			}
		}else if(hpDo != null){
			hpDo.setStatus(DOStatus.DELETED);
			ifChange = true;
		}
		
		//监护人
		PiPatContDO oldGuarder = getGuardianCont(aggDo);
		if(!StringUtil.isEmpty(chisPat.getGuarder_social_no())) {
			PiPatContDO guarder = new PiPatContDO();
			guarder.setStatus(DOStatus.NEW);
			guarder.setId_pat(pat.getId_pat());
			guarder.setId_conttp(IPiDictCodeConst.ID_CONT_TYPE_PARENT);
			guarder.setSd_conttp(IPiDictCodeConst.SD_CONT_TYPE_PARENT);
			guarder.setConttp_name("父母");
			guarder.setName(chisPat.getGuarder_name());
			guarder.setContid(chisPat.getGuarder_social_no());
			guarder.setId_cont(IPiDictCodeConst.ID_IDTP_IDENTITY);
			guarder.setSd_cont(IPiDictCodeConst.SD_IDTP_IDENTITY);
			guarder.setContname("居民身份证");
			guarder.setFg_guardian(FBoolean.TRUE);
			if (oldGuarder != null) {				
				oldGuarder.setStatus(DOStatus.DELETED);
			}
			PiPatContDO[] contdos = aggDo.getPiPatContDO();
			List<PiPatContDO> contlist = new ArrayList<PiPatContDO>();
			contlist.addAll(Arrays.asList(contdos));
			guarder.setSortno(contlist.size() + 1);
			contlist.add(guarder);
			aggDo.setPiPatContDO(contlist.toArray(new PiPatContDO[0]));
			ifChange = true;
		}
		
		if(ifChange){
			pat.setStatus(DOStatus.UPDATED);
			pat.setOrigin(IPiPatConst.PAT_ORIGIN_CHIS);
		}
		
		return ifChange;
	}
	
	/**
	 * 取得患者分类
	 * @param code
	 * @return
	 * @throws BizException
	 */
	private static PiPatCaDO getPatCa(String code) throws BizException{
		
		DAFacade daf = new DAFacade();
		String sql = "select id_patca,code,name from pi_pat_ca where code = ? and id_org = ? and ds = 0";
		SqlParam param = new SqlParam();
		param.addParam(code);
		param.addParam(Context.get().getOrgId());
		
		PiPatCaDO caDo = (PiPatCaDO)daf.execQuery(sql, param, new BeanHandler(PiPatCaDO.class));
		
		return caDo;
	}
	
	/**
	 * 获取患者价格分类
	 * @param code
	 * @return
	 * @throws BizException
	 */
	public static PriPatDO getPatPri(String code) throws BizException{
		
		DAFacade daf = new DAFacade();
		String sql = "select id_pripat,code,name from bd_pri_pat where code = ? and id_org = ? and ds = 0";
		SqlParam param = new SqlParam();
		param.addParam(code);
		param.addParam(Context.get().getOrgId());
		
		PriPatDO caDo = (PriPatDO)daf.execQuery(sql, param, new BeanHandler(PriPatDO.class));
		
		return caDo;
	}
	
	
	/**
	 * 获取现住址
	 * @param aggDo
	 * @return
	 */
	private static PatiAddrDO getNowAddr(PatiAggDO aggDo){
		
		if(ArrayUtil.isEmpty(aggDo.getPatiAddrDO()))
			return null;
		
		for (PatiAddrDO addr : aggDo.getPatiAddrDO()) {
			if(IPiDictCodeConst.SD_ADDR_TYPE_NOW.equals(addr.getSd_addrtp()))
				return addr;
		}
		
		return null;
	}

	/**
	 * 获取北京医保
	 * @param aggDo
	 * @return
	 */
	private static PiPatHpDO getBJHp(PatiAggDO aggDo){
		
		if(ArrayUtil.isEmpty(aggDo.getPiPatHpDO()))
			return null;
		
		for (PiPatHpDO hp : aggDo.getPiPatHpDO()) {
			if(IPiPatConst.BJ_ID_HP.equals(hp.getId_hp()))
					return hp;
		}
		
		return null;
	}
	
	/**
	 * 获取监护人
	 * @param aggDo
	 * @return
	 */
	private static PiPatContDO getGuardianCont(PatiAggDO aggDo) {
		
		if(ArrayUtil.isEmpty(aggDo.getPiPatContDO()))
			return null;
		
		for (PiPatContDO gc : aggDo.getPiPatContDO()) {
			if(FBoolean.TRUE.equals(gc.getFg_guardian()))
					return gc;
		}
		
		return null;
	}
	
	/**
	 * 取得区县对应的
	 * @param regionCode
	 * @return
	 * @throws BizException
	 */
	private static AdminAreaDO getAddress(String regionCode) throws BizException {
		
		if(StringUtil.isEmpty(regionCode))
			return null;
		
		IAdminareaRService areaService = ServiceFinder.find(IAdminareaRService.class);
		String whereSql = AdminAreaDODesc.TABLE_ALIAS_NAME + ".code = '" +regionCode+ "'";
		AdminAreaDO[] areas = areaService.find(whereSql, "", FBoolean.FALSE);
		
		if(ArrayUtil.isEmpty(areas))
			return null;
		
		return areas[0];
	}
}
