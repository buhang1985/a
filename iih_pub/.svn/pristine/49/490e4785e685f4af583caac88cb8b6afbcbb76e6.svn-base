package iih.bd.res.warehouse.i;

import iih.bd.res.warehouse.d.WarehouseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 仓库查询类(数据权限过滤)
 * @author ly 2017/06/16
 *
 */
public interface IWarehouseRWithDataperService {

	/**
	 * 根据condition条件查找仓库数据集合(数据权限)
	 */
	public abstract WarehouseDO[] findByDataper(String whereStr, String orderStr, FBoolean isLazy) throws BizException;
}
