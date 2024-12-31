package iih.bd.mm.materialnames.s;

import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.i.IMaterialnamesEnableService;
import iih.bd.mm.materialnames.s.bp.DisableMaterialNamesBp;
import iih.bd.mm.materialnames.s.bp.EnableMaterialNamesBp;
import xap.mw.core.data.BizException;

/**
 * 药品通用名目录启用服务
 * 
 * @author hao_wu
 *
 */
public class MaterialnamesEnableServiceImpl implements IMaterialnamesEnableService {

	@Override
	public MaterialNamesDO[] Enable(MaterialNamesDO[] materialNamesDOs) throws BizException {
		EnableMaterialNamesBp bp = new EnableMaterialNamesBp();
		MaterialNamesDO[] result = bp.exec(materialNamesDOs);
		return result;
	}

	@Override
	public MaterialNamesDO[] Disable(MaterialNamesDO[] materialNamesDOs) throws BizException {
		DisableMaterialNamesBp bp = new DisableMaterialNamesBp();
		MaterialNamesDO[] result = bp.exec(materialNamesDOs);
		return result;
	}

}
