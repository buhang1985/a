package iih.bl.comm.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.base.utils.MapUtils;
import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.dto.prisrvcompratio.d.BdPriSrvCompRatioDTO;
import iih.bd.pp.dto.priview.d.BdPriViewDTO;
import iih.bd.pp.i.IBdPpQryService;
import iih.bd.pp.i.IBdPriCalService;
import iih.bd.srv.medsrv.d.MedSrvBlModeEnum;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bl.cg.dto.calpri.d.BlCalSrvPriDTO;
import iih.bl.cg.dto.calpri.d.BlCalSrvPriRltDTO;
import iih.bl.comm.IBlConst;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 计算医疗服务价格
 * @author ly 2018/12/04
 *
 */
public class BLCalSrvPriceBP {

	/**
	 * 计算医疗服务价格（药品暂不处理）
	 * @param dtos 待计算服务
	 * @return 计价结果
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BlCalSrvPriRltDTO[] exec(BlCalSrvPriDTO[] dtos) throws BizException{
		
		this.validate(dtos);
		
		Set<String> srvSet = new HashSet<String>();
		for (BlCalSrvPriDTO dto : dtos) {
			srvSet.add(dto.getId_srv());
		}
		
		//查询服务信息
		DAFacade daf = new DAFacade();
		String[] srvFields = new String[]{MedSrvDO.ID_SRV,MedSrvDO.EU_BLMD};
		List<MedSrvDO> srvDOList = (List<MedSrvDO>)daf.findByPKs(MedSrvDO.class, srvSet.toArray(new String[0]), srvFields);
		Map<String, MedSrvDO> srvMap = (Map<String, MedSrvDO>)MapUtils.convertListToMap(srvDOList, MedSrvDO.ID_SRV);
		
		List<String> orsrvList = new ArrayList<String>();//手工划价集合
		srvSet = new HashSet<String>();
		Set<String> priTpSet = new HashSet<String>();
		for (BlCalSrvPriDTO dto : dtos) {
			
			MedSrvDO srvDO = srvMap.get(dto.getId_srv());
			if(MedSrvBlModeEnum.MANUALBL.equals(srvDO.getEu_blmd())){
				if(!StringUtil.isEmpty(dto.getId_orsrv())){
					orsrvList.add(dto.getId_orsrv());
				}
			}else{
				srvSet.add(dto.getId_srv());
			}
			priTpSet.add(dto.getId_patpritp());
		}
		
		//获取服务价格
		Map<String,BdPriViewDTO> srvPriMap = this.getSrvPrice(
				srvSet.toArray(new String[0]), priTpSet.toArray(new String[0]));
		
		//获取手工计价
		Map<String, FDouble> orsrvPriMap = this.getOrsrvPrice(orsrvList.toArray(new String[0]));
		
		//组装返回值
		List<BlCalSrvPriRltDTO> priRltList = new ArrayList<BlCalSrvPriRltDTO>();
		for (BlCalSrvPriDTO dto : dtos) {

			BlCalSrvPriRltDTO priRltDto = new BlCalSrvPriRltDTO();
			priRltDto.setId_orsrv(dto.getId_orsrv());
			priRltDto.setId_srv(dto.getId_srv());
			priRltDto.setId_patpritp(dto.getId_patpritp());

			MedSrvDO srvDO = srvMap.get(dto.getId_srv());
			if (MedSrvBlModeEnum.MANUALBL.equals(srvDO.getEu_blmd())) {

				if (!StringUtil.isEmpty(dto.getId_orsrv())) {
					FDouble manualPri = orsrvPriMap.get(dto.getId_orsrv());
					if (manualPri != null) {
						priRltDto.setPrice_std(manualPri);
						priRltDto.setPrice_ratio(manualPri);
						priRltDto.setRate(FDouble.ONE_DBL);
					}
				}
			} else {
				String key = dto.getId_srv() + dto.getId_patpritp();
				BdPriViewDTO priViewDto = srvPriMap.get(key);
				if (priViewDto != null) {
					priRltDto.setPrice_std(priViewDto.getPrice_std());
					priRltDto.setPrice_ratio(priViewDto.getPrice_ratio());
					priRltDto.setRate(priViewDto.getRate());
				}
			}

			priRltList.add(priRltDto);
		}
		
		//处理组合计价折扣
		this.dealCompRate(priRltList);
		
		return priRltList.toArray(new BlCalSrvPriRltDTO[0]);
	}
	
	/**
	 * 入参校验
	 * @param dtos
	 * @throws BizException
	 */
	private void validate(BlCalSrvPriDTO[] dtos) throws BizException{
		
		if(ArrayUtil.isEmpty(dtos)){
			throw new BizException("服务计价：入参为空");
		}
		
		for (BlCalSrvPriDTO dto : dtos) {
			
			if(StringUtil.isEmpty(dto.getId_srv())){
				throw new BizException("服务计价：医疗服务不能为空");
			}
			
			if(StringUtil.isEmpty(dto.getId_patpritp())){
				throw new BizException("服务计价：患者价格分类不能为空");

			}
		}
	}


