package iih.bd.mm.materialnames.d.adapter;

import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import xap.mw.core.data.DOStatus;

/**
 * 药品通用名主数据适配器
 * 
 * @author hao_wu
 *
 */
public class MaterialNamesDOAdapter extends BaseAdapter {

	/**
	 * 医疗服务和药品属性适配
	 * 
	 * @param medSrvDO
	 * @param medSrvDrugDO
	 * @return
	 */
	public MaterialNamesDO getMaterialNamesDO(MedSrvDO medSrvDO, MedSrvDrugDO medSrvDrugDO) {
		MaterialNamesDO materialNamesDO = getMaterialNamesDO(medSrvDO);
		setDrugInfo(materialNamesDO, medSrvDrugDO);
		return materialNamesDO;
	}

	/**
	 * 获取药品通用名中医疗服务信息
	 * 
	 * @param materialNamesDO
	 * @return
	 */
	public MedSrvDO getMedSrvDO(MaterialNamesDO materialNamesDO) {
		MedSrvDO medSrvDO = new MedSrvDO();
		setDOCommonProp(medSrvDO, materialNamesDO);
		medSrvDO.setId_srv(materialNamesDO.getId_materialname());
		medSrvDO.setId_grp(materialNamesDO.getId_grp());
		medSrvDO.setId_org(materialNamesDO.getId_org());
		medSrvDO.setCode(materialNamesDO.getCode());
		medSrvDO.setName(materialNamesDO.getName());
		medSrvDO.setId_srvtp(materialNamesDO.getId_srvtp());
		medSrvDO.setSrvtp_code(materialNamesDO.getSrvtp_code());
		medSrvDO.setSrvtp_name(materialNamesDO.getSrvtp_name());
		medSrvDO.setSd_srvtp(materialNamesDO.getSd_srvtp());
		medSrvDO.setId_srvca(materialNamesDO.getId_srvca());
		medSrvDO.setSrvca_code(materialNamesDO.getSrvca_code());
		medSrvDO.setSrvca_name(materialNamesDO.getSrvca_name());
		medSrvDO.setSrvca_innercode(materialNamesDO.getSrvca_innercode());
		medSrvDO.setPycode(materialNamesDO.getPycode());
		medSrvDO.setWbcode(materialNamesDO.getWbcode());
		medSrvDO.setMnecode(materialNamesDO.getMnecode());
		medSrvDO.setShortname(materialNamesDO.getShortname());
		medSrvDO.setDes(materialNamesDO.getDes());
		medSrvDO.setQuan_med(materialNamesDO.getQuan_dosage());
		medSrvDO.setId_unit_med(materialNamesDO.getId_unit_med());
		medSrvDO.setMed_code(materialNamesDO.getUnit_med_code());
		medSrvDO.setMed_name(materialNamesDO.getUnit_med_name());
		medSrvDO.setId_freq(materialNamesDO.getId_freq());
		medSrvDO.setFreq_code(materialNamesDO.getFreq_code());
		medSrvDO.setFreq_name(materialNamesDO.getFreq_name());
		medSrvDO.setSd_frequnitct(materialNamesDO.getFreq_sd_frequnitct());
		medSrvDO.setFrequnitct(materialNamesDO.getFreq_frequnitct());
		medSrvDO.setFreqct(materialNamesDO.getFreq_freqct());
		medSrvDO.setFg_prnor(materialNamesDO.getFreq_fg_prnor());
		medSrvDO.setFg_long(materialNamesDO.getFreq_fg_long());
		medSrvDO.setId_route(materialNamesDO.getId_route());
		medSrvDO.setRoute_code(materialNamesDO.getRoute_code());
		medSrvDO.setRoute_name(materialNamesDO.getRoute_name());
		medSrvDO.setRoute_mnecode(materialNamesDO.getRoute_mnecode());
		medSrvDO.setId_routedes(materialNamesDO.getId_routedes());
		medSrvDO.setRoutedes_code(materialNamesDO.getRoutedes_code());
		medSrvDO.setRoutedes_name(materialNamesDO.getRoutedes_name());
		medSrvDO.setId_boil(materialNamesDO.getId_boil());
		medSrvDO.setBoil_code(materialNamesDO.getBoil_code());
		medSrvDO.setBoil_name(materialNamesDO.getBoil_name());
		medSrvDO.setBoil_mnecode(materialNamesDO.getBoil_mnecode());
		medSrvDO.setId_boildes(materialNamesDO.getId_boildes());
		medSrvDO.setBoildes_code(materialNamesDO.getBoildes_code());
		medSrvDO.setBoildes_name(materialNamesDO.getBoildes_name());
		medSrvDO.setBoildes_mnecode(materialNamesDO.getBoildes_mnecode());
		medSrvDO.setId_primd(materialNamesDO.getId_primd());
		medSrvDO.setPrimd_code(materialNamesDO.getPrimd_code());
		medSrvDO.setPrimd_name(materialNamesDO.getPrimd_name());
		medSrvDO.setSd_primd(materialNamesDO.getSd_primd());
		medSrvDO.setPri(materialNamesDO.getPri());
		medSrvDO.setFg_ctm(materialNamesDO.getFg_ctm());
		medSrvDO.setFg_or(materialNamesDO.getFg_or());
		medSrvDO.setFg_mm(materialNamesDO.getFg_mm());
		medSrvDO.setFg_bl(materialNamesDO.getFg_bl());
		medSrvDO.setEu_blmd(materialNamesDO.getEu_blmd());
		medSrvDO.setFg_set(materialNamesDO.getFg_set());
		medSrvDO.setId_setord(materialNamesDO.getId_setord());
		medSrvDO.setSetord_code(materialNamesDO.getSetord_code());
		medSrvDO.setSetord_name(materialNamesDO.getSetord_name());
		medSrvDO.setSd_setord(materialNamesDO.getSd_setord());
		medSrvDO.setFg_use_er(materialNamesDO.getFg_use_er());
		medSrvDO.setFg_use_er1(materialNamesDO.getFg_use_er1());
		medSrvDO.setFg_use_er2(materialNamesDO.getFg_use_er2());
		medSrvDO.setFg_use_fm(materialNamesDO.getFg_use_fm());
		medSrvDO.setFg_use_op(materialNamesDO.getFg_use_op());
		medSrvDO.setFg_use_pip(materialNamesDO.getFg_use_pip());
		medSrvDO.setFg_use_ip(materialNamesDO.getFg_use_ip());
		medSrvDO.setFg_use_pe(materialNamesDO.getFg_use_pe());
		medSrvDO.setId_mmbind_er(materialNamesDO.getId_mmbind_er());
		medSrvDO.setEr_code(materialNamesDO.getMmbind_er_code());
		medSrvDO.setEr_name(materialNamesDO.getMmbind_er_name());
		medSrvDO.setSd_mmbind_er(materialNamesDO.getSd_mmbind_er());
		medSrvDO.setId_mmbind_fm(materialNamesDO.getId_mmbind_fm());
		medSrvDO.setFm_code(materialNamesDO.getMmbind_fm_code());
		medSrvDO.setFm_name(materialNamesDO.getMmbind_fm_name());
		medSrvDO.setSd_mmbind_fm(materialNamesDO.getSd_mmbind_fm());
		medSrvDO.setId_mmbind_op(materialNamesDO.getId_mmbind_op());
		medSrvDO.setOp_code(materialNamesDO.getMmbind_op_code());
		medSrvDO.setOp_name(materialNamesDO.getMmbind_op_name());
		medSrvDO.setSd_mmbind_op(materialNamesDO.getSd_mmbind_op());
		medSrvDO.setId_mmbind_ip(materialNamesDO.getId_mmbind_ip());
		medSrvDO.setIp_code(materialNamesDO.getMmbind_ip_code());
		medSrvDO.setIp_name(materialNamesDO.getMmbind_ip_name());
		medSrvDO.setSd_mmbind_ip(materialNamesDO.getSd_mmbind_ip());
		medSrvDO.setId_mmbind_pe(materialNamesDO.getId_mmbind_pe());
		medSrvDO.setPe_code(materialNamesDO.getMmbind_pe_code());
		medSrvDO.setPename(materialNamesDO.getMmbind_pe_name());
		medSrvDO.setSd_mmbind_pe(materialNamesDO.getSd_mmbind_pe());
		medSrvDO.setFg_active(materialNamesDO.getFg_active());
		medSrvDO.setDes_pri(materialNamesDO.getDes_pri());
		medSrvDO.setIncca_ip(materialNamesDO.getId_incca_ip());
		medSrvDO.setInccaitmip_name(materialNamesDO.getIncca_ip_name());
		medSrvDO.setIncca_op(materialNamesDO.getId_incca_op());
		medSrvDO.setInccaitmop_name(materialNamesDO.getIncca_op_name());
		medSrvDO.setId_pritp(materialNamesDO.getId_pritp());
		medSrvDO.setCode_pritp(materialNamesDO.getPritp_code());
		medSrvDO.setName_pritp(materialNamesDO.getPritp_name());
		medSrvDO.setSd_pritp(materialNamesDO.getSd_pritp());
		medSrvDO.setCode_rel1(materialNamesDO.getCode_rel1());
		medSrvDO.setCode_rel2(materialNamesDO.getCode_rel2());
		medSrvDO.setCode_rel3(materialNamesDO.getCode_rel3());
		medSrvDO.setCode_rel4(materialNamesDO.getCode_rel4());
		medSrvDO.setCode_rel5(materialNamesDO.getCode_rel5());
		medSrvDO.setCode_rel6(materialNamesDO.getCode_rel6());
		medSrvDO.setDef1(materialNamesDO.getDef1());
		medSrvDO.setDef2(materialNamesDO.getDef2());
		medSrvDO.setDef3(materialNamesDO.getDef3());
		medSrvDO.setDef4(materialNamesDO.getDef4());
		medSrvDO.setDef5(materialNamesDO.getDef5());
		medSrvDO.setDef6(materialNamesDO.getDef6());
		medSrvDO.setDef7(materialNamesDO.getDef7());
		medSrvDO.setDef8(materialNamesDO.getDef8());
		medSrvDO.setDef9(materialNamesDO.getDef9());
		medSrvDO.setDef10(materialNamesDO.getDef10());
		medSrvDO.setFg_nedruglist(materialNamesDO.getFg_nedruglist());

		medSrvDO.setId_acc_gy(materialNamesDO.getId_acc_gy());
		medSrvDO.setId_acc_mz(materialNamesDO.getId_acc_mz());
		medSrvDO.setId_acc_zy(materialNamesDO.getId_acc_zy());
		medSrvDO.setId_account_gy(materialNamesDO.getId_account_gy());
		medSrvDO.setId_account_mz(materialNamesDO.getId_account_mz());
		medSrvDO.setId_account_zy(materialNamesDO.getId_account_zy());
		medSrvDO.setCode_gy_accsub(materialNamesDO.getCode_gy_accsub());
		medSrvDO.setCode_mz_accsub(materialNamesDO.getCode_mz_accsub());
		medSrvDO.setCode_zy_accsub(materialNamesDO.getCode_zy_accsub());
		medSrvDO.setName_gy_accsub(materialNamesDO.getName_gy_accsub());
		medSrvDO.setName_mz_accsub(materialNamesDO.getName_mz_accsub());
		medSrvDO.setName_zy_accsub(materialNamesDO.getName_zy_accsub());
		medSrvDO.setFg_binding(materialNamesDO.getFg_binding());
		return medSrvDO;
	}

