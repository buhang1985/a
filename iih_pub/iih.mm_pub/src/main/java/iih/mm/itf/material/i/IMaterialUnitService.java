package iih.mm.itf.material.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

public interface IMaterialUnitService {
	
	/**
	 * 物品包装单位、医学单位或体积单位之间的换算。
	 * @return 单位换算之后的数值
	 * @throws BizException
	 */
	public FDouble unitConversion(String id_mm, String type, String in_unit_id, FDouble in_num, String out_unit_id) throws BizException; 
	
	/**
	 * 获取物品单位（包装单位、医学单位或体积单位）与物品基本包装单位的换算系数。
	 * @param mmId 物品ID
	 * @param unitId 单位ID 
	 * @return
	 * @throws BizException
	 */
	public FDouble getMaterialUnitFactor(String mmId, String unitId) throws BizException;
}
