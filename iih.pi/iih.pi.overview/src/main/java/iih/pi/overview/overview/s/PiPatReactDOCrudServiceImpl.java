package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatReactDODesc;
import iih.pi.overview.overview.d.PiPatReactDO;
import iih.pi.overview.overview.i.IPiPatReactDOCudService;
import iih.pi.overview.overview.i.IPiPatReactDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatReactDOCudService.class,IPiPatReactDORService.class}, binding=Binding.JSONRPC)
public class PiPatReactDOCrudServiceImpl extends BaseDOService<PiPatReactDO> implements IPiPatReactDOCudService,IPiPatReactDORService {

    public PiPatReactDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatReactDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