	/**
	 * 获取药品通用名中药品属性信息
	 * 
	 * @param materialNamesDO
	 * @return
	 */
	public void getMedSrvDrugDO(MedSrvDrugDO medSrvDrugDO, MaterialNamesDO materialNamesDO) {
		medSrvDrugDO.setId_grp(materialNamesDO.getId_grp());
		medSrvDrugDO.setId_org(materialNamesDO.getId_org());
		medSrvDrugDO.setId_srv(materialNamesDO.getId_materialname());

		medSrvDrugDO.setId_dosage(materialNamesDO.getId_dosage());
		medSrvDrugDO.setDs_code(materialNamesDO.getDosage_code());
		medSrvDrugDO.setDs_name(materialNamesDO.getDosage_name());
		medSrvDrugDO.setSd_dosage(materialNamesDO.getSd_dosage());
		medSrvDrugDO.setId_pharm(materialNamesDO.getId_pharm());
		medSrvDrugDO.setName_pharm(materialNamesDO.getPharm_name());
		medSrvDrugDO.setSd_pharm(materialNamesDO.getSd_pharm());
		medSrvDrugDO.setFg_pois(materialNamesDO.getFg_pois());
		medSrvDrugDO.setId_pois(materialNamesDO.getId_pois());
		medSrvDrugDO.setName_pois(materialNamesDO.getPois_name());
		medSrvDrugDO.setSd_pois(materialNamesDO.getSd_pois());
		medSrvDrugDO.setFg_anti(materialNamesDO.getFg_anti());
		medSrvDrugDO.setId_anti(materialNamesDO.getId_anti());
		medSrvDrugDO.setName_anti(materialNamesDO.getAnti_name());
		medSrvDrugDO.setSd_anti(materialNamesDO.getSd_anti());
		medSrvDrugDO.setIndica(materialNamesDO.getIndica());
		medSrvDrugDO.setConstr(materialNamesDO.getConstr());
		medSrvDrugDO.setUsage(materialNamesDO.getUsage());
		medSrvDrugDO.setReact(materialNamesDO.getReact());
		medSrvDrugDO.setPrecaut(materialNamesDO.getPrecaut());
		medSrvDrugDO.setInteract(materialNamesDO.getInteract());

		medSrvDrugDO.setId_mmtp(materialNamesDO.getId_mmtp());
		medSrvDrugDO.setSd_mmtp(materialNamesDO.getSd_mmtp());
		medSrvDrugDO.setName_mmtp(materialNamesDO.getMmtp_name());
		medSrvDrugDO.setFg_highrisk(materialNamesDO.getFg_highrisk());
		medSrvDrugDO.setId_antdrugca(materialNamesDO.getId_antdrugca());
		medSrvDrugDO.setSd_antdrugca(materialNamesDO.getSd_antdrugca());
		medSrvDrugDO.setName_antdrugca(materialNamesDO.getName_antdrugca());

		if (medSrvDrugDO.getStatus() == DOStatus.UNCHANGED) {
			medSrvDrugDO.setStatus(materialNamesDO.getStatus());
		}
	}

