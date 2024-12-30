package iih.sc.sch.s.bp.mt.apt.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScValidator;
import iih.sc.sch.s.ep.mt.apt.Sch4MtAptEP;
import iih.sc.sch.s.ep.mt.apt.TickChl4MtAptEP;
import iih.sc.sch.s.ep.mt.apt.Ticks4MtAptEP;
import iih.sc.sch.sctick.d.ScSchTickDO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 按渠道根据服务占用号位BP
 * 
 * @author zhengcm
 * @date 2017-07-27 10:35:32
 *
 */
public class OccupyChlTickBySrv4ManualAptBP {
	/**
	 * 按渠道占用号位
	 * 
	 * @author zhengcm
	 *
	 * @param tickId 号位ID
	 * @param polcn 号源池
	 * @param srvId 服务ID
	 * @param chlId 渠道ID
	 * @return 号位DO
	 * @throws BizException
	 */
	public ScSchTickDO exec(String tickId, Map<Integer,Integer> polcnMap, String srvId, String chlId,MtResDTO resDTO) throws BizException {
		ScValidator.validateParam("tickId", tickId);
		ScValidator.validateParam("srvId", srvId);
		ScValidator.validateParam("chlId", chlId);
		int polcn = IScDictCodeConst.SC_CHL_REMAIN;
		List<Integer> polcnList = new ArrayList<Integer>();
		for (Integer key : polcnMap.keySet()) {
			if (key == null || key < 0 || key > 10) {
				throw new BizException(IScMsgConst.ERROR_SC_SCH_POLCN_OUT_OF_RANGE);
			}
			int remain = polcnMap.get(key);
			if(remain > 0){
				polcnList.add(key);
			}
		}

		// 1、占用号位
		ScSchTickDO tickDO = new TickChl4MtAptEP().occupyTickBySrv(tickId, /*polcn*/polcnMap, srvId, chlId, resDTO);

		// 2、如果是号段，则需占用号段
		if (!StringUtil.isEmpty(tickDO.getId_ticks())) {
			Ticks4MtAptEP ticksBP = new Ticks4MtAptEP();
			ticksBP.occupy(tickDO.getId_ticks());
		}

		// 3、占用排班号源
		Sch4MtAptEP schBP = new Sch4MtAptEP();
		schBP.occupyTick(tickDO.getId_sch(), polcn);

		return tickDO;
	}
}
