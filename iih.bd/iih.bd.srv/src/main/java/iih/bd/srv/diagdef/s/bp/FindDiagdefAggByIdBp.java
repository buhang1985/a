package iih.bd.srv.diagdef.s.bp;

import iih.bd.srv.diagdef.d.DiagdefAggDO;
import iih.bd.srv.diagdef.i.IDiagdefRService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据主键查询诊断信息业务逻辑</br>
 * 查询后会补全对照信息中的计算字段
 * 
 * @author hao_wu
 *
 */
public class FindDiagdefAggByIdBp {

	public DiagdefAggDO exec(String id_Diagdef) throws BizException {
		IDiagdefRService diagdefRService = ServiceFinder.find(IDiagdefRService.class);
		DiagdefAggDO result = diagdefRService.findById(id_Diagdef);
		FillCompDataBp bp = new FillCompDataBp();
		bp.exec(result);
		return result;
	}
}
