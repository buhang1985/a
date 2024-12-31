package iih.bl.pay.s.ep;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.utils.AppUtils;
import iih.bd.base.utils.MapUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.base.utils.StringUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bl.comm.util.BlCodeUtils;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.i.IBlIncUtilService;
import iih.bl.params.BlParams;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.prepaypatrcpt.d.BlPrepayPatRcptDO;
import iih.bl.pay.prepaypatrcpt.d.desc.BlPrepayPatRcptDODesc;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptCudService;
import iih.bl.pay.prepaypatrcpt.i.IPrepaypatrcptRService;
import iih.bl.pay.s.bp.util.PrepayReceiptAssembleUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 预交金票据记录EP
 * @author ly 2018/06/20
 *
 */
public class PrepayPatRcptEP {

	/**
	 * 查询最近一次票据记录
	 * @param prepayId
	 * @return
	 * @throws BizException
	 */
	public BlPrepayPatRcptDO findLastRcptByPrepayId(String prepayId) throws BizException{
	
		IPrepaypatrcptRService rService = ServiceFinder.find(IPrepaypatrcptRService.class);
		String whereSql = String.format(BlPrepayPatRcptDODesc.TABLE_ALIAS_NAME + "." 
				+ BlPrepayPatRcptDO.ID_PAYPAT + " = '%s'", prepayId);
		
		BlPrepayPatRcptDO[] dos = rService.find(whereSql, BlPrepayPatRcptDO.PRINT_TIMES, FBoolean.FALSE);
		if(ArrayUtil.isEmpty(dos))
			return null;
		
		return dos[dos.length - 1];
	}
	
	/**
	 * 查询最近一次票据记录(批量)
	 * @param prepayIds
	 * @return
	 * @throws BizException
	 */
	public BlPrepayPatRcptDO[] findLastRcptByPrepayIds(String[] prepayIds) throws BizException{
		
		if(ArrayUtil.isEmpty(prepayIds))
			return null;
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select rcpt.* ");
		sqlSb.append("from bl_prepay_pat_rcpt rcpt ");
		sqlSb.append("inner join ");
		sqlSb.append("(select id_paypat, max(print_times) print_times ");
		sqlSb.append("from bl_prepay_pat_rcpt ");
		sqlSb.append("where " + SqlUtils.getInSqlByIds("id_paypat", prepayIds) + " ");
		sqlSb.append("group by id_paypat) maxrcpt ");
		sqlSb.append("on rcpt.id_paypat = maxrcpt.id_paypat ");
		sqlSb.append("and rcpt.print_times = maxrcpt.print_times ");
		
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<BlPrepayPatRcptDO> doList = (List<BlPrepayPatRcptDO>)daf.execQuery(
				sqlSb.toString(), new BeanListHandler(BlPrepayPatRcptDO.class));
		
		if(ListUtil.isEmpty(doList))
			return null;
		
		return doList.toArray(new BlPrepayPatRcptDO[0]);
	}
	
	/**
	 * 查询最近一次票据记录(批量)
	 * @param prepayIds
	 * @return key:预交金id value:票据数据
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public Map<String,BlPrepayPatRcptDO> findLastRcptByPrepayIdsToMap(String[] prepayIds) throws BizException{
		
		if(ArrayUtil.isEmpty(prepayIds))
			return new HashMap<String,BlPrepayPatRcptDO>();
		
		BlPrepayPatRcptDO[] rcptDos = this.findLastRcptByPrepayIds(prepayIds);
		return (Map<String, BlPrepayPatRcptDO>) MapUtils.convertArrayToMap(
				rcptDos, BlPrepayPatRcptDO.ID_PAYPAT);
	}
	
	/**
	 * 更新打印次数(重打时)
	 * @param rcptDO
	 * @return
	 * @throws BizException
	 */
	public BlPrepayPatRcptDO refreshPrintTimes(BlPrepayPatRcptDO rcptDO) throws BizException{
		
		IPrepaypatrcptCudService cudService = ServiceFinder.find(IPrepaypatrcptCudService.class);
		rcptDO.setPrint_times(rcptDO.getPrint_times() + 1);
		rcptDO.setId_emp_rcpt(Context.get().getStuffId());
		rcptDO.setDt_receipt(AppUtils.getServerDateTime());
		rcptDO.setStatus(DOStatus.UPDATED);
		
		return cudService.update(new BlPrepayPatRcptDO[]{rcptDO})[0];
	}

	/**
	 * 保存票据打印数据(带过号功能)
	 * @param prepayDO
	 * @param incIssDO
	 * @return
	 * @throws BizException
	 */
	public BlPrepayPatRcptDO saveRcptPrint(BlPrePayPatDO prepayDO, BlIncIssDO incIssDO) throws BizException {

		IBlIncUtilService incService = ServiceFinder.find(IBlIncUtilService.class);
		
		String autoCode = this.autoCode(prepayDO);
		
		IPrepaypatrcptCudService cudService = ServiceFinder.find(IPrepaypatrcptCudService.class);
		
		if(StringUtil.isEmpty(autoCode)){
			if(incIssDO == null){
				incIssDO = incService.getCurInvoiceDO(StringUtils.isNotEmpty(prepayDO.getId_emp_pay()) ? prepayDO.getId_emp_pay() : Context.get().getStuffId(), Context.get().getClientHost(), prepayDO.getId_incca());
			}
			
			BlPrepayPatRcptDO rcptDO = PrepayReceiptAssembleUtil.assemble(prepayDO, incIssDO.getCode_incpkg(),incIssDO.getIncno_cur(), 1, null);
			rcptDO = cudService.insert(new BlPrepayPatRcptDO[]{rcptDO})[0];
			
			incService.nextInvoiceNo(StringUtils.isNotEmpty(prepayDO.getId_emp_pay()) ? prepayDO.getId_emp_pay() : Context.get().getStuffId(), Context.get().getClientHost(),prepayDO.getId_incca());
			return rcptDO;
		}
		
		BlPrepayPatRcptDO rcptDO = PrepayReceiptAssembleUtil.assemble(prepayDO, null, autoCode, 1, null);
		rcptDO = cudService.insert(new BlPrepayPatRcptDO[]{rcptDO})[0];
		
		return rcptDO;
	}
	
	/**
	 * 保存票据打印数据(外部票号)
	 * @param prepayDO
	 * @param codeRep
	 * @return
	 * @throws BizException
	 */
	public BlPrepayPatRcptDO saveRcptPrintWithCode(BlPrePayPatDO prepayDO,String codeRep) throws BizException {

		IPrepaypatrcptCudService cudService = ServiceFinder.find(IPrepaypatrcptCudService.class);
		BlPrepayPatRcptDO rcptDO = PrepayReceiptAssembleUtil.assemble(prepayDO, null, codeRep, 1, null);
		rcptDO = cudService.insert(new BlPrepayPatRcptDO[]{rcptDO})[0];
		
		return rcptDO;
	}
	
	/**
	 * 自动生成票据号
	 * 如果是自动生成自返回票号，如果不是则返回空
	 * @param prepayDO
	 * @return
	 * @throws BizException
	 */
	private String autoCode(BlPrePayPatDO prepayDO) throws BizException{
		
		if(IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(prepayDO.getCode_enttp())){
			if(FBoolean.TRUE.equals(BlParams.BLINC0018())){
				return BlCodeUtils.generateIpPrepayCode();
			}
		}else{
			if(FBoolean.TRUE.equals(BlParams.BLINC0017())){
				return BlCodeUtils.generateOpPrepayCode();
			}
		}
		
		return null;
	}
}
