package iih.pi.overview.overview.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.overview.overview.d.desc.PiPatDisaDODesc;
import iih.pi.overview.overview.d.PiPatDisaDO;
import iih.pi.overview.overview.i.IPiPatDisaDOCudService;
import iih.pi.overview.overview.i.IPiPatDisaDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者临床摘要主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatDisaDOCudService.class,IPiPatDisaDORService.class}, binding=Binding.JSONRPC)
public class PiPatDisaDOCrudServiceImpl extends BaseDOService<PiPatDisaDO> implements IPiPatDisaDOCudService,IPiPatDisaDORService {

    public PiPatDisaDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatDisaDODesc.class),IAppFwTempTbl.tmp_iaw_16.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

