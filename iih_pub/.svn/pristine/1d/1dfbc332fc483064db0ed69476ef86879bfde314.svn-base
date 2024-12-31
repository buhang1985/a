package iih.bd.srv.medsrv.refs.sql.ip.relhp;

import iih.bd.srv.medsrv.refs.sql.hptype.HptypeDisplay;
import iih.bd.srv.medsrv.refs.sql.ip.IpOrderRefSrvSQLBuilder;
/**
 * 住院参照去掉描述字段去掉bd_srv.des
 * @author LiYueLong
 *
 * 2020年7月27日-下午5:14:33
 */
public class IpOrderRefSrvRelHpDesSQLBuilder extends IpOrderRefSrvSQLBuilder{

	@Override
	public String getDesField() {
		String hptypeDisplay = HptypeDisplay.getInstance().getHptyDisplay();
		StringBuffer sql = new StringBuffer();
		sql.append("(case " );
		sql.append(String.format("  when hpsrvca.code is null and srv.fg_bl = 'Y' then '%s ' when  hptp.name  is null and srv.fg_bl = 'Y' then '%s ' else hptp.name end )",hptypeDisplay,hptypeDisplay));
		sql.append("       || decode(hpsrvca.des,null,'',' '||hpsrvca.des)||decode(hpsrvca.note,null,'',' '||hpsrvca.note) " );
		sql.append("       ||  CASE  WHEN hpsrvca.rate IS NULL THEN  '' else ' 报销比例：'||CONCAT(TO_CHAR(hpsrvca.rate*100, 'fm9999999990'),'%')||' ' END des, " );
		return sql.toString();
	}
}
