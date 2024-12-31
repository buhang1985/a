package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatVsDODesc;
import iih.pi.overview.overview.d.PiPatVsDO;
import iih.pi.overview.overview.i.IPiPatVsDOCudService;
import iih.pi.overview.overview.i.IPiPatVsDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatVsDOCudService.class,IPiPatVsDORService.class}, binding=Binding.JSONRPC)
public class PiPatVsDOCrudServiceImpl extends BaseDOService<PiPatVsDO> implements IPiPatVsDOCudService,IPiPatVsDORService {

    public PiPatVsDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatVsDODesc.class),IAppFwTempTbl.tmp_iaw_17.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

