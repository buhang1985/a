package iih.bd.mm.task;

import java.util.ArrayList;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.s.bp.UpdateMaterialSpecByMaterialsBp;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.jdbc.kernel.exception.DbException;

/**
 * 更新药品规格业务逻辑
 * 
 * @author hao_wu 2019-3-7
 *
 */
public class UpdataMaterialSpecBp {

	public void exec() throws BizException {
		MeterialDO[] materials = findMaterials();

		SqlParam[] sqlParams = getSqlParams(materials);

		batchUpdateSpec(sqlParams);
	}

	/**
	 * 查询物品列表
	 * 
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private MeterialDO[] findMaterials() throws BizException {
		String sql = getQrySql();

		DAFacade daFacade = new DAFacade();
		ArrayList<MeterialDO> materialList = (ArrayList<MeterialDO>) daFacade.execQuery(sql,
				new BeanListHandler(MeterialDO.class));
		if (materialList != null) {
			return materialList.toArray(new MeterialDO[0]);
		}
		return null;
	}

	private String getQrySql() {
		StringBuilder sqlBuilder = new StringBuilder();

		sqlBuilder.append("SELECT mm.id_mm,");
		sqlBuilder.append("mm.id_unit_weight,");
		sqlBuilder.append("pkg_weight.NAME AS weight_name,");
		sqlBuilder.append("mm.factor_wb,");
		sqlBuilder.append("mm.id_unit_volbase,");
		sqlBuilder.append("pkg_vol.NAME AS volbase_name,");
		sqlBuilder.append("mm.factor_vb,");
		sqlBuilder.append("mm.id_unit_pkgbase,");
		sqlBuilder.append("pkg_base.NAME AS pkgbase_name,");
		sqlBuilder.append("mm.id_unit_pkgsp,");
		sqlBuilder.append("pkg_sp.NAME AS pkgsp_name,");
		sqlBuilder.append("mm.factor_sb ");
		sqlBuilder.append("FROM bd_mm mm ");
		sqlBuilder.append("INNER JOIN bd_measdoc pkg_base ");
		sqlBuilder.append("ON pkg_base.id_measdoc = mm.id_unit_pkgbase ");
		sqlBuilder.append("INNER JOIN bd_measdoc pkg_sp ");
		sqlBuilder.append("ON pkg_sp.id_measdoc = mm.id_unit_pkgsp ");
		sqlBuilder.append("LEFT JOIN bd_measdoc pkg_weight ");
		sqlBuilder.append("ON pkg_weight.id_measdoc = mm.id_unit_weight ");
		sqlBuilder.append("LEFT JOIN bd_measdoc pkg_vol ");
		sqlBuilder.append("ON pkg_vol.id_measdoc = mm.id_unit_volbase ");
		return sqlBuilder.toString();
	}

	/**
	 * 获取SQL参数集合
	 * 
	 * @param materialList
	 * @return
	 * @throws BizException
	 */
	private SqlParam[] getSqlParams(MeterialDO[] materials) throws BizException {
		if (materials == null || materials.length <= 0) {
			throw new BizException("未查询到需要更新的物品数据");
		}

		buildSpec(materials);

		ArrayList<SqlParam> sqlParamList = new ArrayList<SqlParam>();
		for (MeterialDO meterialDO : materials) {
			SqlParam sqlParam = getSqlParam(meterialDO);
			sqlParamList.add(sqlParam);
		}
		return sqlParamList.toArray(new SqlParam[0]);
	}

	/**
	 * 获取SQL参数
	 * 
	 * @param meterialDO
	 * @return
	 */
	private SqlParam getSqlParam(MeterialDO meterialDO) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(meterialDO.getSpec());
		sqlParam.addParam(meterialDO.getId_mm());
		return sqlParam;
	}

	/**
	 * 构建规格
	 * 
	 * @param materials
	 */
	private void buildSpec(MeterialDO[] materials) {
		UpdateMaterialSpecByMaterialsBp bp = new UpdateMaterialSpecByMaterialsBp();
		bp.exec(materials);
	}

	/**
	 * 批量更新物品规格
	 * 
	 * @param sqlParams
	 * @throws BizException
	 */
	private void batchUpdateSpec(SqlParam[] sqlParams) throws BizException {
		String sql = getUpdateSpecSql();

		PersistMgr persist = null;
		PersistSession session = null;
		try {
			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();
			session.addBatch(sql, sqlParams);
			session.execBatch();

		} catch (DbException e) {
			throw new BizException(e);
		} finally {
			if (session != null) {
				session.closeAll();
			}
			if (persist != null) {
				persist.release();
			}
		}
	}

	/**
	 * 获取更新SQL
	 * 
	 * @return
	 */
	private String getUpdateSpecSql() {
		String sql = "update bd_mm set spec = ? where id_mm = ?";
		return sql;
	}

}
