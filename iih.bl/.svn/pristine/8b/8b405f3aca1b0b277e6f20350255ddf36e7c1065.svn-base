package iih.bl.st.s.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 获取组合计价对应的服务明细
 * @author Administrator
 * @date 2019年10月29日
 */
public class GetCombinedValationItemBP {
     public  BlOrderAppendBillParamDTO[] exec (String id_srv_comp,String id_pripat) throws BizException{
    	 IPriCalService ipriCaService = ServiceFinder.find(IPriCalService.class);
    	 //查询组合计价模式 下对应的费用明细
    	 Map<String, SrvPricalRateAndPriceDTO> calSrvCompPriceByIdPripat_map = ipriCaService.CalSrvCompPriceByIdPripat_map(id_srv_comp,id_pripat);
    	 if(!calSrvCompPriceByIdPripat_map.isEmpty()){
    		 SrvPricalRateAndPriceDTO[] srvDto =calSrvCompPriceByIdPripat_map.values().toArray(new SrvPricalRateAndPriceDTO[calSrvCompPriceByIdPripat_map.values().size()]);
    		
    		 //添加返回的服务明细
    		 List<String> listSrv= new ArrayList<String>();
    		 List<String> listMM= new ArrayList<String>();
    		 if(!ArrayUtil.isEmpty(srvDto)){
    			 for (SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO : srvDto) {
    				
    				 if(!StringUtils.isNullOrEmpty(srvPricalRateAndPriceDTO.getId_mm())){
    					// listMM.add(srvPricalRateAndPriceDTO.getId_mm());
    					 return null;
    				 }
    				 else {
    					 listSrv.add(srvPricalRateAndPriceDTO.getId_srv());
    				 }
				}
    		 }
    		 //查询对应的服务do  组装dto
    	     return getBillAppendDto(listSrv.toArray(new String []{}),id_pripat,calSrvCompPriceByIdPripat_map,listMM.toArray(new String []{}));
    	 }
		return null;
     }
     /**
      * 根据id 查询 费用明细 
      * @param id_srvs
      * @return
      * @throws BizException
      */
     private BlOrderAppendBillParamDTO[]  getBillAppendDto(String[] id_srvs,String id_pripat,Map<String, SrvPricalRateAndPriceDTO> map,String[] id_mm) throws BizException{
    	 StringBuffer sb = new StringBuffer();
	    	sb.append("select ");
	 		sb.append(" srv1.name as name_srv,srv1.code as code_srv,bd_mm.name as name_mm,bd_mm.spec,   ");
	 		sb.append(" srv1.id_srv ,");
	 		sb.append(" srv1.id_srv  as Apprno,srv1.id_srvtp,srv1.sd_srvtp,srv1.id_srvca,");
	 		sb.append(" srv1.quan_med as quan_med,srv1.id_unit_med as Srvu,srvdoc.name as Srvu_name,");
	 		sb.append(" case when nvl(bd_mm.id_mm,'~')='~' then srv1.id_unit_med else bd_mm.id_unit_pkgsp end as Pgku_cur,");
	 		sb.append(" case when srvdoc.name is null then mmdoc.name else srvdoc.name end as name_unit_pkg,");
	 		sb.append(" bd_mm.id_unit_pkgsp,");
	 		sb.append(" bd_mm.id_unit_pkgbase as Pgku_base,");
	 		sb.append(" srv1.fg_mm,bd_mm.id_mm,srv1.wbcode as srv_wbcode,srv1.pycode as srv_pycode,");
	 		sb.append(" bd_mm.factor_sb as factor,bd_mm.factor_mb,srv1.id_route,bd_mm.fg_otc,");
	 		sb.append(" 1 as quan, ");
	 		sb.append(" srv1.eu_blmd ");
	 	    sb.append(" from bd_srv srv1 left join bd_mm on srv1.id_srv = bd_mm.id_srv");
	 		sb.append(" left join bd_measdoc srvdoc on srv1.id_unit_med = srvdoc.id_measdoc");
	 		sb.append(" left join bd_measdoc mmdoc on bd_mm.id_unit_pkgsp = mmdoc.id_measdoc");
	 		
	 		sb.append(" where srv1.fg_active='Y' ");
	 		sb.append( " and "+SqlUtils.getInSqlByIds("srv1.id_srv ",id_srvs));
	 		if(!ArrayUtil.isEmpty(id_mm)){
	 			sb.append(" union all ");
	 			sb.append("select ");
		 		sb.append(" srv1.name as name_srv,srv1.code as code_srv,bd_mm.name as name_mm,bd_mm.spec,   ");
		 		sb.append(" srv1.id_srv ,");
		 		sb.append(" srv1.id_srv  as Apprno,srv1.id_srvtp,srv1.sd_srvtp,srv1.id_srvca,");
		 		sb.append(" srv1.quan_med as quan_med,srv1.id_unit_med as Srvu,srvdoc.name as Srvu_name,");
		 		sb.append(" case when nvl(bd_mm.id_mm,'~')='~' then srv1.id_unit_med else bd_mm.id_unit_pkgsp end as Pgku_cur,");
		 		sb.append(" case when srvdoc.name is null then mmdoc.name else srvdoc.name end as name_unit_pkg,");
		 		sb.append(" bd_mm.id_unit_pkgsp,");
		 		sb.append(" bd_mm.id_unit_pkgbase as Pgku_base,");
		 		sb.append(" srv1.fg_mm,bd_mm.id_mm,srv1.wbcode as srv_wbcode,srv1.pycode as srv_pycode,");
		 		sb.append(" bd_mm.factor_sb as factor,bd_mm.factor_mb,srv1.id_route,bd_mm.fg_otc,");
		 		sb.append(" 1 as quan, ");
		 		sb.append(" srv1.eu_blmd ");
		 	    sb.append(" from bd_srv srv1 left join bd_mm on srv1.id_srv = bd_mm.id_srv");
		 		sb.append(" left join bd_measdoc srvdoc on srv1.id_unit_med = srvdoc.id_measdoc");
		 		sb.append(" left join bd_measdoc mmdoc on bd_mm.id_unit_pkgsp = mmdoc.id_measdoc");
		 		
		 		sb.append(" where srv1.fg_active='Y'  ");
		 		//sb.append( " and "+SqlUtils.getInSqlByIds("srv1.id_srv ",id_srvs));
		 		
		 			sb.append(" and "+SqlUtils.getInSqlByIds("bd_mm.id_mm ",id_mm));
	 		}
	 		
	 		List<BlOrderAppendBillParamDTO> execQuery =(List<BlOrderAppendBillParamDTO>) new DAFacade().execQuery(sb.toString(), null, new BeanListHandler(BlOrderAppendBillParamDTO.class));
	 		
	 		if(id_srvs.length- execQuery.size()!=0){
	 			return null;
	 		}
	 		for (BlOrderAppendBillParamDTO blOrderAppendBillParamDTO : execQuery) {
	 			blOrderAppendBillParamDTO.setPrice_ratio(map.get(blOrderAppendBillParamDTO.getId_srv()).getPrice_ratio());
	 			blOrderAppendBillParamDTO.setPrice(blOrderAppendBillParamDTO.getPrice_ratio());
	 			blOrderAppendBillParamDTO.setQuan(map.get(blOrderAppendBillParamDTO.getId_srv()).getQuan());
	 			blOrderAppendBillParamDTO.setAmt_ratio(blOrderAppendBillParamDTO.getPrice_ratio().multiply(blOrderAppendBillParamDTO.getQuan(), 4));
	 			blOrderAppendBillParamDTO.setAmt(blOrderAppendBillParamDTO.getAmt_ratio());
	 			blOrderAppendBillParamDTO.setAmt_pat(blOrderAppendBillParamDTO.getAmt_ratio());
	 			blOrderAppendBillParamDTO.setPrice(map.get(blOrderAppendBillParamDTO.getId_srv()).getPrice());
	 			blOrderAppendBillParamDTO.setAmt_std(map.get(blOrderAppendBillParamDTO.getId_srv()).getPrice().multiply(blOrderAppendBillParamDTO.getQuan(),4));
			}
    	 return execQuery.toArray(new BlOrderAppendBillParamDTO[]{});
     } 
}
