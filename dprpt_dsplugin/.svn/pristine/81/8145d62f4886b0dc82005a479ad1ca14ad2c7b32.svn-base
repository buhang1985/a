package iih.pe.wardprint.bp;

import java.util.List;

import iih.pe.wardprint.dto.TestLableDTO;
import iih.pe.wardprint.qry.GetTestLableSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 获取检验标签信息
 * @author 32797
 *
 */
public class GetTestLableInfoBp {

	/**
	 * 主入口
	 * @param id_papt
	 * @return
	 * @throws BizException
	 */
	public List<TestLableDTO> exec(String id_papt) throws BizException {

		// 1、基础校验
		if (!validation(id_papt))
			return null;

		// 3、查询数据
		List<TestLableDTO> listDatas = queryData(id_papt);

		return listDatas;
	}

	/**
	 * 基础校验
	 * 
	 * @param id_ents
	 * @param dt_begin
	 * @param dt_end
	 * @param eu_long
	 * @return
	 */
	private boolean validation(String id_papt) {
		if (StringUtil.isEmptyWithTrim(id_papt)) return false;
		return true;
	}

	/**
	 * 查询数据
	 * 
	 * @param id_ents
	 * @param sd_srvtps
	 * @param dt_begin
	 * @param dt_end
	 * @param fg_long
	 * @param id_routes
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private List<TestLableDTO> queryData(String id_papt) throws BizException {
		GetTestLableSql sql = new GetTestLableSql(id_papt);
		System.out.println(id_papt);
		String qrySQLStr = sql.getQrySQLStr();
		List<TestLableDTO> reList = (List<TestLableDTO>) new DAFacade().execQuery(qrySQLStr, null, new BeanListHandler(TestLableDTO.class));
		return reList;
	}

}
