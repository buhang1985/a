package iih.sc.sch.s.bp.mt.apt.bp.auto;

import java.util.List;
import java.util.Map;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.scbd.dto.d.ScBdSrvDTO;
import iih.sc.scbd.schedulesrv.d.ScSrvKindItm;
import iih.sc.scbd.schedulesrv.i.IScSrvKindItmRService;
import iih.sc.sch.s.bp.mt.apt.ep.ScSrvKindEP;
import iih.sc.sch.s.bp.mt.apt.filter.ScAptKinditmFilter;
import iih.sc.sch.s.ep.mt.apt.Sch4MtAptEP;
import iih.sc.sch.s.ep.mt.apt.TickChl4MtAptEP;
import iih.sc.sch.s.ep.mt.apt.Ticks4MtAptEP;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 按渠道占用排班号位最小号BP
 * @author yzh
 * @author zhengcm
 * @date 2017-07-27 10:34:57
 *
 */
public class OccupyChlTickBySch4AutoLocateAptBP {
	/**
	 * 按渠道占用排班号位最小号，如果没有可用资源抛异常
	 * @author yzh
	 * @author zhengcm
	 * @param schId 排班id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param ticksId 号段id，可为null
	 * @return 号位
	 * @throws BizException 异常
	 */
	public ScSchTickDO exec(String schId,Map<Integer,Integer> polcnMap, String ticksId, String chlId,String idEnttp,MtResDTO resDTO,String idSrv) throws BizException {
		// 校验参数
		boolean check = this.validateParam(schId, polcnMap, chlId);
		if(!check){
			return null;
		}

		TickChl4MtAptEP tickEP = new TickChl4MtAptEP();

		// 获取票号模式
		String tickMd = tickEP.getTickModeBySchId4Auto(schId);
		if(StringUtil.isEmpty(tickMd)){
			return null;	
		}
		// 当前排班加锁
		tickEP.lockSch(schId);

		ScSchTickDO tickDO = null;
		// 1、如果是号段，则需占用号段
		if (IScDictCodeConst.SD_TICKMD_TICKS.equals(tickMd)) {
			Ticks4MtAptEP ticksBP = new Ticks4MtAptEP();
			if (!StringUtil.isEmpty(ticksId)) {
				// 号段互斥检验
				ISctickRService rService = ServiceFinder.find(ISctickRService.class);
				String whereStr = "id_ticks = ?";
				SqlParamDTO param = new SqlParamDTO();
				param.addParam(ticksId);
				ScSchTickDO[] tickDOs = rService.find2(whereStr, param, null, FBoolean.FALSE);
				if(!ArrayUtil.isEmpty(tickDOs)){
					tickDO = tickDOs[0];
				}
				tickDO = this.occupyByTicksId(tickDO.getId_tick(), resDTO);
				if (tickDO == null) {
					return null;
				}
				ScSchTicksDO ticksDO = ticksBP.occupy4AutoLocate(ticksId);
				// 过滤类别明细
				if(!StringUtil.isEmpty(idSrv))
				{
					ticksDO = new ScAptKinditmFilter().filterTicksByScSrvKinditm4Manual(ticksDO, idSrv, ticksDO.getId_sch(),resDTO);
					if(ticksDO == null)
					{
						return null;
					}
				}
			} else {
				ScSchTicksDO ticksDO = ticksBP.occupyBySchId4AutoLocate(schId, chlId,idEnttp,polcnMap,resDTO,idSrv);// 根据排班占用号段
				// 如果排班对应没有可用号位 并且没有通过互斥校验
				if (ticksDO == null || resDTO.getFg_stop_daysmsgs().booleanValue()) {
					return null;
				}
				ticksId = ticksDO.getId_ticks();
			}
		}

		// 2、占用号位
		if (IScDictCodeConst.SD_TICKMD_TICKS.equals(tickMd)) {
			tickDO = tickEP.occupyByTicksId4AutoLocate(ticksId, polcnMap, chlId, idEnttp,resDTO,idSrv,schId);// 号段
		} else {
			tickDO = tickEP.occupyBySchId4AutoLocate(schId, polcnMap, chlId,idEnttp,resDTO,idSrv);// 号位
		}
		if(tickDO != null){
			// 3、占用排班号源
			Sch4MtAptEP schBP = new Sch4MtAptEP();
			boolean success = schBP.occupyTick4AutoLocate(schId, tickDO.getPolno_used());
			if(!success) return null;
		}

		return tickDO;
	}
	/**
	 * 根据号段占用号位
	 * @param tickId
	 * @param resDTO
	 * @return
	 * @throws BizException
	 */
	public ScSchTickDO occupyByTicksId(String tickId, MtResDTO resDTO) throws BizException {
		ScSchTickDO tickDO = (ScSchTickDO) new DAFacade().findByPK(ScSchTickDO.class, tickId);
		if (tickDO == null) {
			return null;
		}
		tickDO = new TickChl4MtAptEP().mutualExclusionCheck(tickDO,resDTO);
		if(tickDO == null)
		{
			return null;
		}
		// 占用号位
		return tickDO;
	}
	/**
	 * 校验参数
	 * 
	 * @author zhengcm
	 * 
	 * @param schId 排班ID
	 * @param polcn 号源池
	 * @param chlId 渠道ID
	 * @throws BizException
	 */
	private boolean validateParam(String schId, Map<Integer,Integer> polcnMap, String chlId) throws BizException {
		// 参数校验
		if(StringUtil.isEmpty(schId)||StringUtil.isEmpty(chlId)) return false;
		for (Integer polcn : polcnMap.keySet()) {
			if ((polcn == null || polcn < 0 || polcn > 10) && polcn != IScDictCodeConst.SC_CHL_REMAIN) {
				return false;
			}
		}
		return true;
	}
	

