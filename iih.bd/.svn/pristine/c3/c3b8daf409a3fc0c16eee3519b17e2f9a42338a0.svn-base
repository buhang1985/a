package iih.bd.pp.bdhpspec.s.bp;

import java.util.ArrayList;

import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang.StringUtils;

import iih.bd.pp.bdhpspec.d.BdHpSpecDO;
import iih.bd.pp.bdhpspec.d.BdHpSpecDrugDO;
import iih.bd.pp.bdhpspec.d.BdhpspecAggDO;
import iih.bd.pp.bdhpspec.s.bp.sql.FindBdHpSpecDrugSql;
import iih.bd.pp.bdhpspec.s.bp.sql.FindBdHpSpecSql;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 使用主键查询医保特殊病信息业务逻辑
 * 
 * @author hao_wu
 *
 */
public class FindByIdBp {

	public BdhpspecAggDO exec(String specId) throws BizException {
		if (StringUtils.isEmpty(specId)) {
			throw new NullArgumentException("pk");
		}

		BdhpspecAggDO bdhpspecAggDO = new BdhpspecAggDO();
		BdHpSpecDO bdHpSpecDO = FindBdHpSpec(specId);
		bdhpspecAggDO.setParentDO(bdHpSpecDO);
		BdHpSpecDrugDO[] bdHpSpecDrugDOs = FindBdHpSpecDrugs(specId);
		bdhpspecAggDO.setBdHpSpecDrugDO(bdHpSpecDrugDOs);

		return bdhpspecAggDO;
	}

	/**
	 * 医保计划特殊病药品列表
	 * 
	 * @param specId
	 * @return
	 * @throws BizException
	 */
	private BdHpSpecDrugDO[] FindBdHpSpecDrugs(String specId) throws BizException {
		String wherePart = String.format("Id_hpspec = '%s'", specId);
		FindBdHpSpecDrugSql sql = new FindBdHpSpecDrugSql(wherePart);
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		ArrayList<BdHpSpecDrugDO> dataList = (ArrayList<BdHpSpecDrugDO>) daFacade.execQuery(sql.getQrySQLStr(),
				sql.getQryParameter(null), new BeanListHandler(BdHpSpecDrugDO.class));
		if (dataList != null) {
			return dataList.toArray(new BdHpSpecDrugDO[0]);
		}
		return null;
	}

	/**
	 * 查询医保特殊病主DO
	 * 
	 * @param pk
	 * @return
	 * @throws BizException
	 */
	private BdHpSpecDO FindBdHpSpec(String pk) throws BizException {
		String wherePart = String.format("Id_hpspec = '%s'", pk);
		FindBdHpSpecSql sql = new FindBdHpSpecSql(wherePart);
		DAFacade daFacade = new DAFacade();
		BdHpSpecDO bdHpSpecDO = (BdHpSpecDO) daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null),
				new BeanHandler(BdHpSpecDO.class));
		return bdHpSpecDO;
	}

}
