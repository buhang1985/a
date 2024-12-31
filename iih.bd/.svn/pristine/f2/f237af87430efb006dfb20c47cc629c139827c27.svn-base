package iih.bd.mm.autoreplenishconfigure.s;

import iih.bd.mm.autoreplenishconfigure.bp.BatchAddBp;
import iih.bd.mm.autoreplenishconfigure.bp.FindAutoReplenishConfiguresBp;
import iih.bd.mm.autoreplenishconfigure.bp.FindMmListDtoBp;
import iih.bd.mm.autoreplenishconfigure.d.AutoReplenishConfigureDO;
import iih.bd.mm.autoreplenishconfigure.i.IAutoreplenishconfigureCudExtService;
import iih.bd.mm.autoreplenishconfigure.i.IAutoreplenishconfigureExtService;
import iih.bd.mm.autoreplenishdto.d.BatchReplenishDTO;
import iih.bd.mm.mmcategory.d.MMCategoryDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

public class AutoreplenishconfigureExtServiceImpl implements IAutoreplenishconfigureExtService, IAutoreplenishconfigureCudExtService{

	@Override
	public AutoReplenishConfigureDO[] findAutoReplenishConfigures(String whId, QryRootNodeDTO qryNode, MMCategoryDO mmcaDo)
			throws BizException {
		FindAutoReplenishConfiguresBp bp = new FindAutoReplenishConfiguresBp();
		AutoReplenishConfigureDO[] result = bp.exec(whId, qryNode, mmcaDo);
		return result;
	}

	@Override
	public BatchReplenishDTO[] findMmListDto(String whId, QryRootNodeDTO qryNode) throws BizException {
		FindMmListDtoBp bp = new FindMmListDtoBp();
		BatchReplenishDTO[] result = bp.exec(whId, qryNode);
		return result;
	}

	@Override
	public void batchAdd(BatchReplenishDTO[] dtos, String idWh) throws BizException {
		BatchAddBp bp = new BatchAddBp();
		bp.exec(dtos, idWh);
	}
}
