package iih.bd.mm.meterial.s.bp;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDOCudService;
import iih.bd.mm.warehouseinfo.s.bp.OpenWarehouseInfoByMaterialIdsBp;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 开放物品业务逻辑
 * 
 * @author hao_wu
 *
 */
public class MaterialOpenBp {

	public MeterialDO[] exec(MeterialDO[] materials) throws BizException {
		if (materials == null || materials.length <= 0) {
			return materials;
		}
		MeterialDO[] result = OpenMaterial(materials);
		OpenWarehouseInfo(result);
		return result;
	}

	/**
	 * 开放物品与仓库关系
	 * 
	 * @param result
	 * @throws BizException
	 */
	private void OpenWarehouseInfo(MeterialDO[] result) throws BizException {
		String[] materialIds = GetMaterialIds(result);
		OpenWarehouseInfoByMaterialIdsBp bp = new OpenWarehouseInfoByMaterialIdsBp();
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
	 * 开放物品
	 * 
	 * @param materials
	 * @return
	 * @throws BizException
	 */
	private MeterialDO[] OpenMaterial(MeterialDO[] materials) throws BizException {
		for (MeterialDO meterialDO : materials) {
			meterialDO.setFg_out(FBoolean.FALSE);
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
