package iih.bd.mm.materialnames.s.bp.findbp;

import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.d.MaterialnamesAggDO;
import iih.bd.mm.materialnames.d.MaterialsDO;
import iih.bd.mm.materialnames.d.MnAliasSetDO;
import iih.bd.mm.materialnames.d.MnCodeSetDO;
import iih.bd.mm.materialnames.s.bp.creater.MaterialnamesAggDOCreater;
import iih.bd.mm.materialnames.s.bp.queryer.MaterialNamesQueryer;
import iih.bd.mm.materialnames.s.bp.queryer.MaterialsDOQueryer;
import iih.bd.mm.materialnames.s.bp.queryer.MnAliasSetQueryer;
import iih.bd.mm.materialnames.s.bp.queryer.MnCodeSetQueryer;
import xap.mw.core.data.BizException;

/**
 * 通过id查询药品通用名Agg信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindMaterialnamesAggDOByIdBp {

	public MaterialnamesAggDO exec(String id) throws BizException {
		MaterialNamesDO materialNamesDO = MaterialNamesQueryer.findMaterialNamesBySrvId(id);
		MnCodeSetDO[] mnCodeSetDOs = MnCodeSetQueryer.findMnCodeSetBySrvId(id);
		MnAliasSetDO[] mnAliasSetDOs = MnAliasSetQueryer.findMnAliasSetBySrvId(id);
		MaterialsDO[] Mmaterials = MaterialsDOQueryer.findMaterialsBySrvId(id);

		MaterialnamesAggDO materialnamesAggDO = MaterialnamesAggDOCreater.createMaterialnamesAggDO(materialNamesDO,
				mnCodeSetDOs, mnAliasSetDOs, Mmaterials);

		return materialnamesAggDO;
	}
}
