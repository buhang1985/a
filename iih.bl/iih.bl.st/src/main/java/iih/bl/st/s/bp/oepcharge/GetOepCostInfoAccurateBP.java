package iih.bl.st.s.bp.oepcharge;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeAccurateCondDTO;
import iih.bl.st.dto.bloepcharge.d.BlOepChargeInputDTO;
import iih.bl.st.s.bp.oepcharge.qry.BlOepCostOrdInfoQry;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.ListUtil;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊调入(精准调入)
 * @author ly 2018/12/04
 *
 */
public class GetOepCostInfoAccurateBP extends GetOepCostInfoBP {

	 /**
     * 门诊调入(精准调入)
     * @param 精准调入条件
     * @return
     * @throws BizException
     */
	 @SuppressWarnings("unchecked")
	public BlOepChargeInputDTO[] exec(BlOepChargeAccurateCondDTO condDto)   throws BizException{
		 BlOepChargeInputDTO[] blOepChargeInputDTOArr = new BlOepChargeInputDTO[]{};
		 if(condDto==null)
			 return blOepChargeInputDTOArr;
		 List<String> idOrSrvList = new ArrayList<String>();				 
		 if(!ListUtil.isEmpty(condDto.getId_orsrv())){
			 idOrSrvList=condDto.getId_orsrv();
		 }else if(!ListUtil.isEmpty(condDto.getId_or())){
			 idOrSrvList=this.getUnChargeOrdIds(condDto.getId_or());
		 }
		 
		 if(!ListUtil.isEmpty(idOrSrvList)){
			 //删除挂起数据
			 this.deleteSuspData(idOrSrvList);
			 //获取待缴费信息
			 blOepChargeInputDTOArr =this.getOrUnchargeInfo(null,idOrSrvList);
			 this.addApplyInfo(blOepChargeInputDTOArr);
			 
		 }
		 return blOepChargeInputDTOArr;
	 }

		/**
		 * 获取待缴费服务id
		 * @param patId
		 * @param day
		 * @return
		 * @throws BizException
		 */
		private List<String> getUnChargeOrdIds(FArrayList idOrList) throws BizException {
			
			StringBuilder sqlSb = new StringBuilder();
			sqlSb.append("select orsrv.id_orsrv from ci_or_srv orsrv ");
			sqlSb.append("inner join ci_order ord ");
			sqlSb.append("on orsrv.id_or = ord.id_or ");
			sqlSb.append("where orsrv.sd_su_bl = ? ");
			sqlSb.append("and orsrv.fg_bl = 'Y' ");
			sqlSb.append("and ord.code_entp in (?,?) ");
//			sqlSb.append("and ord.id_pat = ? ");
			sqlSb.append("and ord.fg_sign = 'Y' ");
			sqlSb.append("and ord.fg_canc = 'N' ");
			sqlSb.append(SqlUtils.getInSqlByIds(" and ord.id_or ", idOrList));
			
			SqlParam param = new SqlParam();
			param.addParam(ICiDictCodeConst.SD_SU_BL_NONE);
			param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
			param.addParam(IBdFcDictCodeConst.SD_CODE_ENTP_ET);

			DAFacade daf = new DAFacade();
			@SuppressWarnings("unchecked")
			List<String> rlt = (List<String>)daf.execQuery(sqlSb.toString(), param, new ColumnListHandler());
			
			return rlt;
		}
		
		/**
		 * 删除挂起数据
		 * @param patId
		 * @throws BizException
		 */
		@SuppressWarnings("unchecked")
		private void deleteSuspData(List<String> idOrSrvList) throws BizException{
			
			String sql = "select distinct id_stoep from bl_cg_itm_oep "
					+ "where fg_susp = 'Y' and eu_srctp <> 1 and fg_pricinginsertcg = 'Y' ";
			sql +=SqlUtils.getInSqlByIds(" and id_orsrv ", idOrSrvList);
			DAFacade daf = new DAFacade();
			
			List<Object> rlt = (List<Object>)daf.execQuery(sql, new SqlParam(), new ColumnListHandler());
			if(ListUtil.isEmpty(rlt))
				return;
			
			BlOepCancelPricingBP cancelBp = new BlOepCancelPricingBP();
			for (Object obj : rlt) {
				String stId = (String)obj;
				cancelBp.exec(stId);
			}
		}
		
}
