package iih.bl.pay.blpaypat.s;
import org.apache.commons.lang.StringUtils;

import iih.bl.pay.blpaypat.bp.BlPaypatRExtBp;
import iih.bl.pay.blpaypat.bp.FindByDtoPageInfoBp;
import iih.bl.pay.blpaypat.bp.FindByPageInfoBp;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.d.desc.BlPrePayPatDODesc;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
import iih.bl.pay.blpaypat.i.IBlpaypatRService;
import iih.bl.pay.blpaypat.s.rule.SavePrepayAccAfterInsertRule;
import iih.bl.pay.dto.blprepaydto.d.BlPrepayDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;


/**
 * 医疗费用_收付款_患者AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBlpaypatCudService.class,IBlpaypatRService.class}, binding=Binding.JSONRPC)
public class BlpaypatCrudServiceImpl extends BaseDOService<BlPrePayPatDO> implements IBlpaypatCudService,IBlpaypatRService {

    public BlpaypatCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BlPrePayPatDODesc.class),IAppFwTempTbl.tmp_iaw_27.name()); 
    }
    
    @Override
    public BlPrePayPatDO[] find(String whereStr, String orderStr, FBoolean isLazy) throws BizException {
    	// TODO Auto-generated method stub
    	//return super.find(whereStr, orderStr, isLazy);
    	BlPaypatRExtBp bp=new BlPaypatRExtBp();
    	return bp.exec(whereStr, orderStr, isLazy);
    }
    @Override
    public PagingRtnData<BlPrePayPatDO> findByPageInfo(PaginationInfo pg, String whereStr, String orderStr) throws BizException {
    	FindByPageInfoBp bp=new FindByPageInfoBp();
    	return bp.exec(pg, whereStr, orderStr);
    }

	@Override
	public PagingRtnData<BlPrepayDTO> findDtoByPageInfo(PaginationInfo pg, String whereStr, String orderStr)
			throws BizException {
		FindByDtoPageInfoBp bp=new FindByDtoPageInfoBp();
		String Sd_cctp = !StringUtils.isBlank(whereStr) && whereStr.contains("a0.SD_PAYTP  in ('11' )") ? "02" :"10";
    	return bp.exec(pg,Sd_cctp, whereStr, orderStr);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<BlPrePayPatDO> processor) {
		super.addInsertAfterRule(processor);
		processor.addAfterRule(new SavePrepayAccAfterInsertRule());
	}
}