	/**
	 * 根据排班类别明细过滤号段
	 * 
	 * @author yzh
	 * @param ticks
	 * @param idSrv
	 * @param idSch
	 * @return
	 * @throws BizException
	 */
	private ScSchTicksDO filterTicksByScSrvKinditm(ScSchTicksDO tick, String idSrv, String idSch) throws BizException {
		ScBdSrvDTO[] scbdsrvs = new ScSrvKindEP().getScBdSrv8IdSrv(idSch, idSrv);
		String ids_kinditm = tick.getIds_kinditm();
		if (StringUtil.isEmpty(ids_kinditm)) {
			return tick;
		}
		String cond = ScSqlUtils.getInSqlByIds(ScSrvKindItm.ID_SCSRVKINDITM, ids_kinditm.split(","));
		IScSrvKindItmRService iscsrvkinditmrservice = ServiceFinder.find(IScSrvKindItmRService.class);
		ScSrvKindItm[] scSrvKindItms = iscsrvkinditmrservice.find(cond, null, FBoolean.FALSE);
		// 根据服务上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
		Map<String,List<String>> scSrvKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND, "Id_scsrvkinditem", scbdsrvs);
		// 根据号位号段上的类别明细查询出DO DO上的服务类别需要参与到下面的类别明细的校验
		Map<String,List<String>> scTickKindItmMap = ScAppUtils.extractStrMapFromObjs(ScSrvKindItm.ID_SCSRVKIND, ScSrvKindItm.ID_SCSRVKINDITM, scSrvKindItms);
		
		for (Map.Entry<String,List<String>> entry : scTickKindItmMap.entrySet()) {
			String id_scsrvkind = entry.getKey();
			// 判断服务是否包含号位号段上的类别
			if(scSrvKindItmMap.containsKey(id_scsrvkind)){
				// 取出号位号段上的类别对应的明细集合list
				List<String> id_kinditm_list = scTickKindItmMap.get(id_scsrvkind);
				// 判断号位号段上的类别对应明细是否包含服务上该类别下的明细
				if (!id_kinditm_list.containsAll(scSrvKindItmMap.get(id_scsrvkind))) {
					return null;
				} 
			}else{
				return null;
			}
		}
		return tick;
	}
}
