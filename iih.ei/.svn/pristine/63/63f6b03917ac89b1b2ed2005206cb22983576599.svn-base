package iih.ei.std.s.v1.bp.mp.pivas.qry;

import iih.ei.std.d.v1.mp.pivasdata.d.PivasIpOrderParamDTO;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetIpDrugPalnsQry implements ITransQry {
	
	private String dt_begin = null;
	private String dt_end = null;
	
	public GetIpDrugPalnsQry(PivasIpOrderParamDTO param) {
		this.dt_begin = param.getDt_b_search();
		this.dt_end = param.getDt_e_search();
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer whrStr) {
		SqlParam param = new SqlParam();
		whrStr.append(" where dt.id_grp = ? ");
		param.addParam(Context.get().getGroupId());
		whrStr.append(" and dt.id_org = ? ");
		param.addParam(Context.get().getOrgId());
		whrStr.append(" and dt.id_dep_wh = ? ");
		param.addParam(Context.get().getDeptId());
		whrStr.append(" and nvl(ci_or_srv.fg_self, 'N') <> 'Y' ");
		whrStr.append(" and dt.dt_mp_plan >= ? and dt.dt_mp_plan <= ?");
		param.addParam(this.dt_begin);param.addParam(this.dt_end);
		//只查询在院患者信息
		whrStr.append(" and en_ent.fg_ip = 'Y' ");
		//只获取护士已经发送和取消发送的
		whrStr.append(" and dt.en_send in (1, 2) ");
		//只获取未发药的
		whrStr.append(" and nvl(dt.id_dgipde, '~') = '~' ");
		//首日不摆的
		whrStr.append(" and (nvl(dt.sd_fddgipap, '~') = '~' or dt.sd_fddgipap <> '01')");
		whrStr.append(" and ( ");
		whrStr.append(" (nvl(ap.disp_time, '~') = '~' or (ap.disp_time >= ? and ap.disp_time <= ?) or dt.en_send = 2)");
		param.addParam(this.dt_begin);param.addParam(this.dt_end);
		whrStr.append(" or (dt.sv >= ? and dt.sv <= ?)");
		param.addParam(this.dt_begin);param.addParam(this.dt_end);
		whrStr.append(" or (ap.sv >= ? and ap.sv <= ?) ");
		param.addParam(this.dt_begin);param.addParam(this.dt_end);
		whrStr.append(" or (ci_order.dt_chk >= ? and ci_order.dt_chk <= ?) ");
		param.addParam(this.dt_begin);param.addParam(this.dt_end);
		whrStr.append(" or (ci_order.dt_chk_canc >= ? and ci_order.dt_chk_canc <= ?) ");
		param.addParam(this.dt_begin);param.addParam(this.dt_end);
		whrStr.append(" or (ci_order.dt_chk_stop >= ? and ci_order.dt_chk_stop <= ?) ");
		param.addParam(this.dt_begin);param.addParam(this.dt_end);
		whrStr.append(" or dt.en_opap = '2' or dt.en_opde = '2' ");
		whrStr.append(" ) ");
		whrStr.append(" and dt.ds = 0 ");
		whrStr.append(" order by ci_order.code_or,ci_or_srv.sortno ");
		return param;
	}

	@Override
	public String getQrySQLStr() {
		return this._getQrySQLStr();
	}

	private String _getQrySQLStr() {
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append(" select  ");
		SqlStr.append(" ci_order.code_or groupno, ");
		SqlStr.append(" ci_order.code_or || ci_or_srv.sortno recipeid, ");
		SqlStr.append(" dt.code_dgipap druglistid, ");
		SqlStr.append(" bd_freq.name drugfreq, ");
		SqlStr.append(" bd_mm.code drugcode, ");
		SqlStr.append(" bd_mm.name drugname, ");
		SqlStr.append(" dt.dt_mp_plan occdt ");
		SqlStr.append(" from mp_dg_ip_apde_dt dt ");
		SqlStr.append(" inner join mp_dg_ip_ap ap ");
		SqlStr.append(" on dt.id_dgipap = ap.id_dgipap ");
		SqlStr.append(" inner join ci_order ");
		SqlStr.append(" on dt.id_or = ci_order.id_or ");
		SqlStr.append(" inner join ci_or_srv ");
		SqlStr.append(" on dt.id_orsrv = ci_or_srv.id_orsrv ");
		SqlStr.append(" inner join en_ent ");
		SqlStr.append(" on dt.id_ent = en_ent.id_ent ");
		SqlStr.append(" inner join bd_mm ");
		SqlStr.append(" on dt.id_mm = bd_mm.id_mm ");
		SqlStr.append(" left join bd_freq ");
		SqlStr.append(" on ci_order.id_freq = bd_freq.id_freq ");
		
		return SqlStr.toString();
	}
}
