package iih.bd.srv.medsrv.s.rule.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗服务属性变更检查业务逻辑
 * 
 * @author hao_wu
 *
 */
public class MedSrvPropChangCheckBp {

	public void exec(MedSrvDO oldMedSrv, MedSrvDO newMedSrv) throws BizException {
		if (oldMedSrv == null || newMedSrv == null) {
			return;
		}

		if (oldMedSrv != null && !StringUtils.isEmpty(oldMedSrv.getSd_srvtp()) && newMedSrv != null
				&& !StringUtils.isEmpty(newMedSrv.getSd_srvtp())
				&& newMedSrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)
				&& oldMedSrv.getSd_srvtp().equals(newMedSrv.getSd_srvtp())) {
			// 排除药品通用名
			return;
		}

		CheckCodeAndName(oldMedSrv, newMedSrv);
	}

	/**
	 * 检查医疗服务编码和名称
	 * 
	 * @param oldMedSrv
	 * @param newMedSrv
	 * @throws BizException
	 */
	private void CheckCodeAndName(MedSrvDO oldMedSrv, MedSrvDO newMedSrv) throws BizException {
		boolean hasReviewedHpComp = HasReviewedHpComp(newMedSrv.getId_srv());
		CheckCode(oldMedSrv, newMedSrv, hasReviewedHpComp);
		CheckName(oldMedSrv, newMedSrv, hasReviewedHpComp);
	}

	/**
	 * 检查医疗服务编码
	 * 
	 * @param oldMedSrv
	 * @param newMedSrv
	 * @param hasReviewedHpComp
	 * @throws BizException
	 */
	private void CheckCode(MedSrvDO oldMedSrv, MedSrvDO newMedSrv, boolean hasReviewedHpComp) throws BizException {
		String oldCode = oldMedSrv.getCode();
		String newCode = newMedSrv.getCode();
		if ((StringUtils.isEmpty(oldCode) && !StringUtils.isEmpty(newCode))
				|| (!StringUtils.isEmpty(oldCode) && StringUtils.isEmpty(newCode))
				|| (!StringUtils.isEmpty(oldCode) && !StringUtils.isEmpty(newCode) && !oldCode.equals(newCode))) {
			// 名称有变化
			if (!hasReviewedHpComp) {
				String msg = String.format("医疗服务\"%s\"存在已审核的医保目录对照信息，不允许修改编码。", oldMedSrv.getName());
				throw new BizException(msg);
			}
		}
	}

	/**
	 * 检查医疗服务名称
	 * 
	 * @param oldMedSrv
	 * @param newMedSrv
	 * @throws BizException
	 */
	private void CheckName(MedSrvDO oldMedSrv, MedSrvDO newMedSrv, boolean hasReviewedHpComp) throws BizException {
		String oldName = oldMedSrv.getName();
		String newName = newMedSrv.getName();
		if ((StringUtils.isEmpty(oldName) && !StringUtils.isEmpty(newName))
				|| (!StringUtils.isEmpty(oldName) && StringUtils.isEmpty(newName))
				|| (!StringUtils.isEmpty(oldName) && !StringUtils.isEmpty(newName) && !oldName.equals(newName))) {
			// 名称有变化
			if (!hasReviewedHpComp) {
				String msg = String.format("医疗服务\"%s\"存在已审核的医保目录对照信息，不允许修改名称。", oldMedSrv.getName());
				throw new BizException(msg);
			}
		}
	}

	/**
	 * 存在已审批的医保目录对照
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private boolean HasReviewedHpComp(String id_srv) throws BizException {
		HPSrvorcaDO[] result = GetAuditedHpSrvByIdSrv(id_srv);
		return result == null || result.length <= 0;
	}

	/**
	 * 使用服务id获取已审核医保目录对照数据
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private HPSrvorcaDO[] GetAuditedHpSrvByIdSrv(String id_srv) throws BizException {
		IHpsrvorcaRService hpsrvorcaRService = ServiceFinder.find(IHpsrvorcaRService.class);
		FDateTime srvFateTime = AppUtils.getServerDateTime();
		String whereStr = String.format(
				"eu_status = '%s' and id_srv = '%s' and dt_b is not null and dt_b <= '%s' and dt_e is not null and dt_e > '%s'",
				HpStatusEnum.REVIEW, id_srv, srvFateTime, srvFateTime);
		HPSrvorcaDO[] result = hpsrvorcaRService.find(whereStr, "", FBoolean.FALSE);
		return result;
	}

}
