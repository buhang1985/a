package iih.mi.mc.mimcpatspec.s;
import iih.mi.mc.dto.d.MiMcPatSpecDTO;
import iih.mi.mc.mimcpatspec.d.MiMcPatSpecDO;
import iih.mi.mc.mimcpatspec.d.MimcpatspecdiAggDO;
import iih.mi.mc.mimcpatspec.d.desc.MiMcPatSpecDODesc;
import iih.mi.mc.mimcpatspec.i.IMimcpatspecdiCudService;
import iih.mi.mc.mimcpatspec.i.IMimcpatspecdiRService;
import iih.mi.mc.mimcpatspec.s.bp.MiMcSpecPatCuBeforeBp;
import iih.mi.mc.mimcspec.s.bp.ImportExcelDataBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.IRule;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医保特殊病患者维护AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IMimcpatspecdiCudService.class,IMimcpatspecdiRService.class}, binding=Binding.JSONRPC)
public class MimcpatspecdiCrudServiceImpl extends BaseAggService<MimcpatspecdiAggDO,MiMcPatSpecDO> implements IMimcpatspecdiCudService,IMimcpatspecdiRService {
    public MimcpatspecdiCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(MiMcPatSpecDODesc.class),IAppFwTempTbl.tmp_iaw_19.name()); 
    }
    /**
	 * 根据AggDO保存导入医保患者诊断信息
	 */
	@Override
	public void importData(MiMcPatSpecDTO[] miSpecAgg) throws BizException {
		
		ImportExcelDataBp importBp=new ImportExcelDataBp();
		importBp.exec(miSpecAgg);
	}
	
    @SuppressWarnings("unchecked")
    @Override
    protected void addInsertBeforeRule(AroundProcesser<MimcpatspecdiAggDO> processer){
    	super.addInsertBeforeRule(processer);
    	processer.addBeforeRule(new IRule<MimcpatspecdiAggDO>() {
			@Override
			public void process(MimcpatspecdiAggDO... dos) throws BizException {
				for (MimcpatspecdiAggDO mimcpatspecdiAggDO : dos) {
					
					processBeforeInsertOrUpdate(mimcpatspecdiAggDO);
				}
			}
    	});
    }
    
	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<MimcpatspecdiAggDO> processer, MimcpatspecdiAggDO[] originvos){
    	super.addUpdateBeforeRule(processer, originvos);
    	processer.addBeforeRule(new IRule<MimcpatspecdiAggDO>() {
			@Override
			public void process(MimcpatspecdiAggDO... dos) throws BizException {
				for (MimcpatspecdiAggDO mimcpatspecdiAggDO : dos) {
					
					processBeforeInsertOrUpdate(mimcpatspecdiAggDO);
				}
			}
    	});
    }
	
    protected void processBeforeInsertOrUpdate(MimcpatspecdiAggDO miMcSpecDrugDO) throws BizException{
    	MiMcSpecPatCuBeforeBp bp = new MiMcSpecPatCuBeforeBp();
    	bp.exec(miMcSpecDrugDO);
    }
}
