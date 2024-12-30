package iih.sc.apt.s.bp.mt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.sc.apt.dto.d.ScAptMtDto;
import iih.sc.comm.ScSqlUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 根据医嘱id批量获取医技预约DO
 * @author yzh
 * @date 2019年7月10日09:35:52
 * @param idOrs
 * @return
 * @throws BizException
 */
public class GetScAptByIdOrsBP {

	/**
	 * 根据医嘱id批量获取申请单已预约状态对应的医技预约DO
	 * @author yzh
	 * @date 2019年7月10日09:35:52
	 * @param idOrs
	 * @return
	 * @throws BizException
	 */
	public ScAptMtDto[] exec(String[] idOrs) throws BizException{
		if(ArrayUtil.isEmpty(idOrs)) return null;
		return this.getScAptByIdOrs(idOrs);
	}
	/**
	 * 查询医嘱对应的已预约的预约记录信息
	 * @param idOrs
	 * @return
	 * @throws DAException
	 */
	private ScAptMtDto[] getScAptByIdOrs(String[] idOrs) throws DAException{
		List<ScAptMtDto> result =  null;
		if(idOrs.length <= 500){
			 result = this.executeSql(idOrs);
		}else{
			 result = this.getScAptByIdOrsGrp(idOrs);
		}
		return result== null?null:result.toArray(new ScAptMtDto[result.size()]);
	}
	/**
	 * 按500条分组
	 * @param idOrs
	 * @throws DAException 
	 */
	private List<ScAptMtDto> getScAptByIdOrsGrp(String[] idOrs) throws DAException{
		List<String[]> list = new ArrayList<String[]>();
		int length  = idOrs.length;
		int grpCount = length/500 + 1;
		List<ScAptMtDto> result = new ArrayList<ScAptMtDto>();
		for (int i = 1; i < grpCount; i++) {
			List<ScAptMtDto> mtDtoList = null;
			if( i == grpCount){
				mtDtoList = executeSql(Arrays.copyOfRange(idOrs, 500*(i-1), length-1));
			}else{
				mtDtoList = executeSql(Arrays.copyOfRange(idOrs, 500*(i-1), 500*i-1));
			}
			if(!ListUtil.isEmpty(result))
			result.addAll(mtDtoList);
		}
		return result;
	}
	/**
	 * 执行sql 
	 */
	private List<ScAptMtDto> executeSql(String[] idOrs) throws DAException{
		StringBuffer sql = new StringBuffer();
		sql.append("select apt.dt_b as t_b,appl.id_dep_mp as id_dep,dep.name as id_dep_mp_name,appl.id_or,appl.name as srv_name ")
		.append("from sc_apt_appl appl left join sc_apt apt on appl.id_scapt = apt.id_apt ")
		.append("left join bd_dep dep on appl.id_dep_mp = dep.id_dep ")
		.append("where apt.fg_canc='N' and appl.fg_comfirm='Y' and appl.id_or in (").append(ScSqlUtils.buildIdStr(idOrs)) .append(")");
		DAFacade dafacade = new DAFacade();
		List<ScAptMtDto> result = (List<ScAptMtDto>) dafacade.execQuery(sql.toString(), new BeanListHandler(ScAptMtDto.class));
		if(ListUtil.isEmpty(result)){
			return null;
		}
		return result;
	}
}