	/**
	 * 医疗服务适配
	 * 
	 * @param medSrvDO
	 * @return
	 */
	private MaterialNamesDO getMaterialNamesDO(MedSrvDO medSrvDO) {
		MaterialNamesDO materialNamesDO = new MaterialNamesDO();

		setDOCommonProp(materialNamesDO, medSrvDO);

		materialNamesDO.setId_materialname(medSrvDO.getId_srv());
		materialNamesDO.setId_grp(medSrvDO.getId_grp());
		materialNamesDO.setId_org(medSrvDO.getId_org());
		materialNamesDO.setCode(medSrvDO.getCode());
		materialNamesDO.setName(medSrvDO.getName());
		materialNamesDO.setId_srvtp(medSrvDO.getId_srvtp());
		materialNamesDO.setSrvtp_code(medSrvDO.getSrvtp_code());
		materialNamesDO.setSrvtp_name(medSrvDO.getSrvtp_name());
		materialNamesDO.setSd_srvtp(medSrvDO.getSd_srvtp());
		materialNamesDO.setId_srvca(medSrvDO.getId_srvca());
		materialNamesDO.setSrvca_code(medSrvDO.getSrvca_code());
		materialNamesDO.setSrvca_name(medSrvDO.getSrvca_name());
		materialNamesDO.setSrvca_innercode(medSrvDO.getSrvca_innercode());
		materialNamesDO.setPycode(medSrvDO.getPycode());
		materialNamesDO.setWbcode(medSrvDO.getWbcode());
		materialNamesDO.setMnecode(medSrvDO.getMnecode());
		materialNamesDO.setShortname(medSrvDO.getShortname());
		materialNamesDO.setDes(medSrvDO.getDes());
		materialNamesDO.setQuan_dosage(medSrvDO.getQuan_med());
		materialNamesDO.setId_unit_med(medSrvDO.getId_unit_med());
		materialNamesDO.setUnit_med_code(medSrvDO.getMed_code());
		materialNamesDO.setUnit_med_name(medSrvDO.getMed_name());
		materialNamesDO.setId_freq(medSrvDO.getId_freq());
		materialNamesDO.setFreq_code(medSrvDO.getFreq_code());
		materialNamesDO.setFreq_name(medSrvDO.getFreq_name());
		materialNamesDO.setFreq_sd_frequnitct(medSrvDO.getSd_frequnitct());
		materialNamesDO.setFreq_frequnitct(medSrvDO.getFrequnitct());
		materialNamesDO.setFreq_freqct(medSrvDO.getFreqct());
		materialNamesDO.setFreq_fg_prnor(medSrvDO.getFg_prnor());
		materialNamesDO.setFreq_fg_long(medSrvDO.getFg_long());
		materialNamesDO.setId_route(medSrvDO.getId_route());
		materialNamesDO.setRoute_code(medSrvDO.getRoute_code());
		materialNamesDO.setRoute_name(medSrvDO.getRoute_name());
		materialNamesDO.setRoute_mnecode(medSrvDO.getRoute_mnecode());
		materialNamesDO.setId_routedes(medSrvDO.getId_routedes());
		materialNamesDO.setRoutedes_code(medSrvDO.getRoutedes_code());
		materialNamesDO.setRoutedes_name(medSrvDO.getRoutedes_name());
		materialNamesDO.setId_boil(medSrvDO.getId_boil());
		materialNamesDO.setBoil_code(medSrvDO.getBoil_code());
		materialNamesDO.setBoil_name(medSrvDO.getBoil_name());
		materialNamesDO.setBoil_mnecode(medSrvDO.getBoil_mnecode());
		materialNamesDO.setId_boildes(medSrvDO.getId_boildes());
		materialNamesDO.setBoildes_code(medSrvDO.getBoildes_code());
		materialNamesDO.setBoildes_name(medSrvDO.getBoildes_name());
		materialNamesDO.setBoildes_mnecode(medSrvDO.getBoildes_mnecode());
		materialNamesDO.setId_primd(medSrvDO.getId_primd());
		materialNamesDO.setPrimd_code(medSrvDO.getPrimd_code());
		materialNamesDO.setPrimd_name(medSrvDO.getPrimd_name());
		materialNamesDO.setSd_primd(medSrvDO.getSd_primd());
		materialNamesDO.setPri(medSrvDO.getPri());
		materialNamesDO.setFg_ctm(medSrvDO.getFg_ctm());
		materialNamesDO.setFg_or(medSrvDO.getFg_or());
		materialNamesDO.setFg_mm(medSrvDO.getFg_mm());
		materialNamesDO.setFg_bl(medSrvDO.getFg_bl());
		materialNamesDO.setEu_blmd(medSrvDO.getEu_blmd());
		materialNamesDO.setFg_set(medSrvDO.getFg_set());
		materialNamesDO.setId_setord(medSrvDO.getId_setord());
		materialNamesDO.setSetord_code(medSrvDO.getSetord_code());
		materialNamesDO.setSetord_name(medSrvDO.getSetord_name());
		materialNamesDO.setSd_setord(medSrvDO.getSd_setord());
		materialNamesDO.setFg_use_er(medSrvDO.getFg_use_er());
		materialNamesDO.setFg_use_er1(medSrvDO.getFg_use_er1());
		materialNamesDO.setFg_use_er2(medSrvDO.getFg_use_er2());
		materialNamesDO.setFg_use_fm(medSrvDO.getFg_use_fm());
		materialNamesDO.setFg_use_op(medSrvDO.getFg_use_op());
		materialNamesDO.setFg_use_pip(medSrvDO.getFg_use_pip());
		materialNamesDO.setFg_use_ip(medSrvDO.getFg_use_ip());
		materialNamesDO.setFg_use_pe(medSrvDO.getFg_use_pe());
		materialNamesDO.setId_mmbind_er(medSrvDO.getId_mmbind_er());
		materialNamesDO.setMmbind_er_code(medSrvDO.getEr_code());
		materialNamesDO.setMmbind_er_name(medSrvDO.getEr_name());
		materialNamesDO.setSd_mmbind_er(medSrvDO.getSd_mmbind_er());
		materialNamesDO.setId_mmbind_fm(medSrvDO.getId_mmbind_fm());
		materialNamesDO.setMmbind_fm_code(medSrvDO.getFm_code());
		materialNamesDO.setMmbind_fm_name(medSrvDO.getFm_name());
		materialNamesDO.setSd_mmbind_fm(medSrvDO.getSd_mmbind_fm());
		materialNamesDO.setId_mmbind_op(medSrvDO.getId_mmbind_op());
		materialNamesDO.setMmbind_op_code(medSrvDO.getOp_code());
		materialNamesDO.setMmbind_op_name(medSrvDO.getOp_name());
		materialNamesDO.setSd_mmbind_op(medSrvDO.getSd_mmbind_op());
		materialNamesDO.setId_mmbind_ip(medSrvDO.getId_mmbind_ip());
		materialNamesDO.setMmbind_ip_code(medSrvDO.getIp_code());
		materialNamesDO.setMmbind_ip_name(medSrvDO.getIp_name());
		materialNamesDO.setSd_mmbind_ip(medSrvDO.getSd_mmbind_ip());
		materialNamesDO.setId_mmbind_pe(medSrvDO.getId_mmbind_pe());
		materialNamesDO.setMmbind_pe_code(medSrvDO.getPe_code());
		materialNamesDO.setMmbind_pe_name(medSrvDO.getPename());
		materialNamesDO.setSd_mmbind_pe(medSrvDO.getSd_mmbind_pe());
		materialNamesDO.setFg_active(medSrvDO.getFg_active());
		materialNamesDO.setDes_pri(medSrvDO.getDes_pri());
		materialNamesDO.setId_incca_ip(medSrvDO.getIncca_ip());
		materialNamesDO.setIncca_ip_name(medSrvDO.getInccaitmip_name());
		materialNamesDO.setId_incca_op(medSrvDO.getIncca_op());
		materialNamesDO.setIncca_op_name(medSrvDO.getInccaitmop_name());
		materialNamesDO.setId_pritp(medSrvDO.getId_pritp());
		materialNamesDO.setPritp_code(medSrvDO.getCode_pritp());
		materialNamesDO.setPritp_name(medSrvDO.getName_pritp());
		materialNamesDO.setSd_pritp(medSrvDO.getSd_pritp());
		materialNamesDO.setCode_rel1(medSrvDO.getCode_rel1());
		materialNamesDO.setCode_rel2(medSrvDO.getCode_rel2());
		materialNamesDO.setCode_rel3(medSrvDO.getCode_rel3());
		materialNamesDO.setCode_rel4(medSrvDO.getCode_rel4());
		materialNamesDO.setCode_rel5(medSrvDO.getCode_rel5());
		materialNamesDO.setCode_rel6(medSrvDO.getCode_rel6());
		materialNamesDO.setDef1(medSrvDO.getDef1());
		materialNamesDO.setDef2(medSrvDO.getDef2());
		materialNamesDO.setDef3(medSrvDO.getDef3());
		materialNamesDO.setDef4(medSrvDO.getDef4());
		materialNamesDO.setDef5(medSrvDO.getDef5());
		materialNamesDO.setDef6(medSrvDO.getDef6());
		materialNamesDO.setDef7(medSrvDO.getDef7());
		materialNamesDO.setDef8(medSrvDO.getDef8());
		materialNamesDO.setDef9(medSrvDO.getDef9());
		materialNamesDO.setDef10(medSrvDO.getDef10());
		materialNamesDO.setFg_nedruglist(medSrvDO.getFg_nedruglist());

		materialNamesDO.setId_acc_gy(medSrvDO.getId_acc_gy());
		materialNamesDO.setId_acc_mz(medSrvDO.getId_acc_mz());
		materialNamesDO.setId_acc_zy(medSrvDO.getId_acc_zy());
		materialNamesDO.setId_account_gy(medSrvDO.getId_account_gy());
		materialNamesDO.setId_account_mz(medSrvDO.getId_account_mz());
		materialNamesDO.setId_account_zy(medSrvDO.getId_account_zy());
		materialNamesDO.setCode_gy_accsub(medSrvDO.getCode_gy_accsub());
		materialNamesDO.setCode_mz_accsub(medSrvDO.getCode_mz_accsub());
		materialNamesDO.setCode_zy_accsub(medSrvDO.getCode_zy_accsub());
		materialNamesDO.setName_gy_accsub(medSrvDO.getName_gy_accsub());
		materialNamesDO.setName_mz_accsub(medSrvDO.getName_mz_accsub());
		materialNamesDO.setName_zy_accsub(medSrvDO.getName_zy_accsub());
		materialNamesDO.setFg_binding(medSrvDO.getFg_binding());
		return materialNamesDO;
	}

