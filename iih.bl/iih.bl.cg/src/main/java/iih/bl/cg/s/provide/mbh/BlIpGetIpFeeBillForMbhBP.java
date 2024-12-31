package iih.bl.cg.s.provide.mbh;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.cg.dto.mb.ipfeebill.d.BlCgIpFeeBillCondDTO;
import iih.bl.cg.dto.mb.ipfeebill.d.BlCgIpFeeBillDTO;
import iih.bl.cg.dto.mb.ipfeebill.d.BlCgIpFeeBillDetailDTO;
import iih.bl.cg.s.provide.mbh.qry.GetIpFeeBillForMbhQry;

import java.util.HashMap;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 查询住院患者费用清单
 * @author ly 2018/08/06
 *
 */
public class BlIpGetIpFeeBillForMbhBP {

	/**
	 * 查询住院患者费用清单
	 * @param cond
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlCgIpFeeBillDTO[] exec(BlCgIpFeeBillCondDTO cond) throws BizException {
		// 校验参数
		this.validate(cond);
		
		// 查询	
		BlCgIpFeeBillDetailDTO[] detailDtos = (BlCgIpFeeBillDetailDTO[]) AppFwUtil.getDORstWithDao(
				new GetIpFeeBillForMbhQry(cond), BlCgIpFeeBillDetailDTO.class);		
		
		if(ArrayUtil.isEmpty(detailDtos))
			return null;
		
		Map<String, BlCgIpFeeBillDTO> map = new HashMap<String, BlCgIpFeeBillDTO>();
		for (BlCgIpFeeBillDetailDTO detail : detailDtos) {
			BlCgIpFeeBillDTO head = null;
			if(map.containsKey(detail.getCode_type())){
				head = map.get(detail.getCode_type());
			}else{
				head = new BlCgIpFeeBillDTO();
				head.setCode_type(detail.getCode_type());
				head.setName_type(detail.getName_type());
				head.setAmt(FDouble.ZERO_DBL);
				head.setDetail(new FArrayList());
				
				map.put(detail.getCode_type(), head);
			}
			head.setAmt(head.getAmt().add(detail.getAmt()));
			head.getDetail().add(detail);
		}
		
		return map.values().toArray(new BlCgIpFeeBillDTO[0]);
	}
	
	/**
	 * 校验参数
	 * @param cond
	 * @throws BizException 
	 */
	private void validate(BlCgIpFeeBillCondDTO cond) throws BizException{
		
		if(cond == null){
			throw new ArgumentNullException("查询住院患者费用清单", "查询条件");
		}
		
		if(StringUtil.isEmpty(cond.getId_ent())){
			throw new ArgumentNullException("查询住院患者费用清单", "就诊id");
		}
	}
}
