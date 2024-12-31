package iih.bl.cg.s.bp.validate;

import iih.bd.base.exception.ArgumentNullException;
import iih.bd.pp.dto.priview.d.BdPriViewDTO;
import iih.bd.pp.i.IBdPriCalService;
import iih.bl.cg.dto.accenough.d.BlCgAccEnoughRltDTO;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.acc.dto.d.PatRelAmountInfoDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 校验账户余额是否大于指定服务价格
 * @author ly 2018/08/15
 *
 */
public class OpAccIsEnoughBP {

	/**
	 * 校验账户余额是否大于指定服务价格
	 * @param patId 患者id
	 * @param pripatId 患者价格分类
	 * @param srvIds 服务id数组
	 * @return
	 * @throws BizException
	 */
	public BlCgAccEnoughRltDTO exec(String patId, String pripatId, String[] srvIds) throws BizException{
		
		if(StringUtil.isEmpty(patId)){
			throw new ArgumentNullException("校验账户余额是否大于指定服务金额", "患者id");
		}
		
		if(StringUtil.isEmpty(pripatId)){
			throw new ArgumentNullException("校验账户余额是否大于指定服务金额", "患者价格分类");
		}
		
		if(ArrayUtil.isEmpty(srvIds)){
			throw new ArgumentNullException("校验账户余额是否大于指定服务金额", "服务id数组");
		}
		
		IPatAccServiceExt accService = ServiceFinder.find(IPatAccServiceExt.class);
		PatRelAmountInfoDTO accInfo = accService.GetPatRelAmountInfo(patId);
		
		if(accInfo == null){
			throw new ArgumentNullException("未查询到账户信息，患者id:" + patId);
		}
		
		IBdPriCalService priService = ServiceFinder.find(IBdPriCalService.class);
		BdPriViewDTO[] priDtos = priService.calSrvPrice(srvIds, new String[] { pripatId });
		
		BlCgAccEnoughRltDTO rltDto = new BlCgAccEnoughRltDTO();
		rltDto.setResult(FBoolean.TRUE);
		rltDto.setAcc_canuse(accInfo.getMoney_canuse());
		
		if(ArrayUtil.isEmpty(priDtos)){
			return rltDto;
		}
		
		FDouble srvAmt = FDouble.ZERO_DBL;
		for (BdPriViewDTO bdPriViewDTO : priDtos) {
			srvAmt = srvAmt.add(bdPriViewDTO.getPrice_ratio());
		}
		
		rltDto.setSrv_amt(srvAmt);
		rltDto.setResult(rltDto.getAcc_canuse().compareTo(rltDto.getSrv_amt()) >= 0 ? 
				FBoolean.TRUE : FBoolean.FALSE);
		
		return rltDto;
	} 
}
