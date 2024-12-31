package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatPhyDODesc;
import iih.pi.overview.overview.d.PiPatPhyDO;
import iih.pi.overview.overview.i.IPiPatPhyDOCudService;
import iih.pi.overview.overview.i.IPiPatPhyDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatPhyDOCudService.class,IPiPatPhyDORService.class}, binding=Binding.JSONRPC)
public class PiPatPhyDOCrudServiceImpl extends BaseDOService<PiPatPhyDO> implements IPiPatPhyDOCudService,IPiPatPhyDORService {

    public PiPatPhyDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatPhyDODesc.class),IAppFwTempTbl.tmp_iaw_03.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

