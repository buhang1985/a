package iih.en.pv.s.bp.ip.qry;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.res.bed.d.Bdbed;
import iih.en.comm.ep.BedEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.util.EnAgeCalcUtil;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.EnHosRegDTO;
import iih.en.pv.entplan.d.EntHpDO;
import iih.en.pv.entplan.i.IEnthpRService;
import iih.en.pv.inpatient.dto.d.EnHosDTO;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.reg.dto.d.PiPatFuzyyQueryCondDTO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.d.PiPatHpDO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
/**
 * 入院登记(含注册)(新)信息查询
 * 
 * @author renying
 *
 */
public class GetEnHosBP {
	/**
	 * 入院登记(含注册)患者信息查询
	 * 
	 * @param cond
	 * @return
	 * @throws BizException 
	 */
	public EnHosDTO[] exec(PiPatFuzyyQueryCondDTO cond, FBoolean fgBb) throws BizException {
		EnHosDTO enhosDTO = new EnHosDTO ();
		//1.查询患者agg信息  将患者信息转换成enhosdto信息
		PatiAggDO  patiAggDO = this.getPatInfo(enhosDTO, cond, fgBb);
		if(patiAggDO == null)
			return null;
		//2.查询就诊信息
		EnHosDTO[] enhosDTOs = this.GetEnHosRegDTO(patiAggDO,enhosDTO );
		
		return enhosDTOs;
	}
		
	/**
	 * 查找患者信息
	 * @param patiAggDO
	 * @param entId
	 * @param ischild
	 * @param fg_bb
	 * @return
	 * @throws BizException 
	 */
	private PatiAggDO  getPatInfo(EnHosDTO enhosDTO,PiPatFuzyyQueryCondDTO cond,FBoolean fg_bb) throws BizException {	
		PatiAggDO  patiAggDO = new PatEP().getPatAggDo(cond);
		if (patiAggDO == null) {
			return patiAggDO;
		}
        this.getPatBasicInfo(patiAggDO, enhosDTO);
		this.getAddrInfo(patiAggDO, enhosDTO);
        this.getPatContValue(patiAggDO, enhosDTO,fg_bb);

        return patiAggDO;
	}
	
	/**
	 * 地址信息
	 * 
	 * @param patiAggDO
	 * @param enHosPatDTO
	 */
	private void getAddrInfo(PatiAggDO patiAggDO, EnHosDTO enHosPatDTO) {
		PatiAddrDO[] patAddrs = patiAggDO.getPatiAddrDO();
        if (patAddrs == null || patAddrs.length == 0)
        {
            return;
        }
        for (PatiAddrDO addrPatDO : patAddrs)
        {//现住址
            if (!EnValidator.isEmpty(addrPatDO.getSd_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.SD_ADDR_TYPE_NOW) && EnValidator.isEmpty(enHosPatDTO.getName_admdiv()))
            {
            	enHosPatDTO.setName_admdiv(addrPatDO.getAdmdiv_fullname());
            	enHosPatDTO.setId_admdiv(addrPatDO.getId_admdiv());
            	enHosPatDTO.setSd_admdiv(addrPatDO.getSd_admdiv());
            	enHosPatDTO.setAddr_pat(addrPatDO.getStreet());
            	enHosPatDTO.setPostcode_addr(addrPatDO.getZip());
            	enHosPatDTO.setTel_admdiv(addrPatDO.getTel());
            }
            //户籍地址
            if (!EnValidator.isEmpty(addrPatDO.getSd_addrtp()) && addrPatDO.getSd_addrtp().equals(IPiDictCodeConst.SD_ADDR_TYPE_CENCUS))
            {
            	enHosPatDTO.setId_admdiv_resi(addrPatDO.getId_admdiv());
            	enHosPatDTO.setSd_admdiv_resi(addrPatDO.getSd_admdiv());
            	enHosPatDTO.setName_admdiv_resi(addrPatDO.getAdmdiv_fullname());
            	enHosPatDTO.setDetail_addr_resi(addrPatDO.getStreet());
            	enHosPatDTO.setPostcode_resi(addrPatDO.getZip());
            }
            //工作地址
            if (!EnValidator.isEmpty(addrPatDO.getSd_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.SD_ADDR_TYPE_WORK))
            {
            	enHosPatDTO.setId_admdiv_work(addrPatDO.getId_admdiv());
            	enHosPatDTO.setSd_admdiv_work(addrPatDO.getSd_admdiv());
            	enHosPatDTO.setName_admdiv_work(addrPatDO.getAdmdiv_fullname());
            	enHosPatDTO.setDetail_addr_work(addrPatDO.getStreet());
            	enHosPatDTO.setPostcode_work(addrPatDO.getZip());
            	enHosPatDTO.setTel_work(addrPatDO.getTel());
            }
            //籍贯
            if (!EnValidator.isEmpty(addrPatDO.getSd_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.SD_ADDR_TYPE_ORIGIN))
            {
            	enHosPatDTO.setId_nativeaddr(addrPatDO.getId_admdiv());
            	enHosPatDTO.setName_nativeaddr(addrPatDO.getAdmdiv_fullname());
            	enHosPatDTO.setSd_nativeaddr(addrPatDO.getSd_admdiv());
            }
            //出生地
            if (!EnValidator.isEmpty(addrPatDO.getSd_addrtp()) && addrPatDO.getId_addrtp().equals(IPiDictCodeConst.SD_ADDR_TYPE_BORN))
            {
            	enHosPatDTO.setId_birth_addr(addrPatDO.getId_admdiv());
            	enHosPatDTO.setName_birth_addr(addrPatDO.getAdmdiv_fullname());
            	enHosPatDTO.setSd_birth_addr(addrPatDO.getSd_admdiv());
            }
        }
	}
	
