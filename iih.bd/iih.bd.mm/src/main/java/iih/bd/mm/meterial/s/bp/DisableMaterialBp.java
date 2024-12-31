package iih.bd.mm.meterial.s.bp;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDOCudService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 停用物品业务逻辑
 * 
 * @author hao_wu
 *
 */
public class DisableMaterialBp {
	public MeterialDO[] exec(MeterialDO[] materials) throws BizException {
		if (materials == null || materials.length <= 0) {
			return null;
		}

		MeterialDO[] result = EnableMaterial(materials);
		return result;
	}

	/**
	 * 停用物品
	 * 
	 * @param materials
	 * @return
	 * @throws BizException
	 */
	private MeterialDO[] EnableMaterial(MeterialDO[] materials) throws BizException {
		for (MeterialDO meterialDO : materials) {
			meterialDO.setFg_active(FBoolean.FALSE);
			meterialDO.setStatus(DOStatus.UPDATED);
		}

		MeterialDO[] result = SaveMaterial(materials);
		return result;
	}

	/**
	 * 保存物品信息
	 * 
	 * @param materials
	 * @return
	 * @throws BizException
	 */
	private MeterialDO[] SaveMaterial(MeterialDO[] materials) throws BizException {
		IMeterialMDOCudService meterialMDOCudService = ServiceFinder.find(IMeterialMDOCudService.class);
		MeterialDO[] result = meterialMDOCudService.update(materials);
		return result;
	}
}
