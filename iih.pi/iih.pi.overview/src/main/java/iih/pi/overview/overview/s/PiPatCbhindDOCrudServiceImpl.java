package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatCbhindDODesc;
import iih.pi.overview.overview.d.PiPatCbhindDO;
import iih.pi.overview.overview.i.IPiPatCbhindDOCudService;
import iih.pi.overview.overview.i.IPiPatCbhindDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatCbhindDOCudService.class,IPiPatCbhindDORService.class}, binding=Binding.JSONRPC)
public class PiPatCbhindDOCrudServiceImpl extends BaseDOService<PiPatCbhindDO> implements IPiPatCbhindDOCudService,IPiPatCbhindDORService {

    public PiPatCbhindDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatCbhindDODesc.class),IAppFwTempTbl.tmp_iaw_21.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