	/**
	 * 基本信息
	 * 
	 * @param pataggdo
	 * @param enhosDTO
	 * @throws BizException 
	 */
	private void getPatBasicInfo(PatiAggDO pataggdo, EnHosDTO enhosDTO) throws BizException
    {
        PatDO patdo = pataggdo.getParentDO();
        enhosDTO.setName_marry(patdo.getMarry_name());
        enhosDTO.setId_marry(patdo.getId_marry());
        enhosDTO.setId_pat(patdo.getId_pat());
        enhosDTO.setCode_pat(patdo.getCode());
        enhosDTO.setName_pat(patdo.getName());
        enhosDTO.setCode_amr_ip(patdo.getCode_amr_ip());

        enhosDTO.setId_sex(patdo.getId_sex());//性别
        enhosDTO.setSd_sex(patdo.getSd_sex());
        enhosDTO.setName_sex(patdo.getName_sex());

        enhosDTO.setId_idtp(patdo.getId_idtp());//证件类型
        enhosDTO.setSd_idtp(patdo.getSd_idtp());
        enhosDTO.setName_idtp(patdo.getIdtp_name());
        enhosDTO.setId(patdo.getId_code());//证件号码

        enhosDTO.setDt_birth(patdo.getDt_birth());
        enhosDTO.setId_marry(patdo.getId_marry());
        enhosDTO.setSd_marry(patdo.getSd_marry());
        enhosDTO.setName_marry(patdo.getMarry_name());
        enhosDTO.setTel(patdo.getTel());//电话
        enhosDTO.setMob(patdo.getMob());//移动电话      	

        enhosDTO.setId_nation(patdo.getId_nation()); //民族
        enhosDTO.setName_nation(patdo.getNation_name());

        enhosDTO.setId_country(patdo.getId_country());//国籍
        enhosDTO.setName_country(patdo.getCountry_name());
        //enhosDTO.setAge(AgeCalcUtil.getAge(patdo.getDt_birth()));
        EnAgeCalcUtil.setDoAges(new EnHosDTO[]{enhosDTO}, "Id_ent", "Age");

        enhosDTO.setId_patca(patdo.getId_paticate());//患者分类
        enhosDTO.setName_patca(patdo.getPaticate_name());

        enhosDTO.setId_job(patdo.getId_occu());
        enhosDTO.setName_job(patdo.getOccu_name());
        enhosDTO.setPhoto(patdo.getPhoto());
        enhosDTO.setWorkplace(patdo.getWorkunit());
    }
	
	/**
	 * 患者联系人
	 * 
	 * @param pataggdo
	 * @param enhosDTO
	 * @param entId
	 * @param ischild
	 * @param fg_bb
	 * @throws BizException
	 */
	private void getPatContValue(PatiAggDO pataggdo, EnHosDTO enhosDTO,  FBoolean fg_bb) throws BizException
    {
        if (fg_bb == null || !fg_bb.booleanValue())
        {
            PiPatContDO[] patContDOs = pataggdo.getPiPatContDO();
            if (patContDOs == null || patContDOs.length == 0)
            {
                return;
            }
            List<PiPatContDO> patConts = new ArrayList<PiPatContDO>();
            if (patConts == null || patContDOs.length == 0)
            {
                return;
            }
            PiPatContDO contDo = patConts.get(0);
            enhosDTO.setId_patcont(contDo.getId_patcont());
            enhosDTO.setName_patcont(contDo.getName());
            enhosDTO.setName_patcontref(contDo.getName());
            enhosDTO.setId_conttp(contDo.getId_conttp());
            enhosDTO.setName_conttp(contDo.getConttp_name());
            enhosDTO.setConttel(contDo.getConttel());
            enhosDTO.setContaddr(contDo.getContaddr());
        }
        else {
            PiPatContDO[] patContDOs = pataggdo.getPiPatContDO();
            if (patContDOs == null || patContDOs.length == 0)
            {
                return;
            }
            for (PiPatContDO contDo : patContDOs)
            {
                if (contDo.getSd_fmrole() == IPiDictCodeConst.SD_PARENT_MOTHER)
                {
                    enhosDTO.setId_patcont(contDo.getId_patcont());
                    enhosDTO.setName_patcontref(contDo.getName());
                    enhosDTO.setConttel(contDo.getConttel());
                    enhosDTO.setContaddr(contDo.getContaddr());
                    enhosDTO.setZip_cont(contDo.getZip());
                    enhosDTO.setId_cont(contDo.getContid());
                }
                if (contDo.getSd_fmrole() == IPiDictCodeConst.SD_PARENT_FATHER) 
                {
                    enhosDTO.setId_patcont2(contDo.getId_patcont());
                    enhosDTO.setName_patcontref2(contDo.getName());
                    enhosDTO.setConttel2(contDo.getConttel());
                    enhosDTO.setContaddr2(contDo.getContaddr());
                    enhosDTO.setZip_cont2(contDo.getZip());
                    enhosDTO.setId_cont2(contDo.getContid());
                }
            }
        }
    }
//========================================================================================================//
	
