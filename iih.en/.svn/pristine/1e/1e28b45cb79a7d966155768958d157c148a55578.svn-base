package iih.en.ip.s.bp.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeTypeConst;
import iih.en.comm.ep.IpEP;
import iih.en.comm.ep.UdiDocEP;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.sc.apt.dto.d.AptIpDTO;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.d.UdidoclistDO;
import xap.sys.xbd.udi.i.IUdidocRService;
import xap.sys.xbd.udi.i.IUdidoclistRService;

/**
 * 获取入院通知单BP
 * 
 * @author renying
 *
 */
public class GetAptIpByEntIdBP {
	/**
	 * 查询入院通知单信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public AptIpDTO exec( String entId) throws BizException {
		//查询患者入院通知单
		List<AptIpDTO> list = this.getAptSql(entId);
		if(EnValidator.isEmpty(list))	{	
			 return null;
			}
			this.dealData(list.get(0));
			return   list.get(0);		
	}
	
	/**
	 * 查询入院通知单信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public AptIpDTO getEntInfo( String entId) throws BizException {
		//查询患者入院通知单
		List<AptIpDTO> list = this.getEntSql(entId);		
		if(EnValidator.isEmpty(list))	{	
		 return null;
		}
		this.dealData(list.get(0));
		return   list.get(0);
	}
	
	/**
	 * 未挂号，获取入院申请单
	 * @param aptIpId
	 * @return
	 * @throws BizException
	 */
	public AptIpDTO getAptIpNoEnt( String aptIpId) throws BizException {
		//查询患者入院通知单
		List<AptIpDTO> list = getAptIpNoEntSql(aptIpId);		
		if(EnValidator.isEmpty(list))	{	
		 return null;
		}
		dealData(list.get(0));
		return list.get(0);
	}
	
