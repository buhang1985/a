package iih.sc.sch.s.bp.qry;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.pub.ScGroupControlUtils;
import iih.sc.sch.scsch.d.ScSchDO;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 *  医技排班管理扼要信息
 * @author Sarah,yanglu
 *
 */
public class GetAllMtSchMgr4SingleSql implements ITransQry {

	private FDate Dt_b;
	private String DepId;
	private String ScresId;
	private String SrvId;
	private String Sd_sctp;
	public GetAllMtSchMgr4SingleSql(FDate dt_b, String depId, String scresId, String srvId,String sd_sctp) {
		this.Dt_b = dt_b;
		this.DepId = depId;
		this.ScresId = scresId;
		this.SrvId = srvId;
		this.Sd_sctp = sd_sctp;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		//param.addParam(Dt_b);
		param.addParam(DepId);
		param.addParam(Sd_sctp);
		param.addParam(IScDictCodeConst.EU_EDIT_TP_OTHER);
		if (!StringUtil.isEmptyWithTrim(SrvId)) {
			param.addParam(SrvId);
		}
		if (!StringUtil.isEmptyWithTrim(ScresId)) {
			param.addParam(ScresId);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("select ");
		sb.append("sch.id_sch,");
		sb.append("sch.d_sch,");
		sb.append("sch.sd_tickmd,");
		sb.append("srv.id_scsrv,");
		sb.append("srv.name name_srv,");
		sb.append("res.id_scres,");
		sb.append("res.name name_res,");
		sb.append("dl.id_dayslot,");
		sb.append("dl.name name_dayslot,");
		sb.append("sch.scpolcn,");
		sb.append("sch.quan_total,");
		sb.append("sch.quan_total_chkin,");
		sb.append("sch.quan_total_appt,");
		sb.append(" sch.t_b_acpt,");
		sb.append("sch.t_e_acpt,");
		sb.append("sch.fg_active, ");
		sb.append("pl.id_queben, ");
		sb.append("ben.name as name_queben, ");
		sb.append("sch.id_scca ");
		sb.append("from ");
		sb.append("sc_sch sch ");
		sb.append("left outer join sc_pl pl on sch.id_scpl = pl.id_scpl and pl.ds = 0 ");
		sb.append("left outer join sc_res res on res.id_scres = pl.id_scres and res.ds = 0 ");
		sb.append("left outer join sc_srv srv on srv.id_scsrv = pl.id_scsrv and srv.ds = 0 ");
		sb.append("left outer join bd_dayslot dl on dl.id_dayslot = sch.id_dayslot ");
		sb.append("left outer join bd_que_ben ben on pl.id_queben = ben.id_queben ");
		sb.append("where ");
		sb.append("sch.ds = 0 ");
		//sb.append("and sch.d_sch >=? ");
		sb.append("and pl.id_dep =? ");
		sb.append(" and pl.sd_sctp =?");
		sb.append(" and pl.eu_edit_tp =?");
		if (!StringUtil.isEmptyWithTrim(SrvId)) {
			sb.append("and pl.id_scsrv =? ");
		}
		if (!StringUtil.isEmptyWithTrim(ScresId)) {
			sb.append("and pl.id_scres =? ");
		}	
		sb.append(" and");
		String str = ScGroupControlUtils.getGroupControlFitler(new ScSchDO(), "sch");
		sb.append(str);
		sb.append(" order by sch.d_sch desc");
		return sb.toString();
	}

}
