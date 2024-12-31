package iih.bl.cg.s.bp.op;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDOCudService;
import iih.bl.cg.blcgoep.i.IBlCgItmOepDORService;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.i.IBlincoepCudService;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.bl.st.blstoep.i.IBlstoepCudService;
import iih.bl.st.blstoep.i.IBlstoepRService;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;

/**
 * 
 * 清除预交金记账挂起数据
 * @author ly 2018/10/16
 *
 */
public class BlOpClearAccSuspDataBP {

	/**
	 * 清除预交金记账挂起数据
	 * @param orsrvIds 医嘱服务id数组
	 * @throws BizException
	 */
	public void exec(String[] orsrvIds) throws BizException{
	
		if(ArrayUtil.isEmpty(orsrvIds))
			return;
		
		//查询指定数据
		String[] stIds = this.getStId(orsrvIds);
		if(ArrayUtil.isEmpty(stIds))
			return;
		
		// 取消记账挂起
		this.cancelCgSusp(stIds);
		
		// 删除结算
		this.deleteStData(stIds);
		
		// 删除发票
		this.deleteIncData(stIds);
	}
	
	/**
	 * 查询结算id
	 * @param orsrvIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private String[] getStId(String[] orsrvIds) throws BizException{
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select distinct stoep.id_stoep ");
		sqlSb.append("from bl_cg_itm_oep cgitm ");
		sqlSb.append("inner join bl_cg_oep cgoep ");
		sqlSb.append("on cgitm.id_cgoep = cgoep.id_cgoep ");
		sqlSb.append("and cgoep.eu_direct = 1 ");
		sqlSb.append("inner join bl_st_oep stoep ");
		sqlSb.append("on cgitm.id_stoep = stoep.id_stoep ");
		sqlSb.append("and nvl(stoep.id_paypatoep,'~') = '~' ");
		sqlSb.append("where " + SqlUtils.getInSqlByIds("cgitm.id_orsrv", orsrvIds));
		sqlSb.append(" and cgitm.fg_acc = 'Y' ");
		
		DAFacade daf = new DAFacade();
		List<String> result = (List<String>)daf.execQuery(sqlSb.toString(), new ColumnListHandler());
	
		if(ListUtil.isEmpty(result))
			return null;
		
		return result.toArray(new String[0]);
	}

	/**
	 * 取消记账数据挂起状态
	 * @param stIds
	 * @throws BizException
	 */
	private void cancelCgSusp(String[] stIds) throws BizException{
		
		IBlCgItmOepDORService cgRService = ServiceFinder.find(IBlCgItmOepDORService.class);
		BlCgItmOepDO[] cgItms = cgRService.findByAttrValStrings(BlCgItmOepDO.ID_STOEP, stIds);
		if(ArrayUtil.isEmpty(cgItms))
			return;
		
		for (BlCgItmOepDO itmDO : cgItms) {
			itmDO.setId_stoep(null);
			itmDO.setFg_st(FBoolean.FALSE);
			itmDO.setFg_susp(FBoolean.FALSE);
			itmDO.setStatus(DOStatus.UPDATED);
		}
		
		IBlCgItmOepDOCudService cgCudService = ServiceFinder.find(IBlCgItmOepDOCudService.class);
		cgCudService.update(cgItms);
	}

	/**
	 * 删除结算数据
	 * @param stIds
	 * @throws BizException
	 */
	private void deleteStData(String[] stIds) throws BizException{
		
		IBlstoepRService stRService = ServiceFinder.find(IBlstoepRService.class);
		BlStOepDO[] stDos =  stRService.findByIds(stIds, FBoolean.FALSE);
		
		if(ArrayUtil.isEmpty(stDos))
			return;
		
		IBlstoepCudService stCudService = ServiceFinder.find(IBlstoepCudService.class);
		stCudService.delete(stDos);
	}
	
	/**
	 * 删除发票数据
	 * @param stIds
	 * @throws BizException
	 */
	private void deleteIncData(String[] stIds) throws BizException{
		
		IBlincoepRService incRService = ServiceFinder.find(IBlincoepRService.class);
		BlincoepAggDO[] incAggDos = incRService.findByAttrValStrings(BlIncOepDO.ID_STOEP, stIds);
		
		if(ArrayUtil.isEmpty(incAggDos))
			return;
		
		IBlincoepCudService incCudService = ServiceFinder.find(IBlincoepCudService.class);
		incCudService.delete(incAggDos);
	}
}
