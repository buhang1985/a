package iih.en.pv.s.bp.op;

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
public class GetEnIpntBP {
	/**
	 * 查询入院通知单信息
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public AptIpDTO[] exec(String patId, String entId) throws BizException {
		//查询患者入院通知单
		SqlParam param = new SqlParam();
		String ipntSql = this.getSql1(param, patId);
		List<AptIpDTO> list = (List<AptIpDTO>) new DAFacade().execQuery(ipntSql, param, new BeanListHandler(AptIpDTO.class));
		//本次就诊无入院通知单标志
		boolean flag = true;
		if (!list.isEmpty()) {
			for (AptIpDTO aptIpDTO : list) {
				if (entId.equals(aptIpDTO.getId_ent())) {
					flag = false;
				}
			}
		}
		//患者本次就诊无入院通知单
		if (flag) {
			param.clearParams();
			ipntSql = this.getSql2(param, patId, entId);
			List<AptIpDTO> patList = (List<AptIpDTO>) new DAFacade().execQuery(ipntSql, param, new BeanListHandler(AptIpDTO.class));
			if (!patList.isEmpty()){
				list.add(patList.get(0));
			}
		}

		if (!list.isEmpty()) {
			for (AptIpDTO entipntDTO : list) {
				if (!EnValidator.isEmpty(entipntDTO.getId_pat())) {
					IpEP ipep = new IpEP();
					entipntDTO.setFg_ip(ipep.IsInHos(entipntDTO.getId_pat()));
				}
				// this.getEntDI(entipntDTO);
				//设置性别
				this.setUdidocList(entipntDTO);
				// 设置患者年龄
				//entipntDTO.setAge(AgeCalcUtil.getAge(entipntDTO.getBirth_pat()));
				//设置默认值，fanlq-2018-03-29
				setDefValus(entipntDTO, entId);
			}
			// 设置患者年龄
			EnAgeCalcUtil.setDoAges(list.toArray(new AptIpDTO[]{}), "Id_ent", "Age");
			return list.toArray(new AptIpDTO[]{});
		}
		
		return null;
	}
	/**
	 * 拼接查询患者是否已有入院通知单sql
	 * 
	 * @param param
	 * @return
	 */
	private String getSql1(SqlParam param, String patId) {
		StringBuffer ipntBuffer = new StringBuffer();
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
		ipntBuffer.append(" ipnt.name_didef_op   name_didef_op,");
		ipntBuffer.append(" ipnt.id_didef_op   id_didef_op,");
		ipntBuffer.append(" ipnt.supplement_di as    supplement_di, ");
		ipntBuffer.append(" docStatus.name      name_level_dise,");
		ipntBuffer.append(" dep.name            name_dep_phy_ip,");
		ipntBuffer.append(" ipnt.id_aptip   id_scaptip  ,");
		ipntBuffer.append(" ipnt.dt_admit_plan, ipnt.sd_status,");
		ipntBuffer.append(" ipnt.amt_deposit,");
		ipntBuffer.append(" ipnt.note,");
		ipntBuffer.append(" ipnt.Fg_plan,");
		ipntBuffer.append(" ipnt.id_dep_phy_ip     id_dep_phy_ip,");
		ipntBuffer.append(" ipnt.id_dep_phy_ip     id_dep_phyadm,");
		ipntBuffer.append(" ipnt.sd_level_dise   sd_level_dise,");
		ipntBuffer.append(" ipnt.id_level_dise   id_level_dise,");
		ipntBuffer.append(" ipnt.Id_dep_nur_ip   Id_dep_nur_ip,");
		ipntBuffer.append(" ipnt.name_dep_op   	 Name_dep_op,");
		ipntBuffer.append(" ipnt.name_emp_phy_op   Name_emp_phy_op,");
		ipntBuffer.append(" ipnt.id_emp_phy_op   Id_emp_phy_op,");
		ipntBuffer.append(" ipnt.da_notice   Dt_notice,");
		ipntBuffer.append(" ipnt.amt_deposit  ,");
		
		//入院申请单增加字段，fanlq-add-2018.02.05
		ipntBuffer.append(" ipnt.fg_vip  ,");
		ipntBuffer.append(" ipnt.sd_referalsrc  ,");
		ipntBuffer.append(" ipnt.id_referalsrc  ,");
		ipntBuffer.append(" u.name as name_referalsrc,");
		ipntBuffer.append(" ipnt.name_cont_phy  ,");
		ipntBuffer.append(" ipnt.tel_cont_phy  ,");
		//入院申请单增加字段，fanlq-add-2018.05.31
		ipntBuffer.append(" ipnt.sd_walkwith  ,");
		ipntBuffer.append(" ipnt.id_walkwith  ,");
		ipntBuffer.append(" ipnt.id_introducer  ,");
		ipntBuffer.append(" walk.name as name_walkwith,");
		//联系人,fanlq-2018.02.09  modified renying
		ipntBuffer.append("   entcont.id_entcont,");
		ipntBuffer.append("   patcont.name         name_patcontref,");
		ipntBuffer.append("   patcont.id_conttp,");
		ipntBuffer.append("   patcont.sd_conttp,");
		ipntBuffer.append("   patcont.conttel,");
		ipntBuffer.append("   patcont.contaddr,");
		ipntBuffer.append("   patcont. Id_patcont,");
		ipntBuffer.append(" dep2.name   name_dep_nur_ip,");
		//籍贯 zhangpp 2019.10.21
		ipntBuffer.append(" area1.id_adminarea as id_addr_origin, ");
		ipntBuffer.append(" area1.code as sd_addr_origin, ");
		ipntBuffer.append(" area1.fullname as name_addr_origin, ");
//		ipntBuffer.append(" ent.addr_pat,");
		ipntBuffer.append(" ent.id_ent,");
		ipntBuffer.append(" inpsn.name as  name_introducer,");
		ipntBuffer.append(" op.sd_status sd_status_op,");//门诊就诊状态
		ipntBuffer.append(" ipnt.dt_insert");
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
		ipntBuffer.append(" inner join sc_apt_ip ipnt");
		ipntBuffer.append(" on ipnt.id_ent = ent.id_ent");
		ipntBuffer.append(" and ipnt.fg_canc = 'N' and  ipnt.dt_valid >='");
		ipntBuffer.append(EnAppUtils.getServerDateTime());
		ipntBuffer.append("' and ipnt.fg_emgstay = 'N' ");
		ipntBuffer.append(" left outer join en_ent_ip ip on ip.id_ent = ipnt.id_entip and ip.sd_status in ('22', '25') ");
		ipntBuffer.append("  left outer join pi_pat_cont patcont");
		ipntBuffer.append("   on patcont.id_patcont = ipnt.id_patcont");
		
		ipntBuffer.append(" left join en_ent_cont entcont on entcont.id_ent = ent.id_ent  and entcont.id_patcontid = patcont.id_patcont");
		ipntBuffer.append(" left outer join bd_udidoc docStatus");
		ipntBuffer.append(" on docStatus.id_udidoc = ipnt.id_level_dise");
		// ipntBuffer.append(" and docStatus.Code = ipnt.sd_status_pat");
		ipntBuffer.append(" left outer join bd_dep dep");
		ipntBuffer.append("   on dep.id_dep = ipnt.id_dep_phy_ip ");
		ipntBuffer.append(" left outer join bd_dep dep2");
		ipntBuffer.append("   on dep2.id_dep = ipnt.Id_dep_nur_ip");
		ipntBuffer.append(" left outer join pi_pat_addr addr");
		ipntBuffer.append("   on pat.id_pat = addr.id_pat");
		ipntBuffer.append(" and addr.sd_addrtp = ?   ");
		ipntBuffer.append(" left outer join bd_adminarea area ");
		ipntBuffer.append("   on addr.id_admdiv = area.id_adminarea");
		ipntBuffer.append(" left outer join pi_pat_addr addr1");
		ipntBuffer.append("   on pat.id_pat = addr1.id_pat");
		ipntBuffer.append(" and addr1.sd_addrtp = ?   ");
		ipntBuffer.append(" left outer join bd_adminarea area1 ");
		ipntBuffer.append("   on addr1.id_admdiv = area1.id_adminarea");
		ipntBuffer.append(" left outer join bd_udidoc u");
		ipntBuffer.append("  on u.id_udidoc = ipnt.id_referalsrc");
		ipntBuffer.append(" left join pi_pat_ca patca on patca.id_patca = ipnt.id_patca ");//fanlq
		ipntBuffer.append(" left join bd_udidoc walk on walk.id_udidoc = ipnt.id_walkwith ");//fanlq
		ipntBuffer.append(" left outer join bd_psndoc inpsn	");
		ipntBuffer.append(" on inpsn.id_psndoc =  ipnt.id_introducer ");
		ipntBuffer.append(" where pat.id_pat = ?   ");
		String ipntSql = ipntBuffer.toString();
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN);
		param.addParam(patId);
		return ipntSql;
	}
	/**
	 * 患者无入院通知单，拼接查询患者就诊信息sql
	 * @param param
	 * @param patId
	 * @param entId
	 * @return
	 */
	private String getSql2(SqlParam param, String patId, String entId) {

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
		ipntBuffer.append(" where pat.id_pat = ?   ");

		ipntBuffer.append(" and ent.id_ent = ?   ");

		String ipntSql = ipntBuffer.toString();
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
		param.addParam(IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN);
		param.addParam(patId);
		param.addParam(entId);
		return ipntSql;
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
	private void setDefValus(AptIpDTO entipntDTO, String entId) throws BizException{
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
		if(entipntDTO !=null && EnValidator.isEmpty(entipntDTO.getName_cont_phy()) && entId.equals(entipntDTO.getId_ent()) && EnValidator.isEmpty(entipntDTO.getName_cont_phy()) ){
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
