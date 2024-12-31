package iih.bd.srv.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMedSrvRelMmQry implements ITransQry {
	private String _id_srv;
	
	public GetMedSrvRelMmQry(String id_srv){
		_id_srv=id_srv;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(_id_srv);
		param.addParam(_id_srv);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		return " select  GG.id_srvrelmm,GG.id_srv,GG.sortno,GG.id_org,GG.id_dep,GG.id_mm,GG.id_owtp,GG.sd_owtp, "
              +" EE.Name as srv_name,GG.mm_name,GG.dept_name,GG.owtp_name,GG.Sd_opmutp,GG.Sd_ermutp,GG.Sd_er1mutp,factor_mb"
              +" from  "
              +" (select id_srv || rownum as id_srvrelmm, id_srv, rownum as sortno,id_org,'' as  id_dep,id_mm,'0001AA1000000000ELNS' as id_owtp,'0' as sd_owtp,name as mm_name,'全院' as owtp_name,'' as dept_name,Sd_opmutp,Sd_ermutp,Sd_er1mutp,factor_mb"
              +" from bd_mm  "
              +" where id_srv=? and id_mm not in (select  id_mm from BD_MM_CTR) and fg_active='Y' and  fg_out='N' and ds=0 "
              +" union all "
              +" select A.ID_MMCTR || rownum as id_srvrelmm, B.id_srv, rownum as sortno,A.id_org,A.id_dep,A.id_mm,'0001AA1000000000ELNR' as id_owtp,'1' as sd_owtp,B.name as mm_name,'科室' as owtp_name,C.Name as dept_name,B.Sd_opmutp,B.Sd_ermutp,B.Sd_er1mutp,B.factor_mb "
              +" from BD_MM_CTR A left outer join bd_mm B ON A.id_mm=B.id_mm left outer join bd_dep C ON A.Id_Dep=C.Id_Dep "
              +" where B.id_srv=?  and B.fg_active='Y' and  B.fg_out='N' and B.ds=0  ) GG left outer join bd_srv EE ON GG.id_srv=EE.id_srv";
	}

}
