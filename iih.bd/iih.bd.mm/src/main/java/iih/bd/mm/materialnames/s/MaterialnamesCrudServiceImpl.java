package iih.bd.mm.materialnames.s;

import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.d.MaterialnamesAggDO;
import iih.bd.mm.materialnames.d.desc.MaterialNamesDODesc;
import iih.bd.mm.materialnames.i.IMaterialnamesCudService;
import iih.bd.mm.materialnames.i.IMaterialnamesRService;
import iih.bd.mm.materialnames.s.bp.deletebp.DeleteMaterialnamesAggDOByParentDOBp;
import iih.bd.mm.materialnames.s.bp.findbp.FindMaterialnamesAggDOByIdBp;
import iih.bd.mm.materialnames.s.bp.savebp.SaveMaterialnamesAggDOBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;

/**
 * 药品通用名目录AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IMaterialnamesCudService.class,
		IMaterialnamesRService.class }, binding = Binding.JSONRPC)
public class MaterialnamesCrudServiceImpl extends BaseAggService<MaterialnamesAggDO, MaterialNamesDO>
		implements IMaterialnamesCudService, IMaterialnamesRService {
	public MaterialnamesCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MaterialNamesDODesc.class), IAppFwTempTbl.tmp_iaw_08.name());
	}

	@Override
	public MaterialnamesAggDO findById(String id) throws BizException {
		FindMaterialnamesAggDOByIdBp bp = new FindMaterialnamesAggDOByIdBp();
		return bp.exec(id);
	}

	@Override
	public MaterialnamesAggDO[] save(MaterialnamesAggDO[] aggs) throws BizException {
		SaveMaterialnamesAggDOBp bp = new SaveMaterialnamesAggDOBp();
		MaterialnamesAggDO[] rtn = bp.exec(aggs);
		return rtn;
	}

	@Override
	public MaterialnamesAggDO[] insert(MaterialnamesAggDO[] arg0) throws BizException {
		SaveMaterialnamesAggDOBp bp = new SaveMaterialnamesAggDOBp();
		MaterialnamesAggDO[] rtn = bp.exec(arg0);
		return rtn;
	}

	@Override
	public MaterialnamesAggDO[] update(MaterialnamesAggDO[] aggs) throws BizException {
		SaveMaterialnamesAggDOBp bp = new SaveMaterialnamesAggDOBp();
		MaterialnamesAggDO[] rtn = bp.exec(aggs);
		return rtn;
	}

	@Override
	public void deleteByParentDO(MaterialNamesDO[] arg0) throws BizException {
		DeleteMaterialnamesAggDOByParentDOBp bp = new DeleteMaterialnamesAggDOByParentDOBp();
		bp.exec(arg0);
	}
}
