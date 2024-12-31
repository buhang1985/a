package iih.mi.mibd.drugdircomp.s.bp.sql;

import org.apache.commons.lang3.StringUtils;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.mi.mibd.drug.d.DrugDO;
import iih.mi.mibd.drugdircomp.d.DrugdircompDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/** 
* @author hexx 
* @version 创建时间：2018年2月8日 下午7:21:10 
* 通过名称查找sql 
*/
public class AutoCompDrugByNameSql implements ITransQry {

	private String _misId;

	public AutoCompDrugByNameSql(String misId) {
		this._misId = misId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._misId);
		sqlParam.addParam(this._misId);
		return sqlParam;
	}
	@Override
	public String getQrySQLStr() {
		StringBuilder baseSQL = new StringBuilder();
        baseSQL.append(" SELECT BDMM.ID_MM AS ID_DRUG ,                                 ");
        baseSQL.append("   MIDRUG.CODE			  				");
        baseSQL.append(" FROM				  				");
        baseSQL.append("   (SELECT ID_MM,		  				");
        baseSQL.append("     CODE,			  				");
        baseSQL.append("     NAME			  				");
        baseSQL.append("   FROM BD_MM			  				");
        baseSQL.append("   WHERE   1 = 1				");

        String wherePart = BdEnvContextUtil.processEnvContext(new MeterialDO(), "BD_MM");
        if (StringUtils.isNotEmpty(wherePart)) {
        baseSQL.append(" AND ");
        baseSQL.append(wherePart);
        }

        baseSQL.append("   AND ID_MM NOT IN		       				");		
        baseSQL.append("     (SELECT ID_DRUG FROM MI_BD_COMP_DRUG WHERE ID_MIS = ?   	");

        wherePart = BdEnvContextUtil.processEnvContext(new DrugdircompDO(), "MI_BD_COMP_DRUG");
        if (StringUtils.isNotEmpty(wherePart)) {
	    baseSQL.append(" AND ");
	    baseSQL.append(wherePart);
        }

        baseSQL.append("     )				       				");		
        baseSQL.append("   ) BDMM			       				");		
        baseSQL.append(" INNER JOIN			       				");		
        baseSQL.append("   (SELECT MIN(MI_BD_DRUG.CODE) AS CODE,	       		");		
        baseSQL.append("     MI_BD_DRUG.NAME		       				");		
        baseSQL.append("   FROM MI_BD_DRUG WHERE ID_MIS = ?		       		");

        wherePart = BdEnvContextUtil.processEnvContext(new DrugDO(), "MI_BD_DRUG");
        if (StringUtils.isNotEmpty(wherePart)) {
	    baseSQL.append(" AND ");
	    baseSQL.append(wherePart);
        }

        baseSQL.append("   GROUP BY MI_BD_DRUG.NAME	       				");		
        baseSQL.append("   ) MIDRUG			       				");		
        baseSQL.append(" ON MIDRUG.NAME = BDMM.NAME 	       				");		
										
		  return baseSQL.toString();
		}
}
