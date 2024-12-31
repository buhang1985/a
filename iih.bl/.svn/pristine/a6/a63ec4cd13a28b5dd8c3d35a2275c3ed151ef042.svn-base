package iih.bl.cg.s.bp.ip.ipoutpatprice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.cxf.common.util.StringUtils;

import iih.bd.base.utils.DateTimeUtils;
import iih.bd.pp.dto.d.PriceResultDTO;
import iih.bd.pp.i.IBdPriCalcService;
import iih.bl.cg.bp.GetBlIpOutPatPriDTOBP;
import iih.bl.cg.dto.d.NurseTPOrderCGModeEnum;
import iih.bl.cg.s.bp.ip.backcg.DayFeeParam;
import iih.bl.cg.s.bp.ip.backcg.comparator.NurFeeComparator;
import iih.bl.cg.s.bp.ip.ipoutpatprice.qry.GetPatNerseDaysQry;
import iih.bl.comm.util.BlMsgUtils;
import iih.bl.params.BlParams;
import iih.bl.pub.IBlExternalParamConst;
import iih.bl.st.dto.d.BlIpOutPatPriDTO;
import iih.en.pv.enres.d.EnBedDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;

/**
 * 检索护理费是否划价
 * @author LIM
 * @version ly 2018/09/07 修改护理费截止时间校验逻辑
 *
 */
