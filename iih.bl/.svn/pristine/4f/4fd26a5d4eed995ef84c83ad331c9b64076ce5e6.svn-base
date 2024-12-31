package iih.bl.cg.service.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class BlPropArQry implements ITransQry {

    private String strIdStOep;
    public BlPropArQry(String strIdStOep) {
        // TODO Auto-generated constructor stub
        this.strIdStOep=strIdStOep;
    }
    @Override
    public SqlParam getQryParameter(StringBuffer arg0) {
        // TODO Auto-generated method stub
        SqlParam param=new SqlParam();
        param.addParam(this.strIdStOep);
        return param;
    }

    @Override
    public String getQrySQLStr() {
    	StringBuilder sb=new StringBuilder();
        sb.append(" SELECT A.* FROM BL_PROP_AR_OEP A");
        sb.append(" INNER JOIN BL_PROP_OEP B ON A.ID_PROPOEP=B.ID_PROPOEP");
        sb.append(" WHERE B.ID_STOEP=?");
        return sb.toString();
    }

}