	/**
	 * 未挂号，获取申请单患者信息
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	public AptIpDTO getPatInfo(String patId) throws BizException {
		
		//查询申请单患者信息
		List<AptIpDTO> list = getPatSql(patId);		
		if(EnValidator.isEmpty(list))	{	
		 return null;
		}
		dealData(list.get(0));
		return list.get(0);
	}
	
	/**
	 * 处理查出来的数据
	 * @param aptIpDTO
	 * @throws BizException
	 */
	private void dealData(AptIpDTO aptIpDTO) throws BizException{			
		//设置在院状态
		if (!EnValidator.isEmpty(aptIpDTO.getId_pat())) {
			IpEP ipep = new IpEP();
			aptIpDTO.setFg_ip(ipep.IsInHos(aptIpDTO.getId_pat()));
		}
		//设置性别
		this.setUdidocList(aptIpDTO);
		//设置默认值，fanlq-2018-03-29
		setDefValus(aptIpDTO);
		// 设置患者年龄
		EnAgeCalcUtil.setDoAges(new AptIpDTO[]{aptIpDTO}, "Id_ent", "Age");						
	}
	/**
	 * 拼接查询患者是否已有入院通知单sql
	 * 
	 * @param param
	 * @return
	 * @throws DAException 
	 */
	private List<AptIpDTO> getAptSql(String entId) throws DAException {
		SqlParam param = new SqlParam();

		StringBuffer ipntBuffer = new StringBuffer();
		ipntBuffer.append(" select ");
		ipntBuffer.append(" pat.code            code_pat,");
		ipntBuffer.append(" pat.mob             tel_pat,");
		ipntBuffer.append(" pat.name            name_pat,");
		ipntBuffer.append(" pat.id_pat,");
		ipntBuffer.append(" pat.id_sex           id_sex_pat,");
		ipntBuffer.append(" pat.sd_sex           sd_sex_pat,");
		ipntBuffer.append(" pat.dt_birth         birth_pat,");
		ipntBuffer.append(" area.fullname        name_admdiv,");
		ipntBuffer.append(" area.id_adminarea    id_admdiv,");
		ipntBuffer.append(" area.code            sd_admdiv,");
		ipntBuffer.append(" addr.street          addr_pat,");
		ipntBuffer.append(" addr.id_pataddr      id_addr,");
		ipntBuffer.append(" doc.name             name_patcardtp,");
		ipntBuffer.append(" pat.id_code          sd_patcardtp_code,");
		ipntBuffer.append(" pat.barcode_chis  as Chis_pat,");//fanlq
		ipntBuffer.append("	patca.id_patca    as id_patca,");
		ipntBuffer.append("	patca.name        as name_patca,");//fanlq
		ipntBuffer.append(" docStatus.name       name_level_dise,");
		ipntBuffer.append(" dep.name             name_dep_phy_ip,");
		ipntBuffer.append(" ipnt.id_aptip        id_scaptip  ,");
		ipntBuffer.append(" ipnt.name_didef_op   name_didef_op,");
		ipntBuffer.append(" ipnt.id_didef_op     id_didef_op,");
		ipntBuffer.append(" ipnt.supplement_di as supplement_di, ");
		ipntBuffer.append(" ipnt.dt_admit_plan,  ipnt.sd_status,");
		ipntBuffer.append(" ipnt.amt_deposit,");
		ipntBuffer.append(" ipnt.note,");
		ipntBuffer.append(" ipnt.Fg_plan,");
		ipntBuffer.append(" ipnt.id_dep_phy_ip   id_dep_phy_ip,");
		ipntBuffer.append(" ipnt.id_dep_phy_ip   id_dep_phyadm,");
		ipntBuffer.append(" ipnt.sd_level_dise   sd_level_dise,");
		ipntBuffer.append(" ipnt.id_level_dise   id_level_dise,");
		ipntBuffer.append(" ipnt.Id_dep_nur_ip   Id_dep_nur_ip,");
		ipntBuffer.append(" ipnt.name_dep_op   	 Name_dep_op,");
		ipntBuffer.append(" ipnt.name_emp_phy_op   Name_emp_phy_op,");
		ipntBuffer.append(" ipnt.id_emp_phy_op   Id_emp_phy_op,");
		ipntBuffer.append(" ipnt.da_notice       Dt_notice,");
		ipntBuffer.append(" ipnt.amt_deposit,");
		//入院申请单增加字段，fanlq-add-2018.02.05
		ipntBuffer.append(" ipnt.fg_vip,");
		ipntBuffer.append(" ipnt.sd_referalsrc,");
		ipntBuffer.append(" ipnt.id_referalsrc,");
		ipntBuffer.append(" ipnt.u.name       as name_referalsrc,");
		ipntBuffer.append(" ipnt.name_cont_phy,");
		ipntBuffer.append(" ipnt.tel_cont_phy,");
		//入院申请单增加字段，fanlq-add-2018.05.31
		ipntBuffer.append(" ipnt.sd_walkwith  ,");
		ipntBuffer.append(" ipnt.id_walkwith  ,");
		ipntBuffer.append(" ipnt.id_introducer  ,");
		ipntBuffer.append(" walk.name         as name_walkwith,");
		//联系人,fanlq-2018.02.09  modified renying
		ipntBuffer.append(" entcont.id_entcont,");
		ipntBuffer.append(" patcont.name         name_patcontref,");
		ipntBuffer.append(" patcont.id_conttp,");
		ipntBuffer.append(" patcont.sd_conttp,");
		ipntBuffer.append(" patcont.conttel,");
		ipntBuffer.append(" patcont.contaddr,");
		ipntBuffer.append(" patcont.Id_patcont,");
		ipntBuffer.append(" dep2.name            name_dep_nur_ip,");
		//籍贯 zhangpp 2019.10.21
		ipntBuffer.append(" area1.id_adminarea  as id_addr_origin, ");
		ipntBuffer.append(" area1.code          as sd_addr_origin, ");
		ipntBuffer.append(" area1.fullname      as name_addr_origin, ");
		ipntBuffer.append(" ent.id_ent,");
		ipntBuffer.append(" inpsn.name          as name_introducer,");
		ipntBuffer.append(" op.sd_status           sd_status_op,");//门诊就诊状态
		//预住院
		ipntBuffer.append(" ipnt.fg_ippre, ");
		ipntBuffer.append(" ipnt.id_dep_phy_ippre, ");
		ipntBuffer.append(" dep3.name              name_dep_phy_ippre, ");
		ipntBuffer.append(" ipnt.id_dep_nur_ippre, ");
		ipntBuffer.append(" dep4.name              name_dep_nur_ippre, ");
		ipntBuffer.append(" ipnt.id_kind, ");
		ipntBuffer.append(" ipnt.sd_kind, ");
		ipntBuffer.append(" ipkind.name            name_kind, ");
		ipntBuffer.append(" ipnt.fg_bedday, ");
		ipntBuffer.append(" bedday.id_srv_opt, ");
		ipntBuffer.append(" bedday.name_srv_opt, ");
		ipntBuffer.append(" bedday.dt_opt, ");
		ipntBuffer.append(" bedday.days, ");
		ipntBuffer.append(" ipnt.dt_insert");
		ipntBuffer.append(" from pi_pat pat");
		ipntBuffer.append(" inner join en_ent ent on pat.id_pat = ent.id_pat");
		ipntBuffer.append(" inner join en_ent_op op on ent.id_ent = op.id_ent");
		ipntBuffer.append(" left outer join en_ent_di di on di.id_ent = ent.id_ent and di.fg_maj = 'Y'");
		ipntBuffer.append(" left outer join bd_udidoc doc on doc.id_udidoc = pat.id_idtp");
		ipntBuffer.append(" inner join sc_apt_ip ipnt on ipnt.id_ent = ent.id_ent and ipnt.fg_canc = 'N' and  ipnt.dt_valid >='");
		ipntBuffer.append(EnAppUtils.getServerDateTime());
		ipntBuffer.append("' and ipnt.fg_emgstay = 'N' ");
		ipntBuffer.append(" left join sc_apt_ip_bedday bedday on bedday.id_aptip = ipnt.id_aptip ");
		ipntBuffer.append(" left outer join en_ent_ip ip on ip.id_ent = ipnt.id_entip and ip.sd_status in ('22', '25') ");
		ipntBuffer.append(" left outer join pi_pat_cont patcont on patcont.id_patcont = ipnt.id_patcont");
		ipntBuffer.append(" left join en_ent_cont entcont on entcont.id_ent = ent.id_ent  and entcont.id_patcontid = patcont.id_patcont");
		ipntBuffer.append(" left outer join bd_udidoc docStatus on docStatus.id_udidoc = ipnt.id_level_dise");
		ipntBuffer.append(" left outer join bd_dep dep on dep.id_dep = ipnt.id_dep_phy_ip ");
		ipntBuffer.append(" left outer join bd_dep dep2 on dep2.id_dep = ipnt.Id_dep_nur_ip");
		ipntBuffer.append(" left outer join bd_dep dep3 on dep3.id_dep = ipnt.id_dep_phy_ippre ");
		ipntBuffer.append(" left outer join bd_dep dep4 on dep4.id_dep = ipnt.Id_dep_nur_ippre ");
		ipntBuffer.append(" left outer join bd_udidoc ipkind on ipkind.id_udidoc = ipnt.id_kind ");
		ipntBuffer.append(" left outer join pi_pat_addr addr on pat.id_pat = addr.id_pat and addr.sd_addrtp = ? ");
		ipntBuffer.append(" left outer join bd_adminarea area on addr.id_admdiv = area.id_adminarea");
		ipntBuffer.append(" left outer join pi_pat_addr addr1 on pat.id_pat = addr1.id_pat and addr1.sd_addrtp = ? ");
		ipntBuffer.append(" left outer join bd_adminarea area1 on addr1.id_admdiv = area1.id_adminarea");
		ipntBuffer.append(" left outer join bd_udidoc u on u.id_udidoc = ipnt.id_referalsrc");
		ipntBuffer.append(" left join pi_pat_ca patca on patca.id_patca = ipnt.id_patca ");//fanlq
		ipntBuffer.append(" left join bd_udidoc walk on walk.id_udidoc = ipnt.id_walkwith ");//fanlq
		ipntBuffer.append(" left outer join bd_psndoc inpsn on inpsn.id_psndoc =  ipnt.id_introducer ");
		ipntBuffer.append(" where ent.id_ent = ?   ");
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN);
		param.addParam(entId);
		
