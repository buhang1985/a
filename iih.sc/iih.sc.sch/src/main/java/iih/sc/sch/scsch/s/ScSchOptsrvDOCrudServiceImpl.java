package iih.sc.sch.scsch.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.sch.scsch.d.desc.ScSchOptsrvDODesc;
import iih.sc.sch.scsch.d.ScSchOptsrvDO;
import iih.sc.sch.scsch.i.IScSchOptsrvDOCudService;
import iih.sc.sch.scsch.i.IScSchOptsrvDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 计划排班_排班主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScSchOptsrvDOCudService.class,IScSchOptsrvDORService.class}, binding=Binding.JSONRPC)
public class ScSchOptsrvDOCrudServiceImpl extends BaseDOService<ScSchOptsrvDO> implements IScSchOptsrvDOCudService,IScSchOptsrvDORService {

    public ScSchOptsrvDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScSchOptsrvDODesc.class),IAppFwTempTbl.tmp_iaw_01.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

