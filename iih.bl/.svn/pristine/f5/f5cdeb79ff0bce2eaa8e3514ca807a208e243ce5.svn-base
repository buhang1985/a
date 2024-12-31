package iih.bl.pay.s.bp.ip;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.d.BlPayPatItemDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayRDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.i.IBlPrepayCmdService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 保存住院登记录入预交金
 * @author xy.zhou
 * @date 2018年7月27日
 */
public class BlIpReginPrePayInputBp {
	
	public  BlPrePayPatDO exec(BlPayPatItemDTO blPayPatItemDto)throws BizException{
		if (blPayPatItemDto==null) {
			throw new BizException("未获取到录入的住院预交金信息");
		}
		//组装接口入参
		BlPrepayRDTO blPrepayRDTO = this.setBlPrepayRDTO(blPayPatItemDto);
		//组装配置
		BlPrepaySetDTO prepaySetDTO = this.setBlPrepaySetDTO();
		//调用接口
		IBlPrepayCmdService iCmdService=ServiceFinder.find(IBlPrepayCmdService.class);
		BlPrePayPatDO blPrePayPatDO = iCmdService.recharge(blPrepayRDTO,prepaySetDTO);
		if (blPrePayPatDO==null) {
			throw new BizException("保存住院登记预交金返回数据为空，保存失败！");
		}
		//返回保存的预交金数据
		return blPrePayPatDO;
	}
	/**
	 * 
	 * @Title: setBlPrepayRDTO   
	 * @Description:  组装充值预交金接口入参 
	 * @param: @param blPayPatItemDto
	 * @param: @return      
	 * @return: BlPrepayRDTO 
	 * @author: xy.zhou     
	 * @throws
	 */
	private BlPrepayRDTO setBlPrepayRDTO(BlPayPatItemDTO  blPayPatItemDto){
		BlPrepayRDTO blPrepayRDTO=new BlPrepayRDTO();
		blPrepayRDTO.setId_pat(blPayPatItemDto.getId_pat());
		blPrepayRDTO.setId_ent(blPayPatItemDto.getId_ent());
		blPrepayRDTO.setCode_req(blPayPatItemDto.getCode_rep());
		blPrepayRDTO.setAmt(blPayPatItemDto.getAmt());
		blPrepayRDTO.setSd_pttp(blPayPatItemDto.getSd_pttp());
		blPrepayRDTO.setId_pm(blPayPatItemDto.getId_paymod());
		blPrepayRDTO.setSd_pm(blPayPatItemDto.getPaymod_code());
		blPrepayRDTO.setPaymodenode(blPayPatItemDto.getPaymodeno());
		blPrepayRDTO.setId_emp_pay(blPayPatItemDto.getId_emp_pay());
		blPrepayRDTO.setEu_direct(1);
		return blPrepayRDTO;
	}
	
	/**
	 * 
	 * @Title: setBlPrepaySetDTO   
	 * @Description: 设置预交金配置  
	 * @param: @return      
	 * @return: BlPrepaySetDTO 
	 * @author: xy.zhou     
	 * @throws
	 */
	private BlPrepaySetDTO setBlPrepaySetDTO()throws BizException{
		BlPrepaySetDTO blPrepaySetDTO=new BlPrepaySetDTO();
		blPrepaySetDTO.setFg_print(FBoolean.TRUE);
		blPrepaySetDTO.setFg_accupdate(FBoolean.TRUE);
		return blPrepaySetDTO;
	}
}
