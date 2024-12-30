package iih.sc.sch.s.bp;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.comm.IScMsgConst;
import iih.sc.sch.scsch.d.ScSchDO;
import iih.sc.sch.scsch.d.desc.ScSchDODesc;
import iih.sc.sch.scsch.i.IScschMDOCudService;
import iih.sc.sch.scsch.i.IScschMDORService;
import iih.sc.scp.scplan.d.ScPlanDO;
import iih.sc.scp.scplan.d.desc.ScPlanDODesc;
import iih.sc.scp.scplan.i.IScplanRService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/** 排班调整所涉及的所有信息
 * @author ccj
 *
 */
public class SchBatchAdjBp {
	
	/**排班调整所涉及的所有信息
	 * @param adjTypeCode  排班类型编码	
	 * @param id_dept	科室id
	 * @param oldDate	原日期
	 * @param targetDate	调整到日期
	 * @param idScplList	排除计划
	 * @throws BizException
	 */
	public void exec(String adjTypeCode,String id_dept,FDate oldDate,FDate targetDate,List<String> idScplList)throws BizException{
		if(StringUtils.isEmpty(adjTypeCode) || oldDate == null) return;
		StringBuffer sqlWhere = new StringBuffer("1=1 ");  // 查询符合条件的计划
		if(CollectionUtils.isNotEmpty(idScplList)){
			StringBuffer excludeScpls = new StringBuffer();  //要排除的计划
			for (String scpl : idScplList) {
				excludeScpls.append("'");
				excludeScpls.append(scpl);
				excludeScpls.append("',");
			}
			String id_scpls = excludeScpls.substring(0, excludeScpls.length()-1).toString(); //要排除的计划
			sqlWhere.append("and ");
			sqlWhere.append(ScPlanDODesc.TABLE_ALIAS_NAME);
			sqlWhere.append(".");
			sqlWhere.append(ScPlanDO.ID_SCPL);
			sqlWhere.append(" not in (");
			sqlWhere.append(id_scpls);
			sqlWhere.append(")");
		}
		if(StringUtils.isNotEmpty(id_dept)){
			//科室
			sqlWhere.append("and ");
			sqlWhere.append(ScPlanDODesc.TABLE_ALIAS_NAME);
			sqlWhere.append(".");
			sqlWhere.append(ScPlanDO.ID_DEP);
			sqlWhere.append(" = '");
			sqlWhere.append(id_dept);
			sqlWhere.append("'");
		}
		IScplanRService iScplanRService = ServiceFinder.find(IScplanRService.class);
		ScPlanDO[] planDOs = iScplanRService.find(sqlWhere.toString(), "", FBoolean.TRUE);
		if(ArrayUtils.isEmpty(planDOs)) throw new BizException(IScMsgConst.SC_SCH_ADJ_EFFECTIVE_DATA);
		StringBuffer scplwhere = new StringBuffer();
		for (ScPlanDO scPlanDO : planDOs) {
			scplwhere.append("'");
			scplwhere.append(scPlanDO.getId_scpl());
			scplwhere.append("',");
		}
		String id_scplss = scplwhere.substring(0, scplwhere.length()-1);
		if(IScDictCodeConst.SCSCH_ADJ_STOP.equals(adjTypeCode)){
			//停诊
			stopBp(id_scplss,oldDate);
		}else if(IScDictCodeConst.SCSCH_ADJ_EXCHANGE.equals(adjTypeCode)){
			//互换
			valdata(id_scplss,oldDate,targetDate);
			exchangeBp(id_scplss,oldDate,targetDate);
		}else if(IScDictCodeConst.SCSCH_ADJ_REPLACE.equals(adjTypeCode)){
			//替换
			valdata(id_scplss,oldDate,targetDate);
			replaceBp(id_scplss,oldDate,targetDate);
		}else if(IScDictCodeConst.SCSCH_ADJ_ADDITIONAL.equals(adjTypeCode)){
			//追加
			valdata(id_scplss,oldDate,null);
			additionalBp(id_scplss,oldDate,targetDate);
		}
	}
	
