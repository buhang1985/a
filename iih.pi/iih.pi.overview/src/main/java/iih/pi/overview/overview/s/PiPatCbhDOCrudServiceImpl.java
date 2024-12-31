package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatCbhDODesc;
import iih.pi.overview.overview.d.PiPatCbhDO;
import iih.pi.overview.overview.i.IPiPatCbhDOCudService;
import iih.pi.overview.overview.i.IPiPatCbhDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatCbhDOCudService.class,IPiPatCbhDORService.class}, binding=Binding.JSONRPC)
public class PiPatCbhDOCrudServiceImpl extends BaseDOService<PiPatCbhDO> implements IPiPatCbhDOCudService,IPiPatCbhDORService {

    public PiPatCbhDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatCbhDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

