package iih.en.er.bp.pre;

import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bd.srv.dto.d.PhySignDTO;
import iih.en.comm.ep.PiPatEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.EnErPreTriageDTO;
import iih.en.er.dto.d.TriageLevelDTO;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.er.pre.d.EnErPreScoreDO;
import iih.en.er.pre.i.IEnerpreRService;
import iih.en.er.pre.i.IEnerprescoredoRService;
import iih.en.pv.vt.d.EnVtDO;
import iih.en.pv.vt.d.EnVtSrvDO;
import iih.en.pv.vt.d.EnvtAggDO;
import iih.en.pv.vt.i.IEnvtRService;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.i.IPiPatContDORService;

import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 获取患者预检信息
 * 
 * @author
 *
 */
public class GetPatErPreInfosBP {
	/**
	 * 获取患者预检信息
	 * 
	 * @param patId
	 *            患者id
	 * @param statusErPre
	 *            预检状态
	 * @return
	 * @throws BizException
	 */
	public EnErPreTriageDTO[] exec(String patId, String[] statusErPre)
			throws BizException {
		// 1.查询预检信息
		// 1.1查预检id或者患者id
		List<EnErPreTriageDTO> list = new LinkedList<EnErPreTriageDTO>();
		EnErPreDO[] enpredos = getEnErPreDO(patId, statusErPre);
		boolean haserpre = true;
		if (enpredos == null) {
			enpredos = new EnErPreDO[] { new EnErPreDO() };
			haserpre = false;
		}
		// 1.2设置信息
		for (EnErPreDO enpredo : enpredos) {
			EnErPreTriageDTO enErPreTriage = new EnErPreTriageDTO();
			if (enpredo.getId_erpre() != null) {
				// 设置患者基本信息
				PatDO pat = getPat(patId);
				assemlyEnErPrePatDTO(enErPreTriage, pat);
				// 设置预检信息
				assemlyEnErPreTriageDTO(enErPreTriage, enpredo);
				// 设置生命体征
				assemlyEnVtDTO(enErPreTriage, enpredo);
				// 设置预检分级得分
				assemlyLevitmDTO(enErPreTriage, enpredo);
			}
			// 2.没有预检信息，查询患者信息
			// 2.1 设置患者信息
			else {// 没有预检
				if (!EnValidator.isEmpty(patId)) {
					PatDO pat = getPat(patId);
					assemlyEnErPrePatDTO(enErPreTriage, pat);
					FDateTime nowTime = EnAppUtils.getServerDateTime();
					enErPreTriage.setDt_entry(nowTime);
					enErPreTriage.setDt_pick_vs(nowTime);
				}
			}
			list.add(enErPreTriage);
		}
		return list.toArray(new EnErPreTriageDTO[0]);
	}

	/**
	 * 获取预检do
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private EnErPreDO[] getEnErPreDO(String id_pat, String[] statusErPre) throws BizException {
		IEnerpreRService ensrv = ServiceFinder.find(IEnerpreRService.class);
		EnErPreDO[] enerpres = ensrv.find(String.format(" ID_PAT = '%s' and  %s ", id_pat, EnSqlUtils.getInSqlByIds(" sd_status ", statusErPre)), "sv desc", FBoolean.FALSE);
		if (enerpres == null || enerpres.length <= 0)
			return null;
		return enerpres;
	}

	/**
	 * 根据患者id获取患者
	 * 
	 * @param id_pat
	 * @return
	 * @throws BizException
	 */
	private PatDO getPat(String id_pat) throws BizException {
		PatDO pat = new PatDO();
		if (EnValidator.isEmpty(id_pat))
			return pat;
		PiPatEP ep = new PiPatEP();
		pat = ep.getPatById(id_pat);
		return pat;
	}

