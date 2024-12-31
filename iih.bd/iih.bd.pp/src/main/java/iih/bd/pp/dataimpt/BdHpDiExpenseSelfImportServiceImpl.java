package iih.bd.pp.dataimpt;

import iih.bd.dataimport.BDBaseDataImport;
import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import iih.bd.pp.hpdiexpenseself.i.IHpdiexpenseselfCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医保自费诊断导入服务
 * 
 * @author hao_wu
 *
 */
public class BdHpDiExpenseSelfImportServiceImpl extends BDBaseDataImport<BdHpDiExpenseSelfDO> {

	@Override
	protected BaseDO getDoInstance() {
		return new BdHpDiExpenseSelfDO();
	}

	@Override
	protected String[] getCheckNullProps() {
		return new String[] { BdHpDiExpenseSelfDO.ID_HPDIEXPENSESELF, BdHpDiExpenseSelfDO.ID_HP,
				BdHpDiExpenseSelfDO.ID_GRP, BdHpDiExpenseSelfDO.ID_ORG, BdHpDiExpenseSelfDO.ID_DIDEF };
	}

	@Override
	protected void checkNotNullProp(BdHpDiExpenseSelfDO[] importData) throws BizException {
		super.checkNotNullProp(importData);

		for (BdHpDiExpenseSelfDO bdHpDiExpenseSelfDO : importData) {
			if (!FBoolean.TRUE.equals(bdHpDiExpenseSelfDO.getFg_entp_er())
					&& !FBoolean.TRUE.equals(bdHpDiExpenseSelfDO.getFg_entp_op())
					&& !FBoolean.TRUE.equals(bdHpDiExpenseSelfDO.getFg_entp_ip())
					&& !FBoolean.TRUE.equals(bdHpDiExpenseSelfDO.getFg_entp_fm())
					&& !FBoolean.TRUE.equals(bdHpDiExpenseSelfDO.getFg_entp_pe())) {
				String msg = String.format("诊断\"%s\"的标识都为空。", bdHpDiExpenseSelfDO.getId_didef());
				throw new BizException(msg);
			}
		}
	}

	@Override
	protected void insertToDB(BdHpDiExpenseSelfDO[] importDatas) throws BizException {
		ServiceFinder.find(IHpdiexpenseselfCudService.class).insert(importDatas);
	}

	@Override
	protected void updateToDB(BdHpDiExpenseSelfDO[] importDatas) throws BizException {
		ServiceFinder.find(IHpdiexpenseselfCudService.class).update(importDatas);
	}
}
