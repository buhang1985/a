package iih.sc.scbd.schedulesrv.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.sc.scbd.schedulesrv.d.desc.ScSrvKindDODesc;
import iih.sc.scbd.schedulesrv.d.ScSrvKindDO;
import iih.sc.scbd.schedulesrv.i.IScsrvkinddoMDOCudService;
import iih.sc.scbd.schedulesrv.i.IScsrvkinddoMDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 排班服务类别主实体CRUD服务实现
 */
@Service(serviceInterfaces={IScsrvkinddoMDOCudService.class,IScsrvkinddoMDORService.class}, binding=Binding.JSONRPC)
public class ScsrvkinddoMDOCrudServiceImpl extends BaseDOService<ScSrvKindDO> implements IScsrvkinddoMDOCudService,IScsrvkinddoMDORService {

    public ScsrvkinddoMDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(ScSrvKindDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

