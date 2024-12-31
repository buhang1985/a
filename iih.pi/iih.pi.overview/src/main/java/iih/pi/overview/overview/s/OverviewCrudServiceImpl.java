package iih.pi.overview.overview.s;
import iih.pi.overview.overview.d.OverviewAggDO;
import iih.pi.overview.overview.d.PiPatDO;
import iih.pi.overview.overview.d.desc.PiPatDODesc;
import iih.pi.overview.overview.i.IOverviewCudService;
import iih.pi.overview.overview.i.IOverviewRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 患者临床摘要AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IOverviewCudService.class,IOverviewRService.class}, binding=Binding.JSONRPC)
public class OverviewCrudServiceImpl extends BaseAggService<OverviewAggDO,PiPatDO> implements IOverviewCudService,IOverviewRService {

	private final Integer PRECISION_YEAR=0;
	private final Integer PRECISION_MONTH=1;
	private final Integer PRECISION_DAY=2;
	
    public OverviewCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(PiPatDODesc.class),IAppFwTempTbl.tmp_iaw_05.name()); 
    }

	@Override
	public OverviewAggDO[] save(OverviewAggDO[] aggs) throws BizException {
		
		for (OverviewAggDO agg : aggs) {
			BaseDO[] children=agg.getAllChildrenDO();
			for(BaseDO c:children) {
				Object precision=c.getAttrVal("Id_ymd_act");
				if(precision!=null) {
					setDatePrecision(c,precision,"Dt_act");
					setDatePrecision(c,precision,"Dt_b");
					setDatePrecision(c,precision,"Dt_e");
				}
			}
		}
		return super.save(aggs);
	}
	
	private void setDatePrecision(BaseDO baseDo,Object precision,String field) {
		Object date=baseDo.getAttrVal(field);
		if(date!=null) {
			baseDo.setAttrVal(field, getFmtDate(precision, date));
		}
	}
	
	private FDateTime getFmtDate(Object precsion,Object date) {
		FDateTime dt=(FDateTime)date;//2016-05-16 00:00:00
		String ds=dt.toStdString();
		if(PRECISION_YEAR.equals(precsion)) {
			dt=new FDateTime(ds.substring(0,4)+"-01-01 00:00:00");
//			dt=new FDateTime(dt.getYear()+"-01-01 00:00:00");
		}else if(PRECISION_MONTH.equals(precsion)) {
			dt=new FDateTime(ds.substring(0,7)+"-01 00:00:00");
//			dt=new FDateTime(dt.getYear()+"-"+dt.getStrMonth()+"-01 00:00:00");
		}else {
			dt=new FDateTime(ds.substring(0,10)+" 00:00:00");
//			dt=new FDateTime(dt.getDate()+" 00:00:00");
		}
		return dt;
	}
}

