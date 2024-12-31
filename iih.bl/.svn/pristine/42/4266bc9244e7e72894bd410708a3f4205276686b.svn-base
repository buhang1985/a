package iih.bl.pay.s.bp.ip;

import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.dto.d.BlIpRegisKnotsPayDTO;
import iih.bl.pay.dto.prepay.d.BlPrepaySetDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayTDTO;
import iih.bl.pay.dto.prepay.d.BlPrepayTSubDTO;
import iih.bl.pay.i.IBlPrepayCmdService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 住院历次结转押金转入bp
 * @author xy.zhou
 * @date 2018年7月27日
 */
public class BlKontsPrePayInputBp {
	
	public BlPrePayPatDO[] exec(BlIpRegisKnotsPayDTO[] blIpRegisKnots,String id_ent)throws BizException{
		if (ArrayUtil.isEmpty(blIpRegisKnots)) {
			throw new BizException("没有获取可转入的结转预交金！");
		}
		//组装入参
		BlPrepayTDTO blPrepayTDTO = this.setBlPrepayRDTO(blIpRegisKnots,id_ent);
		//组装配置
		BlPrepaySetDTO prepaySetDTO = this.setBlPrepaySetDTO();
		//调用转移接口
		IBlPrepayCmdService iCmdService=ServiceFinder.find(IBlPrepayCmdService.class);
		BlPrePayPatDO[] blPrePayPatDOs = iCmdService.transfer(blPrepayTDTO, prepaySetDTO);
		if (ArrayUtil.isEmpty(blPrePayPatDOs)) {
			throw new BizException("住院结转预交金返回数据失败，转移失败！");
		}
		//返回新转入的预交金数据
		return blPrePayPatDOs;
	}
	/**
	 * 
	 * @Title: setBlPrepayRDTO   
	 * @Description: 为转移接口入参赋值  
	 * @param: @param blReservePatDOs
	 * @param: @param entId
	 * @param: @return
	 * @param: @throws BizException      
	 * @return: BlPrepayTDTO[] 
	 * @author: xy.zhou     
	 * @throws
	 */
	private BlPrepayTDTO  setBlPrepayRDTO(BlIpRegisKnotsPayDTO [] blIpRegisKnots,String id_ent) throws BizException{	
		BlPrepayTDTO blPrepayTDTO=new BlPrepayTDTO();
		blPrepayTDTO.setId_ent(id_ent);
		blPrepayTDTO.setId_pat(blIpRegisKnots[0].getId_pat());
		blPrepayTDTO.setSd_pttp("01");
		FArrayList tSubList=new FArrayList();
		for (int i = 0; i < blIpRegisKnots.length; i++) {
			BlPrepayTSubDTO bSubDTO=new BlPrepayTSubDTO();
			bSubDTO.setId_prepay(blIpRegisKnots[i].getId_paypat());
			bSubDTO.setAmt(blIpRegisKnots[i].getAmt());
			tSubList.add(bSubDTO);
		}
		blPrepayTDTO.setPrepaytranids(tSubList);
		return blPrepayTDTO;
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
