package iih.bl.cg.s.task;

import iih.bd.base.utils.AppUtils;
import iih.bl.cg.blcgoep.d.BlCgOepDO;
import iih.bl.cg.blcgoep.d.BlcgoepAggDO;
import iih.bl.cg.blcgoep.i.IBlcgoepRService;
import iih.bl.cg.service.s.bp.BLCiOrderToBlCgServiceImplBp;
import iih.bl.comm.log.BLTaskLogger;
import iih.bl.st.blstoep.d.StTypeEnum;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRServiceExt;

/**
 * 门诊定时删除挂起数据定时任务
 * @author ly 2018/10/17
 *
 */
public class OpDeleteSuspDataTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext bgContext) throws BizException {
		
		Map<String, Object> map = bgContext.getKeyMap();
		String hour = (String)map.get("hour");
		
		Integer intHour = 1;//默认删除小时前挂起数据
		try {
			intHour = Integer.parseInt(hour);
		} catch (Exception e) {
		}
		
		FDateTime now = AppUtils.getServerDateTime();
		FDateTime delTime = now.addSeconds(intHour * 3600 * -1);
		
		//多组织处理
		IOrgRServiceExt orgService = ServiceFinder.find(IOrgRServiceExt.class);
		OrgDO[] orgDos =  orgService.queryAllOrgUnitVOs();
		
		if(ArrayUtil.isEmpty(orgDos))
			return null;
		
		
		for (OrgDO orgDO : orgDos) {
			
			BLTaskLogger.info(String.format("组织%s门诊定时删除挂起数据定时任务开始", orgDO.getName()));
			Context.get().setGroupId(orgDO.getId_grp());
			Context.get().setOrgId(orgDO.getId_org());
			Context.get().setGroupNumber(orgDO.getGroupno());
			
			BlcgoepAggDO[] cgAggDos = this.getToDelSuspData(delTime);
			if(ArrayUtil.isEmpty(cgAggDos)){
				BLTaskLogger.info(String.format("组织%s门诊定时删除挂起数据定时任务,删除数据0条", orgDO.getName()));
				BLTaskLogger.info(String.format("组织%s门诊定时删除挂起数据定时任务结束", orgDO.getName()));
				continue;
			}
			
			// 待重构 TODO
			BLCiOrderToBlCgServiceImplBp bp = new BLCiOrderToBlCgServiceImplBp();
			bp.DeletePricingInfo_bp(cgAggDos, false);
			
			BLTaskLogger.info(String.format("组织%s门诊定时删除挂起数据定时任务,删除数据" 
					+ cgAggDos.length + "条", orgDO.getName()));
			BLTaskLogger.info(String.format("组织%s门诊定时删除挂起数据定时任务结束", orgDO.getName()));
		}
		
		return null;
	}
	
	/**
	 * 删除挂起数据
	 * @param delTime
	 * @return
	 * @throws BizException
	 */
	private BlcgoepAggDO[] getToDelSuspData(FDateTime delTime) throws BizException {
		
		// 查询挂起结算数据
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select distinct cgitm.id_cgoep ");
		sqlSb.append("from bl_st_oep stoep ");
		sqlSb.append("inner join bl_cg_itm_oep cgitm ");
		sqlSb.append("on stoep.id_stoep = cgitm.id_stoep ");
		sqlSb.append("where stoep.dt_st <= ? ");
		sqlSb.append("and nvl(stoep.id_paypatoep,'~') = '~' ");
		sqlSb.append("and eu_sttp = ? ");
		
		SqlParam param = new SqlParam();
		param.addParam(delTime);
		param.addParam(StTypeEnum.ST_OEP_CHARGE);
		
		@SuppressWarnings("unchecked")
		List<String> cgIdList = (List<String>)new DAFacade().execQuery(sqlSb.toString(), param, new ColumnListHandler());
		if(ListUtil.isEmpty(cgIdList))
			return null;
		
		IBlcgoepRService cgRService = ServiceFinder.find(IBlcgoepRService.class);
		BlcgoepAggDO[] aggDos = cgRService.findByAttrValStrings(BlCgOepDO.ID_CGOEP, cgIdList.toArray(new String[0]));
		
		return aggDos;
	}
}
