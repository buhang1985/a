package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatFhDODesc;
import iih.pi.overview.overview.d.PiPatFhDO;
import iih.pi.overview.overview.i.IPiPatFhDOCudService;
import iih.pi.overview.overview.i.IPiPatFhDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatFhDOCudService.class,IPiPatFhDORService.class}, binding=Binding.JSONRPC)
public class PiPatFhDOCrudServiceImpl extends BaseDOService<PiPatFhDO> implements IPiPatFhDOCudService,IPiPatFhDORService {

    public PiPatFhDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatFhDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

