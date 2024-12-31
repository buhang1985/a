package iih.bl.inc.bp.qry;

import iih.bl.comm.util.BlInccaParamUtil;
import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询票据领用信息
 * @author yi
 *
 */
public class IncIssOepInfoQry implements ITransQry {
    private String strIdEmpIss;
    private String strCodeIncca;
    private String Id_pc;//按过滤条件和模式使用计算机
    
    public IncIssOepInfoQry(String strIdEmpIss,String strCodeIncca)
    {
        this.strCodeIncca=strCodeIncca;
        this.strIdEmpIss=strIdEmpIss;
    }
    
    @Override
    public SqlParam getQryParameter(StringBuffer arg0) {
        SqlParam rtnParam=new SqlParam();
        try {
			String id_incca = BlInccaParamUtil.getIdIncca(this.strCodeIncca);
			if(BlInccaParamUtil.isPc(id_incca)){
				Id_pc =Id_pc == null? BlParams.getRealPcId(Context.get().getClientHost()) : Id_pc;
	        	rtnParam.addParam(Id_pc); //计算机ID
			}else{
				rtnParam.addParam(strIdEmpIss); //操作员ID
			}
		} catch (BizException e) {
			e.printStackTrace();
			rtnParam.addParam(strIdEmpIss); //操作员ID
		}
        rtnParam.addParam(strCodeIncca); //票据类型
        return rtnParam;
    }
    @Override
    public String getQrySQLStr() {
        return getQrySql();
    }
    
    public String getId_pc() {
		return Id_pc;
	}

	public void setId_pc(String id_pc) {
		Id_pc = id_pc;
	}

	private String getQrySql()
    {
        StringBuffer strSql=new StringBuffer();
        strSql.append(" SELECT A.ID_INCISS,A.ID_INCCA,A.CODE_INCPKG,");
        strSql.append(" A.ID_EMP_ISS,A.DT_ISS,A.NUM_B,A.NUM_E,A.INCCN,");
        strSql.append(" A.INCCN_USE,A.INCNO_CUR,A.FG_CURUSE,A.FG_ACTIVE,");
        strSql.append(" A.INCCN_TRANS,A.INCCN_CANC,A.INCCN_RET,A.INCCN_WF");
        strSql.append(" FROM BL_INC_ISS A");
        strSql.append(" INNER JOIN BD_INCCA B ON A.ID_INCCA=B.ID_INCCA");
        try {
			String id_incca = BlInccaParamUtil.getIdIncca(this.strCodeIncca);
			if(BlInccaParamUtil.isPc(id_incca)){
				strSql.append(" WHERE A.ID_PC=? AND A.FG_CURUSE='Y' AND B.CODE=? AND A.DS=0");
			}else{
				strSql.append(" WHERE A.ID_EMP_ISS=? AND A.FG_CURUSE='Y' AND B.CODE=? AND A.DS=0");
			}
		} catch (BizException e) {
			e.printStackTrace();
			strSql.append(" WHERE A.ID_EMP_ISS=? AND A.FG_CURUSE='Y' AND B.CODE=? AND A.DS=0");
		}
        strSql.append(" AND A.ID_GRP='"+Context.get().getGroupId()+"'");
        strSql.append(" AND A.ID_ORG='"+Context.get().getOrgId()+"'");
        
        return strSql.toString();
    }

}
