package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatBTDODesc;
import iih.pi.overview.overview.d.PiPatBTDO;
import iih.pi.overview.overview.i.IPiPatBTDOCudService;
import iih.pi.overview.overview.i.IPiPatBTDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatBTDOCudService.class,IPiPatBTDORService.class}, binding=Binding.JSONRPC)
public class PiPatBTDOCrudServiceImpl extends BaseDOService<PiPatBTDO> implements IPiPatBTDOCudService,IPiPatBTDORService {

    public PiPatBTDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatBTDODesc.class),IAppFwTempTbl.tmp_iaw_11.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

