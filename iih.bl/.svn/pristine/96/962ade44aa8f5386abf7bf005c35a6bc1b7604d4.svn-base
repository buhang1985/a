package iih.bl.cg.s.bp.ip;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountDTO;
import iih.bl.cg.dto.cglogic.d.BlCgRefundAccountSetDTO;
import iih.bl.cg.dto.cglogic.d.RefundModeEnum;
import iih.bl.cg.i.IBlCgAccountService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 
 * 医嘱作废时退记账
 * @author ly 2018/09/25
 *
 */
public class BlIpRefundForOrderCancelBP {

	/**
	 * 医嘱作废时退记账
	 * @param orIds
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public void refundForIpOrderCancel(String[] orIds) throws BizException{
	
		if(ArrayUtil.isEmpty(orIds))
			return;
		
		//查询记账数据
		DAFacade daf  = new DAFacade();
		String cond = SqlUtils.getInSqlByIds("id_or", orIds) + " and fg_refund = 'N' and eu_direct = 1 ";
		
		List<BlCgIpDO> cgList = (List<BlCgIpDO>) daf.findByCond(BlCgIpDO.class,
				cond, new String[] { BlCgIpDO.ID_CGIP, BlCgIpDO.ID_ENT, BlCgIpDO.ID_PAT, BlCgIpDO.QUAN, BlCgIpDO.QUAN_RET });
		if(ListUtil.isEmpty(cgList))
			return;
		
		//退记账
		List<BlCgRefundAccountDTO> accDtoList = new ArrayList<BlCgRefundAccountDTO>();
		for (BlCgIpDO cgIpDO : cgList) {
			
			if(cgIpDO.getQuan().equals(cgIpDO.getQuan_ret()))
				continue;
			
			BlCgRefundAccountDTO accDto = new BlCgRefundAccountDTO();
			accDto.setId_pat(cgIpDO.getId_pat());
			accDto.setId_ent(cgIpDO.getId_ent());
			accDto.setId_cg(cgIpDO.getId_cgip());
			accDto.setQuan(cgIpDO.getQuan().sub(cgIpDO.getQuan_ret()));
			
			accDtoList.add(accDto);
		}
		
		if(accDtoList.size() == 0)
			return;
		
		BlCgRefundAccountSetDTO setDto = new BlCgRefundAccountSetDTO();
		setDto.setSrcfunc_des("BlIpRefundForOrderCancelBP");
		setDto.setEu_rfdmode(RefundModeEnum.CG_KEY);
		
		IBlCgAccountService accountService = ServiceFinder.find(IBlCgAccountService.class);
		accountService.refundAccountForIp(accDtoList.toArray(new BlCgRefundAccountDTO[0]), setDto);
	}
}
