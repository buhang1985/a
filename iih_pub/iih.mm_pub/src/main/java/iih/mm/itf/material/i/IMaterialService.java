package iih.mm.itf.material.i;

import xap.mw.core.data.BizException;
import iih.mm.itf.material.d.MaterialDTO;
import iih.mm.itf.material.d.QueryCondDTO;

public interface IMaterialService {

	/**
	 * 物品查询服务.
	 * @param condition 查询条件
	 * @return 物品列表
	 * @throws BizException
	 */
	public MaterialDTO[] query(QueryCondDTO condition) throws BizException;
	
	/**
	 * 获取物品的皮试医疗服务ID
	 * @param materialId 物品ID
	 * @return String 皮试服务ID
	 */
	public String getMaterialSkinTestServerId(String materialId) throws BizException;
	
}
