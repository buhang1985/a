package iih.bd.srv.s.bp.qry;

import org.apache.commons.lang3.StringUtils;

import iih.bd.srv.emsqry.d.EmsQryMatchDTO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getSrvEmsSql implements ITransQry {

	private EmsQryMatchDTO matchDTO;//匹配查寻

	public getSrvEmsSql(EmsQryMatchDTO dto) {
		this.matchDTO = dto;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();
		param.addParam(matchDTO.getId_srv());
		param.addParam(matchDTO.getDt_systime());
		param.addParam(matchDTO.getDt_systime());
		param.addParam(matchDTO.getId_dept());
		return param;
	}

	@Override
	public String getQrySQLStr() {
		return getSqlStr();
	}

	public String getSqlStr() {
		
		String entp="";
		if(StringUtils.isNotBlank(matchDTO.getCode_entp())){
			
			entp=" and  fg_entp_"+matchDTO.getCode_entp().toLowerCase()+" = 'Y'";
		}
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append("select sof.* ");
		SqlStr.append("from bd_srv_of sof ");
		SqlStr.append("left join bd_srv_of_rel rel ");
		SqlStr.append("on sof.id_srvof = rel.id_srvof ");
		SqlStr.append("where rel.id_srv = ? ");
		SqlStr.append("and rel.eu_ofreftp = 1 ");//关联类型是服务的
		SqlStr.append("and rel.eu_direct = 1 ");//增减项是增项的
		SqlStr.append("and sof.dt_effe >= ? ");//有效开始时间
		SqlStr.append("and ? <= sof.dt_end ");//有效截止时间
		SqlStr.append("and ( (sof.sd_srvorrt='1' and sof.id_dept = ?) or sof.sd_srvorrt='0') ");//所属是部门的 或者是全院适用的
		SqlStr.append(entp);//适用范围
		
		return SqlStr.toString();
	}

}
