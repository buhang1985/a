package iih.bl.cg.blprinterset;

import iih.bd.res.workstation.d.WorkStationPcDO;
import iih.bl.comm.IBlParamConst;
import iih.bl.st.dto.d.BlPrinterSetDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.paramset.d.ParamSetDO;
import xap.sys.devcfg.paramset.i.IParamsetCudService;
import xap.sys.devcfg.paramset.i.IParamsetRService;
import xap.sys.devcfg.paramtmplset.d.ParamTmplSetDO;
import xap.sys.devcfg.paramtmplset.i.IParamtmplsetRService;
import xap.sys.jdbc.facade.DAFacade;

public class SavePrinterSetBp {
	
/**
 * 保存打印机设置信息
 * @param plPrinterSetDTO
 * @return
 * @throws BizException
 */
	public FBoolean execSavePrinterSetInfo(BlPrinterSetDTO plPrinterSetDTO)throws BizException {
		
		return  this.setBlPrinterSetDTO(plPrinterSetDTO);
	}
	
	/**
	 * 设置客户打印机（保存方法）
	 * @param blPrinterSetDTO
	 * @return
	 * @throws BizException
	 */
	private FBoolean setBlPrinterSetDTO(BlPrinterSetDTO blPrinterSetDTO)  throws BizException
	{
		FBoolean flag=FBoolean.TRUE;
		IParamsetCudService ser= ServiceFinder.find(IParamsetCudService.class);
		IParamsetRService ser_r= ServiceFinder.find(IParamsetRService.class);
		IParamtmplsetRService rtplSevice=ServiceFinder.find(IParamtmplsetRService.class);
		String id_pc="";
		String clientHost = xap.mw.core.data.Context.get().getClientHost();//活动pcid
		
		DAFacade dafacade=new DAFacade();
		@SuppressWarnings("unchecked")
		List<WorkStationPcDO> workStationPcDOList = (List<WorkStationPcDO>)dafacade.findByCond(WorkStationPcDO.class, " pcid='"+clientHost+"'",new String[]{"id_pc"}); 
		if(workStationPcDOList != null && workStationPcDOList.size() > 0)
		{
			id_pc=workStationPcDOList.toArray(new WorkStationPcDO[0])[0].getId_pc();
			ParamSetDO[]	 paramDos_oepInvoice    = ser_r.find(" a0.id_instance='"+id_pc+"' and a0.paramcode='"+IBlParamConst.BL_INC_OEP_INVOICE_PRINTER+"'", "", FBoolean.FALSE);
			ParamSetDO[]	 paramDos_oepItemdetail = ser_r.find(" a0.id_instance='"+id_pc+"' and a0.paramcode='"+IBlParamConst.BL_INC_OEP_ITM_PRINTER+"'", "", FBoolean.FALSE);
			ParamSetDO[]	 paramDos_reporter      = ser_r.find(" a0.id_instance='"+id_pc+"' and a0.paramcode='"+IBlParamConst.BL_INC_RPT_PRINTER+"'", "", FBoolean.FALSE);
			ParamSetDO[]	 paramDos_ipInvoice     = ser_r.find(" a0.id_instance='"+id_pc+"' and a0.paramcode='"+IBlParamConst.BL_INC_IP_INVOICE_PRINTER+"'", "", FBoolean.FALSE); 
			ParamSetDO[]	 paramDos_ipItmdetail   = ser_r.find(" a0.id_instance='"+id_pc+"' and a0.paramcode='"+IBlParamConst.BL_INC_IP_ITM_PRINTER+"'", "", FBoolean.FALSE);
			ParamSetDO[]	 paramDos_cc            = ser_r.find(" a0.id_instance='"+id_pc+"' and a0.paramcode='"+IBlParamConst.BL_INC_CC_PRINTER+"'", "", FBoolean.FALSE);
			ParamSetDO[]	 paramDos_ipprepay      = ser_r.find(" a0.id_instance='"+id_pc+"' and a0.paramcode='"+IBlParamConst.BL_INC_IP_PREPAY_PRINTER+"'", "", FBoolean.FALSE);
			ParamSetDO[]	 paramDos_oepprepay     = ser_r.find(" a0.id_instance='"+id_pc+"' and a0.paramcode='"+IBlParamConst.BL_INC_OEP_PREPAY_PRINTER+"'", "", FBoolean.FALSE);
			ParamSetDO[]	 paramDos_oepstwinno    = ser_r.find(" a0.id_instance='"+id_pc+"' and a0.paramcode='"+IBlParamConst.BL_ST_OEP_WINDOW_NO+"'", "", FBoolean.FALSE);
			ParamSetDO[]	 paramDos_ipstwinno     = ser_r.find(" a0.id_instance='"+id_pc+"' and a0.paramcode='"+IBlParamConst.BL_ST_IP_WINDOW_NO+"'", "", FBoolean.FALSE);
			ParamSetDO[]	 paramDos_fgChangeInfo  = ser_r.find(" a0.id_instance='"+id_pc+"' and a0.paramcode='"+IBlParamConst.BL_ST_OEP_CHANGE_FEEINFO+"'", "", FBoolean.FALSE);
			ParamSetDO[]	 paramDos_specOutDir     = ser_r.find(" a0.id_instance='"+id_pc+"' and a0.paramcode='"+IBlParamConst.BL_HP_OEP_SPECIALILL_OUT_DIR+"'", "", FBoolean.FALSE);
			ParamSetDO[]	 paramDos_specInDir     = ser_r.find(" a0.id_instance='"+id_pc+"' and a0.paramcode='"+IBlParamConst.BL_HP_OEP_SPECIALILL_IN_DIR+"'", "", FBoolean.FALSE);
			ParamSetDO[]	 paramDos_opFeeOutDir   = ser_r.find(" a0.id_instance='"+id_pc+"' and a0.paramcode='"+IBlParamConst.BL_HP_OEP_FEE_OUT_DIR+"'", "", FBoolean.FALSE);
			ParamSetDO[]	 paramDos_RegInfoOutDir = ser_r.find(" a0.id_instance='"+id_pc+"' and a0.paramcode='"+IBlParamConst.BL_HP_REGINFO_OUT_DIR+"'", "", FBoolean.FALSE);
			
			//1、保存门诊收费打印机设置
			this.saveBloepInvoicePrinterName(paramDos_oepInvoice, blPrinterSetDTO, id_pc);

			//2.保存门诊明细打印机设置
			this.saveBlOepItmdetail(paramDos_oepItemdetail, blPrinterSetDTO, id_pc);
		
			//3.保存报表打印机设置
			this.saveReporterPrinterName(paramDos_reporter, blPrinterSetDTO, id_pc);
	
			//4.保存住院发票打印机设置
			this.saveIpInvoicePrinterName(paramDos_ipInvoice, blPrinterSetDTO, id_pc);

			
				//5.保存住院明细打印机设置
				if(paramDos_ipItmdetail !=null &&paramDos_ipItmdetail.length>0)
				{	
					   if(blPrinterSetDTO.getBl_ip_itmdetail_printer()!=null && blPrinterSetDTO.getBl_ip_itmdetail_printer().trim().length()>0)
					    {
                        	//update
                        	paramDos_ipItmdetail[0].setValue(blPrinterSetDTO.getBl_ip_itmdetail_printer());
                        	paramDos_ipItmdetail[0].setId_instance(id_pc);
                            paramDos_ipItmdetail[0].setId_org(Context.get().getOrgId());
                        	paramDos_ipItmdetail[0].setStatus(DOStatus.UPDATED);
                        	paramDos_ipItmdetail[0].setAttrVal(ParamSetDO.DS,0);
							new DAFacade().updateDOArray(paramDos_ipItmdetail, new String[]{ParamSetDO.VALUE}); 	
						}else{
							
						     }
				}else{
						ParamTmplSetDO[] paramTmplSetDOArr=rtplSevice.find(" paramcode='"+IBlParamConst.BL_INC_IP_ITM_PRINTER+"'", "", FBoolean.FALSE);
						 if(blPrinterSetDTO.getBl_ip_itmdetail_printer()!=null && blPrinterSetDTO.getBl_ip_itmdetail_printer().trim().length()>0)
						 {
							 if(paramTmplSetDOArr!=null && paramTmplSetDOArr.length>0)
							 {
									//new 
									 ParamSetDO  newparamDo=new  ParamSetDO();
									newparamDo.setId_paramtmplset(paramTmplSetDOArr[0].getId_paramtmplset());
									newparamDo.setParamcode(paramTmplSetDOArr[0].getParamcode());
									newparamDo.setParamname(paramTmplSetDOArr[0].getParamname());
									newparamDo.setValue(blPrinterSetDTO.getBl_ip_itmdetail_printer());
									newparamDo.setId_instance(id_pc);
								    newparamDo.setId_org(Context.get().getOrgId());
									newparamDo.setCreatedby("00000000000000000000");
									newparamDo.setIseditable(FBoolean.TRUE);
									newparamDo.setIsctldownlevel(FBoolean.FALSE);
									newparamDo.setStatus(DOStatus.NEW);	
									ser.save(new ParamSetDO[]{newparamDo});
								} 
						 }
					  }	
				
				//6.保存结账打印机设置---结账打印机
				if(paramDos_cc !=null &&paramDos_cc.length>0)
				{	
					   if(blPrinterSetDTO.getBl_cc_priner()!=null && blPrinterSetDTO.getBl_cc_priner().trim().length()>0)
					    {
                        	//update
						   paramDos_cc[0].setValue(blPrinterSetDTO.getBl_cc_priner());
						   paramDos_cc[0].setId_instance(id_pc);
						   paramDos_cc[0].setId_org(Context.get().getOrgId());
						   paramDos_cc[0].setStatus(DOStatus.UPDATED);
						   paramDos_cc[0].setAttrVal(ParamSetDO.DS,0);
							new DAFacade().updateDOArray(paramDos_cc, new String[]{ParamSetDO.VALUE}); 	
						}else{
							
						     }
				}else{
						ParamTmplSetDO[] paramTmplSetDOArr=rtplSevice.find(" paramcode='"+IBlParamConst.BL_INC_CC_PRINTER+"'", "", FBoolean.FALSE);
						 if(blPrinterSetDTO.getBl_cc_priner()!=null && blPrinterSetDTO.getBl_cc_priner().trim().length()>0)
						 {
							 if(paramTmplSetDOArr!=null && paramTmplSetDOArr.length>0)
							 {
									//new 
									 ParamSetDO  newparamDo=new  ParamSetDO();
									newparamDo.setId_paramtmplset(paramTmplSetDOArr[0].getId_paramtmplset());
									newparamDo.setParamcode(paramTmplSetDOArr[0].getParamcode());
									newparamDo.setParamname(paramTmplSetDOArr[0].getParamname());
									newparamDo.setValue(blPrinterSetDTO.getBl_cc_priner());
									newparamDo.setId_instance(id_pc);
									newparamDo.setId_org(Context.get().getOrgId());
									newparamDo.setCreatedby("00000000000000000000");
									newparamDo.setIseditable(FBoolean.TRUE);
									newparamDo.setIsctldownlevel(FBoolean.FALSE);
									newparamDo.setStatus(DOStatus.NEW);	
									ser.save(new ParamSetDO[]{newparamDo});
								} 
						 }
					  }
				
				//7.保存门诊预交金打印机设置---门诊预交金打印机
				if(paramDos_oepprepay !=null &&paramDos_oepprepay.length>0)
				{	
					   if(blPrinterSetDTO.getBl_oep_prepay_printer()!=null && blPrinterSetDTO.getBl_oep_prepay_printer().trim().length()>0)
					    {
                        	//update
						   paramDos_oepprepay[0].setValue(blPrinterSetDTO.getBl_oep_prepay_printer());
						   paramDos_oepprepay[0].setId_instance(id_pc);
						   paramDos_oepprepay[0].setId_org(Context.get().getOrgId());
						   paramDos_oepprepay[0].setStatus(DOStatus.UPDATED);
						   paramDos_oepprepay[0].setAttrVal(ParamSetDO.DS,0);
							new DAFacade().updateDOArray(paramDos_oepprepay, new String[]{ParamSetDO.VALUE}); 	
						}else{
							
						     }
				}else{
						ParamTmplSetDO[] paramTmplSetDOArr=rtplSevice.find(" paramcode='"+IBlParamConst.BL_INC_OEP_PREPAY_PRINTER+"'", "", FBoolean.FALSE);
						 if(blPrinterSetDTO.getBl_oep_prepay_printer()!=null && blPrinterSetDTO.getBl_oep_prepay_printer().trim().length()>0)
						 {
							 if(paramTmplSetDOArr!=null && paramTmplSetDOArr.length>0)
							 {
									//new 
									 ParamSetDO  newparamDo=new  ParamSetDO();
									newparamDo.setId_paramtmplset(paramTmplSetDOArr[0].getId_paramtmplset());
									newparamDo.setParamcode(paramTmplSetDOArr[0].getParamcode());
									newparamDo.setParamname(paramTmplSetDOArr[0].getParamname());
									newparamDo.setValue(blPrinterSetDTO.getBl_oep_prepay_printer());
									newparamDo.setId_instance(id_pc);
									newparamDo.setId_org(Context.get().getOrgId());
									newparamDo.setCreatedby("00000000000000000000");
									newparamDo.setIseditable(FBoolean.TRUE);
									newparamDo.setIsctldownlevel(FBoolean.FALSE);
									newparamDo.setStatus(DOStatus.NEW);	
									ser.save(new ParamSetDO[]{newparamDo});
							} 
						 }
					  }
				
				//8.保存住院预交金打印机设置---住院预交金打印机
				if(paramDos_ipprepay !=null &&paramDos_ipprepay.length>0)
				{	
					   if(blPrinterSetDTO.getBl_ip_prepay_printer()!=null && blPrinterSetDTO.getBl_ip_prepay_printer().trim().length()>0)
					    {
                        	//update
						   paramDos_ipprepay[0].setValue(blPrinterSetDTO.getBl_ip_prepay_printer());
						   paramDos_ipprepay[0].setId_instance(id_pc);
						   paramDos_ipprepay[0].setId_org(Context.get().getOrgId());
						   paramDos_ipprepay[0].setStatus(DOStatus.UPDATED);
						   paramDos_ipprepay[0].setAttrVal(ParamSetDO.DS,0);
							new DAFacade().updateDOArray(paramDos_ipprepay, new String[]{ParamSetDO.VALUE}); 	
						}else{
							
						     }
				}else{
						ParamTmplSetDO[] paramTmplSetDOArr=rtplSevice.find(" paramcode='"+IBlParamConst.BL_INC_IP_PREPAY_PRINTER+"'", "", FBoolean.FALSE);
						 if(blPrinterSetDTO.getBl_ip_prepay_printer()!=null && blPrinterSetDTO.getBl_ip_prepay_printer().trim().length()>0)
						 {
							 if(paramTmplSetDOArr!=null && paramTmplSetDOArr.length>0)
							 {
									//new 
									 ParamSetDO  newparamDo=new  ParamSetDO();
									newparamDo.setId_paramtmplset(paramTmplSetDOArr[0].getId_paramtmplset());
									newparamDo.setParamcode(paramTmplSetDOArr[0].getParamcode());
									newparamDo.setParamname(paramTmplSetDOArr[0].getParamname());
									newparamDo.setValue(blPrinterSetDTO.getBl_ip_prepay_printer());
									newparamDo.setId_instance(id_pc);
									newparamDo.setId_org(Context.get().getOrgId());
									newparamDo.setCreatedby("00000000000000000000");
									newparamDo.setIseditable(FBoolean.TRUE);
									newparamDo.setIsctldownlevel(FBoolean.FALSE);
									newparamDo.setStatus(DOStatus.NEW);	
									ser.save(new ParamSetDO[]{newparamDo});
							} 
						 }
					  }
				
				//9.保存门诊结算窗口号设置---门诊结算窗口号
				if(paramDos_oepstwinno !=null &&paramDos_oepstwinno.length>0)
				{	
					   if(blPrinterSetDTO.getBl_st_oep_windowno()!=null && blPrinterSetDTO.getBl_st_oep_windowno().trim().length()>0)
					    {
                        	//update,当由前台界面带过来的窗口号字段不为空时，
						   paramDos_oepstwinno[0].setValue(blPrinterSetDTO.getBl_st_oep_windowno());
						   paramDos_oepstwinno[0].setId_instance(id_pc);
						 //  paramDos_oepstwinno[0].setId_org(IOrgConst.GLOBEORG);
						   paramDos_oepstwinno[0].setStatus(DOStatus.UPDATED);
						   paramDos_oepstwinno[0].setAttrVal(ParamSetDO.DS,0);
							new DAFacade().updateDOArray(paramDos_oepstwinno, new String[]{ParamSetDO.VALUE}); 	
						}else{
							   //update ,当由前台界面带过来的窗口号字段为空，即前台不设置值时
							   paramDos_oepstwinno[0].setValue("");
							   paramDos_oepstwinno[0].setId_instance(id_pc);
							   paramDos_oepstwinno[0].setId_org(Context.get().getOrgId());
							   paramDos_oepstwinno[0].setStatus(DOStatus.UPDATED);
							   paramDos_oepstwinno[0].setAttrVal(ParamSetDO.DS,0);
								new DAFacade().updateDOArray(paramDos_oepstwinno, new String[]{ParamSetDO.VALUE});
						     }
				}else{
						ParamTmplSetDO[] paramTmplSetDOArr=rtplSevice.find(" paramcode='"+IBlParamConst.BL_ST_OEP_WINDOW_NO+"'", "", FBoolean.FALSE);
						 if(blPrinterSetDTO.getBl_st_oep_windowno()!=null && blPrinterSetDTO.getBl_st_oep_windowno().trim().length()>0)
						 {
							 if(paramTmplSetDOArr!=null && paramTmplSetDOArr.length>0)
							 {
									//new 
									 ParamSetDO  newparamDo=new  ParamSetDO();
									newparamDo.setId_paramtmplset(paramTmplSetDOArr[0].getId_paramtmplset());
									newparamDo.setParamcode(paramTmplSetDOArr[0].getParamcode());
									newparamDo.setParamname(paramTmplSetDOArr[0].getParamname());
									newparamDo.setValue(blPrinterSetDTO.getBl_st_oep_windowno());
									newparamDo.setId_instance(id_pc);
									newparamDo.setId_org(Context.get().getOrgId());
									newparamDo.setCreatedby("00000000000000000000");
									newparamDo.setIseditable(FBoolean.TRUE);
									newparamDo.setIsctldownlevel(FBoolean.FALSE);
									newparamDo.setStatus(DOStatus.NEW);	
									ser.save(new ParamSetDO[]{newparamDo});
							} 
						 }else{
							
						 }
					  }
				
				//10.保存住院结算窗口号设置---住院结算窗口号
				if(paramDos_ipstwinno !=null &&paramDos_ipstwinno.length>0)
				{	
					   if(blPrinterSetDTO.getBl_st_ip_windowno()!=null && blPrinterSetDTO.getBl_st_ip_windowno().trim().length()>0)
					    {
                        	//update,且当前台窗口号字段设置值，带过来的字段值不为空时
						   paramDos_ipstwinno[0].setValue(blPrinterSetDTO.getBl_st_ip_windowno());
						   paramDos_ipstwinno[0].setId_instance(id_pc);
						   paramDos_ipstwinno[0].setId_org(Context.get().getOrgId());
						   paramDos_ipstwinno[0].setStatus(DOStatus.UPDATED);
						   paramDos_ipstwinno[0].setAttrVal(ParamSetDO.DS,0);
							new DAFacade().updateDOArray(paramDos_ipstwinno, new String[]{ParamSetDO.VALUE}); 	
						}else{
							    //update，且当前台窗口号字段没设置值，带过来的字段值为空时
							   paramDos_ipstwinno[0].setValue("");
							   paramDos_ipstwinno[0].setId_instance(id_pc);
							   paramDos_ipstwinno[0].setAttrVal(ParamSetDO.DS,0);
								new DAFacade().updateDOArray(paramDos_ipstwinno, new String[]{ParamSetDO.VALUE}); 
						     }
				}else{
						ParamTmplSetDO[] paramTmplSetDOArr=rtplSevice.find(" paramcode='"+IBlParamConst.BL_ST_IP_WINDOW_NO+"'", "", FBoolean.FALSE);
						 if(blPrinterSetDTO.getBl_st_ip_windowno()!=null && blPrinterSetDTO.getBl_st_ip_windowno().trim().length()>0)
						 {
							 if(paramTmplSetDOArr!=null && paramTmplSetDOArr.length>0)
							 {
									//new 且当前台窗口号字段设置值，带过来的字段值不为空时
									 ParamSetDO  newparamDo=new  ParamSetDO();
									newparamDo.setId_paramtmplset(paramTmplSetDOArr[0].getId_paramtmplset());
									newparamDo.setParamcode(paramTmplSetDOArr[0].getParamcode());
									newparamDo.setParamname(paramTmplSetDOArr[0].getParamname());
									newparamDo.setValue(blPrinterSetDTO.getBl_st_ip_windowno());
									newparamDo.setId_instance(id_pc);
									newparamDo.setId_org(Context.get().getOrgId());
									newparamDo.setCreatedby("00000000000000000000");
									newparamDo.setIseditable(FBoolean.TRUE);
									newparamDo.setIsctldownlevel(FBoolean.FALSE);
									newparamDo.setStatus(DOStatus.NEW);	
									ser.save(new ParamSetDO[]{newparamDo});
							} 
						 }else{
							    
						      }
					  }
			//	特殊病结算文件导入目录 	
		    this.saveSpecOutDirInfo(paramDos_specOutDir, blPrinterSetDTO, id_pc);
			//	特殊病项目明细导出文件目录 
			this.saveSpecInDirInfo(paramDos_specInDir, blPrinterSetDTO, id_pc);
			//	门诊费用导出目录  
			this.saveOpFeeOutDirInfo(paramDos_opFeeOutDir, blPrinterSetDTO, id_pc);
			//	挂号信息导出目录  
			this.saveRegInfoOutDirInfo(paramDos_RegInfoOutDir, blPrinterSetDTO, id_pc);
			
			this.savefgChangeInfo(paramDos_fgChangeInfo, blPrinterSetDTO, id_pc);
		}
	   return flag;
	}
	
