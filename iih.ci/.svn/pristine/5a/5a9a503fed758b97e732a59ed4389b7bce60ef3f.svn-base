package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.nursorderquerydto.d.NursOrderQueryDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class GetNurstationDocOrdBP {
	
	public CiOrderDO[] exec(NursOrderQueryDTO dto)throws BizException{
		ICiorderMDORService service = ServiceFinder.find(ICiorderMDORService.class);
		String wherePart = this.getWherePart(dto);
		CiOrderDO[] orders = service.find(wherePart, " a0.dt_effe desc", FBoolean.FALSE);
		handleOrders(orders);
		return orders;
	}
	private void handleOrders(CiOrderDO[] orders){
		if(orders==null||orders.length==0){
			return;
		}
		for(CiOrderDO order : orders){
			if(FBoolean.TRUE.equals(order.getFg_long())){
				order.setStr_long("长期");
			}else{
				order.setStr_long("临时");
			}
			if(FBoolean.FALSE.equals(order.getFg_stop())){
				order.setDt_end(null);
			}
		}
	}
	private String getWherePart(NursOrderQueryDTO dto){
		StringBuilder sb = new StringBuilder();
		sb.append(" a0.fg_sign='Y'");
		sb.append(" and a0.id_en='"+dto.getId_ent()+"'");
		//医嘱模式
		if("0".equals(dto.getQueryModel())){
			sb.append(" and a0.eu_orsrcmdtp <>'"+OrSourceFromEnum.IIHMEDTECHORDERS+"' ");
			sb.append(" and a0.Sd_orsrcfun <>'"+ICiDictCodeConst.SD_ORDSRCFUN_NUR+"' ");
		}else if("1".equals(dto.getQueryModel())){
			sb.append(" and a0.eu_orsrcmdtp <>'"+OrSourceFromEnum.IIHMEDTECHORDERS+"' ");
			sb.append(" and a0.Sd_orsrcfun ='"+ICiDictCodeConst.SD_ORDSRCFUN_NUR+"' ");
		}
		if("long".equals(dto.getStr_long())){
			sb.append(" and a0.fg_long='Y' ");
		}else if("temp".equals(dto.getStr_long())){
			sb.append(" and a0.fg_long='N'");
		}
		//查询当前的医嘱
		if("curr".equals(dto.getStr_active())){
			String begin_datatime = new FDateTime().getBeginDate() + " 00:00:00";
			sb.append(" and (nvl(a0.dt_end,'~') = '~' or a0.dt_end > '" + begin_datatime+"')");
			sb.append(" and a0.fg_canc='N' ");
		}
		return sb.toString();
	}
}
