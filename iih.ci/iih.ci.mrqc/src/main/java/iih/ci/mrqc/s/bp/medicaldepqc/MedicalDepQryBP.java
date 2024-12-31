package iih.ci.mrqc.s.bp.medicaldepqc;

import java.util.List;

import iih.ci.mrqc.qcresult.d.QcPatResultListDTO;
import iih.ci.mrqc.s.bp.medicaldepqc.sqlbp.MedicalDepMrQcSqlBP;
import iih.en.pv.enres.d.EnPsnDO;
import iih.en.pv.enres.i.IEnpsnRService;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 医务质控报表
 * @author F
 *
 */
public class MedicalDepQryBP {

	/**
	 * 医务质控报表全查
	 * @param sqlwhere
	 * @return
	 */
	public QcPatResultListDTO[] getQcPatResultList(QryRootNodeDTO qryRootNodeDTO) throws BizException{
		IQrySQLGeneratorService service=ServiceFinder.find(IQrySQLGeneratorService.class);
		DAFacade daf = new DAFacade();  
 		String sqlwhere = " en_ent.dt_acpt is not null";
 		if (qryRootNodeDTO!=null){
 			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
 		}
 		MedicalDepMrQcSqlBP sqlBp=new MedicalDepMrQcSqlBP();
 		String sqlStr=sqlBp.GetMedicalDepMrQcResultSql(sqlwhere);
 		@SuppressWarnings("unchecked")
		List<QcPatResultListDTO> qcPatResultDTO=(List<QcPatResultListDTO>) daf.execQuery(sqlStr, new BeanListHandler(QcPatResultListDTO.class));
		return (QcPatResultListDTO[]) qcPatResultDTO.toArray(new QcPatResultListDTO[qcPatResultDTO.size()]);
	}
	
	
	/**
	 * 获取医护人员信息
	 * 
	 * @param entId
	 * @param empRole
	 * @return
	 * @throws BizException
	 */
	public EnPsnDO getEnEmpByRole(String entId, String empRole) throws BizException {
		IEnpsnRService enpsnService = ServiceFinder.find(IEnpsnRService.class);
		String whereStr = String.format("id_ent='%s' and sd_emprole='%s'", entId, empRole);
		String orderStr = "dt_e desc";
		EnPsnDO[] psnDOArray = enpsnService.find(whereStr, orderStr, FBoolean.FALSE);
		if (ArrayUtil.isEmpty(psnDOArray)) {
			return null;
		}
		return psnDOArray[0];

	}
}
