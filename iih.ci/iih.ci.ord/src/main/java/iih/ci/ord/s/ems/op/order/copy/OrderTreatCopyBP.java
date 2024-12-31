package iih.ci.ord.s.ems.op.order.copy;

import java.util.Map;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.listener.sourceid.SourceIdConst;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.s.ems.ip.order.copy.CiSkinTestRstCopyBP;
import iih.ci.ord.s.ems.utils.meta.TreatOrContentParam;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;

/**
 * 复制诊疗
 * @author Young
 *
 */
public class OrderTreatCopyBP extends OrderBaseCopyBP {
	@Override
	protected CiSkinTestRstDO[] copySkinTestRst(Map<String, String> mapIdors, FDateTime dt) throws BizException {
		CiSkinTestRstCopyBP bp = new CiSkinTestRstCopyBP();
		return bp.exec(mapIdors, dt);
	}

	@Override
	protected void content_or(CiorderAggDO[] aggDOs, Map<String, OrdSrvMmDO> mapTeamSrvDOs) throws BizException {
		for (CiorderAggDO aggDO : aggDOs) {
			String id_or_old = mapNewOldKeys.get(aggDO.getParentDO().getId_or());
//			TreatOrContentParam treatOrContentParam = new TreatOrContentParam(aggDO.getParentDO().getSd_srvtp(), aggDO.getParentDO().getName_or(),aggDO.getParentDO().getDes_or(),aggDO.getParentDO().getFreq_name(),
//					aggDO.getParentDO().getRoute_name(), aggDO.getParentDO().getFg_urgent(),id_or_old,aggDO.getParentDO().getQuan_medu(),aggDO.getParentDO().getId_unit_med(),aggDO.getParentDO().getId_srv());
			TreatOrContentParam treatOrContentParam = new TreatOrContentParam(id_or_old,aggDO.getParentDO());
			CiOrContentDO contentdo=new CiOrContentDO();
			Object[] params = new Object[]{contentdo,treatOrContentParam};
			BDCommonEvent event = new BDCommonEvent(SourceIdConst.COPY_CONTENTOR_TREAT_SOURCEID, IEventType.TYPE_UPDATE_AFTER, params);
			EventDispatcher.fireEvent(event);
			aggDO.getParentDO().setContent_or(contentdo==null?null:contentdo.toString());//CiOrContentUtils.create(drugOrContentParam)
			//aggDO.getParentDO().setContent_or(CiOrContentUtils.create(treatOrContentParam).toString());

		}
	}

}
