package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatMhDODesc;
import iih.pi.overview.overview.d.PiPatMhDO;
import iih.pi.overview.overview.i.IPiPatMhDOCudService;
import iih.pi.overview.overview.i.IPiPatMhDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatMhDOCudService.class,IPiPatMhDORService.class}, binding=Binding.JSONRPC)
public class PiPatMhDOCrudServiceImpl extends BaseDOService<PiPatMhDO> implements IPiPatMhDOCudService,IPiPatMhDORService {

    public PiPatMhDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatMhDODesc.class),IAppFwTempTbl.tmp_iaw_18.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

