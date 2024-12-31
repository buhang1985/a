package iih.bl.cg.s.bp.ip.ipoutpatprice;

import iih.bd.base.utils.DateTimeUtils;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bl.cg.bp.GetBlIpOutPatPriDTOBP;
import iih.bl.comm.util.BlMsgUtils;
import iih.bl.params.BlParams;
import iih.bl.pub.IBlExternalParamConst;
import iih.bl.st.dto.d.BlIpOutPatPriDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.en.pv.enfee.d.EnFixedFeeDO;
import iih.en.pv.enfee.d.EnfixedfeeAggDO;
import iih.en.pv.enfee.i.IEnfixedfeeRService;
import iih.en.pv.i.IEnOutQryService;
import iih.en.pv.inpatient.d.NewbornDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.cxf.common.util.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 固定收费包是否划价
 * @author LIM
 *
 */
public class GetCheckFixFeeBP {
	/**
	 * 固定收费包是否划价
	 * @param id_ent 就诊id
	 * @param dt_end 出院日期
	 * @return
	 * @throws BizException
	 */
	public BlIpOutPatPriDTO exec(String id_ent, FDateTime dt_end) throws BizException{		
		GetBlIpOutPatPriDTOBP blIpOutPatPriDTOBP = new GetBlIpOutPatPriDTOBP();
		BlIpOutPatPriDTO blIpOutPatPriDTO= new BlIpOutPatPriDTO();
		//1.如果( 参数BLSTIP0010==N   && 患者是新生儿)，则不收固定费用
		NewbornDO bbDO = ServiceFinder.find(IEnOutQryService.class).getNewbornDO(id_ent);
		if(bbDO != null && !BlParams.BLCG0010().booleanValue()){
			blIpOutPatPriDTO =blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_FIXFEE, FBoolean.TRUE, "不收固定费用");
			return blIpOutPatPriDTO;
		}
		//2.校验固定收费包是否划价
		String message=this.getPrice_FixFee(id_ent, dt_end);
		if(!StringUtils.isEmpty(message)){
			blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_FIXFEE, FBoolean.FALSE, message);
		}else{
			message=BlMsgUtils.GetCheckFixFeeMsg(FBoolean.TRUE);
			blIpOutPatPriDTO=blIpOutPatPriDTOBP.exec(IBlExternalParamConst.TYPE_FIXFEE, FBoolean.TRUE, message);
		}
		return blIpOutPatPriDTO;
	}
	
	/**
	 * 固定收费包是否划价
	 * 
	 * @param id_ent
	 * @param dt_end
	 * @return
	 * @throws BizException
	 */
	private String getPrice_FixFee(String id_ent, FDateTime dt_end) throws BizException {
//		FBoolean bPrice = FBoolean.FALSE;
		String message="";
		// 是否收取固定收费包费用
		ICiorderMDORService ciOrderService = ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO[] ciOrderDO = ciOrderService.findByAttrValString(CiOrderDO.ID_EN, id_ent);
		if (ciOrderDO != null) {
			// 2、获取就诊固定费用
			EnfixedfeeAggDO[] enFixedAggs = this.getPatFixedFeeList(id_ent);
			if (!ArrayUtil.isEmpty(enFixedAggs)) {
				//查询固定收费包模式，获取固定收费包内容是否为空，如果为空则不再校验
				if(IEnDictCodeConst.SD_DCG_MODE_DEP.equals(enFixedAggs[0].getParentDO().getSd_dcg_mode())){
					if(ArrayUtils.isEmpty(enFixedAggs[0].getEnFixedFeeItemDO())){
						return message;
					}
				}else{
					FBoolean bhasFix=getFixFeeByMode(id_ent);
					if(FBoolean.FALSE.equals(bhasFix)){
						return message;
					}
				}
				FDateTime dt_dcg_bill = enFixedAggs[0].getParentDO().getDt_dcg_bill();
				//查询入科时间
		
				if (dt_dcg_bill != null) {
					//入科时间
					FDateTime dt_Acpt= this.getPatAcpt(id_ent);
					int days= DateTimeUtils.getNatDaysBetween(dt_end, dt_dcg_bill);
					if(days>1 || dt_dcg_bill.compareTo(dt_Acpt)<=0){
						message=BlMsgUtils.GetCheckFixFeeMsg(FBoolean.FALSE);
					}
					//message =days<=1?"":BlMsgUtils.GetCheckFixFeeMsg(FBoolean.FALSE);
				}else{
					message=BlMsgUtils.GetCheckFixFeeMsg(FBoolean.FALSE);
				}
			}			
		}
		return message;
	}

	/**
	 * 获取患者未记账的固定收费Agg集合
	 * 
	 * @param entId 就诊ID
	 * @return 固定收费Agg集合
	 * @throws BizException
	 */
	private EnfixedfeeAggDO[] getPatFixedFeeList(String entId) throws BizException {
		String whereStr = String.format("ID_ENT='%s'", entId);
		IEnfixedfeeRService fixfeeRService = ServiceFinder.find(IEnfixedfeeRService.class);
		EnfixedfeeAggDO[] fixedfeeAggs = fixfeeRService.find(whereStr, null, FBoolean.FALSE);
		return fixedfeeAggs;
	}
	
	/**
	 * 查询患者入科时间
	 * @param id_ent
	 * @return
	 * @throws BizException 
	 */
	private FDateTime getPatAcpt(String id_ent) throws BizException{
		IPativisitRService ser= ServiceFinder.find(IPativisitRService.class);
		PatiVisitDO patiVisitDO= ser.findById(id_ent);
		if(patiVisitDO!=null){
			return patiVisitDO.getDt_acpt();
		}
		return null;
	}
	
	/**
	 * 判断患者固定收费包是否为空
	 * @param id_ent
	 * @return
	 * @throws DAException 
	 */
	private FBoolean getFixFeeByMode(String id_ent) throws DAException{
		StringBuilder sb= new StringBuilder();
		sb.append(" select dc.id_srvdc");
		sb.append(" from bd_srv_dc dc");
		sb.append(" inner join  bd_srv_dc_itm itm on dc.id_srvdc= itm.id_srvdc ");
		sb.append(" where id_dep like  '%'||(select id_dep_nuradm from en_ent_ip where id_ent=?)||'%'");
		
		SqlParam param= new SqlParam();
		param.addParam(id_ent);
		
		DAFacade daFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<EnFixedFeeDO> itm= (List<EnFixedFeeDO>)daFacade.execQuery(sb.toString(),param,new BeanListHandler(EnFixedFeeDO.class));		
		return ListUtil.isEmpty(itm)?FBoolean.FALSE:FBoolean.TRUE;
	}
}
