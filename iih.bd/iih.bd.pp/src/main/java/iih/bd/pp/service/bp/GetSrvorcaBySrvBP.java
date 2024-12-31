package iih.bd.pp.service.bp;

import java.util.List;

import iih.bd.pp.hp.d.HPDO;
import iih.bd.pp.hp.i.IHpMDORService;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询指定医保计划下服务的医保计划目录
 * 
 * @author ly 2017/05/26 整理tcy代码
 *
 */
public class GetSrvorcaBySrvBP {

	/**
	 * 查询指定医保计划下服务的医保计划目录
	 * @param hpId 医保计划
	 * @param id_srvarr 服务ID数组
	 * @return 医保计划目录
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public HPSrvorcaDO[] exec(String hpId, String[] id_srvarr) throws BizException {
		
		// 1.查询真实使用的医保计划
		hpId = this.getRealHpId(hpId);
		
		HPSrvorcaDO[] hPSrvorcaDOArr=null;
		SqlParam sqlp=new SqlParam();
		StringBuffer sqlb=new StringBuffer();
		sqlb.append("select a.id_hpsrvorca,");
		sqlb.append("       a.id_hp,");
		sqlb.append("       a.id_srv,");
		sqlb.append("       a.id_mm,");
		sqlb.append("       a.code,");
		sqlb.append("       a.name,");
		sqlb.append("       a.code_ca,");
		sqlb.append("       a.name_ca,");
		sqlb.append("		a.id_hpsrvtp,");
		sqlb.append("       a.sd_hpsrvtp,");
		sqlb.append("       a.des,");
		sqlb.append("		b.his_des,");//医院限制描述
		sqlb.append("       b.eu_hpsrvctrtp,");
		sqlb.append("       b.id_rule");
		sqlb.append("  from bd_hp_srvorca a left join bd_hp_srvctr b ");
		sqlb.append(" on a.id_hp = b.id_hp");		
		sqlb.append("   and a.id_srv = b.id_srv");
		sqlb.append(" where  a.id_hp=? and a.id_srv in (''");
		sqlp.addParam(hpId);
		for(String id_srv:id_srvarr)
		{
			sqlb.append(",?");
			sqlp.addParam(id_srv);
		}
		sqlb.append(")");
		List<HPSrvorcaDO> hPSrvorcaDOLst=(List<HPSrvorcaDO>)new DAFacade().execQuery(sqlb.toString(), sqlp, new BeanListHandler(HPSrvorcaDO.class));
		if(hPSrvorcaDOLst!=null && hPSrvorcaDOLst.size()>0)
		{
			hPSrvorcaDOArr=hPSrvorcaDOLst.toArray(new HPSrvorcaDO[0]);
		}
		
		return hPSrvorcaDOArr;
	}
	/**
	 * 获取真实使用的医保计划
	 * @param hpId
	 * @return
	 */
	private String getRealHpId(String hpId) throws BizException{
		IHpMDORService iHpMDORService = ServiceFinder.find(IHpMDORService.class);
		HPDO hpDO = iHpMDORService.findById(hpId);
		if (hpDO == null) {
			throw new BizException("没有查询到医保计划");
		}
		if (!StringUtil.isEmptyWithTrim(hpDO.getId_par())) {
			// 复用医保计划
			hpDO = iHpMDORService.findById(hpDO.getId_par());
			if (hpDO == null) {
				throw new BizException("没有查询到复用的医保计划");
			}
		}
		return hpDO.getId_hp();
	}
}
