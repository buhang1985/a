package iih.bd.srv.s.bp.qry;

import org.apache.commons.lang3.StringUtils;

import iih.bd.srv.emsqry.d.EmsQryMatchDTO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getSrvtpEmsSql implements ITransQry {

	private EmsQryMatchDTO matchDTO;//匹配查寻
	public String srvtps="";

	public getSrvtpEmsSql(EmsQryMatchDTO dto) {
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
		
		
		if(StringUtils.isNotBlank(matchDTO.getId_srvtp())){
			srvtps = matchDTO.getId_srvtp();
			
		}		
		
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append("select sof.* ");
		SqlStr.append("from bd_srv_of sof ");
		SqlStr.append("left join bd_srv_of_rel rel ");
		SqlStr.append("on sof.id_srvof = rel.id_srvof ");
		SqlStr.append("where rel.eu_ofreftp = 0 ");//关联类型是分类的
		SqlStr.append("and rel.sd_srvtp in (select doc.id_udidoc ");//关联类型是分类的
		SqlStr.append("from bd_udidoc doc ");//增减项是增项的
		SqlStr.append("where doc.id_udidoclist = '0001ZZ2000000000000T' ");//有效开始时间
		SqlStr.append("and code in ('01', '0101')) ");//有效截止时间
		SqlStr.append("order by rel.sd_srvtp desc ");//所属是部门的 或者是全院适用的
		if(!srvtps.equals("")){
			
			SqlStr.append("rel.sd_srvtp in ("+srvtps+") ");//所属是部门的 或者是全院适用的
		}
		//SqlStr.append(entp);//适用范围
		
		return SqlStr.toString();
	}
	
	/**
	 * 递归取出编码的父级
	 * @param codes
	 * @return
	 */
	public void getSrvtpCode(String codes){
		if(!srvtps.equals("")){
			srvtps+=",";
		}
		srvtps +="'"+codes+"'";
				
		if(codes.length()>0){			
			String codeParent = codes.substring(codes.length()-2);
			getSrvtpCode(codeParent);
		}
		
	}
	

}
