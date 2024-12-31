package iih.ci.ord.s.ems.op.order;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.i.meta.OrderOperateDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 
 * Copyright © 2018 北大医疗信息技术有限公司 PKU healthcare IT solution Co. Ltd
 * @author 作者 lizheng:
 * @version 创建时间：2018年4月19日 下午8:41:46
 * 医保患者有自费诊断时，是否有医保的医嘱
 * 
 * 类说明
 */

public class JudgeOrderSelfPayDiagBP {
    /***
     * 判断有自费诊断是否有医保的医嘱
     * @param aggors
     * @param arg
     * @return
     * @throws BizException
     */
	public FBoolean JudgeOrderSelfPayDiagBP(CiorderAggDO[] aggors,OrderOperateDTO arg)throws BizException{
		if(arg != null && arg.getEnContext() != null){
			String id_ent = arg.getEnContext().getId_en();
			if(arg.getEnContext().getId_hp() != null && arg.getEnContext().getSd_hptp() != null && arg.getEnContext().getSd_hptp().startsWith("1")){
				if(FBoolean.TRUE.equals(JudgeDiagSelf(id_ent))){
				  return JudgeOrderSrvDO(aggors);
				}
			}
		}
		return FBoolean.FALSE;
	}
	/**
	 * 判断是否有医保的医嘱
	 * @param aggors
	 * @return
	 * @throws BizException
	 */
	 private FBoolean JudgeOrderSrvDO(CiorderAggDO[] aggors)throws BizException{
		 if(aggors != null && aggors.length >0 ){
			 for(CiorderAggDO ciorderaggDO:aggors){
				for(OrdSrvDO ordsrvDO:ciorderaggDO.getOrdSrvDO()){
					if(FBoolean.FALSE.equals(ordsrvDO.getFg_selfpay())){
						 return FBoolean.TRUE;
					}
				} 
			 }
		 }
		 return FBoolean.FALSE;
	 }
	
	/**
	 * 判断是否自费
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private FBoolean JudgeDiagSelf(String id_ent)throws BizException{
		 String id_di =  GetCiDiagDO(id_ent);
		 return GetCiDiagItemDO(id_di);
	}
	/**
	 * 主诊断
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private  String  GetCiDiagDO(String id_ent)throws BizException{
		//CiDiagDO cidiagDO = new 
		StringBuffer sb = new StringBuffer();
		sb.append(" select  id_di from ci_di where  id_en= '");
		sb.append(id_ent).append("'");
		sb.append(" and fg_sign ='Y' and fg_cancel ='N' order by ci_di.dt_sign desc ");
		DAFacade df = new DAFacade();
		List<CiDiagDO> list = (List<CiDiagDO>)df.execQuery(sb.toString(), new BeanListHandler(CiDiagDO.class));
		if(list != null && list.size() >0){
			CiDiagDO diagDO= (CiDiagDO)list.get(0);
			return diagDO.getId_di();
		}
		return null;
	}
	/**
	 * 诊断明细是否自费
	 * @param id_di
	 * @return
	 * @throws BizException
	 */
	private  FBoolean  GetCiDiagItemDO(String id_di)throws BizException{
		if(StringUtils.isEmpty(id_di))return FBoolean.FALSE;
		StringBuffer sb = new StringBuffer();
		sb.append(" select id_didef, eu_hpbeyond from ci_di_itm where  ci_di_itm.eu_hpbeyond='1'");
		sb.append(" and id_di = '").append(id_di).append("'");
		//sb.append(" and fg_sign ='Y' and fg_cancel ='N' order by ci_di.dt_sign desc ");
		DAFacade df = new DAFacade();
		List<CiDiagItemDO> list = (List<CiDiagItemDO>)df.execQuery(sb.toString(), new BeanListHandler(CiDiagItemDO.class));
		if(list != null && list.size() >0){
			return FBoolean.TRUE;
		}
		return FBoolean.FALSE;
	}
}
