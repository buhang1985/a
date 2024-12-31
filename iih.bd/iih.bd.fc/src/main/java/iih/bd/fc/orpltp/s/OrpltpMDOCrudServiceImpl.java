package iih.bd.fc.orpltp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.bd.fc.orpltp.d.desc.OrpltpDODesc;
import iih.bd.fc.orpltp.d.OrpltpDO;
import iih.bd.fc.orpltp.i.IOrpltpMDOCudService;
import iih.bd.fc.orpltp.i.IOrpltpMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 医嘱执行计划状态主实体CRUD服务实现
 */
@Service(serviceInterfaces={IOrpltpMDOCudService.class,IOrpltpMDORService.class}, binding=Binding.JSONRPC)
public class OrpltpMDOCrudServiceImpl extends TreeBaseDOService<OrpltpDO> implements IOrpltpMDOCudService,IOrpltpMDORService {

    public OrpltpMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(OrpltpDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

