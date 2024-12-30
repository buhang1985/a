package iih.sc.scbd.bdsrv.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.scbd.bdsrv.d.desc.ScBdsrvDODesc;
import iih.sc.scbd.bdsrv.d.ScBdsrvDO;
import iih.sc.scbd.bdsrv.i.IScbdsrvMDOCudService;
import iih.sc.scbd.bdsrv.i.IScbdsrvMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 排班计划-医疗服务主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScbdsrvMDOCudService.class,IScbdsrvMDORService.class}, binding=Binding.JSONRPC)
public class ScbdsrvMDOCrudServiceImpl extends BaseDOService<ScBdsrvDO> implements IScbdsrvMDOCudService,IScbdsrvMDORService {

    public ScbdsrvMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScBdsrvDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

