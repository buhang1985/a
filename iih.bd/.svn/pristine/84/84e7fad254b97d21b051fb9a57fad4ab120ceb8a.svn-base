package iih.bd.fc.orpltpmatch.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.fc.orpltpmatch.d.desc.OrpltpMatchAttrDODesc;
import iih.bd.fc.orpltpmatch.d.OrpltpMatchAttrDO;
import iih.bd.fc.orpltpmatch.i.IOrpltpMatchAttrDOCudService;
import iih.bd.fc.orpltpmatch.i.IOrpltpMatchAttrDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医嘱闭环匹配主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrpltpMatchAttrDOCudService.class,IOrpltpMatchAttrDORService.class}, binding=Binding.JSONRPC)
public class OrpltpMatchAttrDOCrudServiceImpl extends BaseDOService<OrpltpMatchAttrDO> implements IOrpltpMatchAttrDOCudService,IOrpltpMatchAttrDORService {

    public OrpltpMatchAttrDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrpltpMatchAttrDODesc.class),IAppFwTempTbl.tmp_iaw_13.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

