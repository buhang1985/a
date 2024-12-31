package iih.bl.cc.ep;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBlDictCodeConst;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.pp.pripm.i.IPripmRService;
import iih.bl.cc.blcc.d.BlCcPmDO;
import iih.bl.cc.blcc.d.BlccAggDO;
import iih.bl.st.blpaypatip.d.BlPayPatIpDO;
import iih.bl.st.blpaypatip.d.BlpaypatipAggDO;
import iih.bl.st.blpaypatip.i.IBlpaypatipMDOCudService;
import iih.bl.st.blpaypatip.i.IBlpaypatipMDORService;
import iih.bl.st.blpaypatip.i.IBlpaypatipRService;
import iih.bl.st.blpaypatoep.d.BlPayPatOepDO;
import iih.bl.st.blpaypatoep.d.BlpaypatoepAggDO;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepMDOCudService;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepMDORService;
import iih.bl.st.blpaypatoep.i.IBlpaypatoepRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 结账付款方式EP
 * @author yankan
 * @since 2017-06-19
 *
 */
public class CcPmEP {
	/**
	 * 修改门诊结算收付款门诊表的结算标识为已结账
	 * @param id_cc 结账id
	 * @throws Exception
	 * @author LIM
	 */
	public void updatePayPatOepDO(String id_user,FDateTime end_time,String id_cc) throws BizException{
		IBlpaypatoepMDORService peRService = ServiceFinder.find(IBlpaypatoepMDORService.class);
		IBlpaypatoepMDOCudService peCService = ServiceFinder.find(IBlpaypatoepMDOCudService.class);
		BlPayPatOepDO[] blPayPatOepDOArr = peRService.find(this.getQrySql(id_user,end_time), null, FBoolean.FALSE);
		if(blPayPatOepDOArr != null && blPayPatOepDOArr.length > 0){
			for(BlPayPatOepDO blPayPatOepDO : blPayPatOepDOArr){
				blPayPatOepDO.setId_cc(id_cc);
				blPayPatOepDO.setFg_cc(FBoolean.TRUE);
				blPayPatOepDO.setStatus(DOStatus.UPDATED);
			}
			peCService.save(blPayPatOepDOArr);
		}
	}
	/**
	 * 修改门诊结算收付款表(BL_PAY_PAT_OEP)中结账标志为未结账
	 * @param blccAggDO
	 * @throws BizException
	 * @author LIM
	 */
	public void updatePayPatOepDOForCancel(String sqlStr,BlccAggDO blccAggDO) throws BizException{	
		IBlpaypatoepMDORService payOepService = ServiceFinder.find(IBlpaypatoepMDORService.class);//门诊
		
		BlPayPatOepDO[] blPayPatOepDOArr = payOepService.find(sqlStr, null, FBoolean.FALSE);
		if(blPayPatOepDOArr != null && blPayPatOepDOArr.length > 0){
			for(BlPayPatOepDO blPayPatOepDO : blPayPatOepDOArr){
				blPayPatOepDO.setId_cc(null);
				blPayPatOepDO.setFg_cc(FBoolean.FALSE);
				blPayPatOepDO.setStatus(DOStatus.UPDATED);
			}
			IBlpaypatoepMDOCudService patOepService = ServiceFinder.find(IBlpaypatoepMDOCudService.class);
			patOepService.save(blPayPatOepDOArr);
		}
	}	
	
