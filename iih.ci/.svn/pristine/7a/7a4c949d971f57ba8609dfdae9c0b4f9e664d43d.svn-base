package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.OrdApOpAgainDO;
import iih.ci.ord.cior.i.IOrdApOpAgainDOCudService;
import iih.ci.ord.cior.i.IOrdApOpAgainDORService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 二次手术申请单保存修改
 * @author zhangwq
 *
 */
public class SaveAgainSugBP {
	public boolean exec(OrdApOpAgainDO dataSource) throws BizException{
		IOrdApOpAgainDOCudService againCudService = ServiceFinder.find(IOrdApOpAgainDOCudService.class);
		IOrdApOpAgainDORService againRService = ServiceFinder.find(IOrdApOpAgainDORService.class);
		OrdApOpAgainDO ordApOpAgainDO = againRService.findById(dataSource.getId_ap_sug_again());
		ordApOpAgainDO.setFg_urgent(dataSource.getFg_urgent());
		ordApOpAgainDO.setFg_same_dep(dataSource.getFg_same_dep());
		ordApOpAgainDO.setName_emp_sugs(dataSource.getName_emp_sugs());
		ordApOpAgainDO.setId_emp_sugs(dataSource.getId_emp_sugs());
		ordApOpAgainDO.setFirst_op_id_srv(dataSource.getFirst_op_id_srv());
		ordApOpAgainDO.setFirst_op_name(dataSource.getFirst_op_name());
		ordApOpAgainDO.setAgain_op_id_srv(dataSource.getAgain_op_id_srv());
		ordApOpAgainDO.setAgain_op_name(dataSource.getAgain_op_name());
		ordApOpAgainDO.setId_emp_joins(dataSource.getId_emp_joins());
		ordApOpAgainDO.setName_emp_joins(dataSource.getName_emp_joins());
		ordApOpAgainDO.setId_emp_comperes(dataSource.getId_emp_comperes());
		ordApOpAgainDO.setName_emp_comperes(dataSource.getName_emp_comperes());
		ordApOpAgainDO.setPlace(dataSource.getPlace());
		ordApOpAgainDO.setContent(dataSource.getContent());
		ordApOpAgainDO.setFg_submit(dataSource.getFg_submit());
		ordApOpAgainDO.setSd_reltp(dataSource.getSd_reltp());
		ordApOpAgainDO.setDep_opinion(dataSource.getDep_opinion());
		ordApOpAgainDO.setAdm_opinion(dataSource.getAdm_opinion());
		againCudService.update(new OrdApOpAgainDO[]{ordApOpAgainDO});
		return true;
	}
}
