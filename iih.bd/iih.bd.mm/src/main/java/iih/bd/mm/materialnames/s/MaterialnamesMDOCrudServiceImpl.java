package iih.bd.mm.materialnames.s;

import iih.bd.mm.materialnames.d.MaterialNamesDO;
import iih.bd.mm.materialnames.d.desc.MaterialNamesDODesc;
import iih.bd.mm.materialnames.i.IMaterialnamesMDOCudService;
import iih.bd.mm.materialnames.i.IMaterialnamesMDORService;
import iih.bd.mm.materialnames.s.bp.findbp.FindMaterialNamesByPageInfoBp;
import iih.bd.mm.materialnames.s.bp.findbp.FindMaterialNamesByQCondAndPageInfoBp;
import iih.bd.mm.materialnames.s.bp.savebp.SaveMaterialNamesDOBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 药品通用名目录主实体CRUD服务实现
 */
@Service(serviceInterfaces = { IMaterialnamesMDOCudService.class,
		IMaterialnamesMDORService.class }, binding = Binding.JSONRPC)
public class MaterialnamesMDOCrudServiceImpl extends BaseDOService<MaterialNamesDO>
		implements IMaterialnamesMDOCudService, IMaterialnamesMDORService {

	public MaterialnamesMDOCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MaterialNamesDODesc.class), IAppFwTempTbl.tmp_iaw_08.name());
	}

	@Override
	public PagingRtnData<MaterialNamesDO> findByQCondAndPageInfo(QryRootNodeDTO qryRootNodeDTO, String orderStr,
			PaginationInfo pg) throws BizException {
		FindMaterialNamesByQCondAndPageInfoBp bp = new FindMaterialNamesByQCondAndPageInfoBp();
		return bp.exec(qryRootNodeDTO, orderStr, pg);
	}

	@Override
	public PagingRtnData<MaterialNamesDO> findByPageInfo(PaginationInfo pg, String whereStr, String orderStr)
			throws BizException {
		FindMaterialNamesByPageInfoBp bp = new FindMaterialNamesByPageInfoBp();
		return bp.exec(pg, whereStr, orderStr);
	}

	@Override
	public MaterialNamesDO[] update(MaterialNamesDO... dos) throws BizException {
		SaveMaterialNamesDOBp bp = new SaveMaterialNamesDOBp();
		MaterialNamesDO[] rtn = bp.exec(dos);
		return rtn;
	}

	@Override
	public MaterialNamesDO[] insert(MaterialNamesDO... arg0) throws BizException {
		SaveMaterialNamesDOBp bp = new SaveMaterialNamesDOBp();
		MaterialNamesDO[] rtn = bp.exec(arg0);
		return rtn;
	}

	@Override
	public MaterialNamesDO[] save(MaterialNamesDO... dos) throws BizException {
		SaveMaterialNamesDOBp bp = new SaveMaterialNamesDOBp();
		MaterialNamesDO[] rtn = bp.exec(dos);
		return rtn;
	}
}