	/**
	 * 住院登记查询
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private EnHosDTO[] GetEnHosRegDTO(PatiAggDO pataggdo,EnHosDTO  enhosDTO) throws BizException {
		if (EnValidator.isEmpty(pataggdo.getPrimaryKey())) {
			return null;
		}
		// 取得住院数据
		EnHosRegDTO[] results = getInpatientData(pataggdo);
		for(EnHosRegDTO enhosregDTO:results){
			if (enhosDTO.getTimes() == null) {
				this.getIpTimes(enhosregDTO);
			}
		}
	   EnHosDTO[] enhosDTOs = this.setEnHosRegToHosData(results, enhosDTO);
	   return enhosDTOs;	
		
	}
	
	/**
	 * 查询sql
	 * 
	 * @param idPat
	 * @return
	 * @throws BizException
	 */
	private EnHosRegDTO[] getInpatientData(PatiAggDO pataggdo) throws BizException {
		StringBuffer sqlSb = new StringBuffer();
		sqlSb.append(" Select ent.id_ent,ent.fg_ip,");
		sqlSb.append(" ent.code_entp,");
		sqlSb.append(" ent.id_entp,");
		sqlSb.append(" ent.dt_entry, ");
		sqlSb.append(" ent.id_patca as id_paticate,");
		sqlSb.append(" patca.name as name_paticate,");
		sqlSb.append(" ent.id_pripat,");
		sqlSb.append(" pripat.name as pri_name, ");
		sqlSb.append(" ent.id_patcret,");
		sqlSb.append(" patcret.name as pat_name, ");
		sqlSb.append(" ent.id_pat,");
		sqlSb.append(" ent.code code_ent,");
		sqlSb.append(" ent.code_hpmedkind,");//诊疗类别
		sqlSb.append(" hmk.id_hpmedkindah id_hpmedkind,");
		sqlSb.append(" hmk.name name_hpmedkind,");
		sqlSb.append(" ent.id_emp_phy,");
		sqlSb.append(" emp.code as code_emp_phy,");
		sqlSb.append(" emp.name as name_emp_phy,");
		sqlSb.append(" ip.id_level_diseadm,");
		sqlSb.append(" ip.id_patcont,");
		sqlSb.append(" ip.fg_newborn  Fg_bb,");
		sqlSb.append(" ip.sd_level_diseadm,");
		sqlSb.append(" ip.sd_status,");
		sqlSb.append(" ip.id_referalsrc,");
		sqlSb.append(" ip.sd_referalsrc,");
		sqlSb.append(" ent.id_dep_phy as id_dep_phyadm,");
		sqlSb.append(" ip.times_ip times ,");
		sqlSb.append(" ent.id_dep_nur as id_dep_nuradm,");
		sqlSb.append(" ip.id_bed,");
		sqlSb.append(" bed.code as code_bed, ");
		sqlSb.append(" ip.name_bed      bedname,");
		sqlSb.append(" ip.Id_diag_op    Id_diag,");
		sqlSb.append(" ip.Desc_diag_op   Desc_diag,");
		sqlSb.append(" ip.fg_vip,");
		sqlSb.append(" def.name as Dia_name,");
		sqlSb.append(" def.code as sd_diag,");
		sqlSb.append(" udidoc.name     referalsrc_name,");
		sqlSb.append(" udidoc2.name   name_level_diseadm,");
//		sqlSb.append(" case ip.sd_status");
//		sqlSb.append("  when '25' then '在院'");
//		sqlSb.append("  when '22' then '登记'");
//		sqlSb.append("  end as show_ipstatus,");
		sqlSb.append(" bed.sd_bedsexlimit   sd_bedsex,");
		sqlSb.append(" opemp.name name_emp_phy_op,");
		sqlSb.append(" opemp.code code_emp_phy_op,");
		sqlSb.append(" ip.id_emp_opapply id_emp_phy_op,");
		sqlSb.append(" ent.id_cust_cmpy,");
		sqlSb.append(" cust.name name_cust_cmpy,");
		sqlSb.append(" apt.amt_deposit,");
		sqlSb.append(" apt.id_bed id_bed_sc, ");
		sqlSb.append(" (CASE WHEN EXISTS (SELECT TAGTP.ID_ENTTAGTP FROM EN_ENT_TAGTP TAGTP WHERE TAGTP.ID_ENT = ent.ID_ENT AND TAGTP.CODE_TAGTP = '003') THEN 'Y' ELSE 'N' END) AS FG_POOR ");//贫困患者
		sqlSb.append(" from en_ent ent");
		sqlSb.append(" inner join en_ent_ip ip on ent.id_ent = ip.id_ent ");
		sqlSb.append(" left join bd_bed bed on ip.id_bed = bed.id_bed ");
		sqlSb.append(" left join bd_psndoc emp on ent.id_emp_phy = emp.id_psndoc ");
		sqlSb.append(" left outer join pi_pat_ca patca on ent.id_patca = patca.id_patca ");
		sqlSb.append(" left outer join bd_pri_pat pripat on ent.id_pripat = pripat.Id_pripat ");
		sqlSb.append(" left outer join pi_pat_cret patcret on ent.id_patcret = patcret.Id_patcret ");
		sqlSb.append(" left outer join bd_udidoc udidoc on ip.id_referalsrc = udidoc.id_udidoc ");
		sqlSb.append(" left outer join bd_udidoc udidoc2 on ip.id_level_diseadm = udidoc2.id_udidoc ");
		sqlSb.append(" left join bd_di_def def on def.id_didef = ip.Id_diag_op ");
		sqlSb.append(" left join bd_hp_med_kind_ah hmk on ent.code_hpmedkind = hmk.code and ent.id_hp = hmk.id_hp ");
		sqlSb.append(" left join bd_bed bed");
		sqlSb.append(" 	 on bed.id_bed = ip.id_bed");
		sqlSb.append(" left join bd_psndoc opemp on ip.id_emp_opapply = opemp.id_psndoc");
		sqlSb.append(" left join bd_cust cust on ent.id_cust_cmpy = cust.id_cust");
		sqlSb.append(" left join sc_apt_ip apt on apt.id_entip = ent.id_ent");
		sqlSb.append("  where ent.id_pat = ?");
		sqlSb.append("  and ip.sd_status in ('" + IEnDictCodeConst.SD_ENSTATUS_IN_DEPTIN + "','" // del																									
				+ IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALIN + "')");
		SqlParam param = new SqlParam();
		param.addParam(pataggdo.getPrimaryKey());
		@SuppressWarnings("unchecked")
		List<EnHosRegDTO> list = (List<EnHosRegDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(EnHosRegDTO.class));
		if (EnValidator.isEmpty(list)) {
		     //1.获取申请单数据
			//查询入院通知单
			EnHosRegDTO[] ipnts = getNoticeData(pataggdo);         
			if (!EnValidator.isEmpty(ipnts)) {
				return ipnts;
			}
			 //2。没有申请单就new DTO返回
			EnHosRegDTO enhosDTO = new EnHosRegDTO();
			this.setPatCate(enhosDTO);
			enhosDTO.setStatus(DOStatus.NEW);			
			return new EnHosRegDTO[]{enhosDTO};			
		}
		for(EnHosRegDTO enhosDTO: list){
			this.getHPValue(enhosDTO, pataggdo);
			this.getDepName(enhosDTO);
		}
		return list.toArray(new EnHosRegDTO[0]);
	}
	
