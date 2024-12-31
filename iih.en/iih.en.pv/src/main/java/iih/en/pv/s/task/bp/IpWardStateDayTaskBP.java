package iih.en.pv.s.task.bp;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.enstatwardsay.d.EnStatWardDay;
import iih.en.pv.enstatwardsay.i.IEnstatwardsayCudService;
import iih.en.pv.enstatwardsay.i.IEnstatwardsayRService;
import iih.en.pv.inpatient.dto.d.IpTotalInfoDTO;
import iih.en.pv.s.bp.ip.GetIpTotalInfoBP;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class IpWardStateDayTaskBP {

	public void exec(FDate date) throws BizException{
		//1.校验查询日期
		if (date == null) {
			return;
		}
		//2.删除当天数据
		EnStatWardDay[] statWardDays = rService().find("d_stat = '"+date+"'", null, FBoolean.FALSE);
		cudService().delete(statWardDays);
		//3.查询数据
		GetIpTotalInfoBP bp = new GetIpTotalInfoBP();
		IpTotalInfoDTO[] ipTotalInfoDTOs = bp.exec(null, null, date, date);
		//4.插入表
		this.saveWardStateDay(date, ipTotalInfoDTOs);
	}

	/***
	 * 保存科室统计数据到数据库
	 * @param date
	 * @param ipTotalInfoDTOs
	 * @throws BizException
	 */
	private void saveWardStateDay(FDate date,IpTotalInfoDTO[] ipTotalInfoDTOs) throws BizException{
		List<EnStatWardDay> list = new ArrayList<EnStatWardDay>();
		if(ipTotalInfoDTOs != null && ipTotalInfoDTOs.length > 0){
			for(IpTotalInfoDTO ipTotalInfoDTO : ipTotalInfoDTOs){
				EnStatWardDay enStatWardDay = new EnStatWardDay();
				//enStatWardDay.setId(ipTotalInfoDTO.getSd_dep_nur()+date);
				enStatWardDay.setD_stat(date);
				enStatWardDay.setId_dep(ipTotalInfoDTO.getId_dep_nur());
				enStatWardDay.setCode(ipTotalInfoDTO.getSd_dep_nur());
				enStatWardDay.setName(ipTotalInfoDTO.getName_dep_nur());
				enStatWardDay.setNum_in(ipTotalInfoDTO.getNum_acpt());
				enStatWardDay.setNum_out(ipTotalInfoDTO.getNum_leave());
				enStatWardDay.setNum_in_tran(ipTotalInfoDTO.getNum_transin());
				enStatWardDay.setNum_out_tran(ipTotalInfoDTO.getNum_transout());
				enStatWardDay.setNum_pat(ipTotalInfoDTO.getNum_now());
				enStatWardDay.setDs(DOStatus.NEW);
				list.add(enStatWardDay);
			}
		}
		//获取开放床位数
		this.getOpenBed(ipTotalInfoDTOs,list);
		cudService().insert(list != null ? list.toArray(new EnStatWardDay[]{}) : null);
	}
	
	/***
	 * 获取开放床位数
	 * @param ipTotalInfoDTOs
	 * @param enStatWardDays
	 * @throws BizException
	 */
	private void getOpenBed(IpTotalInfoDTO[] ipTotalInfoDTOs,List<EnStatWardDay> enStatWardDays) throws BizException{
		if(ipTotalInfoDTOs == null || ipTotalInfoDTOs.length <= 0 || enStatWardDays == null || enStatWardDays.size() <= 0){
			return;
		}
		List<String> id_deps = new ArrayList<String>();
		for(IpTotalInfoDTO ipTotalInfoDTO : ipTotalInfoDTOs){
			if(!EnValidator.isEmpty(ipTotalInfoDTO.getId_dep_nur())){
				id_deps.add(ipTotalInfoDTO.getId_dep_nur());
			}
		}
		FMap map = new FMap();
		if(id_deps != null && id_deps.size() > 0){
			StringBuffer sql = new StringBuffer();
			sql.append("select id_dep_belong as id_dep,count(1) as num_bed from bd_bed ");
			sql.append("where sd_bedtp = '"+IBdResDictCodeConst.SD_BEDTYPE_ORI+"' " );
			sql.append("and "+SqlUtils.getInSqlByIds("id_dep_belong", id_deps));
			sql.append("group by id_dep_belong ");
			@SuppressWarnings("unchecked")
			List<EnStatWardDay> list = (List<EnStatWardDay>) new DAFacade().execQuery(sql.toString(), new BeanListHandler(EnStatWardDay.class));
			if(list != null && list.size() > 0){
				for(EnStatWardDay day : list){
					map.put(day.getId_dep(), day.getNum_bed());
				}
			}
		}
		if(map != null && map.size() > 0){
			for(EnStatWardDay day : enStatWardDays){
				if(!EnValidator.isEmpty(day.getId_dep()) && map.get(day.getId_dep()) !=null){
					day.setNum_bed(Integer.valueOf(map.get(day.getId_dep()).toString()));
				}
			}
		}
	}
	/**
	 * CUD服务
	 * @return
	 */
	private IEnstatwardsayCudService cudService(){
		 return ServiceFinder.find(IEnstatwardsayCudService.class);
	}
	/***
	 * 查询服务
	 * @return
	 */
	private IEnstatwardsayRService rService(){
		return ServiceFinder.find(IEnstatwardsayRService.class);
	}
}
