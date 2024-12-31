package iih.bd.srv.s.bp.qry;

import iih.bd.srv.emrterm.d.EmrEvent4TermDO;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据病例录入事件获取相关联的辅助录入组件
 * @author hums
 *
 */
public class GetEmrTermCompQry implements ITransQry {

	private EmrEvent4TermDO emrEvent4Term;

	public GetEmrTermCompQry(EmrEvent4TermDO emrEvent4Term) {
		this.emrEvent4Term = emrEvent4Term;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();
		param.addParam(emrEvent4Term.getId_mraet());

		// 可使用标识_门诊
		if (emrEvent4Term.getFg_entp_op() == FBoolean.TRUE) {
			param.addParam(FBoolean.TRUE);
		}
		// 可使用标识_住院
		if (emrEvent4Term.getFg_entp_ip() == FBoolean.TRUE) {
			param.addParam(FBoolean.TRUE);
		}
		// 可使用标识_急诊
		if (emrEvent4Term.getFg_entp_er() == FBoolean.TRUE) {
			param.addParam(FBoolean.TRUE);
		}
		// 可使用标识_体检
		if (emrEvent4Term.getFg_entp_pe() == FBoolean.TRUE) {
			param.addParam(FBoolean.TRUE);
		}
		// 可使用标识_家床
		if (emrEvent4Term.getFg_entp_fm() == FBoolean.TRUE) {
			param.addParam(FBoolean.TRUE);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {

		// 拼接术语查询语句
		StringBuffer buffer = new StringBuffer();
		buffer.append("select comp.* from bd_mra_comp comp ,bd_mra_etcomp_rel rel where ");
		buffer.append(" comp.id_mracomp = rel.id_mracomp");
		buffer.append(" and rel.id_mraet = ?");

		// 可使用标识_门诊
		if (emrEvent4Term.getFg_entp_op() == FBoolean.TRUE) {
			buffer.append(" and comp.fg_entp_op = ?");
		}
		// 可使用标识_住院
		if (emrEvent4Term.getFg_entp_ip() == FBoolean.TRUE) {
			buffer.append(" and comp.fg_entp_ip = ?");
		}
		// 可使用标识_急诊
		if (emrEvent4Term.getFg_entp_er() == FBoolean.TRUE) {
			buffer.append(" and comp.fg_entp_er = ?");
		}
		// 可使用标识_体检
		if (emrEvent4Term.getFg_entp_pe() == FBoolean.TRUE) {
			buffer.append(" and comp.fg_entp_pe = ?");
		}
		// 可使用标识_家床
		if (emrEvent4Term.getFg_entp_fm() == FBoolean.TRUE) {
			buffer.append(" and comp.fg_entp_fm = ?");
		}
		return buffer.toString();
	}

}