	/**
	 * 查询服务价格
	 * @param srvIds
	 * @param priTpIds
	 * @return
	 * @throws BizException
	 */
	private Map<String,BdPriViewDTO> getSrvPrice(String[] srvIds,String[] priTpIds) throws BizException{
		
		Map<String,BdPriViewDTO> rltMap = new HashMap<String, BdPriViewDTO>();
		if (ArrayUtil.isEmpty(srvIds)){
			return rltMap;
		}
		
		IBdPriCalService priCalService = ServiceFinder.find(IBdPriCalService.class);
		BdPriViewDTO[] priViewDtos = priCalService.calSrvPrice(srvIds, priTpIds);
		if(ArrayUtil.isEmpty(priViewDtos)){
			return rltMap;
		}
		
		rltMap = (Map<String,BdPriViewDTO>)MapUtils.convertArrayToMap(priViewDtos, "Id_srv,Id_pripat");
		return rltMap;
	}
	
	/**
	 * 查询手工计价价格
	 * @param orsrvIds
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private Map<String,FDouble> getOrsrvPrice(String[] orsrvIds) throws BizException{
		
		Map<String,FDouble> rltMap = new HashMap<String, FDouble>();
		if (ArrayUtil.isEmpty(orsrvIds)){
			return rltMap;
		}
		
		DAFacade daf = new DAFacade();
		List<OrdSrvDO> orsrvList = (List<OrdSrvDO>) daf.findByPKs(
				OrdSrvDO.class, orsrvIds, new String[] { OrdSrvDO.ID_ORSRV, OrdSrvDO.PRI });
		if(ListUtil.isEmpty(orsrvList)){
			return rltMap;
		}
		
		for (OrdSrvDO ordSrvDO : orsrvList) {
			rltMap.put(ordSrvDO.getId_orsrv(), ordSrvDO.getPri());
		}
		
		return rltMap;
	}

	/**
	 * 处理组合计价折扣
	 * @param priRltList
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private void dealCompRate(List<BlCalSrvPriRltDTO> priRltList) throws BizException{
		
		Set<String> orsrvIdSet = new HashSet<String>();
		for (BlCalSrvPriRltDTO srvPriRlt : priRltList) {
			if(!StringUtil.isEmpty(srvPriRlt.getId_orsrv())){
				orsrvIdSet.add(srvPriRlt.getId_orsrv());
			}
		}
		
		if(orsrvIdSet.size() == 0)
			return;
		
		String sql = "select ci_order.id_srv,ci_or_srv.id_orsrv "
				+ "from ci_order inner join ci_or_srv on ci_order.id_or = ci_or_srv.id_or "
				+ "where " + SqlUtils.getInSqlByIds("ci_or_srv.id_orsrv", orsrvIdSet.toArray(new String[0]));
		
		DAFacade daf = new DAFacade();
		List<Map<String, Object>> rlts = (List<Map<String, Object>>)daf.execQuery(sql, new MapListHandler());
		if(ListUtil.isEmpty(rlts))
			return;
		
		Set<String> ordSrvIds = new HashSet<String>();
		Map<String, String> srvOrMap = new HashMap<String, String>();
		for (Map<String, Object> rlt : rlts) {
			
			String srvId = (String)rlt.get("id_srv");
			String orsrvId = (String)rlt.get("id_orsrv");
			
			ordSrvIds.add(srvId);
			srvOrMap.put(orsrvId, srvId);
		}
		
		IBdPpQryService ppService = ServiceFinder.find(IBdPpQryService.class);
		BdPriSrvCompRatioDTO[] compDtos = ppService.getSpecialSrvCompRatio(ordSrvIds.toArray(new String[0]));
		
		if(!ArrayUtil.isEmpty(compDtos)){
			for (BdPriSrvCompRatioDTO compDto : compDtos) {
				for (BlCalSrvPriRltDTO srvPriRlt : priRltList) {
					
					if(StringUtil.isEmpty(srvPriRlt.getId_orsrv()))
						continue;
					
					String ordSrvId = srvOrMap.get(srvPriRlt.getId_orsrv());
					if(compDto.getId_srv().equals(ordSrvId) && compDto.getId_srv_bl().equals(srvPriRlt.getId_srv())){
					
						srvPriRlt.setPrice_ratio(srvPriRlt.getPrice_ratio().multiply(compDto.getRatio(), IBlConst.PRECISION_PRICE));
						srvPriRlt.setRate(srvPriRlt.getRate().multiply(compDto.getRatio(), IBlConst.PRECISION_PRICE));
						break;
					}
				}
			}
		}
	}
}
