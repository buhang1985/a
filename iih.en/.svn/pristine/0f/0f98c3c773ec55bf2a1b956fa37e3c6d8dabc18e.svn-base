package iih.en.pv.s.bp.ip;

import iih.bd.bc.udi.pub.IPiDictCodeConst;
import iih.en.comm.ep.EntContEP;
import iih.en.comm.ep.NbEP;
import iih.en.comm.ep.PatEP;
import iih.en.comm.ep.PvEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.pativisit.d.EntContDO;
import iih.en.pv.pativisit.d.EuEntContTp;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.d.PiPatContDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/**
 * 同步婴儿信息
 * 
 * @author zhengcm
 *
 */
public class SyncBabyInfoBP {

	/**
	 * 同步婴儿信息 1、更新婴儿就诊联系人 2、更新婴儿患者联系人
	 * 
	 * @param momEntId 母亲就诊ID
	 * @throws BizException
	 * @author zhengcm
	 */
	public void exec(String momEntId) throws BizException {
		if (EnValidator.isEmpty(momEntId)) {
			return;
		}

		// 1、查询母亲的所有孩子
		NewbornDO[] allBabys = new NbEP().getNbListByMomEnt(momEntId);

		if (EnValidator.isEmpty(allBabys)) {
			return;
		}

		// 2、查询母亲的就诊信息
		PatiVisitDO momEntDO = new PvEP().getPvById(momEntId);

		// 3、查询母亲的患者信息
		PatDO momPatDO = new PatEP().getPatById(momEntDO.getId_pat());

		// 4、同步所有孩子的就诊联系人
		this.syncBabyEntCont(allBabys, momEntDO, momPatDO);
	}

	/**
	 * 查询所有孩子的直接联系人（母亲）
	 *
	 * @param allBabys 所有孩子DO
	 * @return key：孩子就诊ID val：直接联系人(母亲)DO
	 * @throws BizException
	 * @author zhengcm
	 */
	private Map<String, EntContDO> getAllBabyMomCont(NewbornDO[] allBabys) throws BizException {
		if (EnValidator.isEmpty(allBabys)) {
			return null;
		}
		Map<String, EntContDO> map = new HashMap<String, EntContDO>();
		List<String> entIds = new ArrayList<String>();
		for (NewbornDO nbDO : allBabys) {
			entIds.add(nbDO.getId_ent_bb());
		}
		EntContEP ep = new EntContEP();
		EntContDO[] entContDOs = ep.getBabyMomEntContByEntIds(entIds.toArray(new String[] {}));
		if (!EnValidator.isEmpty(entContDOs)) {
			for (EntContDO contDO : entContDOs) {
				map.put(contDO.getId_ent(), contDO);
			}
		}
		return map;
	}

	/**
	 * 根据母亲就诊信息同步所有孩子的就诊联系人
	 *
	 * @param allBabys 所有孩子DO
	 * @param momEntDO 母亲就诊DO
	 * @param momPatDO 母亲患者DO
	 * @throws BizException
	 * @author zhengcm
	 */
	private void syncBabyEntCont(NewbornDO[] allBabys, PatiVisitDO momEntDO, PatDO momPatDO)
			throws BizException {
		if (EnValidator.isEmpty(allBabys) || null == momEntDO || null == momPatDO) {
			return;
		}
		List<EntContDO> newAllBabyEntContList = new ArrayList<EntContDO>();
		PiPatContDO patContDO = null;
		// 所有孩子的直接联系人
		Map<String, EntContDO> map = this.getAllBabyMomCont(allBabys);
		// 将母亲作为孩子的联系人
		for (NewbornDO baby : allBabys) {
			EntContDO cdo = new EntContDO();
			cdo.setStatus(DOStatus.NEW);
			cdo.setId_patcontid(null);
			if (null != map && map.containsKey(baby.getId_ent_bb())) {
				cdo.setStatus(DOStatus.UPDATED);
				cdo.setId_patcontid(map.get(baby.getId_ent_bb()).getId_patcontid());
			}
			cdo.setId_ent(baby.getId_ent_bb());
			cdo.setSortno(new EntContEP().getSortNo(baby.getId_ent_bb()) + 1);
			cdo.setEu_entconttp(EuEntContTp.MOTHER.intValue());
			cdo.setSd_conttp(IPiDictCodeConst.SD_CONT_TYPE_PARENT);
			cdo.setId_conttp(IPiDictCodeConst.ID_CONT_TYPE_PARENT);
			cdo.setName(momEntDO.getName_pat());
			cdo.setConttel(momEntDO.getTelno_pat());
			cdo.setContaddr(momEntDO.getAddr_pat());
			// 拼音
			if (!EnValidator.isEmpty(cdo.getName())) {
				cdo.setPycode(EnAppUtils.getPyCode(cdo.getName()));
				// 助记码
				cdo.setMnecode(cdo.getPycode());
			}
			// 五笔
			if (!EnValidator.isEmpty(cdo.getName())) {
				cdo.setWbcode(EnAppUtils.getWbCode(cdo.getName()));
			}
			if (EnValidator.isEmpty(cdo.getId_patcontid())) {
				patContDO = this.processPatContDO(baby.getId_pat_bb(), momEntDO, momPatDO,
						DOStatus.NEW);
			} else {
				patContDO = this.processPatContDO(cdo.getId_patcontid(), momEntDO, momPatDO,
						DOStatus.UPDATED);
			}
			cdo.setId_patcontid(patContDO.getId_patcont());
			newAllBabyEntContList.add(cdo);
		}
		new EntContEP().saveEntContByStatus(newAllBabyEntContList);
	}

	/**
	 * 处理孩子的患者联系人
	 *
	 * @param id 孩子的患者ID或孩子患者联系人ID
	 * @param momEntDO 母亲的就诊信息DO
	 * @param momPatDO 母亲的患者信息DO
	 * @param status DO状态
	 * @return 孩子的患者联系人DO
	 * @throws BizException
	 * @author zhengcm
	 */
	private PiPatContDO processPatContDO(String id, PatiVisitDO momEntDO, PatDO momPatDO, int status)
			throws BizException {
		PiPatContDO patContDO = null;
		if (status == DOStatus.NEW) {
			patContDO = new PiPatContDO();
			patContDO.setStatus(DOStatus.NEW);
			patContDO.setId_pat(id);
		} else if (status == DOStatus.UPDATED) {
			patContDO = new PatEP().getPatContById(id);
			patContDO.setStatus(DOStatus.UPDATED);
		}
		patContDO.setName(momEntDO.getName_pat());
		patContDO.setId_conttp(IPiDictCodeConst.ID_CONT_TYPE_PARENT);
		patContDO.setSd_conttp(IPiDictCodeConst.SD_CONT_TYPE_PARENT);
		patContDO.setId_fmrole(IPiDictCodeConst.ID_PARENT_MOTHER);
		patContDO.setSd_fmrole(IPiDictCodeConst.SD_PARENT_MOTHER);
		patContDO.setConttel(momEntDO.getTelno_pat());
		patContDO.setContaddr(momEntDO.getAddr_pat());
		patContDO.setContid(momPatDO.getId_code());
		patContDO = new PatEP().savePatCont(patContDO);
		return patContDO;
	}

}
