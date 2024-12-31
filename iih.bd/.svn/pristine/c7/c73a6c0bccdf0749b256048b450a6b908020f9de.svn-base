package iih.bd.pp.s.bp.qry;

import iih.bd.pp.samppri.d.SampPriDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * @Description:儿童标本采集费用对照
 * @author: xu_xing@founder.com.cn
 * @version：2019年6月13日 下午6:02:45 创建
 * @version:xuxing_2019年6月13日18:05:54，迭代
 */
public class GetSampPriChldCnstQry implements ITransQry {

	private String id_srv_base;
	private String id_srv;

	public GetSampPriChldCnstQry(String id_srv_base, String id_srv) {
		this.id_srv_base = id_srv_base;
		this.id_srv = id_srv;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (!StringUtil.isEmptyWithTrim(id_srv_base))
			param.addParam(id_srv_base);
		if (!StringUtil.isEmptyWithTrim(id_srv))
			param.addParam(id_srv);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                               ");
		sqlStr.append(" chldcnst.id_chld_cnst,                                                               ");
		sqlStr.append(" temtable.id_srv as samppri_id_srv,                                                   ");
		sqlStr.append(" srvbas.name as samppri_ser_name,                                                     ");
		sqlStr.append(" srvbas.code as samppri_code,                                                         ");
		sqlStr.append(" meabas.name as samppri_unit,                                                         ");
		sqlStr.append(" rp.price_std  as samppri_pri_std,                                                    ");
		sqlStr.append(" chldcnst.id_srv as contrast_id_srv,                                                  ");
		sqlStr.append(" srv.name as contrast_srv_name,                                                       ");
		sqlStr.append(" mea.name as contrast_unit,                                                           ");
		sqlStr.append(" srv.code as contrast_code,                                                           ");
		sqlStr.append(" srv.pri  as contrast_pri_std                                                         ");
		sqlStr.append(" from                                                                                 ");
		sqlStr.append(" (                                                                                    ");
		sqlStr.append("   select                                                                             ");
		sqlStr.append("   itm.id_srv,                                                                        ");
		sqlStr.append("   itm.id_unit                                                                        ");
		sqlStr.append("   from bd_samp_pri_itm itm                                                           ");
		sqlStr.append("   inner join  bd_samp_pri pri  on  pri.ID_SAMP_PRI  = itm.ID_SAMP_PRI                ");
		sqlStr.append("   where       " + EnvContextUtil.processEnvContext("",new SampPriDO(), "pri"));
		sqlStr.append("   group by itm.id_srv,itm.id_unit                                                    ");
		sqlStr.append(" )temtable                                                                            ");
		sqlStr.append(" left join bd_samp_pri_chldcnst chldcnst on chldcnst.id_srv_base = temtable.id_srv    ");
		sqlStr.append(" left join bd_srv srvbas on srvbas.id_srv = temtable.id_srv                           ");
		sqlStr.append(" left join bd_measdoc meabas on temtable.id_unit = meabas.id_measdoc                  ");
		sqlStr.append(" left join bd_srv srv on srv.id_srv = chldcnst.id_srv                                 ");
		sqlStr.append(" left join bd_measdoc mea on srv.id_unit_med = mea.id_measdoc                         ");
		sqlStr.append(" left join view_price_rp  rp on rp.id_pripat = '@@@@Z8100000002YL8PO' and rp.id_mm = '~' and srvbas.id_srv = rp.id_srv ");
		sqlStr.append(" where 1=1                			         ");
		if (!StringUtil.isEmptyWithTrim(id_srv_base))
			sqlStr.append(" and  temtable.id_srv = ?                                                         ");
		if (!StringUtil.isEmptyWithTrim(id_srv) ){			
			sqlStr.append(" and  chldcnst.id_srv = ?                                                         ");
		}	
		sqlStr.append(" order by srvbas.name                                                                 ");
		return sqlStr.toString();
	}
}
