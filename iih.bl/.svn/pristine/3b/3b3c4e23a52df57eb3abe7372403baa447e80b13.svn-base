package iih.bl.st.s.bp.oepcharge;

import java.util.List;

import iih.bd.base.utils.StringUtils;
import iih.bl.itf.dto.blthirdrefundreturndto.d.BlThirdRefundReturnDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 根据结算id和支付方式id 
 * 查询退费的结算id 和收付款明细id
 * 
 * @author zhangxin
 * @date 2019年8月28日
 */
public class GetThirdRefundInfoBP {
	
     public BlThirdRefundReturnDTO exec(String id_st,String id_pm,String id_pay) throws BizException{
    	 StringBuffer sql = new StringBuffer();
    	 SqlParam param = new SqlParam();
    	 //门诊收费根据 收费结算id 反查 退费的信息 
    	 if(StringUtils.isNotEmpty(id_st)){
    		 sql.append("  select stoep.id_stoep, payitm.id_payitmpatoep  id_pay,oripayitm.bankno bankno ");
        	 sql.append("    from bl_st_oep stoep ");
        	 sql.append("  inner join bl_pay_itm_pat_oep payitm on stoep.id_paypatoep = payitm.id_paypatoep  ");
        	 sql.append("  inner join bl_st_oep orist on orist.id_stoep = stoep.id_rootst ");
        	 sql.append("  inner join bl_pay_itm_pat_oep oripayitm on oripayitm.id_paypatoep =orist.id_paypatoep ");
        	 sql.append("  where stoep.id_par = ?  ");
        	 sql.append("  and payitm.id_pm = ? ");
        	 sql.append("  and payitm.fg_realpay = 'Y' ");
        	 sql.append("  and oripayitm.id_pm = ? ");
        	 sql.append("  and oripayitm.fg_realpay = 'Y' ");
        	 sql.append("  order by stoep.dt_st desc  "); 
        	 param.addParam(id_st);
        	 param.addParam(id_pm);
        	 param.addParam(id_pm);
    	 }
    	 //预交金的根据退费的id 查询信息
    	 if(StringUtils.isNotEmpty(id_pay)){
    		 sql.append(" select '' id_stoep,prepay.id_paypat id_pay,prepay.bankno from bl_prepay_pat prepay  ");
    		 sql.append(" where prepay.id_paypat = ?  order by prepay.dt_pay desc ");
        	 param.addParam(id_pay);
    	 }
    	
    	
    	
    	 BlThirdRefundReturnDTO blThirdRefundReturnDTO = null ;
    	 List<BlThirdRefundReturnDTO> list = (List<BlThirdRefundReturnDTO>) new DAFacade().execQuery(sql.toString(), param, new BeanListHandler(BlThirdRefundReturnDTO.class));
    	 //增加查询终端类型
    	 if(ListUtil.isEmpty(list)){
    		 throw new BizException("收付款信息不存在  "); 
    	 }
    		 blThirdRefundReturnDTO = list.get(0);
    		 StringBuffer sqlpay = new StringBuffer();
    		 SqlParam paramPay = new SqlParam();
    		 if(StringUtils.isNotEmpty(id_st)){
    			 sqlpay.append("  select payoep.sd_pttp ");
        		 sqlpay.append("  from bl_st_oep stoep ");
        		 sqlpay.append("  inner join bl_pay_pat_oep payoep  on stoep.id_paypatoep = payoep.id_paypatoep ");
        		 sqlpay.append("  where stoep.id_stoep = ?");
        		 paramPay.addParam(id_st);
    		 }
    		 if(StringUtils.isNotEmpty(id_pay)){
        		 sqlpay.append("  select prepay.sd_pttp  from bl_prepay_pat prepay where prepay.id_paypat = ?  ");
        		 paramPay.addParam(id_pay);
    		 }
    		
    		
    		 List<BlThirdRefundReturnDTO> listPAY = (List<BlThirdRefundReturnDTO>) new DAFacade().execQuery(sqlpay.toString(), paramPay, new BeanListHandler(BlThirdRefundReturnDTO.class));
    		 if(ListUtil.isEmpty(listPAY)){
    			throw new BizException("收付款信息不存在  "); 
    		 }
    		 blThirdRefundReturnDTO.setSd_pttp(listPAY.get(0).getSd_pttp());
    		 
    	 
    	 return blThirdRefundReturnDTO;
     }
}
