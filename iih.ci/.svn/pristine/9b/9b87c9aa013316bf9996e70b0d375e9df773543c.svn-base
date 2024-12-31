package iih.ci.mr.mrsign.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mr.mrsign.d.desc.CiMrSignCaDODesc;
import iih.ci.mr.mrsign.d.CiMrSignCaDO;
import iih.ci.mr.mrsign.i.ICiMrSignCaDOCudService;
import iih.ci.mr.mrsign.i.ICiMrSignCaDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 临床医疗记录签名主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiMrSignCaDOCudService.class,ICiMrSignCaDORService.class}, binding=Binding.JSONRPC)
public class CiMrSignCaDOCrudServiceImpl extends BaseDOService<CiMrSignCaDO> implements ICiMrSignCaDOCudService,ICiMrSignCaDORService {

    public CiMrSignCaDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrSignCaDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

