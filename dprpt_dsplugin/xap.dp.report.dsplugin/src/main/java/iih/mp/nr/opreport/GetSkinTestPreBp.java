package iih.mp.nr.opreport;

import java.util.List;

import iih.mp.nr.dto.pres.d.PreSkinTestDTO;
import iih.mp.nr.opreport.qry.GetPreSkinTestInfosSql;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 皮试处方单（门急诊输液登记）数据查询
 * 
 * @author fengjj
 * @date 2019年3月20日18:52:54 创建
 *
 */
public class GetSkinTestPreBp {
	/**
	 * 皮试处方单（门急诊输液登记）数据查询 入口
	 * 
	 * @param id_or_prs
	 * @return
	 * @throws BizException
	 */
	public List<PreSkinTestDTO> exec(String id_or_prs) throws BizException {
		// 1.参数校验
		validate(id_or_prs);

		// 2.查询数据
		List<PreSkinTestDTO> listDatas = queryData(id_or_prs);

		// 3.分组
		List<PreSkinTestDTO> rtns = new OpReUtil().packageData(listDatas);

		return rtns;
	}

	/**
	 * 参数校验
	 * 
	 * @param id_or_prs
	 * @throws BizException
	 */
	private void validate(String id_or_prs) throws BizException {
		if (StringUtil.isEmptyWithTrim(id_or_prs))
			throw new BizException("参数id_or_prs不能为空！");
	}

	/**
	 * 查询数据
	 * 
	 * @param id_or_prs
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	private List<PreSkinTestDTO> queryData(String id_or_prs) throws DAException {
		GetPreSkinTestInfosSql sql = new GetPreSkinTestInfosSql(id_or_prs);
		List<PreSkinTestDTO> reList = (List<PreSkinTestDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(PreSkinTestDTO.class));
		return reList;
	}

}
