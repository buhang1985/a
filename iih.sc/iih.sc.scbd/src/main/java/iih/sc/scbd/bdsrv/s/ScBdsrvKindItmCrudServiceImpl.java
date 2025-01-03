package iih.sc.scbd.bdsrv.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.scbd.bdsrv.d.desc.ScBdsrvKindItmDesc;
import iih.sc.scbd.bdsrv.d.ScBdsrvKindItm;
import iih.sc.scbd.bdsrv.i.IScBdsrvKindItmCudService;
import iih.sc.scbd.bdsrv.i.IScBdsrvKindItmRService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 排班计划-医疗服务主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScBdsrvKindItmCudService.class,IScBdsrvKindItmRService.class}, binding=Binding.JSONRPC)
public class ScBdsrvKindItmCrudServiceImpl extends BaseDOService<ScBdsrvKindItm> implements IScBdsrvKindItmCudService,IScBdsrvKindItmRService {

    public ScBdsrvKindItmCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScBdsrvKindItmDesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