	/**
	 * 通过就诊id获取住院就诊数据
	 * 
	 * @param entId
	 * @return
	 * @throws BizException
	 */
	public EnHosRegDTO getEnHosRegByEntId(String entId, FBoolean fg_st) throws BizException {
		if(EnValidator.isEmpty(entId))
			return null;
		StringBuffer sqlSb = new StringBuffer();
		sqlSb.append(" Select ent.id_ent,ent.fg_ip,");
		sqlSb.append(" ent.dt_entry, ");
		sqlSb.append(" ent.id_pripat,");
		sqlSb.append(" pripat.name as pri_name, ");
		sqlSb.append(" ent.id_patcret,");
		sqlSb.append(" patcret.name as pat_name, ");
		sqlSb.append(" ent.id_pat,");
		sqlSb.append(" ent.code code_ent,");
		sqlSb.append(" ent.code_hpmedkind,");//诊疗类别
		sqlSb.append(" hmk.id_hpmedkindah id_hpmedkind,");
		sqlSb.append(" hmk.name name_hpmedkind,");
		sqlSb.append(" ip.id_level_diseadm,");
		sqlSb.append(" ip.id_patcont,");
		sqlSb.append(" ip.sd_level_diseadm,");
		sqlSb.append(" ip.sd_status,");
		sqlSb.append(" ip.id_referalsrc,");
		sqlSb.append(" ip.sd_referalsrc,");
		sqlSb.append(" ip.id_dep_phyadm,");
		sqlSb.append(" ip.times_ip times ,");
		sqlSb.append(" ip.id_dep_nuradm,");
		sqlSb.append(" ip.id_bed,");
		sqlSb.append(" ip.name_bed      bedname,");
		sqlSb.append(" ip.Id_diag_op    Id_diag,");
		sqlSb.append(" ip.Desc_diag_op   Desc_diag,");
		sqlSb.append(" ent.id_patca as id_paticate,");
		sqlSb.append(" patca.name as name_paticate,");
		sqlSb.append(" def.name as Dia_name,");
		sqlSb.append(" def.code as sd_diag,");
		sqlSb.append(" udidoc.name     referalsrc_name,");
		sqlSb.append(" udidoc2.name   name_level_diseadm,");
		sqlSb.append(" case ip.sd_status");
//		sqlSb.append("  when '25' then '在院'");
//		sqlSb.append("  when '22' then '登记'");
//		sqlSb.append("  when '28' then '出院'");
//		sqlSb.append("  end as show_ipstatus,");
		sqlSb.append(" bed.sd_bedsexlimit   sd_bedsex,");
		sqlSb.append(" opemp.name name_emp_phy_op,");
		sqlSb.append(" ip.id_emp_opapply id_emp_phy_op ");
	//	sqlSb.append(" (CASE WHEN EXISTS (SELECT TAGTP.ID_ENTTAGTP FROM EN_ENT_TAGTP TAGTP WHERE TAGTP.ID_ENT = ent.ID_ENT AND TAGTP.CODE_TAGTP = '003') THEN 'Y' ELSE 'N' END) AS FG_POOR ");//贫困患者
		sqlSb.append(" from en_ent ent");
		sqlSb.append(" inner join en_ent_ip ip");
		sqlSb.append("   on ent.id_ent = ip.id_ent");
		sqlSb.append(" left outer join pi_pat_ca patca ");
		sqlSb.append("   on ent.id_patca = patca.id_patca ");
		sqlSb.append(" left outer join bd_pri_pat pripat ");
		sqlSb.append("   on ent.id_pripat = pripat.Id_pripat ");
		sqlSb.append(" left outer join pi_pat_cret patcret ");
		sqlSb.append("   on ent.id_patcret = patcret.Id_patcret ");
		sqlSb.append(" left outer join bd_udidoc udidoc");
		sqlSb.append("   on ip.id_referalsrc = udidoc.id_udidoc");
		sqlSb.append(" left outer join bd_udidoc udidoc2");
		sqlSb.append("   on ip.id_level_diseadm = udidoc2.id_udidoc");
		sqlSb.append(" left join bd_di_def def");
		sqlSb.append("   on def.id_didef = ip.Id_diag_op ");
		sqlSb.append(" left join bd_hp_med_kind_ah hmk");
		sqlSb.append("   on ent.code_hpmedkind = hmk.code ");
		sqlSb.append(" left join bd_bed bed");
		sqlSb.append(" 	 on bed.id_bed = ip.id_bed");
		sqlSb.append(" left join bd_psndoc opemp on ip.id_emp_opapply = opemp.id_psndoc");
		sqlSb.append("  where ent.id_ent = ?");
		sqlSb.append(" and ent.fg_canc = ? ");
		SqlParam param = new SqlParam();
		param.addParam(entId);
		param.addParam(FBoolean.FALSE);
		@SuppressWarnings("unchecked")
		List<EnHosRegDTO> list = (List<EnHosRegDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(EnHosRegDTO.class));
		if(!EnValidator.isEmpty(list)){
			EnHosRegDTO enHostReg = list.get(0);
			this.setHpValue(enHostReg);
			return enHostReg;
		}
		return null;
	}
	
	


