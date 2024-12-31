package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatDiDODesc;
import iih.pi.overview.overview.d.PiPatDiDO;
import iih.pi.overview.overview.i.IPiPatDiDOCudService;
import iih.pi.overview.overview.i.IPiPatDiDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatDiDOCudService.class,IPiPatDiDORService.class}, binding=Binding.JSONRPC)
public class PiPatDiDOCrudServiceImpl extends BaseDOService<PiPatDiDO> implements IPiPatDiDOCudService,IPiPatDiDORService {

    public PiPatDiDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatDiDODesc.class),IAppFwTempTbl.tmp_iaw_02.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

