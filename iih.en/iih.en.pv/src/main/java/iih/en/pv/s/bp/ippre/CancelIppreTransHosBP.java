package iih.en.pv.s.bp.ippre;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.deptrans.d.EnDepTransDO;
import iih.en.pv.deptrans.d.EnEuTrans;
import iih.en.pv.deptrans.i.IEndeptransCudService;
import iih.en.pv.deptrans.i.IEndeptransRService;
import iih.en.pv.inpatient.d.EnIppreDO;
import iih.en.pv.inpatient.dto.d.EnIppreInfoDTO;
import iih.en.pv.inpatient.i.IEnippreCudService;
import iih.en.pv.inpatient.i.IEnippreRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 取消预住院转住院
 *
 */
public class CancelIppreTransHosBP {
	
	public void exec(EnIppreInfoDTO ippreTransHos) throws BizException{
		//1.校验状态是否已经变化
		EnDepTransDO transdepdo = this.validateStatus(ippreTransHos);
		//2.删除en_dep_trans 对应记录
		this.deleteTransDO(transdepdo);
		//3.修改住院转出标志 
		this.updateEnIppreFlag(ippreTransHos);
	}
	/**
	 * 修改住院转出标志
	 * @param ippreTransHos 
	 * @throws BizException 
	 */
	private void updateEnIppreFlag(EnIppreInfoDTO ippreTransHos) throws BizException {
		IEnippreCudService iCudService = ServiceFinder.find(IEnippreCudService.class);
		IEnippreRService iRService = ServiceFinder.find(IEnippreRService.class);
		EnIppreDO[] ippredos = iRService.find(" id_ent = '" + ippreTransHos.getId_ent() + "' ", "", FBoolean.FALSE);
		if(!EnValidator.isEmpty(ippredos)){
			for (EnIppreDO enIppreDO : ippredos) {
				enIppreDO.setStatus(DOStatus.UPDATED);
				enIppreDO.setFg_transdep(FBoolean.FALSE);
			}
		}
		iCudService.save(ippredos);
	}
	/**
	 * 删除en_dep_trans 对应记录
	 * @param transdepdo
	 * @throws BizException 
	 */
	private void deleteTransDO(EnDepTransDO transdepdo) throws BizException {
		IEndeptransCudService  cudService = ServiceFinder.find(IEndeptransCudService.class);
		cudService.delete(new EnDepTransDO[]{transdepdo});
	}
	
	/**
	 * 校验患者状态
	 * @param transDTO
	 * @return
	 * @throws BizException
	 */
	private EnDepTransDO validateStatus(EnIppreInfoDTO transDTO) throws BizException {
		if(transDTO==null){
			throw new BizException("传入的选中信息为空!");
		}
		IEndeptransRService RService  = ServiceFinder.find(IEndeptransRService.class);
  	    String whereStr = "id_ent = '" +transDTO.getId_ent()+"' AND Eu_trans ='"+EnEuTrans.APPLY+"'";
  	    EnDepTransDO[] res = RService.find(whereStr, "", FBoolean.FALSE);
  	    if(EnValidator.isEmpty(res)){
  	    	throw new BizException("申请患者的状况已经改变,请刷新页面!");
  	    }
  	    return res[0];
	}
}
