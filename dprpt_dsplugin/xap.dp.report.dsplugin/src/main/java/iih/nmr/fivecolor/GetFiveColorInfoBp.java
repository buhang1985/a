package iih.nmr.fivecolor;

import java.util.ArrayList;
import java.util.List;

import iih.nmr.fivecolor.qry.GetFiveColorInfoSql;
import iih.nmr.javabean.FiveColorAppPrintDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDate;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @Description:获取孕妇五色卡打印信息
 * @Author:dukx
 * @Version:2019年9月26日上午10:16:55
 *
 */
public class GetFiveColorInfoBp {
	/**
	 * 主入口
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public List<FiveColorAppPrintDTO> exec(String id_ent, String name_report, String org_report) throws BizException {

		// 1、基础校验
		if (StringUtil.isEmptyWithTrim(id_ent))
			throw new BizException("错误信息：患者信息空异常！");

		// 2、查询数据
		List<FiveColorAppPrintDTO> list = queryData(id_ent);

		// 3、处理数据
		return handleData(list, name_report, org_report);
	}

	/**
	 * 处理数据
	 * 
	 * @param rtn
	 * @throws BizException
	 */
	private List<FiveColorAppPrintDTO> handleData(List<FiveColorAppPrintDTO> list, String name_report, String org_report) throws BizException {
		FiveColorAppPrintDTO prnDTO = new FiveColorAppPrintDTO();
		prnDTO.setName_pat(list.get(0).getName_pat());
		prnDTO.setDt_birth_pat(list.get(0).getDt_birth_pat());
		if (StringUtil.isEmptyWithTrim(list.get(0).getDt_birth_pat()))
			prnDTO.setAge("不详");
		else
			prnDTO.setAge(AgeCalcUtil.getAge(new FDate(prnDTO.getDt_birth_pat())));
		prnDTO.setId_card(list.get(0).getId_card());
		prnDTO.setAddr_pat(list.get(0).getAddr_pat());
		prnDTO.setTel_pat(list.get(0).getTel_pat());
		prnDTO.setName_didef_dic(list.get(0).getName_didef_dic());
		prnDTO.setDt_assess(list.get(0).getDt_assess());
		prnDTO.setName_report(name_report);
		prnDTO.setOrg_report(org_report);
		prnDTO.setDt_report(new FDate().toLocalString());
		String eu_colors = "";
		for (FiveColorAppPrintDTO dto : list) {
			eu_colors += "".equals(eu_colors) ? dto.getEu_color() : "," + dto.getEu_color() + "";
		}
		prnDTO.setEu_color(eu_colors);
		List<FiveColorAppPrintDTO> list2 = new ArrayList<>();
		list2.add(prnDTO);
		return list2;
	}

	/**
	 * 查询数据
	 * 
	 * @param id_ent
	 * @return
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	private List<FiveColorAppPrintDTO> queryData(String id_ent) throws DAException {
		GetFiveColorInfoSql sql = new GetFiveColorInfoSql(id_ent);
		return (List<FiveColorAppPrintDTO>) new DAFacade().execQuery(sql.getQrySQLStr(), sql.getQryParameter(null), new BeanListHandler(FiveColorAppPrintDTO.class));
	}

}
