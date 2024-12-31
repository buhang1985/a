package iih.ci.diag.s.bp;

import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.s.CiDiUtils;
import iih.en.pv.entdi.d.EntDiDO;
import iih.en.pv.entdi.d.desc.EntDiDODesc;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 诊断删除
 * @author li_zheng
 *
 */
public class DeleteCiDiagBP {
    /**
     * 删除诊断
     * @return
     * @throws BizException
     */
	public  CidiagAggDO DeleteCiDiag(CiDiagDO ciDiagDo)throws BizException{
		 if(ciDiagDo.getId_di() == null)  throw new BizException(" 诊断id_di不能为空");
		 CidiagAggDO agg = CiDiUtils.getICidiagRService().findById(ciDiagDo.getId_di());
		 if(agg == null) throw new BizException("诊断没有保存!");
		 CiDiUtils.getICidiagCudService().delete(new CidiagAggDO[]{agg});
		 // 删除就诊域的诊断
		 String whereStr = EntDiDODesc.TABLE_ALIAS_NAME+"."+EntDiDO.ID_DI +"='" +ciDiagDo.getId_di()+"'";
		 EntDiDO[] entDido = CiDiUtils.getIEntdiRService().find(whereStr, EntDiDO.ID_DI, FBoolean.FALSE);
		 CiDiUtils.getIEntdiCudService().delete(entDido);
		 return agg;
	}
}
