package iih.sc.scp.s.bp.oral;

import iih.sc.comm.ScValidator;
import iih.sc.scp.dto.d.OralPlDTO;
import iih.sc.scp.dto.d.OralPlTickDTO;
import iih.sc.scp.s.bp.common.DelPlWeekBP;
import iih.sc.scp.s.ep.ScplEp;
import iih.sc.scp.s.ep.ScplOptSrvEP;
import iih.sc.scp.s.ep.ScplWeekEP;
import iih.sc.scp.s.ep.ScplWeekTickEP;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scploptsrv.d.ScPlOptSrvDO;
import iih.sc.scp.scpltick.d.ScPlanWeekTickDO;
import iih.sc.scp.scplweek.d.ScPlanWeekChlDO;
import iih.sc.scp.scplweek.d.ScPlanWeekDO;
import iih.sc.scp.scplweek.d.ScplweekAggDO;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 重量级口腔计划保存
 * 
 * @author liubin
 * @param
 *
 */
public class SaveOralPlBP {
	/**
	 * 口腔计划保存
	 * 
	 * @param oralPlDTO 口腔门诊排班计划DTO
	 * @return 口腔门诊排班计划DTO
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public OralPlDTO exec(OralPlDTO oralPl) throws BizException{
		if(ScValidator.isNullOrEmpty(oralPl))
			throw new BizException("保存数据为空！");
		//1.删除备选服务
		this.deleteOptSrv(oralPl);
		//2.保存计划数据
		ScPlanDO[] pls = this.saveScPl(oralPl);
		if(ScValidator.isNullOrEmpty(pls))
			throw new BizException("保存失败！");
		//3.保存备选服务
		this.saveOptSrv(pls[0]);
		//4.删除周计划渠道
		//this.deleteWeekPlChl(oralPl);
		//5.保存周计划和号位
		this.saveScplWeekAndTicks(oralPl, pls[0]);
		oralPl.setId_scpl(pls[0].getId_scpl());
		FArrayList plList = new FArrayList();
		plList.add(pls[0]);
		oralPl.setScpl_list(plList);
		return oralPl;
	}
	/**
	 * 保存计划数据
	 * 参数修改时，删除周计划
	 * 
	 * @param oralPl
	 * @return
	 * @throws BizException
	 */
	private ScPlanDO[] saveScPl(OralPlDTO oralPl) throws BizException{
		FArrayList plList =  oralPl.getScpl_list();
		if(ScValidator.isNullOrEmpty(plList))
			throw new BizException("保存数据为空！");
		ScPlanDO new_pl = (ScPlanDO)plList.get(0);
		ScplEp ep = new ScplEp();
		if(!ScValidator.isEmptyIgnoreBlank(new_pl.getId_scpl())){
			ScPlanDO pl = ep.getScPl(new_pl.getId_scpl());
			//如果参数发生改变,删除周计划
			if(!new_pl.getId_depparam().equals(pl.getId_depparam())){
				DelPlWeekBP delPlWeekBP = new DelPlWeekBP();
				delPlWeekBP.deletePlWeek(pl.getId_scpl(), pl.getSd_tickmd());
			}
		}
		return ep.save(new ScPlanDO[]{new_pl});
	}
	/**
	 * 保存备选服务
	 * 
	 * @param pl
	 * @throws BizException
	 */
	private void saveOptSrv(ScPlanDO pl)throws BizException{
		if (null == pl || ScValidator.isEmptyIgnoreBlank(pl.getId_optsrv())){
			return;
		}
		String[] optSrvs = pl.getId_optsrv().split(",");
		if(ScValidator.isNullOrEmpty(optSrvs))
			return;
		List<ScPlOptSrvDO> planOptSrvList = new LinkedList<>();
		for (String id_scsrv : optSrvs) {
			ScPlOptSrvDO planOptSrvDO = new ScPlOptSrvDO();
			planOptSrvDO.setStatus(DOStatus.NEW);
			planOptSrvDO.setId_scpl(pl.getId_scpl());
			planOptSrvDO.setId_scsrv(id_scsrv);
			planOptSrvList.add(planOptSrvDO);
		}
		ScplOptSrvEP ep = new ScplOptSrvEP();
		ep.save(planOptSrvList.toArray(new ScPlOptSrvDO[0]));
	}
	/**
	 * 保存周计划
	 * 
	 * @param oralPl
	 * @param id_scpl
	 * @return
	 * @throws BizException 
	 */
	private void saveScplWeekAndTicks(OralPlDTO oralPl, ScPlanDO pl) throws BizException{
		FArrayList weekList = oralPl.getWeek_list();
		if(weekList == null || weekList.size() <= 0)
			return;
		List<ScplweekAggDO> weekAggList = new LinkedList<>();
		List<ScPlanWeekTickDO> weekTkList = new LinkedList<>();
		//删除周计划渠道
		for(Object obj : weekList){
			if(!(obj instanceof OralPlTickDTO))
				continue;
			OralPlTickDTO plTick = (OralPlTickDTO)obj;
			this.processWeekAggAndTicks(plTick, pl, weekAggList, weekTkList);
		}
		ScplWeekEP weekEp = new ScplWeekEP();
		weekEp.savePlanWeekAgg(weekAggList.toArray(new ScplweekAggDO[0]));
		
		ScplWeekTickEP weekTickEP = new ScplWeekTickEP();
		weekTickEP.save(weekTkList.toArray(new ScPlanWeekTickDO[0]));
	}
	/**
	 * 删除备选服务
	 * 
	 * @param oralPl
	 * @throws BizException 
	 */
	private void deleteOptSrv(OralPlDTO oralPl) throws BizException{
		FArrayList plList =  oralPl.getScpl_list();
		if(plList == null || plList.size() <=0)
			return;
		ScPlanDO pl = (ScPlanDO) plList.get(0);
		if(ScValidator.isEmptyIgnoreBlank(pl.getId_scpl()))
			return;
		ScplOptSrvEP optSrvEP = new ScplOptSrvEP();
		optSrvEP.deleteScplOptSrvByplId(pl.getId_scpl());
	}
	/**
	 * 删除周计划渠道
	 * 
	 * @param oralPl
	 * @throws BizException
	 */
	private void deleteWeekPlChl(OralPlDTO oralPl) throws BizException{
		FArrayList weekDtoList = oralPl.getWeek_list();
		if(weekDtoList == null || weekDtoList.size() <= 0)
			return;
		List<String> scPlWeekIdList = new LinkedList<>();
		for(Object obj : weekDtoList){
			if(!(obj instanceof OralPlTickDTO))
				continue;
			OralPlTickDTO plTick = (OralPlTickDTO)obj;
			FArrayList weekList = plTick.getScpl_week_list();
			if(weekList == null || weekList.size() <= 0)
				continue;
			ScplweekAggDO agg = (ScplweekAggDO)weekList.get(0);
			if(agg != null && agg.getParentDO() !=null && !ScValidator.isEmptyIgnoreBlank(agg.getParentDO().getId_scplweek()))
				scPlWeekIdList.add(agg.getParentDO().getId_scplweek());
		}
		ScplWeekEP weekEP = new ScplWeekEP();
		weekEP.deleteChlByWeekIds(scPlWeekIdList.toArray(new String[0]));
	}
	