	/** 停诊操作
	 * @param id_scplss
	 * @param oldDate
	 * @throws BizException
	 */
	private void stopBp(String id_scplss,FDate oldDate) throws BizException{
		IScschMDORService iScschMDORService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO[] oldSchDOs = iScschMDORService.find(ScSchDODesc.TABLE_ALIAS_NAME+".Id_scpl in ("+id_scplss+") and "
				+ ScSchDODesc.TABLE_ALIAS_NAME+".d_sch = '"+oldDate+"'", "", FBoolean.TRUE);
		if(ArrayUtils.isEmpty(oldSchDOs)) throw new BizException(IScMsgConst.SC_SCH_ADJ_EFFECTIVE_DATA);
		for (ScSchDO scSchDO : oldSchDOs) {
			scSchDO.setFg_active(FBoolean.FALSE);
			scSchDO.setStatus(DOStatus.UPDATED);
		}
		IScschMDOCudService cudService = ServiceFinder.find(IScschMDOCudService.class);
		cudService.save(oldSchDOs);
	}
	
	private void valdata(String id_scplss,FDate oldDate,FDate targetDate) throws BizException{
		String sqlWhere;
		if(targetDate == null){
			sqlWhere = ""+ScSchDODesc.TABLE_ALIAS_NAME+".d_sch = '"+oldDate+"' and ";
		}else{
			sqlWhere = "("+ScSchDODesc.TABLE_ALIAS_NAME+".d_sch = '"+oldDate+"' or "+ScSchDODesc.TABLE_ALIAS_NAME+".d_sch = '"+targetDate+"') and ";
		}
		IScschMDORService iScschMDORService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO[] schDOs = iScschMDORService.find(ScSchDODesc.TABLE_ALIAS_NAME+".Id_scpl in ("+id_scplss+") and "+sqlWhere
				+ ScSchDODesc.TABLE_ALIAS_NAME+".quan_total_used > 0", "", FBoolean.TRUE);
		if(ArrayUtils.isNotEmpty(schDOs)) throw new BizException("排班有使用，本次操作失败");
	}
	
	/**互换操作
	 * @param id_scplss
	 * @param oldDate
	 * @param targetDate
	 * @throws BizException
	 */
	private void exchangeBp(String id_scplss,FDate oldDate,FDate targetDate) throws BizException{
		//TODO 这里有两种方案 是先在查询里判断条件写好 还是 查询出所有 在判断？  有待确定 效率
		List<ScSchDO> list = new ArrayList<ScSchDO>();
		IScschMDORService iScschMDORService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO[] oldSchDOs = iScschMDORService.find(ScSchDODesc.TABLE_ALIAS_NAME+".Id_scpl in ("+id_scplss+") and "
				+ ScSchDODesc.TABLE_ALIAS_NAME+".d_sch = '"+oldDate+"'", "", FBoolean.TRUE);
		ScSchDO[] targetSchDOs = iScschMDORService.find(ScSchDODesc.TABLE_ALIAS_NAME+".Id_scpl in ("+id_scplss+") and "
				+ ScSchDODesc.TABLE_ALIAS_NAME+".d_sch = '"+targetDate+"'", "", FBoolean.TRUE);
		if(ArrayUtils.isEmpty(oldSchDOs) && ArrayUtils.isEmpty(targetSchDOs)) 
			throw new BizException(IScMsgConst.SC_SCH_ADJ_EFFECTIVE_DATA);
		for (ScSchDO scSchDO : oldSchDOs) {
			scSchDO.setD_sch(targetDate);
			scSchDO.setStatus(DOStatus.UPDATED);
		}
		list.addAll(Arrays.asList(oldSchDOs));
		for (ScSchDO scSchDO : targetSchDOs) {
			scSchDO.setD_sch(oldDate);
			scSchDO.setStatus(DOStatus.UPDATED);
		}
		list.addAll(Arrays.asList(targetSchDOs));
		IScschMDOCudService cudService = ServiceFinder.find(IScschMDOCudService.class);
		cudService.save(list.toArray(new ScSchDO[list.size()]));
	}
	
