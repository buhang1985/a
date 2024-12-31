package iih.bd.mm.meterial.s.rule;

import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.s.rule.bp.MaterialPropChangCheckBp;
import xap.mw.core.data.BizException;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 药品属性变更检查规则
 * 
 * @author hao_wu
 *
 */
@SuppressWarnings("rawtypes")
public class MaterialPropChangCheckRule implements ICompareRule {

	@Override
	public void process(Object[] oldDataArray, Object[] newDataArray) throws BizException {
		if (oldDataArray == null || oldDataArray.length <= 0) {
			return;
		}

		if (oldDataArray[0] instanceof MeterialAggDO) {
			MaterialPropChangCheck((MeterialAggDO[]) oldDataArray, (MeterialAggDO[]) newDataArray);
		} else if (oldDataArray[0] instanceof MeterialDO) {
			MaterialPropChangCheck((MeterialDO[]) oldDataArray, (MeterialDO[]) newDataArray);
		}
	}

	/**
	 * 药品属性变更检查
	 * 
	 * @param oldMaterialAggArray
	 * @param newMaterialAggArray
	 * @throws BizException
	 */
	private void MaterialPropChangCheck(MeterialAggDO[] oldMaterialAggArray, MeterialAggDO[] newMaterialAggArray)
			throws BizException {
		int lenght = oldMaterialAggArray.length;
		for (int i = 0; i < lenght; i++) {
			MeterialDO oldMaterial = oldMaterialAggArray[i].getParentDO();
			MeterialDO newMaterial = newMaterialAggArray[i].getParentDO();
			MaterialPropChangCheck(oldMaterial, newMaterial);
		}
	}

	/**
	 * 药品属性变更检查
	 * 
	 * @param oldMaterialArray
	 * @param newMaterialArray
	 * @throws BizException
	 */
	private void MaterialPropChangCheck(MeterialDO[] oldMaterialArray, MeterialDO[] newMaterialArray)
			throws BizException {
		int lenght = oldMaterialArray.length;
		for (int i = 0; i < lenght; i++) {
			MeterialDO oldMaterial = oldMaterialArray[i];
			MeterialDO newMaterial = newMaterialArray[i];
			MaterialPropChangCheck(oldMaterial, newMaterial);
		}
	}

	/**
	 * 药品属性变更检查
	 * 
	 * @param oldMaterial
	 * @param newMaterial
	 * @throws BizException
	 */
	private void MaterialPropChangCheck(MeterialDO oldMaterial, MeterialDO newMaterial) throws BizException {
		MaterialPropChangCheckBp bp = new MaterialPropChangCheckBp();
		bp.exec(oldMaterial, newMaterial);
	}
}