	/**
	 * 设置药品属性
	 * 
	 * @param materialNamesDO
	 * @param medSrvDrugDO
	 */
	private void setDrugInfo(MaterialNamesDO materialNamesDO, MedSrvDrugDO medSrvDrugDO) {
		if (medSrvDrugDO == null) {
			return;
		}
		materialNamesDO.setId_dosage(medSrvDrugDO.getId_dosage());
		materialNamesDO.setDosage_code(medSrvDrugDO.getDs_code());
		materialNamesDO.setDosage_name(medSrvDrugDO.getDs_name());
		materialNamesDO.setSd_dosage(medSrvDrugDO.getSd_dosage());
		materialNamesDO.setId_pharm(medSrvDrugDO.getId_pharm());
		materialNamesDO.setPharm_name(medSrvDrugDO.getName_pharm());
		materialNamesDO.setSd_pharm(medSrvDrugDO.getSd_pharm());
		materialNamesDO.setFg_pois(medSrvDrugDO.getFg_pois());
		materialNamesDO.setId_pois(medSrvDrugDO.getId_pois());
		materialNamesDO.setPois_name(medSrvDrugDO.getName_pois());
		materialNamesDO.setSd_pois(medSrvDrugDO.getSd_pois());
		materialNamesDO.setFg_anti(medSrvDrugDO.getFg_anti());
		materialNamesDO.setId_anti(medSrvDrugDO.getId_anti());
		materialNamesDO.setAnti_name(medSrvDrugDO.getName_anti());
		materialNamesDO.setSd_anti(medSrvDrugDO.getSd_anti());
		materialNamesDO.setIndica(medSrvDrugDO.getIndica());
		materialNamesDO.setConstr(medSrvDrugDO.getConstr());
		materialNamesDO.setUsage(medSrvDrugDO.getUsage());
		materialNamesDO.setReact(medSrvDrugDO.getReact());
		materialNamesDO.setPrecaut(medSrvDrugDO.getPrecaut());
		materialNamesDO.setInteract(medSrvDrugDO.getInteract());
		materialNamesDO.setId_mmtp(medSrvDrugDO.getId_mmtp());
		materialNamesDO.setSd_mmtp(medSrvDrugDO.getSd_mmtp());
		materialNamesDO.setMmtp_name(medSrvDrugDO.getName_mmtp());
		materialNamesDO.setFg_highrisk(medSrvDrugDO.getFg_highrisk());
		materialNamesDO.setId_antdrugca(medSrvDrugDO.getId_antdrugca());
		materialNamesDO.setSd_antdrugca(medSrvDrugDO.getSd_antdrugca());
		materialNamesDO.setName_antdrugca(medSrvDrugDO.getName_antdrugca());
	}

}
