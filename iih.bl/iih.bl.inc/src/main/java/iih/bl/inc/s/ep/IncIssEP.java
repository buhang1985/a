package iih.bl.inc.s.ep;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bl.comm.IBlMsgConst;
import iih.bl.inc.blinccanc.d.BlIncCancDO;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.blinciss.d.desc.BlIncIssDODesc;
import iih.bl.inc.blinciss.i.IBlincissCudService;
import iih.bl.inc.blinciss.i.IBlincissRService;
import iih.bl.inc.s.util.InvoiceCalUtil;
import iih.bl.params.BlParamValueConst;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 发票领用扩展类
 * @author ly 2018/03/30
 *
 */
public class IncIssEP {

	private static Map<String,String> INCCA_MAG_MAP = null;
	static{
		INCCA_MAG_MAP = new HashMap<String,String>();
		INCCA_MAG_MAP.put(IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE, IBlMsgConst.ERROR_INCISS_MZFP_ALERT);
		INCCA_MAG_MAP.put(IBdPpCodeTypeConst.ID_INHOS_INVOICE, IBlMsgConst.ERROR_INCISS_ZYFP_ALERT);
		INCCA_MAG_MAP.put(IBdPpCodeTypeConst.ID_OUTPATIENT_DEPOSIT, IBlMsgConst.ERROR_INCISS_MZYJT_ALERT);
		INCCA_MAG_MAP.put(IBdPpCodeTypeConst.ID_INHOS_DEPOSIT, IBlMsgConst.ERROR_INCISS_ZYYJT_ALERT);
		INCCA_MAG_MAP.put(IBdPpCodeTypeConst.ID_ET_INVOICE, IBlMsgConst.ERROR_INCISS_JZFP_ALERT);
		INCCA_MAG_MAP.put(IBdPpCodeTypeConst.ID_OUTREGISTER_INVIOCE, IBlMsgConst.ERROR_INCISS_GHFP_ALERT);
	}
	
	/**
	 * 获取人员正在使用的票据数据
	 * @param empId
	 * @param hostId
	 * @param inccaId
	 * @return
	 */
	public BlIncIssDO findUsingInc(String empId, String hostId, String inccaId) throws BizException{
		
		String whereSql = "";
		
		String pcIncs = BlParams.BLINC0013();
		if(BlParamValueConst.BLINC0012_PC.equals(BlParams.BLINC0012()) && 
				!StringUtil.isEmpty(pcIncs) && pcIncs.contains(inccaId)){
			String idPc = BlParams.getRealPcId(hostId);
			if(StringUtil.isEmpty(idPc)){
				throw new BizException(IBlMsgConst.ERROR_INCISS_NOPC_ALERT);
			}
			whereSql = String.format("%s.%s = '%s' and %s.%s = '%s' and %s.%s = 'Y'",
					BlIncIssDODesc.TABLE_ALIAS_NAME, BlIncIssDO.ID_PC, idPc,
					BlIncIssDODesc.TABLE_ALIAS_NAME, BlIncIssDO.ID_INCCA, inccaId,
					BlIncIssDODesc.TABLE_ALIAS_NAME, BlIncIssDO.FG_CURUSE);
			
		}else{
			 whereSql = String.format("%s.%s = '%s' and %s.%s = '%s' and %s.%s = 'Y'",
					BlIncIssDODesc.TABLE_ALIAS_NAME, BlIncIssDO.ID_EMP_ISS, empId,
					BlIncIssDODesc.TABLE_ALIAS_NAME, BlIncIssDO.ID_INCCA, inccaId,
					BlIncIssDODesc.TABLE_ALIAS_NAME, BlIncIssDO.FG_CURUSE);
		}
		
		IBlincissRService rService = ServiceFinder.find(IBlincissRService.class);
		BlIncIssDO[] dos = rService.find(whereSql, "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(dos)){
			throw new BizException(INCCA_MAG_MAP.get(inccaId));
		}
		
		return dos[0];
	}
	
	/**
	 * 更新票据包当前票号为下个可用票号
	 * @param incInfo 票据信息
	 * @param cancInfo 废票信息
	 * @param incno 当前发票号
	 * @return
	 * @throws BizException
	 */
	public BlIncIssDO updateNextProvince(BlIncIssDO incInfo, BlIncCancDO[] cancInfo, String incno) throws BizException{
		// 计算下一张可用发票
		String nextInc = InvoiceCalUtil.nextAvailableInvoice(incno, cancInfo);
		if(nextInc == null || nextInc.compareTo(incInfo.getNum_e()) > 0){
			// 无可用票号
			incInfo.setInccn_use(0);
			incInfo.setIncno_cur(null);
			incInfo.setFg_curuse(FBoolean.FALSE);
			incInfo.setFg_active(FBoolean.FALSE);
			
			FBoolean fgUseNewPkg = BlParams.BLINC0016();
			if(FBoolean.TRUE.equals(fgUseNewPkg)){
				this.useNewPkg(incInfo);
			}
		}else{
			// 计算下一个发票 与当前在用发票差
			int diff = InvoiceCalUtil.calNumNetweenTwoInvoiceno(incInfo.getIncno_cur(), nextInc) - 1;
			incInfo.setInccn_use(incInfo.getInccn_use() - diff);
			incInfo.setIncno_cur(nextInc);
		}
		
		incInfo.setStatus(DOStatus.UPDATED);
		IBlincissCudService cudService = ServiceFinder.find(IBlincissCudService.class);
		return cudService.update(new BlIncIssDO[] { incInfo })[0];
	}