	/**
	 * 医保特殊病导入文件目录设置信息保存
	 * @param paramDos_specOutDir
	 * @param blPrinterSetDTO
	 * @param id_pc
	 * @throws BizException
	 */
	private void  saveSpecOutDirInfo (ParamSetDO[] paramDos_specOutDir, BlPrinterSetDTO blPrinterSetDTO,String id_pc)throws BizException
	{
		IParamtmplsetRService rtplSevice=ServiceFinder.find(IParamtmplsetRService.class);
		IParamsetCudService ser= ServiceFinder.find(IParamsetCudService.class);
	
		if(paramDos_specOutDir!=null && paramDos_specOutDir.length>0)
		{	
					if(blPrinterSetDTO.getBl_hp_oep_specialill_out_dir()!=null && blPrinterSetDTO.getBl_hp_oep_specialill_out_dir().trim().length()>0)
					{
						//update
						paramDos_specOutDir[0].setValue(blPrinterSetDTO.getBl_hp_oep_specialill_out_dir());
						paramDos_specOutDir[0].setId_instance(id_pc);
						paramDos_specOutDir[0].setId_org(Context.get().getOrgId());
					    new DAFacade().updateDOArray(paramDos_specOutDir, new String[]{ParamSetDO.VALUE});	
					 }else{
						    //update，且当前台窗口号字段没设置值，带过来的字段值为空时
						    paramDos_specOutDir[0].setValue("");
						    paramDos_specOutDir[0].setId_instance(id_pc);
						    paramDos_specOutDir[0].setAttrVal(ParamSetDO.DS,0);
							new DAFacade().updateDOArray(paramDos_specOutDir, new String[]{ParamSetDO.VALUE}); 
					      }
		   }else{
			    	ParamTmplSetDO[] paramTmplSetDOArr=rtplSevice.find(" paramcode='"+IBlParamConst.BL_HP_OEP_SPECIALILL_OUT_DIR+"'", "", FBoolean.FALSE);
			    	if(blPrinterSetDTO.getBl_hp_oep_specialill_out_dir()!=null && blPrinterSetDTO.getBl_hp_oep_specialill_out_dir().trim().length()>0)
			    	{
			    		if(paramTmplSetDOArr!=null && paramTmplSetDOArr.length>0)
						{
							//new 
					        ParamSetDO  newparamDo=new  ParamSetDO();
							newparamDo.setId_paramtmplset(paramTmplSetDOArr[0].getId_paramtmplset());
							newparamDo.setParamcode(paramTmplSetDOArr[0].getParamcode());
							newparamDo.setParamname(paramTmplSetDOArr[0].getParamname());
							newparamDo.setValue(blPrinterSetDTO.getBl_hp_oep_specialill_out_dir());
							newparamDo.setId_instance(id_pc);
							newparamDo.setId_org(Context.get().getOrgId());
							newparamDo.setIseditable(FBoolean.TRUE);
							newparamDo.setIsctldownlevel(FBoolean.FALSE);
							newparamDo.setStatus(DOStatus.NEW);	
							ser.save(new ParamSetDO[]{newparamDo});
						}	
			    	}
				 
	             }
	}
	
