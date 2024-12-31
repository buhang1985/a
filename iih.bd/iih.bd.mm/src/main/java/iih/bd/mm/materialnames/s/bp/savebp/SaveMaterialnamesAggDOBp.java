package iih.bd.mm.materialnames.s.bp.savebp;

import java.util.ArrayList;

import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.d.MaterialnamesAggDO;
import iih.bd.mm.materialnames.d.MnAliasSetDO;
import iih.bd.mm.materialnames.d.MnCodeSetDO;
import iih.bd.mm.materialnames.s.bp.creater.MaterialnamesAggDOCreater;
import xap.mw.core.data.BizException;

/**
 * 保存药品通用名Agg业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SaveMaterialnamesAggDOBp {

	public MaterialnamesAggDO[] exec(MaterialnamesAggDO[] aggs) throws BizException {
		ArrayList<MaterialnamesAggDO> rtnList = new ArrayList<MaterialnamesAggDO>();
		ArrayList<MaterialNamesDO> namesList = new ArrayList<MaterialNamesDO>();
		for (MaterialnamesAggDO materialnamesAggDO : aggs) {
			MaterialNamesDO paretnData = saveMaterialNames(materialnamesAggDO);
			namesList.add(paretnData);
			MnCodeSetDO[] codeSet = saveCodeSet(materialnamesAggDO);
			MnAliasSetDO[] aliasSet = saveAliasSet(materialnamesAggDO);
			MaterialnamesAggDO rtnAggDo = MaterialnamesAggDOCreater.createMaterialnamesAggDO(paretnData, codeSet,
					aliasSet, materialnamesAggDO.getMaterialsDO());
			rtnList.add(rtnAggDo);
		}
		updateSrvAccRel(rtnList.toArray(new MaterialnamesAggDO[0]));
		return rtnList.toArray(new MaterialnamesAggDO[0]);
	}

	/**
	 * 更新通用名与核算项目关系业务
	 * 
	 * @param materialNameAggs
	 * @throws BizException
	 */
	private void updateSrvAccRel(MaterialnamesAggDO[] materialNameAggs) throws BizException {
		UpdateSrvAccRelBp bp = new UpdateSrvAccRelBp();
		bp.exec(materialNameAggs);
	}

	/**
	 * 保存药品通用名
	 * 
	 * @param materialnamesAggDO
	 * @return
	 * @throws BizException
	 */
	private MaterialNamesDO saveMaterialNames(MaterialnamesAggDO materialnamesAggDO) throws BizException {
		SaveMaterialNamesDOBp bp = new SaveMaterialNamesDOBp();
		MaterialNamesDO[] rtn = bp.exec(new MaterialNamesDO[] { materialnamesAggDO.getParentDO() });
		if (rtn != null && rtn.length > 0) {
			UpdateIdMaterialname(materialnamesAggDO, rtn[0]);
		}
		return rtn[0];
	}

	/**
	 * 更新通用名主键
	 * 
	 * @param materialnamesAggDO
	 * @param materialNamesDO
	 */
	private void UpdateIdMaterialname(MaterialnamesAggDO materialnamesAggDO, MaterialNamesDO materialNamesDO) {
		MnCodeSetDO[] codeSetArray = materialnamesAggDO.getMnCodeSetDO();
		if (codeSetArray != null && codeSetArray.length > 0) {
			for (MnCodeSetDO mnCodeSetDO : codeSetArray) {
				mnCodeSetDO.setId_materialname(materialNamesDO.getId_materialname());
			}
		}

		MnAliasSetDO[] aliasSetArray = materialnamesAggDO.getMnAliasSetDO();
		if (aliasSetArray != null && aliasSetArray.length > 0) {
			for (MnAliasSetDO mnAliasSetDO : aliasSetArray) {
				mnAliasSetDO.setId_materialname(materialNamesDO.getId_materialname());
			}
		}
	}

	/**
	 * 保存编码集
	 * 
	 * @param materialnamesAggDO
	 * @return
	 * @throws BizException
	 */
	private MnCodeSetDO[] saveCodeSet(MaterialnamesAggDO materialnamesAggDO) throws BizException {
		SaveCodeSetDOsBp bp = new SaveCodeSetDOsBp();
		MnCodeSetDO[] rtn = bp.exec(materialnamesAggDO.getMnCodeSetDO());
		return rtn;
	}

	/**
	 * 保存别名集
	 * 
	 * @param materialnamesAggDO
	 * @return
	 * @throws BizException
	 */
	private MnAliasSetDO[] saveAliasSet(MaterialnamesAggDO materialnamesAggDO) throws BizException {
		SaveAliasSetDOsBp bp = new SaveAliasSetDOsBp();
		MnAliasSetDO[] rtn = bp.exec(materialnamesAggDO.getMnAliasSetDO());
		return rtn;
	}
}
