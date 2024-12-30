package iih.sc.sch.s.bp.mt.apt.bp;

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
 * 根据排班和服务占用票号(根据渠道)
 * 
 * @author zhengcm
 * @date 2017-07-31 15:57:14
 *
 */
public class OccupyChlTickBySchAndSrv4ManualAptBP {
	/**
	 * 占用排班号位最小号,如果没有可用资源抛异常
	 * 
	 * @author zhengcm
	 * 
	 * @param schId 排班id
	 * @param polcn 号源池编号，0-9，默认为0
	 * @param ticksId 号段id
	 * @param srvId 服务id
	 * @param id_scchl
	 * @param exclDateList 排斥日期集合
	 * @return 号位DO
	 * @throws BizException 异常
	 */
	public ScSchTickDO exec(String schId, Map<Integer,Integer> polcnMap, String ticksId, String srvId, String id_scchl,String idEnttp,MtResDTO resDTO)
			throws BizException {
		// 校验参数
		this.validateParam(schId, polcnMap, id_scchl);

		TickChl4MtAptEP tickEP = new TickChl4MtAptEP();

		// 获取票号模式
		String tickMd = tickEP.getTickModeBySchId(schId);

		// 当前排班加锁
		tickEP.lockSch(schId);

		// 1、占用号位和号段
		ScSchTickDO tickDO = null;
		if (IScDictCodeConst.SD_TICKMD_TICKS.equals(tickMd)) {
			if (!StringUtil.isEmpty(ticksId)) {
				tickDO = tickEP.occupyByTicksAndSrv(ticksId, polcnMap, srvId, id_scchl, idEnttp,resDTO);// 根据号段占用号位
			} else {
				tickDO = tickEP.occpuyBySchAndSrv(schId, polcnMap, srvId, id_scchl, idEnttp, resDTO);// 根据排班号位
			}
			// 占用号段
			Ticks4MtAptEP ticksBP = new Ticks4MtAptEP();
			ticksBP.occupy(tickDO.getId_ticks());
		} else {
			tickDO = tickEP.occpuyBySchAndSrv(schId, polcnMap, srvId, id_scchl, idEnttp,resDTO);// 号位
		}

		// 2、占用排班号源
		Sch4MtAptEP schBP = new Sch4MtAptEP();
		// 传入号位使用的号源池号
		schBP.occupyTick(schId, tickDO.getPolno_used());

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
	private void validateParam(String schId, Map<Integer,Integer> polcnMap, String chlId) throws BizException {
		// 参数校验
		ScValidator.validateParam("schId", schId);
		ScValidator.validateParam("chlId", chlId);
		for (Integer polcn : polcnMap.keySet()) {
			if (polcn == null || polcn < 0 || polcn > 10) {
				throw new BizException(IScMsgConst.ERROR_SC_SCH_POLCN_OUT_OF_RANGE);
			}
		}
	}
}