public class GetCheckNurseFeeBP {
	/**
	 *  检索护理费是否划价
	 * @param id_ent 就诊id
	 * @param dt_end 出院时间
	 * @return
	 * @throws BizException 
	 */
	public BlIpOutPatPriDTO exec(String id_ent, FDateTime dt_end) throws BizException{
		BlIpOutPatPriDTO blIpOutPatPriDTO= new BlIpOutPatPriDTO();
		GetBlIpOutPatPriDTOBP blIpOutPatPriDTOBP = new GetBlIpOutPatPriDTOBP();
		//1.护理费是否划价
		String message=this.getPrice_NurseFee(id_ent, dt_end);

		//2.患者的护理天数是否大于实际住院天数
		//护理天数
		FDouble NurDays= this.getPatNerseDay(id_ent);
		//住院天数
		PatiVisitDO enDO = ServiceFinder.find(IPativisitRService.class).findById(id_ent);
		if(enDO!=null){
			int ipDays=DateTimeUtils.getNatDaysBetween(enDO.getDt_acpt(),dt_end);
			//如果是当天入院当天出院要收一天护理费			
			if(NurDays.compareTo(new FDouble(ipDays==0?1:ipDays))>0){
				message +=BlMsgUtils.GetCheckNurseDaysMsg();;
			}
		}
		
		if(!StringUtils.isEmpty(message)){
			blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_NURSEFEE, FBoolean.FALSE, message);
		}else{
			message=BlMsgUtils.GetCheckNurseFeeMsg(FBoolean.TRUE,"",null,null);
			blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_NURSEFEE, FBoolean.TRUE, message);
		}
		return blIpOutPatPriDTO;
	}
	
	/**
	 * 护理费是否划价
	 * 
	 * @param id_ent 就诊id
	 * @param dt_end 出院时间
	 * @return
	 * @throws BizException
	 */
	private String getPrice_NurseFee(String id_ent, FDateTime dt_end) throws BizException {
		FBoolean bPrice = FBoolean.TRUE;
		String message="";
		//1.获取患者入院日期
		FDateTime dt_acpt=this.getPatAcptDate(id_ent);
		//2.查询护理费
		GetNurseFeePriceBP bp = new GetNurseFeePriceBP();
		EnBedDO[] enBedDoArr = bp.exec(id_ent);//do里id_bed字段表示id_srv
		
		//3.过滤有效医嘱
		EnBedDO[] enBedDo =this.filterData(id_ent,dt_acpt,dt_end,enBedDoArr);
		if (ArrayUtil.isEmpty(enBedDo)) {
			return "";
		}
		
		//DateTimeUtils.isSameDay(patInfoF.getDt_acpt(), cgEndTimeF)
		//获取最大停止时间,如果存在未停止护理费用,则使用dt_end
		dt_end = this.getMaxDateEnd(enBedDo, dt_end);
		
		if (!ArrayUtils.isEmpty(enBedDo)) {
			// 护理费记账模式
			String nurseTPOrderCGMode = BlParams.BLCG0001();
			if (nurseTPOrderCGMode.equals(NurseTPOrderCGModeEnum.SECOND)) // 按秒,持续计费
			{
				for (EnBedDO bedDo : enBedDo) {
					// 如果护理结束日期为空，则未划价
					if (bedDo.getDt_e() == null) {
						bPrice = FBoolean.FALSE;
						message=BlMsgUtils.GetCheckNurseFeeMsg(bPrice, bedDo.getName_bed(), null, null);
						continue;
					} else {
						// 如果护理停止时间和划价时间不等，则未划价
						if (!bedDo.getDt_e().equals(bedDo.getDt_chg_bill())) {
							bPrice = FBoolean.FALSE;
							message=BlMsgUtils.GetCheckNurseFeeMsg(bPrice, bedDo.getName_bed(),bedDo.getDt_chg_bill()==null?null: bedDo.getDt_chg_bill(),bedDo.getDt_e());
							continue;
						}
					}
				}
			} else {
				// 按天
				FDateTime maxPriceDate = this.getMaxDate(enBedDo);
				if(maxPriceDate==null){
					bPrice = FBoolean.FALSE;
					message=BlMsgUtils.GetCheckNurseFeeMsg(bPrice, enBedDo[0].getName_bed(), null, null);
					return message;
				}
				bPrice = new FBoolean(DateTimeUtils.isSameDay(dt_end, maxPriceDate));				
				if(FBoolean.FALSE.equals(bPrice)){
					message=BlMsgUtils.GetCheckNurseFeeMsg(bPrice, "", maxPriceDate, dt_end);
				}
			}
		}
		return message;
	}
	
	/**
	 * 获取划着的护理费用天数
	 * @throws BizException 
	 */
	private FDouble getPatNerseDay(String id_ent) throws BizException{
		//获取护理费编码
		String id_srv=BlParams.BLCG0011();
		if(StringUtils.isEmpty(id_srv)){
			return new FDouble(0);
		}
		DAFacade daFacade = new DAFacade();
		GetPatNerseDaysQry sql = new GetPatNerseDaysQry(id_ent,id_srv);
		Object days= (Object)daFacade.execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new ColumnHandler());		
		return new FDouble(days.toString());
	}
	
	/**
	 * 获取最大划价日期
	 * 
	 * @return
	 */
	private FDateTime getMaxDate(EnBedDO[] enBedDO) {
		FDateTime priceDate = new FDateTime("1900-01-01 00:00:00");
		for (EnBedDO enDO : enBedDO) {
			if (enDO.getDt_chg_bill() != null && enDO.getDt_chg_bill().compareTo(priceDate) > 0) {
				priceDate = enDO.getDt_chg_bill();
			}
		}
		//return priceDate;
		return priceDate.equals(new FDateTime("1900-01-01 00:00:00"))? null :priceDate;
	}
	
	/**
	 * 获取最大截止时间
	 * @param enBedDO
	 * @param dt_end
	 * @return
	 * @throws BizException 
	 */
	private FDateTime getMaxDateEnd(EnBedDO[] enBedDO, FDateTime dt_end) throws BizException {
	
		FDateTime  maxDateEnd = new FDateTime("1900-01-01 00:00:00");
		boolean allNull = true;
//		for (EnBedDO enDO : enBedDO) {
//			if(enDO.getDt_e() == null){
//				continue;
//			}
//			
//			if(enDO.getDt_e().compareTo(maxDateEnd) > 0){
//				maxDateEnd = enDO.getDt_e();
//			}
//			allNull= false;
//		}	
		
		IBdPriCalcService calcPriService = ServiceFinder.find(IBdPriCalcService.class);
		
		//对过滤后的护理费根据BLCG0001参数进行排序（该排序方案和住院后台记账护理费时的排序方案一致）
		List<DayFeeParam> feeList = new ArrayList<DayFeeParam>();
		for(EnBedDO enDO : enBedDO){
			PriceResultDTO price = calcPriService.calcStdPrice(enDO.getId_bed());//计算服务价格
			
			DayFeeParam feeParam = new DayFeeParam();
			feeParam.setDt_b(enDO.getDt_b());
			feeParam.setPrice(price == null ? FDouble.ZERO_DBL : price.getPrice_std());
			feeParam.setRealObj(enDO);
			feeList.add(feeParam);
		}
		
		if(feeList.size() == 0){
			maxDateEnd = dt_end;
			return maxDateEnd;
		}
		
		String cgMode = BlParams.BLCG0001();
		Collections.sort(feeList, new NurFeeComparator(cgMode));
		
		EnBedDO enDO = (EnBedDO)feeList.get(0).getRealObj();
		
		if(enDO.getDt_e() != null){
			if(enDO.getDt_e().compareTo(maxDateEnd) > 0){
				maxDateEnd = enDO.getDt_e();
			}
			allNull= false;
		}
		
		// 注释掉 如果护理医嘱停止时间在出院医嘱时间之后取出院时间的判断 lim
//		if(allNull|| maxDateEnd.compareTo(dt_end)>=0){
//			maxDateEnd = dt_end;
//		}
		
		if(allNull){
			maxDateEnd = dt_end;
		}
		return maxDateEnd;
	}
	
	/**
	 * 获取患者入院日期
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	private FDateTime getPatAcptDate(String id_ent) throws BizException{
		IPativisitRService ser =ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO enEntDo=ser.findById(id_ent);
		return enEntDo!=null && enEntDo.getDt_acpt()!=null?enEntDo.getDt_acpt():null;		
	}
	
	/**
	 * 过滤数据
	 * @param id_ent
	 * @param dt_acpt 入科日期
	 * @param dt_ent  出院日期
	 * @param enBedDo
	 * @return
	 * @throws BizException
	 */
	private EnBedDO[] filterData(String id_ent,FDateTime dt_acpt,FDateTime dt_ent,EnBedDO[] enBedDo) throws BizException{
		List<EnBedDO> enBedDOList = new ArrayList<EnBedDO>();
		for(EnBedDO entDO :enBedDo){
			//判断 入院日期和出院日期不是同一天 并且 护理医嘱的生效日期和出院日期同一天就不收了
			if(!DateTimeUtils.isSameDay(dt_acpt, dt_ent)  && DateTimeUtils.isSameDay(entDO.getDt_b(), dt_ent)){	
			}else{
				enBedDOList.add(entDO);
			}
		}
		return enBedDOList.toArray(new EnBedDO[0]);
	}
}
