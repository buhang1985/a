package iih.sc.sch.s.bp.oral;

import iih.bd.fc.quesite.d.QueSiteDO;
import iih.bd.fc.quesite.i.IQueSiteQryService;
import iih.sc.comm.IScMsgConst;
import iih.sc.comm.ScSqlUtils;
import iih.sc.comm.ScValidator;
import iih.sc.comm.exception.ArgumentNullException;
import iih.sc.sch.dto.d.SchOralInfoDTO;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.i.IScschMDORService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 是否可粘贴覆盖
 * 
 * @author yank
 *
 */
public class CanCopyConverBP {
	/**
	 * 是否可粘贴覆盖
	 * 
	 * @param deptId 科室ID
	 * @param siteSchMap 拷贝的站点排班集合
	 * @param beginDate 预粘贴的开始日期
	 * @param endDate 预粘贴的结束日期
	 * @return
	 * @throws BizException
	 */
	public boolean exec(String deptId, FMap siteSchMap, FDate beginDate, FDate endDate) throws BizException {
		// 1、验证参数
		this.validateParam(deptId, siteSchMap, beginDate, endDate);
	
		// 2、排班是否已经占用
		String[] queSiteIdArray = siteSchMap.keySet().toArray(new String[0]);
		if (this.hasUsedSch(queSiteIdArray, beginDate, endDate)) {
			throw new BizException(IScMsgConst.SC_ORAL_SCH_HAS_USED_SCH);
		}

		// 3、验证复制排班是否在其他诊椅已经有排班
		if (this.hasOtherQueSiteSch(deptId, siteSchMap, beginDate, endDate)) {
			throw new BizException(IScMsgConst.SC_ORAL_SCH_HAS_SCH_ON_OTHER_QUESITE);
		}

		return true;
	}

	/**
	 * 验证参数
	 * 
	 * @param deptId 科室ID
	 * @param siteSchMap 拷贝的站点排班集合
	 * @param beginDate 预粘贴的开始日期
	 * @param endDate 预粘贴的结束日期
	 * @throws BizException
	 */
	private void validateParam(String deptId, FMap siteSchMap, FDate beginDate, FDate endDate) throws BizException {
		ScValidator.validateParam("科室ID", deptId);
		ScValidator.validateParam("站点排班集合", siteSchMap);
		ScValidator.validateParam("开始日期", beginDate);
		ScValidator.validateParam("结束日期", endDate);

		if (siteSchMap.size() == 0) {
			throw new ArgumentNullException("站点排班集合");
		}
	}

	/**
	 * 站点是否已经使用的排班
	 * 
	 * @param queSiteIds 站点（诊椅）
	 * @param date 日期
	 * @return
	 * @throws BizException
	 */
	private boolean hasUsedSch(String[] queSiteIds, FDate beginDate, FDate endDate) throws BizException {		
		// 1、查询该时期的站点的所有排班
		List<String> queSiteIdList = new ArrayList<String>();
		for(String queSiteId : queSiteIds){
			queSiteIdList.add(queSiteId);
		}
		
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ID_QUESITE,COUNT(ID_SCH) AS SCH_COUNT ");
		sqlBuilder.append(" FROM SC_SCH ");
		sqlBuilder.append(" WHERE 1=1 ");	
		sqlBuilder.append(" AND ").append(ScSqlUtils.getInSqlByIds("ID_QUESITE", queSiteIdList));
		sqlBuilder.append(" AND (D_SCH>=? AND D_SCH<=?) AND QUAN_TOTAL_USED>0");
		sqlBuilder.append(" GROUP BY ID_QUESITE");

		SqlParam param = new SqlParam();
		param.addParam(beginDate);
		param.addParam(endDate);

		boolean hasUsedSch = false;
		List<Map<String, Object>> list = (List<Map<String, Object>>) new DAFacade().execQuery(sqlBuilder.toString(),param, new MapListHandler());
		int size = list == null ? 0 : list.size();
		for (int i = 0; i < size; i++) {
			Map<String, Object> map = (Map<String, Object>) list.get(i);
			int count = (Integer) map.get("sch_count");
			if (count > 0) {
				hasUsedSch = true;
				break;
			}
		}
		return hasUsedSch;
	}

