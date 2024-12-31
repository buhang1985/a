package iih.pi.dic.cardtype.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.permfw.pub.AggBDReferenceChecker;
import xap.sys.permfw.pub.BDReferenceChecker;
import iih.pi.dic.cardtype.d.desc.PiPatCardTpDODesc;
import iih.pi.dic.cardtype.d.PiPatCardTpDO;
import iih.pi.dic.cardtype.i.ICardtypeCudService;
import iih.pi.dic.cardtype.i.ICardtypeRService;


/**
 * 患者卡类型AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ICardtypeCudService.class,ICardtypeRService.class}, binding=Binding.JSONRPC)
public class CardtypeCrudServiceImpl extends BaseDOService<PiPatCardTpDO> implements ICardtypeCudService,ICardtypeRService {

    public CardtypeCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatCardTpDODesc.class),IAppFwTempTbl.tmp_iaw_20.name()); 
    }
    
    @Override
  	protected Validator[] getDeleteValidator() {
  		return new Validator[] {
  				BDReferenceChecker.getInstance()
  		};
  	}
}

