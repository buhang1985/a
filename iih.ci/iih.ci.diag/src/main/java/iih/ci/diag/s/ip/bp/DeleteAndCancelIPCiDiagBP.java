package iih.ci.diag.s.ip.bp;

import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.s.CiDiUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
/**
 * 住院的删除和作废诊断
 * @author li_zheng
 *
 */
public class DeleteAndCancelIPCiDiagBP {
     /**
      * 
      * @param ciDiagDo
      * @param id_emp
      * @return
      * @throws BizException
      */
	 public   CiDiagDO[] DeleteAndCancelIPCiDiag(CiDiagDO ciDiagDo,String id_emp)throws BizException{
		 if(ciDiagDo != null && FBoolean.TRUE.equals(ciDiagDo.getFg_sign())){
			 CancelCiDiagBP bp = new CancelCiDiagBP();
			 return bp.CancelCiDiagDO(ciDiagDo.getId_di(), id_emp);
		 }else{
			 CidiagAggDO agg = CiDiUtils.getICidiagRService().findById(ciDiagDo.getId_di());
			 if(agg == null) throw new BizException("诊断没有保存!");
			 CiDiUtils.getICidiagCudService().delete(new CidiagAggDO[]{agg});
			 return null;
		 }
   }
}
