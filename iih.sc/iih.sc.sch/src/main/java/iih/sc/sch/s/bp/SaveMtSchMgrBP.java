package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.ScContextUtils;
import iih.sc.sch.dto.d.MtSchDetailDTO;
import iih.sc.sch.s.ep.SchChlEP;
import iih.sc.sch.s.ep.SchEP;
import iih.sc.sch.s.ep.TicksEP;
import iih.sc.sch.scsch.d.ScSchChlDO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.ScSchEnDO;
import iih.sc.sch.scsch.d.ScSchOptsrvDO;
import iih.sc.sch.scsch.i.IScSchOptsrvDOCudService;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.i.ISctickCudService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.i.IScticksCudService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 保存医技排班管理信息
 *
 * @author yang.lu
 * @author liubin
 *
 */
public class SaveMtSchMgrBP {

	/**
	 * 保存医技排班管理信息
	 *
	 * @param mtschMgrDTO
	 * @throws BizException
	 */
	public void exec(MtSchDetailDTO mtschMgrDTO) throws BizException {
		//1.保存排班数据
		saveSchInfo(mtschMgrDTO);
		//2.保存渠道数据
		this.updateSchChl(mtschMgrDTO.getSch_chl_list(), mtschMgrDTO.getId_sch(),mtschMgrDTO.getFg_setentp());
		//3.保存就诊数据
		this.updateSchEn(mtschMgrDTO.getSch_chl_list(), mtschMgrDTO.getId_sch(),mtschMgrDTO.getSch_en_list(),mtschMgrDTO.getFg_setentp());
		//4.保存备用服务数据
		this.updateSchOptsrv(mtschMgrDTO.getId_scsrvs(),mtschMgrDTO.getId_sch());
		//5.保存号位号段数据
		if(IScDictCodeConst.SD_TICKMD_TIME.equals(mtschMgrDTO.getSd_tickmd()))
			saveTimeMd(mtschMgrDTO);//时间片模式
		else
			saveTickAndTicks(mtschMgrDTO);//号段号位模式
	}
	/**
	 * 保存排班数据
	 *
	 * @author liubin
	 *
	 * @param mtschMgrDTO
	 * @throws BizException
	 */
	private void saveSchInfo(MtSchDetailDTO mtschMgrDTO) throws BizException {
		SchEP ep = new SchEP();
		ScSchDO scschdo = ep.getById(mtschMgrDTO.getId_sch());
		this.setScSchValue(mtschMgrDTO, scschdo);
		ep.save(new ScSchDO[]{scschdo});
	}
	/**
	 * 保存号段和号位数据
	 *
	 * @author liubin
	 *
	 * @param mtschMgrDTO
	 * @throws BizException
	 */
	private void saveTickAndTicks(MtSchDetailDTO mtschMgrDTO)throws BizException{
		ScSchTicksDO[] ticksDOs =(ScSchTicksDO[]) mtschMgrDTO.getSch_ticks_list().toArray(new ScSchTicksDO[mtschMgrDTO.getSch_ticks_list().size()]);
		ScSchTickDO[] tickDOs 	=(ScSchTickDO[]) mtschMgrDTO.getSch_tick_list().toArray(new ScSchTickDO[mtschMgrDTO.getSch_tick_list().size()]);
		ISctickCudService tickCudService = ServiceFinder.find(ISctickCudService.class);
		IScticksCudService ticksCudService = ServiceFinder.find(IScticksCudService.class);
		this.setTickDoTicksId(ticksDOs,tickDOs );
		tickCudService.save(tickDOs);
		ticksCudService.save(ticksDOs);
	}
	/**
	 * 保存时间片模式号段
	 *
	 * @author liubin
	 *
	 * @param mtschMgrDTO
	 * @throws BizException
	 */
	private void saveTimeMd(MtSchDetailDTO mtschMgrDTO)throws BizException{
		TicksEP ticksEP = new TicksEP();
		ScSchTicksDO[] ticksDos = ticksEP.getTicksByCond(String.format("Id_sch = '%s'", mtschMgrDTO.getId_sch()), ScSchTicksDO.T_B);
		if(ArrayUtil.isEmpty(ticksDos))
			return;
		//处理第一个号段
		Set<ScSchTicksDO> ticksList = new HashSet<>();
		ScSchTicksDO firstTicksDo = ticksDos[0];
		if(FBoolean.TRUE.equals(firstTicksDo.getFg_used())){
			if(mtschMgrDTO.getT_b_acpt().before(firstTicksDo.getT_b())){
				//添加号段T_b_acpt-T_b
				ticksList.add(wrapInsertTicksDo(mtschMgrDTO.getId_sch(), mtschMgrDTO.getT_b_acpt(), firstTicksDo.getT_b()));
			}
		}else{
			if(mtschMgrDTO.getT_b_acpt().before(firstTicksDo.getT_e())){
				//修改号段
				firstTicksDo.setStatus(DOStatus.UPDATED);
				firstTicksDo.setT_b(mtschMgrDTO.getT_b_acpt());
			}else{
				firstTicksDo.setStatus(DOStatus.DELETED);
			}
			ticksList.add(firstTicksDo);
		}
		ScSchTicksDO lastTicksDo = ticksDos[ticksDos.length - 1];
		if(FBoolean.TRUE.equals(lastTicksDo.getFg_used())){
			if(mtschMgrDTO.getT_e_acpt().after(lastTicksDo.getT_e())){
				//添加号段T_e - T_e_acpt
				ticksList.add(wrapInsertTicksDo(mtschMgrDTO.getId_sch(), lastTicksDo.getT_e(), mtschMgrDTO.getT_e_acpt()));
			}
		}else{
			if(mtschMgrDTO.getT_e_acpt().after(lastTicksDo.getT_b())){
				//修改号段
				lastTicksDo.setStatus(DOStatus.UPDATED);
				lastTicksDo.setT_e(mtschMgrDTO.getT_e_acpt());
			}else{
				lastTicksDo.setStatus(DOStatus.DELETED);
			}
			ticksList.add(lastTicksDo);
		}
		if(ticksList.size() > 0)
			ticksEP.save(ticksList.toArray(new ScSchTicksDO[0]));
	}

