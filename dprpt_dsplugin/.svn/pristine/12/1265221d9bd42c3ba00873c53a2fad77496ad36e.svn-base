package iih.nmr.bp;

import java.util.ArrayList;
import java.util.List;

import iih.nmr.common.GetResultbysql;
import iih.nmr.javabean.DiagInfoDTO;
import iih.nmr.javabean.UdiDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

public class GetObsamcareassBp {

	/**
	 * 程序主入口
	 * @param id_ent
	 * @param id_udidoclists
	 * @return
	 */
	public List<DiagInfoDTO> exec(String id_ent, String id_udidoclists) throws Exception{

		// 1.参数校验
		if (StringUtil.isEmptyWithTrim(id_ent)||StringUtil.isEmptyWithTrim(id_udidoclists)) {
			throw new BizException("数据传入不正确!");
		}

		//2查询自定义档案
		String udis = getUdi(id_udidoclists).get(0);

		//3获取用户选中档案项
		List<UdiDTO> udiCheck = getCheckedUdi(id_ent);

		//4处理档案项
		String rtn = dealUdi(udiCheck,udis);
		
		System.out.println(rtn);
		
		List<DiagInfoDTO> rtnlist = new ArrayList<DiagInfoDTO>();
		DiagInfoDTO dto =  new DiagInfoDTO();
		dto.setName_di(rtn);
		rtnlist.add(dto);
		return rtnlist;
	}



	/**
	 * 查询自定义档案
	 * @param id_udidoclists
	 * @return
	 * @throws Exception
	 */
	private List<String> getUdi(String id_udidoclists) throws Exception{
		AddBracketsUdiBp bp = new AddBracketsUdiBp();
		List<String> udis= bp.exec(id_udidoclists);
		return udis;
	}

	/**
	 * 获取用户选中档案项
	 * @param id_ent
	 * @param udis
	 * @return
	 * @throws Exception
	 */
	private List<UdiDTO> getCheckedUdi(String id_ent) throws Exception{
		StringBuffer strBuffer = new StringBuffer(); 
		strBuffer.append("  select udi.*                                                             ");
		strBuffer.append("  from  NMR_HA_TCHO_ADMISSIONNURSING  adm                                  ");
		strBuffer.append("  left join bd_udidoc udi on instr(adm.id_etiology,udi.id_udidoc)>0        ");
		strBuffer.append("  where id_ent = '"+id_ent+"'                                    			 ");
		strBuffer.append("  order by udi.code                                                        ");

		GetResultbysql sqlutil = new GetResultbysql();
		@SuppressWarnings("unchecked")
		List<UdiDTO> idudiList = (List<UdiDTO>) sqlutil.getResultListBySql(strBuffer.toString(),UdiDTO.class);
		return idudiList;


	}

	/**
	 * 处理档案项
	 * @param udiCheck
	 * @return
	 */
	private String dealUdi(List<UdiDTO> udiCheck, String udis) {
		if(udiCheck==null||udiCheck.size()==0)
			return null;
		
		for (UdiDTO row : udiCheck) {
			if(udis.indexOf(row.getName()+"口")>=0)
				udis = udis.replace(row.getName()+"口", row.getName()+"√");
		}
		
		udis = udis.replaceAll("口", "口 ");
		udis = udis.replaceAll("√", "√ ");
		udis = udis.replaceAll(" \\)", "\\) ");
		
		return udis;
	}

}