	/**
	 * //1、保存门诊收费打印机设置
	 * @param paramDos_oepInvoice
	 * @param blPrinterSetDTO
	 * @param id_pc
	 * @throws BizException
	 */
	private  void  saveBloepInvoicePrinterName(ParamSetDO[]	 paramDos_oepInvoice,BlPrinterSetDTO blPrinterSetDTO,String id_pc) throws BizException
	{
		IParamtmplsetRService rtplSevice=ServiceFinder.find(IParamtmplsetRService.class);
		IParamsetCudService ser= ServiceFinder.find(IParamsetCudService.class);
		//1、保存门诊收费打印机设置
	    if(paramDos_oepInvoice!=null && paramDos_oepInvoice.length>0)
		{
				//应该先判断此数组是否为空，如果不为空，则已经有了数据，只是value值为空而已，如果paramDos不为空，则均视为编辑数据
				if(paramDos_oepInvoice!=null && paramDos_oepInvoice.length>0 )  //则是update数据
				{
					//参数模板
					ParamTmplSetDO[] paramTmplSetDOArr=rtplSevice.find(" paramcode='"+IBlParamConst.BL_INC_OEP_INVOICE_PRINTER+"'", "", FBoolean.FALSE);
					if(blPrinterSetDTO.getBl_oep_invoice_printer()!=null && blPrinterSetDTO.getBl_oep_invoice_printer().trim().length()>0)
					{
						//update
						
						paramDos_oepInvoice[0].setValue(blPrinterSetDTO.getBl_oep_invoice_printer());
						paramDos_oepInvoice[0].setId_instance(id_pc);
						paramDos_oepInvoice[0].setId_org(Context.get().getOrgId());
						if(paramTmplSetDOArr!=null && paramTmplSetDOArr.length>0)
						{
							paramDos_oepInvoice[0].setParamcode(paramTmplSetDOArr[0].getParamcode());
							paramDos_oepInvoice[0].setParamname(paramTmplSetDOArr[0].getParamname());	
						}
						new DAFacade().updateDOArray(paramDos_oepInvoice, new String[]{ParamSetDO.VALUE}); //也可以修改其他的属性值，调用set什么之类的方法即可，此时在ParamSetDO.VALUE后边用逗号分隔开即可
					}else{
					        
					}
				}
         }else{
				//此处else逻辑先不写，先调试正常逻辑
			    //插入数据
				ParamTmplSetDO[] paramTmplSetDOArr=rtplSevice.find(" paramcode='"+IBlParamConst.BL_INC_OEP_INVOICE_PRINTER+"'", "", FBoolean.FALSE);
				if(paramTmplSetDOArr!=null && paramTmplSetDOArr.length>0)
				{
					if(blPrinterSetDTO.getBl_oep_invoice_printer()!=null && blPrinterSetDTO.getBl_oep_invoice_printer().trim().length()>0)
					{	
						ParamSetDO  newparamDo=new  ParamSetDO();
						newparamDo.setId_paramtmplset(paramTmplSetDOArr[0].getId_paramtmplset());
						newparamDo.setParamcode(paramTmplSetDOArr[0].getParamcode());
						newparamDo.setParamname(paramTmplSetDOArr[0].getParamname());
						newparamDo.setId_org(Context.get().getOrgId());
						newparamDo.setCreatedby("00000000000000000000"); //创建人的id赋值为20个0是表示数据来源于打印机设置节点，轻量级处数据来源的创建人为登录人id，以做区分
						newparamDo.setValue(blPrinterSetDTO.getBl_oep_invoice_printer());
						newparamDo.setId_instance(id_pc);
						newparamDo.setIseditable(FBoolean.TRUE);
						newparamDo.setIsctldownlevel(FBoolean.FALSE);
						newparamDo.setStatus(DOStatus.NEW);	
						ser.save(new ParamSetDO[]{newparamDo});	
					}
				}
		  
			}
	}
	
