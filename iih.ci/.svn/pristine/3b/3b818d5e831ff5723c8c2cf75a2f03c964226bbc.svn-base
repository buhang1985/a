package iih.ci.ord.s.bp;

import iih.bl.cg.blorderappendbillparamdto.d.BlOrderAppendBillParamDTO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.splitpres.OrdPresSplitSaveBP;
import iih.en.pv.dto.d.Ent4BannerDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
/**
 * 高端商保的退费
 * @author li_zheng
 *
 */
public class setOrderRefundBillCancelReserveBP {

  /***
   * 
   * @param idOrs
   * @param id_psndoc
   * @param ciEnContextDTO
   * @return
   * @throws BizException
   */
	public String setOrderRefundBillCancelReserve(String[] idOrs,String id_psndoc,CiEnContextDTO ctx)throws BizException{
		   
		OrdSrvDO[] ordSrvDOs = getorderSrv(idOrs);
		   if(ordSrvDOs != null && ordSrvDOs.length >0){
			List<String>  list  = new ArrayList();
		
			BlOrderAppendBillParamDTO[]  refundBillParamDTO = new BlOrderAppendBillParamDTO[ordSrvDOs.length];
			String code_entp=ctx.getCode_entp();
			int i =0;
			
			for(OrdSrvDO srvDO:ordSrvDOs){
				//医嘱取消记账且取消物品预留，必填：id_pat,id_org,id_or,id_orsrv,id_emp_cg
				BlOrderAppendBillParamDTO dto = new BlOrderAppendBillParamDTO();
				dto.setId_pat(ctx.getId_pat());
				dto.setId_org(ctx.getId_org());
				dto.setId_or(srvDO.getId_or());
				dto.setId_orsrv(srvDO.getId_orsrv());
				dto.setId_emp_cg(id_psndoc);
				refundBillParamDTO[i]=dto;
				list.add(srvDO.getId_pres());
				i++;
			}   
			 String str= CiOrdAppUtils.getIBLOrderAppendBillService().SetOrderRefundBill_ByIdor_cancelReserve(refundBillParamDTO, code_entp);
			 OrdPresSplitSaveBP saveBP = new OrdPresSplitSaveBP();
			 saveBP.DeletePresDO(list);
			 return str;
		   }
		return "没有退费的项目";
	}
	/**
	 * 查询已经缴费的医嘱项目
	 * @param idOrs
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDO[] getorderSrv(String[] idOrs)throws BizException{
		String  whereStr  = " id_or  in ("+CiOrdUtils.getSqlInStrsWithOutIn(idOrs)+")"
		 + " and  fg_bl ='Y' and  sd_su_bl ='1' and  sd_su_mp ='0'  and  ds=0";
		return CiOrdAppUtils.getOrSrvQryService().find(whereStr, "id_or", FBoolean.FALSE);
	}
}
