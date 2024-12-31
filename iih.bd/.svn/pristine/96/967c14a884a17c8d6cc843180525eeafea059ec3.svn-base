package iih.bd.pp.anhuisrvorca.s.bp.sql;

import iih.bd.pp.anhuisrvorca.d.TreatCompDTO;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 保存医保诊疗和服务设施对照SQL
 * 
 * @author hao_wu
 *
 */
public class SaveInsurZlAndFwssCompSql implements ITransQry {

	private TreatCompDTO _treatCompDTO;

	public SaveInsurZlAndFwssCompSql(TreatCompDTO treatCompDTO) {
		this._treatCompDTO = treatCompDTO;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._treatCompDTO.getId_hp());
		if (HpSrvTpEnum.FWSS.equals(this._treatCompDTO.getEu_hpsrvtp()) && this._treatCompDTO.getCode().endsWith("-F")) {
			sqlParam.addParam(this._treatCompDTO.getCode().substring(0, this._treatCompDTO.getCode().length() - 2));
		} else {
			sqlParam.addParam(this._treatCompDTO.getCode());
		}

		sqlParam.addParam(this._treatCompDTO.getName());
		sqlParam.addParam(this._treatCompDTO.getEu_hpsrvtp());
		sqlParam.addParam(HpStatusEnum.CONTRAST);
		sqlParam.addParam(this._treatCompDTO.getId_hpsrvorca());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = "UPDATE BD_HP_SRVORCA SET ID_HP = ?, CODE = ?, NAME = ?, EU_HPSRVTP = ?, EU_STATUS = ? WHERE ID_HPSRVORCA = ?";
		return sql;
	}
}