	/**
	 * 设置预检信息
	 * 
	 * @param erPreTriage
	 * @param enerpre
	 * @throws BizException
	 */
	private void assemlyEnErPreTriageDTO(EnErPreTriageDTO erPreTriage,
			EnErPreDO enerpre) throws BizException {
		erPreTriage.setId_obspre(enerpre.getId_erpre());
		erPreTriage.setFg_nonperson(enerpre.getFg_nonperson());
		// erPreTriage.setFg_wms(enerpre.getfg);
		erPreTriage.setNo_obspre(enerpre.getCode());
		erPreTriage.setDt_entry(enerpre.getDt_entry());
		erPreTriage.setId_come_way(enerpre.getId_come_way());
		erPreTriage.setSd_come_way(enerpre.getSd_come_way());
		erPreTriage.setName_come_way(enerpre.getName_come_way());
		erPreTriage.setIds_companion(enerpre.getIds_companion());
		erPreTriage.setSds_companion(enerpre.getSds_companion());
		erPreTriage.setNames_companion(enerpre.getNames_companion());// name
		erPreTriage.setEu_chk_eqidemic(enerpre.getEu_chk_eqidemic());
		erPreTriage.setIds_chk_note(enerpre.getIds_chk_note());
		erPreTriage.setSds_chk_note(enerpre.getSds_chk_note());
		erPreTriage.setNames_chk_note(enerpre.getNames_chk_note());// name
		erPreTriage.setDt_pick_vs(enerpre.getDt_pick_vs());
		erPreTriage.setId_breath_state(enerpre.getId_breath_state());
		erPreTriage.setSd_breath_state(enerpre.getSd_breath_state());
		erPreTriage.setId_triage_ca(enerpre.getId_triage_ca());
		erPreTriage.setName_triage_ca(enerpre.getName_triage_ca());
		erPreTriage.setId_triage_cmpt(enerpre.getId_triage_cmpt());
		erPreTriage.setName_triage_cmpt(enerpre.getName_triage_cmpt());
		erPreTriage.setId_triage_res(enerpre.getId_triage_res());
		erPreTriage.setName_triage_res(enerpre.getName_triage_res());
		erPreTriage.setSd_scale_auto(enerpre.getSd_scale_auto());
		erPreTriage.setSd_scale_hm(enerpre.getSd_scale_hm());
		erPreTriage.setSd_scale_cmpt(enerpre.getSd_scale_cmpt());
		erPreTriage.setName_triage_cmpt(enerpre.getName_triage_cmpt());
		erPreTriage.setId_triage_cmpt(enerpre.getId_triage_cmpt());
		erPreTriage.setId_dep_to(enerpre.getId_dep_to());
		erPreTriage.setName_dep_to(enerpre.getName_dep_to());// name
		erPreTriage.setFg_green_channel(enerpre.getFg_green_channel());
		erPreTriage.setId_green_channel_sym(enerpre.getIds_green_channel_sym());
		erPreTriage.setSd_green_channel_sym(enerpre.getSds_green_channel_sym());
		erPreTriage.setName_green_channel_sym(enerpre.getNames_green_channel());// name
		erPreTriage.setId_triage_to(EnAppUtils.getUdidoc(
				IEnDictCodeTypeConst.SD_ERPRE_TRIAGETO, enerpre.getSd_triage_to())
				.getId_udidoc());
		erPreTriage.setSd_triage_to(enerpre.getSd_triage_to());
		erPreTriage.setName_triage_to(EnAppUtils.getUdidoc(
				IEnDictCodeTypeConst.SD_ERPRE_TRIAGETO, enerpre.getSd_triage_to())
				.getName());// name
		erPreTriage.setFg_refuse_pre(enerpre.getFg_refuse_exa());
		erPreTriage.setManual_cmptdes(enerpre.getDes_cmpt());
		erPreTriage.setSd_status(enerpre.getSd_status());
	}

	/**
	 * 通过注册患者设置患者信息
	 * 
	 * @param erPreTriage
	 * @param patdo
	 * @throws BizException
	 */
	private void assemlyEnErPrePatDTO(EnErPreTriageDTO erPreTriage, PatDO patdo)
			throws BizException {
		erPreTriage.setId_pat(patdo.getId_pat());
		erPreTriage.setName_pat(patdo.getName());
		erPreTriage.setId_sex(patdo.getId_sex());
		erPreTriage.setSd_sex(patdo.getSd_sex());
		erPreTriage.setName_sex(patdo.getName_sex());
		erPreTriage.setId_admdiv(patdo.getId_admdiv());
		erPreTriage.setSd_admdiv(patdo.getSd_admdiv());
		erPreTriage.setDt_birth(patdo.getDt_birth());
		erPreTriage.setId_idtp(patdo.getId_idtp());
		erPreTriage.setSd_idtp(patdo.getSd_idtp());
		erPreTriage.setName_idtp(patdo.getIdtp_name());
		erPreTriage.setCode_pat(patdo.getCode());
		erPreTriage.setNo_id(patdo.getId_code());
		if (!EnValidator.isEmpty(patdo.getMob()))
			erPreTriage.setTel(patdo.getMob());
		else
			erPreTriage.setTel(patdo.getTel());
		erPreTriage.setPhoto(patdo.getPhoto());
		erPreTriage.setFg_realname(patdo.getFg_realname());
		PiPatEP ep = new PiPatEP();
		PatiAddrDO pataddrdo = ep.getNowPatAddr(patdo.getId_pat());
		this.setPatAddrInfo(erPreTriage, pataddrdo);
		this.setPatContInfo(erPreTriage, patdo);
	}