	/**替换操作
	 * @param id_scplss
	 * @param oldDate
	 * @param targetDate
	 * @throws BizException
	 */
	private void replaceBp(String id_scplss,FDate oldDate,FDate targetDate) throws BizException{
		IScschMDOCudService cudService = ServiceFinder.find(IScschMDOCudService.class);
		IScschMDORService iScschMDORService = ServiceFinder.find(IScschMDORService.class);
		ScSchDO[] oldSchDOs = iScschMDORService.find(ScSchDODesc.TABLE_ALIAS_NAME+".Id_scpl in ("+id_scplss+") and "
				+ ScSchDODesc.TABLE_ALIAS_NAME+".d_sch = '"+oldDate+"'", "", FBoolean.TRUE);
		ScSchDO[] targetSchDOs = iScschMDORService.find(ScSchDODesc.TABLE_ALIAS_NAME+".Id_scpl in ("+id_scplss+") and "
				+ ScSchDODesc.TABLE_ALIAS_NAME+".d_sch = '"+targetDate+"'", "", FBoolean.TRUE);
		if(ArrayUtils.isEmpty(oldSchDOs) && ArrayUtils.isEmpty(targetSchDOs)) 
			throw new BizException(IScMsgConst.SC_SCH_ADJ_EFFECTIVE_DATA);
		cudService.delete(targetSchDOs);
		for (ScSchDO scSchDO : oldSchDOs) {
			scSchDO.setD_sch(targetDate);
			scSchDO.setStatus(DOStatus.UPDATED);
		}
		cudService.save(oldSchDOs);
	}
	
	/**追加操作
	 * @param id_scplss
	 * @param oldDate
	 * @param targetDate
	 * @throws BizException 
	 */
	private void additionalBp(String id_scplss,FDate oldDate,FDate targetDate) throws BizException{
		IScschMDORService iScschMDORService = ServiceFinder.find(IScschMDORService.class);
		IScschMDOCudService cudService = ServiceFinder.find(IScschMDOCudService.class);
		List<String> list = new ArrayList<String>();
		StringBuffer scplBuffer = new StringBuffer();
		ScSchDO[] targetSchDOs = iScschMDORService.find(ScSchDODesc.TABLE_ALIAS_NAME+".Id_scpl in ("+id_scplss+") and "
				+ ScSchDODesc.TABLE_ALIAS_NAME+".d_sch = '"+targetDate+"'", "", FBoolean.TRUE);
		for (ScSchDO scSchDO : targetSchDOs) {
			if(!list.contains(scSchDO.getId_scpl())){
				list.add(scSchDO.getId_scpl());
				scplBuffer.append("'");
				scplBuffer.append(scSchDO.getId_scpl());
				scplBuffer.append("',");	
			}
		}
		ScSchDO[] oldSchDOs;
		if(StringUtils.isEmpty(scplBuffer.toString())){
			oldSchDOs = iScschMDORService.find(ScSchDODesc.TABLE_ALIAS_NAME+".Id_scpl in ("+id_scplss+") and "
					+ ScSchDODesc.TABLE_ALIAS_NAME+".d_sch = '"+oldDate+"' ", "", FBoolean.TRUE);
		}else{
			oldSchDOs = iScschMDORService.find(ScSchDODesc.TABLE_ALIAS_NAME+".Id_scpl in ("+id_scplss+") and "
					+ ScSchDODesc.TABLE_ALIAS_NAME+".d_sch = '"+oldDate+"' and "+ScSchDODesc.TABLE_ALIAS_NAME+".Id_scpl not in ("+scplBuffer.substring(0, scplBuffer.length()-1)+") ", "", FBoolean.TRUE);
		}
		for (ScSchDO scSchDO : oldSchDOs) {
			scSchDO.setD_sch(targetDate);
			scSchDO.setStatus(DOStatus.UPDATED);
		}
		cudService.save(oldSchDOs);
		if(StringUtils.isNotEmpty(scplBuffer.toString())){
			ScSchDO[] oldSchDOs1 = iScschMDORService.find(ScSchDODesc.TABLE_ALIAS_NAME+".Id_scpl in ("+scplBuffer.substring(0, scplBuffer.length()-1)+") and "
					+ ScSchDODesc.TABLE_ALIAS_NAME+".d_sch = '"+oldDate+"'  ", "", FBoolean.TRUE);
			cudService.delete(oldSchDOs1);
		}
		
	}
}
