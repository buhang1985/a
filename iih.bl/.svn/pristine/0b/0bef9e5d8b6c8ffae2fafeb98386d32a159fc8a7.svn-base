package iih.bl.st.s.bp;

import java.util.List;

import iih.bl.st.dto.d.BlReconciliationDifferencerDTO;
import iih.bl.st.dto.d.BlReconciliationQryCondDTO;
import iih.pmp.pay.blpmp.d.PmpBlReconciliationDifferencerDTO;
import iih.pmp.pay.blpmp.d.PmpBlReconciliationQryCondDTO;
import iih.pmp.pay.i.IPmpPayOperatorService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 
* @ClassName: GetReconciliationDifferencerDataBP  
* @Description: 获取对账汇总数据
* @author xy.zhou
* @date 2019年3月29日
 */
public class GetReconciliationDifferencerDataBP {

	public BlReconciliationDifferencerDTO [] exec(BlReconciliationQryCondDTO blCondDTO) throws BizException{
		
		if(blCondDTO==null){
			throw new BizException("查询条件为空！");
		}
		
		//获取iih汇总数据
		BlReconciliationDifferencerDTO iihDate = this.getIIHDate(blCondDTO);
		
		//获取平台汇总数据
		BlReconciliationDifferencerDTO pmpData = this.getPmpData(blCondDTO);
		
		BlReconciliationDifferencerDTO bDifferencerDTO=new BlReconciliationDifferencerDTO();
		bDifferencerDTO.setPlatform_type("3");
		bDifferencerDTO.setPayment_amt(pmpData.getPayment_amt().sub(iihDate.getPayment_amt()).abs());
		bDifferencerDTO.setPayment_quan(pmpData.getPayment_quan().sub(iihDate.getPayment_quan()).abs());
		bDifferencerDTO.setRefund_amt(pmpData.getRefund_amt().sub(iihDate.getRefund_amt()).abs());
		bDifferencerDTO.setRefund_quan(pmpData.getRefund_quan().sub(iihDate.getRefund_quan()).abs());
		bDifferencerDTO.setTotal_amt(pmpData.getTotal_amt().sub(iihDate.getTotal_amt()).abs());
		
		return new BlReconciliationDifferencerDTO []{pmpData,iihDate,bDifferencerDTO};
	}
	
