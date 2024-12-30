package iih.sc.apt.s.bp.mt;

import java.util.HashSet;
import java.util.Set;

import iih.sc.apt.s.ep.MtAptEP;
import iih.sc.apt.scaptappl.d.ScAptApplDO;
import iih.sc.apt.scaptappl.d.ScAptApplItmDO;
import iih.sc.apt.scaptappl.i.IScAptApplItmDORService;
import iih.sc.apt.scaptappl.i.IScaptapplMDORService;
import iih.sc.comm.ScLogUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 提供 给MP域设置-撤销取消执行
 * @author yaohl
 * @date 2019/07/05
 */
public class ScAptApplUndoCancExecBP {

	/**
	 * 提供 给MP域设置预约申请-撤销取消执行
	 * @param ids  医嘱id数组
	 * @param id_emp 操作人员id
	 * @param dt_opera 操作时间
	 * @throws BizException
	 */
	public void exec(String[] idOrs,String id_emp,String dt_opera) throws BizException{
		if(ArrayUtil.isEmpty(idOrs)) return;
		ScAptApplItmDO[] itms = this.getApplItmByIdOr(idOrs);
		Set<String> idsAppl = this.getIdsAppl(itms);
		for (String id_appl : idsAppl) {
			//1.查询预约记录、预约申请记录
			ScAptApplDO scApplDO = this.getScAptAppl(id_appl);//预约申请
			if(scApplDO != null)
			{
				//2.撤销 取消执行
				this.undoCancAptAppl(scApplDO);
			}
		}
	}
	
	/**
	 * 获取预约申请记录
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	private ScAptApplDO getScAptAppl(String id_appl) throws BizException
	{
		IScaptapplMDORService scaptapplRService =  ServiceFinder.find(IScaptapplMDORService.class);
		ScAptApplDO[] dos = scaptapplRService.find(" id_aptappl = '" + id_appl + "' and  fg_canc='N' and fg_reg_arv = 'N' and fg_canc_exec = 'Y'", "", FBoolean.FALSE);
		if(dos == null || dos.length==0)
		{
			ScLogUtil.getInstance().logError("ScAptApplUndoCancExecBP_未找到预约申请记录,id_appl:" + id_appl);
			return null;
		}
		return dos[0];
	}
	/***
	 * 修改申请单状态 撤销 取消执行状态
	 * @param scApplDO
	 * @throws BizException 
	 */
	private void undoCancAptAppl(ScAptApplDO scApplDO) throws BizException{
		if(!scApplDO.getFg_canc_exec().booleanValue()){
			return;
		}
		MtAptEP mtAptEP = new MtAptEP();
		scApplDO.setStatus(DOStatus.UPDATED);
		scApplDO.setFg_canc_exec(FBoolean.FALSE);
		// 更新预约申请
		mtAptEP.saveAptAppl(new ScAptApplDO[] { scApplDO });
	}
	
	/**
	 * 根据医嘱ID获取医嘱DO
	 *
	 * @author yu.b
	 * 
	 * @param id_or 医嘱ID
	 * @return ScAptApplItmDO[]
	 * @throws BizException
	 */
	private ScAptApplItmDO[] getApplItmByIdOr(String[] ids_or) throws BizException {
		if (ArrayUtil.isEmpty(ids_or)) {
			return null;
		}
		IScAptApplItmDORService qryService = ServiceFinder.find(IScAptApplItmDORService.class);
		return qryService.findByAttrValStrings("Id_or", ids_or);
	}
	
	/**
	 * 根据医嘱DO对申请单ID进行去重
	 *
	 * @author yu.b
	 * 
	 * @param ScAptApplItmDO[]
	 * @return Set<String>
	 * @throws BizException
	 */
	private Set<String> getIdsAppl(ScAptApplItmDO[] itms) throws BizException {
		if (ArrayUtil.isEmpty(itms)) {
			return null;
		}
		Set<String> idsAppl = new HashSet<String>();
		for (ScAptApplItmDO itm : itms) {
			idsAppl.add(itm.getId_aptappl());
		}
		return idsAppl;
	}
}
