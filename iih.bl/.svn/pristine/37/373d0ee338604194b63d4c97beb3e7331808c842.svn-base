package iih.bl.pay.s.bp.op;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.utils.SqlUtils;
import iih.bl.pay.blspclpat.d.BlSpclPatDO;
import iih.bl.pay.blspclpat.d.BlspclpatAggDO;
import iih.bl.pay.blspclpat.d.desc.BlSpclPatDODesc;
import iih.bl.pay.blspclpat.i.IBlspclpatRService;
import iih.bl.pay.dto.blspclpatamt.d.BlSpclPatAmtDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据数据来源查询专用款金额信息
 * @author ly 2018/05/21
 *
 */
public class GetSpclPatAmtBP {

	/**
	 * 根据数据来源查询专用款金额信息
	 * @param srcIds
	 * @return
	 * @throws BizException
	 */
	public BlSpclPatAmtDTO[] exec(String[] srcIds) throws BizException{
	
		if(ArrayUtil.isEmpty(srcIds)){
			return null;
		}
		
		IBlspclpatRService service = ServiceFinder.find(IBlspclpatRService.class);
		String fieldName = BlSpclPatDODesc.TABLE_ALIAS_NAME + "." + BlSpclPatDO.ID_SRC;
		String whereSql = SqlUtils.getInSqlByIds(fieldName, srcIds);
		
		BlspclpatAggDO[] aggDos = service.find(whereSql, "", FBoolean.FALSE);
		
		List<BlSpclPatAmtDTO> rltList = new ArrayList<BlSpclPatAmtDTO>();
		for (String srcId : srcIds) {
			
			BlSpclPatAmtDTO dto = new BlSpclPatAmtDTO();
			dto.setId_src(srcId);
			dto.setFg_pay(FBoolean.FALSE);
			rltList.add(dto);
			if(ArrayUtil.isEmpty(aggDos)){
				continue;
			}
			
			for (BlspclpatAggDO aggDO : aggDos) {
				if(srcId.equals(aggDO.getParentDO().getId_src())){
					dto.setAmt(aggDO.getParentDO().getAmt());
					dto.setFg_pay(FBoolean.TRUE);
					break;
				}
			}
		}
		
		return rltList.toArray(new BlSpclPatAmtDTO[0]);
	}
}
