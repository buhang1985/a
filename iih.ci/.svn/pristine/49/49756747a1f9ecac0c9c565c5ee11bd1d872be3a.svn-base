package iih.ci.ord.s.bp.iemsg.qry;

import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import iih.ci.ord.s.bp.iemsg.qry.sql.Drug4IESql;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiOpDrugPres8idenPriceQry implements ITransQry{
private String _iden;
	
	public CiOpDrugPres8idenPriceQry(String id_en){
		this._iden = id_en;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		sqlpram.addParam(_iden);
		sqlpram.addParam(ICiDictCodeTypeConst.ID_SU_BL_1);
		sqlpram.addParam(ICiDictCodeTypeConst.ID_SU_BL_0);
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
		 String sqlString=new Drug4IESql().CiIeOrpharmOpPres8idenPriceSql();
		 System.out.println("BS302 IEOpPharmPresDTO+IEOpPharmOrFeeDTO 金额 sql:"+sqlString+" param:"+this._iden+","+ICiDictCodeTypeConst.ID_SU_BL_1+","+ICiDictCodeTypeConst.ID_SU_BL_0);
		 return sqlString;
	 }

}