	/**
	 * 处理周计划渠道和号位
	 * 
	 * @param plTick
	 * @param pl
	 * @param weekAggList
	 * @param weekTkList
	 * @throws BizException 
	 */
	private void processWeekAggAndTicks(OralPlTickDTO plTick, ScPlanDO pl, List<ScplweekAggDO> weekAggList, List<ScPlanWeekTickDO> weekTkList) throws BizException{
		if(plTick == null)
			return;
		FArrayList weekList = plTick.getScpl_week_list();
		if(weekList == null || weekList.size() <= 0)
			return;
		ScplweekAggDO agg = (ScplweekAggDO)weekList.get(0);
		ScplweekAggDO oldAgg = null;
		ScPlanWeekDO planWeekDO = agg.getParentDO();
		if (StringUtil.isEmptyWithTrim(planWeekDO.getId_scplweek())) {
			DBUtil util = new DBUtil();
			planWeekDO.setStatus(DOStatus.NEW);
			planWeekDO.setId_scpl(pl.getId_scpl());
			planWeekDO.setId_scplweek(util.getOIDs(1)[0]);// 主键
		} else {
			planWeekDO.setStatus(DOStatus.UPDATED);
			oldAgg = new ScplWeekEP().getScplweekAggById(planWeekDO.getId_scplweek());
		}
		//1.处理渠道
		this.processWeekChl(agg, oldAgg);
		weekAggList.add(agg);
		//2.处理号位
		FArrayList tksList = plTick.getTick_list();
		if(tksList == null || tksList.size() <= 0)
			return;
		ScPlanWeekTickDO[] tks = this.list2PlWeekArray(tksList);
		this.processWeekTick(agg, tks);
		weekTkList.addAll(Arrays.asList(tks));
	}
	/**
	 * 处理周计划渠道
	 * 
	 * @param pl
	 * @param agg
	 * @throws BizException 
	 */
	private void processWeekChl(ScplweekAggDO weekAgg, ScplweekAggDO oldAgg) throws BizException{
		//根据界面号源池渠道信息组装渠道DO集合
		List<ScPlanWeekChlDO> newChlsList = new LinkedList<>();
		this.assemlyNewWeekChls(weekAgg, newChlsList);
		//界面数据组装的渠道DO与原数据对比，分出新增，删除，修改的渠道DO
		List<ScPlanWeekChlDO> chlsList = new LinkedList<>();
		new ScplWeekEP().assemlyWeekChls(oldAgg, newChlsList, chlsList);
		weekAgg.setScPlanWeekChlDO(chlsList.toArray(new ScPlanWeekChlDO[0]));
	}
	/**
	 * 根据界面号源池渠道信息组装渠道DO集合
	 * 
	 * @param weekAgg 周计划编辑界面数据源
	 * @param newChlsList 渠道DO集合
	 * @throws BizException 
	 */
	private void assemlyNewWeekChls(ScplweekAggDO weekAgg, List<ScPlanWeekChlDO> newChlsList) throws BizException{
		ScPlanWeekDO planWeekDO = weekAgg.getParentDO();
		ScPlanWeekChlDO[] chls = weekAgg.getScPlanWeekChlDO();
		for(ScPlanWeekChlDO chl : chls){
			if(chl.getStatus() == DOStatus.DELETED){
				planWeekDO.setAttrVal("Quan"+chl.getScpolcn()+"_appt", null);//删掉的号源池，清空号源数
				continue;
			}
			String chlId = chl.getId_scchl();
			if(ScValidator.isEmptyIgnoreBlank(chlId)){
				if(chl.getScnum()== 0){
					ScPlanWeekChlDO planWeekChlDO = new ScPlanWeekChlDO();
					planWeekChlDO.setStatus(DOStatus.NEW);
					planWeekChlDO.setId_scplweek(planWeekDO.getId_scplweek());
					planWeekChlDO.setScpolcn(chl.getScpolcn());
					newChlsList.add(planWeekChlDO);
				}else{
					throw new BizException("号源池"+chl.getScpolcn()+"对应渠道不能为空！");
				}
			}else{
				String[] chlIds = chlId.split(",");
				for(String id : chlIds){
					ScPlanWeekChlDO planWeekChlDO = new ScPlanWeekChlDO();
					planWeekChlDO.setStatus(DOStatus.NEW);
					planWeekChlDO.setId_scplweek(planWeekDO.getId_scplweek());
					planWeekChlDO.setId_scchl(id);
					planWeekChlDO.setScpolcn(chl.getScpolcn());
					newChlsList.add(planWeekChlDO);
				}
			}
			planWeekDO.setAttrVal("Quan"+chl.getScpolcn()+"_appt", chl.getScnum());
		}
	}
	/**
	 * 处理周计划号位
	 * 
	 * @param scplWeekId
	 * @param tks
	 */
	private void processWeekTick(ScplweekAggDO agg, ScPlanWeekTickDO[] tks){
		if(ScValidator.isNullOrEmpty(tks))
			return;
		String scplWeekId = agg.getParentDO().getId_scplweek();
		int quan_total_appt = 0;
		for(ScPlanWeekTickDO tk : tks){
			if(FBoolean.TRUE.equals(tk.getFg_active()))
				quan_total_appt++;
			if(ScValidator.isEmptyIgnoreBlank(tk.getId_tick())){
				tk.setStatus(DOStatus.NEW);
				tk.setId_scplweek(scplWeekId);
				continue;
			}
			tk.setStatus(DOStatus.UPDATED);
		}
		agg.getParentDO().setQuan_total_appt(quan_total_appt);
		agg.getParentDO().setQuan_total(quan_total_appt);
	}
	
	/**
	 * 把FArrayList转化为ScPlanWeekTickDO集合
	 * 
	 * @param flist
	 * @return
	 */
	private ScPlanWeekTickDO[] list2PlWeekArray(FArrayList flist){
		if(flist == null || flist.size() <= 0)
			return null;
		List<ScPlanWeekTickDO> list = new LinkedList<>();
		for(Object obj : flist){
			if(!(obj instanceof ScPlanWeekTickDO))
				continue;
			list.add((ScPlanWeekTickDO)obj);
		}
		return list.toArray(new ScPlanWeekTickDO[0]);
	}
}