	/**
	 * 是否含有其他诊椅的相同排班
	 * 
	 * @param deptId 科室ID
	 * @param siteSchMap 站点排班集合
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @return
	 * @throws BizException
	 */
	private boolean hasOtherQueSiteSch(String deptId, FMap siteSchMap, FDate beginDate, FDate endDate)
			throws BizException {
		// 1、获取已有排班
		ScSchDO[] existSchs = this.getDeptSch(deptId, beginDate, endDate);
		if (ArrayUtil.isEmpty(existSchs)) {
			return false;
		}

		// 2、验证是否有其他诊椅上的排班
		boolean hasSch = false;
		SchOralInfoDTO oralSchDTO =null;
		for (String queSiteId : siteSchMap.keySet()) {
			FArrayList2 copySchList = (FArrayList2) siteSchMap.get(queSiteId);
			if(copySchList==null)continue;
			for (Object oralSch : copySchList) {
				oralSchDTO = (SchOralInfoDTO) oralSch;
				if(FBoolean.TRUE.equals(oralSchDTO.getFg_occupy())){
					continue;//如果是占用排班，则过滤判定
				}
				for (ScSchDO schDO : existSchs) {
					if (StringUtil.isEmpty(schDO.getId_quesite()))
						continue;
					if (siteSchMap.keySet().contains(schDO.getId_quesite())) {
						continue;//拷贝诊椅包含该诊椅，则不判定
					}
					if (this.schIsSameWithoutQuesite(schDO, oralSchDTO)) {
						hasSch = true;
						break;
					}
				}
			}
		}
		return hasSch;
	}

	/**
	 * 排班除诊椅是否相同
	 * 
	 * @param source 源排班
	 * @param target 目标排班
	 * @return
	 */
	private boolean schIsSameWithoutQuesite(ScSchDO source, SchOralInfoDTO target) {
		if (source == null || target == null) {
			return false;// 直接返回false，不再具体判定
		}
		//如果排班计划、星期几、午别相同，则认为相同
		if (source.getId_scpl().equals(target.getId_scpl()) 
				&& this.isSameWeekNo(source.getD_sch(), target.getD_sch())
				&& source.getId_dayslot().equals(target.getId_dayslot())) {
			return true;
		}
		return false;
	}

	/**
	 * 是否星期几相同
	 * 
	 * @param sourceDate
	 * @param targetDate
	 * @return
	 */
	private boolean isSameWeekNo(FDate sourceDate, FDate targetDate) {
		if (sourceDate == null || targetDate == null) {
			return false;
		}
		return sourceDate.getDayOfWeek() == targetDate.getDayOfWeek();
	}

	/**
	 * 获取科室排班
	 * 
	 * @param deptId 科室ID
	 * @param beginDate 开始日期
	 * @param endDate 结束日期
	 * @return
	 * @throws BizException
	 */
	private ScSchDO[] getDeptSch(String deptId, FDate beginDate, FDate endDate) throws BizException {
		// 1、查询科室诊间
		IQueSiteQryService quesiteQryService = ServiceFinder.find(IQueSiteQryService.class);
		QueSiteDO[] sites = quesiteQryService.getQueSiteByRoom(deptId, "%");
		List<String> siteIdList = new ArrayList<String>();
		int length = sites == null ? 0 : sites.length;
		if (length == 0) {
			return null;
		}
		for (int i = 0; i < length; i++) {
			siteIdList.add(sites[i].getId_quesite());
		}

		// 2、查询该诊间
		String whereStr = String.format("(D_SCH>='%s' AND D_SCH<='%s')", beginDate, endDate);// 排班日期
		whereStr += " AND " + ScSqlUtils.getInSqlByIds("ID_QUESITE", siteIdList);// 诊椅
		IScschMDORService schRService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO[] schDOs = schRService.find(whereStr, "id_quesite", FBoolean.TRUE);

		return schDOs;
	}
}
