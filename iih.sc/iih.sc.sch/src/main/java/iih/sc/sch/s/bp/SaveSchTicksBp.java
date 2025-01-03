package iih.sc.sch.s.bp;

import iih.bd.res.dayslot.d.DayslotAggDO;
import iih.bd.res.dayslot.d.DayslotSecDO;
import iih.bd.res.dayslot.i.IDayslotRService;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScContextUtils;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.sctick.d.ScSchTickDO;
import iih.sc.sch.sctick.d.desc.ScSchTickDODesc;
import iih.sc.sch.sctick.i.ISctickCudService;
import iih.sc.sch.sctick.i.ISctickRService;
import iih.sc.sch.scticks.d.ScSchTicksDO;
import iih.sc.sch.scticks.d.desc.ScSchTicksDODesc;
import iih.sc.sch.scticks.i.IScticksCudService;
import iih.sc.sch.scticks.i.IScticksRService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.SqlParamDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;

/**保存排班号段
 * @author ccj
 *
 */
public class SaveSchTicksBp {
	
	/**根据排班生成号段
	 * @param schDo 排班do
	 * @param schState	排班状态时新增还是修改
	 * @return 保存后的 号段
	 * @throws BizException
	 */
	public ScSchTicksDO[] exec(ScSchDO schDo,Integer schState) throws BizException{
		if(schDo == null || schState == null ) return null;
		IScticksRService rService = ServiceFinder.find(IScticksRService.class);
		IScticksCudService scticksCudService = ServiceFinder.find(IScticksCudService.class);
		if(schState == DOStatus.UPDATED){
			// 修改要先删除 号段下号位 再删除号段
			ISctickRService iSctickRService = ServiceFinder.find(ISctickRService.class);
			ISctickCudService sctickCudService = ServiceFinder.find(ISctickCudService.class);
			String whereStr = String.format("%s.id_sch=? ", ScSchTickDODesc.TABLE_ALIAS_NAME);
			SqlParamDTO param = new SqlParamDTO();
			param.addParam(schDo.getId_sch());
			ScSchTickDO[] schTickDOs =  iSctickRService.find2(whereStr, param, null, FBoolean.TRUE);
			sctickCudService.delete(schTickDOs);
			ScSchTicksDO[] schTicksDOs =  rService.find(ScSchTicksDODesc.TABLE_ALIAS_NAME+".id_sch='"+schDo.getId_sch()+"'", "", FBoolean.TRUE);
			scticksCudService.delete(schTicksDOs);
		}
		List tickList = new ArrayList();
		//取出日期分组
		IDayslotRService daysloatSrv = ServiceFinder.find(IDayslotRService.class);		
		DayslotAggDO dlotAgg = daysloatSrv.findById(schDo.getId_dayslot());
		DayslotSecDO[] secDO = dlotAgg.getDayslotSecDO();
		List<DayslotSecDO> list = new ArrayList<DayslotSecDO>();
		Collections.addAll(list, secDO);
		sortList(list);
		// 日期分组时段
		if(secDO.length==0 || secDO.length == 0) return null;
		Integer total = schDo.getQuan_total(); 	//总号数
		Integer quecn_appt = schDo.getQuan_total_appt(); 	// 可预约总数
		Integer avgTotal; // 平均每个号段的票号数
		if( (total%secDO.length+1) != 0){
			 avgTotal = total/secDO.length+1;
		}else{
			 avgTotal = total/secDO.length;
		} 
		Integer avgQuecnAppt; 	// 平均每个号段的可预约数
		if( (quecn_appt%secDO.length+1) != 0){
			avgQuecnAppt = quecn_appt/secDO.length+1;
		}else{
			avgQuecnAppt = quecn_appt/secDO.length;
		}
		Integer addAppt = 0; //可预约数累加
		Integer num = 1;  //初始号位
		FTime startTime = dlotAgg.getParentDO().getTime_begin();  //日期分组  开始时间
		for(int i=0;i<secDO.length;i++){
			// 如果总数个数少于日期分组时段个数则后面时段不生成
			if(num > total) return (ScSchTicksDO[])tickList.toArray(new ScSchTicksDO[tickList.size()]);
			ScSchTicksDO ticks = new ScSchTicksDO();
			ticks.setId_grp(ScContextUtils.getGrpId()); //集团
			ticks.setId_org(ScContextUtils.getOrgId()); //组织
			ticks.setId_sch(schDo.getId_sch()); // 排班
			ticks.setCode(Integer.toString(i+1)); // 编码
			ticks.setName(Integer.toString(i+1)); // 名称
			ticks.setT_b(startTime); // 开始时间
			// 结束时间
			startTime = ScAppUtils.addSecondsByFTime(startTime, secDO[i].getPeriod()*60);
			ticks.setT_e(startTime);
			ticks.setQueno_b(num); 	// 开始票号
			ticks.setQuecn_used(0);//已使用数
			num += avgTotal; 	// 开始票号累加票号张数
			if(i!=secDO.length-1){
				ticks.setQuecn(avgTotal);  // 票号张数
				if(addAppt >= quecn_appt){
					ticks.setQuecn_appt(0); 	//可预约数量
				}else{
					ticks.setQuecn_appt(avgQuecnAppt); 	//可预约数量
					// 累加可预约数
					addAppt += avgQuecnAppt; 
				}
			}else{
				//当为最后一个号段生成时
				ticks.setQuecn( total - ( (secDO.length-1)*avgTotal ) ); // 票号张数
				ticks.setQuecn_appt( quecn_appt - addAppt ); 	//可预约数量
			}
			ticks.setQuecn_used(0);
			ticks.setFg_active(FBoolean.TRUE);
			ticks.setStatus(DOStatus.NEW);
			tickList.add(ticks);
		}
		ScSchTicksDO[] schTicksDOs = scticksCudService.save((ScSchTicksDO[])tickList.toArray(new ScSchTicksDO[tickList.size()]));
		return schTicksDOs;
	} 
	
	/**list 排序
	 * @param list
	 */
	private void sortList(List<DayslotSecDO> list) {
		 Collections.sort(list, new Comparator<DayslotSecDO>() {
			@Override
			public int compare(DayslotSecDO o1, DayslotSecDO o2) {
				Integer sortno = o1.getSortno(); 
				Integer sortno1 = o2.getSortno();
				return sortno.compareTo(sortno1);
			} 
		 });
	}
}
