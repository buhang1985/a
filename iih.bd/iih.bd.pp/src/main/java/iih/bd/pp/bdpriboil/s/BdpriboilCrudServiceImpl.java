package iih.bd.pp.bdpriboil.s;
import iih.bd.pp.bdpriboil.d.BdPriBoilDO;
import iih.bd.pp.bdpriboil.d.desc.BdPriBoilDODesc;
import iih.bd.pp.bdpriboil.i.IBdpriboilCudService;
import iih.bd.pp.bdpriboil.i.IBdpriboilRService;
import iih.bd.pp.s.bp.CommUpdateSrvPriBp;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;


/**
 * 煎法下费用项目对照AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces={IBdpriboilCudService.class,IBdpriboilRService.class}, binding=Binding.JSONRPC)
public class BdpriboilCrudServiceImpl extends BaseDOService<BdPriBoilDO> implements IBdpriboilCudService,IBdpriboilRService {

    public BdpriboilCrudServiceImpl() {
        super(DescManager.getInstance().getDODesc(BdPriBoilDODesc.class),IAppFwTempTbl.tmp_iaw_06.name()); 
    }
    
    @Override
   	protected Validator[] getInsertValidator() {
   		return new Validator[] { new BDUniqueRuleValidate(), };
   	}

   	@Override
   	protected Validator[] getUpdateValidator(BdPriBoilDO[] oldDOs) {
   		return new Validator[] { new BDUniqueRuleValidate() };
   	}
   	@Override
   	protected Validator[] getDeleteValidator() {
   		return new Validator[] { BDReferenceChecker.getInstance() };
   	}
   	
   	@Override
	public BdPriBoilDO[] find(String whereStr, String orderStr, FBoolean isLazy) throws BizException {
   		BdPriBoilDO[] rtn = super.find(whereStr, orderStr, isLazy);
		updatePri(rtn);
		return rtn;
	}

	@Override
	public BdPriBoilDO[] findByAttrValString(String attr, String value) throws BizException {
		BdPriBoilDO[] rtn = super.findByAttrValString(attr, value);
		updatePri(rtn);
		return rtn;
	}

	/**
	 * 更新价格信息
	 * 
	 * @param rtn
	 * @throws BizException
	 */
	private void updatePri(BdPriBoilDO[] rtn) throws BizException {
		CommUpdateSrvPriBp bp = new CommUpdateSrvPriBp();
		bp.exec(rtn, BdPriBoilDO.ID_SRV, BdPriBoilDO.PRI_STD);
	}
}

