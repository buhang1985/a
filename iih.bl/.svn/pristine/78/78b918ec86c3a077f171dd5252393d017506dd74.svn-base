package iih.bl.cg.service.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.primd.i.IPriCalService;
import iih.bl.cg.blcgoep.d.BlCgItmOepDO;
import iih.bl.cg.service.udi.IBlCgCodeConst;
import iih.bl.st.blstoep.d.BlStOepDO;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.i.ICiOrdMaintainService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.en.pv.enfee.dto.d.BalanceDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.pi.acc.account.i.IPatAccServiceExt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 分诊需要的从费用角度判断医嘱是否可以分诊的业务逻辑
 * 
 * @author 唐婵懿
 *
 */
public class BlSupportTriageCiOrderFeeBp {
	/**
	 * 从费用角度判断，是否可以分诊：
	 * 医嘱已交费，可以分诊；医嘱未交费，预交金余额任免支付，可以分诊；医嘱未交费，预交金余额不足，信用额度足够，可以分诊
	 * @param id_orArr 待判定的医嘱
	 * @return FMap<id_or,提示>
	 * @throws BizException
	 */
	public  FMap fSupportTriage_CiOrderFee(String[] id_orArr)   throws BizException
	{
		FMap idorTipfmap=new FMap();
		IOrdSrvDORService iOrdSrvDORService=ServiceFinder.find(IOrdSrvDORService.class);
		//计价接口
		IPriCalService iPriCalService=ServiceFinder.find(IPriCalService.class);
		boolean pringCg=true;  //是否记账
		boolean oepPayCg=true;//门诊：是否收费
		boolean oepFgAccCg=true;//门诊：是否预授权
		List<PriStdSrvDTO> id_srvLst=new ArrayList<PriStdSrvDTO>();
		FDouble idor_amt_ratio=new FDouble(0);
		FDouble temp_amt_ratio=new FDouble(0);
		FDouble prepayAmount =new FDouble(0);
		TimeService timeService = new TimeServiceImpl();
		FDateTime fDateTime = timeService.getUFDateTime();
		// 调用门诊账户接口
		IPatAccServiceExt patAccImpls = (IPatAccServiceExt) ServiceFinder.find(IPatAccServiceExt.class);
		//调用就诊账户接口
		IEnOutQryService inpPatAccImpls = ServiceFinder.find(IEnOutQryService.class);
		//物品领域接口
		IMaterialStockService iMaterialStockService=ServiceFinder.find(IMaterialStockService.class);
		//CI领域接口
		ICiOrdMaintainService iCiOrdMaintainService = ServiceFinder.find(ICiOrdMaintainService.class);	
		List<GetStockReqDTO> getStockReqDTOLst=null;
		DAFacade dafacade=new DAFacade();
		String sql="",source="";
		List<String> id_orsrv_error_Lst=new ArrayList<String>();//实际未记账，但是医嘱表中却打上记账标志的服务
		for(String id_or:id_orArr)
		{
			id_srvLst=new ArrayList<PriStdSrvDTO>();
			idor_amt_ratio=new FDouble(0);
			pringCg=true;  //默认已记账		
			oepPayCg=true;//门诊：默认收费
			oepFgAccCg=true;//门诊：默认预授权
			//1.获取医嘱下的服务
			OrdSrvDO[] ordSrvDOArr= iOrdSrvDORService.find(" id_or='"+id_or+"'", "", FBoolean.TRUE);			
			for(OrdSrvDO ordSrvDO: ordSrvDOArr)
			{
				temp_amt_ratio=new FDouble(0);
				getStockReqDTOLst=new ArrayList<GetStockReqDTO>();
				source=ordSrvDOArr[0].getCode_entp();
				//1.检查医嘱是否记账
				if(ordSrvDO.getSd_su_bl().equals(ICiDictCodeConst.SD_SU_BL_ACCOUNT) && ordSrvDO.getFg_bl().booleanValue())//未记账
				{
					 //医嘱表记账，门诊就诊的需要进一步检查是否收费
					if (source.equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP)
							|| source.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET)
							|| source.equals(IBdFcDictCodeConst.SD_CODE_ENTP_PE)) //门诊检查是否缴费
					{
						//查CG表
						List<BlCgItmOepDO> blCgItmOepDOLst=(List<BlCgItmOepDO>)dafacade.execQuery("select a.* from bl_cg_itm_oep a where a.id_or='"+ordSrvDO.getId_or()+"' and a.id_orsrv='"+ordSrvDO.getId_orsrv()+"' and a.id_ent='"+ordSrvDO.getId_en()+"'", new BeanListHandler(BlCgItmOepDO.class));
						if(blCgItmOepDOLst==null || blCgItmOepDOLst.size()==0)
						{
							ordSrvDO.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE); //患者未记账，需要参与下步计算
							id_orsrv_error_Lst.add(ordSrvDO.getId_orsrv());
						}
						else
						{
							//可能会参与计算的金额
							temp_amt_ratio=blCgItmOepDOLst.toArray(new BlCgItmOepDO[0])[0].getAmt_ratio();
						}
						//查ST表
						List<BlStOepDO> blStOepDOLst=(List<BlStOepDO>)dafacade.execQuery("select b.id_paypatoep from bl_cg_itm_oep a inner join bl_st_oep b on a.id_stoep=b.id_stoep where a.id_or='"+ordSrvDO.getId_or()+"' and a.id_orsrv='"+ordSrvDO.getId_orsrv()+"' and a.id_ent='"+ordSrvDO.getId_en()+"'", new BeanListHandler(BlStOepDO.class));					
						if(blStOepDOLst==null || blStOepDOLst.size()==0)
						{										
							//只有CG表，没有ST表，则数据来源于补费，已记账，未交费
							if(blCgItmOepDOLst.toArray(new BlCgItmOepDO[0])[0].getFg_acc().booleanValue()) //预授权
							{
								oepPayCg=false;
								temp_amt_ratio=new FDouble(0);
							}							
						}
						//未收付款，只划价了
						else if(blStOepDOLst.toArray(new BlStOepDO[0])[0].getId_paypatoep()==null || blStOepDOLst.toArray(new BlStOepDO[0])[0].getId_paypatoep().length()<2)
						{
							oepPayCg=false;								
						}
						else //已缴费
						{
							temp_amt_ratio=new FDouble(0);
						}
						idor_amt_ratio=idor_amt_ratio.add(temp_amt_ratio);
					}
					continue;//退出本次循环
				}
				//1.2.医嘱未记账，提取需要计价的项目
				if(!ordSrvDO.getSd_su_bl().equals(ICiDictCodeConst.SD_SU_BL_ACCOUNT) && ordSrvDO.getFg_bl().booleanValue())//未记账
				{
					pringCg=false; //未记账
					PriStdSrvDTO priStdSrvDTO=new PriStdSrvDTO();
					//1.2.1检查是不是物品
					if(ordSrvDO.getFg_mm().booleanValue()) //物品
					{						
						sql=" select id_mm,quan_cur,id_pgku_cur from ci_or_srv_mm where id_orsrv = '"+ordSrvDO.getId_orsrv()+"'";
						List<OrdSrvMmDO> ordSrvMmDOLst=(List<OrdSrvMmDO>)dafacade.execQuery(sql,new BeanListHandler(OrdSrvMmDO.class));
						if(ordSrvMmDOLst!=null && ordSrvMmDOLst.size()>0)
						{
							for(OrdSrvMmDO ordSrvMmDO:ordSrvMmDOLst)
							{
								GetStockReqDTO getStockReqDTO=new GetStockReqDTO();
								getStockReqDTO.setId_dep(ordSrvDO.getId_dep_wh());
								getStockReqDTO.setId_mm(ordSrvMmDO.getId_mm());
								getStockReqDTO.setReq_unit_id(ordSrvMmDO.getId_pgku_cur());
								getStockReqDTOLst.add(getStockReqDTO);
							}
							MaterialStockDTO[] materialStockDTOArr=iMaterialStockService.getMaterialStocks(getStockReqDTOLst.toArray(new GetStockReqDTO[0]));
							for(MaterialStockDTO materialStockDTO: materialStockDTOArr)
							{
								for(OrdSrvMmDO ordSrvMmDO:ordSrvMmDOLst)
								{
									//2.2获取物品费用：单价*数量
									idor_amt_ratio=idor_amt_ratio.add(materialStockDTO.getPrice_act().multiply(ordSrvMmDO.getQuan_cur()).setScale(-2, BigDecimal.ROUND_HALF_UP));
								}
							}
						}										
					}
					else//非物品
					{
						priStdSrvDTO.setId_srv(ordSrvDO.getId_srv());
						priStdSrvDTO.setName_srv(ordSrvDO.getName_srv());
						priStdSrvDTO.setQuan(ordSrvDO.getQuan_total_medu());
						id_srvLst.add(priStdSrvDTO);
					}
				}
			}
			
			//2.查项目对应的价格
			if(id_srvLst!=null && id_srvLst.size()>0)
			{
				SrvPricalRateAndPriceDTO[] srvPricalRateAndPriceDTOArr=iPriCalService.CalManySrvsPriceMapByIdent(id_srvLst.toArray(new PriStdSrvDTO[0]), ordSrvDOArr[0].getId_en());
				
				for(SrvPricalRateAndPriceDTO srvPricalRateAndPriceDTO: srvPricalRateAndPriceDTOArr)
				{
					for(OrdSrvDO ordSrvDO: ordSrvDOArr)
					{
						if(srvPricalRateAndPriceDTO.getId_srv().equals(ordSrvDO.getId_srv()))
						{
							//2.1非物品费用:单价*数量*价格比例
							idor_amt_ratio=idor_amt_ratio.add(srvPricalRateAndPriceDTO.getPrice().multiply(ordSrvDO.getQuan_total_medu()).multiply(srvPricalRateAndPriceDTO.getRate()).setScale(-2, BigDecimal.ROUND_HALF_UP));
						}
					}
				}
			}
			
			//3.检查可用额度是否足够			
			if(idor_amt_ratio.compareTo(FDouble.ZERO_DBL)>0)
			{
				if (source.equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP)
						|| source.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET)
						|| source.equals(IBdFcDictCodeConst.SD_CODE_ENTP_PE)) //门急诊
				{
					
					// 3.1计算门诊账户余额：调用门诊账户接口
					prepayAmount = patAccImpls
							.GetOutpPrepaymentAmount(ordSrvDOArr[0].getId_pat());
					if(prepayAmount.compareTo(idor_amt_ratio) < 0)
					{
						idorTipfmap.put(id_or, IBlCgCodeConst.CODE_CI_NO_PRICING_NO_PAYPAMET);//未计费，可用额度不足	
					}
					else
					{
						idorTipfmap.put(id_or,IBlCgCodeConst.CODE_CI_NO_PRICING_PAYPAMET);//未计费，可用额度充足
					}
				}
				else  //住院
				{
					
					BalanceDTO balanceDTO = inpPatAccImpls
							.getBalanceDTO(ordSrvDOArr[0].getId_en());
					prepayAmount = balanceDTO.getAvailable();
					//3.2 与标准金额比较，当预交金余额不足时，需要进行示范允许后付费的判断
					if (prepayAmount.compareTo(idor_amt_ratio) < 0) 
					{
						idorTipfmap.put(id_or,  IBlCgCodeConst.CODE_CI_NO_PRICING_NO_PAYPAMET);//未计费，可用额度不足			
					}
					else
					{
						idorTipfmap.put(id_or,IBlCgCodeConst.CODE_CI_NO_PRICING_PAYPAMET);//未计费，可用额度充足
					}
				}
			}
			
			if(pringCg)//已记账
			{
				idorTipfmap.put(id_or, IBlCgCodeConst.CODE_CI_PRICING);	//门诊：已收费；住院：已记账			
			}
		}
		//处理医嘱表中标志为已记账，但是记账表中没有记录的医嘱，置为未记账
		if(id_orsrv_error_Lst!=null && id_orsrv_error_Lst.size()>0)
		{
			FBoolean updateRes=iCiOrdMaintainService.UpdateOrdChargeRelInfo2( (String[])id_orsrv_error_Lst.toArray(), ICiDictCodeConst.SD_SU_BL_NONE,ICiDictCodeConst.SD_SU_BL_NONE_ID,fDateTime,FeeReverseType.NOBLCANCEL);
			if(!updateRes.booleanValue())
			{
				throw new BizException("更新医嘱状态失败,本次操作不成功！");
			}
		}

		return idorTipfmap;
	}
}
