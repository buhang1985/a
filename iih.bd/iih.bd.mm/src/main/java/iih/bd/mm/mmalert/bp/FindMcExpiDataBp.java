package iih.bd.mm.mmalert.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import iih.mm.qy.validperiod.d.ValidPeriodView;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class FindMcExpiDataBp {
	
	public static ValidPeriodView[] queryExpiData(BgWorkingContext bgwc) throws BizException {
		
		Map<String, Object> map = bgwc.getKeyMap();
		String id_grp = (String) map.get("id_grp");
		String id_org = (String) map.get("id_org");
		String inv_dt = (String) map.get("inv_dt");//提前预警天数


		StringBuffer sql = new StringBuffer("select id_bl,mm_code,mm_name,mm_spec,sup_name,wh_name,id_grp,id_org,id_wh,id_mm,id_mmtp,id_mmca,id_sup,printname,srv_name,batch,date_expi,onlycode,pri_act as pri_base,pri_act,pri_sa as pri_sa_base,pri_sa,quan_stock,quan_stockact,quan_reserve,quan_usable,quan_usable as quan_usableact,pri_act * quan_stock as amt_cost,invalid_dt ");
		       sql.append(" from v_mc_validperiod where 1=1 ");
		if(StringUtils.isNotBlank(id_grp))
		{
			sql.append(" and  id_grp = '"+id_grp+"' ");
		}
		if(StringUtils.isNotBlank(id_org))
		{
			sql.append(" and  id_org = '"+id_org+"' ");
		}
		if(StringUtils.isBlank(inv_dt))
		{
			inv_dt ="90"; //默认为90天
		}
		sql.append(" and  invalid_dt <= "+inv_dt+" ");
		
		DAFacade daFacade = new DAFacade();
		List<ValidPeriodView> list = (ArrayList<ValidPeriodView>)daFacade.execQuery(sql.toString(),  new SqlParam(), new BeanListHandler(ValidPeriodView.class));
		
		
		return list.toArray(new ValidPeriodView[0]);
	}
}
