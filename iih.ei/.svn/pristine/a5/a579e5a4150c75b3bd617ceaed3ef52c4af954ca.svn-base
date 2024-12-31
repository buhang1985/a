package iih.ei.std.cr_technology.v1.s.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.TransactionStatus;

import iih.bd.webservice.WsResultMsgCode;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugParaItemBean;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugParamBean;
import iih.ei.std.cr_technology.v1.d.PivasDispDrugRstBean;
import iih.mp.dg.dto.ipdrugmp.d.IpDgDtDTO;
import iih.mp.dg.ipdgapp.d.IpDgApdeItmDO;
import iih.mp.dg.ipdgapp.i.IIpdgapdeCudService;
import iih.mp.dg.ipdgapp.i.IIpdgapdeRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.jdbc.tx.TransactionExecutor;
import xap.mw.jdbc.tx.TransactionalOperation;
import xap.mw.sf.core.util.ServiceFinder;

public class PivasDispDrugCommBp {
	
	public static final String OPER_TYPE_CHK = "校验";
	public static final String OPER_TYPE_DISP = "发药";
	
	/**
	 * 请领数据异常信息保存
	 * 
	 * @throws BizException
	 */
	public static void saveIpdgItem(final Map<String, IpDgDtDTO> invalidMap, FBoolean fg_hasTransa) throws BizException {
		
		if(fg_hasTransa.booleanValue()) {
			TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
				@Override
				public String doInTransaction(TransactionStatus arg0) {
					try {
						saveIpdgItem(invalidMap);
					} catch (Exception e) {
					}
					return null;
				}
			});
		} else {
			saveIpdgItem(invalidMap);
		}
	}
	
	/**
	 * 请领数据异常信息保存
	 * 
	 * @throws BizException
	 */
	private static void saveIpdgItem(Map<String, IpDgDtDTO> invalidMap) throws BizException {
		IIpdgapdeRService apdeRService = ServiceFinder.find(IIpdgapdeRService.class);
		IIpdgapdeCudService apdeCudService = ServiceFinder.find(IIpdgapdeCudService.class);
		if(invalidMap == null || invalidMap.size() <= 0)
			return;
		IpDgApdeItmDO[] apDeItemDOs = apdeRService.findByIds(invalidMap.keySet().toArray(new String[0]), FBoolean.TRUE);
		for(IpDgApdeItmDO itemDO : apDeItemDOs) {
			IpDgDtDTO itemDTO = invalidMap.get(itemDO.getId_dgipdt());
			itemDO.setStatus(DOStatus.UPDATED);
			if(StringUtils.isBlank(itemDO.getId_dgipde())) {
				itemDO.setEn_opap(itemDTO.getEn_opap());
				itemDO.setEn_opde(itemDTO.getEn_opde());
			}
			itemDO.setNote(itemDTO.getNote());
		}
		apdeCudService.save(apDeItemDOs);
	}
	
	/**
	 * 记录发药失败原因
	 * 
	 * @throws BizException
	 */
	public static void recordFailNote(final IpDgDtDTO[] dgdtList, final Exception ex, final String oper_type) {
		
		TransactionExecutor.executeNewTransaction(new TransactionalOperation<String>() {
			@Override
			public String doInTransaction(TransactionStatus arg0) {
				try {
					//更新摆药失败原因
					IIpdgapdeRService apdeRService = ServiceFinder.find(IIpdgapdeRService.class);
					IIpdgapdeCudService apdeCudService = ServiceFinder.find(IIpdgapdeCudService.class);
					String note = oper_type + ":" + ex.getMessage();
					List<String> ids = new ArrayList<String>();
					for(IpDgDtDTO dtDTO : dgdtList) {
						ids.add(dtDTO.getId_dgipdt());
					}
					IpDgApdeItmDO[] result = apdeRService.findByIds(ids.toArray(new String[0]), FBoolean.TRUE);
					if(result == null || result.length <= 0)
						return null;
					for(IpDgApdeItmDO itemDO : result) {
						itemDO.setStatus(DOStatus.UPDATED);
						String oringnote = StringUtils.isBlank(itemDO.getNote()) ? "" : itemDO.getNote();
						if(oringnote.indexOf(note) < 0) {
							String itemnote = oringnote + "," + note;
							itemDO.setNote(itemnote);
						}
					}
					apdeCudService.update(result);
				} catch (Exception e) {
				}
				return null;
			}
		});
	}
	
	/**
	 * 成功结果
	 * 
	 * @throws BizException
	 */
	public static PivasDispDrugRstBean iniSuccRstBean(PivasDispDrugParamBean paramBean) {
		PivasDispDrugRstBean rstBean = new PivasDispDrugRstBean();
		rstBean.setOrderNo(paramBean.getOrderNo());
		rstBean.setOrderSrvPlanTime(paramBean.getOrderSrvPlanTime());
		rstBean.setOrderPrSrvID(paramBean.getOrderPrSrvID());
		rstBean.setResultCode(WsResultMsgCode.SUCCESS);
		rstBean.setResultMsg("发药成功");
		
		return rstBean;
	}
	
	/**
	 * 异常结果
	 * 
	 * @throws BizException
	 */
	public static PivasDispDrugRstBean initExcRstBean(PivasDispDrugParamBean paramBean, Exception e) {
		PivasDispDrugRstBean rstBean = new PivasDispDrugRstBean();
		if(paramBean == null) {
			rstBean.setOrderNo("");
			rstBean.setOrderSrvPlanTime("");
			rstBean.setOrderPrSrvID(new PivasDispDrugParaItemBean[] {});
		} else {
			rstBean.setOrderNo(paramBean.getOrderNo());
			rstBean.setOrderSrvPlanTime(paramBean.getOrderSrvPlanTime());
			rstBean.setOrderPrSrvID(paramBean.getOrderPrSrvID());
		}
		rstBean.setResultCode(WsResultMsgCode.ERROR);
		rstBean.setResultMsg(e.getMessage());
		
		return rstBean;
	}
}
