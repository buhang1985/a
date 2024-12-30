package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.AptDto;
import iih.sc.apt.scapt.d.ScaptAggDO;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScParamUtils;
import iih.sc.scbd.schedulechl.d.SchedulechlDO;
import iih.sc.sch.i.IScSchOutCmdService;
import iih.sc.sch.i.IScSchOutQryService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.scp.scplan.d.ScPlanDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 选号预约
 * 
 * @author ccj
 *
 */
public class SaveSelectAptBp {

	/**
	 * 门诊、医技预约选号保存
	 * 
	 * @param id_sch 排班id
	 * @param tickmd 票号模式
	 * @param tickid 号段或号位id
	 * @param id_pat 患者id
	 * @param sd_scchltp 渠道编码
	 * @param scpolcn 号源池
	 * @param return 预约的票号
	 * @throws BizException
	 */
	public Integer exec(AptDto aptDto) throws BizException {
		if (aptDto == null)
			return null;
		IScschMDORService schSrv = ServiceFinder.find(IScschMDORService.class);
		ScSchDO schDO = schSrv.findById(aptDto.getId_sch()); // 排班do
		GetChannelByTpBP getChlBP = new GetChannelByTpBP();
		SchedulechlDO chlDO = getChlBP.exec(aptDto.getSd_scchltp());
		SaveAptOpBP aptOpBP = new SaveAptOpBP();
		GetAptAggBp aptAggBp = new GetAptAggBp();
		SaveAptMtBP aptMtBP = new SaveAptMtBP();
		UpdateSdSuObsBp sdSuObsBp = new UpdateSdSuObsBp();
		IScSchOutCmdService iScSchOutCmdService = ServiceFinder.find(IScSchOutCmdService.class);
		ScSchTickDO schTickDO = null;
		String sd_sctp = schDO.getSd_sctp(); // 排班分类编码
		if (IScDictCodeConst.SD_TICKMD_TICK.equals(aptDto.getTickmd())) {
			// 计划排班_号位 DO数据
			if (IScDictCodeConst.SD_SCTP_MT.equals(sd_sctp) && ScParamUtils.getscAptCOI(null).booleanValue()) {
				schTickDO = iScSchOutCmdService.occupyTickBySchAndSrv(aptDto.getId_sch(), aptDto.getScpolcn(), null,
						aptDto.getId_scsrv());
			} else if (IScDictCodeConst.SD_SCTP_OP.equals(sd_sctp)) {
				schTickDO = iScSchOutCmdService.occupyTickBySch(aptDto.getId_sch(),
						aptDto.getScpolcn(), null, chlDO.getId_scchl());
			}
		} else if (IScDictCodeConst.SD_TICKMD_TICKS.equals(aptDto.getTickmd())) {
			if (IScDictCodeConst.SD_SCTP_MT.equals(sd_sctp) && ScParamUtils.getscAptCOI(null).booleanValue()) {
				schTickDO = iScSchOutCmdService.occupyTickBySchAndSrv(aptDto.getId_sch(), aptDto.getScpolcn(),
						aptDto.getId_tick(), aptDto.getId_scsrv());
			} else if (IScDictCodeConst.SD_SCTP_OP.equals(sd_sctp)) {
				schTickDO = iScSchOutCmdService.occupyTickBySch(aptDto.getId_sch(),
						aptDto.getScpolcn(), aptDto.getId_tick(), chlDO.getId_scchl());
			}
		}
		IScSchOutQryService iScSchOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		ScPlanDO planDO = iScSchOutQryService.getScplanBySchBp(schDO);
		if (planDO == null)
			throw new BizException(IScMsgConst.SC_SCH_SCPLAN_ISEMPY);
		ScaptAggDO aggDO = aptAggBp.exec(planDO, schDO, schTickDO, aptDto.getId_pat(),
				chlDO.getId_scchl(),FBoolean.FALSE);
		if (IScDictCodeConst.SD_SCTP_OP.equals(sd_sctp)) {
			// 门诊
			aptOpBP.exec(aggDO, planDO.getId_scsrv());
		} else if (IScDictCodeConst.SD_SCTP_MT.equals(sd_sctp)) {
			// 医技
			try {
				// MtApt4EsDTO apt4EsDTO = new MtApt4EsDTO();
				// apt4EsDTO.setId_apt(aggDO.getParentDO().getId_apt());
				// new MakeAptEvent().invoke(apt4EsDTO);
				aptMtBP.exec(aggDO, aptDto);
			} catch (Exception e) {

			}
			sdSuObsBp.exec(aptDto.getId_or(), FBoolean.TRUE);
		}
		return schTickDO.getQueno();
	}

}
