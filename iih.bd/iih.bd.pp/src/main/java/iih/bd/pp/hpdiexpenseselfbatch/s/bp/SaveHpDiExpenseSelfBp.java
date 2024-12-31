package iih.bd.pp.hpdiexpenseselfbatch.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpdiexpenseself.d.BdHpDiExpenseSelfDO;
import iih.bd.pp.hpdiexpenseself.i.IHpdiexpenseselfCudService;
import iih.bd.pp.hpdiexpenseselfbatch.s.bp.sql.FindBdHpDiExpenseSelfSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 保存医保计划自费诊断业务逻辑
 * 
 * @author hao_wu
 *
 */
public class SaveHpDiExpenseSelfBp {

	public BdHpDiExpenseSelfDO[] exec(BdHpDiExpenseSelfDO[] bdHpDiExpenseSelfDOs, HPDO hpdo) throws BizException {
		if (bdHpDiExpenseSelfDOs == null) {
			return null;
		}
		BdHpDiExpenseSelfDO[] result = SaveHpDiExpenseSelf(bdHpDiExpenseSelfDOs, hpdo);

		return result;
	}

	/**
	 * 保存医保计划自费诊断
	 * 
	 * @param bdHpDiExpenseSelfDOs
	 * @return
	 * @throws BizException
	 */
	private BdHpDiExpenseSelfDO[] SaveHpDiExpenseSelf(BdHpDiExpenseSelfDO[] bdHpDiExpenseSelfDOs, HPDO hpdo)
			throws BizException {
		UpdateStatus(bdHpDiExpenseSelfDOs, hpdo);
		BdHpDiExpenseSelfDO[] result = SaveData(bdHpDiExpenseSelfDOs, hpdo);
		return result;
	}

	/**
	 * 保存数据
	 * 
	 * @param bdHpDiExpenseSelfDOs
	 * @return
	 * @throws BizException
	 */
	private BdHpDiExpenseSelfDO[] SaveData(BdHpDiExpenseSelfDO[] bdHpDiExpenseSelfDOs, HPDO hpdo) throws BizException {
		IHpdiexpenseselfCudService hpdiexpenseselfCudService = ServiceFinder.find(IHpdiexpenseselfCudService.class);
		hpdiexpenseselfCudService.save(bdHpDiExpenseSelfDOs);
		BdHpDiExpenseSelfDO[] result = GetNewData(bdHpDiExpenseSelfDOs, hpdo);
		return result;
	}

	/**
	 * 获取保存后的新数据
	 * 
	 * @param bdHpDiExpenseSelfDOs
	 * @return
	 * @throws BizException
	 */
	private BdHpDiExpenseSelfDO[] GetNewData(BdHpDiExpenseSelfDO[] bdHpDiExpenseSelfDOs, HPDO hpdo)
			throws BizException {
		String[] diDefIdArr = GetDiDefIdArr(bdHpDiExpenseSelfDOs);
		String wherePart = SqlUtils.getInSqlByIds(BdHpDiExpenseSelfDO.ID_DIDEF, diDefIdArr);
		FindBdHpDiExpenseSelfSql sql = new FindBdHpDiExpenseSelfSql(hpdo.getId_hp(), wherePart);

		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<BdHpDiExpenseSelfDO> dataList = (ArrayList<BdHpDiExpenseSelfDO>) daFacade.execQuery(
				sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(BdHpDiExpenseSelfDO.class));
		return dataList.toArray(new BdHpDiExpenseSelfDO[0]);
	}

	/**
	 * 获取疾病诊断主键数组
	 * 
	 * @param bdHpDiExpenseSelfDOs
	 * @return
	 */
	private String[] GetDiDefIdArr(BdHpDiExpenseSelfDO[] bdHpDiExpenseSelfDOs) {
		ArrayList<String> diDefIdList = new ArrayList<String>();
		for (BdHpDiExpenseSelfDO bdHpDiExpenseSelfDO : bdHpDiExpenseSelfDOs) {
			diDefIdList.add(bdHpDiExpenseSelfDO.getId_didef());
		}
		return diDefIdList.toArray(new String[0]);
	}

	/**
	 * 更新数据状态
	 * 
	 * @param bdHpDiExpenseSelfDOs
	 */
	private void UpdateStatus(BdHpDiExpenseSelfDO[] bdHpDiExpenseSelfDOs, HPDO hpdo) {
		for (BdHpDiExpenseSelfDO bdHpDiExpenseSelfDO : bdHpDiExpenseSelfDOs) {
			UpdateStatus(bdHpDiExpenseSelfDO);
			bdHpDiExpenseSelfDO.setId_hp(hpdo.getId_hp());
		}
	}

	/**
	 * 更新数据状态
	 * 
	 * @param bdHpDiExpenseSelfDO
	 */
	private void UpdateStatus(BdHpDiExpenseSelfDO bdHpDiExpenseSelfDO) {
		boolean hasPk = StringUtils.isNotEmpty(bdHpDiExpenseSelfDO.getId_hpdiexpenseself());
		boolean hasValue = FBoolean.TRUE.equals(bdHpDiExpenseSelfDO.getFg_entp_op())
				|| FBoolean.TRUE.equals(bdHpDiExpenseSelfDO.getFg_entp_er())
				|| FBoolean.TRUE.equals(bdHpDiExpenseSelfDO.getFg_entp_ip())
				|| FBoolean.TRUE.equals(bdHpDiExpenseSelfDO.getFg_entp_pe())
				|| FBoolean.TRUE.equals(bdHpDiExpenseSelfDO.getFg_entp_fm());
		if (hasValue && !hasPk) {
			bdHpDiExpenseSelfDO.setStatus(DOStatus.NEW);
		} else if (hasValue && hasPk) {
			bdHpDiExpenseSelfDO.setStatus(DOStatus.UPDATED);
		} else if (!hasValue && hasPk) {
			bdHpDiExpenseSelfDO.setStatus(DOStatus.DELETED);
		} else {
			bdHpDiExpenseSelfDO.setStatus(DOStatus.UNCHANGED);
		}
	}
}
