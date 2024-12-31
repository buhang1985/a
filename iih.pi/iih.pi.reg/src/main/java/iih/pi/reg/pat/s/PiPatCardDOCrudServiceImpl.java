package iih.pi.reg.pat.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import iih.pi.reg.pat.d.desc.PiPatCardDODesc;
import iih.pi.reg.pat.d.PiPatCardDO;
import iih.pi.reg.pat.i.IPiPatCardDOCudService;
import iih.pi.reg.pat.i.IPiPatCardDORService;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.appfw.bizrule.validation.Validator;

/**
 * 患者基本信息主实体CRUD服务实现
 */
@Service(serviceInterfaces={IPiPatCardDOCudService.class,IPiPatCardDORService.class}, binding=Binding.JSONRPC)
public class PiPatCardDOCrudServiceImpl extends BaseDOService<PiPatCardDO> implements IPiPatCardDOCudService,IPiPatCardDORService {

    public PiPatCardDOCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatCardDODesc.class),IAppFwTempTbl.tmp_iaw_22.name()); 
    }
    
    @Override
   	protected Validator[] getDeleteValidator() {
   		return new Validator[] {
   				BDReferenceChecker.getInstance(new String[]{"pi_card_act"})//删除时，不校验就诊卡操作记录表。
   		};
   	}
}

