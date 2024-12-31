package iih.en.er.bp.pre;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeTypeConst;
import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.bd.srv.dto.d.PhySignDTO;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.PiPatEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnCodeUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnFMapUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.er.dto.d.EnErPreTriageDTO;
import iih.en.er.dto.d.TriageLevelDTO;
import iih.en.er.ip.d.EnEntIpErDO;
import iih.en.er.ip.i.IEnentiperCudService;
import iih.en.er.ip.i.IEnentiperRService;
import iih.en.er.op.d.EnEntOpErDO;
import iih.en.er.op.i.IEnentoperCudService;
import iih.en.er.op.i.IEnentoperRService;
import iih.en.er.pre.d.EnErPreDO;
import iih.en.er.pre.d.EnErPrePatDO;
import iih.en.er.pre.d.EnErPreScoreDO;
import iih.en.er.pre.i.IEnerpreCudService;
import iih.en.er.pre.i.IEnerpreRService;
import iih.en.er.pre.i.IEnerprepatCudService;
import iih.en.er.pre.i.IEnerprepatRService;
import iih.en.er.pre.i.IEnerprescoredoCudService;
import iih.en.er.pre.i.IEnerprescoredoRService;
import iih.en.pv.enres.d.EnEvtDO;
import iih.en.pv.enres.i.IEnevtCudService;
import iih.en.pv.enres.i.IEnevtRService;
import iih.en.pv.sco.scotp.d.EnScoTpDO;
import iih.en.pv.sco.scotp.i.IEnscotpRService;
import iih.en.pv.vt.d.EnVtDO;
import iih.en.pv.vt.d.EnVtSrvDO;
import iih.en.pv.vt.d.EnvtAggDO;
import iih.en.pv.vt.i.IEnvtCudService;
import iih.en.pv.vt.i.IEnvtRService;
import iih.pi.dic.patientcategory.d.PiPatCaDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PatiAddrDO;
import iih.pi.reg.pat.d.PatiAggDO;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.i.IPatiCudService;
import iih.pi.reg.pat.i.IPatiRService;
import iih.pi.reg.pat.i.IPiPatContDORService;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 保存急诊预检
 * 
 * @author liubin
 *
 */
public class SaveErPreBP {
	/**
	 * 保存急诊预检
	 * 
	 * @param erPreTriage
	 * @return
	 * @throws BizException
	 */
	public EnErPreTriageDTO exec(EnErPreTriageDTO erPreTriage) throws BizException {
		// 先根据预检id去查询dto
		IEnerpreRService serv = ServiceFinder.find(IEnerpreRService.class);
		EnErPreDO enerpredo = serv.findById(erPreTriage.getId_obspre());
		Boolean isnew = null;
		String id_erpre = null;
		if (enerpredo == null) {
			isnew = true;
		} else {
			isnew = false;
			// if(!(IEnDictCodeConst.SD_STATUS_ERPRE_NEW.equals(enerpredo.getSd_status()))){
			// throw new BizException("患者状态已经被修改!");
			// }
		}
		String code = null;
		EnErPreDO enErPreDO = null;
		List<PatiAggDO> patList = null;
		List<EnErPreDO> enerpreList = null;
		// 1.保存患者注册表pi_pat
		patList = this.savePiPat(erPreTriage);
		// 2.保存地址信息
		this.saveAddr(erPreTriage, patList);
		// 3.保存联系人信息,保存agg
		List<PatiAggDO> agglist = this.saveCont(erPreTriage, patList);
		erPreTriage.setId_pat(((PatDO) agglist.get(0).getParentDO()).getId_pat());
		// 4.保存急诊预检表en_erpre
		enerpreList = this.saveEnerpre(erPreTriage, isnew, patList);
		enErPreDO = enerpreList.get(0);
		// id_erpre = enErPreDO.getId_erpre();
		code = enErPreDO.getCode();
		// 5.保存急诊预检患者表en_erpre_pat
		this.saveEnerprePat(erPreTriage, id_erpre, isnew, enerpreList);
		// 6.保存生命体征信息
		this.saveEnvt(erPreTriage, isnew, enerpreList);
		// 7.保存急诊预检分级表en_erpre_levitm
		this.saveEnerpreLevitm(erPreTriage, id_erpre, isnew, enerpreList);
		// 判断是否为新增
		if (enErPreDO.getStatus() == 0)
			// 8.保存EnEvtDO
			this.saveEnEvtDO(erPreTriage, enErPreDO.getId_erpre(), isnew, enerpreList);
		// 保存后设置预检id，防止重复新增
		// erPreTriage.setId_obspre(id_erpre);
		// 回显预检码
		if (erPreTriage.getFg_wms() == null || FBoolean.FALSE.equals(erPreTriage.getFg_wms())) {
			erPreTriage.setNo_obspre(code);
			erPreTriage.setCode_pat(((PatDO) patList.get(0).getParent()).getCode());
		}

		// 9.更新en_ent_ip_er/en_ent_op_er
		this.updateOPER(enErPreDO, isnew);
		this.updateIPER(enErPreDO, isnew);

		FArrayList id_obspre_list = new FArrayList();
		for (EnErPreDO enErPreDO2 : enerpreList) {
			id_obspre_list.add(enErPreDO2.getId_erpre());
		}
		erPreTriage.setId_obspre_list(id_obspre_list);
		return erPreTriage;
	}

