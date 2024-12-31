package iih.bl.pay.designedfundspkgcollect.bp;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.incca.i.IBdInccaCodeConst;
import iih.bd.pp.pripm.i.IBdPripmCodeConst;
import iih.bl.inc.blinciss.d.BlIncIssDO;
import iih.bl.inc.blinciss.i.IBlincissCudService;
import iih.bl.inc.blinciss.i.IBlincissRService;
import iih.bl.inc.service.i.IBLInvoiceService;
import iih.bl.pay.blpaypat.d.BlPrePayPatDO;
import iih.bl.pay.blpaypat.i.IBlpaypatCudService;
//import iih.bl.inc.blinciss.Service.i.IBLInvoiceService;
import iih.bl.pay.blpayspcl.d.BlPayItmSpclDO;
import iih.bl.pay.blpayspcl.d.BlPaySpclDO;
import iih.bl.pay.blpayspcl.d.BlpayspclAggDO;
import iih.bl.pay.blpayspcl.i.IBlpayspclCudService;
import iih.bl.pay.blspclpat.d.BlSpclItmPatDO;
import iih.bl.pay.blspclpat.d.BlSpclPatDO;
import iih.bl.pay.blspclpat.d.BlspclpatAggDO;
import iih.bl.pay.blspclpat.i.IBlspclpatCudService;
import iih.bl.pay.dto.d.BdPriSrvPkgVsItmDTO;
import iih.bl.pay.dto.d.PiPatSrvPkgVsItmDTO;
import iih.bl.pay.dto.d.PipatSrvPkgDTO;
import iih.bl.pay.ep.PiPatSrvPkgDOEp;
import iih.pi.acc.account.d.PiPatAccDO;
import iih.pi.acc.account.i.IPatAccServiceExt;
import iih.pi.patsrvpkg.dto.PiPatSrvPkgTotalDTO;
import iih.pi.patsrvpkg.i.IPiPatsrvpkgMaintainService;
import iih.pi.patsrvpkg.patsrvpkg.d.PiPatSrvPkgDO;
import iih.pi.patsrvpkg.patsrvpkg.i.IPatsrvpkgCudService;



import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;



/** 文件头注释
* ==============================================================================
* @Filename: DesignedFundsPkgCollectBp   
* @Date: 2016/06/30 10:37:15
* @Compiler: Eclipse luna 4.4.1 
* @author li_pengying
* @Company: Copyright 2016 by PKU healthcare IT Co.,Ltd.
* @Description:优惠包销售（又名专用款收款）节点用的接口中所用方法的实现类
* ==============================================================================
*/

