package iih.bd.srv.medsrv.s.rule.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDrugDO;
import org.apache.commons.lang.StringUtils;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医疗服务更新药品属性业务逻辑
 * 
 * @author hao_wu
 *
 */
public class MedSrvUpdateDrugDOBp {

	public void exec(MedSrvDrugDO[] medSrvDrugArr) {
		if (medSrvDrugArr == null || medSrvDrugArr.length <= 0) {
			return;
		}
		updateDrugDO(medSrvDrugArr);
	}

	/**
	 * 更新药品属性信息
	 * 
	 * @param medSrvDrugArr
	 */
	private void updateDrugDO(MedSrvDrugDO[] medSrvDrugArr) {
		for (MedSrvDrugDO medSrvDrugDO : medSrvDrugArr) {
			updateDrugDO(medSrvDrugDO);
		}
	}

	/**
	 * 更新药品属性信息
	 * 
	 * @param medSrvDrugDO
	 */
	private void updateDrugDO(MedSrvDrugDO medSrvDrugDO) {
		if (medSrvDrugDO == null) {
			return;
		}
		// 更新毒麻标识
		String sdPois = medSrvDrugDO.getSd_pois();
		if (!StringUtils.isBlank(sdPois)) {
			boolean fgPois = !sdPois.equals(IBdSrvDictCodeConst.SD_POIS_NONTOXIC);
			medSrvDrugDO.setFg_pois(new FBoolean(fgPois));
		}
		// 更新抗菌药标识
		String sdAnti = medSrvDrugDO.getSd_anti();
		if (!StringUtils.isBlank(sdAnti)) {
			boolean fgAnti = !sdAnti.equals(IBdSrvDictCodeConst.SD_ANTI_NONANTIBACTERIAL);
			medSrvDrugDO.setFg_anti(new FBoolean(fgAnti));
		}
	}
}
