package iih.pi.reg.pat.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.reg.pat.d.desc.PiPatContDODesc;
import iih.pi.reg.pat.d.PiPatContDO;
import iih.pi.reg.pat.i.IPiPatContDOCudService;
import iih.pi.reg.pat.i.IPiPatContDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者基本信息主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatContDOCudService.class,IPiPatContDORService.class}, binding=Binding.JSONRPC)
public class PiPatContDOCrudServiceImpl extends BaseDOService<PiPatContDO> implements IPiPatContDOCudService,IPiPatContDORService {

    public PiPatContDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatContDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

