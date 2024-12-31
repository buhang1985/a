package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatLabDODesc;
import iih.pi.overview.overview.d.PiPatLabDO;
import iih.pi.overview.overview.i.IPiPatLabDOCudService;
import iih.pi.overview.overview.i.IPiPatLabDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatLabDOCudService.class,IPiPatLabDORService.class}, binding=Binding.JSONRPC)
public class PiPatLabDOCrudServiceImpl extends BaseDOService<PiPatLabDO> implements IPiPatLabDOCudService,IPiPatLabDORService {

    public PiPatLabDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatLabDODesc.class),IAppFwTempTbl.tmp_iaw_14.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

