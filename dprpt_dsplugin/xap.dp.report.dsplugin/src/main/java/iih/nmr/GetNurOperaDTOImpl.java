package iih.nmr;

import iih.nmr.bp.GetNurOperaBp;
import iih.nmr.javabean.DiagInfoDTO;

import java.util.List;

public class GetNurOperaDTOImpl {

	/**
	 * 获取Json格式的自定义档案数据（带□的自定义档案）
	 * @param fullclassname
	 * @return
	 * @throws Exception
	 */
	public List<DiagInfoDTO> exec(String id_ent,String id_ca) throws Exception {

		GetNurOperaBp bp = new GetNurOperaBp();

		return bp.exec(id_ent,id_ca);
	}

}
