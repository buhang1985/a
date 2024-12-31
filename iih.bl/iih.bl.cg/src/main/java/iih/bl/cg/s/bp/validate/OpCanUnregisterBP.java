package iih.bl.cg.s.bp.validate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBlDictCodeTypeConst;
import iih.bd.pp.bdpripmpttpdo.d.BdPriPmPtTpDO;
import iih.bd.pp.bdpripmpttpdo.i.IBdpripmpttpdoRService;
import iih.bd.pp.pripm.d.PriPmDO;
import iih.bd.utils.UdidocUtils;
import iih.bl.comm.dto.d.BlCheckResultDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * 校验指定终端是否可以退号
 * @author ly 2019/12/26
 *
 */
public class OpCanUnregisterBP {

	/**
	 * 校验指定终端是否可以退号
	 * @param entId
	 * @param sdPttp
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlCheckResultDTO exec(String entId, String sdPttp) throws BizException{
		
		if(StringUtil.isEmpty(entId)){
			throw new BizException("校验指定终端是否可以退号:入参就诊id为空");
		}
		
		if(StringUtil.isEmpty(sdPttp)){
			throw new BizException("校验指定终端是否可以退号:入参终端类型为空");
		}
		
		BlCheckResultDTO rlt = new BlCheckResultDTO();
		
		// 查询挂号结算收费款支付方式信息
		String sql = this.getSql();
		SqlParam param = new SqlParam();
		param.addParam(entId);
		
		DAFacade daf = new DAFacade();
		List<Object> pmIdList = (List<Object>)daf.execQuery(sql, param, new ColumnListHandler());
		if(ListUtil.isEmpty(pmIdList)){
			rlt.setResult(FBoolean.TRUE);
			return rlt;
		}
		
		IBdpripmpttpdoRService rService = ServiceFinder.find(IBdpripmpttpdoRService.class);
		BdPriPmPtTpDO[] pmPttpDos = rService.findByAttrValStrings(BdPriPmPtTpDO.ID_PM, pmIdList.toArray(new String[0]));
		if(ArrayUtil.isEmpty(pmPttpDos)){
			rlt.setResult(FBoolean.TRUE);
			//rlt.SetMsg("所有支付方式都未配置付款方式可退费终端");
			return rlt;
		}
		
		Map<String,List<BdPriPmPtTpDO>> pmPttpMap = new HashMap<String,List<BdPriPmPtTpDO>>();
		Map<String,String> pmMap = this.getPmMap(pmIdList.toArray(new String[0]));
		
		for (BdPriPmPtTpDO pmPttpDO : pmPttpDos) {
			
			List<BdPriPmPtTpDO> pmPttpList = null;
			if(pmPttpMap.containsKey(pmPttpDO.getId_pm())){
				pmPttpList = pmPttpMap.get(pmPttpDO.getId_pm());
			}else{
				pmPttpList = new ArrayList<BdPriPmPtTpDO>();
				pmPttpMap.put(pmPttpDO.getId_pm(), pmPttpList);
			}
			pmPttpList.add(pmPttpDO);
		}
		
		for (Object pmId : pmIdList) {
			String key = pmId.toString();
			
			if(pmPttpMap.containsKey(key)){
				
				List<BdPriPmPtTpDO> pmPttpList = pmPttpMap.get(key);
				boolean has = false;
				for (BdPriPmPtTpDO pmPttpDO : pmPttpList) {
					
					if(sdPttp.equals(pmPttpDO.getSd_pttp()) && FBoolean.TRUE.equals(pmPttpDO.getFg_refund())){
						has = true;
						break;
					}
				}
				
				if(!has){
					rlt.setResult(FBoolean.FALSE);
					String pttpName = this.getPttpName(sdPttp);
					rlt.SetMsg(String.format("支付方式%s不支持在%s终端退费", pmMap.get(key), sdPttp + pttpName));
				}
			}else{
				rlt.setResult(FBoolean.TRUE);
				//rlt.SetMsg(String.format("支付方式%s未配置付款方式可退费终端", pmMap.get(key)));
			}
		}
		
		rlt.setResult(FBoolean.TRUE);
		return rlt;
	}
	
	/**
	 * 查询sql
	 * @return
	 */
	private String getSql(){
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ");
		sqlSb.append("payitm.id_pm ");
		sqlSb.append("from bl_st_oep st ");
		sqlSb.append("inner join bl_pay_itm_pat_oep payitm ");
		sqlSb.append("on st.id_paypatoep = payitm.id_paypatoep ");
		sqlSb.append("where st.id_ent = ? ");
		sqlSb.append("and st.eu_direct = 1 ");
		sqlSb.append("and st.eu_sttp = '31' ");
		sqlSb.append("and payitm.eu_direct = 1");
		
		return sqlSb.toString();
	}

	/**
	 * 获取支付方式map
	 * @param pmIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String,String> getPmMap(String[] pmIds) throws BizException{
	
		DAFacade daf = new DAFacade();
		
		List<PriPmDO> pmList = (List<PriPmDO>)daf.findByPKs(PriPmDO.class, pmIds, 
				new String[] { PriPmDO.ID_PM, PriPmDO.NAME });
		
		Map<String, String> pmMap = new HashMap<String, String>();
		
		for (PriPmDO priPmDO : pmList) {
			pmMap.put(priPmDO.getId_pm(), priPmDO.getName());
		}
		
		return pmMap;
	}

	/**
	 * 获取支付终端名称
	 * @param sdPttp
	 * @return
	 * @throws BizException
	 */
	private String getPttpName(String sdPttp){
		String name = "";
		UdidocDO udiDocDO = null;
		try {
			udiDocDO = UdidocUtils.getUdidocByCode(IBlDictCodeTypeConst.SD_PTTP, sdPttp);
		} catch (BizException e) {
			e.printStackTrace();
		}
		
		if(udiDocDO != null){
			name = udiDocDO.getName();
		}
		
		return name;
	}
}
	