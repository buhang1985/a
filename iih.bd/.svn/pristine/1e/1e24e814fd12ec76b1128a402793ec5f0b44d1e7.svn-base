package iih.bd.bc.cdsys.s.rule;

import java.util.ArrayList;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.cdsys.d.MedCdSystemDO;
import iih.bd.bc.udi.pub.IBdBcDictCodeConst;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.utils.BdEnvContextUtil;
import iih.bd.utils.BdSrvParamUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.ICompareRule;
import xap.sys.bdfw.cenum.d.ActiveStateEnum;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 诊断医疗体系停用后规则
 * 
 * @author hao_wu 2019-6-3
 *
 */
public class DiCdSysAfterDisableRule implements ICompareRule<MedCdSystemDO> {

	@Override
	public void process(MedCdSystemDO[] newCdSysDos, MedCdSystemDO[] oldCdSysDos) throws BizException {
		if (ArrayUtils.isEmpty(newCdSysDos)) {
			return;
		}

		MedCdSystemDO[] disableDiCdSyss = getDisabledDiCdSyss(newCdSysDos, oldCdSysDos);
		if (ArrayUtils.isEmpty(disableDiCdSyss)) {
			return;
		}
		disableDiDefByCdSys(disableDiCdSyss);
	}

	/**
	 * 根据诊断标准停用诊断定义
	 * 
	 * @param disableDiCdSyss
	 * @throws BizException
	 */
	private void disableDiDefByCdSys(MedCdSystemDO[] disableDiCdSyss) throws BizException {
		FBoolean isDiAndStdStopTogether = BdSrvParamUtils.getIsDiAndStdStopTogether();
		if (FBoolean.FALSE.equals(isDiAndStdStopTogether)) {
			return;
		}

		String[] cdSysIds = getCdSysIds(disableDiCdSyss);

		String sql = String.format("update bd_di_def set fg_active = 'N' where %s and %s",
				BdEnvContextUtil.processEnvContext(new DiagDefDO(), false),
				SqlUtils.getInSqlByIds(DiagDefDO.ID_CDSYS, cdSysIds));

		DAFacade daFacade = new DAFacade();
		daFacade.execUpdate(sql);
	}

	/**
	 * 获取诊断标准主键集合
	 * 
	 * @param disableDiCdSyss
	 * @return
	 */
	private String[] getCdSysIds(MedCdSystemDO[] disableDiCdSyss) {
		String[] cdSysIds = new String[disableDiCdSyss.length];

		for (int i = 0; i < disableDiCdSyss.length; i++) {
			cdSysIds[i] = disableDiCdSyss[i].getId_cdsys();
		}
		return cdSysIds;
	}

	/**
	 * 获取停用的诊断标准集合
	 * 
	 * @param newCdSysDos
	 * @param oldCdSysDos
	 * @return
	 */
	private MedCdSystemDO[] getDisabledDiCdSyss(MedCdSystemDO[] newCdSysDos, MedCdSystemDO[] oldCdSysDos) {
		ArrayList<MedCdSystemDO> cdSysDoList = new ArrayList<MedCdSystemDO>();

		int count = newCdSysDos.length;
		for (int i = 0; i < count; i++) {
			MedCdSystemDO newCdSysDo = newCdSysDos[i];
			MedCdSystemDO oldCdSysDo = oldCdSysDos[i];

			if (StringUtils.isNotBlank(newCdSysDo.getSd_cdsystp())
					&& newCdSysDo.getSd_cdsystp().startsWith(IBdBcDictCodeConst.SD_CDSYSTP_DIAG)
					&& !ActiveStateEnum.ACTIVE.equals(newCdSysDo.getActivestate())
					&& ActiveStateEnum.ACTIVE.equals(oldCdSysDo.getActivestate())) {
				cdSysDoList.add(newCdSysDo);
			}
		}
		return cdSysDoList.toArray(new MedCdSystemDO[0]);
	}
}