	/**
	 * 2.保存门诊明细小条打印机名称设置
	 * @param paramDos_oepItemdetail
	 * @param blPrinterSetDTO
	 * @param id_pc
	 * @throws BizException
	 */
	private void  saveBlOepItmdetail(ParamSetDO[]	 paramDos_oepItemdetail,BlPrinterSetDTO blPrinterSetDTO,String id_pc)
			throws BizException
	{
		IParamtmplsetRService rtplSevice=ServiceFinder.find(IParamtmplsetRService.class);
		IParamsetCudService ser= ServiceFinder.find(IParamsetCudService.class);
	
		if(paramDos_oepItemdetail!=null && paramDos_oepItemdetail.length>0)
		{		
			//2.1 先判断其是否为空，如果不为空，则表示已经有门诊明细打印机设置数据了，则为update数据
			if(paramDos_oepItemdetail!=null && paramDos_oepItemdetail.length>0 )  //如果不为空，则表示已经有门诊明细打印机设置数据了，则为update数据
			{
				if(blPrinterSetDTO.getBl_oep_itmdetail_printer()!=null && blPrinterSetDTO.getBl_oep_itmdetail_printer().trim().length()>0)
				{  //表示前台做了重新设置，带过来门诊明细打印机设置字段新值
					//update
					paramDos_oepItemdetail[0].setValue(blPrinterSetDTO.getBl_oep_itmdetail_printer());
					paramDos_oepItemdetail[0].setId_instance(id_pc);
					paramDos_oepItemdetail[0].setId_org(Context.get().getOrgId());
					paramDos_oepItemdetail[0].setStatus(DOStatus.UPDATED);
					paramDos_oepItemdetail[0].setAttrVal(ParamSetDO.DS,0);
					new DAFacade().updateDOArray(paramDos_oepItemdetail, new String[]{ParamSetDO.VALUE});	
				}else{
					
				}
			}
		}else{
				 ParamTmplSetDO[] paramTmplSetDOArr=rtplSevice.find(" paramcode='"+IBlParamConst.BL_INC_OEP_ITM_PRINTER+"'", "", FBoolean.FALSE);
				 if(blPrinterSetDTO.getBl_oep_itmdetail_printer()!=null && blPrinterSetDTO.getBl_oep_itmdetail_printer().trim().length()>0)
				 {
				   if(paramTmplSetDOArr!=null && paramTmplSetDOArr.length>0)
				   {
						 //new 
						 ParamSetDO  newparamDo=new  ParamSetDO();
						 newparamDo.setId_paramtmplset(paramTmplSetDOArr[0].getId_paramtmplset());
						 newparamDo.setParamcode(paramTmplSetDOArr[0].getParamcode());
						 newparamDo.setParamname(paramTmplSetDOArr[0].getParamname());
						 newparamDo.setValue(blPrinterSetDTO.getBl_oep_itmdetail_printer());  //为value属性赋值即是设置打印机名称
						 newparamDo.setId_instance(id_pc);
						 newparamDo.setId_org(Context.get().getOrgId());
						 newparamDo.setCreatedby("00000000000000000000");
						 newparamDo.setIseditable(FBoolean.TRUE);
						 newparamDo.setIsctldownlevel(FBoolean.FALSE);
						 newparamDo.setStatus(DOStatus.NEW);
						 ser.save(new ParamSetDO[]{newparamDo});
					 }
				 }
		     }
			
	}
	/**
	 * 保存报表打印机名称设置
	 * @param paramDos_reporter
	 * @param blPrinterSetDTO
	 * @param id_pc
	 * @throws BizException
	 */
	private void saveReporterPrinterName(ParamSetDO[]	 paramDos_reporter,BlPrinterSetDTO blPrinterSetDTO,String id_pc) throws BizException
	{
		IParamtmplsetRService rtplSevice=ServiceFinder.find(IParamtmplsetRService.class);
		IParamsetCudService ser= ServiceFinder.find(IParamsetCudService.class);
	
		if(paramDos_reporter !=null && paramDos_reporter.length>0  )
		{		
			if(blPrinterSetDTO.getBl_rpt_printer()!=null && blPrinterSetDTO.getBl_rpt_printer().trim().length()>0)
			{
					//update
					paramDos_reporter[0].setValue(blPrinterSetDTO.getBl_rpt_printer());
					paramDos_reporter[0].setId_instance(id_pc);
					paramDos_reporter[0].setId_org(Context.get().getOrgId());
					paramDos_reporter[0].setStatus(DOStatus.UPDATED);
					paramDos_reporter[0].setAttrVal(ParamSetDO.DS,0);
				    new DAFacade().updateDOArray(paramDos_reporter, new String[]{ParamSetDO.VALUE});	
			}else{
					
				}
		  }else{
			    ParamTmplSetDO[] paramTmplSetDOArr=rtplSevice.find(" paramcode='"+IBlParamConst.BL_INC_RPT_PRINTER+"'", "", FBoolean.FALSE);
			    if(blPrinterSetDTO.getBl_rpt_printer()!=null && blPrinterSetDTO.getBl_rpt_printer().trim().length()>0){
			    	if(paramTmplSetDOArr!=null && paramTmplSetDOArr.length>0)
					{
							//new 
						ParamSetDO  newparamDo=new  ParamSetDO();
						newparamDo.setId_paramtmplset(paramTmplSetDOArr[0].getId_paramtmplset());
						newparamDo.setParamcode(paramTmplSetDOArr[0].getParamcode());
						newparamDo.setParamname(paramTmplSetDOArr[0].getParamname());
						newparamDo.setValue(blPrinterSetDTO.getBl_rpt_printer());
						newparamDo.setId_instance(id_pc);
						newparamDo.setId_org(Context.get().getOrgId());
						newparamDo.setCreatedby("00000000000000000000");
						newparamDo.setIseditable(FBoolean.TRUE);
						newparamDo.setIsctldownlevel(FBoolean.FALSE);
						newparamDo.setStatus(DOStatus.NEW);	
						 ser.save(new ParamSetDO[]{newparamDo});
					}	
			    }
		      }
	}
	/**
	 * 保存住院发票打印机名称设置
	 * @param paramDos_ipInvoice
	 * @param blPrinterSetDTO
	 * @param id_pc
	 * @throws BizException
	 */
	private void saveIpInvoicePrinterName(ParamSetDO[]	 paramDos_ipInvoice,BlPrinterSetDTO blPrinterSetDTO,String id_pc) 
			throws BizException
	{
		IParamtmplsetRService rtplSevice=ServiceFinder.find(IParamtmplsetRService.class);
		IParamsetCudService ser= ServiceFinder.find(IParamsetCudService.class);
	
		if(paramDos_ipInvoice!=null && paramDos_ipInvoice.length>0)
		{	
					if(blPrinterSetDTO.getBl_ip_invoice_printer()!=null && blPrinterSetDTO.getBl_ip_invoice_printer().trim().length()>0)
					{
						//update
						paramDos_ipInvoice[0].setValue(blPrinterSetDTO.getBl_ip_invoice_printer());
						paramDos_ipInvoice[0].setId_instance(id_pc);
						paramDos_ipInvoice[0].setId_org(Context.get().getOrgId());
					    new DAFacade().updateDOArray(paramDos_ipInvoice, new String[]{ParamSetDO.VALUE});	
					 }else{
						
					      }
		   }else{
			    	ParamTmplSetDO[] paramTmplSetDOArr=rtplSevice.find(" paramcode='"+IBlParamConst.BL_INC_IP_INVOICE_PRINTER+"'", "", FBoolean.FALSE);
			    	if(blPrinterSetDTO.getBl_ip_invoice_printer()!=null && blPrinterSetDTO.getBl_ip_invoice_printer().trim().length()>0)
			    	{
			    		if(paramTmplSetDOArr!=null && paramTmplSetDOArr.length>0)
						{
							//new 
							 ParamSetDO  newparamDo=new  ParamSetDO();
							newparamDo.setId_paramtmplset(paramTmplSetDOArr[0].getId_paramtmplset());
							newparamDo.setParamcode(paramTmplSetDOArr[0].getParamcode());
							newparamDo.setParamname(paramTmplSetDOArr[0].getParamname());
							newparamDo.setValue(blPrinterSetDTO.getBl_ip_invoice_printer());
							newparamDo.setId_instance(id_pc);
							newparamDo.setId_org(Context.get().getOrgId());
							newparamDo.setCreatedby("00000000000000000000");
							newparamDo.setIseditable(FBoolean.TRUE);
							newparamDo.setIsctldownlevel(FBoolean.FALSE);
							newparamDo.setStatus(DOStatus.NEW);	
							ser.save(new ParamSetDO[]{newparamDo});
						}	
			    	}
				 }
				
	}
	
