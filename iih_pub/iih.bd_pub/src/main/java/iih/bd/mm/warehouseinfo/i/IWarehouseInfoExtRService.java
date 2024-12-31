package iih.bd.mm.warehouseinfo.i;

import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 物品与仓库关系扩展查询服务
 * 
 * @author hao_wu
 *
 */
public interface IWarehouseInfoExtRService {

	/**
	 * 查询仓库物品关系分页数据</br>
	 * 因排序中涉及参照表字段，索引单独写查询解决排序问题
	 * 
	 * @param pgInfo         分页信息
	 * @param qryRootNodeDto 查询方案
	 * @param wherePart      条件语句
	 * @param orderPart      排序语句
	 * @return 仓库物品关系集合
	 * @throws BizException
	 */
	public abstract PagingRtnData<WarehouseInfoDO> findPagingDataByQCond(PaginationInfo pgInfo, QryRootNodeDTO qryRootNodeDto,
			String wherePart, String orderPart) throws BizException;
}
