package iih.bd.srv.s.bp;

import java.util.List;

import iih.bd.srv.ortpl.utils.OrtmplUtils;
import iih.bd.srv.ortpl.utils.UtilsDTO;

public class GetMaxSeqNO4OrTmplBP {

	public String exec(String id_ortmplca) throws Exception {
		String sqlQry = "select max(seqno) as def1 from bd_srv_ortmpl where id_ortmpl in "
				+ "(select id_ortmpl from bd_srv_ortmpl_ca_rel where id_ortmplca='"+id_ortmplca+"')";

		List<UtilsDTO> dtos = OrtmplUtils.GetQueryResulte(UtilsDTO.class, sqlQry);

		return dtos == null || dtos.size() <= 0
				|| dtos.get(0).getDef1() == null ? "0" : dtos.get(0).getDef1();
	}
}
