package iih.bd.mm.meterial.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.mm.meterial.d.MeterialDO;

/**
 * 获取物品主键集合业务逻辑
 * 
 * @author hao_wu
 *
 */
public class GetMaterialIdsBp {

	public String[] exec(MeterialDO[] materialDOs) {
		if (materialDOs == null || materialDOs.length <= 0) {
			return new String[0];
		}

		String[] materialIds = GetMaterialIds(materialDOs);
		return materialIds;
	}

	/**
	 * 获取物品主键集合
	 * 
	 * @param materialDOs
	 * @return
	 */
	private String[] GetMaterialIds(MeterialDO[] materialDOs) {
		ArrayList<String> materialIdList = new ArrayList<String>();
		for (MeterialDO materialDO : materialDOs) {
			String id_mm = materialDO.getId_mm();
			if (materialDO != null && StringUtils.isNotEmpty(id_mm)) {
				materialIdList.add(id_mm);
			}
		}
		return materialIdList.toArray(new String[0]);
	}

}
