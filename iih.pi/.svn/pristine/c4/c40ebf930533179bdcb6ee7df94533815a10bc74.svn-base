package iih.pi.reg.pat.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.reg.pat.d.desc.PiPatHpDODesc;
import iih.pi.reg.pat.d.PiPatHpDO;
import iih.pi.reg.pat.i.IPiPatHpDOCudService;
import iih.pi.reg.pat.i.IPiPatHpDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者基本信息主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatHpDOCudService.class,IPiPatHpDORService.class}, binding=Binding.JSONRPC)
public class PiPatHpDOCrudServiceImpl extends BaseDOService<PiPatHpDO> implements IPiPatHpDOCudService,IPiPatHpDORService {

    public PiPatHpDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatHpDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

