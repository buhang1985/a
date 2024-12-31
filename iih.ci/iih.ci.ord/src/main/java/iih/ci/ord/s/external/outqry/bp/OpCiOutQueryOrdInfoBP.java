package iih.ci.ord.s.external.outqry.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.ci.ord.external.outqry.d.CiOrderOutInfo;
import iih.ci.ord.external.outqry.d.CiOrdqryInfoDTO;
import iih.ci.ord.external.outqry.d.OrdQueryParamDTO;
import iih.ci.ord.external.outqry.d.PatientInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.sys.appfw.orm.utils.AppFwUtil;


public class OpCiOutQueryOrdInfoBP {
	
	public PatientInfoDTO[] exe(OrdQueryParamDTO param) throws BizException {
	
		CiOrderOutInfo[] patientinfos=this.queryPatientData(param);
		if(patientinfos==null||patientinfos.length==0)
			throw new BizException("没有查询到患者信息");
		
		HashMap<String,PatientInfoDTO> map =this.getPatientInfo(patientinfos);       
		CiOrderOutInfo[] ordinfo=queryCiOrderData(param,map.keySet().toArray(new String[0]));
		if(ordinfo!=null&&ordinfo.length>0) {
			for (CiOrderOutInfo ord : ordinfo) {
				CiOrdqryInfoDTO dto=this.getOrdInfo(ord);
				map.get(ord.getId_ent()).getCiordinfos().add(dto);
				map.get(ord.getId_ent()).setFg_vip(ord.getFg_vip());
			}
		}	
		List<PatientInfoDTO> rst=new ArrayList<>();

		for (String key : map.keySet()) {
			PatientInfoDTO r=map.get(key);
			if(r.getCiordinfos().size()==0)
				continue;
			rst.add(r);
		}
		return rst.toArray(new PatientInfoDTO[0]);
	}
	
	
	/**
	 * 查询就诊信息数据
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private CiOrderOutInfo[] queryPatientData( OrdQueryParamDTO param) throws BizException {
		CiOrderOutInfo[] patientinfos = null;
		if (param != null) {
			OpPatientInfoQry sql = new OpPatientInfoQry(param);
			patientinfos = (CiOrderOutInfo[]) AppFwUtil.getDORstWithDao(sql, CiOrderOutInfo.class);
		}
		return patientinfos;
	}
	
	/**
	 * 查询医嘱信息数据
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private CiOrderOutInfo[] queryCiOrderData( OrdQueryParamDTO param,String[] id_ents) throws BizException {
		CiOrderOutInfo[] patientinfos = null;
		if (param != null) {
			OpOrderInfoQry sql = new OpOrderInfoQry(id_ents,param);
			patientinfos = (CiOrderOutInfo[]) AppFwUtil.getDORstWithDao(sql, CiOrderOutInfo.class);
		}
		return patientinfos;
	}
	
	private HashMap<String,PatientInfoDTO> getPatientInfo(CiOrderOutInfo[] ordinfos) throws BizException {
		HashMap<String,PatientInfoDTO> map=new HashMap<>();
		for (CiOrderOutInfo ordinfo : ordinfos) {
			PatientInfoDTO patinfo=new PatientInfoDTO();
			patinfo.setCode_en(ordinfo.getCode_en());
			patinfo.setName_pat(ordinfo.getName_pat());
			patinfo.setCode_entp(ordinfo.getCode_entp());
			patinfo.setCode_grp(ordinfo.getCode_grp());
			patinfo.setCode_pat(ordinfo.getCode_pat());
			patinfo.setId_code(ordinfo.getId_code());
			patinfo.setCode_org(ordinfo.getCode_org());
			patinfo.setTimes_en(ordinfo.getTimes_en());
			patinfo.setDt_birth_pat(ordinfo.getDt_birth_pat());
			patinfo.setSd_idtp(ordinfo.getSd_idtp());
			patinfo.setName_idtp(ordinfo.getName_idtp());
			patinfo.setSd_sex_pat(ordinfo.getSd_sex_pat());
			patinfo.setName_sex_pat(ordinfo.getName_sex_pat());
			patinfo.setDt_enacpt(ordinfo.getDt_enacpt());
			patinfo.setPri_pat_code(ordinfo.getPri_pat_code());
			patinfo.setPri_pat_name(ordinfo.getPri_pat_name());
			patinfo.setCode_dep_phy(ordinfo.getCode_dep_phy());
			patinfo.setCode_dep_nur(ordinfo.getCode_dep_nur());
			patinfo.setCode_emp_phy(ordinfo.getCode_emp_phy());
			patinfo.setCode_emp_nur(ordinfo.getCode_emp_nur());
			patinfo.setMob(ordinfo.getMob());
			patinfo.setCiordinfos(new FArrayList2());	
			map.put(ordinfo.getId_ent(), patinfo);
		}
		
		return map;
	}
	
	private CiOrdqryInfoDTO getOrdInfo(CiOrderOutInfo ordinfo) {
		CiOrdqryInfoDTO qryinfo=new CiOrdqryInfoDTO();
		 qryinfo.setCode_or(ordinfo.getCode_or());
		 qryinfo.setCode_or_itm(ordinfo.getCode_or_itm());
		 qryinfo.setDt_effe(ordinfo.getDt_effe());
		 qryinfo.setDays_or(ordinfo.getDays_or());
		qryinfo.setFg_urgent(ordinfo.getFg_urgent());
		qryinfo.setDes_or(ordinfo.getDes_or());
		qryinfo.setCode_srvca(ordinfo.getCode_srvca());
		qryinfo.setName_srvca(ordinfo.getName_srvca());
		qryinfo.setSd_srvtp(ordinfo.getSd_srvtp());
		qryinfo.setName_srvtp(ordinfo.getName_srvtp());
		qryinfo.setCode_dep_mp(ordinfo.getCode_dep_mp());
		qryinfo.setName_dep_mp(ordinfo.getName_dep_mp());
		qryinfo.setDt_entry(ordinfo.getDt_entry());
		qryinfo.setCode_emp_or(ordinfo.getCode_emp_or());
		qryinfo.setName_emp_or(ordinfo.getName_emp_or());
		qryinfo.setCode_dep_or(ordinfo.getCode_dep_or());
		qryinfo.setName_dep_or(ordinfo.getName_dep_or());
		qryinfo.setName_dep_nur_or(ordinfo.getName_dep_nur_or());
		qryinfo.setFg_sign(ordinfo.getFg_sign());
		qryinfo.setCode_emp_sign(ordinfo.getCode_emp_sign());
		qryinfo.setName_emp_sign(ordinfo.getName_emp_sign());
		qryinfo.setCode_dep_sign(ordinfo.getCode_dep_sign());
		qryinfo.setName_dep_sign(ordinfo.getName_dep_sign());
		qryinfo.setFg_canc(ordinfo.getFg_canc());
		qryinfo.setCode_emp_canc(ordinfo.getCode_emp_canc());
		qryinfo.setName_emp_canc(ordinfo.getName_emp_canc());
		qryinfo.setOrders(ordinfo.getOrders());
		qryinfo.setSd_su_bl(ordinfo.getSd_su_bl());
		qryinfo.setSd_su_or(ordinfo.getSd_su_or());
		qryinfo.setName_su_or(ordinfo.getName_su_or());
		qryinfo.setCode_or_srv(ordinfo.getCode_or_srv());
		qryinfo.setName_or_srv(ordinfo.getName_or_srv());
		qryinfo.setShortname(ordinfo.getShortname());
		qryinfo.setPrintname(ordinfo.getPrintname());
		qryinfo.setSup_name(ordinfo.getSup_name());
		qryinfo.setCode_freq(ordinfo.getCode_freq());
		qryinfo.setCode_route(ordinfo.getCode_route());
		qryinfo.setName_route(ordinfo.getName_route());
		qryinfo.setCode_wh(ordinfo.getCode_wh());
		qryinfo.setSpec(ordinfo.getSpec());
		qryinfo.setFg_propc(ordinfo.getFg_propc());
		qryinfo.setQuan_medu(ordinfo.getQuan_medu());
		qryinfo.setCode_medu(ordinfo.getCode_medu());
		qryinfo.setQuan_medu_cur(ordinfo.getQuan_medu_cur());
		qryinfo.setCode_medu_cur(ordinfo.getCode_medu_cur());
		qryinfo.setFactor_cur(ordinfo.getFactor_cur());
		qryinfo.setQuan_cur(ordinfo.getQuan_cur());
		qryinfo.setCode_pgku_cur(ordinfo.getCode_pgku_cur());
		qryinfo.setCode_pres(ordinfo.getCode_pres());
		qryinfo.setFg_skintest(ordinfo.getFg_skintest());
		qryinfo.setSd_rst_skintest(ordinfo.getSd_rst_skintest());
		qryinfo.setSd_nodispense(ordinfo.getSd_nodispense());
		qryinfo.setPri(ordinfo.getPri());
		qryinfo.setSd_hpsrvtp(ordinfo.getSd_hpsrvtp());
		qryinfo.setFg_selfpay(ordinfo.getFg_selfpay());
		qryinfo.setFg_specill(ordinfo.getFg_specill());
		qryinfo.setFg_research(ordinfo.getFg_research());
		qryinfo.setCode_researchproject(ordinfo.getCode_researchproject());
		qryinfo.setNo_ba(ordinfo.getNo_ba());
		return qryinfo;
		
	}

}
