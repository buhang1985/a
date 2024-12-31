package iih.ci.pre.obspre.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.pre.obspre.d.desc.ObsPreDODesc;
import iih.ci.pre.obspre.d.ObsPreDO;
import iih.ci.pre.obspre.i.IObspreMDOCudService;
import iih.ci.pre.obspre.i.IObspreMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 预检主实体CRUD服务实现
 */
@Service(serviceInterfaces={IObspreMDOCudService.class,IObspreMDORService.class}, binding=Binding.JSONRPC)
public class ObspreMDOCrudServiceImpl extends BaseDOService<ObsPreDO> implements IObspreMDOCudService,IObspreMDORService {

    public ObspreMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ObsPreDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

