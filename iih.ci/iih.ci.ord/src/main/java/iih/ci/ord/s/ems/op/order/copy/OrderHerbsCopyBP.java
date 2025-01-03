package iih.ci.ord.s.ems.op.order.copy;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.SortEnum;
import iih.ci.ord.s.bp.ems.CiOrHerbBoilDesRelationFeeBP;
import iih.ci.ord.s.ems.utils.meta.HerbOrContentParam;
import iih.ci.ord.s.ems.utils.meta.OrContentDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * 草药复制
 * 
 * @author Young
 *
 */
public class OrderHerbsCopyBP extends OrderBaseCopyBP {
	protected void setCiorderAggDOs(CiorderAggDO[] aggDOs, Map<String, String> mapIdors,
			Map<String, String> mapIdorsrvs, FDateTime dt, FMap2 extension,FDateTime dt_effe) throws BizException {
		super.setCiorderAggDOs(aggDOs, mapIdors, mapIdorsrvs, dt, extension,dt_effe);
		for (CiorderAggDO aggDO : aggDOs) {
			CiOrderDO ciOrderDO = aggDO.getParentDO();
			ciOrderDO.setDt_end(ciOrderDO.getDt_effe());
			ciOrderDO.setQuan_firday_mp(1);
			if (FBoolean.TRUE.equals(ciOrderDO.getFg_stop())) {
				ciOrderDO.setId_emp_stop(Context.get().getStuffId());
				ciOrderDO.setId_dep_stop(Context.get().getDeptId());
			}
		}
	}

	@Override
	protected void content_or(CiorderAggDO[] aggDOs, Map<String, OrdSrvMmDO> mapTeamSrvDOs) throws BizException {
		for (CiorderAggDO aggDO : aggDOs) {

			HerbOrContentParam drugOrContentParam = new HerbOrContentParam(aggDO.getParentDO().getOrders(),aggDO.getParentDO().getSd_srvtp(),
					aggDO.getParentDO().getFreq_name(), aggDO.getParentDO().getDays_or(),
					aggDO.getParentDO().getRoute_name(), aggDO.getParentDO().getBoil_name(),
					aggDO.getParentDO().getRoutedes_name(), aggDO.getParentDO().getDes_or(),
					getOrContentDTOs(aggDO.getOrdSrvDO(), mapTeamSrvDOs));
			CiOrContentDO contentdo=new CiOrContentDO();
			Object[] params = new Object[]{contentdo,drugOrContentParam};
			BDCommonEvent event = new BDCommonEvent(SourceIdConst.COPY_CONTENTOR_HERB_SOURCEID, IEventType.TYPE_UPDATE_AFTER, params);
			EventDispatcher.fireEvent(event);
			aggDO.getParentDO().setContent_or(contentdo==null?null:contentdo.toString());//CiOrContentUtils.herbCreate(drugOrContentParam)

		}
	}
	/**
	 * 获取拼接医嘱内容的参数
	 */
	protected List<OrContentDTO> getOrContentDTOs(OrdSrvDO[] ordSrvs, Map<String, OrdSrvMmDO> mapTeamSrvDOs) {
		List<OrContentDTO> list = new ArrayList<OrContentDTO>();
		ordSrvs = CiOrdUtils.Sort(ordSrvs, OrdSrvDO.SORTNO, SortEnum.ASC);
		for (OrdSrvDO ordSrvDO : ordSrvs) {
			if (mapTeamSrvDOs.containsKey(ordSrvDO.getId_orsrv())) {
				OrContentDTO orContentDTO = new OrContentDTO(ordSrvDO,mapTeamSrvDOs.get(ordSrvDO.getId_orsrv()));
				orContentDTO.setSpec(mapTeamSrvDOs.get(ordSrvDO.getId_orsrv()).getSpec());
				list.add(orContentDTO);
			}else{
				OrContentDTO orContentDTO = new OrContentDTO(ordSrvDO);
				list.add(orContentDTO);
			}
		}
		return list;
	}

	/**
	 * 获得煎法要求关联费用数据
	 * @return
	 * @throws BizException
	 */
	@Override
	protected void aggCiOrderHerbHandle(CiorderAggDO aggorder, CiEmsDTO ems, ArrayList<OrdSrvDO> bdsrvList,Hashtable ht) throws BizException {
		CiOrHerbBoilDesRelationFeeBP bpBoil=new CiOrHerbBoilDesRelationFeeBP();
		ArrayList<OrdSrvDO> ordsrvList = bpBoil.exec(aggorder,ems,bdsrvList,ht);
		OrdSrvDO[] ordSrvDOs = merge(aggorder.getOrdSrvDO(),ordsrvList);
		aggorder.setOrdSrvDO(ordSrvDOs);
	}
}
