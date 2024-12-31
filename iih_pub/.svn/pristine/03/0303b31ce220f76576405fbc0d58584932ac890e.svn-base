package iih.ci.mr.mrpsndto.i;

import xap.sys.jdbc.facade.DAException;
import iih.ci.mr.mrpsndto.d.MrPsnDTO;

public interface IMrPsnDtoService {

	/**
	 * 根据当前科室 选择上级查房医师 人员 
	 * @param id_dep 当前登录科室
	 * @return
	 * @throws DAException 
	 */
	public abstract MrPsnDTO[] getMrPsnDtos(String id_dep) throws DAException;
	
	/**
	 * 选择主治及主任
	 * @param strWhere
	 * @return
	 * @throws DAException
	 */
	public abstract MrPsnDTO[] getMrPsnDtosWhere(String strWhere) throws DAException;
	
	/**
	 * 获取上级医师
	 * 医疗组中的指认上级，以及有主治、主任、教授职务的人员
	 * @param id_ent 就诊id
	 * @return
	 * @throws DAException 
	 */
	public abstract MrPsnDTO[] getMrPsnDtosSup(String id_ent) throws DAException;
}
