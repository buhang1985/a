package iih.bl.inc.s.bp;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.exception.ArgumentNullException;
import iih.bl.inc.dto.blinctf.d.BlIncIssDTO;
import iih.bl.params.BlParams;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetIncIssTfRecordBP {

	public BlIncIssDTO[] exec(String empId, String pcId, FBoolean leftorright) throws BizException {

		// 1、基础校验
		if (StringUtil.isEmptyWithTrim(empId) && StringUtil.isEmptyWithTrim(pcId))
			throw new ArgumentNullException("发票票据领用人员信息", "票据领用人员或者票据领用计算机ID为空");

		// 2、查询数据
		if (FBoolean.TRUE.equals(leftorright)) {
			BlIncIssDTO[] rtn = querycurData(empId, pcId);
			return rtn;

		} else {
			BlIncIssDTO[] rtns = queryData(empId, pcId);
			return rtns;
		}
	}

	/**
	 * 查询数据
	 * 
	 * @param empId
	 * @param pcId
	 * @return
	 * @throws BizException
	 */
	private BlIncIssDTO[] querycurData(String empId, String pcId) throws BizException {
		StringBuffer sqlStr = new StringBuffer();
		SqlParam param = new SqlParam();
		sqlStr.append(" select                                                         ");
		sqlStr.append(" tf.id_inctf  Id_iss_tf,                                        ");
		sqlStr.append(" iss.id_emp_iss         id_emp_iss_old ,                        ");
		sqlStr.append(" iss.id_pc Id_pc_old,                                                     ");
		sqlStr.append(" iss.id_inciss as id_inc_iss,                                   ");
		sqlStr.append(" incca.name as name_innca,                                      ");
		sqlStr.append(" iss.id_inciss,                                                 ");
		sqlStr.append(" iss.id_incca,                                                  ");
		sqlStr.append(" incca.name     name_incca  ,                                    ");
		sqlStr.append(" iss.Code_incpkg,                                               ");
		sqlStr.append(" iss.dt_iss,                                                    ");
		sqlStr.append(" iss.num_b,                                                     ");
		sqlStr.append(" iss.num_e,                                                     ");
		sqlStr.append(" iss.incno_cur,                                                 ");
		sqlStr.append(" iss.fg_curuse                                                  ");
		sqlStr.append(" from bl_inc_iss iss                                            ");
		sqlStr.append(" left join bl_inc_tf tf on tf.id_inc_iss=iss.id_inciss      ");
		sqlStr.append(" left join bd_incca incca on incca.id_incca = iss.id_incca      ");
		sqlStr.append(" where iss.fg_active = 'Y'                                      ");
		//sqlStr.append(" and iss.fg_curuse = 'N'                                        ");
//		String ver = BlParams.BLINC0012();
//		if ("01".equals(ver)) {
//			sqlStr.append(" and iss.id_emp_iss = ?                                     ");
//			param.addParam(empId);
//		} else if ("02".equals(ver)) {
//			sqlStr.append(" and iss.id_pc = ?                                          ");
//			param.addParam(pcId);
//		}
		if(StringUtils.isNotBlank(empId) && StringUtils.isNotBlank(pcId)){
			sqlStr.append(" and (iss.id_emp_iss = ?                                     ");
			param.addParam(empId);
			sqlStr.append(" or iss.id_pc = ?)                                          ");
			param.addParam(pcId);
		}
		else if (StringUtils.isNotBlank(empId)) {
			sqlStr.append(" and iss.id_emp_iss = ?                                     ");
			param.addParam(empId);
		} 
		else{
			sqlStr.append(" and iss.id_pc = ?                                          ");
			param.addParam(pcId);
		}
		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<BlIncIssDTO> list = (List<BlIncIssDTO>) new DAFacade().execQuery(sqlStr.toString(), param,
				new BeanListHandler(BlIncIssDTO.class));
		return list.toArray(new BlIncIssDTO[] {});
	}

	/**
	 * 查询数据
	 * 
	 * @param empId
	 * @param pcId
	 * @return
	 * @throws BizException
	 */
	private BlIncIssDTO[] queryData(String empId, String pcId) throws BizException {
		StringBuffer sqlStr = new StringBuffer();
		SqlParam param = new SqlParam();
		sqlStr.append(" select                                                         ");
		sqlStr.append(" tf.id_inctf  Id_iss_tf,                                        ");
		sqlStr.append(" iss.id_emp_iss         id_emp_iss_old ,                        ");
		sqlStr.append(" iss.id_pc Id_pc_old,                                                     ");
		sqlStr.append(" iss.id_inciss as id_inc_iss,                                   ");
		sqlStr.append(" incca.name as name_innca,                                      ");
		sqlStr.append(" iss.id_inciss,                                                 ");
		sqlStr.append(" iss.id_incca,                                                  ");
		sqlStr.append(" incca.name     name_incca  ,                                   ");
		sqlStr.append(" iss.Code_incpkg,                                               ");
		sqlStr.append(" iss.dt_iss,                                                    ");
		sqlStr.append(" iss.num_b,                                                     ");
		sqlStr.append(" iss.num_e,                                                     ");
		sqlStr.append(" iss.incno_cur,                                                 ");
		sqlStr.append(" iss.fg_curuse                                                  ");
		sqlStr.append(" from bl_inc_iss iss                                            ");
		sqlStr.append(" inner join bl_inc_tf tf on tf.id_inc_iss_tf=iss.id_inciss      ");
		sqlStr.append(" left join bd_incca incca on incca.id_incca = iss.id_incca      ");
		sqlStr.append(" where iss.fg_active = 'Y'                                      ");
		//sqlStr.append(" and iss.fg_curuse = 'Y'                                        ");
//		String ver = BlParams.BLINC0012();
		if(StringUtils.isNotBlank(empId) && StringUtils.isNotBlank(pcId)){
			sqlStr.append(" and (iss.id_emp_iss = ?                                     ");
			param.addParam(empId);
			sqlStr.append(" or iss.id_pc = ?)                                          ");
			param.addParam(pcId);
		}
		else if (StringUtils.isNotBlank(empId)) {
			sqlStr.append(" and iss.id_emp_iss = ?                                     ");
			param.addParam(empId);
		} 
		else{
			sqlStr.append(" and iss.id_pc = ?                                          ");
			param.addParam(pcId);
		}
		// 执行sql语句
		@SuppressWarnings("unchecked")
		List<BlIncIssDTO> list = (List<BlIncIssDTO>) new DAFacade().execQuery(sqlStr.toString(), param,
				new BeanListHandler(BlIncIssDTO.class));
		return list.toArray(new BlIncIssDTO[] {});
	}
}
