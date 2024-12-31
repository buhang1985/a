package iih.pi.reg.pat.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.reg.pat.d.desc.PiPatBiolDODesc;
import iih.pi.reg.pat.d.PiPatBiolDO;
import iih.pi.reg.pat.i.IPiPatBiolDOCudService;
import iih.pi.reg.pat.i.IPiPatBiolDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者基本信息主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatBiolDOCudService.class,IPiPatBiolDORService.class}, binding=Binding.JSONRPC)
public class PiPatBiolDOCrudServiceImpl extends BaseDOService<PiPatBiolDO> implements IPiPatBiolDOCudService,IPiPatBiolDORService {

    public PiPatBiolDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatBiolDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