public class DesignedFundsPkgCollectBp {
  
//   /***
//    * 得到所有可用的优惠包，和患者无关
//    * @return
//    * @throws BizException
//    */
//  public PipatSrvPkgDTO[] getAllPipatSrvPkgDTOs()throws BizException{
//	  StringBuffer sb=new StringBuffer();
//	   sb.append(" select A.id_srvpkg,A.NAME,A.code ,A.id_srvpkgbltp,A.sd_srvpkgbltp,A.fg_multien,A.Fg_Entp_Er,A.Fg_Entp_Fm,A.Fg_Entp_Ip,A.Fg_Entp_Op,A.Fg_Entp_Pe, ");
//	   sb.append("  B.amt,B.id_pripkg  ");
//	   sb.append("        from  bd_srv_pkg       A  ");
//	   sb.append("      left  join    bd_pri_pkg       B ");
//	   sb.append("        on A.id_srvpkg=B.id_srvpkg ");
//	   sb.append("   ");
//	   
//	   @SuppressWarnings("unchecked")
//	   List<PipatSrvPkgDTO> list  = (List<PipatSrvPkgDTO>)new DAFacade().execQuery(sb.toString(), new BeanListHandler(PipatSrvPkgDTO.class));
//	   PipatSrvPkgDTO[]  ppspDOArr=list.toArray(new PipatSrvPkgDTO[]{});
//	   return ppspDOArr;
//  }
	
	
/**
 * 通过患者的主键id获得改患者名下的优惠包
 * @param id_pat
 * @return
 * @throws BizException
 */
//public PipatSrvPkgDTO[] execfindPiPatSrvPkgDTOByIdpat(String id_pat) throws BizException {
//	// TODO Auto-generated method stub
//	 StringBuffer sb=new StringBuffer();
//	   sb.append(" select A.id_srvpkg,A.name,B.amt,C.code as code_pat,C.name as name_pat,D.name as name_empinc  ");
//	   sb.append("  ");
//	   sb.append("        from  pi_pat_srv_pkg  A ");
//	   sb.append("   left  join  bd_pri_pkg     B ");
//	   sb.append("       on A.id_srvpkg=B.id_srvpkg ");
//	   sb.append("    join       pi_pat         C  ");
//	   sb.append("       on A.id_pat=C.id_pat ");
//	   sb.append("    join       bd_psndoc      D  ");
//	   sb.append("       on A.id_emp_sale=D.id_psndoc");
//	   sb.append(" where fg_pay='N'  ");
//	  // sb.append("     and  A.id_pat='").append(id_pat).append("' ");
//	   sb.append("     and  A.id_pat=?  ");
//	   SqlParam sqlparam=new SqlParam();
//	   sqlparam.addParam(id_pat);
//	 
//	   @SuppressWarnings("unchecked")
//	   List<PipatSrvPkgDTO> list  = (List<PipatSrvPkgDTO>)new DAFacade().execQuery(sb.toString(),sqlparam, new BeanListHandler(PipatSrvPkgDTO.class));
//	   PipatSrvPkgDTO[]  ppspDOArr=list.toArray(new PipatSrvPkgDTO[]{});
//	   return ppspDOArr;
//}


public String getNextInvoiceNo(String id_emp_inc, String code_incca)throws BizException {
	// TODO Auto-generated method stub
	//付款后需要修改当前票据号
		//设置当前收据号
		/*IBLInvoiceService iBLInvoiceService = ServiceFinder.find(IBLInvoiceService.class);	
		return iBLInvoiceService.NextInvoiceNoUpdateCurNoAndGetInvoiceNo(id_emp_inc, code_incca);*/
	return null;
}





/**
 * 优惠包销售节点付款时用，用于保存更新和新增的数据，将所有数据在一个事务中保存
 * author:  li_pengying
 * @param ppspDOArr
 * @param pkgs
 * @param blspclpatAggDOArr
 * @param blpayspclAggDO
 * @return
 * @throws BizException
 */
public FBoolean doSaveNewAndUpdateData(PiPatSrvPkgDO[] ppspDOArr,
		PiPatSrvPkgTotalDTO[] pkgs,BlPrePayPatDO[] blprepaypatDOArr, BlspclpatAggDO[] blspclpatAggDOArr,
		BlpayspclAggDO blpayspclAggDO)throws BizException {
	// TODO Auto-generated method stub
	//主要业务：1、保存需要更新的患者服务包数据  2.保存新增的数据：2.1保存新增患者域服务包pi_pat_srv_pkg数据   2.2保存bl领域的新增数据:2.2.1保存患者专用款bl_spcl_pat数据 2.2.2保存收付款专用款bl_pay_spcl数据
	
	//1.1  如果有需要更新的患者服务包数据，保存更新的患者服务包数据  
	PiPatSrvPkgDOEp ppspep = new PiPatSrvPkgDOEp();
	PiPatSrvPkgDO[] pipatSrvPkgDOArr = ppspep.save(ppspDOArr);
	//1.2保存患者域新增服务包数据
	//先保存新增的患者域的服务包数据，再将其取出来把生成的主键作为bl域中的外键回写到bl域数据表中
	PiPatSrvPkgTotalDTO[]  totalDTOArr=this.doSaveNewPipatsrvpkgAggDOData(pkgs);
	
	//2.准备bl域的需要保存的数据blspclpatAggDOArr,blpayspclAggDO
	//再将保存后的服务包数据取出来，将其以外键形式和新增的BL数据关联起来
	if(totalDTOArr==null||totalDTOArr.length==0) return FBoolean.FALSE;
	for(int i=0;i<totalDTOArr.length;i++){
		PiPatSrvPkgTotalDTO pipatSrvPkgTotalDTO=totalDTOArr[i];
		PiPatSrvPkgDO pipatsrvpkgDO=pipatSrvPkgTotalDTO.getPiPatSrvPkgDO();
		FArrayList list_GrpDTOs=pipatSrvPkgTotalDTO.getGroup();
        //由于pkgs的元素个数和blspclpatAggDOArr中的个数相同
		BlSpclPatDO blspclPatDO=blspclpatAggDOArr[i].getParentDO();
		BlSpclItmPatDO[] blspclItmPatDOArr=blspclpatAggDOArr[i].getBlSpclItmPatDO();
	}
	
	 for(int m=0;m<blspclpatAggDOArr.length;m++)
     {
		 //先为BlSpclPatDO和pi领域的服务包的关联外键赋值,一个totalDTO对应一个BlSpclPatAggDO数据
		 BlSpclPatDO	 blSpclPatDO =blspclpatAggDOArr[m].getParentDO();
		 PiPatSrvPkgDO   pipatSrvPkgDO=totalDTOArr[m].getPiPatSrvPkgDO();
		 String idPatsrvpkg= pipatSrvPkgDO.getId_patsrvpkg();
		 blSpclPatDO.setId_src(idPatsrvpkg);
		
		 //再为BlSpclItmPatDO[]数组的各个数据和pi领域的服务包的关联外键赋值
         BlSpclItmPatDO[]  blSpclItmPatDOArr=blspclpatAggDOArr[m].getBlSpclItmPatDO();
		 for(BlSpclItmPatDO blSpclItmPatDO: blSpclItmPatDOArr)
		 {
			for(PiPatSrvPkgTotalDTO piPatSrvPkgTotalDTO:totalDTOArr)
			{
				//1.根据id_patsrvpkg获得id_srvpkg,d.id_patsrvpkgsrv,d.id_srv
				 PiPatSrvPkgDO piPatSrvPkgDO=piPatSrvPkgTotalDTO.getPiPatSrvPkgDO();
				 StringBuffer sql1=new StringBuffer();
				 sql1.append(" select a.id_patsrvpkg, ");
				 sql1.append("        a.id_srvpkg, ");
				 sql1.append("        d.id_patsrvpkgsrv, ");
				 sql1.append("        d.ID_SRVPKGITMCOMP ");
				 sql1.append("   from PI_PAT_SRV_PKG          a, ");
				 sql1.append("        PI_PAT_SRV_PKG_GR       b, ");
				 sql1.append("        pi_pat_srv_pkg_itm      c, ");
				 sql1.append("        pi_pat_srv_pkg_itm_comp d ");
				 sql1.append("  where a.id_patsrvpkg = b.id_patsrvpkg ");
				 sql1.append("    and b.id_patsrvpkggr = c.id_patsrvpkggr ");
				 sql1.append("    and c.id_patsrvpkgitm = d.id_patsrvpkgitm ");
				 sql1.append("    and a.id_patsrvpkg = ? ");
				 sql1.append("  order by d.sv desc ");//新增后，获得主键
				 SqlParam sqlp=new SqlParam();
				 sqlp.addParam(piPatSrvPkgDO.getId_patsrvpkg());
				 DAFacade dafacade=new DAFacade();
				 List<PiPatSrvPkgVsItmDTO> piPatSrvPkgVsItmDTO=(List<PiPatSrvPkgVsItmDTO>)dafacade.execQuery(sql1.toString(),sqlp, new BeanListHandler(PiPatSrvPkgVsItmDTO.class));
				 if(null==piPatSrvPkgVsItmDTO || piPatSrvPkgVsItmDTO.size()==0)
				 {
					throw new BizException("查询患者优惠包失败");
				 }
				 //2.建立一个map，里边的key是id_srvpkgitmcomp字段的值，value是id_patsrvpkgsrv的值
				 Map<String,String> pi_pat_srvpkgitmcompsrv=new HashMap<String,String>();
				 List<String> Id_patsrvpkgitmLst=new ArrayList<String>();
				 for(PiPatSrvPkgVsItmDTO piPatSrvPkgVsItmDTO1:piPatSrvPkgVsItmDTO)
				 {
					 pi_pat_srvpkgitmcompsrv.put(piPatSrvPkgVsItmDTO1.getId_srvpkgitmcomp(),piPatSrvPkgVsItmDTO1.getId_patsrvpkgsrv());
                 }
				 
			 //3.根据id_srvpkg获得付款策略领域的b1.id_srvpkgitmcomp,b1.id_srv（收费ID_SRV)
		     sql1=new StringBuffer();
			 sql1.append("  select a1.id_srvpkg, b1.id_pripkgitm, b1.id_srvpkgitmcomp, b1.id_srv ");
			 sql1.append("    from bd_pri_pkg a1, bd_pri_pkg_itm b1 ");
			 sql1.append("   where a1.id_pripkg = b1.id_pripkg ");
			 sql1.append("     and a1.id_srvpkg = ? ");
			 sqlp.clearParams();
			 sqlp.addParam(piPatSrvPkgDO.getId_srvpkg());
			 List<BdPriSrvPkgVsItmDTO> bdSrvPkgVsItmDTOLst=(List<BdPriSrvPkgVsItmDTO>)dafacade.execQuery(sql1.toString(),sqlp, new BeanListHandler(BdPriSrvPkgVsItmDTO.class));
			 if(bdSrvPkgVsItmDTOLst==null || bdSrvPkgVsItmDTOLst.size()==0)
			 {
				 throw new BizException("没有找到医疗服务包，服务包ID:"+piPatSrvPkgDO.getId_srvpkg());
			 }
			 //4.BL_PAY_ITM_SPCL中的id_srv与3中id_srv比较，得到id_srvpkgitmcomp
				 for(BdPriSrvPkgVsItmDTO bdPriSrvPkgVsItmDTO:bdSrvPkgVsItmDTOLst)
				 {
					 if(blSpclItmPatDO.getId_srv().equals(bdPriSrvPkgVsItmDTO.getId_srv()))
					 {
						 //通过比较1,3中的id_srv是否相同来看是否赋值，找到对应的id_srv数据，得到了id_srvpkgitmcomp字段的值，由于它是主键是唯一的，可由map的 key值得到其value值。
						String id_patsrvpkgsrv= pi_pat_srvpkgitmcompsrv.get(bdPriSrvPkgVsItmDTO.getId_srvpkgitmcomp());						
						
						blSpclItmPatDO.setId_patsrvpkgitm(id_patsrvpkgsrv);
					 }
				  
				 }
			}
		 }
	
	}
     //保存预交金支付数据，主要从前台的支付时的付款明细中带过来的数据
	IBlpaypatCudService  blprepaySer=ServiceFinder.find(IBlpaypatCudService.class);
	BlPrePayPatDO[] blprepaySave=blprepaySer.save(blprepaypatDOArr) ;
	
	//将生成的预交金主键作为外键回写到患者收付款专用款id_paypat中，
	BlPayItmSpclDO[]  blpayItmSpclDOs=blpayspclAggDO.getBlPayItmSpclDO();
    if(blprepaySave!=null && blprepaySave.length>0  && blpayItmSpclDOs!=null && blpayItmSpclDOs.length>0){
		for(BlPrePayPatDO  varplppp : blprepaySave){
			for(BlPayItmSpclDO varblpis :blpayItmSpclDOs){
				if(varblpis.getId_pm().equals(IBdPripmCodeConst.ID_PRI_PM_PAY)){
					Integer fd1=   varplppp.getEu_direct();
					Integer fd2=   varblpis.getEu_direct();
					if(fd1 == -fd2){
						System.out.println(" 判断方向值是否是相反的");
					}
					if(varplppp.getAmt().equals(varblpis.getAmt())  && fd1== -fd2  ){
						varblpis.setId_paypat(varplppp.getId_paypat());
					}
				}
			}
		}
	}
	blpayspclAggDO.setBlPayItmSpclDO(blpayItmSpclDOs);
	//保存新增的bl域数据
	FBoolean bl=this.doSaveNewBlData(blspclpatAggDOArr, blpayspclAggDO);
	//更新患者的账户余额
	BlPaySpclDO  blpsDO=blpayspclAggDO.getParentDO();
	this.prepayConsume(new BlpayspclAggDO[]{blpayspclAggDO});
	return FBoolean.TRUE;
}

   
/**
 * 保存新增的患者域数据，一个bd域服务包对应一条患者域服务包数据，在用
 * @param pkgs
 * @return
 * @throws BizException
 */
private PiPatSrvPkgTotalDTO[] doSaveNewPipatsrvpkgAggDOData(
		PiPatSrvPkgTotalDTO[] pkgs) throws BizException{
	// TODO Auto-generated method stub
	IPiPatsrvpkgMaintainService ppspkgMService=ServiceFinder.find(IPiPatsrvpkgMaintainService.class);
	
	PiPatSrvPkgTotalDTO[] totalDTOArr=ppspkgMService.savePiPatSrvPkg(pkgs);
	return    totalDTOArr;
	
}

//保存新增的bl域数据，并更新所用票据包信息
private FBoolean doSaveNewBlData(BlspclpatAggDO[] blspclpatAggDOArr,
		BlpayspclAggDO blpayspclAggDO) throws BizException{
	// TODO Auto-generated method stub
	IBlpayspclCudService blpayspclCudService=ServiceFinder.find(IBlpayspclCudService.class);
	BlpayspclAggDO[] blPSAggDOArr=blpayspclCudService.save(new BlpayspclAggDO[]{blpayspclAggDO});
	
	IBlspclpatCudService blspclpatCudService=ServiceFinder.find(IBlspclpatCudService.class);
	BlspclpatAggDO[]  blSPAggDOArr=blspclpatCudService.save(blspclpatAggDOArr);
	
	//判断所用的票据所在的票据包，将其所在票据包的可用张数字段减1
	BlPaySpclDO blspclDO= blpayspclAggDO.getParentDO();
	IBlincissRService  blinciss_rser=ServiceFinder.find(IBlincissRService.class);
	IBlincissCudService  blinciss_cudser=ServiceFinder.find(IBlincissCudService.class);
	String qrystr= " a0.id_emp_iss='"+blspclDO.getId_emp_pay()+"' and a0.id_incca='"+IBdPpCodeTypeConst.ID_DESIGNED_FUND+"'  and a0.fg_curuse='Y' and a0.id_grp='"+Context.get().getGroupId()+"' and a0.id_org='"+Context.get().getOrgId()+"'";
	BlIncIssDO[]  blincissDOArr=blinciss_rser.find(qrystr, "", FBoolean.FALSE);
	if(blincissDOArr!=null && blincissDOArr.length>0){
		if(blincissDOArr[0].getInccn_use()>=1){
			blincissDOArr[0].setInccn_use(blincissDOArr[0].getInccn_use()-1)	;
			blincissDOArr[0].setStatus(DOStatus.UPDATED);
			blinciss_cudser.save(blincissDOArr);
		}
	}
	
	return FBoolean.TRUE;
}


/**
 * 如果患者采用预交金支付，则统计预交金支付金额，且修改门诊预交金账户
 * @param blpaypatoepAggDOs
 */
private void prepayConsume(BlpayspclAggDO[] blpaypatoepAggDOs)
		throws BizException
{
    // 如果是预交金结算，则修改预交金账户
	FDouble consumeAmount = new FDouble(0);
	FDouble prepayAmount = new FDouble(0);
	//获得需要预交金支付的金额
	for (int i = 0; i < blpaypatoepAggDOs.length; i++) 
	{
		BlPayItmSpclDO[] blPayItmPatOepDO_arr = blpaypatoepAggDOs[i].getBlPayItmSpclDO();
		for (int j = 0; j < blPayItmPatOepDO_arr.length; j++) {
			if (  IBdPripmCodeConst.ID_PRI_PM_PAY.equals(blPayItmPatOepDO_arr[j].getId_pm())) // 支付方式为预交金时
			{
				consumeAmount = consumeAmount.add(blPayItmPatOepDO_arr[j]
						.getAmt().multiply(
								blPayItmPatOepDO_arr[j].getEu_direct()));
			}
		}
	}
	if (consumeAmount.compareTo(new FDouble(0)) > 0)// 调整门诊预交金账户
	{
		// 调用门诊账户接口
		IPatAccServiceExt patAccImpls = (IPatAccServiceExt) ServiceFinder
				.find(IPatAccServiceExt.class);
		// 计算门诊账户余额：调用门诊账户接口
		prepayAmount = patAccImpls
				.GetOutpPrepaymentAmount(blpaypatoepAggDOs[0].getParentDO()
						.getId_pat());
		// 比较，当预交金余额不足时，不能采用预交金结算
		if (prepayAmount.compareTo(consumeAmount) < 0) 
		{
			throw new BizException("预交金余额不足，不能采用预交金支付。\r\n预交金余额："
					+ prepayAmount.setScale(-2, BigDecimal.ROUND_HALF_UP).toString() + "。\r\n需要预交金支付额："
					+ consumeAmount.setScale(-2, BigDecimal.ROUND_HALF_UP).toString());
		} 
		else 
		{
			// 更新预交金余额 ：调用门诊账户接口
			PiPatAccDO piPatAccDO = patAccImpls.PatiAccPreAuthor(
					blpaypatoepAggDOs[0].getParentDO().getId_pat(),
					consumeAmount);
			if (null == piPatAccDO) {
				throw new BizException("保存患者预交金信息失败");
			}
		}
	}
  }
}
