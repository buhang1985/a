package iih.bd.pp.incca.s;

import java.util.ArrayList;
import java.util.List;

import iih.bd.pp.incca.bp.InccaBp;
import iih.bd.pp.incca.d.IncCaDO;
import iih.bd.pp.incca.d.IncCaItmDO;
import iih.bd.pp.incca.d.InccaAggDO;
import iih.bd.pp.incca.d.desc.IncCaDODesc;
import iih.bd.pp.incca.i.IInccaCudService;
import iih.bd.pp.incca.i.IInccaRService;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.agg.BaseAggService;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 票据分类AggDO数据CRUD服务实现
 */
@Service(serviceInterfaces = { IInccaCudService.class, IInccaRService.class }, binding = Binding.JSONRPC)
public class InccaCrudServiceImpl extends BaseAggService<InccaAggDO, IncCaDO> implements IInccaCudService, IInccaRService {

	public InccaCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(IncCaDODesc.class), IAppFwTempTbl.tmp_iaw_02.name());
	}

	@Override
	protected Validator[] getInsertValidator() {
		return new Validator[] { new BDUniqueRuleValidate(), };
	}

	@Override
	protected Validator[] getUpdateValidator(InccaAggDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}

	
//	@Override
//	protected Validator[] getDeleteValidator() {
//		return new Validator[] { AggBDReferenceChecker.getInstance() };
//	}


	/**
	 * 保存时添加发送事件
	 */
	// @Override
	// public InccaAggDO[] save(InccaAggDO[] aggs) throws BizException {
	// InccaAggDO[] inccaAggDOArr = super.save(aggs);
	// InccaBp inccaBp = new InccaBp();
	// inccaBp.invokeEvent(aggs[0]);
	// return inccaAggDOArr;
	// }

	/**
	 * 删除时添加发送事件
	 */
	@Override
	public void delete(InccaAggDO[] aggs) throws BizException {
		super.delete(aggs);
		InccaBp inccaBp = new InccaBp();
		inccaBp.invokeDeleteEvent(aggs[0]);
	}

	/**
	 * 新增时添加发送事件
	 */
	@Override
	public InccaAggDO[] insert(InccaAggDO[] arg0) throws BizException {
		InccaAggDO[] inccaAggDOArr = super.insert(arg0);
		InccaBp inccaBp = new InccaBp();
		inccaBp.invokeInsertEvent(arg0[0]);
		return inccaAggDOArr;
	}

	/**
	 * 修改时添加发送事件
	 */
	@Override
	public InccaAggDO[] update(InccaAggDO[] aggs) throws BizException {
		IncCaDO incCaDO = aggs[0].getParentDO();
		IncCaItmDO[] incCaItmDOArr = aggs[0].getIncCaItmDO();

		List<IncCaItmDO> inList = new ArrayList<IncCaItmDO>();
		List<IncCaItmDO> upList = new ArrayList<IncCaItmDO>();
		List<IncCaItmDO> deList = new ArrayList<IncCaItmDO>();
		InccaBp inccaBp = new InccaBp();
		if (incCaItmDOArr != null && incCaItmDOArr.length > 0) {
			inccaBp.distinctUpdateData(incCaItmDOArr, inList, upList, deList);
		}

		InccaAggDO[] inccaAggDOArr = super.update(aggs);

		if (incCaItmDOArr != null && incCaItmDOArr.length > 0) {
			inccaBp.invokeUpdateEvent(incCaDO, inList, upList, deList);
		}

		return inccaAggDOArr;
	}

}
