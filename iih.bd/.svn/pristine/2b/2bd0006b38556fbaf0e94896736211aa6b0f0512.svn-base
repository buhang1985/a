package iih.bd.res.warehouse.s;

import iih.bd.res.warehouse.d.WarehouseDO;
import iih.bd.res.warehouse.d.desc.WarehouseDODesc;
import iih.bd.res.warehouse.i.IWarehouseCudService;
import iih.bd.res.warehouse.i.IWarehouseRService;
import iih.bd.res.warehouse.i.IWarehouseRWithDataperService;
import iih.bd.res.warehouse.s.rule.DeptUniqueRule;
import iih.bd.res.warehouse.s.rule.WarehouseDeleteRule;
import iih.bd.res.warehouse.s.rule.WarehouseSaveRule;
import iih.bd.res.warehouse.s.rule.WarehouseUpdateRule;
import iih.bd.res.warehouse.util.WhDataperUtil;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.TreeBaseDOService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 仓库AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IWarehouseCudService.class, IWarehouseRService.class,IWarehouseRWithDataperService.class }, binding = Binding.JSONRPC)
public class WarehouseCrudServiceImpl extends TreeBaseDOService<WarehouseDO>
		implements IWarehouseCudService, IWarehouseRService, IWarehouseRWithDataperService {

	public WarehouseCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(WarehouseDODesc.class), IAppFwTempTbl.tmp_iaw_13.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<WarehouseDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new DeptUniqueRule());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertAfterRule(AroundProcesser<WarehouseDO> processer) {
		super.addInsertAfterRule(processer);
		processer.addAfterRule(new WarehouseSaveRule());
	}

	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<WarehouseDO> processer, WarehouseDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new WarehouseUpdateRule());
		processer.addBeforeRule(new DeptUniqueRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteBeforeRule(AroundProcesser<WarehouseDO> processor, int versionValidateType) {
		super.addLogicDeleteBeforeRule(processor, versionValidateType);
		processor.addBeforeRule(new WarehouseDeleteRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteBeforeRule(AroundProcesser<WarehouseDO> processor, int versionValidateType) {
		super.addRealDeleteBeforeRule(processor, versionValidateType);
		processor.addBeforeRule(new WarehouseDeleteRule());
	}

	@Override
	protected Validator[] getDeleteValidator() {
		return new Validator[] { BDReferenceChecker.getInstance() };
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	@Override
	protected Validator[] getUpdateValidator(WarehouseDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
	
	/**
	 * 根据condition条件查找仓库数据集合(数据权限)
	 */
	@Override
	public WarehouseDO[] findByDataper(String whereStr,String orderStr, FBoolean isLazy) throws BizException{
		
		String dataperSql = WhDataperUtil.getDataperSql(Context.get().getUserId(), FBoolean.TRUE);
		if(!StringUtil.isEmpty(dataperSql)){
			if(!StringUtil.isEmpty(whereStr)){
				whereStr += " and (" + dataperSql + ") ";
			}else{
				whereStr = dataperSql;
			}
		}
		
		return find(whereStr, orderStr, isLazy);
	}
}