	/**
	 * 设置入院次数
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void getIpTimes(EnHosRegDTO enhosDTO) throws BizException {
		int times = 0;
		StringBuilder sql = new StringBuilder();

		sql.append(" select  max(nvl(times_ip,0))  times_ip from en_ent_ip  ip");
		sql.append(" inner join en_ent ent");
		sql.append(" on ent.id_ent = ip.id_ent");
		sql.append(" where id_pat = '");
		sql.append(enhosDTO.getId_pat());
		sql.append("'");

		FArrayList list = AppFwUtil.getMapListWithDao(sql.toString());
		if (!EnValidator.isEmpty(list)) {
			Map<String, Object> map = (Map<String, Object>) list.get(0);
			if ((Integer) map.get("times_ip") != null) {
				times = (Integer) map.get("times_ip");
			}
		}

		enhosDTO.setTimes(times + 1);
	}

	/**
	 * 查询入院通知单sql
	 * 
	 * @param idPat
	 * @return
	 * @throws BizException
	 */
	private EnHosRegDTO[] getNoticeData(PatiAggDO pataggdo) throws BizException {

		StringBuffer sqlSb = new StringBuffer();
		sqlSb.append(" select ip.id_aptip Id_ent_ipnt,");
		sqlSb.append(" ip.id_dep_phy_ip    id_dep_phyadm,");
		sqlSb.append(" case when bed.id_bed is null then ip.id_dep_nur_ip else dep3.id_dep end  id_dep_nuradm,");
		sqlSb.append(" ip.id_didef_op   id_diag,");
	    sqlSb.append(" ip.amt_deposit,");
		sqlSb.append(" ip.supplement_di desc_diag,");
		sqlSb.append(" ip.sd_level_dise    sd_level_diseadm,");
		sqlSb.append(" ip.id_level_dise    id_level_diseadm,");
		sqlSb.append(" ip.sd_status  apt_status,");
		sqlSb.append(" ip.id_bed,");
		sqlSb.append(" ip.id_emp_phy_op,");
		sqlSb.append(" ip.name_emp_phy_op,");
		sqlSb.append(" ip.fg_vip,");
		sqlSb.append(" ip.dt_insert dt_insert_sc,");
		sqlSb.append(" ip.id_referalsrc,");
		sqlSb.append(" ip.sd_referalsrc,");
		sqlSb.append(" ip.id_bed id_bed_sc,");
		sqlSb.append(" udidoc2.name     referalsrc_name,");
		//sqlSb.append(" ent.id_ent,");
		sqlSb.append(" udidoc.name         name_level_diseadm,");
		sqlSb.append(" dep.name            phy_name,");
		sqlSb.append(" dep.code            code_dep_phyadm,");
		sqlSb.append(" case when bed.id_bed is null then dep2.name else dep3.name end   nur_name,");
		sqlSb.append(" case when bed.id_bed is null then dep2.code else dep3.code end   code_dep_nuradm,");
		sqlSb.append(" bed.name  bedname,");
		sqlSb.append(" bed.id_dep_belong   id_nur_bed,");
		sqlSb.append(" def.name            dia_name,");
		sqlSb.append(" bed.sd_bedsexlimit   sd_bedsex,");
		sqlSb.append(" ent.id_cust_cmpy,");
		sqlSb.append(" opemp.code code_emp_phy_op,");
		sqlSb.append(" cust.name name_cust_cmpy ");
		sqlSb.append(" from sc_apt_ip ip");
		sqlSb.append(" inner join en_ent ent");
		sqlSb.append(" on ent.id_ent = ip.id_ent");
		sqlSb.append(" left outer join bd_dep dep");
		sqlSb.append(" on ip.id_dep_phy_ip = dep.id_dep");
		sqlSb.append(" left outer join bd_dep dep2");
		sqlSb.append(" on ip.id_dep_nur_ip = dep2.id_dep");
		sqlSb.append(" left outer join bd_di_def def");
		sqlSb.append(" on ip.id_didef_op = def.id_didef");
		sqlSb.append(" left outer join bd_udidoc udidoc");
		sqlSb.append(" on udidoc.id_udidoc = ip.id_level_dise");
		sqlSb.append(" left join bd_bed  bed ");
		sqlSb.append(" on ip.id_bed = bed.id_bed ");
		sqlSb.append(" left outer join bd_dep dep3");
		sqlSb.append(" on bed.id_dep_belong = dep3.id_dep");
		sqlSb.append(" left join bd_cust cust on ent.id_cust_cmpy = cust.id_cust");
		sqlSb.append(" left join bd_psndoc opemp on ip.id_emp_phy_op = opemp.id_psndoc");
		sqlSb.append(" left outer join bd_udidoc udidoc2 on ip.id_referalsrc = udidoc2.id_udidoc ");

		sqlSb.append(" where ent.id_pat = ?");
		sqlSb.append(" and ip.sd_status in ('" + IEnDictCodeConst.SD_STATUS_NOTICE_CREATE + "','" + IEnDictCodeConst.SD_STATUS_NOTICE_NOTIFY + "','"

		+ IEnDictCodeConst.SD_STATUS_NOTICE_ACC + "','" + IEnDictCodeConst.SD_STATUS_NOTICE_REFUSE + "')");
		sqlSb.append(" and ip.fg_emgstay=ISNULL(ip.fg_emgstay,'N')  and ip.Fg_canc ='N'");// 急诊留观标识
		SqlParam param = new SqlParam();
		param.addParam(pataggdo.getPrimaryKey());
		@SuppressWarnings("unchecked")
		List<EnHosRegDTO> list = (List<EnHosRegDTO>) new DAFacade().execQuery(sqlSb.toString(), param, new BeanListHandler(EnHosRegDTO.class));
		if (EnValidator.isEmpty(list)) {
			return null;
		}
		for (EnHosRegDTO enhosDTO : list) {
			enhosDTO.setId_pat(pataggdo.getPrimaryKey());
			enhosDTO.setFg_aptip(FBoolean.TRUE);
			this.setPatCate(enhosDTO);
			if(EnValidator.isEmpty(enhosDTO.getId_dep_nuradm()) &&!EnValidator.isEmpty(enhosDTO.getId_bed())){
				this.getBedNur(enhosDTO);
			}	
			if (enhosDTO.getTimes() == null) {
				this.getIpTimes(enhosDTO);
			}
		}
		return  list.toArray(new EnHosRegDTO[]{});
	}

	
	/**
	 * 设置床位所属的病区
	 * @param enhosDTO
	 * @throws BizException
	 */
	private void getBedNur(EnHosRegDTO enhosDTO) throws BizException
	{
		BedEP bedEp = new BedEP();
		Bdbed bedDO = bedEp.getBed(enhosDTO.getId_bed());
		enhosDTO.setId_dep_nuradm(bedDO.getId_dep_belong());
		enhosDTO.setNur_name(bedDO.getDept_name());
	}
	
