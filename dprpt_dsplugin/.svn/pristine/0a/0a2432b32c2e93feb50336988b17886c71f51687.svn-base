package iih.nm.nom.wardprint.qry;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:查询护理质量图表数据
 * @author:zhongcl@founder.com.cn
 * @version:2019年1月9日 下午3:22:14 创建
 */
public class GetNomQualityChartsQry implements ITransQry {

	private String sqlbase;
	private List<String> id_dep_nurs;
	private String dt_begin;
	private String dt_end;
	private FBoolean isWard;
	

	public GetNomQualityChartsQry(String sqlbase, List<String> id_dep_nurs, String dt_begin, String dt_end,
			FBoolean isWard) {
		super();
		this.sqlbase = sqlbase;
		this.id_dep_nurs = id_dep_nurs;
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
		this.isWard = isWard;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if(CollectionUtils.isNotEmpty(this.id_dep_nurs)){
			List<Object> datas=param.getParameters();
			datas.addAll(this.id_dep_nurs);
		}
		param.addParam(this.dt_begin);
		param.addParam(this.dt_end);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql=new StringBuilder(this.sqlbase);
		if(CollectionUtils.isNotEmpty(this.id_dep_nurs)){
			String insql="";
			for (String id_dep_nur : id_dep_nurs) {
				insql+=StringUtils.isBlank(insql)? "?":","+"?";
			}
			sql.append(" and quality.id_dep_nur in " +"("+insql+")");
		}
		if(!this.isWard.isValue()){
			sql.append(" and quality.fg_comfirm='Y'");
		}
		sql.append(" and substr(quality.check_month,0,7)>=?" );
		sql.append(" and substr(quality.check_month,0,7)<=?");
		sql.append(" group by quality.check_month,doc.ctrl3,doc.ctrl4 ");
		sql.append(" order by quality.check_month asc ");
		return sql.toString();
	}

}
