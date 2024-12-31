package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatSugDODesc;
import iih.pi.overview.overview.d.PiPatSugDO;
import iih.pi.overview.overview.i.IPiPatSugDOCudService;
import iih.pi.overview.overview.i.IPiPatSugDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatSugDOCudService.class,IPiPatSugDORService.class}, binding=Binding.JSONRPC)
public class PiPatSugDOCrudServiceImpl extends BaseDOService<PiPatSugDO> implements IPiPatSugDOCudService,IPiPatSugDORService {

    public PiPatSugDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatSugDODesc.class),IAppFwTempTbl.tmp_iaw_04.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

