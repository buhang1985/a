package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatPsnDODesc;
import iih.pi.overview.overview.d.PiPatPsnDO;
import iih.pi.overview.overview.i.IPiPatPsnDOCudService;
import iih.pi.overview.overview.i.IPiPatPsnDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatPsnDOCudService.class,IPiPatPsnDORService.class}, binding=Binding.JSONRPC)
public class PiPatPsnDOCrudServiceImpl extends BaseDOService<PiPatPsnDO> implements IPiPatPsnDOCudService,IPiPatPsnDORService {

    public PiPatPsnDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatPsnDODesc.class),IAppFwTempTbl.tmp_iaw_29.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

