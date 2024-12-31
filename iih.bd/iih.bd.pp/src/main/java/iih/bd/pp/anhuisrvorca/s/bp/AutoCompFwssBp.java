package iih.bd.pp.anhuisrvorca.s.bp;

import java.util.ArrayList;

import iih.bd.pp.anhuisrvorca.s.bp.sql.AutoCompFwssSql;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 自动对照服务设施目录业务逻辑
 * 
 * @author hao_wu
 *
 */
public class AutoCompFwssBp {
	public void exec(String hpCode) throws BizException {
		String hpId = GetHpId(hpCode);
		DeleteNoMatchedData(hpId);
		String[] pks = AutoCompFwss(hpId);
		SyncInsurFwssData(hpId, pks);
		AutoGenerateSrvctr(hpId);
	}

	/**
	 * 获取医保计划主键
	 * 
	 * @param hpCode
	 * @return
	 * @throws BizException
	 */
	private String GetHpId(String hpCode) throws BizException {
		FindHpDoByCodeBp bp = new FindHpDoByCodeBp();
		HPDO hpdo = bp.exec(hpCode);
		return hpdo.getId_hp();
	}

	/**
	 * 自动生成医保计划控制策略
	 * 
	 * @throws BizException
	 */
	private void AutoGenerateSrvctr(String hpId) throws BizException {
		AutoGenerateSrvctrBp bp = new AutoGenerateSrvctrBp();
		bp.exec(hpId, HpSrvTpEnum.FWSS);
	}

	/**
	 * 删除未匹配数据
	 * 
	 * @throws BizException
	 */
	private void DeleteNoMatchedData(String hpId) throws BizException {
		DeleteNoMatchedDataBp bp = new DeleteNoMatchedDataBp();
		bp.exec(hpId, HpSrvTpEnum.FWSS);
	}

	/**
	 * 同步医保服务设施数据
	 * 
	 * @throws BizException
	 */
	private void SyncInsurFwssData(String hpId, String[] pks) throws BizException {
		SyncInsurFwssDataBp bp = new SyncInsurFwssDataBp();
		bp.exec(hpId, pks);
	}

	@SuppressWarnings("unchecked")
	private String[] AutoCompFwss(String hpId) throws BizException {
		DAFacade daFacade = new DAFacade();
		AutoCompFwssSql sql = new AutoCompFwssSql(hpId);
		ArrayList<HPSrvorcaDO> hpSrvorcaDOList = (ArrayList<HPSrvorcaDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(HPSrvorcaDO.class));
		String[] pks = daFacade.insertDOs(hpSrvorcaDOList.toArray(new HPSrvorcaDO[0]));
		return pks;
	}
}