	/**
	 * 设置医保计划
	 * 
	 * @param enhosDTO
	 * @return
	 * @throws BizException
	 */
	private void setHpValue(EnHosRegDTO enhosDTO) throws BizException {
		String entID = enhosDTO.getId_ent();
		IEnthpRService rservice = ServiceFinder.find(IEnthpRService.class);
		EntHpDO[] entHpDOArr = rservice.findByAttrValString(EntHpDO.ID_ENT, entID);
		if(EnValidator.isEmpty(entHpDOArr))
			return;
		for (EntHpDO hpDO : entHpDOArr) { // 查询就诊医保
			if (enhosDTO.getId_ent().equals(hpDO.getId_ent())) {
				if (hpDO.getFg_maj() == FBoolean.TRUE) {
					enhosDTO.setPrim_cplan(hpDO.getId_hp());
					enhosDTO.setPrim_name(hpDO.getName_hp());
					enhosDTO.setId_enthp_prim(hpDO.getId_enthp());
					enhosDTO.setCode_hp(hpDO.getNo_hp());
					enhosDTO.setCode_hpkind(hpDO.getCode_hpkind());
					enhosDTO.setCode_hppatca(hpDO.getCode_hppatca());
					enhosDTO.setCode_hparea(hpDO.getCode_hparea());
					enhosDTO.setHpcode(hpDO.getCode_hp());
					enhosDTO.setFg_fundpay(hpDO.getFg_fundpay());
					enhosDTO.setFg_hpspcl(hpDO.getFg_hpspcl());
					enhosDTO.setFg_hp_card(hpDO.getFg_hp_card());
				} else {
					enhosDTO.setAuxi_cplan(hpDO.getId_hp());
					enhosDTO.setAuxi_name(hpDO.getName_hp());
					enhosDTO.setId_enthp_auxi(hpDO.getId_enthp());
				}
			}
		}
	}
	/**
	 * 查询患者医保数据
	 * 
	 * @param enhosDTO
	 * @return
	 * @throws BizException
	 */
	private EnHosRegDTO getHPValue(EnHosRegDTO enhosDTO, PatiAggDO patAgg) throws BizException {
		this.setHpValue(enhosDTO);
		if (enhosDTO.getId_pat() != null) {// 查询患者医保号
			PiPatHpDO[] pipatHpDOs = GetHpCode(patAgg);
			if (!EnValidator.isEmpty(pipatHpDOs)) {
				for (PiPatHpDO pipatHpDo : pipatHpDOs) {
					if (!EnValidator.isEmpty(pipatHpDo.getId_hp()) && pipatHpDo.getId_hp().equals(enhosDTO.getPrim_cplan())) {
						enhosDTO.setCode_hp(pipatHpDo.getNo_hp());
					}
					if (!EnValidator.isEmpty(pipatHpDo.getId_hp()) && pipatHpDo.getId_hp().equals(enhosDTO.getAuxi_cplan())) {
						enhosDTO.setCode_hp2(pipatHpDo.getNo_hp());
					}
				}
			}
		}
		return enhosDTO;
	}

