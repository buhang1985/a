package iih.ci.ord.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.dto.blexorder.d.OrGenSplitTpEnum;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class getMpSplitDataBP {
	public SrvSplitOrderDTO[] exec(OrSrvSplitParamDTO param)throws BizException{	
		if(param==null)return null;
		if(param.getEu_orgensplittp()==OrGenSplitTpEnum.SPLITBYSRVMM) {
			return getSrvOrderData( param);
		}else if(param.getEu_orgensplittp()==OrGenSplitTpEnum.SPLITBYOR) {
			return getOrderData( param);
		}
			return null;
	}
	private SrvSplitOrderDTO[] getSrvOrderData(OrSrvSplitParamDTO param)throws BizException{
		String sql="select a.Id_or," + 
				"       a.Id_orsrv,  " + 
				"      b.Dt_effe," + 
				"       b.Fg_long," + 
				"       b.dt_stop," + 
				"       a.Id_srv," + 
				"      a.Code_srv," + 
				"       a.name Name_srv," + 
				"        b.fg_pres_outp," + 
				"       a.fg_or," + 
				"       c.sd_frequnitct Sd_frequnit," + 
				"       a.Id_srvtp ," + 
				"       a.Sd_srvtp," + 
				"       c.freqct Freqcnt" + 
				"  from ci_order b left join ci_or_srv a on a.id_or=b.id_or left join bd_freq c on b.id_freq=c.id_freq "
				+ " where  b.id_en='"+param.getId_ens()+"' and a.sd_srvtp in ("+param.getSd_srvtps()+")  and "
						+ "b.fg_sign='Y' and b.fg_chk='Y' and a.fg_self='N' and b.code_entp="+ IBdFcDictCodeConst.SD_CODE_ENTP_IP+"  and b.fg_canc='N' and b.fg_pmor='N' ";
	
		DAFacade da=new DAFacade();
		List<SrvSplitOrderDTO> result=(List<SrvSplitOrderDTO>) da.execQuery(sql,  new BeanListHandler(SrvSplitOrderDTO.class));	
		if(result!=null)
			return result.toArray(new SrvSplitOrderDTO[0]);
		return null;
		
	}
	private SrvSplitOrderDTO[] getOrderData(OrSrvSplitParamDTO param)throws BizException{
		String sql=" select a.Id_or," + 
				"       a.Dt_effe," + 
				"       a.Fg_long," + 
				"       a.dt_stop," + 
				"       a.name_or," + 
				"       a.Dt_effe as dt_mp_plan," + 
				"       a.sd_su_mp as or_mp_status," + 
				"       b.sd_frequnitct Sd_frequnit," + 
				"       a.Id_srvtp Id_orsrvtp," + 
				"       a.Sd_srvtp Sd_orsrvtp," + 
				"       b.freqct        Freqcnt" + 
				"  from ci_order a" + 
				"  left join bd_freq b " + 
				"    on a.id_freq = b.id_freq "
				+ " where a.id_en='"+param.getId_ens()+"' and a.sd_srvtp in ("+param.getSd_srvtps()+") and a.dt_effe>='"+param.getDt_split_start()+"' and a.dt_effe<='"+param.getDt_split_end()+"' and "
						+ " a.fg_sign='Y' and a.fg_chk='Y' and a.code_entp="+ IBdFcDictCodeConst.SD_CODE_ENTP_IP+" and a.fg_canc='N' and a.fg_pmor='N'";
		DAFacade da=new DAFacade();
		List<SrvSplitOrderDTO> result=(List<SrvSplitOrderDTO>) da.execQuery(sql,  new BeanListHandler(SrvSplitOrderDTO.class));	
		if(result!=null)
			return result.toArray(new SrvSplitOrderDTO[0]);
		return null;
	}
}
