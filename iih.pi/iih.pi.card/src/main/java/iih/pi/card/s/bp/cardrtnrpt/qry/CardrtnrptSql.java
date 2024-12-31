package iih.pi.card.s.bp.cardrtnrpt.qry;

import xap.mw.core.data.Context;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CardrtnrptSql implements ITransQry{
	private String Pi_code;
	private String Code;
	private String Name;
	private String Id_code;
	
	public CardrtnrptSql(String pi_code, String code,String name,
			String id_code){
		Pi_code = pi_code;
		Code = code;
		Name = name;
		Id_code = id_code;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam = new SqlParam();
		if (!StringUtil.isEmptyWithTrim(Pi_code)) {
			rtnParam.addParam(Pi_code);
			whereSQL.append(" and  a.code= ? ");
		}
		if (!StringUtil.isEmptyWithTrim(Code)) {
			rtnParam.addParam(Code);
			whereSQL.append(" and  b.code=? ");
		}
		if (!StringUtil.isEmptyWithTrim(Name)) {
			rtnParam.addParam("%"+Name+"%");
			whereSQL.append(" and  a.name like ? ");
		}
		if (!StringUtil.isEmptyWithTrim(Id_code)) {
			rtnParam.addParam(Id_code);
			whereSQL.append(" and  a.id_code=? ");
		}
		
		whereSQL.append(" and a.id_org = ? ");
		rtnParam.addParam(Context.get().getOrgId());
		
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		return _getQrySQLStr();
	}	
	
	private String _getQrySQLStr() {
		String SqlStr = " select c.eu_cardsu as id_cardsu,c.code,a.code as pi_code, a.name , a.dt_birth ,"
				      + " a.id_pat,c.id_card ,b.id_patcard,a.id_sex,a.id_paticate,e.name as id_paticate_name,e.code as id_paticate_code, "      
				      + " a.id_patpritp,f.name as id_patpritp_name,f.code as id_patpritp_code ,"
				      + " a.id_patcrettp ,g.name as id_patcrettp_name,g.code as id_patcrettp_code ,"
				      + " c.id_patcardtp, h.name as id_patcardtp_name,h.code as id_patcardtp_code ,"
				      + " bd.name as id_sex_name,bd.code as id_sex_code,acc.id_accsta,bdu.name as id_accsta_name,bdu.code as id_accsta_code "
				      + " from pi_pat a "
				      + " join pi_pat_card b on a.id_pat = b.id_pat"
				      + " join pi_card c on b.id_card = c.id_card"
				      + " left join pi_pat_ca e on a.id_paticate = e.id_patca"
				      + " left join bd_pri_pat f on a.id_patpritp = f.id_pripat"
				      + " left join pi_pat_cret g on a.id_patcrettp = g.id_patcret"
				      + " left join pi_pat_cardtp h on c.id_patcardtp = h.id_cardtp "
				      + " left join bd_udidoc bd on a.id_sex=bd.id_udidoc"
				      + " left join pi_pat_acc acc on a.id_pat=acc.id_pat"
				      + " left join bd_udidoc bdu on acc.id_accsta=bdu.id_udidoc"
				      + " where  c.ds = 0 "
					  + " and b.ds = 0 "
				      + " and c.eu_cardsu in (1,2) ";//在用和挂失
				      //+ "and  b.fg_act='Y' ";
		return SqlStr;
	}

}