	/**
	 * 门诊收费付款后若找零不为零，是否需要弹出收费信息提示框
	 * @param paramDos_fgChangeInfo
	 * @param blPrinterSetDTO
	 * @param id_pc
	 * @throws BizException
	 */
    private void savefgChangeInfo(ParamSetDO[] paramDos_fgChangeInfo, BlPrinterSetDTO blPrinterSetDTO,String id_pc)throws BizException
	{
		IParamtmplsetRService rtplSevice=ServiceFinder.find(IParamtmplsetRService.class);
		IParamsetCudService ser= ServiceFinder.find(IParamsetCudService.class);
	
		if(paramDos_fgChangeInfo!=null && paramDos_fgChangeInfo.length>0)
		{	
					if(blPrinterSetDTO.getFg_changeinfo()!=null )
					{
						//update
						paramDos_fgChangeInfo[0].setValue(blPrinterSetDTO.getFg_changeinfo().booleanValue()+"");
						paramDos_fgChangeInfo[0].setId_instance(id_pc);
						paramDos_fgChangeInfo[0].setId_org(Context.get().getOrgId());
					    new DAFacade().updateDOArray(paramDos_fgChangeInfo, new String[]{ParamSetDO.VALUE});	
					 }else{
						
					      }
		   }else{
			    	ParamTmplSetDO[] paramTmplSetDOArr=rtplSevice.find(" paramcode='"+IBlParamConst.BL_ST_OEP_CHANGE_FEEINFO+"'", "", FBoolean.FALSE);
			    	if(blPrinterSetDTO.getFg_changeinfo()!=null)
			    	{
			    		if(paramTmplSetDOArr!=null && paramTmplSetDOArr.length>0)
						{
							//new 
							ParamSetDO  newparamDo=new  ParamSetDO();
							newparamDo.setId_paramtmplset(paramTmplSetDOArr[0].getId_paramtmplset());
							newparamDo.setParamcode(paramTmplSetDOArr[0].getParamcode());
							newparamDo.setParamname(paramTmplSetDOArr[0].getParamname());
							newparamDo.setValue(blPrinterSetDTO.getFg_changeinfo().booleanValue()+"");
							newparamDo.setId_instance(id_pc);
							newparamDo.setId_org(Context.get().getOrgId());
						    newparamDo.setIseditable(FBoolean.TRUE);
							newparamDo.setIsctldownlevel(FBoolean.FALSE);
							newparamDo.setStatus(DOStatus.NEW);	
							ser.save(new ParamSetDO[]{newparamDo});
						}	
			    	}
				 }
	}
	
