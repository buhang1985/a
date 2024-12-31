package iih.pmp.pay.trade.s;
import xap.mw.core.annotation.Service;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.permfw.pub.BDUniqueRuleValidate;
import iih.pmp.pay.s.bp.validate.OrderVidator;
import iih.pmp.pay.s.bp.validate.TradeValidator;
import iih.pmp.pay.trade.d.desc.TradeDODesc;
import iih.pmp.pay.trade.d.TradeDO;
import iih.pmp.pay.trade.i.ITradeCudService;
import iih.pmp.pay.trade.i.ITradeRService;


/**
 * 交易流水AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={ITradeCudService.class,ITradeRService.class}, binding=Binding.JSONRPC)
public class TradeCrudServiceImpl extends BaseDOService<TradeDO> implements ITradeCudService,ITradeRService {
    public TradeCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(TradeDODesc.class),IAppFwTempTbl.tmp_iaw_07.name()); 
    }
    
    @Override
   	protected Validator[] getInsertValidator() {
   		return new Validator[] { new TradeValidator(), new BDUniqueRuleValidate() };
   	}
}
