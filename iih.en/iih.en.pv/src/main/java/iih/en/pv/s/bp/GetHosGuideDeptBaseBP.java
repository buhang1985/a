package iih.en.pv.s.bp;

import iih.bd.bc.udi.pub.IBdResDictCodeConst;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.DeptPsndocDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 患者导医系统--获取就诊科室信息
 * 
 * @author fanlq
 *
 */
public class GetHosGuideDeptBaseBP {

	/**
	 * 患者导医系统--获取就诊科室信息
	 * @param pyCode
	 * @return zhangpp
	 * @throws BizException
	 */
	public DeptPsndocDTO[] exec(String pyCode) throws BizException {
		StringBuffer sql = new StringBuffer();
		SqlParam param = new SqlParam();
		sql.append("select distinct dep.id_dep, ");
		sql.append("dep.name as name_dep, " );
		sql.append("dep.code as code_dep, " );
		sql.append("dep.id_plc as addr_dep, " );
		sql.append("dep.des as des_dep " );
		sql.append("from bd_dep dep " );
		sql.append("inner join bd_psndoc doc on doc.id_dep = dep.id_dep ");
		sql.append("where 1=1 ");
		sql.append("and doc.activestate = ? ");
		param.addParam(IBdResDictCodeConst.SD_PSN_ACTIVESTATE_ENABLE);
		sql.append("and dep.fg_leaf = ? ");
		param.addParam(FBoolean.TRUE);
		sql.append("and dep.fg_op = ? ");
		param.addParam(FBoolean.TRUE);
		sql.append("and dep.fg_ip = ? ");
		param.addParam(FBoolean.TRUE);
		if(!EnValidator.isEmpty(pyCode)){
			sql.append("and dep.pycode like ? ");
			param.addParam("%"+pyCode.toUpperCase()+"%");
		}
		@SuppressWarnings("unchecked")
		List<DeptPsndocDTO> deptPsnList =(List<DeptPsndocDTO>)new DAFacade().execQuery(
				sql.toString(), param,new BeanListHandler(DeptPsndocDTO.class));
		return deptPsnList == null || deptPsnList.size() <= 0 ? null : deptPsnList.toArray(new DeptPsndocDTO[]{});
	}
}
