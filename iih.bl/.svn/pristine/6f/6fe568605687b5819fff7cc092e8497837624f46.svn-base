package iih.bl.pay.s.bp;

import iih.bl.comm.util.BlCodeUtils;
import iih.bl.st.blstip.d.BlStIpDO;
import iih.bl.st.blstip.i.IBlstipCudService;
import iih.bl.st.blstip.i.IBlstipRService;

import org.apache.commons.lang.ArrayUtils;

import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医保交易撤消后，调用此接口
 * @author liwq
 */
public class UpdateCodeStBp {

	public FBoolean exec(String idEnt,String idStIp) throws BizException {
		if(StringUtils.isEmpty(idEnt))
			return FBoolean.FALSE;
		
		IBlstipRService stRService = ServiceFinder.find(IBlstipRService.class);
		IBlstipCudService stCudService = ServiceFinder.find(IBlstipCudService.class);
		String newCodeSt = BlCodeUtils.generateIpStCode();
		if (!StringUtils.isEmpty(idStIp)) {		
			// 1. 检验原结算是否被取消
			BlStIpDO rtnStIpDo = stRService.findById(idStIp);
			if (rtnStIpDo == null && rtnStIpDo.getFg_canc().booleanValue()) {
				throw new BizException("原结算信息已被取消,请重新进行结算操作！");
			}
			//2. 更新结算表中Code_st字段	
			rtnStIpDo.setCode_st(newCodeSt);
			rtnStIpDo.setStatus(DOStatus.UPDATED);
			BlStIpDO[] results = stCudService.save(new BlStIpDO[]{ rtnStIpDo });
			if(ArrayUtils.isEmpty(results)){
				return FBoolean.FALSE;
			} else{
				return FBoolean.TRUE;
			}
		} else{
			BlStIpDO[] stDOs = stRService.find(" fg_pay = 'N' and id_ent = '"+ idEnt +"' ", "", FBoolean.TRUE);
			if(!ArrayUtils.isEmpty(stDOs)){
				stDOs[0].setCode_st(newCodeSt);
				stDOs[0].setStatus(DOStatus.UPDATED);
				BlStIpDO[] results = stCudService.save(new BlStIpDO[]{ stDOs[0] });
				if(ArrayUtils.isEmpty(results)){
					return FBoolean.FALSE;
				} else{
					return FBoolean.TRUE;
				}
			} else {
				return FBoolean.TRUE;
			}
		}
		
	}
}
