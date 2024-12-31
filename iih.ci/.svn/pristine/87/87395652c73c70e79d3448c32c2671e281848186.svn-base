package iih.ci.rcm.contagion.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.ci.rcm.contagion.d.desc.HepatitisBDODesc;
import iih.ci.rcm.contagion.d.HepatitisBDO;
import iih.ci.rcm.contagion.i.IHepatitisBDOCudService;
import iih.ci.rcm.contagion.i.IHepatitisBDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 传染病报告卡主实体CRUD服务实现
 */
@Service(serviceInterfaces={IHepatitisBDOCudService.class,IHepatitisBDORService.class}, binding=Binding.JSONRPC)
public class HepatitisBDOCrudServiceImpl extends BaseDOService<HepatitisBDO> implements IHepatitisBDOCudService,IHepatitisBDORService {

    public HepatitisBDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HepatitisBDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    
    @Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] {
				BDReferenceChecker.getInstance()
		};
	}
}

