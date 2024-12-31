package iih.bd.mm.meterial.s.rule.bp;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.bc.param.IBdPpParamValueConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import iih.bd.pp.hpsrvorca.i.IHpsrvorcaRService;
import iih.bd.utils.BdPpParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 药品属性变更检查业务逻辑
 * 
 * @author hao_wu
 *
 */
public class MaterialPropChangCheckBp {

	public void exec(MeterialDO oldMaterial, MeterialDO newMaterial) throws BizException {
		if (oldMaterial == null || newMaterial == null) {
			return;
		}

		CheckCodeAndName(oldMaterial, newMaterial);
	}

	/**
	 * 检查药品编码和名称
	 * 
	 * @param oldMaterial
	 * @param newMaterial
	 * @throws BizException
	 */
	private void CheckCodeAndName(MeterialDO oldMaterial, MeterialDO newMaterial) throws BizException {
		CheckCode(oldMaterial, newMaterial);
		CheckName(oldMaterial, newMaterial);
		CheckMIName(oldMaterial, newMaterial);
	}

	/**
	 * 检查药品编码
	 * 
	 * @param oldMaterial
	 * @param newMaterial
	 * @param hasReviewedHpComp
	 * @throws BizException
	 */
	private void CheckCode(MeterialDO oldMaterial, MeterialDO newMaterial) throws BizException {
		String oldCode = oldMaterial.getCode();
		String newCode = newMaterial.getCode();
		if ((StringUtils.isEmpty(oldCode) && !StringUtils.isEmpty(newCode))
				|| (!StringUtils.isEmpty(oldCode) && StringUtils.isEmpty(newCode))
				|| (!StringUtils.isEmpty(oldCode) && !StringUtils.isEmpty(newCode) && !oldCode.equals(newCode))) {
			// 名称有变化
			boolean hasReviewedHpComp = HasReviewedHpComp(newMaterial.getId_srv());
			if (hasReviewedHpComp) {
				String msg = String.format("药品\"%s\"存在已审核的医保目录对照信息，不允许修改编码。", oldMaterial.getName());
				throw new BizException(msg);
			}
		}
	}

	/**
	 * 检查药品名称
	 * 
	 * @param oldMaterial
	 * @param newMaterial
	 * @throws BizException
	 */
	private void CheckName(MeterialDO oldMaterial, MeterialDO newMaterial) throws BizException {
		String oldName = oldMaterial.getName();
		String newName = newMaterial.getName();

		String miDrugNameType = BdPpParamUtils.GetMiDrugNameType();
		if (!IBdPpParamValueConst.MI_DRUGNAMETYP_MMNAME.equals(miDrugNameType)) {
			return;
		}

		if ((StringUtils.isEmpty(oldName) && !StringUtils.isEmpty(newName))
				|| (!StringUtils.isEmpty(oldName) && StringUtils.isEmpty(newName))
				|| (!StringUtils.isEmpty(oldName) && !StringUtils.isEmpty(newName) && !oldName.equals(newName))) {
			// 名称有变化
			boolean hasReviewedHpComp = HasReviewedHpComp(newMaterial.getId_srv());
			if (hasReviewedHpComp) {
				String msg = String.format("药品\"%s\"存在已审核的医保目录对照信息，不允许修改名称。", oldMaterial.getName());
				throw new BizException(msg);
			}
		}
	}

	/**
	 * 检查医保名称
	 * 
	 * @param oldMaterial
	 * @param newMaterial
	 * @throws BizException
	 */
	private void CheckMIName(MeterialDO oldMaterial, MeterialDO newMaterial) throws BizException {
		String oldName = oldMaterial.getHiname();
		String newName = newMaterial.getHiname();

		String miDrugNameType = BdPpParamUtils.GetMiDrugNameType();
		if (!IBdPpParamValueConst.MI_DRUGNAMETYP_MINAME.equals(miDrugNameType)) {
			return;
		}

		if ((StringUtils.isEmpty(oldName) && !StringUtils.isEmpty(newName))
				|| (!StringUtils.isEmpty(oldName) && StringUtils.isEmpty(newName))
				|| (!StringUtils.isEmpty(oldName) && !StringUtils.isEmpty(newName) && !oldName.equals(newName))) {
			// 医保名称有变化
			boolean hasReviewedHpComp = HasReviewedHpComp(newMaterial.getId_mm());
			if (hasReviewedHpComp) {
				String msg = String.format("药品\"%s\"存在已审核的医保目录对照信息，不允许修改医保名称。", oldMaterial.getName());
				throw new BizException(msg);
			}
		}
	}

	/**
	 * 存在已审批的医保目录对照
	 * 
	 * @param id_mm
	 * @return
	 * @throws BizException
	 */
	private boolean HasReviewedHpComp(String id_mm) throws BizException {
		HPSrvorcaDO[] result = GetAuditedHpSrvByIdSrv(id_mm);
		return result != null && result.length > 0;
	}

	/**
	 * 使用服务id获取已审核医保目录对照数据
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private HPSrvorcaDO[] GetAuditedHpSrvByIdSrv(String id_mm) throws BizException {
		IHpsrvorcaRService hpsrvorcaRService = ServiceFinder.find(IHpsrvorcaRService.class);
		FDateTime srvFateTime = AppUtils.getServerDateTime();
		String whereStr = String.format(
				"eu_status = '%s' and id_mm = '%s' and dt_b is not null and dt_b <= '%s' and dt_e is not null and dt_e > '%s'",
				HpStatusEnum.REVIEW, id_mm, srvFateTime, srvFateTime);
		HPSrvorcaDO[] result = hpsrvorcaRService.find(whereStr, "", FBoolean.FALSE);
		return result;
	}

}