	/**
	 * 设置排班数据
	 * @param mtschMgrDTO
	 * @param scschdo
	 */
	private void setScSchValue(MtSchDetailDTO mtschMgrDTO,ScSchDO scschdo){
		scschdo.setStatus(DOStatus.UPDATED);
		int allappt = 0;
		for (Object obj : mtschMgrDTO.getSch_chl_list()) {
			ScSchChlDO schChlDO = (ScSchChlDO) obj;
			Integer Quan_appt = new Integer(0);
			if (IScDictCodeConst.SD_TICKMD_TIME.equals(scschdo.getSd_tickmd())) {
				Quan_appt = schChlDO.getQuan_appt() + schChlDO.getQuan_used();
			} else {
				Quan_appt = schChlDO.getQuan_appt();
			}
			scschdo.setAttrVal("Quan" + schChlDO.getScpolcn() + "_appt", Quan_appt);
			scschdo.setAttrVal("Quan" + schChlDO.getScpolcn() + "_used", schChlDO.getQuan_used());
			allappt += Quan_appt;
		}
		// 保存推荐报到时间字段 add by zhengcm 2017-11-29
		scschdo.setSugest_exmint(mtschMgrDTO.getSugest_exmint());
		scschdo.setQuan_total(mtschMgrDTO.getQuan_total());
		scschdo.setQuan_total_appt(allappt);
		scschdo.setMax_num_add(mtschMgrDTO.getMax_num_add());
		scschdo.setT_b_acpt(mtschMgrDTO.getT_b_acpt());
		scschdo.setT_e_acpt(mtschMgrDTO.getT_e_acpt());
		scschdo.setT_e_reg(mtschMgrDTO.getT_e_reg());
		scschdo.setFg_std_acpt(mtschMgrDTO.getFg_std_acpt());
		scschdo.setScpolcn(mtschMgrDTO.getScpolcn());
		if(mtschMgrDTO.getSugest_exmint() !=null){
		      scschdo.setSugest_exmint(mtschMgrDTO.getSugest_exmint());
			}
		// 自动释放号源 zhengcm 2017-10-23
		scschdo.setFg_auto_release(mtschMgrDTO.getFg_auto_release());
		if (mtschMgrDTO.getSch_ticks_list() != null)
			for (Object obj : mtschMgrDTO.getSch_ticks_list()) {
				((ScSchTicksDO) obj).setStatus(DOStatus.UPDATED);
			}
		if (mtschMgrDTO.getSch_tick_list() != null)
			for (Object obj : mtschMgrDTO.getSch_tick_list()) {
				((ScSchTickDO) obj).setStatus(DOStatus.UPDATED);
			}
		scschdo.setFg_setentp(mtschMgrDTO.getFg_setentp());//设置就诊类型
		scschdo.setFg_auto_apt(mtschMgrDTO.getFg_auto_apt());//设置是否适用于自动预约
	}
	/**
	 * 更新排班渠道
	 *
	 * @param schChlDOList 排班渠道DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void updateSchChl(List<ScSchChlDO> schChlDOList, String schId,FBoolean fg_entp) throws BizException {
		if (ListUtil.isEmpty(schChlDOList)) {
			return;
		}
		List<ScSchChlDO> chlDOList = new ArrayList<ScSchChlDO>();
		for (ScSchChlDO chlDO : schChlDOList) {
			List<String> list = new ArrayList<String>();
			if (chlDO.getId_scchl() != null) {
				list = StringUtil.toList(chlDO.getId_scchl(), ",");
				for (String scchlId : list) {
					chlDOList.add(this.setSchlDO(scchlId, chlDO, schId,fg_entp));
				}
			}
		}
		SchChlEP chlEp = new SchChlEP();
		List<ScSchChlDO> schChls = new ArrayList<ScSchChlDO>();
		chlEp.assemlySchChls(schId, chlDOList, schChls, fg_entp);
		if (!ListUtil.isEmpty(schChls)) {
			chlEp.save(schChls.toArray(new ScSchChlDO[] {}));
		}

	}

	/**
	 * 更新排班就诊
	 *
	 * @param schEnDOList 排班就诊DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void updateSchEn(List<ScSchChlDO> schChlDOList, String schId,List<ScSchEnDO> schEnDOList,FBoolean fg_setentp) throws BizException {		if (ListUtil.isEmpty(schChlDOList)) {
			return;
		}

		List<ScSchEnDO> enDOList = new ArrayList<ScSchEnDO>();
		// 设置就诊类型为true
		if(fg_setentp != null && fg_setentp.booleanValue())
		{
			for(int i = 0;i<schChlDOList.size();i++){
				ScSchChlDO chlDO = (ScSchChlDO)schChlDOList.get(i);
				enDOList.add(this.setEnDO(schId, chlDO, schId));
			}
		}
		SchChlEP chlEp = new SchChlEP();
		List<ScSchEnDO> schChls = new ArrayList<ScSchEnDO>();
		chlEp.assemlySchEns(schId, enDOList, schChls);

		if (!ListUtil.isEmpty(schChls)) {
			chlEp.saveEn(schChls.toArray(new ScSchEnDO[] {}));
		}

	}
	/**
	 * 更新排班备用服务
	 *
	 * @param schEnDOList 排班就诊DO列表
	 * @throws BizException
	 * @author zhengcm
	 */
	private void updateSchOptsrv(String id_scsrvs,String id_sch) throws BizException {
		IScSchOptsrvDOCudService iscschoptsrvdocudservice = ServiceFinder.find(IScSchOptsrvDOCudService.class);
		DAFacade dafacade = new DAFacade();
		StringBuffer sql = new StringBuffer();
		sql.append("delete from sc_sch_optsrv where id_sch = '").append(id_sch).append("'");
		dafacade.execUpdate(sql.toString());
		if(!StringUtil.isEmpty(id_scsrvs)){
			List<ScSchOptsrvDO> result = new ArrayList<ScSchOptsrvDO>();
			String[] idscsrvs = id_scsrvs.split(",");
			for (String id_scsrv : idscsrvs) {
				ScSchOptsrvDO optsrv = new ScSchOptsrvDO();
				optsrv.setStatus(DOStatus.NEW);
				optsrv.setId_sch(id_sch);
				optsrv.setId_scsrv(id_scsrv);
				result.add(optsrv);
			}
			iscschoptsrvdocudservice.save(result.toArray(new ScSchOptsrvDO[0]));
		}
	}
	/**
	 * 设置渠道do
	 *
	 * @param id_scchl
	 * @param num
	 * @return
	 */
	private ScSchChlDO setSchlDO(String id_scchl, ScSchChlDO chldo, String id_sch,FBoolean fg_entp) {
		ScSchChlDO chlDO = new ScSchChlDO();
		chlDO.setStatus(DOStatus.NEW);
		chlDO.setId_scchl(id_scchl);
		chlDO.setScpolcn(chldo.getScpolcn());
		chlDO.setId_sch(id_sch);
		chlDO.setIds_dep_spec(chldo.getIds_dep_spec());
		chlDO.setIds_emp_spec(chldo.getIds_emp_spec());
		chlDO.setId_grp(ScContextUtils.getGrpId());
		chlDO.setId_org(ScContextUtils.getOrgId());
		chlDO.setFg_active(chldo.getFg_active());
		if(fg_entp != null && fg_entp.booleanValue())
		{
			chlDO.setId_entp(chldo.getId_entp());//就诊类型
		}
		return chlDO;
	}

