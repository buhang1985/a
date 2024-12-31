package iih.mi.mc.s.ctrlcore.mimcwholecheck.rule;

import iih.bd.base.utils.DateTimeUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.params.BlParams;
import iih.ci.ord.i.external.provide.ICiOrdMiService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

import com.core.AppUtils;

/**
 * 整体开单校验基类
 * @author liming
 *
 */
public class MiCheckBaseRule {

	/**
	 * 获取患者当月开单量
	 * @param idPat
	 * @return
	 * @throws BizException 
	 */
	public FMap getPatDrugMap(String idPat) throws BizException {
		FDateTime dt_begin=this.getLoadBeginDate();//开始时间
		FDateTime dt_end=AppUtils.getServerDateTime();//结束时间
		
		//1.获取未记账的医嘱信息
		ICiOrdMiService ser = ServiceFinder.find(ICiOrdMiService.class);
		FMap patDrugMap=ser.getPatHistoryMmInfo(idPat, dt_begin, dt_end);
		if(patDrugMap==null){
			patDrugMap= new FMap();
		}
		//2.获取已经记账的物品数量
		List<BlCgItmOepDO> miOrSrvlist=this.getPatCurrentMonthCgMm(idPat, dt_begin, dt_end);
		if(!ListUtil.isEmpty(miOrSrvlist)){
			for(BlCgItmOepDO itm :miOrSrvlist){
				if(patDrugMap.containsKey( itm.getId_mm())){
					FDouble quan= (FDouble)patDrugMap.get(itm.getId_mm());
					patDrugMap.put(itm.getId_mm(), quan.add(itm.getQuan()));
				}else{
					patDrugMap.put(itm.getId_mm(), itm.getQuan());
				}
			}
		}
		return patDrugMap;
	}
	

	/**
	 * 获取当月患者已开药总数量
	 * @param idPat
	 * @param dt_begin
	 * @param dt_end
	 * @return
	 * @throws DAException
	 */
	private List<BlCgItmOepDO> getPatCurrentMonthCgMm(String idPat,FDateTime dt_begin,FDateTime dt_end) throws DAException{
		StringBuffer buffer = new StringBuffer();
		//已记账的医嘱信息
		buffer.append("select srv.id_dsdef || itm.id_mm as id_mm,sum(cg.eu_direct* itm.quan* srvmm.factor* srvmm.factor_mb) as quan "); 
		buffer.append("  from bl_cg_oep cg inner join bl_cg_itm_oep itm on cg.id_cgoep=itm.id_cgoep");
		buffer.append(" inner join ci_or_srv_mm srvmm on itm.id_orsrv=srvmm.id_orsrv");
		buffer.append(" inner join ci_or_srv srv on srv.id_orsrv=srvmm.id_orsrv");
		buffer.append("  where itm.fg_mm='Y' and nvl(srv.id_dsdef,'~')<>'~'  and  itm.id_pat=? and  cg.dt_cg>=? and cg.dt_cg<=?");
		buffer.append(" group by srv.id_dsdef||itm.id_mm");

		SqlParam param= new SqlParam();
		param.addParam(idPat);
		param.addParam(dt_begin);
		param.addParam(dt_end);
		
		@SuppressWarnings("unchecked")
		List<BlCgItmOepDO> miOrSrvlist= (List<BlCgItmOepDO>) new DAFacade().execQuery(buffer.toString(), param,new BeanListHandler(BlCgItmOepDO.class));
		return miOrSrvlist;
	}
	
	/**
	 * 获取查询医嘱的开始时间
	 * @return
	 * @throws BizException
	 */
	private FDateTime getLoadBeginDate() throws BizException{
		//默认医嘱调入天数
		int loadDays=BlParams.BLSTOEP0004();
		FDateTime tmp_dt_begin1=DateTimeUtils.getDateTimeBefore(AppUtils.getServerDateTime(), loadDays);
		FDateTime tmp_dt_begin2 =DateTimeUtils.getCurrentMonthBeginDate(AppUtils.getServerDateTime());
		return DateTimeUtils.getLarger(tmp_dt_begin1,tmp_dt_begin2);
	}
}
