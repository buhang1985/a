package iih.bd.res.warehouse.s.bp;

import java.util.ArrayList;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.i.IWarehouseRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 仓库所属部门唯一性规则逻辑
 * 
 * @author hao_wu
 *
 */
public class DeptUniqueRuleBp {

	public void exec(WarehouseDO[] warehouseDOs) throws BizException {
		if (warehouseDOs == null || warehouseDOs.length <= 0) {
			return;
		}

		WarehouseDO[] needValidateDatas = getNeedValidateDatas(warehouseDOs);
		if (needValidateDatas == null || needValidateDatas.length <= 0) {
			return;
		}

		deptUniqueRulValidate(needValidateDatas);
	}

	/**
	 * 获取需要校验的数据
	 * 
	 * @param warehouseDOs
	 * @return
	 */
	private WarehouseDO[] getNeedValidateDatas(WarehouseDO[] warehouseDOs) {
		ArrayList<WarehouseDO> dataArray = new ArrayList<WarehouseDO>();
		for (WarehouseDO warehouseDO : warehouseDOs) {
			String whTp = warehouseDO.getSd_whtp();
			if (whTp != null && (whTp.equals(IBdResDictCodeConst.SD_WHTP_YAOKU)
					|| whTp.equals(IBdResDictCodeConst.SD_WHTP_YAOFANG)
					|| whTp.equals(IBdResDictCodeConst.SD_WHTP_JISHU))) {
				dataArray.add(warehouseDO);
			}
		}
		return dataArray.toArray(new WarehouseDO[0]);
	}

	/**
	 * 科室唯一性规则校验
	 * 
	 * @param warehouseDOs
	 * @return
	 * @throws BizException
	 */
	private void deptUniqueRulValidate(WarehouseDO[] warehouseDOs) throws BizException {
		String wherePart = getWherePart(warehouseDOs);
		IWarehouseRService warehouseRService = ServiceFinder.find(IWarehouseRService.class);
		WarehouseDO[] result = warehouseRService.find(wherePart, "", new FBoolean(false));
		if (result != null && result.length > 0) {
			WarehouseDO warehouse = result[0];
			String msg = String.format("仓库类型属于[药库|药房|基数药房]时，所属部门不允许重复，所属部门\"%s\"已存在。", warehouse.getDep_name());
			throw new BizException(msg);
		}
	}

	/**
	 * 获取条件语句
	 * 
	 * @param warehouseDOs
	 * @return
	 */
	private String getWherePart(WarehouseDO[] warehouseDOs) {
		ArrayList<String> deptIdList = new ArrayList<String>();
		ArrayList<String> warehouseIdList = new ArrayList<String>();
		getIdArrray(warehouseDOs, deptIdList, warehouseIdList);

		return getWherePart(warehouseIdList, deptIdList);
	}

	/**
	 * 获取条件语句
	 * 
	 * @param warehouseIdList
	 * @param deptIdList
	 * @return
	 */
	private String getWherePart(ArrayList<String> warehouseIdList, ArrayList<String> deptIdList) {
		StringBuffer wherePart = new StringBuffer("sd_whtp in ('01','02','03')");

		if (warehouseIdList != null && warehouseIdList.size() > 0) {
			wherePart.append(" and id_wh not in (");
			int size = warehouseIdList.size();
			for (int i = 0; i < size; i++) {
				if (i != 0) {
					wherePart.append(", ");
				}
				String str = String.format("'%s'", warehouseIdList.get(i));
				wherePart.append(str);
			}
			wherePart.append(")");
		}

		if (deptIdList != null && deptIdList.size() > 0) {
			wherePart.append(" and Id_dep_belong in (");
			int size = deptIdList.size();
			for (int i = 0; i < size; i++) {
				if (i != 0) {
					wherePart.append(", ");
				}
				String str = String.format("'%s'", deptIdList.get(i));
				wherePart.append(str);
			}
			wherePart.append(")");
		}
		return wherePart.toString();
	}

	/**
	 * 获取Id数组
	 * 
	 * @param warehouseDOs
	 * @param deptIdList
	 * @param warehouseIdList
	 */
	private void getIdArrray(WarehouseDO[] warehouseDOs, ArrayList<String> deptIdList,
			ArrayList<String> warehouseIdList) {
		for (WarehouseDO warehouse : warehouseDOs) {
			String deptId = warehouse.getId_dep_belong();
			String warehouseId = warehouse.getId_wh();
			if (deptId != null && !"".equals(deptId.trim())) {
				deptIdList.add(deptId);
			}
			if (warehouseId != null && !"".equals(warehouseId.trim())) {
				warehouseIdList.add(warehouseId);
			}
		}
	}
}
