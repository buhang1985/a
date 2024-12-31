package iih.en.pv.s.bp;

import iih.en.comm.ep.EnQueEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.SysPatDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitCudService;
import iih.en.que.enqueue.d.EnQueueDO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 同步就诊的患者信息
 * 
 * @author renying
 *
 */
public class SyncEnPatInfoBP {
	/**
	 * 同步就诊的患者信息
	 * 
	 * @param sysPatDTO
	 *            患者dto
	 * @throws BizException
	 */
	public void exec(SysPatDTO sysPatDTO) throws BizException {
		validateDTO(sysPatDTO);
		List<PatiVisitDO> list = this.getPatiVisitDOs(sysPatDTO.getId_pat());
		if (EnValidator.isEmpty(list))
			return;
		this.updateMob(list, sysPatDTO);
		this.updateInfo(list, sysPatDTO);
		this.updateList(list);
		this.updateEntQue(list, sysPatDTO);
	}

	private void updateList(List<PatiVisitDO> list) throws BizException {
		IPativisitCudService cudService = ServiceFinder
				.find(IPativisitCudService.class);
		@SuppressWarnings("unused")
		PatiVisitDO[] pats = cudService.update(list
				.toArray(new PatiVisitDO[] {}));
	}

	/**
	 * 更新除手机号意外的信息
	 * 
	 * @param list
	 * @param sysPatDTO
	 */
	private void updateInfo(List<PatiVisitDO> list, SysPatDTO sysPatDTO) {
		for (PatiVisitDO patvisitDO : list) {
			patvisitDO.setId_admdiv_addr(sysPatDTO.getId_admin_addr());
			patvisitDO.setSd_admdiv_addr(sysPatDTO.getSd_admin_addr());
			patvisitDO.setAddr_pat(sysPatDTO.getAddr());

			patvisitDO.setId_mari_pat(sysPatDTO.getId_marry());
			patvisitDO.setSd_mari_pat(sysPatDTO.getSd_marry());

			patvisitDO.setId_sex_pat(sysPatDTO.getId_sex());
			patvisitDO.setSd_sex_pat(sysPatDTO.getSd_sex());

			patvisitDO.setDt_birth_pat(sysPatDTO.getDt_birth_pat());
			patvisitDO.setName_pat(sysPatDTO.getName_pat());
		}
	}

	/**
	 * 更新电话信息
	 * 
	 * @param list
	 * @param sysPatDTO
	 */
	private void updateMob(List<PatiVisitDO> list, SysPatDTO sysPatDTO) {
		if (!EnValidator.isEmpty(sysPatDTO.getMob())) {

			for (PatiVisitDO patvisitDO : list) {
				patvisitDO.setTelno_pat(sysPatDTO.getMob());
			}
		} else {
			if (!EnValidator.isEmpty(sysPatDTO.getTel())) {
				for (PatiVisitDO patvisitDO : list) {
					patvisitDO.setTelno_pat(sysPatDTO.getTel());
				}
			}
		}
	}

	/**
	 * 查找patvisitDO
	 * 
	 * modify liubin 2018-08-25
	 * modify liubin 2020-04-10 fg_st = 'N'
	 * 
	 * @param patId
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<PatiVisitDO> getPatiVisitDOs(String patId) throws BizException {
		List<PatiVisitDO> list = new ArrayList<PatiVisitDO>();
		// 查找住院患者信息，fg_st = 'N'
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT EN.* FROM EN_ENT EN ");
		sqlBuilder.append(" INNER JOIN EN_ENT_IP IP ON EN.ID_ENT = IP.ID_ENT ");
		sqlBuilder.append(" WHERE EN.ID_PAT = ? ");
		sqlBuilder.append(" AND EN.FG_CANC = ? ");
		sqlBuilder.append(" AND EN.FG_ST = ? ");
		SqlParam param = new SqlParam();
		param.addParam(patId);
		param.addParam(FBoolean.FALSE);
		param.addParam(FBoolean.FALSE);
		List<PatiVisitDO> ipList = (List<PatiVisitDO>) new DAFacade()
				.execQuery(sqlBuilder.toString(), param, new BeanListHandler(
						PatiVisitDO.class));
		if (!EnValidator.isEmpty(ipList))
			list.addAll(ipList);

		// 查找门诊患者信息，有效期内的门诊病人. [en_ent_op. dt_valid_e> sysdate()]
		sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT EN.* FROM EN_ENT EN ");
		sqlBuilder.append(" INNER JOIN EN_ENT_OP OP ON EN.ID_ENT = OP.ID_ENT ");
		sqlBuilder.append(" WHERE EN.ID_PAT = ? ");
		sqlBuilder.append(" AND OP.DT_VALID_E > ? ");
		param.clearParams();
		param.addParam(patId);
		param.addParam(EnAppUtils.getServerDateTime());
		List<PatiVisitDO> opList = (List<PatiVisitDO>) new DAFacade()
				.execQuery(sqlBuilder.toString(), param, new BeanListHandler(
						PatiVisitDO.class));
		if (!EnValidator.isEmpty(opList))
			list.addAll(opList);
		return list;
	}

	/**
	 * 校验参数
	 * 
	 * @param sysPatDTO
	 * @throws BizException
	 */
	private void validateDTO(SysPatDTO sysPatDTO) throws BizException {
		EnValidator.validateParam("sysPatDTO", sysPatDTO);
		EnValidator.validateParam("sysPatDTO.id_pat", sysPatDTO.getId_pat());
	}

	/**
	 * 更新队列信息
	 * 
	 * @param list
	 * @param name_pat
	 * @throws BizException
	 */
	private void updateEntQue(List<PatiVisitDO> list, SysPatDTO sysPatDTO)
			throws BizException {
		if (sysPatDTO == null || EnValidator.isEmpty(sysPatDTO.getName_pat()))
			return;
		List<String> idlist = new ArrayList<String>();
		if (EnValidator.isEmpty(list))
			return;
		for (PatiVisitDO endo : list) {
			idlist.add(endo.getId_ent());
		}
		EnQueEP ep = new EnQueEP();
		EnQueueDO[] queDOs = ep.getEnQueueByEntIds(idlist.toArray(new String[0]));
		if (EnValidator.isEmpty(queDOs))
			return;
		for (EnQueueDO ueDO : queDOs) {
			ueDO.setName_pat(sysPatDTO.getName_pat());
			ueDO.setStatus(DOStatus.UPDATED);
		}
		ep.save(queDOs);
	}
}