	/**
	 * 获取his数据
	 */
	@SuppressWarnings("unchecked")
	private BlReconciliationDifferencerDTO getIIHDate(BlReconciliationQryCondDTO blCondDTO)throws BizException{
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append(" ");
		sqlSb.append("select  nvl(summy1.payment_amt,0) as payment_amt, ");
		sqlSb.append("        nvl(summy1.payment_quan,0) as payment_quan, ");
		sqlSb.append("       nvl(summy1.refund_amt,0) as refund_amt, ");
		sqlSb.append("        nvl(summy1.refund_quan,0) as refund_quan, ");
		sqlSb.append("        (nvl(summy1.payment_amt,0)  +  nvl(summy1.refund_amt,0)) as total_amt, ");
		sqlSb.append("       2 as platform_type ");
		sqlSb.append("  from (select sum(summy.payment_amt) as payment_amt, ");
		sqlSb.append("               sum(summy.payment_quan) as payment_quan, ");
		sqlSb.append("               sum(summy.refund_amt) as refund_amt, ");
		sqlSb.append("               sum(summy.refund_quan) as refund_quan ");
		sqlSb.append("          from ( ");
		sqlSb.append("                select (case when itemip.eu_direct=1 then itemip.amt else 0 end) as payment_amt, ");
		sqlSb.append("                       (case when itemip.eu_direct=1 then 1 else 0 end) as payment_quan, ");
		sqlSb.append("                       (case when itemip.eu_direct=1 then 0 else itemip.amt end)  as refund_amt, ");
		sqlSb.append("                       (case when itemip.eu_direct=1 then 0 else 1 end) as  refund_quan ");
		sqlSb.append("                  from bl_trd_trans_rcd rcd");
		sqlSb.append("                 inner join bl_pay_itm_pat_ip itemip  ");
		sqlSb.append("                    on rcd.id_pay = itemip.id_payitmpatip ");
		sqlSb.append(" where 1=1 ");
		if(!StringUtil.isEmpty(blCondDTO.getCode_serial())){
			sqlSb.append(" and rcd.sd_chl ='").append(blCondDTO.getCode_serial()).append("' ");
		}
		if(!StringUtil.isEmpty(blCondDTO.getId_pm())){
			sqlSb.append("  and rcd.id_pm ='").append(blCondDTO.getId_pm()).append("' ");
		}
		if(blCondDTO.getDt_transr_start()!=null){
			sqlSb.append(" and rcd.dt_oper >='").append(blCondDTO.getDt_transr_start()).append("' ");
		}
		if(blCondDTO.getDt_transr_last()!=null){
			sqlSb.append(" and rcd.dt_oper <='").append(blCondDTO.getDt_transr_last()).append("' ");
		}
		if(!StringUtil.isEmpty(blCondDTO.getId_emp_oper())){
			sqlSb.append(" and rcd.id_emp_oper='").append(blCondDTO.getId_emp_oper()).append("' ");
		}
		sqlSb.append("                union all ");
		sqlSb.append("                select (case when itemoep.eu_direct=1 then itemoep.amt else 0 end) as payment_amt, ");
		sqlSb.append("                     (case when itemoep.eu_direct=1 then 1 else 0 end) as payment_quan, ");
		sqlSb.append("                     (case when itemoep.eu_direct=1 then 0 else itemoep.amt end)  as refund_amt, ");
		sqlSb.append("                     (case when itemoep.eu_direct=1 then 0 else 1 end) as  refund_quan ");
		sqlSb.append("                  from  bl_trd_trans_rcd rcd");
		sqlSb.append("                 inner join bl_pay_itm_pat_oep itemoep ");
		sqlSb.append("                    on rcd.id_pay = itemoep.id_payitmpatoep ");
		sqlSb.append(" where 1=1 ");
		if(!StringUtil.isEmpty(blCondDTO.getCode_serial())){
			sqlSb.append(" and rcd.sd_chl ='").append(blCondDTO.getCode_serial()).append("' ");
		}
		if(!StringUtil.isEmpty(blCondDTO.getId_pm())){
			sqlSb.append("  and rcd.id_pm ='").append(blCondDTO.getId_pm()).append("' ");
		}
		if(blCondDTO.getDt_transr_start()!=null){
			sqlSb.append(" and rcd.dt_oper >='").append(blCondDTO.getDt_transr_start()).append("' ");
		}
		if(blCondDTO.getDt_transr_last()!=null){
			sqlSb.append(" and rcd.dt_oper <='").append(blCondDTO.getDt_transr_last()).append("' ");
		}
		if(!StringUtil.isEmpty(blCondDTO.getId_emp_oper())){
			sqlSb.append(" and rcd.id_emp_oper='").append(blCondDTO.getId_emp_oper()).append("' ");
		}
		sqlSb.append("                union all ");
		sqlSb.append("                select (case when paypat.eu_direct=1 then paypat.amt else 0 end) as payment_amt, ");
		sqlSb.append("                     (case when paypat.eu_direct=1 then 1 else 0 end) as payment_quan, ");
		sqlSb.append("                     (case when paypat.eu_direct=1 then 0 else paypat.amt end)  as refund_amt, ");
		sqlSb.append("                     (case when paypat.eu_direct=1 then 0 else 1 end) as  refund_quan ");
		sqlSb.append("                  from  bl_trd_trans_rcd rcd");
		sqlSb.append("                 inner join bl_prepay_pat paypat ");
		sqlSb.append("                    on rcd.id_pay = paypat.id_paypat ");
		sqlSb.append(" where 1=1 ");
		if(!StringUtil.isEmpty(blCondDTO.getCode_serial())){
			sqlSb.append(" and rcd.sd_chl ='").append(blCondDTO.getCode_serial()).append("' ");
		}
		if(!StringUtil.isEmpty(blCondDTO.getId_pm())){
			sqlSb.append("  and rcd.id_pm ='").append(blCondDTO.getId_pm()).append("' ");
		}
		if(blCondDTO.getDt_transr_start()!=null){
			sqlSb.append(" and rcd.dt_oper >='").append(blCondDTO.getDt_transr_start()).append("' ");
		}
		if(blCondDTO.getDt_transr_last()!=null){
			sqlSb.append(" and rcd.dt_oper <='").append(blCondDTO.getDt_transr_last()).append("' ");
		}
		if(!StringUtil.isEmpty(blCondDTO.getId_emp_oper())){
			sqlSb.append(" and rcd.id_emp_oper='").append(blCondDTO.getId_emp_oper()).append("' ");
		}
		sqlSb.append(" ) summy) summy1 ");
		List<BlReconciliationDifferencerDTO> list = (List<BlReconciliationDifferencerDTO>)new DAFacade().execQuery(sqlSb.toString(), 
				new BeanListHandler(BlReconciliationDifferencerDTO.class));
		if(ListUtil.isEmpty(list)){
			BlReconciliationDifferencerDTO bDifferencerDTO=new BlReconciliationDifferencerDTO();
			bDifferencerDTO.setPayment_amt(new FDouble(0));
			bDifferencerDTO.setRefund_amt(new FDouble(0));
			bDifferencerDTO.setPayment_quan(new FDouble(0));
			bDifferencerDTO.setRefund_quan(new FDouble(0));
			bDifferencerDTO.setTotal_amt(new FDouble(0));
			bDifferencerDTO.setPlatform_type("2");
			return bDifferencerDTO;
		}
		return list.get(0);
	}
	/**
	 * 获取平台汇总数据
	 */
	private BlReconciliationDifferencerDTO getPmpData(BlReconciliationQryCondDTO blCondDTO)throws BizException{

		IPmpPayOperatorService iService=ServiceFinder.find(IPmpPayOperatorService.class);
		PmpBlReconciliationQryCondDTO pmdDto=new PmpBlReconciliationQryCondDTO();
		pmdDto.setId_pm(blCondDTO.getId_pm());
		pmdDto.setCode_pm(blCondDTO.getCode_pm());
		pmdDto.setName_pm(blCondDTO.getName_pm());
		pmdDto.setDt_transr_start(blCondDTO.getDt_transr_start());
		pmdDto.setDt_transr_last(blCondDTO.getDt_transr_last());
		pmdDto.setId_serial(blCondDTO.getId_serial());
		pmdDto.setCode_serial(blCondDTO.getCode_serial());
		pmdDto.setName_serial(blCondDTO.getName_serial());
		pmdDto.setId_emp_oper(blCondDTO.getId_emp_oper());
		pmdDto.setName_emp_oper(blCondDTO.getName_emp_oper());
		
		PmpBlReconciliationDifferencerDTO pmpTraSantis = iService.getTraSantis(pmdDto);
		BlReconciliationDifferencerDTO IIHtraSantis =new BlReconciliationDifferencerDTO ();
		IIHtraSantis.setPayment_amt(pmpTraSantis.getPayment_amt()==null?new FDouble():pmpTraSantis.getPayment_amt());
		IIHtraSantis.setRefund_amt(pmpTraSantis.getRefund_amt()==null?new FDouble():pmpTraSantis.getRefund_amt());
		IIHtraSantis.setPayment_quan(pmpTraSantis.getPayment_quan()==null?new FDouble():pmpTraSantis.getPayment_quan());
		IIHtraSantis.setRefund_quan(pmpTraSantis.getRefund_quan()==null?new FDouble():pmpTraSantis.getRefund_quan());
		IIHtraSantis.setTotal_amt(pmpTraSantis.getTotal_amt()==null?new FDouble():pmpTraSantis.getTotal_amt());
		IIHtraSantis.setPlatform_type("1");
		return IIHtraSantis;
	}
}