	/**
	 * 设置体征信息
	 * 
	 * @param erPreTriage
	 * @param enerpre
	 * @throws BizException
	 */
	private void assemlyEnVtDTO(EnErPreTriageDTO erPreTriage, EnErPreDO enerpre)
			throws BizException {
		// 1.获取AggDO
		EnvtAggDO agg = getEnvtAggDO(erPreTriage, enerpre);
		// 2.保存体征信息
		EnVtDO envtDO = agg.getParentDO();
		EnVtSrvDO[] enVtSrvDOs = agg.getEnVtSrvDO();
		erPreTriage.setId_ent(envtDO.getId_ent());
		erPreTriage.setDt_pick_vs(envtDO.getDt_vt());
		FArrayList vs_list = new FArrayList();
		for (EnVtSrvDO enVtSrvDO : enVtSrvDOs) {
			PhySignDTO phySign = new PhySignDTO();
			phySign.setId_srv(enVtSrvDO.getId_srv());
			phySign.setVal0(enVtSrvDO.getVal0());
			phySign.setVal1(enVtSrvDO.getVal1());
			phySign.setVal2(enVtSrvDO.getVal2());
			phySign.setVal3(enVtSrvDO.getVal3());
			phySign.setVal4(enVtSrvDO.getVal4());
			vs_list.add(phySign);
		}
		erPreTriage.setVs_list(vs_list);
	}

	/**
	 * 获取aggDO
	 * 
	 * @param erPreTriage
	 * @param enerpre
	 * @return
	 * @throws BizException
	 */
	private EnvtAggDO getEnvtAggDO(EnErPreTriageDTO erPreTriage,
			EnErPreDO enerpre) throws BizException {
		IEnvtRService serv = ServiceFinder.find(IEnvtRService.class);
		EnvtAggDO[] aggs = serv.findByAttrValString(EnVtDO.ID_ERPRE, enerpre.getId_erpre());
		if (aggs == null || aggs.length <= 0)
			return new EnvtAggDO();
		EnvtAggDO agg = aggs[0];
		return agg;
	}

	/**
	 * 设置预检分级得分
	 * 
	 * @param erPreTriage
	 * @param enerpre
	 * @throws BizException
	 */
	private void assemlyLevitmDTO(EnErPreTriageDTO erPreTriage,
			EnErPreDO enerpre) throws BizException {
		IEnerprescoredoRService serv = ServiceFinder
				.find(IEnerprescoredoRService.class);
		EnErPreScoreDO[] scoredos = serv.find(
				String.format(" ID_ERPRE = '%s' ", enerpre.getId_erpre()), "",
				FBoolean.FALSE);
		FArrayList scale_list = new FArrayList();
		for (EnErPreScoreDO scoreDO : scoredos) {
			TriageLevelDTO level = new TriageLevelDTO();
			level.setId_scale(scoreDO.getId_erpre_score());
			level.setSd_scaletp(scoreDO.getSd_scotp());
			level.setId_triagelevel_itm(scoreDO.getId_scotp());
			if ("01".equals(scoreDO.getSd_scotp())) {
				level.setSd_scale(scoreDO.getScore());
			}
			// level.setSd_scale(scoreDO.getScore());
			level.setLevel_des(scoreDO.getNote());
			scale_list.add(level);
		}
		erPreTriage.setScale_list(scale_list);
	}

	/**
	 * 设置患者现住址信息
	 * 
	 * @param erPreTriage
	 * @param patAddr
	 */
	private void setPatAddrInfo(EnErPreTriageDTO erPreTriage, PatiAddrDO patAddr) {
		if (erPreTriage == null || patAddr == null)
			return;
		erPreTriage.setId_admdiv(patAddr.getId_admdiv());
		erPreTriage.setSd_admdiv(patAddr.getSd_admdiv());
		erPreTriage.setName_admdiv(patAddr.getAdmdiv_fullname());
		erPreTriage.setZipcode(patAddr.getZip());
		erPreTriage.setStreet(patAddr.getStreet());
	}

	/**
	 * 设置患者联系人信息
	 * 
	 * @param erPreTriage
	 * @param patdo
	 * @throws BizException
	 */
	private void setPatContInfo(EnErPreTriageDTO erPreTriage, PatDO patdo)
			throws BizException {
		IPiPatContDORService srv = ServiceFinder
				.find(IPiPatContDORService.class);
		PiPatContDO[] patconts = srv.find(
				String.format(" ID_PAt = '%s' ", patdo.getId_pat()), "",
				FBoolean.FALSE);
		if (patconts == null || patconts.length <= 0)
			return;
		if (patconts.length == 1 && "-".equals(patconts[0].getName()))// 防止错误数据
			return;
		PiPatContDO patcont = patconts[0];
		erPreTriage.setId_patcont(patcont.getId_patcont());
		erPreTriage.setId_conttp(patcont.getId_conttp());
		erPreTriage.setSd_conttp(patcont.getSd_conttp());
		erPreTriage.setName_conttp(patcont.getConttp_name());
		erPreTriage.setName_cont(patcont.getName());
		erPreTriage.setTel_cont(patcont.getConttel());
	}

}