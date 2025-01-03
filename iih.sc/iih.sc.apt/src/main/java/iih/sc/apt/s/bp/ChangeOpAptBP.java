package iih.sc.apt.s.bp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.dto.d.MtResDTO;
import iih.sc.apt.dto.d.OptApt4OrmDTO;
import iih.sc.apt.s.bp.mt.GetMtResBP;
import iih.sc.apt.s.event.MakeOptAptEvent;
import iih.sc.apt.s.event.MakeOptCancAptEvent;
import iih.sc.apt.scapt.d.ScAptDO;
import iih.sc.apt.scapt.d.ScaptAggDO;
import iih.sc.apt.scapt.i.IScaptMDOCudService;
import iih.sc.apt.scapt.i.IScaptMDORService;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.scbd.log.d.EuOperTp;
import iih.sc.scbd.log.d.ScLogRecDO;
import iih.sc.scbd.log.i.ISclogrecCudService;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDOCudService;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickCudService;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.i.IScplanRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 手术预约  改约
 * @author Administrator
 *
 */
public class ChangeOpAptBP {
	//排班服务
	IScschMDORService iScschService ;
	IScschMDOCudService iScschCudService;
	//号位服务
	ISctickRService iSctickRService;
	ISctickCudService iSctickCudService;
	/**
	 * 手术预约  改约
	 * @param resDTO
	 * @param appDTO
	 * @return
	 */
	public MtResDTO exec(MtResDTO resDTO, MtAppDTO appDTO) throws BizException
	{
		//排班服务
		this.iScschService = ServiceFinder.find(IScschMDORService.class);
		this.iScschCudService = ServiceFinder.find(IScschMDOCudService.class);
		//号位服务
		this.iSctickRService = ServiceFinder.find(ISctickRService.class);
		this.iSctickCudService = ServiceFinder.find(ISctickCudService.class);
		
		//1.更改原排班,票号数据
		this.SaveOldSchAndTick(appDTO);
		
		//2.修改新排班信息
		ScSchDO[] schDOs = this.SaveNewSch(resDTO);
		
		//3.修改新号位信息
		ScSchTickDO[] tickDOs = this.SaveNewTick(resDTO);
		
		//4.修改预约信息
		IScaptMDORService iScaptMDORService = ServiceFinder.find(IScaptMDORService.class);
		ScAptDO scAptDO = iScaptMDORService.findById(appDTO.getId_apt());
		//手术退约 发送BS009手术退约消息
		this.cancOptApt(appDTO);
		ScAptDO scAptDO4Log = (ScAptDO)scAptDO.clone();
		ScAptDO[] aptDOs = this.SaveAptInfo(scAptDO,resDTO, appDTO, schDOs[0], tickDOs[0],schDOs[0].getId_scpl());
		
		//5.记录日志
		this.SaveLog(appDTO.getId_apt(), 
				scAptDO4Log.getDt_b(), aptDOs[0].getDt_b(), 
				appDTO.getId_sch(), resDTO.getId_sch(),
				scAptDO4Log.getId_tick(), resDTO.getId_ticks());
		
		//6.拼装返回数据
		MtResDTO mtRes = new GetMtResBP().exec(resDTO.getId_dep(), resDTO.getId_sch(), resDTO.getId_scchl(),FBoolean.FALSE,null);
		mtRes.setId_apt(aptDOs[0].getId_apt());
		
		//7.预约 修改后给 预约确认发事件
		mtRes.setIds_scapt(new SendChangeOptApt4OrBP().buildIdStr(Arrays.asList(aptDOs)));
		this.sendOptIeMsg(aptDOs[0].getId_apt());
		return mtRes;
	}
	
	/**
	 * 5.记录日志
	 * @param id_apt  预约id
	 * @param old_dt_b 旧预约时间
	 * @param new_dt_b 新预约时间
	 * @param old_id_sch 旧排班
	 * @param new_id_sch 新排班
	 * @param old_id_tick 旧号位
	 * @param new_id_tick 新号位
	 * @throws BizException
	 */
	private void SaveLog(String id_apt, FDateTime old_dt_b,FDateTime new_dt_b,String old_id_sch,String new_id_sch,String old_id_tick,String new_id_tick) throws BizException
	{
		ISclogrecCudService iSclogrecCudService = ServiceFinder.find(ISclogrecCudService.class);
		ScLogRecDO scLogRecDO = new ScLogRecDO();
		scLogRecDO.setStatus(DOStatus.NEW);
		scLogRecDO.setName_table("sc_apt");
		scLogRecDO.setId_data(id_apt);
		scLogRecDO.setId_parent_data(id_apt);
		scLogRecDO.setDt_log(ScAppUtils.getServerDateTime());
		scLogRecDO.setId_emp(ScContextUtils.getPsnId());
		scLogRecDO.setEu_operate(EuOperTp.UPDATE);
		scLogRecDO.setContent("预约id ：\n "+id_apt
				+";\n旧预约时间：\n"+old_dt_b+"\t—>\t 新预约时间：\n"+new_dt_b
				+";\n旧排班：\n"+old_id_sch+"\t—>\t 新排班：\n" + new_id_sch
				+";\n旧号位：\n"+old_id_tick+"\t—>\t 新号位：\n" + new_id_tick);
		iSclogrecCudService.save(new ScLogRecDO[]{scLogRecDO});
	}
	
