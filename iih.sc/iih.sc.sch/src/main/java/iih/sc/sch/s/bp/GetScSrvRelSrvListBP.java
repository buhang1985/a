package iih.sc.sch.s.bp;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.primd.i.IPriCalService;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.sch.reg.dto.d.EuLoadPriceMod;
import iih.sc.sch.reg.dto.d.RelSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取排班服务关联服务集合
 * @author yank
 *
 */
public class GetScSrvRelSrvListBP {
	/**
	 * 获取排班服务关联服务集合
	 * @param scsrvIds 排班服务id集合
	 * @param loadPriceMod 加载价格模式，EuLoadPrice
	 * @param patPriTpId 患者价格分类id	 
	 * @return
	 * @throws BizException
	 */
	public Map<String,List<RelSrvDTO>> exec(String[] scsrvIds,String loadPriceMod,String patPriTpId) throws BizException{
		ScValidator.validateParam("排班服务ID", scsrvIds);
		StringBuilder builder =new StringBuilder();
		builder.append("SELECT REL.ID_SCSRV,REL.ID_MDSRV ID_SRV,SRV.NAME NAME_SRV,REL.FG_MAJ,SRV.ID_SRVTP,SRV.SD_SRVTP ");
		builder.append(" FROM SC_SRV_REL REL ");
		builder.append(" INNER JOIN BD_SRV SRV ON REL.ID_MDSRV = SRV.ID_SRV AND SRV.DS = '0' ");
		builder.append(" WHERE ID_SCSRV IN (");
		builder.append(ScSqlUtils.arrayToStr(scsrvIds));
		builder.append(")");		
		List<RelSrvDTO> relSrvList =(List<RelSrvDTO>) new DAFacade().execQuery(builder.toString(), 
				null,new BeanListHandler(RelSrvDTO.class));	
		if (ListUtil.isEmpty(relSrvList)) return null;
		
		// 加载价格
		if(!StringUtil.isEmpty(loadPriceMod) && !EuLoadPriceMod.UNLOAD.equals(loadPriceMod)){
			this.loadPrice(relSrvList, loadPriceMod, patPriTpId);
		}
		
		Map<String, List<RelSrvDTO>> scSrvMap = new LinkedHashMap<String, List<RelSrvDTO>>();
		int size = relSrvList == null ? 0 : relSrvList.size();
		for (int i = 0; i < size; i++) {
			List<RelSrvDTO> srvList = scSrvMap.get(relSrvList.get(i).getId_scsrv());
			if (srvList == null) srvList = new ArrayList<RelSrvDTO>();
			srvList.add(relSrvList.get(i));
			scSrvMap.put(relSrvList.get(i).getId_scsrv(), srvList);
		}

		return scSrvMap;
	}
	/**
	 * 加载价格
	 * @param relSrvList 关联服务集合
	 * @param loadPriceMod 加载价格模式
	 * @param patPriTpId 患者价格分类ID
	 * @throws BizException
	 */
	private void loadPrice(List<RelSrvDTO> relSrvList, String loadPriceMod, String patPriTpId) throws BizException {
		if (StringUtil.isEmpty(loadPriceMod) || EuLoadPriceMod.UNLOAD.equals(loadPriceMod))
			return;
		FDouble amt_st = new FDouble(0);// 标准价格
		FDouble amt = new FDouble(0);// 支付金额
		int size = relSrvList == null ? 0 : relSrvList.size();
		IPriCalService priCalService = ServiceFinder.find(IPriCalService.class);
		RelSrvDTO relSrvDTO;
		for (int i = 0; i < size; i++) {
			relSrvDTO = relSrvList.get(i);
			if (EuLoadPriceMod.STDPRICE.equals(loadPriceMod)) {
				amt_st = priCalService.CalSingleSrvStdPrice_NameTip(relSrvDTO.getId_srv(),relSrvDTO.getName_srv());
				amt = amt_st;// 默认等于标准价格
			} else if (EuLoadPriceMod.PATPRICE.equals(loadPriceMod)) {
				SrvPricalRateAndPriceDTO priceDTO = priCalService.CalSingleSrvPriceByIdPripat_NameTip(
						relSrvDTO.getId_srv(),relSrvDTO.getName_srv(), patPriTpId);
				amt_st = priceDTO.getPrice();
				amt = priceDTO.getPrice_ratio();
			}
			relSrvDTO.setAmt_st(amt_st);
			relSrvDTO.setAmt(amt);
			relSrvDTO.setAmt_hp(FDouble.ZERO_DBL);
			relSrvDTO.setAmt_pat(amt);
		}
	}
}
