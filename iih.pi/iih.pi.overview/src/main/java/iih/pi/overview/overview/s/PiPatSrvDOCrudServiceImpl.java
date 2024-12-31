package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatSrvDODesc;
import iih.pi.overview.overview.d.PiPatSrvDO;
import iih.pi.overview.overview.i.IPiPatSrvDOCudService;
import iih.pi.overview.overview.i.IPiPatSrvDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatSrvDOCudService.class,IPiPatSrvDORService.class}, binding=Binding.JSONRPC)
public class PiPatSrvDOCrudServiceImpl extends BaseDOService<PiPatSrvDO> implements IPiPatSrvDOCudService,IPiPatSrvDORService {

    public PiPatSrvDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatSrvDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

