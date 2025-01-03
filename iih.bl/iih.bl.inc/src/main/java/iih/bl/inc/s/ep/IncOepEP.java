package iih.bl.inc.s.ep;

import java.util.Arrays;
import java.util.Comparator;

import iih.bd.base.utils.SqlUtils;
import iih.bl.comm.util.BlFlowContextUtil;
import iih.bl.inc.blincoep.d.BlIncOepDO;
import iih.bl.inc.blincoep.d.BlincoepAggDO;
import iih.bl.inc.blincoep.d.desc.BlIncOepDODesc;
import iih.bl.inc.blincoep.i.IBlincoepMDOCudService;
import iih.bl.inc.blincoep.i.IBlincoepRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 门诊发票扩展类
 * @author ly 2018/04/07
 *
 */
public class IncOepEP {

	/**
	 * 根据结算id查询发票信息
	 * @param stIds 结算id
	 * @return
	 * @throws BizException
	 */
	public BlincoepAggDO[] findIncByStId(String... stIds) throws BizException{
		
		IBlincoepRService rService = ServiceFinder.find(IBlincoepRService.class);
		String whereSql = "";
		if (stIds.length == 1) {
			whereSql = BlIncOepDODesc.TABLE_ALIAS_NAME + ".id_stoep = '" + stIds[0] + "'";
		} else {
			whereSql = SqlUtils.getInSqlByIds(BlIncOepDODesc.TABLE_ALIAS_NAME + ".id_stoep", stIds);
		}
		
		BlincoepAggDO[] aggDos = rService.find(whereSql, BlIncOepDODesc.TABLE_ALIAS_NAME + ".incno", FBoolean.FALSE);
		//当无票号时排序
		if(!ArrayUtil.isEmpty(aggDos) && aggDos.length > 1 && 
				StringUtil.isEmpty(aggDos[0].getParentDO().getIncno())){
			Arrays.sort(aggDos, new OpIncComparator());
		}
		return aggDos;
	}
	
	private class OpIncComparator implements Comparator<BlincoepAggDO>{

		@Override
		public int compare(BlincoepAggDO o1, BlincoepAggDO o2) {
			
			Integer cgItmNum1 = ArrayUtil.isEmpty(o1.getBlIncCgItmOep()) ? 0 : o1.getBlIncCgItmOep().length;
			Integer cgItmNum2 = ArrayUtil.isEmpty(o2.getBlIncCgItmOep()) ? 0 : o2.getBlIncCgItmOep().length;

			BlIncOepDO headDO1 = o1.getParentDO();
			BlIncOepDO headDO2 = o2.getParentDO();

			int comp = headDO1.getId_stoep().compareTo(headDO2.getId_stoep());
			if (comp != 0)
				return comp;

			comp = cgItmNum2.compareTo(cgItmNum1);
			if (comp != 0)
				return comp;
			
			comp = headDO1.getId_incoep().compareTo(headDO2.getId_incoep());
			return comp;
		}
	}
	
	/**
	 * 回写电子发票属性
	 * @param incDO
	 * @throws BizException
	 * @author ly 2019/12/16
	 */
	public void writebackEcIncInfo(BlIncOepDO incDO) throws BizException{
		
		//重新查询
		DAFacade daf = new DAFacade();
		BlIncOepDO oldIncDO = (BlIncOepDO)daf.findByPK(BlIncOepDO.class, incDO.getId_incoep());
		oldIncDO.setIncno(incDO.getIncno());
		oldIncDO.setFg_ec_inc(incDO.getFg_ec_inc());
		oldIncDO.setEc_inc_code(incDO.getEc_inc_code());
		oldIncDO.setEc_inc_checkno(incDO.getEc_inc_checkno());
		oldIncDO.setEc_url(incDO.getEc_url());
		oldIncDO.setEc_net_url(incDO.getEc_net_url());
		
		oldIncDO.setFg_ec_inc(FBoolean.TRUE);
		oldIncDO.setFg_print(FBoolean.TRUE);
		if(StringUtil.isEmpty(incDO.getId_emp_inc())){
			oldIncDO.setId_emp_inc(BlFlowContextUtil.getEmpId());
		}else{
			oldIncDO.setId_emp_inc(incDO.getId_emp_inc());
		}
		oldIncDO.setDt_inc(BlFlowContextUtil.getNowTime());
		oldIncDO.setStatus(DOStatus.UPDATED);
		
		IBlincoepMDOCudService incService = ServiceFinder.find(IBlincoepMDOCudService.class);
		incService.update(new BlIncOepDO[] { oldIncDO });
	}
}
