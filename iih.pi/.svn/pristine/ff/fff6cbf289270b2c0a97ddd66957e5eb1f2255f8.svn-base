package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatImmDODesc;
import iih.pi.overview.overview.d.PiPatImmDO;
import iih.pi.overview.overview.i.IPiPatImmDOCudService;
import iih.pi.overview.overview.i.IPiPatImmDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatImmDOCudService.class,IPiPatImmDORService.class}, binding=Binding.JSONRPC)
public class PiPatImmDOCrudServiceImpl extends BaseDOService<PiPatImmDO> implements IPiPatImmDOCudService,IPiPatImmDORService {

    public PiPatImmDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatImmDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