	/**
	 * 特殊病项目明细导出文件目录
     * @param paramDos_specInDir
	 * @param blPrinterSetDTO
	 * @param id_pc
	 * @throws BizException
	 */
	private void saveSpecInDirInfo(ParamSetDO[] paramDos_specInDir,BlPrinterSetDTO blPrinterSetDTO,String id_pc)throws BizException
	{
		IParamtmplsetRService rtplSevice=ServiceFinder.find(IParamtmplsetRService.class);
		IParamsetCudService ser= ServiceFinder.find(IParamsetCudService.class);
	
		if(paramDos_specInDir!=null && paramDos_specInDir.length>0)
		{	
					if(blPrinterSetDTO.getBl_hp_oep_specialill_in_dir()!=null && blPrinterSetDTO.getBl_hp_oep_specialill_in_dir().trim().length()>0)
					{
						//update
						paramDos_specInDir[0].setValue(blPrinterSetDTO.getBl_hp_oep_specialill_in_dir());
						paramDos_specInDir[0].setId_instance(id_pc);
						paramDos_specInDir[0].setId_org(Context.get().getOrgId());
					    new DAFacade().updateDOArray(paramDos_specInDir, new String[]{ParamSetDO.VALUE});	
					 }else{
						    paramDos_specInDir[0].setValue("");
						    paramDos_specInDir[0].setId_instance(id_pc);
						    paramDos_specInDir[0].setAttrVal(ParamSetDO.DS,0);
							new DAFacade().updateDOArray(paramDos_specInDir, new String[]{ParamSetDO.VALUE}); 
					      }
		   }else{
			    	ParamTmplSetDO[] paramTmplSetDOArr=rtplSevice.find(" paramcode='"+IBlParamConst.BL_HP_OEP_SPECIALILL_IN_DIR+"'", "", FBoolean.FALSE);
			    	if(blPrinterSetDTO.getBl_hp_oep_specialill_in_dir()!=null && blPrinterSetDTO.getBl_hp_oep_specialill_in_dir().trim().length()>0)
			    	{
			    		if(paramTmplSetDOArr!=null && paramTmplSetDOArr.length>0)
						{
							//new 
							 ParamSetDO  newparamDo=new  ParamSetDO();
							newparamDo.setId_paramtmplset(paramTmplSetDOArr[0].getId_paramtmplset());
							newparamDo.setParamcode(paramTmplSetDOArr[0].getParamcode());
							newparamDo.setParamname(paramTmplSetDOArr[0].getParamname());
							newparamDo.setValue(blPrinterSetDTO.getBl_hp_oep_specialill_in_dir());
							newparamDo.setId_instance(id_pc);
							newparamDo.setId_org(Context.get().getOrgId());
							newparamDo.setIseditable(FBoolean.TRUE);
							newparamDo.setIsctldownlevel(FBoolean.FALSE);
							newparamDo.setStatus(DOStatus.NEW);	
							ser.save(new ParamSetDO[]{newparamDo});
						}	
			    	}
				 }
	}
	
