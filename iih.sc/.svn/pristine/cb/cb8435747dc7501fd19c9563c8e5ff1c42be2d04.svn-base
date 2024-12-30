package iih.sc.apt.s.bp;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.sc.apt.dto.d.AptMtListDto;

/**
 * 获取资源已预约列表数据
 * @author ccj
 *
 */
public class GetAptMtResourcesBP {
	/**
	 * 获取资源已预约列表数据
	 * @param id_sch  排班id
	 * @return AptMtListDto[]
	 * @throws BizException
	 */
	public AptMtListDto[] exec(String id_sch)throws BizException{
		if(StringUtils.isBlank(id_sch)) return null;
		StringBuffer sb = new StringBuffer();
		SqlParam param = new SqlParam();
		sb.append("select"); 
		sb.append(" apt.queno,en.id_entp,en.name_pat,en.dt_birth_pat,en.id_sex_pat as id_sex");
		sb.append(",mt.fg_urgent,mt.id_dep_apply,mt.content_or ");
		sb.append(" from (select queno,id_apt from sc_apt where id_sch = ? and sd_status in ('");
		sb.append(IScDictCodeConst.SD_APTSTATUS_ORDER);
		sb.append("','");
		sb.append(IScDictCodeConst.SD_APTSTATUS_PAY);
		sb.append("')  and ds = 0) apt");
		sb.append(" inner join sc_aptmt mt on apt.id_apt = mt.id_apt");
		sb.append(" inner join en_ent en on mt.id_ent = en.id_ent");
		sb.append(" inner join ci_or_srv srv on mt.id_or = srv.id_or");
		sb.append(" and srv.sd_srvtp like '02%'");
		param.addParam(id_sch);
		List<AptMtListDto> reList = (List<AptMtListDto>)new DAFacade().execQuery(sb.toString(),param,new BeanListHandler(AptMtListDto.class));
		if(CollectionUtils.isEmpty(reList)) return null;
		return reList.toArray(new AptMtListDto[reList.size()]);
	}
}
