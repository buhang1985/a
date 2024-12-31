package iih.bd.srv.medsrv.refs.sql.ip.relhp;

import iih.bd.srv.medsrv.refs.sql.hptype.HptypeDisplay;
import iih.bd.srv.medsrv.refs.sql.ip.IpOrderRefMMSQLBuilder;
/**
 * 住院参照去掉描述字段去掉bd_srv.des
 * @author LiYueLong
 *
 * 2020年7月27日-下午3:40:23
 */
public class IpOrderRefMMRelHpDesSQLBuilder extends IpOrderRefMMSQLBuilder{
	
	@Override
	public String getDesField() {
		String hptypeDisplay = HptypeDisplay.getInstance().getHptyDisplay();
		StringBuffer sql = new StringBuffer();
		sql.append("( " );
		sql.append("  (case when mm.fg_keymonitor ='Y' then '【重点监控】' end)");
		sql.append("  ||(case when mmgroup.name is not null then  ' ('||mmgroup.name||') ' else'' end)");
		sql.append(String.format("  || (case when hpsrvca.code is null AND srv.fg_bl = 'Y'  then '%s '  when hptp.name is null AND srv.fg_bl = 'Y'  then '%s ' else hptp.name end) ",hptypeDisplay,hptypeDisplay));
		sql.append("  || case when basedrugrange.name is not null then ' ('||basedrugrange.name||') ' else ''end " );
		sql.append("  ||antidoc.name||' '");
		sql.append("  ||poisdoc.name||' ' " );
		sql.append("  ||decode(mm.sup_name,null,'','【' || mm.sup_name || '】') " );
		sql.append("  ||abrddoc.name ||  CASE  WHEN hpsrvca.rate IS NULL THEN  '' else ' 报销比例：'||CONCAT(TO_CHAR(hpsrvca.rate*100, 'fm9999999990'),'%')||' ' END " );
		sql.append("  ||decode(hpsrvca.des,null,'',' '||hpsrvca.des)||decode(hpsrvca.note,null,'',' '||hpsrvca.note) " );
		sql.append(")as des, " );
		return sql.toString();
	}
	
}
