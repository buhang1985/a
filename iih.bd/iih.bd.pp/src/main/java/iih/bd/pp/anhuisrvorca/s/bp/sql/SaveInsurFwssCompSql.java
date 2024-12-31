package iih.bd.pp.anhuisrvorca.s.bp.sql;

import iih.bd.pp.anhuisrvorca.d.FwssCompDTO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 保存医保服务设施目录对照SQL
 * 
 * @author hao_wu
 *
 */
public class SaveInsurFwssCompSql implements ITransQry {

	private FwssCompDTO _fwssCompDTO;

	public SaveInsurFwssCompSql(FwssCompDTO fwssCompDTO) {
		this._fwssCompDTO = fwssCompDTO;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._fwssCompDTO.getId_srv());
		sqlParam.addParam(HpStatusEnum.CONTRAST);
		sqlParam.addParam(this._fwssCompDTO.getId_hpsrvorca());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = "UPDATE BD_HP_SRVORCA SET ID_SRV = ?, EU_STATUS = ? WHERE ID_HPSRVORCA = ?";
		return sql;
	}
}
