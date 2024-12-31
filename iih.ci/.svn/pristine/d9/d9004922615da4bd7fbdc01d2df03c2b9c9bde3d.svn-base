package iih.ci.ord.s.bp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.d.desc.OrdSrvDODesc;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.dto.patorderlistdto.d.Patorderlistdto;
import iih.ci.ord.dto.patundoorderdto.d.PatUnDoOrderdto;
import iih.ci.ord.s.bp.qry.GetPatOrderListQry;
import iih.ci.ord.s.bp.qry.GetPatUnDoOrderListQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

 

public class GetPatUnDoOrderListBP {
	
	
/*	使用场景：
	患者出院时查询住院患者为处理完的医嘱（包括医生未处理完、护士未处理完）	传入参数：entId（患者本次就诊id）
	传出参数：医嘱id，医嘱内容，医学单位数值，医学单位，频率，用法。
	过滤条件： 
	长期医嘱：<CI_OR .医嘱状态>！= 核对作废 或<CI_OR .医嘱状态>！= 核对停止
	临时医嘱：<CI_OR .医嘱状态>！= 已核对 或<CI_OR .医嘱状态>！= 已作废*/
	public PatUnDoOrderdto[] exec(String id_ent) throws BizException{
		
		if(id_ent == null || id_ent== "") return null;
		 String[] id_ents = {id_ent};
		GetPatUnDoOrderListQry qry = new GetPatUnDoOrderListQry(id_ents);
		
		 PatUnDoOrderdto rtn[] = (PatUnDoOrderdto[])AppFwUtil.getDORstWithDao(qry, PatUnDoOrderdto.class);
		 this.setOrderStatus(rtn);
		 HandleDateTime(rtn);
		 return  rtn;
		 
	}
     //修改bug  http://172.18.98.25/view.php?id=100078 
	 private void HandleDateTime(PatUnDoOrderdto[] rtn){
		 if(rtn != null && rtn.length >0){
			for(PatUnDoOrderdto dto:rtn){
				if(dto.getDt_end() != null && ("2099-01-01 00:00:00".equals(dto.getDt_end().toStdString()) ||"3000-01-01 00:00:00".equals(dto.getDt_end().toStdString()) )){
					dto.setDt_end(null);
				}
			} 
		 }
	 }
	
	/**
	 * 多个就诊 id时 处理
	 * 患者出院时查询住院患者为处理完的医嘱（包括医生未处理完、护士未处理完）	传入参数：entId（患者本次就诊id）
		传出参数：医嘱id，医嘱内容，医学单位数值，医学单位，频率，用法。
		过滤条件： 
		长期医嘱：<CI_OR .医嘱状态>！= 核对作废 或<CI_OR .医嘱状态>！= 核对停止
		临时医嘱：<CI_OR .医嘱状态>！= 已核对 或<CI_OR .医嘱状态>！= 已作废
	 * @param id_ents
	 * @return
	 * @throws BizException
	 */
    public  Map exe2(String[] id_ents) throws BizException{
		
		if(id_ents == null || id_ents.length ==0) return null;
		 Map map = new HashMap();
		 GetPatUnDoOrderListQry qry = new GetPatUnDoOrderListQry(id_ents);
		 PatUnDoOrderdto[] rtn = (PatUnDoOrderdto[])AppFwUtil.getDORstWithDao(qry, PatUnDoOrderdto.class);
		 this.setOrderStatus(rtn);
		 return getIdEnNumMap(rtn,id_ents);
	}
	
	
    private Map getIdEnNumMap( PatUnDoOrderdto rtn[],String[] id_ents){
    	Map map = new HashMap();
    	int  num = 0;
    	for(String id_en:id_ents){
    		for(PatUnDoOrderdto item :rtn){
        		if(item.getId_en().equals(id_en)){
        			num ++;
        		}
        	}
    		map.put(id_en, num);
		    num = 0;
    	}
    	return map;
    }
    
    
    
	
/*	查询患者医嘱（CI_OR）	
	传入参数：entId（患者本次就诊id）
	传出参数：服务类型、医嘱内容、用法、频次、天数、状态*/
	
