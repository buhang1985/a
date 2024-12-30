package iih.sc.scbd.scdeptparam.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.scbd.scdeptparam.d.desc.ScDeptParamDsDODesc;
import iih.sc.scbd.scdeptparam.d.ScDeptParamDsDO;
import iih.sc.scbd.scdeptparam.i.IScDeptParamDsDOCudService;
import iih.sc.scbd.scdeptparam.i.IScDeptParamDsDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 排班科室参数主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScDeptParamDsDOCudService.class,IScDeptParamDsDORService.class}, binding=Binding.JSONRPC)
public class ScDeptParamDsDOCrudServiceImpl extends BaseDOService<ScDeptParamDsDO> implements IScDeptParamDsDOCudService,IScDeptParamDsDORService {

    public ScDeptParamDsDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScDeptParamDsDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
}

