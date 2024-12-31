package iih.bl.cg.bp.ip;

import iih.bl.cg.blcgquery.d.BlCgIpDO;
import iih.bl.cg.blcgquery.i.IBlcgqueryRService;
import iih.bl.cg.bp.ip.qry.GetIpCgSumInfoByEntIdQry;
import iih.bl.cg.dto.d.BlIpOrdCgDTO;
import iih.ci.ord.dto.d.OrderByPriceDTO;
import iih.ci.ord.i.ICiOrdQryService;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 查询住院记账按服务的分组汇总信息
 * 
 * @author liwenqiang
 *
 */
public class GetIpCgSumInfoByOrdBP {
	/**
	 * 查询住院记账按服务的分组汇总信息
	 * 
	 * @param entId
	 *            就诊id
	 * @param qryNode
	 *            查询模板
	 * @return 住院记账汇总信息集合
	 * @throws BizException
	 * @author liwenqiang
	 */
	public BlIpOrdCgDTO[] exec(String entId, FBoolean isCiOrder,QryRootNodeDTO qryNode)
			throws BizException {
		
		if (StringUtil.isEmpty(entId)) {
			return null;
		}
		// 需要查询的ID_ent集合
		List<String> entIdList = new ArrayList<String>();
		entIdList.add(entId); 
		
		IBlcgqueryRService cgIpService = ServiceFinder.find(IBlcgqueryRService.class);
		//此处排除母婴合并结算，母婴医嘱不合并
//		// 判断是否母婴同时结算
//		if (BlParamUtils.isMomBBMergeSettlement()) {
//			// 查询BB的idEnt
//			BlcgqueryAggDO[] aggDos = cgIpService.find(" id_ent_mom='" + entId	+ "'", null, FBoolean.FALSE);
//			if (aggDos != null && aggDos.length != 0) {
//				for (BlcgqueryAggDO agg : aggDos) {
//					entIdList.add(agg.getParentDO().getId_ent());
//				}
//			}
//		}

		List<BlIpOrdCgDTO> ipOrdCgList = new ArrayList<BlIpOrdCgDTO>();
		if(isCiOrder.booleanValue()) {
		// 1.调用CI接口获取医嘱信息
		ICiOrdQryService ciOrdQryService = ServiceFinder.find(ICiOrdQryService.class);
		OrderByPriceDTO[] orderByPrices = ciOrdQryService.getCiOrderDOByCondition(entIdList.toArray(new String[0]),	qryNode);
	
		//如果CI返回数据不为空则补充记账金额
		if (orderByPrices != null && orderByPrices.length != 0) {
			// 2把医嘱信息赋给BlIpOrdCgDTO
			for (OrderByPriceDTO orderByPriceDTO : orderByPrices) {
				BlIpOrdCgDTO ipOrdCg = new BlIpOrdCgDTO();
				// 组装数据
				ipOrdCg.setId_or(orderByPriceDTO.getId_or());
				ipOrdCg.setName_su_or(orderByPriceDTO.getOrd_colligate());
				ipOrdCg.setName_su_bl(orderByPriceDTO.getSd_su_bl_name());
				// 长临
				ipOrdCg.setFg_long(orderByPriceDTO.getFg_long());
				ipOrdCg.setContent_or(orderByPriceDTO.getContent_or().split("\\|")[2].split("&")[0]);
				//医嘱开立时间
				ipOrdCg.setDt_entry(orderByPriceDTO.getDt_entry());
				//医嘱开始时间
				ipOrdCg.setDt_effc(orderByPriceDTO.getDt_effe());
				TimeService timeService = new TimeServiceImpl();
				FDateTime dt_service = timeService.getUFDateTime(); //即获取当前时间
				if(orderByPriceDTO.getDt_end().getYear() == dt_service.getYear())
					ipOrdCg.setDt_end(orderByPriceDTO.getDt_end()); //医嘱结束时间
				ipOrdCg.setName_freq(orderByPriceDTO.getFreq_name());
				ipOrdCg.setName_route(orderByPriceDTO.getRoute_name());
				ipOrdCg.setId_emp_or(orderByPriceDTO.getId_emp_or());
				ipOrdCg.setName_emp_or(orderByPriceDTO.getEmp_name());
				ipOrdCg.setId_dep_or(orderByPriceDTO.getId_dep_or());
				ipOrdCg.setName_dep_or(orderByPriceDTO.getName_dep_or());
				ipOrdCgList.add(ipOrdCg);
			}

			// 3.根据entID获取所有记账信息
			BlCgIpDO[] blCgIpDOs = cgIpService.find(" id_ent='" + entId + "' and fg_real = 'Y' ",
					null, FBoolean.FALSE);
			// 4.匹配医嘱和记账信息,并赋给ipOrdCgList
			for (BlIpOrdCgDTO cgDo : ipOrdCgList) {
				FDouble amtSum = new FDouble(0);
				for (BlCgIpDO cgIpDo : blCgIpDOs) {
					if (cgDo.getId_or().equals(cgIpDo.getId_or())) {
						amtSum = amtSum.add(cgIpDo.getAmt_ratio().multiply(cgIpDo.getEu_direct()));
					}
				}
				cgDo.setAmt_ratio(amtSum);
			}
		}
		}
		if(!isCiOrder.booleanValue()) {
		//5.添加本次就诊的所有无医嘱数据
		BlIpOrdCgDTO[] blIpOrdCgDTOs = (BlIpOrdCgDTO[]) AppFwUtil.getDORstWithDao(
				new GetIpCgSumInfoByEntIdQry(entId), BlIpOrdCgDTO.class);
		if(blIpOrdCgDTOs!=null && blIpOrdCgDTOs.length>0){
//			blIpOrdCgDTOs[0].setId_or("~");
			for(BlIpOrdCgDTO dto : blIpOrdCgDTOs) {
				dto.setId_or("~");
				ipOrdCgList.add(dto);
			}
		}
		}
		return ipOrdCgList.toArray(new BlIpOrdCgDTO[0]);
	}
}
