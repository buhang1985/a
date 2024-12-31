package iih.ci.mrfp.other2mrfp.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.mrfp.other2mrfp.d.desc.CiMrfpIntenCareDODesc;
import iih.ci.mrfp.other2mrfp.d.CiMrfpIntenCareDO;
import iih.ci.mrfp.other2mrfp.i.ICiMrfpIntenCareDOCudService;
import iih.ci.mrfp.other2mrfp.i.ICiMrfpIntenCareDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 病案首页其他信息主实体CRUD服务实现
 */
@Service(serviceInterfaces={ICiMrfpIntenCareDOCudService.class,ICiMrfpIntenCareDORService.class}, binding=Binding.JSONRPC)
public class CiMrfpIntenCareDOCrudServiceImpl extends BaseDOService<CiMrfpIntenCareDO> implements ICiMrfpIntenCareDOCudService,ICiMrfpIntenCareDORService {

    public CiMrfpIntenCareDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(CiMrfpIntenCareDODesc.class),IAppFwTempTbl.tmp_iaw_25.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

