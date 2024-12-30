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
 * 快捷预约
 * @author ccj
 *
 */
public class SaveQuickAptBp {
	 /**
	 * 门诊、医技 快捷预约
	 * @param  AptDto dto 里面需要赋值的参数
     * @param id_sch  排班id
     * @param tickmd	票号模式
     * @param id_pat	患者id
     * @param scpolcn	号源池数
     * @param sd_scchltp 渠道code
     * @param  scSchTickDOs  号位
     * @param scSchTicksDOs 号段
     * @return 预约的票号  
     * @throws BizException
     */
	public Integer exec(AptDto aptDto) throws BizException{
		if(aptDto == null) return null;
		IScschMDORService schSrv = ServiceFinder.find(IScschMDORService.class);
		ScSchDO schDO = schSrv.findById(aptDto.getId_sch()); 	//  计划排班_排班Do
		String sd_sctp = schDO.getSd_sctp();  //排班分类编码
		GetChannelByTpBP getChlBP = new GetChannelByTpBP();
		SchedulechlDO chlDO = getChlBP.exec(aptDto.getSd_scchltp());
		SaveAptOpBP aptOpBP = new SaveAptOpBP();
		SaveAptMtBP aptMtBP = new SaveAptMtBP();
		GetAptAggBp aptAggBp = new GetAptAggBp();
		UpdateSdSuObsBp sdSuObsBp = new UpdateSdSuObsBp();
		IScSchOutCmdService iScSchOutCmdService = ServiceFinder.find(IScSchOutCmdService.class);
		// 号位
		ScSchTickDO schTickDO = null;
		if (IScDictCodeConst.SD_SCTP_MT.equals(sd_sctp)) {
			FBoolean fBoolean = ScParamUtils.getscAptCOI(null); // 读取系统参数医技预约检查项目类型
			if (fBoolean.booleanValue()) {
				schTickDO = iScSchOutCmdService.occupyTickBySchAndSrv(aptDto.getId_sch(),
						aptDto.getScpolcn(), null, aptDto.getId_scsrv());
			} else {
				schTickDO = iScSchOutCmdService.occupyTickBySch(aptDto.getId_sch(),aptDto.getScpolcn(),null, chlDO.getId_scchl());
			}
		} else if (IScDictCodeConst.SD_SCTP_OP.equals(sd_sctp)) {
			schTickDO = iScSchOutCmdService.occupyTickBySch(aptDto.getId_sch(),aptDto.getScpolcn(),null, chlDO.getId_scchl());
		}
		IScSchOutQryService iScSchOutQryService = ServiceFinder.find(IScSchOutQryService.class);
		ScPlanDO planDO = iScSchOutQryService.getScplanBySchBp(schDO);
		if(planDO == null) throw new BizException(IScMsgConst.SC_SCH_SCPLAN_ISEMPY);
		// 保存预约主表和表相关子表数据
		ScaptAggDO aggDO = aptAggBp.exec(planDO,schDO,schTickDO,aptDto.getId_pat(),chlDO.getId_scchl(),FBoolean.FALSE);
		if(aggDO == null) return null;
		if(IScDictCodeConst.SD_SCTP_OP.equals(sd_sctp)){
			//门诊
			aptOpBP.exec(aggDO,planDO.getId_scsrv());
		}else if(IScDictCodeConst.SD_SCTP_MT.equals(sd_sctp)){
			//医技
			aptMtBP.exec(aggDO, aptDto);
			sdSuObsBp.exec(aptDto.getId_or(),FBoolean.TRUE);
		}
		return schTickDO.getQueno();
	}
}
