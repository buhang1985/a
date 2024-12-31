package iih.bd.mm.meterial.bp;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.s.ds.MaterialCache;
import xap.mw.core.data.BizException;

public class MaterialCuAfterBp {

	public void exec(MeterialAggDO[] mmAggDOS) throws BizException {

		// ■ 参数校验
		this.validaPara(mmAggDOS);

		// ■ 本地缓存信息更新
		this.updateCache(mmAggDOS);

		this.EnableMaterialNames(mmAggDOS);
	}

	/**
	 * 启用药品通用名
	 * 
	 * @param mmAggDOS
	 * @throws BizException 
	 */
	private void EnableMaterialNames(MeterialAggDO[] mmAggDOS) throws BizException {
		EnableMaterialNamesAfterMaterialEnabledBp bp = new EnableMaterialNamesAfterMaterialEnabledBp();
		for (MeterialAggDO meterialAggDO : mmAggDOS) {
			if(meterialAggDO.getParentDO().getSd_mmtp().substring(0,1).equals(IBdMmDictCodeConst.SD_MMTP_WEISHENG) || meterialAggDO.getParentDO().getSd_mmtp().substring(0,1).equals(IBdMmDictCodeConst.SD_MMTP_QIXIE))//耗材的没有通用名，不进行处理
					return;
			MeterialDO meterialDO = meterialAggDO.getParentDO();
			bp.exec(new MeterialDO[] { meterialDO });
		}
	}

	private void validaPara(MeterialAggDO[] mmAggDOS) throws BizException {

		if (mmAggDOS == null || mmAggDOS.length <= 0) {

			throw new BizException("传入物品基本信息为空。");
		}
	}

	private void updateCache(MeterialAggDO[] mmAggDOS) throws BizException {
		
		//更新缓存
		MaterialCache.getInstance().updateMaterialAggInfo(mmAggDOS);
	}
}
