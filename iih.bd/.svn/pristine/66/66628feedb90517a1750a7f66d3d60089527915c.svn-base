package iih.bd.pp.anhuisrvorca.s.bp.sql;

import iih.bd.pp.anhuisrvorca.d.DrugCompDTO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 保存医保药品目录对照Sql
 * 
 * @author hao_wu
 *
 */
public class SaveInsurDrugCompSql implements ITransQry {

	private DrugCompDTO _drugCompDTO;

	public SaveInsurDrugCompSql(DrugCompDTO drugCompDTO) {
		this._drugCompDTO = drugCompDTO;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._drugCompDTO.getId_hp());
		sqlParam.addParam(this._drugCompDTO.getCode());
		sqlParam.addParam(this._drugCompDTO.getName());
		sqlParam.addParam(HpStatusEnum.CONTRAST);
		sqlParam.addParam(this._drugCompDTO.getId_hpsrvorca());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = "UPDATE BD_HP_SRVORCA SET ID_HP = ?, CODE = ?, NAME = ?, EU_STATUS = ? WHERE ID_HPSRVORCA = ?";
		return sql;
	}
}