	/**
	 * 门诊费用导出目录 
	 * @param paramDos_opFeeOutDir
	 * @param blPrinterSetDTO
	 * @param id_pc
	 * @throws BizException
	 */
	private void saveOpFeeOutDirInfo(ParamSetDO[] paramDos_opFeeOutDir, BlPrinterSetDTO blPrinterSetDTO,String id_pc)throws BizException
	{
		IParamtmplsetRService rtplSevice=ServiceFinder.find(IParamtmplsetRService.class);
		IParamsetCudService ser= ServiceFinder.find(IParamsetCudService.class);
	
		if(paramDos_opFeeOutDir!=null && paramDos_opFeeOutDir.length>0)
		{	
					if(blPrinterSetDTO.getBl_hp_oep_fee_out_dir()!=null && blPrinterSetDTO.getBl_hp_oep_fee_out_dir().trim().length()>0)
					{
						//update
						paramDos_opFeeOutDir[0].setValue(blPrinterSetDTO.getBl_hp_oep_fee_out_dir());
						paramDos_opFeeOutDir[0].setId_instance(id_pc);
						paramDos_opFeeOutDir[0].setId_org(Context.get().getOrgId());
					    new DAFacade().updateDOArray(paramDos_opFeeOutDir, new String[]{ParamSetDO.VALUE});	
					 }else{
						    paramDos_opFeeOutDir[0].setValue("");
						    paramDos_opFeeOutDir[0].setId_instance(id_pc);
						    paramDos_opFeeOutDir[0].setAttrVal(ParamSetDO.DS,0);
							new DAFacade().updateDOArray(paramDos_opFeeOutDir, new String[]{ParamSetDO.VALUE}); 
					      }
		   }else{
			    	ParamTmplSetDO[] paramTmplSetDOArr=rtplSevice.find(" paramcode='"+IBlParamConst.BL_HP_OEP_FEE_OUT_DIR+"'", "", FBoolean.FALSE);
			    	if(blPrinterSetDTO.getBl_hp_oep_fee_out_dir()!=null && blPrinterSetDTO.getBl_hp_oep_fee_out_dir().trim().length()>0)
			    	{
			    		if(paramTmplSetDOArr!=null && paramTmplSetDOArr.length>0)
						{
							//new 
							 ParamSetDO  newparamDo=new  ParamSetDO();
							newparamDo.setId_paramtmplset(paramTmplSetDOArr[0].getId_paramtmplset());
							newparamDo.setParamcode(paramTmplSetDOArr[0].getParamcode());
							newparamDo.setParamname(paramTmplSetDOArr[0].getParamname());
							newparamDo.setValue(blPrinterSetDTO.getBl_hp_oep_fee_out_dir());
							newparamDo.setId_instance(id_pc);
							newparamDo.setId_org(Context.get().getOrgId());
							newparamDo.setIseditable(FBoolean.TRUE);
							newparamDo.setIsctldownlevel(FBoolean.FALSE);
							newparamDo.setStatus(DOStatus.NEW);	
							ser.save(new ParamSetDO[]{newparamDo});
						}	
			    	}
				 }
	}
	
