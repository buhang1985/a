package iih.bd.mhi.operatorupload.s.bp;

import java.util.ArrayList;

import iih.bd.mhi.operatorupload.d.OperatorUploadDO;
import iih.bd.mhi.operatorupload.i.IOperatoruploadCudService;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class SynchronizationBp {

	public void exec() throws BizException {
		String sql = getSql();
		DAFacade daFacade = new DAFacade();
		
		//查询需要同步的人员信息
		ArrayList<OperatorUploadDO> operatorUploadDOs = (ArrayList<OperatorUploadDO>) daFacade.execQuery(sql, new BeanListHandler(OperatorUploadDO.class));
		OperatorUploadDO[] resultDos = operatorUploadDOs.toArray(new OperatorUploadDO[0]);
		
		//将数据插入表中
		IOperatoruploadCudService iOperatoruploadCudService = ServiceFinder.find(IOperatoruploadCudService.class);
		iOperatoruploadCudService.insert(resultDos);
	}

	/**
	 * 从人员信息表中获取需要同步的信息SQL
	 * @return
	 */
	private String getSql() {
		StringBuilder sql = new StringBuilder();
		sql.append("select PSNDOC.Id_Group AS ID_GROUP, ");
		sql.append("PSNDOC.Id_Org AS ID_ORG, ");
		sql.append("PSNDOC.Id_Psndoc AS ID_PSNDOC, ");
		sql.append("EMP_PHY.DRID AS DRID, ");
		sql.append("'N' AS FG_UPLOAD ");
		sql.append("from bd_psndoc PSNDOC ");
		sql.append("inner join bd_emp_phy EMP_PHY ");
		sql.append("on EMP_PHY.Id_Psndoc = PSNDOC.Id_Psndoc ");
		sql.append("and EMP_PHY.Fg_Presrt = 'Y' ");
		sql.append("where PSNDOC.Id_Psndoc not in ");
		sql.append("(select PSNUP.Id_Psndoc from bd_hp_psnup PSNUP) ");
		sql.append("and EMP_PHY.Drid is not null ");
		sql.append("and EMP_PHY.Drid != '~' ");

		return sql.toString();
	}
}
