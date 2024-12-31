package iih.bd.mm.mmintelcabinet.s;

import java.util.ArrayList;
import java.util.List;

import iih.bd.mm.mmintelcabinet.bp.MmintelReAfterBp;
import iih.bd.mm.mmintelcabinet.d.MmIntelcabinetDO;
import iih.bd.mm.mmintelcabinet.d.desc.MmIntelcabinetDODesc;
import iih.bd.mm.mmintelcabinet.i.IMmintelcabinetCudService;
import iih.bd.mm.mmintelcabinet.i.IMmintelcabinetRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.bizrule.validation.Validator;
import xap.sys.appfw.orm.desc.DescManager;
import xap.sys.appfw.orm.handle.dataobject.BaseDOService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.utils.IAppFwTempTbl;
import xap.sys.permfw.pub.BDReferenceChecker;
import xap.sys.permfw.pub.BDUniqueRuleValidate;

/**
 * 智能柜物品关系AggDO数据CRUD服务实现
 */
public class MmintelcabinetCrudServiceImpl extends BaseDOService<MmIntelcabinetDO>
		implements IMmintelcabinetCudService, IMmintelcabinetRService {
	public MmintelcabinetCrudServiceImpl() {
		super(DescManager.getInstance().getDODesc(MmIntelcabinetDODesc.class), IAppFwTempTbl.tmp_iaw_13.name());
	}

	@Override
	public MmIntelcabinetDO[] find(String whereStr, String orderStr, FBoolean isLazy) throws BizException {

		MmIntelcabinetDO[] mmIntelcabinetDOs = super.find(whereStr, orderStr, isLazy);

		MmintelReAfterBp bp = new MmintelReAfterBp();
		bp.exec(mmIntelcabinetDOs);

		return mmIntelcabinetDOs;
	}

	@Override
	public MmIntelcabinetDO findById(String id) throws BizException {

		MmIntelcabinetDO mmIntelcabinetDO = super.findById(id);
		if (mmIntelcabinetDO == null) {

			return mmIntelcabinetDO;
		}

		MmintelReAfterBp bp = new MmintelReAfterBp();
		bp.exec(new MmIntelcabinetDO[] { mmIntelcabinetDO });

		return mmIntelcabinetDO;
	}

	@Override
	public PagingRtnData<MmIntelcabinetDO> findByPageInfo(PaginationInfo pg, String wherePart, String orderByPart)
			throws BizException {

		PagingRtnData<MmIntelcabinetDO> mmIntelcabinetDOS = super.findByPageInfo(pg, wherePart, orderByPart);
		if (mmIntelcabinetDOS != null && mmIntelcabinetDOS.getPageData().size() > 0) {

			List<MmIntelcabinetDO> result = new ArrayList<MmIntelcabinetDO>();
			for (Object warehouseInfoDO : mmIntelcabinetDOS.getPageData().toArray()) {

				result.add((MmIntelcabinetDO) warehouseInfoDO);
			}

			MmintelReAfterBp bp = new MmintelReAfterBp();
			bp.exec(result.toArray(new MmIntelcabinetDO[result.size()]));
		}

		return mmIntelcabinetDOS;
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
	protected Validator[] getUpdateValidator(MmIntelcabinetDO[] oldDOs) {
		return new Validator[] { new BDUniqueRuleValidate() };
	}
}
