package iih.ci.ord.s.external.provide.qry;

import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.external.provide.sql.SurInfo4IpSql;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiIpSugOrInfoQry implements ITransQry {

	private String _id_pat;
	private String _id_ent;
	private String _dt_b;
	private String _dt_e;
	private String _id_dep_mp;
	private String _code_entp;
	private String _fg_aptapp1;
	private String _fg_confirm;
	
	public CiIpSugOrInfoQry(String id_pat,String id_ent, String dt_b, String dt_e, String id_dep_mp, String code_entp,
			 String fg_aptapp1, String fg_confirm){
		this._id_pat = id_pat;
		this._id_ent = id_ent;
		this._dt_b = dt_b;
		this._dt_e = dt_e;
		this._id_dep_mp = id_dep_mp;
		this._code_entp = code_entp;
		this._fg_aptapp1 = fg_aptapp1;
		this._fg_confirm = fg_confirm;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		if (this._id_pat != null) {
			sqlpram.addParam( this._id_pat );
		}
		if (this._id_ent != null) {
			sqlpram.addParam( this._id_ent );
		}
		if (this._dt_b != null) {
			sqlpram.addParam( this._dt_b );
		}
		if (this._dt_e != null) {
			sqlpram.addParam( this._dt_e );
		}
		if (this._id_dep_mp != null) {
			sqlpram.addParam( this._id_dep_mp );
		}
		if (this._code_entp != null) {
			sqlpram.addParam( this._code_entp );
		}
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}
   
	/**
	 * 获得查询sql串
	 * @return
	 */
	 private String getSql(){
		 
		 String formatsql=SurInfo4IpSql.IpSugInfoSql(_id_pat, _id_ent, _dt_b, _dt_e, _id_dep_mp, _code_entp, _fg_aptapp1, _fg_confirm);
		 return formatsql;
		 
	 }
	 
}




