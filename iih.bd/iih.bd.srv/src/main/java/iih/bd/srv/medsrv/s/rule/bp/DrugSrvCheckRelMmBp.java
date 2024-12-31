package iih.bd.srv.medsrv.s.rule.bp;

import java.util.ArrayList;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 药品服务检查关联物品业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DrugSrvCheckRelMmBp {

	public void exec(MedSrvDO[] medsrvDoArray) throws BizException {

		String[] pks = getPks(medsrvDoArray);
		if (pks == null || pks.length <= 0) {
			return;
		}
		String whereInPart = buildWhereInPart(pks);

		IMeterialMDORService meterialMDORService = ServiceFinder.find(IMeterialMDORService.class);
		String whereStr = String.format("id_srv in (%s) and fg_active = 'Y'", whereInPart);
		MeterialDO[] materialArray = meterialMDORService.find(whereStr, "id_srv", FBoolean.FALSE);
		checkRelMmActiveCount(medsrvDoArray, materialArray);
	}

	/**
	 * 检查关联物品启用条数
	 * 
	 * @param medsrvDoArray
	 * @param materialArray
	 * @throws BizException
	 */
	private void checkRelMmActiveCount(MedSrvDO[] medsrvDoArray, MeterialDO[] materialArray) throws BizException {
		for (MedSrvDO medSrvDO : medsrvDoArray) {
			// 未启用或删除数据数据不检查
			if ((medSrvDO.getStatus() == DOStatus.DELETED)
					|| (medSrvDO.getFg_active() != null && medSrvDO.getFg_active().booleanValue() != true)) {
				continue;
			}
			//非药品服务不检查
			if (medSrvDO.getSd_srvtp() != null
					&& !medSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
				continue;
			}
			// 新增数据不允许直接启用
			if (medSrvDO.getStatus() == DOStatus.NEW && medSrvDO.getFg_active() != null
					&& medSrvDO.getFg_active().booleanValue() == true) {
				String msg = String.format("医疗服务\"%s\"为新数据，不能启用。", medSrvDO.getName());
				throw new BizException(msg);
			}
			// 关联物品不存在启用物品时，不允许启用
			boolean hasActiveMm = hasActiveMm(materialArray, medSrvDO.getId_srv());
			if (!hasActiveMm) {
				String msg = String.format("医疗服务\"%s\"关联物品中不存在已启用的物品，不能启用。", medSrvDO.getName());
				throw new BizException(msg);
			}
		}

	}

	/**
	 * 是否存在启用的物品
	 * 
	 * @param materialArray
	 * @param id_srv
	 * @return
	 */
	private boolean hasActiveMm(MeterialDO[] materialArray, String id_srv) {
		for (MeterialDO meterialDO : materialArray) {
			if (meterialDO != null && meterialDO.getFg_active() != null
					&& meterialDO.getFg_active().booleanValue() == true && meterialDO.getId_srv() != null
					&& meterialDO.getId_srv().equals(id_srv)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获取已启用数据的主键列表
	 * 
	 * @param medsrvDoArray
	 * @return
	 */
	private String[] getPks(MedSrvDO[] medsrvDoArray) {
		ArrayList<String> pks = new ArrayList<String>();
		for (MedSrvDO medSrvDO : medsrvDoArray) {
			if (medSrvDO != null && medSrvDO.getStatus() != DOStatus.NEW && medSrvDO.getStatus() != DOStatus.DELETED
					&& medSrvDO.getSd_srvtp() != null
					&& medSrvDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)
					&& medSrvDO.getFg_active() != null && medSrvDO.getFg_active().booleanValue() == true
					&& medSrvDO.getId_srv() != null) {
				pks.add(medSrvDO.getId_srv());
			}
		}
		return pks.toArray(new String[0]);
	}

	/**
	 * 构建whereIn片段
	 * 
	 * @param pks
	 * @return
	 */
	private String buildWhereInPart(String[] pks) {
		StringBuilder whereInPart = new StringBuilder();
		for (String pk : pks) {
			if (whereInPart.length() == 1) {
				whereInPart.append(",");
			}
			String str = String.format("'%s'", pk);
			whereInPart.append(str);
		}
		return whereInPart.toString();
	}

}
