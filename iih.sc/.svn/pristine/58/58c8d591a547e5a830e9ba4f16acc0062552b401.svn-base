package iih.sc.sch.s.bp.mt.apt.bp.auto;

import java.util.ArrayList;
import java.util.HashMap;
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
import iih.sc.sch.s.ep.mt.apt.auto.TickChl4AutoMtAptEP;
import iih.sc.sch.s.ep.mt.apt.auto.Ticks4AutoMtAptEP;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 按渠道占用号位BP
 * 
 * @author zhengcm
 * @date 2017-07-27 10:35:32
 *
 */
public class OccupyChlTick4AutoBP {
	/**
	 * 按渠道占用号位
	 * 
	 * @author zhengcm
	 *
	 * @param tickId 号位ID
	 * @param polcn 号源池
	 * @param chlId 渠道ID
	 * @param exclDateList 排斥日期集合
	 * @return 号位DO
	 * @throws BizException
	 */
	public ScSchTickDO exec(String tickId, Map<Integer,Integer> polcnMap, String chlId, MtResDTO resDTO,String id_srv) throws BizException {
		ScValidator.validateParam("tickId", tickId);
		ScValidator.validateParam("chlId", chlId);
		int polcn = getMinCanUsePolcn(polcnMap);
		

		// 1、占用号位
		ScSchTickDO tickDO = new TickChl4AutoMtAptEP().occupyByTickId(tickId, polcn, chlId, resDTO);
		if (tickDO == null) {
			return null;
		}
		// 当前排班加锁 add by zhengcm 2018-03-14
		new TickChl4AutoMtAptEP().lockSch(tickDO.getId_sch());

		// 2、如果是号段，则需占用号段
		ScSchTicksDO tickSectDO = new ScSchTicksDO();
		if (!StringUtil.isEmpty(tickDO.getId_ticks())) {
			Ticks4AutoMtAptEP ticksBP = new Ticks4AutoMtAptEP();
			tickSectDO = ticksBP.occupy(tickDO.getId_ticks());
		}
		else
		{
			//过滤类别明细
			if(!StringUtil.isEmpty(id_srv))
			{
				tickDO = new ScAptKinditmFilter().filterTickByScSrvKinditm4Manual(tickDO, id_srv, tickDO.getId_sch(),resDTO);
				if(tickDO == null)
				{
					 throw new BizException(IScMsgConst.ERROR_SC_SCH_TICK_KINDITM);
				}
			}
		}

		// 3、占用排班号源
		Sch4MtAptEP schBP = new Sch4MtAptEP();
		schBP.occupyTick(tickDO.getId_sch(), polcn);

		return tickDO;
	}
	/**
	 * 获取可用的最小号源池号
	 * @author yzh
	 * @param polcnMap
	 * @return
	 * @throws BizException
	 */
	private int getMinCanUsePolcn(Map<Integer,Integer> polcnMap) throws BizException{
		int polcn = IScDictCodeConst.SC_CHL_REMAIN;
		for (Integer polcnNum : polcnMap.keySet()) {
			if ((polcnNum == null || polcnNum < 0 || polcnNum > 10) && polcnNum != IScDictCodeConst.SC_CHL_REMAIN) {
				throw new BizException(IScMsgConst.ERROR_SC_SCH_POLCN_OUT_OF_RANGE);
			}
			if (polcnNum < polcn && polcnMap.get(polcnNum) > 0) {
				polcn = polcnNum;
			}
		}
		return polcn;
	}
	
	/**
	 * 根据排班类别明细过滤号位
	 * 
	 * @author yzh
	 * @param ticks
	 * @param idSrv
	 * @param idSch
	 * @return
	 * @throws BizException
	 */
	private ScSchTickDO filterTickByScSrvKinditm(ScSchTickDO tick, String idSrv, String idSch) throws BizException {
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