	// 9.修改时更新ip_er表
	private void updateIPER(EnErPreDO erpre, Boolean isnew) throws BizException {
		if (isnew || erpre.getId_erpre() == null || erpre.getId_ent_last() == null)
			return;
		IEnentiperRService serv = ServiceFinder.find(IEnentiperRService.class);
		EnEntIpErDO[] enipers = serv.find(
				String.format(" ID_ERPRE = '%s' and ID_ENT = '%s'", erpre.getId_erpre(), erpre.getId_ent_last()), "",
				FBoolean.FALSE);
		if (enipers == null || enipers.length <= 0)
			return;
		EnEntIpErDO eniper = enipers[0];
		eniper.setStatus(DOStatus.UPDATED);
		IUdidocServiceExt serv3 = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] scoles = serv3.findByUdidoclistCode(IEnDictCodeTypeConst.SD_ERPRE_SCOLE);
		Map<String, UdidocDO> scolesMap = EnFMapUtils.getMap(UdidocDO.CODE, scoles);
		if (scolesMap == null || scolesMap.size() <= 0)
			return;
		UdidocDO scole = scolesMap.get(erpre.getSd_scale_hm());
		String name = EnValidator.isEmpty(scole.getCtrl1()) ? scole.getName() : scole.getCtrl1();
		eniper.setSd_scale_triage(erpre.getSd_scale_hm());
		eniper.setName_scale_triage(name);
		IEnentiperCudService serv2 = ServiceFinder.find(IEnentiperCudService.class);
		serv2.save(new EnEntIpErDO[] { eniper });

	}

	// 修改时更新op_er表
	private void updateOPER(EnErPreDO erpre, Boolean isnew) throws BizException {
		if (isnew || erpre.getId_erpre() == null || erpre.getId_ent_last() == null)
			return;
		IEnentoperRService serv = ServiceFinder.find(IEnentoperRService.class);
		EnEntOpErDO[] enopers = serv.find(
				String.format(" ID_ERPRE = '%s' and ID_ENT = '%s'", erpre.getId_erpre(), erpre.getId_ent_last()), "",
				FBoolean.FALSE);
		if (enopers == null || enopers.length <= 0)
			return;
		EnEntOpErDO enoper = enopers[0];
		enoper.setStatus(DOStatus.UPDATED);
		IUdidocServiceExt serv3 = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] scoles = serv3.findByUdidoclistCode(IEnDictCodeTypeConst.SD_ERPRE_SCOLE);
		Map<String, UdidocDO> scolesMap = EnFMapUtils.getMap(UdidocDO.CODE, scoles);
		if (scolesMap == null || scolesMap.size() <= 0)
			return;
		UdidocDO scole = scolesMap.get(erpre.getSd_scale_hm());
		String name = EnValidator.isEmpty(scole.getCtrl1()) ? scole.getName() : scole.getCtrl1();
		enoper.setSd_scale_triage(erpre.getSd_scale_hm());
		enoper.setName_scale_triage(name);
		IEnentoperCudService serv2 = ServiceFinder.find(IEnentoperCudService.class);
		serv2.save(new EnEntOpErDO[] { enoper });
	}

	/**
	 * 保存急诊预检表
	 * 
	 * @param erPreTriage
	 * @param enerpreList2
	 * @throws BizException
	 */
	private List<EnErPreDO> saveEnerpre(EnErPreTriageDTO erPreTriage, Boolean isnew, List<PatiAggDO> patList)
			throws BizException {
		EnErPreDO enerpredo = null;
		PatDO patDO = null;
		List<EnErPreDO> enerpreList = new LinkedList<EnErPreDO>();
		if (isnew) {
			for (PatiAggDO pataggDO : patList) {
				patDO = (PatDO) pataggDO.getParent();
				enerpredo = new EnErPreDO();
				enerpredo.setStatus(DOStatus.NEW);
				enerpredo.setSd_status(IEnDictCodeConst.SD_STATUS_ERPRE_NEW);
				enerpredo.setId_pat(patDO.getId_pat());
				enerpredo.setId_erpre(erPreTriage.getId_obspre());
				enerpredo.setId_grp(EnContextUtils.getGrpId());
				enerpredo.setId_org(EnContextUtils.getOrgId());
				enerpredo.setFg_refuse_exa(erPreTriage.getFg_refuse_pre());
				enerpredo.setDes_cmpt(erPreTriage.getManual_cmptdes());
				String code = EnCodeUtils.createErPreCode();
				if (EnValidator.isEmpty(code))
					throw new BizException("预检编码生成错误！");
				enerpredo.setCode(code);
				enerpredo.setName_pat(patDO.getName());
				enerpreList.add(enerpredo);
			}
		} else {
			IEnerpreRService serv = ServiceFinder.find(IEnerpreRService.class);
			enerpredo = serv.findById(erPreTriage.getId_obspre());
			enerpredo.setStatus(DOStatus.UPDATED);
			enerpredo.setName_pat(erPreTriage.getName_pat());
			enerpreList.add(enerpredo);
		}
		for (EnErPreDO enerpredo2 : enerpreList) {
			enerpredo2.setFg_nonperson(erPreTriage.getFg_nonperson());
			enerpredo2.setDt_entry(erPreTriage.getDt_entry());
			enerpredo2.setSd_come_way(erPreTriage.getSd_come_way());
			enerpredo2.setId_come_way(erPreTriage.getId_come_way());
			enerpredo2.setSds_companion(erPreTriage.getSds_companion());
			enerpredo2.setIds_companion(erPreTriage.getIds_companion());
			enerpredo2.setNames_companion(erPreTriage.getNames_companion());// name
			enerpredo2.setEu_chk_eqidemic(erPreTriage.getEu_chk_eqidemic());
			enerpredo2.setIds_chk_note(erPreTriage.getIds_chk_note());
			enerpredo2.setSds_chk_note(erPreTriage.getSds_chk_note());
			enerpredo2.setNames_chk_note(erPreTriage.getNames_chk_note());// name
			enerpredo2.setId_breath_state(erPreTriage.getId_breath_state());
			enerpredo2.setSd_breath_state(erPreTriage.getSd_breath_state());
			enerpredo2.setDt_pick_vs(erPreTriage.getDt_pick_vs());
			enerpredo2.setId_triage_ca(erPreTriage.getId_triage_ca());
			enerpredo2.setId_triage_cmpt(erPreTriage.getId_triage_cmpt());
			enerpredo2.setId_triage_res(erPreTriage.getId_triage_res());
			enerpredo2.setSd_scale_auto(erPreTriage.getSd_scale_auto());
			if (erPreTriage.getSd_scale_hm() == null) {
				enerpredo2.setSd_scale_hm(erPreTriage.getSd_scale_auto());
			} else {
				enerpredo2.setSd_scale_hm(erPreTriage.getSd_scale_hm());
			}
			enerpredo2.setSd_scale_cmpt(erPreTriage.getSd_scale_cmpt());
			enerpredo2.setId_dep_to(erPreTriage.getId_dep_to());
			enerpredo2.setName_dep_to(erPreTriage.getName_dep_to());// name
			enerpredo2.setFg_green_channel(erPreTriage.getFg_green_channel());
			enerpredo2.setIds_green_channel_sym(erPreTriage.getId_green_channel_sym());
			enerpredo2.setSds_green_channel_sym(erPreTriage.getSd_green_channel_sym());
			enerpredo2.setNames_green_channel(erPreTriage.getName_green_channel_sym());// name
			enerpredo2.setId_emp_pre(EnContextUtils.getPsnId());
			enerpredo2.setSd_triage_to(erPreTriage.getSd_triage_to());
			enerpredo2.setFg_refuse_exa(erPreTriage.getFg_refuse_pre());
			enerpredo2.setDes_cmpt(erPreTriage.getManual_cmptdes());
		}
		IEnerpreCudService serv = ServiceFinder.find(IEnerpreCudService.class);
		serv.save(enerpreList.toArray(new EnErPreDO[0]));
		return enerpreList;
	}

	/**
	 * 保存急诊预检患者表
	 * 
	 * @param erPreTriage
	 * @param enerpreList
	 * @throws BizException
	 */
	private void saveEnerprePat(EnErPreTriageDTO erPreTriage, String id_erpre, Boolean isnew,
			List<EnErPreDO> enerpreList) throws BizException {
		EnErPrePatDO patdo = null;
		List<EnErPrePatDO> patdoList = new LinkedList<EnErPrePatDO>();
		if (isnew) {
			for (EnErPreDO enErPreDO : enerpreList) {
				EnErPrePatDO patdo2 = new EnErPrePatDO();
				patdo2.setStatus(DOStatus.NEW);
				patdo2.setId_erpre(enErPreDO.getId_erpre());
				patdo2.setName(enErPreDO.getName_pat());
				patdoList.add(patdo2);
			}
		} else {
			IEnerprepatRService serv = ServiceFinder.find(IEnerprepatRService.class);
			EnErPrePatDO[] enpats = serv.find(String.format(" ID_ERPRE = '%s' ", id_erpre), "", FBoolean.FALSE);
			if (enpats == null || enpats.length <= 0)
				return;
			patdo = enpats[0];
			patdo.setStatus(DOStatus.UPDATED);
			patdoList.add(patdo);
		}
		for (EnErPrePatDO patdo2 : patdoList) {
			patdo2.setId_sex(erPreTriage.getId_sex());
			patdo2.setSd_sex(erPreTriage.getSd_sex());
			patdo2.setTelno(erPreTriage.getTel());
			patdo2.setName_admdiv_addr(erPreTriage.getName_admdiv());
			patdo2.setSd_admdiv_addr(erPreTriage.getSd_admdiv());
			patdo2.setId_admdiv_addr(erPreTriage.getId_admdiv());
			patdo2.setName_cont(erPreTriage.getName_cont());
			patdo2.setName_conttp(erPreTriage.getName_conttp());
			patdo2.setId_conttp(erPreTriage.getId_conttp());
			patdo2.setSd_conttp(erPreTriage.getSd_conttp());
			patdo2.setId_patcont(erPreTriage.getId_patcont());
			patdo2.setTelno_cont(erPreTriage.getTel_cont());
			patdo2.setAddr(erPreTriage.getStreet());
		}
		IEnerprepatCudService serv = ServiceFinder.find(IEnerprepatCudService.class);
		serv.save(patdoList.toArray(new EnErPrePatDO[0]));
	}

	/**
	 * 保存急诊预检分级表
	 * 
	 * @param erPreTriage
	 * @param enerpreList
	 * @throws BizException
	 */
	private void saveEnerpreLevitm(EnErPreTriageDTO erPreTriage, String id_erpre, Boolean isnew,
			List<EnErPreDO> enerpreList) throws BizException {
		List<EnErPreScoreDO> scoredoList = new LinkedList<EnErPreScoreDO>();
		for (EnErPreDO enErPreDO : enerpreList) {
			IEnerprescoredoRService serv = ServiceFinder.find(IEnerprescoredoRService.class);
			EnErPreScoreDO[] scoredos = serv.find(String.format(" ID_ERPRE = '%s' ", enErPreDO.getId_erpre()), "",
					FBoolean.FALSE);
			if (!EnValidator.isEmpty(scoredos))
				Collections.addAll(scoredoList, scoredos);
			if (erPreTriage.getScale_list() != null && !erPreTriage.getScale_list().isEmpty()) {
				for (Object obj : erPreTriage.getScale_list()) {
					TriageLevelDTO level = (TriageLevelDTO) obj;
					EnErPreScoreDO scoredo = null;
					if (isnew || scoredoList.size() == 0) {
						scoredo = new EnErPreScoreDO();
						scoredo.setStatus(DOStatus.NEW);
						scoredo.setId_erpre(enErPreDO.getId_erpre());
					} else {
						if (scoredoList != null && scoredoList.size() > 0) {
							for (EnErPreScoreDO scoredo2 : scoredoList) {
								if (scoredo2.getSd_scotp().equals(level.getSd_scaletp())) {
									scoredo = scoredo2;
									scoredo.setStatus(DOStatus.UPDATED);
									scoredoList.remove(scoredo2);
								}
								if (scoredo == null) {
									scoredo = new EnErPreScoreDO();
									scoredo.setStatus(DOStatus.NEW);
									scoredo.setId_erpre(id_erpre);
								}
							}
						}
					}
					scoredo.setSd_scotp(level.getSd_scaletp());
					// 调服务查询评分类型id????
					IEnscotpRService rserv = ServiceFinder.find(IEnscotpRService.class);
					EnScoTpDO[] scos = rserv.find(String.format(" CODE = '%s' ", level.getSd_scaletp()), "",
							FBoolean.FALSE);
					if (scos == null || scos.length <= 0) {
						scoredo.setId_scotp(null);
					} else {
						scoredo.setId_scotp(scos[0].getId_scotp());
					}
					// score表没有记录Sd_scale()的啊??怎么办?先用score代替?
					if ("01".equals(scoredo.getSd_scotp())) {
						scoredo.setScore(level.getSd_scale());
						scoredo.setNote(level.getLevel_des());
						scoredoList.add(scoredo);
					} else {
						// break;
					}
					// scoredo.setScore(level.getSd_scale());
					// scoredo.setNote(level.getLevel_des());
					// scoredoList.add(scoredo);
				}
			}
		}
		IEnerprescoredoCudService cudserv = ServiceFinder.find(IEnerprescoredoCudService.class);
		cudserv.save(scoredoList.toArray(new EnErPreScoreDO[0]));
	}

	/**
	 * 保存生命体征信息
	 * 
	 * @param erPreTriage
	 * @param id_erpre
	 * @param isnew
	 * @param enerpreList
	 * @throws BizException
	 */
	private void saveEnvt(EnErPreTriageDTO erPreTriage, Boolean isnew, List<EnErPreDO> enerpreList)
			throws BizException {
		// 1.获取AggDO
		List<EnvtAggDO> enVtAggList = new LinkedList<EnvtAggDO>();
		for (EnErPreDO enErPreDO : enerpreList) {
			EnvtAggDO agg = getEnvtAggDO(erPreTriage, enErPreDO.getId_erpre());
			EnVtDO envtDO = agg.getParentDO();
			if (envtDO == null)
				envtDO = new EnVtDO();
			envtDO.setId_erpre(enErPreDO.getId_erpre());
			agg.setParentDO(envtDO);
			enVtAggList.add(agg);
		}
		for (EnvtAggDO agg : enVtAggList) {
			// 2.保存体征信息
			EnVtSrvDO[] enVtSrvDOs = agg.getEnVtSrvDO();
			List<EnVtSrvDO> enVtSrvList = new LinkedList<EnVtSrvDO>();
			if (!EnValidator.isEmpty(enVtSrvDOs))
				Collections.addAll(enVtSrvList, enVtSrvDOs);
			// 2.1设置envtdo
			EnVtDO envtDO = agg.getParentDO();
			if (isnew) {
				envtDO.setStatus(DOStatus.NEW);
			} else {
				envtDO.setStatus(DOStatus.UPDATED);
			}
			envtDO.setId_ent(erPreTriage.getId_ent());
			envtDO.setDt_insert(EnAppUtils.getServerDateTime());
			envtDO.setDt_vt(erPreTriage.getDt_pick_vs());
			envtDO.setId_emp_rec(EnContextUtils.getPsnId());
			envtDO.setFg_last(new FBoolean(true));
			// 2.2设置srvdo
			if (erPreTriage.getVs_list() != null && !erPreTriage.getVs_list().isEmpty()) {
				for (Object obj : erPreTriage.getVs_list()) {
					PhySignDTO phySign = (PhySignDTO) obj;
					EnVtSrvDO enVtSrvDO = null;
					if (isnew) {
						enVtSrvDO = new EnVtSrvDO();
						enVtSrvDO.setStatus(DOStatus.NEW);
						enVtSrvDO.setId_ent(erPreTriage.getId_ent());
						enVtSrvDO.setId_srv(phySign.getId_srv());
					} else {
						for (EnVtSrvDO enVtSrvDO2 : enVtSrvList) {
							if (enVtSrvDO2.getId_srv().equals(phySign.getId_srv())) {
								enVtSrvDO = enVtSrvDO2;
								enVtSrvDO.setStatus(DOStatus.UPDATED);
							}
							// 没有相应项的情况（不常出现）
							if (enVtSrvDO == null) {
								enVtSrvDO = new EnVtSrvDO();
								enVtSrvDO.setStatus(DOStatus.NEW);
								enVtSrvDO.setId_ent(erPreTriage.getId_ent());
								enVtSrvDO.setId_srv(phySign.getId_srv());
								enVtSrvDO.setId_envt(envtDO.getId_envt());
							}
						}
					}
					// 没有相应项的情况（不常出现）
					if (enVtSrvDO == null) {
						enVtSrvDO = new EnVtSrvDO();
						enVtSrvDO.setStatus(DOStatus.NEW);
						enVtSrvDO.setId_ent(erPreTriage.getId_ent());
						enVtSrvDO.setId_srv(phySign.getId_srv());
					}
					enVtSrvDO.setVal0(phySign.getVal0());
					enVtSrvDO.setVal1(phySign.getVal1());
					enVtSrvDO.setVal2(phySign.getVal2());
					enVtSrvDO.setVal3(phySign.getVal3());
					enVtSrvDO.setVal4(phySign.getVal4());
					enVtSrvList.add(enVtSrvDO);
				}
			}
			agg.setParentDO(envtDO);
			agg.setEnVtSrvDO(enVtSrvList.toArray(new EnVtSrvDO[0]));
		}
		IEnvtCudService serv = ServiceFinder.find(IEnvtCudService.class);
		serv.save(enVtAggList.toArray(new EnvtAggDO[0]));
	}

	/**
	 * 获取生命体征aggDO
	 * 
	 * @param erPreTriage
	 * @param id_erpre
	 * @return
	 * @throws BizException
	 */
	private EnvtAggDO getEnvtAggDO(EnErPreTriageDTO erPreTriage, String id_erpre) throws BizException {
		if (EnValidator.isEmpty(id_erpre))
			return new EnvtAggDO();
		IEnvtRService serv = ServiceFinder.find(IEnvtRService.class);
		EnvtAggDO[] aggs = serv.find(String.format(" ID_ERPRE = '%s' ", id_erpre), "", FBoolean.FALSE);
		if (aggs == null || aggs.length <= 0)
			return new EnvtAggDO();
		EnvtAggDO agg = aggs[0];
		/*
		 * if(EnValidator.isEmpty(agg)) throw new
		 * BizException("未获取到患者体征信息！");
		 */
		return agg;
	}

	/**
	 * 保存EnEvtDO
	 * 
	 * @param erPreTriage
	 * @param enerpreList
	 * @throws BizException
	 */
	private void saveEnEvtDO(EnErPreTriageDTO erPreTriage, String id_erpre, Boolean isnew, List<EnErPreDO> enerpreList)
			throws BizException {
		List<EnEvtDO> enEvtList = new LinkedList<EnEvtDO>();
		FDateTime nowTime = EnAppUtils.getServerDateTime();
		for (EnErPreDO enErPreDO : enerpreList) {
			EnEvtDO enevtdo = null;
			EnEvtDO enevtdo2 = null;
			if (isnew) {
				enevtdo = new EnEvtDO();
				enevtdo2 = new EnEvtDO();
				enevtdo.setStatus(DOStatus.NEW);
				enevtdo2.setStatus(DOStatus.NEW);
			} else {
				IEnevtRService serv = ServiceFinder.find(IEnevtRService.class);
				EnEvtDO[] enevts = serv.find(String.format(" ID_ERPRE = '%s' ", enErPreDO.getId_erpre()), "",
						FBoolean.FALSE);
				if (enevts == null || enevts.length <= 1)
					return;
				enevtdo = enevts[0];
				enevtdo2 = enevts[1];
				enevtdo.setStatus(DOStatus.UPDATED);
				enevtdo2.setStatus(DOStatus.UPDATED);
			}
			enevtdo.setId_erpre(enErPreDO.getId_erpre());
			enevtdo2.setId_erpre(enErPreDO.getId_erpre());
			enevtdo.setId_ent(erPreTriage.getId_ent());
			enevtdo2.setId_ent(erPreTriage.getId_ent());
			enevtdo.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_ARRIVEHOS);
			enevtdo2.setSd_entevt(IEnDictCodeConst.SD_ENTEVT_ERPRE);
			enevtdo.setDes("患者到院：<姓名：" + erPreTriage.getName_pat() + " 到院时间：" + erPreTriage.getDt_entry() + ">");
			enevtdo2.setDes("患者预检:<姓名：" + erPreTriage.getName_pat() + " 预检时间：" + nowTime + " 分诊去向："
					+ erPreTriage.getName_triage_to() + " 分诊科室：" + erPreTriage.getName_dep_to() + ">");
			enevtdo.setDt_insert(nowTime);
			enevtdo2.setDt_insert(nowTime);
			enevtdo.setDt_evt(erPreTriage.getDt_entry());
			enevtdo2.setDt_evt(nowTime);
			enevtdo2.setName_emp_rec(EnContextUtils.getPsnDoc().getName());
			enevtdo.setName_emp_rec(EnContextUtils.getPsnDoc().getName());
			enevtdo2.setId_emp_rec(EnContextUtils.getPsnId());
			enevtdo.setId_emp_rec(EnContextUtils.getPsnId());
			enEvtList.add(enevtdo2);
			enEvtList.add(enevtdo);
		}
		IEnevtCudService serv = ServiceFinder.find(IEnevtCudService.class);
		serv.save(enEvtList.toArray(new EnEvtDO[0]));
	}

	/**
	 * 保存患者表pi_pat
	 * 
	 * @param erPreTriage
	 * @throws BizException
	 */
	private List<PatiAggDO> savePiPat(EnErPreTriageDTO erPreTriage) throws BizException {
		PatDO pat = null;
		PatiAggDO agg = null;
		int a = 0;// 循环计数
		int start = FBoolean.TRUE.equals(erPreTriage.getFg_wms()) && erPreTriage.getCount_start() != null
				&& erPreTriage.getCount_end() != null ? erPreTriage.getCount_start() : 0;
		int end = FBoolean.TRUE.equals(erPreTriage.getFg_wms()) && erPreTriage.getCount_start() != null
				&& erPreTriage.getCount_end() != null ? erPreTriage.getCount_end() : 0;
		if (start > end) {
			int b = start;
			start = end;
			end = b;
		}
		List<PatiAggDO> pataggdoList = new LinkedList<PatiAggDO>();
		if (erPreTriage.getId_pat() == null) {
			for (int i = start; i <= end; i++) {
				agg = new PatiAggDO();
				pat = new PatDO();
				pat.setStatus(DOStatus.NEW);
				PiPatEP ep = new PiPatEP();
				PiPatCaDO patCate = ep.getPatDefaultCate();
				pat.setId_patpritp(patCate.getId_patpritp());// 价格分类
				pat.setId_patcrettp(patCate.getId_patcrettp());// 信用分类
				pat.setId_paticate(patCate.getId_patca());
				pat.setId_grp(EnContextUtils.getGrpId());
				pat.setId_org(EnContextUtils.getOrgId());
				pat.setCode(EnCodeUtils.createPatCode());
				// 截掉后两位作为患者的Barcode_chis
				String strm = pat.getCode().substring(0, pat.getCode().length() - 2);
				pat.setBarcode_chis(strm);
				agg.setParentDO(pat);
				pataggdoList.add(agg);
			}
		} else {
			agg = this.getPatiAggDO(erPreTriage.getId_pat());
			pat = agg.getParentDO();
			pat.setStatus(DOStatus.UPDATED);
			pataggdoList.add(agg);
		}
		for (PatiAggDO patagg2 : pataggdoList) {
			PatDO pat2 = (PatDO) patagg2.getParent();
			if (FBoolean.TRUE.equals(erPreTriage.getFg_wms()) && erPreTriage.getCount_start() != null
					&& erPreTriage.getCount_end() != null) {
				int No_name = erPreTriage.getCount_start() + a;
				pat2.setName(erPreTriage.getName_pat() + No_name);
				a++;
			} else {
				pat2.setName(erPreTriage.getName_pat());
			}
			pat2.setPhoto(erPreTriage.getPhoto());
			pat2.setId_sex(erPreTriage.getId_sex());
			pat2.setSd_sex(erPreTriage.getSd_sex());
			pat2.setName_sex(erPreTriage.getName_sex());
			pat2.setMob(erPreTriage.getTel());
			pat2.setId_code(erPreTriage.getNo_id());
			pat2.setId_idtp(erPreTriage.getId_idtp());
			pat2.setSd_idtp(erPreTriage.getSd_idtp());
			pat2.setIdtp_name(erPreTriage.getName_idtp());
			pat2.setDt_birth(erPreTriage.getDt_birth());
			pat2.setAge(AgeCalcUtil.getAge(erPreTriage.getDt_birth()));
		}
		return pataggdoList;
	}

	/**
	 * 得到PatiAggDO 旧患者取出 新患者新建
	 * 
	 * @param idPat
	 * @return
	 * @throws BizException
	 */
	private PatiAggDO getPatiAggDO(String idPat) throws BizException {
		if (EnValidator.isEmpty(idPat))
			return new PatiAggDO();
		IPatiRService serv = ServiceFinder.find(IPatiRService.class);
		PatiAggDO agg = serv.findById(idPat);
		if (EnValidator.isEmpty(agg))
			throw new BizException(IEnMsgConst.ERROR_PAT_NOT_EXIST);
		return agg;
	}

	/**
	 * 保存患者地址信息
	 * 
	 * @param erPreTriage
	 * @param pataggList
	 * @throws BizException
	 */
	private void saveAddr(EnErPreTriageDTO erPreTriage, List<PatiAggDO> pataggList) throws BizException {
		List<PatiAddrDO> patAddrList = null;
		PiPatEP ep = new PiPatEP();
		// 地址信息
		for (PatiAggDO pataggDO : pataggList) {
			patAddrList = new LinkedList<PatiAddrDO>();
			PatiAddrDO[] addrs = pataggDO.getPatiAddrDO();
			if (!EnValidator.isEmpty(addrs))
				Collections.addAll(patAddrList, addrs);
			if (addrs == null) {
				addrs = new PatiAddrDO[] {};
			}
			PatiAddrDO addr = null;
			for (PatiAddrDO patiAddrDO : addrs) {
				if (IPiDictCodeConst.ID_ADDR_TYPE_NOW.equals(patiAddrDO.getId_addrtp())) {
					addr = patiAddrDO;
				}
			}
			if (addr == null) {
				if (erPreTriage.getId_admdiv() != null || erPreTriage.getStreet() != null) {
					addr = new PatiAddrDO();
					addr.setId_addrtp(IPiDictCodeConst.ID_ADDR_TYPE_NOW);
					addr.setSd_addrtp(IPiDictCodeConst.SD_ADDR_TYPE_NOW);
					PatDO pat = (PatDO) pataggDO.getParent();
					addr.setId_pat(pat.getId_pat());
					addr.setStatus(DOStatus.NEW);
					patAddrList.add(addr);
				}
			} else {
				addr.setStatus(DOStatus.UPDATED);
			}
			if (addr != null) {
				addr.setStreet(erPreTriage.getStreet());
				addr.setAdmdiv_name(erPreTriage.getName_admdiv());
				addr.setId_admdiv(erPreTriage.getId_admdiv());
				addr.setSd_admdiv(erPreTriage.getSd_admdiv());
			}
			pataggDO.setPatiAddrDO(patAddrList.toArray(new PatiAddrDO[0]));
		}

	}

	/**
	 * 保存联系人信息,保存agg
	 * 
	 * @param erPreTriage
	 * @param patList
	 * @throws BizException
	 */
	@SuppressWarnings("null")
	private List<PatiAggDO> saveCont(EnErPreTriageDTO erPreTriage, List<PatiAggDO> pataggList) throws BizException {
		if(erPreTriage.getName_cont() == null && erPreTriage.getTel_cont() == null){
			IPatiCudService serv = ServiceFinder.find(IPatiCudService.class);
			serv.save(pataggList.toArray(new PatiAggDO[0]));
			return pataggList;
		}
		List<PiPatContDO> patContList = null;
		IPiPatContDORService srv = ServiceFinder.find(IPiPatContDORService.class);
		for (PatiAggDO pataggDO : pataggList) {
			PiPatContDO[] patconts = pataggDO.getPiPatContDO();
			patContList = new LinkedList<PiPatContDO>();
			if (!EnValidator.isEmpty(patconts))
				Collections.addAll(patContList, patconts);
			PatDO patDO = pataggDO.getParentDO();
			PiPatContDO piContDO = null;
			int sortNo = 0;
			for (PiPatContDO contDO : patContList) {
				if (!EnValidator.isEmpty(erPreTriage.getId_patcont())) {
					if (contDO.getId_patcont().equals(erPreTriage.getId_patcont())) {
						piContDO = contDO;
						piContDO.setStatus(DOStatus.UPDATED);
					}
				}
				if (contDO.getSortno() != null && contDO.getSortno() > sortNo) {
					sortNo = contDO.getSortno();
				}
			}
			if (piContDO == null) {
				piContDO = new PiPatContDO();
				piContDO.setStatus(DOStatus.NEW);
				piContDO.setSortno(++sortNo);
				patContList.add(piContDO);
			}
			piContDO.setId_pat(patDO.getId_pat());
			piContDO.setId_patcont(erPreTriage.getId_patcont());
			piContDO.setId_conttp(erPreTriage.getId_conttp());
			piContDO.setSd_conttp(erPreTriage.getSd_conttp());
			piContDO.setConttp_name(erPreTriage.getName_conttp());
			piContDO.setName(erPreTriage.getName_cont());
			piContDO.setConttel(erPreTriage.getTel_cont());
			pataggDO.setPiPatContDO(patContList.toArray(new PiPatContDO[0]));
		}
		IPatiCudService serv = ServiceFinder.find(IPatiCudService.class);
		serv.save(pataggList.toArray(new PatiAggDO[0]));
		return pataggList;
	}
}
