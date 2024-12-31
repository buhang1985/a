package iih.pi.card.s.bp.cardmanage;

import iih.pi.card.dto.d.CardManageDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

public class CardCodeCheckBP {

	/**
	 * 卡号逻辑校验处理
	 * @param dto
	 * @throws BizException
	 */
	public void exec(CardManageDTO dto) throws BizException{
		
		if(StringUtil.isEmpty(dto.getCode_begin()))
			throw new BizException("请输入起始卡号");

		if(StringUtil.isEmpty(dto.getCode_end()))
			throw new BizException("请输入终止卡号");
			
		if(dto.getCode_begin().length() != dto.getCode_end().length())
			throw new BizException("起始卡号与终止卡号长度不等，请重新输入正确的卡号");
		
		int begin = 0;
		int end = 0;
		
		String[] beginA = CardCodeUtil.subString(dto.getCode_begin());
		String[] endA = CardCodeUtil.subString(dto.getCode_end());
		
		if(!beginA[0].equals(endA[0])){
			throw new BizException("起始卡号与终止卡号之差超出计算范围");
		}
		
		try {
			begin = Integer.parseInt(beginA[1]);
			end = Integer.parseInt(endA[1]);
		} catch (NumberFormatException e) {
			throw new BizException("卡号只能输入0~9");
		}
		
		if(end < begin)
			throw new BizException("起始卡号必须小于终止卡号");
		
	}
}