	/**
	 * 查询部门的名称
	 * 
	 * @param enhosDTO
	 * @return
	 * @throws BizException
	 */
	private EnHosRegDTO getDepName(EnHosRegDTO enhosDTO) throws BizException {
		String depId = enhosDTO.getId_dep_phyadm();
		String nurId = enhosDTO.getId_dep_nuradm();
		IDeptRService service = ServiceFinder.find(IDeptRService.class);
		if (EnValidator.isEmpty(depId) && EnValidator.isEmpty(nurId)) {// 如果两个参数都是空，就返回
			return enhosDTO;
		}
		List<String> list = new ArrayList<String>();
		if (!EnValidator.isEmpty(depId)) {
			list.add(depId);
		}
		if (!EnValidator.isEmpty(nurId)) {
			list.add(nurId);
		}

		DeptDO[] depts = service.findByIds(list.toArray(new String[] {}), FBoolean.FALSE);
		if (!EnValidator.isEmpty(depts)) {
			for (DeptDO deptdo : depts) {
				if (deptdo.getId_dep().equals(depId)) {
					enhosDTO.setPhy_name(deptdo.getName());
					enhosDTO.setCode_dep_phyadm(deptdo.getCode());
				}
				if (deptdo.getId_dep().equals(nurId)) {
					enhosDTO.setNur_name(deptdo.getName());
					enhosDTO.setCode_dep_nuradm(deptdo.getCode());
				}
			}
		}
		return enhosDTO;
	}

	/**
	 * 设置患者分类，价格分类，信用分类
	 * 
	 * @param enhosDTO
	 * @throws BizException
	 */
	private void setPatCate(EnHosRegDTO enhosDTO) throws BizException {
		PiPatCaDO patca = new PatEP().getPatDefaultCate();
		if(patca != null){
			enhosDTO.setId_paticate(patca.getId_patca());
			enhosDTO.setName_paticate(patca.getName());
			enhosDTO.setId_pripat(patca.getId_patpritp());
			enhosDTO.setPri_name(patca.getPatpritp_name());
			enhosDTO.setId_patcret(patca.getId_patcrettp());
			enhosDTO.setPat_name(patca.getPatcrettp_name());
		}
	}

	/**
	 * 查询患者医保号
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	private PiPatHpDO[] GetHpCode(PatiAggDO patAgg) throws BizException {
		PiPatHpDO[] piPatHpDOs = patAgg.getPiPatHpDO();
		return piPatHpDOs;
	}
//=====================================================================//

	/**
	 * 将就诊数据设置成EnhosDTO
	 * @param enhosRegDTOs
	 * @param enhosDTO
	 */
	private EnHosDTO[] setEnHosRegToHosData(EnHosRegDTO[] enhosRegDTOs,EnHosDTO enhosDTO){
		if(enhosRegDTOs.length ==1){
			this.setRegPropertiesToHos(enhosRegDTOs[0], enhosDTO);
		}
		List<EnHosDTO> enhosDTOList = new ArrayList<EnHosDTO>();	
		for(EnHosRegDTO enhosRegDTO:enhosRegDTOs){
			EnHosDTO newEnhos= new EnHosDTO();
			newEnhos = (EnHosDTO) enhosDTO.clone();
			this.setRegPropertiesToHos(enhosRegDTO, newEnhos);
			enhosDTOList.add(newEnhos);
		}
		return enhosDTOList.toArray(new EnHosDTO[]{});
	}
	
