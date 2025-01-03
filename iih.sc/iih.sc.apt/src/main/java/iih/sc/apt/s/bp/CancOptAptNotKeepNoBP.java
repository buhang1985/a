package iih.sc.apt.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.s.bp.mt.CancMtAptBP;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.i.IScaptMDOCudService;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.comm.ScLogUtil;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickCudService;
import iih.sc.sch.sctick.i.ISctickRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class CancOptAptNotKeepNoBP {

	public void exec(MtAppDTO appDTO) throws BizException {
		ScLogUtil.getInstance().logError("1.【CancOptAptNotKeepNoBP_退约不保留号,开始】患者:"+appDTO.getName_pat()+",手术:"+appDTO.getName_or()+",参数:id_apt_"+appDTO.getId_apt()+",id_apt_appl_"+appDTO.getId_apt_appl()+",id_dep_apply_"+appDTO.getId_dep_apply()+",id_or_"+appDTO.getId_or()+",id_pat_"+appDTO.getId_pat()+",id_sch_"+appDTO.getId_sch());
		//取消预约
		new CancMtAptBP().exec(appDTO, IScDictCodeConst.SD_SCTP_OT);
		
		//获取票号后面的预约信息
		ScAptDO[] aptDOs = this.getAptDOs(appDTO);
		if(aptDOs == null || aptDOs.length ==0)
		{
			return;
		}
		
		//获取票号以后的排班(包括当前)
		ScSchTickDO[] tickDOs = this.getTickDOs(appDTO);
		if(tickDOs == null || tickDOs.length ==0)
		{
			return;
		}
		
		for(int i = 0 ;i < aptDOs.length ; i++)
		{
			ScAptDO aptDO = aptDOs[i];
			for (int j = 1 ;j < tickDOs.length ; j++) 
			{
				if(aptDO.getQueno().equals(tickDOs[j].getQueno()))
				{
					tickDOs[j - 1 ].setStatus(DOStatus.UPDATED);
					tickDOs[j].setStatus(DOStatus.UPDATED);
					tickDOs[j - 1 ].setEu_used(1);
					tickDOs[j - 1 ].setPolno_used(tickDOs[j].getPolno_used());
					tickDOs[j].setPolno_used(null);
					aptDO.setId_tick(tickDOs[j - 1].getId_tick());
					tickDOs[j].setEu_used(0);
					aptDO.setDt_b(new FDateTime(aptDO.getDt_b().getBeginDate(), tickDOs[j - 1 ].getT_b()));
					break;
				}
			}
			aptDO.setStatus(DOStatus.UPDATED);
			aptDO.setQueno(aptDO.getQueno() - 1);
		}
		
		//保存预约信息
		IScaptMDOCudService aptCud = ServiceFinder.find(IScaptMDOCudService.class);
		aptCud.save(aptDOs);
		
		//保存号位信息
		ISctickCudService tickCud = ServiceFinder.find(ISctickCudService.class);
		tickCud.save(tickDOs);
		ScLogUtil.getInstance().logError("4.【CancOptAptNotKeepNoBP_退约不保留号,结束】患者:"+appDTO.getName_pat()+",手术:"+appDTO.getName_or()+",参数:id_apt_"+appDTO.getId_apt()+",id_apt_appl_"+appDTO.getId_apt_appl()+",id_dep_apply_"+appDTO.getId_dep_apply()+",id_or_"+appDTO.getId_or()+",id_pat_"+appDTO.getId_pat()+",id_sch_"+appDTO.getId_sch());
	}
	
	/**
	 * 获取票号后面的预约信息
	 * @param appDTO
	 * @return
	 * @throws BizException
	 */
	private ScAptDO[] getAptDOs(MtAppDTO appDTO) throws BizException
	{
 		IScaptMDORService rService = ServiceFinder.find(IScaptMDORService.class);
 		String cond = String.format(" id_sch = '%s' and queno > %s and fg_canc = 'N'",appDTO.getId_sch(),appDTO.getQueno());
 		ScLogUtil.getInstance().logError("2.【CancOptAptNotKeepNoBP_退约不保留号,获取票号后面的预约信息,】患者:"+appDTO.getName_pat()+",id_dep_apply_"+appDTO.getId_dep_apply()+",id_or_"+appDTO.getId_or()+",id_pat_"+appDTO.getId_pat()+",id_sch_"+appDTO.getId_sch()+",cond_"+cond);
		ScAptDO[] aptDOs = rService.find(cond, "queno", FBoolean.FALSE);
		return aptDOs;
	}
	/**
	 * 获取票号以后的排班(包括当前)
	 * @param appDTO
	 * @return
	 * @throws BizException
	 */
	private ScSchTickDO[] getTickDOs(MtAppDTO appDTO) throws BizException
	{
		SqlParamDTO param = new SqlParamDTO();
		ISctickRService rService = ServiceFinder.find(ISctickRService.class);
		String whereStr = " id_sch = ? and queno >= ? ";
		param.addParam(appDTO.getId_sch());
		param.addParam(appDTO.getQueno());
		ScLogUtil.getInstance().logError("3.【CancOptAptNotKeepNoBP_退约不保留号,获取票号以后的排班(包括当前),】患者:"+appDTO.getName_pat()+",id_dep_apply_"+appDTO.getId_dep_apply()+",id_or_"+appDTO.getId_or()+",id_pat_"+appDTO.getId_pat()+",id_sch_"+appDTO.getId_sch()+",cond_"+whereStr);
		ScSchTickDO[] tickDOs = rService.find2(whereStr, param, ScSchTickDO.QUENO, FBoolean.FALSE);
		return tickDOs;
	}
}
