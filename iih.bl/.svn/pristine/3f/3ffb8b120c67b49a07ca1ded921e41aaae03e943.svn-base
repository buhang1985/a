package iih.bl.hp.prepay.s;
import iih.bl.hp.prepay.d.HpPrePayDo;
import iih.bl.hp.prepay.d.desc.HpPrePayDoDesc;
import iih.bl.hp.prepay.i.IHprepayCudService;
import iih.bl.hp.prepay.i.IHprepayRService;
import iih.bl.hp.prepay.s.bp.SaveForDailyBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保预结算AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IHprepayCudService.class,IHprepayRService.class}, binding=Binding.JSONRPC)
public class HprepayCrudServiceImpl extends BaseDOService<HpPrePayDo> implements IHprepayCudService,IHprepayRService {
    public HprepayCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(HpPrePayDoDesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }

	@Override
	public HpPrePayDo[] saveForDaily(HpPrePayDo[] aggdos) throws BizException {
		SaveForDailyBP bp = new SaveForDailyBP();
		return bp.exec(aggdos,this);
	}
}