	/**
	 * 设置属性
	 * @param enhosRegDTO
	 * @param enhosDTO
	 */
	private void setRegPropertiesToHos(EnHosRegDTO enhosRegDTO,EnHosDTO enhosDTO){
		enhosDTO.setDt_entry(enhosRegDTO.getDt_entry());
		enhosDTO.setId_referalsrc(enhosRegDTO.getId_referalsrc());
		enhosDTO.setSd_referalsrc(enhosRegDTO.getSd_referalsrc());
		enhosDTO.setId_dep_phyadm(enhosRegDTO.getId_dep_phyadm());
		enhosDTO.setId_dep_nuradm(enhosRegDTO.getId_dep_nuradm());
		enhosDTO.setId_bed(enhosRegDTO.getId_bed());
		enhosDTO.setId_diag(enhosRegDTO.getId_diag());
		enhosDTO.setId_enthp_prim(enhosRegDTO.getId_enthp_prim());
		enhosDTO.setPrim_cplan(enhosRegDTO.getPrim_cplan());
		enhosDTO.setCode_hp(enhosRegDTO.getCode_hp());
		enhosDTO.setId_enthp_auxi(enhosRegDTO.getId_enthp_auxi());
		enhosDTO.setAuxi_cplan(enhosRegDTO.getAuxi_cplan());
		enhosDTO.setCode_hp2(enhosRegDTO.getCode_hp2());
		enhosDTO.setId_pripat(enhosRegDTO.getId_pripat());
		enhosDTO.setPri_name(enhosRegDTO.getPri_name());
		enhosDTO.setId_patcret(enhosRegDTO.getId_patcret());
		enhosDTO.setCret_name(enhosRegDTO.getPat_name());

		enhosDTO.setSd_status(enhosRegDTO.getSd_status());
		enhosDTO.setId_ent(enhosRegDTO.getId_ent());
		enhosDTO.setCode_ent(enhosRegDTO.getCode_ent());
		enhosDTO.setId_ent_ipnt(enhosRegDTO.getId_ent_ipnt());
		enhosDTO.setId_pat(enhosRegDTO.getId_pat());
		enhosDTO.setId_org(enhosRegDTO.getId_org());
		enhosDTO.setDesc_diag(enhosRegDTO.getDesc_diag());
		enhosDTO.setId_emp(enhosRegDTO.getId_emp());
		enhosDTO.setPrim_name(enhosRegDTO.getPrim_name());
		enhosDTO.setAuxi_name(enhosRegDTO.getAuxi_name());
		enhosDTO.setBedname(enhosRegDTO.getBedname());
		enhosDTO.setReferalsrc_name(enhosRegDTO.getReferalsrc_name());
		enhosDTO.setPhy_name(enhosRegDTO.getPhy_name());
		enhosDTO.setNur_name(enhosRegDTO.getNur_name());
		enhosDTO.setDia_name(enhosRegDTO.getDia_name());
		enhosDTO.setId_level_diseadm(enhosRegDTO.getId_level_diseadm());
		enhosDTO.setSd_level_diseadm(enhosRegDTO.getSd_level_diseadm());
		enhosDTO.setName_level_diseadm(enhosRegDTO.getName_level_diseadm());
		enhosDTO.setApt_status(enhosRegDTO.getApt_status());
		enhosDTO.setFg_appt(enhosRegDTO.getFg_appt());
		enhosDTO.setTimes(enhosRegDTO.getTimes());
		enhosDTO.setFg_aptip(enhosRegDTO.getFg_aptip());
		enhosDTO.setId_nur_bed(enhosRegDTO.getId_nur_bed());
		enhosDTO.setFg_ip(enhosRegDTO.getFg_ip());
		enhosDTO.setShow_ipstatus(enhosRegDTO.getShow_ipstatus());
		enhosDTO.setFg_bb(enhosRegDTO.getFg_bb());
		enhosDTO.setSd_diag(enhosRegDTO.getSd_diag());
		enhosDTO.setAmt_deposit(enhosRegDTO.getAmt_deposit());
		enhosDTO.setId_emp_phy_op(enhosRegDTO.getId_emp_phy_op());
		enhosDTO.setName_emp_phy_op(enhosRegDTO.getName_emp_phy_op());
		enhosDTO.setCode_emp_phy_op(enhosRegDTO.getCode_emp_phy_op());
		enhosDTO.setSd_bedsex(enhosRegDTO.getSd_bedsex());
		enhosDTO.setCode_dep_phyadm(enhosRegDTO.getCode_dep_phyadm());
		enhosDTO.setCode_dep_nuradm(enhosRegDTO.getCode_dep_nuradm());
		enhosDTO.setCode_bed(enhosRegDTO.getCode_bed());
		enhosDTO.setHpcode(enhosRegDTO.getHpcode());
		
		enhosDTO.setId_entp(enhosRegDTO.getId_entp());
		enhosDTO.setCode_entp(enhosRegDTO.getCode_entp());
		enhosDTO.setName_entp(enhosRegDTO.getName_entp());
		enhosDTO.setFg_vip(enhosRegDTO.getFg_vip());
		enhosDTO.setId_cust_cmpy(enhosRegDTO.getId_cust_cmpy());
		enhosDTO.setId_bed_sc(enhosRegDTO.getId_bed_sc());
		enhosDTO.setDt_insert_sc(enhosRegDTO.getDt_insert_sc());
		enhosDTO.setCode_patca(enhosRegDTO.getCode_patca());
		enhosDTO.setId_ent_op	(enhosRegDTO.getId_ent_op());	
		return ;
	}
	
}
