package iih.bd.mm.materialnames.s.bp.queryer;

import iih.bd.mm.materialnames.d.MaterialsDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 药品通用名关联药品列表查询器
 * 
 * @author hao_wu
 *
 */
public class MaterialsDOQueryer {

	/**
	 * 根据医疗服务id查询关联药品列表
	 * 
	 * @param srvId
	 * @return
	 * @throws BizException
	 */
	public static MaterialsDO[] findMaterialsBySrvId(String srvId) throws BizException {
		GetMaterialsQrySql getMaterialsQrySql = new GetMaterialsQrySql(srvId);
		MaterialsDO[] materialsDOs = (MaterialsDO[]) AppFwUtil.getDORstWithDao(getMaterialsQrySql, MaterialsDO.class);
		return materialsDOs;
	}
}
