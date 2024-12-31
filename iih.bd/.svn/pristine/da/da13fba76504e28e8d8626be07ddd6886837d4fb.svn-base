package iih.bd.fc.orpltpmatch.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.fc.orpltpmatch.d.desc.OrpltpMatchDODesc;
import iih.bd.fc.orpltpmatch.d.OrpltpMatchDO;
import iih.bd.fc.orpltpmatch.i.IOrpltpmatchMDOCudService;
import iih.bd.fc.orpltpmatch.i.IOrpltpmatchMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医嘱闭环匹配主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrpltpmatchMDOCudService.class,IOrpltpmatchMDORService.class}, binding=Binding.JSONRPC)
public class OrpltpmatchMDOCrudServiceImpl extends BaseDOService<OrpltpMatchDO> implements IOrpltpmatchMDOCudService,IOrpltpmatchMDORService {

    public OrpltpmatchMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrpltpMatchDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

