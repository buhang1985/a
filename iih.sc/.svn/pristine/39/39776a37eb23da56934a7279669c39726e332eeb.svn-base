package iih.sc.scbd.schedulesrv.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.scbd.schedulesrv.d.desc.ScSrvKindItmDesc;
import iih.sc.scbd.schedulesrv.d.ScSrvKindItm;
import iih.sc.scbd.schedulesrv.i.IScSrvKindItmCudService;
import iih.sc.scbd.schedulesrv.i.IScSrvKindItmRService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 排班服务类别主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScSrvKindItmCudService.class,IScSrvKindItmRService.class}, binding=Binding.JSONRPC)
public class ScSrvKindItmCrudServiceImpl extends BaseDOService<ScSrvKindItm> implements IScSrvKindItmCudService,IScSrvKindItmRService {

    public ScSrvKindItmCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScSrvKindItmDesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

