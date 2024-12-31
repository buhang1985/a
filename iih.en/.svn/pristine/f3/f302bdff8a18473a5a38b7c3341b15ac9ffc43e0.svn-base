package iih.en.pv.s.bp.op;

import iih.en.comm.IEnConst;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.ResultDTO;

import java.util.Map;
import java.util.Set;

import xap.mw.coreitf.d.FBoolean;

public class CheckPermitRegByMvelBp {

	/**
	 * 处理规则结果信息
	 * 
	 * @modifier fanlq 2019-07-18
	 * @param rstMap
	 * @return
	 */
	public ResultDTO DealResult(Map<String, Object> rstMap){
		if (rstMap == null)
			return null;
		Object obj = EnContextUtils.getCtxAttribute(IEnConst.KEYCTX_RULE_DEALTIPS);
		boolean isDealTips = obj==null? false :(boolean)obj; 
		StringBuilder rstSb = new StringBuilder();
		StringBuilder tipsSb = new StringBuilder();
		boolean rstFlag = true;
		Set<String> rstKetSet = rstMap.keySet();
		for (String key : rstKetSet) {
			Object result = rstMap.get(key);
			if(result == null)
				continue;
			try{
				String msg = (String)result;
				if(EnValidator.isEmpty(msg))
					continue;
				msg = msg.trim();
				boolean isTip = msg.trim().startsWith("1");
				msg = msg.substring(1);
				if(isDealTips && isTip){//需要处理提示信息
					tipsSb.append(msg);
				}else{
					rstFlag = false;
					rstSb.append(msg);
				}
			}catch (Exception e) {  
				continue;
			}  
		}
		ResultDTO rstDTO = new ResultDTO();
		rstDTO.setFlag(new FBoolean(rstFlag));
		rstDTO.setMsg(rstSb.toString());
		rstDTO.setMsg_tips(tipsSb.toString());
		return rstDTO;
	}

}
