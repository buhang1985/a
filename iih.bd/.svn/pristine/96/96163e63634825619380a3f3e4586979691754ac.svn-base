package iih.bd.pp.anhuisrvorca.s.bp.sql;

import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 保存医保诊疗目录对照SQL
 * 
 * @author hao_wu
 *
 */
public class SaveInsurZlCompSql implements ITransQry {

	private TreatCompDTO _treatCompDTO;

	public SaveInsurZlCompSql(TreatCompDTO treatCompDTO) {
		this._treatCompDTO = treatCompDTO;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._treatCompDTO.getId_hp());
		sqlParam.addParam(this._treatCompDTO.getCode());
		sqlParam.addParam(this._treatCompDTO.getName());
		sqlParam.addParam(HpStatusEnum.CONTRAST);
		sqlParam.addParam(this._treatCompDTO.getId_hpsrvorca());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = "UPDATE BD_HP_SRVORCA SET ID_HP = ?, CODE = ?, NAME = ?, EU_STATUS = ? WHERE ID_HPSRVORCA = ?";
		return sql;
	}
}