	/**
	 * 4.更新预约信息
	 * @param resDTO
	 * @param appDTO
	 * @throws BizException
	 */
	private ScAptDO[] SaveAptInfo(ScAptDO scAptDO, MtResDTO resDTO, MtAppDTO appDTO, ScSchDO schDO, ScSchTickDO tickDO, String id_scpl) throws BizException
	{
		
		scAptDO.setStatus(DOStatus.UPDATED);
		scAptDO.setId_sch(resDTO.getId_sch());
		scAptDO.setId_dateslot(resDTO.getId_dayslot());
		scAptDO.setId_scres(resDTO.getId_res());
		IScplanRService iScplanRService = ServiceFinder.find(IScplanRService.class);
		ScPlanDO scPlanDO = iScplanRService.findById(id_scpl);
		scAptDO.setId_scsrv(scPlanDO.getId_scsrv());
		scAptDO.setId_tick(resDTO.getId_ticks());
		scAptDO.setQueno(tickDO.getQueno());
		scAptDO.setDt_appt(ScAppUtils.getServerDateTime());
		scAptDO.setDt_b(new FDateTime(schDO.getD_sch(),tickDO.getT_b()));
		scAptDO.setId_scchl(resDTO.getId_scchl());
		scAptDO.setId_emp_appt(ScContextUtils.getPsnId());
		IScaptMDOCudService iScaptMDOCudService =  ServiceFinder.find(IScaptMDOCudService.class);
		return iScaptMDOCudService.save(new ScAptDO[]{scAptDO});
	}
	
	/**
	 * 3.修改新号位信息
	 * @param resDTO
	 * @throws BizException 
	 */
	private ScSchTickDO[] SaveNewTick(MtResDTO resDTO) throws BizException
	{
		ScSchTickDO newTickDO = this.iSctickRService.findById(resDTO.getId_ticks());
		newTickDO.setStatus(DOStatus.UPDATED);
		newTickDO.setEu_used(1);//使用
		newTickDO.setPolno_used(resDTO.getScpolcn());
		return this.iSctickCudService.save(new ScSchTickDO[]{newTickDO});
	}
	
	/**
	 * 2.修改新排班信息
	 * @param resDTO
	 * @throws BizException 
	 */
	private ScSchDO[] SaveNewSch(MtResDTO resDTO) throws BizException
	{
		ScSchDO newSchDO = this.iScschService.findById(resDTO.getId_sch());
		newSchDO.setStatus(DOStatus.UPDATED);
		newSchDO.setQuan_total_used(newSchDO.getQuan_total_used() - 1);
		String quanX_used = String.format("Quan%s_used", resDTO.getScpolcn());
		newSchDO.setAttrVal(quanX_used, (Integer)newSchDO.getAttrVal(quanX_used) + 1);
		return this.iScschCudService.save(new ScSchDO[]{newSchDO});
	}
	
	/**
	 * 1.更改原排班,票号数据
	 * @param appDTO
	 * @throws BizException
	 */
	private void SaveOldSchAndTick(MtAppDTO appDTO) throws BizException
	{
		//更改原票号数据
		ScSchTickDO[] tickDOs = this.SaveOldTick(appDTO);
		
		//更改原排班数据
		this.SaveOldSch(appDTO,tickDOs[0].getPolno_used());
	}
	
	/**
	 * 更改原票号数据
	 * @param appDTO
	 * @throws BizException
	 */
	private ScSchTickDO[] SaveOldTick(MtAppDTO appDTO) throws BizException
	{
		SqlParamDTO param = new SqlParamDTO();
		String whereStr = " id_sch = ? and queno = ? ";
		param.addParam(appDTO.getId_sch());
		param.addParam(appDTO.getQueno());
		ScSchTickDO[] oldTickDOs = this.iSctickRService.find2(whereStr, param, "", FBoolean.FALSE);
		if(oldTickDOs == null || oldTickDOs.length == 0)
		{
			throw new BizException("未找到号位数据,请刷新后重试!");
		}
		oldTickDOs[0].setStatus(DOStatus.UPDATED);
		oldTickDOs[0].setEu_used(0);
		appDTO.setPolno_used(oldTickDOs[0].getPolno_used());
		return this.iSctickCudService.save(oldTickDOs);
	}
	
	/**
	 * 更改原排班数据
	 * @param appDTO
	 * @throws BizException
	 */
	private void SaveOldSch(MtAppDTO appDTO,Integer polno_used) throws BizException
	{
		ScSchDO schDO = this.iScschService.findById(appDTO.getId_sch());
		schDO.setStatus(DOStatus.UPDATED);
		schDO.setQuan_total_used(schDO.getQuan_total_used() -1);
		String quanx_used = String.format("Quan%s_used", polno_used);
		schDO.setAttrVal(quanx_used, (Integer) schDO.getAttrVal(quanx_used) -1);
		this.iScschCudService.save(new ScSchDO[]{schDO});
	}
	
	/**
	 * 取消手术预约集成平台消息
	 * @param mtAppDTO
	 * @throws BizException
	 */
	private void cancOptApt(MtAppDTO mtAppDTO) throws BizException {
		// 进行取消手术预约的触发
		List<OptApt4OrmDTO> optApt4OrmList = new ArrayList<OptApt4OrmDTO>();
		OptApt4OrmDTO optapt4ormdto = new OptApt4OrmDTO();
		optapt4ormdto.setId_apt(mtAppDTO.getId_apt());
		optApt4OrmList.add(optapt4ormdto);
		new MakeOptCancAptEvent().invoke(optApt4OrmList);
	}
	
	/**
	 * 发送手术预约IE信息
	 * @param aptAggDO
	 * @throws BizException
	 */
	private void sendOptIeMsg(String id_apt) throws BizException{
		// 触发手术预约信息事件
		OptApt4OrmDTO optapt4ormdto = new OptApt4OrmDTO();
		optapt4ormdto.setId_apt(id_apt);
		List<OptApt4OrmDTO> list = new ArrayList<OptApt4OrmDTO>();
		list.add(optapt4ormdto);
		new MakeOptAptEvent().invoke(list);
	}
}