	public  Patorderlistdto[] GetPatOrderList(String id_ent)throws BizException{
		
		if(id_ent == null || id_ent== "") return null;
		GetPatOrderListQry qry = new GetPatOrderListQry(id_ent);
	
		Patorderlistdto[] rtn =(Patorderlistdto[])AppFwUtil.getDORstWithDao(qry, Patorderlistdto.class);

		 return  rtn;
		 
	}
	
	
	/**
	 *  患者本次就诊医嘱列表
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	 public CiOrderDO[] GetOrderList(String id_ent)throws BizException{
		 
		 ICiorderMDORService orderSerice = (ICiorderMDORService)ServiceFinder.find(ICiorderMDORService.class);
		 return orderSerice.find(CiOrderDODesc.TABLE_ALIAS_NAME+".id_en = '"+id_ent+"'", CiOrderDODesc.TABLE_ALIAS_NAME+".id_or", FBoolean.FALSE);
		 
	 }
	
	
/*	查询医嘱关联的服务（CI_OR_SRV）	
	传入参数：id_or
	传出参数： id_srv 项目, quan_medu 医疗单位数值， id_medu 医疗单位, id_dep_mp 执行科室, sd_su_mp 执行状态, sd_su_bl 记账状态
	from ci_or_srv  where id_or=选择医嘱*/
	
	public OrdSrvDO[] GetOrderSrvDOS(String id_or)throws BizException {
		 
		IOrdSrvDORService orderSrvservice =(IOrdSrvDORService)ServiceFinder.find(IOrdSrvDORService.class);
		 
		 return  orderSrvservice.find(OrdSrvDODesc.TABLE_ALIAS_NAME+".id_or = '"+id_or+"'", OrdSrvDODesc.TABLE_ALIAS_NAME+".id_or", FBoolean.FALSE);
	}
	/**
	 * 设置医嘱显示状态
	 * 
	 * @param orderList
	 */
	private void setOrderStatus(PatUnDoOrderdto[] orderList) {
		for (PatUnDoOrderdto order : orderList) {
			if (ICiDictCodeConst.SD_SU_OPEN.equals(order.getSd_su_or())) {
				order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_OPEN);// 开立
			} else if (ICiDictCodeConst.SD_SU_SIGN.equals(order.getSd_su_or())) {
				order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_SIGN);// 签署
			} else if (ICiDictCodeConst.SD_SU_CHECKTHROUGH.equals(order.getSd_su_or())) {
				if (ICiDictCodeConst.SD_SU_MP_NONE.equals(order.getSd_su_mp())) {
					if (FBoolean.FALSE.equals(order.getFg_stop()) || FBoolean.TRUE.equals(order.getFg_pres_outp())) {
						// 出院带药不需要预停操作
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_CHECKTHROUGH);// 确认
					} else if (FBoolean.TRUE.equals(order.getFg_stop())) {
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_22);// 确认预停
					} else {
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_11);// 未知
					}
				} else if (ICiDictCodeConst.SD_SU_MP_PERFORMED.equals(order.getSd_su_mp())) {
					if (FBoolean.FALSE.equals(order.getFg_stop())) {
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_21);// 执行中
					} else if (FBoolean.TRUE.equals(order.getFg_stop())) {
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_23);// 预停
					} else {
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_11);// 未知
					}
				} else {
					order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_11);// 未知
				}
			} else if (ICiDictCodeConst.SD_SU_CHECKSTOP.equals(order.getSd_su_or())) {
				if (FBoolean.TRUE.equals(order.getFg_stop())) {
					if (ICiDictCodeConst.SD_SU_MP_NONE.equals(order.getSd_su_mp())) {
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_CHECKSTOP);
					} else if (ICiDictCodeConst.SD_SU_MP_PERFORMED.equals(order.getSd_su_mp())) {
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_51);
					} else {
						order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_11);// 未知
					}
				} else {
					order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_11);// 未知
				}
			} else if (ICiDictCodeConst.SD_SU_FINISH.equals(order.getSd_su_or())) {
				if (ICiDictCodeConst.SD_SU_MP_EXEOK.equals(order.getSd_su_mp())) {
					order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_FINISH);// 完成
				} else if (ICiDictCodeConst.SD_SU_MP_EXECANC.equals(order.getSd_su_mp())) {
					order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_61);// 取消
				} else if (ICiDictCodeConst.SD_SU_MP_CANCEL.equals(order.getSd_su_mp())) {
					order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_62);// 不执行
				} else {
					order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_11);// 未知
				}
			} else if (ICiDictCodeConst.SD_SU_CANCEL.equals(order.getSd_su_or())) {
				order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_CANCEL);// 作废
			} else if (ICiDictCodeConst.SD_SU_CHECKCANCEL.equals(order.getSd_su_or())) {
				order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_CHECKCANCEL);// 作废确认
			} else {
				order.setSd_su_or_ext(ICiDictCodeConst.SD_SU_11);// 未知
			}
		}
	}
}
