package iih.bd.mm.meterial.s.bp;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDOCudService;
import iih.bd.mm.warehouseinfo.s.bp.CloseWarehouseInfoByMaterialIdsBp;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 停开物品业务逻辑
 * 
 * @author hao_wu
 *
 */
public class MaterialCloseBp {

	public MeterialDO[] exec(MeterialDO[] materials) throws BizException {
		if (materials == null || materials.length <= 0) {
			return materials;
		}
		MeterialDO[] result = CloseMaterial(materials);
		CloseWarehouseInfo(result);
		return result;
	}

	/**
	 * 停开物品与仓库关系
	 * 
	 * @param result
	 * @throws BizException
	 */
	private void CloseWarehouseInfo(MeterialDO[] result) throws BizException {
		String[] materialIds = GetMaterialIds(result);
		CloseWarehouseInfoByMaterialIdsBp bp = new CloseWarehouseInfoByMaterialIdsBp();
		bp.exec(materialIds);
	}

	/**
	 * 获取物品主键集合
	 * 
	 * @param materialDOs
	 * @return
	 */
	private String[] GetMaterialIds(MeterialDO[] materialDOs) {
		GetMaterialIdsBp bp = new GetMaterialIdsBp();
		String[] materialIds = bp.exec(materialDOs);
		return materialIds;
	}

	/**
	 * 停开物品
	 * 
	 * @param materials
	 * @return
	 * @throws BizException
	 */
	private MeterialDO[] CloseMaterial(MeterialDO[] materials) throws BizException {
		for (MeterialDO meterialDO : materials) {
			meterialDO.setFg_out(FBoolean.TRUE);
			meterialDO.setStatus(DOStatus.UPDATED);
		}
		MeterialDO[] result = SaveMaterials(materials);
		return result;
	}

	/**
	 * 保存物品信息
	 * 
	 * @param materials
	 * @return
	 * @throws BizException
	 */
	private MeterialDO[] SaveMaterials(MeterialDO[] materials) throws BizException {
		IMeterialMDOCudService meterialMDOCudService = ServiceFinder.find(IMeterialMDOCudService.class);
		MeterialDO[] result = meterialMDOCudService.save(materials);
		return result;
	}
}
