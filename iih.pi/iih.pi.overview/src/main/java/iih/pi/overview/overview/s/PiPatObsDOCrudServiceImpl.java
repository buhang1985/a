package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatObsDODesc;
import iih.pi.overview.overview.d.PiPatObsDO;
import iih.pi.overview.overview.i.IPiPatObsDOCudService;
import iih.pi.overview.overview.i.IPiPatObsDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatObsDOCudService.class,IPiPatObsDORService.class}, binding=Binding.JSONRPC)
public class PiPatObsDOCrudServiceImpl extends BaseDOService<PiPatObsDO> implements IPiPatObsDOCudService,IPiPatObsDORService {

    public PiPatObsDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatObsDODesc.class),IAppFwTempTbl.tmp_iaw_10.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

