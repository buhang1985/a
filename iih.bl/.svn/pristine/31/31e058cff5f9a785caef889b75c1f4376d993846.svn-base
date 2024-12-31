package iih.bl.pay.s.bp.op;

import iih.bd.pp.dto.priview.d.BdPriViewDTO;
import iih.bd.pp.i.IBdPriCalService;
import iih.bl.params.BlParams;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 获取患者
 * @author wq.li
 *
 */
public class GetMedrecordAmtBP {

	public FDouble exec (String patId) throws BizException{
		String srvIds = BlParams.BLCG0008();
		if(StringUtil.isEmpty(srvIds)){
			return FDouble.ZERO_DBL;
		}
		
		IPatiMDORService patRService=ServiceFinder.find(IPatiMDORService.class);
		PatDO patDo=patRService.findById(patId);
		if(patDo==null){
			throw new BizException("未查询到患者信息 id："+patId);
		}
		IBdPriCalService priCalService=ServiceFinder.find(IBdPriCalService.class);
		BdPriViewDTO[] priArr = priCalService.calSrvPrice(srvIds.split(","), new String[]{patDo.getId_patpritp()});
		FDouble amt=FDouble.ZERO_DBL;
		if(!ArrayUtil.isEmpty(priArr)){
			for (BdPriViewDTO bdPriViewDTO : priArr) {
				amt=amt.add(bdPriViewDTO.getPrice_ratio());
			}
		}
		return amt;
	}
}
