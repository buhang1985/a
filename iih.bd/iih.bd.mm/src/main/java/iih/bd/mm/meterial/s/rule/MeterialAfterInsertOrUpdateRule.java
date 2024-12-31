package iih.bd.mm.meterial.s.rule;

import iih.bd.mm.meterial.bp.EnableMaterialNamesAfterMaterialEnabledBp;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.s.ds.MaterialCache;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.IRule;

/**
 * 物品信息插入或更新后规则
 * 
 * @author hao_wu
 *
 */
public class MeterialAfterInsertOrUpdateRule implements IRule<MeterialDO> {

	@Override
	public void process(MeterialDO... mmDOS) throws BizException {

		UpdateCache(mmDOS);
		this.EnableMaterialNames(mmDOS);
	}

	/**
	 * 启用药品通用名
	 * 
	 * @param mmDOS
	 * @throws BizException 
	 */
	private void EnableMaterialNames(MeterialDO[] mmDOS) throws BizException {
		EnableMaterialNamesAfterMaterialEnabledBp bp = new EnableMaterialNamesAfterMaterialEnabledBp();
		bp.exec(mmDOS);
	}

	/**
	 * 更新缓存
	 * 
	 * @param mmDOS
	 * @throws BizException
	 */
	private void UpdateCache(MeterialDO[] mmDOS) throws BizException {
		MaterialCache.getInstance().updateMaterialInfo(mmDOS);
	}
}
