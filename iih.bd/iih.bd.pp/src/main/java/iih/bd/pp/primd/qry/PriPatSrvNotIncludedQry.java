package iih.bd.pp.primd.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询某种患者价格系数下，维护的特殊服务项目所使用的价格策略
 * @author yangyang
 *
 */
public class PriPatSrvNotIncludedQry implements ITransQry {

    //患者价格系数
    private String strIdPriPat;
    //时间
    private String strCurDate;
    
    public PriPatSrvNotIncludedQry(String strIdPriPat,String strCurDate)
    {
        this.strIdPriPat=strIdPriPat;
        this.strCurDate=strCurDate;
    }
    @Override
    public SqlParam getQryParameter(StringBuffer arg0) {
        SqlParam sqlParam = new SqlParam(); 
        sqlParam.addParam(strIdPriPat);  
        if(!StringUtil.isEmpty(strCurDate))
        	sqlParam.addParam(strCurDate);
//        sqlParam.addParam(strCurDate);
//        sqlParam.addParam(strIdPriPat);
//        sqlParam.addParam(strCurDate);
//        sqlParam.addParam(strCurDate);
        return sqlParam;
    }

    @Override
    public String getQrySQLStr() {
        //获取价格分类下，特殊服务项目的价格系数策略
        //如果一个服务项目维护多条，则先比较结束时间，结束时间早的优先，如果结束时间相同，则比较开始时间，开始时间晚的先生效
         StringBuffer strSql=new StringBuffer();
//         strSql.append(" SELECT EU_SRVORCA,ID_SRV,RATE FROM(");
//         strSql.append(" SELECT ROW_NUMBER() OVER(PARTITION BY ID_SRV ORDER BY DT_E,DT_B DESC) RN,EU_SRVORCA,ID_SRV,RATE,DT_E,DT_B FROM");
//         strSql.append(" (SELECT A.EU_SRVORCA,A.ID_SRV,A.RATE,A.DT_E,A.DT_B FROM BD_PRI_PAT_SRVORCA A WHERE A.ID_PRIPAT=? AND A.DT_B<? AND A.DT_E IS NULL");
//         strSql.append(" AND A.ID_GRP='"+Context.get().getGroupId()+"' AND A.ID_ORG='"+Context.get().getOrgId()+"'");
//         strSql.append(" UNION");
//         strSql.append(" SELECT A.EU_SRVORCA,A.ID_SRV,A.RATE,A.DT_E,A.DT_B FROM BD_PRI_PAT_SRVORCA A WHERE A.ID_PRIPAT=? AND A.DT_B<? AND A.DT_E>?");
//         strSql.append(" AND A.ID_GRP='"+Context.get().getGroupId()+"' AND A.ID_ORG='"+Context.get().getOrgId()+"'))");
//         strSql.append(" WHERE RN=1");
         
         //TODO:2017-5-17  DT_E='2099-12-31 23：59：59'为有效数据
         strSql.append(" SELECT A.EU_SRVORCA,A.ID_SRV,A.RATE,A.EU_PI_PRIRATEMD, A.PRI");
         strSql.append(" FROM BD_PRI_PAT_SRVORCA A ");
         strSql.append(" WHERE A.ID_PRIPAT=? AND (A.DT_E='2099-12-31 23:59:59' AND A.DT_E IS NOT NULL)");
         if(!StringUtil.isEmpty(strCurDate))
             strSql.append(" AND A.DT_B<=? ");
         //价格分类有管控，具体查询某个价格分类的服务，无需再加管控
        
         return strSql.toString();
    }

}