	/**
	 * 挂号信息导出目录 
	 * @param paramDos_RegInfoOutDir
	 * @param blPrinterSetDTO
	 * @param id_pc
	 * @throws BizException
	 */
	private void saveRegInfoOutDirInfo(ParamSetDO[] paramDos_RegInfoOutDir, BlPrinterSetDTO blPrinterSetDTO,String id_pc)throws BizException
	{
		IParamtmplsetRService rtplSevice=ServiceFinder.find(IParamtmplsetRService.class);
		IParamsetCudService ser= ServiceFinder.find(IParamsetCudService.class);
	
		if(paramDos_RegInfoOutDir!=null && paramDos_RegInfoOutDir.length>0)
		{	
					if(blPrinterSetDTO.getBl_hp_reginfo_out_dir()!=null && blPrinterSetDTO.getBl_hp_reginfo_out_dir().trim().length()>0)
					{
						//update
						paramDos_RegInfoOutDir[0].setValue(blPrinterSetDTO.getBl_hp_reginfo_out_dir());
						paramDos_RegInfoOutDir[0].setId_instance(id_pc);
						paramDos_RegInfoOutDir[0].setId_org(Context.get().getOrgId());
					    new DAFacade().updateDOArray(paramDos_RegInfoOutDir, new String[]{ParamSetDO.VALUE});	
					 }else{
						    paramDos_RegInfoOutDir[0].setValue("");
						    paramDos_RegInfoOutDir[0].setId_instance(id_pc);
						    paramDos_RegInfoOutDir[0].setAttrVal(ParamSetDO.DS,0);
							new DAFacade().updateDOArray(paramDos_RegInfoOutDir, new String[]{ParamSetDO.VALUE}); 
					      }
		   }else{
			    	ParamTmplSetDO[] paramTmplSetDOArr=rtplSevice.find(" paramcode='"+IBlParamConst.BL_HP_REGINFO_OUT_DIR+"'", "", FBoolean.FALSE);
			    	if(blPrinterSetDTO.getBl_hp_reginfo_out_dir()!=null && blPrinterSetDTO.getBl_hp_reginfo_out_dir().trim().length()>0)
			    	{
			    		if(paramTmplSetDOArr!=null && paramTmplSetDOArr.length>0)
						{
							//new 
							 ParamSetDO  newparamDo=new  ParamSetDO();
							newparamDo.setId_paramtmplset(paramTmplSetDOArr[0].getId_paramtmplset());
							newparamDo.setParamcode(paramTmplSetDOArr[0].getParamcode());
							newparamDo.setParamname(paramTmplSetDOArr[0].getParamname());
							newparamDo.setValue(blPrinterSetDTO.getBl_hp_reginfo_out_dir());
							newparamDo.setId_instance(id_pc);
							newparamDo.setId_org(Context.get().getOrgId());
							newparamDo.setIseditable(FBoolean.TRUE);
							newparamDo.setIsctldownlevel(FBoolean.FALSE);
							newparamDo.setStatus(DOStatus.NEW);	
							ser.save(new ParamSetDO[]{newparamDo});
						}	
			    	}
				 }
	}
	
}
