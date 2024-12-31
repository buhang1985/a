package iih.ci.ord.s.bp.qry;

import iih.bd.base.utils.SqlUtils;
import iih.ci.ord.cior.d.CiOrLastMpDTO;
import xap.sie.common.utils.StringUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiOrLastMpJudgeQry implements ITransQry {

	private CiOrLastMpDTO[] _param;

	public CiOrLastMpJudgeQry(CiOrLastMpDTO[] param) {
		this._param = param;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		for (CiOrLastMpDTO param : _param) {
			if(!StringUtils.isEmpty(param.getId_or())){
				sqlpram.addParam(param.getId_or());
			}
		}
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}

	/**
	 * 获得查询sql串
	 * 
	 * @return
	 */
	private String getSql() {

		StringBuffer sqlStr = new StringBuffer();

		sqlStr.append(" select A.id_or,A.code_entp,A.fg_long,A.sd_srvtp,A.id_freq,B.Sd_Frequnitct as sd_frequnit,");
		sqlStr.append(" B.frequnitct,B.freqct,A.dt_effe,A.dt_end,null as dt_mp_plan,3 as eu_last,A.fg_pres_outp");
		sqlStr.append(" from ci_order A left outer join bd_freq B ON A.Id_Freq=B.Id_Freq");
		sqlStr.append(" where  ");
		sqlStr.append(SqlUtils.getInSqlByParamValues(" A.id_or", getIdOrSQlStr()));

		return sqlStr.toString();

		// return
		// " select A.id_or,A.code_entp,A.fg_long,A.sd_srvtp,A.id_freq,B.Sd_Frequnitct as sd_frequnit, "
		// +
		// " B.frequnitct,B.freqct,A.dt_effe,A.dt_end,null as dt_mp_plan,3 as eu_last,A.fg_pres_outp "
		// + " from ci_order A left outer join bd_freq B ON A.Id_Freq=B.Id_Freq"
		// + " where A.id_or "
		// + getIdOrSQlStr();
	}

	private String[] getIdOrSQlStr() {
        String[] Ids = new String[_param.length];
		int i =0;
		for (CiOrLastMpDTO param : _param) {
			  Ids[i] =param.getId_or();
			  i++;
		    }
         return Ids;
	   }
}
