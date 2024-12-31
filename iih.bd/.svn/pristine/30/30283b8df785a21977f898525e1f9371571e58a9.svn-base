package iih.bd.mm.mmalert.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.mm.mmcerti.d.MaterialCertiDO;
import iih.mm.qy.validperiod.d.ValidPeriodView;
import xap.mw.core.data.BizException;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class FindMmcfExpiDataBp {
	
public static MaterialCertiDO[] queryExpiData(BgWorkingContext bgwc) throws BizException {
		
		Map<String, Object> map = bgwc.getKeyMap();
		String id_grp = (String) map.get("id_grp");
		String id_org = (String) map.get("id_org");
		String inv_dt = (String) map.get("inv_dt");//提前预警天数


		StringBuffer sql = new StringBuffer("select  id_mm,mm_name, cf_no, da_b, da_e,mm_code,sd_ct,certi_name from ( ");
		sql.append("select cf.id_mm,tcf.name certi_name, mm.name mm_name, cf_no, da_b, da_e,mm.code mm_code, ");
		sql.append(" floor(to_date(cf.da_e,'yyyy-mm-dd')-to_date(to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd')) as sd_ct ");
		sql.append(" from bd_mm_mmcf cf left join bd_mm mm on mm.id_mm = cf.id_mm left join bd_mm_cf tcf on tcf.id_mmcf = cf.id_mmcf where cf.da_e is not null ");
		sql.append(" ) a where 1=1 ");
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
			inv_dt ="30"; //默认为30天
		}
		sql.append(" and  sd_ct <= "+inv_dt+" ");
		
		DAFacade daFacade = new DAFacade();
		List<MaterialCertiDO> list = (ArrayList<MaterialCertiDO>)daFacade.execQuery(sql.toString(),  new SqlParam(), new BeanListHandler(MaterialCertiDO.class));
		
		
		return list.toArray(new MaterialCertiDO[0]);
	}

public static MaterialCertiDO[] querySupExpiData(BgWorkingContext bgwc,String tpSup) throws BizException {
	
	Map<String, Object> map = bgwc.getKeyMap();
	String id_grp = (String) map.get("id_grp");
	String id_org = (String) map.get("id_org");
	String inv_dt = (String) map.get("inv_dt");//提前预警天数

	StringBuffer sql = new StringBuffer("select  id_mm,mm_name, cf_no, da_b, da_e,mm_code,sd_ct,certi_name from ( ");
	sql.append("select '' id_mm,sup.code mm_code,sup.name mm_name,cf.cf_no,mmcf.name certi_name,cf.da_b ,cf.da_e , ");
	sql.append(" floor(to_date(cf.da_e,'yyyy-mm-dd')-to_date(to_char(sysdate, 'yyyy-mm-dd'), 'yyyy-mm-dd')) as sd_ct ");
	sql.append(" from bd_sup sup inner join BD_MM_SUPCF cf on cf.id_sup = sup.id_sup ");
	sql.append(" left join BD_MM_CF mmcf  on mmcf.id_mmcf = cf.id_mmcf ");
	sql.append(" where 1=1  and cf.da_e is not null ");
	if("sup".equals(tpSup)){
		sql.append(" and sup.fg_sup = 'Y' ");
	}else{
		sql.append(" and sup.fg_fac = 'Y' ");
	}
	sql.append(" ) a where 1=1 ");
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
		inv_dt ="30"; //默认为30天
	}
	sql.append(" and  sd_ct <= "+inv_dt+" ");
	
	DAFacade daFacade = new DAFacade();
	List<MaterialCertiDO> list = (ArrayList<MaterialCertiDO>)daFacade.execQuery(sql.toString(),  new SqlParam(), new BeanListHandler(MaterialCertiDO.class));
	
	
	return list.toArray(new MaterialCertiDO[0]);
}
}