	/**
	 * 设置就诊do
	 *
	 * @param id_scchl
	 * @param num
	 * @return
	 */
	private ScSchEnDO setEnDO(String id_scchl,  ScSchChlDO chldo,String id_sch) {
		ScSchEnDO updateEnDO = new ScSchEnDO();
		updateEnDO.setStatus(DOStatus.NEW);
		updateEnDO.setId_sch(id_sch);
		updateEnDO.setId_entp(chldo.getId_entp());
		updateEnDO.setSd_entp(chldo.getCode_entp());
		updateEnDO.setScpolcn(chldo.getScpolcn());
		return updateEnDO;
	}
	/**
	 * 根据号段指定号位id
	 * @param ticksDOs
	 * @param mtPlWk
	 * @throws BizException
	 */
	private void setTickDoTicksId(ScSchTicksDO[] ticksDOs, ScSchTickDO[] tickDOs ) throws BizException {
		if (ticksDOs==null||ticksDOs.length<=0||tickDOs == null || tickDOs.length<=0)
			return;
		Map<String, ScSchTicksDO> ticksMap=new HashMap<String,ScSchTicksDO>();
		for (ScSchTicksDO ticksDO : ticksDOs) {
			ticksMap.put(ticksDO.getId_ticks(), ticksDO);
		}
		for (ScSchTickDO tickDO : tickDOs) {
			if(StringUtil.isEmpty(tickDO.getId_ticks())||ticksMap.get(tickDO.getId_ticks())==null ){
				throw new BizException("未获取到号位号段的ID");
			}
			ScSchTicksDO ticksDO=ticksMap.get(tickDO.getId_ticks());
			tickDO.setT_b(ticksDO.getT_b());
			tickDO.setT_e(ticksDO.getT_e());
			tickDO.setIds_kinditm(ticksDO.getIds_kinditm());
		}
	}
	/**
	 * 组装新增的号段do
	 *
	 * @author liubin
	 *
	 * @param id_sch
	 * @param t_b
	 * @param t_e
	 * @param fg_used
	 * @return
	 * @throws BizException
	 */
	private ScSchTicksDO wrapInsertTicksDo(String id_sch, FTime t_b, FTime t_e)throws BizException{
		ScSchTicksDO schTicksDO = new ScSchTicksDO();
		schTicksDO.setStatus(DOStatus.NEW);
		schTicksDO.setId_grp(ScContextUtils.getGrpId());
		schTicksDO.setId_org(ScContextUtils.getOrgId());
		schTicksDO.setId_sch(id_sch);
		schTicksDO.setT_b(t_b);
		schTicksDO.setT_e(t_e);
		schTicksDO.setQuecn(1);
		schTicksDO.setQuecn_appt(1);
		schTicksDO.setFg_used(FBoolean.FALSE);
		schTicksDO.setFg_active(FBoolean.TRUE);
		schTicksDO.setQuecn_used(0);
		return schTicksDO;
	}
}
