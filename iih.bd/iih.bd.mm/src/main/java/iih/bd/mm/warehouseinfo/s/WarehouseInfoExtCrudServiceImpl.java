package iih.bd.mm.warehouseinfo.s;

import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import iih.bd.mm.warehouseinfo.i.IWarehouseInfoExtCudService;
import iih.bd.mm.warehouseinfo.i.IWarehouseInfoExtRService;
import iih.bd.mm.warehouseinfo.s.bp.CloseWarehouseInfoBp;
import iih.bd.mm.warehouseinfo.s.bp.CloseWarehouseInfoByMaterialIdsBp;
import iih.bd.mm.warehouseinfo.s.bp.FindPagingDataByQCondBp;
import iih.bd.mm.warehouseinfo.s.bp.OpenWarehouseInfoBp;
import iih.bd.mm.warehouseinfo.s.bp.OpenWarehouseInfoByMaterialIdsBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 物品与仓库关系扩展服务
 * 
 * @author hao_wu
 *
 */
public class WarehouseInfoExtCrudServiceImpl implements IWarehouseInfoExtRService, IWarehouseInfoExtCudService {

	@Override
	public WarehouseInfoDO[] Open(WarehouseInfoDO[] warehouseInfos) throws BizException {
		OpenWarehouseInfoBp bp = new OpenWarehouseInfoBp();
		WarehouseInfoDO[] result = bp.exec(warehouseInfos);
		return result;
	}

	@Override
	public WarehouseInfoDO[] Close(WarehouseInfoDO[] warehouseInfos) throws BizException {
		CloseWarehouseInfoBp bp = new CloseWarehouseInfoBp();
		WarehouseInfoDO[] result = bp.exec(warehouseInfos);
		return result;
	}

	@Override
	public void OpenByMaterialIds(String[] materialIds) throws BizException {
		OpenWarehouseInfoByMaterialIdsBp bp = new OpenWarehouseInfoByMaterialIdsBp();
		bp.exec(materialIds);
	}

	@Override
	public void CloseByMaterialIds(String[] materialIds) throws BizException {
		CloseWarehouseInfoByMaterialIdsBp bp = new CloseWarehouseInfoByMaterialIdsBp();
		bp.exec(materialIds);
	}

	@Override
	public PagingRtnData<WarehouseInfoDO> findPagingDataByQCond(PaginationInfo pgInfo, QryRootNodeDTO qryRootNodeDto,
			String wherePart, String orderPart) throws BizException {
		FindPagingDataByQCondBp bp = new FindPagingDataByQCondBp();
		PagingRtnData<WarehouseInfoDO> result = bp.exec(pgInfo, qryRootNodeDto, wherePart, orderPart);
		return result;
	}
}
