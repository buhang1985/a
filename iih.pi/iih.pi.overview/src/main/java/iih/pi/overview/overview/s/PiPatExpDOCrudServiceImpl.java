package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatExpDODesc;
import iih.pi.overview.overview.d.PiPatExpDO;
import iih.pi.overview.overview.i.IPiPatExpDOCudService;
import iih.pi.overview.overview.i.IPiPatExpDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatExpDOCudService.class,IPiPatExpDORService.class}, binding=Binding.JSONRPC)
public class PiPatExpDOCrudServiceImpl extends BaseDOService<PiPatExpDO> implements IPiPatExpDOCudService,IPiPatExpDORService {

    public PiPatExpDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatExpDODesc.class),IAppFwTempTbl.tmp_iaw_09.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

