package iih.nmr.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import iih.nmr.common.GetResultbysql;
import iih.nmr.javabean.UdiDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 将层级结构的档案转成进行优化
 * 
 * @author zhaoyangyang
 *
 */
public class AddBracketsUdiBp {

	/**
	 * 程序主入口
	 * @param id_udidoclists
	 * @return
	 * @throws Exception
	 */
	public List<String> exec(String id_udidoclist) throws Exception {

		// 1.参数校验
		if (StringUtil.isEmptyWithTrim(id_udidoclist)) {
			throw new BizException("数据传入不正确!");
		}

		//2查询档案项
		List<UdiDTO> idUdis = getUdis(id_udidoclist);

		//3拼接档案
		String udis = dealUdi(idUdis);
		List<String> str = new ArrayList<String>();
		str.add(udis);
		return str;
	}


	/**
	 * 查询档案项
	 * @param id_udidoclist
	 * @return
	 * @throws Exception
	 */
	private List<UdiDTO> getUdis(String id_udidoclist) throws Exception {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("  select                                                                       ");
		strBuffer.append("  udi.*                                                                        ");
		strBuffer.append("  from bd_udidoclist list                                                      ");
		strBuffer.append("  left join bd_udidoc udi on list.id_udidoclist = udi.id_udidoclist            ");
		strBuffer.append("  where list.id_udidoclist in ('"+id_udidoclist+"')  ");
		strBuffer.append("  order by udi.id_udidoclist ,udi.code asc                                     ");

		GetResultbysql sqlutil = new GetResultbysql();
		@SuppressWarnings("unchecked")
		List<UdiDTO> idudiList = (List<UdiDTO>) sqlutil.getResultListBySql(strBuffer.toString(),UdiDTO.class);
		return idudiList;
	}

	/**
	 * 拼接档案
	 * @param idUdis
	 * @return
	 */
	private String dealUdi(List<UdiDTO> idUdis) {
		Stack<String> stack = new Stack<String>();//创建一个栈

		if(idUdis==null||idUdis.size()==0)
			return null;

		Map<String,String> map = new HashMap<String,String>();
		UdiDTO udi = new UdiDTO();
		String val =null;
		for (UdiDTO row : idUdis) {
			//判断是不是第一个
			if(StringUtil.isEmptyWithTrim(udi.getId_udidoc()))
			{	
				udi = row;
				val = udi.getName()+"口";
				continue;
			}

			if(udi.getId_udidoclist().equals(row.getId_udidoclist()))
			{
				if(row.getCode().indexOf(udi.getCode())==0)
				{
					val = val.substring(0, val.length()-1)+"("+row.getName()+"口 ";
					stack.push(udi.getCode());
					udi = row;
				}else{
					String parCode = null;
					if(stack.size()!=0)
						 parCode = stack.pop();

					if(parCode==null){
						val = val+row.getName()+"口";
						continue;
					}
					if(row.getCode().indexOf(parCode)==0)
					{
						stack.push(parCode);
						val = val+row.getName()+"口";
					}
					else 
						val = val+")"+row.getName()+"口";
					udi = row;
				}
			}else{

			}
		}
		return val;
	}

}