		@SuppressWarnings("unchecked")
		List<AptIpDTO> list = (List<AptIpDTO>) new DAFacade().execQuery(ipntBuffer.toString(), param, new BeanListHandler(AptIpDTO.class));
		return list;
	}
	/**
	 * 患者无入院通知单，拼接查询患者就诊信息sql
	 * @param entId
	 * @return
	 * @throws DAException 
	 */
	private  List<AptIpDTO>  getEntSql(String entId) throws DAException {
		SqlParam param = new SqlParam();
		StringBuffer ipntBuffer = new StringBuffer();
		ipntBuffer.delete(0, ipntBuffer.length());
		ipntBuffer.append(" select pat.code     code_pat,");
		ipntBuffer.append(" pat.mob             tel_pat,");
		ipntBuffer.append(" pat.name            name_pat,");
		ipntBuffer.append(" pat.id_pat,");
		ipntBuffer.append(" pat.id_sex          id_sex_pat,");
		ipntBuffer.append(" pat.sd_sex          sd_sex_pat,");
		ipntBuffer.append(" pat.dt_birth        birth_pat,");
		ipntBuffer.append(" area.fullname        name_admdiv,");
		ipntBuffer.append(" area.id_adminarea    id_admdiv,");
		ipntBuffer.append(" area.code            sd_admdiv,");
		ipntBuffer.append(" addr.street          addr_pat,");
		ipntBuffer.append(" addr.id_pataddr      id_addr,");
		ipntBuffer.append(" doc.name            name_patcardtp,");
		ipntBuffer.append(" pat.id_pat, ");
		ipntBuffer.append(" pat.id_code         sd_patcardtp_code,");
		ipntBuffer.append(" pat.barcode_chis as Chis_pat,");//fanlq
		ipntBuffer.append("	patca.id_patca as id_patca,");
		ipntBuffer.append("	patca.name as name_patca,");//fanlq
		ipntBuffer.append(" di.name_didef_dis   name_didef_op,");
		ipntBuffer.append(" di.id_didef_dis   	id_didef_op,");
		ipntBuffer.append(" di.supplement as    supplement_di, ");
		ipntBuffer.append(" op.sd_status sd_status_op,");//门诊就诊状态
		//籍贯 zhangpp 2019.10.21
		ipntBuffer.append(" area1.id_adminarea as id_addr_origin, ");
		ipntBuffer.append(" area1.code as sd_addr_origin, ");
		ipntBuffer.append(" area1.fullname as name_addr_origin, ");
//		ipntBuffer.append(" ent.addr_pat,");
		ipntBuffer.append(" ent.id_ent");
		ipntBuffer.append(" from pi_pat pat");
		ipntBuffer.append(" inner join en_ent ent");
		ipntBuffer.append(" on pat.id_pat = ent.id_pat");
		ipntBuffer.append(" inner join en_ent_op op");
		ipntBuffer.append(" on ent.id_ent = op.id_ent");
		ipntBuffer.append(" left outer join en_ent_di di");
		ipntBuffer.append(" on di.id_ent = ent.id_ent");
		ipntBuffer.append(" and di.fg_maj = 'Y'");
		ipntBuffer.append(" left outer join bd_udidoc doc");
		ipntBuffer.append(" on doc.id_udidoc = pat.id_idtp");
		ipntBuffer.append(" left outer join pi_pat_addr addr");
		ipntBuffer.append("   on pat.id_pat = addr.id_pat");
		ipntBuffer.append(" and addr.sd_addrtp = ?   ");
		ipntBuffer.append(" left outer join bd_adminarea area");
		ipntBuffer.append("   on addr.id_admdiv = area.id_adminarea");
		ipntBuffer.append(" left outer join pi_pat_addr addr1");
		ipntBuffer.append("   on pat.id_pat = addr1.id_pat");
		ipntBuffer.append(" and addr1.sd_addrtp = ?   ");
		ipntBuffer.append(" left outer join bd_adminarea area1 ");
		ipntBuffer.append("   on addr1.id_admdiv = area1.id_adminarea");
		ipntBuffer.append(" left join pi_pat_ca patca on patca.id_patca = ent.id_patca ");
		ipntBuffer.append(" where  ent.id_ent = ?");

		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN);
		param.addParam(entId);
		@SuppressWarnings("unchecked")
		List<AptIpDTO> list = (List<AptIpDTO>) new DAFacade().execQuery(ipntBuffer.toString(), param, new BeanListHandler(AptIpDTO.class));
		return list;
	}
	
	/**
	 * 未挂号，获取入院申请单
	 * @param aptIpId
	 * @return
	 * @throws DAException
	 */
	private List<AptIpDTO> getAptIpNoEntSql(String aptIpId) throws DAException {
		
		SqlParam param = new SqlParam();
		StringBuffer ipntBuffer = new StringBuffer();
		ipntBuffer.append(" select pat.id_pat,");
		ipntBuffer.append(" pat.code                as code_pat,");
		ipntBuffer.append(" pat.mob                 as tel_pat,");
		ipntBuffer.append(" pat.name                as name_pat,");
		ipntBuffer.append(" pat.id_sex              as id_sex_pat,");
		ipntBuffer.append(" pat.sd_sex              as sd_sex_pat,");
		ipntBuffer.append(" pat.dt_birth            as birth_pat,");
		ipntBuffer.append(" area.fullname           as name_admdiv,");
		ipntBuffer.append(" area.id_adminarea       as id_admdiv,");
		ipntBuffer.append(" area.code               as sd_admdiv,");
		ipntBuffer.append(" addr.street             as addr_pat,");
		ipntBuffer.append(" addr.id_pataddr         as id_addr,");
		ipntBuffer.append(" doc.name                as name_patcardtp,");
		ipntBuffer.append(" pat.id_code             as sd_patcardtp_code,");
		ipntBuffer.append(" pat.barcode_chis        as Chis_pat,");
		ipntBuffer.append("	patca.id_patca          as id_patca,");
		ipntBuffer.append("	patca.name              as name_patca,");
		ipntBuffer.append(" docStatus.name          as name_level_dise,");
		ipntBuffer.append(" dep.name                as name_dep_phy_ip,");
		ipntBuffer.append(" ipnt.id_aptip           as id_scaptip,");
		ipntBuffer.append(" ipnt.name_didef_op      as name_didef_op,");
		ipntBuffer.append(" ipnt.id_didef_op        as id_didef_op,");
		ipntBuffer.append(" ipnt.supplement_di      as supplement_di,");
		ipntBuffer.append(" ipnt.dt_admit_plan,");
		ipntBuffer.append(" ipnt.sd_status,");
		ipntBuffer.append(" ipnt.amt_deposit,");
		ipntBuffer.append(" ipnt.note,");
		ipntBuffer.append(" ipnt.Fg_plan,");
		ipntBuffer.append(" ipnt.id_dep_phy_ip      as id_dep_phy_ip,");
		ipntBuffer.append(" ipnt.id_dep_phy_ip      as id_dep_phyadm,");
		ipntBuffer.append(" ipnt.sd_level_dise      as sd_level_dise,");
		ipntBuffer.append(" ipnt.id_level_dise      as id_level_dise,");
		ipntBuffer.append(" ipnt.Id_dep_nur_ip      as id_dep_nur_ip,");
		ipntBuffer.append(" ipnt.name_dep_op   	    as name_dep_op,");
		ipntBuffer.append(" ipnt.name_emp_phy_op    as name_emp_phy_op,");
		ipntBuffer.append(" ipnt.id_emp_phy_op      as id_emp_phy_op,");
		ipntBuffer.append(" ipnt.da_notice          as dt_notice,");
		ipntBuffer.append(" ipnt.amt_deposit,");
		ipntBuffer.append(" ipnt.fg_vip,");
		ipntBuffer.append(" ipnt.sd_referalsrc,");
		ipntBuffer.append(" ipnt.id_referalsrc,");
		ipntBuffer.append(" u.name                  as name_referalsrc,");
		ipntBuffer.append(" ipnt.name_cont_phy,");
		ipntBuffer.append(" ipnt.tel_cont_phy,");
		ipntBuffer.append(" ipnt.sd_walkwith,");
		ipntBuffer.append(" ipnt.id_walkwith,");
		ipntBuffer.append(" ipnt.id_introducer,");
		ipntBuffer.append(" walk.name               as name_walkwith,");
		//ipntBuffer.append(" entcont.id_entcont,");
		ipntBuffer.append(" patcont.name            as name_patcontref,");
		ipntBuffer.append(" patcont.id_conttp,");
		ipntBuffer.append(" patcont.sd_conttp,");
		ipntBuffer.append(" patcont.conttel,");
		ipntBuffer.append(" patcont.contaddr,");
		ipntBuffer.append(" patcont.Id_patcont,");
		ipntBuffer.append(" dep2.name               as name_dep_nur_ip,");
		ipntBuffer.append(" area1.id_adminarea      as id_addr_origin, ");
		ipntBuffer.append(" area1.code              as sd_addr_origin, ");
		ipntBuffer.append(" area1.fullname          as name_addr_origin, ");
		ipntBuffer.append(" inpsn.name              as name_introducer,");
		ipntBuffer.append(" ipnt.fg_ippre           as fg_ippre, ");
		ipntBuffer.append(" ipnt.id_dep_phy_ippre   as id_dep_phy_ippre, ");
		ipntBuffer.append(" dep3.name               as name_dep_phy_ippre, ");
		ipntBuffer.append(" ipnt.id_dep_nur_ippre   as id_dep_nur_ippre, ");
		ipntBuffer.append(" dep4.name               as name_dep_nur_ippre, ");
		ipntBuffer.append(" ipnt.id_kind            as id_kind, ");
		ipntBuffer.append(" ipnt.sd_kind            as sd_kind, ");
		ipntBuffer.append(" ipkind.name             as name_kind, ");
		ipntBuffer.append(" ipnt.fg_bedday, ");
		ipntBuffer.append(" bedday.id_srv_opt, ");
		ipntBuffer.append(" bedday.name_srv_opt, ");
		ipntBuffer.append(" bedday.dt_opt, ");
		ipntBuffer.append(" bedday.days, ");
		ipntBuffer.append(" ipnt.dt_insert");
		ipntBuffer.append(" from sc_apt_ip ipnt");
		ipntBuffer.append(" inner join pi_pat pat on pat.id_pat = ipnt.id_pat");
		ipntBuffer.append(" left join sc_apt_ip_bedday bedday on bedday.id_aptip = ipnt.id_aptip");
		ipntBuffer.append(" left outer join bd_udidoc doc on doc.id_udidoc = pat.id_idtp");
		ipntBuffer.append(" left outer join pi_pat_cont patcont on patcont.id_patcont = ipnt.id_patcont");
		//ipntBuffer.append(" left join en_ent_cont entcont on entcont.id_ent = ent.id_ent  and entcont.id_patcontid = patcont.id_patcont");
		ipntBuffer.append(" left outer join bd_udidoc docStatus on docStatus.id_udidoc = ipnt.id_level_dise");
		ipntBuffer.append(" left outer join bd_dep dep on dep.id_dep = ipnt.id_dep_phy_ip ");
		ipntBuffer.append(" left outer join bd_dep dep2 on dep2.id_dep = ipnt.Id_dep_nur_ip");
		ipntBuffer.append(" left outer join bd_dep dep3 on dep3.id_dep = ipnt.id_dep_phy_ippre ");
		ipntBuffer.append(" left outer join bd_dep dep4 on dep4.id_dep = ipnt.Id_dep_nur_ippre ");
		ipntBuffer.append(" left outer join bd_udidoc ipkind on ipkind.id_udidoc = ipnt.id_kind ");
		ipntBuffer.append(" left outer join pi_pat_addr addr on pat.id_pat = addr.id_pat and addr.sd_addrtp = ?");
		ipntBuffer.append(" left outer join bd_adminarea area on addr.id_admdiv = area.id_adminarea");
		ipntBuffer.append(" left outer join pi_pat_addr addr1 on pat.id_pat = addr1.id_pat and addr1.sd_addrtp = ?");
		ipntBuffer.append(" left outer join bd_adminarea area1 on addr1.id_admdiv = area1.id_adminarea");
		ipntBuffer.append(" left outer join bd_udidoc u on u.id_udidoc = ipnt.id_referalsrc");
		ipntBuffer.append(" left join pi_pat_ca patca on patca.id_patca = ipnt.id_patca ");
		ipntBuffer.append(" left join bd_udidoc walk on walk.id_udidoc = ipnt.id_walkwith ");
		ipntBuffer.append(" left outer join bd_psndoc inpsn on inpsn.id_psndoc =  ipnt.id_introducer ");
		ipntBuffer.append(" where ipnt.id_aptip = ?");
		ipntBuffer.append(" and ipnt.fg_canc = ?");
		ipntBuffer.append(" and ipnt.dt_valid >= ?");
		ipntBuffer.append(" and ipnt.fg_emgstay = ?");
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN);
		param.addParam(aptIpId);
		param.addParam(FBoolean.FALSE);
		param.addParam(EnAppUtils.getServerDateTime());
		param.addParam(FBoolean.FALSE);
		
		@SuppressWarnings("unchecked")
		List<AptIpDTO> list = (List<AptIpDTO>) new DAFacade().execQuery(ipntBuffer.toString(), param, new BeanListHandler(AptIpDTO.class));
		return list;
	}
	
	/**
	 * 未挂号，查询申请单患者信息
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private List<AptIpDTO> getPatSql(String patId) throws BizException {
		
		SqlParam param = new SqlParam();
		StringBuffer ipntBuffer = new StringBuffer();
		ipntBuffer.append(" select");
		ipntBuffer.append(" pat.id_pat          as id_pat, ");
		ipntBuffer.append(" pat.code            as code_pat,");
		ipntBuffer.append(" pat.mob             as tel_pat,");
		ipntBuffer.append(" pat.name            as name_pat,");
		ipntBuffer.append(" pat.id_sex          as id_sex_pat,");
		ipntBuffer.append(" pat.sd_sex          as sd_sex_pat,");
		ipntBuffer.append(" pat.dt_birth        as birth_pat,");
		ipntBuffer.append(" area.fullname       as name_admdiv,");
		ipntBuffer.append(" area.id_adminarea   as id_admdiv,");
		ipntBuffer.append(" area.code           as sd_admdiv,");
		ipntBuffer.append(" addr.street         as addr_pat,");
		ipntBuffer.append(" addr.id_pataddr     as id_addr,");
		ipntBuffer.append(" doc.name            as name_patcardtp,");
		ipntBuffer.append(" pat.id_code         as sd_patcardtp_code,");
		ipntBuffer.append(" pat.barcode_chis    as Chis_pat,");
		ipntBuffer.append("	patca.id_patca      as id_patca,");
		ipntBuffer.append("	patca.name          as name_patca,");
		ipntBuffer.append(" area1.id_adminarea  as id_addr_origin, ");
		ipntBuffer.append(" area1.code          as sd_addr_origin, ");
		ipntBuffer.append(" area1.fullname      as name_addr_origin ");
		ipntBuffer.append(" from ");
	    ipntBuffer.append(" pi_pat pat");
		ipntBuffer.append(" left outer join bd_udidoc doc on doc.id_udidoc = pat.id_idtp");
		ipntBuffer.append(" left outer join pi_pat_addr addr on pat.id_pat = addr.id_pat and addr.sd_addrtp = ?");
		ipntBuffer.append(" left outer join bd_adminarea area on addr.id_admdiv = area.id_adminarea");
		ipntBuffer.append(" left outer join pi_pat_addr addr1 on pat.id_pat = addr1.id_pat and addr1.sd_addrtp = ?");
		ipntBuffer.append(" left outer join bd_adminarea area1 on addr1.id_admdiv = area1.id_adminarea");
		ipntBuffer.append(" left join pi_pat_ca patca on patca.id_patca = pat.id_paticate ");
		ipntBuffer.append(" where ");
		ipntBuffer.append(" pat.id_pat = ?");
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN);
		param.addParam(patId);
		@SuppressWarnings("unchecked")
		List<AptIpDTO> list = (List<AptIpDTO>) new DAFacade().execQuery(ipntBuffer.toString(), param, new BeanListHandler(AptIpDTO.class));
		return list;
	}
	
	/**
	 * 设置自定义档案的值
	 * 
	 * @param pregDocDTO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void setUdidocList(AptIpDTO entipntDTO) throws BizException {
		UdiDocEP docEp = new UdiDocEP();
		FArrayList idlist = new FArrayList();
		idlist.add(IPiDictCodeTypeConst.SD_SEX_CODE);

		Map<String, UdidocDO> map = docEp.getUdiDocsByCodes(idlist);
		if (EnValidator.isEmpty(map)) {
			return;
		}
		// 性别
		if (map.get(entipntDTO.getId_sex_pat()) != null) {
			entipntDTO.setName_sex_pat(map.get(entipntDTO.getId_sex_pat()).getName());
		}
	}
	

	/***
	 * 设置入院申请单默认值
	 * @author fanlq 
	 * @param entipntDTO
	 * @throws BizException 
	 */
	private void setDefValus(AptIpDTO entipntDTO) throws BizException{
		IUdidocRService service = ServiceFinder.find(IUdidocRService.class);
		IUdidoclistRService listservice = ServiceFinder.find(IUdidoclistRService.class);
		UdidoclistDO[] listDOs = listservice.find("code = '"+IEnDictCodeTypeConst.CODE_UDIDOCLIST_IP+"'", null, FBoolean.FALSE);
		if(listDOs != null && listDOs[0] != null){
			UdidocDO[] ralsrcudidocDos = service.find("id_udidoclist = '"+listDOs[0].getId_udidoclist()+"' and code = '"+IBdFcDictCodeConst.SD_REFERALSRC_OP+"'",  null, FBoolean.FALSE);
			if(entipntDTO !=null && EnValidator.isEmpty(entipntDTO.getId_referalsrc()) && ralsrcudidocDos != null && ralsrcudidocDos.length > 0 && ralsrcudidocDos[0] != null){
				entipntDTO.setId_referalsrc(ralsrcudidocDos[0].getId_udidoc());
				entipntDTO.setSd_referalsrc(ralsrcudidocDos[0].getCode());
				entipntDTO.setName_referalsrc(ralsrcudidocDos[0].getName());
			}
		}
		if(entipntDTO !=null && EnValidator.isEmpty(entipntDTO.getName_cont_phy())  && EnValidator.isEmpty(entipntDTO.getName_cont_phy()) ){
			entipntDTO.setId_cont_phy(EnContextUtils.getPsnDoc().getId_psndoc());
			entipntDTO.setName_cont_phy(EnContextUtils.getPsnDoc().getName());
		}
		UdidoclistDO[] statelistDOs = listservice.find("code = '"+IBdFcDictCodeConst.CODE_UDIDOCLIST_DIS+"'", null, FBoolean.FALSE);
		if(statelistDOs != null && statelistDOs[0] != null){
			UdidocDO[] stateudidocDos = service.find("id_udidoclist = '"+statelistDOs[0].getId_udidoclist()+"' and code = '"+IBdFcDictCodeConst.CONDITION_GRADE_ORDINARY+"'",  null, FBoolean.FALSE);
			if(entipntDTO !=null && EnValidator.isEmpty(entipntDTO.getId_level_dise()) && stateudidocDos != null && stateudidocDos.length > 0 && stateudidocDos[0] != null){
				entipntDTO.setId_level_dise(stateudidocDos[0].getId_udidoc());
				entipntDTO.setSd_level_dise(stateudidocDos[0].getCode());
				entipntDTO.setName_level_dise(stateudidocDos[0].getName());
			}
		}
	}
}
