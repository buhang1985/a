package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatMarDODesc;
import iih.pi.overview.overview.d.PiPatMarDO;
import iih.pi.overview.overview.i.IPiPatMarDOCudService;
import iih.pi.overview.overview.i.IPiPatMarDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatMarDOCudService.class,IPiPatMarDORService.class}, binding=Binding.JSONRPC)
public class PiPatMarDOCrudServiceImpl extends BaseDOService<PiPatMarDO> implements IPiPatMarDOCudService,IPiPatMarDORService {

    public PiPatMarDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatMarDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

