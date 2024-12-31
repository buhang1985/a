package iih.bd.mm.meterial.s.rule;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.s.rule.bp.MaterialPropChangSetSrvBp;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.ICompareRule;

/**
 * 药品是否可用属性变更前更改药品通用名相关属性规则
 * 
 * @author shao_yuan
 *
 */
public class MaterialPropChangSetSrvRule implements ICompareRule {

	@Override
	public void process(Object[] newDataArray, Object[] oldDataArray) throws BizException {
		if (oldDataArray == null || oldDataArray.length <= 0) {
			return;
		}
		if (oldDataArray[0] instanceof MeterialAggDO) {
			MaterialPropSetSrv((MeterialAggDO[]) oldDataArray, (MeterialAggDO[]) newDataArray);
		} else if (oldDataArray[0] instanceof MeterialDO) {
			MaterialPropSetSrv((MeterialDO[]) oldDataArray, (MeterialDO[]) newDataArray);
		}
	}

	/**
	 * 药品是否可用属性变更前更改药品通用名相关属性规则
	 * 
	 * @param oldMaterialArray
	 * @param newMaterialArray
	 * @throws BizException
	 */
	private void MaterialPropSetSrv(MeterialDO[] oldDataArray, MeterialDO[] newDataArray) throws BizException {
		int lenght = oldDataArray.length;
		List<String> ids = new ArrayList();
		for (int i = 0; i < lenght; i++) {
			MeterialDO oldMaterial = oldDataArray[i];
			MeterialDO newMaterial = newDataArray[i];
			MaterialPropChangSetSrv(oldMaterial, newMaterial, ids);
		}
		MaterialPropChangSetSrvBp bp = new MaterialPropChangSetSrvBp();
		bp.exec(ids.toArray(new String[0]));
	}

	/**
	 * 组装药品服务id集合
	 * 
	 * @param oldMaterialArray
	 * @param newMaterialArray
	 * @param ids
	 * @throws BizException
	 */
	private void MaterialPropChangSetSrv(MeterialDO oldMaterial, MeterialDO newMaterial, List<String> ids) {
		if (StringUtils.isBlank(newMaterial.getSd_mmtp())
				|| !newMaterial.getSd_mmtp().startsWith(IBdMmDictCodeConst.SD_MMTP_DRUG)) {
			return;
		}
		if (FBoolean.FALSE.equals(newMaterial.getFg_active()) && FBoolean.TRUE.equals(oldMaterial.getFg_active())) {
			ids.add(oldMaterial.getId_srv());
		}
	}

	/**
	 * 药品是否可用属性变更前更改药品通用名相关属性规则
	 * 
	 * @param oldMaterialArray
	 * @param newMaterialArray
	 * @throws BizException
	 */
	private void MaterialPropSetSrv(MeterialAggDO[] oldDataArray, MeterialAggDO[] newDataArray) throws BizException {
		int lenght = oldDataArray.length;
		MeterialDO[] newMaterials = new MeterialDO[lenght];
		MeterialDO[] oldMaterials = new MeterialDO[lenght];
		for (int i = 0; i < lenght; i++) {
			MeterialDO oldMaterial = oldDataArray[i].getParentDO();
			MeterialDO newMaterial = newDataArray[i].getParentDO();
			oldMaterials[i] = oldMaterial;
			newMaterials[i] = newMaterial;
		}
		MaterialPropSetSrv(oldMaterials, newMaterials);
	}

}
