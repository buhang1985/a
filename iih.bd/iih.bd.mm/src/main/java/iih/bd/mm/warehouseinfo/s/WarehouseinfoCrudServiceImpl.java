package iih.bd.mm.warehouseinfo.s;

import java.util.ArrayList;
import java.util.List;

import iih.bd.mm.warehouseinfo.bp.WhmmReAfterBp;
import iih.bd.mm.warehouseinfo.d.WarehouseInfoDO;
import iih.bd.mm.warehouseinfo.d.desc.WarehouseInfoDODesc;
import iih.bd.mm.warehouseinfo.i.IWarehouseinfoCudService;
import iih.bd.mm.warehouseinfo.i.IWarehouseinfoRService;
import iih.bd.mm.warehouseinfo.s.rule.WarehouseInfoBeforeDeleteRule;
import iih.bd.mm.warehouseinfo.s.rule.WarehouseInfoBeforeUpdateRule;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.handler.AroundProcesser;
import xap.sys.appfw.bizrule.handler.CompareAroundProcesser;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 医疗物品_与仓库关系AggDO数据CRUD服务实现
 */
public class WarehouseinfoCrudServiceImpl extends BaseDOService<WarehouseInfoDO>
		implements IWarehouseinfoCudService, IWarehouseinfoRService {

	public WarehouseinfoCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(WarehouseInfoDODesc.class), IAppFwTempTbl.tmp_iaw_16.name());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addInsertBeforeRule(AroundProcesser<WarehouseInfoDO> processer) {
		super.addInsertBeforeRule(processer);
		processer.addBeforeRule(new WarehouseInfoBeforeUpdateRule());
	}

	@Override
	protected void addUpdateBeforeRule(CompareAroundProcesser<WarehouseInfoDO> processer, WarehouseInfoDO[] originvos) {
		super.addUpdateBeforeRule(processer, originvos);
		processer.addBeforeRule(new WarehouseInfoBeforeUpdateRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addLogicDeleteBeforeRule(AroundProcesser<WarehouseInfoDO> processer, int versionValidateType) {
		super.addLogicDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new WarehouseInfoBeforeDeleteRule());
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void addRealDeleteBeforeRule(AroundProcesser<WarehouseInfoDO> processer, int versionValidateType) {
		super.addRealDeleteBeforeRule(processer, versionValidateType);
		processer.addBeforeRule(new WarehouseInfoBeforeDeleteRule());
	}

	@Override
	public WarehouseInfoDO[] find(String whereStr, String orderStr, FBoolean isLazy) throws BizException {

		WarehouseInfoDO[] warehouseInfoDOs = super.find(whereStr, orderStr, isLazy);

		WhmmReAfterBp bp = new WhmmReAfterBp();
		bp.exec(warehouseInfoDOs);

		return warehouseInfoDOs;
	}

	@Override
	public WarehouseInfoDO findById(String id) throws BizException {

		WarehouseInfoDO warehouseInfoDO = super.findById(id);

		if (warehouseInfoDO == null) {

			return null;
		}

		WhmmReAfterBp bp = new WhmmReAfterBp();
		bp.exec(new WarehouseInfoDO[] { warehouseInfoDO });

		return warehouseInfoDO;
	}

	@Override
	public PagingRtnData<WarehouseInfoDO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart)
			throws BizException {

		PagingRtnData<WarehouseInfoDO> warehouseInfoDOS = super.findByPageInfo(pg, wherePart, orderByPart);
		if (warehouseInfoDOS != null && warehouseInfoDOS.getPageData().size() > 0) {

			List<WarehouseInfoDO> result = new ArrayList<WarehouseInfoDO>();
			for (Object warehouseInfoDO : warehouseInfoDOS.getPageData().toArray()) {

				result.add((WarehouseInfoDO) warehouseInfoDO);
			}

			WhmmReAfterBp bp = new WhmmReAfterBp();
			bp.exec(result.toArray(new WarehouseInfoDO[result.size()]));
		}

		return warehouseInfoDOS;
	}

	@Override
	public WarehouseInfoDO[] findByAttrValString(String attr, String value) throws BizException {
		WarehouseInfoDO[] warehouseInfoDOs = super.findByAttrValString(attr, value);

		WhmmReAfterBp bp = new WhmmReAfterBp();
		bp.exec(warehouseInfoDOs);

		return warehouseInfoDOs;
	}

	@Override
	public WarehouseInfoDO[] findByAttrValStrings(String attr, String[] values) throws BizException {
		WarehouseInfoDO[] warehouseInfoDOs = super.findByAttrValStrings(attr, values);

		WhmmReAfterBp bp = new WhmmReAfterBp();
		bp.exec(warehouseInfoDOs);

		return warehouseInfoDOs;
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
	protected Validator[] getUpdateValidator(WarehouseInfoDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
