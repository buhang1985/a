package iih.bd.mm.autoreplenishconfigure.i;

import iih.bd.mm.autoreplenishconfigure.d.AutoReplenishConfigureDO;
import iih.bd.mm.autoreplenishdto.d.BatchReplenishDTO;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public interface IAutoreplenishconfigureExtService {

	/**
	 * 根据1.仓库+查询模板或2.仓库+物品基本分类加载数据
	 * @param whId
	 * @param qryNode
	 * @param mmca
	 * @return
	 * @throws BizException
	 */
	public abstract AutoReplenishConfigureDO[] findAutoReplenishConfigures(String whId, QryRootNodeDTO qryNode, MMCategoryDO mmcaDo) throws BizException;

	/**
	 * 根据仓库查询有仓库物品关系的物品
	 * @param whId
	 * @return
	 * @throws BizException
	 */
	public abstract BatchReplenishDTO[] findMmListDto(String whId, QryRootNodeDTO qryNode) throws BizException;
}