	/**
	 * 修改住院结算收付款住院表的结算标示为已结账
	 * @param id_user
	 * @param end_time
	 * @param id_cc
	 * @throws BizException
	 * @author LIM
	 */
	public void updatePayPatIpDO(String id_user,FDateTime end_time,String id_cc) throws BizException{
		IBlpaypatipMDORService piRService = ServiceFinder.find(IBlpaypatipMDORService.class);
		IBlpaypatipMDOCudService piCService = ServiceFinder.find(IBlpaypatipMDOCudService.class);
		BlPayPatIpDO[] blPayPatIpDOArr = piRService.find(this.getQrySql(id_user,end_time), null, FBoolean.FALSE);
		if(blPayPatIpDOArr != null && blPayPatIpDOArr.length > 0){
			for(BlPayPatIpDO blPayPatIpDO : blPayPatIpDOArr){
				blPayPatIpDO.setId_cc(id_cc);
				blPayPatIpDO.setFg_cc(FBoolean.TRUE);
				blPayPatIpDO.setStatus(DOStatus.UPDATED);
			}
			piCService.save(blPayPatIpDOArr);
		}		
	}
	/**
	 * 修改住院结算收付款表(BL_PAY_PAT_IP)中结账标志为未结账
	 * @param sqlStr
	 * @throws BizException
	 */
	public void updatePayPatIpDOForCanecl(String sqlStr)throws BizException{
		IBlpaypatipMDORService payIpService = ServiceFinder.find(IBlpaypatipMDORService.class);//住院
		
		BlPayPatIpDO[] blPayPatIpDOArr = payIpService.find(sqlStr, null, FBoolean.FALSE);
		if(blPayPatIpDOArr != null && blPayPatIpDOArr.length > 0){
			for(BlPayPatIpDO blPayPatIpDO : blPayPatIpDOArr){
				blPayPatIpDO.setId_cc(null);
				blPayPatIpDO.setFg_cc(FBoolean.FALSE);
				blPayPatIpDO.setStatus(DOStatus.UPDATED);
			}
			IBlpaypatipMDOCudService patIpService = ServiceFinder.find(IBlpaypatipMDOCudService.class);
			patIpService.save(blPayPatIpDOArr);
		}
	}
	/**
	 * 获取查询条件
	 * @param id_user
	 * @param end_time
	 * @return
	 * @author LIM
	 */
	private String getQrySql(String id_user,FDateTime end_time){
		StringBuilder sf= new StringBuilder();
		sf.append(" a0.FG_CC = 'N'");
		sf.append(" and a0.ID_EMP_PAY = '").append(id_user).append("'")
//		  .append(" and a0.ID_ORG = '").append(id_org).append("'")
		  .append(" and a0.DT_PAY < '").append(end_time).append("'");
		return sf.toString();
	}
	/**
	 * 检查是否存在门诊/住院收退款数据
	 * */
	public FBoolean checkBlPayPatInfo(String id_user, String id_org,String sd_cctp,FDateTime end_time) throws BizException{
		FBoolean flag = FBoolean.FALSE;
		StringBuffer sf = new StringBuffer();
		sf.append(" a0.FG_CC = 'N'")
		  .append(" and a0.ID_EMP_PAY = '").append(id_user).append("'")
//					  .append(" and a0.ID_ORG = '").append(id_org).append("'")
		  .append(" and a0.DT_PAY < '").append(end_time).append("'");
		if(IBlDictCodeConst.SD_CCTP_MZSF.equals(sd_cctp)|| IBlDictCodeConst.SD_CCTP_MZLC.equals(sd_cctp)){//门诊（患者）
			IBlpaypatoepRService oepService = ServiceFinder.find(IBlpaypatoepRService.class);
			BlpaypatoepAggDO[] oepAggDOArr = oepService.find(sf.toString(), null, FBoolean.FALSE);
			if(oepAggDOArr != null && oepAggDOArr.length > 0){
				for(BlpaypatoepAggDO aggDO : oepAggDOArr){
					if(aggDO.getBlPayItmPatOepDO() != null && aggDO.getBlPayItmPatOepDO().length > 0){
						flag = FBoolean.TRUE;
						break;
					}
				}
			}
		}else if(IBlDictCodeConst.SD_CCTP_ZYSF.equals(sd_cctp) || IBlDictCodeConst.SD_CCTP_ZYLC.equals(sd_cctp)){//住院
			IBlpaypatipRService ipService = ServiceFinder.find(IBlpaypatipRService.class);
			BlpaypatipAggDO[] ipAggDOArr = ipService.find(sf.toString(), null, FBoolean.FALSE);
			if(ipAggDOArr != null && ipAggDOArr.length > 0){
				for(BlpaypatipAggDO aggDO : ipAggDOArr){
					if(aggDO.getBlPayItmPatIpDO() != null && aggDO.getBlPayItmPatIpDO().length > 0){
						flag = FBoolean.TRUE;
						break;
					}
				}
			}
		}
		return flag;
	}	
	/**
	 * 补全收款方式
	 * @param blccAggDOArr
	 * @throws BizException
	 */
	public void setBlCcPmInfo(BlccAggDO[] blccAggDOArr) throws BizException{
		IPripmRService pmService = ServiceFinder.find(IPripmRService.class);
		//PriPmDO[] priPmDOArr = pmService.find(" 1 = 1 and id_pm <> '@@@@Z7100000000H1L91'", null, FBoolean.FALSE);
		PriPmDO[] priPmDOArr = pmService.find(" 1 = 1 ", null, FBoolean.FALSE);
		
		for(BlccAggDO aggDO : blccAggDOArr){
			List<BlCcPmDO> blCcPmDOList = new ArrayList<BlCcPmDO>();
			if(aggDO.getBlCcPmDO() == null || aggDO.getBlCcPmDO().length == 0){
				for(PriPmDO priPmDO : priPmDOArr){
					BlCcPmDO blCcPmDO = new BlCcPmDO();
					blCcPmDO.setId_pm(priPmDO.getId_pm());
					blCcPmDO.setCode(priPmDO.getCode());
					blCcPmDO.setName(priPmDO.getName());
					blCcPmDO.setAmt(new FDouble(0.00,2));
					blCcPmDO.setCn_amt(0);
					blCcPmDO.setAmt_return(new FDouble(0.00,2));
					blCcPmDO.setCn_amtreturn(0);
					blCcPmDOList.add(blCcPmDO);
				}
			}else{
				for(PriPmDO priPmDO : priPmDOArr){
					Boolean flag = false;
					for(BlCcPmDO blCcPmDO : aggDO.getBlCcPmDO()){
						if(blCcPmDO.getId_pm().equals(priPmDO.getId_pm())){
							flag = true;
							blCcPmDOList.add(blCcPmDO);
							break;
						}
					}
					if(!flag){
						BlCcPmDO blCcPmDO = new BlCcPmDO();
						blCcPmDO.setId_pm(priPmDO.getId_pm());
						blCcPmDO.setCode(priPmDO.getCode());
						blCcPmDO.setName(priPmDO.getName());
						blCcPmDO.setAmt(new FDouble(0.00,2));
						blCcPmDO.setCn_amt(0);
						blCcPmDO.setAmt_return(new FDouble(0.00,2));
						blCcPmDO.setCn_amtreturn(0);
						blCcPmDOList.add(blCcPmDO);
					}
				}
			}
			aggDO.setBlCcPmDO(blCcPmDOList.toArray(new BlCcPmDO[]{}));
			TimeService timeService = new TimeServiceImpl();
			aggDO.getParentDO().setDt_pt(timeService.getUFDateTime());
		}
	}	
}