	/**
	 * 获取票据包指定数量的可用发票号
	 * 从当前可用号开始
	 * @param incIssId 票据包id
	 * @param num 数量
	 * @return
	 * @throws BizException
	 */
	public String[] getAvailableIncno(String incIssId, int num) throws BizException{
		
		if(StringUtil.isEmpty(incIssId)){
			throw new ArgumentNullException("获取票据包指定数量的可用发票号", "票据包id");
		}
		
		if(num <= 0){
			throw new BizException("获取的发票数量需要大于0");
		}
		
		IBlincissRService rService = ServiceFinder.find(IBlincissRService.class);
		BlIncIssDO incIssDO = rService.findById(incIssId);
		if(incIssDO == null){
			throw new BizException("获取票据数据失败");
		}
		
		String[] incnos = InvoiceCalUtil.nextInvoice(num, incIssDO);
		return incnos;
	}

	/**
	 * 启用新票据包
	 * @param oldIncInfo
	 * @throws BizException
	 */
	private void useNewPkg(BlIncIssDO oldIncInfo) throws BizException{
		
		String sql = "select * from bl_inc_iss where fg_active = 'Y' and fg_curuse = 'N' ";
		SqlParam param = new SqlParam();
		if(!StringUtil.isEmpty(oldIncInfo.getId_pc())){
			sql += " and id_pc = ? ";
			param.addParam(oldIncInfo.getId_pc());
		}else{
			sql += " and id_emp_iss = ? ";
			param.addParam(oldIncInfo.getId_emp_iss());
		}
		
		sql += " and id_incca = ? ";
		param.addParam(oldIncInfo.getId_incca());
		
		sql += " order by dt_iss ";
		
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<BlIncIssDO> incIssList = (List<BlIncIssDO>)daf.execQuery(sql, param, new BeanListHandler(BlIncIssDO.class));
	
		if(ListUtil.isEmpty(incIssList))
			return;
		
		BlIncIssDO first = incIssList.get(0);
		first.setFg_curuse(FBoolean.TRUE);
		first.setStatus(DOStatus.UPDATED);
		
		IBlincissCudService cudService = ServiceFinder.find(IBlincissCudService.class);
		cudService.update(new BlIncIssDO[] { first });
	}

	public BlIncIssDO findUsingInc(String empId, String hostId, String inccaId, String sdPttp) throws BizException {

		String whereSql = "";
		
		String pcIncs = BlParams.BLINC0013();
		//床旁结算开启计算机(住院发票或者押金条)或其他开启计算机
		boolean isPc = false;
		if(IBlDictCodeConst.SD_PTTP_BEDSIDE.equals(sdPttp) && (IBdPpCodeTypeConst.ID_INHOS_INVOICE.equals(inccaId) || IBdPpCodeTypeConst.ID_INHOS_DEPOSIT.equals(inccaId))){
			isPc = BlParamValueConst.BLINC0012_PC.equals(BlParams.BLINC0043());
		}else{
			isPc = BlParamValueConst.BLINC0012_PC.equals(BlParams.BLINC0012());
		}
		if(isPc && 	!StringUtil.isEmpty(pcIncs) && pcIncs.contains(inccaId)){
			String idPc = BlParams.getRealPcId(hostId);
			if(StringUtil.isEmpty(idPc)){
				throw new BizException(IBlMsgConst.ERROR_INCISS_NOPC_ALERT);
			}
			whereSql = String.format("%s.%s = '%s' and %s.%s = '%s' and %s.%s = 'Y'",
					BlIncIssDODesc.TABLE_ALIAS_NAME, BlIncIssDO.ID_PC, idPc,
					BlIncIssDODesc.TABLE_ALIAS_NAME, BlIncIssDO.ID_INCCA, inccaId,
					BlIncIssDODesc.TABLE_ALIAS_NAME, BlIncIssDO.FG_CURUSE);
			
		}else{
			 whereSql = String.format("%s.%s = '%s' and %s.%s = '%s' and %s.%s = 'Y'",
					BlIncIssDODesc.TABLE_ALIAS_NAME, BlIncIssDO.ID_EMP_ISS, empId,
					BlIncIssDODesc.TABLE_ALIAS_NAME, BlIncIssDO.ID_INCCA, inccaId,
					BlIncIssDODesc.TABLE_ALIAS_NAME, BlIncIssDO.FG_CURUSE);
		}
		
		IBlincissRService rService = ServiceFinder.find(IBlincissRService.class);
		BlIncIssDO[] dos = rService.find(whereSql, "", FBoolean.FALSE);
		if(ArrayUtil.isEmpty(dos)){
			throw new BizException(INCCA_MAG_MAP.get(inccaId));
		}
		return dos[0];
	}
}
